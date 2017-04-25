package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.d;

final class an implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Throwable pMi;

    an(Context context, Throwable th) {
        this.a = context;
        this.pMi = th;
    }

    public final void run() {
        try {
            if (b.bPX()) {
                new n(new a(this.a, d.a(this.a, false, null), this.pMi, d.pKT)).a();
            }
        } catch (Throwable th) {
            d.pKH.by("reportSdkSelfException error: " + th);
        }
    }
}
