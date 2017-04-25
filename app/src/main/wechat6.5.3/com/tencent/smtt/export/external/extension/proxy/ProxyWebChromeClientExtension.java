package com.tencent.smtt.export.external.extension.proxy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public class ProxyWebChromeClientExtension implements IX5WebChromeClientExtension {
    private static boolean sCompatibleNewOnSavePassword = true;
    private static boolean sCompatibleOpenFileChooser = true;
    protected IX5WebChromeClientExtension mWebChromeClient;

    public void acquireWakeLock() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.acquireWakeLock();
        }
    }

    public void addFlashView(View view, LayoutParams layoutParams) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.addFlashView(view, layoutParams);
        }
    }

    public void exitFullScreenFlash() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.exitFullScreenFlash();
        }
    }

    public Context getApplicationContex() {
        return this.mWebChromeClient != null ? this.mWebChromeClient.getApplicationContex() : null;
    }

    public View getVideoLoadingProgressView() {
        return this.mWebChromeClient != null ? this.mWebChromeClient.getVideoLoadingProgressView() : null;
    }

    public Object getX5WebChromeClientInstance() {
        return this.mWebChromeClient;
    }

    public IX5WebChromeClientExtension getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void h5videoExitFullScreen(String str) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoExitFullScreen(str);
        }
    }

    public void h5videoRequestFullScreen(String str) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoRequestFullScreen(str);
        }
    }

    public void jsExitFullScreen() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsExitFullScreen();
        }
    }

    public void jsRequestFullScreen() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsRequestFullScreen();
        }
    }

    public boolean onAddFavorite(IX5WebViewExtension iX5WebViewExtension, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient != null ? this.mWebChromeClient.onAddFavorite(iX5WebViewExtension, str, str2, jsResult) : false;
    }

    public void onAllMetaDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onAllMetaDataFinished(iX5WebViewExtension, hashMap);
        }
    }

    public void onBackforwardFinished(int i) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onBackforwardFinished(i);
        }
    }

    public void onColorModeChanged(long j) {
    }

    public void onHitTestResultFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultFinished(iX5WebViewExtension, hitTestResult);
        }
    }

    public void onHitTestResultForPluginFinished(IX5WebViewExtension iX5WebViewExtension, HitTestResult hitTestResult, Bundle bundle) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultForPluginFinished(iX5WebViewExtension, hitTestResult, bundle);
        }
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        return this.mWebChromeClient != null ? this.mWebChromeClient.onMiscCallBack(str, bundle) : null;
    }

    public boolean onPageNotResponding(Runnable runnable) {
        return this.mWebChromeClient != null ? this.mWebChromeClient.onPageNotResponding(runnable) : false;
    }

    public boolean onPermissionRequest(String str, long j, MediaAccessPermissionsCallback mediaAccessPermissionsCallback) {
        return false;
    }

    public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPrepareX5ReadPageDataFinished(iX5WebViewExtension, hashMap);
        }
    }

    public void onPrintPage() {
    }

    public void onPromptNotScalable(IX5WebViewExtension iX5WebViewExtension) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptNotScalable(iX5WebViewExtension);
        }
    }

    public void onPromptScaleSaved(IX5WebViewExtension iX5WebViewExtension) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptScaleSaved(iX5WebViewExtension);
        }
    }

    public boolean onSavePassword(ValueCallback<String> valueCallback, String str, String str2, String str3, String str4, String str5, boolean z) {
        if (this.mWebChromeClient != null && sCompatibleNewOnSavePassword) {
            try {
                return this.mWebChromeClient.onSavePassword(valueCallback, str, str2, str3, str4, str5, z);
            } catch (NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("onSavePassword")) {
                    throw e;
                }
                sCompatibleNewOnSavePassword = false;
            }
        }
        return false;
    }

    public boolean onSavePassword(String str, String str2, String str3, boolean z, Message message) {
        if (this.mWebChromeClient != null) {
            try {
                return this.mWebChromeClient.onSavePassword(str, str2, str3, z, message);
            } catch (NoSuchMethodError e) {
            }
        }
        return false;
    }

    public void onX5ReadModeAvailableChecked(HashMap<String, String> hashMap) {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onX5ReadModeAvailableChecked(hashMap);
        }
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2) {
        if (this.mWebChromeClient != null && sCompatibleOpenFileChooser) {
            try {
                this.mWebChromeClient.openFileChooser(valueCallback, str, str2);
            } catch (NoSuchMethodError e) {
                if (e.getMessage() == null || !e.getMessage().contains("openFileChooser")) {
                    throw e;
                }
                sCompatibleOpenFileChooser = false;
            }
        }
    }

    public void releaseWakeLock() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.releaseWakeLock();
        }
    }

    public void requestFullScreenFlash() {
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.requestFullScreenFlash();
        }
    }

    public void setWebChromeClientExtend(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        this.mWebChromeClient = iX5WebChromeClientExtension;
    }
}
