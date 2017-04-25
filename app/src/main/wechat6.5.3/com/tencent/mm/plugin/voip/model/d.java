package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.ui.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.v.d.c;
import java.util.HashMap;

public final class d implements ag {
    private m krt = null;
    private i kru = new i();
    f krv;
    private a krw = new a();

    private static d bbv() {
        d dVar = (d) ak.yP().fY("plugin.voip");
        if (dVar != null) {
            return dVar;
        }
        dVar = new d();
        ak.yP().a("plugin.voip", dVar);
        return dVar;
    }

    public static m bbw() {
        if (ak.uz()) {
            if (bbv().krt == null) {
                bbv().krt = new m();
            }
            return bbv().krt;
        }
        throw new b();
    }

    public static f bbx() {
        if (ak.uz()) {
            if (bbv().krv == null) {
                bbv().krv = new f();
            }
            return bbv().krv;
        }
        throw new b();
    }

    public final void th() {
        if (this.krv != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ d krx;

                {
                    this.krx = r1;
                }

                public final void run() {
                    this.krx.krv.dismiss();
                    this.krx.krv = null;
                }
            });
        }
        c.aw(Integer.valueOf(50));
        bbw();
        m.bcK();
        com.tencent.mm.sdk.c.a.nhr.f(this.krw);
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        c.a(Integer.valueOf(50), this.kru);
        bbw();
        m.bcJ();
        com.tencent.mm.sdk.c.a.nhr.e(this.krw);
        ak.oH().cancel(40);
    }

    public final void aH(boolean z) {
    }
}
