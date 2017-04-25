package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.UUID;

public final class c extends k implements j {
    public String bdo;
    private b cif;
    e cii;
    private String clientId;
    ah cxS = new ah(new a(this) {
        final /* synthetic */ c lbW;

        {
            this.lbW = r1;
        }

        public final boolean oU() {
            long aQ = ((long) com.tencent.mm.a.e.aQ(this.lbW.filename)) - ((long) this.lbW.lbT);
            v.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[]{this.lbW.filename, Long.valueOf((long) com.tencent.mm.a.e.aQ(this.lbW.filename)), Integer.valueOf(this.lbW.lbT), Boolean.valueOf(this.lbW.diB), Long.valueOf(aQ)});
            if (aQ < 3300 && !this.lbW.diB) {
                return true;
            }
            if (this.lbW.diB && aQ <= 0) {
                return false;
            }
            if (this.lbW.a(this.lbW.czE, this.lbW.cii) == -1) {
                this.lbW.cii.a(3, -1, "doScene failed", this.lbW);
            }
            return false;
        }
    }, true);
    public boolean diB = false;
    private boolean dkd = false;
    private int dkh = 0;
    String filename = null;
    public int iwf;
    int lbT = 0;
    public String lbU;
    public boolean lbV;

    public c(String str, String str2, int i) {
        this.iwf = i;
        this.bdo = str2;
        this.filename = str;
        this.dkh = 0;
        this.clientId = UUID.randomUUID().toString();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        int aQ = com.tencent.mm.a.e.aQ(this.filename);
        if (aQ <= 0) {
            v.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[]{this.filename});
            return -1;
        }
        int i = aQ - this.lbT;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.diB) {
            v.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.diB)});
            return -1;
        } else if (this.diB) {
            this.dkd = true;
        }
        v.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[]{Integer.valueOf(aQ), Integer.valueOf(this.lbT), Boolean.valueOf(this.diB), Boolean.valueOf(this.dkd), this.filename});
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.lbT, i);
        if (c != null) {
            b.a aVar = new b.a();
            aVar.czn = new bcc();
            aVar.czo = new bcd();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.czm = 349;
            aVar.czp = 158;
            aVar.czq = 1000000158;
            this.cif = aVar.Bv();
            bcc com_tencent_mm_protocal_c_bcc = (bcc) this.cif.czk.czs;
            ak.yW();
            com_tencent_mm_protocal_c_bcc.gln = (String) com.tencent.mm.model.c.vf().get(2, "");
            com_tencent_mm_protocal_c_bcc.mfg = new are().ba(c);
            com_tencent_mm_protocal_c_bcc.mfb = this.lbT;
            com_tencent_mm_protocal_c_bcc.mXJ = this.clientId;
            com_tencent_mm_protocal_c_bcc.mfh = this.dkd ? 1 : 0;
            com_tencent_mm_protocal_c_bcc.mXK = 0;
            com_tencent_mm_protocal_c_bcc.mdF = 0;
            com_tencent_mm_protocal_c_bcc.mXL = this.dkh;
            com_tencent_mm_protocal_c_bcc.mdC = 0;
            aQ = a(eVar, this.cif, this);
            this.lbT = com_tencent_mm_protocal_c_bcc.mfg.mQu + com_tencent_mm_protocal_c_bcc.mfb;
            v.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[]{this.filename, Long.valueOf(this.diB ? 0 : 500), Integer.valueOf(aQ)});
            this.cxS.ea(r0);
            return aQ;
        } else if (this.dkd) {
            return 0;
        } else {
            v.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.diB), Boolean.valueOf(this.dkd)});
            return -1;
        }
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 20;
    }

    protected final void a(k.a aVar) {
        this.cii.a(3, 0, "securityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.filename});
        bcd com_tencent_mm_protocal_c_bcd = (bcd) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bcd.mfh), d(com_tencent_mm_protocal_c_bcd.mXM)});
            if (com_tencent_mm_protocal_c_bcd.mfh == 1) {
                this.lbV = true;
                String d = d(com_tencent_mm_protocal_c_bcd.mXM);
                if (d != null) {
                    this.lbU = d;
                }
                this.cii.a(i2, i3, str, this);
                return;
            }
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    private static String d(are com_tencent_mm_protocal_c_are) {
        if (com_tencent_mm_protocal_c_are == null || com_tencent_mm_protocal_c_are.mQw == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_are.mQw.brp();
    }

    public final int getType() {
        return 349;
    }
}
