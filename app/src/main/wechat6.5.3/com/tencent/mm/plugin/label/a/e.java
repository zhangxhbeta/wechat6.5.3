package com.tencent.mm.plugin.label.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.baw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private final b cif;
    private com.tencent.mm.v.e cii;
    private afp gPU = null;

    public e(int i, String str) {
        a aVar = new a();
        aVar.czn = new bav();
        aVar.czo = new baw();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.czm = 637;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        if (i >= 0 && !be.kS(str)) {
            this.gPU = new afp();
            this.gPU.mFs = i;
            this.gPU.mFr = str;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        bav com_tencent_mm_protocal_c_bav = (bav) this.cif.czk.czs;
        if (this.gPU != null) {
            com_tencent_mm_protocal_c_bav.mXk = this.gPU;
            return a(eVar, this.cif, this);
        }
        v.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        eVar2.a(3, -1, "[doScene]empty label pair.", this);
        return 0;
    }
}
