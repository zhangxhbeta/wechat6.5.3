package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.mw;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.plugin.brandservice.ui.a.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.f.e;
import java.util.HashMap;

public final class b implements ag {
    private a exi;

    public static class a extends c<mw> {
        public a() {
            this.nhz = mw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            mw mwVar = (mw) bVar;
            if (mwVar instanceof mw) {
                if (!(mwVar.boh == null || be.kS(mwVar.boh.bmE) || mwVar.boh.boi == null)) {
                    ak.vy().a(new l(mwVar.boh.bmE, mwVar.boh.boi), 0);
                }
                return true;
            }
            v.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
            return false;
        }
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        v.d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.exi == null) {
            this.exi = new a();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.exi);
        e.a(new d());
        e.a(new com.tencent.mm.plugin.brandservice.ui.a.b());
    }

    public final void th() {
        if (this.exi != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.exi);
        }
        e.xZ(96);
        e.xZ(4192);
    }
}
