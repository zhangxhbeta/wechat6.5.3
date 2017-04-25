package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private String aXp;
    private e cii;
    private b exr;
    private long ext;
    public asc exu;
    private int scene;

    public i(String str, long j, int i) {
        this.aXp = str;
        this.ext = j;
        this.scene = i;
        v.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.exr != null) {
            this.exu = (asc) this.exr.czl.czs;
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1070;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.cii = eVar2;
        if (be.kS(this.aXp)) {
            v.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
            return -1;
        }
        a aVar = new a();
        aVar.czm = 1070;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
        aVar.czn = new asb();
        aVar.czo = new asc();
        aVar.czp = 0;
        aVar.czq = 0;
        this.exr = aVar.Bv();
        asb com_tencent_mm_protocal_c_asb = (asb) this.exr.czk.czs;
        com_tencent_mm_protocal_c_asb.mxU = this.aXp;
        com_tencent_mm_protocal_c_asb.mGZ = c.Ig();
        com_tencent_mm_protocal_c_asb.miQ = this.ext;
        com_tencent_mm_protocal_c_asb.mQL = this.scene;
        v.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[]{Long.valueOf(this.ext)});
        return a(eVar, this.exr, this);
    }
}
