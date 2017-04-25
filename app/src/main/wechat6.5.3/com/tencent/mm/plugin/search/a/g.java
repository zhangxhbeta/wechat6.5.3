package com.tencent.mm.plugin.search.a;

import android.database.Cursor;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsearch.d;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.j;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class g extends com.tencent.mm.modelsearch.a {
    private r cWq;
    com.tencent.mm.modelsearch.a.a iGg;

    private class b extends com.tencent.mm.modelsearch.r.a {
        private String bkC;
        final /* synthetic */ g iGh;
        private h iGi;
        private int scene;

        private b(g gVar) {
            this.iGh = gVar;
        }

        public final boolean execute() {
            com.tencent.mm.modelsearch.b bVar = this.iGh.iGg;
            String str = this.bkC;
            h hVar = this.iGi;
            int i = this.scene;
            str = str.trim();
            boolean inTransaction = bVar.cUY.inTransaction();
            if (!inTransaction) {
                bVar.cUY.beginTransaction();
            }
            Object[] objArr = new Object[]{str, hVar.cWv, Integer.valueOf(i)};
            bVar.cUY.execSQL(String.format("UPDATE %s SET score=score+4 WHERE query=? AND aux_index=? AND scene=?;", new Object[]{bVar.HZ()}), objArr);
            if (((int) bVar.cWX.simpleQueryForLong()) == 0) {
                bVar.cWT.bindString(1, hVar.content);
                bVar.cWT.execute();
                String m = com.tencent.mm.a.g.m(hVar.content.getBytes());
                bVar.cWU.bindLong(1, (long) hVar.type);
                bVar.cWU.bindLong(2, (long) hVar.cWt);
                bVar.cWU.bindLong(3, hVar.cWu);
                bVar.cWU.bindString(4, hVar.cWv);
                bVar.cWU.bindLong(5, hVar.timestamp);
                bVar.cWU.bindString(6, str);
                bVar.cWU.bindLong(7, 4);
                bVar.cWU.bindLong(8, (long) i);
                bVar.cWU.bindString(9, m);
                bVar.cWU.execute();
            }
            str = str + '%';
            String format = String.format("DELETE FROM %s WHERE query LIKE ? AND score<=1;", new Object[]{bVar.HZ()});
            Object[] objArr2 = new Object[]{str};
            bVar.cUY.execSQL(format, objArr2);
            bVar.cUY.execSQL(String.format("UPDATE %s SET score=score-1 WHERE query LIKE ?;", new Object[]{bVar.HZ()}), objArr2);
            if (!inTransaction) {
                bVar.cUY.commit();
            }
            return true;
        }

        public final String toString() {
            return String.format("%s : query=%s scene=%d", new Object[]{"UpdateTopHitsWithQueryTask", this.bkC, Integer.valueOf(this.scene)});
        }
    }

    private class a extends com.tencent.mm.modelsearch.a.a {
        private int[] iFr;
        final /* synthetic */ g iGh;
        private int scene;

        public a(g gVar, j jVar) {
            this.iGh = gVar;
            super(jVar.bkC, jVar.cUS, jVar.cUR, jVar.cUP, jVar.handler);
            this.iFr = jVar.cWM;
            this.scene = jVar.scene;
        }

        protected final List<h> a(String[] strArr, HashSet<String> hashSet, int i) {
            int[] e = FTSUtils.e(strArr);
            HashSet hashSet2 = new HashSet();
            List linkedList = new LinkedList();
            Cursor a = this.iGh.iGg.a(this.bkC, strArr, this.iFr, this.scene, i + hashSet.size());
            while (a != null && a.moveToNext()) {
                com.tencent.mm.modelsearch.q.b a2 = new com.tencent.mm.modelsearch.q.b().a(a, e, true);
                if (!hashSet.contains(a2.cWv) && hashSet2.add(a2.cWv)) {
                    if (a2.type == 131075 && a2.cWt == 38) {
                        a2.j(d.cVv);
                    }
                    if (a2.type == 131072 && a2.cWt == 11) {
                        a2.j(d.cVx);
                    }
                    linkedList.add(a2);
                    if (linkedList.size() >= i) {
                        break;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            return linkedList;
        }

        protected final String getName() {
            return "SearchTopHitsTask";
        }

        public final int getId() {
            return 8;
        }
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchTopHitsLogic", "Create Success!");
            this.iGg = (com.tencent.mm.modelsearch.a.a) p.gd(1);
            this.cWq = p.It();
            this.iGg.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchTopHitsLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        return true;
    }

    public final com.tencent.mm.modelsearch.r.a a(j jVar) {
        return this.cWq.a(-65536, new a(this, jVar));
    }

    public final String getName() {
        return "SearchTopHitsLogic";
    }

    public final void a(String str, h hVar, int i) {
        b bVar = new b();
        bVar.bkC = str;
        bVar.iGi = hVar;
        bVar.scene = i;
        this.cWq.a(65557, bVar);
    }
}
