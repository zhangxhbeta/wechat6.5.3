package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    private final b cif;
    private e cii;
    public byte[] fek = null;
    private String fel;

    public l(String str, byte[] bArr) {
        a aVar = new a();
        aVar.czn = new vq();
        aVar.czo = new vr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.czm = 299;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fek = bArr;
        this.fel = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        vr vrVar = (vr) ((b) pVar).czl.czs;
        if (vrVar.mcA != null) {
            this.fek = m.a(vrVar.mcA);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 299;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        vq vqVar = (vq) this.cif.czk.czs;
        if (this.fek != null) {
            vqVar.mcz = m.H(this.fek);
        } else {
            vqVar.mcz = new are();
        }
        vqVar.mdM = this.fel;
        return a(eVar, this.cif, this);
    }

    public final vr afO() {
        return (vr) this.cif.czl.czs;
    }
}
