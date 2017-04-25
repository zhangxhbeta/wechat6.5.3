package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private final b cif;
    private e cii;
    String koo = "";
    int kop = 0;
    String koq = "";

    public d(int i, String str) {
        a aVar = new a();
        aVar.czn = new aah();
        aVar.czo = new aai();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.czm = 611;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aah com_tencent_mm_protocal_c_aah = (aah) this.cif.czk.czs;
        v.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(i), str});
        com_tencent_mm_protocal_c_aah.mBP = i;
        com_tencent_mm_protocal_c_aah.mBQ = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aai com_tencent_mm_protocal_c_aai = (aai) ((b) pVar).czl.czs;
        if (i2 == 0 || i3 == 0) {
            if (com_tencent_mm_protocal_c_aai.mBR != null) {
                this.koo = new String(com_tencent_mm_protocal_c_aai.mBR.mQb.mQw.lVU);
                this.kop = com_tencent_mm_protocal_c_aai.mBR.mPA;
                v.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", new Object[]{Integer.valueOf(this.kop), this.koo});
            } else {
                v.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
