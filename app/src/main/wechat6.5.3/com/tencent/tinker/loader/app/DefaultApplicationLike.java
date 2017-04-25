package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;

public class DefaultApplicationLike extends ApplicationLike {
    private static final String TAG = "Tinker.DefaultAppLike";

    public DefaultApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent, Resources[] resourcesArr, ClassLoader[] classLoaderArr, AssetManager[] assetManagerArr) {
        super(application, i, z, j, j2, intent, resourcesArr, classLoaderArr, assetManagerArr);
    }

    public void onCreate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
    }

    public void onTerminate() {
    }

    public void onConfigurationChanged(Configuration configuration) {
        new StringBuilder("onConfigurationChanged:").append(configuration.toString());
    }

    public void onBaseContextAttached(Context context) {
    }
}
