package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebViewTestUI extends MMActivity {
    private WebViewClient dzE = new WebViewClient(this) {
        final /* synthetic */ WebViewTestUI ljP;

        {
            this.ljP = r1;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    };
    MMWebViewWithJsApi ljO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        MMWebViewWithJsApi.cQ(this);
        MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(this);
        MMWebViewWithJsApi.a(mMWebViewWithJsApi);
        MMWebViewWithJsApi.a(mMWebViewWithJsApi, mMWebViewWithJsApi.getX5WebViewExtension() != null);
        this.ljO = mMWebViewWithJsApi;
        this.ljO.setWebViewClient(this.dzE);
        setContentView(this.ljO);
        this.ljO.loadUrl(stringExtra);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
