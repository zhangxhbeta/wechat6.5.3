package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class k extends com.tencent.mm.v.k implements j {
    private b cif = null;
    private e cii = null;
    public anz gHS = null;
    private aoa gHT = null;

    public k(int i, long j, long j2, int i2) {
        a aVar = new a();
        aVar.czn = new anz();
        aVar.czo = new aoa();
        aVar.czm = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        long currentTimeMillis = System.currentTimeMillis();
        this.gHS = (anz) this.cif.czk.czs;
        this.gHS.gon = com.tencent.mm.model.k.xF();
        this.gHS.mqS = i;
        this.gHS.mqT = j;
        this.gHS.mNQ = j2;
        this.gHS.eeO = i2;
        this.gHS.mNN = currentTimeMillis;
        v.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 723;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHT = (aoa) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
