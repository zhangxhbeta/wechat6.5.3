package com.tencent.mm.plugin.scanner.b;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qbar.QbarNative;

public final class i {
    private long iDQ = 0;
    private boolean isInit = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(byte[] r9, android.graphics.Point r10, android.graphics.Rect r11, boolean r12) {
        /*
        r8 = this;
        r0 = 1;
        monitor-enter(r8);
        r1 = new android.graphics.Rect;	 Catch:{ all -> 0x00ff }
        r1.<init>();	 Catch:{ all -> 0x00ff }
        r2 = com.tencent.mm.compatible.d.c.rt();	 Catch:{ all -> 0x00ff }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        if (r12 == 0) goto L_0x003c;
    L_0x000f:
        r2 = r11.width();	 Catch:{ all -> 0x00ff }
        r2 = r2 % 4;
        r3 = r11.height();	 Catch:{ all -> 0x00ff }
        r3 = r3 % 4;
        r4 = r11.left;	 Catch:{ all -> 0x00ff }
        r1.left = r4;	 Catch:{ all -> 0x00ff }
        r4 = r11.right;	 Catch:{ all -> 0x00ff }
        r2 = r4 - r2;
        r1.right = r2;	 Catch:{ all -> 0x00ff }
        r2 = r11.top;	 Catch:{ all -> 0x00ff }
        r1.top = r2;	 Catch:{ all -> 0x00ff }
        r2 = r11.bottom;	 Catch:{ all -> 0x00ff }
        r2 = r2 - r3;
        r1.bottom = r2;	 Catch:{ all -> 0x00ff }
        r2 = r1.right;	 Catch:{ all -> 0x00ff }
        r3 = r1.left;	 Catch:{ all -> 0x00ff }
        if (r2 <= r3) goto L_0x003a;
    L_0x0034:
        r2 = r1.bottom;	 Catch:{ all -> 0x00ff }
        r3 = r1.top;	 Catch:{ all -> 0x00ff }
        if (r2 > r3) goto L_0x00bd;
    L_0x003a:
        monitor-exit(r8);
        return r0;
    L_0x003c:
        r2 = r10.x;	 Catch:{ all -> 0x00ff }
        r2 = r2 / 2;
        r3 = r11.height();	 Catch:{ all -> 0x00ff }
        r2 = r2 - r3;
        r1.left = r2;	 Catch:{ all -> 0x00ff }
        r2 = r10.x;	 Catch:{ all -> 0x00ff }
        r2 = r2 / 2;
        r3 = r11.height();	 Catch:{ all -> 0x00ff }
        r2 = r2 + r3;
        r1.right = r2;	 Catch:{ all -> 0x00ff }
        r2 = r10.y;	 Catch:{ all -> 0x00ff }
        r2 = r2 / 2;
        r3 = r11.width();	 Catch:{ all -> 0x00ff }
        r3 = r3 / 2;
        r2 = r2 - r3;
        r1.top = r2;	 Catch:{ all -> 0x00ff }
        r2 = r10.y;	 Catch:{ all -> 0x00ff }
        r2 = r2 / 2;
        r3 = r11.width();	 Catch:{ all -> 0x00ff }
        r3 = r3 / 2;
        r2 = r2 + r3;
        r1.bottom = r2;	 Catch:{ all -> 0x00ff }
        r2 = r1.left;	 Catch:{ all -> 0x00ff }
        if (r2 >= 0) goto L_0x0073;
    L_0x0070:
        r2 = 0;
        r1.left = r2;	 Catch:{ all -> 0x00ff }
    L_0x0073:
        r2 = r1.right;	 Catch:{ all -> 0x00ff }
        r3 = r10.x;	 Catch:{ all -> 0x00ff }
        r3 = r3 + -1;
        if (r2 <= r3) goto L_0x0081;
    L_0x007b:
        r2 = r10.x;	 Catch:{ all -> 0x00ff }
        r2 = r2 + -1;
        r1.right = r2;	 Catch:{ all -> 0x00ff }
    L_0x0081:
        r2 = r1.top;	 Catch:{ all -> 0x00ff }
        if (r2 >= 0) goto L_0x0088;
    L_0x0085:
        r2 = 0;
        r1.top = r2;	 Catch:{ all -> 0x00ff }
    L_0x0088:
        r2 = r1.bottom;	 Catch:{ all -> 0x00ff }
        r3 = r10.y;	 Catch:{ all -> 0x00ff }
        r3 = r3 + -1;
        if (r2 <= r3) goto L_0x0096;
    L_0x0090:
        r2 = r10.y;	 Catch:{ all -> 0x00ff }
        r2 = r2 + -1;
        r1.bottom = r2;	 Catch:{ all -> 0x00ff }
    L_0x0096:
        r2 = r1.width();	 Catch:{ all -> 0x00ff }
        r2 = r2 % 4;
        r3 = r1.height();	 Catch:{ all -> 0x00ff }
        r3 = r3 % 4;
        if (r2 == 0) goto L_0x00aa;
    L_0x00a4:
        r4 = r1.right;	 Catch:{ all -> 0x00ff }
        r2 = r4 - r2;
        r1.right = r2;	 Catch:{ all -> 0x00ff }
    L_0x00aa:
        if (r3 == 0) goto L_0x00b1;
    L_0x00ac:
        r2 = r1.bottom;	 Catch:{ all -> 0x00ff }
        r2 = r2 - r3;
        r1.bottom = r2;	 Catch:{ all -> 0x00ff }
    L_0x00b1:
        r2 = r1.right;	 Catch:{ all -> 0x00ff }
        r3 = r1.left;	 Catch:{ all -> 0x00ff }
        if (r2 <= r3) goto L_0x003a;
    L_0x00b7:
        r2 = r1.bottom;	 Catch:{ all -> 0x00ff }
        r3 = r1.top;	 Catch:{ all -> 0x00ff }
        if (r2 <= r3) goto L_0x003a;
    L_0x00bd:
        r2 = new com.tencent.mm.plugin.scanner.b.c;	 Catch:{ all -> 0x00ff }
        r3 = r10.x;	 Catch:{ all -> 0x00ff }
        r4 = r10.y;	 Catch:{ all -> 0x00ff }
        r2.<init>(r9, r3, r4, r1);	 Catch:{ all -> 0x00ff }
        r2 = r2.aLP();	 Catch:{ all -> 0x00ff }
        if (r2 == 0) goto L_0x003a;
    L_0x00cc:
        r3 = r8.isInit;	 Catch:{ all -> 0x00ff }
        if (r3 != 0) goto L_0x0117;
    L_0x00d0:
        r3 = com.tencent.mm.compatible.d.c.rt();	 Catch:{ all -> 0x00ff }
        if (r3 != 0) goto L_0x0102;
    L_0x00d6:
        r3 = r1.height();	 Catch:{ all -> 0x00ff }
        r1 = r1.width();	 Catch:{ all -> 0x00ff }
        r4 = 0;
        r5 = 15;
        r6 = 65;
        r1 = com.tencent.qbar.QbarNative.FocusInit(r3, r1, r4, r5, r6);	 Catch:{ all -> 0x00ff }
    L_0x00e7:
        r3 = -1;
        if (r1 != r3) goto L_0x0114;
    L_0x00ea:
        r2 = "MicroMsg.ScanClearImageDetector";
        r3 = "error in Focus init = [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ff }
        r5 = 0;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x00ff }
        r4[r5] = r1;	 Catch:{ all -> 0x00ff }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ all -> 0x00ff }
        goto L_0x003a;
    L_0x00ff:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0102:
        r3 = r1.width();	 Catch:{ all -> 0x00ff }
        r1 = r1.height();	 Catch:{ all -> 0x00ff }
        r4 = 0;
        r5 = 15;
        r6 = 65;
        r1 = com.tencent.qbar.QbarNative.FocusInit(r3, r1, r4, r5, r6);	 Catch:{ all -> 0x00ff }
        goto L_0x00e7;
    L_0x0114:
        r0 = 1;
        r8.isInit = r0;	 Catch:{ all -> 0x00ff }
    L_0x0117:
        r0 = com.tencent.mm.sdk.platformtools.be.Nj();	 Catch:{ all -> 0x00ff }
        r3 = com.tencent.mm.compatible.d.c.rt();	 Catch:{ all -> 0x00ff }
        r4 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        com.tencent.qbar.QbarNative.FocusPro(r2, r3, r4);	 Catch:{ all -> 0x00ff }
        r2 = "MicroMsg.ScanClearImageDetector";
        r3 = "is best:%s, need focus:%s, cost:%s";
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ff }
        r5 = 0;
        r6 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        r7 = 0;
        r6 = r6[r7];	 Catch:{ all -> 0x00ff }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x00ff }
        r4[r5] = r6;	 Catch:{ all -> 0x00ff }
        r5 = 1;
        r6 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        r7 = 1;
        r6 = r6[r7];	 Catch:{ all -> 0x00ff }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x00ff }
        r4[r5] = r6;	 Catch:{ all -> 0x00ff }
        r5 = 2;
        r0 = com.tencent.mm.sdk.platformtools.be.az(r0);	 Catch:{ all -> 0x00ff }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ all -> 0x00ff }
        r4[r5] = r0;	 Catch:{ all -> 0x00ff }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);	 Catch:{ all -> 0x00ff }
        r0 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        r1 = 1;
        r0 = r0[r1];	 Catch:{ all -> 0x00ff }
        if (r0 == 0) goto L_0x0167;
    L_0x015a:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00ff }
        r8.iDQ = r0;	 Catch:{ all -> 0x00ff }
    L_0x0160:
        r0 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        r1 = 1;
        r0 = r0[r1];	 Catch:{ all -> 0x00ff }
        goto L_0x003a;
    L_0x0167:
        r0 = r8.iDQ;	 Catch:{ all -> 0x00ff }
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0175;
    L_0x016f:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00ff }
        r8.iDQ = r0;	 Catch:{ all -> 0x00ff }
    L_0x0175:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00ff }
        r2 = r8.iDQ;	 Catch:{ all -> 0x00ff }
        r2 = r0 - r2;
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x0160;
    L_0x0183:
        r2 = "MicroMsg.ScanClearImageDetector";
        r3 = "timeout, need refocus";
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);	 Catch:{ all -> 0x00ff }
        r2 = com.tencent.mm.plugin.scanner.b.b.a.iCZ;	 Catch:{ all -> 0x00ff }
        r3 = 1;
        r4 = 1;
        r2[r3] = r4;	 Catch:{ all -> 0x00ff }
        r8.iDQ = r0;	 Catch:{ all -> 0x00ff }
        goto L_0x0160;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.b.i.a(byte[], android.graphics.Point, android.graphics.Rect, boolean):boolean");
    }

    public final synchronized void release() {
        this.iDQ = 0;
        if (this.isInit) {
            v.d("MicroMsg.ScanClearImageDetector", "release, ret: %s", new Object[]{Integer.valueOf(QbarNative.FocusRelease())});
            this.isInit = false;
        }
    }
}
