package com.tencent.mm.plugin.location.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    public final b cif;
    private e cii;
    private byte[] gRX;
    String gRY;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.czn = new xc();
        aVar.czo = new xd();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        aVar.czm = 648;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        xc xcVar = (xc) this.cif.czk.czs;
        xcVar.fvz = str2;
        if (be.He()) {
            xcVar.mzv = 1;
        } else {
            xcVar.mzv = 0;
        }
        xcVar.mjN = f;
        xcVar.mjM = f2;
        xcVar.mzw = i;
        v.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        v.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), xcVar.fvz});
        xcVar.Height = i3;
        xcVar.Width = i2;
        this.gRY = str;
    }

    public final int getType() {
        return 648;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        try {
            this.gRX = ((xd) ((b) pVar).czl.czs).mbY.mQw.lVU;
            com.tencent.mm.a.e.b(this.gRY, this.gRX, this.gRX.length);
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
