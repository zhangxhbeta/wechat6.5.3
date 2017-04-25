package com.tencent.gmtrace;

import java.util.Arrays;

public class GMTraceBitSet {
    private int bitNum;
    private byte[] boolFilter;

    public GMTraceBitSet(int i) {
        this.bitNum = i;
        if (i % 8 == 0) {
            this.boolFilter = new byte[(i / 8)];
        } else {
            this.boolFilter = new byte[((i / 8) + 1)];
        }
    }

    public void set(int i) {
        if (i >= this.bitNum) {
            i %= this.bitNum;
        }
        int i2 = i / 8;
        this.boolFilter[i2] = (byte) (((byte) (1 << (i % 8))) | this.boolFilter[i2]);
    }

    public void unset(int i) {
        if (i >= this.bitNum) {
            i %= this.bitNum;
        }
        int i2 = i / 8;
        this.boolFilter[i2] = (byte) (((byte) ((1 << (i % 8)) ^ -1)) & this.boolFilter[i2]);
    }

    public boolean get(int i) {
        if (i >= this.bitNum) {
            i %= this.bitNum;
        }
        if ((this.boolFilter[i / 8] & ((byte) (1 << (i % 8)))) > 0) {
            return true;
        }
        return false;
    }

    public void clear() {
        Arrays.fill(this.boolFilter, (byte) 0);
    }
}
