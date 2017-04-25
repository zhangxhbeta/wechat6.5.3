package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.e;
import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;
import java.util.HashMap;

public final class x implements ag {
    private w ibF;
    private q ich;
    private b ici = new b();

    private static x aHF() {
        x xVar = (x) ak.yP().fY("plugin.qqmail");
        if (xVar != null) {
            return xVar;
        }
        xVar = new x();
        ak.yP().a("plugin.qqmail", xVar);
        return xVar;
    }

    public static q aHG() {
        ak.yW();
        if (c.ww() == 0) {
            throw new b();
        }
        if (aHF().ich == null) {
            aHF().ich = new q(d.lWh, d.cmW);
        }
        return aHF().ich;
    }

    public static w aHH() {
        ak.yW();
        if (c.ww() == 0) {
            throw new b();
        }
        if (aHF().ibF == null) {
            aHF().ibF = new w();
        }
        return aHF().ibF;
    }

    public final void th() {
        q qVar = aHF().ich;
        if (qVar != null) {
            qVar.reset();
        }
        a.nhr.f(this.ici);
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
        if ((i & 1) != 0) {
            aHI();
        }
    }

    public static void aHI() {
        aw.fO("qqmail");
        ak.yW();
        c.wK().Mf("qqmail");
        q aHG = aHG();
        ak.yW();
        e.e(new File(c.wZ()));
        aHG.reset();
    }

    public final void aG(boolean z) {
        a.nhr.e(this.ici);
        ad.o(new Runnable(this) {
            final /* synthetic */ x icj;

            {
                this.icj = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    t tVar = new t();
                    if (tVar.ibD.hjx.size() > 0) {
                        for (int i = 0; i < tVar.ibD.hjx.size(); i++) {
                            t.ye(((r) tVar.ibD.hjx.get(i)).iav);
                        }
                        tVar.ibD.hjx.clear();
                        tVar.save();
                    }
                }
            }
        });
    }

    public final void aH(boolean z) {
    }
}
