package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends k implements j {
    private final b cif;
    private e cii;
    public String eDn;

    public w(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, axv com_tencent_mm_protocal_c_axv) {
        a aVar = new a();
        aVar.czn = new ud();
        aVar.czo = new ue();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        aVar.czm = 645;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ud udVar = (ud) this.cif.czk.czs;
        udVar.bol = str;
        udVar.bon = i;
        udVar.eCB = str2;
        udVar.bom = str3;
        udVar.lZM = str4;
        udVar.lZL = str5;
        udVar.lZN = i2;
        udVar.mxa = str6;
        udVar.lZP = com_tencent_mm_protocal_c_axv;
    }

    public final int getType() {
        return 645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.eDn = ((ue) this.cif.czl.czs).eDn;
        }
        this.cii.a(i2, i3, str, this);
    }
}
