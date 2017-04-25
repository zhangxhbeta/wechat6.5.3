package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.c.b;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.encode.a.f;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j implements c {
    String aZy = "";
    String bdZ = null;
    private boolean clD = false;
    VideoTransPara hnB;
    boolean hnC = false;
    f hoI;
    n hoJ;
    f hoK;
    a hoL = null;
    d hoM;
    String hoN = "";
    int hoO = 0;
    float hoP = 0.0f;
    private int hoQ = 480;
    private int hoR = 640;
    int hoS = 1600000;
    int hoT = 480;
    int hoU = 640;
    int hoV = 0;
    String hoW = null;
    private HandlerThread hoX = null;
    ac hoY = null;
    int hoZ = -1;
    int hpa = -1;
    private String hpb = null;
    private boolean hpc = false;
    boolean hpd = false;
    int hpe = -1;
    boolean hpf = false;
    boolean hpg = false;
    int hph = 0;
    com.tencent.mm.plugin.mmsight.model.a.c.a hpi;
    private b hpj = new b(this) {
        final /* synthetic */ j hpk;

        {
            this.hpk = r1;
        }

        public final boolean au(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (this.hpk.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWE) {
                return false;
            }
            j jVar = this.hpk;
            if (!jVar.hpd) {
                jVar.hpd = true;
                Object obj = new byte[bArr.length];
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                e.a(new AnonymousClass6(jVar, obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
            }
            if (this.hpk.hoY == null) {
                return true;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = bArr;
            this.hpk.hoY.sendMessage(obtain);
            return true;
        }
    };
    private String mFileName;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ j hpk;
        final /* synthetic */ byte[] hpl;

        AnonymousClass6(j jVar, byte[] bArr) {
            this.hpk = jVar;
            this.hpl = bArr;
        }

        public final void run() {
            j jVar = this.hpk;
            byte[] bArr = this.hpl;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (be.kS(jVar.bdZ)) {
                            v.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                            jVar.hpd = false;
                            return;
                        }
                        int i;
                        Bitmap b;
                        int i2 = (jVar.hoV == 0 || jVar.hoV == 180) ? jVar.hoT : jVar.hoU;
                        int i3 = (jVar.hoV == 0 || jVar.hoV == 180) ? jVar.hoU : jVar.hoT;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
                        Rect rect = new Rect(0, 0, i2, i3);
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (jVar.hnB != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > jVar.hnB.width) {
                            int i4;
                            i2 = decodeByteArray.getWidth();
                            i3 = decodeByteArray.getHeight();
                            if (i2 < i3) {
                                i4 = jVar.hnB.width;
                                i = (int) (((float) i3) / ((((float) i2) * 1.0f) / ((float) i4)));
                            } else {
                                i = jVar.hnB.width;
                                i4 = (int) (((float) i2) / ((((float) i3) * 1.0f) / ((float) i)));
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i4, i, true);
                        }
                        if (!jVar.hpg || jVar.hph == 180) {
                            i = jVar.hoV;
                            if (jVar.hph == 180) {
                                i += 180;
                                if (i > 360) {
                                    i -= 360;
                                }
                            }
                            b = d.b(decodeByteArray, (float) i);
                        } else if (Math.abs(jVar.hoV - jVar.hph) == 0) {
                            b = d.b(decodeByteArray, 180.0f);
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        d.a(b, 60, CompressFormat.JPEG, jVar.bdZ, true);
                        v.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[]{jVar.bdZ, Integer.valueOf(jVar.hoV), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
                        return;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                    jVar.hpd = false;
                    return;
                }
            }
            v.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
            jVar.hpd = false;
        }
    }

    private class a implements Runnable {
        Runnable bpT;
        int duration;
        final /* synthetic */ j hpk;
        int hpm;
        volatile int hpn;
        float hpo;
        volatile boolean hpp;
        boolean hpq;
        boolean hpr;
        boolean hps;
        boolean hpt;
        Object hpu;

        private a(j jVar) {
            this.hpk = jVar;
            this.hpn = 0;
            this.hpp = true;
            this.hpq = false;
            this.hpr = false;
            this.hps = false;
            this.hpt = false;
            this.hpu = new Object();
            this.bpT = null;
        }

        public final void run() {
            if (this.hpk.hpa == -1) {
                this.hpk.hpa = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                v.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[]{Integer.valueOf(this.hpk.hpa)});
            }
            synchronized (this.hpu) {
                long Nj;
                while (!this.hpr) {
                    Nj = be.Nj();
                    int triggerEncode = SightVideoJNI.triggerEncode(this.hpm, Math.max(0, this.hpn), false);
                    v.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Integer.valueOf(triggerEncode), Long.valueOf(Thread.currentThread().getId())});
                    if (Math.abs(triggerEncode - this.hpn) <= 5) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            v.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
                        }
                    }
                    this.hpn = triggerEncode;
                }
                Nj = be.Nj();
                if (!this.hps) {
                    this.hpn = SightVideoJNI.triggerEncode(this.hpm, this.hpn, true);
                }
                v.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[]{Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Boolean.valueOf(this.hps), Long.valueOf(Thread.currentThread().getId())});
                if (!this.hps) {
                    this.hpk.hoM = new k(this.hpm, this.hpk.hoN, this.hpo, this.hpk.hoS, Math.max(BaseReportManager.MAX_READ_COUNT, this.duration), this.hpk.hnB.audioSampleRate);
                    Nj = be.Nj();
                    v.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(be.az(Nj)), Boolean.valueOf(this.hpk.hoM.aAq())});
                    if (!this.hpk.hoM.aAq()) {
                        v.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
                        SightVideoJNI.releaseBigSightDataBuffer(this.hpm);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ a hpv;

                            {
                                this.hpv = r1;
                            }

                            public final void run() {
                                if (this.hpv.hpk.hpi != null) {
                                    this.hpv.hpk.hpi.aAp();
                                }
                            }
                        });
                        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
                        g.iuh.a(440, 30, 1, false);
                        return;
                    } else if ((this.hpk.hpg && this.hpk.hnC) || (!(this.hpk.hnC || this.hpk.hpg) || ((this.hpk.hpg && Math.abs(this.hpk.hoV - this.hpk.hph) == 0) || this.hpk.hph == 180))) {
                        int i;
                        long Nj2 = be.Nj();
                        if (!this.hpk.hnC && !this.hpk.hpg) {
                            i = this.hpk.hoV;
                        } else if (this.hpk.hnC) {
                            i = this.hpk.hph;
                        } else {
                            i = 180;
                        }
                        if (this.hpk.hph == 180 && !this.hpk.hnC) {
                            i += 180;
                            if (i > 360) {
                                i -= 360;
                            }
                        }
                        SightVideoJNI.tagRotateVideo(this.hpk.hoN, this.hpk.hoW, i);
                        v.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(be.az(Nj2)), Integer.valueOf(this.hpk.hoV), Boolean.valueOf(this.hpk.hpg), Integer.valueOf(this.hpk.hph), Integer.valueOf(i)});
                        final String str = this.hpk.hoW;
                        try {
                            FileOp.p(this.hpk.hoW, this.hpk.hoN);
                            e.a(new Runnable(this) {
                                final /* synthetic */ a hpv;

                                public final void run() {
                                    try {
                                        FileOp.deleteFile(str);
                                    } catch (Exception e) {
                                        v.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
                                    }
                                }
                            }, "BigSightFFMpegRecorder_tagRotate_after_process");
                            v.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[]{Long.valueOf(be.az(Nj2))});
                        } catch (Exception e2) {
                            v.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
                            SightVideoJNI.releaseBigSightDataBuffer(this.hpm);
                            ad.o(new Runnable(this) {
                                final /* synthetic */ a hpv;

                                {
                                    this.hpv = r1;
                                }

                                public final void run() {
                                    if (this.hpv.hpk.hpi != null) {
                                        this.hpv.hpk.hpi.aAp();
                                    }
                                }
                            });
                            return;
                        }
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.hpm);
                v.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[]{this.bpT});
                this.hpk.reset();
                ad.o(this.bpT);
                this.hpt = true;
                this.hpk.hpa = -1;
                this.hpk.hoZ = -1;
            }
        }
    }

    public j(VideoTransPara videoTransPara) {
        this.hnB = videoTransPara;
        this.hoQ = videoTransPara.width;
        this.hoR = videoTransPara.height;
        this.hoS = videoTransPara.cGx;
        i.aAw();
        int aAx = i.aAx();
        if (aAx == -1) {
            this.hoS = videoTransPara.cGx;
        } else {
            this.hoS = aAx;
        }
        this.hoK = new f();
        this.clD = false;
        v.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[]{Integer.valueOf(this.hoQ), Integer.valueOf(this.hoR), Integer.valueOf(this.hoS), Integer.valueOf(aAx)});
    }

    public final void i(int i, int i2, int i3, int i4) {
        v.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.hoQ = i3;
        this.hoR = i4;
        this.hoT = i;
        this.hoU = i2;
        if (h.hoF.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            h.bP(i, i2);
        }
    }

    final boolean na(int i) {
        if (this.hoL == null || this.hoL.hpt) {
            return false;
        }
        if (!this.hoL.hpq) {
            this.hoL.bpT = null;
            this.hoL.hps = true;
            this.hoL.hpr = true;
            e.remove(this.hoL);
        }
        synchronized (this.hoL.hpu) {
            SightVideoJNI.releaseBigSightDataBuffer(i);
            if (this.hoL.hpm != i) {
                SightVideoJNI.releaseBigSightDataBuffer(this.hoL.hpm);
            }
        }
        return true;
    }

    private void clear() {
        boolean z;
        boolean z2 = false;
        int i = -1;
        if (this.hoJ != null) {
            i = this.hoJ.hpP;
            if (i < 0) {
                v.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
                return;
            }
            this.hoJ.stop();
        }
        if (this.hoI != null) {
            this.hoI.a(null);
        }
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (this.hoL == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.hoL != null) {
            z2 = this.hoL.hps;
        }
        objArr[2] = Boolean.valueOf(z2);
        v.v(str, str2, objArr);
        if (i >= 0 && !na(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseDataBufferRef(i);
        }
    }

    public final void cancel() {
        v.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWG);
        clear();
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWH);
    }

    public final void s(final Runnable runnable) {
        boolean z = true;
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.hoL == null);
        boolean z2 = this.hoL != null && this.hoL.hpq;
        objArr[1] = Boolean.valueOf(z2);
        if (this.hoL == null || !this.hoL.hpr) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (this.hoL == null || !this.hoL.hpq) {
            e.a(new Runnable(this) {
                final /* synthetic */ j hpk;

                public final void run() {
                    j jVar = this.hpk;
                    Runnable runnable = runnable;
                    jVar.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWG);
                    if (jVar.hoJ != null) {
                        int i = jVar.hoJ.hpP;
                        float aAC = (((float) jVar.hoJ.hpQ) * 1000.0f) / ((float) jVar.hoJ.aAC());
                        v.i("MicroMsg.MMSightFFMpegRecorder", "stop, bufID %d, frameCount %d, duration %dms, %.6ffps", new Object[]{Integer.valueOf(i), Integer.valueOf(jVar.hoJ.hpQ), Long.valueOf(jVar.hoJ.aAC()), Float.valueOf(aAC)});
                        jVar.hoO = (int) jVar.hoJ.aAC();
                        jVar.hoP = aAC;
                        jVar.hoJ.stop();
                        if (jVar.hoL != null) {
                            jVar.hoL.hpo = aAC;
                            jVar.hoL.duration = jVar.hoO;
                            jVar.hoL.bpT = runnable;
                            jVar.hoL.hpq = true;
                            e.remove(jVar.hoL);
                        }
                    }
                    if (jVar.hoI != null) {
                        jVar.hoI.a(new b(jVar) {
                            final /* synthetic */ j hpk;

                            {
                                this.hpk = r1;
                            }

                            public final void aAv() {
                                if (this.hpk.hoL != null) {
                                    this.hpk.hoL.hpr = true;
                                }
                            }
                        });
                    }
                    jVar.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWH);
                    jVar.aZy = com.tencent.mm.b.g.aX(jVar.hoN);
                    if (jVar.hoL == null) {
                        v.e("MicroMsg.MMSightFFMpegRecorder", "encodeRunnable is null!, directly call stopcallback");
                        jVar.reset();
                        ad.o(runnable);
                    }
                }
            }, "MMSightFFMpegRecorder_stop");
            return;
        }
        synchronized (this.hoL.hpu) {
            reset();
            ad.o(runnable);
        }
    }

    public final String EB() {
        return be.ah(this.aZy, "");
    }

    public final com.tencent.mm.plugin.sight.encode.a.b.b aAk() {
        return this.hoK.iXd;
    }

    public final long aAi() {
        return this.hoJ.aAC();
    }

    public final b aAj() {
        return this.hpj;
    }

    public final String OZ() {
        return this.hoN;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final void setFilePath(String str) {
        this.hoN = str;
    }

    public final void wy(String str) {
        this.bdZ = str;
    }

    public final void wz(String str) {
        this.hpb = str;
    }

    public final String aAg() {
        return this.hpb;
    }

    public final void reset() {
        v.i("MicroMsg.MMSightFFMpegRecorder", "reset");
        this.hoK.iXd = com.tencent.mm.plugin.sight.encode.a.b.b.iWH;
        this.hpf = false;
        if (this.hoI != null) {
            this.hoI.clear();
        }
        if (this.hoJ != null) {
            n nVar = this.hoJ;
            nVar.hpP = -1;
            nVar.hpQ = 0;
            nVar.ewI = 0;
        }
        clear();
    }

    private boolean nb(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        long Nj = be.Nj();
        this.hnC = com.tencent.mm.plugin.mmsight.model.g.hns.hnC;
        this.hoV = i;
        if (this.hnC) {
            i2 = (i == 0 || i == 180) ? this.hoT : this.hoU;
            i3 = (i == 0 || i == 180) ? this.hoU : this.hoT;
            i4 = (i == 0 || i == 180) ? this.hoQ : this.hoR;
            if (i == 0 || i == 180) {
                i5 = this.hoR;
            } else {
                i5 = this.hoQ;
            }
        } else {
            i3 = (i == 0 || i == 180) ? this.hoT : this.hoU;
            i2 = (i == 0 || i == 180) ? this.hoU : this.hoT;
            i4 = this.hoQ;
            i5 = this.hoR;
            int i6 = i2;
            i2 = i3;
            i3 = i6;
        }
        i3 = SightVideoJNI.initDataBufferForMMSight(i2, i3, i, i4, i5, (float) this.hnB.cdg, this.hoS, this.hnB.cGn, 8, this.hnB.cGm, 23.0f, this.hnC, true, this.hnB.duration);
        if (i3 < 0) {
            v.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
            h.azX();
            return false;
        }
        this.hoJ = new n(this.hnC, i, i4, i5);
        this.hoI = new f(this.hnB.audioSampleRate, this.hnB.cGk);
        n nVar = this.hoJ;
        if (i3 < 0) {
            v.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            i2 = -1;
        } else {
            nVar.hpP = i3;
            nVar.hpQ = 0;
            nVar.ewI = 0;
            i2 = 0;
        }
        int mZ = this.hoI.mZ(i3);
        if (i2 < 0 || mZ < 0) {
            v.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(mZ)});
            SightVideoJNI.releaseBigSightDataBuffer(i3);
            h.azX();
            return false;
        }
        this.hpe = i3;
        v.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        return true;
    }

    public final boolean mY(int i) {
        if (this.clD) {
            return true;
        }
        v.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        boolean nb = nb(i);
        this.clD = true;
        v.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(nb)});
        return nb;
    }

    public final int b(int i, boolean z, int i2) {
        v.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{this.hoK.iXd, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.hpg = z;
        this.hoO = 0;
        this.hph = i2;
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWD);
        String str = "MicroMsg.MMSightFFMpegRecorder";
        String str2 = "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.hoN;
        objArr[1] = Boolean.valueOf(this.hoL == null);
        objArr[2] = Boolean.valueOf(this.hoL == null ? true : this.hoL.hpt);
        v.i(str, str2, objArr);
        if (this.hoL != null && !this.hoL.hpt) {
            v.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
            return -1;
        } else if (be.kS(this.hoN)) {
            v.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
            return -1;
        } else {
            try {
                this.mFileName = com.tencent.mm.a.e.aT(this.hoN);
                String jR = FileOp.jR(this.hoN);
                if (!jR.endsWith("/")) {
                    jR = jR + "/";
                }
                this.hoW = jR + "tempRotate.mp4";
            } catch (Exception e) {
                v.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[]{this.hoN});
            this.hoV = i;
            v.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[]{Integer.valueOf(this.hoV)});
            if (!this.clD) {
                nb(i);
                this.clD = true;
            }
            n nVar = this.hoJ;
            if (0 == nVar.ewI) {
                nVar.ewI = System.currentTimeMillis();
            }
            int a = this.hoI.a(new a(this) {
                final /* synthetic */ j hpk;

                {
                    this.hpk = r1;
                }

                public final void aAu() {
                    v.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
                    if (!(this.hpk.hoL == null || this.hpk.hoL.hpt)) {
                        v.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[]{this.hpk.hoL});
                        this.hpk.na(this.hpk.hoL.hpm);
                    }
                    if (this.hpk.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWL) {
                        v.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
                        return;
                    }
                    this.hpk.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWE);
                    this.hpk.hoL = new a();
                    this.hpk.hoL.hpm = this.hpk.hpe;
                    e.b(this.hpk.hoL, "SightCustomAsyncMediaRecorder_encode_" + be.Nj(), 5);
                }
            });
            v.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[]{Integer.valueOf(a)});
            this.hoX = e.bJ("BigSightWriteCameraData", 0);
            this.hoX.start();
            this.hoY = new ac(this, this.hoX.getLooper()) {
                final /* synthetic */ j hpk;

                public final void handleMessage(Message message) {
                    if (this.hpk.hoZ == -1) {
                        this.hpk.hoZ = Process.myTid();
                        v.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[]{Integer.valueOf(this.hpk.hoZ)});
                    }
                    if (message.what == 1) {
                        int length;
                        int i;
                        int i2;
                        n nVar;
                        byte[] bArr;
                        this.hpk.hoI.hos = true;
                        j jVar = this.hpk;
                        byte[] bArr2 = (byte[]) message.obj;
                        n nVar2;
                        if (jVar.hnC) {
                            nVar2 = jVar.hoJ;
                            length = bArr2.length;
                            int i3 = jVar.hoT;
                            i = jVar.hoU;
                            i2 = i3;
                            nVar = nVar2;
                            bArr = bArr2;
                        } else {
                            nVar2 = jVar.hoJ;
                            length = bArr2.length;
                            i = (jVar.hoV == 0 || jVar.hoV == 180) ? jVar.hoT : jVar.hoU;
                            if (jVar.hoV == 0 || jVar.hoV == 180) {
                                i2 = i;
                                nVar = nVar2;
                                i = jVar.hoU;
                                bArr = bArr2;
                            } else {
                                i2 = i;
                                nVar = nVar2;
                                i = jVar.hoT;
                                bArr = bArr2;
                            }
                        }
                        nVar.hnY = be.Nj();
                        if (nVar.hpP < 0) {
                            v.e("MicroMsg.MMSightX264YUVRecorder", "write data error, yuv buffer id error");
                        } else {
                            boolean z;
                            int i4;
                            int i5;
                            int i6;
                            boolean z2;
                            nVar.hpQ++;
                            int i7 = nVar.hpR;
                            boolean z3 = nVar.hnC;
                            if (z3) {
                                i7 = nVar.hpS == -1 ? nVar.hpR : nVar.hpS;
                            } else if (nVar.hpS == -1 || nVar.hpS == nVar.hpR) {
                                z = false;
                                i4 = i7;
                                SightVideoJNI.setRotateForBufId(nVar.hpP, i4);
                                i7 = z ? (i4 != 0 || i4 == 180) ? nVar.gVE : nVar.fQm : (i4 != 0 || i4 == 180) ? nVar.fQm : nVar.gVE;
                                i5 = z ? (i4 != 0 || i4 == 180) ? nVar.fQm : nVar.gVE : (i4 != 0 || i4 == 180) ? nVar.gVE : nVar.fQm;
                                i6 = z ? (i4 != 0 || i4 == 180) ? i2 : i : (i4 != 0 || i4 == 180) ? i : i2;
                                i4 = z ? (i4 != 0 || i4 == 180) ? i : i2 : (i4 != 0 || i4 == 180) ? i2 : i;
                                z2 = i6 == i7 || i4 != i5;
                                SightVideoJNI.writeYuvDataForMMSight(nVar.hpP, bArr, length, i7, i5, z, z2, i6, i4);
                                v.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(be.az(nVar.hnY))});
                            } else {
                                z3 = true;
                                i7 = nVar.hpS;
                                i7 = Math.max(0, nVar.hpR <= 180 ? i7 - nVar.hpR : i7 + (360 - nVar.hpR));
                                if (i7 >= 360) {
                                    i7 = 0;
                                } else {
                                    z = true;
                                    i4 = i7;
                                    SightVideoJNI.setRotateForBufId(nVar.hpP, i4);
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (z) {
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (i6 == i7) {
                                    }
                                    SightVideoJNI.writeYuvDataForMMSight(nVar.hpP, bArr, length, i7, i5, z, z2, i6, i4);
                                    v.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(be.az(nVar.hnY))});
                                }
                            }
                            z = z3;
                            i4 = i7;
                            SightVideoJNI.setRotateForBufId(nVar.hpP, i4);
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (z) {
                                if (i4 != 0) {
                                }
                            }
                            if (i6 == i7) {
                            }
                            SightVideoJNI.writeYuvDataForMMSight(nVar.hpP, bArr, length, i7, i5, z, z2, i6, i4);
                            v.d("MicroMsg.MMSightX264YUVRecorder", "write data use %dms", new Object[]{Long.valueOf(be.az(nVar.hnY))});
                        }
                        h.hoF.x(bArr2);
                        jVar.hpf = true;
                    }
                }
            };
            this.hpf = false;
            if (a != 0) {
                this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWK);
            } else {
                this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWL);
            }
            h.azW();
            v.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
            g.iuh.a(440, 1, 1, false);
            return a;
        }
    }

    public final int aAl() {
        return Math.round(((float) this.hoO) / 1000.0f);
    }

    public final Point aAm() {
        return new Point(this.hoT, this.hoU);
    }

    public final int aAn() {
        return this.hoV;
    }

    public final void pause() {
        v.i("MicroMsg.MMSightFFMpegRecorder", "pause");
        if (this.hoK != null && this.hoK.iXd == com.tencent.mm.plugin.sight.encode.a.b.b.iWE) {
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWM);
        }
    }

    public final void D(int i, int i2, int i3) {
        v.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.hoK != null && this.hoK.iXd == com.tencent.mm.plugin.sight.encode.a.b.b.iWM) {
            if (this.hoJ != null) {
                n nVar = this.hoJ;
                v.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                nVar.hpS = i;
                nVar.hpT = i2;
                nVar.hpU = i3;
            }
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWE);
        }
    }

    public final boolean aAo() {
        return this.hpf;
    }

    public final void a(com.tencent.mm.plugin.mmsight.model.a.c.a aVar) {
        this.hpi = aVar;
    }

    public final boolean azQ() {
        return this.hpg;
    }

    public final float aAh() {
        return this.hoP;
    }
}
