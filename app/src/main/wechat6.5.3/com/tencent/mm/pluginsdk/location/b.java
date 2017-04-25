package com.tencent.mm.pluginsdk.location;

public final class b {
    public int bhu;
    public float cJq;
    public float cJr;
    public long lyQ;
    public int scene;

    public b(long j, float f, float f2, int i, int i2) {
        this.cJq = f;
        this.cJr = f2;
        this.bhu = i;
        this.scene = i2;
        this.lyQ = j;
    }

    public final String toString() {
        return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.cJq * 1000000.0f)), Integer.valueOf((int) (this.cJr * 1000000.0f)), Integer.valueOf(this.bhu)});
    }
}
