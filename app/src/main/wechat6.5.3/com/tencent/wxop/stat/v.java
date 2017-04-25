package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.b;

final class v implements Runnable {
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ b pLj;
    final /* synthetic */ r pLu;
    final /* synthetic */ ah pLx;

    v(r rVar, b bVar, ah ahVar, boolean z, boolean z2) {
        this.pLu = rVar;
        this.pLj = bVar;
        this.pLx = ahVar;
        this.c = z;
        this.d = z2;
    }

    public final void run() {
        this.pLu.a(this.pLj, this.pLx, this.c, this.d);
    }
}
