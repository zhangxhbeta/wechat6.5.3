package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "IPCallAddressItem")};
    public static final String[] gIC = new String[]{"*", "rowid"};
    public com.tencent.mm.sdk.h.d cie;

    public final java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c> auT() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x004b in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r3 = 0;
        r0 = r8.cie;
        r1 = "IPCallAddressItem";
        r2 = gIC;
        r4 = r3;
        r5 = r3;
        r6 = r3;
        r7 = r3;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        if (r1 == 0) goto L_0x0053;
    L_0x0012:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        if (r0 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
    L_0x0018:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r0.<init>();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
    L_0x001d:
        r2 = r1.isAfterLast();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        if (r2 != 0) goto L_0x004c;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
    L_0x0023:
        r2 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r2.<init>();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r2.b(r1);	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r0.add(r2);	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r1.moveToNext();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        goto L_0x001d;
    L_0x0032:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r4 = "getAllAddress, error: %s";	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r5 = 1;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r6 = 0;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r4, r5);	 Catch:{ Exception -> 0x0032, all -> 0x0059 }
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        r1.close();
    L_0x004b:
        return r3;
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();
    L_0x0051:
        r3 = r0;
        goto L_0x004b;
    L_0x0053:
        if (r1 == 0) goto L_0x004b;
    L_0x0055:
        r1.close();
        goto L_0x004b;
    L_0x0059:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.close();
    L_0x005f:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.auT():java.util.ArrayList<com.tencent.mm.plugin.ipcall.a.g.c>");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c ca(long r10) {
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
        r9 = this;
        r4 = 1;
        r7 = 0;
        r5 = 0;
        r0 = r9.cie;
        r1 = "IPCallAddressItem";
        r2 = gIC;
        r3 = "rowid=?";
        r4 = new java.lang.String[r4];
        r6 = java.lang.String.valueOf(r10);
        r4[r7] = r6;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r0 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
    L_0x0021:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r0 != 0) goto L_0x0036;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
    L_0x0027:
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0.<init>();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0.b(r1);	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        r5 = r0;
    L_0x0035:
        return r5;
    L_0x0036:
        if (r1 == 0) goto L_0x0035;
    L_0x0038:
        r1.close();
        goto L_0x0035;
    L_0x003c:
        r0 = move-exception;
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r3 = "getByLocalId error: %s";	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r4 = 1;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r6 = 0;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);	 Catch:{ Exception -> 0x003c, all -> 0x0056 }
        if (r1 == 0) goto L_0x0035;
    L_0x0052:
        r1.close();
        goto L_0x0035;
    L_0x0056:
        r0 = move-exception;
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.ca(long):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c uK(java.lang.String r9) {
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
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = r8.cie;
        r1 = "IPCallAddressItem";
        r2 = gIC;
        r3 = "contactId=?";
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
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
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
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r3 = "getByContactId error: %s";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.uK(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c uL(java.lang.String r9) {
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
        r4 = 1;
        r6 = 0;
        r5 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r5;
    L_0x000a:
        r0 = r8.cie;
        r1 = "IPCallAddressItem";
        r2 = gIC;
        r3 = "systemAddressBookUsername=?";
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
        r0 = new com.tencent.mm.plugin.ipcall.a.g.c;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
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
        r2 = "MicroMsg.IPCallAddressStorage";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r3 = "getByContactName error: %s";	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4 = 1;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r6 = 0;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);	 Catch:{ Exception -> 0x003f, all -> 0x0059 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.a.g.d.uL(java.lang.String):com.tencent.mm.plugin.ipcall.a.g.c");
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "IPCallAddressItem", null);
        this.cie = dVar;
    }

    public final Cursor uM(String str) {
        int i;
        Cursor uN;
        Iterator it;
        String str2;
        String str3;
        String str4;
        System.currentTimeMillis();
        for (i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i == 0) {
            uN = uN(str);
        } else {
            ArrayList vr = a.vr(str);
            Cursor uN2 = uN(str);
            try {
                if (uN2.moveToFirst()) {
                    while (!uN2.isAfterLast()) {
                        vr.add(uN2.getString(uN2.getColumnIndex("contactId")));
                        uN2.moveToNext();
                    }
                }
                if (uN2 != null) {
                    uN2.close();
                }
            } catch (Exception e) {
                v.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", new Object[]{e.getMessage()});
                it = vr.iterator();
                str2 = "";
                while (it.hasNext()) {
                    str2 = str2 + ((String) it.next()) + ",";
                }
                if (str2.lastIndexOf(",") >= 0) {
                    str2 = str2.substring(0, str2.lastIndexOf(","));
                }
                str3 = null;
                str4 = null;
                uN = this.cie.query("IPCallAddressItem", gIC, "contactId IN " + ("(" + str2 + ")"), null, str3, str4, "upper(sortKey) asc");
            } finally {
                if (uN2 != null) {
                    uN2.close();
                }
            }
            it = vr.iterator();
            str2 = "";
            while (it.hasNext()) {
                str2 = str2 + ((String) it.next()) + ",";
            }
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            str3 = null;
            str4 = null;
            uN = this.cie.query("IPCallAddressItem", gIC, "contactId IN " + ("(" + str2 + ")"), null, str3, str4, "upper(sortKey) asc");
        }
        System.currentTimeMillis();
        return uN;
    }

    private Cursor uN(String str) {
        return this.cie.query("IPCallAddressItem", gIC, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null, null, "upper(sortKey) asc");
    }

    public final long auU() {
        if (this.cie instanceof g) {
            return ((g) this.cie).auU();
        }
        return -1;
    }

    public final void cb(long j) {
        if ((this.cie instanceof g) && j != -1) {
            ((g) this.cie).es(j);
        }
    }
}
