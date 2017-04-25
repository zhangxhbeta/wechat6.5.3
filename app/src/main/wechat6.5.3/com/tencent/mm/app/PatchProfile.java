package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class PatchProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":patch");

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        t tVar = new t(c.ao(this.app.getBaseContext()));
        tVar.cR("PATCH");
        try {
            int intValue = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.uA(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            v.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!be.kS(string)) {
                d.cmW = "android-" + string;
                d.lWc = "android-" + string;
                d.lWe = string;
                b.JP(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.cmW).append(" ").append(b.bsJ());
            }
        } catch (Exception e2) {
            v.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.lWg).append(" new: ").append(intValue);
            d.lWg = (long) intValue;
        } catch (Exception e3) {
            v.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean a = be.a(tVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = be.a(tVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = be.a(tVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = be.a(tVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e4) {
            v.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.b(aa.getContext(), true);
        i.bk(aQE);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.nhg, PatchProfile.class.getClassLoader());
        k.a(this.app);
        com.tencent.mm.ay.c.a("hp", null, null);
        com.tencent.mm.ay.c.k("hp", null);
        v.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return aQE;
    }
}
