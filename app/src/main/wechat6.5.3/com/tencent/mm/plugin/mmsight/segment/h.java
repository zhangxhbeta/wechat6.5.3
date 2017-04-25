package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class h implements com.tencent.mm.plugin.mmsight.segment.f.a {
    private static int pRe = -1;
    int cdi;
    private int fQm;
    private int gVE;
    long hlp = -1;
    long hlq = -1;
    VideoTransPara hlv;
    private int hnZ;
    private int hoa;
    private int hqI;
    private int hqJ;
    a hqK;
    Thread hqL;
    private int hqM = 0;
    MediaExtractor hqN;
    int hqO;
    f hqP;
    private boolean hqQ = false;
    String hqy;
    private Object lock = new byte[0];

    private class a implements Runnable {
        int hpa;
        volatile int hpn;
        Object hpu;
        final /* synthetic */ h hqR;
        boolean hqS;

        private a(h hVar) {
            this.hqR = hVar;
            this.hpu = new Object();
        }

        public final void run() {
            if (this.hpa == -1) {
                this.hpa = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[]{Integer.valueOf(this.hpa)});
            }
            this.hpn = 0;
            synchronized (this.hpu) {
                long Nj;
                while (!this.hqS) {
                    Nj = be.Nj();
                    v.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                    int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.hpn), false);
                    v.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId())});
                    if (triggerEncodeForSegment == this.hpn) {
                        try {
                            Thread.sleep(20);
                        } catch (Exception e) {
                            v.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                        }
                    }
                    this.hpn = triggerEncodeForSegment;
                }
                Nj = be.Nj();
                this.hpn = MP4MuxerJNI.triggerEncodeForSegment(this.hpn, true);
                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[]{Long.valueOf(be.az(Nj)), Integer.valueOf(this.hpn), Long.valueOf(Thread.currentThread().getId())});
            }
        }
    }

    public static int aAO() {
        if (pRe != -1) {
            return pRe;
        }
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.t.a.ntJ, Integer.valueOf(-1))).intValue();
        int i = p.ceH.ceV;
        if (intValue != -1) {
            if (intValue == 1) {
                if (d.dW(21)) {
                    pRe = 2;
                } else {
                    pRe = 1;
                }
            } else if (intValue == 2) {
                pRe = 1;
            } else {
                pRe = 3;
            }
        } else if (!(i == -1 || i == 1)) {
            if (i == 2) {
                if (d.dW(21)) {
                    pRe = 2;
                } else {
                    pRe = 1;
                }
            } else if (i == 3) {
                pRe = 3;
            }
        }
        if (d.dW(be.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21))) {
            pRe = 1;
        } else {
            pRe = 3;
        }
        return pRe;
    }

    public final int e(MediaFormat mediaFormat) {
        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[]{mediaFormat, this.hqy});
        int aAO = aAO();
        if (aAO == 1) {
            this.hqP = new i(this.hqN, mediaFormat, this.hqO);
            this.hqQ = false;
        } else if (aAO == 2) {
            this.hqP = new j(this.hqN, mediaFormat, this.hqO);
            this.hqQ = false;
        } else {
            this.hqP = new b();
            this.hqQ = true;
        }
        if (this.hqP == null) {
            v.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.hqP = new i(this.hqN, mediaFormat, this.hqO);
            this.hqQ = false;
        }
        aAO = this.hqP.e(this.hqy, this.hlp, this.hlq);
        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[]{Integer.valueOf(aAO)});
        if (aAO < 0 && (pRe == 1 || pRe == 2)) {
            v.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.hqP.stop();
                this.hqP = null;
            } catch (Exception e) {
            }
            this.hqP = new b();
            this.hqQ = true;
            pRe = 3;
            aAO = this.hqP.e(this.hqy, this.hlp, this.hlq);
        }
        this.hqP.a(this);
        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[]{Integer.valueOf(aAO), Integer.valueOf(pRe)});
        return aAO;
    }

    public final void bR(int i, int i2) {
        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.hqI = i;
        this.hqJ = i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r7 = this;
        r2 = 1;
        r6 = -1;
        r5 = 0;
        r0 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r1 = "release, decoderType: %d";
        r2 = new java.lang.Object[r2];
        r3 = pRe;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r7.hqP;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r0 = r7.hqP;	 Catch:{ Exception -> 0x0025 }
        r0.stop();	 Catch:{ Exception -> 0x0025 }
    L_0x001f:
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        pRe = r6;
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        r1 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r2 = "release error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x003f }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x003f }
        r3[r4] = r0;	 Catch:{ all -> 0x003f }
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);	 Catch:{ all -> 0x003f }
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        pRe = r6;
        goto L_0x0024;
    L_0x003f:
        r0 = move-exception;
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        pRe = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.h.release():void");
    }

    public final void av(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            v.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            return;
        }
        int i;
        Point aAH = this.hqP.aAH();
        this.hnZ = aAH.x;
        this.hoa = aAH.y;
        if (this.gVE <= 0 || this.fQm <= 0) {
            int i2 = this.hnZ;
            int i3 = this.hoa;
            i = this.hqI;
            int i4 = this.hqJ;
            v.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i2 + "], decoderOutputHeight = [" + i3 + "], specWidth = [" + i + "], specHeight = [" + i4 + "]");
            if (i2 > i || i3 > i4) {
                int max = Math.max(i2, i3);
                int min = Math.min(i2, i3);
                int max2 = Math.max(i, i4);
                int min2 = Math.min(i, i4);
                if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                    v.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                    aAH = null;
                } else if (max / 2 == max2 && min / 2 == min2) {
                    v.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                    i = i2 / 2;
                    i4 = i3 / 2;
                    if (i % 2 != 0) {
                        i++;
                    }
                    if (i4 % 2 != 0) {
                        i4++;
                    }
                    aAH = new Point(i, i4);
                } else {
                    max /= 2;
                    min /= 2;
                    if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                        Point point = new Point();
                        if (i2 < i3) {
                            i4 = Math.min(i, i4);
                            i = (int) (((double) i3) / ((1.0d * ((double) i2)) / ((double) i4)));
                        } else {
                            i = Math.min(i, i4);
                            i4 = (int) (((double) i2) / ((((double) i3) * 1.0d) / ((double) i)));
                        }
                        if (i % 2 != 0) {
                            i++;
                        }
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i)});
                        point.x = i4;
                        point.y = i;
                        aAH = point;
                    } else {
                        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                        i = i2 / 2;
                        i4 = i3 / 2;
                        if (i % 2 != 0) {
                            i++;
                        }
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        aAH = new Point(i, i4);
                    }
                }
            } else {
                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
                aAH = null;
            }
            if (aAH != null) {
                this.gVE = aAH.x;
                this.fQm = aAH.y;
            } else {
                this.gVE = this.hnZ;
                this.fQm = this.hoa;
            }
            this.hqM = this.hqP.aAI();
            v.i("MicroMsg.MediaCodecFFMpegTranscoder", "initTargetWidth, srcSize:[%sx%s], dstSize:[%sx%s]", new Object[]{Integer.valueOf(this.hnZ), Integer.valueOf(this.hoa), Integer.valueOf(this.gVE), Integer.valueOf(this.fQm)});
        }
        long Nj = be.Nj();
        i = MP4MuxerJNI.writeYuvDataForSegment(bArr, this.hnZ, this.hoa, this.gVE, this.fQm, this.hqM);
        v.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        if (i < 0) {
            v.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[]{Integer.valueOf(i)});
        }
        if (this.hqK == null) {
            MP4MuxerJNI.initH264Encoder(this.gVE, this.fQm, (float) this.hlv.cdg, this.hlv.cGx, this.hlv.cGn, 8, this.hlv.cGm, 23.0f);
            this.hqK = new a();
            this.hqL = e.c(this.hqK, "MediaCodecFFMpegTranscoder_Encoder");
            this.hqL.start();
            v.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
    }
}
