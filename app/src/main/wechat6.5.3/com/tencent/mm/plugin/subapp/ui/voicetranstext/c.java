package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class c extends k implements j {
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private b czf;
    private e hGc;
    private String khU;
    private bdx khW;
    public bcq kic;
    private String mFileName;

    public c(c cVar) {
        this.khU = cVar.khU;
        this.khW = cVar.khW;
        this.kic = cVar.kic;
        this.mFileName = cVar.mFileName;
        aZG();
    }

    public c(String str, bcq com_tencent_mm_protocal_c_bcq, int i, String str2) {
        Assert.assertTrue(str2 != null);
        this.khU = str;
        this.kic = com_tencent_mm_protocal_c_bcq;
        this.khW = d.ag(i, str2);
        this.mFileName = str2;
        aZG();
    }

    public final int getType() {
        return 547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hGc = eVar2;
        Object obj = (be.kS(this.mFileName) || be.kS(this.khU) || this.kic == null || this.khW == null) ? null : 1;
        if (obj == null) {
            v.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            return -1;
        }
        bcr com_tencent_mm_protocal_c_bcr = (bcr) this.czf.czk.czs;
        com_tencent_mm_protocal_c_bcr.mne = this.khU;
        com_tencent_mm_protocal_c_bcr.mnf = this.khW;
        com_tencent_mm_protocal_c_bcr.mnh = this.kic;
        String str = this.mFileName;
        int i = this.kic.mdA;
        int i2 = this.kic.mdB;
        are com_tencent_mm_protocal_c_are = new are();
        com.tencent.mm.modelvoice.b lC = q.lC(str);
        if (lC != null) {
            com_tencent_mm_protocal_c_are = m.H(lC.aU(i, i2).buf);
        }
        com_tencent_mm_protocal_c_bcr.mfg = com_tencent_mm_protocal_c_are;
        return a(eVar, this.czf, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aZH();
        if (i2 == 0 && i3 == 0) {
            this.kic = ((bcs) this.czf.czl.czs).mnh;
        } else {
            v.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.hGc.a(i2, i3, str, this);
        if (aZH()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.kic != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str2, str3, objArr);
        }
    }

    private void aZG() {
        a aVar = new a();
        aVar.czn = new bcr();
        aVar.czo = new bcs();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.czm = 547;
        aVar.czp = 0;
        aVar.czq = 0;
        this.czf = aVar.Bv();
    }

    public final boolean aZH() {
        if (this.kic == null || this.kic.mdB <= 0) {
            return true;
        }
        return false;
    }
}
