package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;

final class am implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ e pLi = null;

    am(Context context, e eVar) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            d.pKH.error("The Context of StatService.onPause() can not be null!");
        } else {
            d.b(this.a, l.gY(this.a), this.pLi);
        }
    }
}
