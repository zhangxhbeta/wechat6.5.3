package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private final b cif;
    private e cii;
    public String eDn;
    public int eDo;
    public String eDp;

    public g(int i, LinkedList<auo> linkedList, String str, String str2, auw com_tencent_mm_protocal_c_auw, int i2, axv com_tencent_mm_protocal_c_axv) {
        a aVar = new a();
        aVar.czn = new aum();
        aVar.czo = new aun();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        aVar.czm = 902;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aum com_tencent_mm_protocal_c_aum = (aum) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aum.mSd = i;
        com_tencent_mm_protocal_c_aum.cqE = linkedList;
        com_tencent_mm_protocal_c_aum.mSe = str;
        com_tencent_mm_protocal_c_aum.mxa = str2;
        v.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        com_tencent_mm_protocal_c_aum.mSf = com_tencent_mm_protocal_c_auw;
        com_tencent_mm_protocal_c_aum.bon = i2;
        com_tencent_mm_protocal_c_aum.lZP = com_tencent_mm_protocal_c_axv;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3)});
        aun com_tencent_mm_protocal_c_aun;
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            com_tencent_mm_protocal_c_aun = (aun) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_aun != null) {
                this.eDn = com_tencent_mm_protocal_c_aun.eDn;
                this.eDo = com_tencent_mm_protocal_c_aun.eDo;
                this.eDp = com_tencent_mm_protocal_c_aun.eDp;
            }
        } else {
            com_tencent_mm_protocal_c_aun = (aun) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_aun != null) {
                this.eDn = com_tencent_mm_protocal_c_aun.eDn;
                this.eDo = com_tencent_mm_protocal_c_aun.eDo;
                this.eDp = com_tencent_mm_protocal_c_aun.eDp;
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 902;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
