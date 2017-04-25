package com.tencent.mm.model.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class f implements ag {
    private b cvY = null;

    private static f Ai() {
        f fVar = (f) ak.yP().fY(f.class.getName());
        if (fVar == null) {
            synchronized (f.class) {
                if (fVar == null) {
                    fVar = new f();
                    ak.yP().a(f.class.getName(), fVar);
                }
            }
        }
        return fVar;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        b Aj = Aj();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ak.yW();
            Aj.gb((String) com.tencent.mm.model.c.vf().get(328193, null));
            if (Aj.Ah()) {
                e.gd(Aj.cvS.cvO);
            }
        } catch (Exception e) {
            v.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
        }
        v.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        b Aj = Aj();
        Aj.cvT = null;
        Aj.cvS = null;
    }

    public static b Aj() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        if (Ai().cvY == null) {
            Ai().cvY = new b();
        }
        return Ai().cvY;
    }
}
