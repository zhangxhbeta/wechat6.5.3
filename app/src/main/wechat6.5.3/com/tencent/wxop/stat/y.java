package com.tencent.wxop.stat;

import java.util.List;

final class y implements ah {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ r pLA;

    y(r rVar, List list, boolean z) {
        this.pLA = rVar;
        this.a = list;
        this.b = z;
    }

    public final void a() {
        d.c();
        r rVar = this.pLA;
        List list = this.a;
        boolean z = this.b;
        if (rVar.pKL != null) {
            rVar.pKL.a(new t(rVar, list, z, true));
        }
    }

    public final void b() {
        d.d();
        r rVar = this.pLA;
        List list = this.a;
        boolean z = this.b;
        if (rVar.pKL != null) {
            rVar.pKL.a(new s(rVar, list, 1, z, true));
        }
    }
}
