package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.at;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b implements ag {
    private static b kCV = null;
    private a kCW = new a();
    private d kCX = new d();
    private c kCY = new c();
    private com.tencent.mm.plugin.voip_cs.a.a kCZ = new com.tencent.mm.plugin.voip_cs.a.a();
    private c kDa = new c<at>(this) {
        final /* synthetic */ b kDb;

        {
            this.kDb = r2;
            this.nhz = at.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            boolean z = true;
            at atVar = (at) bVar;
            if (atVar instanceof at) {
                at.a aVar = atVar.aYv;
                if (!(b.bec().kEe == 1 || b.bec().kEe == 2)) {
                    z = false;
                }
                aVar.aYi = z;
            }
            return false;
        }
    };

    private static b bea() {
        if (kCV == null) {
            kCV = new b();
            ak.yP().a("plugin.voip_cs", kCV);
        }
        return kCV;
    }

    public static a beb() {
        return bea().kCW;
    }

    public static d bec() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (bea().kCX == null) {
            bea().kCX = new d();
        }
        return bea().kCX;
    }

    public static c bed() {
        return bea().kCY;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.c.a.nhr.e(this.kCZ);
        com.tencent.mm.sdk.c.a.nhr.e(this.kDa);
        ak.oH().cancel(44);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kCZ);
        com.tencent.mm.sdk.c.a.nhr.f(this.kDa);
    }
}
