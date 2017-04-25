package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskManager;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class j {
    public static final Runnable dAW = new Runnable() {
        private static void Pk() {
            List list = null;
            l lVar = a.dzP;
            Cursor rawQuery = lVar.dBf.rawQuery(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null);
            List list2;
            if (rawQuery == null) {
                list2 = null;
            } else {
                list2 = new LinkedList();
                if (rawQuery.moveToFirst()) {
                    do {
                        list2.add(rawQuery.getString(0));
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            if (!be.bP(r0)) {
                list = new LinkedList();
                for (String m : r0) {
                    Collection m2 = lVar.m(m, 0, 2);
                    if (!be.bP(m2)) {
                        list.addAll(m2);
                    }
                }
            }
            if (!be.bP(r1)) {
                for (i iVar : r1) {
                    b.deleteFile(iVar.field_pkgPath);
                    lVar = a.dzP;
                    if (!be.kS(iVar.field_appId)) {
                        lVar.dBg.c(iVar, i.dAV);
                    }
                }
            }
        }

        private static void Pl() {
            File file = new File(g.OU());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    int i;
                    l lVar = a.dzP;
                    String absolutePath = file2.getAbsolutePath();
                    Cursor query = lVar.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{absolutePath}, null, null, null);
                    if (query == null) {
                        i = 0;
                    } else {
                        i = query.getCount() > 0 ? 1 : 0;
                        query.close();
                    }
                    if (i == 0) {
                        b.deleteFile(file2.getAbsolutePath());
                    }
                }
            }
        }

        public final void run() {
            try {
                Cursor query = a.dzP.dBf.query("AppBrandWxaPkgManifestRecord", null, String.format("%s<>?", new Object[]{"debugType"}), new String[]{"0"}, null, null, null);
                List list;
                if (query == null) {
                    list = null;
                } else if (query.moveToFirst()) {
                    list = new LinkedList();
                    do {
                        i iVar = new i();
                        iVar.b(query);
                        list.add(iVar);
                    } while (query.moveToNext());
                    query.close();
                } else {
                    query.close();
                    list = null;
                }
                if (!be.bP(r0)) {
                    long Nh = be.Nh();
                    for (i iVar2 : r0) {
                        if (iVar2.field_endTime > 0 && iVar2.field_endTime <= Nh) {
                            b.deleteFile(iVar2.field_pkgPath);
                            AppBrandTaskManager.ab(iVar2.field_appId, iVar2.field_debugType);
                        }
                    }
                }
                AnonymousClass1.Pk();
                AnonymousClass1.Pl();
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", new Object[]{be.e(e)});
            }
        }
    };

    public static void Pj() {
        com.tencent.mm.plugin.appbrand.k.a.vA().x(dAW);
    }
}
