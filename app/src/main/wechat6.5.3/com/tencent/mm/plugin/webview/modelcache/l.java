package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class l {

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String aSi;
        final /* synthetic */ String lfF;
        final /* synthetic */ String lfG;
        final /* synthetic */ String lfH;
        final /* synthetic */ String lfI;
        final /* synthetic */ String lfJ;
        final /* synthetic */ int lfK;
        final /* synthetic */ int lfL;
        final /* synthetic */ l lfM;

        public AnonymousClass1(l lVar, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            this.lfM = lVar;
            this.aSi = str;
            this.lfF = str2;
            this.lfG = str3;
            this.lfH = str4;
            this.lfI = str5;
            this.lfJ = str6;
            this.lfK = i;
            this.lfL = i2;
        }

        public final void run() {
            String str = this.aSi;
            String str2 = this.lfF;
            String str3 = this.lfG;
            String str4 = this.lfH;
            String str5 = this.lfI;
            String str6 = this.lfJ;
            int i = this.lfK;
            int i2 = this.lfL;
            String En = v.En(str2);
            try {
                String[] El = v.El(str6);
                if (El.length == 0) {
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, get empty array from resourceList, return and callback, resourceList = %s ", new Object[]{str6});
                    j.tl(i).x(i2, "cache", "fail");
                    return;
                }
                for (String str22 : El) {
                    str22 = str22.trim();
                    if (!be.kS(str22)) {
                        if (!v.Ei(str22)) {
                            str22 = v.S(En, str3, str22);
                        }
                        String Eq = v.Eq(str22);
                        if (be.kS(Eq)) {
                            Eq = "1";
                        }
                        str6 = v.Ep(str22);
                        if (be.kS(str6) || !s.HZ(str6)) {
                            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, illegal url = %s", new Object[]{str6});
                        } else {
                            String Eo = v.Eo(str6);
                            p biL = p.biL();
                            i i3 = !biL.lfs ? null : (be.kS(str) || be.kS(str4) || be.kS(Eo)) ? null : biL.i(String.format("select * from %s where %s=? and %s=? and %s=? and %s=? order by %s desc", new Object[]{"WebViewResourceCache", "appId", "domain", "cacheType", "urlMd5Hashcode", "createTime"}), str, str4, "1", String.valueOf(z.Kg(Eo).hashCode()));
                            if (i3 == null) {
                                i iVar = new i();
                                iVar.field_url = Eo;
                                iVar.field_appId = str;
                                iVar.field_domain = str4;
                                iVar.field_version = Eq;
                                iVar.field_isLatestVersion = true;
                                iVar.field_createTime = be.Nh();
                                iVar.field_accessTime = be.Nh();
                                iVar.field_cacheType = 1;
                                iVar.field_configId = null;
                                iVar.field_protocol = str6.startsWith("https://") ? com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU : com.tencent.mm.plugin.webview.modelcache.b.a.HTTP.bkU;
                                iVar.field_packageId = str5;
                                p.biL().insert(iVar, i, i2);
                                b.lgu.lgi.a(iVar, i, i2);
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, new cacheRes = %s", new Object[]{iVar});
                            } else if (!Eq.equals(i3.field_version)) {
                                i3.field_contentMd5 = null;
                                i3.field_contentType = null;
                                i3.field_createTime = be.Nh();
                                i3.field_accessTime = be.Nh();
                                p.biL().update(i3, i, i2);
                                b.lgu.lgi.a(i3, i, i2);
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, updated cacheRes = %s", new Object[]{i3});
                            } else if (v.g(i3)) {
                                j.tl(i).x(i2, "cache", "ok");
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, queried cacheRes = %s", new Object[]{i3});
                            } else {
                                i3.field_isLatestVersion = true;
                                p.biL().update(i3, i, i2);
                                b.lgu.lgi.a(i3, i, i2);
                            }
                            v.d("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncResource, submit request = %s", new Object[]{new g(str6, Eq, str, str4, str5, 1)});
                            WebViewCacheDownloadHelper.biQ().a(r4);
                        }
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadSyncCacheResource, exception = %s", new Object[]{e});
            }
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int lfK;
        final /* synthetic */ int lfL;
        final /* synthetic */ l lfM;
        final /* synthetic */ String lfN;

        public AnonymousClass2(l lVar, String str, int i, int i2) {
            this.lfM = lVar;
            this.lfN = str;
            this.lfK = i;
            this.lfL = i2;
        }

        public final void run() {
            byte[] Er = v.Er(this.lfN);
            if (be.bl(Er)) {
                v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloaderPublicResource, get null bytes from configURL");
                j.tl(this.lfK).x(this.lfL, "publicCache", "fail");
                return;
            }
            String str = new String(Er);
            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, config json Result = %s", new Object[]{str});
            if (be.kS(str)) {
                v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, get empty json, publicCacheConfigURL = %s", new Object[]{this.lfN});
                j.tl(this.lfK).x(this.lfL, "publicCache", "fail");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                long bo = be.bo(Er);
                String string = jSONObject.getString("name");
                if (be.kS(string)) {
                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicCache, get null or nil configName from cacheConfig");
                    j.tl(this.lfK).x(this.lfL, "publicCache", "fail");
                    return;
                }
                String Kg = z.Kg(string);
                string = String.format("%s_%s_%s", new Object[]{"PublicShareResAppId", "PublicShareResDomain", z.Kg(string)});
                JSONObject jSONObject2 = jSONObject.getJSONObject("manifest");
                if (jSONObject2 == null) {
                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, get null manifest obj");
                    j.tl(this.lfK).x(this.lfL, "publicCache", "fail");
                    return;
                }
                j Eh = e.bjg().Eh(string);
                if (Eh == null) {
                    Eh = new j();
                    Eh.field_configCrc32 = bo;
                    Eh.field_configId = string;
                    Eh.field_configResources = jSONObject2.toString();
                    Eh.field_configUrl = this.lfN;
                    Eh.field_disable = false;
                    e.bjg().b(Eh);
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, new mapRecord = %s", new Object[]{Eh});
                } else if (Eh.field_configCrc32 != bo) {
                    Eh.field_configCrc32 = bo;
                    Eh.field_configId = string;
                    Eh.field_configResources = jSONObject2.toString();
                    Eh.field_configUrl = this.lfN;
                    Eh.field_disable = false;
                    e.bjg().a(Eh);
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, updated mapRecord = %s", new Object[]{Eh});
                } else {
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, queried mapRecord = %s", new Object[]{Eh});
                }
                List linkedList = new LinkedList();
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (!be.kS(str2)) {
                        String string2 = jSONObject2.getString(str2);
                        String Ep = v.Ep(str2);
                        if (v.Es(Ep)) {
                            String Eo = v.Eo(Ep);
                            i b = p.biL().b("PublicShareResAppId", "PublicShareResDomain", 3, Eo, Kg);
                            if (b == null) {
                                b = new i();
                                b.field_url = Eo;
                                b.field_appId = "PublicShareResAppId";
                                b.field_domain = "PublicShareResDomain";
                                b.field_version = string2;
                                b.field_isLatestVersion = true;
                                b.field_createTime = be.Nh();
                                b.field_accessTime = be.Nh();
                                b.field_cacheType = 3;
                                b.field_configId = null;
                                b.field_protocol = com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU;
                                b.field_packageId = Kg;
                                p.biL().insert(b, this.lfK, this.lfL);
                                b.lgu.lgi.a(b, this.lfK, this.lfL);
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, new cacheResRecord = %s", new Object[]{b});
                            } else if (!be.ma(b.field_version).equals(string2)) {
                                b.field_localPath = null;
                                b.field_version = string2;
                                b.field_contentMd5 = null;
                                p.biL().update(b, this.lfK, this.lfL);
                                b.lgu.lgi.a(b, this.lfK, this.lfL);
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, updated cacheResRecord = %s", new Object[]{b});
                                linkedList.add(new g(Ep, string2, "PublicShareResAppId", "PublicShareResDomain", Kg, 3));
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, added request = %s", new Object[]{r0});
                            } else if (v.g(b)) {
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, queried cacheResRecord = %s", new Object[]{b});
                            }
                            linkedList.add(new g(Ep, string2, "PublicShareResAppId", "PublicShareResDomain", Kg, 3));
                            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, added request = %s", new Object[]{r0});
                        } else {
                            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, not public cache, return to msgHandler to callback, url = %s", new Object[]{Ep});
                            j.tl(this.lfK).x(this.lfL, "publicCache", "fail");
                            return;
                        }
                    }
                }
                if (be.bP(linkedList)) {
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, get empty request list, all requested resources cached");
                    j.tl(this.lfK).x(this.lfL, "publicCache", "ok");
                    return;
                }
                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, submit request list size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                WebViewCacheDownloadHelper.biQ().bG(linkedList);
            } catch (Exception e) {
                v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadPublicResource, e = " + e);
            }
        }
    }

    private static final class a extends Exception {
        private final String bsI;
        private final String lfC;

        private a(String str, String str2) {
            this.bsI = str;
            this.lfC = str2;
        }
    }

    private static final class b extends Exception {
        private final String url;

        private b(String str) {
            this.url = str;
        }
    }

    public static boolean biJ() {
        if (ak.uz()) {
            ak.yW();
            if (((Boolean) c.vf().get(com.tencent.mm.storage.t.a.nrI, Boolean.valueOf(true))).booleanValue()) {
                return true;
            }
            v.i("MicroMsg.WebViewCacheResDownloadOperator", "checkCanDoDownload, download is disabled");
            return false;
        }
        v.i("MicroMsg.WebViewCacheResDownloadOperator", "checkCanDoDownload, account db not ready");
        return false;
    }

    public final void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (biJ()) {
            if (c.biH()) {
                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, appId = %s, mainDocumentURL = %s, asyncCacheConfigURL = %s, msgHandlerId = %s, msgId = %s", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)});
                if (be.kS(str2) || be.kS(str) || be.kS(str3)) {
                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, appid or json download url is null");
                    if (z) {
                        j.tl(i).x(i2, "cache", "fail");
                        return;
                    }
                    return;
                }
                String str4;
                if (v.Ei(str3)) {
                    str4 = str3;
                } else {
                    str4 = v.En(str2) + "/" + str3;
                }
                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, realConfigURL = %s", new Object[]{str4});
                final String Em = v.Em(str2);
                if (be.kS(Em)) {
                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, get null or nil domain from mainDocumentURL");
                    if (z) {
                        j.tl(i).x(i2, "cache", "fail");
                        return;
                    }
                    return;
                }
                final boolean z2 = z;
                final int i3 = i;
                final int i4 = i2;
                final String str5 = str;
                final String str6 = str2;
                b.lgu.vA().x(new Runnable(this) {
                    final /* synthetic */ l lfM;

                    public final void run() {
                        byte[] Er = v.Er(str4);
                        if (be.bl(Er)) {
                            v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, get null bytes from asyncConfigURL");
                            return;
                        }
                        String str = new String(Er);
                        v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, config json Result = %s", new Object[]{str});
                        try {
                            if (!be.kS(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                long bo = be.bo(Er);
                                boolean optBoolean = jSONObject.optBoolean("disable", false);
                                String string = jSONObject.getString("name");
                                if (be.kS(string)) {
                                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, get null or nil cofingName from cacheConfig");
                                    if (z2) {
                                        j.tl(i3).x(i4, "cache", "fail");
                                        return;
                                    }
                                    return;
                                }
                                String Kg = z.Kg(string);
                                String format = String.format("%s_%s_%s", new Object[]{str5, Em, Kg});
                                if (optBoolean) {
                                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "asyncCache disabled, config name = %s", new Object[]{string});
                                    b.lgu.lgh.Ee(format);
                                    if (z2) {
                                        j.tl(i3).x(i4, "cache", "ok");
                                        return;
                                    }
                                    return;
                                }
                                JSONObject jSONObject2 = jSONObject.getJSONObject("manifest");
                                if (jSONObject2 == null) {
                                    v.e("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, get null manifest obj");
                                    if (z2) {
                                        j.tl(i3).x(i4, "cache", "fail");
                                        return;
                                    }
                                    return;
                                }
                                j Eh = e.bjg().Eh(format);
                                if (Eh == null) {
                                    Eh = new j();
                                    Eh.field_disable = optBoolean;
                                    Eh.field_configId = format;
                                    Eh.field_configUrl = str4;
                                    Eh.field_configResources = jSONObject2.toString();
                                    Eh.field_configCrc32 = bo;
                                    Eh.field_isFromXml = false;
                                    e.bjg().b(Eh);
                                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, new config map = %s", new Object[]{Eh});
                                } else if (Eh.field_configCrc32 != bo) {
                                    Eh.field_disable = optBoolean;
                                    Eh.field_configId = format;
                                    Eh.field_configUrl = str4;
                                    Eh.field_configResources = jSONObject2.toString();
                                    Eh.field_configCrc32 = bo;
                                    Eh.field_isFromXml = false;
                                    e.bjg().a(Eh);
                                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, updated config map = %s", new Object[]{Eh});
                                } else {
                                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, queried config map = %s", new Object[]{Eh});
                                    if (z2) {
                                        j.tl(i3).x(i4, "cache", "config data not change");
                                    }
                                }
                                String optString = jSONObject.optString("base");
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("page");
                                Collection b = l.a(str6, str5, Em, optString, format, Kg, jSONObject3, jSONObject3.keys(), true, i3, i4, z2);
                                jSONObject3 = jSONObject2.getJSONObject("resource");
                                Collection b2 = l.a(str6, str5, Em, optString, format, Kg, jSONObject3, jSONObject3.keys(), false, i3, i4, z2);
                                List linkedList = new LinkedList();
                                linkedList.addAll(b);
                                linkedList.addAll(b2);
                                if (be.bP(linkedList)) {
                                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, get empty request list, all requested resources cached");
                                    if (z2) {
                                        j.tl(i3).x(i4, "cache", "ok");
                                        return;
                                    }
                                    return;
                                }
                                v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, submit request list size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                                WebViewCacheDownloadHelper.biQ().bG(linkedList);
                            }
                        } catch (b e) {
                            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, illegal requestURL = %s", new Object[]{e.url});
                            if (z2) {
                                j.tl(i3).x(i4, "cache", "fail");
                            }
                        } catch (a e2) {
                            v.i("MicroMsg.WebViewCacheResDownloadOperator", "downloadAsyncResource, crossDomainPageResource, targetDomain = %s, reqURL = %s", new Object[]{e2.bsI, e2.lfC});
                            if (z2) {
                                j.tl(i3).x(i4, "cache", "not support cross domain page");
                            }
                        } catch (Exception e3) {
                            v.e("MicroMsg.WebViewCacheResDownloadOperator", "startDownloadAsyncResource, e = " + e3);
                            if (z2) {
                                j.tl(i3).x(i4, "cache", "fail");
                            }
                        }
                    }
                });
            } else if (z) {
                j.tl(i).x(i2, "cache", "not in white list");
            }
        } else if (z) {
            j.tl(i).x(i2, "cache", "fail");
        }
    }

    private static List<g> a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, Iterator<String> it, boolean z, int i, int i2, boolean z2) {
        List<g> linkedList = new LinkedList();
        while (it.hasNext()) {
            String str7 = (String) it.next();
            String string = jSONObject.getString(str7);
            if (!(be.kS(str7) || be.kS(string))) {
                if (!v.Ei(str7)) {
                    str7 = v.S(v.En(str), str4, str7);
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "iterateAsyncResource, isPage = %b, combinedRequestURL = %s", new Object[]{Boolean.valueOf(z), str7});
                } else if (z && !str3.equals(v.Em(str7))) {
                    throw new a(str3, str7);
                }
                String Ep = v.Ep(str7);
                if (be.kS(Ep) || !s.HZ(Ep)) {
                    throw new b(Ep);
                }
                String Eo = v.Eo(Ep);
                i b = p.biL().b(str2, str3, 2, Eo, str6);
                if (b == null) {
                    b = new i();
                    b.field_url = Eo;
                    b.field_appId = str2;
                    b.field_domain = str3;
                    b.field_version = string;
                    b.field_contentType = null;
                    b.field_isLatestVersion = true;
                    b.field_createTime = be.Nh();
                    b.field_accessTime = be.Nh();
                    b.field_cacheType = 2;
                    b.field_configId = str5;
                    b.field_protocol = Ep.startsWith("https://") ? com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU : com.tencent.mm.plugin.webview.modelcache.b.a.HTTP.bkU;
                    b.field_packageId = str6;
                    if (z2) {
                        p.biL().insert(b, i, i2);
                        b.lgu.lgi.a(b, i, i2);
                    } else {
                        p.biL().d(b);
                    }
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "iterateAsyncResource, isPage = %b, new cacheResInfo = %s", new Object[]{Boolean.valueOf(z), b});
                } else if (!string.equals(b.field_version)) {
                    b.field_version = string;
                    b.field_contentType = null;
                    b.field_isLatestVersion = true;
                    b.field_createTime = be.Nh();
                    b.field_accessTime = be.Nh();
                    b.field_cacheType = 2;
                    b.field_configId = str5;
                    b.field_protocol = Ep.startsWith("https://") ? com.tencent.mm.plugin.webview.modelcache.b.a.HTTPS.bkU : com.tencent.mm.plugin.webview.modelcache.b.a.HTTP.bkU;
                    b.field_packageId = str6;
                    if (z2) {
                        p.biL().update(b, i, i2);
                        b.lgu.lgi.a(b, i, i2);
                    } else {
                        p.biL().e(b);
                    }
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "iterateAsyncResource, isPage = %b, updated cacheResInfo = %s", new Object[]{Boolean.valueOf(z), b});
                } else if (v.g(b)) {
                    v.i("MicroMsg.WebViewCacheResDownloadOperator", "iterateAsyncCacheFiles, queried cacheResInfo = %s", new Object[]{b});
                    b.field_isLatestVersion = true;
                    if (z2) {
                        p.biL().update(b, i, i2);
                        b.lgu.lgi.a(b, i, i2);
                    } else {
                        p.biL().e(b);
                    }
                } else {
                    b.field_isLatestVersion = true;
                    if (z2) {
                        p.biL().update(b, i, i2);
                        b.lgu.lgi.a(b, i, i2);
                    } else {
                        p.biL().e(b);
                    }
                }
                v.i("MicroMsg.WebViewCacheResDownloadOperator", "iterateAsyncResource, isPage = %b, added request = %s", new Object[]{Boolean.valueOf(z), new g(Ep, string, str2, str3, str6, 2)});
                linkedList.add(r2);
            }
        }
        return linkedList;
    }
}
