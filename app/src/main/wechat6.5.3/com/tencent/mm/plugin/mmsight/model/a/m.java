package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

@TargetApi(18)
@Deprecated
public final class m implements d {
    boolean bhY;
    private MediaMuxer hpL;
    private int hpM;
    private int hpN;
    long hpO;

    public final boolean aAq() {
        return false;
    }

    public final synchronized void a(MediaFormat mediaFormat) {
        try {
            if (this.hpL != null && this.hpM == -1) {
                this.hpM = this.hpL.addTrack(mediaFormat);
                v.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[]{Integer.valueOf(this.hpM)});
                if (!(this.bhY || this.hpM == -1 || this.hpN == -1)) {
                    v.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.hpL.start();
                    this.bhY = true;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void b(MediaFormat mediaFormat) {
        try {
            if (this.hpL != null && this.hpN == -1) {
                this.hpN = this.hpL.addTrack(mediaFormat);
                v.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[]{Integer.valueOf(this.hpN)});
                if (!(this.bhY || this.hpN == -1 || this.hpM == -1)) {
                    v.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.hpL.start();
                    this.bhY = true;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        try {
            if (!(this.hpL == null || this.hpN == -1 || !this.bhY || byteBuffer == null || bufferInfo == null)) {
                long j = bufferInfo.presentationTimeUs;
                bufferInfo.presentationTimeUs = (System.nanoTime() - this.hpO) / 1000;
                long Nj = be.Nj();
                this.hpL.writeSampleData(this.hpN, byteBuffer, bufferInfo);
                v.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(be.az(Nj)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        int i = 1;
        synchronized (this) {
            try {
                if (!(this.hpL == null || this.hpM == -1 || !this.bhY)) {
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo == null) {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - this.hpO) / 1000;
                        bufferInfo.flags = 1;
                        long Nj = be.Nj();
                        this.hpL.writeSampleData(this.hpM, byteBuffer, bufferInfo);
                        v.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(be.az(Nj)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
