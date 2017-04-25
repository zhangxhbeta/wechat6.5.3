package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class t extends k implements j {
    public final b cQA;
    private e cii;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new bde();
        aVar.czo = new bdf();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        aVar.czm = 1702;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        bde com_tencent_mm_protocal_c_bde = (bde) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_bde.glb = str;
        com_tencent_mm_protocal_c_bde.bmJ = str2;
        com_tencent_mm_protocal_c_bde.bax = str3;
    }

    public final int getType() {
        return 1702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            v.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.cii.a(i2, i3, str, this);
    }
}
