package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class g {

    static final class a {
        static void c(Map<String, String> map, String str, String str2) {
            int i;
            String str3 = (String) map.get(str + ".$subtype");
            int i2;
            if (be.kS(str3)) {
                i2 = be.getInt((String) map.get(str + ".$scene"), -1);
                if (i2 == 2) {
                    i2 = 1;
                }
                v.d("MicroMsg.WebViewCacheNewXmlMsgHandler", "getType from $scene, subType = %d", new Object[]{Integer.valueOf(i2)});
                i = i2;
            } else {
                v.d("MicroMsg.WebViewCacheNewXmlMsgHandler", "getType from $subtype, subType = %d", new Object[]{Integer.valueOf(be.getInt(str3, 2))});
                i = i2;
            }
            String str4 = (String) map.get(str + ".$packageid");
            str3 = (String) map.get(str + ".$appid");
            int i3 = be.getInt((String) map.get(str + ".$networktype"), 1);
            long j = be.getLong((String) map.get(str + ".$expiretime"), 0);
            String str5 = (String) map.get(str + ".$base");
            String str6 = (String) map.get(str + ".$domain");
            if (!be.kS(str) && !be.kS(str3)) {
                if (i != 2 && i != 1) {
                    return;
                }
                if (i3 == 2 || i3 == 1) {
                    List a = a(map, str, "page", i == 2);
                    Collection a2 = a(map, str, "resource", i == 2);
                    List linkedList = new LinkedList();
                    linkedList.addAll(a);
                    linkedList.addAll(a2);
                    if (i == 2) {
                        if (!be.kS(str4)) {
                            if (be.bP(a)) {
                                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "WebCache resource async-type push, can't find page-type resource, unable to determine mainDocumentURL, skip");
                                return;
                            }
                            String trim = ((b) a.get(0)).path.trim();
                            if (!v.Ei(trim)) {
                                if (v.Ei(str5)) {
                                    trim = v.Ej(str5 + "/" + trim);
                                } else {
                                    v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "WebCache resource async-type push, mainDocumentURL(%s) invalid, skip", new Object[]{trim});
                                    return;
                                }
                            }
                            trim = be.ma(v.Em(trim));
                            if (trim.startsWith(str6)) {
                                g.a(str3, trim, str4, str5, str2, i3, j, linkedList);
                            } else {
                                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "WebCache resource async-type push, docDomain(%s), given domain(%s), mismatch, skip", new Object[]{trim, str6});
                            }
                        }
                    } else if (i == 1) {
                        g.a(str3, str6, str5, str4, i3, j, linkedList);
                    }
                }
            }
        }

        public static void Eg(String str) {
            Map q = bf.q(str, "cache");
            if (q == null || q.size() <= 0) {
                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "parseAppMsgNode, xml invalid");
            } else {
                c(q, ".cache", str);
            }
        }

        private static List<b> a(Map<String, String> map, String str, String str2, boolean z) {
            if (map == null || map.size() <= 0 || be.kS(str2)) {
                return null;
            }
            List<b> linkedList = new LinkedList();
            String str3 = (String) map.get(str + "." + str2);
            if (str3 == null) {
                return linkedList;
            }
            String str4;
            if (z) {
                str4 = (String) map.get(String.format("%s.%s.$version", new Object[]{str, str2}));
            } else {
                str4 = v.Eq(str3);
                if (be.kS(str4)) {
                    str4 = "1";
                }
            }
            if (!(be.kS(str3) || be.kS(str4))) {
                linkedList.add(new b(str3, str4, str2));
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                str3 = (String) map.get(String.format("%s.%s%d", new Object[]{str, str2, Integer.valueOf(i2)}));
                if (z) {
                    str4 = (String) map.get(String.format("%s.%s%d.$version", new Object[]{str, str2, Integer.valueOf(i2)}));
                } else {
                    str4 = v.Eq(str3);
                    if (be.kS(str4)) {
                        str4 = "1";
                    }
                }
                if (str3 == null) {
                    return linkedList;
                }
                if (be.kS(str3) || be.kS(str4)) {
                    i = i2;
                } else {
                    linkedList.add(new b(str3, str4, str2));
                    i = i2;
                }
            }
        }
    }

    private static final class b {
        public final String path;
        public final String tag;
        public final String version;

        b(String str, String str2, String str3) {
            this.version = str2;
            this.path = str;
            this.tag = str3;
        }
    }

    static /* synthetic */ void a(String str, String str2, String str3, String str4, int i, long j, List list) {
        v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, appId = %s, domain = %s, base = %s, packageId = %s", new Object[]{str, str2, str3, str4});
        if (be.kS(str)) {
            v.e("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, invalid params");
        } else if (be.bP(list)) {
            v.e("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, items is null or nil");
        } else {
            String str5 = str4;
            String str6 = str2;
            for (b bVar : list) {
                String trim = be.ma(bVar.path).trim();
                if (!be.kS(trim)) {
                    if (v.Ei(trim)) {
                        str6 = be.ah(str6, v.Em(trim));
                    } else if (!be.kS(str6)) {
                        trim = v.S("http://" + str6, str3, trim);
                    }
                    if (!be.kS(trim)) {
                        String Eo = v.Eo(trim);
                        if (!be.kS(Eo)) {
                            String Eq = v.Eq(trim);
                            if (!be.kS(Eq)) {
                                str5 = be.ah(str5, z.Kg(trim));
                                if (!be.kS(str5)) {
                                    i b = p.biL().b(str, str6, 1, Eo, str5);
                                    if (b == null) {
                                        i iVar = new i();
                                        iVar.field_url = Eo;
                                        iVar.field_appId = str;
                                        iVar.field_domain = str6;
                                        iVar.field_version = Eq;
                                        iVar.field_isLatestVersion = true;
                                        iVar.field_createTime = be.Nh();
                                        iVar.field_accessTime = be.Nh();
                                        iVar.field_cacheType = 1;
                                        iVar.field_configId = null;
                                        iVar.field_protocol = trim.startsWith("https://") ? com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU : com.tencent.mm.plugin.webview.modelcache.b.a.HTTP.bkU;
                                        iVar.field_packageId = str5;
                                        iVar.field_expireTime = j;
                                        p.biL().d(iVar);
                                        v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, new cacheRes = %s", new Object[]{iVar});
                                    } else if (!Eq.equals(b.field_version)) {
                                        b.field_contentMd5 = null;
                                        b.field_contentType = null;
                                        b.field_createTime = be.Nh();
                                        b.field_accessTime = be.Nh();
                                        b.field_expireTime = j;
                                        b.field_version = Eq;
                                        p.biL().e(b);
                                        v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, updated cacheRes = %s", new Object[]{b});
                                    } else if (v.g(b)) {
                                        v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, queried cacheRes = %s", new Object[]{b});
                                    } else {
                                        b.field_isLatestVersion = true;
                                        p.biL().e(b);
                                    }
                                    v.d("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadSyncResource, submit request = %s", new Object[]{new com.tencent.mm.plugin.webview.modelcache.downloaderimpl.g(trim, Eq, str, str6, str5, 1, i)});
                                    WebViewCacheDownloadHelper.biQ().a(r8);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, int i, long j, List list) {
        v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, appId = %s, domain = %s, packageId = %s, base = %s", new Object[]{str, str2, str3, str4});
        if (be.kS(str) || be.kS(str2) || be.kS(str3)) {
            v.e("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, invalid params");
        } else if (be.bP(list)) {
            v.e("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, pages and resources is null or nil");
        } else if (be.kS(str5)) {
            v.e("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, xmlContent is null or nil");
        } else {
            String format = String.format("%s_%s_%s", new Object[]{str, str2, str3});
            long bo = be.bo(str5.getBytes());
            j Eh = e.bjg().Eh(format);
            if (Eh == null) {
                Eh = new j();
                Eh.field_disable = false;
                Eh.field_configId = format;
                Eh.field_configUrl = null;
                Eh.field_configResources = str5;
                Eh.field_configCrc32 = bo;
                Eh.field_isFromXml = true;
                e.bjg().b(Eh);
                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, new config map = %s", new Object[]{Eh});
            } else if (Eh.field_configCrc32 != bo) {
                Eh.field_disable = false;
                Eh.field_configId = format;
                Eh.field_configUrl = null;
                Eh.field_configResources = str5;
                Eh.field_configCrc32 = bo;
                Eh.field_isFromXml = true;
                e.bjg().a(Eh);
                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, updated config map = %s", new Object[]{Eh});
            } else {
                v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "downloadAsyncResource, queried config map = %s", new Object[]{Eh});
            }
            String format2 = String.format("%s_%s_%s", new Object[]{str, str2, str3});
            for (b bVar : list) {
                if (!(be.kS(bVar.path) || be.kS(bVar.version))) {
                    format = be.ma(bVar.path).trim();
                    if (!be.kS(format)) {
                        String S = !v.Ei(format) ? v.S("http://" + str2, str4, format) : format;
                        if (!be.kS(S)) {
                            String Eo = v.Eo(S);
                            if (!be.kS(Eo)) {
                                s.h(12675, S, Integer.valueOf(i));
                                i b = p.biL().b(str, str2, 2, Eo, str3);
                                if (b == null) {
                                    i iVar = new i();
                                    iVar.field_url = Eo;
                                    iVar.field_appId = str;
                                    iVar.field_domain = str2;
                                    iVar.field_version = bVar.version;
                                    iVar.field_isLatestVersion = true;
                                    iVar.field_createTime = be.Nh();
                                    iVar.field_accessTime = be.Nh();
                                    iVar.field_cacheType = 2;
                                    iVar.field_configId = format2;
                                    iVar.field_protocol = S.startsWith("https://") ? com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU : com.tencent.mm.plugin.webview.modelcache.b.a.HTTP.bkU;
                                    iVar.field_packageId = str3;
                                    iVar.field_expireTime = j;
                                    p.biL().d(iVar);
                                    v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "iterateAsyncResource, new cacheRes = %s", new Object[]{iVar});
                                } else if (!bVar.version.equals(b.field_version)) {
                                    b.field_contentMd5 = null;
                                    b.field_contentType = null;
                                    b.field_createTime = be.Nh();
                                    b.field_accessTime = be.Nh();
                                    b.field_expireTime = j;
                                    b.field_version = bVar.version;
                                    p.biL().e(b);
                                    v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "iterateAsyncResource, updated cacheRes = %s", new Object[]{b});
                                } else if (v.g(b)) {
                                    v.i("MicroMsg.WebViewCacheNewXmlMsgHandler", "iterateAsyncResource, queried cacheRes = %s", new Object[]{b});
                                } else {
                                    b.field_isLatestVersion = true;
                                    p.biL().e(b);
                                }
                                v.d("MicroMsg.WebViewCacheNewXmlMsgHandler", "iterateAsyncResource, submit request = %s", new Object[]{new com.tencent.mm.plugin.webview.modelcache.downloaderimpl.g(S, bVar.version, str, str2, str3, 2, i)});
                                WebViewCacheDownloadHelper.biQ().a(r2);
                            }
                        }
                    }
                }
            }
        }
    }
}
