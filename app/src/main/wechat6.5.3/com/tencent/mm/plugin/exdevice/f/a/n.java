package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n extends k implements j {
    private b cif = null;
    private e cii = null;
    public int fwF;
    public int fwG;
    public int opType;

    public n(int i, int i2) {
        this.opType = i;
        this.fwF = i2;
        a aVar = new a();
        aVar.czn = new bbb();
        aVar.czo = new bbc();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.czm = 1044;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bbb com_tencent_mm_protocal_c_bbb = (bbb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bbb.bmK = this.opType;
        com_tencent_mm_protocal_c_bbb.bkU = this.fwF;
    }

    public final int getType() {
        return 1044;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.fwG = ((bbc) this.cif.czl.czs).bkU;
        }
        this.cii.a(i2, i3, str, this);
    }
}
