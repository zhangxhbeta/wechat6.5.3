package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.c.b.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.qafpapi.QAFPNative;

public final class a implements e {
    c aTF;
    private com.tencent.mm.c.b.c.a aUE = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ a iPZ;

        {
            this.iPZ = r1;
        }

        public final void d(byte[] bArr, int i) {
            int QAFPProcessTV;
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            synchronized (this.iPZ.iPQ) {
                if (this.iPZ.iPN == 408) {
                    v.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                    QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
                }
            }
            long Ni = be.Ni() - this.iPZ.iPX;
            v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[]{Integer.valueOf(this.iPZ.iPU), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(Ni), Long.valueOf(aVar.sn())});
            if (Ni > ((long) ((this.iPZ.iPY * 3000) + 4000))) {
                Object obj = new byte[10240];
                com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
                if (this.iPZ.iPN == 408) {
                    v.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(obj);
                } else {
                    QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(obj);
                }
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[]{Integer.valueOf(this.iPZ.iPU), Integer.valueOf(QAFPProcessTV), Long.valueOf(aVar2.sn())});
                if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                    v.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[]{Integer.valueOf(this.iPZ.iPU), Integer.valueOf(QAFPProcessTV)});
                    this.iPZ.reset();
                    return;
                }
                synchronized (this.iPZ.iPJ) {
                    System.arraycopy(obj, 0, this.iPZ.iPJ, 0, QAFPProcessTV);
                    this.iPZ.iPK = QAFPProcessTV;
                    this.iPZ.iPT = this.iPZ.iPY >= 3;
                    this.iPZ.iPL = (int) (Ni / 1000);
                }
                this.iPZ.Ge();
                a aVar3 = this.iPZ;
                aVar3.iPY++;
            }
            if (this.iPZ.iPT) {
                v.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[]{Integer.valueOf(this.iPZ.iPU), Long.valueOf(Ni)});
                this.iPZ.reset();
            }
        }

        public final void as(int i, int i2) {
        }
    };
    byte[] iPJ = new byte[10240];
    int iPK = 0;
    int iPL = 0;
    long iPM = 0;
    int iPN = 0;
    boolean iPO = false;
    e iPP = null;
    Object iPQ = new Object();
    a iPR = null;
    boolean iPS = false;
    boolean iPT = false;
    int iPU = 0;
    int iPV;
    private boolean iPW = false;
    long iPX;
    int iPY;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a iPZ;
        final /* synthetic */ boolean iQa = false;
        final /* synthetic */ boolean iQb;

        AnonymousClass2(a aVar, boolean z, boolean z2) {
            this.iPZ = aVar;
            this.iQb = z2;
        }

        public final void run() {
            if (this.iQa) {
                this.iPZ.iPR.a(null, -1, this.iQb);
            } else if (!this.iPZ.iPO) {
                v.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
            } else if (this.iPZ.aTF != null) {
                v.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
            } else if (this.iPZ.iPP != null) {
                a aVar = this.iPZ.iPR;
                aqx aOr = this.iPZ.iPP.aOr();
                e eVar = this.iPZ.iPP;
                long Ni = be.Ni();
                if (eVar.iQf > 0 && eVar.iQf < Ni) {
                    Ni = eVar.iQf;
                }
                aVar.a(aOr, Ni, this.iQb);
            } else {
                this.iPZ.iPR.a(null, -1, this.iQb);
            }
        }
    }

    public interface a {
        void a(aqx com_tencent_mm_protocal_c_aqx, long j, boolean z);
    }

    public final boolean aOo() {
        boolean z = false;
        synchronized (this.iPQ) {
            if (this.iPW) {
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
            } else {
                int QAFPInit = QAFPNative.QAFPInit();
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[]{Integer.valueOf(QAFPInit)});
                if (QAFPInit >= 0) {
                    this.iPW = true;
                }
                if (QAFPInit >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean aOp() {
        boolean z = false;
        synchronized (this.iPQ) {
            if (this.iPW) {
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPRelease())});
                if (QAFPNative.QAFPRelease() >= 0) {
                    z = true;
                }
            } else {
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
            }
        }
        return z;
    }

    public final boolean pb() {
        v.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[]{Integer.valueOf(this.iPU)});
        ak.vy().b(367, this);
        ak.vy().b(408, this);
        synchronized (this.iPJ) {
            this.iPK = 0;
        }
        if (this.aTF != null) {
            this.aTF.pb();
            this.aTF = null;
        }
        return true;
    }

    public final boolean a(int i, a aVar) {
        pb();
        synchronized (this.iPQ) {
            this.iPV = QAFPNative.QAFPGetVersion();
        }
        aOo();
        this.iPN = i;
        this.iPR = aVar;
        this.iPT = false;
        this.iPS = false;
        this.iPO = false;
        ak.vy().a(367, this);
        ak.vy().a(408, this);
        this.iPU = (int) be.Ni();
        v.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[]{Integer.valueOf(this.iPU)});
        this.aTF = new c(8000, 4);
        this.aTF.aUc = -19;
        this.aTF.aUn = this.aUE;
        if (this.aTF.pj()) {
            synchronized (this.iPQ) {
                v.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPReset())});
                if (QAFPNative.QAFPReset() < 0) {
                    v.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[]{Integer.valueOf(r3), Integer.valueOf(this.iPU)});
                    reset();
                    return false;
                }
                this.iPM = be.Ni();
                this.iPX = be.Ni();
                this.iPY = 0;
                return true;
            }
        }
        v.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        return false;
    }

    final void reset() {
        v.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[]{Integer.valueOf(this.iPU)});
        if (this.aTF != null) {
            this.aTF.pb();
            this.aTF = null;
        }
        fr(false);
    }

    private void fr(boolean z) {
        v.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[]{Boolean.valueOf(false)});
        ad.o(new AnonymousClass2(this, false, z));
    }

    final void Ge() {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a iPZ;

            {
                this.iPZ = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r6 = 1;
                r9 = 0;
                r0 = r10.iPZ;
                r0 = r0.iPS;
                if (r0 == 0) goto L_0x001e;
            L_0x0008:
                r0 = "MicroMsg.MusicFingerPrintRecorder";
                r1 = "tryStartNetscene clientid: %d but netscene is running.";
                r2 = new java.lang.Object[r6];
                r3 = r10.iPZ;
                r3 = r3.iPU;
                r3 = java.lang.Integer.valueOf(r3);
                r2[r9] = r3;
                com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
            L_0x001d:
                return;
            L_0x001e:
                r0 = r10.iPZ;
                r1 = r0.iPJ;
                monitor-enter(r1);
                r0 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r0 = r0.iPK;	 Catch:{ all -> 0x002b }
                if (r0 > 0) goto L_0x002e;
            L_0x0029:
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                goto L_0x001d;
            L_0x002b:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                throw r0;
            L_0x002e:
                r0 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r0 = r0.iPK;	 Catch:{ all -> 0x002b }
                r2 = new byte[r0];	 Catch:{ all -> 0x002b }
                r0 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r0 = r0.iPJ;	 Catch:{ all -> 0x002b }
                r3 = 0;
                r4 = 0;
                r5 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r5 = r5.iPK;	 Catch:{ all -> 0x002b }
                java.lang.System.arraycopy(r0, r3, r2, r4, r5);	 Catch:{ all -> 0x002b }
                r0 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r3 = 0;
                r0.iPK = r3;	 Catch:{ all -> 0x002b }
                r0 = r10.iPZ;	 Catch:{ all -> 0x002b }
                r4 = r0.iPM;	 Catch:{ all -> 0x002b }
                monitor-exit(r1);	 Catch:{ all -> 0x002b }
                r0 = r10.iPZ;
                r0.iPS = r6;
                r0 = r10.iPZ;
                r0 = r0.iPN;
                r1 = r10.iPZ;
                r3 = r1.iPL;
                r1 = r10.iPZ;
                r6 = r1.iPU;
                r1 = r10.iPZ;
                r7 = r1.iPT;
                r1 = r10.iPZ;
                r8 = r1.iPV;
                r1 = 367; // 0x16f float:5.14E-43 double:1.813E-321;
                if (r0 != r1) goto L_0x0074;
            L_0x0067:
                r1 = new com.tencent.mm.plugin.shake.d.a.f;
                r1.<init>(r2, r3, r4, r6, r7, r8);
            L_0x006c:
                r0 = com.tencent.mm.model.ak.vy();
                r0.a(r1, r9);
                goto L_0x001d;
            L_0x0074:
                r1 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
                if (r0 != r1) goto L_0x007e;
            L_0x0078:
                r1 = new com.tencent.mm.plugin.shake.d.a.g;
                r1.<init>(r2, r3, r4, r6, r7, r8);
                goto L_0x006c;
            L_0x007e:
                r1 = 0;
                goto L_0x006c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.shake.d.a.a.3.run():void");
            }

            public final String toString() {
                return super.toString() + "|tryStartNetscene";
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 367 || kVar.getType() == 408) {
            v.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.iPS = false;
            if (((e) kVar).aOq()) {
                v.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[]{Integer.valueOf(this.iPU)});
                pb();
                this.iPP = (e) kVar;
                this.iPO = true;
                fr(false);
            } else if (this.iPK == 0 && this.iPT) {
                v.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[]{Integer.valueOf(this.iPU)});
                this.iPP = null;
                this.iPO = true;
                if (i == 0 && i2 == 0) {
                    fr(false);
                } else {
                    fr(true);
                }
                ak.vy().b(367, this);
                ak.vy().b(408, this);
            } else {
                v.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[]{Integer.valueOf(this.iPU)});
                Ge();
            }
        }
    }
}
