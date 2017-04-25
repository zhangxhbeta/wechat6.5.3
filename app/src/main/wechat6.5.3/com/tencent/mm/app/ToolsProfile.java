package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.r;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.recovery.b;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

public final class ToolsProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":tools");
    private static int aRu = 0;
    private static Locale locale;

    static /* synthetic */ int ou() {
        int i = aRu;
        aRu = i + 1;
        return i;
    }

    static /* synthetic */ int ov() {
        int i = aRu;
        aRu = i - 1;
        return i;
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        a.b(aa.getContext(), true);
        i.bk(aQE);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.nhg, ToolsProfile.class.getClassLoader());
        b.a(new com.tencent.mm.bc.e());
        k.b("mmdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b("wechatImgTools", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int rx = l.rx();
        if ((rx & 1024) != 0) {
            v.i("MicroMsg.ToolsProfile", "load wechatsight_v7a, core number: %d", Integer.valueOf(rx >> 12));
            k.b("wechatsight_v7a", classLoader);
            if ((rx >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.iTs = 3;
                com.tencent.mm.plugin.sight.base.b.iTt = 3;
                com.tencent.mm.plugin.sight.base.b.iTu = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.iTs = 1;
                com.tencent.mm.plugin.sight.base.b.iTt = 1;
                com.tencent.mm.plugin.sight.base.b.iTu = 640000;
            }
        } else {
            v.i("MicroMsg.ToolsProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.iTs = 1;
            com.tencent.mm.plugin.sight.base.b.iTt = 1;
            com.tencent.mm.plugin.sight.base.b.iTu = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.ed(this.app.getBaseContext());
        k.a(this.app);
        r wVar = new w(c.ao(this.app.getBaseContext()));
        wVar.cR("TOOL");
        q.dpx = be.a(wVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        q.dpy = be.a(wVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        q.dpz = be.a(wVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        q.dpA = be.a(wVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        q.dpB = be.a(wVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        q.dpC = be.a(wVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        q.dpG = be.a(wVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        q.dpH = be.a(wVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        q.dpK = be.a(wVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        q.dpL = be.a(wVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        q.dpM = be.a(wVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        q.dpN = be.a(wVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        q.dpQ = be.a(wVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        q.dpR = be.a(wVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        rx = be.a(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        q.dpO = rx;
        if (rx != 4 && q.dpO > 0) {
            s.noe = q.dpO;
            v.e("MicroMsg.ToolDebugger", "cdn thread num " + q.dpO);
        }
        q.dpP = be.a(wVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            rx = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.uA(rx);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(rx));
        } catch (Exception e) {
            v.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!be.kS(string)) {
                d.cmW = "android-" + string;
                d.lWc = "android-" + string;
                d.lWe = string;
                com.tencent.mm.sdk.b.b.JP(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.cmW).append(" ").append(com.tencent.mm.sdk.b.b.bsJ());
            }
        } catch (Exception e2) {
            v.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            rx = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.lWg).append(" new: ").append(rx);
            d.lWg = (long) rx;
        } catch (Exception e3) {
            v.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.mDebugger.bXJ = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            v.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a = be.a(wVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = be.a(wVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = be.a(wVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = be.a(wVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e5) {
            v.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        q.dqe = be.ah(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), SQLiteDatabase.KeyEmpty);
        v.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + q.dqe);
        q.dqf = be.ah(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), SQLiteDatabase.KeyEmpty);
        v.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + q.dqf);
        q.dqg = be.a(wVar.cS(".com.tencent.mm.debug.skiploadurlcheck"), false);
        v.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + q.dqg);
        q.dqh = be.a(wVar.cS(".com.tencent.mm.debug.forcex5webview"), false);
        v.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + q.dqh);
        if (com.tencent.mm.compatible.util.d.dW(14) && MMApplicationLike.applicationLike != null) {
            MMApplicationLike.applicationLike.getApplication().registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(this) {
                final /* synthetic */ ToolsProfile aRv;

                {
                    this.aRv = r1;
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    ToolsProfile.ou();
                }

                public final void onActivityDestroyed(Activity activity) {
                    ToolsProfile.ov();
                    v.d("MicroMsg.ToolsProfile", "onActivityDestroyed, after destroy, activityInstanceNum = %d", Integer.valueOf(ToolsProfile.aRu));
                    if (ToolsProfile.aRu == 0) {
                        v.i("MicroMsg.ToolsProfile", "onActivityDestroyed, tbsNeedReboot = %b", Boolean.valueOf(WebView.getTbsNeedReboot()));
                        if (WebView.getTbsNeedReboot()) {
                            int myPid = Process.myPid();
                            b.yH(13);
                            Process.killProcess(myPid);
                        }
                    }
                }

                public final void onActivityPaused(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityStopped(Activity activity) {
                }
            });
        }
        FileOp.init(false);
        MMBitmapFactory.init();
        v.i("MicroMsg.ToolsProfile", "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.bc.c.brO();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Locale ed = MMActivity.ed(this.app.getBaseContext());
        v.d("MicroMsg.ToolsProfile", "onConfigurationChanged, locale = " + locale.toString() + ", n = " + ed.toString());
        if (!ed.equals(locale)) {
            v.w("MicroMsg.ToolsProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return aQE;
    }
}
