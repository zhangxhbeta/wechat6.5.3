package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private b cif = null;
    private e cii = null;
    public anv gHM = null;
    public anw gHN = null;

    public h(int i, long j, long j2) {
        a aVar = new a();
        aVar.czn = new anv();
        aVar.czo = new anw();
        aVar.czm = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHM = (anv) this.cif.czk.czs;
        this.gHM.mqS = i;
        this.gHM.mqT = j;
        this.gHM.mNQ = j2;
    }

    public final int getType() {
        return 726;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHN = (anw) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
