package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    byte[] brw;
    private final com.tencent.mm.v.b cif;
    private e cii;
    int ret;

    public b(float f, float f2, int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.czn = new aui();
        aVar.czo = new auj();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        aVar.czm = 161;
        aVar.czp = 56;
        aVar.czq = 1000000056;
        this.cif = aVar.Bv();
        aui com_tencent_mm_protocal_c_aui = (aui) this.cif.czk.czs;
        v.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        com_tencent_mm_protocal_c_aui.lZm = 0;
        com_tencent_mm_protocal_c_aui.mjM = f;
        com_tencent_mm_protocal_c_aui.mjN = f2;
        com_tencent_mm_protocal_c_aui.mrA = i;
        com_tencent_mm_protocal_c_aui.mrB = str;
        com_tencent_mm_protocal_c_aui.mrC = str2;
        com_tencent_mm_protocal_c_aui.mrD = i2;
        ak.yW();
        com_tencent_mm_protocal_c_aui.mSa = be.a((Integer) c.vf().get(4107, null), 0);
        ak.yW();
        int f3 = be.f((Integer) c.vf().get(4106, null));
        com_tencent_mm_protocal_c_aui.mSb = f3;
        int i3 = f3 + 1;
        ak.yW();
        c.vf().set(4106, Integer.valueOf(i3));
        n.a(2002, f, f2, i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 161;
    }

    public final int aNz() {
        return ((aui) this.cif.czk.czs).mrD;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        auj com_tencent_mm_protocal_c_auj = (auj) this.cif.czl.czs;
        this.ret = pVar.ze().lWU;
        if (i2 == 0 && i3 == 0) {
            this.brw = m.a(com_tencent_mm_protocal_c_auj.meT);
        }
        this.cii.a(i2, i3, str, this);
    }
}
