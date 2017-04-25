package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView.WebViewTransport;
import com.tencent.smtt.sdk.w.a;

class SystemWebChromeClient extends WebChromeClient {
    private WebView dOZ;
    private WebChromeClient pvm;

    private static class ConsoleMessageImpl implements ConsoleMessage {
        private int mLineNumber;
        private String mMessage;
        private MessageLevel mMessageLevel;
        private String mSourceId;

        ConsoleMessageImpl(android.webkit.ConsoleMessage consoleMessage) {
            this.mMessageLevel = MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.mMessage = consoleMessage.message();
            this.mSourceId = consoleMessage.sourceId();
            this.mLineNumber = consoleMessage.lineNumber();
        }

        ConsoleMessageImpl(String str, String str2, int i) {
            this.mMessageLevel = MessageLevel.LOG;
            this.mMessage = str;
            this.mSourceId = str2;
            this.mLineNumber = i;
        }

        public int lineNumber() {
            return this.mLineNumber;
        }

        public String message() {
            return this.mMessage;
        }

        public MessageLevel messageLevel() {
            return this.mMessageLevel;
        }

        public String sourceId() {
            return this.mSourceId;
        }
    }

    class CustomViewCallbackImpl implements CustomViewCallback {
        WebChromeClient.CustomViewCallback mCustomViewCallback;

        CustomViewCallbackImpl(WebChromeClient.CustomViewCallback customViewCallback) {
            this.mCustomViewCallback = customViewCallback;
        }

        public void onCustomViewHidden() {
            this.mCustomViewCallback.onCustomViewHidden();
        }
    }

    class GeolocationPermissionsCallbackImpl implements GeolocationPermissionsCallback {
        Callback mCallback;

        GeolocationPermissionsCallbackImpl(Callback callback) {
            this.mCallback = callback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            this.mCallback.invoke(str, z, z2);
        }
    }

    private class JsResultImpl implements JsResult {
        android.webkit.JsResult mJsResult;

        JsResultImpl(android.webkit.JsResult jsResult) {
            this.mJsResult = jsResult;
        }

        public void cancel() {
            this.mJsResult.cancel();
        }

        public void confirm() {
            this.mJsResult.confirm();
        }
    }

    class QuotaUpdaterImpl implements a {
        QuotaUpdater mQuotaUpdater;

        QuotaUpdaterImpl(QuotaUpdater quotaUpdater) {
            this.mQuotaUpdater = quotaUpdater;
        }

        public void updateQuota(long j) {
            this.mQuotaUpdater.updateQuota(j);
        }
    }

    private class JsPromptResultImpl implements JsPromptResult {
        android.webkit.JsPromptResult mJsPromptResult;

        JsPromptResultImpl(android.webkit.JsPromptResult jsPromptResult) {
            this.mJsPromptResult = jsPromptResult;
        }

        public void cancel() {
            this.mJsPromptResult.cancel();
        }

        public void confirm() {
            this.mJsPromptResult.confirm();
        }

        public void confirm(String str) {
            this.mJsPromptResult.confirm(str);
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.dOZ = webView;
        this.pvm = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        return this.pvm.getDefaultVideoPoster();
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.pvm.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(final ValueCallback<String[]> valueCallback) {
        this.pvm.getVisitedHistory(new u<String[]>() {
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    public void onCloseWindow(WebView webView) {
        this.pvm.onCloseWindow(this.dOZ);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        this.pvm.onConsoleMessage(new ConsoleMessageImpl(str, str2, i));
    }

    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.pvm.onConsoleMessage(new ConsoleMessageImpl(consoleMessage));
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, final Message message) {
        WebView webView2 = this.dOZ;
        webView2.getClass();
        final WebViewTransport webViewTransport = new WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() {
            public void run() {
                WebView webView = webViewTransport.getWebView();
                if (webView != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(!webView.pxL ? webView.pxN : null);
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.pvm.onCreateWindow(this.dOZ, z, z2, obtain);
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        this.pvm.onExceededDatabaseQuota(str, str2, j, j2, j3, new QuotaUpdaterImpl(quotaUpdater));
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.pvm.onGeolocationPermissionsHidePrompt();
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        this.pvm.onGeolocationPermissionsShowPrompt(str, new GeolocationPermissionsCallbackImpl(callback));
    }

    @TargetApi(7)
    public void onHideCustomView() {
        this.pvm.onHideCustomView();
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.pvm.onJsAlert(this.dOZ, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.pvm.onJsBeforeUnload(this.dOZ, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        return this.pvm.onJsConfirm(this.dOZ, str, str2, new JsResultImpl(jsResult));
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        return this.pvm.onJsPrompt(this.dOZ, str, str2, str3, new JsPromptResultImpl(jsPromptResult));
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.pvm.onJsTimeout();
    }

    public void onProgressChanged(WebView webView, int i) {
        this.pvm.onProgressChanged(this.dOZ, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        this.pvm.onReachedMaxAppCacheSize(j, j2, new QuotaUpdaterImpl(quotaUpdater));
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.pvm.onReceivedIcon(this.dOZ, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.pvm.onReceivedTitle(this.dOZ, str);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.pvm.onReceivedTouchIconUrl(this.dOZ, str, z);
    }

    public void onRequestFocus(WebView webView) {
        this.pvm.onRequestFocus(this.dOZ);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.pvm.onShowCustomView(view, i, new CustomViewCallbackImpl(customViewCallback));
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.pvm.onShowCustomView(view, new CustomViewCallbackImpl(customViewCallback));
    }

    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, final FileChooserParams fileChooserParams) {
        return this.pvm.onShowFileChooser(this.dOZ, new u<Uri[]>() {
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        }, new WebChromeClient.a() {
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            public int getMode() {
                return fileChooserParams.getMode();
            }

            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        });
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback, String str, String str2) {
        this.pvm.openFileChooser(new u<Uri>() {
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
