package com.google.android.gms.c;

public final class bh {
    public static final int[] aAX = new int[0];
    public static final long[] aAY = new long[0];
    public static final float[] aAZ = new float[0];
    public static final double[] aBa = new double[0];
    public static final boolean[] aBb = new boolean[0];
    public static final String[] aBc = new String[0];
    public static final byte[][] aBd = new byte[0][];
    public static final byte[] aBe = new byte[0];

    static int ah(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int b(aw awVar, int i) {
        int i2 = 1;
        int position = awVar.getPosition();
        awVar.bU(i);
        while (awVar.lg() == i) {
            awVar.bU(i);
            i2++;
        }
        awVar.bX(position);
        return i2;
    }

    static int ci(int i) {
        return i & 7;
    }

    public static int cj(int i) {
        return i >>> 3;
    }
}
