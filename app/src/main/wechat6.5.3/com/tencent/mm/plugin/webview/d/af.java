package com.tencent.mm.plugin.webview.d;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af {
    private int leu = -1;
    public ArrayList<String> lev = new ArrayList();
    public ArrayList<String> lew = new ArrayList();
    public List<Integer> lex = new ArrayList();
    public final Map<String, Boolean> ley = new HashMap();
    public final Set<String> lez = new HashSet();

    public final WebResourceResponse a(String str, String str2, boolean z, d dVar, int i) {
        if (be.kS(str2)) {
            v.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (be.kS(str2) || !str2.startsWith("weixin://resourceid/")) {
            if (z) {
                int intValue;
                if (!be.kS(str2) && com.tencent.mm.plugin.webview.modelcache.v.Ei(str2)) {
                    String toLowerCase = str2.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains(s.bre())) {
                        if (this.lex != null && this.lex.size() > 0) {
                            for (Integer intValue2 : this.lex) {
                                intValue = intValue2.intValue();
                                if (!toLowerCase.contains("localhost:" + intValue)) {
                                    if (toLowerCase.contains("127.0.0.1:" + intValue)) {
                                    }
                                }
                                v.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[]{toLowerCase, Integer.valueOf(intValue)});
                            }
                        }
                        v.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[]{toLowerCase});
                        intValue = 1;
                    }
                    intValue = 0;
                    break;
                }
                intValue = 0;
                if (intValue != 0) {
                    v.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[]{str2});
                    return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                }
            }
            if (a(str2, dVar)) {
                v.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[]{str2});
                return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
            }
            WebResourceResponse webResourceResponse;
            if (be.kS(str)) {
                v.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, mainDocumentURL is null or nil, let webview itself do the loading, requestURL = %s", new Object[]{str2});
                webResourceResponse = null;
            } else if (dVar == null) {
                v.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, invoker is null, let webview itself do the loading");
                webResourceResponse = null;
            } else {
                v.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, currentURL = %s, requestURL = %s", new Object[]{str, str2});
                if (be.kS(str) || be.kS(str2)) {
                    v.i("MicroMsg.WebViewResourceInterrupter", "requestURL or mainDocumentURL is invalid");
                    webResourceResponse = null;
                } else {
                    webResourceResponse = a.lgb.lfY.a(str, str2, dVar, i);
                }
            }
            if (webResourceResponse == null) {
                return null;
            }
            return webResourceResponse;
        } else {
            v.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                InputStream inputStream;
                String bl = dVar.bl(str2, 1);
                if (be.kS(bl)) {
                    v.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
                    inputStream = null;
                } else {
                    inputStream = ah.Ea(bl);
                }
                return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, inputStream);
            } catch (Exception e) {
                v.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }

    private boolean a(String str, d dVar) {
        Iterator it;
        if (this.leu == -1) {
            try {
                Bundle i = dVar.i(31, null);
                if (i != null) {
                    this.leu = i.getInt("webview_ad_intercept_control_flag");
                    this.lev = i.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.lew = i.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.lev.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.lew.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    v.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e) {
                v.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[]{e.getMessage()});
                this.leu = 0;
            }
        }
        if (this.leu == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        v.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[]{host, this.ley.get(host)});
        if (be.kS(host)) {
            return false;
        }
        if (this.ley.containsKey(host)) {
            return ((Boolean) this.ley.get(host)).booleanValue();
        }
        if (this.lev != null && this.lev.size() > 0) {
            it = this.lev.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    this.ley.put(host, Boolean.valueOf(false));
                    v.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                    return false;
                }
            }
        }
        if (this.lew != null && this.lew.size() > 0) {
            it = this.lew.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    if (this.leu == 1) {
                        this.ley.put(host, Boolean.valueOf(true));
                        v.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[]{r0, str});
                        return true;
                    } else if (this.leu == 2) {
                        v.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[]{r0, str});
                        this.lez.add(host);
                        this.ley.put(host, Boolean.valueOf(false));
                        return false;
                    }
                }
            }
        }
        this.ley.put(host, Boolean.valueOf(false));
        return false;
    }
}
