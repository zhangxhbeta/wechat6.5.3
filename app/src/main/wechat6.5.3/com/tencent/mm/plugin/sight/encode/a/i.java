package com.tencent.mm.plugin.sight.encode.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class i {
    long ewI = 0;
    long hnY = 0;
    int hpP = -1;
    int hpQ = 0;

    public final void stop() {
        this.hpP = -1;
        this.hpQ = 0;
        this.ewI = 0;
    }

    public final long aAC() {
        if (0 != this.ewI) {
            return be.az(this.ewI);
        }
        v.w("MicroMsg.SightYUVRecorder", "do not start record");
        return 0;
    }
}
