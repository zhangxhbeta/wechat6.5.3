package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private b cif = null;
    private e cii = null;
    public anm gHx = null;
    private ann gHy = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new anm();
        aVar.czo = new ann();
        aVar.czm = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        long currentTimeMillis = System.currentTimeMillis();
        this.gHx = (anm) this.cif.czk.czs;
        this.gHx.mqS = i;
        this.gHx.mqT = j;
        this.gHx.gom = str;
        this.gHx.mNN = currentTimeMillis;
        this.gHx.mNO = i2;
        this.gHx.mNP = str2;
        this.gHx.mNQ = j2;
        v.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2)});
    }

    public final int getType() {
        return 843;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHy = (ann) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
