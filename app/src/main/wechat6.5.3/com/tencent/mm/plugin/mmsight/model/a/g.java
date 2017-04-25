package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

@TargetApi(16)
public class g {
    c aTF = null;
    int audioSampleRate;
    private int cGk;
    b hoA;
    boolean hoB = false;
    ac hoC;
    Runnable hoD = new Runnable(this) {
        final /* synthetic */ g hoE;

        {
            this.hoE = r1;
        }

        public final void run() {
            if (this.hoE.aTF != null) {
                this.hoE.hoB = true;
                this.hoE.aTF.pb();
            }
        }
    };
    MediaCodec hoi;
    private MediaFormat hoj;
    private BufferInfo hok;
    long hol = 0;
    int hom;
    int hon;
    long hoo;
    long hop;
    private final int hoq = 100;
    private int hor;
    boolean hos = false;
    a hot = null;
    m hou;
    ac hov = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ g hoE;

        public final void handleMessage(Message message) {
            if (this.hoE.hot != null) {
                this.hoE.hot.aAu();
                this.hoE.hot = null;
            }
        }
    };
    int how;
    protected boolean hox;
    boolean hoy;
    Object hoz = new byte[0];
    private long startTime = 0;

    interface a {
        void aAu();
    }

    interface b {
        void aAv();
    }

    public g(int i, int i2) {
        this.cGk = i2;
        this.audioSampleRate = i;
        this.hou = null;
        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(this.cGk), Integer.valueOf(this.audioSampleRate)});
    }

    public final int aAt() {
        if (this.aTF != null) {
            String str = "MicroMsg.MMSightAACMediaCodecRecorder";
            String str2 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.hoA == null);
            v.e(str, str2, objArr);
            this.aTF.pb();
        }
        if (this.hoi != null) {
            boolean z;
            str = "MicroMsg.MMSightAACMediaCodecRecorder";
            str2 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.hoA == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            this.hoi.stop();
            this.hoi.release();
            this.hoi = null;
            if (this.hoA != null) {
                this.hoA.aAv();
                this.hoA = null;
            }
        }
        this.how = 0;
        this.hox = false;
        this.hoy = false;
        this.hoA = null;
        this.aTF = new c(this.audioSampleRate, 5);
        this.aTF.cL(128);
        this.aTF.al(false);
        this.aTF.aUn = new com.tencent.mm.c.b.c.a(this) {
            final /* synthetic */ g hoE;

            {
                this.hoE = r1;
            }

            public final void d(byte[] bArr, int i) {
                int i2 = 0;
                this.hoE.hov.sendEmptyMessage(0);
                if (!this.hoE.hos) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    g gVar = this.hoE;
                    gVar.how += 128;
                }
                boolean z = this.hoE.hox;
                if (i2 == 0) {
                    g gVar2 = this.hoE;
                    if (0 == gVar2.hol) {
                        gVar2.hol = System.nanoTime();
                    }
                    if (gVar2.hou != null && gVar2.hou.hpO <= 0) {
                        gVar2.hou.hpO = System.nanoTime();
                    }
                    if (gVar2.hoi != null) {
                        if (gVar2.hoi == null) {
                            v.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                        } else {
                            try {
                                ByteBuffer[] inputBuffers = gVar2.hoi.getInputBuffers();
                                int dequeueInputBuffer = gVar2.hoi.dequeueInputBuffer(100);
                                gVar2.hom = dequeueInputBuffer;
                                if (dequeueInputBuffer < 0) {
                                    v.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                                    gVar2.ei(false);
                                }
                                if (gVar2.hoi == null) {
                                    v.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                                } else if (gVar2.hom >= 0) {
                                    ByteBuffer byteBuffer = inputBuffers[gVar2.hom];
                                    byteBuffer.clear();
                                    byteBuffer.put(bArr);
                                    byteBuffer.position(0);
                                    gVar2.hon = bArr.length;
                                    gVar2.hoo = System.nanoTime();
                                    gVar2.hoo -= (long) ((gVar2.hon / gVar2.audioSampleRate) / 1000000000);
                                    if (gVar2.hon == -3) {
                                        v.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                                    }
                                    gVar2.hop = (gVar2.hoo - (gVar2.hou != null ? gVar2.hou.hpO : gVar2.hol)) / 1000;
                                    v.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + gVar2.hon + " audio bytes with pts " + gVar2.hop + ", end:" + z + ", enqueue:" + gVar2.hom);
                                    if (z) {
                                        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                        gVar2.hoi.queueInputBuffer(gVar2.hom, 0, gVar2.hon, gVar2.hop, 4);
                                    } else {
                                        gVar2.hoi.queueInputBuffer(gVar2.hom, 0, gVar2.hon, gVar2.hop, 0);
                                    }
                                }
                            } catch (Throwable th) {
                                v.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th.getMessage());
                            }
                        }
                        gVar2.ei(z);
                    }
                }
                if (z && !this.hoE.hoB) {
                    synchronized (this.hoE.hoz) {
                        if (this.hoE.hoA != null) {
                            v.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                            this.hoE.hoA.aAv();
                            this.hoE.hoA = null;
                        } else {
                            v.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                        }
                        this.hoE.hoy = true;
                    }
                    this.hoE.hoB = true;
                    this.hoE.hoC.removeCallbacks(this.hoE.hoD);
                    this.hoE.hoC.post(this.hoE.hoD);
                }
            }

            public final void as(int i, int i2) {
                v.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            }
        };
        if (this.hoC == null) {
            v.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.hoC = new ac();
        } else if (this.hoC.getLooper() != Looper.myLooper()) {
            v.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", new Object[]{this.hoC.getLooper(), Looper.myLooper()});
            this.hoC = new ac();
        }
        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", new Object[]{Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.cGk)});
        try {
            this.hok = new BufferInfo();
            this.hoj = new MediaFormat();
            this.hoj.setString("mime", "audio/mp4a-latm");
            this.hoj.setInteger("aac-profile", 2);
            this.hoj.setInteger("sample-rate", this.audioSampleRate);
            this.hoj.setInteger("channel-count", 1);
            this.hoj.setInteger("bitrate", this.cGk);
            this.hoj.setInteger("max-input-size", 16384);
            this.hoi = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.hoi.configure(this.hoj, null, null, 1);
            this.hoi.start();
            return 0;
        } catch (Throwable th) {
            v.a("MicroMsg.MMSightAACMediaCodecRecorder", th, "start aac encoder error: %s", new Object[]{th.getMessage()});
            if (this.hoi != null) {
                try {
                    this.hoi.stop();
                    this.hoi.release();
                    this.hoi = null;
                } catch (Exception e) {
                    str = "MicroMsg.MMSightAACMediaCodecRecorder";
                    str2 = "try to stop aac encoder error: %s";
                    this.hoi = null;
                    v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
                    com.tencent.mm.plugin.report.service.g.iuh.a(440, 15, 1, false);
                    return -1;
                } catch (Throwable th2) {
                    this.hoi = null;
                }
            }
            v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
            com.tencent.mm.plugin.report.service.g.iuh.a(440, 15, 1, false);
            return -1;
        } finally {
            this.hos = false;
        }
    }

    public final int a(a aVar) {
        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[]{aVar});
        this.hot = aVar;
        if (this.aTF == null) {
            v.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
            return -1;
        } else if (this.aTF.pj()) {
            return 0;
        } else {
            return -1;
        }
    }

    public final int a(b bVar) {
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.aTF == null);
        objArr[1] = Boolean.valueOf(this.hoA == null);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.hox);
        v.i(str, str2, objArr);
        if (this.aTF == null) {
            return -1;
        }
        this.hox = true;
        synchronized (this.hoz) {
            this.hoA = bVar;
            if (this.hoy && bVar != null) {
                v.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                bVar.aAv();
                this.hoA = null;
            }
        }
        ad.g(new Runnable(this) {
            final /* synthetic */ g hoE;

            {
                this.hoE = r1;
            }

            public final void run() {
                try {
                    if (this.hoE.hoi != null) {
                        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
                        this.hoE.hoi.stop();
                        this.hoE.hoi.release();
                        this.hoE.hoi = null;
                    }
                    if (this.hoE.aTF != null) {
                        this.hoE.aTF.pb();
                        this.hoE.aTF = null;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
                }
            }
        }, 500);
        return 0;
    }

    public final void clear() {
        v.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        try {
            if (this.hoi != null) {
                v.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.hoi.stop();
                this.hoi.release();
                this.hoi = null;
            }
            if (this.aTF != null) {
                v.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
                this.aTF.pb();
                this.aTF = null;
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    final void ei(boolean z) {
        if (this.hoi == null) {
            v.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.hoi.getOutputBuffers();
            while (true) {
                this.hor = this.hoi.dequeueOutputBuffer(this.hok, 100);
                v.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[]{Integer.valueOf(this.hor)});
                if (this.hor == -1) {
                    v.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    return;
                } else if (this.hor == -3) {
                    outputBuffers = this.hoi.getOutputBuffers();
                } else if (this.hor == -2) {
                    MediaFormat outputFormat = this.hoi.getOutputFormat();
                    v.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + outputFormat);
                    if (this.hou != null) {
                        this.hou.b(outputFormat);
                    }
                } else if (this.hor < 0) {
                    v.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(this.hor)});
                } else {
                    v.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.hor];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + this.hor + " was null");
                    }
                    if ((this.hok.flags & 2) != 0) {
                        v.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[]{Integer.valueOf(this.hok.size), Boolean.valueOf(aAs())});
                        if (aAs()) {
                            this.hok.size = 0;
                        }
                    }
                    if (this.hok.size != 0) {
                        if (!(this.hou == null || this.hou.bhY)) {
                            this.hou.b(this.hoi.getOutputFormat());
                        }
                        byteBuffer.position(this.hok.offset);
                        byteBuffer.limit(this.hok.offset + this.hok.size);
                        a(byteBuffer, this.hok);
                    }
                    this.hoi.releaseOutputBuffer(this.hor, false);
                    if ((this.hok.flags & 4) != 0) {
                        break;
                    }
                }
            }
            if (z) {
                v.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                this.hoi.stop();
                this.hoi.release();
                this.hoi = null;
                return;
            }
            v.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
        } catch (Exception e) {
            v.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[]{e.getMessage()});
        }
    }

    protected void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.hou != null && (bufferInfo.flags & 4) == 0) {
            this.hou.b(byteBuffer, bufferInfo);
        }
    }

    protected boolean aAs() {
        return false;
    }
}
