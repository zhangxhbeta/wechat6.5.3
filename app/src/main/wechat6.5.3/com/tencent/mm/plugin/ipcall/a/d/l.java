package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    private b cif = null;
    private e cii;
    public aob gHU = null;
    public aoc gHV = null;

    public l(int i, long j, int i2, long j2, boolean z) {
        a aVar = new a();
        aVar.czn = new aob();
        aVar.czo = new aoc();
        aVar.czm = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        long currentTimeMillis = System.currentTimeMillis();
        this.gHU = (aob) this.cif.czk.czs;
        this.gHU.mOk = com.tencent.mm.model.k.xF();
        this.gHU.mqS = i;
        this.gHU.mqT = j;
        this.gHU.mNN = currentTimeMillis;
        this.gHU.mOl = i2;
        this.gHU.mNQ = j2;
        if (z) {
            this.gHU.mOm = 1;
        } else {
            this.gHU.mOm = 0;
        }
        v.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.gHU.mOm), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 819;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHV = (aoc) ((b) pVar).czl.czs;
        this.cii.a(i2, i3, str, this);
    }
}
