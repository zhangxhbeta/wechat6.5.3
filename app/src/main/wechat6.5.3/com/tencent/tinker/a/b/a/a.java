package com.tencent.tinker.a.b.a;

public abstract class a {
    final com.tencent.tinker.a.c.a pBX = new com.tencent.tinker.a.c.a();
    public int pBY = 0;

    public final int bOQ() {
        int indexOfKey = this.pBX.indexOfKey(this.pBY);
        if (indexOfKey < 0) {
            return this.pBY;
        }
        return this.pBX.pCP[indexOfKey];
    }

    public final void dM(int i, int i2) {
        this.pBX.put(i, i2);
    }

    protected final void bOR() {
        this.pBY++;
    }
}
