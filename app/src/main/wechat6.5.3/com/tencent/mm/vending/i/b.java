package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b {
    private static b pij = new b();
    private Handler mHandler;
    public HandlerThread pii = new HandlerThread("Vending-LogicThread");

    private b() {
        this.pii.start();
        this.mHandler = new Handler(this.pii.getLooper());
    }

    public static b bKT() {
        return pij;
    }
}
