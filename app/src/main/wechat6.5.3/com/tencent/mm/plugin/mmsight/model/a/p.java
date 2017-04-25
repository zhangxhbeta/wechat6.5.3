package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.e.a;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.nio.ByteBuffer;

@TargetApi(16)
public class p implements e {
    boolean bhY = false;
    int fQm;
    int gVE;
    boolean hnC = false;
    int hob;
    protected MediaCodec hoi;
    private int hor = -1;
    private m hou;
    int hpQ;
    int hpR = -1;
    int hpS = -1;
    int hpT = -1;
    int hpU = -1;
    a hpV = new a(this.hqj);
    private int hpW;
    private int hpX;
    protected MediaFormat hpY;
    private long hpZ = 0;
    private int hpx = 0;
    private ByteBuffer[] hqa;
    private ByteBuffer[] hqb;
    private int hqc = -1;
    private BufferInfo hqd;
    boolean hqe = false;
    private boolean hqf = false;
    private int hqg;
    private int hqh;
    a hqi;
    private a.a hqj = new a.a(this) {
        final /* synthetic */ p hqk;

        {
            this.hqk = r1;
        }

        public final void output(byte[] bArr) {
            long Nj = be.Nj();
            boolean aAf = this.hqk.hpV.aAf();
            p pVar = this.hqk;
            boolean z = aAf && this.hqk.hqe;
            pVar.c(bArr, z);
            h.hoF.x(bArr);
            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "markStop: %s isEnd %s costTime %d", new Object[]{Boolean.valueOf(this.hqk.hqe), Boolean.valueOf(aAf), Long.valueOf(be.az(Nj))});
            if (aAf && this.hqk.hqe) {
                this.hqk.aAE();
            }
        }
    };
    long startTime = 0;

    public p(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.hpW = i;
        this.hpX = i2;
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.gVE = i3;
        this.fQm = i4;
        this.hqh = i7;
        this.hqg = i6;
        this.hou = null;
        this.hqd = new BufferInfo();
        this.hpx = i5;
        this.hnC = z;
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[]{Integer.valueOf(this.hpW), Integer.valueOf(this.hpX), Integer.valueOf(this.gVE), Integer.valueOf(this.fQm), Integer.valueOf(i5), Boolean.valueOf(z), null});
    }

    public int bQ(int i, int i2) {
        int i3 = -1;
        try {
            this.hpR = i2;
            i3 = aAD();
        } catch (Exception e) {
            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                CaptureMMProxy.getInstance().set(t.a.ntM, Integer.valueOf(-1));
                i3 = aAD();
            } catch (Exception e2) {
                v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "re-init again error: %s", new Object[]{e2.getMessage()});
                h.azZ();
            }
        }
        return i3;
    }

    private int aAD() {
        int intValue;
        MediaCodecInfo mediaCodecInfo;
        long Nj = be.Nj();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Unable to find an appropriate codec for video/avc");
            h.azZ();
            return -1;
        }
        long Nj2;
        int i2;
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(be.az(Nj))});
        Nj = be.Nj();
        intValue = ((Integer) CaptureMMProxy.getInstance().get(t.a.ntM, Integer.valueOf(-1))).intValue();
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "saveColorFormat: %s", new Object[]{Integer.valueOf(intValue)});
        if (intValue <= 0) {
            intValue = 0;
            Nj2 = be.Nj();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(be.az(Nj2))});
            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
            for (int i3 : capabilitiesForType.colorFormats) {
                Object obj;
                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i3)});
                switch (i3) {
                    case 19:
                    case 21:
                    case 2130706688:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null && (i3 > intValue || i3 == 21)) {
                    intValue = i3;
                }
            }
            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(intValue)});
        }
        this.hob = intValue;
        long az = be.az(Nj);
        if (this.hob > 0 && az > 200) {
            CaptureMMProxy.getInstance().set(t.a.ntM, Integer.valueOf(this.hob));
        }
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.hob), Long.valueOf(az)});
        Nj2 = be.Nj();
        String str2;
        if (this.hnC) {
            str2 = "video/avc";
            intValue = (this.hpR == 180 || this.hpR == 0) ? this.gVE : this.fQm;
            i2 = (this.hpR == 180 || this.hpR == 0) ? this.fQm : this.gVE;
            this.hpY = MediaFormat.createVideoFormat(str2, intValue, i2);
        } else {
            str2 = "video/avc";
            intValue = (this.hpR == 180 || this.hpR == 0) ? this.fQm : this.gVE;
            i2 = (this.hpR == 180 || this.hpR == 0) ? this.gVE : this.fQm;
            this.hpY = MediaFormat.createVideoFormat(str2, intValue, i2);
        }
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "createVideoFormat used %sms", new Object[]{Long.valueOf(be.az(Nj2))});
        if (mediaCodecInfo != null) {
            CodecCapabilities capabilitiesForType2;
            if (d.dW(23)) {
                try {
                    capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                Object obj2;
                                int i4 = codecProfileLevel2.profile;
                                int i5 = codecProfileLevel2.level;
                                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                                switch (i4) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj2 = 1;
                                        break;
                                    default:
                                        obj2 = null;
                                        break;
                                }
                                if (obj2 != null && i4 >= codecProfileLevel.profile && i5 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i4;
                                    codecProfileLevel.level = i5;
                                }
                            }
                            v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.hpY.setInteger("profile", codecProfileLevel.profile);
                                this.hpY.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                }
            }
            try {
                if (d.dW(21)) {
                    capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        EncoderCapabilities encoderCapabilities = capabilitiesForType2.getEncoderCapabilities();
                        if (encoderCapabilities != null) {
                            if (encoderCapabilities.isBitrateModeSupported(2)) {
                                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "support cbr bitrate mode");
                                this.hpY.setInteger("bitrate-mode", 2);
                            } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "support cq bitrate mode");
                                this.hpY.setInteger("bitrate-mode", 0);
                            } else {
                                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "both cbr and cq bitrate mode not support!");
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
            }
        }
        this.hpY.setInteger("bitrate", this.hpx);
        this.hpY.setInteger("frame-rate", this.hqh);
        this.hpY.setInteger("color-format", this.hob);
        this.hpY.setInteger("i-frame-interval", this.hqg);
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "mediaFormat: %s", new Object[]{this.hpY});
        this.hoi = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.hoi.configure(this.hpY, null, null, 1);
        this.hoi.start();
        return 0;
    }

    public final void c(byte[] bArr, boolean z) {
        try {
            if (!this.bhY) {
                v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, not start!");
            } else if (this.hoi == null) {
                v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
            } else {
                if (this.hou != null && this.hou.hpO <= 0) {
                    this.hou.hpO = System.nanoTime();
                }
                long Nj = be.Nj();
                this.hqa = this.hoi.getInputBuffers();
                this.hqb = this.hoi.getOutputBuffers();
                int dequeueInputBuffer = this.hoi.dequeueInputBuffer(100);
                this.hqc = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "video no input available, drain first");
                    azO();
                }
                if (this.hoi == null) {
                    v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
                    return;
                }
                v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.hqc)});
                long Nj2 = be.Nj();
                if (this.hqc >= 0) {
                    long nanoTime = ((System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000))) - (this.hou != null ? this.hou.hpO : this.startTime)) / 1000;
                    v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "presentationTime: " + nanoTime);
                    ByteBuffer byteBuffer = this.hqa[this.hqc];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.bhY || z) {
                        v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "end of stream");
                        this.hqf = true;
                        this.hoi.queueInputBuffer(this.hqc, 0, bArr.length, nanoTime, 4);
                    } else {
                        this.hoi.queueInputBuffer(this.hqc, 0, bArr.length, nanoTime, 0);
                    }
                } else {
                    v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "input buffer not available");
                }
                azO();
                v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder used %sms %sms", new Object[]{Long.valueOf(be.az(Nj)), Long.valueOf(be.az(Nj2))});
            }
        } catch (Throwable e) {
            v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
            g.iuh.a(440, 21, 1, false);
            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData error: %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", e, "", new Object[0]);
        }
    }

    private void azO() {
        this.hor = this.hoi.dequeueOutputBuffer(this.hqd, 100);
        v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "outputBufferIndex-->" + this.hor);
        while (true) {
            if (this.hor != -1) {
                if (this.hor != -3) {
                    if (this.hor != -2) {
                        if (this.hor >= 0) {
                            v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "perform encoding");
                            ByteBuffer byteBuffer = this.hqb[this.hor];
                            if (byteBuffer != null) {
                                this.hpQ++;
                                if ((this.hqd.flags & 2) != 0) {
                                    v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.hqd.size), Boolean.valueOf(false)});
                                }
                                if (this.hqd.size != 0) {
                                    if (!(this.hou == null || this.hou.bhY)) {
                                        this.hou.a(this.hoi.getOutputFormat());
                                    }
                                    byteBuffer.position(this.hqd.offset);
                                    byteBuffer.limit(this.hqd.offset + this.hqd.size);
                                    a(byteBuffer, this.hqd);
                                }
                                this.hoi.releaseOutputBuffer(this.hor, false);
                                if ((this.hqd.flags & 4) != 0) {
                                    break;
                                }
                            }
                            throw new RuntimeException("encoderOutputBuffer " + this.hor + " was null");
                        }
                        v.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.hor);
                    } else {
                        MediaFormat outputFormat = this.hoi.getOutputFormat();
                        v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output format changed: " + outputFormat);
                        if (this.hou != null) {
                            this.hou.a(outputFormat);
                        }
                    }
                } else {
                    this.hqb = this.hoi.getOutputBuffers();
                    v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output buffers changed");
                }
            } else {
                v.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.hqf)});
                if (!this.hqf) {
                    return;
                }
            }
            this.hor = this.hoi.dequeueOutputBuffer(this.hqd, 100);
            if (this.hor <= 0) {
                v.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.hor)});
            }
            if (this.hor < 0 && !this.hqf) {
                return;
            }
        }
        if (this.hqe) {
            v.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder");
            try {
                this.hoi.stop();
                this.hoi.release();
                this.hpV.stop();
                this.hoi = null;
                this.bhY = false;
                if (this.hqi != null) {
                    this.hqi.aAr();
                    return;
                }
                return;
            } catch (Exception e) {
                v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "reached end of stream unexpectedly");
    }

    protected void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.hou != null && (bufferInfo.flags & 4) == 0) {
            this.hou.c(byteBuffer, bufferInfo);
        }
    }

    public final void a(a aVar) {
        this.hqi = aVar;
        this.hqe = true;
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[]{Boolean.valueOf(this.bhY), this.hqi, Boolean.valueOf(this.hpV.aAf())});
        if (this.hpV.aAf()) {
            aAE();
        }
    }

    final void aAE() {
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stopImp %s", new Object[]{be.bur().toString()});
        try {
            if (this.bhY) {
                ad.g(new Runnable(this) {
                    final /* synthetic */ p hqk;

                    {
                        this.hqk = r1;
                    }

                    public final void run() {
                        try {
                            if (this.hqk.hoi != null) {
                                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder");
                                this.hqk.hpV.stop();
                                this.hqk.hoi.stop();
                                this.hqk.hoi.release();
                                this.hqk.hoi = null;
                                this.hqk.bhY = false;
                                if (this.hqk.hqi != null) {
                                    this.hqk.hqi.aAr();
                                }
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
                        }
                    }
                }, 500);
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop error: %s", new Object[]{e.getMessage()});
        }
    }

    public final long aAC() {
        return System.currentTimeMillis() - this.startTime;
    }

    public final void clear() {
        v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear");
        try {
            if (this.hoi != null) {
                v.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop encoder");
                this.hpV.stop();
                this.hoi.stop();
                this.hoi.release();
                this.hoi = null;
                this.bhY = false;
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }
}
