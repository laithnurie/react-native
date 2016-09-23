package com.facebook.react;

import android.app.Activity;

public class ReactAppCompatActivityDelegate extends ReactActivityDelegate {

    private final BaseReactAppCompatActivity reactAppCompatActivity;
    private ReactRootView mReactRootView;

    public ReactAppCompatActivityDelegate(BaseReactAppCompatActivity reactAppCompatActivity, String mainComponentName) {
        super(reactAppCompatActivity, mainComponentName);
        this.reactAppCompatActivity = reactAppCompatActivity;
    }

    @Override
    protected ReactRootView createRootView() {
        return reactAppCompatActivity.reactRootView();
    }

    @Override
    protected void loadApp(String appKey) {
        if (mReactRootView != null) {
            throw new IllegalStateException("Cannot loadApp while app is already running.");
        }
        mReactRootView = createRootView();
        mReactRootView.startReactApplication(
                getReactNativeHost().getReactInstanceManager(),
                appKey,
                getLaunchOptions());
    }

    @Override
    protected void onDestroy() {
        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication();
            mReactRootView = null;
        }
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostDestroy(getPlainActivity());
        }
    }

    private Activity getPlainActivity() {
        return reactAppCompatActivity;
    }
}
