package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class l extends k implements j {
    public b cif;
    private e cii;

    public l(String str, LinkedList<ahf> linkedList) {
        a aVar = new a();
        aVar.czn = new ahi();
        aVar.czo = new ahj();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        aVar.czm = 1030;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ahi com_tencent_mm_protocal_c_ahi = (ahi) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahi.mDK = str;
        com_tencent_mm_protocal_c_ahi.mGV = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1030;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        return a(eVar, this.cif, this);
    }
}
