package com.tencent.mm.ba;

import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] lVU;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public b(byte[] bArr, int i, int i2) {
        this.lVU = new byte[i2];
        System.arraycopy(bArr, i, this.lVU, 0, i2);
    }

    public static b f(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static b aT(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new b(bArr);
    }

    public static b Ir(String str) {
        try {
            b bVar = new b();
            bVar.lVU = str.getBytes("UTF-8");
            return bVar;
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final b uz(int i) {
        Object obj = new byte[i];
        if (this.lVU.length >= i) {
            System.arraycopy(this.lVU, 0, obj, 0, i - 1);
            this.lVU = obj;
        } else {
            System.arraycopy(this.lVU, 0, obj, 0, this.lVU.length);
            this.lVU = obj;
        }
        return this;
    }

    public final byte[] toByteArray() {
        int length = this.lVU.length;
        Object obj = new byte[length];
        System.arraycopy(this.lVU, 0, obj, 0, length);
        return obj;
    }

    public final byte[] getBytes() {
        return this.lVU;
    }

    public final String brp() {
        int i = 0;
        while (i < this.lVU.length && this.lVU[i] != (byte) 0) {
            try {
                i++;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?");
            }
        }
        return new String(this.lVU, 0, i, "UTF-8");
    }
}
