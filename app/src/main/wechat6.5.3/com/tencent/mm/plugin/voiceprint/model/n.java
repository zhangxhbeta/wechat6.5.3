package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class n implements e {
    public String dRA = null;
    public String koC = null;
    private String koM = null;
    public int koN = -1;
    public String koP = null;
    public a koQ = null;

    public interface a {
        void CL(String str);

        void baS();

        void baU();

        void gJ(boolean z);
    }

    public n() {
        ak.vy().a(618, this);
        ak.vy().a(616, this);
        ak.vy().a(617, this);
    }

    public final void baT() {
        ak.vy().a(new g(this.koP), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 618) {
                this.koP = ((e) kVar).cZU;
                v.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", new Object[]{Boolean.valueOf(be.kS(this.koP))});
                if (!be.kS(this.koP)) {
                    baT();
                }
            }
            if (kVar.getType() == 616) {
                g gVar = (g) kVar;
                this.koN = gVar.kop;
                this.koM = gVar.koo;
                v.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.koN), Boolean.valueOf(be.kS(this.koM))});
                if (this.koQ != null) {
                    this.koQ.CL(this.koM);
                }
            }
            if (kVar.getType() == 617) {
                h hVar = (h) kVar;
                if (hVar.koz == 0) {
                    v.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.koC = hVar.koC;
                    if (this.koQ != null) {
                        this.koQ.gJ(true);
                        return;
                    }
                    return;
                }
                v.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.koQ != null) {
                    this.koQ.gJ(false);
                }
            }
        } else if (i2 == -34 && kVar.getType() == 617) {
            v.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.koQ != null) {
                this.koQ.baU();
            }
        } else if (this.koQ != null) {
            this.koQ.baS();
        }
    }
}
