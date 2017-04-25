package com.tencent.mm.kernel.plugin;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.av.a;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public class ProcessProfileImpl extends ProcessProfile {
    private a<ApplicationLifeCycle> mApplicationLifeCycleCallbacks = new a();

    public ProcessProfileImpl(String str, Application application, MMApplicationLike mMApplicationLike) {
        super(str, application, mMApplicationLike);
    }

    public void onCreate() {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            {
                this.cli = r1;
            }

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onCreate();
            }
        });
    }

    public void onLowMemory() {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            {
                this.cli = r1;
            }

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onLowMemory();
            }
        });
    }

    public void onTrimMemory(final int i) {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onTrimMemory(i);
            }
        });
    }

    public void onTerminate() {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            {
                this.cli = r1;
            }

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onTerminate();
            }
        });
    }

    public void onConfigurationChanged(final Configuration configuration) {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onConfigurationChanged(configuration);
            }
        });
    }

    public void onBaseContextAttached(final Context context) {
        this.mApplicationLifeCycleCallbacks.a(new a.a<ApplicationLifeCycle>(this) {
            final /* synthetic */ ProcessProfileImpl cli;

            public final /* synthetic */ void an(Object obj) {
                ((ApplicationLifeCycle) obj).onBaseContextAttached(context);
            }
        });
    }

    public b addApplicationLifeCycleCallback(ApplicationLifeCycle applicationLifeCycle) {
        return this.mApplicationLifeCycleCallbacks.ay(applicationLifeCycle);
    }

    public void removeApplicationLifeCycleCallback(ApplicationLifeCycle applicationLifeCycle) {
        this.mApplicationLifeCycleCallbacks.remove(applicationLifeCycle);
    }
}
