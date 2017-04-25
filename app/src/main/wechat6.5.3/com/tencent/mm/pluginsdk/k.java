package com.tencent.mm.pluginsdk;

public final class k {
    public static double c(double d, double d2, double d3, double d4) {
        double d5 = (3.141592653589793d * d) / 180.0d;
        double d6 = (3.141592653589793d * d3) / 180.0d;
        double d7 = ((d2 - d4) * 3.141592653589793d) / 180.0d;
        return (double) (Math.round(((Math.asin(Math.sqrt(((Math.cos(d5) * Math.cos(d6)) * Math.pow(Math.sin(d7 / 2.0d), 2.0d)) + Math.pow(Math.sin((d5 - d6) / 2.0d), 2.0d))) * 2.0d) * 6378137.0d) * 10000.0d) / 10000);
    }

    public static float af(float f) {
        if (f > 0.0f) {
            return f % 360.0f;
        }
        return (((float) ((((((int) f) * -1) / 360) + 1) * 360)) + f) % 360.0f;
    }
}
