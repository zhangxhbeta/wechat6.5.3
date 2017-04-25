package com.tencent.wxop.stat.b;

public class h {
    static final /* synthetic */ boolean a = (!h.class.desiredAssertionStatus());

    private h() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bC(byte[] r14) {
        /*
        r13 = -2;
        r12 = -1;
        r11 = 6;
        r3 = 0;
        r0 = r14.length;
        r6 = new com.tencent.wxop.stat.b.j;
        r1 = r0 * 3;
        r1 = r1 / 4;
        r1 = new byte[r1];
        r6.<init>(r3, r1);
        r1 = r6.e;
        if (r1 != r11) goto L_0x0020;
    L_0x0014:
        r0 = r3;
    L_0x0015:
        if (r0 != 0) goto L_0x013d;
    L_0x0017:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "bad base-64";
        r0.<init>(r1);
        throw r0;
    L_0x0020:
        r7 = r0 + 0;
        r0 = r6.e;
        r1 = r6.f;
        r8 = r6.a;
        r9 = r6.pLO;
        r2 = r3;
        r5 = r0;
        r0 = r3;
    L_0x002d:
        if (r2 >= r7) goto L_0x0110;
    L_0x002f:
        if (r5 != 0) goto L_0x0076;
    L_0x0031:
        r4 = r2 + 4;
        if (r4 > r7) goto L_0x0074;
    L_0x0035:
        r1 = r14[r2];
        r1 = r1 & 255;
        r1 = r9[r1];
        r1 = r1 << 18;
        r4 = r2 + 1;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r4 = r4 << 12;
        r1 = r1 | r4;
        r4 = r2 + 2;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r4 = r4 << 6;
        r1 = r1 | r4;
        r4 = r2 + 3;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r1 = r1 | r4;
        if (r1 < 0) goto L_0x0074;
    L_0x005e:
        r4 = r0 + 2;
        r10 = (byte) r1;
        r8[r4] = r10;
        r4 = r0 + 1;
        r10 = r1 >> 8;
        r10 = (byte) r10;
        r8[r4] = r10;
        r4 = r1 >> 16;
        r4 = (byte) r4;
        r8[r0] = r4;
        r0 = r0 + 3;
        r2 = r2 + 4;
        goto L_0x0031;
    L_0x0074:
        if (r2 >= r7) goto L_0x0110;
    L_0x0076:
        r4 = r2 + 1;
        r2 = r14[r2];
        r2 = r2 & 255;
        r2 = r9[r2];
        switch(r5) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0091;
            case 2: goto L_0x00a2;
            case 3: goto L_0x00c2;
            case 4: goto L_0x00fa;
            case 5: goto L_0x0109;
            default: goto L_0x0081;
        };
    L_0x0081:
        r2 = r4;
        goto L_0x002d;
    L_0x0083:
        if (r2 < 0) goto L_0x008b;
    L_0x0085:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x008b:
        if (r2 == r12) goto L_0x0081;
    L_0x008d:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0091:
        if (r2 < 0) goto L_0x009b;
    L_0x0093:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x009b:
        if (r2 == r12) goto L_0x0081;
    L_0x009d:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00a2:
        if (r2 < 0) goto L_0x00ac;
    L_0x00a4:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x00ac:
        if (r2 != r13) goto L_0x00bb;
    L_0x00ae:
        r2 = r0 + 1;
        r5 = r1 >> 4;
        r5 = (byte) r5;
        r8[r0] = r5;
        r0 = 4;
        r5 = r0;
        r0 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x00bb:
        if (r2 == r12) goto L_0x0081;
    L_0x00bd:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00c2:
        if (r2 < 0) goto L_0x00de;
    L_0x00c4:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r0 + 2;
        r5 = (byte) r1;
        r8[r2] = r5;
        r2 = r0 + 1;
        r5 = r1 >> 8;
        r5 = (byte) r5;
        r8[r2] = r5;
        r2 = r1 >> 16;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r0 + 3;
        r2 = r4;
        r5 = r3;
        goto L_0x002d;
    L_0x00de:
        if (r2 != r13) goto L_0x00f3;
    L_0x00e0:
        r2 = r0 + 1;
        r5 = r1 >> 2;
        r5 = (byte) r5;
        r8[r2] = r5;
        r2 = r1 >> 10;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r0 + 2;
        r2 = 5;
        r5 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x00f3:
        if (r2 == r12) goto L_0x0081;
    L_0x00f5:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00fa:
        if (r2 != r13) goto L_0x0102;
    L_0x00fc:
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002d;
    L_0x0102:
        if (r2 == r12) goto L_0x0081;
    L_0x0104:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0109:
        if (r2 == r12) goto L_0x0081;
    L_0x010b:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0110:
        r2 = r1;
        switch(r5) {
            case 0: goto L_0x0114;
            case 1: goto L_0x011b;
            case 2: goto L_0x0120;
            case 3: goto L_0x0129;
            case 4: goto L_0x0138;
            default: goto L_0x0114;
        };
    L_0x0114:
        r6.e = r5;
        r6.b = r0;
        r0 = 1;
        goto L_0x0015;
    L_0x011b:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0120:
        r1 = r0 + 1;
        r2 = r2 >> 4;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r1;
        goto L_0x0114;
    L_0x0129:
        r1 = r0 + 1;
        r4 = r2 >> 10;
        r4 = (byte) r4;
        r8[r0] = r4;
        r0 = r1 + 1;
        r2 = r2 >> 2;
        r2 = (byte) r2;
        r8[r1] = r2;
        goto L_0x0114;
    L_0x0138:
        r6.e = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x013d:
        r0 = r6.b;
        r1 = r6.a;
        r1 = r1.length;
        if (r0 != r1) goto L_0x0147;
    L_0x0144:
        r0 = r6.a;
    L_0x0146:
        return r0;
    L_0x0147:
        r0 = r6.b;
        r0 = new byte[r0];
        r1 = r6.a;
        r2 = r6.b;
        java.lang.System.arraycopy(r1, r3, r0, r3, r2);
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.h.bC(byte[]):byte[]");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bD(byte[] r12) {
        /*
        r4 = r12.length;
        r7 = new com.tencent.wxop.stat.b.k;
        r0 = 0;
        r7.<init>(r0);
        r0 = r4 / 3;
        r0 = r0 * 4;
        r1 = r7.d;
        if (r1 == 0) goto L_0x00d4;
    L_0x000f:
        r1 = r4 % 3;
        if (r1 <= 0) goto L_0x0015;
    L_0x0013:
        r0 = r0 + 4;
    L_0x0015:
        r1 = r7.e;
        if (r1 == 0) goto L_0x0028;
    L_0x0019:
        if (r4 <= 0) goto L_0x0028;
    L_0x001b:
        r1 = r4 + -1;
        r1 = r1 / 57;
        r2 = r1 + 1;
        r1 = r7.f;
        if (r1 == 0) goto L_0x00e3;
    L_0x0025:
        r1 = 2;
    L_0x0026:
        r1 = r1 * r2;
        r0 = r0 + r1;
    L_0x0028:
        r1 = new byte[r0];
        r7.a = r1;
        r8 = r7.pLR;
        r9 = r7.a;
        r5 = 0;
        r2 = r7.k;
        r3 = 0;
        r10 = r4 + 0;
        r1 = -1;
        r4 = r7.c;
        switch(r4) {
            case 0: goto L_0x00e6;
            case 1: goto L_0x00e9;
            case 2: goto L_0x010a;
            default: goto L_0x003c;
        };
    L_0x003c:
        r4 = r1;
    L_0x003d:
        r1 = -1;
        if (r4 == r1) goto L_0x0258;
    L_0x0040:
        r1 = 0;
        r5 = r4 >> 18;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r1 = 1;
        r5 = r4 >> 12;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r1 = 2;
        r5 = r4 >> 6;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r5 = 3;
        r1 = 4;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r5] = r4;
        r2 = r2 + -1;
        if (r2 != 0) goto L_0x0254;
    L_0x0067:
        r2 = r7.f;
        if (r2 == 0) goto L_0x0071;
    L_0x006b:
        r2 = 4;
        r1 = 5;
        r4 = 13;
        r9[r2] = r4;
    L_0x0071:
        r5 = r1 + 1;
        r2 = 10;
        r9[r1] = r2;
        r1 = 19;
        r6 = r1;
    L_0x007a:
        r1 = r3 + 3;
        if (r1 > r10) goto L_0x012b;
    L_0x007e:
        r1 = r12[r3];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r2 = r3 + 1;
        r2 = r12[r2];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r1 = r1 | r2;
        r2 = r3 + 2;
        r2 = r12[r2];
        r2 = r2 & 255;
        r1 = r1 | r2;
        r2 = r1 >> 18;
        r2 = r2 & 63;
        r2 = r8[r2];
        r9[r5] = r2;
        r2 = r5 + 1;
        r4 = r1 >> 12;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r2] = r4;
        r2 = r5 + 2;
        r4 = r1 >> 6;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r2] = r4;
        r2 = r5 + 3;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r2] = r1;
        r3 = r3 + 3;
        r2 = r5 + 4;
        r1 = r6 + -1;
        if (r1 != 0) goto L_0x0250;
    L_0x00c0:
        r1 = r7.f;
        if (r1 == 0) goto L_0x024d;
    L_0x00c4:
        r1 = r2 + 1;
        r4 = 13;
        r9[r2] = r4;
    L_0x00ca:
        r5 = r1 + 1;
        r2 = 10;
        r9[r1] = r2;
        r1 = 19;
        r6 = r1;
        goto L_0x007a;
    L_0x00d4:
        r1 = r4 % 3;
        switch(r1) {
            case 0: goto L_0x0015;
            case 1: goto L_0x00db;
            case 2: goto L_0x00df;
            default: goto L_0x00d9;
        };
    L_0x00d9:
        goto L_0x0015;
    L_0x00db:
        r0 = r0 + 2;
        goto L_0x0015;
    L_0x00df:
        r0 = r0 + 3;
        goto L_0x0015;
    L_0x00e3:
        r1 = 1;
        goto L_0x0026;
    L_0x00e6:
        r4 = r1;
        goto L_0x003d;
    L_0x00e9:
        r4 = 2;
        if (r4 > r10) goto L_0x003c;
    L_0x00ec:
        r1 = r7.j;
        r3 = 0;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r3 = 0;
        r3 = r12[r3];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r1 = r1 | r3;
        r4 = 1;
        r3 = 2;
        r4 = r12[r4];
        r4 = r4 & 255;
        r1 = r1 | r4;
        r4 = 0;
        r7.c = r4;
        r4 = r1;
        goto L_0x003d;
    L_0x010a:
        if (r10 <= 0) goto L_0x003c;
    L_0x010c:
        r1 = r7.j;
        r3 = 0;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r3 = r7.j;
        r4 = 1;
        r3 = r3[r4];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r1 = r1 | r3;
        r4 = 0;
        r3 = 1;
        r4 = r12[r4];
        r4 = r4 & 255;
        r1 = r1 | r4;
        r4 = 0;
        r7.c = r4;
        goto L_0x003c;
    L_0x012b:
        r1 = r7.c;
        r1 = r3 - r1;
        r2 = r10 + -1;
        if (r1 != r2) goto L_0x0194;
    L_0x0133:
        r2 = 0;
        r1 = r7.c;
        if (r1 <= 0) goto L_0x018e;
    L_0x0138:
        r1 = r7.j;
        r4 = 0;
        r2 = 1;
        r1 = r1[r4];
    L_0x013e:
        r1 = r1 & 255;
        r4 = r1 << 4;
        r1 = r7.c;
        r1 = r1 - r2;
        r7.c = r1;
        r2 = r5 + 1;
        r1 = r4 >> 6;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r5] = r1;
        r1 = r2 + 1;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r2] = r4;
        r2 = r7.d;
        if (r2 == 0) goto L_0x0169;
    L_0x015d:
        r2 = r1 + 1;
        r4 = 61;
        r9[r1] = r4;
        r1 = r2 + 1;
        r4 = 61;
        r9[r2] = r4;
    L_0x0169:
        r2 = r7.e;
        if (r2 == 0) goto L_0x017f;
    L_0x016d:
        r2 = r7.f;
        if (r2 == 0) goto L_0x0178;
    L_0x0171:
        r2 = r1 + 1;
        r4 = 13;
        r9[r1] = r4;
        r1 = r2;
    L_0x0178:
        r2 = r1 + 1;
        r4 = 10;
        r9[r1] = r4;
        r1 = r2;
    L_0x017f:
        r5 = r1;
    L_0x0180:
        r1 = com.tencent.wxop.stat.b.k.g;
        if (r1 != 0) goto L_0x0228;
    L_0x0184:
        r1 = r7.c;
        if (r1 == 0) goto L_0x0228;
    L_0x0188:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x018e:
        r4 = r3 + 1;
        r1 = r12[r3];
        r3 = r4;
        goto L_0x013e;
    L_0x0194:
        r1 = r7.c;
        r1 = r3 - r1;
        r2 = r10 + -2;
        if (r1 != r2) goto L_0x020c;
    L_0x019c:
        r2 = 0;
        r1 = r7.c;
        r4 = 1;
        if (r1 <= r4) goto L_0x0200;
    L_0x01a2:
        r1 = r7.j;
        r4 = 0;
        r2 = 1;
        r1 = r1[r4];
    L_0x01a8:
        r1 = r1 & 255;
        r11 = r1 << 10;
        r1 = r7.c;
        if (r1 <= 0) goto L_0x0206;
    L_0x01b0:
        r1 = r7.j;
        r4 = r2 + 1;
        r1 = r1[r2];
        r2 = r4;
    L_0x01b7:
        r1 = r1 & 255;
        r1 = r1 << 2;
        r1 = r1 | r11;
        r4 = r7.c;
        r2 = r4 - r2;
        r7.c = r2;
        r2 = r5 + 1;
        r4 = r1 >> 12;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r5] = r4;
        r4 = r2 + 1;
        r5 = r1 >> 6;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r2] = r5;
        r2 = r4 + 1;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r4] = r1;
        r1 = r7.d;
        if (r1 == 0) goto L_0x024b;
    L_0x01e2:
        r1 = r2 + 1;
        r4 = 61;
        r9[r2] = r4;
    L_0x01e8:
        r2 = r7.e;
        if (r2 == 0) goto L_0x01fe;
    L_0x01ec:
        r2 = r7.f;
        if (r2 == 0) goto L_0x01f7;
    L_0x01f0:
        r2 = r1 + 1;
        r4 = 13;
        r9[r1] = r4;
        r1 = r2;
    L_0x01f7:
        r2 = r1 + 1;
        r4 = 10;
        r9[r1] = r4;
        r1 = r2;
    L_0x01fe:
        r5 = r1;
        goto L_0x0180;
    L_0x0200:
        r4 = r3 + 1;
        r1 = r12[r3];
        r3 = r4;
        goto L_0x01a8;
    L_0x0206:
        r4 = r3 + 1;
        r1 = r12[r3];
        r3 = r4;
        goto L_0x01b7;
    L_0x020c:
        r1 = r7.e;
        if (r1 == 0) goto L_0x0180;
    L_0x0210:
        if (r5 <= 0) goto L_0x0180;
    L_0x0212:
        r1 = 19;
        if (r6 == r1) goto L_0x0180;
    L_0x0216:
        r1 = r7.f;
        if (r1 == 0) goto L_0x0249;
    L_0x021a:
        r1 = r5 + 1;
        r2 = 13;
        r9[r5] = r2;
    L_0x0220:
        r5 = r1 + 1;
        r2 = 10;
        r9[r1] = r2;
        goto L_0x0180;
    L_0x0228:
        r1 = com.tencent.wxop.stat.b.k.g;
        if (r1 != 0) goto L_0x0234;
    L_0x022c:
        if (r3 == r10) goto L_0x0234;
    L_0x022e:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0234:
        r7.b = r5;
        r7.k = r6;
        r1 = a;
        if (r1 != 0) goto L_0x0246;
    L_0x023c:
        r1 = r7.b;
        if (r1 == r0) goto L_0x0246;
    L_0x0240:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0246:
        r0 = r7.a;
        return r0;
    L_0x0249:
        r1 = r5;
        goto L_0x0220;
    L_0x024b:
        r1 = r2;
        goto L_0x01e8;
    L_0x024d:
        r1 = r2;
        goto L_0x00ca;
    L_0x0250:
        r6 = r1;
        r5 = r2;
        goto L_0x007a;
    L_0x0254:
        r6 = r2;
        r5 = r1;
        goto L_0x007a;
    L_0x0258:
        r6 = r2;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.b.h.bD(byte[]):byte[]");
    }
}
