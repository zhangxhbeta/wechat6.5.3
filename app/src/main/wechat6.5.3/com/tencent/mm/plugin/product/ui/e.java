package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.v;

public final class e {
    int hRW;
    int hRX;

    public e(int i, int i2) {
        this.hRX = i;
        this.hRW = i2;
    }

    public final boolean aGv() {
        boolean z = (this.hRX & 1) > 0;
        v.d("MicroMsg.MallProductConfig", "isFreePost, ret = " + z);
        return z;
    }
}
