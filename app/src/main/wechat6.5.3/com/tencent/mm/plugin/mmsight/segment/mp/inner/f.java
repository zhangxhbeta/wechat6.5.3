package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;

final class f extends e {
    private Surface hud;
    private boolean hue;

    public f(g gVar, int i, b bVar, Surface surface, boolean z) {
        super(gVar, false, i, bVar);
        this.hud = surface;
        this.hue = z;
        aBf();
    }

    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, this.hud, null, 0);
    }

    public final void a(Surface surface) {
        if (surface == null) {
            throw new RuntimeException("surface must not be null");
        }
        this.hud = surface;
        aBf();
    }

    public final int getVideoWidth() {
        MediaFormat mediaFormat = this.htL;
        if (mediaFormat == null) {
            return 0;
        }
        return (int) (mediaFormat.getFloat("mpx-dar") * ((float) mediaFormat.getInteger("height")));
    }

    public final int getVideoHeight() {
        MediaFormat mediaFormat = this.htL;
        return mediaFormat != null ? mediaFormat.getInteger("height") : 0;
    }

    @SuppressLint({"NewApi"})
    public final void a(a aVar, long j) {
        if (this.hue) {
            this.htM.releaseOutputBuffer(aVar.htZ, System.nanoTime() + (1000 * j));
            c(aVar);
            return;
        }
        a(aVar, true);
    }

    private void a(a aVar, boolean z) {
        this.htM.releaseOutputBuffer(aVar.htZ, z);
        c(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final com.tencent.mm.plugin.mmsight.segment.mp.inner.e.a a(com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k r19, long r20, com.tencent.mm.plugin.mmsight.segment.mp.inner.g r22, android.media.MediaCodec r23) {
        /*
        r18 = this;
        r4 = r20;
        r3 = r19;
        r2 = r18;
    L_0x0006:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r4 / r6;
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.FAST;
        if (r3 == r6) goto L_0x001a;
    L_0x000e:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.FAST_TO_CLOSEST_SYNC;
        if (r3 == r6) goto L_0x001a;
    L_0x0012:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.FAST_TO_PREVIOUS_SYNC;
        if (r3 == r6) goto L_0x001a;
    L_0x0016:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.FAST_TO_NEXT_SYNC;
        if (r3 != r6) goto L_0x003b;
    L_0x001a:
        r6 = r22;
        r7 = r23;
        r2 = super.a(r3, r4, r6, r7);
        r3 = new java.lang.StringBuilder;
        r6 = "fast seek to ";
        r3.<init>(r6);
        r3 = r3.append(r4);
        r4 = " arrived at ";
        r3 = r3.append(r4);
        r4 = r2.presentationTimeUs;
        r3.append(r4);
    L_0x003a:
        return r2;
    L_0x003b:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.FAST_EXACT;
        if (r3 != r6) goto L_0x0063;
    L_0x003f:
        r0 = r22;
        r1 = r23;
        r2.a(r4, r0, r1);
        r2 = r2.aBh();
        r3 = new java.lang.StringBuilder;
        r6 = "fast_exact seek to ";
        r3.<init>(r6);
        r3 = r3.append(r4);
        r4 = " arrived at ";
        r3 = r3.append(r4);
        r4 = r2.presentationTimeUs;
        r3.append(r4);
        goto L_0x003a;
    L_0x0063:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.PRECISE;
        if (r3 == r6) goto L_0x006b;
    L_0x0067:
        r6 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.EXACT;
        if (r3 != r6) goto L_0x00db;
    L_0x006b:
        r6 = r22;
        r7 = r23;
        r8 = super.a(r3, r4, r6, r7);
        r9 = 0;
        r4 = -1;
        r6 = r8.presentationTimeUs;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r12;
        r16 = r10;
        r10 = r6;
        r6 = r16;
    L_0x0080:
        r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r12 >= 0) goto L_0x00a9;
    L_0x0084:
        r9 = r9 + 1;
        r10 = r2.htR;
        if (r10 == 0) goto L_0x008f;
    L_0x008a:
        r6 = r8.presentationTimeUs;
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r10;
    L_0x008f:
        r10 = r8.hub;
        if (r10 == 0) goto L_0x0099;
    L_0x0093:
        r6 = 0;
        r2.a(r8, r6);
        goto L_0x0006;
    L_0x0099:
        r4 = r8.presentationTimeUs;
        r10 = 0;
        r2.a(r8, r10);
        r8 = r2.aBh();
        r10 = r8.presentationTimeUs;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        goto L_0x0080;
    L_0x00a9:
        r12 = new java.lang.StringBuilder;
        r13 = "frame new position:         ";
        r12.<init>(r13);
        r14 = r8.presentationTimeUs;
        r12.append(r14);
        r12 = new java.lang.StringBuilder;
        r13 = "seeking finished, skipped ";
        r12.<init>(r13);
        r12 = r12.append(r9);
        r13 = " frames";
        r12.append(r13);
        r12 = com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k.EXACT;
        if (r3 != r12) goto L_0x00d8;
    L_0x00cc:
        r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x00d8;
    L_0x00d0:
        if (r9 == 0) goto L_0x00d8;
    L_0x00d2:
        r6 = 0;
        r2.a(r8, r6);
        goto L_0x0006;
    L_0x00d8:
        r2 = r8;
        goto L_0x003a;
    L_0x00db:
        r6 = r22;
        r7 = r23;
        r2 = super.a(r3, r4, r6, r7);
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.mp.inner.f.a(com.tencent.mm.plugin.mmsight.segment.mp.inner.h$k, long, com.tencent.mm.plugin.mmsight.segment.mp.inner.g, android.media.MediaCodec):com.tencent.mm.plugin.mmsight.segment.mp.inner.e$a");
    }

    private long a(long j, g gVar, MediaCodec mediaCodec) {
        mediaCodec.flush();
        gVar.seekTo(j, 0);
        if (gVar.huf.getSampleTime() == j) {
            return j;
        }
        if (!this.htW) {
            while (true) {
                int sampleTrackIndex = this.htJ.huf.getSampleTrackIndex();
                if (sampleTrackIndex == -1 || sampleTrackIndex == this.htK || this.htQ) {
                    break;
                }
                this.htJ.huf.advance();
            }
        }
        er(false);
        gVar.seekTo(j, 0);
        long j2 = Long.MAX_VALUE;
        long j3 = 0;
        int i = 0;
        while (gVar.huf.advance() && i < 20) {
            long sampleTime = j - gVar.huf.getSampleTime();
            if (sampleTime >= 0 && sampleTime < r0) {
                j3 = gVar.huf.getSampleTime();
                j2 = sampleTime;
            }
            if (sampleTime < 0) {
                i++;
            }
        }
        gVar.seekTo(j3, 0);
        while (gVar.huf.getSampleTime() != j3) {
            gVar.huf.advance();
        }
        new StringBuilder("exact fastseek match:       ").append(gVar.huf.getSampleTime());
        return j3;
    }
}
