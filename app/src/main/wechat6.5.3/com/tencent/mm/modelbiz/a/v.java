package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class v extends k implements j {
    public b cif;
    private e cii;

    public v(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new aou();
        aVar.czo = new aov();
        aVar.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        this.cif = aVar.Bv();
        aou com_tencent_mm_protocal_c_aou = (aou) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aou.mhJ = str;
        com_tencent_mm_protocal_c_aou.mhD = str2;
        com_tencent_mm_protocal_c_aou.time_stamp = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        return a(eVar, this.cif, this);
    }
}
