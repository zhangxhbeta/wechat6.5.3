package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class q implements e {
    public String koM;
    public int koN;
    private String koq;
    private int kow;
    public a kpd;

    public interface a {
        void CL(String str);

        void baS();

        void gK(boolean z);
    }

    public q() {
        this.kpd = null;
        this.koN = -1;
        this.koM = null;
        this.koq = null;
        this.kow = 0;
        ak.vy().a(611, this);
        ak.vy().a(613, this);
    }

    public q(a aVar) {
        this();
        this.kpd = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.koN = dVar.kop;
                this.koM = dVar.koo;
                this.koq = dVar.koq;
                v.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", new Object[]{Integer.valueOf(this.koN), this.koq, Boolean.valueOf(be.kS(this.koM))});
                if (this.kpd != null) {
                    this.kpd.CL(this.koM);
                }
            }
            if (kVar.getType() != 613) {
                return;
            }
            if (((j) kVar).koz == 0) {
                v.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                if (this.kpd != null) {
                    this.kpd.gK(true);
                    return;
                }
                return;
            }
            v.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
            if (this.kpd != null) {
                this.kpd.gK(false);
            }
        } else if (this.kpd != null) {
            this.kpd.baS();
        }
    }
}
