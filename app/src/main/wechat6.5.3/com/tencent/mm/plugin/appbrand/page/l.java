package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class l extends MMWebView implements com.tencent.mm.plugin.appbrand.b {
    public String dOM;
    public String dON;
    public m dOO;
    public b dOP;
    private long dOQ;
    private String dOR = null;
    String dOS = null;
    long dOT;
    private LinkedList<Pair<String, String>> dOU = new LinkedList();
    private x dOV = new x(this) {
        final /* synthetic */ l dOX;

        {
            this.dOX = r1;
        }

        public final boolean p(MotionEvent motionEvent) {
            return this.dOX.z(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.dOX.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void RC() {
            this.dOX.bKp();
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            this.dOX.c(i, i2, z, z2);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (this.dOX.dOP != null) {
                this.dOX.dOP.onScrollChanged(i, i2, i3, i4, view);
            }
            this.dOX.r(i, i2, i3, i4);
        }

        public final boolean q(MotionEvent motionEvent) {
            return this.dOX.A(motionEvent);
        }

        public final boolean r(MotionEvent motionEvent) {
            return this.dOX.B(motionEvent);
        }
    };
    private ProxyWebViewClientExtension dOW = new ProxyWebViewClientExtension(this) {
        final /* synthetic */ l dOX;

        {
            this.dOX = r1;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.dOX.dOV.p(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.dOX.dOV.r(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.dOX.dOV.q(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.dOX.dOV.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.dOX.dOV.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.dOX.dOV.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            this.dOX.dOV.RC();
        }

        public final boolean onShowLongClickPopupMenu() {
            if (WebView.getTbsCoreVersion(this.dOX.getContext()) >= 43011) {
                return false;
            }
            return true;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            if (be.kS(str) || bundle == null) {
                return null;
            }
            v.i("MicroMsg.AppBrandWebView", "method = %s", new Object[]{str});
            if (!str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
                return null;
            }
            String string = bundle.getString("url");
            if (be.kS(string)) {
                return null;
            }
            AppBrandLocalMediaObject az = c.az(this.dOX.dzg, string);
            if (az == null) {
                v.e("MicroMsg.AppBrandWebView", "get meidiaobj failed, appid : %s, localid :%s", new Object[]{this.dOX.dzg, string});
                return null;
            }
            Object obj = az.cvK;
            v.i("MicroMsg.AppBrandWebView", new StringBuilder(DownloadInfoColumns.FILEPATH).append(obj).append("tempFilePath").append(string).toString());
            return obj;
        }
    };
    boolean dzD = false;
    String dzg;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int dEU;
        final /* synthetic */ l dOX;
        final /* synthetic */ String dOY;

        AnonymousClass5(l lVar, int i, String str) {
            this.dOX = lVar;
            this.dEU = i;
            this.dOY = str;
        }

        public final void run() {
            this.dOX.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(this.dEU), this.dOY}), null);
        }
    }

    private class a extends WebViewClient {
        final /* synthetic */ l dOX;

        private a(l lVar) {
            this.dOX = lVar;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            v.i("MicroMsg.AppBrandWebView", "onPageStarted, url = %s", new Object[]{str});
            this.dOX.dzD = false;
        }

        public final void onPageFinished(WebView webView, String str) {
            v.i("MicroMsg.AppBrandWebView", "onPageFinished, url = %s", new Object[]{str});
            if (!this.dOX.dzD) {
                this.dOX.dzD = true;
                l.c(this.dOX);
                com.tencent.mm.plugin.appbrand.report.a.n(3, System.currentTimeMillis() - this.dOX.dOQ);
                if (this.dOX.dOM != null) {
                    v.i("MicroMsg.AppBrandWebView", "Inject page on frame load finished");
                    this.dOX.oh(this.dOX.dOM);
                }
                l.f(this.dOX);
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            v.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
            return true;
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            v.e("MicroMsg.AppBrandWebView", "SSL Error, Page URL: %s, Code %d", new Object[]{this.dOX.dOM, Integer.valueOf(sslError.getPrimaryError())});
            sslErrorHandler.cancel();
        }

        private WebResourceResponse oi(String str) {
            WebResourceResponse ar;
            boolean z;
            if (str.startsWith(this.dOX.RA())) {
                ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(this.dOX.dzg, str.replace(this.dOX.RA(), ""));
            } else if (str.startsWith("wxfile://")) {
                AppBrandLocalMediaObject az = c.az(this.dOX.dzg, str);
                if (az != null) {
                    try {
                        ar = new WebResourceResponse(az.mimeType, ProtocolPackage.ServerEncoding, new FileInputStream(az.cvK));
                    } catch (Throwable e) {
                        v.e("MicroMsg.AppBrandWebView", "tryInterceptWebViewRequest with localId(%s), exp = %s", new Object[]{str, be.e(e)});
                    }
                }
                ar = null;
            } else {
                ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(this.dOX.dzg, str);
            }
            String str2 = "MicroMsg.AppBrandWebView";
            String str3 = "tryInterceptWebViewRequest, reqURL = %s, WebResourceResponse == null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (ar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            v.i(str2, str3, objArr);
            return ar;
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (be.kS(str)) {
                return null;
            }
            return oi(str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || be.kS(webResourceRequest.getUrl().toString())) {
                return null;
            }
            return oi(webResourceRequest.getUrl().toString());
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || be.kS(webResourceRequest.getUrl().toString())) {
                return null;
            }
            return oi(webResourceRequest.getUrl().toString());
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            v.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[]{Integer.valueOf(i), str, str2});
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, com.tencent.smtt.sdk.WebViewClient.a aVar) {
            Uri url = webResourceRequest.getUrl();
            String uri = url == null ? "null" : url.toString();
            v.e("MicroMsg.AppBrandWebView", "onReceivedError, WebResourceRequest url = %s, description = %s, errCode = %d", new Object[]{uri, aVar.getDescription(), Integer.valueOf(aVar.getErrorCode())});
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Uri url = webResourceRequest.getUrl();
            String uri = url == null ? "null" : url.toString();
            v.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[]{uri, webResourceResponse.getMimeType(), Integer.valueOf(webResourceResponse.getStatusCode())});
        }
    }

    public interface b {
        void onScrollChanged(int i, int i2, int i3, int i4, View view);
    }

    static /* synthetic */ String bRy() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }

    static /* synthetic */ void c(l lVar) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        Object obj = (com.tencent.mm.plugin.appbrand.a.mr(lVar.dzg).dDp && com.tencent.mm.plugin.appbrand.a.mr(lVar.dzg).dDB.dBr == 1) ? 1 : null;
        if (obj != null) {
            str = com.tencent.mm.plugin.appbrand.appcache.b.aq(lVar.dzg, "WAVConsole.js");
        }
        str = stringBuilder.append(str).append(com.tencent.mm.plugin.appbrand.appcache.b.aq(lVar.dzg, "WAWebview.js")).toString();
        g.iuh.a(370, 1, 1, false);
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandWebView", "get Null Or Nil page js");
            g.iuh.a(370, 2, 1, false);
            return;
        }
        com.tencent.mm.plugin.appbrand.k.c.a(lVar.getContext(), lVar, str, new com.tencent.mm.plugin.appbrand.k.c.a(lVar) {
            final /* synthetic */ l dOX;

            {
                this.dOX = r1;
            }

            public final void onSuccess() {
                g.iuh.a(370, 3, 1, false);
            }

            public final void OK() {
                v.e("MicroMsg.AppBrandWebView", "page inject library js fail");
                g.iuh.a(370, 2, 1, false);
                com.tencent.mm.plugin.appbrand.report.a.S(this.dOX.dzg, 24);
            }
        });
    }

    static /* synthetic */ void f(l lVar) {
        Iterator it = lVar.dOU.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            lVar.aP((String) pair.first, (String) pair.second);
        }
        lVar.dOU.clear();
    }

    public l(Context context, String str) {
        boolean z;
        super(context);
        this.dzg = str;
        this.dOQ = System.currentTimeMillis();
        eO(getContext());
        this.cfB = true;
        if (getX5WebViewExtension() != null) {
            z = true;
        } else {
            z = false;
        }
        this.pdG = z;
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
        getSettings().setUserAgentString(s.aW(getContext(), getSettings().getUserAgentString()));
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(new a());
        setWebViewCallbackClient(this.dOV);
        if (this.pdG) {
            getX5WebViewExtension().setWebViewClientExtension(this.dOW);
        }
        v.i("MicroMsg.AppBrandWebView", "Is the current broswer kernel X5, " + this.pdG);
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ l dOX;

            {
                this.dOX = r1;
            }

            public final boolean onLongClick(View view) {
                if (WebView.getTbsCoreVersion(this.dOX.getContext()) >= 43011) {
                    return false;
                }
                return true;
            }
        });
        setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ l dOX;

            {
                this.dOX = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                v.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
            }
        });
        this.dOO = new m(this);
    }

    public final void OE() {
        this.dOO.dPa.clear();
    }

    public final void destroy() {
        OE();
        super.destroy();
    }

    final String RA() {
        if (this.dOR == null) {
            this.dOR = "https://servicewechat.com/" + this.dzg + "/" + com.tencent.mm.plugin.appbrand.a.mr(this.dzg).dDB.dBs + "/";
        }
        return this.dOR;
    }

    final void oh(String str) {
        this.dOT = System.currentTimeMillis();
        String aq = com.tencent.mm.plugin.appbrand.appcache.b.aq(this.dzg, str);
        if (be.kS(aq)) {
            v.e("MicroMsg.AppBrandWebView", "Cache content empty, abort inject");
            return;
        }
        int indexOf = aq.indexOf("<style>");
        int indexOf2 = aq.indexOf("</style>");
        String substring = (indexOf == -1 || indexOf2 == (-indexOf)) ? "" : aq.substring(indexOf + 7, indexOf2);
        String encodeToString = Base64.encodeToString(substring.getBytes(), 2);
        indexOf = aq.indexOf("<page>");
        int indexOf3 = aq.indexOf("</page>");
        substring = (indexOf == -1 || indexOf3 == (-indexOf)) ? "" : aq.substring(indexOf + 6, indexOf3);
        String encodeToString2 = Base64.encodeToString(substring.getBytes(), 2);
        indexOf = aq.indexOf("<script>");
        int indexOf4 = aq.indexOf("</script>");
        substring = (indexOf == -1 || indexOf4 == (-indexOf)) ? "" : aq.substring(indexOf + 8, indexOf4);
        evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s", new Object[]{encodeToString, encodeToString2, substring}), null);
    }

    public final void aP(final String str, String str2) {
        if (be.kS(str2)) {
            str2 = "{}";
        }
        if (this.dzD) {
            v.d("MicroMsg.AppBrandWebView", "dispatch, event: %s, data size: %d", new Object[]{str, Integer.valueOf(str2.length())});
            post(new Runnable(this) {
                final /* synthetic */ l dOX;

                public final void run() {
                    this.dOX.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, undefined, %s)", new Object[]{str, str2, l.bRy()}), null);
                }
            });
            return;
        }
        this.dOU.add(new Pair(str, str2));
    }
}
