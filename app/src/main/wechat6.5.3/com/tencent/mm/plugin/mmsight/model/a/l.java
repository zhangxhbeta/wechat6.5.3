package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.encode.a.f;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l implements c {
    private static boolean hpF = false;
    private String aZy = "";
    private String bdZ = null;
    private boolean clD = false;
    private Point hmG = null;
    private VideoTransPara hnB;
    private boolean hnC = false;
    f hoK;
    private String hoN = "";
    private int hoO = 0;
    private float hoP = 0.0f;
    private int hoQ = 480;
    private int hoR = 640;
    private int hoS = 1600000;
    private int hoT = 480;
    private int hoU = 640;
    private int hoV;
    private String hoW = null;
    private int hoh;
    private o hpA;
    private k hpB;
    private HandlerThread hpC;
    private ac hpD;
    private int hpE = 0;
    private com.tencent.mm.pluginsdk.j.f hpG = new com.tencent.mm.pluginsdk.j.f("yuvRecorderWriteData");
    private com.tencent.mm.pluginsdk.j.f hpH = new com.tencent.mm.pluginsdk.j.f("frameCountCallback");
    private Runnable hpI = null;
    private String hpb = null;
    private boolean hpc = false;
    private boolean hpd = false;
    private boolean hpf = false;
    private boolean hpg = false;
    private int hph = 0;
    private a hpi;
    private b hpj = new b(this) {
        final /* synthetic */ l hpJ;

        {
            this.hpJ = r1;
        }

        public final boolean au(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (this.hpJ.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWE && this.hpJ.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWF) {
                return false;
            }
            if (this.hpJ.hoK.iXd == com.tencent.mm.plugin.sight.encode.a.b.b.iWF) {
                this.hpJ.hoK.iXd = com.tencent.mm.plugin.sight.encode.a.b.b.iWG;
                v.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
            }
            this.hpJ.hpH.dO(1);
            if (this.hpJ.hpz != null) {
                this.hpJ.hpz.hos = true;
            }
            if (this.hpJ.hpA != null) {
                v.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "getExactSize used %sms", new Object[]{Long.valueOf(be.az(be.Nj()))});
                v.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "arraycopy used %sms", new Object[]{Long.valueOf(be.az(be.Nj()))});
                if (be.az(be.Nj()) > 10) {
                    this.hpJ.hpE = this.hpJ.hpE + 1;
                    v.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "arraycopy use too long!");
                    if (this.hpJ.hpE > 3) {
                        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!switch to main thread!!");
                        l.hpF = true;
                    }
                } else {
                    this.hpJ.hpE = 0;
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = bArr;
                if (this.hpJ.hpD != null) {
                    this.hpJ.hpD.sendMessage(obtain);
                }
            }
            return true;
        }
    };
    private f hpz;
    private String mFileName;

    static /* synthetic */ void a(l lVar, byte[] bArr) {
        if (lVar.hpA != null) {
            int i;
            boolean z;
            int i2;
            int i3;
            int i4;
            boolean z2;
            boolean z3;
            b bVar;
            a aVar;
            Looper looper;
            b.a aVar2;
            final Object obj;
            lVar.hpG.dO(1);
            long Nj = be.Nj();
            p pVar = lVar.hpA;
            int i5 = lVar.hoT;
            int i6 = lVar.hoU;
            be.Nj();
            int i7 = pVar.hpR;
            boolean z4 = pVar.hnC;
            if (z4) {
                i = pVar.hpS == -1 ? pVar.hpR : pVar.hpS;
            } else if (pVar.hpS == -1 || pVar.hpS == pVar.hpR) {
                z = false;
                i2 = (pVar.hpS != -1 || pVar.hpS == pVar.hpR) ? pVar.hpR : pVar.hpS;
                i3 = (i2 != 0 || i2 == 180) ? i5 : i6;
                i4 = (i2 != 0 || i2 == 180) ? i6 : i5;
                z2 = i3 == pVar.gVE || i4 != pVar.fQm;
                z3 = (pVar.hpT != -1 || pVar.hpU == -1 || (pVar.hpT == pVar.gVE && pVar.hpU == pVar.fQm)) ? z2 : true;
                v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(pVar.hnC), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                bVar = new b(i3, i4, pVar.hob, pVar.gVE, pVar.fQm, z3, z, i7, bArr);
                aVar = pVar.hpV;
                if (!aVar.ecS) {
                    if (aVar.handler == null) {
                        aVar.handler = new ac(Looper.myLooper());
                    }
                    i4 = aVar.hnM % a.hnK;
                    if (aVar.hnL[i4] != null) {
                        i5 = aVar.hnM;
                        looper = aVar.hnL[i4].getLooper();
                        aVar2 = aVar.hnQ;
                        bVar.hnX = i5;
                        bVar.hoc = i4;
                        bVar.hnY = be.Nj();
                        v.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.hnU.length), Integer.valueOf(bVar.hnX)});
                        new ac(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                        aVar.hnM++;
                    }
                }
                v.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(be.az(Nj))});
                if (!lVar.hpd) {
                    lVar.hpd = true;
                    obj = new byte[bArr.length];
                    System.arraycopy(bArr, 0, obj, 0, bArr.length);
                    e.a(new Runnable(lVar) {
                        final /* synthetic */ l hpJ;

                        public final void run() {
                            l.b(this.hpJ, obj);
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                }
                lVar.hpf = true;
            } else {
                z4 = true;
                i = pVar.hpS;
                i7 = Math.max(0, pVar.hpR <= 180 ? i - pVar.hpR : i + (360 - pVar.hpR));
                if (i7 >= 360) {
                    i = 0;
                } else {
                    z = true;
                    if (pVar.hpS != -1) {
                    }
                    if (i2 != 0) {
                    }
                    if (i2 != 0) {
                    }
                    if (i3 == pVar.gVE) {
                    }
                    if (pVar.hpT != -1) {
                    }
                    v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(pVar.hnC), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
                    bVar = new b(i3, i4, pVar.hob, pVar.gVE, pVar.fQm, z3, z, i7, bArr);
                    aVar = pVar.hpV;
                    if (aVar.ecS) {
                        if (aVar.handler == null) {
                            aVar.handler = new ac(Looper.myLooper());
                        }
                        i4 = aVar.hnM % a.hnK;
                        if (aVar.hnL[i4] != null) {
                            i5 = aVar.hnM;
                            looper = aVar.hnL[i4].getLooper();
                            aVar2 = aVar.hnQ;
                            bVar.hnX = i5;
                            bVar.hoc = i4;
                            bVar.hnY = be.Nj();
                            v.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.hnU.length), Integer.valueOf(bVar.hnX)});
                            new ac(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                            aVar.hnM++;
                        }
                    }
                    v.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(be.az(Nj))});
                    if (lVar.hpd) {
                        lVar.hpd = true;
                        obj = new byte[bArr.length];
                        System.arraycopy(bArr, 0, obj, 0, bArr.length);
                        e.a(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                    }
                    lVar.hpf = true;
                }
            }
            z = z4;
            i7 = i;
            if (pVar.hpS != -1) {
            }
            if (i2 != 0) {
            }
            if (i2 != 0) {
            }
            if (i3 == pVar.gVE) {
            }
            if (pVar.hpT != -1) {
            }
            v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", new Object[]{Boolean.valueOf(pVar.hnC), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2)});
            bVar = new b(i3, i4, pVar.hob, pVar.gVE, pVar.fQm, z3, z, i7, bArr);
            aVar = pVar.hpV;
            if (aVar.ecS) {
                if (aVar.handler == null) {
                    aVar.handler = new ac(Looper.myLooper());
                }
                i4 = aVar.hnM % a.hnK;
                if (aVar.hnL[i4] != null) {
                    i5 = aVar.hnM;
                    looper = aVar.hnL[i4].getLooper();
                    aVar2 = aVar.hnQ;
                    bVar.hnX = i5;
                    bVar.hoc = i4;
                    bVar.hnY = be.Nj();
                    v.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", new Object[]{Integer.valueOf(bVar.hnU.length), Integer.valueOf(bVar.hnX)});
                    new ac(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(bVar, aVar2));
                    aVar.hnM++;
                }
            }
            v.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", new Object[]{Long.valueOf(be.az(Nj))});
            if (lVar.hpd) {
                lVar.hpd = true;
                obj = new byte[bArr.length];
                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                e.a(/* anonymous class already generated */, "BigSightMediaCodecMP4MuxRecorder_saveThumb");
            }
            lVar.hpf = true;
        }
    }

    static /* synthetic */ void b(l lVar, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (be.kS(lVar.bdZ)) {
                        v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        lVar.hpd = false;
                        return;
                    }
                    int i;
                    Bitmap b;
                    int i2 = (lVar.hoV == 0 || lVar.hoV == 180) ? lVar.hoT : lVar.hoU;
                    int i3 = (lVar.hoV == 0 || lVar.hoV == 180) ? lVar.hoU : lVar.hoT;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
                    Rect rect = new Rect(0, 0, i2, i3);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (lVar.hnB != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > lVar.hnB.width) {
                        int i4;
                        i2 = decodeByteArray.getWidth();
                        i3 = decodeByteArray.getHeight();
                        if (i2 < i3) {
                            i4 = lVar.hnB.width;
                            i = (int) (((float) i3) / ((((float) i2) * 1.0f) / ((float) i4)));
                        } else {
                            i = lVar.hnB.width;
                            i4 = (int) (((float) i2) / ((((float) i3) * 1.0f) / ((float) i)));
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i4, i, true);
                    }
                    if (!lVar.hpg || lVar.hph == 180) {
                        i = lVar.hoV;
                        if (lVar.hph == 180) {
                            i += 180;
                            if (i > 360) {
                                i -= 360;
                            }
                        }
                        b = d.b(decodeByteArray, (float) i);
                    } else if (Math.abs(lVar.hoV - lVar.hph) == 0) {
                        b = d.b(decodeByteArray, 180.0f);
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    d.a(b, 60, CompressFormat.JPEG, lVar.bdZ, true);
                    v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", new Object[]{lVar.bdZ, Integer.valueOf(lVar.hoV), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(FileOp.jP(lVar.bdZ))});
                    return;
                }
            } catch (Exception e) {
                v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                lVar.hpd = false;
                return;
            }
        }
        v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        lVar.hpd = false;
    }

    public l(VideoTransPara videoTransPara) {
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
        v.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, defaultRate: %s", new Object[]{Integer.valueOf(this.hoQ), Integer.valueOf(this.hoR), Integer.valueOf(this.hoS), Integer.valueOf(aAx)});
    }

    private boolean nb(int i) {
        long Nj = be.Nj();
        this.hnC = g.hns.hnC;
        this.hoh = SightVideoJNI.initDataBufferForMMSight(this.hoT, this.hoU, i, this.hoQ, this.hoR, (float) this.hnB.cdg, this.hoS, this.hnB.cGn, 8, this.hnB.cGm, 23.0f, false, false, this.hnB.duration);
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[]{Integer.valueOf(this.hoh)});
        if (this.hoh < 0) {
            v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            h.azY();
            return false;
        }
        this.hoV = i;
        this.hpA = new o(this.hoT, this.hoU, this.hoQ, this.hoR, this.hoS, this.hnB.cGl, this.hnB.cdg, this.hnC);
        this.hpz = new f(this.hnB.audioSampleRate, this.hnB.cGk);
        int bQ = this.hpA.bQ(this.hoh, i);
        int mZ = this.hpz.mZ(this.hoh);
        if (bQ < 0 || mZ < 0) {
            v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[]{Integer.valueOf(bQ), Integer.valueOf(mZ)});
            SightVideoJNI.releaseBigSightDataBuffer(this.hoh);
            h.azY();
            return false;
        }
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        return true;
    }

    public final boolean mY(int i) {
        if (this.clD) {
            return true;
        }
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean nb = nb(i);
        this.clD = true;
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[]{Boolean.valueOf(nb)});
        return nb;
    }

    public final int b(int i, boolean z, int i2) {
        int i3 = -1;
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        this.hpG.reset();
        this.hoO = 0;
        this.hpH.reset();
        this.hpd = false;
        this.hpg = z;
        this.hph = i2;
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWD);
        if (be.kS(this.hoN)) {
            v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
        } else {
            try {
                this.mFileName = com.tencent.mm.a.e.aT(this.hoN);
                String jR = FileOp.jR(this.hoN);
                if (!jR.endsWith("/")) {
                    jR = jR + "/";
                }
                this.hoW = jR + "tempRotate.mp4";
            } catch (Exception e) {
                v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[]{e.getMessage()});
            }
            v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[]{this.hoN, this.hoW});
            this.hoV = i;
            this.hpC = e.bJ("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.hpC.start();
            this.hpD = new ac(this, this.hpC.getLooper()) {
                final /* synthetic */ l hpJ;

                public final void handleMessage(Message message) {
                    if (message.what == 1) {
                        l.a(this.hpJ, (byte[]) message.obj);
                    }
                }
            };
            if (!this.clD) {
                nb(i);
                this.clD = true;
            }
            i3 = this.hpz.a(new a(this) {
                final /* synthetic */ l hpJ;

                {
                    this.hpJ = r1;
                }

                public final void aAu() {
                    v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
                    if (this.hpJ.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWL) {
                        v.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        return;
                    }
                    p d = this.hpJ.hpA;
                    v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Start");
                    d.bhY = true;
                    d.startTime = System.currentTimeMillis();
                    this.hpJ.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWE);
                }
            });
            v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[]{Integer.valueOf(i3)});
            this.hpf = false;
            if (i3 != 0) {
                this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWK);
            } else {
                this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWL);
            }
            h.azW();
            v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
            com.tencent.mm.plugin.report.service.g.iuh.a(440, 2, 1, false);
        }
        return i3;
    }

    public final void s(Runnable runnable) {
        this.hpI = runnable;
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[]{runnable});
        if (this.hpA == null || this.hpz == null) {
            v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                ad.o(runnable);
            }
        } else if (this.hoK == null || this.hoK.iXd != com.tencent.mm.plugin.sight.encode.a.b.b.iWH) {
            this.hpj = null;
            this.hoO = (int) this.hpA.aAC();
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWF);
            this.hpA.a(new e.a(this) {
                final /* synthetic */ l hpJ;

                {
                    this.hpJ = r1;
                }

                public final void aAr() {
                    e.a(new Runnable(this.hpJ) {
                        final /* synthetic */ l hpJ;

                        {
                            this.hpJ = r1;
                        }

                        public final void run() {
                            v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", new Object[]{Boolean.valueOf(this.hpJ.aAB())});
                            if (!this.hpJ.aAB()) {
                                SightVideoJNI.releaseBigSightDataBuffer(this.hpJ.hoh);
                                if (this.hpJ.hpi != null) {
                                    ad.o(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass6 hpK;

                                        {
                                            this.hpK = r1;
                                        }

                                        public final void run() {
                                            this.hpK.hpJ.hpi.aAp();
                                        }
                                    });
                                }
                            } else if (this.hpJ.hpI != null) {
                                v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                                ad.o(this.hpJ.hpI);
                            }
                        }
                    }, "MMSightMediaCodecMP4MuxRecorder_stop");
                }
            });
            this.hpz.a(new b(this) {
                final /* synthetic */ l hpJ;

                {
                    this.hpJ = r1;
                }

                public final void aAv() {
                    v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                }
            });
        } else {
            v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.hpz != null) {
                this.hpz.clear();
            }
            if (this.hpA != null) {
                this.hpA.clear();
            }
            if (runnable != null) {
                ad.o(runnable);
            }
        }
    }

    private boolean aAB() {
        long Nj = be.Nj();
        if (!(this.hpC == null || this.hpD == null)) {
            if (com.tencent.mm.compatible.util.d.dW(18)) {
                this.hpC.quitSafely();
            } else {
                this.hpC.quit();
            }
            this.hpD = null;
        }
        this.hoP = (((float) this.hpA.hpQ) * 1000.0f) / ((float) this.hoO);
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s", new Object[]{Integer.valueOf(r2), Float.valueOf(this.hoP), Integer.valueOf(this.hoO), this.hoN, Long.valueOf(be.az(Nj))});
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[]{this.hpH.getValue()});
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[]{this.hpG.getValue()});
        this.hpB = new k(this.hoh, this.hoN, this.hoP, this.hoS, this.hoO, this.hnB.audioSampleRate);
        Nj = be.Nj();
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[]{Long.valueOf(be.az(Nj)), Boolean.valueOf(this.hpB.aAq())});
        if (this.hpB.aAq()) {
            if ((this.hpg && this.hnC) || (!(this.hnC || this.hpg) || ((this.hpg && Math.abs(this.hoV - this.hph) == 0) || this.hph == 180))) {
                long Nj2 = be.Nj();
                int i = (this.hnC || this.hpg) ? this.hnC ? this.hph : 180 : this.hoV;
                if (this.hph == 180 && !this.hnC) {
                    i += 180;
                    if (i > 360) {
                        i -= 360;
                    }
                }
                SightVideoJNI.tagRotateVideo(this.hoN, this.hoW, i);
                this.hpc = true;
                v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[]{Long.valueOf(be.az(Nj2)), Integer.valueOf(this.hoV), Boolean.valueOf(this.hpg), Integer.valueOf(this.hph), Integer.valueOf(i)});
                Nj = be.Nj();
                try {
                    FileOp.deleteFile(this.hoN);
                    FileOp.ab(this.hoW, this.hoN);
                    v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[]{Long.valueOf(be.az(Nj))});
                    final String str = this.hoW;
                    e.a(new Runnable(this) {
                        final /* synthetic */ l hpJ;

                        public final void run() {
                            try {
                                FileOp.deleteFile(str);
                            } catch (Exception e) {
                                v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
                            }
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e) {
                    v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    return false;
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.hoh);
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWH);
            this.aZy = com.tencent.mm.b.g.aX(this.hoW);
            return true;
        }
        v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        com.tencent.mm.plugin.report.service.g.iuh.a(440, 31, 1, false);
        return false;
    }

    public final String EB() {
        return be.ah(this.aZy, "");
    }

    public final void cancel() {
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.hpA == null || this.hpz == null) {
            v.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            return;
        }
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWG);
        this.hpA.a(null);
        this.hpz.a(new b(this) {
            final /* synthetic */ l hpJ;

            {
                this.hpJ = r1;
            }

            public final void aAv() {
                v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
            }
        });
        if (!(this.hpC == null || this.hpD == null)) {
            this.hpD.removeMessages(0);
            this.hpC.quit();
            this.hpD = null;
        }
        SightVideoJNI.releaseBigSightDataBuffer(this.hoh);
        this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWH);
        reset();
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

    public final String OZ() {
        return this.hoN;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float aAh() {
        return this.hoP;
    }

    public final void reset() {
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[]{this.hpA, this.hpz, this.hpB});
        this.hpA = null;
        this.hpz = null;
        this.hpB = null;
        this.clD = false;
        this.hpf = false;
    }

    public final long aAi() {
        if (this.hpA != null) {
            return this.hpA.aAC();
        }
        return 0;
    }

    public final b aAj() {
        return this.hpj;
    }

    public final void i(int i, int i2, int i3, int i4) {
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.hoQ = i3;
        this.hoR = i4;
        this.hoT = i;
        this.hoU = i2;
        if (h.hoF.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            h.bP(i, i2);
        }
    }

    public final com.tencent.mm.plugin.sight.encode.a.b.b aAk() {
        return this.hoK.iXd;
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
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.hoK != null && this.hoK.iXd == com.tencent.mm.plugin.sight.encode.a.b.b.iWE) {
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWM);
        }
    }

    public final void D(int i, int i2, int i3) {
        v.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[]{Integer.valueOf(i)});
        if (this.hoK != null && this.hoK.iXd == com.tencent.mm.plugin.sight.encode.a.b.b.iWM) {
            if (this.hpA != null) {
                p pVar = this.hpA;
                pVar.hpS = i;
                pVar.hpT = i2;
                pVar.hpU = i3;
                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            this.hoK.b(com.tencent.mm.plugin.sight.encode.a.b.b.iWE);
        }
    }

    public final boolean aAo() {
        return this.hpf;
    }

    public final void a(a aVar) {
        this.hpi = aVar;
    }

    public final boolean azQ() {
        return this.hpg;
    }
}
