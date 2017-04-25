package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.f.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements f {
    private boolean gWB = false;
    private long hlp;
    private long hlq;
    private a hqx;
    private String hqy;
    private byte[] hqz = null;

    public final int e(String str, long j, long j2) {
        v.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        this.hqy = str;
        this.hlp = j;
        this.hlq = j2;
        if (be.kS(str)) {
            return -1;
        }
        long Nj = be.Nj();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        v.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(be.az(Nj))});
        return ffmpegOpenAndSeekFile;
    }

    public final void t(Runnable runnable) {
        v.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.gWB = true;
        while (this.gWB) {
            long Nj = be.Nj();
            this.hqz = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.hqz);
            v.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(be.az(Nj))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.hqz == null || ffmpegCheckIfReachEndTimestamp) {
                v.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                this.gWB = false;
                runnable.run();
                return;
            } else if (this.hqx != null) {
                this.hqx.av(this.hqz);
            }
        }
    }

    public final void a(a aVar) {
        this.hqx = aVar;
    }

    public final Point aAH() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }

    public final void stop() {
        v.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[]{Boolean.valueOf(this.gWB)});
        this.gWB = false;
    }

    public final int aAI() {
        return 2;
    }
}
