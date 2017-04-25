package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.q;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient extends WebViewClient {
    private static String pvq = null;
    private WebView dOZ;
    private WebViewClient hRx;

    private static class ClientCertRequestImpl extends ClientCertRequest {
        private android.webkit.ClientCertRequest mClientCertRequest;

        public ClientCertRequestImpl(android.webkit.ClientCertRequest clientCertRequest) {
            this.mClientCertRequest = clientCertRequest;
        }

        public void cancel() {
            this.mClientCertRequest.cancel();
        }

        public String getHost() {
            return this.mClientCertRequest.getHost();
        }

        public String[] getKeyTypes() {
            return this.mClientCertRequest.getKeyTypes();
        }

        public int getPort() {
            return this.mClientCertRequest.getPort();
        }

        public Principal[] getPrincipals() {
            return this.mClientCertRequest.getPrincipals();
        }

        public void ignore() {
            this.mClientCertRequest.ignore();
        }

        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.mClientCertRequest.proceed(privateKey, x509CertificateArr);
        }
    }

    private static class HttpAuthHandlerImpl implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler mHandler;

        HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.mHandler = httpAuthHandler;
        }

        public void cancel() {
            this.mHandler.cancel();
        }

        public void proceed(String str, String str2) {
            this.mHandler.proceed(str, str2);
        }

        public boolean useHttpAuthUsernamePassword() {
            return this.mHandler.useHttpAuthUsernamePassword();
        }
    }

    private static class SslErrorHandlerImpl implements SslErrorHandler {
        android.webkit.SslErrorHandler mSslErrorHandler;

        SslErrorHandlerImpl(android.webkit.SslErrorHandler sslErrorHandler) {
            this.mSslErrorHandler = sslErrorHandler;
        }

        public void cancel() {
            this.mSslErrorHandler.cancel();
        }

        public void proceed() {
            this.mSslErrorHandler.proceed();
        }
    }

    private static class SslErrorImpl implements SslError {
        android.net.http.SslError mSslError;

        SslErrorImpl(android.net.http.SslError sslError) {
            this.mSslError = sslError;
        }

        public boolean addError(int i) {
            return this.mSslError.addError(i);
        }

        public SslCertificate getCertificate() {
            return this.mSslError.getCertificate();
        }

        public int getPrimaryError() {
            return this.mSslError.getPrimaryError();
        }

        public boolean hasError(int i) {
            return this.mSslError.hasError(i);
        }
    }

    private static class WebResourceRequestImpl2 implements WebResourceRequest {
        android.webkit.WebResourceRequest mWebResourceRequest;

        WebResourceRequestImpl2(android.webkit.WebResourceRequest webResourceRequest) {
            this.mWebResourceRequest = webResourceRequest;
        }

        public String getMethod() {
            return this.mWebResourceRequest.getMethod();
        }

        public Map<String, String> getRequestHeaders() {
            return this.mWebResourceRequest.getRequestHeaders();
        }

        public Uri getUrl() {
            return this.mWebResourceRequest.getUrl();
        }

        public boolean hasGesture() {
            return this.mWebResourceRequest.hasGesture();
        }

        public boolean isForMainFrame() {
            return this.mWebResourceRequest.isForMainFrame();
        }
    }

    private class WebResourceRequestImpl implements WebResourceRequest {
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private String method;
        private Map<String, String> requestHeaders;
        private String url;

        public WebResourceRequestImpl(String str, boolean z, boolean z2, String str2, Map<String, String> map) {
            this.url = str;
            this.isMainFrame = z;
            this.hasUserGesture = z2;
            this.method = str2;
            this.requestHeaders = map;
        }

        public String getMethod() {
            return this.method;
        }

        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public Uri getUrl() {
            return Uri.parse(this.url);
        }

        public boolean hasGesture() {
            return this.hasUserGesture;
        }

        public boolean isForMainFrame() {
            return this.isMainFrame;
        }
    }

    private static class WebResourceResponseImpl2 extends WebResourceResponse {
        android.webkit.WebResourceResponse mWebResourceResponse;

        public WebResourceResponseImpl2(android.webkit.WebResourceResponse webResourceResponse) {
            this.mWebResourceResponse = webResourceResponse;
        }

        public InputStream getData() {
            return this.mWebResourceResponse.getData();
        }

        public String getEncoding() {
            return this.mWebResourceResponse.getEncoding();
        }

        public String getMimeType() {
            return this.mWebResourceResponse.getMimeType();
        }

        public String getReasonPhrase() {
            return this.mWebResourceResponse.getReasonPhrase();
        }

        public Map<String, String> getResponseHeaders() {
            return this.mWebResourceResponse.getResponseHeaders();
        }

        public int getStatusCode() {
            return this.mWebResourceResponse.getStatusCode();
        }

        public void setData(InputStream inputStream) {
            this.mWebResourceResponse.setData(inputStream);
        }

        public void setEncoding(String str) {
            this.mWebResourceResponse.setEncoding(str);
        }

        public void setMimeType(String str) {
            this.mWebResourceResponse.setMimeType(str);
        }

        public void setResponseHeaders(Map<String, String> map) {
            this.mWebResourceResponse.setResponseHeaders(map);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.mWebResourceResponse.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.dOZ = webView;
        this.hRx = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.hRx.doUpdateVisitedHistory(this.dOZ, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.hRx.onFormResubmission(this.dOZ, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.hRx.onLoadResource(this.dOZ, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (pvq == null) {
            q bOi = q.bOi();
            if (bOi != null) {
                bOi.kC(true);
                pvq = Boolean.toString(true);
            }
        }
        WebView webView2 = this.dOZ;
        webView2.pxP++;
        this.hRx.onPageFinished(this.dOZ, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            WebView.fI(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.bNE();
        if (this.dOZ.getContext() != null && q.fz(this.dOZ.getContext())) {
            new Thread(new Runnable() {
                public void run() {
                    SystemWebViewClient.this.dOZ.getContext();
                    if (j.o(SystemWebViewClient.this.dOZ.getContext(), false)) {
                        j.fd(SystemWebViewClient.this.dOZ.getContext());
                    }
                }
            }).start();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.hRx.onPageStarted(this.dOZ, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.hRx.onReceivedClientCertRequest(this.dOZ, new ClientCertRequestImpl(clientCertRequest));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.hRx.onReceivedError(this.dOZ, i, str, str2);
    }

    public void onReceivedError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        a aVar = null;
        WebResourceRequest webResourceRequestImpl2 = webResourceRequest != null ? new WebResourceRequestImpl2(webResourceRequest) : null;
        if (webResourceError != null) {
            aVar = new a() {
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.hRx.onReceivedError(this.dOZ, webResourceRequestImpl2, aVar);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.hRx.onReceivedHttpAuthRequest(this.dOZ, new HttpAuthHandlerImpl(httpAuthHandler), str, str2);
    }

    public void onReceivedHttpError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.hRx.onReceivedHttpError(this.dOZ, new WebResourceRequestImpl2(webResourceRequest), new WebResourceResponseImpl2(webResourceResponse));
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.hRx.onReceivedLoginRequest(this.dOZ, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.hRx.onReceivedSslError(this.dOZ, new SslErrorHandlerImpl(sslErrorHandler), new SslErrorImpl(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.hRx.onScaleChanged(this.dOZ, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.hRx.onTooManyRedirects(this.dOZ, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.hRx.onUnhandledKeyEvent(this.dOZ, keyEvent);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (webResourceRequest == null) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.hRx.shouldInterceptRequest(this.dOZ, new WebResourceRequestImpl(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            return webResourceResponse;
        }
        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        return webResourceResponse;
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.hRx.shouldInterceptRequest(this.dOZ, str);
        return shouldInterceptRequest != null ? new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData()) : null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.hRx.shouldOverrideKeyEvent(this.dOZ, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return (str == null || this.dOZ.showDebugView(str) || l.bOc().bw(this.dOZ.getContext().getApplicationContext(), str)) ? true : this.hRx.shouldOverrideUrlLoading(this.dOZ, str);
    }
}
