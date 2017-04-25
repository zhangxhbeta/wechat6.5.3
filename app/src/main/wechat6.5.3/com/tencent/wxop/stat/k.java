package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class k implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ e pLi = null;

    k(Context context, e eVar) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            d.pKH.error("The Context of StatService.onResume() can not be null!");
        } else {
            d.a(this.a, l.gY(this.a), this.pLi);
        }
    }
}
