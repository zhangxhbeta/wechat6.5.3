package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.j.c;

public enum h {
    ;

    public enum a {
        public static final a dAM = null;
        public static final a dAN = null;
        public static final a dAO = null;
        public static final a dAP = null;
        public static final a dAQ = null;
        public static final a dAR = null;
        private static final /* synthetic */ a[] dAS = null;

        private a(String str, int i) {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) dAS.clone();
        }

        static {
            dAM = new a("APP_READY", 0);
            dAN = new a("APP_MANIFEST_NULL", 1);
            dAO = new a("PKG_EXPIRED", 2);
            dAP = new a("APP_NOT_INSTALLED", 3);
            dAQ = new a("APP_BROKEN", 4);
            dAR = new a("ENV_ERR", 5);
            dAS = new a[]{dAM, dAN, dAO, dAP, dAQ, dAR};
        }

        public final int Pi() {
            return super.ordinal();
        }
    }

    public static c<a, WxaPkgWrappingInfo> bt(boolean z) {
        return k("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static c<a, WxaPkgWrappingInfo> k(String str, int i, int i2) {
        if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return com.tencent.mm.vending.j.a.t(a.dAR, null);
        }
        i iVar;
        i iVar2;
        String str2;
        int i3;
        WxaPkgWrappingInfo l;
        Cursor query;
        if (i != 0) {
            query = com.tencent.mm.plugin.appbrand.a.a.dzP.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"downloadURL", "pkgPath", "versionMd5", "createTime", "startTime", "endTime"}, String.format("%s=? and %s=? order by %s desc limit 1 offset 0", new Object[]{"appId", "debugType", "createTime"}), new String[]{str, String.valueOf(i)}, null, null, null);
            if (query == null) {
                iVar = null;
            } else if (query.getCount() <= 0) {
                query.close();
                iVar = null;
            } else {
                query.moveToFirst();
                iVar = new i();
                iVar.b(query);
                query.close();
            }
        } else if (i2 < 0) {
            iVar = com.tencent.mm.plugin.appbrand.a.a.dzP.mN(str);
        } else {
            query = com.tencent.mm.plugin.appbrand.a.a.dzP.dBf.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "versionMd5"}, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "version", "debugType"}), new String[]{str, String.valueOf(i2), "0"}, null, null, null);
            if (query == null) {
                iVar = null;
            } else if (query.getCount() <= 0) {
                query.close();
                iVar = null;
            } else {
                query.moveToFirst();
                iVar = new i();
                iVar.b(query);
                query.close();
            }
            iVar2 = iVar;
            if (iVar2 != null) {
                v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                WxaPkgWrappingInfo l2 = l(str, i, -1);
                return l2 == null ? com.tencent.mm.vending.j.a.t(a.dAM, l2) : com.tencent.mm.vending.j.a.t(a.dAN, null);
            } else if (iVar2.field_endTime <= 0 && iVar2.field_endTime <= com.tencent.mm.plugin.appbrand.k.a.Sm()) {
                return com.tencent.mm.vending.j.a.t(a.dAO, null);
            } else {
                str2 = iVar2.field_pkgPath;
                String str3 = iVar2.field_versionMd5;
                i3 = i2 >= 0 ? iVar2.field_version : i2;
                long j = iVar2.field_createTime;
                l = l(str, i, i3);
                if (l != null) {
                    return com.tencent.mm.vending.j.a.t(a.dAM, l);
                }
                if (be.kS(str2) && e.aR(str2)) {
                    String aX = g.aX(str2);
                    if (be.kS(str3) || str3.equals(aX)) {
                        WxaPkgWrappingInfo mO = WxaPkgWrappingInfo.mO(str2);
                        if (mO == null) {
                            v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                            return com.tencent.mm.vending.j.a.t(a.dAQ, null);
                        }
                        mO.dBs = i3;
                        mO.dBt = j;
                        mO.dBA = str2;
                        mO.dBu = false;
                        mO.dBr = i;
                        v.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(iVar2.field_startTime), Long.valueOf(iVar2.field_endTime), mO});
                        return com.tencent.mm.vending.j.a.t(a.dAM, mO);
                    }
                    v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[]{aX, str3, str, Integer.valueOf(i), Integer.valueOf(i2)});
                    return com.tencent.mm.vending.j.a.t(a.dAQ, null);
                }
                v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i3)});
                return com.tencent.mm.vending.j.a.t(a.dAQ, null);
            }
        }
        iVar2 = iVar;
        if (iVar2 != null) {
            if (iVar2.field_endTime <= 0) {
            }
            str2 = iVar2.field_pkgPath;
            String str32 = iVar2.field_versionMd5;
            if (i2 >= 0) {
            }
            long j2 = iVar2.field_createTime;
            l = l(str, i, i3);
            if (l != null) {
                return com.tencent.mm.vending.j.a.t(a.dAM, l);
            }
            if (be.kS(str2)) {
            }
            v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i3)});
            return com.tencent.mm.vending.j.a.t(a.dAQ, null);
        }
        v.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        WxaPkgWrappingInfo l22 = l(str, i, -1);
        if (l22 == null) {
        }
    }

    private static WxaPkgWrappingInfo l(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str) || i != 0 || (i2 >= 0 && 30 < i2)) {
            return null;
        }
        v.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[]{Integer.valueOf(30), str, Integer.valueOf(i), Integer.valueOf(i2)});
        return e.OR();
    }
}
