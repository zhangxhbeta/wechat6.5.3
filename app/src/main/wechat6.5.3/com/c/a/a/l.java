package com.c.a.a;

import java.util.Arrays;

final class l {
    float aJr;
    long aJv;
    private final float[] aJw = new float[3];
    private int aJx;
    private long aJy;
    long aJz;

    l() {
    }

    final void a(float f, int i, long j) {
        long j2 = j - this.aJy;
        if (j2 > this.aJv) {
            Arrays.fill(this.aJw, 0.0f);
            this.aJx = 0;
            this.aJy = 0;
            this.aJz = 0;
            this.aJr = 0.0f;
        } else {
            this.aJz = j2 + this.aJz;
        }
        this.aJw[0] = this.aJw[1];
        this.aJw[1] = this.aJw[2];
        this.aJw[2] = f;
        if (this.aJw[2] != 0.0f) {
            float f2 = this.aJw[0] != 0.0f ? ((this.aJw[0] + this.aJw[1]) + this.aJw[2]) / 3.0f : this.aJw[1] != 0.0f ? (this.aJw[1] + this.aJw[2]) / 2.0f : this.aJw[2];
            this.aJr = ((((float) i) / (f2 + (this.aJw[2] * 3.0f))) * y.aNC) + ((y.aND * ((float) (i - this.aJx))) / ((float) ((this.aJx + i) + 1)));
        }
        this.aJx = i;
        this.aJy = j;
    }
}
