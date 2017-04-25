package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final int[] aGA = new int[0];
    public int hO;
    public int[] pCP;
    public int[] vV;

    public final /* synthetic */ Object clone() {
        return bOS();
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.vV = new int[10];
        this.pCP = new int[this.vV.length];
        this.hO = 0;
    }

    private static int zu(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a bOS() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.vV = (int[]) this.vV.clone();
                aVar.pCP = (int[]) this.pCP.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = a(this.vV, this.hO, i);
        if (a >= 0) {
            this.pCP[a] = i2;
            return;
        }
        a ^= -1;
        this.vV = b(this.vV, this.hO, a, i);
        this.pCP = b(this.pCP, this.hO, a, i2);
        this.hO++;
    }

    public final int indexOfKey(int i) {
        return a(this.vV, this.hO, i);
    }

    private static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public static int[] c(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[zu(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] b(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            Object obj = new int[zu(i)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i3;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            return obj;
        }
    }

    public final String toString() {
        if (this.hO <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.hO * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.hO; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.vV[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.pCP[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
