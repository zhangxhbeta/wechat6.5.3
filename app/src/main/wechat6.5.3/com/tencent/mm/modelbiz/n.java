package com.tencent.mm.modelbiz;

import com.tencent.mm.model.ax;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    private b cif;
    private e cii;

    public n(String str, int i, String str2) {
        a aVar = new a();
        aVar.czn = new kw();
        aVar.czo = new kx();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        this.cif = aVar.Bv();
        kw kwVar = (kw) this.cif.czk.czs;
        kwVar.mnz = i;
        kwVar.mnA = str2;
        kwVar.mhz = str;
        kwVar.mbZ = ax.zr();
        v.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s", str, Integer.valueOf(i), str2, kwVar.mbZ);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 359;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
