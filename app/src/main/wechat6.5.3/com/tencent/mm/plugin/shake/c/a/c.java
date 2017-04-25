package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    private final b cif;
    private e cii;
    e iOG;

    public c(float f, float f2, int i, String str) {
        a aVar = new a();
        aVar.czn = new aub();
        aVar.czo = new auc();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        aVar.czm = 1250;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aub com_tencent_mm_protocal_c_aub = (aub) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aub.bhs = f2;
        com_tencent_mm_protocal_c_aub.biH = f;
        com_tencent_mm_protocal_c_aub.scene = i;
        com_tencent_mm_protocal_c_aub.mRH = str;
    }

    public final int getType() {
        return 1250;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            auc com_tencent_mm_protocal_c_auc = (auc) this.cif.czl.czs;
            if (com_tencent_mm_protocal_c_auc != null) {
                this.iOG = new e();
                this.iOG.eCZ = com_tencent_mm_protocal_c_auc.eCZ;
                this.iOG.eBK = com_tencent_mm_protocal_c_auc.eBK;
                this.iOG.bom = com_tencent_mm_protocal_c_auc.bom;
                this.iOG.title = com_tencent_mm_protocal_c_auc.title;
                this.iOG.eBN = com_tencent_mm_protocal_c_auc.eBN;
                this.iOG.eBO = com_tencent_mm_protocal_c_auc.eBO;
                this.iOG.eCD = com_tencent_mm_protocal_c_auc.eCD;
                this.iOG.eBM = com_tencent_mm_protocal_c_auc.eBM;
                this.iOG.coN = com_tencent_mm_protocal_c_auc.coN;
                this.iOG.iOH = com_tencent_mm_protocal_c_auc.iOH;
                this.iOG.iOK = com_tencent_mm_protocal_c_auc.iOK;
                this.iOG.iOL = com_tencent_mm_protocal_c_auc.iOL;
                this.iOG.iOM = com_tencent_mm_protocal_c_auc.iOM;
                this.iOG.iON = com_tencent_mm_protocal_c_auc.iON;
                this.iOG.iOO = com_tencent_mm_protocal_c_auc.iOO;
                this.iOG.eBR = com_tencent_mm_protocal_c_auc.eBR;
                this.iOG.iOP = com_tencent_mm_protocal_c_auc.iOP;
                this.iOG.iOQ = com_tencent_mm_protocal_c_auc.iOQ;
                com.tencent.mm.plugin.shake.b.k.aNU().iOJ = this.iOG.iOO;
            } else {
                this.iOG = new e();
                this.iOG.eCZ = 3;
                this.iOG.iOO = com.tencent.mm.plugin.shake.b.k.aNU().iOJ;
            }
        } else {
            this.iOG = new e();
            this.iOG.eCZ = 3;
            this.iOG.iOO = com.tencent.mm.plugin.shake.b.k.aNU().iOJ;
        }
        this.cii.a(i2, i3, str, this);
    }
}
