package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

final class d extends e {
    private a htI;

    public d(g gVar, boolean z, int i, b bVar, a aVar) {
        super(gVar, z, i, bVar);
        this.htI = aVar;
        aBf();
    }

    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        super.a(mediaCodec, mediaFormat);
        this.htI.c(mediaFormat);
    }

    protected final boolean aBe() {
        if (this.htW) {
            return super.aBe();
        }
        return this.htI.aAW() < 200000;
    }

    public final void a(a aVar, long j) {
        a aVar2 = this.htI;
        ByteBuffer byteBuffer = aVar.hua;
        long j2 = aVar.presentationTimeUs;
        int remaining = byteBuffer.remaining();
        if (aVar2.htm < remaining) {
            aVar2.htm = remaining;
            aVar2.c(aVar2.hoj);
        }
        if (aVar2.htw == a.htk) {
            aVar2.htw = j2;
            aVar2.htx = 0;
            long aAX = aVar2.aAX();
            if (aAX > 0) {
                aVar2.htw -= aAX;
            }
        }
        aVar2.hto.a(byteBuffer, j2);
        a aVar3 = aVar2.htq;
        synchronized (aVar3.hty) {
            aVar3.hty.notify();
        }
        b(aVar);
    }

    protected final void d(MediaFormat mediaFormat) {
        this.htI.c(mediaFormat);
    }
}
