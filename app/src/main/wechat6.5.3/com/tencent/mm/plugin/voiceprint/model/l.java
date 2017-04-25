package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l implements e {
    public int koL;
    private String koM;
    public int koN;
    public a koO;
    public int kow;

    public interface a {
        void CJ(String str);

        void CK(String str);

        void baS();

        void o(boolean z, int i);
    }

    public l() {
        this.koL = 71;
        this.koM = null;
        this.koN = 0;
        this.kow = 0;
        this.koO = null;
        ak.vy().a(611, this);
        ak.vy().a(612, this);
    }

    public l(a aVar) {
        this();
        this.koO = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.koN = dVar.kop;
                this.koM = dVar.koo;
                v.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", new Object[]{Integer.valueOf(this.koN), Boolean.valueOf(be.kS(this.koM))});
                if (this.koO != null) {
                    if (this.koL == 71) {
                        this.koO.CJ(this.koM);
                    } else if (this.koL == 72) {
                        this.koO.CK(this.koM);
                    }
                }
            }
            if (kVar.getType() == 612) {
                boolean z;
                f fVar = (f) kVar;
                if ((fVar.koy == 72 && fVar.koz == 0) || fVar.koy == 71) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    v.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", new Object[]{Integer.valueOf(fVar.koy)});
                    this.kow = fVar.kow;
                    if (this.koO != null) {
                        this.koO.o(true, fVar.koy);
                    }
                } else {
                    v.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", new Object[]{Integer.valueOf(fVar.koy)});
                    if (this.koO != null) {
                        this.koO.o(false, fVar.koy);
                    }
                }
                if (z && fVar.koy == 71 && this.koO != null) {
                    this.koO.CK(this.koM);
                }
            }
        } else if (this.koO != null) {
            this.koO.baS();
        }
    }
}
