package com.tencent.mm.ap;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public abstract class e extends b implements j, com.tencent.mm.v.e {
    int type;

    public final void JK() {
        f.a(aa.getContext(), "SoteLoginAuthKeyName", new d(this) {
            final /* synthetic */ e cZV;

            {
                this.cZV = r1;
            }

            public final void h(int i, String str, String str2) {
                v.i("MicroMsg.NetSceneSoterLoginBase", "alvinluo: generate login auth key onProcessEnd errCode: %d, errMsg: %s");
                if (i != 0 || be.kS(f.aQ(aa.getContext(), "SoteLoginAuthKeyName"))) {
                    this.cZV.b(3, i, str);
                    return;
                }
                com.tencent.mm.v.e eVar = this.cZV;
                k kVar = null;
                if (ak.uz()) {
                    eVar.type = 620;
                    ak.vy().a(eVar.type, eVar);
                    kVar = new f();
                }
                if (kVar != null) {
                    ak.vy().a(kVar, 0);
                }
            }
        }, false);
    }

    public final void a(int i, int i2, String str, k kVar) {
        ak.vy().b(this.type, (com.tencent.mm.v.e) this);
        if (i == 0 && i2 == 0) {
            a(this.czE, BH());
        } else {
            b(3, i2, str);
        }
    }
}
