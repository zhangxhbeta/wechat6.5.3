package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.mm.e.a.qd;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;

public final class o {
    public k koR;
    public ah koS;
    int koT;
    int koU;

    public o() {
        this.koR = null;
        this.koS = null;
        this.koT = 0;
        this.koU = 0;
        this.koR = new k();
        this.koS = new ah(Looper.getMainLooper(), new a(this) {
            final /* synthetic */ o koV;

            {
                this.koV = r1;
            }

            public final boolean oU() {
                o oVar = this.koV;
                oVar.koT += 100;
                oVar = this.koV;
                oVar.koU = ((this.koV.koR.getMaxAmplitude() * 100) / 100) + oVar.koU;
                if (this.koV.koT < 3000) {
                    return true;
                }
                boolean z;
                o oVar2 = this.koV;
                v.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                oVar2.koR.pb();
                oVar2.koS.QI();
                oVar2.koU /= 30;
                if (oVar2.koU >= 30) {
                    z = true;
                } else {
                    z = false;
                }
                v.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[]{Integer.valueOf(oVar2.koU), Boolean.valueOf(z)});
                qd qdVar = new qd();
                qdVar.brr.brs = z;
                com.tencent.mm.sdk.c.a.nhr.z(qdVar);
                return false;
            }
        }, true);
    }

    public final void reset() {
        this.koR.pb();
        v.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        this.koS.QI();
        this.koT = 0;
        this.koU = 0;
    }
}
