package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.u;

public final class h {
    private static String lpd = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    private WebView liG;
    private f lkl;
    private boolean loD = false;
    private String loE = "";
    a loY;
    private boolean loZ = false;
    public boolean lpa = true;
    public boolean lpb = false;
    private final ah lpc = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ h lpe;

        {
            this.lpe = r1;
        }

        public final boolean oU() {
            h hVar = this.lpe;
            boolean hI = hVar.hI(false);
            v.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[]{Boolean.valueOf(hI)});
            if (hI && hVar.loY != null) {
                hVar.loY.bkG();
            }
            g.iuh.a(156, 1, 1, false);
            if (!hI) {
                g.iuh.a(156, 0, 1, false);
            }
            return false;
        }
    }, true);

    public interface a {
        void bkG();
    }

    public h(WebView webView, f fVar, a aVar, boolean z) {
        this.liG = webView;
        this.lkl = fVar;
        this.loY = aVar;
        this.loZ = z;
        v.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b", new Object[]{Boolean.valueOf(z)});
    }

    public final void bll() {
        this.loD = true;
        this.loE = be.but();
        v.i("MicroMsg.JsLoader", "js digest verification randomStr = ", new Object[]{this.loE});
        if (this.lkl != null) {
            f fVar = this.lkl;
            String str = this.loE;
            fVar.loD = true;
            fVar.loE = str;
        }
    }

    public final void detach() {
        v.v("MicroMsg.JsLoader", "detach");
        this.liG = null;
        this.lkl = null;
        this.loY = null;
    }

    public final void blm() {
        v.v("MicroMsg.JsLoader", "onPageStarted");
        if (!this.lpc.btC()) {
            this.lpc.QI();
            v.i("MicroMsg.JsLoader", "tryStopTimer success");
        }
    }

    public final void bln() {
        v.v("MicroMsg.JsLoader", "onPageFinished");
        if (this.lpc.btC()) {
            this.lpc.ea(this.loZ ? 0 : 1000);
            v.i("MicroMsg.JsLoader", "tryStartTimer success");
        }
    }

    final boolean hI(boolean z) {
        String e;
        try {
            e = be.e(this.liG.getContext().getAssets().open("jsapi/wxjs.js"));
            if (this.loD) {
                e = e.replace("isUseMd5_check", "yes").replace("xx_yy", this.loE);
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.JsLoader", e2, "", new Object[0]);
            e = null;
        }
        if (e == null) {
            v.e("MicroMsg.JsLoader", "loadJavaScript fail, jsContent is null");
            return false;
        } else if (this.liG == null) {
            v.e("MicroMsg.JsLoader", "loadJavaScript, viewWV is null");
            return false;
        } else {
            this.liG.evaluateJavascript("javascript:" + e, new u<String>(this) {
                final /* synthetic */ h lpe;

                {
                    this.lpe = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    v.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret = %s", new Object[]{(String) obj});
                }
            });
            if (this.lkl == null) {
                v.e("MicroMsg.JsLoader", "loadJavaScript, jspai is null");
                return false;
            }
            if (!this.lpa) {
                this.liG.evaluateJavascript("javascript:WeixinJSBridge._isBridgeByIframe = false", null);
            }
            f fVar = this.lkl;
            v.v("MicroMsg.JsApiHandler", "jsapi init, preInit = %b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("sys:preInit", fVar.loz, fVar.loD, fVar.loE) + ")", null);
            } else {
                fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("sys:init", fVar.loz, fVar.loD, fVar.loE) + ")", null);
            }
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("sys:bridged", null, fVar.loD, fVar.loE) + ")", null);
            fVar.loB = true;
            fVar.bld();
            if (!(be.kS(fVar.loG) || fVar.lov == null)) {
                fVar.lov.evaluateJavascript(fVar.Fx(fVar.loG), null);
                fVar.loG = null;
            }
            v.i("MicroMsg.JsLoader", "jsapi init done");
            return true;
        }
    }

    public final void blo() {
        if (this.lpb) {
            boolean hI = hI(true);
            if (hI && this.loY != null) {
                this.loY.bkG();
            }
            g.iuh.a(156, 4, 1, false);
            if (!hI) {
                g.iuh.a(156, 3, 1, false);
            }
            v.i("MicroMsg.JsLoader", "preInjectJsBridge, js loaded ret = %b", new Object[]{Boolean.valueOf(hI)});
            return;
        }
        v.i("MicroMsg.JsLoader", "preInjectJsBridge, unchecked");
        s.b(this.liG);
    }
}
