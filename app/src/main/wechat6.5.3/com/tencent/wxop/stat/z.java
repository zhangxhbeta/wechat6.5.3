package com.tencent.wxop.stat;

final class z implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ r pLy;

    z(r rVar, int i) {
        this.pLy = rVar;
        this.a = i;
    }

    public final void run() {
        r.a(this.pLy, this.a, true);
        r.a(this.pLy, this.a, false);
    }
}
