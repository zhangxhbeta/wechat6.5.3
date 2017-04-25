package com.tencent.mm.c.b;

import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.c.c.b;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ju;
import com.tencent.mm.e.a.jv;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class c {
    private int aTB;
    public int aTS;
    int aTT;
    int aTU;
    int aTV;
    private int aTW;
    int aTX;
    private boolean aTY;
    boolean aTZ;
    private int aUa;
    private int aUb;
    public int aUc;
    private boolean aUd;
    long aUe;
    int aUf;
    boolean aUg;
    int aUh;
    private boolean aUi;
    int aUj;
    boolean aUk;
    boolean aUl;
    private AudioRecord aUm;
    public a aUn;
    private f aUo;
    private e aUp;
    b aUq;
    private int aUr;
    public int aUs;
    private com.tencent.mm.c.b.f.a aUt;

    public interface a {
        void as(int i, int i2);

        void d(byte[] bArr, int i);
    }

    public c(int i, int i2) {
        this.aTS = 0;
        this.aTT = 0;
        this.aTU = 0;
        this.aTV = 0;
        this.aTW = 1;
        this.aTB = 8000;
        this.aTX = 120;
        this.aTY = false;
        this.aTZ = false;
        this.aUa = 10;
        this.aUb = -1;
        this.aUc = -123456789;
        this.aUd = false;
        this.aUe = -1;
        this.aUg = false;
        this.aUi = false;
        this.aUj = 0;
        this.aUk = false;
        this.aUl = false;
        this.aUr = 2;
        this.aUs = 1;
        this.aUt = new com.tencent.mm.c.b.f.a(this) {
            final /* synthetic */ c aUu;

            {
                this.aUu = r1;
            }

            public final void c(int i, byte[] bArr) {
                c cVar;
                int i2;
                int i3;
                c cVar2 = this.aUu;
                cVar2.aUj++;
                if (this.aUu.aUl && System.currentTimeMillis() - this.aUu.aUe <= 1000 && ((long) (this.aUu.aUj - 10)) > (System.currentTimeMillis() - this.aUu.aUe) / ((long) this.aUu.aTX)) {
                    g.iuh.a(151, 0, 1, false);
                    g.iuh.a(151, 4, 1, false);
                    v.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(this.aUu.aUj), Long.valueOf((System.currentTimeMillis() - this.aUu.aUe) / ((long) this.aUu.aTX)));
                    this.aUu.aUk = true;
                }
                if (this.aUu.aUq != null) {
                    this.aUu.aUq.h(bArr, i);
                }
                if (i > 0) {
                    cVar = this.aUu;
                    if (!(cVar.aUg && -2 == cVar.aTU)) {
                        int i4 = i / cVar.aUf;
                        for (i2 = 5; i2 <= cVar.aUh + i4; i2 += 5) {
                            i3 = ((i2 - cVar.aUh) - 1) * cVar.aUf;
                            int i5 = cVar.aUf + i3;
                            if (i3 < 0 || i5 > i) {
                                v.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                                break;
                            }
                            while (i3 < i5) {
                                if (bArr[i3] != (byte) 0) {
                                    cVar.aTU = -1;
                                    cVar.aUg = true;
                                    break;
                                }
                                i3++;
                            }
                            cVar.aTU++;
                        }
                        cVar.aUh = (cVar.aUh + i4) % 5;
                        if (cVar.aTU == 20) {
                            cVar.aTS = 6;
                            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                            if (cVar.aTT == -1 && cVar.aTV == -1) {
                                cVar.aTS = 11;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar.aTT == -1) {
                                cVar.aTS = 8;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar.aTV == -1) {
                                cVar.aTS = 9;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                            }
                            g.iuh.a(151, 0, 1, false);
                            g.iuh.a(151, 5, 1, false);
                            cVar.aTU = -2;
                            cVar.pk();
                        }
                    }
                }
                if (!this.aUu.aTZ) {
                    return;
                }
                if (i > 0) {
                    cVar = this.aUu;
                    if (cVar.aTT != -1) {
                        i3 = 0;
                        for (i2 = 0; i2 < i / 2; i2++) {
                            short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & WebView.NORMAL_MODE_ALPHA));
                            if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                                i3++;
                            }
                            if (i3 >= 5) {
                                cVar.aTT++;
                                break;
                            }
                        }
                        if (cVar.aTT > 100) {
                            cVar.aTS = 7;
                            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                            if (cVar.aTU == -2 && cVar.aTV == -1) {
                                cVar.aTS = 11;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                            } else if (cVar.aTU == -2) {
                                cVar.aTS = 8;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                            } else if (cVar.aTV == -1) {
                                cVar.aTS = 10;
                                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                            }
                            g.iuh.a(151, 0, 1, false);
                            g.iuh.a(151, 6, 1, false);
                            cVar.pk();
                            cVar.aTT = -1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                cVar2 = this.aUu;
                if (cVar2.aTV != -1 && i < 0) {
                    cVar2.aTV++;
                    if (cVar2.aTV >= 50) {
                        cVar2.aTS = 5;
                        v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                        if (cVar2.aTU == -2 && cVar2.aTT == -1) {
                            cVar2.aTS = 11;
                            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar2.aTU == -2) {
                            cVar2.aTS = 9;
                            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        } else if (cVar2.aTT == -1) {
                            cVar2.aTS = 10;
                            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        g.iuh.a(151, 0, 1, false);
                        g.iuh.a(151, 7, 1, false);
                        cVar2.pk();
                        cVar2.aTV = -1;
                    }
                }
            }
        };
        this.aTW = 1;
        this.aTB = i;
        this.aUb = i2;
        if (this.aTW == 2) {
            this.aUr = 3;
        } else {
            this.aUr = 2;
        }
        if (this.aUb == 0 && p.ceJ.cdx > 0) {
            this.aTX = p.ceJ.cdx;
        }
        if (p.ceJ.cdI > 0) {
            this.aUr = p.ceJ.cdI;
        }
        if (p.ceJ.cds > 0) {
            this.aUa = p.ceJ.cds;
        }
        if (p.ceB.cbV) {
            this.aUq = new b(g.aUR, this.aTW, this.aTB);
        }
        this.aUl = 1 == g.i("EnableRecorderCheckUnreasonableData", 1);
        v.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.aTB), Integer.valueOf(this.aTW), Integer.valueOf(this.aTX), Boolean.valueOf(this.aTY), Integer.valueOf(this.aUb));
    }

    public final void cL(int i) {
        this.aTX = i;
        v.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.aTX);
    }

    public final void al(boolean z) {
        this.aTY = z;
        v.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.aTY);
    }

    public final void pi() {
        this.aTZ = true;
        v.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.aTZ);
    }

    public final void r(int i, boolean z) {
        if (10 == this.aUa || z) {
            this.aUa = i;
            v.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.aUa);
        }
    }

    public final void am(boolean z) {
        this.aUd = z;
        v.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.aUd);
    }

    private boolean init() {
        boolean z;
        Object obj;
        this.aUs = 1;
        if (p.ceJ.cdt == 2) {
            z = false;
        } else {
            z = true;
        }
        int rx = l.rx();
        int i = p.ceB.cci;
        if ((rx & 1024) != 0) {
            if (i <= 0) {
                i = 0;
            }
            v.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        v.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.aTB, this.aUr, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.aUs = 3;
            this.aTS = 1;
            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
            pk();
            return false;
        }
        v.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", Integer.valueOf(minBufferSize));
        this.aUf = (((this.aTB * 20) * this.aTW) * 2) / 1000;
        int i2 = ((this.aTB * this.aTX) * this.aTW) / 1000;
        int i3 = i2 * 2;
        v.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", Integer.valueOf(minBufferSize), Integer.valueOf(this.aTB), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.aUa), Boolean.valueOf(z));
        int i4 = this.aUb;
        rx = 1;
        if (1 == i4 || 6 == i4) {
            i = VERSION.SDK_INT < 11 ? 1 : 7;
            if (p.ceB.cbr) {
                i = 1;
            }
            if (p.ceB.cbP >= 0) {
                rx = p.ceB.cbP;
            } else {
                rx = i;
            }
            if (6 == i4 && p.ceB.ccs >= 0) {
                rx = p.ceB.ccs;
            }
        }
        try {
            this.aUm = new AudioRecord(rx, this.aTB, this.aUr, 2, this.aUa * minBufferSize);
            if (this.aUm.getState() == 0) {
                g.iuh.a(151, 0, 1, false);
                g.iuh.a(151, 2, 1, false);
                this.aUm.release();
                this.aTS = 2;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                if (7 == rx) {
                    rx = 1;
                } else {
                    rx = 0;
                }
                this.aUm = new AudioRecord(rx, this.aTB, this.aUr, 2, this.aUa * minBufferSize);
            }
            if (this.aUm.getState() == 0) {
                g.iuh.a(151, 0, 1, false);
                g.iuh.a(151, 2, 1, false);
                this.aUm.release();
                this.aUm = null;
                this.aUs = 2;
                this.aTS = 3;
                v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                pk();
                return false;
            }
            AudioRecord audioRecord;
            if (z) {
                audioRecord = this.aUm;
                boolean z2 = this.aTY;
                a aVar = this.aUn;
                boolean z3 = (this.aUb == 1 || this.aUb == 6) && obj != null;
                this.aUo = new e(audioRecord, z2, i3, aVar, z3);
            } else {
                this.aUo = new d(this.aUm, this.aUn, this.aTY, i2, i3);
            }
            this.aUo.a(this.aUt);
            if (-123456789 != this.aUc) {
                this.aUo.cM(this.aUc);
            }
            if (this.aUd) {
                this.aUp = new e();
                e eVar = this.aUp;
                audioRecord = this.aUm;
                i4 = this.aUb;
                v.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                if (!f.dX(16)) {
                    if (audioRecord == null) {
                        v.d("MicroMsg.MMAudioPreProcess", "audio is null");
                    } else if (1 == i4) {
                        if (p.ceJ.cdP != 1) {
                            v.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            if (p.ceJ.cdQ != 2) {
                                eVar.cbm = new com.tencent.mm.compatible.b.g(audioRecord);
                                if (eVar.cbm != null && eVar.cbm.isAvailable()) {
                                    eVar.cbm.qQ();
                                }
                            }
                            if (p.ceJ.cdR != 2) {
                                eVar.cbn = new com.tencent.mm.compatible.b.c(audioRecord);
                                if (eVar.cbn != null && eVar.cbn.isAvailable()) {
                                    eVar.cbn.qQ();
                                }
                            }
                            if (p.ceJ.cdS != 2) {
                                eVar.cbo = new com.tencent.mm.compatible.b.f(audioRecord);
                                if (eVar.cbo != null && eVar.cbo.isAvailable()) {
                                    eVar.cbo.qQ();
                                }
                            }
                        }
                    } else if (p.ceJ.cdw != 1) {
                        v.d("MicroMsg.MMAudioPreProcess", "disable by config");
                    } else {
                        eVar.cbm = new com.tencent.mm.compatible.b.g(audioRecord);
                        if (eVar.cbm != null && eVar.cbm.isAvailable()) {
                            eVar.cbm.qQ();
                        }
                        eVar.cbn = new com.tencent.mm.compatible.b.c(audioRecord);
                        if (eVar.cbn != null && eVar.cbn.isAvailable()) {
                            eVar.cbn.qQ();
                        }
                        eVar.cbo = new com.tencent.mm.compatible.b.f(audioRecord);
                        if (eVar.cbo != null && eVar.cbo.isAvailable()) {
                            eVar.cbo.qQ();
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.aTS = 12;
            v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            g.iuh.a(151, 0, 1, false);
            g.iuh.a(151, 1, 1, false);
            return false;
        }
    }

    public final void an(boolean z) {
        v.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + z);
        if (this.aUo != null) {
            this.aUo.an(z);
        }
    }

    public final boolean pj() {
        boolean z = false;
        v.d("MicroMsg.MMPcmRecorder", "startRecord");
        com.tencent.mm.sdk.c.b juVar = new ju();
        juVar.bkt.type = 1;
        juVar.bkt.bkv = true;
        com.tencent.mm.sdk.c.a.nhr.z(juVar);
        this.aUe = System.currentTimeMillis();
        this.aUg = false;
        if (juVar.bku.bkx) {
            v.i("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.aTS = 13;
        } else {
            this.aUi = false;
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            v.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
            if (this.aUm != null) {
                v.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
            } else {
                aVar.cgu = SystemClock.elapsedRealtime();
                v.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
                if (init()) {
                    v.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.sn() + "ms");
                    aVar.cgu = SystemClock.elapsedRealtime();
                    this.aUm.startRecording();
                    v.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.sn());
                    if (this.aUm.getRecordingState() != 3) {
                        g.iuh.a(151, 0, 1, false);
                        g.iuh.a(151, 3, 1, false);
                        this.aUs = 2;
                        this.aTS = 4;
                        v.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                        pk();
                    } else if (this.aUo != null) {
                        z = this.aUo.pj();
                    } else {
                        v.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                    }
                } else {
                    v.e("MicroMsg.MMPcmRecorder", "startRecord init error");
                }
            }
            if (!z) {
                pb();
                juVar = new jv();
                juVar.bky.type = 1;
                com.tencent.mm.sdk.c.a.nhr.z(juVar);
            }
        }
        return z;
    }

    public final synchronized boolean pb() {
        boolean z = true;
        synchronized (this) {
            if (true == this.aUi) {
                v.i("MicroMsg.MMPcmRecorder", "already have stopped");
            } else {
                boolean z2;
                this.aUi = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.aUq != null) {
                    this.aUq.pw();
                    this.aUq = null;
                }
                aVar.cgu = SystemClock.elapsedRealtime();
                if (this.aUo != null) {
                    this.aUo.oT();
                    this.aUo = null;
                }
                v.i("MicroMsg.MMPcmRecorder", "cost " + aVar.sn() + "ms to call stopRecord");
                v.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.aUm == null) {
                    v.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.aUm.getState() != 1) {
                    v.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.aUm.getState());
                    z2 = false;
                } else {
                    aVar.cgu = SystemClock.elapsedRealtime();
                    this.aUm.stop();
                    this.aUm.release();
                    this.aUm = null;
                    v.i("MicroMsg.MMPcmRecorder", "cost " + aVar.sn() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.aUg || -1 == this.aUe || System.currentTimeMillis() - this.aUe < 2000) || this.aUk) {
                    v.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    com.tencent.mm.sdk.c.b jvVar = new jv();
                    jvVar.bky.type = 1;
                    com.tencent.mm.sdk.c.a.nhr.z(jvVar);
                    z = false;
                }
                com.tencent.mm.sdk.c.b juVar = new ju();
                juVar.bkt.type = 1;
                juVar.bkt.bkv = false;
                juVar.bkt.bkw = z;
                com.tencent.mm.sdk.c.a.nhr.z(juVar);
                v.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.aTS));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.aTS != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.aTS) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                v.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                g gVar = g.iuh;
                g.d(arrayList, false);
                z = z2;
            }
        }
        return z;
    }

    final void pk() {
        if (this.aUn != null) {
            this.aUn.as(this.aUs, this.aTS);
        }
    }

    public final int pl() {
        if (this.aUo != null) {
            return this.aUo.pl();
        }
        return -1;
    }
}
