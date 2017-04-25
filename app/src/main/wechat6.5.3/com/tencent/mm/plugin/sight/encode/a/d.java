package com.tencent.mm.plugin.sight.encode.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.encode.a.a.a;
import com.tencent.mm.plugin.sight.encode.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class d implements a {
    c aTF = null;
    ac hoC;
    Runnable hoD = new Runnable(this) {
        final /* synthetic */ d iWV;

        {
            this.iWV = r1;
        }

        public final void run() {
            if (this.iWV.aTF != null) {
                this.iWV.aTF.pb();
            }
        }
    };
    private MediaFormat hoj;
    private BufferInfo hok;
    long hol = 0;
    int hom;
    int hon;
    long hoo;
    long hop;
    private final int hoq = 100;
    boolean hos = false;
    ac hov = new ac(this, ak.vA().htb.getLooper()) {
        final /* synthetic */ d iWV;

        public final void handleMessage(Message message) {
            if (this.iWV.iWQ != null) {
                this.iWV.iWQ.aAu();
                this.iWV.iWQ = null;
            }
        }
    };
    int how;
    boolean hox;
    boolean hoy;
    Object hoz = new byte[0];
    int iWP;
    a iWQ = null;
    MediaCodec iWS;
    private int iWT;
    b iWU;

    public final int aa(int i, String str) {
        this.iWP = i;
        if (this.aTF != null) {
            String str2 = "MicroMsg.SightAACEncoderJB";
            String str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.iWU == null);
            v.e(str2, str3, objArr);
            this.aTF.pb();
        }
        if (this.iWS != null) {
            boolean z;
            str2 = "MicroMsg.SightAACEncoderJB";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.iWU == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
            this.iWS.stop();
            this.iWS.release();
            this.iWS = null;
            if (this.iWU != null) {
                this.iWU.aAv();
                this.iWU = null;
            }
        }
        this.how = 0;
        this.hox = false;
        this.hoy = false;
        this.iWU = null;
        this.aTF = new c(com.tencent.mm.plugin.sight.base.b.aOO(), 5);
        this.aTF.cL(FileUtils.S_IWUSR);
        this.aTF.al(false);
        this.aTF.aUn = new c.a(this) {
            final /* synthetic */ d iWV;

            {
                this.iWV = r1;
            }

            public final void d(byte[] bArr, int i) {
                int i2 = 1;
                this.iWV.hov.sendEmptyMessage(0);
                if (this.iWV.hos) {
                    i2 = 0;
                }
                if (i2 == 0) {
                    d dVar = this.iWV;
                    dVar.how += FileUtils.S_IWUSR;
                }
                boolean z = this.iWV.hox;
                if (i2 == 0) {
                    d dVar2 = this.iWV;
                    int i3 = this.iWV.iWP;
                    if (0 == dVar2.hol) {
                        dVar2.hol = System.nanoTime();
                    }
                    if (dVar2.iWS == null) {
                        v.w("MicroMsg.SightAACEncoderJB", "send audio to encoder error, encoder is null, end:" + z);
                    } else {
                        try {
                            ByteBuffer[] inputBuffers = dVar2.iWS.getInputBuffers();
                            while (true) {
                                int dequeueInputBuffer = dVar2.iWS.dequeueInputBuffer(100);
                                dVar2.hom = dequeueInputBuffer;
                                if (dequeueInputBuffer >= 0) {
                                    break;
                                }
                                v.i("MicroMsg.SightAACEncoderJB", "no input available, drain first");
                                dVar2.F(i3, false);
                            }
                            if (dVar2.iWS == null) {
                                v.w("MicroMsg.SightAACEncoderJB", "send audio to encoder error, encoder is null, end:" + z);
                            } else if (dVar2.hom >= 0) {
                                ByteBuffer byteBuffer = inputBuffers[dVar2.hom];
                                byteBuffer.clear();
                                byteBuffer.put(bArr);
                                byteBuffer.position(0);
                                dVar2.hon = bArr.length;
                                dVar2.hoo = System.nanoTime();
                                dVar2.hoo -= (long) ((dVar2.hon / com.tencent.mm.plugin.sight.base.b.aOO()) / 1000000000);
                                if (dVar2.hon == -3) {
                                    v.e("MicroMsg.SightAACEncoderJB", "Audio read error");
                                }
                                dVar2.hop = (dVar2.hoo - dVar2.hol) / 1000;
                                v.v("MicroMsg.SightAACEncoderJB", "queueing " + dVar2.hon + " audio bytes with pts " + dVar2.hop + ", end:" + z + ", enqueue:" + dVar2.hom);
                                if (z) {
                                    v.i("MicroMsg.SightAACEncoderJB", "EOS received in sendAudioToEncoder");
                                    dVar2.iWS.queueInputBuffer(dVar2.hom, 0, dVar2.hon, dVar2.hop, 4);
                                } else {
                                    dVar2.iWS.queueInputBuffer(dVar2.hom, 0, dVar2.hon, dVar2.hop, 1);
                                }
                            }
                        } catch (Throwable th) {
                            v.e("MicroMsg.SightAACEncoderJB", "_offerAudioEncoder exception " + th.getMessage());
                            v.a("MicroMsg.SightAACEncoderJB", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    dVar2.F(i3, z);
                }
                if (z) {
                    synchronized (this.iWV.hoz) {
                        if (this.iWV.iWU != null) {
                            v.i("MicroMsg.SightAACEncoderJB", "do aac stop callback");
                            this.iWV.iWU.aAv();
                            this.iWV.iWU = null;
                        } else {
                            v.w("MicroMsg.SightAACEncoderJB", "aac stop callback is null");
                        }
                        this.iWV.hoy = true;
                    }
                    this.iWV.hoC.removeCallbacks(this.iWV.hoD);
                    this.iWV.hoC.post(this.iWV.hoD);
                }
            }

            public final void as(int i, int i2) {
                v.w("MicroMsg.SightAACEncoderJB", "on rec error, %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            }
        };
        if (this.hoC == null) {
            v.i("MicroMsg.SightAACEncoderJB", "create pcm control handler");
            this.hoC = new ac();
        } else if (this.hoC.getLooper() != Looper.myLooper()) {
            v.w("MicroMsg.SightAACEncoderJB", "error pcm control handler looper[%s, %s], recreate handler", this.hoC.getLooper(), Looper.myLooper());
            this.hoC = new ac();
        }
        v.i("MicroMsg.SightAACEncoderJB", "sample rate %d, audio rate %d", Integer.valueOf(com.tencent.mm.plugin.sight.base.b.aOO()), Integer.valueOf(com.tencent.mm.plugin.sight.base.b.aOP()));
        try {
            this.hok = new BufferInfo();
            this.hoj = new MediaFormat();
            this.hoj.setString("mime", "audio/mp4a-latm");
            this.hoj.setInteger("aac-profile", 2);
            this.hoj.setInteger("sample-rate", com.tencent.mm.plugin.sight.base.b.aOO());
            this.hoj.setInteger("channel-count", 1);
            this.hoj.setInteger("bitrate", com.tencent.mm.plugin.sight.base.b.aOP());
            this.hoj.setInteger("max-input-size", 16384);
            this.iWS = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.iWS.configure(this.hoj, null, null, 1);
            this.iWS.start();
            return 0;
        } catch (Throwable th) {
            MediaCodec th2 = th;
            v.a("MicroMsg.SightAACEncoderJB", th2, "start aac encoder error: %s", th2.getMessage());
            if (this.iWS != null) {
                try {
                    this.iWS.stop();
                    this.iWS.release();
                    this.iWS = th2;
                } catch (Exception e) {
                    str2 = "MicroMsg.SightAACEncoderJB";
                    str3 = "try to stop aac encoder error: %s";
                    this.iWS = null;
                    com.tencent.mm.plugin.sight.base.d.aOT();
                    return -1;
                } catch (Throwable th3) {
                    th2 = th3;
                    this.iWS = null;
                }
            }
            com.tencent.mm.plugin.sight.base.d.aOT();
            return -1;
        } finally {
            this.hos = false;
        }
    }

    public final int a(a aVar) {
        this.iWQ = aVar;
        if (this.aTF != null && this.aTF.pj()) {
            return 0;
        }
        return -1;
    }

    public final int a(b bVar) {
        String str = "MicroMsg.SightAACEncoderJB";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.aTF == null);
        objArr[1] = Boolean.valueOf(this.iWU == null);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.hox);
        v.i(str, str2, objArr);
        if (this.aTF == null) {
            return -1;
        }
        synchronized (this.hoz) {
            this.iWU = bVar;
            if (this.hoy && bVar != null) {
                v.i("MicroMsg.SightAACEncoderJB", "has stop, directly call stop callback");
                bVar.aAv();
                this.iWU = null;
            }
        }
        this.hox = true;
        return 0;
    }

    public final void aPN() {
        this.hos = true;
    }

    final void F(int i, boolean z) {
        if (this.iWS == null) {
            v.w("MicroMsg.SightAACEncoderJB", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        loop0:
        while (true) {
            ByteBuffer[] outputBuffers = this.iWS.getOutputBuffers();
            while (true) {
                this.iWT = this.iWS.dequeueOutputBuffer(this.hok, 100);
                if (this.iWT == -1) {
                    if (z) {
                        v.d("MicroMsg.SightAACEncoderJB", "no output available, spinning to await EOS");
                    } else {
                        v.d("MicroMsg.SightAACEncoderJB", "no output available. aborting drain");
                        return;
                    }
                } else if (this.iWT != -3) {
                    if (this.iWT == -2) {
                        continue;
                    } else if (this.iWT < 0) {
                        v.v("MicroMsg.SightAACEncoderJB", "unexpected result from encoder.dequeueOutputBuffer: " + this.iWT);
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[this.iWT];
                        if (byteBuffer == null) {
                            throw new RuntimeException("encoderOutputBuffer " + this.iWT + " was null");
                        }
                        if ((this.hok.flags & 2) != 0) {
                            this.hok.size = 0;
                        }
                        if (this.hok.size != 0) {
                            byteBuffer.position(this.hok.offset);
                            byteBuffer.limit(this.hok.offset + this.hok.size);
                            SightVideoJNI.writeAACData(i, byteBuffer, this.hok.size);
                        }
                        this.iWS.releaseOutputBuffer(this.iWT, false);
                        if ((this.hok.flags & 4) != 0) {
                            break loop0;
                        }
                    }
                }
            }
        }
        if (z) {
            v.w("MicroMsg.SightAACEncoderJB", "do stop audio encoder");
            this.iWS.stop();
            this.iWS.release();
            this.iWS = null;
            return;
        }
        v.w("MicroMsg.SightAACEncoderJB", "reached end of stream unexpectedly");
    }

    public final int aPM() {
        return this.iWP;
    }
}
