package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private int cRc = 0;
    private b cif;
    private e cii;

    public h(int i, String str) {
        a aVar = new a();
        aVar.czn = new anb();
        aVar.czo = new anc();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.czm = 1804;
        this.cif = aVar.Bv();
        anb com_tencent_mm_protocal_c_anb = (anb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_anb.myW = i;
        com_tencent_mm_protocal_c_anb.myY = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.h.a aVar2 = new com.tencent.mm.ui.h.a();
            bah com_tencent_mm_protocal_c_bah = new bah();
            if (aVar2.oYf == null) {
                com_tencent_mm_protocal_c_bah = null;
            } else if (!be.kS(aVar2.oYf.token)) {
                com_tencent_mm_protocal_c_bah.mWT = aVar2.oYf.token;
                com_tencent_mm_protocal_c_bah.mWU = aVar2.oYf.mIu;
            }
            com_tencent_mm_protocal_c_anb.mNq = com_tencent_mm_protocal_c_bah;
        }
        this.cRc = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1804;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
