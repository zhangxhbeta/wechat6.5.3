package android.support.b.a;

import android.graphics.Path;
import java.util.ArrayList;

final class c {

    private static class a {
        int me;
        boolean mf;

        private a() {
        }
    }

    public static class b {
        char mg;
        float[] mh;

        private b(char c, float[] fArr) {
            this.mg = c;
            this.mh = fArr;
        }

        private b(b bVar) {
            this.mg = bVar.mg;
            this.mh = c.copyOfRange(bVar.mh, 0, bVar.mh.length);
        }

        static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double toRadians;
            double cos;
            double sin;
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            double d7;
            double d8;
            double d9;
            Path path2 = path;
            while (true) {
                toRadians = Math.toRadians((double) f7);
                cos = Math.cos(toRadians);
                sin = Math.sin(toRadians);
                d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
                d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
                d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
                d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
                d5 = d - d3;
                d6 = d2 - d4;
                d7 = (d + d3) / 2.0d;
                double d10 = (d2 + d4) / 2.0d;
                d8 = (d5 * d5) + (d6 * d6);
                if (d8 != 0.0d) {
                    d9 = (1.0d / d8) - 0.25d;
                    if (d9 >= 0.0d) {
                        break;
                    }
                    float sqrt = (float) (Math.sqrt(d8) / 1.99999d);
                    f5 *= sqrt;
                    f6 *= sqrt;
                } else {
                    return;
                }
            }
            d8 = Math.sqrt(d9);
            d5 *= d8;
            d6 *= d8;
            if (z == z2) {
                d6 = d7 - d6;
                d5 += d10;
            } else {
                d6 += d7;
                d5 = d10 - d5;
            }
            d7 = Math.atan2(d2 - d5, d - d6);
            d3 = Math.atan2(d4 - d5, d3 - d6) - d7;
            if (z2 != (d3 >= 0.0d)) {
                if (d3 > 0.0d) {
                    d3 -= 6.283185307179586d;
                } else {
                    d3 += 6.283185307179586d;
                }
            }
            d6 *= (double) f5;
            d = ((double) f6) * d5;
            a(path2, (d6 * cos) - (d * sin), (d6 * sin) + (cos * d), (double) f5, (double) f6, (double) f, (double) f2, toRadians, d7, d3);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            cos2 = (cos2 * (d4 * cos)) + (sin2 * ((-d3) * sin));
            double d11 = d9 / ((double) ceil);
            int i = 0;
            while (i < ceil) {
                double d12 = d8 + d11;
                sin2 = Math.sin(d12);
                double cos3 = Math.cos(d12);
                double d13 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin2);
                double d14 = ((d4 * cos) * sin2) + (((d3 * sin) * cos3) + d2);
                double d15 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos3);
                cos3 = (cos3 * (d4 * cos)) + (sin2 * ((-d3) * sin));
                sin2 = Math.tan((d12 - d8) / 2.0d);
                sin2 = ((Math.sqrt((sin2 * (3.0d * sin2)) + 4.0d) - 1.0d) * Math.sin(d12 - d8)) / 3.0d;
                Path path2 = path;
                path2.cubicTo((float) ((d10 * sin2) + d5), (float) (d6 + (cos2 * sin2)), (float) (d13 - (sin2 * d15)), (float) (d14 - (sin2 * cos3)), (float) d13, (float) d14);
                d10 = d15;
                d8 = d12;
                i++;
                d6 = d14;
                d5 = d13;
                cos2 = cos3;
            }
        }
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 + 0;
        length = Math.min(i3, length + 0);
        Object obj = new float[i3];
        System.arraycopy(fArr, 0, obj, 0, length);
        return obj;
    }

    public static b[] g(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int c = c(str, i);
            String trim = str.substring(i2, c).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i = c + 1;
            i2 = c;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    private static int c(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] h(java.lang.String r13) {
        /*
        r1 = 1;
        r2 = 0;
        r0 = r13.charAt(r2);
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r0 != r3) goto L_0x001a;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = r13.charAt(r2);
        r4 = 90;
        if (r3 != r4) goto L_0x001c;
    L_0x0013:
        r3 = r1;
    L_0x0014:
        r0 = r0 | r3;
        if (r0 == 0) goto L_0x001e;
    L_0x0017:
        r0 = new float[r2];
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r2;
        goto L_0x000b;
    L_0x001c:
        r3 = r2;
        goto L_0x0014;
    L_0x001e:
        r0 = r13.length();	 Catch:{ NumberFormatException -> 0x0095 }
        r8 = new float[r0];	 Catch:{ NumberFormatException -> 0x0095 }
        r9 = new android.support.b.a.c$a;	 Catch:{ NumberFormatException -> 0x0095 }
        r0 = 0;
        r9.<init>();	 Catch:{ NumberFormatException -> 0x0095 }
        r10 = r13.length();	 Catch:{ NumberFormatException -> 0x0095 }
        r7 = r1;
        r3 = r2;
    L_0x0030:
        if (r7 >= r10) goto L_0x008f;
    L_0x0032:
        r0 = 0;
        r9.mf = r0;	 Catch:{ NumberFormatException -> 0x0095 }
        r5 = r2;
        r0 = r2;
        r4 = r2;
        r6 = r7;
    L_0x0039:
        r11 = r13.length();	 Catch:{ NumberFormatException -> 0x0095 }
        if (r6 >= r11) goto L_0x0072;
    L_0x003f:
        r11 = r13.charAt(r6);	 Catch:{ NumberFormatException -> 0x0095 }
        switch(r11) {
            case 32: goto L_0x0052;
            case 44: goto L_0x0052;
            case 45: goto L_0x0056;
            case 46: goto L_0x0061;
            case 69: goto L_0x006e;
            case 101: goto L_0x006e;
            default: goto L_0x0046;
        };	 Catch:{ NumberFormatException -> 0x0095 }
    L_0x0046:
        r5 = r4;
        r4 = r0;
        r0 = r2;
    L_0x0049:
        if (r5 != 0) goto L_0x0072;
    L_0x004b:
        r6 = r6 + 1;
        r12 = r0;
        r0 = r4;
        r4 = r5;
        r5 = r12;
        goto L_0x0039;
    L_0x0052:
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x0056:
        if (r6 == r7) goto L_0x0046;
    L_0x0058:
        if (r5 != 0) goto L_0x0046;
    L_0x005a:
        r4 = 1;
        r9.mf = r4;	 Catch:{ NumberFormatException -> 0x0095 }
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x0061:
        if (r0 != 0) goto L_0x0067;
    L_0x0063:
        r0 = r2;
        r5 = r4;
        r4 = r1;
        goto L_0x0049;
    L_0x0067:
        r4 = 1;
        r9.mf = r4;	 Catch:{ NumberFormatException -> 0x0095 }
        r4 = r0;
        r5 = r1;
        r0 = r2;
        goto L_0x0049;
    L_0x006e:
        r5 = r4;
        r4 = r0;
        r0 = r1;
        goto L_0x0049;
    L_0x0072:
        r9.me = r6;	 Catch:{ NumberFormatException -> 0x0095 }
        r4 = r9.me;	 Catch:{ NumberFormatException -> 0x0095 }
        if (r7 >= r4) goto L_0x00b3;
    L_0x0078:
        r0 = r3 + 1;
        r5 = r13.substring(r7, r4);	 Catch:{ NumberFormatException -> 0x0095 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ NumberFormatException -> 0x0095 }
        r8[r3] = r5;	 Catch:{ NumberFormatException -> 0x0095 }
    L_0x0084:
        r3 = r9.mf;	 Catch:{ NumberFormatException -> 0x0095 }
        if (r3 == 0) goto L_0x008b;
    L_0x0088:
        r7 = r4;
        r3 = r0;
        goto L_0x0030;
    L_0x008b:
        r7 = r4 + 1;
        r3 = r0;
        goto L_0x0030;
    L_0x008f:
        r0 = 0;
        r0 = copyOfRange(r8, r0, r3);	 Catch:{ NumberFormatException -> 0x0095 }
        goto L_0x0019;
    L_0x0095:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "error in parsing \"";
        r2.<init>(r3);
        r2 = r2.append(r13);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00b3:
        r0 = r3;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.b.a.c.h(java.lang.String):float[]");
    }
}
