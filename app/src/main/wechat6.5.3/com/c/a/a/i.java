package com.c.a.a;

import android.location.Location;

final class i {
    static i aHX;
    double aHY;
    double aHZ;
    float aIa;
    float aIb;
    float aIc;
    float aId;
    float aIe;
    float aIf;
    boolean aIg = false;

    i() {
    }

    final void a(double d, double d2, float f, float f2, float f3, float f4) {
        double d3;
        float[] fArr = new float[1];
        if (d2 > 179.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d, d2, d, d2 + d3, fArr);
        this.aIf = fArr[0];
        if (d > 89.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d3 + d, d2, d, d2, fArr);
        this.aIe = fArr[0];
        this.aHY = d;
        this.aHZ = d2;
        this.aIa = f2;
        this.aIb = f3;
        this.aId = f;
        this.aIc = f4;
        this.aIg = true;
    }
}
