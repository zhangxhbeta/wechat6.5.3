package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        v.i(TAG, "init ");
    }

    protected final int a(MediaCodecInfo mediaCodecInfo, String str) {
        v.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long Nj = be.Nj();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        v.i(TAG, "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        v.i(TAG, "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            v.i(TAG, "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (nc(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        v.i(TAG, "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected final boolean nc(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    protected final boolean aAP() {
        if (this.hqU == null) {
            v.e(TAG, "drainDecoder, decoder is null");
            return true;
        }
        int dequeueOutputBuffer = this.hqU.dequeueOutputBuffer(this.hqd, 60000);
        v.i(TAG, "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                v.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.hlr = this.hqU.getOutputFormat();
                v.i(TAG, "decoder output format changed: " + this.hlr);
            } else if (dequeueOutputBuffer < 0) {
                v.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                v.v(TAG, "perform decoding");
                long Nj = be.Nj();
                byte[] a = a(this.hqU.getOutputImage(dequeueOutputBuffer));
                v.v(TAG, "perform decoding costImage %s", new Object[]{Long.valueOf(be.az(Nj))});
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.hqd;
                    if (a == null) {
                        v.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        v.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[]{a, bufferInfo, Integer.valueOf(bufferInfo.size)});
                        this.hlr = this.hqU.getOutputFormat();
                        if (this.hqx != null) {
                            this.hqx.av(a);
                        }
                    }
                    this.hqU.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.hqd.presentationTimeUs;
                    if (this.hlq != 1 && j >= this.hlq * 1000) {
                        v.e(TAG, "exceed endTimeMs");
                        return true;
                    } else if ((this.hqd.flags & 4) == 0) {
                        return false;
                    } else {
                        v.i(TAG, "receive end of stream");
                        try {
                            this.hqU.stop();
                            this.hqU.release();
                            this.hqU = null;
                            return true;
                        } catch (Exception e) {
                            v.e(TAG, "stop and release decoder error: %s", new Object[]{e.getMessage()});
                            return true;
                        }
                    }
                } else {
                    this.hqU.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.hqU.dequeueOutputBuffer(this.hqd, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        v.i(TAG, "no output from decoder available, break");
        return false;
    }

    public final int aAI() {
        return 2;
    }

    private static byte[] a(Image image) {
        int i;
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        v.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[]{Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format)});
        byte[] h = h.hoF.h(Integer.valueOf(i));
        format = 0;
        while (format < planes.length) {
            ByteBuffer buffer = planes[format].getBuffer();
            int rowStride = planes[format].getRowStride();
            int pixelStride = planes[format].getPixelStride();
            int i3 = format == 0 ? width : width / 2;
            i = format == 0 ? height : height / 2;
            v.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[]{Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(pixelStride)});
            byte[] h2 = h.hoF.h(Integer.valueOf(rowStride));
            for (int i4 = 0; i4 < i; i4++) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel) {
                    bitsPerPixel *= i3;
                    buffer.get(h, i2, bitsPerPixel);
                    if (i - i4 != 1) {
                        buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                    }
                    i2 += bitsPerPixel;
                } else {
                    if (i - i4 == 1) {
                        buffer.get(h2, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(h2, 0, rowStride);
                    }
                    bitsPerPixel = 0;
                    while (bitsPerPixel < i3) {
                        int i5 = i2 + 1;
                        h[i2] = h2[bitsPerPixel * pixelStride];
                        bitsPerPixel++;
                        i2 = i5;
                    }
                }
            }
            h.hoF.x(h2);
            format++;
        }
        return h;
    }
}
