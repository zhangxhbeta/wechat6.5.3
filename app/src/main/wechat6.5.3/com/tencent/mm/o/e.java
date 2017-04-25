package com.tencent.mm.o;

import android.content.ContentValues;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends f<d> {
    public static final String[] cic = new String[]{f.a(d.chq, "FunctionMsgItem")};
    private static final String[] cid = new String[]{"*", "rowid"};
    private d cie;

    public final com.tencent.mm.o.d dL(java.lang.String r9) {
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
        r0 = "MicroMsg.FunctionMsgStorage";
        r1 = "getByFunctionMsgId, functionMsgId: %s";
        r2 = new java.lang.Object[r4];
        r2[r6] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r8.cie;
        r1 = "FunctionMsgItem";
        r2 = cid;
        r3 = "functionmsgid=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r9;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        if (r0 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
    L_0x0031:
        r0 = r1.isAfterLast();	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        if (r0 != 0) goto L_0x0046;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
    L_0x0037:
        r0 = new com.tencent.mm.o.d;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r0.<init>();	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r0.b(r1);	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.close();
    L_0x0044:
        r5 = r0;
        goto L_0x0009;
    L_0x0046:
        if (r1 == 0) goto L_0x0009;
    L_0x0048:
        r1.close();
        goto L_0x0009;
    L_0x004c:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r3 = "getByFunctionMsgId error: %s";	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r4 = 1;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r6 = 0;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x004c, all -> 0x0066 }
        if (r1 == 0) goto L_0x0009;
    L_0x0062:
        r1.close();
        goto L_0x0009;
    L_0x0066:
        r0 = move-exception;
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r1.close();
    L_0x006c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.o.e.dL(java.lang.String):com.tencent.mm.o.d");
    }

    public final java.util.List<com.tencent.mm.o.d> uk() {
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
        r7 = 0;
        r5 = 0;
        r0 = r8.cie;
        r1 = "FunctionMsgItem";
        r2 = cid;
        r3 = "status<?";
        r4 = new java.lang.String[r4];
        r6 = "2";
        r4[r7] = r6;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        if (r1 != 0) goto L_0x001d;
    L_0x001c:
        return r5;
    L_0x001d:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        if (r0 == 0) goto L_0x005e;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
    L_0x0023:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r0.<init>();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
    L_0x0028:
        r2 = r1.isAfterLast();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        if (r2 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
    L_0x002e:
        r2 = new com.tencent.mm.o.d;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r2.<init>();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r2.b(r1);	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r0.add(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r1.moveToNext();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        goto L_0x0028;
    L_0x003d:
        r0 = move-exception;
        r2 = "MicroMsg.FunctionMsgStorage";	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r3 = "getAllNeedFetchFunctionMsg error: %s";	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r4 = 1;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r6 = 0;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x003d, all -> 0x0064 }
        if (r1 == 0) goto L_0x001c;
    L_0x0053:
        r1.close();
        goto L_0x001c;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();
    L_0x005c:
        r5 = r0;
        goto L_0x001c;
    L_0x005e:
        if (r1 == 0) goto L_0x001c;
    L_0x0060:
        r1.close();
        goto L_0x001c;
    L_0x0064:
        r0 = move-exception;
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r1.close();
    L_0x006a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.o.e.uk():java.util.List<com.tencent.mm.o.d>");
    }

    public e(d dVar) {
        super(dVar, d.chq, "FunctionMsgItem", null);
        this.cie = dVar;
    }

    public final void a(String str, d dVar) {
        v.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, functionMsgId: %s", str);
        d dL = dL(str);
        if (dL != null) {
            try {
                String str2 = "MicroMsg.FunctionMsgStorage";
                String str3 = "updateByFunctionMsgId, functionMsgId: %s, newFunctionMsgItem.msgContent==null: %s,oldFunctionMsgItem.msgContent==null: %s";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(dVar.field_addMsg == null);
                objArr[2] = Boolean.valueOf(dL.field_addMsg == null);
                v.i(str2, str3, objArr);
                ContentValues py = dVar.py();
                if (py.get("addMsg") == null && dL.field_addMsg != null) {
                    py.put("addMsg", dL.field_addMsg.toByteArray());
                }
                int update = this.cie.update("FunctionMsgItem", py, "functionmsgid=?", new String[]{str});
                v.i("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId, ret: %s", Integer.valueOf(update));
            } catch (Exception e) {
                v.e("MicroMsg.FunctionMsgStorage", "updateByFunctionMsgId error: %s", e.getMessage());
            }
        }
    }
}
