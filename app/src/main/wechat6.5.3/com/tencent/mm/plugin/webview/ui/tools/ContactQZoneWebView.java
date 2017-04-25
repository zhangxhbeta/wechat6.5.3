package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class ContactQZoneWebView extends WebViewUI {
    private String hQK = "";
    private boolean lik = false;
    private String lil = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(getString(2131232116));
        this.igd.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ ContactQZoneWebView lim;

            {
                this.lim = r1;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("weixin://viewimage/")) {
                    this.lim.EQ(str);
                    webView.stopLoading();
                } else if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (str.startsWith("weixin://viewimage/")) {
                    this.lim.EQ(str);
                    webView.stopLoading();
                } else if (str.equals(this.lim.hQK)) {
                    be.E(this.lim, str);
                    webView.stopLoading();
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }
        });
        this.igd.loadUrl(this.bpX);
        v.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.bpX);
    }

    protected void onResume() {
        super.onResume();
        this.lik = false;
    }

    final void EQ(String str) {
        if (!this.lik) {
            this.lik = true;
            String substring = str.substring(19);
            v.d("MicroMsg.ContactQZoneWebView", "get url :" + substring);
            Intent intent = new Intent();
            intent.putExtra("nowUrl", substring);
            intent.putExtra("tweetid", be.ma(getIntent().getStringExtra("tweetid")));
            intent.putExtra("htmlData", this.lil);
            intent.putExtra("type", getIntent().getIntExtra("type", 0));
            startActivity(intent);
            a.drp.u(intent, this);
        }
    }
}
