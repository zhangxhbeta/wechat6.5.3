package com.tencent.mm.pluginsdk.l;

public enum k {
    ;
    
    public String appId;
    private int errCode;
    private int errType;

    private k(String str) {
        this.appId = null;
        this.errType = 0;
        this.errCode = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void k(java.lang.String r10, java.lang.String r11, int r12, int r13) {
        /*
        r9 = 3;
        r8 = 2;
        r3 = -1;
        r2 = 1;
        r1 = 0;
        r0 = "MicroMsg.SoterReportManager";
        r4 = "SoterReportManager functionName: %s, appId: %s, errType: %d, errCode: %d";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r5[r1] = r10;
        r5[r2] = r11;
        r6 = java.lang.Integer.valueOf(r12);
        r5[r8] = r6;
        r6 = java.lang.Integer.valueOf(r13);
        r5[r9] = r6;
        com.tencent.mm.sdk.platformtools.v.d(r0, r4, r5);
        r0 = r10.hashCode();
        switch(r0) {
            case -1378849968: goto L_0x0068;
            case 70807596: goto L_0x0073;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = r3;
    L_0x0029:
        switch(r0) {
            case 0: goto L_0x007e;
            case 1: goto L_0x0080;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = "MicroMsg.SoterReportManager";
        r4 = "unknown soter jsapi function name";
        com.tencent.mm.sdk.platformtools.v.e(r0, r4);
        r0 = r3;
    L_0x0036:
        r4 = "MicroMsg.SoterReportManager";
        r5 = "functionNameCode: %d";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);
        if (r0 == r3) goto L_0x0067;
    L_0x0049:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 13711; // 0x358f float:1.9213E-41 double:6.774E-320;
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r0 = java.lang.Integer.valueOf(r0);
        r5[r1] = r0;
        r5[r2] = r11;
        r0 = java.lang.Integer.valueOf(r12);
        r5[r8] = r0;
        r0 = java.lang.Integer.valueOf(r13);
        r5[r9] = r0;
        r3.h(r4, r5);
    L_0x0067:
        return;
    L_0x0068:
        r0 = "requireSoterBiometricAuthentication";
        r0 = r10.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0071:
        r0 = r1;
        goto L_0x0029;
    L_0x0073:
        r0 = "getSupportSoter";
        r0 = r10.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x007c:
        r0 = r2;
        goto L_0x0029;
    L_0x007e:
        r0 = r1;
        goto L_0x0036;
    L_0x0080:
        r0 = r2;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.l.k.k(java.lang.String, java.lang.String, int, int):void");
    }
}
