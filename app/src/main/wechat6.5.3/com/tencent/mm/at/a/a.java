package com.tencent.mm.at.a;

public final class a {
    public int dkP = 0;
    public int dkQ = 0;
    public int dkR = 0;
    public short[] dkS;

    public a(int i) {
        if (i <= 1) {
            i = 512;
        }
        this.dkS = new short[i];
    }

    public final int b(short[] sArr, int i) {
        int length;
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            return 0;
        }
        int length2 = this.dkS.length;
        if (length >= this.dkR) {
            length = this.dkR;
        }
        if (length <= length2 - this.dkP) {
            System.arraycopy(this.dkS, this.dkP, sArr, 0, length);
            this.dkP += length;
            if (this.dkP >= length2) {
                this.dkP = 0;
            }
        } else {
            length2 -= this.dkP;
            System.arraycopy(this.dkS, this.dkP, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.dkS, 0, sArr, length2, i2);
            this.dkP = i2;
        }
        this.dkR -= length;
        return length;
    }
}
