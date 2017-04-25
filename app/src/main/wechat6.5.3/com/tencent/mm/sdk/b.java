package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.aw;

public class b<T> extends aw<T> {
    private final Object mLock = new Object();

    public b() {
        super(20);
    }

    public final T bJ() {
        T bJ;
        synchronized (this.mLock) {
            bJ = super.bJ();
        }
        return bJ;
    }

    public final boolean i(T t) {
        boolean i;
        synchronized (this.mLock) {
            i = super.i(t);
        }
        return i;
    }
}
