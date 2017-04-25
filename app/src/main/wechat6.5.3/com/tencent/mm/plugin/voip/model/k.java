package com.tencent.mm.plugin.voip.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class k {
    public static k kuJ;
    v2protocal kuB = new v2protocal(new ac(Looper.getMainLooper()));
    boolean kuC = false;
    public a kuD;
    int kuE = -1;
    boolean kuF = false;
    int kuG = 0;
    public int kuH;
    public int kuI;
    ah kuK = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ k kuL;

        {
            this.kuL = r1;
        }

        public final boolean oU() {
            if (!this.kuL.kuF) {
                return false;
            }
            int i;
            byte[] bArr = new byte[4];
            if (this.kuL.kuB.setAppCmd(10, bArr, 4) < 0) {
                v.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
                i = -1;
            } else {
                i = be.aA(bArr);
                v.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
            }
            if (i != -1) {
                this.kuL.kuE = i;
                this.kuL.kuH = this.kuL.kuE + this.kuL.kuH;
                k kVar = this.kuL;
                kVar.kuI++;
                kVar = this.kuL;
                if (kVar.kuE < 5) {
                    kVar.kuG = 0;
                    if (!kVar.kuC) {
                        kVar.kuC = true;
                        v.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                        if (kVar.kuD != null) {
                            kVar.kuD.atR();
                        }
                    }
                } else if (kVar.kuC) {
                    if (kVar.kuG <= 0) {
                        v.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                        kVar.kuG++;
                    } else {
                        kVar.kuC = false;
                        v.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
                        if (kVar.kuD != null) {
                            kVar.kuD.atS();
                        }
                    }
                }
            }
            return true;
        }
    }, true);

    public interface a {
        void atR();

        void atS();
    }

    public static k bct() {
        if (kuJ == null) {
            kuJ = new k();
        }
        return kuJ;
    }

    private k() {
    }

    public final void bcu() {
        v.d("MicroMsg.VoipNetStatusChecker", "startNetStatusCheck");
        this.kuE = -1;
        this.kuF = true;
        this.kuI = 0;
        this.kuH = 0;
        ad.g(new Runnable(this) {
            final /* synthetic */ k kuL;

            {
                this.kuL = r1;
            }

            public final void run() {
                this.kuL.kuK.ea(2000);
            }
        }, 3000);
    }

    public final void bcv() {
        v.d("MicroMsg.VoipNetStatusChecker", "stopNetStatusCheck");
        this.kuE = -1;
        this.kuC = false;
        this.kuF = false;
        this.kuI = 0;
        this.kuH = 0;
        ad.o(new Runnable(this) {
            final /* synthetic */ k kuL;

            {
                this.kuL = r1;
            }

            public final void run() {
                this.kuL.kuK.QI();
            }
        });
    }
}
