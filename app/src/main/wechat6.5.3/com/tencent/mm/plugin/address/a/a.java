package com.tencent.mm.plugin.address.a;

import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.plugin.address.model.h;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a implements ag {
    private i dxh = null;
    private g dxi = new g();
    private h dxj = new h();

    public static a Op() {
        a aVar = (a) ak.yP().fY("plugin.address");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.address", aVar);
        return aVar;
    }

    public static i Oq() {
        ak.yW();
        if (c.ww() == 0) {
            throw new b();
        }
        if (Op().dxh == null) {
            Op().dxh = new i();
        }
        return Op().dxh;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.dxi);
        com.tencent.mm.sdk.c.a.nhr.e(this.dxj);
        this.dxh = null;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.dxi);
        com.tencent.mm.sdk.c.a.nhr.f(this.dxj);
    }
}
