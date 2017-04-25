package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private b czf;
    private e hGc;
    public String hGd;

    public a(String str, String str2, String str3, afu com_tencent_mm_protocal_c_afu, int i, LinkedList<arf> linkedList, String str4) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new ma();
        aVar.czo = new mb();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        aVar.czm = 650;
        aVar.czp = 0;
        aVar.czq = 0;
        this.czf = aVar.Bv();
        String ah = be.ah(str4, "");
        String ah2 = be.ah(null, "");
        ma maVar = (ma) this.czf.czk.czs;
        maVar.gkB = str;
        maVar.moE = str2;
        maVar.moG = com_tencent_mm_protocal_c_afu;
        maVar.eet = i;
        if (linkedList != null) {
            maVar.moH = linkedList;
        }
        maVar.moI = ah;
        maVar.moJ = ah2;
        maVar.moF = str3;
        v.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[]{str, str2, str3, Float.valueOf(com_tencent_mm_protocal_c_afu.mjN), Float.valueOf(com_tencent_mm_protocal_c_afu.mjM), Integer.valueOf(i), ah, ah2});
    }

    public final int getType() {
        return 650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hGc = eVar2;
        return a(eVar, this.czf, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        mb mbVar = (mb) this.czf.czl.czs;
        if (this.czf.czl.lWU != 0) {
            this.hGc.a(i2, i3, str, this);
            return;
        }
        this.hGd = mbVar.moK;
        v.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.hGd);
        this.hGc.a(i2, i3, str, this);
    }
}
