package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bdx;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.protocal.c.ks;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public static int khY = 1;
    public static int khZ = 2;
    public static int kia = 3;
    private b czf;
    private e hGc;
    private String khU;
    private int khV;
    private bdx khW;
    private long khX;
    public bec kib;
    public bcq kic;
    public aoo kid;
    int kie;
    private String mFileName;
    public int mState = -1;

    public a(String str, int i, String str2) {
        a(str, i, -1, -1, str2);
    }

    public a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, j, str2);
    }

    private void a(String str, int i, int i2, long j, String str2) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new kr();
        aVar.czo = new ks();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.czm = 546;
        aVar.czp = 0;
        aVar.czq = 0;
        this.mFileName = str2;
        this.czf = aVar.Bv();
        v.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.khW = d.ag(i2, str2);
        }
        if (j > 0) {
            this.khX = j;
        }
        this.khU = str;
        this.khV = i;
    }

    public final int getType() {
        return 546;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hGc = eVar2;
        kr krVar = (kr) this.czf.czk.czs;
        krVar.mne = this.khU;
        krVar.mdz = this.khV;
        krVar.mnf = this.khW;
        krVar.mcb = this.khX;
        return a(eVar, this.czf, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ks ksVar = (ks) this.czf.czl.czs;
            if (ksVar != null) {
                this.kib = ksVar.mng;
                this.mState = ksVar.eeO;
                this.kic = ksVar.mnh;
                this.kid = ksVar.mni;
                this.kie = ksVar.mnj;
            } else {
                return;
            }
        }
        v.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.khU);
        this.hGc.a(i2, i3, str, this);
    }

    public final boolean aZF() {
        return (this.kib == null || be.kS(this.kib.mZM)) ? false : true;
    }
}
