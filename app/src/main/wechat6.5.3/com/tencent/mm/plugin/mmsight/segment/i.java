package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.segment.f.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

public class i implements f {
    protected long hlp;
    protected long hlq;
    protected MediaFormat hlr;
    protected MediaExtractor hlt;
    protected int hqO;
    protected String hqT = null;
    protected MediaCodec hqU;
    protected int hqV;
    private byte[] hqW;
    protected BufferInfo hqd = new BufferInfo();
    protected a hqx;

    public i(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[]{mediaExtractor, mediaFormat, Integer.valueOf(i)});
        this.hlt = mediaExtractor;
        this.hlr = mediaFormat;
        this.hqO = i;
    }

    public final int e(String str, long j, long j2) {
        this.hqT = str;
        this.hlp = j;
        this.hlq = j2;
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.hlr + "]");
        try {
            String string = this.hlr.getString("mime");
            this.hqU = MediaCodec.createDecoderByType(string);
            MediaCodecInfo wC = wC(string);
            v.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[]{wC});
            if (wC != null) {
                v.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[]{wC.getName()});
                v.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[]{Integer.valueOf(a(wC, string))});
                this.hlr.setInteger("color-format", r1);
            }
            this.hqU.configure(this.hlr, null, null, 0);
            this.hqU.start();
            return 0;
        } catch (Throwable e) {
            v.a("MicroMsg.MediaCodecTranscodeDecoder", e, "Init decoder failed : %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    private static MediaCodecInfo wC(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    protected int a(MediaCodecInfo mediaCodecInfo, String str) {
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long Nj = be.Nj();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            v.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (nc(i2) && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected boolean nc(int i) {
        switch (i) {
            case 19:
            case 21:
                return true;
            default:
                return false;
        }
    }

    protected boolean aAP() {
        if (this.hqU == null) {
            v.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            return true;
        }
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[]{Integer.valueOf(this.hqU.getOutputBuffers().length)});
        int dequeueOutputBuffer = this.hqU.dequeueOutputBuffer(this.hqd, 60000);
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->" + dequeueOutputBuffer);
        int i = dequeueOutputBuffer;
        ByteBuffer[] byteBufferArr = r1;
        int i2 = i;
        while (i2 != -1) {
            if (i2 != -3) {
                if (i2 != -2) {
                    if (i2 >= 0) {
                        v.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[i2];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.hqd.presentationTimeUs;
                        if (j < this.hlp * 1000 && (this.hqd.flags & 4) == 0) {
                            this.hqU.releaseOutputBuffer(i2, false);
                            v.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[]{Long.valueOf(j), Long.valueOf(this.hlp * 1000)});
                            return false;
                        } else if (this.hqd.size != 0) {
                            byteBuffer.position(this.hqd.offset);
                            byteBuffer.limit(this.hqd.offset + this.hqd.size);
                            long Nj = be.Nj();
                            BufferInfo bufferInfo = this.hqd;
                            if (byteBuffer == null) {
                                v.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                if (this.hqW == null) {
                                    this.hqW = new byte[byteBuffer.remaining()];
                                }
                                long Nj2 = be.Nj();
                                try {
                                    this.hlr = this.hqU.getOutputFormat();
                                } catch (Exception e) {
                                    v.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                }
                                byteBuffer.get(this.hqW, 0, byteBuffer.remaining());
                                v.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[]{byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(be.az(Nj2))});
                                if (this.hqx != null) {
                                    this.hqx.av(this.hqW);
                                }
                            }
                            v.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[]{Long.valueOf(be.az(Nj))});
                            this.hqU.releaseOutputBuffer(i2, false);
                            if (this.hlq != 1 && j >= this.hlq * 1000) {
                                v.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                return true;
                            } else if ((this.hqd.flags & 4) == 0) {
                                return false;
                            } else {
                                v.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                try {
                                    this.hqU.stop();
                                    this.hqU.release();
                                    this.hqU = null;
                                } catch (Exception e2) {
                                    v.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[]{e2.getMessage()});
                                }
                                return true;
                            }
                        } else {
                            this.hqU.releaseOutputBuffer(i2, false);
                        }
                    } else {
                        v.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: " + i2);
                    }
                } else {
                    this.hlr = this.hqU.getOutputFormat();
                    v.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.hlr);
                }
            } else {
                byteBufferArr = this.hqU.getOutputBuffers();
                v.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
            }
            i2 = this.hqU.dequeueOutputBuffer(this.hqd, 60000);
            if (i2 < 0) {
                break;
            }
        }
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(java.lang.Runnable r11) {
        /*
        r10 = this;
    L_0x0000:
        r2 = r10.hlt;
        r0 = r10.hqU;
        if (r0 != 0) goto L_0x00ae;
    L_0x0006:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "input decoder is null";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r7 = 1;
    L_0x0010:
        if (r7 != 0) goto L_0x002a;
    L_0x0012:
        r0 = r10.hlt;
        r0.advance();
        r0 = r10.hlt;
        r0 = r0.getSampleTrackIndex();
        r1 = r10.hqO;
        if (r0 == r1) goto L_0x0000;
    L_0x0021:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "track index not match, break";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
    L_0x002a:
        r0 = r10.hlt;
        r1 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "sendDecoderEOS";
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        r1 = r10.hqU;
        r2 = r1.getInputBuffers();
        r1 = r10.hqU;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = r1.dequeueInputBuffer(r4);
        if (r1 >= 0) goto L_0x0067;
    L_0x0046:
        r3 = "MicroMsg.MediaCodecTranscodeDecoder";
        r4 = "check decoder input buffer index = %d count = %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = 0;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
        r3 = r10.aAP();
        if (r3 != 0) goto L_0x00a0;
    L_0x0067:
        if (r1 < 0) goto L_0x009d;
    L_0x0069:
        r2 = r2[r1];
        r2.clear();
        r3 = 0;
        r3 = r0.readSampleData(r2, r3);
        r10.hqV = r3;
        r3 = 0;
        r2.position(r3);
        r4 = r0.getSampleTime();
        if (r1 < 0) goto L_0x018c;
    L_0x007f:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "send EOS, decoderInputBufferIndex: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r3[r6] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
        r0 = r10.hqU;
        r2 = 0;
        r3 = 0;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r6 = 4;
        r0.queueInputBuffer(r1, r2, r3, r4, r6);
    L_0x009d:
        r10.aAP();
    L_0x00a0:
        r0 = new com.tencent.mm.plugin.mmsight.segment.i$1;
        r0.<init>(r10);
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.mm.sdk.platformtools.ad.g(r0, r2);
        r11.run();
        return;
    L_0x00ae:
        r0 = r10.hqU;
        r3 = r0.getInputBuffers();
        if (r3 != 0) goto L_0x00b9;
    L_0x00b6:
        r7 = 0;
        goto L_0x0010;
    L_0x00b9:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "decoderInputByteBuffers size: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r3.length;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r4);
        r0 = 0;
    L_0x00ce:
        r1 = r10.hqU;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = r1.dequeueInputBuffer(r4);
        if (r1 >= 0) goto L_0x0104;
    L_0x00d9:
        r4 = 15;
        if (r0 >= r4) goto L_0x0104;
    L_0x00dd:
        r4 = com.tencent.mm.sdk.platformtools.be.Nj();
        r1 = r10.aAP();
        r6 = "MicroMsg.MediaCodecTranscodeDecoder";
        r7 = "drain cost1 %d";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r4 = com.tencent.mm.sdk.platformtools.be.az(r4);
        r4 = java.lang.Long.valueOf(r4);
        r8[r9] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r6, r7, r8);
        if (r1 == 0) goto L_0x0101;
    L_0x00fe:
        r7 = 1;
        goto L_0x0010;
    L_0x0101:
        r0 = r0 + 1;
        goto L_0x00ce;
    L_0x0104:
        r0 = 0;
        if (r1 < 0) goto L_0x0181;
    L_0x0107:
        r3 = r3[r1];
        r3.clear();
        r4 = 0;
        r4 = r2.readSampleData(r3, r4);
        r10.hqV = r4;
        r4 = 0;
        r3.position(r4);
        r4 = r2.getSampleTime();
        r2 = "MicroMsg.MediaCodecTranscodeDecoder";
        r3 = "sampleTime: %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Long.valueOf(r4);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r6);
        r2 = r10.hqV;
        if (r2 < 0) goto L_0x013b;
    L_0x0132:
        r2 = r10.hlq;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r6;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0197;
    L_0x013b:
        r0 = 1;
        r7 = r0;
    L_0x013d:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "sawInputEOS: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r6 = 0;
        r8 = java.lang.Boolean.valueOf(r7);
        r3[r6] = r8;
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
        r0 = r10.hqU;
        r2 = 0;
        r3 = r10.hqV;
        if (r7 == 0) goto L_0x017f;
    L_0x0157:
        r6 = 4;
    L_0x0158:
        r0.queueInputBuffer(r1, r2, r3, r4, r6);
    L_0x015b:
        r0 = com.tencent.mm.sdk.platformtools.be.Nj();
        r2 = r10.aAP();
        r3 = "MicroMsg.MediaCodecTranscodeDecoder";
        r4 = "drain cost2 %d";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.az(r0);
        r0 = java.lang.Long.valueOf(r0);
        r5[r6] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);
        if (r2 == 0) goto L_0x0010;
    L_0x017c:
        r7 = 1;
        goto L_0x0010;
    L_0x017f:
        r6 = 0;
        goto L_0x0158;
    L_0x0181:
        r1 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "input buffer not available";
        com.tencent.mm.sdk.platformtools.v.w(r1, r2);
        r7 = r0;
        goto L_0x015b;
    L_0x018c:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "input buffer not available";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x009d;
    L_0x0197:
        r7 = r0;
        goto L_0x013d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.t(java.lang.Runnable):void");
    }

    public final void a(a aVar) {
        this.hqx = aVar;
    }

    public int aAI() {
        v.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[]{Integer.valueOf(this.hlr.getInteger("color-format"))});
        switch (this.hlr.getInteger("color-format")) {
            case 19:
                return 2;
            default:
                return 1;
        }
    }

    public final Point aAH() {
        return new Point(this.hlr.getInteger("width"), this.hlr.getInteger("height"));
    }

    public final void stop() {
        if (this.hqU != null) {
            try {
                v.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.hqU.stop();
                this.hqU.release();
                this.hqU = null;
            } catch (Throwable e) {
                v.a("MicroMsg.MediaCodecTranscodeDecoder", e, "stop decoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
