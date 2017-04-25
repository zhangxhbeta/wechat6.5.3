package com.tencent.mm.p;

import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class c implements ag {
    private a ciL;

    public c() {
        if (a.ciq == null) {
            a.ciq = new a();
        }
        this.ciL = a.ciq;
    }

    public final void th() {
        a aVar = this.ciL;
        aVar.cis.clear();
        b bVar = aVar.cir;
        v.d("MicroMsg.NewBandageDecoder", "[carl] decoder.clear()");
        bVar.ciB.clear();
        bVar.ciD.clear();
        bVar.ciC.clear();
        bVar.ciE.clear();
        aVar.cit = false;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        this.ciL.init();
    }

    public final void aH(boolean z) {
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public static a us() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        c cVar = (c) ak.yP().fY(c.class.getName());
        if (cVar == null) {
            cVar = new c();
            ak.yP().a(c.class.getName(), cVar);
            cVar.ciL.init();
        }
        return cVar.ciL;
    }
}
