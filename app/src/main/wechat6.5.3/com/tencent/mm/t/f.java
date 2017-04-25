package com.tencent.mm.t;

import com.tencent.mm.modelsearch.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class f extends c implements j {
    private final b cxe;
    private e cxf;
    private bgw cxg;

    public f(String str, int i, String str2, int i2, int i3, int i4, String str3, int i5, String str4) {
        this.cVg = str;
        this.vI = i;
        this.cVh = i3;
        a aVar = new a();
        aVar.czn = new bgv();
        aVar.czo = new bgw();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        aVar.czm = 1162;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cxe = aVar.Bv();
        bgv com_tencent_mm_protocal_c_bgv = (bgv) this.cxe.czk.czs;
        com_tencent_mm_protocal_c_bgv.mxU = str;
        com_tencent_mm_protocal_c_bgv.mfb = i;
        com_tencent_mm_protocal_c_bgv.miU = str2;
        com_tencent_mm_protocal_c_bgv.nck = i2;
        com_tencent_mm_protocal_c_bgv.ncj = i4;
        com_tencent_mm_protocal_c_bgv.ncl = b.jHr;
        com_tencent_mm_protocal_c_bgv.pRx = str3;
        com_tencent_mm_protocal_c_bgv.pRy = i5;
        com_tencent_mm_protocal_c_bgv.pRz = str4;
        com_tencent_mm_protocal_c_bgv.ncm = b.jHs;
        v.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID:%s, KeywordID:%s", new Object[]{com_tencent_mm_protocal_c_bgv.ncl, com_tencent_mm_protocal_c_bgv.ncm});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cxg = (bgw) this.cxe.czl.czs;
        if (this.cxg != null) {
            v.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", new Object[]{this.cxg.min});
        }
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1162;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }

    public final String AI() {
        return this.cxg != null ? this.cxg.min : "";
    }

    public final int AJ() {
        return this.cxg != null ? this.cxg.ncn : 0;
    }
}
