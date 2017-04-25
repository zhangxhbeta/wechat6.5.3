package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private b cif;
    private com.tencent.mm.v.e cii;

    public e(String str, String str2) {
        v.i("MicroMsg.NetSceneUploadSoterASK", "Netsceneuploadsoter ask constructor");
        a aVar = new a();
        aVar.czn = new bbf();
        aVar.czo = new bbg();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar.czm = 619;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bbf com_tencent_mm_protocal_c_bbf = (bbf) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bbf.maG = 619;
        com_tencent_mm_protocal_c_bbf.mXm = str;
        com_tencent_mm_protocal_c_bbf.mXn = str2;
    }

    public final int getType() {
        return 619;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask rsa successfully");
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
