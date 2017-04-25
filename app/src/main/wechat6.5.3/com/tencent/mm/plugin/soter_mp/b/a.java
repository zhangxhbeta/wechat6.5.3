package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class a extends b implements j {
    public final com.tencent.mm.v.b cif;
    private e cii;

    public a(h hVar) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bcm();
        aVar.czo = new bcn();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar.czm = 1185;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bcm com_tencent_mm_protocal_c_bcm = (bcm) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bcm.mYh = hVar.kdf;
        com_tencent_mm_protocal_c_bcm.mYi = hVar.bCj;
    }

    public final int getType() {
        return 1185;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void b(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final void JK() {
        v.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        v.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }
}
