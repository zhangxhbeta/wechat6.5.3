package com.tencent.mm.plugin.search.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.nc;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class f extends com.tencent.mm.modelsearch.a implements com.tencent.mm.sdk.h.g.a, com.tencent.mm.storage.au.a {
    r cWq;
    com.tencent.mm.bg.g iEs;
    com.tencent.mm.plugin.search.a.b.c iFO;
    boolean iFP = false;
    private com.tencent.mm.sdk.c.c iFQ = new com.tencent.mm.sdk.c.c<lz>(this) {
        final /* synthetic */ f iFV;

        {
            this.iFV = r2;
            this.nhz = lz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            lz lzVar = (lz) bVar;
            if (lzVar instanceof lz) {
                this.iFV.cWq.a(65576, new d(this.iFV, lzVar.bnh.bao));
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iFR = new com.tencent.mm.sdk.c.c<ly>(this) {
        final /* synthetic */ f iFV;

        {
            this.iFV = r2;
            this.nhz = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ly lyVar = (ly) bVar;
            if (lyVar instanceof ly) {
                this.iFV.cWq.a(65576, new d(this.iFV, lyVar.bnd.bao));
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iFS = new com.tencent.mm.sdk.c.c<nc>(this) {
        final /* synthetic */ f iFV;

        {
            this.iFV = r2;
            this.nhz = nc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.iFV.cWq.a(65574, new com.tencent.mm.modelsearch.r.a(this) {
                final /* synthetic */ AnonymousClass3 iFW;

                {
                    this.iFW = r1;
                }

                public final boolean execute() {
                    this.iFW.iFV.iFO.f(-1, Long.MAX_VALUE);
                    return true;
                }

                public final String toString() {
                    return "ResetMessageCreateTimeCursor";
                }
            });
            return false;
        }
    };
    com.tencent.mm.sdk.c.c iFT = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.d>(this) {
        final /* synthetic */ f iFV;

        {
            this.iFV = r2;
            this.nhz = com.tencent.mm.e.a.d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((com.tencent.mm.e.a.d) bVar).aWo.aWp) {
                this.iFV.iFU.QI();
            } else {
                this.iFV.iFU.ea(60000);
            }
            return false;
        }
    };
    ah iFU = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ f iFV;

        {
            this.iFV = r1;
        }

        public final boolean oU() {
            if (!this.iFV.iFP) {
                this.iFV.iFP = true;
                this.iFV.cWq.a(131112, new a());
            }
            com.tencent.mm.sdk.c.a.nhr.f(this.iFV.iFT);
            return false;
        }

        public final String toString() {
            return super.toString() + "|mBackgroundTimer";
        }
    }, false);

    private class a extends com.tencent.mm.modelsearch.r.a {
        private int fKA;
        private int fKB;
        final /* synthetic */ f iFV;
        private HashSet<Pair<Long, Long>> iFX;
        private ArrayList<Long> iFY;
        private long iFZ;
        private long iGa;
        private int iGb;
        private int mFailedCount;

        private class a {
            long bao;
            String bdo;
            String content;
            long dhH;
            int iGc;
            final /* synthetic */ a iGd;
            int msgType;

            private a(a aVar) {
                this.iGd = aVar;
            }
        }

        private a(f fVar) {
            this.iFV = fVar;
            this.iFX = null;
            this.iFY = null;
            this.iFZ = -1;
            this.iGa = Long.MAX_VALUE;
            this.iGb = 0;
            this.fKA = 0;
            this.fKB = 0;
            this.mFailedCount = 0;
        }

        public final boolean execute() {
            long j;
            if (this.iFZ < 0) {
                this.iFZ = this.iFV.iFO.e(-2, 0);
                if (this.iFZ != 1) {
                    this.iGa = Long.MAX_VALUE;
                    this.iFV.iFO.beginTransaction();
                    this.iFV.iFO.f(-1, this.iGa);
                    this.iFV.iFO.f(-2, 1);
                    this.iFV.iFO.commit();
                } else {
                    this.iGa = this.iFV.iFO.e(-1, Long.MAX_VALUE);
                }
            }
            v.i("MicroMsg.FTS.SearchMessageLogic", "Start building message index, last createTime: " + this.iGa);
            if (this.iFX == null) {
                this.iFX = new HashSet();
                this.iFY = new ArrayList();
                Cursor a = this.iFV.iFO.a(com.tencent.mm.modelsearch.d.cVi, true, true, false, true, true);
                while (a.moveToNext()) {
                    long j2 = a.getLong(0);
                    long j3 = a.getLong(1);
                    j = a.getLong(2);
                    if (a.getInt(3) == -1) {
                        this.iFY.add(Long.valueOf(j2));
                    } else if (j <= this.iGa) {
                        this.iFX.add(new Pair(Long.valueOf(j3), Long.valueOf(j)));
                    }
                }
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i;
            int i2 = 50;
            int i3 = Integer.MAX_VALUE;
            String[] strArr = new String[2];
            a[] aVarArr = new a[50];
            while (i3 >= 50) {
                strArr[0] = Long.toString(this.iGa);
                strArr[1] = Integer.toString(this.iGb);
                Cursor rawQuery = this.iFV.iEs.rawQuery("SELECT msgId, talker, createTime, content, type FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                i3 = 0;
                while (rawQuery.moveToNext()) {
                    a aVar = aVarArr[i3];
                    if (aVar == null) {
                        a aVar2 = this;
                        aVar = new a();
                        aVarArr[i3] = aVar;
                    }
                    aVar.bao = rawQuery.getLong(0);
                    aVar.bdo = rawQuery.getString(1);
                    aVar.dhH = rawQuery.getLong(2);
                    aVar.content = rawQuery.getString(3);
                    aVar.msgType = rawQuery.getInt(4);
                    aVar.iGc = 41;
                    if ((aVar.msgType & 65535) == 49 && !be.kS(aVar.content)) {
                        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(aVar.content);
                        if (dV != null) {
                            switch (dV.type) {
                                case 3:
                                case 4:
                                case 5:
                                case 8:
                                case 10:
                                case as.CTRL_INDEX /*13*/:
                                case am.CTRL_INDEX /*15*/:
                                case 16:
                                case 20:
                                case 25:
                                    aVar.content = be.ah(dV.title, "");
                                    aVar.iGc = 43;
                                    break;
                                case 6:
                                    aVar.content = be.ah(dV.title, "");
                                    aVar.iGc = 42;
                                    break;
                                case 19:
                                    aVar.content = be.ah(dV.description, "");
                                    if (aVar.content != null) {
                                        aVar.content = aVar.content.replace(":", "​");
                                    }
                                    aVar.iGc = 44;
                                    break;
                                default:
                                    aVar.content = null;
                                    break;
                            }
                        }
                        v.i("MicroMsg.FTS.SearchMessageLogic", "appmsgcontent is null");
                    }
                    i3++;
                }
                rawQuery.close();
                if (i3 < 50) {
                    Arrays.fill(aVarArr, i3, 50, null);
                }
                int i4 = 0;
                i = i2;
                while (i4 < 50) {
                    a aVar3 = aVarArr[i4];
                    if (aVar3 == null) {
                        continue;
                        i2 = i;
                    } else if (Thread.interrupted()) {
                        this.iFV.iFO.f(-1, this.iGa);
                        this.iFV.iFO.commit();
                        throw new InterruptedException();
                    } else {
                        long j4 = aVar3.bao;
                        j = aVar3.dhH;
                        if (j == this.iGa) {
                            this.iGb++;
                        } else {
                            this.iGa = j;
                            this.iGb = 0;
                        }
                        if (this.iFX.remove(new Pair(Long.valueOf(j4), Long.valueOf(j)))) {
                            i2 = i;
                        } else {
                            if (i >= 50) {
                                this.iFV.iFO.f(-1, this.iGa);
                                this.iFV.iFO.commit();
                                this.iFV.iFO.beginTransaction();
                                i2 = 0;
                            } else {
                                i2 = i;
                            }
                            String str = aVar3.bdo;
                            String str2 = aVar3.content;
                            int i5 = aVar3.iGc;
                            if (str2 != null && (str == null || !str.endsWith("@app"))) {
                                try {
                                    this.iFV.iFO.a(65536, i5, j4, str, j, f.aA(str, str2));
                                    i2++;
                                    this.fKA++;
                                } catch (Throwable e) {
                                    v.a("MicroMsg.FTS.SearchMessageLogic", e, "Build message index failed with exception.", new Object[0]);
                                    this.mFailedCount++;
                                }
                            }
                        }
                        i4++;
                        i = i2;
                    }
                }
                i2 = i;
            }
            this.iFV.iFO.commit();
            i = 50;
            Iterator it = this.iFX.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.iFV.iFO.f(-1, this.iGa);
                    this.iFV.iFO.commit();
                    throw new InterruptedException();
                }
                int i6;
                if (i >= 50) {
                    this.iFV.iFO.commit();
                    this.iFV.iFO.beginTransaction();
                    i6 = 0;
                } else {
                    i6 = i;
                }
                Pair pair = (Pair) it.next();
                this.iFV.iFO.a(com.tencent.mm.modelsearch.d.cVi, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                i = i6 + 1;
                this.fKB++;
                it.remove();
            }
            this.iFV.iFO.commit();
            i = 50;
            ListIterator listIterator = this.iFY.listIterator(this.iFY.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    this.iFV.iFO.f(-1, this.iGa);
                    this.iFV.iFO.commit();
                    throw new InterruptedException();
                }
                int i7;
                if (i >= 50) {
                    this.iFV.iFO.commit();
                    this.iFV.iFO.beginTransaction();
                    i7 = 0;
                } else {
                    i7 = i;
                }
                this.iFV.iFO.c(Long.valueOf(((Long) listIterator.previous()).longValue()));
                i = i7 + 1;
                this.fKB++;
                listIterator.remove();
            }
            this.iFV.iFO.f(-1, this.iGa - 1);
            this.iFV.iFO.commit();
            this.iFV.iFP = false;
            return true;
        }

        public final String toString() {
            return "BuildMessageIndex [new: " + this.fKA + ", removed: " + this.fKB + ", failed: " + this.mFailedCount + "]";
        }

        public final int getId() {
            return 4;
        }
    }

    private class c extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ f iFV;
        private int mCount;

        private c(f fVar) {
            this.iFV = fVar;
            this.mCount = 0;
        }

        public final boolean execute() {
            this.mCount = this.iFV.iFO.c(com.tencent.mm.modelsearch.d.cVi, -1).size();
            return true;
        }

        public final String toString() {
            return "DeleteAllMessages [" + this.mCount + "]";
        }
    }

    private class d extends com.tencent.mm.modelsearch.r.a {
        private long bZz;
        final /* synthetic */ f iFV;
        private long mCreateTime = -1;

        public d(f fVar, long j) {
            this.iFV = fVar;
            this.bZz = j;
        }

        public final boolean execute() {
            if (this.mCreateTime > 0) {
                this.iFV.iFO.a(com.tencent.mm.modelsearch.d.cVi, this.bZz, this.mCreateTime);
            } else {
                this.iFV.iFO.a(com.tencent.mm.modelsearch.d.cVi, this.bZz);
            }
            return true;
        }

        public final String toString() {
            return "DeleteMessage(" + this.bZz + ")";
        }
    }

    private class e extends com.tencent.mm.modelsearch.r.a {
        private String eSI;
        final /* synthetic */ f iFV;
        private int mCount = 0;

        public e(f fVar, String str) {
            this.iFV = fVar;
            this.eSI = str;
        }

        public final boolean execute() {
            this.mCount = this.iFV.iFO.a(com.tencent.mm.modelsearch.d.cVi, this.eSI, -1).size();
            return true;
        }

        public final String toString() {
            return "DeleteMessageByTalker(\"" + this.eSI + "\") [" + this.mCount + "]";
        }
    }

    private class f extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ f iFV;

        private f(f fVar) {
            this.iFV = fVar;
        }

        public final boolean execute() {
            v.i("MicroMsg.FTS.SearchMessageLogic", "total %d", new Object[]{Long.valueOf(this.iFV.iFO.Ie())});
            return true;
        }
    }

    private class g extends com.tencent.mm.modelsearch.r.a {
        private long bZz = 0;
        final /* synthetic */ f iFV;
        private at[] iGe;
        private int mCount = 0;
        private long mCreateTime = 0;

        public g(f fVar, List<at> list) {
            this.iFV = fVar;
            this.iGe = new at[list.size()];
            if (!list.isEmpty()) {
                list.toArray(this.iGe);
            }
        }

        public final boolean execute() {
            boolean z = false;
            if (!(this.iGe == null || this.iGe.length == 0)) {
                at[] atVarArr = this.iGe;
                int length = atVarArr.length;
                int i = 0;
                while (i < length) {
                    boolean z2;
                    bx bxVar = atVarArr[i];
                    if (bxVar.field_type == 1 || bxVar.bvY()) {
                        if (z) {
                            z2 = z;
                        } else {
                            this.iFV.iFO.beginTransaction();
                            z2 = true;
                        }
                        String str = bxVar.field_talker;
                        String str2 = bxVar.field_content;
                        int i2 = 41;
                        if (!(str == null || str2 == null || (str != null && str.endsWith("@app")))) {
                            if (bxVar.bvY()) {
                                com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(bxVar.field_content);
                                if (dV != null) {
                                    switch (dV.type) {
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 8:
                                        case 10:
                                        case as.CTRL_INDEX /*13*/:
                                        case am.CTRL_INDEX /*15*/:
                                        case 16:
                                        case 20:
                                        case 25:
                                            str2 = be.ah(dV.title, "");
                                            i2 = 43;
                                            break;
                                        case 6:
                                            str2 = be.ah(dV.title, "");
                                            i2 = 42;
                                            break;
                                        case 19:
                                            str2 = be.ah(dV.description, "");
                                            if (str2 != null) {
                                                str2 = str2.replace(":", "​");
                                            }
                                            i2 = 44;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                v.i("MicroMsg.FTS.SearchMessageLogic", "appmsgcontent is null");
                            }
                            String aA = f.aA(str, str2);
                            this.bZz = bxVar.field_msgId;
                            this.mCreateTime = bxVar.field_createTime;
                            this.iFV.iFO.a(65536, i2, this.bZz, str, this.mCreateTime, aA);
                            this.mCount++;
                        }
                    } else {
                        z2 = z;
                    }
                    i++;
                    z = z2;
                }
                if (z) {
                    this.iFV.iFO.commit();
                }
            }
            return true;
        }

        public final String toString() {
            return "InsertMessage " + (this.mCount > 0 ? "[id: " + this.bZz + ", count: " + this.mCount + "]" : "[skipped]");
        }
    }

    private class b extends a {
        final /* synthetic */ f iFV;

        public b(f fVar) {
            this.iFV = fVar;
            super(fVar.iFO, new int[]{65536}, new int[]{4});
        }

        protected final void aMg() {
            this.iFV.iFO.f(-1, Long.MAX_VALUE);
        }

        public final String toString() {
            return "CheckMessageIndexUpdate [4]";
        }
    }

    private class h extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ f iFV;

        h(f fVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iFV = fVar;
            super(jVar.bkC, 0, jVar.cUR, jVar.cUP, jVar.handler);
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            int[] e = FTSUtils.e(strArr);
            Cursor a = this.iFV.iFO.a(strArr, com.tencent.mm.modelsearch.d.cVi);
            HashMap hashMap = new HashMap();
            HashSet hashSet2 = new HashSet();
            while (a.moveToNext()) {
                if (hashSet2.add(new Pair(Long.valueOf(a.getLong(2)), Long.valueOf(a.getLong(4))))) {
                    String string = a.getString(3);
                    com.tencent.mm.modelsearch.p.h hVar = (com.tencent.mm.modelsearch.p.h) hashMap.get(string);
                    if (hVar != null) {
                        com.tencent.mm.modelsearch.p.h a2;
                        if (hVar.timestamp < a.getLong(4)) {
                            a2 = new com.tencent.mm.modelsearch.q.b().a(a, e, false);
                            a2.userData = hVar.userData;
                            hashMap.put(string, a2);
                        } else {
                            a2 = hVar;
                        }
                        a2.userData = Integer.valueOf(((Integer) a2.userData).intValue() + 1);
                    } else {
                        com.tencent.mm.modelsearch.q.b a3 = new com.tencent.mm.modelsearch.q.b().a(a, e, false);
                        a3.userData = Integer.valueOf(1);
                        hashMap.put(string, a3);
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
            List<com.tencent.mm.modelsearch.p.h> arrayList = new ArrayList(hashMap.values());
            if (this.cUU != null) {
                Collections.sort(arrayList, this.cUU);
            }
            return arrayList;
        }

        protected final String getName() {
            return "SearchGroupedMessageTask";
        }

        public final int getId() {
            return 13;
        }
    }

    private class i extends com.tencent.mm.modelsearch.a.a {
        private String bdo;
        final /* synthetic */ f iFV;

        i(f fVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iFV = fVar;
            super(jVar.bkC, 0, jVar.cUR, jVar.cUP, jVar.handler);
            this.bdo = jVar.bdo;
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            int[] e = FTSUtils.e(strArr);
            Cursor a = this.iFV.iFO.a(strArr, com.tencent.mm.modelsearch.d.cVi, this.bdo, true);
            List<com.tencent.mm.modelsearch.p.h> arrayList = new ArrayList();
            HashSet hashSet2 = new HashSet();
            while (a.moveToNext()) {
                if (hashSet2.add(new Pair(Long.valueOf(a.getLong(2)), Long.valueOf(a.getLong(4))))) {
                    arrayList.add(new com.tencent.mm.modelsearch.q.b().a(a, e, false));
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Collections.sort(arrayList, new Comparator<com.tencent.mm.modelsearch.p.h>(this) {
                final /* synthetic */ i iGf;

                {
                    this.iGf = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    com.tencent.mm.modelsearch.p.h hVar = (com.tencent.mm.modelsearch.p.h) obj;
                    com.tencent.mm.modelsearch.p.h hVar2 = (com.tencent.mm.modelsearch.p.h) obj2;
                    if (hVar2.timestamp < hVar.timestamp) {
                        return -1;
                    }
                    return hVar2.timestamp == hVar.timestamp ? 0 : 1;
                }
            });
            return arrayList;
        }

        protected final String getName() {
            return "SearchTalkerMessageTask";
        }

        public final String toString() {
            return String.format("%s[%s, %s] %d", new Object[]{"SearchTalkerMessageTask", this.bdo, this.bkC, Integer.valueOf(this.cUT)});
        }

        public final int getId() {
            return 14;
        }
    }

    private class j extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ f iFV;

        public j(f fVar, com.tencent.mm.modelsearch.p.j jVar) {
            this.iFV = fVar;
            super(jVar.bkC, jVar.cUS, jVar.cUR, jVar.cUP, jVar.handler);
        }

        protected final List<com.tencent.mm.modelsearch.p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            com.tencent.mm.modelsearch.b bVar = this.iFV.iFO;
            StringBuilder stringBuilder = new StringBuilder(32);
            for (String str : strArr) {
                stringBuilder.append('\"');
                stringBuilder.append(str);
                stringBuilder.append("*\" ");
            }
            String stringBuilder2 = stringBuilder.toString();
            Cursor rawQuery = bVar.cUY.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, content, count(aux_index) as msgCount FROM %s, %s WHERE content MATCH ? AND %s.docid = %s.docid AND type = ? AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i > 0 ? " LIMIT " + (i + 1) : "") + ";", new Object[]{bVar.Ia(), bVar.HZ(), bVar.Ia(), bVar.HZ()}), new String[]{stringBuilder2, "65536"});
            List linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.modelsearch.p.h hVar = new com.tencent.mm.modelsearch.p.h();
                hVar.type = rawQuery.getInt(0);
                hVar.cWt = rawQuery.getInt(1);
                hVar.cWu = rawQuery.getLong(2);
                hVar.cWv = rawQuery.getString(3);
                hVar.timestamp = rawQuery.getLong(4);
                hVar.content = rawQuery.getString(5);
                hVar.userData = Integer.valueOf(rawQuery.getInt(6));
                linkedList.add(hVar);
            }
            rawQuery.close();
            return linkedList;
        }

        protected final String getName() {
            return "SearchTopGroupMessageTask";
        }

        public final int getId() {
            return 15;
        }
    }

    static /* synthetic */ String aA(String str, String str2) {
        if (m.dE(str)) {
            str2 = aw.fM(str2);
        }
        com.tencent.mm.bf.g.buU();
        return com.tencent.mm.bf.g.dH(str2, "​");
    }

    public final com.tencent.mm.modelsearch.r.a b(com.tencent.mm.modelsearch.p.j jVar) {
        com.tencent.mm.modelsearch.r.a hVar;
        if (i.aMj().searchMode == 2) {
            hVar = new h(this, jVar);
        } else {
            hVar = new j(this, jVar);
        }
        return this.cWq.a(-65536, hVar);
    }

    public final com.tencent.mm.modelsearch.r.a e(com.tencent.mm.modelsearch.p.j jVar) {
        com.tencent.mm.modelsearch.a.a iVar = new i(this, jVar);
        iVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, iVar);
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchMessageLogic", "Create Success!");
            this.iFO = (com.tencent.mm.plugin.search.a.b.c) p.gd(4);
            this.cWq = p.It();
            ak.yW();
            this.iEs = com.tencent.mm.model.c.wF();
            this.cWq.a(65575, new b(this));
            this.cWq.a(Integer.MAX_VALUE, new f());
            com.tencent.mm.sdk.c.a.nhr.e(this.iFT);
            com.tencent.mm.sdk.c.a.nhr.e(this.iFS);
            com.tencent.mm.sdk.c.a.nhr.e(this.iFR);
            com.tencent.mm.sdk.c.a.nhr.e(this.iFQ);
            ak.yW();
            com.tencent.mm.model.c.wJ().c(this);
            ak.yW();
            com.tencent.mm.model.c.wJ().a(this, null);
            this.iFO.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchMessageLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFT);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFS);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFR);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFQ);
        return true;
    }

    public final String getName() {
        return "SearchMessageLogic";
    }

    public final void a(au auVar, com.tencent.mm.storage.au.c cVar) {
        if (cVar.nws.equals("insert")) {
            this.cWq.a(65576, new g(this, cVar.nwt));
        }
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0) {
            if (split[0].equals("delete_id")) {
                this.cWq.a(65576, new d(this, be.getLong(split[1], 0)));
            } else if (split[0].equals("delete_talker")) {
                this.cWq.a(65576, new e(this, split[1]));
            } else if (split[0].equals("delete_all") && split[1].equals("message")) {
                this.cWq.a(65576, new c());
            }
        }
    }
}
