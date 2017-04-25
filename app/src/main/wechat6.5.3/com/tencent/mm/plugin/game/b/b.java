package com.tencent.mm.plugin.game.b;

import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.j;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends com.tencent.mm.modelsearch.a {
    r cWq;
    a ghh;
    private com.tencent.mm.sdk.h.g.a ghi = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ b ghj;

        {
            this.ghj = r1;
        }

        public final void a(String str, i iVar) {
            v.i("MicroMsg.FTS.SearchGameLogic", "appinfo storage change: event=%s | eventData=%s", new Object[]{str, iVar});
            switch (iVar.nmq) {
                case 2:
                case 3:
                    this.ghj.cWq.a(65606, new b(this.ghj, iVar.obj.toString()));
                    return;
                case 5:
                    this.ghj.cWq.a(65606, new a(this.ghj, iVar.obj.toString()));
                    return;
                default:
                    return;
            }
        }
    };

    class a extends com.tencent.mm.modelsearch.r.a {
        private String appId;
        final /* synthetic */ b ghj;

        public a(b bVar, String str) {
            this.ghj = bVar;
            this.appId = str;
        }

        public final boolean execute() {
            v.i("MicroMsg.FTS.SearchGameLogic", "delete app info appId=%s", new Object[]{this.appId});
            this.ghj.ghh.b(com.tencent.mm.modelsearch.d.cVl, this.appId);
            return true;
        }

        public final String toString() {
            return String.format("DeleteGame [%s]", new Object[]{this.appId});
        }
    }

    class b extends com.tencent.mm.modelsearch.r.a {
        private String appId;
        final /* synthetic */ b ghj;
        private String name;

        public b(b bVar, String str) {
            this.ghj = bVar;
            this.appId = str;
        }

        public final boolean execute() {
            f Gz = com.tencent.mm.pluginsdk.j.a.lxJ.bmv().Gz(this.appId);
            if (Gz != null && Gz.bnk()) {
                v.i("MicroMsg.FTS.SearchGameLogic", "insert app info appId=%s", new Object[]{this.appId});
                this.ghj.ghh.beginTransaction();
                this.ghj.ghh.b(com.tencent.mm.modelsearch.d.cVl, this.appId);
                this.ghj.ghh.a(327680, 1, 0, Gz.field_appId, System.currentTimeMillis(), Gz.field_appName);
                this.ghj.ghh.commit();
                this.name = Gz.field_appName;
            }
            return true;
        }

        public final String toString() {
            String str = "InsertGame [%s, %s]";
            Object[] objArr = new Object[2];
            objArr[0] = this.name == null ? "(skipped)" : this.name;
            objArr[1] = this.appId;
            return String.format(str, objArr);
        }
    }

    class d extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ b ghj;

        d(b bVar) {
            this.ghj = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            /*
            r12 = this;
            r11 = 0;
            r2 = 1;
            r0 = "MicroMsg.FTS.SearchGameLogic";
            r1 = "UpdateIndexTask";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r9 = new java.util.LinkedList;
            r9.<init>();
            r0 = com.tencent.mm.pluginsdk.j.a.lxJ;
            r0 = r0.bmv();
            r1 = r0.bnr();
            if (r1 != 0) goto L_0x0026;
        L_0x001c:
            r0 = "MicroMsg.FTS.SearchGameLogic";
            r1 = "Game cursor is null!";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        L_0x0025:
            return r2;
        L_0x0026:
            r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x008c }
            if (r0 == 0) goto L_0x003d;
        L_0x002c:
            r0 = new com.tencent.mm.pluginsdk.model.app.f;	 Catch:{ Throwable -> 0x008c }
            r0.<init>();	 Catch:{ Throwable -> 0x008c }
            r0.b(r1);	 Catch:{ Throwable -> 0x008c }
            r9.add(r0);	 Catch:{ Throwable -> 0x008c }
            r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x008c }
            if (r0 != 0) goto L_0x002c;
        L_0x003d:
            if (r1 == 0) goto L_0x0042;
        L_0x003f:
            r1.close();
        L_0x0042:
            r0 = r12.ghj;
            r0 = r0.ghh;
            r0.beginTransaction();
            r0 = r12.ghj;
            r0 = r0.ghh;
            r1 = com.tencent.mm.modelsearch.d.cVl;
            r0.g(r1);
            r0 = "MicroMsg.FTS.SearchGameLogic";
            r1 = "current list size: %d";
            r3 = new java.lang.Object[r2];
            r4 = r9.size();
            r4 = java.lang.Integer.valueOf(r4);
            r3[r11] = r4;
            com.tencent.mm.sdk.platformtools.v.i(r0, r1, r3);
            r10 = r9.iterator();
        L_0x006b:
            r0 = r10.hasNext();
            if (r0 == 0) goto L_0x0095;
        L_0x0071:
            r0 = r10.next();
            r8 = r0;
            r8 = (com.tencent.mm.pluginsdk.model.app.f) r8;
            r6 = java.lang.System.currentTimeMillis();
            r0 = r12.ghj;
            r0 = r0.ghh;
            r1 = 327680; // 0x50000 float:4.59177E-40 double:1.618954E-318;
            r3 = 0;
            r5 = r8.field_appId;
            r8 = r8.field_appName;
            r0.a(r1, r2, r3, r5, r6, r8);
            goto L_0x006b;
        L_0x008c:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception;
            if (r1 == 0) goto L_0x0094;
        L_0x0091:
            r1.close();
        L_0x0094:
            throw r0;
        L_0x0095:
            r0 = r12.ghj;
            r0 = r0.ghh;
            r0.commit();
            r0 = "MicroMsg.FTS.SearchGameLogic";
            r1 = "UpdateIndexTask %d";
            r3 = new java.lang.Object[r2];
            r4 = r9.size();
            r4 = java.lang.Integer.valueOf(r4);
            r3[r11] = r4;
            com.tencent.mm.sdk.platformtools.v.d(r0, r1, r3);
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.d.execute():boolean");
        }

        public final int getId() {
            return 7;
        }
    }

    class c extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ b ghj;

        c(b bVar, j jVar) {
            this.ghj = bVar;
            super(jVar.bkC, 0, jVar.cUR, jVar.cUP, jVar.handler);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.util.List<com.tencent.mm.modelsearch.p.h> a(java.lang.String[] r6, java.util.HashSet<java.lang.String> r7, int r8) {
            /*
            r5 = this;
            r0 = com.tencent.mm.modelsearch.FTSUtils.e(r6);
            r1 = new java.util.ArrayList;
            r1.<init>();
            r2 = r5.ghj;
            r2 = r2.ghh;
            r3 = com.tencent.mm.modelsearch.d.cVl;
            r2 = r2.a(r6, r3);
        L_0x0013:
            r3 = r2.moveToNext();	 Catch:{ Throwable -> 0x0026 }
            if (r3 == 0) goto L_0x002f;
        L_0x0019:
            r3 = new com.tencent.mm.modelsearch.q$b;	 Catch:{ Throwable -> 0x0026 }
            r3.<init>();	 Catch:{ Throwable -> 0x0026 }
            r4 = 0;
            r3.a(r2, r0, r4);	 Catch:{ Throwable -> 0x0026 }
            r1.add(r3);	 Catch:{ Throwable -> 0x0026 }
            goto L_0x0013;
        L_0x0026:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0028 }
        L_0x0028:
            r0 = move-exception;
            if (r2 == 0) goto L_0x002e;
        L_0x002b:
            r2.close();
        L_0x002e:
            throw r0;
        L_0x002f:
            if (r2 == 0) goto L_0x0034;
        L_0x0031:
            r2.close();
        L_0x0034:
            r0 = java.lang.Thread.interrupted();
            if (r0 == 0) goto L_0x0040;
        L_0x003a:
            r0 = new java.lang.InterruptedException;
            r0.<init>();
            throw r0;
        L_0x0040:
            r0 = r5.cUU;
            if (r0 == 0) goto L_0x0049;
        L_0x0044:
            r0 = r5.cUU;
            java.util.Collections.sort(r1, r0);
        L_0x0049:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.c.a(java.lang.String[], java.util.HashSet, int):java.util.List<com.tencent.mm.modelsearch.p$h>");
        }

        protected final String getName() {
            return "SearchGameTask";
        }

        public final int getId() {
            return 10;
        }
    }

    public final com.tencent.mm.modelsearch.r.a b(j jVar) {
        com.tencent.mm.modelsearch.a.a cVar = new c(this, jVar);
        cVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, cVar);
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchGameLogic", "Create Success!");
            this.ghh = (a) p.gd(16);
            this.cWq = p.It();
            this.cWq.a(65606, new d(this));
            com.tencent.mm.pluginsdk.j.a.lxJ.bmv().c(this.ghi);
            this.ghh.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        com.tencent.mm.pluginsdk.j.a.lxJ.bmv().d(this.ghi);
        return true;
    }

    public final String getName() {
        return "SearchGameLogic";
    }
}
