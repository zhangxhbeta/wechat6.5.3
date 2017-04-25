package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.u;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends WebView implements b {
    private final LinkedList<Pair<String, u<String>>> dzC = new LinkedList();
    private boolean dzD = false;
    private WebViewClient dzE = new WebViewClient(this) {
        final /* synthetic */ h dzH;

        {
            this.dzH = r1;
        }

        public final void onPageFinished(WebView webView, String str) {
            synchronized (this.dzH.dzC) {
                Iterator it = this.dzH.dzC.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    this.dzH.a((String) pair.first, (u) pair.second);
                }
                this.dzH.dzC.clear();
                this.dzH.dzD = true;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    };
    private Context mContext;
    private ac mHandler;

    public h(Context context, Object obj, String str) {
        super(context);
        this.mContext = context;
        this.mHandler = new ac(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aW(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.dzE);
        if (!(obj == null || be.kS(str))) {
            addJavascriptInterface(obj, str);
        }
        setWillNotDraw(true);
        loadDataWithBaseURL("https://servicewechat.com/app-service", "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
    }

    public final void evaluateJavascript(String str, u<String> uVar) {
        synchronized (this.dzC) {
            if (this.dzD) {
                a(str, uVar);
                return;
            }
            this.dzC.add(new Pair(str, uVar));
        }
    }

    private void a(final String str, final u<String> uVar) {
        final Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ h dzH;

            public final void run() {
                super.evaluateJavascript(str, uVar);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass1.run();
        } else {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ h dzH;

                public final void run() {
                    anonymousClass1.run();
                }
            });
        }
    }

    public final void OE() {
        destroy();
    }
}
