package com.tencent.mm.plugin.c.a.b.a;

import com.tencent.mm.plugin.c.a.b.h;
import com.tencent.mm.sdk.platformtools.v;

public class b extends a {
    static final String TAG = b.class.getName();
    public static String eqQ = h.eqK;
    public static String eqR = h.eqL;
    public static String eqS = h.eqM;
    private final int eqT;
    private final int eqU;
    private final int eqV;
    private final int eqW;
    private final int eqX;
    b eqY;
    a eqZ;
    int era;

    private class a {
        public boolean erb = false;
        public double erc = 0.0d;
        public int erd = 0;
        public int ere = 0;
        public int erf = 0;
        public c erg = new c();
        final /* synthetic */ b erh;

        public a(b bVar) {
            this.erh = bVar;
        }
    }

    private class b {
        public boolean erb = false;
        public int erd = 0;
        public int ere = 0;
        public int erf = 0;
        public c erg = new c();
        final /* synthetic */ b erh;
        public double eri = 0.0d;
        public double erj = 0.0d;
        public double erk = 0.0d;

        public b(b bVar) {
            this.erh = bVar;
        }
    }

    public static class c {
        public int erl = 0;
        public int erm = 0;
        public int ern = 0;
        public int ero = 0;
        public int erp = 0;
        public int erq = 0;

        public final boolean t(byte[] bArr, int i) {
            String bB = b.TAG;
            String str = "data size = %d, offset = %d, lenght = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(7);
            v.d(bB, str, objArr);
            if (bArr == null || i < 0 || bArr.length < i + 7) {
                v.e(b.TAG, "data input error");
                return false;
            }
            this.erl = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            this.erm = bArr[i + 2] & 255;
            this.ern = bArr[i + 3] & 255;
            this.ero = bArr[i + 4] & 255;
            this.erp = bArr[i + 5] & 255;
            this.erq = bArr[i + 6] & 255;
            v.d(b.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(this.erl), Integer.valueOf(this.erm), Integer.valueOf(this.ern), Integer.valueOf(this.ero), Integer.valueOf(this.erp), Integer.valueOf(this.erq)});
            return true;
        }
    }

    public b() {
        this.eqT = 1;
        this.eqU = 2;
        this.eqV = 4;
        this.eqW = 8;
        this.eqX = 16;
        this.eqO = null;
        this.eqP = 2;
        this.eqh = 8;
        this.eqY = null;
    }

    static double s(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        int i3 = (i2 >> 12) - 16;
        int i4 = i2 & 3840;
        int i5 = (bArr[i] & 255) + (65280 & i4);
        double pow = ((double) i5) * Math.pow(10.0d, (double) i3);
        v.d(TAG, "hbyte=" + i2 + " hvalue=" + i4 + " value=" + i5 + " exp=" + i3);
        return pow;
    }

    public final byte[] Xt() {
        return null;
    }
}
