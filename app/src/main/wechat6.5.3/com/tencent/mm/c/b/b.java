package com.tencent.mm.c.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.aq.c;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;

public final class b {
    private static Object aTA = new Object();
    private int aTB = 8000;
    private int aTC = 16000;
    private boolean aTD = false;
    public MediaRecorder aTE;
    public c aTF = null;
    public com.tencent.mm.compatible.b.b.a aTG;
    public b aTH;
    private com.tencent.mm.compatible.util.g.a aTI = new com.tencent.mm.compatible.util.g.a();
    private com.tencent.mm.c.b.c.a aTJ = new com.tencent.mm.c.b.c.a(this) {
        final /* synthetic */ b aTK;

        {
            this.aTK = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2 = -1;
            if (this.aTK.aTH == b.STOPPED) {
                v.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                return;
            }
            long ay = be.ay(this.aTK.aTy);
            if (this.aTK.aTx <= 0 || ay <= this.aTK.aTx) {
                v.d("MicroMsg.MMAudioRecorder", "read :" + i + " time: " + this.aTK.aTI.sn() + " dataReadedCnt: " + this.aTK.aTz);
                if (i >= 0) {
                    com.tencent.mm.aq.b h;
                    b.a(this.aTK, i);
                    if (this.aTK.aTv == null && ((this.aTK.aTG == com.tencent.mm.compatible.b.b.a.PCM || this.aTK.aTG == com.tencent.mm.compatible.b.b.a.SILK) && this.aTK.aTw != null && this.aTK.aTD)) {
                        this.aTK.aTv = new com.tencent.mm.aq.b();
                        h = this.aTK.aTv;
                        int l = this.aTK.aTB;
                        v.i("MicroMsg.SpeexEncoderWorker", "init ");
                        h.daj.clear();
                        com.tencent.mm.aq.c.b bVar = new com.tencent.mm.aq.c.b();
                        bVar.cXU = c.getPrefix();
                        bVar.dad = l;
                        bVar.dae = 1;
                        bVar.daf = 16;
                        h.mFileName = String.format("%s%d_%d_%d_%d", new Object[]{bVar.cXU, Integer.valueOf(bVar.dad), Integer.valueOf(bVar.dae), Integer.valueOf(bVar.daf), Long.valueOf(System.currentTimeMillis())});
                    }
                    if (this.aTK.aTv != null) {
                        h = this.aTK.aTv;
                        v.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + h.daj.size());
                        if (bArr != null && bArr.length > 0) {
                            h.daj.add(new com.tencent.mm.c.b.g.a(bArr, bArr.length));
                        }
                    }
                    if (this.aTK.aTG == com.tencent.mm.compatible.b.b.a.SILK) {
                        if (this.aTK.aTt == null) {
                            this.aTK.aTt = new com.tencent.mm.c.c.c(this.aTK.aTB, this.aTK.aTC);
                            this.aTK.aTt.bA(this.aTK.aTr);
                        }
                        f(bArr, i);
                        com.tencent.mm.c.c.c m = this.aTK.aTt;
                        String str = "MicroMsg.SilkWriter";
                        String str2 = "pushBuf queueLen:%d bufLen:%d len:%d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(m.aVO == null ? -1 : m.aVO.size());
                        if (bArr != null) {
                            i2 = bArr.length;
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = Integer.valueOf(i);
                        v.d(str, str2, objArr);
                        if (i <= 0) {
                            return;
                        }
                        if (m.aVP) {
                            v.e("MicroMsg.SilkWriter", "already stop");
                            return;
                        }
                        if (m.aVV == null) {
                            m.aVV = new a();
                            e.a(m.aVV, "SilkWriter_run");
                        }
                        m.aVO.add(new com.tencent.mm.c.b.g.a(bArr, i));
                        return;
                    }
                    if (this.aTK.aTB == 16000) {
                        bArr = AnonymousClass2.e(bArr, i);
                        i = bArr.length;
                    }
                    f(bArr, i);
                    return;
                } else if (this.aTK.aTH == b.STOPPED) {
                    v.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                    return;
                } else {
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 aTL;

                        {
                            this.aTL = r1;
                        }

                        public final void run() {
                            this.aTL.aTK.ph();
                            this.aTL.aTK.aTu.onError();
                        }
                    });
                    return;
                }
            }
            v.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:" + ay);
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 aTL;

                {
                    this.aTL = r1;
                }

                public final void run() {
                    this.aTL.aTK.ph();
                    this.aTL.aTK.aTu.onError();
                }
            });
        }

        private static byte[] e(byte[] bArr, int i) {
            int i2 = i % 4;
            if (i2 != 0) {
                i -= i2;
            }
            if (i <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2 += 2) {
                bArr2[i2] = bArr[i2 * 2];
                bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
            }
            return bArr2;
        }

        private void f(byte[] bArr, int i) {
            for (int i2 = 0; i2 < i / 2; i2++) {
                short s = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | (bArr[(i2 * 2) + 1] << 8));
                if (s > this.aTK.aTq) {
                    this.aTK.aTq = s;
                }
            }
        }

        public final void as(int i, int i2) {
        }
    };
    private int aTq = 0;
    private String aTr = null;
    private int aTs;
    private com.tencent.mm.c.c.c aTt = null;
    private a aTu;
    private com.tencent.mm.aq.b aTv = null;
    private com.tencent.mm.aq.c.a aTw = null;
    private long aTx = 0;
    private long aTy = 0;
    private int aTz = 0;

    public interface a {
        void onError();
    }

    public enum b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    static /* synthetic */ int a(b bVar, int i) {
        int i2 = bVar.aTz + i;
        bVar.aTz = i2;
        return i2;
    }

    public b(com.tencent.mm.compatible.b.b.a aVar) {
        v.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + aVar);
        this.aTG = aVar;
        if (!com.tencent.mm.c.b.g.b.po()) {
            v.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.aTG = com.tencent.mm.compatible.b.b.a.AMR;
        }
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            this.aTs = 7;
            this.aTE = new MediaRecorder();
            return;
        }
        pg();
        this.aTs = 1;
    }

    public final void a(a aVar) {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.aTE != null) {
                this.aTu = aVar;
                this.aTE.setOnErrorListener(new OnErrorListener(this) {
                    final /* synthetic */ b aTK;

                    {
                        this.aTK = r1;
                    }

                    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                        if (this.aTK.aTu != null) {
                            this.aTK.aTu.onError();
                        }
                        try {
                            this.aTK.aTE.release();
                        } catch (Exception e) {
                            v.e("MicroMsg.MMAudioRecorder", e.getMessage());
                        }
                        this.aTK.aTH = b.ERROR;
                    }
                });
            }
        } else if (this.aTH == b.INITIALIZING) {
            this.aTu = aVar;
        } else {
            v.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
        }
    }

    public final void setOutputFile(String str) {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.aTE != null) {
                this.aTE.setOutputFile(str);
                this.aTr = str;
            }
        } else if (this.aTH == b.INITIALIZING) {
            this.aTr = str;
        } else {
            v.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.aTH = b.ERROR;
        }
    }

    public final void setMaxDuration(int i) {
        if (this.aTG != com.tencent.mm.compatible.b.b.a.AMR) {
            this.aTx = (long) i;
        } else if (this.aTE != null) {
            this.aTE.setMaxDuration(i);
        }
    }

    public final void pd() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR && this.aTE != null) {
            this.aTE.setAudioEncoder(1);
        }
    }

    public final void pe() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR && this.aTE != null) {
            this.aTE.setAudioSource(1);
        }
    }

    public final void pf() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR && this.aTE != null) {
            this.aTE.setOutputFormat(3);
        }
    }

    public final int getMaxAmplitude() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.aTE == null) {
                return 0;
            }
            return this.aTE.getMaxAmplitude();
        } else if (this.aTH != b.RECORDING) {
            return 0;
        } else {
            int i = this.aTq;
            this.aTq = 0;
            return i;
        }
    }

    public final void pg() {
        int nextInt;
        this.aTw = com.tencent.mm.aq.c.a.JT();
        if (this.aTw != null) {
            boolean z;
            com.tencent.mm.aq.c.a aVar = this.aTw;
            if (1 == g.i("EnableSpeexVoiceUpload", 0)) {
                z = true;
            } else {
                v.d("upload", "type " + c.chatType);
                int JS = aVar.JS();
                int JR = aVar.JR();
                ak.yW();
                Integer valueOf = Integer.valueOf(be.f((Integer) com.tencent.mm.model.c.vf().get(16646145, null)));
                v.d("upload", "daycount " + aVar.JS() + "  count " + valueOf + " rate " + JR);
                if (valueOf.intValue() <= JS && JR != 0 && com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                    ak.yW();
                    z = aVar.bBZ == 0 ? true : aVar.bBZ == be.a((Integer) com.tencent.mm.model.c.vf().get(12290, null), 0);
                    v.d("upload", "fitSex " + aVar.bBZ + " " + z + " " + aVar.bBZ);
                    if (z && aVar.JQ()) {
                        nextInt = aVar.dax.nextInt(JR);
                        v.d("upload", "luck " + nextInt);
                        if (nextInt == JR / 2) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            this.aTD = z;
        }
        if (this.aTG == com.tencent.mm.compatible.b.b.a.SILK) {
            this.aTB = be.getInt(j.sU().getValue("VoiceSamplingRate"), 16000);
            this.aTC = be.getInt(j.sU().getValue("VoiceRate"), 16000);
            v.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", r0, Integer.valueOf(this.aTB), r3, Integer.valueOf(this.aTC));
        } else {
            if (this.aTD) {
                this.aTB = 16000;
            } else {
                this.aTB = 8000;
            }
            nextInt = be.a((Integer) ak.yT().get(27), 0);
            v.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.aTB + " notSupp16K: " + nextInt);
            if (nextInt == 1) {
                this.aTB = 8000;
            }
        }
        this.aTq = 0;
        this.aTr = null;
        this.aTv = null;
        this.aTt = null;
        this.aTz = 0;
        try {
            synchronized (aTA) {
                this.aTF = new c(this.aTB, 0);
                this.aTF.al(true);
                this.aTF.cL(120);
                this.aTF.aUn = this.aTJ;
            }
            this.aTH = b.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                v.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                v.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.aTH = b.ERROR;
        }
    }

    public final void start() {
        if (this.aTG != com.tencent.mm.compatible.b.b.a.AMR) {
            v.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.aTH + " recMode: " + this.aTG);
            if (this.aTH == b.READY) {
                this.aTy = System.currentTimeMillis();
                this.aTz = 0;
                this.aTH = b.RECORDING;
                synchronized (aTA) {
                    this.aTF.pj();
                }
                return;
            }
            ak.yT().set(27, Integer.valueOf(1));
            v.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
            this.aTH = b.ERROR;
        } else if (this.aTE != null) {
            this.aTE.start();
        }
    }

    public final void prepare() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.aTE != null) {
                this.aTE.prepare();
            }
        } else if (this.aTH != b.INITIALIZING || this.aTr == null) {
            this.aTH = b.ERROR;
            release();
        } else {
            this.aTH = b.READY;
        }
    }

    public final void release() {
        if (this.aTG != com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.aTH == b.RECORDING) {
                ph();
            } else {
                b bVar = b.READY;
            }
            synchronized (aTA) {
                if (this.aTF != null) {
                    this.aTF.pb();
                    this.aTF = null;
                }
            }
        } else if (this.aTE != null) {
            this.aTE.release();
        }
    }

    public final boolean ph() {
        if (this.aTG == com.tencent.mm.compatible.b.b.a.AMR) {
            v.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.aTE);
            if (this.aTE == null) {
                return true;
            }
            this.aTE.stop();
            this.aTE.release();
            this.aTE = null;
            return true;
        }
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        v.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.aTH);
        if (this.aTH != b.RECORDING) {
            v.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.aTH = b.ERROR;
            return true;
        }
        synchronized (aTA) {
            if (this.aTF != null) {
                this.aTF.pb();
                this.aTF.aUn = null;
            } else {
                v.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
            }
        }
        long sn = aVar.sn();
        this.aTH = b.STOPPED;
        long sn2 = aVar.sn();
        if (this.aTt != null) {
            this.aTt.pv();
        }
        if (this.aTv != null) {
            com.tencent.mm.aq.b bVar = this.aTv;
            v.i("MicroMsg.SpeexEncoderWorker", "stop ");
            new ac(Looper.getMainLooper()).post(new Runnable(bVar) {
                final /* synthetic */ b dak;

                {
                    this.dak = r1;
                }

                public final void run() {
                    Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                        final /* synthetic */ AnonymousClass1 dal;

                        {
                            this.dal = r1;
                        }

                        public final boolean queueIdle() {
                            v.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                            d.JU().b(this.dal.dak);
                            return false;
                        }
                    });
                }
            });
        }
        long ay = be.ay(this.aTy);
        v.i("MicroMsg.MMAudioRecorder", "toNow " + ay + " startTickCnt: " + this.aTy + " pcmDataReadedCnt: " + this.aTz);
        if (ay > 2000 && this.aTz == 0) {
            ak.yT().set(27, Integer.valueOf(1));
            v.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        v.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + sn + " Read:" + sn2 + " Thr:" + aVar.sn());
        return false;
    }
}
