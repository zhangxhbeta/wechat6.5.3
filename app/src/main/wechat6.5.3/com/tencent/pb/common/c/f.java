package com.tencent.pb.common.c;

public abstract class f<T> {
    private T psW;

    public abstract T bMm();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.psW == null) {
                this.psW = bMm();
            }
            t = this.psW;
        }
        return t;
    }
}
