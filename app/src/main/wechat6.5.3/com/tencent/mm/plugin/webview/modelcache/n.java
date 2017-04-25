package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.modelcache.b.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.List;

public final class n {
    public final q d(String str, String str2, String str3, int i) {
        q qVar;
        if (be.kS(str3)) {
            v.e("MicroMsg.WebViewCacheResQuerier", "url is null or nil");
            qVar = null;
        } else {
            String Ep = v.Ep(str2);
            String Eo = v.Eo(str3);
            String Em = v.Em(Ep);
            v.i("MicroMsg.WebViewCacheResQuerier", "getResCache, appId = %s, mainDocumentURL = %s, requestURL = %s, protocol = %s, mainURL = %s", new Object[]{str, Ep, str3, a.toString(i), Eo});
            if (be.kS(Ep) || be.kS(Eo) || be.kS(Em)) {
                qVar = null;
            } else {
                i i2;
                List<j> g;
                String[] split;
                p biL;
                p biL2;
                if (v.Es(str3)) {
                    p biL3 = p.biL();
                    i2 = !biL3.lfs ? null : be.kS(Eo) ? null : biL3.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s=? order by %s desc", new Object[]{"WebViewResourceCache", "appId", "domain", "cacheType", "protocol", "urlMd5Hashcode", "createTime"}), "PublicShareResAppId", "PublicShareResDomain", "3", String.valueOf(a.HTTPS.bkU), String.valueOf(z.Kg(Eo).hashCode()));
                    if (v.g(i2)) {
                        c(i2);
                        qVar = q.f(i2);
                        v.i("MicroMsg.WebViewCacheResQuerier", "tryHitPublicCache, requestURL = %s, ret = %s", new Object[]{str3, qVar});
                        if (qVar == null) {
                            g = be.kS(str) ? e.bjg().g(String.format("select * from %s where %s like '%%/_%s/_%%' escape '/'", new Object[]{"WebViewCacheResConfigMap", "configId", Em}), new String[0]) : e.bjg().g(String.format("select * from %s where %s like '%s/_%s/_%%' escape '/'", new Object[]{"WebViewCacheResConfigMap", "configId", str, Em}), new String[0]);
                            if (g != null) {
                                v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache, get null mapList by appId = %s, and domain = %s", new Object[]{str, Em});
                            } else {
                                for (j jVar : g) {
                                    v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache with appId = %s, map = %s", new Object[]{str, jVar});
                                    if (!jVar.field_disable) {
                                        Ep = jVar.field_configId;
                                        if (be.kS(Ep)) {
                                            split = Ep.split("_");
                                            Ep = split.length == 3 ? null : split[2];
                                        } else {
                                            Ep = null;
                                        }
                                        if (be.kS(Ep)) {
                                            if (be.kS(str)) {
                                                biL = p.biL();
                                                if (biL.lfs) {
                                                    if (!be.kS(str) || be.kS(Em) || be.kS(Eo) || be.kS(Ep)) {
                                                        i2 = null;
                                                    } else if (a.sE(i) || a.sF(i)) {
                                                        v.i("MicroMsg.WebViewCacheResStorage", "getCacheRes, appId = %s, domain = %s, cacheType = %s, mainURL = %s, protocol = %s, urlMd5Hashcode = %s, packageId = %s", new Object[]{str, Em, Integer.valueOf(2), Eo, Integer.valueOf(i), Integer.valueOf(z.Kg(Eo).hashCode()), Ep});
                                                        if (a.sE(i) && a.sF(i)) {
                                                            i2 = biL.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s=? order by %s desc", new Object[]{"WebViewResourceCache", "appId", "domain", "cacheType", "urlMd5Hashcode", "packageId", "createTime"}), str, Em, "2", String.valueOf(z.Kg(Eo).hashCode()), Ep);
                                                        } else {
                                                            i iVar = new i();
                                                            iVar.field_appId = str;
                                                            iVar.field_domain = Em;
                                                            iVar.field_cacheType = 2;
                                                            iVar.field_urlMd5Hashcode = z.Kg(Eo).hashCode();
                                                            iVar.field_protocol = i;
                                                            iVar.field_packageId = Ep;
                                                            if (biL.b(iVar, new String[]{"appId", "domain", "cacheType", "urlMd5Hashcode", "protocol", "packageId"})) {
                                                                i2 = iVar;
                                                            }
                                                        }
                                                    } else {
                                                        v.e("MicroMsg.WebViewCacheResStorage", "unsupported protocol = %d", new Object[]{Integer.valueOf(i)});
                                                    }
                                                }
                                                i2 = null;
                                            } else {
                                                biL2 = p.biL();
                                                if (biL2.lfs) {
                                                    if (!be.kS(Em) || be.kS(Eo) || be.kS(Ep)) {
                                                        i2 = null;
                                                    } else if (a.sE(i) || a.sF(i)) {
                                                        String valueOf = String.valueOf(z.Kg(Eo).hashCode());
                                                        v.i("MicroMsg.WebViewCacheResStorage", "getCacheRes without appId, domain = %s, cacheType = %s, mainURL = %s, protocol = %s, urlMd5Hashcode = %s, packageId = %s", new Object[]{Em, Integer.valueOf(2), Eo, Integer.valueOf(i), valueOf, Ep});
                                                        String sJ = p.sJ(i);
                                                        i2 = biL2.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s order by %s desc", new Object[]{"WebViewResourceCache", "domain", "cacheType", "urlMd5Hashcode", "packageId", sJ, "createTime"}), Em, "2", valueOf, Ep);
                                                    } else {
                                                        v.e("MicroMsg.WebViewCacheResStorage", "getCacheRes without appId, unsupported protocol = %d", new Object[]{Integer.valueOf(i)});
                                                    }
                                                }
                                                i2 = null;
                                            }
                                            if (v.g(i2) && i2.field_isLatestVersion) {
                                                c(i2);
                                                v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache with appId = %s, requestURL = %s", new Object[]{str, str3});
                                                qVar = q.f(i2);
                                                break;
                                            }
                                        }
                                        continue;
                                    }
                                }
                            }
                            qVar = null;
                            if (qVar == null) {
                                v.i("MicroMsg.WebViewCacheResQuerier", "tryHitSyncCache, appId = %s, domain = %s, mainDocumentURL = %s, requestURL = %s, mainURL = %s, protocol = %s", new Object[]{str, Em, str2, str3, Eo, a.toString(i)});
                                if (!be.kS(str2)) {
                                    Ep = v.Eq(str3);
                                    if (be.kS(Ep)) {
                                        Ep = "1";
                                    }
                                    String sJ2;
                                    if (be.kS(str)) {
                                        biL2 = p.biL();
                                        if (biL2.lfs) {
                                            i2 = null;
                                        } else if (!be.kS(str) || be.kS(Em) || be.kS(Eo)) {
                                            i2 = null;
                                        } else if (a.sE(i) || a.sF(i)) {
                                            v.i("MicroMsg.WebViewCacheResStorage", "getCacheRes, appId = %s, domain = %s, cacheType = %s, mainURL = %s, protocol = %s, urlMd5Hashcode = %s, packageId = %s", new Object[]{str, Em, Integer.valueOf(1), Eo, Integer.valueOf(i), Integer.valueOf(z.Kg(Eo).hashCode()), null});
                                            sJ2 = p.sJ(i);
                                            i2 = !be.kS(null) ? biL2.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s=? and %s=? and %s order by %s desc", new Object[]{"WebViewResourceCache", "appId", "domain", "cacheType", "urlMd5Hashcode", "packageId", "version", sJ2, "createTime"}), str, Em, "1", String.valueOf(z.Kg(Eo).hashCode()), null, Ep) : biL2.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s=? and %s order by %s desc", new Object[]{"WebViewResourceCache", "appId", "domain", "cacheType", "urlMd5Hashcode", "version", sJ2, "createTime"}), str, Em, "1", String.valueOf(z.Kg(Eo).hashCode()), Ep);
                                        } else {
                                            v.e("MicroMsg.WebViewCacheResStorage", "unsupported protocol = %d", new Object[]{Integer.valueOf(i)});
                                            i2 = null;
                                        }
                                    } else {
                                        biL2 = p.biL();
                                        if (biL2.lfs) {
                                            i2 = null;
                                        } else if (!be.kS(Em) || be.kS(Eo)) {
                                            i2 = null;
                                        } else if (a.sE(i) || a.sF(i)) {
                                            sJ2 = String.valueOf(z.Kg(Eo).hashCode());
                                            v.i("MicroMsg.WebViewCacheResStorage", "getCacheRes without appId, domain = %s, cacheType = %s, mainURL = %s, protocol = %s, urlMd5Hashcode = %s, packageId = %s, version = %s", new Object[]{Em, Integer.valueOf(1), Eo, Integer.valueOf(i), sJ2, null, Ep});
                                            Eo = p.sJ(i);
                                            i2 = !be.kS(null) ? biL2.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s=? and %s order by %s desc", new Object[]{"WebViewResourceCache", "domain", "cacheType", "urlMd5Hashcode", "packageId", "version", Eo, "createTime"}), Em, "1", sJ2, null, Ep) : biL2.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? and %s order by %s desc", new Object[]{"WebViewResourceCache", "domain", "cacheType", "urlMd5Hashcode", "version", Eo, "createTime"}), Em, "1", sJ2, Ep);
                                        } else {
                                            v.e("MicroMsg.WebViewCacheResStorage", "getCacheRes without appId, unsupported protocol = %d", new Object[]{Integer.valueOf(i)});
                                            i2 = null;
                                        }
                                    }
                                    if (v.g(i2)) {
                                        c(i2);
                                        v.i("MicroMsg.WebViewCacheResQuerier", "url (%s) hit in sync resource", new Object[]{str3});
                                        qVar = q.f(i2);
                                    }
                                }
                                qVar = null;
                            }
                        }
                    }
                }
                qVar = null;
                v.i("MicroMsg.WebViewCacheResQuerier", "tryHitPublicCache, requestURL = %s, ret = %s", new Object[]{str3, qVar});
                if (qVar == null) {
                    if (be.kS(str)) {
                    }
                    if (g != null) {
                        for (j jVar2 : g) {
                            v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache with appId = %s, map = %s", new Object[]{str, jVar2});
                            if (!jVar2.field_disable) {
                                Ep = jVar2.field_configId;
                                if (be.kS(Ep)) {
                                    split = Ep.split("_");
                                    if (split.length == 3) {
                                    }
                                } else {
                                    Ep = null;
                                }
                                if (be.kS(Ep)) {
                                    if (be.kS(str)) {
                                        biL = p.biL();
                                        if (biL.lfs) {
                                            if (be.kS(str)) {
                                            }
                                            i2 = null;
                                        }
                                        i2 = null;
                                    } else {
                                        biL2 = p.biL();
                                        if (biL2.lfs) {
                                            if (be.kS(Em)) {
                                            }
                                            i2 = null;
                                        }
                                        i2 = null;
                                    }
                                    c(i2);
                                    v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache with appId = %s, requestURL = %s", new Object[]{str, str3});
                                    qVar = q.f(i2);
                                    break;
                                }
                                continue;
                            }
                        }
                    } else {
                        v.i("MicroMsg.WebViewCacheResQuerier", "tryHitAsyncCache, get null mapList by appId = %s, and domain = %s", new Object[]{str, Em});
                    }
                    qVar = null;
                    if (qVar == null) {
                        v.i("MicroMsg.WebViewCacheResQuerier", "tryHitSyncCache, appId = %s, domain = %s, mainDocumentURL = %s, requestURL = %s, mainURL = %s, protocol = %s", new Object[]{str, Em, str2, str3, Eo, a.toString(i)});
                        if (be.kS(str2)) {
                            Ep = v.Eq(str3);
                            if (be.kS(Ep)) {
                                Ep = "1";
                            }
                            if (be.kS(str)) {
                                biL2 = p.biL();
                                if (biL2.lfs) {
                                    if (be.kS(str)) {
                                    }
                                    i2 = null;
                                } else {
                                    i2 = null;
                                }
                            } else {
                                biL2 = p.biL();
                                if (biL2.lfs) {
                                    if (be.kS(Em)) {
                                    }
                                    i2 = null;
                                } else {
                                    i2 = null;
                                }
                            }
                            if (v.g(i2)) {
                                c(i2);
                                v.i("MicroMsg.WebViewCacheResQuerier", "url (%s) hit in sync resource", new Object[]{str3});
                                qVar = q.f(i2);
                            }
                        }
                        qVar = null;
                    }
                }
            }
        }
        v.i("MicroMsg.WebViewCacheResQuerier", "getResCache, ret = " + qVar);
        return qVar;
    }

    private static void c(i iVar) {
        if (iVar == null) {
            v.e("MicroMsg.WebViewCacheResQuerier", "can't touch null cacheResRecord");
            return;
        }
        iVar.field_accessTime = be.Nh();
        p.biL().e(iVar);
    }
}
