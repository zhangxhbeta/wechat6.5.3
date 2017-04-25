package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.res.Configuration;

public abstract class e {
    public Application app;

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate();

    public void onTerminate() {
    }

    public void onTrimMemory(int i) {
    }
}
