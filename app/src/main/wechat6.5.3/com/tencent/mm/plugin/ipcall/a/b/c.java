package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public boolean bhY;
    public boolean eJx;
    public com.tencent.mm.c.b.c gGC;
    public final Object gGD;
    int gGE;
    boolean gGF;
    int gGG;
    boolean gGH;
    com.tencent.mm.c.b.c.a gGI;

    private class a implements Runnable {
        final /* synthetic */ c gGJ;
        private com.tencent.mm.c.b.c gGK = null;

        public a(c cVar, com.tencent.mm.c.b.c cVar2) {
            this.gGJ = cVar;
            this.gGK = cVar2;
        }

        public final void run() {
            v.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.gGK != null) {
                this.gGK.pb();
                this.gGK = null;
                c cVar = this.gGJ;
                cVar.gGE = 92;
                cVar.gGF = true;
                cVar.gGG = 0;
            }
        }
    }

    public c() {
        this.gGC = null;
        this.gGD = new Object();
        this.bhY = false;
        this.eJx = false;
        this.gGE = 92;
        this.gGF = true;
        this.gGG = 0;
        this.gGH = true;
        this.gGI = new com.tencent.mm.c.b.c.a(this) {
            final /* synthetic */ c gGJ;

            {
                this.gGJ = r1;
            }

            public final void d(byte[] bArr, int i) {
                int i2 = 0;
                synchronized (this.gGJ.gGD) {
                    int bbr;
                    c cVar = this.gGJ;
                    if (cVar.gGE <= 10) {
                        cVar.gGE = 92;
                    }
                    a aVar = i.aup().gGs;
                    if (aVar.gGm != null) {
                        bbr = aVar.gGm.bbr();
                    } else {
                        bbr = 0;
                    }
                    cVar.gGE = ((bbr + 24) + (cVar.gGE * 3)) / 4;
                    if (cVar.gGF) {
                        v.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                        aVar = i.aup().gGs;
                        if (aVar.gGm != null) {
                            i2 = aVar.gGm.bbo();
                        }
                        cVar.gGG = i2;
                        if (cVar.gGG >= cVar.gGE) {
                            cVar.gGG -= cVar.gGE;
                        }
                        cVar.gGE = cVar.gGG;
                        cVar.gGF = false;
                    } else {
                        cVar.gGE = 0;
                    }
                    if (i.auq().gEK == 5) {
                        if (this.gGJ.gGH) {
                            v.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                            this.gGJ.gGH = false;
                        }
                        i.aun().gGO.recordCallback(bArr, i, this.gGJ.gGE);
                    }
                }
            }

            public final void as(int i, int i2) {
            }
        };
        this.bhY = false;
    }

    public final void dJ(boolean z) {
        v.i("MicroMsg.IPCallRecorder", "setMute: %b", new Object[]{Boolean.valueOf(z)});
        if (this.bhY && this.gGC != null) {
            this.gGC.an(z);
        }
        this.eJx = z;
    }
}
