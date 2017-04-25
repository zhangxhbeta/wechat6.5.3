package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.j;
import com.tencent.mm.modelsearch.r;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class g extends com.tencent.mm.modelsearch.a {
    r cWq;
    private com.tencent.mm.sdk.h.g.a ghi = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ g owd;

        {
            this.owd = r1;
        }

        public final void a(String str, i iVar) {
            v.i("MicroMsg.FTS.SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[]{str, iVar});
            switch (iVar.nmq) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        this.owd.cWq.a(65616, new b(this.owd, iVar.obj.toString()));
                        return;
                    } else if (iVar.obj != null && (iVar.obj instanceof List)) {
                        for (String bVar : (List) iVar.obj) {
                            this.owd.cWq.a(65616, new b(this.owd, bVar));
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        this.owd.cWq.a(65616, new a(this.owd, iVar.obj.toString()));
                        return;
                    } else if (iVar.obj != null && (iVar.obj instanceof List)) {
                        for (String bVar2 : (List) iVar.obj) {
                            this.owd.cWq.a(65616, new a(this.owd, bVar2));
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    d owc;

    class a extends com.tencent.mm.modelsearch.r.a {
        private String id;
        final /* synthetic */ g owd;

        public a(g gVar, String str) {
            this.owd = gVar;
            this.id = str;
        }

        public final boolean execute() {
            v.i("MicroMsg.FTS.SearchWeAppLogic", "delete we app info id=%s", new Object[]{this.id});
            this.owd.owc.b(com.tencent.mm.modelsearch.d.ldi, this.id);
            return true;
        }

        public final String toString() {
            return String.format("DeleteWeApp [%s]", new Object[]{this.id});
        }
    }

    class b extends com.tencent.mm.modelsearch.r.a {
        private String id;
        private String name;
        final /* synthetic */ g owd;

        public b(g gVar, String str) {
            this.owd = gVar;
            this.id = str;
        }

        public final boolean execute() {
            com.tencent.mm.plugin.appbrand.b.b Rl = com.tencent.mm.plugin.appbrand.a.a.dzS.Rl(this.id);
            if (Rl == null) {
                return true;
            }
            v.i("MicroMsg.FTS.SearchWeAppLogic", "insert we app info id = %s", new Object[]{this.id});
            this.owd.owc.beginTransaction();
            this.owd.owc.b(com.tencent.mm.modelsearch.d.ldi, this.id);
            long currentTimeMillis = System.currentTimeMillis();
            this.owd.owc.a(393216, 1, (long) Rl.nAR, Rl.nAR, currentTimeMillis, Rl.appName);
            this.owd.owc.a(393216, 2, (long) Rl.nAR, Rl.nAR, currentTimeMillis, com.tencent.mm.platformtools.c.lT(Rl.appName));
            this.owd.owc.a(393216, 3, (long) Rl.nAR, Rl.nAR, currentTimeMillis, com.tencent.mm.platformtools.c.lU(Rl.appName));
            this.owd.owc.commit();
            this.name = Rl.appName;
            return true;
        }

        public final String toString() {
            String str = "InsertWeApp [%s, %s]";
            Object[] objArr = new Object[2];
            objArr[0] = this.name == null ? "(skipped)" : this.name;
            objArr[1] = this.id;
            return String.format(str, objArr);
        }
    }

    class d extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ g owd;

        d(g gVar) {
            this.owd = gVar;
        }

        public final boolean execute() {
            v.i("MicroMsg.FTS.SearchWeAppLogic", "UpdateIndexTask");
            List<com.tencent.mm.plugin.appbrand.b.b> WG = com.tencent.mm.plugin.appbrand.a.a.dzS.WG();
            if (WG == null || WG.isEmpty()) {
                v.i("MicroMsg.FTS.SearchWeAppLogic", "WeApp recent usage list is nil.");
                return true;
            }
            this.owd.owc.beginTransaction();
            this.owd.owc.g(com.tencent.mm.modelsearch.d.ldi);
            v.i("MicroMsg.FTS.SearchWeAppLogic", "current list size: %d", new Object[]{Integer.valueOf(WG.size())});
            for (com.tencent.mm.plugin.appbrand.b.b bVar : WG) {
                long currentTimeMillis = System.currentTimeMillis();
                this.owd.owc.a(393216, 1, (long) bVar.nAR, bVar.nAR, currentTimeMillis, bVar.appName);
                this.owd.owc.a(393216, 2, (long) bVar.nAR, bVar.nAR, currentTimeMillis, com.tencent.mm.platformtools.c.lT(bVar.appName));
                this.owd.owc.a(393216, 3, (long) bVar.nAR, bVar.nAR, currentTimeMillis, com.tencent.mm.platformtools.c.lU(bVar.appName));
            }
            this.owd.owc.commit();
            v.d("MicroMsg.FTS.SearchWeAppLogic", "UpdateIndexTask %d", new Object[]{Integer.valueOf(WG.size())});
            return true;
        }

        public final int getId() {
            return 21;
        }
    }

    class c extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ g owd;

        c(g gVar, j jVar) {
            this.owd = gVar;
            super(jVar.bkC, 0, jVar.cUR, jVar.cUP, jVar.handler);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.util.List<com.tencent.mm.modelsearch.p.h> a(java.lang.String[] r9, java.util.HashSet<java.lang.String> r10, int r11) {
            /*
            r8 = this;
            r0 = com.tencent.mm.modelsearch.FTSUtils.e(r9);
            r1 = new java.util.ArrayList;
            r1.<init>();
            r2 = new java.util.HashSet;
            r2.<init>();
            r3 = r8.owd;
            r3 = r3.owc;
            r4 = com.tencent.mm.modelsearch.d.ldi;
            r3 = r3.a(r9, r4);
        L_0x0018:
            r4 = r3.moveToNext();	 Catch:{ Throwable -> 0x0048 }
            if (r4 == 0) goto L_0x0051;
        L_0x001e:
            r4 = new com.tencent.mm.modelsearch.q$b;	 Catch:{ Throwable -> 0x0048 }
            r4.<init>();	 Catch:{ Throwable -> 0x0048 }
            r5 = 0;
            r4.a(r3, r0, r5);	 Catch:{ Throwable -> 0x0048 }
            r6 = r4.cWu;	 Catch:{ Throwable -> 0x0048 }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x0048 }
            r5 = r2.contains(r5);	 Catch:{ Throwable -> 0x0048 }
            if (r5 != 0) goto L_0x0018;
        L_0x0033:
            r5 = r4.cWv;	 Catch:{ Throwable -> 0x0048 }
            r5 = r10.contains(r5);	 Catch:{ Throwable -> 0x0048 }
            if (r5 != 0) goto L_0x0018;
        L_0x003b:
            r1.add(r4);	 Catch:{ Throwable -> 0x0048 }
            r4 = r4.cWu;	 Catch:{ Throwable -> 0x0048 }
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0048 }
            r2.add(r4);	 Catch:{ Throwable -> 0x0048 }
            goto L_0x0018;
        L_0x0048:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception;
            if (r3 == 0) goto L_0x0050;
        L_0x004d:
            r3.close();
        L_0x0050:
            throw r0;
        L_0x0051:
            if (r3 == 0) goto L_0x0056;
        L_0x0053:
            r3.close();
        L_0x0056:
            r0 = java.lang.Thread.interrupted();
            if (r0 == 0) goto L_0x0062;
        L_0x005c:
            r0 = new java.lang.InterruptedException;
            r0.<init>();
            throw r0;
        L_0x0062:
            r0 = r8.cUU;
            if (r0 == 0) goto L_0x006b;
        L_0x0066:
            r0 = r8.cUU;
            java.util.Collections.sort(r1, r0);
        L_0x006b:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.g.c.a(java.lang.String[], java.util.HashSet, int):java.util.List<com.tencent.mm.modelsearch.p$h>");
        }

        protected final String getName() {
            return "SearchWeAppTask";
        }

        public final int getId() {
            return 21;
        }
    }

    public final com.tencent.mm.modelsearch.r.a b(j jVar) {
        com.tencent.mm.modelsearch.a.a cVar = new c(this, jVar);
        cVar.cUU = jVar.cWO;
        return this.cWq.a(-65536, cVar);
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchWeAppLogic", "Create Success!");
            this.owc = (d) p.gd(512);
            this.cWq = p.It();
            this.cWq.a(65616, new d(this));
            com.tencent.mm.plugin.appbrand.a.a.dzS.c(this.ghi);
            this.owc.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchWeAppLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        com.tencent.mm.plugin.appbrand.a.a.dzS.d(this.ghi);
        return true;
    }

    public final String getName() {
        return "SearchWeAppLogic";
    }
}
