package com.tencent.mm.modelcontrol;

public final class f implements Comparable {
    public int cGq;
    public int cGr;
    public int cGs;
    public int cGt;
    public int cGu;
    public int cGv;
    public int cGw;

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.cGq = i;
        this.cGr = i2;
        this.cGs = i3;
        this.cGt = i4;
        this.cGu = i5;
        this.cGv = i6;
        this.cGw = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return 0;
        }
        return this.cGq - ((f) obj).cGq;
    }
}
