package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

final class d extends X5ProxyWebChromeClient {
    private WebView dOZ;
    private WebChromeClient pvm;

    class a implements com.tencent.smtt.sdk.w.a {
        final /* synthetic */ d pvn;
        QuotaUpdater pvp;

        a(d dVar, QuotaUpdater quotaUpdater) {
            this.pvn = dVar;
            this.pvp = quotaUpdater;
        }

        public final void updateQuota(long j) {
            this.pvp.updateQuota(j);
        }
    }

    public d(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.dOZ = webView;
        this.pvm = webChromeClient;
    }

    public final Bitmap getDefaultVideoPoster() {
        return this.pvm.getDefaultVideoPoster();
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public final void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onCloseWindow(this.dOZ);
    }

    public final void onConsoleMessage(String str, int i, String str2) {
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.pvm.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, final Message message) {
        WebView webView = this.dOZ;
        webView.getClass();
        final WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable(this) {
            final /* synthetic */ d pvn;

            public final void run() {
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((IX5WebViewBase.WebViewTransport) message.obj).setWebView(webView.pxM);
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.pvm.onCreateWindow(this.dOZ, z, z2, obtain);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.pvm.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(this, quotaUpdater));
    }

    public final void onGeolocationPermissionsHidePrompt() {
        this.pvm.onGeolocationPermissionsHidePrompt();
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.pvm.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    public final void onHideCustomView() {
        this.pvm.onHideCustomView();
    }

    public final boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.pvm.onJsAlert(this.dOZ, str, str2, jsResult);
    }

    public final boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.pvm.onJsBeforeUnload(this.dOZ, str, str2, jsResult);
    }

    public final boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.pvm.onJsConfirm(this.dOZ, str, str2, jsResult);
    }

    public final boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.dOZ.pxM = iX5WebViewBase;
        return this.pvm.onJsPrompt(this.dOZ, str, str2, str3, jsPromptResult);
    }

    public final boolean onJsTimeout() {
        return this.pvm.onJsTimeout();
    }

    public final void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onProgressChanged(this.dOZ, i);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.pvm.onReachedMaxAppCacheSize(j, j2, new a(this, quotaUpdater));
    }

    public final void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onReceivedIcon(this.dOZ, bitmap);
    }

    public final void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onReceivedTitle(this.dOZ, str);
    }

    public final void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onReceivedTouchIconUrl(this.dOZ, str, z);
    }

    public final void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.dOZ.pxM = iX5WebViewBase;
        this.pvm.onRequestFocus(this.dOZ);
    }

    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.pvm.onShowCustomView(view, i, customViewCallback);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.pvm.onShowCustomView(view, customViewCallback);
    }

    public final boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, final ValueCallback<Uri[]> valueCallback, final FileChooserParams fileChooserParams) {
        u anonymousClass3 = new u<Uri[]>(this) {
            final /* synthetic */ d pvn;

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                valueCallback.onReceiveValue((Uri[]) obj);
            }
        };
        com.tencent.smtt.sdk.WebChromeClient.a anonymousClass4 = new com.tencent.smtt.sdk.WebChromeClient.a(this) {
            final /* synthetic */ d pvn;

            public final Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            public final String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            public final String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            public final int getMode() {
                return fileChooserParams.getMode();
            }

            public final CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            public final boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.dOZ.pxM = iX5WebViewBase;
        return this.pvm.onShowFileChooser(this.dOZ, anonymousClass3, anonymousClass4);
    }

    public final void openFileChooser(final ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.pvm.openFileChooser(new u<Uri>(this) {
            final /* synthetic */ d pvn;

            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                Uri uri = (Uri) obj;
                valueCallback.onReceiveValue(new Uri[]{uri});
            }
        }, str, str2);
    }
}
