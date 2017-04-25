package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class x extends BroadcastReceiver {
    final /* synthetic */ f pLz;

    x(f fVar) {
        this.pLz = fVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.pLz.pKL != null) {
            this.pLz.pKL.a(new ac(this));
        }
    }
}
