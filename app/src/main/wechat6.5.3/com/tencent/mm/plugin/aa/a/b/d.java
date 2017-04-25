package com.tencent.mm.plugin.aa.a.b;

import com.tencent.mm.sdk.h.f;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "AARecord")};
    private static final String[] dsX = new String[]{"*", "rowid"};
    private com.tencent.mm.sdk.h.d cie;

    public final com.tencent.mm.plugin.aa.a.b.c me(java.lang.String r9) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = r8.cie;
        r1 = "AARecord";
        r2 = dsX;
        r3 = "billNo=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r9;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
    L_0x0024:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        if (r0 != 0) goto L_0x0039;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
    L_0x002a:
        r0 = new com.tencent.mm.plugin.aa.a.b.c;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r0.<init>();	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r0.b(r1);	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        if (r1 == 0) goto L_0x0037;
    L_0x0034:
        r1.close();
    L_0x0037:
        r5 = r0;
        goto L_0x0009;
    L_0x0039:
        if (r1 == 0) goto L_0x0009;
    L_0x003b:
        r1.close();
        goto L_0x0009;
    L_0x003f:
        r0 = move-exception;
        r2 = "MicroMsg.AARecordStorage";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r3 = "getRecordByBillno error: %s";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4 = 1;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r6 = 0;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        if (r1 == 0) goto L_0x0009;
    L_0x0055:
        r1.close();
        goto L_0x0009;
    L_0x0059:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.close();
    L_0x005f:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.a.b.d.me(java.lang.String):com.tencent.mm.plugin.aa.a.b.c");
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "AARecord", null);
        this.cie = dVar;
    }
}
