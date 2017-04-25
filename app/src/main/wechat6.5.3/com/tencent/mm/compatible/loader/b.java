package com.tencent.mm.compatible.loader;

public final class b<E> {
    static final Object vB = new Object();
    int hO;
    boolean vC;
    long[] vD;
    Object[] vE;

    public final void put(long j, E e) {
        int b = b(this.vD, this.hO, j);
        if (b >= 0) {
            this.vE[b] = e;
            return;
        }
        b ^= -1;
        if (b >= this.hO || this.vE[b] != vB) {
            int i;
            if (this.vC && this.hO >= this.vD.length) {
                int i2 = this.hO;
                long[] jArr = this.vD;
                Object[] objArr = this.vE;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr[i];
                    if (obj != vB) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr[b] = obj;
                        }
                        b++;
                    }
                }
                this.vC = false;
                this.hO = b;
                b = b(this.vD, this.hO, j) ^ -1;
            }
            if (this.hO >= this.vD.length) {
                i = a.Q(this.hO + 1);
                Object obj2 = new long[i];
                Object obj3 = new Object[i];
                System.arraycopy(this.vD, 0, obj2, 0, this.vD.length);
                System.arraycopy(this.vE, 0, obj3, 0, this.vE.length);
                this.vD = obj2;
                this.vE = obj3;
            }
            if (this.hO - b != 0) {
                System.arraycopy(this.vD, b, this.vD, b + 1, this.hO - b);
                System.arraycopy(this.vE, b, this.vE, b + 1, this.hO - b);
            }
            this.vD[b] = j;
            this.vE[b] = e;
            this.hO++;
            return;
        }
        this.vD[b] = j;
        this.vE[b] = e;
    }

    static int b(long[] jArr, int i, long j) {
        int i2 = -1;
        int i3 = i + 0;
        while (i3 - i2 > 1) {
            int i4 = (i3 + i2) / 2;
            if (jArr[i4] < j) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        if (i3 == i + 0) {
            return (i + 0) ^ -1;
        }
        return jArr[i3] != j ? i3 ^ -1 : i3;
    }
}
