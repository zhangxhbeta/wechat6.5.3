package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.abe;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class aa extends k implements j {
    public String bom;
    private final b cif;
    private e cii;
    public int eDo;
    public String eDp;

    public aa(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new abd();
        aVar.czo = new abe();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        aVar.czm = 652;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        abd com_tencent_mm_protocal_c_abd = (abd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_abd.bol = str;
        com_tencent_mm_protocal_c_abd.mCx = str2;
        com_tencent_mm_protocal_c_abd.mCy = i;
    }

    public final int getType() {
        return 652;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        abe com_tencent_mm_protocal_c_abe;
        if (i2 == 0 && i3 == 0) {
            com_tencent_mm_protocal_c_abe = (abe) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_abe != null) {
                this.bom = com_tencent_mm_protocal_c_abe.bom;
                this.eDp = com_tencent_mm_protocal_c_abe.eDp;
                this.eDo = com_tencent_mm_protocal_c_abe.eDo;
            }
        } else {
            com_tencent_mm_protocal_c_abe = (abe) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_abe != null) {
                this.bom = com_tencent_mm_protocal_c_abe.bom;
                this.eDp = com_tencent_mm_protocal_c_abe.eDp;
                this.eDo = com_tencent_mm_protocal_c_abe.eDo;
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
