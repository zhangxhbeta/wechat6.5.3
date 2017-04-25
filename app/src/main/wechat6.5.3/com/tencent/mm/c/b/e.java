package com.tencent.mm.c.b;

import android.media.AudioRecord;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    boolean aTY;
    private int aUB = 12800;
    private b aUC = new b(this);
    com.tencent.mm.compatible.b.a aUD = null;
    com.tencent.mm.c.b.c.a aUE;
    private final Object aUF = new Object();
    final byte[] aUG = new byte[0];
    final Object aUH = new Object();
    private Timer aUI = null;
    private boolean aUJ = false;
    private boolean aUK = false;
    AudioRecord aUm;
    int aUx;
    boolean aUy = false;
    int mStatus = 0;

    class a extends TimerTask {
        private int aUL = (this.aUO.aUx * 2);
        private int aUM = this.aUO.aUx;
        byte[] aUN = new byte[this.aUL];
        final /* synthetic */ e aUO;

        a(e eVar) {
            this.aUO = eVar;
        }

        public final void run() {
            if (!this.aUO.aUP) {
                int pm = (int) (0.8d * ((double) this.aUO.pm()));
                if (pm < this.aUO.aUx * 8) {
                    pm = this.aUO.aUx * 8;
                }
                if (this.aUO.pn() > pm) {
                    pm = 8;
                } else {
                    pm = 1;
                }
                for (int i = 0; i < pm; i++) {
                    int g = this.aUO.g(this.aUN, this.aUM);
                    if (this.aUO.aUE != null && g == 0) {
                        this.aUO.aUE.d(this.aUN, this.aUM);
                    }
                }
            }
        }
    }

    final class b implements Runnable {
        final /* synthetic */ e aUO;

        b(e eVar) {
            this.aUO = eVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r11 = this;
            r2 = -1;
            r10 = 1;
            r9 = 2;
            r3 = 0;
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread started. frameSize:%d";
            r4 = new java.lang.Object[r10];
            r5 = r11.aUO;
            r5 = r5.aUx;
            r5 = java.lang.Integer.valueOf(r5);
            r4[r3] = r5;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r4);
            r0 = -123456789; // 0xfffffffff8a432eb float:-2.6642794E34 double:NaN;
            r1 = r11.aUO;
            r1 = r1.aUc;
            if (r0 == r1) goto L_0x0043;
        L_0x0022:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = new java.lang.StringBuilder;
            r4 = "set priority to ";
            r1.<init>(r4);
            r4 = r11.aUO;
            r4 = r4.aUc;
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = r11.aUO;
            r0 = r0.aUc;
            android.os.Process.setThreadPriority(r0);
        L_0x0043:
            r0 = r11.aUO;
            r1 = r0.aUH;
            monitor-enter(r1);
            r0 = r11.aUO;	 Catch:{ all -> 0x009f }
            r0 = r0.mStatus;	 Catch:{ all -> 0x009f }
            if (r10 == r0) goto L_0x006a;
        L_0x004e:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
            r3 = "status is not inited, now status: ";
            r2.<init>(r3);	 Catch:{ all -> 0x009f }
            r3 = r11.aUO;	 Catch:{ all -> 0x009f }
            r3 = r3.mStatus;	 Catch:{ all -> 0x009f }
            r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
            r2 = r2.toString();	 Catch:{ all -> 0x009f }
            com.tencent.mm.sdk.platformtools.v.e(r0, r2);	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
        L_0x0069:
            return;
        L_0x006a:
            r0 = r11.aUO;	 Catch:{ all -> 0x009f }
            r4 = 2;
            r0.mStatus = r4;	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            r0 = r11.aUO;
            r0 = r0.aUx;
            r0 = new byte[r0];
        L_0x0076:
            r1 = r11.aUO;
            r1 = r1.mStatus;
            if (r9 != r1) goto L_0x0095;
        L_0x007c:
            r1 = r11.aUO;
            r1 = r1.aUG;
            monitor-enter(r1);
            r4 = r11.aUO;	 Catch:{ all -> 0x00c1 }
            r4 = r4.aUP;	 Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x00a2;
        L_0x0087:
            r4 = r11.aUO;	 Catch:{ InterruptedException -> 0x0245 }
            r4 = r4.aUG;	 Catch:{ InterruptedException -> 0x0245 }
            r4.wait();	 Catch:{ InterruptedException -> 0x0245 }
        L_0x008e:
            r4 = r11.aUO;	 Catch:{ all -> 0x00c1 }
            r4 = r4.mStatus;	 Catch:{ all -> 0x00c1 }
            if (r9 == r4) goto L_0x00a2;
        L_0x0094:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
        L_0x0095:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread exited.";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            goto L_0x0069;
        L_0x009f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            throw r0;
        L_0x00a2:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            r1 = r11.aUO;
            r1 = r1.aUm;
            if (r1 != 0) goto L_0x00c4;
        L_0x00a9:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "mAudioRecord is null, so stop record.";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = r11.aUO;
            r1 = r0.aUH;
            monitor-enter(r1);
            r0 = r11.aUO;	 Catch:{ all -> 0x00be }
            r2 = 3;
            r0.mStatus = r2;	 Catch:{ all -> 0x00be }
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            goto L_0x0095;
        L_0x00be:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            throw r0;
        L_0x00c1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            throw r0;
        L_0x00c4:
            r1 = r11.aUO;
            r1 = r1.aTY;
            if (r1 == 0) goto L_0x00d0;
        L_0x00ca:
            r0 = r11.aUO;
            r0 = r0.aUx;
            r0 = new byte[r0];
        L_0x00d0:
            r1 = r11.aUO;
            r4 = r11.aUO;
            r4 = r4.aUQ;
            r4 = r4 + 1;
            r1.aUQ = r4;
            r1 = new com.tencent.mm.compatible.util.g$a;
            r1.<init>();
            r1 = r11.aUO;
            r1 = r1.aUm;
            r4 = r11.aUO;
            r4 = r4.aUx;
            r1 = r1.read(r0, r3, r4);
            r4 = r11.aUO;
            r4 = r4.mStatus;
            if (r9 != r4) goto L_0x0095;
        L_0x00f1:
            r4 = r11.aUO;
            r4 = r4.aUt;
            if (r4 == 0) goto L_0x00fe;
        L_0x00f7:
            r4 = r11.aUO;
            r4 = r4.aUt;
            r4.c(r1, r0);
        L_0x00fe:
            r4 = r11.aUO;
            r4 = r4.aUx;
            if (r4 == r1) goto L_0x011a;
        L_0x0104:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = new java.lang.StringBuilder;
            r6 = "read len ";
            r5.<init>(r6);
            r5 = r5.append(r1);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.v.i(r4, r5);
        L_0x011a:
            r4 = r11.aUO;
            r4 = r4.aUx;
            if (r1 >= r4) goto L_0x012e;
        L_0x0120:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "read too fast? sleep 10 ms";
            com.tencent.mm.sdk.platformtools.v.i(r4, r5);
            r4 = 10;
            java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0242 }
        L_0x012e:
            r4 = r11.aUO;
            r4 = r4.aUE;
            if (r4 == 0) goto L_0x0076;
        L_0x0134:
            if (r1 <= 0) goto L_0x0076;
        L_0x0136:
            r4 = r0.length;
            if (r1 <= r4) goto L_0x013a;
        L_0x0139:
            r1 = r0.length;
        L_0x013a:
            r4 = r11.aUO;
            r4 = r4.aUD;
            if (r4 == 0) goto L_0x022a;
        L_0x0140:
            r4 = r11.aUO;
            r4 = r4.aUy;
            if (r4 == 0) goto L_0x0149;
        L_0x0146:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0149:
            r4 = r11.aUO;
            r5 = r4.aUD;
            if (r1 <= 0) goto L_0x0162;
        L_0x014f:
            r4 = r5.caR;
            if (r4 == 0) goto L_0x0158;
        L_0x0153:
            r4 = r5.caS;
            r4.lock();
        L_0x0158:
            r4 = r5.caP;
            r6 = r5.caQ;
            if (r4 != r6) goto L_0x0186;
        L_0x015e:
            r4 = r5.caM;
        L_0x0160:
            if (r1 <= r4) goto L_0x01c0;
        L_0x0162:
            r1 = r2;
        L_0x0163:
            if (r1 == 0) goto L_0x0076;
        L_0x0165:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "WriteToBuffer Failed, ret:%d AudioBuffer length: %d";
            r6 = new java.lang.Object[r9];
            r1 = java.lang.Integer.valueOf(r1);
            r6[r3] = r1;
            r1 = r11.aUO;
            r1 = r1.aUD;
            r1 = r1.qO();
            r1 = java.lang.Integer.valueOf(r1);
            r6[r10] = r1;
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);
            goto L_0x0076;
        L_0x0186:
            r4 = r5.caQ;
            r4 = r4 + 1;
            r6 = r5.caM;
            r4 = r4 % r6;
            r6 = r5.caP;
            if (r4 != r6) goto L_0x0193;
        L_0x0191:
            r4 = r3;
            goto L_0x0160;
        L_0x0193:
            r4 = r5.caP;
            r6 = r5.caQ;
            if (r4 >= r6) goto L_0x01af;
        L_0x0199:
            r4 = r5.caQ;
            r6 = r5.caP;
            r4 = r4 - r6;
            r5.caN = r4;
        L_0x01a0:
            r4 = r5.caR;
            if (r4 == 0) goto L_0x01a9;
        L_0x01a4:
            r4 = r5.caS;
            r4.unlock();
        L_0x01a9:
            r4 = r5.caM;
            r6 = r5.caN;
            r4 = r4 - r6;
            goto L_0x0160;
        L_0x01af:
            r4 = r5.caP;
            r6 = r5.caQ;
            if (r4 <= r6) goto L_0x01a0;
        L_0x01b5:
            r4 = r5.caQ;
            r6 = r5.caM;
            r4 = r4 + r6;
            r6 = r5.caP;
            r4 = r4 - r6;
            r5.caN = r4;
            goto L_0x01a0;
        L_0x01c0:
            r4 = r5.caQ;
            r4 = r4 + r1;
            r6 = r5.caM;
            r4 = r4 % r6;
            r6 = r5.caP;
            if (r4 != r6) goto L_0x01cc;
        L_0x01ca:
            r1 = r2;
            goto L_0x0163;
        L_0x01cc:
            r4 = r5.caR;
            if (r4 == 0) goto L_0x01d5;
        L_0x01d0:
            r4 = r5.caS;
            r4.lock();
        L_0x01d5:
            r4 = r5.caP;
            r6 = r5.caQ;
            if (r4 >= r6) goto L_0x021a;
        L_0x01db:
            r4 = r5.caM;
            r6 = r5.caQ;
            r4 = r4 - r6;
            if (r1 <= r4) goto L_0x021a;
        L_0x01e2:
            r4 = r5.caO;
            r6 = r5.caQ;
            r7 = r5.caM;
            r8 = r5.caQ;
            r7 = r7 - r8;
            java.lang.System.arraycopy(r0, r3, r4, r6, r7);
            r4 = r5.caM;
            r6 = r5.caQ;
            r4 = r4 - r6;
            r6 = r5.caO;
            r7 = r5.caM;
            r8 = r5.caQ;
            r7 = r7 - r8;
            r7 = r1 - r7;
            java.lang.System.arraycopy(r0, r4, r6, r3, r7);
            r4 = r5.caM;
            r6 = r5.caQ;
            r4 = r4 - r6;
            r1 = r1 - r4;
            r5.caQ = r1;
            r1 = r5.caQ;
            r4 = r5.caM;
            r1 = r1 % r4;
            r5.caQ = r1;
        L_0x020e:
            r1 = r5.caR;
            if (r1 == 0) goto L_0x0217;
        L_0x0212:
            r1 = r5.caS;
            r1.unlock();
        L_0x0217:
            r1 = r3;
            goto L_0x0163;
        L_0x021a:
            r4 = r5.caO;
            r6 = r5.caQ;
            java.lang.System.arraycopy(r0, r3, r4, r6, r1);
            r4 = r5.caQ;
            r1 = r1 + r4;
            r4 = r5.caM;
            r1 = r1 % r4;
            r5.caQ = r1;
            goto L_0x020e;
        L_0x022a:
            r4 = r11.aUO;
            r4 = r4.aUE;
            if (r4 == 0) goto L_0x0076;
        L_0x0230:
            r4 = r11.aUO;
            r4 = r4.aUy;
            if (r4 == 0) goto L_0x0239;
        L_0x0236:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0239:
            r4 = r11.aUO;
            r4 = r4.aUE;
            r4.d(r0, r1);
            goto L_0x0076;
        L_0x0242:
            r4 = move-exception;
            goto L_0x012e;
        L_0x0245:
            r4 = move-exception;
            goto L_0x008e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.c.b.e.b.run():void");
        }
    }

    public e(AudioRecord audioRecord, boolean z, int i, com.tencent.mm.c.b.c.a aVar, boolean z2) {
        this.aUm = audioRecord;
        this.aTY = z;
        this.aUx = i;
        this.aUE = aVar;
        this.aUK = z2;
    }

    public final boolean pj() {
        boolean z = true;
        v.i("MicroMsg.RecordModeAsyncRead", "startRecord");
        synchronized (this.aUH) {
            this.mStatus = 1;
        }
        com.tencent.mm.sdk.i.e.b(this.aUC, "RecordModeAsyncRead_record", 10);
        if (true == this.aUK) {
            boolean z2;
            this.aUD = new com.tencent.mm.compatible.b.a();
            if (this.aUD == null) {
                v.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.aUB = this.aUx * 20;
                v.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.aUB);
                com.tencent.mm.compatible.b.a aVar = this.aUD;
                int i = this.aUB;
                if (i <= 0) {
                    z2 = true;
                } else {
                    aVar.caO = new byte[i];
                    if (aVar.caO == null) {
                        z2 = true;
                    } else {
                        aVar.caM = i;
                        if (aVar.caR) {
                            aVar.caS = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    v.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("audioBuffer init failed, error code = -1").toString());
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.aUJ || this.aUI != null) {
                    v.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.aUJ);
                } else {
                    this.aUI = new Timer();
                    if (this.aUI != null) {
                        z = false;
                    }
                }
                if (z) {
                    v.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return false;
                }
                this.aUI.scheduleAtFixedRate(new a(this), 60, 20);
                this.aUJ = true;
            } else {
                v.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        return true;
    }

    public final void oT() {
        v.i("MicroMsg.RecordModeAsyncRead", "stopRecord");
        synchronized (this.aUH) {
            this.mStatus = 3;
        }
        synchronized (this.aUG) {
            this.aUG.notify();
        }
        com.tencent.mm.sdk.i.e.H(this.aUC);
        try {
            com.tencent.mm.sdk.i.e.J(this.aUC);
        } catch (InterruptedException e) {
        }
        if (this.aUD != null) {
            if (this.aUI != null) {
                this.aUI.cancel();
                this.aUI = null;
            }
            com.tencent.mm.compatible.b.a aVar = this.aUD;
            aVar.caM = 0;
            aVar.caN = 0;
            aVar.caP = 0;
            aVar.caQ = 0;
            aVar.caO = null;
            synchronized (this.aUF) {
                this.aUD = null;
                this.aUE = null;
            }
            this.aUJ = false;
            this.aUD = null;
        }
    }

    public final int pm() {
        synchronized (this.aUF) {
            if (this.aUD != null) {
                int i = this.aUD.caM;
                return i;
            }
            return -1;
        }
    }

    public final int pn() {
        synchronized (this.aUF) {
            if (this.aUD != null) {
                int qO = this.aUD.qO();
                return qO;
            }
            return -1;
        }
    }

    public final int g(byte[] bArr, int i) {
        int i2 = -1;
        synchronized (this.aUF) {
            if (this.aUD != null) {
                com.tencent.mm.compatible.b.a aVar = this.aUD;
                if (i > 0 && i <= aVar.qO() && bArr != null && aVar.caP != aVar.caQ) {
                    if (aVar.caR) {
                        aVar.caS.lock();
                    }
                    if (aVar.caP < aVar.caQ) {
                        System.arraycopy(aVar.caO, aVar.caP, bArr, 0, i);
                        aVar.caP += i;
                    } else if (i <= aVar.caM - aVar.caP) {
                        System.arraycopy(aVar.caO, aVar.caP, bArr, 0, i);
                        aVar.caP += i;
                    } else {
                        System.arraycopy(aVar.caO, aVar.caP, bArr, 0, aVar.caM - aVar.caP);
                        System.arraycopy(aVar.caO, 0, bArr, aVar.caM - aVar.caP, i - (aVar.caM - aVar.caP));
                        aVar.caP = i - (aVar.caM - aVar.caP);
                    }
                    if (aVar.caR) {
                        aVar.caS.unlock();
                    }
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public final void an(boolean z) {
        this.aUy = z;
    }
}
