package com.tencent.mm.ao;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    String cXb;
    private final b cif;
    private e cii;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ath();
        aVar.czo = new ati();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        this.cif = aVar.Bv();
        afu com_tencent_mm_protocal_c_afu = new afu();
        com_tencent_mm_protocal_c_afu.mrC = str2;
        com_tencent_mm_protocal_c_afu.mrD = i2;
        com_tencent_mm_protocal_c_afu.mjN = f2;
        com_tencent_mm_protocal_c_afu.mjM = f;
        com_tencent_mm_protocal_c_afu.mrB = str;
        com_tencent_mm_protocal_c_afu.mrA = i;
        ath com_tencent_mm_protocal_c_ath = (ath) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ath.moG = com_tencent_mm_protocal_c_afu;
        com_tencent_mm_protocal_c_ath.mRz = i3;
        com_tencent_mm_protocal_c_ath.maG = i4;
        com_tencent_mm_protocal_c_ath.hQP = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cXb = ((ati) ((b) pVar).czl.czs).hQP;
        } else {
            v.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 752;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
