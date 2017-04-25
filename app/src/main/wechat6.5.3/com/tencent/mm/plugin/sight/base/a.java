package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.be;

public final class a {
    public int cGk = 0;
    public int cGx = 0;
    public int height = 0;
    public int hpy = 0;
    public int hqh = 0;
    public int iTr = 0;
    public int width = 0;

    public final int aOM() {
        return be.ee((long) this.hpy);
    }

    public final String toString() {
        return "[ videoDuration: " + this.hpy + " videoBitrate: " + this.cGx + " width: " + this.width + " height: " + this.height + " frameRate: " + this.hqh + " audioChannel: " + this.iTr + " audioBitrate: " + this.cGk + "]";
    }
}
