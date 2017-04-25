package com.tencent.mm.plugin.search.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.e.a.ps;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.AssertionFailedError;

public final class c extends com.tencent.mm.modelsearch.a {
    com.tencent.mm.modelsearch.r cWq;
    private com.tencent.mm.sdk.h.j.b iEA = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            if (c.aMd()) {
                obj = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                switch (i) {
                    case 2:
                        if (!be.kS(obj)) {
                            this.iEI.cWq.a(65556, new l(this.iEI, obj, 1));
                            return;
                        }
                        return;
                    case 3:
                        if (!be.kS(obj)) {
                            this.iEI.cWq.a(65556, new v(this.iEI, obj));
                            return;
                        }
                        return;
                    case 5:
                        if (be.kS(obj)) {
                            this.iEI.cWq.a(65556, new e(this.iEI, 1));
                            return;
                        } else {
                            this.iEI.cWq.a(65556, new g(this.iEI, obj, 1));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private com.tencent.mm.sdk.h.j.b iEB = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        }
    };
    private com.tencent.mm.sdk.h.g.a iEC = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
            if (!str.equals("*") && !str.equals("chatroomname")) {
                this.iEI.cWq.a(65555, new t(this.iEI, str));
            }
        }
    };
    private com.tencent.mm.sdk.h.g.a iED = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
            String[] split = str.split(" ");
            if (split != null && split.length != 0 && split[0].equals("update")) {
                for (int i = 1; i < split.length; i++) {
                    this.iEI.cWq.a(65554, new w(this.iEI, be.getLong(split[i], 0)));
                }
                this.iEI.cWq.a(65556, new u());
            }
        }
    };
    private com.tencent.mm.sdk.c.c iEE = new com.tencent.mm.sdk.c.c<pw>(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r2;
            this.nhz = pw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            pw pwVar = (pw) bVar;
            if (pwVar.brg.brh <= 0) {
                this.iEI.cWq.a(131093, new u());
            } else if (this.iEI.iEH.btC()) {
                this.iEI.iEH.ea(pwVar.brg.brh);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "* Update contact at once triggered.");
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iEF = new com.tencent.mm.sdk.c.c<ps>(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r2;
            this.nhz = ps.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.iEI.cWq.a(65556, new n(this.iEI, com.tencent.mm.modelsearch.d.cVo));
            this.iEI.cWq.a(131093, new u());
            return false;
        }
    };
    private ah iEG = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c iEI;
        private int iEJ = 0;

        {
            this.iEI = r2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean oU() {
            /*
            r6 = this;
            r2 = 1;
            r1 = 0;
            r0 = com.tencent.mm.plugin.search.a.i.aMj();
            r0 = r0.iGl;
            if (r0 != 0) goto L_0x0012;
        L_0x000a:
            r0 = com.tencent.mm.plugin.search.a.i.aMj();
            r0 = r0.iGm;
            if (r0 != 0) goto L_0x001f;
        L_0x0012:
            r0 = r2;
        L_0x0013:
            if (r0 != 0) goto L_0x0021;
        L_0x0015:
            r0 = r6.iEJ;
            r0 = r0 + 1;
            r6.iEJ = r0;
            r3 = 6;
            if (r0 >= r3) goto L_0x0021;
        L_0x001e:
            return r2;
        L_0x001f:
            r0 = r1;
            goto L_0x0013;
        L_0x0021:
            r0 = r6.iEI;
            r0 = r0.cWq;
            r3 = 131093; // 0x20015 float:1.837E-40 double:6.47685E-319;
            r4 = new com.tencent.mm.plugin.search.a.c$u;
            r5 = r6.iEI;
            r4.<init>();
            r0.a(r3, r4);
            r6.iEJ = r1;
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.a.c.2.oU():boolean");
        }

        public final String toString() {
            return super.toString() + "|mDelayIndexTimer";
        }
    }, true);
    ah iEH = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final boolean oU() {
            this.iEI.cWq.a(131093, new u());
            return false;
        }

        public final String toString() {
            return super.toString() + "|mAtOnceIndexTimer";
        }
    }, false);
    com.tencent.mm.plugin.search.a.b.a iEr;
    com.tencent.mm.bg.g iEs;
    HashMap<String, List<Long>> iEt;
    HashMap<String, String[]> iEu;
    HashMap<String, List<Long>> iEv;
    private Method iEw;
    private com.tencent.mm.sdk.h.j.b iEx = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            String str = (String) obj;
            if (str != null && !str.endsWith("@stranger") && !com.tencent.mm.model.m.eD(str)) {
                switch (i) {
                    case 2:
                    case 5:
                        this.iEI.cWq.a(65556, new o(this.iEI, str));
                        return;
                    case 3:
                        if (com.tencent.mm.model.m.dE(str)) {
                            this.iEI.cWq.a(65556, new o(this.iEI, str));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private com.tencent.mm.sdk.h.j.b iEy = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            String str = (String) obj;
            if (str != null && !str.endsWith("@stranger")) {
                switch (i) {
                    case 2:
                        this.iEI.cWq.a(65556, new k(this.iEI, str));
                        return;
                    case 3:
                    case 4:
                        this.iEI.cWq.a(65556, new o(this.iEI, str));
                        return;
                    case 5:
                        this.iEI.cWq.a(65556, new f(this.iEI, str));
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private com.tencent.mm.sdk.h.j.b iEz = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ c iEI;

        {
            this.iEI = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            if (c.aMc()) {
                obj = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                switch (i) {
                    case 2:
                        if (obj != null) {
                            this.iEI.cWq.a(65556, new l(this.iEI, obj, 0));
                            return;
                        }
                        return;
                    case 5:
                        if (obj == null) {
                            this.iEI.cWq.a(65556, new e(this.iEI, 0));
                            return;
                        } else {
                            this.iEI.cWq.a(65556, new g(this.iEI, obj, 0));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };

    private static class a {
        String aGX;
        String bhT;
        String cGS;
        String iEK;
        String iEL;
        String iEM;
        String iEN;
        long id;
        int status;
        int type;
        String userName;

        a() {
        }

        a(com.tencent.mm.modelfriend.b bVar) {
            this.id = (long) com.tencent.mm.modelfriend.b.iy(bVar.EB());
            this.cGS = bVar.ED();
            this.iEK = bVar.EF();
            this.iEL = bVar.EE();
            this.aGX = bVar.EG();
            this.iEM = bVar.EI();
            this.iEN = bVar.EH();
            this.userName = bVar.getUsername();
            this.bhT = bVar.EJ();
            this.type = bVar.type;
            this.status = bVar.status;
        }
    }

    private class b extends com.tencent.mm.modelsearch.r.a {
        private int fKA;
        private int fKB;
        final /* synthetic */ c iEI;

        private b(c cVar) {
            this.iEI = cVar;
            this.fKA = 0;
            this.fKB = 0;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = this.iEI.iEr.cUY.rawQuery("SELECT DISTINCT chatroom FROM ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor rawQuery2 = this.iEI.iEs.rawQuery("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i = 5;
            while (rawQuery2.moveToNext()) {
                if (Thread.interrupted()) {
                    rawQuery2.close();
                    this.iEI.iEr.commit();
                    throw new InterruptedException();
                }
                String string = rawQuery2.getString(0);
                Object split = com.tencent.mm.modelsearch.d.cVB.split(rawQuery2.getString(1));
                this.iEI.iEu.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i >= 5) {
                        this.iEI.iEr.commit();
                        this.iEI.iEr.beginTransaction();
                        i = 0;
                    }
                    this.iEI.iEr.d(string, split);
                    i++;
                    this.fKA++;
                }
            }
            rawQuery2.close();
            this.iEI.iEr.commit();
            Iterator it = hashSet.iterator();
            int i2 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i2 >= 5) {
                    this.iEI.iEr.commit();
                    this.iEI.iEr.beginTransaction();
                    i2 = 0;
                }
                this.iEI.iEr.zh(str);
                i = i2 + 1;
                this.fKB++;
                i2 = i;
            }
            this.iEI.iEr.commit();
            return true;
        }

        public final String toString() {
            return "BuildChatroomIndex [new: " + this.fKA + ", removed: " + this.fKB + "]";
        }

        public final int getId() {
            return 3;
        }
    }

    private class c extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private HashSet<String> iEO;
        private long iEP;
        private int iEQ;
        private int iER;
        private int iES;
        private int mFailedCount;

        private c(c cVar) {
            this.iEI = cVar;
            this.iEO = null;
            this.iEP = -1;
            this.iEQ = 0;
            this.iER = 0;
            this.iES = 0;
            this.mFailedCount = 0;
        }

        public final boolean execute() {
            int i;
            long j;
            Throwable e;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Start building contact index.");
            if (this.iEO == null) {
                this.iEO = new HashSet();
                Cursor a = this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, true, false, true, false, true);
                while (a.moveToNext()) {
                    String string = a.getString(1);
                    this.iEO.add(string);
                    i = a.getInt(2);
                    j = a.getLong(0);
                    if (i == 1) {
                        List list = (List) this.iEI.iEt.get(string);
                        if (list == null) {
                            list = new ArrayList(16);
                            this.iEI.iEt.put(string, list);
                        }
                        list.add(Long.valueOf(j));
                    }
                }
                a.close();
                this.iES = this.iEI.iEt.size();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i2;
            Cursor rawQuery = this.iEI.iEs.rawQuery("SELECT ROWID, username, alias, conRemark, conRemarkPYFull, conRemarkPYShort, nickname, quanPin, pyInitial, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.iEP)});
            i = 50;
            while (rawQuery.moveToNext()) {
                if (Thread.interrupted()) {
                    rawQuery.close();
                    this.iEI.iEr.commit();
                    throw new InterruptedException();
                }
                j = rawQuery.getLong(0);
                this.iEP = j;
                com.tencent.mm.storage.u uVar = new com.tencent.mm.storage.u();
                uVar.chr = j;
                uVar.setUsername(rawQuery.getString(1));
                uVar.bP(rawQuery.getString(2));
                uVar.bQ(rawQuery.getString(3));
                uVar.bW(rawQuery.getString(4));
                uVar.bX(rawQuery.getString(5));
                uVar.bS(rawQuery.getString(6));
                uVar.bU(rawQuery.getString(7));
                uVar.bT(rawQuery.getString(8));
                uVar.cR(rawQuery.getInt(9));
                uVar.setType(rawQuery.getInt(10));
                uVar.u(rawQuery.getBlob(11));
                uVar.bZ(rawQuery.getString(12));
                uVar.cT(0);
                if (c.E(uVar) && !this.iEO.remove(uVar.field_username)) {
                    if (i >= 50) {
                        this.iEI.iEr.commit();
                        this.iEI.iEr.beginTransaction();
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    try {
                        if (!uVar.field_username.endsWith("@chatroom") && (uVar.field_verifyFlag & com.tencent.mm.storage.u.bvo()) == 0) {
                            this.iEI.D(uVar);
                            uVar.bvr();
                        }
                        i = this.iEI.F(uVar) + i2;
                        try {
                            this.iEQ++;
                        } catch (Exception e2) {
                            e = e2;
                            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                            this.mFailedCount++;
                        }
                    } catch (Throwable e3) {
                        Throwable th = e3;
                        i = i2;
                        e = th;
                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                        this.mFailedCount++;
                    }
                }
            }
            rawQuery.close();
            this.iEI.iEr.commit();
            Iterator it = this.iEO.iterator();
            i = 50;
            while (it.hasNext()) {
                if (i >= 50) {
                    this.iEI.iEr.commit();
                    this.iEI.iEr.beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i;
                }
                String str = (String) it.next();
                this.iEI.iEr.b(com.tencent.mm.modelsearch.d.cVn, str);
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, str);
                i = i2 + 1;
                this.iER++;
                it.remove();
            }
            this.iEI.iEr.commit();
            return true;
        }

        public final String toString() {
            return "BuildContactIndex [new: " + this.iEQ + ", removed: " + this.iER + ", dirty: " + this.iES + ", failed: " + this.mFailedCount + "]";
        }

        public final int getId() {
            return 1;
        }
    }

    private class d extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private long iEP;
        public boolean iET;
        public boolean iEU;
        public boolean iEV;
        private HashSet<Long> iEW;
        private int iEX;
        private HashMap<int[], j> iEY;

        private d(c cVar) {
            this.iEI = cVar;
            this.iET = false;
            this.iEU = false;
            this.iEV = false;
            this.iEW = null;
            this.iEP = Long.MIN_VALUE;
            this.iEX = -1;
            this.iEY = new HashMap();
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Start building friend index.");
            this.iET = c.aMc();
            this.iEU = c.aMd();
            this.iEV = false;
            if (this.iEX < 0) {
                this.iEX = 0;
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FTS.SearchContactLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mBuildQQIndex : %s, mBuildGoogleIndex : %s, mCurrentTask : %d]", new Object[]{Boolean.valueOf(this.iET), Boolean.valueOf(this.iEU), Boolean.valueOf(this.iEV), Integer.valueOf(this.iEX)});
            if (this.iEX == 0) {
                if (this.iET) {
                    if (!this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVp)) {
                        this.iEY.put(com.tencent.mm.modelsearch.d.cVp, new j());
                    }
                    if (this.iEW == null) {
                        this.iEW = new HashSet();
                        Cursor a = this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVp, false, true, false, false, false);
                        while (a.moveToNext()) {
                            this.iEW.add(Long.valueOf(a.getLong(0)));
                        }
                        a.close();
                    }
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    int i;
                    j jVar;
                    Cursor rawQuery = this.iEI.iEs.rawQuery("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.iEP)});
                    int i2 = 50;
                    while (rawQuery.moveToNext()) {
                        if (Thread.interrupted()) {
                            rawQuery.close();
                            this.iEI.iEr.commit();
                            throw new InterruptedException();
                        }
                        long j = rawQuery.getLong(0);
                        this.iEP = j;
                        a aVar = new a();
                        aVar.id = j;
                        aVar.cGS = rawQuery.getString(1);
                        aVar.iEK = rawQuery.getString(2);
                        aVar.iEL = rawQuery.getString(3);
                        aVar.aGX = rawQuery.getString(4);
                        aVar.iEM = rawQuery.getString(5);
                        aVar.iEN = rawQuery.getString(6);
                        aVar.userName = rawQuery.getString(7);
                        aVar.status = rawQuery.getInt(8);
                        aVar.bhT = rawQuery.getString(9);
                        aVar.type = 0;
                        if (aVar.status == 65536) {
                            aVar.status = 0;
                        }
                        if (c.a(aVar) && !this.iEW.remove(Long.valueOf(aVar.id))) {
                            if (i2 >= 50) {
                                this.iEI.iEr.commit();
                                this.iEI.iEr.beginTransaction();
                                i = 0;
                            } else {
                                i = i2;
                            }
                            try {
                                i += c.a(this.iEI, aVar);
                                jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp);
                                jVar.iEQ++;
                                i2 = i;
                            } catch (Throwable e) {
                                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                                jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp);
                                jVar.mFailedCount++;
                                i2 = i;
                            }
                        }
                    }
                    rawQuery.close();
                    this.iEI.iEr.commit();
                    Iterator it = this.iEW.iterator();
                    i2 = 50;
                    while (it.hasNext()) {
                        if (i2 >= 50) {
                            this.iEI.iEr.commit();
                            this.iEI.iEr.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVp, ((Long) it.next()).longValue());
                        i++;
                        jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp);
                        jVar.iER++;
                        it.remove();
                        i2 = i;
                    }
                    this.iEI.iEr.commit();
                    reset();
                }
                this.iEX = 1;
            }
            if (this.iEX == 1) {
                if (this.iEU) {
                    aMe();
                    reset();
                }
                this.iEX = 2;
            }
            if (this.iEX == 2) {
                if (this.iEV) {
                    aMf();
                    reset();
                }
                this.iEX = -1;
            }
            return true;
        }

        private void reset() {
            this.iEW = null;
            this.iEP = Long.MIN_VALUE;
        }

        private void aMe() {
            if (!this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVq)) {
                this.iEY.put(com.tencent.mm.modelsearch.d.cVq, new j());
            }
            if (this.iEW == null) {
                this.iEW = new HashSet();
                Cursor a = this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVq, false, true, false, false, false);
                while (a.moveToNext()) {
                    this.iEW.add(Long.valueOf(a.getLong(0)));
                }
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Cursor rawQuery = this.iEI.iEs.rawQuery("SELECT qq, username, qqnickname, qqpyinitial, qqquanpin, qqremark, qqremarkpyinitial, qqremarkquanpin, wexinstatus FROM qqlist WHERE qq > ? ORDER BY qq;", new String[]{Long.toString(this.iEP)});
            int i = 50;
            while (rawQuery.moveToNext()) {
                if (Thread.interrupted()) {
                    rawQuery.close();
                    this.iEI.iEr.commit();
                    throw new InterruptedException();
                }
                int i2;
                j jVar;
                long j = rawQuery.getLong(0);
                this.iEP = j;
                p pVar = new p();
                pVar.cIA = j;
                pVar.username = rawQuery.getString(1);
                pVar.iFn = rawQuery.getString(2);
                pVar.iFo = rawQuery.getString(3);
                pVar.iFp = rawQuery.getString(4);
                pVar.iFk = rawQuery.getString(5);
                pVar.iFl = rawQuery.getString(6);
                pVar.iFm = rawQuery.getString(7);
                pVar.iFq = rawQuery.getInt(8);
                if (pVar.iFq == 65536) {
                    pVar.iFq = 0;
                }
                if (c.a(pVar) && !this.iEW.remove(Long.valueOf(pVar.cIA))) {
                    if (i >= 50) {
                        this.iEI.iEr.commit();
                        this.iEI.iEr.beginTransaction();
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    try {
                        i2 += c.a(this.iEI, pVar);
                        jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq);
                        jVar.iEQ++;
                        i = i2;
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Build qq friend index failed with exception.", new Object[0]);
                        jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq);
                        jVar.mFailedCount++;
                        i = i2;
                    }
                }
            }
            rawQuery.close();
            this.iEI.iEr.commit();
            Iterator it = this.iEW.iterator();
            i = 50;
            while (it.hasNext()) {
                if (i >= 50) {
                    this.iEI.iEr.commit();
                    this.iEI.iEr.beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i;
                }
                long longValue = ((Long) it.next()).longValue();
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVq, longValue);
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVq, Long.valueOf(longValue));
                i2++;
                jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq);
                jVar.iER++;
                it.remove();
                i = i2;
            }
            this.iEI.iEr.commit();
        }

        private void aMf() {
            if (!this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVr)) {
                this.iEY.put(com.tencent.mm.modelsearch.d.cVr, new j());
            }
            if (this.iEW == null) {
                this.iEW = new HashSet();
                Cursor a = this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVr, false, true, false, false, false);
                while (a.moveToNext()) {
                    this.iEW.add(Long.valueOf(a.getLong(0)));
                }
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Cursor rawQuery = this.iEI.iEs.rawQuery("SELECT rowid, googlegmail, username, googlename, googlenamepy, status FROM GoogleFriend ORDER BY googleitemid;", new String[0]);
            int i = 50;
            while (rawQuery.moveToNext()) {
                if (Thread.interrupted()) {
                    rawQuery.close();
                    this.iEI.iEr.commit();
                    throw new InterruptedException();
                }
                int i2;
                j jVar;
                h hVar = new h();
                hVar.iFb = rawQuery.getLong(0);
                hVar.iFc = rawQuery.getString(1);
                hVar.username = rawQuery.getString(2);
                hVar.iFd = rawQuery.getString(3);
                hVar.iFe = rawQuery.getString(4);
                hVar.status = rawQuery.getInt(5);
                if (hVar.status == 1) {
                    hVar.status = 0;
                } else if (hVar.status == 0) {
                    hVar.status = 1;
                } else if (hVar.status == 2) {
                    hVar.status = 2;
                }
                if (TextUtils.isEmpty(hVar.iFd)) {
                    hVar.iFd = be.KU(hVar.iFc);
                }
                if (c.a(hVar) && !this.iEW.remove(Long.valueOf(hVar.iFb))) {
                    if (i >= 50) {
                        this.iEI.iEr.commit();
                        this.iEI.iEr.beginTransaction();
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    try {
                        i2 += c.a(this.iEI, hVar);
                        jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr);
                        jVar.iEQ++;
                        i = i2;
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Build google friend index failed with exception.", new Object[0]);
                        jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr);
                        jVar.mFailedCount++;
                        i = i2;
                    }
                }
            }
            rawQuery.close();
            this.iEI.iEr.commit();
            Iterator it = this.iEW.iterator();
            i = 50;
            while (it.hasNext()) {
                if (i >= 50) {
                    this.iEI.iEr.commit();
                    this.iEI.iEr.beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i;
                }
                long longValue = ((Long) it.next()).longValue();
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVr, longValue);
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVr, Long.valueOf(longValue));
                i2++;
                jVar = (j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr);
                jVar.iER++;
                it.remove();
                i = i2;
            }
            this.iEI.iEr.commit();
        }

        public final String toString() {
            return (this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVp) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp)).iEQ + ", removed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp)).iER + ", failed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVp)).mFailedCount + "]\n" : "") + (this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVq) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_QQ_FRIEND [new: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq)).iEQ + ", removed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq)).iER + ", failed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVq)).mFailedCount + "]\n" : "") + (this.iEY.containsKey(com.tencent.mm.modelsearch.d.cVr) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_GOOGLE_FRIEND [new: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr)).iEQ + ", removed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr)).iER + ", failed: " + ((j) this.iEY.get(com.tencent.mm.modelsearch.d.cVr)).mFailedCount + "]" : "");
        }

        public final int getId() {
            return 2;
        }
    }

    private class e extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int iEZ;
        private int mCount = 0;

        public e(c cVar, int i) {
            this.iEI = cVar;
            this.iEZ = i;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FTS.SearchContactLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[]{Integer.valueOf(this.iEZ)});
            if (this.iEZ == 0) {
                this.mCount = this.iEI.iEr.c(com.tencent.mm.modelsearch.d.cVp, -1).size();
            } else if (this.iEZ == 1) {
                this.mCount = this.iEI.iEr.c(com.tencent.mm.modelsearch.d.cVq, -1).size();
            } else if (this.iEZ == 2) {
                this.mCount = this.iEI.iEr.c(com.tencent.mm.modelsearch.d.cVr, -1).size();
            }
            return true;
        }

        public final String toString() {
            return "DeleteAllFriends [" + this.mCount + ", " + this.iEZ + "]";
        }
    }

    private class f extends com.tencent.mm.modelsearch.r.a {
        private String bZy;
        final /* synthetic */ c iEI;
        private int iES = 0;

        public f(c cVar, String str) {
            this.iEI = cVar;
            this.bZy = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Delete Contact %s", new Object[]{this.bZy});
            this.iEI.iEr.b(com.tencent.mm.modelsearch.d.cVn, this.bZy);
            Cursor zg = this.iEI.iEr.zg(this.bZy);
            while (zg.moveToNext()) {
                String string = zg.getString(0);
                if (!this.iEI.iEt.containsKey(string)) {
                    this.iEI.iEt.put(string, this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, string, 1));
                    this.iES++;
                }
            }
            zg.close();
            return true;
        }

        public final String toString() {
            return "DeleteContact(\"" + this.bZy + "\")" + (this.iES > 0 ? " [dirty: " + this.iES + "]" : "");
        }
    }

    private class g extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int iEZ;
        private String iFa;

        public g(c cVar, String str, int i) {
            this.iEI = cVar;
            this.iFa = str;
            this.iEZ = i;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FTS.SearchContactLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.iFa, Integer.valueOf(this.iEZ)});
            if (this.iEZ == 0) {
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVp, (long) com.tencent.mm.modelfriend.b.iy(this.iFa));
            } else if (this.iEZ == 1) {
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVq, be.KM(this.iFa));
            } else if (this.iEZ == 2) {
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVr, be.KM(this.iFa));
            }
            return true;
        }

        public final String toString() {
            return "DeleteFriend(\"" + this.iFa + "\", " + this.iEZ + ")";
        }
    }

    private static class h {
        long iFb;
        String iFc;
        String iFd;
        String iFe;
        int status;
        String username;

        h() {
        }

        h(com.tencent.mm.modelfriend.o oVar) {
            this.iFb = oVar.nmb;
            this.iFc = oVar.field_googlegmail;
            this.username = oVar.field_username;
            this.iFd = oVar.field_googlename;
            this.iFe = oVar.field_googlenamepy;
            this.status = oVar.field_status;
        }
    }

    private class i extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;

        private i(c cVar) {
            this.iEI = cVar;
        }

        public final boolean execute() {
            long Ie = this.iEI.iEr.Ie();
            long h = this.iEI.iEr.h(new int[]{131075});
            long h2 = this.iEI.iEr.h(new int[]{131072});
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "total %d chatroom %d contact %d", new Object[]{Long.valueOf(Ie), Long.valueOf(h), Long.valueOf(h2)});
            return true;
        }
    }

    private static class j {
        public int iEQ;
        public int iER;
        public int mFailedCount;

        private j() {
            this.iEQ = 0;
            this.iER = 0;
            this.mFailedCount = 0;
        }
    }

    private class k extends com.tencent.mm.modelsearch.r.a {
        private String bZy;
        final /* synthetic */ c iEI;
        private boolean iFf = false;

        public k(c cVar, String str) {
            this.iEI = cVar;
            this.bZy = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Insert Contact %s", new Object[]{this.bZy});
            ak.yW();
            com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(this.bZy);
            if (LX == null || LX.field_username.length() <= 0 || !c.E(LX)) {
                this.iFf = true;
            } else {
                this.iEI.F(LX);
            }
            this.iEI.iEt.remove(this.bZy);
            return true;
        }

        public final String toString() {
            return "InsertContact(\"" + this.bZy + "\")" + (this.iFf ? " [skipped]" : "");
        }
    }

    private class l extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int iEZ;
        private String iFa;
        private boolean iFf = false;

        public l(c cVar, String str, int i) {
            this.iEI = cVar;
            this.iFa = str;
            this.iEZ = i;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FTS.SearchContactLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.iFa, Integer.valueOf(this.iEZ)});
            if (this.iEZ == 0) {
                com.tencent.mm.modelfriend.b iB = com.tencent.mm.modelfriend.ah.FL().iB(this.iFa);
                if (iB == null) {
                    this.iFf = true;
                } else {
                    a aVar = new a(iB);
                    if (c.a(aVar)) {
                        c.a(this.iEI, aVar);
                    } else {
                        this.iFf = true;
                    }
                }
            } else if (this.iEZ == 1) {
                af ae = com.tencent.mm.modelfriend.ah.FQ().ae(be.KM(this.iFa));
                if (ae == null) {
                    this.iFf = true;
                } else {
                    p pVar = new p(ae);
                    if (c.a(pVar)) {
                        c.a(this.iEI, pVar);
                    } else {
                        this.iFf = true;
                    }
                }
            }
            return true;
        }

        public final String toString() {
            return "InsertFriend(\"" + this.iFa + "\", " + this.iEZ + ")" + (this.iFf ? " [skipped]" : "");
        }
    }

    private class m extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int iFg;
        private int iFh;

        private m(c cVar) {
            this.iEI = cVar;
            this.iFg = 0;
            this.iFh = 0;
        }

        public final boolean execute() {
            Cursor rawQuery = this.iEI.iEr.cUY.rawQuery("SELECT user, label_id FROM ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j = rawQuery.getLong(1);
                List list = (List) this.iEI.iEv.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    this.iEI.iEv.put(string, list);
                    this.iFg++;
                }
                list.add(Long.valueOf(j));
                this.iFh++;
            }
            rawQuery.close();
            return true;
        }

        public final String toString() {
            return "LoadLabelCache [users: " + this.iFg + ", labels: " + this.iFh + "]";
        }
    }

    private class n extends com.tencent.mm.modelsearch.r.a {
        private int fmf = 0;
        final /* synthetic */ c iEI;
        private int[] iFi;
        private int iFj = 0;

        public n(c cVar, int[] iArr) {
            this.iEI = cVar;
            this.iFi = iArr;
        }

        public final boolean execute() {
            List<com.tencent.mm.modelsearch.q.a> c = this.iEI.iEr.c(this.iFi, 1);
            this.fmf = c.size();
            Object hashMap = new HashMap();
            for (com.tencent.mm.modelsearch.q.a aVar : c) {
                String str = aVar.cWv;
                if (!this.iEI.iEt.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(aVar.cWQ));
                }
            }
            this.iEI.iEt.putAll(hashMap);
            this.iFj = hashMap.size();
            return true;
        }

        public final String toString() {
            return "MarkAllContactDirty [touched: " + this.fmf + ", users: " + this.iFj + "]";
        }
    }

    private class o extends com.tencent.mm.modelsearch.r.a {
        private String bZy;
        private boolean guL = false;
        final /* synthetic */ c iEI;
        private boolean iFf = false;

        public o(c cVar, String str) {
            this.iEI = cVar;
            this.bZy = str;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Dirty Contact %s", new Object[]{this.bZy});
            if (this.iEI.iEt.containsKey(this.bZy)) {
                this.guL = true;
            } else {
                List a = this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, this.bZy, 1);
                this.iEI.iEt.put(this.bZy, a);
                if (a.isEmpty()) {
                    this.iFf = true;
                    this.iEI.cWq.a(65556, new k(this.iEI, this.bZy));
                } else {
                    Cursor zg = this.iEI.iEr.zg(this.bZy);
                    while (zg.moveToNext()) {
                        String string = zg.getString(0);
                        if (!this.iEI.iEt.containsKey(string)) {
                            this.iEI.iEt.put(string, this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, string, 1));
                        }
                    }
                    zg.close();
                }
            }
            return true;
        }

        public final String toString() {
            return "MarkContactDirty(\"" + this.bZy + "\")" + (this.guL ? " [cached]" : "") + (this.iFf ? " [skipped]" : "");
        }

        public final int getId() {
            return 17;
        }
    }

    private static class p {
        long cIA;
        String iFk;
        String iFl;
        String iFm;
        String iFn;
        String iFo;
        String iFp;
        int iFq;
        String username;

        p() {
        }

        p(af afVar) {
            this.cIA = afVar.cIA;
            this.username = afVar.getUsername();
            this.iFk = afVar.FG();
            this.iFl = afVar.FH();
            this.iFm = afVar.FI();
            this.iFn = afVar.FD();
            this.iFo = afVar.FE();
            this.iFp = afVar.FF();
            this.iFq = afVar.cIB;
        }
    }

    private class t extends com.tencent.mm.modelsearch.r.a {
        private int fKA = 0;
        private String gph;
        final /* synthetic */ c iEI;
        private int iFt = 0;

        public t(c cVar, String str) {
            this.iEI = cVar;
            this.gph = str;
        }

        public final boolean execute() {
            String[] strArr = (String[]) this.iEI.iEu.get(this.gph);
            Object obj = null;
            Cursor rawQuery = this.iEI.iEs.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?", new String[]{this.gph});
            if (rawQuery.moveToFirst()) {
                CharSequence string = rawQuery.getString(0);
                if (!be.kS(string)) {
                    obj = com.tencent.mm.modelsearch.d.cVB.split(string);
                }
            }
            rawQuery.close();
            this.iEI.iEr.beginTransaction();
            if (strArr == null) {
                this.iEI.iEr.zh(this.gph);
                this.iFt = (int) this.iEI.iEr.cWX.simpleQueryForLong();
                if (obj != null) {
                    this.iEI.iEr.d(this.gph, obj);
                    this.iEI.iEu.put(this.gph, obj);
                    this.fKA = obj.length;
                }
            } else if (obj == null) {
                this.iEI.iEr.zh(this.gph);
                this.iFt = (int) this.iEI.iEr.cWX.simpleQueryForLong();
                this.iEI.iEu.remove(this.gph);
            } else {
                HashSet hashSet = new HashSet(Arrays.asList(strArr));
                for (String str : obj) {
                    if (!hashSet.remove(str)) {
                        com.tencent.mm.plugin.search.a.b.a aVar = this.iEI.iEr;
                        aVar.iGE.bindString(1, this.gph);
                        aVar.iGE.bindString(2, str);
                        aVar.iGE.execute();
                        this.fKA++;
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    com.tencent.mm.plugin.search.a.b.a aVar2 = this.iEI.iEr;
                    aVar2.iGF.bindString(1, this.gph);
                    aVar2.iGF.bindString(2, str2);
                    aVar2.iGF.execute();
                    this.iFt++;
                }
                this.iEI.iEu.put(this.gph, obj);
            }
            this.iEI.iEr.commit();
            return true;
        }

        public final String toString() {
            return "UpdateChatroom(\"" + this.gph + "\") [new: " + this.fKA + ", removed: " + this.iFt + "]";
        }
    }

    private class u extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int mCount;

        private u(c cVar) {
            this.iEI = cVar;
            this.mCount = 0;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Update DirtyContact");
            Iterator it = this.iEI.iEt.entrySet().iterator();
            int i = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.iEI.iEr.commit();
                    throw new InterruptedException();
                }
                int i2;
                if (i >= 50) {
                    this.iEI.iEr.commit();
                    this.iEI.iEr.beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    this.iEI.iEr.c(Long.valueOf(longValue.longValue()));
                    i2++;
                }
                String str = (String) entry.getKey();
                ak.yW();
                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                if (LX == null || LX.field_username.length() <= 0 || !c.E(LX)) {
                    this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVn, str);
                    i = i2;
                } else {
                    i = this.iEI.F(LX) + i2;
                }
                it.remove();
                this.mCount++;
            }
            this.iEI.iEr.commit();
            return true;
        }

        public final String toString() {
            return "UpdateDirtyContact [" + this.mCount + "]";
        }

        public final int getId() {
            return 16;
        }
    }

    private class v extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private int iEZ;
        private String iFa;
        private boolean iFf = false;

        public v(c cVar, String str) {
            this.iEI = cVar;
            this.iFa = str;
            this.iEZ = 1;
        }

        public final boolean execute() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FTS.SearchContactLogic", "[UpdateFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.iFa, Integer.valueOf(this.iEZ)});
            long KM;
            if (this.iEZ == 1) {
                this.iEI.iEr.beginTransaction();
                KM = be.KM(this.iFa);
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVq, KM);
                af ae = com.tencent.mm.modelfriend.ah.FQ().ae(KM);
                if (ae == null) {
                    this.iFf = true;
                } else {
                    p pVar = new p(ae);
                    if (c.a(pVar)) {
                        c.a(this.iEI, pVar);
                    }
                }
                this.iEI.iEr.commit();
            } else if (this.iEZ == 2) {
                this.iEI.iEr.beginTransaction();
                KM = be.KM(this.iFa);
                this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVr, KM);
                com.tencent.mm.modelfriend.o oVar = new com.tencent.mm.modelfriend.o();
                if (com.tencent.mm.modelfriend.ah.FT().b(KM, oVar)) {
                    h hVar = new h(oVar);
                    if (c.a(hVar)) {
                        c.a(this.iEI, hVar);
                    }
                } else {
                    this.iFf = true;
                }
                this.iEI.iEr.commit();
            }
            return true;
        }

        public final String toString() {
            return "UpdateFriendTask(\"" + this.iFa + "\", " + this.iEZ + ")" + (this.iFf ? " [skipped]" : "");
        }
    }

    private class w extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ c iEI;
        private long iFu;
        private int iFv = 0;

        public w(c cVar, long j) {
            this.iEI = cVar;
            this.iFu = j;
        }

        public final boolean execute() {
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.modelsearch.b bVar = this.iEI.iEr;
            long j = this.iFu;
            Cursor rawQuery = bVar.cUY.rawQuery("SELECT user FROM ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!this.iEI.iEt.containsKey(str)) {
                    this.iEI.iEt.put(str, this.iEI.iEr.a(com.tencent.mm.modelsearch.d.cVo, str, 1));
                }
            }
            return true;
        }

        public final String toString() {
            return "UpdateLabel(" + this.iFu + ") [contacts: " + this.iFv + "]";
        }
    }

    private class q extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ c iEI;

        public q(c cVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iEI = cVar;
            super(jVar.bkC, jVar.cUS, jVar.cUR, jVar.cUP, jVar.handler);
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            if (i <= 0) {
                i = Integer.MAX_VALUE;
            }
            int[] e = FTSUtils.e(strArr);
            Cursor a = this.iEI.iEr.a(strArr, new int[]{131075}, null, null, true);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                String string = a.getString(3);
                if (!hashSet.contains(string)) {
                    int i2 = a.getInt(1);
                    com.tencent.mm.modelsearch.p.h hVar = (com.tencent.mm.modelsearch.p.h) hashMap.get(string);
                    if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVz, i2, hVar.cWt) < 0) {
                        com.tencent.mm.modelsearch.q.b a2 = new com.tencent.mm.modelsearch.q.b().a(a, e, true);
                        hashMap.put(a2.cWv, a2);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.modelsearch.q.b a22 : hashMap.values()) {
                a22.a(strArr, this.bkC, com.tencent.mm.modelsearch.d.cVv);
                arrayList.add(a22);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.cUU != null) {
                Collections.sort(arrayList, this.cUU);
            }
            List arrayList2 = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.tencent.mm.modelsearch.p.h hVar2 = (com.tencent.mm.modelsearch.p.h) arrayList.get(i3);
                if (hVar2.type == 131075 && hVar2.cWt == 38) {
                    ((com.tencent.mm.modelsearch.q.b) hVar2).j(com.tencent.mm.modelsearch.d.cVv);
                }
                stringBuffer.append(hVar2.cWz);
                stringBuffer.append("|");
                stringBuffer.append(hVar2.timestamp);
                stringBuffer.append(" ");
                arrayList2.add(hVar2);
                if (i3 >= i) {
                    break;
                }
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "rank score: %s", new Object[]{stringBuffer.toString()});
            return arrayList2;
        }

        protected final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }
    }

    private class r extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ c iEI;
        private int[] iFr;
        private int[] iFs;

        public r(c cVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iEI = cVar;
            super(jVar.bkC, jVar.cUS, jVar.cUR, jVar.cUP, jVar.handler);
            this.iFr = jVar.cWM;
            this.iFs = jVar.cWN;
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            String str;
            if (i <= 0) {
                i = Integer.MAX_VALUE;
            }
            int[] e = FTSUtils.e(strArr);
            com.tencent.mm.modelsearch.b bVar = this.iEI.iEr;
            int[] iArr = this.iFr;
            int[] iArr2 = this.iFs;
            StringBuilder stringBuilder = new StringBuilder(32);
            for (String str2 : strArr) {
                stringBuilder.append('\"');
                stringBuilder.append(str2);
                stringBuilder.append("*\" ");
            }
            String stringBuilder2 = stringBuilder.toString();
            String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + FTSUtils.i(iArr2);
            if (iArr == null || iArr.length <= 0) {
                str = "";
            } else {
                str = " AND type IN " + FTSUtils.i(iArr);
            }
            Cursor rawQuery = bVar.cUY.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp, content, offsets(%s) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.docid) WHERE content MATCH ?" + str + " AND status >= 0" + str3 + " ORDER BY subtype;", new Object[]{bVar.Ia(), bVar.HZ(), bVar.Ia(), bVar.HZ(), bVar.Ia()}), new String[]{stringBuilder2});
            List<com.tencent.mm.modelsearch.q.b> arrayList = new ArrayList();
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(hashSet);
            int i2 = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet2.add(rawQuery.getString(3))) {
                    com.tencent.mm.modelsearch.q.b a = new com.tencent.mm.modelsearch.q.b().a(rawQuery, e, true);
                    if (i2 < a.cWt) {
                        if (arrayList.size() > i) {
                            break;
                        }
                        i2 = a.cWt;
                        arrayList.add(a);
                    } else {
                        arrayList.add(a);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException();
                    }
                }
            }
            rawQuery.close();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.modelsearch.q.b bVar2 : arrayList) {
                com.tencent.mm.modelsearch.q.b bVar22;
                bVar22.a(strArr, this.bkC, null);
                arrayList2.add(bVar22);
            }
            if (this.cUU != null) {
                Collections.sort(arrayList2, this.cUU);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            StringBuffer stringBuffer = new StringBuffer();
            List<com.tencent.mm.modelsearch.p.h> arrayList3 = new ArrayList();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                bVar22 = (com.tencent.mm.modelsearch.q.b) arrayList2.get(i3);
                if (bVar22.type == 131072 && bVar22.cWt == 11) {
                    bVar22.j(com.tencent.mm.modelsearch.d.cVx);
                }
                stringBuffer.append(bVar22.cWz);
                stringBuffer.append(" ");
                arrayList3.add(bVar22);
                if (i3 >= i) {
                    break;
                }
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "getName() rank score: %s", new Object[]{stringBuffer.toString()});
            if (!Thread.interrupted()) {
                return arrayList3;
            }
            throw new InterruptedException();
        }

        protected final String getName() {
            return "SearchContactTask";
        }

        public final int getId() {
            return 20;
        }
    }

    private class s extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ c iEI;
        private int[] iFr;
        private int[] iFs;

        public s(c cVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iEI = cVar;
            super(jVar.bkC, jVar.cUS, jVar.cUR, jVar.cUP, jVar.handler);
            this.iFr = jVar.cWM;
            this.iFs = jVar.cWN;
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            int[] e = FTSUtils.e(strArr);
            Cursor a = this.iEI.iEr.a(strArr, this.iFr, this.iFs, null, true);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.modelsearch.q.b a2 = new com.tencent.mm.modelsearch.q.b().a(a, e, true);
                if (!hashSet.contains(a2.cWv)) {
                    com.tencent.mm.modelsearch.p.h hVar;
                    if (h.f(com.tencent.mm.modelsearch.d.cVn, a2.type)) {
                        hVar = (com.tencent.mm.modelsearch.p.h) hashMap.get(a2.cWv);
                        if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVz, a2.cWt, hVar.cWt) < 0) {
                            hashMap.put(a2.cWv, a2);
                        }
                    } else if (h.f(com.tencent.mm.modelsearch.d.cVp, a2.type)) {
                        hVar = (com.tencent.mm.modelsearch.p.h) hashMap2.get(Long.valueOf(a2.cWu));
                        if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVz, a2.cWt, hVar.cWt) < 0) {
                            hashMap2.put(Long.valueOf(a2.cWu), a2);
                        }
                    } else if (h.f(com.tencent.mm.modelsearch.d.cVq, a2.type)) {
                        hVar = (com.tencent.mm.modelsearch.p.h) hashMap2.get(Long.valueOf(a2.cWu));
                        if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVz, a2.cWt, hVar.cWt) < 0) {
                            hashMap2.put(Long.valueOf(a2.cWu), a2);
                        }
                    } else if (h.f(com.tencent.mm.modelsearch.d.cVr, a2.type)) {
                        hVar = (com.tencent.mm.modelsearch.p.h) hashMap2.get(Long.valueOf(a2.cWu));
                        if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVz, a2.cWt, hVar.cWt) < 0) {
                            hashMap2.put(Long.valueOf(a2.cWu), a2);
                        }
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            List<com.tencent.mm.modelsearch.p.h> arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.modelsearch.q.b bVar : hashMap.values()) {
                if (bVar.type == 131075 && bVar.cWt == 38) {
                    bVar.j(com.tencent.mm.modelsearch.d.cVv);
                }
                if (bVar.type == 131072 && bVar.cWt == 11) {
                    bVar.j(com.tencent.mm.modelsearch.d.cVx);
                }
                arrayList.add(bVar);
            }
            arrayList.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.cUU != null) {
                Collections.sort(arrayList, this.cUU);
            }
            return arrayList;
        }

        protected final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        public final int getId() {
            return 11;
        }
    }

    static /* synthetic */ int a(c cVar, a aVar) {
        int i;
        String str;
        String str2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        String ma = be.ma(aVar.userName);
        int i2 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.bhT == null || aVar.bhT.length() <= 0) {
            i = 0;
        } else {
            cVar.iEr.c(i2, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.bhT);
            i = 1;
        }
        String str3 = aVar.cGS;
        String str4 = aVar.iEK;
        String str5 = aVar.iEL;
        if (str3 != null && str3.length() > 0) {
            String str6 = str3.equalsIgnoreCase(str4) ? null : str4;
            str = (str6 == null || str6.equalsIgnoreCase(str5)) ? null : str5;
            cVar.iEr.c(i2, 12, aVar.id, ma, currentTimeMillis, str3);
            i++;
            if (str6 != null) {
                cVar.iEr.c(i2, 13, aVar.id, ma, currentTimeMillis, str6);
                i++;
            }
            if (str != null) {
                cVar.iEr.c(i2, 14, aVar.id, ma, currentTimeMillis, str);
                i++;
            }
        }
        str3 = aVar.aGX;
        str4 = aVar.iEM;
        str5 = aVar.iEN;
        if (str3 == null || str3.length() <= 0) {
            return i;
        }
        str = str3.equalsIgnoreCase(str4) ? null : str4;
        if (!(str == null || str.equalsIgnoreCase(str5))) {
            str2 = str5;
        }
        cVar.iEr.c(i2, 5, aVar.id, ma, currentTimeMillis, str3);
        i++;
        if (str != null) {
            cVar.iEr.c(i2, 6, aVar.id, ma, currentTimeMillis, str);
            i++;
        }
        if (str2 == null) {
            return i;
        }
        cVar.iEr.c(i2, 7, aVar.id, ma, currentTimeMillis, str2);
        return i + 1;
    }

    static /* synthetic */ int a(c cVar, h hVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String ma = be.ma(hVar.username);
        int i = hVar.status != 0 ? 131079 : 131080;
        cVar.iEr.c(i, 26, hVar.iFb, ma, currentTimeMillis, hVar.iFc);
        String str = hVar.iFd;
        String str2 = hVar.iFe;
        if (be.kS(str)) {
            return 1;
        }
        String str3 = str.equalsIgnoreCase(str2) ? null : str2;
        cVar.iEr.c(i, 27, hVar.iFb, ma, currentTimeMillis, str);
        if (str3 == null) {
            return 2;
        }
        cVar.iEr.c(i, 28, hVar.iFb, ma, currentTimeMillis, str3);
        return 3;
    }

    static /* synthetic */ int a(c cVar, p pVar) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String ma = be.ma(pVar.username);
        int i2 = pVar.iFq != 0 ? 131077 : 131078;
        cVar.iEr.c(i2, 25, pVar.cIA, ma, currentTimeMillis, pVar.cIA);
        String str = pVar.iFn;
        String str2 = pVar.iFp;
        String str3 = pVar.iFo;
        if (be.kS(str)) {
            i = 1;
        } else {
            if (str.equalsIgnoreCase(str2)) {
                str2 = null;
            }
            String str4 = (str2 == null || str2.equalsIgnoreCase(str3)) ? null : str3;
            cVar.iEr.c(i2, 22, pVar.cIA, ma, currentTimeMillis, str);
            int i3 = 2;
            if (str2 != null) {
                cVar.iEr.c(i2, 23, pVar.cIA, ma, currentTimeMillis, str2);
                i3 = 3;
            }
            if (str4 != null) {
                cVar.iEr.c(i2, 24, pVar.cIA, ma, currentTimeMillis, str4);
                i = i3 + 1;
            } else {
                i = i3;
            }
        }
        String str5 = pVar.iFk;
        String str6 = pVar.iFm;
        str3 = pVar.iFl;
        if (be.kS(str5)) {
            return i;
        }
        String str7 = str.equalsIgnoreCase(str6) ? null : str6;
        String str8 = (str7 == null || str7.equalsIgnoreCase(str3)) ? null : str3;
        cVar.iEr.c(i2, 19, pVar.cIA, ma, currentTimeMillis, str5);
        i++;
        if (str7 != null) {
            cVar.iEr.c(i2, 20, pVar.cIA, ma, currentTimeMillis, str7);
            i++;
        }
        if (str8 == null) {
            return i;
        }
        cVar.iEr.c(i2, 21, pVar.cIA, ma, currentTimeMillis, str8);
        return i + 1;
    }

    static /* synthetic */ boolean a(a aVar) {
        return aVar.type == 0 && aVar.status != 2;
    }

    static /* synthetic */ boolean a(h hVar) {
        return hVar.status != 2;
    }

    static /* synthetic */ boolean a(p pVar) {
        return pVar.iFq != 2;
    }

    static /* synthetic */ boolean aMc() {
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        return str != null && str.length() > 0;
    }

    static /* synthetic */ boolean aMd() {
        ak.yW();
        Object obj = ((be.f((Integer) com.tencent.mm.model.c.vf().get(9, null)) != 0 ? 1 : null) == null || (com.tencent.mm.model.k.xQ() & 4096) != 0) ? 1 : null;
        return obj == null;
    }

    public final com.tencent.mm.modelsearch.r.a b(com.tencent.mm.modelsearch.p.j jVar) {
        com.tencent.mm.modelsearch.a.a sVar = new s(this, jVar);
        sVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, sVar);
    }

    public final com.tencent.mm.modelsearch.r.a c(com.tencent.mm.modelsearch.p.j jVar) {
        com.tencent.mm.modelsearch.a.a rVar = new r(this, jVar);
        rVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, rVar);
    }

    public final com.tencent.mm.modelsearch.r.a d(com.tencent.mm.modelsearch.p.j jVar) {
        com.tencent.mm.modelsearch.a.a qVar = new q(this, jVar);
        qVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, qVar);
    }

    protected final boolean onCreate() {
        if (com.tencent.mm.modelsearch.p.Iu()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Create Success!");
            this.iEr = (com.tencent.mm.plugin.search.a.b.a) com.tencent.mm.modelsearch.p.gd(3);
            this.cWq = com.tencent.mm.modelsearch.p.It();
            ak.yW();
            this.iEs = com.tencent.mm.model.c.wF();
            this.iEt = new HashMap();
            this.iEu = new HashMap();
            this.iEv = new HashMap();
            try {
                this.iEw = ab.class.getDeclaredMethod("pG", new Class[0]);
                this.iEw.setAccessible(true);
                this.cWq.a(65554, new a(this.iEr, new int[]{131072, 131075, 131076, 131073, 131074}, new int[]{4, 5, 0, 1, 1}));
                this.cWq.a(131072, new m());
                this.cWq.a(131082, new b());
                this.cWq.a(131092, new c());
                this.cWq.a(131102, new d());
                ak.yW().wO().c(this.iEC);
                ak.yW();
                com.tencent.mm.model.c.wH().a(this.iEy);
                ak.yW();
                com.tencent.mm.model.c.wK().a(this.iEx);
                com.tencent.mm.modelfriend.ah.FL().a(this.iEz);
                com.tencent.mm.modelfriend.ah.FQ().a(this.iEA);
                com.tencent.mm.modelfriend.ah.FT().cHU.a(this.iEB);
                com.tencent.mm.pluginsdk.j.e bmu = com.tencent.mm.pluginsdk.j.a.bmu();
                if (bmu != null) {
                    bmu.a(this.iED);
                }
                this.iEG.ea(600000);
                com.tencent.mm.sdk.c.a.nhr.e(this.iEE);
                com.tencent.mm.sdk.c.a.nhr.e(this.iEF);
                this.iEr.Ib();
                this.cWq.a(Integer.MAX_VALUE, new i());
                return true;
            } catch (Throwable e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                throw assertionFailedError;
            }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FTS.SearchContactLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        com.tencent.mm.sdk.c.a.nhr.f(this.iEE);
        com.tencent.mm.sdk.c.a.nhr.f(this.iEF);
        this.iEH.QI();
        this.iEG.QI();
        com.tencent.mm.modelfriend.ah.FL().b(this.iEz);
        com.tencent.mm.modelfriend.ah.FQ().b(this.iEA);
        com.tencent.mm.modelfriend.ah.FT().cHU.b(this.iEB);
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.iEy);
        ak.yW().wO().d(this.iEC);
        ak.yW();
        com.tencent.mm.model.c.wK().b(this.iEx);
        com.tencent.mm.pluginsdk.j.e bmu = com.tencent.mm.pluginsdk.j.a.bmu();
        if (bmu != null) {
            bmu.b(this.iED);
        }
        return true;
    }

    public final String getName() {
        return "SearchContactLogic";
    }

    final void D(com.tencent.mm.storage.u uVar) {
        try {
            this.iEw.invoke(uVar, new Object[0]);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.FTS.SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
        }
    }

    private String aB(byte[] bArr) {
        com.tencent.mm.storage.u uVar = new com.tencent.mm.storage.u();
        uVar.u(bArr);
        D(uVar);
        return uVar.bCt;
    }

    static boolean E(com.tencent.mm.storage.u uVar) {
        String str = uVar.field_username;
        if (uVar.isHidden() || uVar.tK() || str.endsWith("@stranger") || str.endsWith("@qqim") || str.endsWith("@app") || uVar.field_deleteFlag != 0) {
            return false;
        }
        if (com.tencent.mm.i.a.ei(uVar.field_type)) {
            return true;
        }
        if (uVar.tJ() || uVar.bvm()) {
            return false;
        }
        ak.yW();
        if (com.tencent.mm.model.c.wK().Mo(str)) {
            return true;
        }
        return false;
    }

    final int F(com.tencent.mm.storage.u uVar) {
        long j;
        int i;
        String Y;
        int i2;
        int i3;
        String str;
        String str2;
        long j2 = uVar.chr;
        String str3 = uVar.field_username;
        String pD = uVar.pD();
        String str4 = uVar.field_nickname;
        String jB = com.tencent.mm.modelsearch.h.jB(str4);
        String jC = com.tencent.mm.modelsearch.h.jC(str4);
        String str5 = uVar.field_conRemark;
        String jB2 = com.tencent.mm.modelsearch.h.jB(str5);
        String jC2 = com.tencent.mm.modelsearch.h.jC(str5);
        String str6 = uVar.bCt;
        String str7 = uVar.field_contactLabelIds;
        String str8 = uVar.bCz;
        int i4 = uVar.field_verifyFlag;
        long currentTimeMillis = System.currentTimeMillis();
        if (str3.endsWith("@chatroom")) {
            String[] strArr = new String[]{str3};
            Cursor rawQuery = this.iEs.rawQuery("SELECT conversationTime FROM rconversation WHERE username=?;", strArr);
            j = 0;
            if (rawQuery != null && rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            com.tencent.mm.storage.o LC = ak.yW().wO().LC(str3);
            if (LC == null) {
                i = 0;
            } else {
                String[] split = com.tencent.mm.modelsearch.d.cVB.split(LC.field_memberlist);
                if (split == null || split.length == 0) {
                    i = 0;
                } else {
                    Cursor rawQuery2 = this.iEs.rawQuery("SELECT username, alias, conRemark, conRemarkPYFull, conRemarkPYShort, nickname, quanPin, pyInitial, lvbuff FROM rcontact WHERE username IN " + h.s(split) + " ORDER BY username;", null);
                    StringBuilder stringBuilder = new StringBuilder(2048);
                    while (rawQuery2.moveToNext()) {
                        String string = rawQuery2.getString(0);
                        Y = h.Y(string, rawQuery2.getString(1));
                        if (Y == null) {
                            Y = "";
                        }
                        stringBuilder.append(Y + '​');
                        String string2 = rawQuery2.getString(2);
                        String string3;
                        if (string2 == null || string2.length() == 0) {
                            string2 = rawQuery2.getString(5);
                            Y = rawQuery2.getString(6);
                            if (string2.equalsIgnoreCase(Y)) {
                                Y = "";
                            }
                            string3 = rawQuery2.getString(7);
                            if (Y.length() == 0 || Y.equalsIgnoreCase(string3)) {
                                string3 = "";
                            }
                            stringBuilder.append(string2 + '​');
                            stringBuilder.append(Y + '​');
                            stringBuilder.append(string3 + '​');
                            stringBuilder.append("​​​");
                        } else {
                            Y = rawQuery2.getString(3);
                            if (string2.equalsIgnoreCase(Y)) {
                                Y = "";
                            }
                            string3 = rawQuery2.getString(4);
                            if (Y.length() == 0 || Y.equalsIgnoreCase(string3)) {
                                string3 = "";
                            }
                            stringBuilder.append(string2 + '​');
                            stringBuilder.append(Y + '​');
                            stringBuilder.append(string3 + '​');
                            string2 = rawQuery2.getString(5);
                            Y = rawQuery2.getString(6);
                            if (string2.equalsIgnoreCase(Y)) {
                                Y = "";
                            }
                            string3 = rawQuery2.getString(7);
                            if (Y.length() == 0 || Y.equalsIgnoreCase(string3)) {
                                string3 = "";
                            }
                            stringBuilder.append(string2 + '​');
                            stringBuilder.append(Y + '​');
                            stringBuilder.append(string3 + '​');
                        }
                        Y = LC.er(string);
                        if (Y == null) {
                            Y = "";
                        }
                        stringBuilder.append(Y + '​');
                        Y = aB(rawQuery2.getBlob(8));
                        if (Y == null) {
                            Y = "";
                        }
                        stringBuilder.append(Y + '​');
                    }
                    rawQuery2.close();
                    stringBuilder.setLength(stringBuilder.length() - 1);
                    this.iEr.c(131075, 38, (long) split.length, str3, j, stringBuilder.toString());
                    i = 1;
                }
            }
            i4 = 131075;
            i2 = i + 0;
        } else if ((i4 & com.tencent.mm.storage.u.bvo()) != 0) {
            i4 = 131076;
            i2 = 0;
            j = currentTimeMillis;
        } else {
            i4 = 131072;
            if (str7 == null || str7.length() <= 0) {
                i2 = 0;
                j = currentTimeMillis;
            } else {
                i2 = a(j2, str3, str7, currentTimeMillis) + 0;
                j = currentTimeMillis;
            }
        }
        String Y2 = h.Y(str3, pD);
        if (Y2 == null || Y2.length() == 0) {
            i3 = i2;
        } else {
            this.iEr.c(i4, 15, j2, str3, j, Y2);
            i3 = i2 + 1;
        }
        if (str5 == null || str5.length() == 0) {
            jC2 = null;
            Y2 = str4;
            str4 = null;
            str = jB;
            Y = jC;
            jC = null;
        } else {
            Y = jC2;
            str = jB2;
            Y2 = str5;
            jC2 = jC;
            jC = jB;
        }
        if (!(Y2 == null || Y2.length() == 0)) {
            if (Y2.equalsIgnoreCase(str)) {
                jB2 = null;
            } else {
                jB2 = str;
            }
            if (jB2 == null || jB2.length() == 0 || jB2.equalsIgnoreCase(Y)) {
                str2 = null;
            } else {
                str2 = Y;
            }
            this.iEr.c(i4, 1, j2, str3, j, Y2);
            if (!(jB2 == null || jB2.length() == 0)) {
                this.iEr.c(i4, 2, j2, str3, j, jB2);
            }
            if (!(str2 == null || str2.length() == 0)) {
                this.iEr.c(i4, 3, j2, str3, j, str2);
            }
            i3 += 3;
        }
        if (str4 == null || str4.length() == 0) {
            i2 = i3;
        } else {
            if (str4.equalsIgnoreCase(jC)) {
                jC = null;
            }
            if (jC == null || jC.length() == 0 || jC.equalsIgnoreCase(jC2)) {
                str2 = null;
            } else {
                str2 = jC2;
            }
            this.iEr.c(i4, 5, j2, str3, j, str4);
            if (!(jC == null || jC.length() == 0)) {
                this.iEr.c(i4, 6, j2, str3, j, jC);
            }
            if (!(str2 == null || str2.length() == 0)) {
                this.iEr.c(i4, 7, j2, str3, j, str2);
            }
            i2 = i3 + 3;
        }
        if (str6 != null && str6.length() > 0) {
            this.iEr.c(i4, 4, j2, str3, j, str6);
            i2++;
        }
        if (i4 == 131072) {
            if (be.kS(str8)) {
                Cursor rawQuery3 = this.iEs.rawQuery("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str3});
                if (rawQuery3.moveToFirst()) {
                    this.iEr.c(i4, 16, j2, str3, j, rawQuery3.getString(0));
                    i = i2 + 1;
                } else {
                    i = i2;
                }
                rawQuery3.close();
                i2 = i;
            } else {
                this.iEr.c(i4, 16, j2, str3, j, str8.replace(",", "​"));
                i2++;
            }
            Y2 = com.tencent.mm.model.l.eu(uVar.getProvince());
            if (!(Y2 == null || Y2.length() == 0)) {
                this.iEr.c(i4, 18, j2, str3, j, Y2);
            }
            Y2 = uVar.getCity();
            if (!(Y2 == null || Y2.length() == 0)) {
                this.iEr.c(i4, 17, j2, str3, j, Y2);
            }
        }
        return i2;
    }

    private int a(long j, String str, String str2, long j2) {
        List arrayList;
        List list;
        if (str2 != null) {
            if (str2.endsWith("\u0000")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            if (str2.length() != 0) {
                String[] split = com.tencent.mm.modelsearch.d.cVF.split(str2);
                if (split.length != 0) {
                    arrayList = new ArrayList(split.length);
                    for (String str3 : split) {
                        arrayList.add(Long.valueOf(be.getLong(str3, 0)));
                    }
                    list = arrayList;
                    arrayList = (List) this.iEv.get(str);
                    if (arrayList != null) {
                        this.iEr.zf(str);
                        if (!(r1 == null || r1.isEmpty())) {
                            this.iEr.g(str, r1);
                            this.iEv.put(str, r1);
                        }
                    } else if (r1 != null || r1.isEmpty()) {
                        this.iEr.zf(str);
                        this.iEv.remove(str);
                    } else {
                        long longValue;
                        com.tencent.mm.plugin.search.a.b.a aVar;
                        HashSet hashSet = new HashSet(arrayList);
                        for (Long longValue2 : r1) {
                            longValue = longValue2.longValue();
                            if (!hashSet.remove(Long.valueOf(longValue))) {
                                aVar = this.iEr;
                                aVar.iGH.bindString(1, str);
                                aVar.iGH.bindLong(2, longValue);
                                aVar.iGH.execute();
                            }
                        }
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            longValue = ((Long) it.next()).longValue();
                            aVar = this.iEr;
                            aVar.iGI.bindString(1, str);
                            aVar.iGI.bindLong(2, longValue);
                            aVar.iGI.execute();
                        }
                        this.iEv.put(str, r1);
                    }
                    if (r1 != null || r1.isEmpty()) {
                        return 0;
                    }
                    StringBuilder stringBuilder = new StringBuilder(512);
                    String str4 = "SELECT labelName, labelPYFull, labelPYShort FROM ContactLabel WHERE labelID=?;";
                    String[] strArr = new String[1];
                    for (Long longValue22 : r1) {
                        strArr[0] = Long.toString(longValue22.longValue());
                        Cursor rawQuery = this.iEs.rawQuery(str4, strArr);
                        if (rawQuery.moveToFirst()) {
                            stringBuilder.append(rawQuery.getString(0)).append('​');
                            stringBuilder.append(rawQuery.getString(1)).append('​');
                            stringBuilder.append(rawQuery.getString(2)).append('​');
                        } else {
                            stringBuilder.append("​​​");
                        }
                        rawQuery.close();
                    }
                    stringBuilder.setLength(stringBuilder.length() - 1);
                    this.iEr.c(131072, 11, j, str, j2, stringBuilder.toString());
                    return 1;
                }
            }
        }
        list = null;
        arrayList = (List) this.iEv.get(str);
        if (arrayList != null) {
            if (r1 != null) {
            }
            this.iEr.zf(str);
            this.iEv.remove(str);
        } else {
            this.iEr.zf(str);
            this.iEr.g(str, r1);
            this.iEv.put(str, r1);
        }
        if (r1 != null) {
        }
        return 0;
    }
}
