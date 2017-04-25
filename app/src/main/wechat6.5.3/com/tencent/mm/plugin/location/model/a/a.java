package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private Runnable cZn;
    public final b cif;
    private e cii;

    public a(String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new oz();
        aVar.czo = new pa();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.czm = 491;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((oz) this.cif.czk.czs).mrc = str;
        v.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + str);
    }

    public final int getType() {
        return 491;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
        if (this.cZn != null) {
            this.cZn.run();
        }
    }
}
