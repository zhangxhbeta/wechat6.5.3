package com.tencent.mm.kernel.plugin;

import android.app.Application;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.booter.c;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public abstract class ProcessProfile implements ApplicationLifeCycle {
    private Application mApplication;
    private b mBoot = new b();
    private c mDebugger;
    private MMApplicationLike mLifeCycle;
    private String mProcessName;
    private e mProfileCompat;

    public abstract com.tencent.mm.vending.b.b addApplicationLifeCycleCallback(ApplicationLifeCycle applicationLifeCycle);

    public abstract void removeApplicationLifeCycleCallback(ApplicationLifeCycle applicationLifeCycle);

    public ProcessProfile(String str, Application application, MMApplicationLike mMApplicationLike) {
        this.mProcessName = str;
        aa.Kh(str);
        this.mApplication = application;
        this.mLifeCycle = mMApplicationLike;
    }

    public void updateApplication(Application application, MMApplicationLike mMApplicationLike) {
        this.mApplication = application;
        this.mLifeCycle = mMApplicationLike;
    }

    public Application application() {
        return this.mApplication;
    }

    public MMApplicationLike lifeCycle() {
        return this.mLifeCycle;
    }

    public c getDebugger() {
        return this.mDebugger;
    }

    public void setDebugger(c cVar) {
        this.mDebugger = cVar;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public b boot() {
        return this.mBoot;
    }

    public void setProfileCompat(e eVar) {
        this.mProfileCompat = eVar;
    }

    public e getProfileCompat() {
        return this.mProfileCompat;
    }

    public String toString() {
        return this.mProcessName != null ? this.mProcessName : super.toString();
    }
}
