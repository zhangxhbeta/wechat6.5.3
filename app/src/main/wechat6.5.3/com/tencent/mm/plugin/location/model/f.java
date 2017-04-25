package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.k;

public final class f {
    private static double gRT = -1000.0d;
    private static double gRU = -1000.0d;
    private static double gRV = -1000.0d;
    private static double gRW = -1000.0d;

    public static float p(float f, float f2) {
        if (f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) {
            return (f < 315.0f || f >= 360.0f || f2 < 0.0f || f2 > 45.0f) ? f2 : f2;
        } else {
            return f2 - 360.0f;
        }
    }

    public static float q(float f, float f2) {
        if ((f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) && f >= 315.0f && f < 360.0f && f2 >= 0.0f && f2 <= 45.0f) {
            return f - 360.0f;
        }
        return f;
    }

    public static double g(double d, double d2) {
        gRV = d;
        gRW = d2;
        double atan2 = (gRT == -1000.0d || gRU == -1000.0d) ? 0.0d : (Math.atan2(gRW - gRU, gRV - gRT) * 180.0d) / 3.141592d;
        gRT = gRV;
        gRU = gRW;
        return atan2;
    }

    public static boolean a(double d, double d2, double d3, double d4, int i, double d5) {
        if (i == 0) {
            if (d5 == 0.0d) {
                return false;
            }
            if (d5 <= 0.0d) {
                return false;
            }
        } else if (i != 1) {
            return false;
        } else {
            Object obj = (d2 == -1000.0d || d == -1000.0d) ? null : (d3 == -1000.0d || d4 == -1000.0d) ? null : k.c(d2, d, d4, d3) >= 5.0d ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static double h(int i, int i2, int i3, int i4) {
        return Math.sqrt((double) (((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4))));
    }

    public static boolean e(double d) {
        return d >= 4.0d;
    }
}
