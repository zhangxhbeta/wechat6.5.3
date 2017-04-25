package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private b cif = null;
    private e cii = null;
    public anq gHI = null;
    private anr gHJ = null;

    public f(int i, long j, long j2) {
        a aVar = new a();
        aVar.czn = new anq();
        aVar.czo = new anr();
        aVar.czm = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        long currentTimeMillis = System.currentTimeMillis();
        this.gHI = (anq) this.cif.czk.czs;
        this.gHI.mqS = i;
        this.gHI.mqT = j;
        this.gHI.mNQ = j2;
        this.gHI.mNN = currentTimeMillis;
        v.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 824;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHJ = (anr) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
