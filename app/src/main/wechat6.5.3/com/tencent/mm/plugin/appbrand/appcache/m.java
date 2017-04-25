package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class m {
    private static volatile m dBh = null;
    private final Map<String, WeakReference<a>> dBi = new HashMap();
    private final g dBj = new g();

    public interface a {

        public static final class a {
            public final String appId;
            public final int dzx;
            public final String filePath;
            public final int version;

            public a(String str, String str2, int i, int i2) {
                this.appId = str;
                this.filePath = str2;
                this.version = i;
                this.dzx = i2;
            }
        }

        public enum b {
            OK(0),
            FAILED(101),
            LOCAL_FILE_NOT_FOUND(102),
            PKG_INTEGRITY_FAILED(UpdateLogConst.ACTION_POP_INSTALL_DIALOG),
            PKG_INVALID(105),
            SEVER_FILE_NOT_FOUND(106);
            
            public final int aJW;

            private b(int i) {
                this.aJW = i;
            }
        }

        void a(String str, b bVar, a aVar);
    }

    private static m Pm() {
        if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            dBh = null;
            return null;
        }
        if (dBh == null) {
            synchronized (m.class) {
                if (dBh == null) {
                    dBh = new m();
                }
            }
        }
        return dBh;
    }

    public static boolean bu(boolean z) {
        v.d("MicroMsg.AppBrandWxaPkgUpdater", "refreshLibraryVersionInfo invoked");
        if (ak.uz()) {
            ak.yW();
            v.i("MicroMsg.AppBrandWxaPkgUpdater", "refreshLibraryVersionInfo, nextSec = %d, nowSec = %d", new Object[]{(Long) c.vf().get(com.tencent.mm.storage.t.a.nsS, Long.valueOf(0)), Long.valueOf(be.Nh())});
            if (be.Nh() < ((Long) c.vf().get(com.tencent.mm.storage.t.a.nsS, Long.valueOf(0))).longValue() && !z) {
                return false;
            }
            if (com.tencent.mm.plugin.appbrand.a.a.SY() == null || com.tencent.mm.plugin.appbrand.a.a.dzS == null) {
                return false;
            }
            com.tencent.mm.plugin.appbrand.b.c cVar = com.tencent.mm.plugin.appbrand.a.a.dzS;
            com.tencent.mm.plugin.appbrand.b.c.Pq();
            if (com.tencent.mm.plugin.appbrand.a.a.dzS.Pp()) {
                com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
                aVar.czn = new biy();
                aVar.czo = new biz();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo";
                aVar.czm = 1168;
                u.a(aVar.Bv(), new com.tencent.mm.v.u.a() {
                    public final int a(int i, int i2, String str, b bVar, k kVar) {
                        if (ak.uz()) {
                            long Nh = 86400 + be.Nh();
                            ak.yW();
                            c.vf().a(com.tencent.mm.storage.t.a.nsS, Long.valueOf(Nh));
                        }
                        if (i == 0 && i2 == 0) {
                            if (((biz) bVar.czl.czs) == null) {
                                v.e("MicroMsg.AppBrandWxaPkgUpdater", "GetPublicLibInfoRequest, get null response");
                            } else if (com.tencent.mm.plugin.appbrand.a.a.dzP != null) {
                                v.i("MicroMsg.AppBrandWxaPkgUpdater", "GetPublicLibInfoRequest, updateRet = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.appbrand.a.a.dzP.a(r0)), Integer.valueOf(r0.version), Integer.valueOf(r0.ndp), r0.aZy, r0.url});
                            } else {
                                v.e("MicroMsg.AppBrandWxaPkgUpdater", "GetPublicLibInfoRequest, null storage");
                            }
                        } else {
                            v.e("MicroMsg.AppBrandWxaPkgUpdater", "GetPublicLibInfoRequest, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        }
                        return 0;
                    }
                }, true);
                return true;
            }
            v.i("MicroMsg.AppBrandWxaPkgUpdater", "refreshLibraryVersionInfo, no need to refresh because entrance is off");
            return false;
        }
        v.e("MicroMsg.AppBrandWxaPkgUpdater", "refreshLibraryVersionInfo MMCore null, skip");
        return false;
    }

    public static boolean a(String str, a aVar) {
        return a("@LibraryAppId", str, 999, aVar);
    }

    public static boolean R(String str, int i) {
        if (Pm() == null) {
            return false;
        }
        if (be.kS(str) || i < 0) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadLibrary, url = %s, version = %d", new Object[]{str, Integer.valueOf(i)});
            return false;
        }
        f dVar = new d(str, i);
        Pm().dBi.put(dVar.lCO, new WeakReference(null));
        Pm().dBj.a(dVar);
        return true;
    }

    static void g(String str, String str2, int i) {
        if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, version = %d, get null storage", new Object[]{Integer.valueOf(i)});
        } else if (Pm() == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, version = %d, get null instance", new Object[]{Integer.valueOf(i)});
        } else {
            i n = com.tencent.mm.plugin.appbrand.a.a.dzP.n("@LibraryAppId", i, 0);
            if (n == null) {
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, get null record by version( %d )", new Object[]{Integer.valueOf(i)});
                return;
            }
            WeakReference weakReference = (WeakReference) Pm().dBi.get(str);
            if (be.kS(str2)) {
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, filePath is null or nil");
                a(weakReference, "@LibraryAppId", b.LOCAL_FILE_NOT_FOUND, null);
                com.tencent.mm.plugin.appbrand.report.a.S("@LibraryAppId", 20);
                return;
            }
            File file = new File(str2);
            if (file.exists()) {
                if (be.ma(n.field_versionMd5).equals(g.aX(str2))) {
                    f fVar = new f(file);
                    if (!fVar.dAt) {
                        fVar.close();
                        v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, pkg invalid");
                        file.delete();
                        a(weakReference, "@LibraryAppId", b.PKG_INVALID, null);
                        com.tencent.mm.plugin.appbrand.report.a.S("@LibraryAppId", 22);
                        return;
                    } else if (fVar.OS()) {
                        n.field_pkgPath = str2;
                        com.tencent.mm.plugin.appbrand.a.a.dzP.b(n);
                        fVar.close();
                        a(weakReference, "@LibraryAppId", b.OK, null);
                        return;
                    } else {
                        fVar.close();
                        v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, pkg readInfo failed");
                        file.delete();
                        a(weakReference, "@LibraryAppId", b.PKG_INVALID, null);
                        com.tencent.mm.plugin.appbrand.report.a.S("@LibraryAppId", 22);
                        return;
                    }
                }
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{n.field_versionMd5, g.aX(str2)});
                com.tencent.mm.loader.stub.b.deleteFile(str2);
                a(weakReference, "@LibraryAppId", b.PKG_INTEGRITY_FAILED, null);
                com.tencent.mm.plugin.appbrand.report.a.S("@LibraryAppId", 21);
                return;
            }
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, pkg file not exists");
            a(weakReference, "@LibraryAppId", b.LOCAL_FILE_NOT_FOUND, null);
            com.tencent.mm.plugin.appbrand.report.a.S("@LibraryAppId", 20);
        }
    }

    public static boolean a(String str, String str2, int i, String str3, a aVar) {
        if (Pm() == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownload, get null updater instance!!!");
            return false;
        } else if (be.kS(str) || be.kS(str2) || i < 0) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownload, appId = %s, basePath = %s, version = %d", new Object[]{str, str2, Integer.valueOf(i)});
            return false;
        } else {
            f fVar = new f(str, str2, i, str3);
            Pm().dBi.put(fVar.lCO, new WeakReference(aVar));
            Pm().dBj.a(fVar);
            return true;
        }
    }

    public static boolean a(String str, String str2, int i, a aVar) {
        if (Pm() == null) {
            return false;
        }
        if (be.kS(str) || be.kS(str2)) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadDebugPkg, appId = %s, fullURL = %s", new Object[]{str, str2});
            return false;
        }
        f cVar = new c(str, str2, i);
        Pm().dBi.put(cVar.lCO, new WeakReference(aVar));
        Pm().dBj.a(cVar);
        return true;
    }

    private static void a(WeakReference<a> weakReference, String str, b bVar, a aVar) {
        if (weakReference == null || weakReference.get() == null) {
            v.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[]{str});
            return;
        }
        ((a) weakReference.get()).a(str, bVar, aVar);
    }

    static void a(String str, String str2, b bVar) {
        if (Pm() == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
        } else {
            a((WeakReference) Pm().dBi.get(str), str2, bVar, null);
        }
    }

    static void b(String str, String str2, String str3, int i, int i2) {
        Object obj = i2 != 0 ? 1 : null;
        if (Pm() == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
            return;
        }
        WeakReference weakReference = (WeakReference) Pm().dBi.get(str);
        if (be.kS(str3)) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(weakReference, str2, b.LOCAL_FILE_NOT_FOUND, null);
            com.tencent.mm.plugin.appbrand.report.a.S(str2, 20);
            return;
        }
        File file = new File(str3);
        if (!file.exists()) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(weakReference, str2, b.LOCAL_FILE_NOT_FOUND, null);
            com.tencent.mm.plugin.appbrand.report.a.S(str2, 20);
        } else if (com.tencent.mm.plugin.appbrand.a.a.dzP == null) {
            v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
        } else {
            int i3 = i2 == 0 ? i : 1;
            i n = com.tencent.mm.plugin.appbrand.a.a.dzP.n(str2, i3, i2);
            if (n == null) {
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int i4;
            Object obj2;
            int i5;
            String str4;
            if (obj == null) {
                if (!be.ma(n.field_versionMd5).equals(g.aX(str3))) {
                    v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{n.field_versionMd5, g.aX(str3)});
                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                    a(weakReference, str2, b.PKG_INTEGRITY_FAILED, null);
                    com.tencent.mm.plugin.appbrand.report.a.S(str2, 21);
                    return;
                }
            }
            if ("@LibraryAppId".equals(str2)) {
                i4 = 8;
            } else if (i2 == 0) {
                i4 = (com.tencent.mm.plugin.appbrand.a.a.dzP == null ? 1 : com.tencent.mm.plugin.appbrand.a.a.dzP.P(str2, i2)) > 1 ? 5 : 2;
            } else {
                i4 = 2;
            }
            if (2 == i4) {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 5, 1, false);
            } else if (5 == i4) {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 14, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(368, 24, 1, false);
            }
            long Ni = be.Ni();
            f fVar = new f(file);
            if (!fVar.dAt) {
                fVar.close();
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                file.delete();
                obj2 = null;
            } else if (i3 != i && i2 == 0) {
                fVar.close();
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, given version(%s) != pkg version(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i3)});
                file.delete();
                obj2 = null;
            } else if (fVar.OS()) {
                fVar.close();
                int i6 = 1;
            } else {
                fVar.close();
                v.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                file.delete();
                obj2 = null;
            }
            int Ni2 = (int) (be.Ni() - Ni);
            int i7 = obj2 != null ? 1 : 2;
            if ("@LibraryAppId".equals(str2)) {
                i5 = 8;
                str4 = "";
            } else if (i2 == 0) {
                i5 = (com.tencent.mm.plugin.appbrand.a.a.dzP == null ? 1 : com.tencent.mm.plugin.appbrand.a.a.dzP.P(str2, i2)) > 1 ? 5 : 2;
                str4 = str2;
            } else {
                i5 = 2;
                str4 = str2;
            }
            if (2 == i5) {
                if (obj2 != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 7, 1, false);
                }
            } else if (5 == i5) {
                if (obj2 != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 15, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 16, 1, false);
                }
            } else if (8 == i5) {
                if (obj2 != null) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 25, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.a(368, 26, 1, false);
                }
            }
            com.tencent.mm.plugin.appbrand.report.a.b(str4, "", i5, i7, Ni2);
            if (obj2 == null) {
                a(weakReference, str2, b.PKG_INVALID, null);
                com.tencent.mm.plugin.appbrand.report.a.S(str2, 22);
                return;
            }
            boolean z;
            l lVar = com.tencent.mm.plugin.appbrand.a.a.dzP;
            if (!be.kS(str2)) {
                i4 = i2 != 0 ? 1 : i3;
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("pkgPath", str3);
                if (lVar.dBf.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str2, String.valueOf(i2), String.valueOf(i4)}) > 0) {
                    z = true;
                    v.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                    a(weakReference, str2, b.OK, new a(str2, str3, i, i2));
                }
            }
            z = false;
            v.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
            a(weakReference, str2, b.OK, new a(str2, str3, i, i2));
        }
    }
}
