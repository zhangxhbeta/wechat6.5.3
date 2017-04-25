package com.tencent.wxop.stat;

final class w implements Runnable {
    final /* synthetic */ af pKd;
    final /* synthetic */ r pLy;

    w(r rVar, af afVar) {
        this.pLy = rVar;
        this.pKd = afVar;
    }

    public final void run() {
        this.pLy.a(this.pKd);
    }
}
