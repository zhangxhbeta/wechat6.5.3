package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.v;

public final class n implements e {
    long ewI = 0;
    int fQm;
    int gVE;
    boolean hnC;
    long hnY = 0;
    int hpP = -1;
    volatile int hpQ = 0;
    int hpR = -1;
    int hpS = -1;
    int hpT = -1;
    int hpU = -1;

    public n(boolean z, int i, int i2, int i3) {
        this.hnC = z;
        this.hpR = i;
        this.gVE = i2;
        this.fQm = i3;
        v.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.hpR), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void stop() {
        this.hpP = -1;
        this.hpQ = 0;
        this.ewI = 0;
    }

    public final long aAC() {
        if (0 != this.ewI) {
            return System.currentTimeMillis() - this.ewI;
        }
        v.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
        return 0;
    }
}
