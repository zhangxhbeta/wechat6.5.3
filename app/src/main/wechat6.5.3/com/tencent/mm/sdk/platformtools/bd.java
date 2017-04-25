package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;

public final class bd {
    private static long nlA;
    private static long nlB;
    private static long nlC;
    private static long nlD;
    private static long nlE;
    private static long nlF;
    private static long nlG;
    private static long nlH;
    private static long nlI;
    private static long nlJ;
    private static long nlK;
    private static long nlL;
    private static long nlM;
    private static long nlN;
    private static long nlO;
    private static final File nlP;
    private static final File nlQ;
    private static long nlz;

    static {
        File file = null;
        File file2 = new File("/proc/" + Process.myPid() + "/net/dev");
        if (!file2.isFile()) {
            file2 = null;
        }
        nlP = file2;
        file2 = new File("/proc/net/xt_qtaguid/stats");
        if (file2.isFile()) {
            file = file2;
        }
        nlQ = file;
    }

    public static long btZ() {
        return nlJ > 0 ? nlJ : 0;
    }

    public static long bua() {
        return nlK > 0 ? nlK : 0;
    }

    public static long bub() {
        return nlH > 0 ? nlH : 0;
    }

    public static long buc() {
        return nlI > 0 ? nlI : 0;
    }

    public static long bud() {
        return nlN > 0 ? nlN : 0;
    }

    public static long bue() {
        return nlO > 0 ? nlO : 0;
    }

    public static long buf() {
        return nlL > 0 ? nlL : 0;
    }

    public static long bug() {
        return nlM > 0 ? nlM : 0;
    }

    public static void reset() {
        nlz = -1;
        nlA = -1;
        nlB = -1;
        nlC = -1;
        nlE = -1;
        nlD = -1;
        nlG = -1;
        nlF = -1;
        update();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void update() {
        /*
        r20 = 0;
        r18 = 0;
        r16 = 0;
        r4 = 0;
        r14 = 0;
        r12 = 0;
        r10 = 0;
        r8 = 0;
        r3 = 0;
        r2 = nlP;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        if (r2 == 0) goto L_0x01d0;
    L_0x0015:
        r6 = new java.util.Scanner;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r2 = nlP;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r6.nextLine();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r6.nextLine();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r2 = r4;
        r4 = r16;
    L_0x0025:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        if (r7 == 0) goto L_0x00a1;
    L_0x002b:
        r7 = r6.nextLine();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r16 = "[ :\t]+";
        r0 = r16;
        r16 = r7.split(r0);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r7 = 0;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r7 = r7.length();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        if (r7 != 0) goto L_0x008a;
    L_0x0041:
        r7 = 1;
    L_0x0042:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r22 = "lo";
        r0 = r17;
        r1 = r22;
        r17 = r0.equals(r1);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        if (r17 != 0) goto L_0x0025;
    L_0x0053:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r22 = "rmnet";
        r0 = r17;
        r1 = r22;
        r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        if (r17 != 0) goto L_0x0075;
    L_0x0064:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r22 = "ccmni";
        r0 = r17;
        r1 = r22;
        r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        if (r17 == 0) goto L_0x008c;
    L_0x0075:
        r17 = r7 + 9;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r22 = java.lang.Long.parseLong(r17);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r20 = r20 + r22;
        r7 = r7 + 1;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r16 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r18 = r18 + r16;
        goto L_0x0025;
    L_0x008a:
        r7 = 0;
        goto L_0x0042;
    L_0x008c:
        r17 = r7 + 9;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r22 = java.lang.Long.parseLong(r17);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r4 = r4 + r22;
        r7 = r7 + 1;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r16 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r2 = r2 + r16;
        goto L_0x0025;
    L_0x00a1:
        r6.close();	 Catch:{ Exception -> 0x0328, all -> 0x0323 }
        r6 = 0;
        r16 = nlz;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x00cc;
    L_0x00ad:
        nlz = r20;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newMobileTx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x00cc:
        r16 = nlA;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x00f3;
    L_0x00d4:
        nlA = r18;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newMobileRx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x00f3:
        r16 = nlB;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x011a;
    L_0x00fb:
        nlB = r4;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newWifiTx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x011a:
        r16 = nlC;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x0141;
    L_0x0122:
        nlC = r2;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newWifiRx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x0141:
        r16 = nlC;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r2 - r16;
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x016c;
    L_0x014b:
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "minu %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r24 = nlC;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r24 = r2 - r24;
        r23 = java.lang.Long.valueOf(r24);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x016c:
        r16 = nlB;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r4 - r16;
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x0197;
    L_0x0176:
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "minu %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17 = r0;
        r22 = 0;
        r24 = nlB;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r24 = r4 - r24;
        r23 = java.lang.Long.valueOf(r24);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r17[r22] = r23;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.v(r7, r0, r1);	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
    L_0x0197:
        r16 = nlz;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x0228;
    L_0x019d:
        r16 = nlz;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r20 - r16;
    L_0x01a1:
        nlH = r16;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = nlA;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x022c;
    L_0x01a9:
        r16 = nlA;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r18 - r16;
    L_0x01ad:
        nlI = r16;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = nlB;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x0230;
    L_0x01b5:
        r16 = nlB;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r4 - r16;
    L_0x01b9:
        nlJ = r16;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = nlC;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r7 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x0233;
    L_0x01c1:
        r16 = nlC;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r16 = r2 - r16;
    L_0x01c5:
        nlK = r16;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        nlz = r20;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        nlA = r18;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        nlB = r4;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        nlC = r2;	 Catch:{ Exception -> 0x032b, all -> 0x0323 }
        r3 = r6;
    L_0x01d0:
        r2 = nlQ;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        if (r2 == 0) goto L_0x0331;
    L_0x01d4:
        r7 = android.os.Process.myUid();	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r6 = new java.util.Scanner;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r2 = nlQ;	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0308, all -> 0x031b }
        r6.nextLine();	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r2 = r8;
        r4 = r10;
        r10 = r12;
        r12 = r14;
    L_0x01e6:
        r8 = r6.hasNext();	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        if (r8 == 0) goto L_0x0243;
    L_0x01ec:
        r8 = r6.nextLine();	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r9 = "[ :\\t]+";
        r8 = r8.split(r9);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r9 = 3;
        r9 = r8[r9];	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        if (r9 != r7) goto L_0x01e6;
    L_0x0200:
        r9 = 1;
        r9 = r8[r9];	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = 5;
        r14 = r8[r14];	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = java.lang.Long.parseLong(r14);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r16 = 7;
        r8 = r8[r16];	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r16 = java.lang.Long.parseLong(r8);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = "rmnet";
        r8 = r9.startsWith(r8);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        if (r8 != 0) goto L_0x0224;
    L_0x021b:
        r8 = "ccmni";
        r8 = r9.startsWith(r8);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        if (r8 == 0) goto L_0x0236;
    L_0x0224:
        r10 = r10 + r14;
        r12 = r12 + r16;
        goto L_0x01e6;
    L_0x0228:
        r16 = r20;
        goto L_0x01a1;
    L_0x022c:
        r16 = r18;
        goto L_0x01ad;
    L_0x0230:
        r16 = r4;
        goto L_0x01b9;
    L_0x0233:
        r16 = r2;
        goto L_0x01c5;
    L_0x0236:
        r8 = "lo";
        r8 = r9.equals(r8);	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        if (r8 != 0) goto L_0x01e6;
    L_0x023f:
        r2 = r2 + r14;
        r4 = r4 + r16;
        goto L_0x01e6;
    L_0x0243:
        r8 = nlE;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x024d;
    L_0x024b:
        nlE = r10;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
    L_0x024d:
        r8 = nlD;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x0257;
    L_0x0255:
        nlD = r12;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
    L_0x0257:
        r8 = nlG;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x0261;
    L_0x025f:
        nlG = r2;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
    L_0x0261:
        r8 = nlF;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x026b;
    L_0x0269:
        nlF = r4;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
    L_0x026b:
        r8 = nlD;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x02fe;
    L_0x0271:
        r8 = nlD;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = r12 - r8;
    L_0x0275:
        nlL = r8;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = nlE;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0301;
    L_0x027d:
        r8 = nlE;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = r10 - r8;
    L_0x0281:
        nlM = r8;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = nlF;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r7 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0304;
    L_0x0289:
        r8 = nlF;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = r4 - r8;
    L_0x028d:
        nlN = r8;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = nlG;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0306;
    L_0x0295:
        r8 = nlG;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        r8 = r2 - r8;
    L_0x0299:
        nlO = r8;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        nlD = r12;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        nlE = r10;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        nlF = r4;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
        nlG = r2;	 Catch:{ Exception -> 0x032e, all -> 0x0323 }
    L_0x02a3:
        if (r6 == 0) goto L_0x02a8;
    L_0x02a5:
        r6.close();
    L_0x02a8:
        r2 = "MicroMsg.SDK.TrafficStats";
        r3 = "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d";
        r4 = 8;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = nlK;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = nlJ;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = nlI;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = nlH;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 4;
        r6 = nlO;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 5;
        r6 = nlN;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 6;
        r6 = nlM;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 7;
        r6 = nlL;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        return;
    L_0x02fe:
        r8 = r12;
        goto L_0x0275;
    L_0x0301:
        r8 = r10;
        goto L_0x0281;
    L_0x0304:
        r8 = r4;
        goto L_0x028d;
    L_0x0306:
        r8 = r2;
        goto L_0x0299;
    L_0x0308:
        r2 = move-exception;
    L_0x0309:
        r4 = "MicroMsg.SDK.TrafficStats";
        r5 = "Failed retrieving TrafficStats.";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0325 }
        com.tencent.mm.sdk.platformtools.v.a(r4, r2, r5, r6);	 Catch:{ all -> 0x0325 }
        if (r3 == 0) goto L_0x02a8;
    L_0x0317:
        r3.close();
        goto L_0x02a8;
    L_0x031b:
        r2 = move-exception;
        r6 = r3;
    L_0x031d:
        if (r6 == 0) goto L_0x0322;
    L_0x031f:
        r6.close();
    L_0x0322:
        throw r2;
    L_0x0323:
        r2 = move-exception;
        goto L_0x031d;
    L_0x0325:
        r2 = move-exception;
        r6 = r3;
        goto L_0x031d;
    L_0x0328:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0309;
    L_0x032b:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0309;
    L_0x032e:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0309;
    L_0x0331:
        r6 = r3;
        goto L_0x02a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.bd.update():void");
    }
}
