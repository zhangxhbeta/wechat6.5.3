package com.tencent.mm.plugin.c.a.a;

import java.math.BigDecimal;

public final class i {
    public static BigDecimal e(double d, double d2) {
        return new BigDecimal(d).multiply(new BigDecimal(d2));
    }

    public static double e(int[] iArr, int i) {
        int i2 = 0;
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
        }
        int i3 = 0;
        while (i2 < iArr.length) {
            i3 += iArr[i2];
            i2++;
        }
        return new BigDecimal((double) i3).divide(new BigDecimal((double) iArr.length), 5, 4).doubleValue();
    }

    public static double l(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new NullPointerException("null == dataGroup || 0 == dataGroup.length");
        }
        double e = e(iArr, 5);
        BigDecimal bigDecimal = new BigDecimal(0.0d);
        for (int i : iArr) {
            bigDecimal = bigDecimal.add(new BigDecimal((double) i).subtract(new BigDecimal(e)).pow(2));
        }
        return Math.pow(bigDecimal.divide(new BigDecimal(iArr.length - 1), 5, 4).doubleValue(), 0.5d);
    }
}
