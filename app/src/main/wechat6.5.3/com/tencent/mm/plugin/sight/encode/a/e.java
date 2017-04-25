package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e implements b {
    String eSI;
    f hoK;
    String hoN;
    private int hoO;
    private float hoP;
    private int hoQ;
    private int hoR;
    int hoS;
    a iWW;
    i iWX;
    a iWY;
    int iWZ;
    private PreviewCallback iXa;
    String mFileName;

    private class a implements Runnable {
        Runnable bpT;
        int duration;
        int hpm;
        int hpn;
        float hpo;
        boolean hpq;
        boolean hpr;
        boolean hps;
        boolean hpt;
        Object hpu;
        final /* synthetic */ e iXb;

        private a(e eVar) {
            this.iXb = eVar;
            this.hpn = 0;
            this.hpq = false;
            this.hpr = false;
            this.hps = false;
            this.hpt = false;
            this.hpu = new Object();
            this.bpT = null;
        }

        public final void run() {
            synchronized (this.hpu) {
                long Nj;
                be.Nj();
                long Nj2 = be.Nj();
                while (!this.hpr) {
                    Nj = be.Nj();
                    int triggerEncode = SightVideoJNI.triggerEncode(this.hpm, Math.max(0, this.hpn), false);
                    v.i("MicroMsg.SightCustomAsyncMediaRecorder", "ing: trgger encode use %dms, Encode index[%d, %d)", Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Integer.valueOf(triggerEncode));
                    if (this.hpn == 0 && triggerEncode > 0) {
                        String zz;
                        if (be.kS(this.iXb.eSI)) {
                            zz = d.zz(this.iXb.hoN);
                        } else {
                            k.KV();
                            zz = o.ld(this.iXb.mFileName);
                        }
                        g.a(SightVideoJNI.getThumbData(this.hpm), SightVideoJNI.getWidth(this.hpm), SightVideoJNI.getHeight(this.hpm), zz);
                    }
                    if (triggerEncode - this.hpn < 5) {
                        try {
                            Thread.sleep(200);
                        } catch (Throwable e) {
                            v.e("MicroMsg.SightCustomAsyncMediaRecorder", "sleep error %s", e.getMessage());
                            v.a("MicroMsg.SightCustomAsyncMediaRecorder", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    this.hpn = triggerEncode;
                }
                Nj = be.Nj();
                if (!this.hps) {
                    this.hpn = SightVideoJNI.triggerEncode(this.hpm, this.hpn, true);
                }
                v.i("MicroMsg.SightCustomAsyncMediaRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B", Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Boolean.valueOf(this.hps));
                long Nj3 = be.Nj();
                SightVideoJNI.releaseRecorderBufferRef("cancel");
                if (!this.hps) {
                    int muxing = SightVideoJNI.muxing(this.hpm, d.zA(this.iXb.hoN), b.aOO(), 1024, 2, 1, 0, this.iXb.hoN, this.hpo, Math.max(1000, this.duration), this.iXb.hoS, b.iTs, 8, 2, 23.0f, null, 0);
                    com.tencent.mm.loader.stub.b.deleteFile(d.zA(this.iXb.hoN));
                    float aQ = ((float) com.tencent.mm.a.e.aQ(this.iXb.hoN)) / 1024.0f;
                    v.i("MicroMsg.SightCustomAsyncMediaRecorder", "mux sight end, duration %ds, %s", Integer.valueOf(muxing), String.format("use %dms, sightFileSize %.2f KB", new Object[]{Long.valueOf(be.az(Nj2)), Float.valueOf(aQ)}));
                    d.zB(r3);
                }
                SightVideoJNI.releaseDataBufferRef(this.hpm);
                String str = "MicroMsg.SightCustomAsyncMediaRecorder";
                String str2 = "ashutest::mux main sigth end, use %dms, do callback null ? %B";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(be.az(Nj3));
                objArr[1] = Boolean.valueOf(this.bpT == null);
                v.i(str, str2, objArr);
                ad.o(this.bpT);
                this.hpt = true;
            }
        }
    }

    public e() {
        this.hoN = SQLiteDatabase.KeyEmpty;
        this.hoO = 0;
        this.hoP = 0.0f;
        this.hoQ = 320;
        this.hoR = 240;
        this.hoS = 400000;
        this.iWZ = 0;
        this.iXa = new PreviewCallback(this) {
            final /* synthetic */ e iXb;

            {
                this.iXb = r1;
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                if (this.iXb.iWZ % 20 == 0) {
                    String str = "MicroMsg.SightCustomAsyncMediaRecorder";
                    String str2 = "got 20 frame! mediaStatus %s, data NULL ? %B, dataLength %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = this.iXb.hoK.iXd;
                    objArr[1] = Boolean.valueOf(bArr == null);
                    objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    v.i(str, str2, objArr);
                }
                e eVar = this.iXb;
                eVar.iWZ++;
                if (bArr != null && bArr.length > 0 && this.iXb.hoK.iXd == b.b.Start) {
                    this.iXb.iWW.aPN();
                    i iVar = this.iXb.iWX;
                    int length = bArr.length;
                    int i = com.tencent.mm.pluginsdk.n.a.lFp;
                    int i2 = com.tencent.mm.pluginsdk.n.a.lFo;
                    iVar.hnY = be.Nj();
                    if (iVar.hpP < 0) {
                        v.e("MicroMsg.SightYUVRecorder", "write data error, yuv buffer id error");
                        return;
                    }
                    if (0 == iVar.ewI) {
                        iVar.ewI = be.Nj();
                    }
                    iVar.hpQ++;
                    SightVideoJNI.writeYuvData(iVar.hpP, bArr, length, i, i2);
                    v.d("MicroMsg.SightYUVRecorder", "write data use %dms", Long.valueOf(be.az(iVar.hnY)));
                }
            }
        };
        this.hoQ = 320;
        this.hoR = 240;
        this.hoS = 400000;
        this.iWX = new i();
        this.hoK = new f();
        if (d.aOS()) {
            this.iWW = new d();
        } else {
            this.iWW = new c();
        }
    }

    public final void initialize(int i) {
        String str = "MicroMsg.SightCustomAsyncMediaRecorder";
        String str2 = "initialize: talker[%s], encodeThread null[%B], encodeThreadFinish[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.eSI;
        objArr[1] = Boolean.valueOf(this.iWY == null);
        objArr[2] = Boolean.valueOf(this.iWY == null ? true : this.iWY.hpt);
        v.i(str, str2, objArr);
        if (this.iWY == null || this.iWY.hpt) {
            if (be.kS(this.eSI)) {
                this.hoN = d.aOQ();
            } else {
                k.KV();
                this.hoN = o.lc(this.mFileName);
            }
            CameraInfo cameraInfo = new CameraInfo();
            Object obj = null;
            try {
                Camera.getCameraInfo(i, cameraInfo);
            } catch (Throwable th) {
                v.a("MicroMsg.SightCustomAsyncMediaRecorder", th, "getCameraInfo failed.", new Object[0]);
                obj = 1;
            }
            int i2 = 90;
            if (obj == null && cameraInfo.orientation == 270) {
                i2 = 270;
            }
            final int initDataBufferRef = SightVideoJNI.initDataBufferRef(com.tencent.mm.pluginsdk.n.a.lFp, com.tencent.mm.pluginsdk.n.a.lFo, i2, com.tencent.mm.pluginsdk.n.a.lFo, (com.tencent.mm.pluginsdk.n.a.lFo * this.hoR) / this.hoQ, this.hoQ, this.hoR, 24.0f, this.hoS, b.iTs, 8, 2, 23.0f, 1);
            i iVar = this.iWX;
            if (initDataBufferRef < 0) {
                v.e("MicroMsg.SightYUVRecorder", "init error, yuv buffer id error");
            } else {
                iVar.hpP = initDataBufferRef;
                iVar.hpQ = 0;
                iVar.ewI = 0;
            }
            if (this.iWW.aa(initDataBufferRef, d.zA(this.hoN)) < 0) {
                v.e("MicroMsg.SightCustomAsyncMediaRecorder", "init aac encoder error, is MediaCodec Type ? %B", Boolean.valueOf(this.iWW instanceof d));
                if (this.iWW instanceof d) {
                    this.iWW = new c();
                    this.iWW.aa(initDataBufferRef, d.zA(this.hoN));
                }
            }
            if (this.iWW.a(new com.tencent.mm.plugin.sight.encode.a.a.a(this) {
                final /* synthetic */ e iXb;

                public final void aAu() {
                    v.i("MicroMsg.SightCustomAsyncMediaRecorder", "ashutest::pcm ready");
                    if (!(this.iXb.iWY == null || this.iXb.iWY.hpt)) {
                        v.e("MicroMsg.SightCustomAsyncMediaRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", this.iXb.iWY);
                        this.iXb.na(this.iXb.iWY.hpm);
                    }
                    if (this.iXb.hoK.iXd != b.b.Initialized) {
                        v.w("MicroMsg.SightCustomAsyncMediaRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
                    } else if (this.iXb.iWW.aPM() != initDataBufferRef) {
                        v.w("MicroMsg.SightCustomAsyncMediaRecorder", "ashutest::error bufferID, return!!!! %d vs %s", Integer.valueOf(this.iXb.iWW.aPM()), Integer.valueOf(initDataBufferRef));
                    } else {
                        this.iXb.hoK.b(b.b.Start);
                        this.iXb.iWY = new a();
                        this.iXb.iWY.hpm = initDataBufferRef;
                        com.tencent.mm.sdk.i.e.a(this.iXb.iWY, "SightCustomAsyncMediaRecorder_encode_" + be.Nj());
                    }
                }
            }) != 0) {
                this.hoK.b(b.b.Error);
                return;
            } else {
                this.hoK.b(b.b.Initialized);
                return;
            }
        }
        v.w("MicroMsg.SightCustomAsyncMediaRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
    }

    final boolean na(int i) {
        if (this.iWY == null || this.iWY.hpt) {
            return false;
        }
        if (!this.iWY.hpq) {
            this.iWY.bpT = null;
            this.iWY.hps = true;
            this.iWY.hpr = true;
            com.tencent.mm.sdk.i.e.remove(this.iWY);
        }
        synchronized (this.iWY.hpu) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseDataBufferRef(i);
            if (this.iWY.hpm != i) {
                SightVideoJNI.releaseDataBufferRef(this.iWY.hpm);
            }
        }
        return true;
    }

    private void clear() {
        boolean z = false;
        int i = this.iWX.hpP;
        if (i < 0) {
            v.v("MicroMsg.SightCustomAsyncMediaRecorder", "call clear, but bufID error");
            return;
        }
        boolean z2;
        this.iWX.stop();
        this.iWW.a(null);
        String str = "MicroMsg.SightCustomAsyncMediaRecorder";
        String str2 = "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        if (this.iWY == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        if (this.iWY != null) {
            z = this.iWY.hps;
        }
        objArr[2] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
        if (!na(i)) {
            SightVideoJNI.releaseRecorderBufferRef("clear");
            SightVideoJNI.releaseDataBufferRef(i);
        }
    }

    public final void cancel() {
        v.i("MicroMsg.SightCustomAsyncMediaRecorder", "ashutest::cancel");
        clear();
        this.hoK.b(b.b.Stop);
    }

    public final void s(Runnable runnable) {
        boolean z;
        String str = "MicroMsg.SightCustomAsyncMediaRecorder";
        String str2 = "ashutest::stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.iWY == null);
        if (this.iWY == null) {
            z = false;
        } else {
            z = this.iWY.hpq;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.iWY == null) {
            z = false;
        } else {
            z = this.iWY.hpr;
        }
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (this.iWY == null || !this.iWY.hpq) {
            int i = this.iWX.hpP;
            float aAC = (((float) this.iWX.hpQ) * 1000.0f) / ((float) this.iWX.aAC());
            v.i("MicroMsg.SightCustomAsyncMediaRecorder", "on mux main sight stop, bufID %d, frameCount %d, duration %dms, %.6ffps", Integer.valueOf(i), Integer.valueOf(this.iWX.hpQ), Long.valueOf(this.iWX.aAC()), Float.valueOf(aAC));
            this.hoO = (int) this.iWX.aAC();
            this.hoP = aAC;
            this.iWX.stop();
            this.iWW.a(new a.b(this) {
                final /* synthetic */ e iXb;

                {
                    this.iXb = r1;
                }

                public final void aAv() {
                    if (this.iXb.iWY != null) {
                        this.iXb.iWY.hpr = true;
                    }
                }
            });
            if (this.iWY != null) {
                this.iWY.hpo = aAC;
                this.iWY.duration = this.hoO;
                this.iWY.bpT = runnable;
                this.iWY.hpq = true;
                com.tencent.mm.sdk.i.e.remove(this.iWY);
            }
            if (b.b.WaitSend != this.hoK.iXd) {
                this.hoK.b(b.b.Stop);
                return;
            }
            return;
        }
        synchronized (this.iWY.hpu) {
            ad.o(runnable);
        }
    }

    public final b.b aAk() {
        return this.hoK.iXd;
    }

    public final long aPP() {
        return this.iWX.aAC();
    }

    public final PreviewCallback aPS() {
        return this.iXa;
    }

    public final void cv(String str, String str2) {
        this.eSI = str;
        this.mFileName = str2;
    }

    public final boolean aPO() {
        this.hoK.b(b.b.WaitSend);
        return false;
    }

    public final void reset() {
        v.i("MicroMsg.SightCustomAsyncMediaRecorder", "reset");
        this.hoK.iXd = b.b.Stop;
        clear();
    }

    public final String aPR() {
        return this.hoN;
    }

    public final void a(com.tencent.mm.plugin.sight.encode.a.b.a aVar) {
        f fVar = this.hoK;
        String str = "MicroMsg.SightMediaStatusHandler";
        String str2 = "add media status callback, hashcode %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(aVar == null ? 0 : aVar.hashCode());
        v.i(str, str2, objArr);
        fVar.iXf.sendMessage(fVar.iXf.obtainMessage(258, aVar));
    }

    public final void b(com.tencent.mm.plugin.sight.encode.a.b.a aVar) {
        f fVar = this.hoK;
        String str = "MicroMsg.SightMediaStatusHandler";
        String str2 = "remove media status callback, hashcode %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(aVar == null ? 0 : aVar.hashCode());
        v.i(str, str2, objArr);
        fVar.iXf.sendMessage(fVar.iXf.obtainMessage(259, aVar));
    }

    public final void aPQ() {
        v.i("MicroMsg.SightCustomAsyncMediaRecorder", "request start, last status %s", this.hoK.iXd);
        this.hoO = 0;
        this.hoK.b(b.b.WaitStart);
    }

    public final int getDuration() {
        return this.hoO / 1000;
    }

    public final int getFrameCount() {
        if (this.iWX != null) {
            return this.iWX.hpQ;
        }
        return 0;
    }

    public final float aAh() {
        return this.hoP;
    }

    public final void a(b.b bVar) {
        this.hoK.b(bVar);
    }
}
