package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class b extends k implements j {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.v.b czf;
    private e hGc;
    private String khU;
    public bec kib;
    public int kif = -1;

    public b(String str) {
        Assert.assertTrue(!be.kS(str));
        this.khU = str;
        a aVar = new a();
        aVar.czn = new aal();
        aVar.czo = new aam();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.czm = 548;
        aVar.czp = 0;
        aVar.czq = 0;
        this.czf = aVar.Bv();
    }

    public final int getType() {
        return 548;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hGc = eVar2;
        ((aal) this.czf.czk.czs).mne = this.khU;
        return a(eVar, this.czf, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            aam com_tencent_mm_protocal_c_aam = (aam) this.czf.czl.czs;
            if (com_tencent_mm_protocal_c_aam.mni != null) {
                this.kif = com_tencent_mm_protocal_c_aam.mni.mOA;
            }
            this.kib = com_tencent_mm_protocal_c_aam.mng;
        } else {
            v.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.hGc.a(i2, i3, str, this);
    }

    public final boolean isComplete() {
        return this.kib != null && this.kib.mfh == 1;
    }

    public final boolean aZF() {
        return (this.kib == null || be.kS(this.kib.mZM)) ? false : true;
    }
}
