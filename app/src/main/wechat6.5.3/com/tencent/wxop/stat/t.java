package com.tencent.wxop.stat;

import java.util.List;

final class t implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c = true;
    final /* synthetic */ r pLv;

    t(r rVar, List list, boolean z, boolean z2) {
        this.pLv = rVar;
        this.a = list;
        this.b = z;
    }

    public final void run() {
        this.pLv.h(this.a, this.b);
        if (this.c) {
            this.a.clear();
        }
    }
}
