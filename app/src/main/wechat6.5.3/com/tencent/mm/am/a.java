package com.tencent.mm.am;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.ym;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public String cUG;
    private final b cif;
    private e cii;

    public a() {
        String xF = com.tencent.mm.model.k.xF();
        ak.yW();
        this(xF, be.f((Integer) c.vf().get(66561, null)));
    }

    public a(String str, int i) {
        this.cii = null;
        this.cUG = null;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new yl();
        aVar.czo = new ym();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.czm = 168;
        aVar.czp = 67;
        aVar.czq = 1000000067;
        this.cif = aVar.Bv();
        yl ylVar = (yl) this.cif.czk.czs;
        ylVar.moM = m.lY(str);
        ylVar.mAp = i;
        v.d("MicroMsg.NetSceneGetQRCode", "req username:" + str + " style" + i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 168;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            ym ymVar = (ym) this.cif.czl.czs;
            String a = m.a(((yl) this.cif.czk.czs).moM);
            byte[] a2 = m.a(ymVar.mAq, new byte[0]);
            int i4 = ymVar.mAp;
            v.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd QRCODE:" + a2.length + " style:" + i4);
            if (a.endsWith("@chatroom")) {
                b.k(a, a2);
                this.cUG = ymVar.mAr;
            } else {
                ak.yW();
                c.vf().set(66561, Integer.valueOf(i4));
                b.k(a, a2);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
