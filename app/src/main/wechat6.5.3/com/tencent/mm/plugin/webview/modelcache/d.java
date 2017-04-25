package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.modelcache.b.a;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.g;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;
import java.util.List;

public final class d {
    final void Ee(String str) {
        List list = null;
        j jVar = new j();
        jVar.field_configId = str;
        e.bjg().c(jVar, new String[]{"configId"});
        p biL = p.biL();
        if (biL.lfs && !be.kS(str)) {
            list = biL.h(String.format("select * from %s where %s=?", new Object[]{"WebViewResourceCache", "configId"}), str);
        }
        bF(list);
        i iVar = new i();
        iVar.field_configId = str;
        p.biL().c(iVar, new String[]{"configId"});
    }

    final void Ef(String str) {
        if (!be.kS(str) && ak.uz()) {
            p biL = p.biL();
            String format = String.format(" order by %s desc", new Object[]{"accessTime"});
            List list;
            if (!biL.lfs) {
                list = null;
            } else if (be.kS(str)) {
                list = null;
            } else {
                list = biL.h(String.format("select * from %s where %s=?   %s", new Object[]{"WebViewResourceCache", "appId", be.ma(format)}), str);
            }
            if (!be.bP(r0)) {
                long j = 0;
                List<i> linkedList = new LinkedList();
                for (i iVar : r0) {
                    if (v.g(iVar)) {
                        if (iVar.field_expireTime <= 0) {
                            if (iVar.field_accessTime > be.Nh() - 2592000) {
                                if (iVar.field_contentLength <= 0) {
                                    if (be.kS(iVar.field_localPath)) {
                                        b(iVar);
                                        iVar.field_contentLength = 0;
                                    } else {
                                        iVar.field_contentLength = a.jP(iVar.field_localPath);
                                    }
                                }
                                j += iVar.field_contentLength;
                                linkedList.add(iVar);
                                if (j >= 5242880) {
                                    break;
                                }
                            }
                            b(iVar);
                        } else if (iVar.field_expireTime <= be.Nh()) {
                            b(iVar);
                        }
                        j = j;
                    } else {
                        b(iVar);
                    }
                }
                if (j >= 5242880) {
                    for (i iVar2 : linkedList) {
                        b(iVar2);
                    }
                }
                linkedList.clear();
            }
        }
    }

    public final void bF(List<i> list) {
        if (!be.bP(list)) {
            List linkedList = new LinkedList();
            for (i iVar : list) {
                b(iVar);
                linkedList.add(new g((iVar.field_protocol == a.HTTP.bkU ? "http" : "https") + "://" + iVar.field_url, iVar.field_version, iVar.field_appId, iVar.field_domain, iVar.field_packageId, iVar.field_cacheType));
            }
            p.a.bog().q(new com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper.AnonymousClass1(WebViewCacheDownloadHelper.biQ(), linkedList));
        }
    }

    public static void a(i iVar) {
        a Ed = a.Ed(iVar.field_appId);
        if (Ed != null) {
            String str = iVar.field_localPath;
            if (!be.kS(str)) {
                long jP;
                if (str.startsWith(Ed.path)) {
                    jP = FileOp.jP(str);
                } else {
                    jP = 0;
                }
                if (FileOp.deleteFile(str) && str.startsWith(Ed.path)) {
                    b bVar = Ed.lfo;
                    String str2 = Ed.appId;
                    if (bVar.lfs) {
                        a aVar = new a();
                        aVar.field_appId = str2;
                        if (bVar.b(aVar, new String[0])) {
                            aVar.field_occupation = Math.max(0, aVar.field_occupation - jP);
                            bVar.a(aVar, new String[0]);
                        }
                    }
                }
            }
        }
    }

    private static void b(i iVar) {
        p biL = p.biL();
        if (!(!biL.lfs || iVar == null || be.kS(iVar.field_appId) || be.kS(iVar.field_domain) || be.kS(iVar.field_packageId))) {
            biL.a(iVar, false, new String[]{"urlMd5Hashcode", "appId", "domain", "cacheType", "packageId"});
        }
        a(iVar);
    }
}
