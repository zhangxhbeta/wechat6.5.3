package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "DelayTransferRecord")};
    private static final String[] dsX = new String[]{"*", "rowid"};
    private d cie;

    public final com.tencent.mm.plugin.remittance.b.a yC(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r0 == 0) goto L_0x0012;
    L_0x0008:
        r0 = "MicroMsg.AARecordStorage";
        r1 = "empty transferId";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
    L_0x0011:
        return r5;
    L_0x0012:
        r0 = r8.cie;
        r1 = "DelayTransferRecord";
        r2 = dsX;
        r3 = "transferId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r4[r6] = r9;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        if (r0 == 0) goto L_0x0042;	 Catch:{ Exception -> 0x0048, all -> 0x005b }
    L_0x002d:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        if (r0 != 0) goto L_0x0042;	 Catch:{ Exception -> 0x0048, all -> 0x005b }
    L_0x0033:
        r0 = new com.tencent.mm.plugin.remittance.b.a;	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        r0.<init>();	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        r0.b(r1);	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        if (r1 == 0) goto L_0x0040;
    L_0x003d:
        r1.close();
    L_0x0040:
        r5 = r0;
        goto L_0x0011;
    L_0x0042:
        if (r1 == 0) goto L_0x0011;
    L_0x0044:
        r1.close();
        goto L_0x0011;
    L_0x0048:
        r0 = move-exception;
        r2 = "MicroMsg.AARecordStorage";	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        r3 = "";	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        r4 = 0;	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0048, all -> 0x005b }
        if (r1 == 0) goto L_0x0011;
    L_0x0057:
        r1.close();
        goto L_0x0011;
    L_0x005b:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();
    L_0x0061:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.b.b.yC(java.lang.String):com.tencent.mm.plugin.remittance.b.a");
    }

    public b(d dVar) {
        super(dVar, a.chq, "DelayTransferRecord", null);
        this.cie = dVar;
    }
}
