package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.q;

final class e extends X5ProxyWebViewClient {
    private static String pvq = null;
    private WebView dOZ;
    private WebViewClient hRx;

    public e(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.dOZ = webView;
        this.hRx = webViewClient;
    }

    public final void countPVContentCacheCallBack(String str) {
        WebView webView = this.dOZ;
        webView.pxP++;
    }

    public final void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.doUpdateVisitedHistory(this.dOZ, str, z);
    }

    public final void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onDetectedBlankScreen(str, i);
    }

    public final void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onFormResubmission(this.dOZ, message, message2);
    }

    public final void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onLoadResource(this.dOZ, str);
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        if (pvq == null) {
            q bOi = q.bOi();
            if (bOi != null) {
                bOi.kC(false);
                pvq = Boolean.toString(false);
            }
        }
        this.dOZ.pxM = iX5WebViewBase;
        WebView webView = this.dOZ;
        webView.pxP++;
        this.hRx.onPageFinished(this.dOZ, str);
        if ("com.qzone".equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            WebView.fI(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.bNE();
        if (this.dOZ.getContext() != null && q.fz(this.dOZ.getContext())) {
            new Thread(new Runnable(this) {
                final /* synthetic */ e pvr;

                {
                    this.pvr = r1;
                }

                public final void run() {
                    this.pvr.dOZ.getContext();
                    if (j.o(this.pvr.dOZ.getContext(), false)) {
                        j.fd(this.pvr.dOZ.getContext());
                    }
                }
            }).start();
        }
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onPageStarted(this.dOZ, str, bitmap);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public final void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedClientCertRequest(this.dOZ, clientCertRequest);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedError(this.dOZ, i, str, str2);
    }

    public final void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedHttpAuthRequest(this.dOZ, httpAuthHandler, str, str2);
    }

    public final void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedHttpError(this.dOZ, webResourceRequest, webResourceResponse);
    }

    public final void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedLoginRequest(this.dOZ, str, str2, str3);
    }

    public final void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onReceivedSslError(this.dOZ, sslErrorHandler, sslError);
    }

    public final void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onScaleChanged(this.dOZ, f, f2);
    }

    public final void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onTooManyRedirects(this.dOZ, message, message2);
    }

    public final void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.dOZ.pxM = iX5WebViewBase;
        this.hRx.onUnhandledKeyEvent(this.dOZ, keyEvent);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.hRx.shouldInterceptRequest(this.dOZ, webResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.hRx.shouldInterceptRequest(this.dOZ, webResourceRequest, bundle);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.hRx.shouldInterceptRequest(this.dOZ, str);
    }

    public final boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.hRx.shouldOverrideKeyEvent(this.dOZ, keyEvent);
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.dOZ.showDebugView(str)) {
            return true;
        }
        this.dOZ.pxM = iX5WebViewBase;
        if (l.bOc().bw(this.dOZ.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.hRx.shouldOverrideUrlLoading(this.dOZ, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.dOZ.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    if (this.dOZ.getContext() == null) {
                        return true;
                    }
                    this.dOZ.getContext().startActivity(intent);
                    return true;
                } catch (Exception e) {
                    return true;
                }
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final void u(String str, Bitmap bitmap) {
        super.onPageStarted(this.dOZ.pxM, 0, 0, str, bitmap);
    }
}
