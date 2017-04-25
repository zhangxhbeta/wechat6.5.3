package com.tencent.mm.plugin.mmsight;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private byte[] hlA;
    private HandlerThread hlB = null;
    private ac hlC = null;
    public MediaCodec hln;
    public MediaCodec hlo;
    private long hlp;
    private long hlq;
    public MediaFormat hlr;
    public MediaFormat hls;
    private MediaExtractor hlt;
    public String hlu = null;
    public VideoTransPara hlv;
    public boolean hlw = true;
    public List<byte[]> hlx = null;
    private boolean hly = false;
    private boolean hlz = false;

    public c(MediaExtractor mediaExtractor, MediaFormat mediaFormat, long j, long j2, VideoTransPara videoTransPara) {
        this.hlt = mediaExtractor;
        this.hlr = mediaFormat;
        this.hlp = j;
        this.hlq = j2;
        this.hlv = videoTransPara;
        this.hlu = mediaFormat.getString("mime");
        this.hlx = new ArrayList();
        v.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), this.hlu, mediaFormat, videoTransPara});
    }

    public final void azL() {
        this.hly = false;
        this.hlz = false;
        while (this.hln != null && this.hlt != null) {
            try {
                ByteBuffer[] inputBuffers = this.hln.getInputBuffers();
                int dequeueInputBuffer = this.hln.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    v.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    azM();
                }
                if (dequeueInputBuffer >= 0) {
                    boolean z;
                    v.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.hlt.readSampleData(byteBuffer, 0);
                    long sampleTime = this.hlt.getSampleTime();
                    this.hlt.advance();
                    v.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[]{Integer.valueOf(readSampleData), Long.valueOf(sampleTime)});
                    if (sampleTime >= this.hlq * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        v.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.hlz = true;
                        ad.g(new Runnable(this) {
                            final /* synthetic */ c hlD;

                            {
                                this.hlD = r1;
                            }

                            public final void run() {
                                try {
                                    if (this.hlD.hln != null) {
                                        v.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                                        this.hlD.hln.stop();
                                        this.hlD.hln.release();
                                        this.hlD.hln = null;
                                    }
                                } catch (Exception e) {
                                    v.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[]{e.getMessage()});
                                }
                            }
                        }, 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.hln == null) {
                        return;
                    }
                    if (z) {
                        v.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.hln.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 4);
                    } else {
                        this.hln.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    }
                }
                azM();
                if (this.hlz && this.hlo == null) {
                    return;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MediaCodecAACTranscoder", e, "startTranscodeBlockLoop error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        v.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
    }

    private void azM() {
        if (this.hln != null) {
            try {
                ByteBuffer[] outputBuffers = this.hln.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                ByteBuffer[] byteBufferArr = outputBuffers;
                while (true) {
                    int dequeueOutputBuffer = this.hln.dequeueOutputBuffer(bufferInfo, 20000);
                    v.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        v.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        byteBufferArr = this.hln.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.hlr = this.hln.getOutputFormat();
                        v.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[]{this.hlr});
                    } else if (dequeueOutputBuffer < 0) {
                        v.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        v.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            v.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                            return;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            v.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                        }
                        this.hln.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                v.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.hln != null) {
                    this.hln.stop();
                    this.hln.release();
                    this.hln = null;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MediaCodecAACTranscoder", e, "drainDecoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void a(ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
        if (byteBuffer != null) {
            v.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.hlz)});
            if (this.hlw) {
                if (!this.hly) {
                    azN();
                    this.hly = true;
                }
                if (this.hlA == null) {
                    this.hlA = new byte[byteBuffer.remaining()];
                    byteBuffer.get(this.hlA, 0, byteBuffer.remaining());
                }
                a(this.hlA, bufferInfo.presentationTimeUs, z);
                return;
            }
            Object obj = new byte[byteBuffer.remaining()];
            byteBuffer.get(obj, 0, byteBuffer.remaining());
            this.hlx.add(obj);
            if (this.hlz || z) {
                try {
                    this.hln.stop();
                    this.hln.release();
                } catch (Throwable e) {
                    v.a("MicroMsg.MediaCodecAACTranscoder", e, "", new Object[0]);
                }
                azN();
                this.hly = true;
                int i = 0;
                for (byte[] bArr : this.hlx) {
                    boolean z2;
                    long j = bufferInfo.presentationTimeUs;
                    if (i >= this.hlx.size() - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a(bArr, j, z2);
                    i++;
                }
            }
        }
    }

    private void azN() {
        if (this.hlo == null || !this.hlw || this.hly) {
            try {
                this.hls = new MediaFormat();
                this.hls.setString("mime", "audio/mp4a-latm");
                this.hls.setInteger("aac-profile", 2);
                this.hls.setInteger("sample-rate", this.hlv.audioSampleRate);
                this.hls.setInteger("channel-count", 1);
                this.hls.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.hlv.cGk);
                this.hls.setInteger("max-input-size", 16384);
                this.hlo = MediaCodec.createEncoderByType(this.hlu);
                this.hlo.configure(this.hls, null, null, 1);
                this.hlo.start();
                v.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                return;
            } catch (Exception e) {
                v.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        this.hln.start();
    }

    private void a(byte[] bArr, long j, boolean z) {
        if (this.hlo != null && bArr != null) {
            ByteBuffer[] inputBuffers = this.hlo.getInputBuffers();
            int dequeueInputBuffer = this.hlo.dequeueInputBuffer(20000);
            if (dequeueInputBuffer < 0) {
                v.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
                azO();
            }
            if (dequeueInputBuffer >= 0) {
                int i;
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(bArr);
                if (z) {
                    v.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                    i = 1;
                    ad.g(new Runnable(this) {
                        final /* synthetic */ c hlD;

                        {
                            this.hlD = r1;
                        }

                        public final void run() {
                            try {
                                if (this.hlD.hlo != null) {
                                    v.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                                    this.hlD.hlo.stop();
                                    this.hlD.hlo.release();
                                    this.hlD.hlo = null;
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[]{e.getMessage()});
                            }
                        }
                    }, 500);
                } else {
                    i = 0;
                }
                if (this.hlo == null) {
                    return;
                }
                if (i != 0) {
                    v.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                    this.hlo.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 4);
                } else {
                    this.hlo.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                }
            }
            azO();
        }
    }

    private void azO() {
        if (this.hlo != null) {
            try {
                ByteBuffer[] outputBuffers = this.hlo.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                while (true) {
                    int dequeueOutputBuffer = this.hlo.dequeueOutputBuffer(bufferInfo, 20000);
                    v.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        v.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.hlo.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.hls = this.hlo.getOutputFormat();
                        v.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[]{this.hls});
                    } else if (dequeueOutputBuffer < 0) {
                        v.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        v.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            v.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                            return;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            if (byteBuffer != null) {
                                MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
                            }
                        }
                        this.hlo.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                v.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.hlo != null) {
                    this.hlo.stop();
                    this.hlo.release();
                    this.hlo = null;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.MediaCodecAACTranscoder", e, "drainEncoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
