package com.tencent.mm.booter;

import com.tencent.mm.e.a.kx;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class a implements u {
    private an bXr = new an();
    private com.tencent.mm.sdk.platformtools.an.a bXs = new com.tencent.mm.sdk.platformtools.an.a(this) {
        final /* synthetic */ a bXv;

        {
            this.bXv = r1;
        }

        public final void dx(int i) {
            switch (i) {
                case 0:
                    v.v("MicroMsg.BackgroundPlayer", "call end");
                    this.bXv.pT();
                    return;
                case 1:
                case 2:
                    v.v("MicroMsg.BackgroundPlayer", "call start");
                    this.bXv.pU();
                    return;
                default:
                    return;
            }
        }
    };
    private List<com.tencent.mm.model.v> bXt = new ArrayList();
    private c bXu;

    public a() {
        this.bXr.a(this.bXs);
        this.bXr.dU(aa.getContext());
        if (this.bXu == null) {
            this.bXu = new c<kx>(this) {
                final /* synthetic */ a bXv;

                {
                    this.bXv = r2;
                    this.nhz = kx.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    switch (((kx) bVar).bmt.state) {
                        case 0:
                            v.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                            this.bXv.pU();
                            break;
                        case 1:
                            v.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                            this.bXv.pT();
                            break;
                    }
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.bXu);
    }

    public final void a(com.tencent.mm.model.v vVar) {
        if (vVar != null) {
            v.d("MicroMsg.BackgroundPlayer", "add callback : %s", vVar.toString());
            this.bXt.add(vVar);
        }
    }

    public final void b(com.tencent.mm.model.v vVar) {
        if (vVar != null) {
            this.bXt.remove(vVar);
        }
    }

    public final void pT() {
        if (this.bXt != null) {
            for (com.tencent.mm.model.v yB : this.bXt) {
                yB.yB();
            }
        }
    }

    public final void pU() {
        if (this.bXt != null) {
            for (com.tencent.mm.model.v yC : this.bXt) {
                yC.yC();
            }
        }
    }
}
