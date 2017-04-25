package com.tencent.mm.plugin.webview.modelcache;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.InputStream;

public final class m {
    m() {
    }

    public final WebResourceResponse a(String str, String str2, d dVar, int i) {
        return b(str, str2, dVar, i);
    }

    final WebResourceResponse b(String str, String str2, d dVar, int i) {
        Boolean bool = (Boolean) a.lgb.lga.get(i);
        boolean z = bool == null ? true : !bool.booleanValue();
        if (!z) {
            v.i("MicroMsg.WebViewCacheResInterceptor", "getWebResourceResponse, webViewUI(%d) can't load cachedWebResource this time", new Object[]{Integer.valueOf(i)});
            return null;
        } else if (be.kS(str) || be.kS(str2) || dVar == null) {
            v.e("MicroMsg.WebViewCacheResInterceptor", "getWebResourceResponse, invalid params, mainURL = %s, reqURL = %s, invoker = %s", new Object[]{str, str2, dVar});
            return null;
        } else if (!v.Ei(str2)) {
            return null;
        } else {
            if (!s.HZ(str2)) {
                return null;
            }
            if (str2.contains("#wechat_redirect")) {
                v.i("MicroMsg.WebViewCacheResInterceptor", "reqURL = %s, is wechat_redirect and ignore", new Object[]{str2});
                return null;
            }
            if (v.Es(str2)) {
                WebResourceResponse a = a(dVar, str, str2, i);
                if (a != null) {
                    s.h(12682, str, str2, Boolean.valueOf(true));
                    return a;
                }
                s.h(12682, str, str2, Boolean.valueOf(false));
            }
            return a(dVar, str, str2, i);
        }
    }

    private static WebResourceResponse a(d dVar, String str, String str2, int i) {
        h hVar = new h(str2, str, i);
        Bundle bundle = new Bundle(3);
        if (!be.kS(hVar.lfC)) {
            bundle.putByteArray("webview_resource_cache_requestURL", q.k(hVar.lfC.getBytes()));
        }
        if (!be.kS(hVar.lfE)) {
            bundle.putByteArray("webview_resource_cache_mainDocURL", q.k(hVar.lfE.getBytes()));
        }
        bundle.putInt("webview_resource_cache_binderId", hVar.ldX);
        try {
            Bundle i2 = dVar.i(26, bundle);
            v.i("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, get data = %s", new Object[]{i2});
            if (i2 != null) {
                if (i2.getBoolean("webview_resource_cache_inWhiteList", true)) {
                    o oVar;
                    q qVar = new q(i2.getString("webview_resource_cache_appId"), i2.getString("webview_resource_cache_domain"), i2.getString("webview_resource_cache_filePath"), i2.getLong("webview_resource_cache_contentLength"), i2.getString("webview_resource_cache_contentType"), i2.getInt("webview_resource_cache_cacheType"));
                    v.i("MicroMsg.WebViewCacheResWrapper", "fromBundle = %s", new Object[]{qVar.toString()});
                    u biN = a.lgb;
                    String str3 = qVar.filePath;
                    if (be.kS(str3)) {
                        v.e("MicroMsg.WebViewCacheToolsManager", "getWebViewCacheResReader failed, filePath is null");
                        oVar = null;
                    } else {
                        v.i("MicroMsg.WebViewCacheToolsManager", "getWebViewCacheResReader, filePath = %s", new Object[]{str3});
                        oVar = (o) biN.lfZ.get(str3.hashCode());
                        if (oVar == null) {
                            oVar = new o(str3);
                            biN.lfZ.put(str3.hashCode(), oVar);
                        }
                    }
                    if (oVar != null) {
                        InputStream openRead = FileOp.openRead(oVar.filePath);
                        if (openRead == null || openRead.available() <= 0) {
                            v.e("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, hit in db but file not found");
                            if (v.Es(str2)) {
                                s.dv(9);
                            } else {
                                s.dv(4);
                            }
                        } else if (openRead.available() > 5242880) {
                            v.i("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, load resource > 5m, return null");
                            s.dv(6);
                            return null;
                        } else {
                            s.h(12702, str2, Integer.valueOf(w.sb()));
                            if (qVar.bsK != 3 && be.ma(v.Ep(str)).equals(v.Ep(str2))) {
                                s.dv((long) (qVar.bsK == 2 ? 14 : 13));
                            }
                            a Ik = a.Ik(qVar.bsL);
                            if (Ik == null) {
                                v.i("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, get unrecognized contentType = %s, reqURL = %s", new Object[]{qVar.bsL, str2});
                                return new WebResourceResponse(qVar.bsL, "UTF-8", openRead);
                            }
                            v.i("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, get obtained contentType = %s, reqURL = %s", new Object[]{Ik, str2});
                            return new WebResourceResponse(Ik.mimeType, Ik.charset, openRead);
                        }
                    }
                    v.e("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, get null cacheReader???");
                    s.dv(4);
                } else {
                    v.i("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, not in white list, will spare rest queries of this WebViewUI");
                    a.lgb.O(i, false);
                    return null;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.WebViewCacheResInterceptor", "remoteQuery, exception = %s", new Object[]{e});
            if (e instanceof RemoteException) {
                if (v.Es(str2)) {
                    s.dv(16);
                } else {
                    s.dv(15);
                }
            } else if (v.Es(str2)) {
                s.dv(9);
            } else {
                s.dv(3);
            }
        }
        return null;
    }
}
