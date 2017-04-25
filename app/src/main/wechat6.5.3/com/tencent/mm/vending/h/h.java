package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class h extends d {
    Looper aJl;
    private String mType;
    public a pif;

    private h(Looper looper, a aVar, String str) {
        this.aJl = looper;
        this.pif = aVar;
        this.mType = str;
    }

    private h(Handler handler, String str) {
        this(new b(handler), str);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
    }

    public final String getType() {
        return this.mType;
    }

    public final void cancel() {
        this.pif.cp();
    }

    public final void g(Runnable runnable) {
        this.pif.f(runnable);
    }

    public final void d(Runnable runnable, long j) {
        if (j >= 0) {
            this.pif.c(runnable, j);
        } else {
            this.pif.f(runnable);
        }
    }
}
