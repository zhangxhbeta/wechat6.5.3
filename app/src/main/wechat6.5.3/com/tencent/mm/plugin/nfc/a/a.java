package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] hHO;
    private transient int hHP;
    private transient int hHQ;
    private transient int hHR;

    public a(byte[] bArr) {
        this.hHO = (byte[]) bArr.clone();
        aDR();
    }

    public a(String str) {
        this.hHO = com.tencent.mm.plugin.nfc.c.a.xk(str);
        aDR();
    }

    private void aDR() {
        int i = 65536;
        int i2 = 256;
        if (this.hHO.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (this.hHO.length != 4) {
            int i3 = this.hHO[4] & 255;
            if (this.hHO.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.hHQ = i2;
            } else if (i3 != 0) {
                if (this.hHO.length == i3 + 5) {
                    this.hHP = i3;
                    this.hHR = 5;
                } else if (this.hHO.length == i3 + 6) {
                    this.hHP = i3;
                    this.hHR = 5;
                    i3 = this.hHO[this.hHO.length - 1] & 255;
                    if (i3 != 0) {
                        i2 = i3;
                    }
                    this.hHQ = i2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.hHO.length + ", b1=" + i3);
                }
            } else if (this.hHO.length < 7) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.hHO.length + ", b1=" + i3);
            } else {
                i2 = ((this.hHO[5] & 255) << 8) | (this.hHO[6] & 255);
                if (this.hHO.length == 7) {
                    if (i2 == 0) {
                        i2 = 65536;
                    }
                    this.hHQ = i2;
                } else if (i2 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.hHO.length + ", b1=" + i3 + ", b2||b3=" + i2);
                } else if (this.hHO.length == i2 + 7) {
                    this.hHP = i2;
                    this.hHR = 7;
                } else if (this.hHO.length == i2 + 9) {
                    this.hHP = i2;
                    this.hHR = 7;
                    i2 = this.hHO.length - 2;
                    i2 = (this.hHO[i2 + 1] & 255) | ((this.hHO[i2] & 255) << 8);
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.hHQ = i;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.hHO.length + ", b1=" + i3 + ", b2||b3=" + i2);
                }
            }
        }
    }

    public final void nE(int i) {
        this.hHQ = i;
        this.hHO[this.hHO.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        return (byte[]) this.hHO.clone();
    }

    public final String toString() {
        return com.tencent.mm.plugin.nfc.c.a.ax(this.hHO);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(this.hHO, ((a) obj).hHO);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.hHO);
    }
}
