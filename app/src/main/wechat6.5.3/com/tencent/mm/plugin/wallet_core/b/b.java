package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.e.a.me;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(LinkedList<String> linkedList) {
        v.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.czn = new sx();
        aVar.czo = new sy();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        aVar.czm = 1650;
        this.cif = aVar.Bv();
        this.cif.czB = true;
        sx sxVar = (sx) this.cif.czk.czs;
        sxVar.mwt = linkedList;
        sxVar.mkb = f.bfP();
        com.tencent.mm.wallet_core.ui.e.yD(42);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            sy syVar = (sy) ((com.tencent.mm.v.b) pVar).czl.czs;
            LinkedList linkedList = syVar.mwu;
            if (linkedList == null || linkedList.size() == 0) {
                v.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                me meVar = new me();
                meVar.bnm.bno = linkedList;
                com.tencent.mm.sdk.c.a.nhr.z(meVar);
            }
            ak.yW();
            c.vf().a(t.a.nsA, be.ah(syVar.mwv, ""));
            ak.yW();
            c.vf().a(t.a.nsB, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.e.yD(43);
        }
        this.cii.a(i2, i3, str, this);
    }
}
