package com.tencent.mm.performance.d;

public abstract class a {
    protected long dnS = -1;
    public long dnT = -1;

    public abstract String MK();

    public abstract void ML();

    public final boolean MM() {
        if (this.dnT == -1) {
            return true;
        }
        if (this.dnS == -1) {
            this.dnS = System.currentTimeMillis();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dnS < this.dnT) {
            return false;
        }
        this.dnS = currentTimeMillis;
        return true;
    }
}
