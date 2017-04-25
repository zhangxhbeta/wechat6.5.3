package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public b cif;
    private e cii;

    public c(float f, float f2, int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.czn = new afn();
        aVar.czo = new afo();
        aVar.uri = "/cgi-bin/mmbiz-bin/lbslife/lbslifegetnearbyrecommendpoi";
        aVar.czm = 1087;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        afn com_tencent_mm_protocal_c_afn = (afn) this.cif.czk.czs;
        amy com_tencent_mm_protocal_c_amy = new amy();
        com_tencent_mm_protocal_c_amy.mjM = f;
        com_tencent_mm_protocal_c_amy.mjN = f2;
        com_tencent_mm_protocal_c_amy.mrA = i;
        com_tencent_mm_protocal_c_amy.mrB = str;
        com_tencent_mm_protocal_c_amy.mrC = str2;
        com_tencent_mm_protocal_c_amy.mrD = i2;
        com_tencent_mm_protocal_c_afn.mFp = com_tencent_mm_protocal_c_amy;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneLBSLifeGetNearbyRecommendPoi", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1087;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
