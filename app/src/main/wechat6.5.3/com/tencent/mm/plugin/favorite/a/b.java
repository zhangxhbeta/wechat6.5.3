package com.tencent.mm.plugin.favorite.a;

import android.database.Cursor;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.j;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.modelsearch.a {
    r cWq;
    a fKu;
    com.tencent.mm.sdk.h.d fKv;
    com.tencent.mm.sdk.h.g.a fKw = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ b fKx;

        {
            this.fKx = r1;
        }

        public final void a(String str, i iVar) {
            v.i("MicroMsg.FTS.SearchFavoriteLogic", "EventData: %s", new Object[]{iVar});
            if (iVar != null) {
                int i = iVar.nmq;
                if (iVar.obj != null) {
                    long longValue = ((Long) iVar.obj).longValue();
                    if (longValue >= 0) {
                        switch (i) {
                            case 2:
                            case 3:
                                this.fKx.cWq.a(65576, new e(longValue));
                                return;
                            case 5:
                                this.fKx.cWq.a(65576, new b(this.fKx, longValue));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    };

    private class a extends com.tencent.mm.modelsearch.r.a {
        private int fKA;
        private int fKB;
        final /* synthetic */ b fKx;
        private HashSet<Long> fKy;
        private int fKz;
        private int mFailedCount;

        private a(b bVar) {
            this.fKx = bVar;
            this.fKy = null;
            this.fKz = 0;
            this.fKA = 0;
            this.fKB = 0;
            this.mFailedCount = 0;
        }

        public final boolean execute() {
            Exception e;
            Throwable th;
            int i;
            if (this.fKx.fKv == null) {
                v.w("MicroMsg.FTS.SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
            } else {
                v.i("MicroMsg.FTS.SearchFavoriteLogic", "start to build favorite index!");
                if (this.fKy == null) {
                    this.fKy = new HashSet();
                    Cursor a;
                    try {
                        a = this.fKx.fKu.a(com.tencent.mm.modelsearch.d.cVj, false, true, false, false, false);
                        while (a.moveToNext()) {
                            try {
                                this.fKy.add(Long.valueOf(a.getLong(0)));
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                        this.fKz = this.fKy.size();
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        a = null;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                Cursor rawQuery = this.fKx.fKv.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
                int i2 = 50;
                while (rawQuery.moveToNext()) {
                    if (Thread.interrupted()) {
                        this.fKx.fKu.commit();
                        throw new InterruptedException();
                    }
                    c cVar = new c();
                    cVar.b(rawQuery);
                    if (!this.fKy.remove(Long.valueOf(cVar.cLu))) {
                        if (i2 >= 50) {
                            this.fKx.fKu.commit();
                            this.fKx.fKu.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        try {
                            i += b.a(this.fKx, cVar);
                            this.fKA++;
                            i2 = i;
                        } catch (Throwable th4) {
                            try {
                                v.a("MicroMsg.FTS.SearchFavoriteLogic", th4, "Build favorite index failed with exception.\n", new Object[0]);
                                this.mFailedCount++;
                                i2 = i;
                            } catch (Exception e4) {
                                throw e4;
                            } catch (Throwable th5) {
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                            }
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                this.fKx.fKu.commit();
                Iterator it = this.fKy.iterator();
                while (it.hasNext()) {
                    if (Thread.interrupted()) {
                        this.fKx.fKu.commit();
                        throw new InterruptedException();
                    }
                    if (i2 >= 50) {
                        this.fKx.fKu.commit();
                        this.fKx.fKu.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    this.fKx.fKu.a(com.tencent.mm.modelsearch.d.cVj, ((Long) it.next()).longValue());
                    i2 = i + 1;
                    this.fKB++;
                    it.remove();
                }
                this.fKx.fKu.commit();
                v.i("MicroMsg.FTS.SearchFavoriteLogic", toString());
            }
            return true;
        }

        public final String toString() {
            return "BuildFavoriteIndex [new: " + this.fKA + ", exist: " + this.fKz + ", removed: " + this.fKB + ", failed: " + this.mFailedCount + "]";
        }

        public final int getId() {
            return 6;
        }
    }

    private class b extends com.tencent.mm.modelsearch.r.a {
        private long fKC;
        final /* synthetic */ b fKx;

        public b(b bVar, long j) {
            this.fKx = bVar;
            this.fKC = j;
        }

        public final boolean execute() {
            v.d("MicroMsg.FTS.SearchFavoriteLogic", "start to delete favorite item");
            this.fKx.fKu.a(com.tencent.mm.modelsearch.d.cVj, this.fKC);
            v.i("MicroMsg.FTS.SearchFavoriteLogic", toString());
            return true;
        }

        public final String toString() {
            return "DeleteFavItemTask id=" + this.fKC;
        }
    }

    private class c {
        String bhM;
        qf bmi;
        long cLu;
        long eBD;
        qn fKD;
        final /* synthetic */ b fKx;
        int type;

        private c(b bVar) {
            this.fKx = bVar;
        }

        public final void b(Cursor cursor) {
            this.cLu = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.eBD = cursor.getLong(2);
            this.bhM = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                v.d("MicroMsg.FTS.SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.bmi = new qf();
            } else {
                this.bmi = (qf) new qf().az(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.fKD = null;
            } else {
                this.fKD = (qn) new qn().az(blob);
            }
        }
    }

    private class d extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ b fKx;

        private d(b bVar) {
            this.fKx = bVar;
        }

        public final boolean execute() {
            h.alu().c(this.fKx.fKw);
            this.fKx.fKv = h.alu().cie;
            this.fKx.cWq.a(131122, new a());
            return true;
        }
    }

    private class e extends com.tencent.mm.modelsearch.r.a {
        private long fKC;
        private int fKE;
        final /* synthetic */ b fKx;

        private e(b bVar, long j) {
            this.fKx = bVar;
            this.fKC = j;
        }

        public final boolean execute() {
            if (this.fKx.fKv == null) {
                v.e("MicroMsg.FTS.SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
            } else {
                v.d("MicroMsg.FTS.SearchFavoriteLogic", "start to insert favorite item");
                Cursor rawQuery = this.fKx.fKv.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.fKC)});
                try {
                    if (rawQuery.moveToFirst()) {
                        c cVar = new c();
                        cVar.b(rawQuery);
                        this.fKx.fKu.beginTransaction();
                        this.fKx.fKu.a(com.tencent.mm.modelsearch.d.cVj, this.fKC);
                        this.fKE = b.a(this.fKx, cVar);
                        this.fKx.fKu.commit();
                        v.i("MicroMsg.FTS.SearchFavoriteLogic", toString());
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }

        public final String toString() {
            return "InsertFavItemTask local id is " + this.fKC + " transactionCount: " + this.fKE;
        }
    }

    private class f extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ b fKx;

        f(b bVar, j jVar) {
            this.fKx = bVar;
            super(jVar.bkC, 0, jVar.cUR, jVar.cUP, jVar.handler);
        }

        protected final List<p.h> a(String[] strArr, HashSet<String> hashSet, int i) {
            int[] e = FTSUtils.e(strArr);
            HashMap hashMap = new HashMap();
            Cursor a = this.fKx.fKu.a(strArr, com.tencent.mm.modelsearch.d.cVj);
            while (a.moveToNext()) {
                try {
                    com.tencent.mm.modelsearch.q.b a2 = new com.tencent.mm.modelsearch.q.b().a(a, e, true);
                    p.h hVar = (p.h) hashMap.get(Long.valueOf(a2.cWu));
                    if (hVar == null || FTSUtils.b(com.tencent.mm.modelsearch.d.cVA, a2.cWt, hVar.cWt) < 0) {
                        hashMap.put(Long.valueOf(a2.cWu), a2);
                    }
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            List<p.h> arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.modelsearch.q.b bVar : hashMap.values()) {
                if (bVar.cWt == 7) {
                    bVar.j(com.tencent.mm.modelsearch.d.cVy);
                }
                arrayList.add(bVar);
            }
            if (this.cUU != null) {
                Collections.sort(arrayList, this.cUU);
            }
            return arrayList;
        }

        protected final String getName() {
            return "SearchFavoriteTask";
        }

        public final int getId() {
            return 9;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int a(com.tencent.mm.plugin.favorite.a.b r26, com.tencent.mm.plugin.favorite.a.b.c r27) {
        /*
        r0 = r27;
        r6 = r0.cLu;
        r0 = r27;
        r0 = r0.type;
        r21 = r0;
        r0 = r27;
        r8 = r0.eBD;
        r0 = r27;
        r10 = r0.bhM;
        r0 = r27;
        r0 = r0.bmi;
        r22 = r0;
        r0 = r27;
        r2 = r0.fKD;
        r12 = 0;
        r0 = r21;
        r1 = r22;
        r23 = com.tencent.mm.pluginsdk.model.c.a(r0, r1, r2);
        if (r23 != 0) goto L_0x0032;
    L_0x0027:
        r2 = "MicroMsg.FTS.SearchFavoriteLogic";
        r3 = "Fav info is null";
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r3 = 0;
    L_0x0031:
        return r3;
    L_0x0032:
        com.tencent.mm.model.ak.yW();
        r16 = com.tencent.mm.model.c.wH();
        r0 = r23;
        r3 = r0.mtF;
        r0 = r23;
        r2 = r0.bhM;
        if (r3 == 0) goto L_0x004f;
    L_0x0043:
        r4 = r3.length();
        if (r4 == 0) goto L_0x004f;
    L_0x0049:
        r4 = r3.equals(r2);
        if (r4 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r23;
        r3 = r0.bhM;
        r2 = 0;
    L_0x0054:
        r0 = r23;
        r0 = r0.aWH;
        r17 = r0;
        r4 = 3;
        r4 = new java.lang.String[r4];
        r5 = 3;
        r5 = new int[r5];
        if (r3 == 0) goto L_0x00d8;
    L_0x0062:
        r11 = r3.length();
        if (r11 <= 0) goto L_0x00d8;
    L_0x0068:
        r0 = r16;
        r13 = r0.LX(r3);
        if (r13 == 0) goto L_0x00d8;
    L_0x0070:
        r14 = r13.field_nickname;
        r11 = r13.pF();
        r12 = r13.pE();
        r15 = r13.field_conRemark;
        r3 = r13.field_conRemarkPYFull;
        r13 = r13.field_conRemarkPYShort;
        if (r15 == 0) goto L_0x0088;
    L_0x0082:
        r18 = r15.length();
        if (r18 != 0) goto L_0x038d;
    L_0x0088:
        r15 = 0;
        r13 = 0;
        r3 = 0;
        r24 = r11;
        r11 = r3;
        r3 = r24;
        r25 = r13;
        r13 = r15;
        r15 = r14;
        r14 = r12;
        r12 = r25;
    L_0x0097:
        r18 = 0;
        r4[r18] = r15;
        r15 = 1;
        r4[r15] = r3;
        r3 = 2;
        r4[r3] = r14;
        r3 = 0;
        r14 = 9;
        r5[r3] = r14;
        r3 = 1;
        r14 = 10;
        r5[r3] = r14;
        r3 = 2;
        r14 = 11;
        r5[r3] = r14;
        r3 = r26;
        r3 = r3.a(r4, r5, r6, r8, r10);
        r14 = r3 + 0;
        r3 = 0;
        r4[r3] = r13;
        r3 = 1;
        r4[r3] = r12;
        r3 = 2;
        r4[r3] = r11;
        r3 = 0;
        r11 = 12;
        r5[r3] = r11;
        r3 = 1;
        r11 = 13;
        r5[r3] = r11;
        r3 = 2;
        r11 = 14;
        r5[r3] = r11;
        r3 = r26;
        r3 = r3.a(r4, r5, r6, r8, r10);
        r12 = r14 + r3;
    L_0x00d8:
        if (r2 == 0) goto L_0x011b;
    L_0x00da:
        r3 = r2.length();
        if (r3 <= 0) goto L_0x011b;
    L_0x00e0:
        r0 = r16;
        r2 = r0.LX(r2);
        if (r2 == 0) goto L_0x011b;
    L_0x00e8:
        r11 = r2.field_conRemark;
        if (r11 == 0) goto L_0x00f2;
    L_0x00ec:
        r3 = r11.length();
        if (r3 != 0) goto L_0x018a;
    L_0x00f2:
        r11 = r2.field_nickname;
        r3 = r2.pF();
        r2 = r2.pE();
    L_0x00fc:
        r13 = 0;
        r4[r13] = r11;
        r11 = 1;
        r4[r11] = r3;
        r3 = 2;
        r4[r3] = r2;
        r2 = 0;
        r3 = 16;
        r5[r2] = r3;
        r2 = 1;
        r3 = 17;
        r5[r2] = r3;
        r2 = 2;
        r3 = 18;
        r5[r2] = r3;
        r3 = r26;
        r2 = r3.a(r4, r5, r6, r8, r10);
        r12 = r12 + r2;
    L_0x011b:
        if (r17 == 0) goto L_0x038a;
    L_0x011d:
        r2 = r17.length();
        if (r2 <= 0) goto L_0x038a;
    L_0x0123:
        r2 = r16.LX(r17);
        if (r2 == 0) goto L_0x038a;
    L_0x0129:
        r11 = r2.field_conRemark;
        if (r11 == 0) goto L_0x0133;
    L_0x012d:
        r3 = r11.length();
        if (r3 != 0) goto L_0x0190;
    L_0x0133:
        r11 = r2.field_nickname;
        r3 = r2.pF();
        r2 = r2.pE();
    L_0x013d:
        r13 = 0;
        r4[r13] = r11;
        r11 = 1;
        r4[r11] = r3;
        r3 = 2;
        r4[r3] = r2;
        r2 = 0;
        r3 = 20;
        r5[r2] = r3;
        r2 = 1;
        r3 = 21;
        r5[r2] = r3;
        r2 = 2;
        r3 = 22;
        r5[r2] = r3;
        r3 = r26;
        r2 = r3.a(r4, r5, r6, r8, r10);
        r2 = r2 + r12;
        r3 = r2;
    L_0x015d:
        r0 = r23;
        r2 = r0.mtG;
        r4 = new java.lang.StringBuilder;
        r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r4.<init>(r5);
        r5 = r2.iterator();
    L_0x016c:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0195;
    L_0x0172:
        r2 = r5.next();
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x016c;
    L_0x017a:
        r11 = r2.length();
        if (r11 <= 0) goto L_0x016c;
    L_0x0180:
        r2 = r4.append(r2);
        r11 = 8203; // 0x200b float:1.1495E-41 double:4.053E-320;
        r2.append(r11);
        goto L_0x016c;
    L_0x018a:
        r3 = r2.field_conRemarkPYFull;
        r2 = r2.field_conRemarkPYShort;
        goto L_0x00fc;
    L_0x0190:
        r3 = r2.field_conRemarkPYFull;
        r2 = r2.field_conRemarkPYShort;
        goto L_0x013d;
    L_0x0195:
        r2 = r4.length();
        if (r2 <= 0) goto L_0x01b0;
    L_0x019b:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 7;
        r20 = r4.toString();
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
    L_0x01b0:
        switch(r21) {
            case 2: goto L_0x0361;
            case 5: goto L_0x0288;
            case 6: goto L_0x01ef;
            case 7: goto L_0x024c;
            case 14: goto L_0x02a7;
            default: goto L_0x01b3;
        };
    L_0x01b3:
        r0 = r23;
        r0 = r0.title;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x01d0;
    L_0x01bf:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 1;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
    L_0x01d0:
        r0 = r23;
        r0 = r0.desc;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0031;
    L_0x01dc:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 2;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x01ef:
        r0 = r22;
        r0 = r0.gxy;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0387;
    L_0x01fb:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 4;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r2 = r3 + 1;
    L_0x020c:
        r0 = r22;
        r3 = r0.mta;
        r0 = r3.bkV;
        r20 = r0;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r3 != 0) goto L_0x022b;
    L_0x021a:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 5;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r2 = r2 + 1;
    L_0x022b:
        r0 = r22;
        r3 = r0.mta;
        r0 = r3.label;
        r20 = r0;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r3 != 0) goto L_0x0384;
    L_0x0239:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 6;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r2 + 1;
        goto L_0x0031;
    L_0x024c:
        r0 = r23;
        r0 = r0.title;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0269;
    L_0x0258:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 1;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
    L_0x0269:
        r0 = r23;
        r0 = r0.desc;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0031;
    L_0x0275:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 3;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x0288:
        r0 = r23;
        r0 = r0.title;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0031;
    L_0x0294:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 1;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x02a7:
        r0 = r22;
        r2 = r0.mtR;
        if (r2 == 0) goto L_0x0031;
    L_0x02ad:
        r20 = "";
        r0 = r22;
        r2 = r0.mtR;
        r5 = r2.iterator();
    L_0x02b8:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x0339;
    L_0x02be:
        r2 = r5.next();
        r2 = (com.tencent.mm.protocal.c.pw) r2;
        r11 = r2.msM;
        r4 = "";
        r12 = r2.aKG;
        switch(r12) {
            case 1: goto L_0x02e1;
            case 2: goto L_0x02ce;
            case 3: goto L_0x02ce;
            case 4: goto L_0x02e8;
            case 5: goto L_0x02f5;
            case 6: goto L_0x0302;
            case 7: goto L_0x02ce;
            case 8: goto L_0x0332;
            case 9: goto L_0x02ce;
            case 10: goto L_0x031d;
            case 11: goto L_0x031d;
            default: goto L_0x02ce;
        };
    L_0x02ce:
        r2 = r11.title;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        r4 = r11.desc;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r2, r4);
    L_0x02da:
        r0 = r20;
        r20 = com.tencent.mm.pluginsdk.model.c.dg(r0, r2);
        goto L_0x02b8;
    L_0x02e1:
        r2 = r2.desc;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        goto L_0x02da;
    L_0x02e8:
        r2 = r11.mtg;
        if (r2 == 0) goto L_0x0381;
    L_0x02ec:
        r2 = r11.mtg;
        r2 = r2.title;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        goto L_0x02da;
    L_0x02f5:
        r2 = r11.mtc;
        if (r2 == 0) goto L_0x0381;
    L_0x02f9:
        r2 = r11.mtc;
        r2 = r2.title;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        goto L_0x02da;
    L_0x0302:
        r2 = r11.gxy;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        r4 = r11.mta;
        if (r4 == 0) goto L_0x02da;
    L_0x030c:
        r4 = r11.mta;
        r4 = r4.bkV;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r2, r4);
        r4 = r11.mta;
        r4 = r4.label;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r2, r4);
        goto L_0x02da;
    L_0x031d:
        r2 = r11.mte;
        if (r2 == 0) goto L_0x0381;
    L_0x0321:
        r2 = r11.mte;
        r2 = r2.title;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        r4 = r11.mte;
        r4 = r4.desc;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r2, r4);
        goto L_0x02da;
    L_0x0332:
        r2 = r11.title;
        r2 = com.tencent.mm.pluginsdk.model.c.dg(r4, r2);
        goto L_0x02da;
    L_0x0339:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0031;
    L_0x033f:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 1;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r2 = "MicroMsg.FTS.SearchFavoriteLogic";
        r4 = "Record Index String %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r20;
        com.tencent.mm.sdk.platformtools.v.d(r2, r4, r5);
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x0361:
        r0 = r23;
        r0 = r0.title;
        r20 = r0;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r20);
        if (r2 != 0) goto L_0x0031;
    L_0x036d:
        r0 = r26;
        r12 = r0.fKu;
        r13 = 196608; // 0x30000 float:2.75506E-40 double:9.71373E-319;
        r14 = 23;
        r15 = r6;
        r17 = r10;
        r18 = r8;
        r12.a(r13, r14, r15, r17, r18, r20);
        r3 = r3 + 1;
        goto L_0x0031;
    L_0x0381:
        r2 = r4;
        goto L_0x02da;
    L_0x0384:
        r3 = r2;
        goto L_0x0031;
    L_0x0387:
        r2 = r3;
        goto L_0x020c;
    L_0x038a:
        r3 = r12;
        goto L_0x015d;
    L_0x038d:
        r24 = r12;
        r12 = r11;
        r11 = r24;
        r25 = r14;
        r14 = r13;
        r13 = r25;
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.a.b.a(com.tencent.mm.plugin.favorite.a.b, com.tencent.mm.plugin.favorite.a.b$c):int");
    }

    public final com.tencent.mm.modelsearch.r.a b(j jVar) {
        com.tencent.mm.modelsearch.a.a fVar = new f(this, jVar);
        fVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, fVar);
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchFavoriteLogic", "Create Success!");
            this.cWq = p.It();
            this.fKu = (a) p.gd(256);
            this.cWq.a(-65536, new d());
            this.fKu.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchFavoriteLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        h.alu().d(this.fKw);
        return true;
    }

    public final String getName() {
        return "SearchFavoriteLogic";
    }

    private int a(String[] strArr, int[] iArr, long j, long j2, String str) {
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        if (str2 == null || str2.length() <= 0) {
            return 0;
        }
        String str5;
        String str6;
        String str7;
        if (str2.equalsIgnoreCase(str3)) {
            str5 = null;
            str6 = null;
        } else {
            str6 = str3;
            str5 = str4;
        }
        if (str6 == null || !str6.equalsIgnoreCase(str5)) {
            str7 = str5;
        } else {
            str7 = null;
        }
        this.fKu.a(196608, iArr[0], j, str, j2, str2);
        int i = 1;
        if (str6 != null && str6.length() > 0) {
            this.fKu.a(196608, iArr[1], j, str, j2, str6);
            i = 2;
        }
        if (str7 == null || str7.length() <= 0) {
            return i;
        }
        this.fKu.a(196608, iArr[2], j, str, j2, str7);
        return i + 1;
    }
}
