package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ExDeviceProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":exdevice");

    public final void onCreate() {
        v.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        c ao = c.ao(this.app.getBaseContext());
        a.b(aa.getContext(), true);
        i.bk(aQE);
        k.setupBrokenLibraryHandler();
        s sVar = new s(ao);
        sVar.cR("EXDEVICE");
        q.dpx = be.a(sVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        q.dpy = be.a(sVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        q.dpz = be.a(sVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        q.dpA = be.a(sVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        q.dpB = be.a(sVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        q.dpC = be.a(sVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        q.dpG = be.a(sVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        q.dpH = be.a(sVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        q.dpK = be.a(sVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        q.dpL = be.a(sVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        q.dpM = be.a(sVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        q.dpN = be.a(sVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        q.dpQ = be.a(sVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        q.dpR = be.a(sVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = be.a(sVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        q.dpO = a;
        if (a != 4 && q.dpO > 0) {
            com.tencent.mm.storage.s.noe = q.dpO;
            v.e("MicroMsg.ExdDebugger", "cdn thread num " + q.dpO);
        }
        q.dpP = be.a(sVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.uA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            v.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = sVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!be.kS(string)) {
                d.cmW = "android-" + string;
                d.lWc = "android-" + string;
                d.lWe = string;
                b.JP(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.cmW).append(" ").append(b.bsJ());
            }
        } catch (Exception e2) {
            v.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.lWg).append(" new: ").append(a);
            d.lWg = (long) a;
        } catch (Exception e3) {
            v.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean a2 = be.a(sVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = be.a(sVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = be.a(sVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = be.a(sVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e4) {
            v.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        q.dqe = be.ah(sVar.getString(".com.tencent.mm.debug.jsapi.permission"), SQLiteDatabase.KeyEmpty);
        v.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + q.dqe);
        q.dqf = be.ah(sVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), SQLiteDatabase.KeyEmpty);
        v.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + q.dqf);
        q.dqg = be.a(sVar.cS(".com.tencent.mm.debug.skiploadurlcheck"), false);
        v.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + q.dqg);
        com.tencent.recovery.b.a(new com.tencent.mm.bc.e());
        k.a(this.app);
        com.tencent.mm.bc.c.brO();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        v.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    }

    public String toString() {
        return aQE;
    }
}
