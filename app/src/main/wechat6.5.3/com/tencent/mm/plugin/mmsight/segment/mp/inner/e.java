package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

abstract class e {
    protected String TAG;
    g htJ;
    int htK;
    MediaFormat htL;
    MediaCodec htM;
    private ByteBuffer[] htN;
    private ByteBuffer[] htO;
    private BufferInfo htP;
    boolean htQ;
    boolean htR;
    private List<a> htS;
    private boolean htT;
    private boolean htU;
    private b htV;
    boolean htW;
    long htX;
    a htY;

    static class a {
        int htZ;
        ByteBuffer hua;
        boolean hub;
        boolean huc;
        long presentationTimeUs;

        public a() {
            clear();
        }

        public final void clear() {
            this.htZ = -1;
            this.hua = null;
            this.presentationTimeUs = -1;
            this.hub = false;
            this.huc = false;
        }

        public final String toString() {
            return "FrameInfo{buffer=" + this.htZ + ", data=" + this.hua + ", presentationTimeUs=" + this.presentationTimeUs + ", endOfStream=" + this.hub + ", representationChanged=" + this.huc + '}';
        }
    }

    interface b {
        void aBi();
    }

    public e(g gVar, boolean z, int i, b bVar) {
        this.TAG = e.class.getSimpleName();
        this.TAG = getClass().getSimpleName();
        if (gVar == null || i == -1) {
            throw new IllegalArgumentException("no track specified");
        }
        this.htJ = gVar;
        this.htW = z;
        this.htK = i;
        this.htL = gVar.getTrackFormat(this.htK);
        this.htV = bVar;
        this.htM = MediaCodec.createDecoderByType(this.htL.getString("mime"));
        this.htX = Long.MIN_VALUE;
    }

    protected final void aBf() {
        int i = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.htL = this.htJ.getTrackFormat(this.htK);
        this.htM.stop();
        a(this.htM, this.htL);
        this.htM.start();
        this.htN = this.htM.getInputBuffers();
        this.htO = this.htM.getOutputBuffers();
        this.htP = new BufferInfo();
        this.htQ = false;
        this.htR = false;
        this.htS = new ArrayList();
        while (i < this.htO.length) {
            this.htS.add(new a());
            i++;
        }
        new StringBuilder("reinitCodec ").append(SystemClock.elapsedRealtime() - elapsedRealtime).append("ms");
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, null, null, 0);
    }

    protected boolean aBe() {
        return true;
    }

    public final boolean er(boolean z) {
        long j = 0;
        if (this.htQ || !aBe()) {
            return false;
        }
        if (this.htJ.huf.getSampleTrackIndex() == -1 || this.htJ.huf.getSampleTrackIndex() == this.htK) {
            boolean z2;
            int dequeueInputBuffer = this.htM.dequeueInputBuffer(0);
            if (dequeueInputBuffer >= 0) {
                int i;
                ByteBuffer byteBuffer = this.htN[dequeueInputBuffer];
                if (this.htJ.huf.getCachedDuration() > -1 && this.htV != null) {
                    this.htV.aBi();
                }
                int readSampleData = this.htJ.huf.readSampleData(byteBuffer, 0);
                if (readSampleData < 0) {
                    this.htQ = true;
                    readSampleData = 0;
                    z2 = false;
                } else {
                    j = this.htJ.huf.getSampleTime();
                    z2 = true;
                }
                MediaCodec mediaCodec = this.htM;
                if (this.htQ) {
                    i = 4;
                } else {
                    i = 0;
                }
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, j, i);
                if (!this.htQ) {
                    this.htJ.huf.advance();
                }
            } else {
                z2 = false;
            }
            return z2;
        } else if (z) {
            return this.htJ.huf.advance();
        } else {
            return false;
        }
    }

    public final a aBg() {
        if (this.htR) {
            return null;
        }
        int dequeueOutputBuffer = this.htM.dequeueOutputBuffer(this.htP, 0);
        boolean z = dequeueOutputBuffer >= 0 && (this.htP.flags & 4) != 0;
        this.htR = z;
        if (this.htR && this.htT) {
            aBf();
            this.htR = false;
            this.htT = false;
            this.htU = true;
        } else if (dequeueOutputBuffer >= 0) {
            ByteBuffer byteBuffer = this.htO[dequeueOutputBuffer];
            if (!(byteBuffer == null || this.htP.size == 0)) {
                byteBuffer.position(this.htP.offset);
                byteBuffer.limit(this.htP.offset + this.htP.size);
            }
            a aVar = (a) this.htS.get(0);
            aVar.htZ = dequeueOutputBuffer;
            aVar.hua = byteBuffer;
            aVar.presentationTimeUs = this.htP.presentationTimeUs;
            aVar.hub = this.htR;
            if (this.htU) {
                this.htU = false;
                aVar.huc = true;
            }
            if (aVar.hub) {
                return aVar;
            }
            this.htX = aVar.presentationTimeUs;
            return aVar;
        } else if (dequeueOutputBuffer == -3) {
            this.htO = this.htM.getOutputBuffers();
        } else if (dequeueOutputBuffer == -2) {
            MediaFormat outputFormat = this.htM.getOutputFormat();
            new StringBuilder("output format has changed to ").append(outputFormat);
            d(outputFormat);
        }
        return null;
    }

    public void a(a aVar, long j) {
        b(aVar);
    }

    public final void a(a aVar) {
        b(aVar);
    }

    public final void b(a aVar) {
        this.htM.releaseOutputBuffer(aVar.htZ, false);
        c(aVar);
    }

    protected final void c(a aVar) {
        aVar.clear();
        this.htS.add(aVar);
    }

    protected void d(MediaFormat mediaFormat) {
    }

    public final a aBh() {
        while (!this.htR) {
            a aBg = aBg();
            do {
            } while (er(true));
            if (aBg != null) {
                return aBg;
            }
        }
        return null;
    }

    public final void a(k kVar, long j) {
        this.htX = Long.MIN_VALUE;
        this.htY = a(kVar, j, this.htJ, this.htM);
    }

    protected a a(k kVar, long j, g gVar, MediaCodec mediaCodec) {
        if (this.htW) {
            this.htQ = false;
            this.htR = false;
            mediaCodec.flush();
            return null;
        }
        new StringBuilder("extractor current position: ").append(gVar.huf.getSampleTime());
        gVar.seekTo(j, kVar.hvb);
        new StringBuilder("extractor new position:     ").append(gVar.huf.getSampleTime());
        this.htQ = false;
        this.htR = false;
        mediaCodec.flush();
        return aBh();
    }
}
