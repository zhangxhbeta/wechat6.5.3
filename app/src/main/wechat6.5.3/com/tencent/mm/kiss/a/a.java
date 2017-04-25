package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a cln = new a();
    public HandlerThread clm = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        this.clm.start();
        this.mHandler = new Handler(this.clm.getLooper());
    }

    public static a vG() {
        return cln;
    }
}
