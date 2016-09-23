package com.facebook.react;

import android.content.Intent;

public class BaseReactAppCompatActivity extends ReactAppCompatActivity {

    protected ReactRootView reactRootView() {
        return new ReactRootView(this);
    }

    @Override
    protected ReactAppCompatActivityDelegate createReactActivityDelegate() {
        return new ReactAppCompatActivityDelegate(this, getMainComponentName());
    }

    @Override
    public void onNewIntent(Intent intent) {
        // left blank intentionally
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // left blank intentionally
    }
}
