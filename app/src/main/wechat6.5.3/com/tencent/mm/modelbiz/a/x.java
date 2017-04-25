package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class x extends k implements j {
    public b cif;
    private e cii;
    Object data;

    public x(String str, String str2, gx gxVar, gx gxVar2, Object obj) {
        a aVar = new a();
        aVar.czn = new bar();
        aVar.czo = new bas();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        this.cif = aVar.Bv();
        bar com_tencent_mm_protocal_c_bar = (bar) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bar.mhJ = str;
        com_tencent_mm_protocal_c_bar.mhD = str2;
        com_tencent_mm_protocal_c_bar.mXi = gxVar;
        com_tencent_mm_protocal_c_bar.mXj = gxVar2;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1357;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        return a(eVar, this.cif, this);
    }
}
