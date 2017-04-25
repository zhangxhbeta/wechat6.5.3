package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import com.tencent.mm.kernel.a.b;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.g.AnonymousClass4;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.vending.h.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import junit.framework.Assert;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final MMApplicationLike lifeCycle;
    private ProcessProfile profile = null;
    private String thisProcess = SQLiteDatabase.KeyEmpty;

    public MMApplicationWrapper(MMApplicationLike mMApplicationLike, String str) {
        this.app = mMApplicationLike.getApplication();
        this.lifeCycle = mMApplicationLike;
        this.thisProcess = str;
    }

    public void onBaseContextAttached(Context context) {
        g.a(this.thisProcess, this.app, this.lifeCycle);
        g.vx();
        this.profile = g.vt().uZ();
        this.profile.onBaseContextAttached(context);
    }

    public void onCreate() {
        try {
            this.profile.onCreate();
            b boot = this.profile.boot();
            c eVar = new e();
            Assert.assertNotNull(eVar);
            g.vt().uZ().getProcessName();
            boot.clf = eVar;
            g vx = g.vx();
            ProcessProfile uZ = g.vt().uZ();
            long currentTimeMillis = System.currentTimeMillis();
            b.a("mmkernel boot startup for process [%s]...", uZ.getProcessName());
            b boot2 = uZ.boot();
            Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", boot2.clf);
            b.a("hello WeChat.", new Object[0]);
            boot2.clf.oh();
            long currentTimeMillis2 = System.currentTimeMillis();
            b.a("boot install plugins...", new Object[0]);
            boot2.clf.oi();
            b.a("boot all installed plugins : %s...", g.vs().cjK);
            b.a("boot install plugins done in [%s].", b.H(currentTimeMillis2));
            currentTimeMillis2 = System.currentTimeMillis();
            b.a("boot make dependency of plugins...", new Object[0]);
            boot2.clf.vE();
            b.a("boot make dependency of done in [%s].", b.H(currentTimeMillis2));
            currentTimeMillis2 = System.currentTimeMillis();
            b.a("boot configure plugins...", new Object[0]);
            boot2.clf.c(uZ);
            b.a("boot configure plugins done in [%s].", b.H(currentTimeMillis2));
            d dVar = d.phX;
            com.tencent.mm.vending.g.d.b anonymousClass4 = new AnonymousClass4(vx, currentTimeMillis);
            b.a("boot execute tasks...", new Object[0]);
            boot2.clf.a(uZ, dVar, anonymousClass4);
        } catch (final Throwable th) {
            new Handler().postAtFrontOfQueue(new Runnable(this) {
                final /* synthetic */ MMApplicationWrapper aQY;

                public final void run() {
                    throw th;
                }
            });
        }
    }

    public void onTerminate() {
        if (this.profile != null) {
            this.profile.onTerminate();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.profile != null) {
            this.profile.onConfigurationChanged(configuration);
        }
    }

    public void onLowMemory() {
        if (this.profile != null) {
            this.profile.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        if (this.profile != null) {
            this.profile.onTrimMemory(i);
        }
    }
}
