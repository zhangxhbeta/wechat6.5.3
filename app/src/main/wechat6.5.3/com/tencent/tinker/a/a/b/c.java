package com.tencent.tinker.a.a.b;

public final class c {
    public static int a(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (65535 & s2) ? -1 : 1;
    }

    public static int dK(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & 4294967295L) < (((long) i2) & 4294967295L) ? -1 : 1;
    }

    public static int m(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            length2 = b == b2 ? 0 : (b & 255) < (b2 & 255) ? -1 : 1;
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    public static int a(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = a(sArr[i], sArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    public static int dL(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = dL(iArr[i], iArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }

    public static <T extends Comparable<T>> int a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            length2 = tArr[i].compareTo(tArr2[i]);
            if (length2 != 0) {
                return length2;
            }
        }
        return 0;
    }
}
