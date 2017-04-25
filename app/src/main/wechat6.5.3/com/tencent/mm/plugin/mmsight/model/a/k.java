package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class k implements d {
    private int audioSampleRate;
    private String bhD;
    private int hoh;
    private float hpo;
    private int hpx;
    private int hpy;

    public k(int i, String str, float f, int i2, int i3, int i4) {
        this.hoh = i;
        this.bhD = str;
        this.hpo = f;
        this.hpx = i2;
        this.hpy = i3;
        this.audioSampleRate = i4;
        v.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s", new Object[]{Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final boolean aAq() {
        long Nj = be.Nj();
        v.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", new Object[]{Integer.valueOf(SightVideoJNI.muxing(this.hoh, null, this.audioSampleRate, 1024, 2, 1, 0, this.bhD, this.hpo, Math.max(BaseReportManager.MAX_READ_COUNT, this.hpy), this.hpx, b.iTs, 8, 2, 23.0f, null, 0)), Long.valueOf(be.az(Nj))});
        return SightVideoJNI.muxing(this.hoh, null, this.audioSampleRate, 1024, 2, 1, 0, this.bhD, this.hpo, Math.max(BaseReportManager.MAX_READ_COUNT, this.hpy), this.hpx, b.iTs, 8, 2, 23.0f, null, 0) >= 0;
    }
}
