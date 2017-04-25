package com.tencent.mm.app;

import android.os.HandlerThread;
import com.tencent.mm.av.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.h.d;

public final class h {
    static h aQU;
    HandlerThread aQV;
    d aQW;
    ac handler = new ac(this.aQV.getLooper());

    public h(String str) {
        this.aQV = e.bJ(str, 10);
        this.aQV.start();
        this.aQW = new com.tencent.mm.vending.h.h(b.b(this.handler), str);
    }
}
