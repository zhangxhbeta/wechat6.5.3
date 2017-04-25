package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.f.a.a.e;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import junit.framework.Assert;

public final class au extends g {
    public static final String[] cic;
    private static e nvZ;
    public final com.tencent.mm.bg.g cuX;
    private final long nuX = 86400;
    private boolean nvV = false;
    private ar nvW;
    private aq nvX;
    private List<e> nvY = new ArrayList();
    public List<b> nwa;
    private final f<Integer, com.tencent.mm.storage.at.c> nwb = new f(100);
    private final f<Integer, d> nwc = new f(100);
    private final f<Integer, com.tencent.mm.storage.at.a> nwd = new f(100);
    private final f<Integer, com.tencent.mm.storage.at.b> nwe = new f(100);
    private final f<Integer, Object> nwf = new f(100);
    private final f<String, Long> nwg = new f(100);
    private ae nwh = new ae();
    private final h<a, c> nwi = new h<a, c>(this) {
        final /* synthetic */ au nwn;

        {
            this.nwn = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a(this.nwn, (c) obj2);
        }
    };
    private Map<String, c> nwj = new HashMap();
    private boolean nwk = false;
    private String nwl = SQLiteDatabase.KeyEmpty;
    private long nwm = 0;

    public interface a {
        void a(au auVar, c cVar);
    }

    public static class b {
        long cLC;
        public String name;
        private a[] nwo;
        int nwp;

        private static class a {
            long nwq;
            long nwr;

            private a() {
            }
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            if (aVarArr.length == 2) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            Assert.assertTrue(aVarArr[0].nwr >= aVarArr[0].nwq);
            Assert.assertTrue(aVarArr[1].nwr >= aVarArr[1].nwq);
            if (aVarArr[1].nwq < aVarArr[0].nwr) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.nwo = aVarArr;
            this.nwp = i;
            this.cLC = aVarArr[0].nwq;
        }

        public final synchronized void bxa() {
            if (this.cLC == this.nwo[0].nwr) {
                this.cLC = this.nwo[1].nwq;
                com.tencent.mm.plugin.report.b.itm.a(111, 251, 1, false);
            } else {
                this.cLC++;
            }
            v.i("MicroMsg.MsgInfoStorage", "incMsgLocalId %d  ", Long.valueOf(this.cLC));
        }

        public final boolean eq(long j) {
            for (a aVar : this.nwo) {
                boolean z = j >= aVar.nwq && j <= aVar.nwr;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.nwq = j;
            aVar.nwr = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.nwq = j3;
            aVar.nwr = j4;
            aVarArr[1] = aVar;
            return aVarArr;
        }
    }

    public static class c {
        public String bdo;
        public long ezh;
        public String nws;
        public ArrayList<at> nwt;
        public int nwu;
        public int nwv;
        public int nww;
        public long nwx;

        public c(String str, String str2, at atVar) {
            this(str, str2, atVar, 0);
        }

        public c(String str, String str2, at atVar, int i) {
            long j = -1;
            this.nwt = new ArrayList();
            this.nwv = 0;
            this.nww = 0;
            this.nwx = 0;
            this.ezh = -1;
            this.bdo = str;
            this.nws = str2;
            this.nwu = i;
            if (atVar != null) {
                j = atVar.field_bizChatId;
            }
            this.ezh = j;
            if (atVar != null) {
                this.nwt.add(atVar);
            }
        }

        public c(String str, String str2, int i) {
            this(str, str2, null, 0);
            this.nww = i;
        }

        static boolean U(at atVar) {
            return atVar != null && atVar.field_isSend == 0 && atVar.field_status == 3;
        }
    }

    public final int Nk(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r7 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r7.Lv(r8);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r7.MF(r8);
        r0 = r0.append(r2);
        r2 = "AND isSend=1";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r7.cuX;
        r3 = 0;
        r3 = r0.rawQuery(r2, r3);
        r0 = r3.moveToLast();	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        if (r0 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x0038:
        r0 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
    L_0x003d:
        r3.close();
    L_0x0040:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]";
        r5 = 3;
        r5 = new java.lang.Object[r5];
        r5[r1] = r8;
        r1 = 1;
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r1 = 2;
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r5);
        return r0;
    L_0x0059:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r5 = "";	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = 0;	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        com.tencent.mm.sdk.platformtools.v.a(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0059, all -> 0x006b }
        r3.close();
        r0 = r1;
        goto L_0x0040;
    L_0x006b:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x0070:
        r0 = r1;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.au.Nk(java.lang.String):int");
    }

    public final int dN(java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r7 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = " SELECT COUNT(*) FROM ";
        r0.<init>(r2);
        r2 = r7.Lv(r8);
        r0 = r0.append(r2);
        r2 = " WHERE";
        r0 = r0.append(r2);
        r2 = r7.MF(r8);
        r0 = r0.append(r2);
        r2 = "AND content LIKE '";
        r0 = r0.append(r2);
        r0 = r0.append(r9);
        r2 = "%' ";
        r0 = r0.append(r2);
        r2 = r0.toString();
        r0 = r7.cuX;
        r3 = 0;
        r3 = r0.rawQuery(r2, r3);
        r0 = r3.moveToLast();	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0043:
        r0 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r0 = r3.getInt(r0);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
    L_0x0048:
        r3.close();
    L_0x004b:
        r3 = "MicroMsg.MsgInfoStorage";
        r4 = "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]";
        r5 = 4;
        r5 = new java.lang.Object[r5];
        r5[r1] = r8;
        r1 = 1;
        r5[r1] = r9;
        r1 = 2;
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r1 = 3;
        r5[r1] = r2;
        com.tencent.mm.sdk.platformtools.v.d(r3, r4, r5);
        return r0;
    L_0x0067:
        r0 = move-exception;
        r4 = "MicroMsg.MsgInfoStorage";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r5 = "";	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = 0;	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        com.tencent.mm.sdk.platformtools.v.a(r4, r0, r5, r6);	 Catch:{ Exception -> 0x0067, all -> 0x0079 }
        r3.close();
        r0 = r1;
        goto L_0x004b;
    L_0x0079:
        r0 = move-exception;
        r3.close();
        throw r0;
    L_0x007e:
        r0 = r1;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.au.dN(java.lang.String, java.lang.String):int");
    }

    public static void a(e eVar) {
        nvZ = eVar;
    }

    public final void a(e eVar) {
        synchronized (this.nvY) {
            if (!this.nvY.contains(this.nvY)) {
                this.nvY.add(eVar);
            }
        }
    }

    static {
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId" + " INTEGER , type INT, status" + " INT, isSend INT, isShowTimer" + " INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath" + " TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording" + " TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId" + " TEXT, msgSeq INTEGER, flag" + " INT) ";
        cic = strArr;
    }

    protected final void a(c cVar) {
        if (this.nwi.bg(cVar)) {
            this.nwi.Ls();
        }
    }

    public final void a(a aVar, Looper looper) {
        this.nwi.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.nwi.remove(aVar);
    }

    public final void lock() {
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
    }

    public final void unlock() {
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
    }

    public final void MC(String str) {
        v.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.nwk), Integer.valueOf(this.nmh.nmk), Integer.valueOf(this.nwi.nmk), Integer.valueOf(this.nwj.size()), this.nwl, Long.valueOf(be.ay(this.nwm)));
        if (be.kS(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.nwk) {
            v.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.nwl, Long.valueOf(be.ay(this.nwm)));
            return;
        }
        this.nwl = str;
        this.nwm = be.Ni();
        this.nwk = true;
        super.lock();
        this.nwi.lock();
    }

    public final void MD(String str) {
        v.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.nwk), Integer.valueOf(this.nmh.nmk), Integer.valueOf(this.nwi.nmk), Integer.valueOf(this.nwj.size()), this.nwl, Long.valueOf(be.ay(this.nwm)));
        if (be.kS(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.nwk) {
            v.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, be.bur());
        } else if (str.equals(this.nwl)) {
            this.nwk = false;
            this.nwm = 0;
            this.nwl = SQLiteDatabase.KeyEmpty;
            for (String str2 : this.nwj.keySet()) {
                a((c) this.nwj.get(str2));
            }
            this.nwj.clear();
            super.unlock();
            this.nwi.unlock();
            Ls();
        } else {
            v.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.nwl, Long.valueOf(be.ay(this.nwm)), str);
        }
    }

    protected static void a(com.tencent.mm.bg.g gVar, String str) {
        Object obj = null;
        Cursor rawQuery = gVar.rawQuery("PRAGMA table_info( " + str + " )", null);
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj9 = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        rawQuery.close();
        long er = gVar.er(Thread.currentThread().getId());
        if (obj9 == null) {
            gVar.dF(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj8 == null) {
            gVar.dF(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj7 == null) {
            gVar.dF(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj6 == null) {
            gVar.dF(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            gVar.dF(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj4 == null) {
            gVar.dF(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj3 == null) {
            gVar.dF(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj2 == null) {
            gVar.dF(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj == null) {
            gVar.dF(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        gVar.es(er);
    }

    public final void R(String str, long j) {
        b Nf = Nf(str);
        long j2 = Nf.cLC;
        Random random = new Random();
        this.cuX.dF("message", "BEGIN;");
        bx atVar = new at(str);
        for (int i = 0; ((long) i) < j; i++) {
            atVar.z(System.currentTimeMillis());
            atVar.setType(1);
            atVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + be.bus());
            atVar.x(j2);
            atVar.dh(random.nextInt(4));
            atVar.di(random.nextInt(1));
            j2++;
            Nf.cLC++;
            atVar.y(System.currentTimeMillis() + ((long) be.bus()));
            this.cuX.dF("message", "INSERT INTO " + Lv(atVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + atVar.field_msgId + "," + atVar.field_msgSvrId + "," + atVar.field_type + "," + atVar.field_status + "," + atVar.field_createTime + ",'" + atVar.field_talker + "','" + atVar.field_content + "'," + MG(str) + ");");
            if (i % 10000 == 0) {
                this.cuX.dF("message", "COMMIT;");
                this.cuX.dF("message", "BEGIN;");
            }
        }
        this.cuX.dF("message", "COMMIT;");
        this.nvW.Mi(str);
        atVar.x(1 + j2);
        R(atVar);
    }

    private void bwS() {
        long currentTimeMillis = System.currentTimeMillis();
        long er = this.cuX.er(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        String str = "message";
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId" + " )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId" + ",type,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId" + ",status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId" + ",isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId" + ",createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId" + ",msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker" + ",type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker" + ",msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker" + ",flag,msgSeq" + " )"};
        if (!this.nvV) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        for (int i = 0; i < arrayList.size(); i++) {
            this.cuX.dF("message", (String) arrayList.get(i));
        }
        v.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        this.cuX.es(er);
        v.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void bwT() {
        com.tencent.mm.kernel.g.vx();
        com.tencent.mm.kernel.g.vw().vf().set(348167, Integer.valueOf(1));
    }

    public au(com.tencent.mm.bg.g gVar, aq aqVar, ar arVar) {
        this.cuX = gVar;
        this.nvX = aqVar;
        this.nvW = arVar;
        com.tencent.mm.kernel.g.vx();
        if (((Integer) com.tencent.mm.kernel.g.vw().vf().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.cuX.delete("message", "msgId> ? ", new String[]{"80000000"});
            v.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().vf().set(348169, Integer.valueOf(1));
        }
        a(gVar, "message");
        bwS();
        if (this.nwa == null) {
            this.nwa = new LinkedList();
        }
        this.nwa.clear();
        a(new b(1, "message", b.a(1, 1000000, 10000000, 90000000)));
    }

    protected final void a(b bVar) {
        this.nwa.add(bVar);
        b(bVar);
    }

    public final void bwU() {
        for (int i = 0; i < this.nwa.size(); i++) {
            b((b) this.nwa.get(i));
        }
    }

    private void b(b bVar) {
        Cursor rawQuery = this.cuX.rawQuery("select max(msgid) from " + bVar.name, null);
        if (rawQuery.moveToFirst()) {
            int i = rawQuery.getInt(0);
            v.i("MicroMsg.MsgInfoStorage", "id count is %d", Integer.valueOf(i));
            if (((long) i) >= bVar.cLC) {
                bVar.cLC = (long) i;
            }
        }
        rawQuery.close();
        v.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.cLC);
    }

    public final void bwV() {
        if (this.nvV) {
            String str = "message";
            Cursor rawQuery = this.cuX.rawQuery("select count(*) from " + str + " where talkerId ISNULL ", null);
            if (rawQuery != null) {
                int i = rawQuery.moveToLast() ? rawQuery.getInt(0) : 0;
                rawQuery.close();
                if (i > 0) {
                    v.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    v.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.cuX.dF(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.cuX.dF(str, "update " + str + " set talkerId=(select rowid from rcontact" + " where rcontact.username" + " = " + str + ".talker)") && this.nvV) {
                        this.cuX.dF("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.cuX.dF("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.cuX.dF("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.cuX.dF("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.cuX.dF("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        v.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
        }
    }

    public final at ek(long j) {
        at atVar = new at();
        Cursor query = this.cuX.query(eo(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            atVar.b(query);
        }
        query.close();
        return atVar;
    }

    public final at S(String str, long j) {
        at atVar = new at();
        Cursor query = this.cuX.query(Lv(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            atVar.b(query);
        }
        query.close();
        return atVar;
    }

    public final at T(String str, long j) {
        at atVar = new at();
        Cursor query = this.cuX.query(Lv(str), null, MF(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            atVar.b(query);
        }
        query.close();
        return atVar;
    }

    public final at U(String str, long j) {
        at atVar = new at();
        Cursor query = this.cuX.query(Lv(str), null, "createTime=? AND" + MF(str), new String[]{String.valueOf(j)}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            atVar.b(query);
        }
        query.close();
        return atVar;
    }

    public final Cursor ME(String str) {
        return this.cuX.query(Lv(str), new String[]{"createTime", "msgId"}, MF(str), null, "createTime", null, "createTime ASC");
    }

    public final List<at> V(String str, long j) {
        List<at> linkedList = new LinkedList();
        String str2 = "Select * From " + Lv(str) + " Where " + MF(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11";
        Cursor rawQuery = this.cuX.rawQuery(str2, new String[]{String.valueOf(j)});
        while (rawQuery.moveToNext()) {
            at atVar = new at();
            atVar.b(rawQuery);
            linkedList.add(atVar);
        }
        rawQuery.close();
        return linkedList;
    }

    public final List<at> W(String str, long j) {
        List<at> linkedList = new LinkedList();
        String str2 = "Select * From " + Lv(str) + " Where " + MF(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 ) " + " Order By createTime Desc Limit 11" + ";";
        Cursor rawQuery = this.cuX.rawQuery(str2, new String[]{String.valueOf(j)});
        while (rawQuery.moveToNext()) {
            at atVar = new at();
            atVar.b(rawQuery);
            linkedList.add(atVar);
        }
        rawQuery.close();
        return linkedList;
    }

    protected final String MF(String str) {
        String Lv = Lv(str);
        if (this.nvV && Lv.equals("message")) {
            return " talkerId=" + MG(str) + " ";
        }
        return " talker= '" + be.lZ(str) + "' ";
    }

    private long MG(String str) {
        long LY = this.nvX.LY(str);
        if (LY < 0) {
            u uVar = new u(str);
            uVar.setType(2);
            this.nvX.N(uVar);
            LY = this.nvX.LY(str);
        }
        v.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(LY), Boolean.valueOf(r2), be.bur());
        return LY;
    }

    public final ArrayList<at> bwW() {
        ArrayList<at> arrayList = new ArrayList();
        Cursor query = this.cuX.query("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC");
        if (query.moveToFirst()) {
            while (!query.isAfterLast()) {
                bx atVar = new at();
                atVar.b(query);
                if (!(((!atVar.bwx() ? 1 : 0) & 1) == 0 || u.LH(atVar.field_talker) || u.LJ(atVar.field_talker) || u.ew(atVar.field_talker))) {
                    arrayList.add(atVar);
                }
                query.moveToNext();
            }
        }
        query.close();
        return arrayList;
    }

    public final boolean X(String str, long j) {
        return U(str, j).field_msgId > 0;
    }

    public final int j(String str, long j, int i) {
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        v.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        return count;
    }

    public final at MH(String str) {
        at atVar = new at();
        Cursor query = this.cuX.query(Lv(str), null, MF(str), null, null, null, "msgSvrId  DESC limit 1 ");
        if (query.moveToFirst()) {
            atVar.b(query);
        }
        query.close();
        return atVar;
    }

    public final at MI(String str) {
        if (be.kS(str)) {
            return null;
        }
        at atVar = new at();
        Cursor rawQuery = this.cuX.rawQuery("select * from " + Lv(str) + " where" + MF(str) + "order by createTime DESC limit 1", null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            atVar.b(rawQuery);
        }
        rawQuery.close();
        return atVar;
    }

    public final at dL(String str, String str2) {
        if (be.kS(str)) {
            v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            return null;
        }
        bx atVar = new at();
        Cursor rawQuery = this.cuX.rawQuery("select * from " + Lv(str) + " where" + MF(str) + str2 + " order by createTime DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            atVar.b(rawQuery);
        }
        rawQuery.close();
        v.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(atVar.field_msgId));
        return atVar;
    }

    public final at MJ(String str) {
        if (be.kS(str)) {
            return null;
        }
        at atVar = new at();
        Cursor rawQuery = this.cuX.rawQuery("select * from " + Lv(str) + " where" + MF(str) + "and isSend = " + 0 + "  order by createTime DESC limit 1", null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            atVar.b(rawQuery);
        }
        rawQuery.close();
        return atVar;
    }

    public final List<at> bM(String str, int i) {
        List<at> arrayList = new ArrayList();
        Assert.assertTrue(this.nwa != null);
        Cursor rawQuery = this.cuX.rawQuery("SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND status = 3" + " AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + i, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                arrayList.add(atVar);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final at vh(int i) {
        if (this.nwa == null) {
            v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        at atVar = new at();
        long j = 0;
        for (int i2 = 0; i2 < this.nwa.size(); i2++) {
            if ((((b) this.nwa.get(i2)).nwp & i) != 0) {
                Cursor rawQuery = this.cuX.rawQuery("select * from " + ((b) this.nwa.get(i2)).name + "  order by createTime DESC limit 1", null);
                if (rawQuery.getCount() != 0) {
                    rawQuery.moveToFirst();
                    if (j < rawQuery.getLong(rawQuery.getColumnIndex("createTime"))) {
                        j = rawQuery.getLong(rawQuery.getColumnIndex("createTime"));
                        atVar.b(rawQuery);
                    }
                }
                rawQuery.close();
            }
        }
        return atVar;
    }

    public final at ap(int i, String str) {
        if (this.nwa == null) {
            v.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            return null;
        }
        String str2;
        at atVar = new at();
        if (be.kS(str)) {
            str2 = SQLiteDatabase.KeyEmpty;
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        long j = 0;
        for (int i2 = 0; i2 < this.nwa.size(); i2++) {
            if ((((b) this.nwa.get(i2)).nwp & i) != 0) {
                Cursor rawQuery = this.cuX.rawQuery("select * from " + ((b) this.nwa.get(i2)).name + str2 + "  order by createTime DESC limit 1", null);
                if (rawQuery.getCount() != 0) {
                    rawQuery.moveToFirst();
                    if (j < rawQuery.getLong(rawQuery.getColumnIndex("createTime"))) {
                        j = rawQuery.getLong(rawQuery.getColumnIndex("createTime"));
                        atVar.b(rawQuery);
                    }
                }
                rawQuery.close();
            }
        }
        return atVar;
    }

    public final int el(long j) {
        int i = 0;
        for (int i2 = 0; i2 < this.nwa.size(); i2++) {
            if ((((b) this.nwa.get(i2)).nwp & 2) != 0) {
                Cursor rawQuery = this.cuX.rawQuery("select *  from " + ((b) this.nwa.get(i2)).name + " where " + ((b) this.nwa.get(i2)).name + ".status != 4" + " and " + ((b) this.nwa.get(i2)).name + ".isSend = 0" + " and " + ((b) this.nwa.get(i2)).name + ".createTime > " + j, null);
                i += rawQuery.getCount();
                rawQuery.close();
            }
        }
        return i;
    }

    public final List<at> bwX() {
        List<at> arrayList = new ArrayList();
        Assert.assertTrue(this.nwa != null);
        List<at> arrayList2 = new ArrayList();
        for (int i = 0; i < this.nwa.size(); i++) {
            Cursor query = this.cuX.query(((b) this.nwa.get(i)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ");
            if (query.moveToFirst()) {
                while (!query.isAfterLast()) {
                    bx atVar = new at();
                    atVar.b(query);
                    query.moveToNext();
                    if (atVar.bwm() || atVar.bwk() || atVar.bwl() || atVar.bwt()) {
                        if (be.ay(atVar.field_createTime) > 600000) {
                            arrayList2.add(atVar);
                        } else {
                            arrayList.add(atVar);
                        }
                    }
                }
            }
            query.close();
        }
        if (arrayList2.size() > 0) {
            long auU = this.cuX.auU();
            for (at atVar2 : arrayList2) {
                v.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(atVar2.field_msgId), Long.valueOf(atVar2.field_createTime), atVar2.field_talker, be.KW(atVar2.field_content));
                atVar2.dh(5);
                a(atVar2.field_msgId, atVar2);
            }
            this.cuX.es(auU);
        }
        return arrayList;
    }

    public final List<at> bN(String str, int i) {
        List<at> arrayList = new ArrayList();
        Assert.assertTrue(this.nwa != null);
        Cursor rawQuery = this.cuX.rawQuery("SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND isSend = 0" + " ORDER BY createTime DESC LIMIT " + i, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                if (atVar.bwm()) {
                    arrayList.add(atVar);
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final List<at> J(String str, int i, int i2) {
        List<at> arrayList = new ArrayList();
        v.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + Lv(str) + " WHERE type = 49 ORDER BY createTime" + " DESC LIMIT " + i + " , " + i2);
        Cursor rawQuery = this.cuX.rawQuery(r1, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                if (atVar.bvY()) {
                    arrayList.add(atVar);
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final int P(at atVar) {
        int i = 0;
        if (!(atVar == null || be.kS(atVar.field_talker))) {
            Cursor rawQuery = this.cuX.rawQuery("SELECT count(msgId) FROM " + Lv(atVar.field_talker) + " WHERE" + MF(atVar.field_talker) + "AND isSend = 0" + " AND msgId >= " + atVar.field_msgId + " ORDER BY createTime DESC", null);
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    private static String MK(String str) {
        if (be.kS(str)) {
            return null;
        }
        try {
            Map q = bf.q(str, "msgsource");
            if (q == null || q.isEmpty()) {
                return null;
            }
            return (String) q.get(".msgsource.bizmsg.msgcluster");
        } catch (Throwable e) {
            v.e("MicroMsg.MsgInfoStorage", "exception:%s", be.e(e));
            v.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            return null;
        }
    }

    private static void Q(at atVar) {
        if (atVar != null && atVar.bvY()) {
            try {
                String str = atVar.field_content;
                int indexOf = str.indexOf("<msg>");
                if (indexOf > 0 && indexOf < str.length()) {
                    str = str.substring(indexOf).trim();
                }
                Map q = bf.q(str, "msg");
                if (q != null && q.size() > 0) {
                    atVar.cJ(com.tencent.mm.sdk.platformtools.au.U(q));
                }
            } catch (Exception e) {
                v.e("MicroMsg.MsgInfoStorage", e.getMessage());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long R(com.tencent.mm.storage.at r13) {
        /*
        r12 = this;
        if (r13 == 0) goto L_0x000a;
    L_0x0002:
        r0 = r13.field_talker;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x0033;
    L_0x000a:
        r1 = com.tencent.mm.plugin.report.b.itm;
        r2 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r4 = 250; // 0xfa float:3.5E-43 double:1.235E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = "MicroMsg.MsgInfoStorage";
        r2 = "Error insert message msg:%s talker:%s";
        r0 = 2;
        r3 = new java.lang.Object[r0];
        r0 = 0;
        r3[r0] = r13;
        r4 = 1;
        if (r13 != 0) goto L_0x0030;
    L_0x0025:
        r0 = "-1";
    L_0x0028:
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
        r0 = -1;
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = r13.field_talker;
        goto L_0x0028;
    L_0x0033:
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "insert lockForSync[%b], message seq[%d]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.nwk;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r13.field_msgSeq;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);
        r0 = 0;
        r1 = r13.bNo;
        r1 = com.tencent.mm.model.aw.fP(r1);
        if (r1 == 0) goto L_0x005c;
    L_0x005a:
        r0 = r1.ctt;
    L_0x005c:
        r2 = com.tencent.mm.model.m.fj(r0);
        if (r2 == 0) goto L_0x008a;
    L_0x0062:
        r2 = "MicroMsg.MsgInfoStorage";
        r3 = "msgCluster = %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        r0 = r13.field_type;
        r2 = 436207665; // 0x1a000031 float:2.6469934E-23 double:2.155152217E-315;
        if (r0 != r2) goto L_0x0084;
    L_0x0078:
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "protect:c2c msg should not here";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        r0 = -1;
        goto L_0x002f;
    L_0x0084:
        r0 = "notifymessage";
        r13.cH(r0);
    L_0x008a:
        r0 = r13.field_talker;
        r2 = r12.Nf(r0);
        if (r2 != 0) goto L_0x00b3;
    L_0x0092:
        r1 = com.tencent.mm.plugin.report.b.itm;
        r2 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r4 = 249; // 0xf9 float:3.49E-43 double:1.23E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "Error insert message getTableByTalker failed. talker:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.field_talker;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        r0 = -1;
        goto L_0x002f;
    L_0x00b3:
        r2.bxa();
        r4 = r2.cLC;
        r13.x(r4);
        r0 = "check table name from id:%d table:%s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r6 = r13.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r4 = 1;
        r3[r4] = r2;
        r0 = java.lang.String.format(r0, r3);
        r3 = r2.name;
        r4 = r13.field_msgId;
        r4 = r12.eo(r4);
        r3 = r3.equals(r4);
        junit.framework.Assert.assertTrue(r0, r3);
        r4 = r13.field_msgSvrId;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x00ee;
    L_0x00e8:
        r0 = 1;
        r13.bNs = r0;
        r0 = 1;
        r13.bKL = r0;
    L_0x00ee:
        r3 = r12.nvY;
        monitor-enter(r3);
        r0 = r12.nvY;	 Catch:{ all -> 0x0124 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0124 }
    L_0x00f7:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0124 }
        if (r0 == 0) goto L_0x0127;
    L_0x00fd:
        r0 = r4.next();	 Catch:{ all -> 0x0124 }
        r0 = (com.tencent.mm.storage.e) r0;	 Catch:{ all -> 0x0124 }
        r0 = r0.a(r13, r1);	 Catch:{ all -> 0x0124 }
        if (r0 != 0) goto L_0x00f7;
    L_0x0109:
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "Error dealMsgSource. talker:%s ,msgSouce:%s";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0124 }
        r4 = 0;
        r5 = r13.field_talker;	 Catch:{ all -> 0x0124 }
        r2[r4] = r5;	 Catch:{ all -> 0x0124 }
        r4 = 1;
        r5 = r13.bNo;	 Catch:{ all -> 0x0124 }
        r2[r4] = r5;	 Catch:{ all -> 0x0124 }
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);	 Catch:{ all -> 0x0124 }
        r0 = -1;
        monitor-exit(r3);	 Catch:{ all -> 0x0124 }
        goto L_0x002f;
    L_0x0124:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0124 }
        throw r0;
    L_0x0127:
        monitor-exit(r3);	 Catch:{ all -> 0x0124 }
        Q(r13);
        r0 = r2.name;
        r1 = "message";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0142;
    L_0x0136:
        r0 = r13.field_talker;
        r0 = r12.MG(r0);
        r0 = (int) r0;
        r13.field_talkerId = r0;
        r0 = 1;
        r13.bMY = r0;
    L_0x0142:
        r0 = r13.py();
        r1 = r12.cuX;
        r2 = r2.name;
        r3 = "msgId";
        r10 = r1.insert(r2, r3, r0);
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]";
        r2 = 12;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Long.valueOf(r10);
        r2[r3] = r4;
        r3 = 1;
        r4 = r13.field_talker;
        r2[r3] = r4;
        r3 = 2;
        r4 = r13.field_msgId;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r13.field_type;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = r13.field_status;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 5;
        r4 = r13.field_msgSvrId;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 6;
        r4 = r13.field_msgSeq;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 7;
        r4 = r13.field_flag;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 8;
        r4 = r13.field_createTime;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 9;
        r4 = r13.field_isSend;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 10;
        r4 = r12.nwl;
        r2[r3] = r4;
        r3 = 11;
        r4 = r12.nwm;
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r4);
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = -1;
        r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x01fa;
    L_0x01ce:
        r1 = com.tencent.mm.plugin.report.b.itm;
        r2 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r4 = 248; // 0xf8 float:3.48E-43 double:1.225E-321;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "insert failed svrid:%d ret:%d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.field_msgSvrId;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Long.valueOf(r10);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        r0 = -1;
        goto L_0x002f;
    L_0x01fa:
        r0 = r12.nwk;
        if (r0 == 0) goto L_0x0237;
    L_0x01fe:
        r0 = r12.nwm;
        r0 = com.tencent.mm.sdk.platformtools.be.ay(r0);
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0237;
    L_0x020a:
        r0 = r13.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0237;
    L_0x020f:
        r0 = r13.field_status;
        r1 = 1;
        if (r0 != r1) goto L_0x0237;
    L_0x0214:
        r0 = "MicroMsg.MsgInfoStorage";
        r1 = "insert this fucking tag[%s] lockForSync too long:%d force to release Now.";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.nwl;
        r2[r3] = r4;
        r3 = 1;
        r4 = r12.nwm;
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r4);
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.w(r0, r1, r2);
        r0 = r12.nwl;
        r12.MD(r0);
    L_0x0237:
        r0 = r12.nwk;
        if (r0 == 0) goto L_0x028d;
    L_0x023b:
        r0 = 0;
        r1 = nvZ;
        if (r1 == 0) goto L_0x0246;
    L_0x0240:
        r0 = nvZ;
        r0 = r0.B(r13);
    L_0x0246:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 == 0) goto L_0x02aa;
    L_0x024c:
        r0 = r13.field_talker;
        r1 = r0;
    L_0x024f:
        r0 = 0;
        r2 = r12.nwj;
        r2 = r2.containsKey(r1);
        if (r2 == 0) goto L_0x0260;
    L_0x0258:
        r0 = r12.nwj;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.storage.au.c) r0;
    L_0x0260:
        if (r0 != 0) goto L_0x0287;
    L_0x0262:
        r0 = new com.tencent.mm.storage.au$c;
        r2 = r13.field_talker;
        r3 = "insert";
        r0.<init>(r2, r3, r13);
    L_0x026c:
        r2 = com.tencent.mm.storage.au.c.U(r13);
        if (r2 == 0) goto L_0x0278;
    L_0x0272:
        r2 = r0.nwu;
        r2 = r2 + 1;
        r0.nwu = r2;
    L_0x0278:
        r2 = r0.nwv;
        r2 = r2 + 1;
        r0.nwv = r2;
        r2 = r12.nwj;
        r2.put(r1, r0);
    L_0x0283:
        r0 = r13.field_msgId;
        goto L_0x002f;
    L_0x0287:
        r2 = r0.nwt;
        r2.add(r13);
        goto L_0x026c;
    L_0x028d:
        r0 = new com.tencent.mm.storage.au$c;
        r1 = r13.field_talker;
        r2 = "insert";
        r0.<init>(r1, r2, r13);
        r1 = com.tencent.mm.storage.au.c.U(r13);
        if (r1 == 0) goto L_0x02a0;
    L_0x029d:
        r1 = 1;
        r0.nwu = r1;
    L_0x02a0:
        r1 = 1;
        r0.nwv = r1;
        r12.Ls();
        r12.a(r0);
        goto L_0x0283;
    L_0x02aa:
        r1 = r0;
        goto L_0x024f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.au.R(com.tencent.mm.storage.at):long");
    }

    public final int em(long j) {
        bx ek = ek(j);
        String str = ek.field_talker;
        this.nwh.a((int) (be.Nh() / 86400), ek.field_msgSvrId, ek.field_createTime / 1000);
        int delete = this.cuX.delete(eo(j), "msgId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            Lf("delete_id " + j);
            c cVar = new c(str, "delete", 1);
            cVar.nwx = j;
            cVar.ezh = ek.field_bizChatId;
            a(cVar);
        } else {
            com.tencent.mm.plugin.report.b.itm.a(111, 245, 1, false);
        }
        return delete;
    }

    public final List<at> ML(String str) {
        List<at> list = null;
        Cursor rawQuery = this.cuX.rawQuery("select * from " + str, null);
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            if (count == 0) {
                rawQuery.close();
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    rawQuery.moveToPosition(i);
                    at atVar = new at();
                    atVar.b(rawQuery);
                    list.add(atVar);
                }
                rawQuery.close();
            }
        }
        return list;
    }

    public final long Y(String str, long j) {
        String str2 = "select createTime from " + Lv(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery.moveToFirst()) {
            j2 = rawQuery.getLong(0);
        }
        rawQuery.close();
        return j2;
    }

    public final List<at> d(String str, long j, boolean z) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgInfoStorage", new StringBuilder("getImgMessage fail, argument is invalid, limit = 10").toString());
            return null;
        }
        long Y = Y(str, j);
        if (Y == 0) {
            v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            return null;
        }
        String str2;
        List<at> arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Lv(str) + " where" + MF(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime" + " > " + Y + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Lv(str) + " where" + MF(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime" + " < " + Y + "  order by createTime DESC limit 10";
        }
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                at atVar = new at();
                atVar.b(rawQuery);
                rawQuery.moveToNext();
                if (z) {
                    arrayList.add(atVar);
                } else {
                    arrayList.add(0, atVar);
                }
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final Cursor MM(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            return null;
        }
        String Lv = Lv(str);
        Cursor rawQuery = this.cuX.rawQuery("select * from " + Lv + " " + MZ(Lv) + " where" + MF(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime", null);
        v.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Lv);
        return rawQuery;
    }

    protected final void b(String str, String str2, String[] strArr) {
        int count;
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((be.Nh() - 172800) * 1000);
        if (!be.kS(str2)) {
            str3 = str3 + " AND " + str2;
        }
        Cursor rawQuery = this.cuX.rawQuery(str3, strArr);
        if (rawQuery != null) {
            count = rawQuery.getCount();
        } else {
            count = 0;
        }
        if (count > 0) {
            List arrayList = new ArrayList(count);
            List arrayList2 = new ArrayList(count);
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                long j = rawQuery.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(rawQuery.getInt(0)));
                arrayList2.add(Long.valueOf(j));
                rawQuery.moveToNext();
            }
            this.nwh.f(arrayList, arrayList2);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public final boolean en(long j) {
        return this.nwh.eh(j);
    }

    public final void MN(String str) {
        b(str, SQLiteDatabase.KeyEmpty, null);
        if (this.cuX.dF(str, "delete from " + str)) {
            Lf("delete_all " + str);
        } else {
            com.tencent.mm.plugin.report.b.itm.a(111, 247, 1, false);
        }
    }

    public final int Z(String str, long j) {
        bx S = S(str, j);
        this.nwh.a((int) (be.Nh() / 86400), S.field_msgSvrId, S.field_createTime / 1000);
        int delete = this.cuX.delete(Lv(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            Ls();
            a(new c(str, "delete", 1));
        } else {
            com.tencent.mm.plugin.report.b.itm.a(111, 246, 1, false);
        }
        return delete;
    }

    public final int MO(String str) {
        v.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, af.btA());
        b(Lv(str), MF(str), null);
        int delete = this.cuX.delete(Lv(str), MF(str), null);
        if (delete != 0) {
            Lf("delete_talker " + str);
            c cVar = new c(str, "delete", delete);
            cVar.nwx = -1;
            a(cVar);
        }
        return delete;
    }

    public final int aa(String str, long j) {
        String str2 = MF(str) + " and createTime <= " + j;
        b(Lv(str), str2, null);
        int delete = this.cuX.delete(Lv(str), str2, null);
        if (delete != 0) {
            Lf("delete_talker " + str);
            c cVar = new c(str, "delete", delete);
            cVar.nwx = -1;
            a(cVar);
        }
        return delete;
    }

    public final int bO(String str, int i) {
        v.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), af.btA());
        Assert.assertTrue(str.equals(S(str, (long) i).field_talker));
        b(Lv(str), "createTime<=? AND" + MF(str), new String[]{r0.field_createTime});
        int delete = this.cuX.delete(Lv(str), "createTime<=? AND" + MF(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            Ls();
            a(new c(str, "delete", delete));
        }
        return delete;
    }

    public final boolean Mg(String str) {
        v.w("MicroMsg.MsgInfoStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, af.btA());
        b(Lv(str), " talker like '%" + str + "'", null);
        boolean dF = this.cuX.dF(Lv(str), "delete from " + Lv(str) + " where talker like '%" + str + "'");
        if (dF) {
            Ls();
        }
        return dF;
    }

    public final Cursor bP(String str, int i) {
        Assert.assertTrue(str.equals(S(str, (long) i).field_talker));
        return this.cuX.query(Lv(str), null, "createTime<=? AND" + MF(str), new String[]{r5.field_createTime}, null, null, null);
    }

    public final void a(long j, at atVar) {
        if (atVar.bwh()) {
            if (m.fj(MK(atVar.bNo))) {
                v.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", MK(atVar.bNo));
                atVar.cH("notifymessage");
            }
        }
        Q(atVar);
        if (this.cuX.update(eo(j), atVar.py(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            Ls();
            a(new c(atVar.field_talker, "update", atVar));
            return;
        }
        com.tencent.mm.plugin.report.b.itm.a(111, 244, 1, false);
    }

    public final void S(at atVar) {
        if (atVar != null && atVar.field_status != 4) {
            atVar.dh(4);
            String eo = eo(atVar.field_msgId);
            if (eo != null && eo.length() > 0) {
                if (this.cuX.update(eo, atVar.py(), "msgId=?", new String[]{atVar.field_msgId}) != 0) {
                    Ls();
                    a(new c(atVar.field_talker, "update", atVar, -1));
                }
            }
        }
    }

    public final void b(long j, at atVar) {
        Assert.assertTrue("no talker set when update by svrid", be.ma(atVar.field_talker).length() > 0);
        if (atVar.bwh()) {
            if (m.fj(MK(atVar.bNo))) {
                v.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", MK(atVar.bNo));
                atVar.cH("notifymessage");
            }
        }
        Q(atVar);
        if (this.cuX.update(Lv(atVar.field_talker), atVar.py(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            Ls();
            a(new c(atVar.field_talker, "update", atVar));
            return;
        }
        com.tencent.mm.plugin.report.b.itm.a(111, 243, 1, false);
    }

    public final int MP(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        int update = this.cuX.update(Lv(str), contentValues, MF(str) + "AND isSend=? AND status" + "!=? ", new String[]{str, "0", "4"});
        if (update != 0) {
            Ls();
            a(new c(str, "update", null));
        }
        return update;
    }

    public final int T(at atVar) {
        int i = 0;
        if (atVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", atVar.field_content);
            contentValues.put("status", Integer.valueOf(atVar.field_status));
            i = this.cuX.update(eo(atVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(atVar.field_msgId)});
            if (i != 0) {
                Ls();
                a(new c(atVar.field_talker, "update", atVar));
            }
        }
        return i;
    }

    public final Cursor MQ(String str) {
        return this.cuX.query(Lv(str), null, MF(str), null, null, null, "createTime ASC ");
    }

    public final Cursor c(String str, int i, long j) {
        return this.cuX.rawQuery("SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null);
    }

    public final Cursor dM(String str, String str2) {
        return this.cuX.rawQuery(("SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null);
    }

    public final Cursor bQ(String str, int i) {
        v.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        return this.cuX.rawQuery("SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC", null);
    }

    public final Cursor d(String str, int i, long j) {
        v.i("MicroMsg.MsgInfoStorage", "summerbadcr getInitCursor2 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE " + "createTime <= " + j);
        return this.cuX.rawQuery("SELECT * FROM ( SELECT * FROM ( SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC ) WHERE " + "createTime <= " + j, null);
    }

    public final Cursor MR(String str) {
        return this.cuX.query(Lv(str), null, "isSend=? AND" + MF(str) + "AND status!=?", new String[]{"0", "4"}, null, null, null);
    }

    public final Cursor bR(String str, int i) {
        return this.cuX.query(Lv(str), null, "isSend=? AND" + MF(str) + "AND status!=?  order by " + "msgId DESC limit " + i, new String[]{"0", "4"}, null, null, null);
    }

    public final com.tencent.mm.storage.at.c MS(String str) {
        com.tencent.mm.storage.at.c cVar = (com.tencent.mm.storage.at.c) this.nwb.get(Integer.valueOf(str.hashCode()));
        if (cVar != null) {
            return cVar;
        }
        cVar = com.tencent.mm.storage.at.c.MA(str);
        this.nwb.k(Integer.valueOf(str.hashCode()), cVar);
        return cVar;
    }

    public final d MT(String str) {
        d dVar = (d) this.nwc.get(Integer.valueOf(str.hashCode()));
        if (dVar != null) {
            return dVar;
        }
        dVar = d.MB(str);
        this.nwc.k(Integer.valueOf(str.hashCode()), dVar);
        return dVar;
    }

    public final com.tencent.mm.storage.at.a MU(String str) {
        com.tencent.mm.storage.at.a aVar = null;
        if (be.kS(str) || this.nwd == null) {
            v.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(be.kS(str)));
            v.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (com.tencent.mm.storage.at.a) this.nwd.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = com.tencent.mm.storage.at.a.My(str);
            if (this.nwd != null) {
                this.nwd.k(Integer.valueOf(be.ah(str, SQLiteDatabase.KeyEmpty).hashCode()), aVar);
            }
        }
        return aVar;
    }

    public final com.tencent.mm.storage.at.b MV(String str) {
        com.tencent.mm.storage.at.b bVar = (com.tencent.mm.storage.at.b) this.nwe.get(Integer.valueOf(str.hashCode()));
        if (bVar != null) {
            return bVar;
        }
        bVar = com.tencent.mm.storage.at.b.Mz(str);
        this.nwe.k(Integer.valueOf(str.hashCode()), bVar);
        return bVar;
    }

    public final int MW(String str) {
        int i = 0;
        if (MX(str)) {
            int Mt = this.nvW.Mt(str);
            if (Mt > 0) {
                v.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(Mt));
                return Mt;
            }
            v.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            if ("appbrandmessage".equals(Lv(str))) {
                Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv(str) + " WHERE" + MF(str), null);
                if (rawQuery.moveToLast()) {
                    i = rawQuery.getInt(0);
                }
                rawQuery.close();
                return i;
            }
        }
        return MY(str);
    }

    public final boolean MX(String str) {
        return "message".equals(Lv(str));
    }

    public final int MY(String str) {
        int i;
        Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv(str) + " " + (this.nvV ? "INDEXED BY messageTalkerIdStatusIndex" : "INDEXED BY messageTalkerStatusIndex") + " WHERE" + MF(str), null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        } else {
            i = 0;
        }
        rawQuery.close();
        return i;
    }

    protected final String MZ(String str) {
        if (str == null || !str.equals("message")) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (this.nvV) {
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        }
        return "INDEXED BY messageCreateTaklerTypeTimeIndex";
    }

    public final int bS(String str, int i) {
        int i2 = 0;
        Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv(str) + " WHERE" + MF(str) + "AND type = " + i, null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i2;
    }

    protected final String Na(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = Nf(str).name;
        return str3 + "  indexed by  " + str3 + "TalkerTypeIndex ";
    }

    public final int Nb(String str) {
        int i = 0;
        Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv(str) + " WHERE" + MF(str) + "AND type IN (3,39,13,43,62,44,49,268435505)", null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final int ab(String str, long j) {
        int i = 0;
        bx ek = ek(j);
        if (ek.field_msgId == 0) {
            v.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv(str) + " WHERE" + MF(str) + "AND type = 49 AND createTime" + " < " + ek.field_createTime, null);
            if (rawQuery.moveToLast()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final int Nc(String str) {
        int i = 0;
        Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Na(str) + " WHERE talker= '" + be.lZ(str) + "' AND type IN (3,39,13,43,62,44,268435505)", null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public final int ac(String str, long j) {
        int i = 0;
        bx ek = ek(j);
        if (ek.field_msgId == 0) {
            v.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String Lv = Lv(str);
            Cursor rawQuery = this.cuX.rawQuery("SELECT COUNT(*) FROM " + Lv + " " + MZ(Lv) + " WHERE " + MF(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime" + " < " + ek.field_createTime, null);
            if (rawQuery.moveToLast()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final String ad(String str, long j) {
        String str2 = null;
        bx ek = ek(j);
        if (ek.field_msgId == 0) {
            v.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
        } else {
            String Lv = Lv(str);
            Cursor rawQuery = this.cuX.rawQuery("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + Lv + " " + MZ(Lv) + " WHERE" + MF(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime" + " < " + ek.field_createTime, null);
            str2 = SQLiteDatabase.KeyEmpty;
            if (rawQuery.moveToFirst()) {
                for (int i = 0; i < rawQuery.getColumnCount(); i++) {
                    str2 = str2 + rawQuery.getString(i) + " ";
                }
            }
            rawQuery.close();
        }
        return str2;
    }

    protected static String bwY() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    protected static String bwZ() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    protected final String Lv(String str) {
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        return Nf(str).name;
    }

    public final String Ne(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        synchronized (this.nvY) {
            for (e Lu : this.nvY) {
                String Lu2 = Lu.Lu(str);
                if (!be.kS(Lu2)) {
                    return Lu2;
                }
            }
            return "message";
        }
    }

    private b Nf(String str) {
        boolean z;
        boolean z2 = true;
        String str2 = "username == null";
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(str2, z);
        str2 = Ne(str);
        String str3 = "tableName == null";
        if (str2 == null || str2.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str3, z2);
        for (int i = 0; i < this.nwa.size(); i++) {
            if (str2.equals(((b) this.nwa.get(i)).name)) {
                return (b) this.nwa.get(i);
            }
        }
        Assert.assertTrue("no table match", false);
        return null;
    }

    private String eo(long j) {
        if (j == 0 || j == -1) {
            return null;
        }
        at.ej(j);
        for (int i = 0; i < this.nwa.size(); i++) {
            if (((b) this.nwa.get(i)).eq(j)) {
                return ((b) this.nwa.get(i)).name;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        return null;
    }

    public final long Ng(String str) {
        String str2 = "select createTime from message where" + MF(str) + "order by createTime LIMIT 1 OFFSET 0";
        v.d("MicroMsg.MsgInfoStorage", "get first message create time: " + str2);
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery == null) {
            v.e("MicroMsg.MsgInfoStorage", "get first message create time failed: " + str);
            return -1;
        } else if (rawQuery.moveToFirst()) {
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        } else {
            rawQuery.close();
            return -1;
        }
    }

    public final long Nh(String str) {
        String str2 = "select createTime from message where" + MF(str) + "order by createTime DESC LIMIT 1 ";
        v.d("MicroMsg.MsgInfoStorage", "get last message create time: " + str2);
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery == null) {
            v.e("MicroMsg.MsgInfoStorage", "get last message create time failed " + str);
            return -1;
        } else if (rawQuery.moveToFirst()) {
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        } else {
            rawQuery.close();
            return -1;
        }
    }

    public final long Ni(String str) {
        if (be.kS(str)) {
            return 0;
        }
        String str2 = "select msgSeq from message where" + MF(str) + "order by msgSeq DESC LIMIT 1 ";
        v.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: " + str2);
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery == null) {
            v.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed " + str);
            return 0;
        } else if (rawQuery.moveToFirst()) {
            long j = rawQuery.getLong(0);
            rawQuery.close();
            return j;
        } else {
            rawQuery.close();
            return 0;
        }
    }

    public final at Nj(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.valueOf(false));
        Long l = (Long) this.nwg.get(str);
        at atVar;
        if (l == null || l.longValue() <= 0) {
            v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            atVar = new at();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor rawQuery = this.cuX.rawQuery("SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND flag %2 = 1  ORDER BY " + "msgSeq DESC LIMIT 1 ", null);
            v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (rawQuery == null) {
                v.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed " + str);
                return atVar;
            }
            if (rawQuery.moveToFirst()) {
                atVar.b(rawQuery);
            }
            rawQuery.close();
            this.nwg.k(str, Long.valueOf(atVar.field_msgId));
            return atVar;
        }
        v.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        atVar = ek(l.longValue());
        if ((atVar.field_flag & 1) != 0) {
            return atVar;
        }
        this.nwg.remove(str);
        return null;
    }

    public final int j(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        v.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j2), Long.valueOf(j));
        String str2 = "SELECT COUNT(msgId) FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        v.d("MicroMsg.MsgInfoStorage", "get count sql: " + str2);
        Cursor rawQuery = this.cuX.rawQuery(str2, null);
        if (rawQuery == null) {
            v.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            return 0;
        } else if (rawQuery.moveToFirst()) {
            v.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(rawQuery.getInt(0)));
            rawQuery.close();
            return rawQuery.getInt(0);
        } else {
            rawQuery.close();
            return 0;
        }
    }

    public final Cursor k(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime >= " + j2 + " AND createTime <= " + j + " ORDER BY createTime ASC ";
        v.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.cuX.rawQuery(str2, null);
    }

    public final Cursor l(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime > " + j2 + " AND createTime < " + j + " ORDER BY createTime ASC ";
        v.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.cuX.rawQuery(str2, null);
    }

    public final Cursor ae(String str, long j) {
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime > " + j + " ORDER BY createTime ASC ";
        v.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.cuX.rawQuery(str2, null);
    }

    public final Cursor m(String str, long j, long j2) {
        if (j2 >= j) {
            long j3 = j2;
            j2 = j;
            j = j3;
        }
        String str2 = "SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime >= " + j2 + " AND createTime <= " + j;
        v.d("MicroMsg.MsgInfoStorage", "get cursor: " + str2);
        return this.cuX.rawQuery(str2, null);
    }

    public final Cursor z(String str, String str2, int i) {
        v.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        return this.cuX.rawQuery(" SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i, null);
    }

    public final Cursor bT(String str, int i) {
        v.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i);
        return this.cuX.rawQuery(" SELECT * FROM " + Lv(str) + " WHERE" + MF(str) + "AND isSend=1" + " ORDER BY createTime DESC LIMIT " + i, null);
    }

    public final long af(String str, long j) {
        v.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        v.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT " + 18);
        Cursor rawQuery = this.cuX.rawQuery(r0, null);
        if (rawQuery == null) {
            v.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            return j;
        } else if (rawQuery.moveToLast()) {
            v.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(rawQuery.getLong(0)));
            rawQuery.close();
            return rawQuery.getLong(0);
        } else {
            rawQuery.close();
            v.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final long ag(String str, long j) {
        v.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(18));
        v.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + Lv(str) + " WHERE" + MF(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT " + 18);
        Cursor rawQuery = this.cuX.rawQuery(r0, null);
        if (rawQuery == null) {
            v.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            return j;
        } else if (rawQuery.moveToLast()) {
            v.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(rawQuery.getLong(0)));
            rawQuery.close();
            return rawQuery.getLong(0);
        } else {
            rawQuery.close();
            v.w("MicroMsg.MsgInfoStorage", "get result fail");
            return j;
        }
    }

    public final at[] bU(String str, int i) {
        at[] atVarArr = null;
        if (str == null || str.length() == 0 || i <= 0) {
            v.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
        } else {
            Cursor rawQuery = this.cuX.rawQuery("select * from " + Lv(str) + " where" + MF(str) + "order by createTime DESC limit " + i, null);
            int count = rawQuery.getCount();
            v.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + count);
            if (count == 0) {
                v.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
                rawQuery.close();
            } else {
                atVarArr = new at[count];
                for (int i2 = 0; i2 < count; i2++) {
                    rawQuery.moveToPosition(i2);
                    atVarArr[(count - i2) - 1] = new at();
                    atVarArr[(count - i2) - 1].b(rawQuery);
                }
                rawQuery.close();
            }
        }
        return atVarArr;
    }

    public final LinkedList<at> dO(String str, String str2) {
        LinkedList<at> linkedList = null;
        Cursor query = this.cuX.query("message", null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null);
        if (query == null || query.getCount() <= 0) {
            v.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        } else {
            linkedList = new LinkedList();
            while (query.moveToNext()) {
                at atVar = new at();
                atVar.b(query);
                linkedList.add(atVar);
            }
            query.close();
        }
        return linkedList;
    }

    public final void ep(long j) {
        this.nwh.a(0, j, 0, false);
    }
}
