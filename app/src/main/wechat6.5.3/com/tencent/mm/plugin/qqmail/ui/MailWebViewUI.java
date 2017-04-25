package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.plugin.qqmail.b.q.a;
import com.tencent.mm.plugin.qqmail.b.q.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String aQl;
    private d gZK = new d(this);
    private ac handler;
    private long icl;
    private MMWebView igd;
    private View ige;
    private a igf = new a(this) {
        final /* synthetic */ MailWebViewUI igg;

        {
            this.igg = r1;
        }

        public final void onSuccess(final String str, Map map) {
            this.igg.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 igi;

                public final void run() {
                    MailWebViewUI.a(this.igi.igg, str);
                }
            });
        }

        public final void onError(int i, final String str) {
            this.igg.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 igi;

                public final void run() {
                    Toast.makeText(this.igi.igg, str, 0).show();
                }
            });
        }
    };

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        if (mailWebViewUI.igd != null && str != null) {
            if (mailWebViewUI.aQl == null) {
                mailWebViewUI.igd.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
                return;
            }
            mailWebViewUI.igd.loadDataWithBaseURL(mailWebViewUI.aQl, str, "text/html", ProtocolPackage.ServerEncoding, null);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        String stringExtra = mailWebViewUI.getIntent().getStringExtra("uri");
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        Map hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.aQl = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String ah = be.ah(mailWebViewUI.getIntent().getStringExtra("method"), "get");
        if (ah == null || ah.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            v.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            return;
        }
        c cVar = new c();
        cVar.ibx = false;
        cVar.t(new Bundle());
        try {
            if (ah.equals("get")) {
                mailWebViewUI.icl = ((Long) new ReadMailProxy(mailWebViewUI.gZK, mailWebViewUI.igf).REMOTE_CALL("get", stringExtra, hashMap, r5)).longValue();
                return;
            }
            mailWebViewUI.icl = ((Long) new ReadMailProxy(mailWebViewUI.gZK, mailWebViewUI.igf).REMOTE_CALL("post", stringExtra, hashMap, r5)).longValue();
        } catch (Exception e) {
            v.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", new Object[]{ah, e.getMessage()});
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            return;
        }
        String substring = str.substring(33);
        final int i = be.getInt(substring, 480);
        v.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:" + substring);
        mailWebViewUI.igd.post(new Runnable(mailWebViewUI) {
            final /* synthetic */ MailWebViewUI igg;

            public final void run() {
                View view = (View) this.igg.igd.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < this.igg.igd.getScale()) {
                            i--;
                            if (i > 0) {
                                this.igg.igd.zoomOut();
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return 2130904215;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ac();
        NI();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            Fd(stringExtra);
        }
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ MailWebViewUI igg;

            {
                this.igg = r1;
            }

            public final void run() {
                MailWebViewUI.b(this.igg);
            }
        });
    }

    protected void onStop() {
        this.igd.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        this.igd.setVisibility(8);
        this.igd.destroy();
        this.igd = null;
        this.gZK.release();
        super.onDestroy();
    }

    protected final void NI() {
        this.ige = findViewById(2131756754);
        if (this.ige != null) {
            this.ige.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.igd = MMWebView.a.eP(this.nDR.nEl);
        this.igd.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2131689900));
        ((FrameLayout) findViewById(2131755326)).addView(this.igd);
        this.igd.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.igd;
            if (VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.igd.getSettings().setDefaultFontSize(8);
        this.igd.getSettings().setSupportZoom(true);
        this.igd.getSettings().setBuiltInZoomControls(true);
        this.igd.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ MailWebViewUI igg;

            {
                this.igg = r1;
            }

            public final void onScaleChanged(WebView webView, float f, float f2) {
                this.igg.igd.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("weixin://private/getcontentwidth/")) {
                    v.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = " + str);
                    MailWebViewUI.b(this.igg, str);
                } else {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                s.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
            }
        });
        this.igd.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MailWebViewUI igg;

            {
                this.igg = r1;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String If = s.If(consoleMessage != null ? consoleMessage.message() : null);
                if (!If.startsWith("weixin://private/getcontentwidth/")) {
                    return super.onConsoleMessage(consoleMessage);
                }
                v.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = " + If);
                MailWebViewUI.b(this.igg, If);
                return true;
            }
        });
        this.igd.bKn();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailWebViewUI igg;

            {
                this.igg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.igg.finish();
                return true;
            }
        });
    }
}
