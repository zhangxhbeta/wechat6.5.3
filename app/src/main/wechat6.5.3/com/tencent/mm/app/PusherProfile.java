package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.p;
import com.tencent.mm.booter.r;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;

public final class PusherProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":push");
    private Shell aRs = new Shell();

    public final void onCreate() {
        Context context = aa.getContext();
        AppLogic.setCallBack(new AppCallBack(aa.getContext()));
        k.b(a.nhf, PusherProfile.class.getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        r uVar = new u(c.ao(context));
        uVar.cR("PUSH");
        q.dpx = be.a(uVar.cS(".com.tencent.mm.debug.test.display_errcode"), false);
        q.dpy = be.a(uVar.cS(".com.tencent.mm.debug.test.display_msgstate"), false);
        q.dpz = be.a(uVar.cS(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        q.dpA = be.a(uVar.cS(".com.tencent.mm.debug.test.network.force_touch"), false);
        q.dpB = be.a(uVar.cS(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        q.dpC = be.a(uVar.cS(".com.tencent.mm.debug.test.crashIsExit"), false);
        q.dpG = be.a(uVar.cS(".com.tencent.mm.debug.test.album_show_info"), false);
        q.dpH = be.a(uVar.cS(".com.tencent.mm.debug.test.location_help"), false);
        q.dpK = be.a(uVar.cS(".com.tencent.mm.debug.test.force_soso"), false);
        q.dpL = be.a(uVar.cS(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        q.dpM = be.a(uVar.cS(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        q.dpN = be.a(uVar.cS(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        q.dpQ = be.a(uVar.cS(".com.tencent.mm.debug.test.filterfpnp"), false);
        q.dpR = be.a(uVar.cS(".com.tencent.mm.debug.test.testForPull"), false);
        int a = be.a(uVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        q.dpO = a;
        if (a != 4 && q.dpO > 0) {
            s.noe = q.dpO;
            v.e("MicroMsg.PushDebugger", "cdn thread num " + q.dpO);
        }
        q.dpP = be.a(uVar.cS(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        q.dpU = be.a(uVar.cS(".com.tencent.mm.debug.test.skip_getdns"), false);
        try {
            a = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.uA(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            v.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            String string = uVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!be.kS(string)) {
                d.cmW = "android-" + string;
                d.lWc = "android-" + string;
                d.lWe = string;
                b.JP(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.cmW).append(" ").append(b.bsJ());
            }
        } catch (Exception e2) {
            v.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.lWg).append(" new: ").append(a);
            d.lWg = (long) a;
        } catch (Exception e3) {
            v.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            uVar.mDebugger.bXJ = Integer.decode(uVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            v.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            boolean a2 = be.a(uVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = be.a(uVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = be.a(uVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = be.a(uVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            v.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        p.onCreate(false);
        com.tencent.mm.ay.c.a("gcm", null, null);
        com.tencent.mm.ay.c.k("gcm", null);
        com.tencent.mm.sdk.c.a.nhr.e(new com.tencent.mm.sdk.c.c<fo>(this) {
            final /* synthetic */ PusherProfile aRt;

            {
                this.aRt = r2;
                this.nhz = fo.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                String str = "gcm";
                String str2 = "GCMDoSyncEvent Notify Now Always should be MM_NEWSYNC_DEFAULT_SELECTOR  & SCENE_SYNC_GCM  atapter == null[%b]";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(z.Mz() == null);
                v.i(str, str2, objArr);
                if (z.Mz() != null) {
                    z.Mz().onPush(2147480001, new byte[0]);
                } else {
                    z.bn(true);
                }
                return true;
            }
        });
        be.ed(aa.getContext());
        com.tencent.recovery.b.a(new com.tencent.mm.bc.e());
        com.tencent.mm.bc.c.brO();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return aQE;
    }
}
