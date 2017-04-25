package com.tencent.mm.plugin.nfc.a;

import com.tencent.mm.plugin.nfc.c.a;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] hHO;

    public c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("apdu is null");
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        if (bArr2.length < 2) {
            throw new IllegalArgumentException("apdu must be at least 2 bytes long");
        }
        this.hHO = bArr2;
    }

    public final short aDS() {
        return (short) (this.hHO[this.hHO.length - 2] & 255);
    }

    public final short aDT() {
        return (short) (this.hHO[this.hHO.length - 1] & 255);
    }

    public final String toString() {
        return a.ax(this.hHO);
    }

    public final void a(c cVar) {
        int length = this.hHO.length;
        this.hHO = Arrays.copyOf(this.hHO, (this.hHO.length + cVar.hHO.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) cVar.hHO.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.hHO[i] = bArr[i2];
            i2++;
            i = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.hHO, ((c) obj).hHO);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.hHO);
    }
}
