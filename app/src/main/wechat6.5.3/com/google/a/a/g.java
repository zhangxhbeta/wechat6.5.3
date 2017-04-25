package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] aGA = new int[0];
    public static final long[] aGB = new long[0];
    public static final float[] aGC = new float[0];
    public static final double[] aGD = new double[0];
    public static final boolean[] aGE = new boolean[0];
    public static final byte[][] aGF = new byte[0][];
    public static final byte[] aGG = new byte[0];

    static int cz(int i) {
        return i & 7;
    }

    public static int cA(int i) {
        return i >>> 3;
    }

    static int ao(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) {
        return aVar.co(i);
    }

    public static final int b(a aVar, int i) {
        int i2 = 1;
        int position = aVar.getPosition();
        aVar.co(i);
        while (aVar.mG() == i) {
            aVar.co(i);
            i2++;
        }
        aVar.cr(position);
        return i2;
    }
}
