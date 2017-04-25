package com.tencent.mm.modelstat;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private final b cif;
    private e cxf;

    public h(int i, String str, int i2) {
        a aVar = new a();
        aVar.czn = new ar();
        aVar.czo = new as();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.czm = 1295;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ar arVar = (ar) this.cif.czk.czs;
        ax axVar = new ax();
        axVar.mbu = i;
        axVar.mbv = new com.tencent.mm.ba.b(str.getBytes());
        axVar.mbw = (long) i2;
        arVar.mbh.add(axVar);
        v.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[]{Integer.valueOf(i), str});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        as asVar = (as) this.cif.czl.czs;
        v.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(asVar.ret), asVar.lcr});
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
