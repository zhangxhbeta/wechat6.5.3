package com.tencent.mm.wallet_core.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class j extends k {
    private final b cif;
    private e cii;
    public String fdU = null;
    public int piD = 0;

    public j(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        a aVar = new a();
        aVar.czn = new bdj();
        aVar.czo = new bdk();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.czm = 414;
        aVar.czp = 215;
        aVar.czq = 1000000215;
        this.cif = aVar.Bv();
        bdj com_tencent_mm_protocal_c_bdj = (bdj) this.cif.czk.czs;
        this.fdU = str;
        com_tencent_mm_protocal_c_bdj.mdM = str;
        com_tencent_mm_protocal_c_bdj.mZm = 1;
        com_tencent_mm_protocal_c_bdj.mNy = i2;
        com_tencent_mm_protocal_c_bdj.hNX = i;
        if (!be.kS(str6)) {
            com_tencent_mm_protocal_c_bdj.mNw = str6;
            com_tencent_mm_protocal_c_bdj.mNx = str5;
        }
        com_tencent_mm_protocal_c_bdj.mNz = str2;
        com_tencent_mm_protocal_c_bdj.mZo = str4;
        if (str3 != null) {
            com_tencent_mm_protocal_c_bdj.mZl = new are().ba(str3.getBytes());
        } else {
            com_tencent_mm_protocal_c_bdj.mZl = new are();
        }
        com_tencent_mm_protocal_c_bdj.mZn = (int) be.Nh();
        v.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.fdU + ",verifyType:1,palyType:" + i + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
    }

    public final void c(int i, int i2, String str, p pVar) {
        v.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i + "   errCode:" + i2);
        bdk com_tencent_mm_protocal_c_bdk = (bdk) ((b) pVar).czl.czs;
        if (com_tencent_mm_protocal_c_bdk.mQl != null) {
            this.piD = com_tencent_mm_protocal_c_bdk.mZq;
        }
        if (i == 0 && i2 == 0) {
            this.cii.a(i, i2, str, this);
        } else {
            this.cii.a(i, i2, str, this);
        }
    }

    public final String bLd() {
        bdk com_tencent_mm_protocal_c_bdk = (bdk) this.cif.czl.czs;
        if (com_tencent_mm_protocal_c_bdk == null) {
            return "";
        }
        v.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + com_tencent_mm_protocal_c_bdk.mqZ);
        v.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + com_tencent_mm_protocal_c_bdk.mZp);
        return com_tencent_mm_protocal_c_bdk.mqZ;
    }

    public final int getType() {
        return 414;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
