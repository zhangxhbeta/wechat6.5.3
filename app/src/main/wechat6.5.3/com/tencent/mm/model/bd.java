package com.tencent.mm.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class bd extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS readerappnews1 ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE TABLE IF NOT EXISTS readerappweibo ( tweetid text  PRIMARY KEY , time long  , type int  , name text  , title text  , url text  , shorturl text  , longurl text  , pubtime long  , sourcename text  , sourceicon text  , istop int  , cover text  , digest text  , reserved1 int  , reserved2 long  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappnews1 ( time )", "CREATE INDEX IF NOT EXISTS  readerapptime ON readerappweibo ( time )"};
    public com.tencent.mm.bg.g cuX;

    public final java.util.List<com.tencent.mm.model.bc> q(java.lang.String r9, int r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0058 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r0 = r8.cuX;
        r1 = eP(r10);
        r2 = new java.lang.String[r4];
        r3 = "*";
        r2[r6] = r3;
        r3 = "reserved3=?";
        r4 = new java.lang.String[r4];
        r4[r6] = r9;
        r6 = r5;
        r7 = r5;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        if (r1 == 0) goto L_0x0060;
    L_0x001f:
        r0 = r1.moveToFirst();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        if (r0 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
    L_0x0025:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r0.<init>();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
    L_0x002a:
        r2 = r1.isAfterLast();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        if (r2 != 0) goto L_0x0059;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
    L_0x0030:
        r2 = new com.tencent.mm.model.bc;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r2.<init>();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r2.b(r1);	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r0.add(r2);	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r1.moveToNext();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        goto L_0x002a;
    L_0x003f:
        r0 = move-exception;
        r2 = "MicroMsg.ReaderAppInfoStorage";	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r3 = "getByFunctionMsgId, error: %s";	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r4 = 1;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r6 = 0;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        r4[r6] = r0;	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);	 Catch:{ Exception -> 0x003f, all -> 0x0066 }
        if (r1 == 0) goto L_0x0058;
    L_0x0055:
        r1.close();
    L_0x0058:
        return r5;
    L_0x0059:
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.close();
    L_0x005e:
        r5 = r0;
        goto L_0x0058;
    L_0x0060:
        if (r1 == 0) goto L_0x0058;
    L_0x0062:
        r1.close();
        goto L_0x0058;
    L_0x0066:
        r0 = move-exception;
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r1.close();
    L_0x006c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.bd.q(java.lang.String, int):java.util.List<com.tencent.mm.model.bc>");
    }

    private static String fW(String str) {
        return "select tweetid,time,type,name,title,url,shorturl,longurl,pubtime,sourcename,sourceicon,istop,cover,digest,reserved1,reserved2,reserved3,reserved4 from " + str + "  ";
    }

    public static String eP(int i) {
        if (i == 20) {
            return "readerappnews1";
        }
        if (i == 11) {
            return "readerappweibo";
        }
        Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
        return null;
    }

    public bd(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        bcVar.bkU = -1;
        ContentValues contentValues = new ContentValues();
        if ((bcVar.bkU & 1) != 0) {
            contentValues.put("tweetid", bcVar.zG());
        }
        if ((bcVar.bkU & 2) != 0) {
            contentValues.put("time", Long.valueOf(bcVar.time));
        }
        if ((bcVar.bkU & 4) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(bcVar.type));
        }
        if ((bcVar.bkU & 8) != 0) {
            contentValues.put("name", bcVar.getName());
        }
        if ((bcVar.bkU & 16) != 0) {
            contentValues.put("title", bcVar.getTitle());
        }
        if ((bcVar.bkU & 32) != 0) {
            contentValues.put("url", bcVar.getUrl());
        }
        if ((bcVar.bkU & 64) != 0) {
            contentValues.put("shorturl", bcVar.zH());
        }
        if ((bcVar.bkU & 128) != 0) {
            contentValues.put("longurl", bcVar.cuO == null ? "" : bcVar.cuO);
        }
        if ((bcVar.bkU & 256) != 0) {
            contentValues.put("pubtime", Long.valueOf(bcVar.cuP));
        }
        if ((bcVar.bkU & 512) != 0) {
            contentValues.put("sourcename", bcVar.zI());
        }
        if ((bcVar.bkU & 1024) != 0) {
            contentValues.put("sourceicon", bcVar.zJ());
        }
        if ((bcVar.bkU & 2048) != 0) {
            contentValues.put("istop", Integer.valueOf(bcVar.cuS));
        }
        if ((bcVar.bkU & 4096) != 0) {
            contentValues.put("cover", bcVar.zK());
        }
        if ((bcVar.bkU & 8192) != 0) {
            contentValues.put("digest", bcVar.zL());
        }
        if ((bcVar.bkU & 16384) != 0) {
            contentValues.put("reserved1", Integer.valueOf(bcVar.cuT));
        }
        if ((bcVar.bkU & 32768) != 0) {
            contentValues.put("reserved2", Long.valueOf(bcVar.cuU));
        }
        if ((bcVar.bkU & 65536) != 0) {
            contentValues.put("reserved3", bcVar.zM());
        }
        if ((bcVar.bkU & 131072) != 0) {
            contentValues.put("reserved4", bcVar.cuW == null ? "" : bcVar.cuW);
        }
        if (((int) this.cuX.insert(eP(bcVar.type), "tweetid", contentValues)) != -1) {
            return true;
        }
        return false;
    }

    public final Cursor aF(int i, int i2) {
        return this.cuX.rawQuery("SELECT time from " + eP(i2) + " GROUP BY time ORDER BY time" + " ASC  LIMIT " + i + " offset (SELECT COUNT(*) FROM (SELECT COUNT(*) FROM " + eP(i2) + " GROUP BY time)) -" + i, null);
    }

    public final int eQ(int i) {
        int i2 = 0;
        Cursor rawQuery = this.cuX.rawQuery("select count(*) from (SELECT count(*) FROM " + eP(i) + " group by time)", null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i2;
    }

    public final List<bc> b(long j, int i) {
        List arrayList = new ArrayList();
        String str = fW(eP(20)) + " where reserved2 = " + j;
        v.d("MicroMsg.ReaderAppInfoStorage", "getInfoListByMsgSvrID :" + str);
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        int count = rawQuery.getCount();
        if (count <= 0) {
            rawQuery.close();
        } else {
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                bc bcVar = new bc();
                bcVar.b(rawQuery);
                arrayList.add(bcVar);
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public final List<bc> c(long j, int i) {
        List arrayList = new ArrayList();
        String str = fW(eP(i)) + " where time = " + j + " order by istop desc , tweetid" + " asc ";
        v.d("MicroMsg.ReaderAppInfoStorage", "getInfobyGroup :" + str);
        Cursor rawQuery = this.cuX.rawQuery(str, null);
        int count = rawQuery.getCount();
        if (count <= 0) {
            rawQuery.close();
        } else {
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                bc bcVar = new bc();
                bcVar.b(rawQuery);
                arrayList.add(bcVar);
            }
            rawQuery.close();
        }
        return arrayList;
    }

    public final void N(long j) {
        v.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", new Object[]{"delete from " + eP(20) + " where reserved2 = " + j});
        if (this.cuX.dF(eP(20), "delete from " + eP(20) + " where reserved2 = " + j)) {
            eS(20);
            Ls();
        }
    }

    public final void a(String str, int i, boolean z, boolean z2) {
        List<bc> q = q(str, i);
        if (q != null && q.size() != 0) {
            bc bcVar = (bc) q.get(0);
            bc bcVar2 = bcVar;
            for (bc bcVar3 : q) {
                if (bcVar3.cuS != 1) {
                    bcVar3 = bcVar2;
                }
                bcVar2 = bcVar3;
            }
            if (this.cuX.delete(eP(i), "reserved3=?", new String[]{str}) >= 0 && z) {
                Ls();
            }
            if (z2) {
                v.i("MicroMsg.ReaderAppInfoStorage", "processConversationAfterDeleteInfo, sql is %s", new Object[]{fW(eP(i)) + " where istop = 1  group by " + "time ORDER BY time DESC " + " limit 2"});
                Cursor rawQuery = this.cuX.rawQuery(r0, null);
                ab abVar;
                if (rawQuery.getCount() == 0) {
                    rawQuery.close();
                    abVar = new ab();
                    abVar.setUsername(bc.eO(i));
                    abVar.setContent("");
                    abVar.s(0);
                    abVar.di(0);
                    abVar.df(0);
                    ak.yW();
                    c.wK().a(abVar, bc.eO(i), true);
                    return;
                }
                ak.yW();
                ab Mh = c.wK().Mh(bc.eO(i));
                rawQuery.moveToFirst();
                bc bcVar4 = new bc();
                bcVar4.b(rawQuery);
                rawQuery.close();
                abVar = new ab();
                abVar.setUsername(bc.eO(i));
                abVar.setContent(bcVar4.getTitle());
                abVar.s(bcVar4.time);
                abVar.di(0);
                if (Mh.field_unReadCount <= 0 || bcVar2 == null || !Mh.field_content.equals(bcVar2.getTitle())) {
                    abVar.df(0);
                } else {
                    abVar.df(Mh.field_unReadCount - 1);
                }
                ak.yW();
                c.wK().a(abVar, bc.eO(i), true);
            }
        }
    }

    public final void eR(int i) {
        ak.yW();
        ab Mh = c.wK().Mh(bc.eO(i));
        if (Mh != null && Mh.field_username.equals(bc.eO(i))) {
            Mh.setUsername(bc.eO(i));
            Mh.setContent("");
            Mh.di(0);
            Mh.df(0);
            ak.yW();
            c.wK().a(Mh, bc.eO(i), true);
            if (this.cuX.dF(eP(i), "delete from " + eP(i))) {
                Ls();
            }
        }
    }

    public final void eS(int i) {
        v.i("MicroMsg.ReaderAppInfoStorage", "reset conversation, sql is %s", new Object[]{fW(eP(i)) + " where istop = 1  group by " + "time ORDER BY time DESC " + " limit 2"});
        Cursor rawQuery = this.cuX.rawQuery(r0, null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            ab abVar = new ab();
            abVar.setUsername(bc.eO(i));
            abVar.setContent("");
            abVar.s(0);
            abVar.di(0);
            abVar.df(0);
            ak.yW();
            c.wK().a(abVar, bc.eO(i), true);
            return;
        }
        rawQuery.moveToFirst();
        bc bcVar = new bc();
        bcVar.b(rawQuery);
        rawQuery.close();
        abVar = new ab();
        abVar.setUsername(bc.eO(i));
        abVar.setContent(bcVar.getTitle());
        abVar.s(bcVar.time);
        abVar.di(0);
        abVar.df(0);
        ak.yW();
        c.wK().a(abVar, bc.eO(i), true);
    }
}
