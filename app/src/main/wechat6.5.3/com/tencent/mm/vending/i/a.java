package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a pih = new a();
    private Handler mHandler;
    public HandlerThread pig = new HandlerThread("Vending-HeavyWorkThread", 10);

    private a() {
        this.pig.start();
        this.mHandler = new Handler(this.pig.getLooper());
    }

    public static a bKS() {
        return pih;
    }
}
