package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ad extends k implements j {
    public final b cif;
    private e cii;

    public ad(String str, String str2, are com_tencent_mm_protocal_c_are) {
        a aVar = new a();
        aVar.czn = new atz();
        aVar.czo = new aua();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        this.cif = aVar.Bv();
        atz com_tencent_mm_protocal_c_atz = (atz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_atz.fvq = be.KE(str);
        com_tencent_mm_protocal_c_atz.mpB = str2;
        com_tencent_mm_protocal_c_atz.mdV = com_tencent_mm_protocal_c_are;
        v.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, authkey:%s", str, str2, be.bk(m.a(com_tencent_mm_protocal_c_are)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }
}
