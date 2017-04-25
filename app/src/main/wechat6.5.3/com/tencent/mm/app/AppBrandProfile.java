package com.tencent.mm.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import com.tencent.mm.booter.q;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMActivity;

public class AppBrandProfile extends e {
    protected static String aQq = "";

    public final void onCreate() {
        aQq = aa.getProcessName();
        ClassLoader classLoader = AppBrandProfile.class.getClassLoader();
        a.b(aa.getContext(), true);
        i.a(new c(this) {
            final /* synthetic */ AppBrandProfile aQr;

            {
                this.aQr = r1;
            }

            public final void oc() {
                g.iuh.a(365, 3, 1, false);
            }
        });
        i.bk(aQq);
        k.b("mmdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int rx = l.rx();
        if ((rx & 1024) != 0) {
            v.i("MicroMsg.AppBrandProfile", "load wechatsight_v7a, core number: %d", new Object[]{Integer.valueOf(rx >> 12)});
            k.b("wechatsight_v7a", classLoader);
            if ((rx >> 12) >= 4) {
                b.iTs = 3;
                b.iTt = 3;
                b.iTu = 544000;
            } else {
                b.iTs = 1;
                b.iTt = 1;
                b.iTu = 640000;
            }
        } else {
            v.i("MicroMsg.AppBrandProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            b.iTs = 1;
            b.iTt = 1;
            b.iTu = 640000;
        }
        a.b(aa.getContext(), true);
        k.a(this.app);
        MMActivity.ed(this.app.getBaseContext());
        FileOp.init(false);
        q qVar = new q(com.tencent.mm.booter.c.ao(this.app.getBaseContext()));
        qVar.cR("APPBRAND" + aQq.replace(aa.getPackageName() + ":appbrand", ""));
        com.tencent.mm.platformtools.q.dpx = be.a(qVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        com.tencent.mm.platformtools.q.dpy = be.a(qVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        com.tencent.mm.platformtools.q.dpz = be.a(qVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        com.tencent.mm.platformtools.q.dpA = be.a(qVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        com.tencent.mm.platformtools.q.dpB = be.a(qVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        com.tencent.mm.platformtools.q.dpC = be.a(qVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        com.tencent.mm.platformtools.q.dpG = be.a(qVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        com.tencent.mm.platformtools.q.dpH = be.a(qVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        com.tencent.mm.platformtools.q.dpK = be.a(qVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        com.tencent.mm.platformtools.q.dpL = be.a(qVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        com.tencent.mm.platformtools.q.dpM = be.a(qVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        com.tencent.mm.platformtools.q.dpN = be.a(qVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        com.tencent.mm.platformtools.q.dpQ = be.a(qVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        com.tencent.mm.platformtools.q.dpR = be.a(qVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        rx = be.a(qVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        com.tencent.mm.platformtools.q.dpO = rx;
        if (rx != 4 && com.tencent.mm.platformtools.q.dpO > 0) {
            s.noe = com.tencent.mm.platformtools.q.dpO;
            v.e("MicroMsg.AppBDebugger", "cdn thread num " + com.tencent.mm.platformtools.q.dpO);
        }
        com.tencent.mm.platformtools.q.dpP = be.a(qVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        com.tencent.mm.platformtools.q.dqh = be.a(qVar.cS(".com.tencent.mm.debug.forcex5webview"), false);
        try {
            rx = Integer.decode(qVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.uA(rx);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(rx));
        } catch (Exception e) {
            v.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            String string = qVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!be.kS(string)) {
                d.cmW = "android-" + string;
                d.lWc = "android-" + string;
                d.lWe = string;
                com.tencent.mm.sdk.b.b.JP(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.cmW).append(" ").append(com.tencent.mm.sdk.b.b.bsJ());
            }
        } catch (Exception e2) {
            v.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            rx = Integer.decode(qVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.lWg).append(" new: ").append(rx);
            d.lWg = (long) rx;
        } catch (Exception e3) {
            v.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            qVar.mDebugger.bXJ = Integer.decode(qVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            v.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        try {
            boolean a = be.a(qVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = be.a(qVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = be.a(qVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = be.a(qVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e5) {
            v.i("MicroMsg.AppBDebugger", "no debugger was got");
        }
        MMBitmapFactory.init();
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "pref_appbrand_process", 4);
        String str = aa.getProcessName() + ":start_time";
        Editor edit = sharedPreferences.edit();
        if (sharedPreferences.contains(str)) {
            edit.remove(str);
            g.iuh.a(365, 2, 1, false);
        }
        g.iuh.a(365, 4, 1, false);
        edit.putLong(str, System.currentTimeMillis());
        edit.commit();
        v.v("MicroMsg.AppBrandReporter", "onProcessStart");
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        v.v("MicroMsg.AppBrandProfile", "onTrimMemory(l : %d)", new Object[]{Integer.valueOf(i)});
    }
}
