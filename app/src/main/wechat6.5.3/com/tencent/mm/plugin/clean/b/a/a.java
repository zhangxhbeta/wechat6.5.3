package com.tencent.mm.plugin.clean.b.a;

public abstract class a implements Runnable {
    private a eVe;
    c eVf;

    public interface a {
        void adG();
    }

    public abstract void execute();

    public void run() {
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
        r4 = this;
        r4.execute();	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        r0 = r4.eVf;
        if (r0 == 0) goto L_0x0018;
    L_0x0007:
        r0 = r4.eVf;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.g(r1);
    L_0x0018:
        r0 = r4.eVe;
        if (r0 == 0) goto L_0x0021;
    L_0x001c:
        r0 = r4.eVe;
        r0.adG();
    L_0x0021:
        return;
    L_0x0022:
        r0 = move-exception;
        r1 = "MicroMsg.AbstractTask";	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        r2 = "";	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        r3 = 0;	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);	 Catch:{ Exception -> 0x0022, all -> 0x004e }
        r0 = r4.eVf;
        if (r0 == 0) goto L_0x0044;
    L_0x0033:
        r0 = r4.eVf;
        r1 = java.lang.Thread.currentThread();
        r2 = r1.getId();
        r1 = java.lang.Long.valueOf(r2);
        r0.g(r1);
    L_0x0044:
        r0 = r4.eVe;
        if (r0 == 0) goto L_0x0021;
    L_0x0048:
        r0 = r4.eVe;
        r0.adG();
        goto L_0x0021;
    L_0x004e:
        r0 = move-exception;
        r1 = r4.eVf;
        if (r1 == 0) goto L_0x0064;
    L_0x0053:
        r1 = r4.eVf;
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        r2 = java.lang.Long.valueOf(r2);
        r1.g(r2);
    L_0x0064:
        r1 = r4.eVe;
        if (r1 == 0) goto L_0x006d;
    L_0x0068:
        r1 = r4.eVe;
        r1.adG();
    L_0x006d:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.b.a.a.run():void");
    }

    public a(a aVar) {
        this.eVe = aVar;
    }
}
