package com.tencent.mm.plugin.mmsight.segment.mp.inner;

final class j {
    double aIr = 1.0d;
    private long mStartTime;

    public j() {
        ci(0);
    }

    public final void ci(long j) {
        this.mStartTime = aBo() - j;
    }

    public final long cj(long j) {
        return j - (aBo() - this.mStartTime);
    }

    private long aBo() {
        return (long) (((double) (System.nanoTime() / 1000)) * this.aIr);
    }
}
