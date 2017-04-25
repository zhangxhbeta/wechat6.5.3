package android.support.v7.widget;

final class ag {
    int aaL = 0;
    int aaM = 0;
    int aaN = Integer.MIN_VALUE;
    int aaO = 0;
    int aaP = 0;
    boolean aaQ = false;
    boolean gc = false;
    int vL = Integer.MIN_VALUE;

    ag() {
    }

    public final void Y(int i, int i2) {
        this.aaN = i;
        this.vL = i2;
        this.aaQ = true;
        if (this.gc) {
            if (i2 != Integer.MIN_VALUE) {
                this.aaL = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.aaM = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.aaL = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.aaM = i2;
        }
    }
}
