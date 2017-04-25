package com.tencent.mm.plugin.product.a;

import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a implements ag {
    private c hPY = null;
    private d hPZ = null;
    private com.tencent.mm.plugin.product.b.a hQa = new com.tencent.mm.plugin.product.b.a();

    public static a aFW() {
        a aVar = (a) ak.yP().fY("plugin.product");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreProduct", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.product", aVar);
        return aVar;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        this.hPY = null;
        com.tencent.mm.sdk.c.a.nhr.e(this.hQa);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hQa);
    }

    public static c aFX() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (aFW().hPY == null) {
            aFW().hPY = new c();
        }
        return aFW().hPY;
    }

    public final d aFY() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (this.hPZ == null) {
            this.hPZ = new d();
        }
        return this.hPZ;
    }
}
