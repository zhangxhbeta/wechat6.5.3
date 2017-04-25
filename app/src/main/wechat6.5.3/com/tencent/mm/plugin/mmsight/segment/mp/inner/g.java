package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.media.MediaExtractor;
import android.media.MediaFormat;

public final class g {
    MediaExtractor huf;

    public g() {
        if (this.huf != null) {
            this.huf.release();
        }
        this.huf = new MediaExtractor();
    }

    public final void setDataSource(String str) {
        this.huf.setDataSource(str);
    }

    public final MediaFormat getTrackFormat(int i) {
        MediaFormat trackFormat = this.huf.getTrackFormat(i);
        if (trackFormat.getString("mime").startsWith("video/")) {
            trackFormat.setFloat("mpx-dar", ((float) trackFormat.getInteger("width")) / ((float) trackFormat.getInteger("height")));
        }
        return trackFormat;
    }

    public final void selectTrack(int i) {
        this.huf.selectTrack(i);
    }

    public final void seekTo(long j, int i) {
        this.huf.seekTo(j, i);
    }
}
