package com.tencent.mm.modelcontrol;

import com.tencent.mmdb.database.SQLiteDebug;

public final class a {
    private static f[] cFZ;

    static {
        cFZ = null;
        r8 = new f[2];
        cFZ = r8;
        r8[0] = new f(0, 120, 540, 960, 30, 1200000, 1200000);
        cFZ[1] = new f(120, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD, 360, 640, 24, 544000, 544000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.tencent.mm.modelcontrol.f[] r10, com.tencent.mm.modelcontrol.VideoTransPara r11, com.tencent.mm.modelcontrol.VideoTransPara r12) {
        /*
        r2 = 0;
        if (r10 == 0) goto L_0x0006;
    L_0x0003:
        r0 = r10.length;	 Catch:{ Exception -> 0x020f }
        if (r0 > 0) goto L_0x0008;
    L_0x0006:
        r10 = cFZ;	 Catch:{ Exception -> 0x020f }
    L_0x0008:
        r1 = r10.length;	 Catch:{ Exception -> 0x020f }
        r0 = r11.width;	 Catch:{ Exception -> 0x020f }
        r12.width = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r11.height;	 Catch:{ Exception -> 0x020f }
        r12.height = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r11.cdg;	 Catch:{ Exception -> 0x020f }
        r12.cdg = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r11.cGx;	 Catch:{ Exception -> 0x020f }
        r12.cGx = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r11.duration;	 Catch:{ Exception -> 0x020f }
        r12.duration = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r11.width;	 Catch:{ Exception -> 0x020f }
        r3 = r11.height;	 Catch:{ Exception -> 0x020f }
        if (r0 <= r3) goto L_0x00f8;
    L_0x0023:
        r0 = 1;
        r7 = r0;
    L_0x0025:
        if (r7 == 0) goto L_0x00fc;
    L_0x0027:
        r4 = r11.width;	 Catch:{ Exception -> 0x020f }
    L_0x0029:
        if (r7 == 0) goto L_0x0100;
    L_0x002b:
        r3 = r11.height;	 Catch:{ Exception -> 0x020f }
    L_0x002d:
        r5 = r11.duration;	 Catch:{ Exception -> 0x020f }
        r0 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r6 = r1 + -1;
        r6 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r6 = r6.cGr;	 Catch:{ Exception -> 0x020f }
        if (r0 < r6) goto L_0x0044;
    L_0x0039:
        r0 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r6 = cFZ;	 Catch:{ Exception -> 0x020f }
        r8 = 1;
        r6 = r6[r8];	 Catch:{ Exception -> 0x020f }
        r6 = r6.cGr;	 Catch:{ Exception -> 0x020f }
        if (r0 >= r6) goto L_0x020c;
    L_0x0044:
        r0 = 0;
        r6 = r0;
    L_0x0046:
        if (r6 >= r1) goto L_0x011b;
    L_0x0048:
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGq;	 Catch:{ Exception -> 0x020f }
        if (r5 < r0) goto L_0x0116;
    L_0x004e:
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGr;	 Catch:{ Exception -> 0x020f }
        if (r5 >= r0) goto L_0x0116;
    L_0x0054:
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r0.cGs;	 Catch:{ Exception -> 0x020f }
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGt;	 Catch:{ Exception -> 0x020f }
        if (r4 > r1) goto L_0x0060;
    L_0x005e:
        if (r3 <= r0) goto L_0x0231;
    L_0x0060:
        r5 = r4 * r0;
        r8 = r3 * r1;
        if (r5 <= r8) goto L_0x0104;
    L_0x0066:
        r5 = 1;
    L_0x0067:
        if (r5 == 0) goto L_0x0107;
    L_0x0069:
        r0 = r3 * r1;
        r0 = r0 / r4;
    L_0x006c:
        r1 = r1 + 8;
        r1 = r1 >> 4;
        r1 = r1 << 4;
        r0 = r0 + 8;
        r0 = r0 >> 4;
        r0 = r0 << 4;
    L_0x0078:
        if (r7 == 0) goto L_0x010c;
    L_0x007a:
        r3 = r1;
    L_0x007b:
        r12.width = r3;	 Catch:{ Exception -> 0x020f }
        if (r7 == 0) goto L_0x010f;
    L_0x007f:
        r12.height = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGu;	 Catch:{ Exception -> 0x020f }
        if (r0 <= r1) goto L_0x0112;
    L_0x0089:
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGu;	 Catch:{ Exception -> 0x020f }
    L_0x008d:
        r12.cdg = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGv;	 Catch:{ Exception -> 0x020f }
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGr;	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r1;
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGw;	 Catch:{ Exception -> 0x020f }
        r3 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 + r1;
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGv;	 Catch:{ Exception -> 0x020f }
        r3 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 - r1;
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGw;	 Catch:{ Exception -> 0x020f }
        r3 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGq;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 - r1;
        r1 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGr;	 Catch:{ Exception -> 0x020f }
        r3 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGq;	 Catch:{ Exception -> 0x020f }
        r1 = r1 - r3;
        r0 = r0 / r1;
        r0 = (double) r0;	 Catch:{ Exception -> 0x020f }
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r12.width;	 Catch:{ Exception -> 0x020f }
        r7 = r12.height;	 Catch:{ Exception -> 0x020f }
        r3 = r3 * r7;
        r8 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r4 = r4 * r8;
        r3 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGs;	 Catch:{ Exception -> 0x020f }
        r7 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r7 = r7.cGt;	 Catch:{ Exception -> 0x020f }
        r3 = r3 * r7;
        r8 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r4 = r4 / r8;
        r4 = java.lang.Math.sqrt(r4);	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r4;
        r3 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r4 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r4;
        r3 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGu;	 Catch:{ Exception -> 0x020f }
        r4 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r0 = r0 / r4;
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r10[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGu;	 Catch:{ Exception -> 0x020f }
        r6 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r3 = r3 - r6;
        r6 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r8 = 4579800533065604792; // 0x3f8eb851eb851eb8 float:-3.218644E26 double:0.015;
        r6 = r6 * r8;
        r4 = r4 + r6;
        r0 = r0 * r4;
        r0 = (int) r0;	 Catch:{ Exception -> 0x020f }
        r12.cGx = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r12.cGx;	 Catch:{ Exception -> 0x020f }
    L_0x00f7:
        return r0;
    L_0x00f8:
        r0 = 0;
        r7 = r0;
        goto L_0x0025;
    L_0x00fc:
        r4 = r11.height;	 Catch:{ Exception -> 0x020f }
        goto L_0x0029;
    L_0x0100:
        r3 = r11.width;	 Catch:{ Exception -> 0x020f }
        goto L_0x002d;
    L_0x0104:
        r5 = 0;
        goto L_0x0067;
    L_0x0107:
        r1 = r4 * r0;
        r1 = r1 / r3;
        goto L_0x006c;
    L_0x010c:
        r3 = r0;
        goto L_0x007b;
    L_0x010f:
        r0 = r1;
        goto L_0x007f;
    L_0x0112:
        r0 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        goto L_0x008d;
    L_0x0116:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x0046;
    L_0x011b:
        r0 = 0;
        r6 = r0;
    L_0x011d:
        r0 = 2;
        if (r6 >= r0) goto L_0x020c;
    L_0x0120:
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGq;	 Catch:{ Exception -> 0x020f }
        if (r5 < r0) goto L_0x0207;
    L_0x0128:
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGr;	 Catch:{ Exception -> 0x020f }
        if (r5 >= r0) goto L_0x0207;
    L_0x0130:
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r0.cGs;	 Catch:{ Exception -> 0x020f }
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGt;	 Catch:{ Exception -> 0x020f }
        if (r4 > r1) goto L_0x0140;
    L_0x013e:
        if (r3 <= r0) goto L_0x022d;
    L_0x0140:
        r5 = r4 * r0;
        r8 = r3 * r1;
        if (r5 <= r8) goto L_0x01f5;
    L_0x0146:
        r5 = 1;
    L_0x0147:
        if (r5 == 0) goto L_0x01f8;
    L_0x0149:
        r0 = r3 * r1;
        r0 = r0 / r4;
    L_0x014c:
        r1 = r1 + 8;
        r1 = r1 >> 4;
        r1 = r1 << 4;
        r0 = r0 + 8;
        r0 = r0 >> 4;
        r0 = r0 << 4;
    L_0x0158:
        if (r7 == 0) goto L_0x01fd;
    L_0x015a:
        r3 = r1;
    L_0x015b:
        r12.width = r3;	 Catch:{ Exception -> 0x020f }
        if (r7 == 0) goto L_0x0200;
    L_0x015f:
        r12.height = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGu;	 Catch:{ Exception -> 0x020f }
        if (r0 <= r1) goto L_0x0203;
    L_0x016b:
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGu;	 Catch:{ Exception -> 0x020f }
    L_0x0171:
        r12.cdg = r0;	 Catch:{ Exception -> 0x020f }
        r0 = cFZ;	 Catch:{ Exception -> 0x020f }
        r0 = r0[r6];	 Catch:{ Exception -> 0x020f }
        r0 = r0.cGv;	 Catch:{ Exception -> 0x020f }
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGr;	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r1;
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGw;	 Catch:{ Exception -> 0x020f }
        r3 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 + r1;
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGv;	 Catch:{ Exception -> 0x020f }
        r3 = r12.duration;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 - r1;
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGw;	 Catch:{ Exception -> 0x020f }
        r3 = cFZ;	 Catch:{ Exception -> 0x020f }
        r3 = r3[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGq;	 Catch:{ Exception -> 0x020f }
        r1 = r1 * r3;
        r0 = r0 - r1;
        r1 = cFZ;	 Catch:{ Exception -> 0x020f }
        r1 = r1[r6];	 Catch:{ Exception -> 0x020f }
        r1 = r1.cGr;	 Catch:{ Exception -> 0x020f }
        r3 = cFZ;	 Catch:{ Exception -> 0x020f }
        r3 = r3[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGq;	 Catch:{ Exception -> 0x020f }
        r1 = r1 - r3;
        r0 = r0 / r1;
        r0 = (double) r0;	 Catch:{ Exception -> 0x020f }
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r12.width;	 Catch:{ Exception -> 0x020f }
        r7 = r12.height;	 Catch:{ Exception -> 0x020f }
        r3 = r3 * r7;
        r8 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r4 = r4 * r8;
        r3 = cFZ;	 Catch:{ Exception -> 0x020f }
        r3 = r3[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGs;	 Catch:{ Exception -> 0x020f }
        r7 = cFZ;	 Catch:{ Exception -> 0x020f }
        r7 = r7[r6];	 Catch:{ Exception -> 0x020f }
        r7 = r7.cGt;	 Catch:{ Exception -> 0x020f }
        r3 = r3 * r7;
        r8 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r4 = r4 / r8;
        r4 = java.lang.Math.sqrt(r4);	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r4;
        r3 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r4 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r0 = r0 * r4;
        r3 = cFZ;	 Catch:{ Exception -> 0x020f }
        r3 = r3[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGu;	 Catch:{ Exception -> 0x020f }
        r4 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r0 = r0 / r4;
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = cFZ;	 Catch:{ Exception -> 0x020f }
        r3 = r3[r6];	 Catch:{ Exception -> 0x020f }
        r3 = r3.cGu;	 Catch:{ Exception -> 0x020f }
        r6 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        r3 = r3 - r6;
        r6 = (double) r3;	 Catch:{ Exception -> 0x020f }
        r8 = 4579800533065604792; // 0x3f8eb851eb851eb8 float:-3.218644E26 double:0.015;
        r6 = r6 * r8;
        r4 = r4 + r6;
        r0 = r0 * r4;
        r0 = (int) r0;	 Catch:{ Exception -> 0x020f }
        r12.cGx = r0;	 Catch:{ Exception -> 0x020f }
        r0 = r12.cGx;	 Catch:{ Exception -> 0x020f }
        goto L_0x00f7;
    L_0x01f5:
        r5 = 0;
        goto L_0x0147;
    L_0x01f8:
        r1 = r4 * r0;
        r1 = r1 / r3;
        goto L_0x014c;
    L_0x01fd:
        r3 = r0;
        goto L_0x015b;
    L_0x0200:
        r0 = r1;
        goto L_0x015f;
    L_0x0203:
        r0 = r12.cdg;	 Catch:{ Exception -> 0x020f }
        goto L_0x0171;
    L_0x0207:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x011d;
    L_0x020c:
        r0 = 0;
        goto L_0x00f7;
    L_0x020f:
        r0 = move-exception;
        r1 = "MicroMsg.BitrateCalculator";
        r3 = new java.lang.StringBuilder;
        r4 = "do calc bitrate error: ";
        r3.<init>(r4);
        r0 = r0.toString();
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);
        r0 = r2;
        goto L_0x00f7;
    L_0x022d:
        r0 = r3;
        r1 = r4;
        goto L_0x0158;
    L_0x0231:
        r0 = r3;
        r1 = r4;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.a.a(com.tencent.mm.modelcontrol.f[], com.tencent.mm.modelcontrol.VideoTransPara, com.tencent.mm.modelcontrol.VideoTransPara):int");
    }
}
