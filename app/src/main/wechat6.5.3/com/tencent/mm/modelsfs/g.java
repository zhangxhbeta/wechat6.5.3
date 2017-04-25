package com.tencent.mm.modelsfs;

import java.util.EnumSet;

final class g {

    public enum a {
        NOESCAPE,
        PATHNAME,
        PERIOD,
        LEADING_DIR,
        CASEFOLD
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.lang.String r10, int r11, java.lang.String r12, int r13, java.util.EnumSet<com.tencent.mm.modelsfs.g.a> r14) {
        /*
    L_0x0000:
        r0 = r10.length();
        if (r11 < r0) goto L_0x0022;
    L_0x0006:
        r0 = com.tencent.mm.modelsfs.g.a.LEADING_DIR;
        r0 = r14.contains(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x000e:
        r0 = r12.charAt(r13);
        r1 = 47;
        if (r0 != r1) goto L_0x0018;
    L_0x0016:
        r0 = 1;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r12.length();
        if (r13 != r0) goto L_0x0020;
    L_0x001e:
        r0 = 1;
        goto L_0x0017;
    L_0x0020:
        r0 = 0;
        goto L_0x0017;
    L_0x0022:
        r0 = r11 + 1;
        r1 = r10.charAt(r11);
        switch(r1) {
            case 42: goto L_0x0220;
            case 63: goto L_0x0034;
            case 91: goto L_0x00e5;
            case 92: goto L_0x01d8;
            default: goto L_0x002b;
        };
    L_0x002b:
        r11 = r0;
    L_0x002c:
        r0 = r12.length();
        if (r13 < r0) goto L_0x01f3;
    L_0x0032:
        r0 = 0;
        goto L_0x0017;
    L_0x0034:
        r1 = r12.length();
        if (r13 < r1) goto L_0x003c;
    L_0x003a:
        r0 = 0;
        goto L_0x0017;
    L_0x003c:
        r1 = r12.charAt(r13);
        r2 = 47;
        if (r1 != r2) goto L_0x004e;
    L_0x0044:
        r1 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r1 = r14.contains(r1);
        if (r1 == 0) goto L_0x004e;
    L_0x004c:
        r0 = 0;
        goto L_0x0017;
    L_0x004e:
        r1 = a(r12, r13, r14);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = 0;
        goto L_0x0017;
    L_0x0056:
        r13 = r13 + 1;
        r11 = r0;
        goto L_0x0000;
    L_0x005a:
        r1 = r10.length();
        if (r11 >= r1) goto L_0x006b;
    L_0x0060:
        r0 = r10.charAt(r11);
        r1 = 42;
        if (r0 != r1) goto L_0x006b;
    L_0x0068:
        r11 = r11 + 1;
        goto L_0x005a;
    L_0x006b:
        r1 = a(r12, r13, r14);
        if (r1 == 0) goto L_0x0073;
    L_0x0071:
        r0 = 0;
        goto L_0x0017;
    L_0x0073:
        r1 = r10.length();
        if (r11 != r1) goto L_0x0098;
    L_0x0079:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r14.contains(r0);
        if (r0 == 0) goto L_0x0096;
    L_0x0081:
        r0 = com.tencent.mm.modelsfs.g.a.LEADING_DIR;
        r0 = r14.contains(r0);
        if (r0 != 0) goto L_0x0092;
    L_0x0089:
        r0 = 47;
        r0 = r12.indexOf(r0, r13);
        r1 = -1;
        if (r0 != r1) goto L_0x0094;
    L_0x0092:
        r0 = 1;
        goto L_0x0017;
    L_0x0094:
        r0 = 0;
        goto L_0x0017;
    L_0x0096:
        r0 = 1;
        goto L_0x0017;
    L_0x0098:
        r1 = 47;
        if (r0 != r1) goto L_0x00c2;
    L_0x009c:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r14.contains(r0);
        if (r0 == 0) goto L_0x00c2;
    L_0x00a4:
        r0 = 47;
        r13 = r12.indexOf(r0, r13);
        r0 = -1;
        if (r13 != r0) goto L_0x0000;
    L_0x00ad:
        r0 = 0;
        goto L_0x0017;
    L_0x00b0:
        r0 = r12.charAt(r13);
        r1 = 47;
        if (r0 != r1) goto L_0x00c0;
    L_0x00b8:
        r0 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r0 = r14.contains(r0);
        if (r0 != 0) goto L_0x00e2;
    L_0x00c0:
        r13 = r13 + 1;
    L_0x00c2:
        r0 = r12.length();
        if (r13 >= r0) goto L_0x00e2;
    L_0x00c8:
        r0 = com.tencent.mm.modelsfs.g.a.PERIOD;
        r0 = r14.contains(r0);
        if (r0 == 0) goto L_0x00d9;
    L_0x00d0:
        r14 = java.util.EnumSet.copyOf(r14);
        r0 = com.tencent.mm.modelsfs.g.a.PERIOD;
        r14.remove(r0);
    L_0x00d9:
        r0 = a(r10, r11, r12, r13, r14);
        if (r0 == 0) goto L_0x00b0;
    L_0x00df:
        r0 = 1;
        goto L_0x0017;
    L_0x00e2:
        r0 = 0;
        goto L_0x0017;
    L_0x00e5:
        r2 = r12.length();
        if (r13 < r2) goto L_0x00ee;
    L_0x00eb:
        r0 = 0;
        goto L_0x0017;
    L_0x00ee:
        r2 = r12.charAt(r13);
        r3 = 47;
        if (r2 != r3) goto L_0x0101;
    L_0x00f6:
        r2 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r2 = r14.contains(r2);
        if (r2 == 0) goto L_0x0101;
    L_0x00fe:
        r0 = 0;
        goto L_0x0017;
    L_0x0101:
        r2 = a(r12, r13, r14);
        if (r2 == 0) goto L_0x010a;
    L_0x0107:
        r0 = 0;
        goto L_0x0017;
    L_0x010a:
        r3 = r12.charAt(r13);
        r2 = r10.length();
        if (r0 < r2) goto L_0x011d;
    L_0x0114:
        r11 = -1;
    L_0x0115:
        r2 = -1;
        if (r11 == r2) goto L_0x002b;
    L_0x0118:
        if (r11 != 0) goto L_0x01d4;
    L_0x011a:
        r0 = 0;
        goto L_0x0017;
    L_0x011d:
        r2 = r10.charAt(r0);
        r4 = 33;
        if (r2 == r4) goto L_0x0129;
    L_0x0125:
        r4 = 94;
        if (r2 != r4) goto L_0x0147;
    L_0x0129:
        r2 = 1;
        r8 = r2;
    L_0x012b:
        if (r8 == 0) goto L_0x021d;
    L_0x012d:
        r2 = r0 + 1;
    L_0x012f:
        r4 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r4 = r14.contains(r4);
        if (r4 == 0) goto L_0x013b;
    L_0x0137:
        r3 = java.lang.Character.toLowerCase(r3);
    L_0x013b:
        r4 = 0;
        r9 = r4;
        r4 = r2;
        r2 = r9;
    L_0x013f:
        r5 = r10.length();
        if (r4 < r5) goto L_0x014a;
    L_0x0145:
        r11 = -1;
        goto L_0x0115;
    L_0x0147:
        r2 = 0;
        r8 = r2;
        goto L_0x012b;
    L_0x014a:
        r11 = r4 + 1;
        r5 = r10.charAt(r4);
        r4 = 93;
        if (r5 == r4) goto L_0x01cf;
    L_0x0154:
        r4 = 92;
        if (r5 != r4) goto L_0x021a;
    L_0x0158:
        r4 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r4 = r14.contains(r4);
        if (r4 != 0) goto L_0x021a;
    L_0x0160:
        r4 = r11 + 1;
        r5 = r10.charAt(r11);
    L_0x0166:
        r6 = 47;
        if (r5 != r6) goto L_0x0174;
    L_0x016a:
        r6 = com.tencent.mm.modelsfs.g.a.PATHNAME;
        r6 = r14.contains(r6);
        if (r6 == 0) goto L_0x0174;
    L_0x0172:
        r11 = 0;
        goto L_0x0115;
    L_0x0174:
        r6 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r6 = r14.contains(r6);
        if (r6 == 0) goto L_0x0180;
    L_0x017c:
        r5 = java.lang.Character.toLowerCase(r5);
    L_0x0180:
        r6 = r10.charAt(r4);
        r7 = 45;
        if (r6 != r7) goto L_0x01ca;
    L_0x0188:
        r6 = r4 + 1;
        r7 = r10.length();
        if (r6 >= r7) goto L_0x01ca;
    L_0x0190:
        r6 = r4 + 1;
        r7 = r10.charAt(r6);
        r6 = 93;
        if (r7 == r6) goto L_0x01ca;
    L_0x019a:
        r6 = r4 + 2;
        r4 = 92;
        if (r7 != r4) goto L_0x0218;
    L_0x01a0:
        r4 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r4 = r14.contains(r4);
        if (r4 != 0) goto L_0x0218;
    L_0x01a8:
        r4 = r10.length();
        if (r6 < r4) goto L_0x01b1;
    L_0x01ae:
        r11 = -1;
        goto L_0x0115;
    L_0x01b1:
        r4 = r6 + 1;
        r5 = r10.charAt(r6);
    L_0x01b7:
        r6 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r6 = r14.contains(r6);
        if (r6 == 0) goto L_0x0216;
    L_0x01bf:
        r6 = java.lang.Character.toLowerCase(r7);
    L_0x01c3:
        if (r5 > r3) goto L_0x013f;
    L_0x01c5:
        if (r3 > r6) goto L_0x013f;
    L_0x01c7:
        r2 = 1;
        goto L_0x013f;
    L_0x01ca:
        if (r5 != r3) goto L_0x013f;
    L_0x01cc:
        r2 = 1;
        goto L_0x013f;
    L_0x01cf:
        if (r2 != r8) goto L_0x0115;
    L_0x01d1:
        r11 = 0;
        goto L_0x0115;
    L_0x01d4:
        r13 = r13 + 1;
        goto L_0x0000;
    L_0x01d8:
        r2 = com.tencent.mm.modelsfs.g.a.NOESCAPE;
        r2 = r14.contains(r2);
        if (r2 != 0) goto L_0x002b;
    L_0x01e0:
        r1 = r10.length();
        if (r0 < r1) goto L_0x01eb;
    L_0x01e6:
        r1 = 92;
        r11 = r0;
        goto L_0x002c;
    L_0x01eb:
        r11 = r0 + 1;
        r1 = r10.charAt(r0);
        goto L_0x002c;
    L_0x01f3:
        r0 = r12.charAt(r13);
        if (r1 == r0) goto L_0x0212;
    L_0x01f9:
        r0 = com.tencent.mm.modelsfs.g.a.CASEFOLD;
        r0 = r14.contains(r0);
        if (r0 == 0) goto L_0x020f;
    L_0x0201:
        r0 = java.lang.Character.toLowerCase(r1);
        r1 = r12.charAt(r13);
        r1 = java.lang.Character.toLowerCase(r1);
        if (r0 == r1) goto L_0x0212;
    L_0x020f:
        r0 = 0;
        goto L_0x0017;
    L_0x0212:
        r13 = r13 + 1;
        goto L_0x0000;
    L_0x0216:
        r6 = r7;
        goto L_0x01c3;
    L_0x0218:
        r4 = r6;
        goto L_0x01b7;
    L_0x021a:
        r4 = r11;
        goto L_0x0166;
    L_0x021d:
        r2 = r0;
        goto L_0x012f;
    L_0x0220:
        r11 = r0;
        r0 = r1;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.g.a(java.lang.String, int, java.lang.String, int, java.util.EnumSet):boolean");
    }

    private static boolean a(String str, int i, EnumSet<a> enumSet) {
        if (i > str.length() - 1) {
            return false;
        }
        if ((i == 0 || (enumSet.contains(a.PATHNAME) && str.charAt(i - 1) == '/')) && str.charAt(i) == '.' && enumSet.contains(a.PERIOD)) {
            return true;
        }
        return false;
    }
}
