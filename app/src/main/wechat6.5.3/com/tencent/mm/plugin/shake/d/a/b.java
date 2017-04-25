package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public com.tencent.mm.v.b cif;
    private e cii;
    private String iQc;
    private int scene;

    public b(String str, int i) {
        this.iQc = str;
        this.scene = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new zm();
        aVar.czo = new zn();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.czm = 552;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        zm zmVar = (zm) this.cif.czk.czs;
        zmVar.mBe = this.iQc;
        zmVar.maG = this.scene;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        zm zmVar = (zm) ((com.tencent.mm.v.b) pVar).czk.czs;
        if (zmVar.maG >= 0 && zmVar.mBe != null && zmVar.mBe.length() > 0) {
            return com.tencent.mm.v.k.b.czU;
        }
        v.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(zmVar.maG)});
        return com.tencent.mm.v.k.b.czV;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 552;
    }
}
