package com.tencent.mm.plugin.music.a.c;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c extends a {
    int dad = 0;
    long dfS = 0;
    AudioTrack djg;
    private boolean ecS = true;
    private Runnable hDA = new Runnable(this) {
        final /* synthetic */ c hDB;

        {
            this.hDB = r1;
        }

        public final void run() {
            v.i("MicroMsg.Music.MMPlayer", "starting...");
            Process.setThreadPriority(-19);
            if (be.kS(this.hDB.hDy)) {
                v.e("MicroMsg.Music.MMPlayer", "source path is null");
                this.hDB.eF(false);
                return;
            }
            this.hDB.hlt = new MediaExtractor();
            try {
                this.hDB.hlt.setDataSource(this.hDB.hDy);
                MediaFormat mediaFormat = null;
                try {
                    MediaFormat trackFormat;
                    int trackCount = this.hDB.hlt.getTrackCount();
                    for (int i = 0; i < trackCount; i++) {
                        trackFormat = this.hDB.hlt.getTrackFormat(i);
                        this.hDB.hlu = trackFormat.getString("mime");
                        if (!be.kS(this.hDB.hlu) && this.hDB.hlu.startsWith("audio/")) {
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    if (mediaFormat == null) {
                        v.e("MicroMsg.Music.MMPlayer", "format is null");
                        this.hDB.eF(true);
                        c.a(this.hDB);
                        return;
                    }
                    this.hDB.dad = mediaFormat.getInteger("sample-rate");
                    this.hDB.hDz = mediaFormat.getInteger("channel-count");
                    this.hDB.dfS = mediaFormat.getLong("durationUs");
                    try {
                        this.hDB.hDx = MediaCodec.createDecoderByType(this.hDB.hlu);
                        this.hDB.hDx.configure(mediaFormat, null, null, 0);
                        this.hDB.hDx.start();
                        ByteBuffer[] inputBuffers = this.hDB.hDx.getInputBuffers();
                        ByteBuffer[] outputBuffers = this.hDB.hDx.getOutputBuffers();
                        v.i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", new Object[]{mediaFormat, this.hDB.hlu, Integer.valueOf(this.hDB.dad), Integer.valueOf(this.hDB.hDz), Long.valueOf(this.hDB.dfS)});
                        this.hDB.hlt.selectTrack(0);
                        BufferInfo bufferInfo = new BufferInfo();
                        Object obj = null;
                        this.hDB.hDr.hDC = 3;
                        this.hDB.onStart();
                        ByteBuffer[] byteBufferArr = outputBuffers;
                        int i2 = 0;
                        Object obj2 = null;
                        while (obj == null && i2 < 10) {
                            try {
                                this.hDB.aDk();
                                if (!this.hDB.aDh()) {
                                    break;
                                }
                                Object obj3;
                                int dequeueOutputBuffer;
                                ByteBuffer byteBuffer;
                                byte[] bArr;
                                c cVar;
                                ByteBuffer[] outputBuffers2;
                                int i3 = i2 + 1;
                                if (obj2 == null) {
                                    i2 = this.hDB.hDx.dequeueInputBuffer(1000);
                                    if (i2 >= 0) {
                                        trackCount = this.hDB.hlt.readSampleData(inputBuffers[i2], 0);
                                        if (trackCount < 0) {
                                            v.d("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                            obj3 = 1;
                                            trackCount = 0;
                                        } else {
                                            this.hDB.presentationTimeUs = this.hDB.hlt.getSampleTime();
                                            this.hDB.nw(this.hDB.dfS == 0 ? 0 : (int) ((100 * this.hDB.presentationTimeUs) / this.hDB.dfS));
                                            obj3 = obj2;
                                        }
                                        this.hDB.hDx.queueInputBuffer(i2, 0, trackCount, this.hDB.presentationTimeUs, obj3 != null ? 4 : 0);
                                        if (obj3 == null) {
                                            this.hDB.hlt.advance();
                                        }
                                        dequeueOutputBuffer = this.hDB.hDx.dequeueOutputBuffer(bufferInfo, 1000);
                                        if (dequeueOutputBuffer >= 0) {
                                            if (bufferInfo.size > 0) {
                                                i3 = 0;
                                            }
                                            byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                            bArr = new byte[bufferInfo.size];
                                            byteBuffer.get(bArr);
                                            byteBuffer.clear();
                                            if (bArr.length > 0) {
                                                if (this.hDB.djg == null) {
                                                    cVar = this.hDB;
                                                    v.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
                                                    trackCount = cVar.hDz != 1 ? 4 : 12;
                                                    cVar.djg = new AudioTrack(3, cVar.dad, trackCount, 2, AudioTrack.getMinBufferSize(cVar.dad, trackCount, 2), 1);
                                                    if (cVar.djg == null && cVar.djg.getState() == 1) {
                                                        obj2 = 1;
                                                    } else {
                                                        v.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                        obj2 = null;
                                                    }
                                                    if (obj2 != null) {
                                                        v.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                        this.hDB.eF(true);
                                                        return;
                                                    }
                                                    this.hDB.djg.play();
                                                }
                                                this.hDB.djg.write(bArr, 0, bArr.length);
                                            }
                                            this.hDB.hDx.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            if ((bufferInfo.flags & 4) == 0) {
                                                v.d("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                                obj2 = 1;
                                            } else {
                                                obj2 = obj;
                                            }
                                            i2 = i3;
                                            obj = obj2;
                                            obj2 = obj3;
                                        } else if (dequeueOutputBuffer == -3) {
                                            outputBuffers2 = this.hDB.hDx.getOutputBuffers();
                                            v.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                            i2 = i3;
                                            byteBufferArr = outputBuffers2;
                                            obj2 = obj3;
                                        } else if (dequeueOutputBuffer != -2) {
                                            trackFormat = this.hDB.hDx.getOutputFormat();
                                            v.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                            this.hDB.dad = trackFormat.getInteger("sample-rate");
                                            this.hDB.hDz = trackFormat.getInteger("channel-count");
                                            c.c(this.hDB);
                                            i2 = i3;
                                            obj2 = obj3;
                                        } else {
                                            v.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                            i2 = i3;
                                            obj2 = obj3;
                                        }
                                    } else {
                                        v.e("MicroMsg.Music.MMPlayer", "inputBufIndex " + i2);
                                    }
                                }
                                obj3 = obj2;
                                dequeueOutputBuffer = this.hDB.hDx.dequeueOutputBuffer(bufferInfo, 1000);
                                if (dequeueOutputBuffer >= 0) {
                                    if (bufferInfo.size > 0) {
                                        i3 = 0;
                                    }
                                    byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                    bArr = new byte[bufferInfo.size];
                                    byteBuffer.get(bArr);
                                    byteBuffer.clear();
                                    if (bArr.length > 0) {
                                        if (this.hDB.djg == null) {
                                            cVar = this.hDB;
                                            v.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
                                            if (cVar.hDz != 1) {
                                            }
                                            cVar.djg = new AudioTrack(3, cVar.dad, trackCount, 2, AudioTrack.getMinBufferSize(cVar.dad, trackCount, 2), 1);
                                            if (cVar.djg == null) {
                                            }
                                            v.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                            obj2 = null;
                                            if (obj2 != null) {
                                                this.hDB.djg.play();
                                            } else {
                                                v.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                this.hDB.eF(true);
                                                return;
                                            }
                                        }
                                        this.hDB.djg.write(bArr, 0, bArr.length);
                                    }
                                    this.hDB.hDx.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    if ((bufferInfo.flags & 4) == 0) {
                                        obj2 = obj;
                                    } else {
                                        v.d("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                        obj2 = 1;
                                    }
                                    i2 = i3;
                                    obj = obj2;
                                    obj2 = obj3;
                                } else if (dequeueOutputBuffer == -3) {
                                    outputBuffers2 = this.hDB.hDx.getOutputBuffers();
                                    v.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                    i2 = i3;
                                    byteBufferArr = outputBuffers2;
                                    obj2 = obj3;
                                } else if (dequeueOutputBuffer != -2) {
                                    v.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                    i2 = i3;
                                    obj2 = obj3;
                                } else {
                                    trackFormat = this.hDB.hDx.getOutputFormat();
                                    v.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                    this.hDB.dad = trackFormat.getInteger("sample-rate");
                                    this.hDB.hDz = trackFormat.getInteger("channel-count");
                                    c.c(this.hDB);
                                    i2 = i3;
                                    obj2 = obj3;
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                                this.hDB.eF(true);
                            } finally {
                                c.a(this.hDB);
                                c.b(this.hDB);
                                c.c(this.hDB);
                                this.hDB.hDy = null;
                                this.hDB.hlu = null;
                                this.hDB.dad = 0;
                                this.hDB.hDz = 0;
                                this.hDB.presentationTimeUs = 0;
                                this.hDB.dfS = 0;
                            }
                        }
                        boolean z = (this.hDB.dfS / 1000) - (this.hDB.presentationTimeUs / 1000) < 2000;
                        if (i2 >= 10) {
                            this.hDB.eF(true);
                        } else {
                            this.hDB.eG(z);
                        }
                        c.a(this.hDB);
                        c.b(this.hDB);
                        c.c(this.hDB);
                        this.hDB.hDy = null;
                        this.hDB.hlu = null;
                        this.hDB.dad = 0;
                        this.hDB.hDz = 0;
                        this.hDB.presentationTimeUs = 0;
                        this.hDB.dfS = 0;
                        v.i("MicroMsg.Music.MMPlayer", "stopping...");
                    } catch (Throwable e2) {
                        v.a("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                        this.hDB.eF(true);
                        c.a(this.hDB);
                        c.b(this.hDB);
                    }
                } catch (Throwable e22) {
                    v.a("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                }
            } catch (Throwable e222) {
                v.a("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
                this.hDB.eF(true);
            }
        }
    };
    MediaCodec hDx;
    String hDy;
    int hDz = 0;
    MediaExtractor hlt;
    String hlu = null;
    long presentationTimeUs = 0;

    static /* synthetic */ void a(c cVar) {
        try {
            if (cVar.hlt != null) {
                cVar.hlt.release();
                cVar.hlt = null;
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void b(c cVar) {
        try {
            if (cVar.hDx != null) {
                cVar.hDx.stop();
                cVar.hDx.release();
                cVar.hDx = null;
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void c(c cVar) {
        try {
            if (cVar.djg != null) {
                cVar.djg.flush();
                cVar.djg.release();
                cVar.djg = null;
            }
        } catch (Exception e) {
        }
    }

    public final void xd(String str) {
        this.hDy = str;
    }

    public final int aDi() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.dfS / 1000);
    }

    public final void play() {
        v.i("MicroMsg.Music.MMPlayer", "play");
        if (!aDh()) {
            this.ecS = false;
            e.a(this.hDA, "music_player");
        } else if (aDh() && this.hDr.aDl()) {
            this.hDr.hDC = 3;
            aDj();
        }
    }

    private synchronized void aDj() {
        v.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
        } catch (Exception e) {
        }
    }

    public final void stop() {
        v.i("MicroMsg.Music.MMPlayer", "stop");
        this.ecS = true;
        if (this.hDr.aDl()) {
            aDj();
        }
    }

    public final void pause() {
        v.i("MicroMsg.Music.MMPlayer", "pause");
        if (aDh()) {
            this.hDr.hDC = 2;
        }
    }

    public final void seek(long j) {
        this.hlt.seekTo(1000 * j, 2);
    }

    public final synchronized void aDk() {
        while (aDh() && this.hDr.aDl()) {
            try {
                v.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final boolean isPlaying() {
        return this.hDr.isPlaying();
    }

    public final boolean aDh() {
        return !this.ecS;
    }

    protected final void eF(boolean z) {
        this.hDr.hDC = 4;
        this.ecS = true;
        super.eF(z);
    }

    protected final void eG(boolean z) {
        this.hDr.hDC = 4;
        this.ecS = true;
        super.eG(z);
    }
}
