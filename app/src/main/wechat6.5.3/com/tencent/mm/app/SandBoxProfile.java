package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.recovery.b;

public final class SandBoxProfile extends e {
    public static final String aQE = (aa.getPackageName() + ":sandbox");

    public final void onCreate() {
        c ao = c.ao(aa.getContext());
        k.setupBrokenLibraryHandler();
        k.b(a.nhg, SandBoxProfile.class.getClassLoader());
        k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(d.lWh);
        v vVar = new v(ao);
        try {
            vVar.cR("SANDBOX");
            q.dpY = be.a(vVar.cS(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + q.dpY);
        } catch (Error e) {
        }
        b.a(new com.tencent.mm.bc.e());
        k.a(this.app);
        com.tencent.mm.bc.c.brO();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return aQE;
    }
}
