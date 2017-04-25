package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class q extends k implements j {
    private final b cif;
    private e cxf;
    public String fZW;
    public String lea;
    public String leb;
    public String lec;
    public int led;

    public q(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new ahb();
        aVar.czo = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        aVar.czm = 1177;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ahb com_tencent_mm_protocal_c_ahb = (ahb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahb.eBQ = str;
        com_tencent_mm_protocal_c_ahb.mGS = str2;
        com_tencent_mm_protocal_c_ahb.eES = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ahc com_tencent_mm_protocal_c_ahc = (ahc) this.cif.czl.czs;
            this.lea = com_tencent_mm_protocal_c_ahc.lea;
            this.fZW = com_tencent_mm_protocal_c_ahc.fZW;
            this.leb = com_tencent_mm_protocal_c_ahc.leb;
            this.lec = com_tencent_mm_protocal_c_ahc.lec;
            this.led = com_tencent_mm_protocal_c_ahc.led;
            v.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[]{this.lea, this.fZW, this.leb, this.lec, Integer.valueOf(this.led)});
        }
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
