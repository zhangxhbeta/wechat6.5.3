package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class l {
    public static final String[] dBe = new String[]{f.a(i.cxi, "AppBrandWxaPkgManifestRecord")};
    public final g dBf;
    public final a dBg;

    private static final class a extends f<i> {
        a(d dVar) {
            super(dVar, i.cxi, "AppBrandWxaPkgManifestRecord", i.btd);
        }
    }

    public l(g gVar) {
        this.dBf = gVar;
        this.dBg = new a(gVar);
    }

    public final i a(String str, int i, String[] strArr) {
        i iVar = null;
        if (!be.kS(str)) {
            Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, (i == 0 ? "version" : "createTime") + " desc");
            if (query != null) {
                if (query.moveToFirst()) {
                    iVar = new i();
                    iVar.b(query);
                    iVar.field_appId = str;
                    iVar.field_debugType = i;
                }
                query.close();
            }
        }
        return iVar;
    }

    final boolean a(biz com_tencent_mm_protocal_c_biz) {
        boolean z = true;
        if (com_tencent_mm_protocal_c_biz.version < 0 || be.kS(com_tencent_mm_protocal_c_biz.url) || be.kS(com_tencent_mm_protocal_c_biz.aZy)) {
            v.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_biz.version), com_tencent_mm_protocal_c_biz.url, com_tencent_mm_protocal_c_biz.aZy});
            return false;
        }
        if (com_tencent_mm_protocal_c_biz.ndp > 0) {
            int delete = this.dBf.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", "0", String.valueOf(com_tencent_mm_protocal_c_biz.version)});
            v.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_biz.version), Integer.valueOf(delete)});
        }
        String str = "@LibraryAppId";
        int i = com_tencent_mm_protocal_c_biz.version;
        String str2 = com_tencent_mm_protocal_c_biz.aZy;
        String str3 = com_tencent_mm_protocal_c_biz.url;
        if (com_tencent_mm_protocal_c_biz.ndp <= 0) {
            z = false;
        }
        return a(str, i, 0, str2, str3, z);
    }

    final int P(String str, int i) {
        Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        if (query == null) {
            return 0;
        }
        int count = query.getCount();
        query.close();
        return count;
    }

    @SuppressLint({"DefaultLocale"})
    final List<i> m(String str, int i, int i2) {
        List<i> list = null;
        if (!be.kS(str)) {
            String format = String.format("order by %s desc", new Object[]{"version"});
            String format2 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(2)});
            Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format, format2}), new String[]{str, "0"}, null, null, null);
            if (query != null) {
                list = new LinkedList();
                if (query.moveToFirst()) {
                    do {
                        i iVar = new i();
                        iVar.field_appId = str;
                        iVar.field_debugType = 0;
                        iVar.b(query);
                        list.add(iVar);
                    } while (query.moveToNext());
                }
                query.close();
            }
        }
        return list;
    }

    public final boolean Q(String str, int i) {
        if (be.kS(str) || i < 0) {
            return false;
        }
        Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        if (query == null) {
            return false;
        }
        boolean z;
        if (query.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId = %s, url = %s", new Object[]{str, str2});
            return false;
        }
        if (i == 999) {
            str = "@LibraryAppId";
        }
        i n = n(str, 1, i);
        if (n == null) {
            i iVar = new i();
            iVar.field_appId = str;
            iVar.field_version = 1;
            iVar.field_debugType = i;
            iVar.field_downloadURL = str2;
            iVar.field_versionMd5 = str3;
            iVar.field_versionState = 0;
            iVar.field_startTime = j;
            iVar.field_endTime = j2;
            iVar.field_createTime = com.tencent.mm.plugin.appbrand.k.a.Sm();
            a(iVar);
            return true;
        }
        if (be.kS(str3) || be.kS(n.field_versionMd5) || str3.equals(n.field_versionMd5)) {
            boolean z = false;
        } else {
            int i2 = 1;
        }
        if (str2.equals(n.field_downloadURL)) {
            boolean z2 = false;
        } else {
            int i3 = 1;
        }
        if (i2 != 0) {
            n.field_downloadURL = str2;
            b.deleteFile(n.field_pkgPath);
            n.field_pkgPath = null;
            n.field_createTime = com.tencent.mm.plugin.appbrand.k.a.Sm();
            n.field_versionMd5 = str3;
            n.field_startTime = j;
            n.field_endTime = j2;
            b(n);
            return true;
        } else if (i3 == 0) {
            return false;
        } else {
            n.field_downloadURL = str2;
            n.field_startTime = j;
            n.field_endTime = j2;
            b(n);
            return false;
        }
    }

    public final boolean a(String str, int i, int i2, String str2, String str3, boolean z) {
        if (i < om(str)) {
            v.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[]{Integer.valueOf(i), Integer.valueOf(om(str))});
            return false;
        } else if ("@LibraryAppId".equals(str) && i == 30 && !z) {
            v.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[]{Integer.valueOf(30)});
            return false;
        } else {
            int i3;
            v.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, givenVersion = %d, forceUpdate = %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            i n = n(str, i, 0);
            boolean a;
            if (n == null) {
                i iVar = new i();
                iVar.field_appId = str;
                iVar.field_version = i;
                iVar.field_versionMd5 = str2;
                iVar.field_versionState = i2;
                iVar.field_downloadURL = str3;
                iVar.field_debugType = 0;
                a = a(iVar);
                i3 = 1;
            } else {
                int i4;
                if (z) {
                    i4 = 1;
                    i3 = 1;
                } else {
                    a = false;
                    boolean z2 = false;
                }
                if (!be.ma(n.field_versionMd5).equals(str2)) {
                    n.field_versionMd5 = str2;
                    n.field_version = i;
                    n.field_downloadURL = str3;
                    i4 = 1;
                    i3 = 1;
                }
                if (n.field_versionState != i2 && i2 >= 0) {
                    n.field_versionState = i2;
                    i4 = 1;
                }
                if (i4 != 0) {
                    if (i3 != 0) {
                        b.deleteFile(n.field_pkgPath);
                        n.field_pkgPath = null;
                    }
                    a = b(n);
                } else {
                    a = false;
                }
            }
            if (i3 != 0) {
                if ("@LibraryAppId".equals(str)) {
                    m.R(str3, i);
                } else {
                    m.a(str, c.OQ(), i, str3, null);
                }
            }
            if (i3 == 0 || !r0) {
                return false;
            }
            return true;
        }
    }

    final i n(String str, int i, int i2) {
        i iVar = new i();
        iVar.field_appId = str;
        iVar.field_version = i;
        iVar.field_debugType = i2;
        return this.dBg.b(iVar, i.dAV) ? iVar : null;
    }

    public final int om(String str) {
        Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format("%s=? order by %s desc limit 1 offset 0", new Object[]{"appId", "version"}), new String[]{str}, null, null, null);
        if (query == null) {
            return -1;
        }
        if (query.getCount() <= 0) {
            query.close();
            return -1;
        }
        query.moveToFirst();
        int i = query.getInt(0);
        query.close();
        return i;
    }

    private boolean a(i iVar) {
        return this.dBg.b(iVar);
    }

    public final i mN(String str) {
        Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"version", "pkgPath", "versionMd5"}, String.format("%s=? and %s=? order by %s desc", new Object[]{"appId", "debugType", "version"}), new String[]{str, "0"}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.getCount() <= 0) {
            query.close();
            return null;
        }
        query.moveToFirst();
        i iVar = new i();
        iVar.b(query);
        query.close();
        return iVar;
    }

    final boolean b(i iVar) {
        return this.dBg.a(iVar, i.dAV);
    }

    public final void d(List<String> list, List<Integer> list2) {
        if (list.size() > 0 && list2.size() > 0 && list.size() == list2.size()) {
            long er = this.dBf.er(Thread.currentThread().getId());
            for (int i = 0; i < list.size(); i++) {
                cx((String) list.get(i), ((Integer) list2.get(i)).intValue());
            }
            this.dBf.es(er);
        }
    }

    public final void cx(String str, int i) {
        if (!be.kS(str)) {
            String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
            String[] strArr = new String[]{str, String.valueOf(i)};
            Cursor query = this.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null);
            if (query == null) {
                return;
            }
            if (query.moveToFirst()) {
                List<String> linkedList = new LinkedList();
                do {
                    linkedList.add(query.getString(0));
                } while (query.moveToNext());
                query.close();
                for (String deleteFile : linkedList) {
                    b.deleteFile(deleteFile);
                }
                this.dBf.delete("AppBrandWxaPkgManifestRecord", format, strArr);
                return;
            }
            query.close();
        }
    }
}
