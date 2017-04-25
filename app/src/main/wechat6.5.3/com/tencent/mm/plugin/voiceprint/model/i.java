package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private final b cif;
    private e cii;
    public int koF;
    public int mStatus;

    public i(int i) {
        a aVar = new a();
        aVar.czn = new ayu();
        aVar.czo = new ayv();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.czm = 615;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((ayu) this.cif.czk.czs).bdn = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 615;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        ayv com_tencent_mm_protocal_c_ayv = (ayv) ((b) pVar).czl.czs;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = com_tencent_mm_protocal_c_ayv.mNm;
            this.koF = com_tencent_mm_protocal_c_ayv.mVX;
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
