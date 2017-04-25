package com.tencent.mm.plugin.search.a;

import com.tencent.mm.al.j;
import com.tencent.mm.al.t;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.a.ps;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.d;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class e extends com.tencent.mm.modelsearch.a implements com.tencent.mm.v.e {
    private d iFJ;
    com.tencent.mm.plugin.search.a.b.b iFK;
    private c iFL = new c<ps>(this) {
        final /* synthetic */ e iFN;

        {
            this.iFN = r2;
            this.nhz = ps.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.iFN.aMh();
            return true;
        }
    };
    private c iFM = new c<fa>(this) {
        final /* synthetic */ e iFN;

        {
            this.iFN = r2;
            this.nhz = fa.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ak.vy().a(new j(((fa) bVar).bei.bej.gof, 18), 0);
            return false;
        }
    };

    private class b extends com.tencent.mm.modelsearch.r.a {
        final /* synthetic */ e iFN;
        private String path;

        public b(e eVar, String str) {
            this.iFN = eVar;
            this.path = str;
        }

        public final String toString() {
            return "UpdateFeatureIndex";
        }

        public final int getId() {
            return 5;
        }

        public final boolean execute() {
            String str = this.path;
            StringBuilder append = new StringBuilder().append(str);
            String str2 = "/feature/feature_%s.conf";
            Object[] objArr = new Object[1];
            String dJ = u.dJ(aa.getContext());
            dJ = dJ.equalsIgnoreCase("zh_CN") ? "zh_CN".toLowerCase() : (dJ.equalsIgnoreCase("zh_TW") || dJ.equalsIgnoreCase("zh_HK")) ? "zh_TW".toLowerCase() : "en".toLowerCase();
            objArr[0] = dJ;
            dJ = append.append(String.format(str2, objArr)).toString();
            int aQ = com.tencent.mm.a.e.aQ(dJ);
            List<b> arrayList = new ArrayList();
            if (aQ == 0) {
                e.aMi();
                throw new com.tencent.mm.plugin.search.a.a.a("data file no exist error");
            }
            b bVar = null;
            for (String str3 : new String(com.tencent.mm.a.e.d(dJ, 0, aQ)).split("\n")) {
                String str32;
                if (str32 != null) {
                    str32 = str32.trim();
                    if (str32.length() != 0) {
                        int indexOf = str32.indexOf("=");
                        if (indexOf >= 0) {
                            String substring = str32.substring(0, indexOf);
                            str32 = str32.substring(indexOf + 1);
                            if (substring.equals("FeatureID")) {
                                if (bVar != null) {
                                    bVar.field_iconPath = str + "/feature/" + bVar.field_featureId + ".png";
                                    arrayList.add(bVar);
                                }
                                bVar = new b();
                                bVar.field_featureId = Integer.valueOf(str32).intValue();
                            }
                            if (bVar != null) {
                                if (substring.equals("Title")) {
                                    bVar.field_title = str32;
                                } else if (substring.equals("TitlePY")) {
                                    bVar.field_titlePY = str32;
                                } else if (substring.equals("TitleShortPY")) {
                                    bVar.field_titleShortPY = str32;
                                } else if (substring.equals("Tag")) {
                                    bVar.field_tag = str32;
                                } else if (substring.equals("ActionType")) {
                                    if (str32.equals("H5")) {
                                        bVar.field_actionType = 2;
                                    } else if (str32.equals("Native")) {
                                        bVar.field_actionType = 1;
                                    }
                                } else if (substring.equals("Url")) {
                                    bVar.field_url = str32;
                                } else if (substring.equals("HelpUrl")) {
                                    bVar.field_helpUrl = str32;
                                } else if (substring.equals("UpdateUrl")) {
                                    bVar.field_updateUrl = str32;
                                } else if (substring.equals("AndroidUrl")) {
                                    bVar.field_androidUrl = str32;
                                }
                            }
                        }
                    }
                }
            }
            if (bVar != null) {
                bVar.field_iconPath = str + "/feature/" + bVar.field_featureId + ".png";
                arrayList.add(bVar);
            }
            if (arrayList.size() == 0) {
                e.aMi();
                throw new com.tencent.mm.plugin.search.a.a.a("no data error");
            }
            this.iFN.iFK.beginTransaction();
            this.iFN.iFK.bi(arrayList);
            this.iFN.iFK.commit();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            this.iFN.iFK.beginTransaction();
            this.iFN.iFK.g(d.cVk);
            this.iFN.iFK.f(d.cVk);
            for (b bVar2 : arrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                this.iFN.iFK.a(262144, 1, (long) bVar2.field_featureId, String.valueOf(bVar2.field_featureId), currentTimeMillis, bVar2.field_title, true);
                this.iFN.iFK.a(262144, 2, (long) bVar2.field_featureId, String.valueOf(bVar2.field_featureId), currentTimeMillis, bVar2.field_titlePY, true);
                this.iFN.iFK.a(262144, 3, (long) bVar2.field_featureId, String.valueOf(bVar2.field_featureId), currentTimeMillis, bVar2.field_titleShortPY, true);
                this.iFN.iFK.a(262144, 4, (long) bVar2.field_featureId, String.valueOf(bVar2.field_featureId), currentTimeMillis, bVar2.field_tag, true);
            }
            this.iFN.iFK.commit();
            v.d("MicroMsg.FTS.SearchFeatureLogic", "UpdateIndexTask %d", new Object[]{Integer.valueOf(arrayList.size())});
            return true;
        }
    }

    private class a extends com.tencent.mm.modelsearch.a.a {
        final /* synthetic */ e iFN;

        private a(e eVar, p.j jVar) {
            this.iFN = eVar;
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
            r3 = r8.iFN;
            r3 = r3.iFK;
            r4 = com.tencent.mm.modelsearch.d.cVk;
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
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.a.e.a.a(java.lang.String[], java.util.HashSet, int):java.util.List<com.tencent.mm.modelsearch.p$h>");
        }

        public final String toString() {
            return "SearchFeature(\"" + this.bkC + "\") [" + this.cUT + "]";
        }

        protected final String getName() {
            return "SearchFeatureTask";
        }

        public final int getId() {
            return 12;
        }
    }

    static /* synthetic */ void aMi() {
        String aN = t.HS().aN(0, 18);
        com.tencent.mm.a.e.e(new File(aN));
        com.tencent.mm.loader.stub.b.deleteFile(aN + ".zip");
        v.i("MicroMsg.FTS.SearchFeatureLogic", "delete unzipPath: %s", new Object[]{aN});
    }

    public final com.tencent.mm.modelsearch.r.a b(p.j jVar) {
        com.tencent.mm.modelsearch.a.a aVar = new a(jVar);
        aVar.cUU = jVar.cWO;
        return this.iFJ.a(-65536, aVar);
    }

    protected final boolean onCreate() {
        if (p.Iu()) {
            v.i("MicroMsg.FTS.SearchFeatureLogic", "Create Success!");
            this.iFJ = (d) p.It();
            this.iFK = (com.tencent.mm.plugin.search.a.b.b) p.gd(17);
            ak.vy().a(160, this);
            com.tencent.mm.sdk.c.a.nhr.e(this.iFL);
            com.tencent.mm.sdk.c.a.nhr.e(this.iFM);
            if (this.iFK.aP(-5, 2)) {
                aMh();
                this.iFK.f(-5, 2);
            }
            this.iFK.Ib();
            return true;
        }
        v.i("MicroMsg.FTS.SearchFeatureLogic", "Create Fail!");
        return false;
    }

    protected final boolean HX() {
        ak.vy().b(160, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFL);
        com.tencent.mm.sdk.c.a.nhr.f(this.iFM);
        return true;
    }

    public final String getName() {
        return "SearchFeatureLogic";
    }

    final void aMh() {
        if (t.HS().aK(0, 18) != null) {
            this.iFJ.a(65596, new b(this, t.HS().aN(0, 18)));
            return;
        }
        v.i("MicroMsg.FTS.SearchFeatureLogic", "updateLanguageListener check first setup app: pack info is null");
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (jVar.aZc != 18) {
                return;
            }
            if (i == 0 || i2 == 0) {
                aMh();
            } else {
                v.e("MicroMsg.FTS.SearchFeatureLogic", "onGYNetEnd id:" + jVar.cUo + " errtype:" + i + " errCode:" + i2 + " errMsg:" + str);
            }
        }
    }
}
