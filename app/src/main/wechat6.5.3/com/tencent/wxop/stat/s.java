package com.tencent.wxop.stat;

import java.util.List;

final class s implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b = 1;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ r pLu;

    s(r rVar, List list, int i, boolean z, boolean z2) {
        this.pLu = rVar;
        this.a = list;
        this.c = z;
        this.d = true;
    }

    public final void run() {
        this.pLu.c(this.a, this.b, this.c);
        if (this.d) {
            this.a.clear();
        }
    }
}
