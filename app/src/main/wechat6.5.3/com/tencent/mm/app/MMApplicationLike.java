package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import com.tencent.mm.app.f.AnonymousClass1;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.f;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.recovery.a.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.util.HashMap;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String NO_SPACE_FOR_DEX_PROCESS = ":nospace";
    private static final String TAG = "MicroMsg.MMApplication";
    public static MMApplicationLike applicationLike;
    public static String hash = SQLiteDatabase.KeyEmpty;
    public static long sAppStartTime;
    public long mGetRevTime;
    public String mNewVersionCode;
    public String mOldVersionCode;
    public long mSetRevTime;
    private ApplicationLifeCycle wrapper;

    public static ApplicationLike getTinkerApplicationLike() {
        return applicationLike;
    }

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent, Resources[] resourcesArr, ClassLoader[] classLoaderArr, AssetManager[] assetManagerArr) {
        super(application, i, z, j, j2, intent, resourcesArr, classLoaderArr, assetManagerArr);
    }

    private void setPatchRev(ApplicationLike applicationLike) {
        if (applicationLike != null) {
            if (applicationLike == null || applicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            HashMap ah = (tinkerResultIntent == null || ShareIntentUtil.ac(tinkerResultIntent) != 0) ? null : ShareIntentUtil.ah(tinkerResultIntent);
            if (ah != null) {
                BaseBuildInfo.cnd = (String) ah.get("patch.rev");
                v.w(TAG, "application set patch rev:%s", BaseBuildInfo.cnd);
            }
        }
    }

    public void onBaseContextAttached(Context context) {
        b bVar;
        super.onBaseContextAttached(context);
        sAppStartTime = getApplicationStartMillisTime();
        applicationLike = this;
        setPatchRev(applicationLike);
        hash += "/" + hashCode();
        aa.iv(false);
        aa.setContext(getApplication());
        String p = d.p(context, Process.myPid());
        Application application = getApplication();
        if (p == null || p.length() == 0) {
            bVar = null;
        } else if (p.equals(context.getPackageName())) {
            bVar = a.a(p, 10000, 20000, com.tencent.recovery.a.a.ptJ, true);
        } else if (p.equals(context.getPackageName() + ":push")) {
            bVar = a.a(p, 5000, 20000, com.tencent.recovery.a.a.ptI, false);
        } else if (p.equals(context.getPackageName() + ":tools")) {
            bVar = a.a(p, 10000, 20000, com.tencent.recovery.a.a.ptJ, true);
        } else if (p.equals(context.getPackageName() + ":exdevice")) {
            bVar = a.a(p, 5000, 5000, com.tencent.recovery.a.a.ptI, false);
        } else if (p.equals(context.getPackageName() + ":sandbox")) {
            bVar = a.a(p, 5000, 5000, com.tencent.recovery.a.a.ptI, false);
        } else {
            bVar = null;
        }
        if (f.ned == null) {
            f.ned = new f();
        }
        com.tencent.recovery.b.a(application, context, bVar, f.ned);
        v.uZ(0);
        Application application2 = getApplication();
        if (!"com.tencent.mm:cuploader".equals(p)) {
            ag.a(new AnonymousClass1(application2, p));
            ag.a(new ag.a() {
                public final void ol() {
                    String str = BaseBuildInfo.cnd;
                }
            });
        }
        boolean endsWith = p.endsWith(NO_SPACE_FOR_DEX_PROCESS);
        clearOldDirIfNewVersion();
        if (!endsWith) {
            com.tencent.mm.d.a.b(getApplication(), false);
        }
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(aa.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{MMApplicationLike.class, String.class}).newInstance(new Object[]{this, p});
            this.wrapper.onBaseContextAttached(context);
        } catch (Throwable e) {
            v.a(TAG, e, "failed to create application wrapper class", new Object[0]);
            throw new RuntimeException("failed to create application wrapper class", e);
        }
    }

    private void clearOldDirIfNewVersion() {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.h.a aVar = new com.tencent.mm.sdk.h.a(com.tencent.mm.loader.stub.a.cng + "NowRev.ini");
        this.mOldVersionCode = aVar.getValue("NowRev");
        this.mNewVersionCode = BaseBuildInfo.vY();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.mGetRevTime = currentTimeMillis2 - currentTimeMillis;
        this.mSetRevTime = 0;
        if (!this.mNewVersionCode.equals(this.mOldVersionCode)) {
            aa.niD = true;
            com.tencent.mm.loader.stub.b.f(getApplication().getDir("lib", 0));
            com.tencent.mm.loader.stub.b.f(getApplication().getDir("dex", 0));
            com.tencent.mm.loader.stub.b.f(getApplication().getDir("cache", 0));
            com.tencent.mm.loader.stub.b.f(getApplication().getDir("recover_lib", 0));
            com.tencent.tinker.lib.d.b.d(applicationLike);
            aVar.dD("NowRev", this.mNewVersionCode);
            this.mSetRevTime = System.currentTimeMillis() - currentTimeMillis2;
            v.w(TAG, "application hash:%s, %s", hash, new af().toString());
        }
        v.i(TAG, "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", this.mOldVersionCode, this.mNewVersionCode, Long.valueOf(this.mGetRevTime), Long.valueOf(this.mSetRevTime));
    }

    public void onCreate() {
        super.onCreate();
        this.wrapper.onCreate();
        com.tencent.recovery.b.bMu();
    }

    public void onTerminate() {
        super.onTerminate();
        this.wrapper.onTerminate();
    }

    public void onConfigurationChanged(Configuration configuration) {
        v.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        this.wrapper.onConfigurationChanged(configuration);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.wrapper.onLowMemory();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.wrapper.onTrimMemory(i);
    }
}
