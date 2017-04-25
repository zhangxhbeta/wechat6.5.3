package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class k extends com.tencent.mm.v.k implements j {
    private final b cif;
    private e cii;
    public String eDn;
    public int eDo;
    public String eDp;

    public k(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, axv com_tencent_mm_protocal_c_axv) {
        a aVar = new a();
        aVar.czn = new ac();
        aVar.czo = new ad();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        aVar.czm = 651;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ac acVar = (ac) this.cif.czk.czs;
        acVar.bol = str;
        acVar.eCB = str2;
        acVar.bon = i;
        acVar.bom = str3;
        acVar.lZM = str4;
        acVar.lZL = str5;
        acVar.lZN = i2;
        acVar.lZO = i3;
        acVar.lZP = com_tencent_mm_protocal_c_axv;
    }

    public final int getType() {
        return 651;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        ad adVar;
        if (i2 == 0 && i3 == 0) {
            adVar = (ad) this.cif.czl.czs;
            if (adVar != null) {
                this.eDn = adVar.eDn;
                this.eDo = adVar.eDo;
                this.eDp = adVar.eDp;
            }
        } else {
            adVar = (ad) this.cif.czl.czs;
            if (adVar != null) {
                this.eDn = adVar.eDn;
                this.eDo = adVar.eDo;
                this.eDp = adVar.eDp;
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
