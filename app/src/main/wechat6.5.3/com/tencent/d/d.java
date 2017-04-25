package com.tencent.d;

public abstract class d<T extends e> {
    public int iUN;
    public final Object mLock = new Object();
    public T[] pHj = zD(20);

    public abstract T bPd();

    public abstract T[] zD(int i);

    public d(int i) {
    }

    public T bPe() {
        T t = null;
        synchronized (this.mLock) {
            if (this.iUN > 0) {
                this.iUN--;
                t = this.pHj[this.iUN];
                this.pHj[this.iUN] = null;
            }
        }
        return t;
    }
}
