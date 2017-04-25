package com.tencent.mm.plugin.appbrand.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.k;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.t.h;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c extends g {
    public static final String[] dBH = new String[]{f.a(d.cxi, "AppBrandLauncherLayoutItem")};
    private final e dBI;
    public final com.tencent.mm.av.a<b> dBJ = new com.tencent.mm.av.a();
    private final com.tencent.mm.av.a.a<b> dBK = new com.tencent.mm.av.a.a<b>(this) {
        final /* synthetic */ c dBO;

        {
            this.dBO = r1;
        }

        public final /* synthetic */ void an(Object obj) {
            b bVar = (b) obj;
            if (bVar != null) {
                bVar.Pr();
            }
        }
    };
    public final com.tencent.mm.av.a<a> dBL = new com.tencent.mm.av.a();
    private final com.tencent.mm.av.a.a<a> dBM = new com.tencent.mm.av.a.a<a>(this) {
        final /* synthetic */ c dBO;

        {
            this.dBO = r1;
        }

        public final /* synthetic */ void an(Object obj) {
            a aVar = (a) obj;
            if (aVar != null) {
                aVar.Pr();
            }
        }
    };
    public final ArrayList<b> dBN = new ArrayList();
    public final com.tencent.mm.bg.g dBf;

    private interface c {
        void Pr();
    }

    private static final class e extends f<d> {
        e(com.tencent.mm.sdk.h.d dVar) {
            super(dVar, d.cxi, "AppBrandLauncherLayoutItem", d.btd);
        }
    }

    public interface a extends c {
    }

    public interface b extends c {
    }

    static final class d extends k {
        static final com.tencent.mm.sdk.h.c.a cxi;
        static final String[] dBQ = new String[]{"brandId", "versionType", "scene"};

        d() {
        }

        protected final com.tencent.mm.sdk.h.c.a tl() {
            return cxi;
        }

        public final ContentValues py() {
            this.nmb = 0;
            ContentValues py = super.py();
            int q = c.p(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = q;
            py.put("recordId", Integer.valueOf(q));
            return py;
        }

        static {
            com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
            aVar.ddU = new Field[5];
            aVar.bXK = new String[6];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.bXK[0] = "recordId";
            aVar.nmd.put("recordId", "INTEGER PRIMARY KEY ");
            stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
            stringBuilder.append(", ");
            aVar.nmc = "recordId";
            aVar.bXK[1] = "brandId";
            aVar.nmd.put("brandId", "TEXT");
            stringBuilder.append(" brandId TEXT");
            stringBuilder.append(", ");
            aVar.bXK[2] = "versionType";
            aVar.nmd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.bXK[3] = "updateTime";
            aVar.nmd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            aVar.bXK[4] = "scene";
            aVar.nmd.put("scene", "INTEGER");
            stringBuilder.append(" scene INTEGER");
            aVar.bXK[5] = "rowid";
            aVar.nme = stringBuilder.toString();
            cxi = aVar;
        }
    }

    public c(com.tencent.mm.bg.g gVar) {
        this.dBf = gVar;
        this.dBI = new e(gVar);
        Pp();
    }

    private void gZ(int i) {
        switch (i) {
            case 1:
                this.dBL.a(this.dBM);
                return;
            case 2:
                this.dBJ.a(this.dBK);
                return;
            default:
                return;
        }
    }

    public static boolean Pn() {
        return false;
    }

    private Cursor a(String[] strArr, int i, int i2) {
        return this.dBf.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
    }

    public final ArrayList<b> WG() {
        Cursor a = a(null, 200, 0);
        if (a == null) {
            return null;
        }
        final ArrayList<b> arrayList = new ArrayList(Math.max(0, a.getCount()));
        d dVar = new d();
        if (a.moveToFirst()) {
            do {
                dVar.b(a);
                if (!be.kS(dVar.field_brandId)) {
                    String str;
                    String str2;
                    String str3;
                    h c = com.tencent.mm.plugin.appbrand.a.a.OO().c(dVar.field_brandId, new String[]{"appId", "appName", "appIcon", "BigHeadImgUrl"});
                    int i = dVar.field_recordId;
                    String str4 = dVar.field_brandId;
                    if (c == null) {
                        str = "";
                    } else {
                        str = c.field_appId;
                    }
                    if (c == null) {
                        str2 = "";
                    } else {
                        str2 = c.field_appName;
                    }
                    if (c == null) {
                        str3 = "";
                    } else {
                        str3 = c.field_appIcon;
                    }
                    int i2 = dVar.field_versionType;
                    String str5 = dVar.field_brandId;
                    int i3 = dVar.field_versionType;
                    arrayList.add(new b(i, str4, str, str2, str3, i2, false, com.tencent.mm.plugin.appbrand.a.a.OO().nf(dVar.field_brandId)));
                }
            } while (a.moveToNext());
        }
        a.close();
        ad.o(new Runnable(this) {
            final /* synthetic */ c dBO;

            public final void run() {
                this.dBO.dBN.clear();
                this.dBO.dBN.addAll(arrayList);
            }
        });
        return arrayList;
    }

    public final b Rl(String str) {
        b bVar = null;
        if (!be.kS(str)) {
            Cursor query = this.dBf.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    d dVar = new d();
                    dVar.b(query);
                    if (!be.kS(dVar.field_brandId)) {
                        String str2;
                        String str3;
                        String str4;
                        h c = com.tencent.mm.plugin.appbrand.a.a.OO().c(dVar.field_brandId, new String[]{"appId", "appName", "appIcon", "BigHeadImgUrl"});
                        int i = dVar.field_recordId;
                        String str5 = dVar.field_brandId;
                        if (c == null) {
                            str2 = "";
                        } else {
                            str2 = c.field_appId;
                        }
                        if (c == null) {
                            str3 = "";
                        } else {
                            str3 = c.field_appName;
                        }
                        if (c == null) {
                            str4 = "";
                        } else {
                            str4 = c.field_appIcon;
                        }
                        int i2 = dVar.field_versionType;
                        String str6 = dVar.field_brandId;
                        int i3 = dVar.field_versionType;
                        bVar = new b(i, str5, str2, str3, str4, i2, false, com.tencent.mm.plugin.appbrand.a.a.OO().nf(dVar.field_brandId));
                    }
                }
                query.close();
            }
        }
        return bVar;
    }

    public final List<String> tq(String str) {
        List<String> linkedList = new LinkedList();
        if (!be.kS(str)) {
            Cursor query = this.dBf.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        return linkedList;
    }

    public final boolean a(String str, int i, int i2, boolean z, boolean z2, int i3) {
        if (be.kS(str) || 999 == i) {
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor rawQuery = this.dBf.rawQuery(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{String.valueOf(i2)});
        if (rawQuery == null) {
            j = 0;
        } else {
            j = 0;
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
        }
        long max = Math.max(j + 1, be.Nh());
        int p = p(str, i, i2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.dBf.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(p)}) > 0 ? 1 : null;
        if (obj != null) {
            a("single", 3, String.valueOf(p));
        }
        if (obj == null) {
            d dVar = new d();
            dVar.field_updateTime = max;
            dVar.field_scene = i2;
            dVar.field_brandId = str;
            dVar.field_versionType = i;
            boolean a = a(dVar);
            if (a) {
                a("single", 2, String.valueOf(p));
            }
            z3 = a;
            z4 = a;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4) {
            d.a(str, i, i2, 1, z2, i3);
        }
        if (z4) {
            gZ(i2);
        }
        if (z3) {
            SP();
        }
        return z4;
    }

    private void SP() {
        int i;
        int i2 = 0;
        Cursor rawQuery = this.dBf.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"});
        if (rawQuery == null) {
            i = 0;
        } else {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            } else {
                i = 0;
            }
            rawQuery.close();
        }
        if (i > 200) {
            rawQuery = a(new String[]{"recordId", "brandId", "versionType"}, Integer.MAX_VALUE, 200);
            if (rawQuery != null) {
                List<String> linkedList = new LinkedList();
                List arrayList = new ArrayList(i - 200);
                List arrayList2 = new ArrayList(i - 200);
                if (rawQuery.moveToFirst()) {
                    do {
                        linkedList.add(String.valueOf(rawQuery.getInt(0)));
                        arrayList.add(rawQuery.getString(1));
                        arrayList2.add(Integer.valueOf(rawQuery.getInt(2)));
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
                if (!be.bP(linkedList)) {
                    String nd;
                    long er = this.dBf.er(Thread.currentThread().getId());
                    for (String nd2 : linkedList) {
                        this.dBf.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{nd2});
                    }
                    this.dBf.es(er);
                    List arrayList3 = new ArrayList(arrayList.size());
                    List arrayList4 = new ArrayList(arrayList.size());
                    while (i2 < arrayList.size()) {
                        nd2 = com.tencent.mm.plugin.appbrand.a.a.OO().nd((String) arrayList.get(i2));
                        if (!be.kS(nd2)) {
                            arrayList3.add(nd2);
                            arrayList4.add(arrayList2.get(i2));
                        }
                        i2++;
                    }
                    if (com.tencent.mm.plugin.appbrand.a.a.dzP != null) {
                        com.tencent.mm.plugin.appbrand.a.a.dzP.d(arrayList3, arrayList4);
                    }
                    a("batch", 5, linkedList);
                }
            }
        }
    }

    public final boolean o(String str, int i, int i2) {
        boolean z = true;
        if (be.kS(str)) {
            return false;
        }
        if (this.dBf.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(p(str, i, i2))}) < 0) {
            z = false;
        }
        if (z) {
            d.a(str, i, i2, 2, false, BaseReportManager.MAX_READ_COUNT);
            gZ(i2);
        }
        return z;
    }

    public final boolean a(String str, int i, boolean z, int i2) {
        boolean a = a(str, i, 2, true, z, i2);
        if (a && ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nsZ, Boolean.valueOf(true));
        }
        return a;
    }

    static void Po() {
    }

    final void R(List<bjd> list) {
        d dVar = new d();
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (bjd com_tencent_mm_protocal_c_bjd : list) {
            if (!be.kS(com_tencent_mm_protocal_c_bjd.username)) {
                dVar.field_brandId = com_tencent_mm_protocal_c_bjd.username;
                dVar.field_versionType = com_tencent_mm_protocal_c_bjd.mXr;
                dVar.field_scene = 2;
                dVar.field_updateTime = (long) com_tencent_mm_protocal_c_bjd.mlC;
                boolean a = a(dVar);
                if (a) {
                    linkedList.add(String.valueOf(dVar.field_recordId));
                }
                if (!a) {
                    this.dBI.b(dVar, new String[0]);
                    dVar.field_updateTime = Math.max((long) com_tencent_mm_protocal_c_bjd.mlC, dVar.field_updateTime);
                    if (this.dBI.a(dVar, new String[0])) {
                        linkedList2.add(String.valueOf(dVar.field_recordId));
                    }
                }
            }
        }
        if (!be.bP(linkedList)) {
            a("batch", 2, linkedList);
        }
        if (!be.bP(linkedList2)) {
            a("batch", 3, linkedList2);
        }
    }

    public final boolean Pp() {
        if (!ak.uz()) {
            return false;
        }
        if (!be.bP(this.dBN)) {
            return true;
        }
        ak.yW();
        return ((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nsZ, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean Pq() {
        return false;
    }

    private boolean a(d dVar) {
        if (be.kS(dVar.field_brandId)) {
            return false;
        }
        long insert = this.dBf.insert("AppBrandLauncherLayoutItem", "", dVar.py());
        if (insert > 0 || insert == ((long) dVar.field_recordId)) {
            return true;
        }
        return false;
    }

    public static int p(String str, int i, int i2) {
        return String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
    }
}
