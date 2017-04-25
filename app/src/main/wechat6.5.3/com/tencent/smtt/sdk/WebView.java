package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.a.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.q;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    public static String TBS_DEBUG_INSTALL_ONLINE = "tbsdebug_install_online_";
    private static Context aHq = null;
    public static boolean mSysWebviewCreated = false;
    private static final Lock pxJ = new ReentrantLock();
    private static OutputStream pxK = null;
    private static BroadcastReceiver pxS = null;
    private static q pxT = null;
    private static Method pxU = null;
    private static String pxV = null;
    private static Paint pyb = null;
    private static boolean pyc = true;
    private final String De;
    private Context mContext;
    public x mWebViewCallbackClient;
    boolean pxL;
    IX5WebViewBase pxM;
    SystemWebView pxN;
    private WebSettings pxO;
    int pxP;
    private boolean pxQ;
    private l pxR;
    private final int pxW;
    private final int pxX;
    private final int pxY;
    private final String pxZ;
    private final String pya;
    private Object pyd;
    private OnLongClickListener pye;

    private static class ConnectivityChangedReceiver extends BroadcastReceiver {
        private ConnectivityChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int fS = b.fS(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.puL) {
                            if (QbSdk.puJ) {
                                QbSdk.sWifiConnectedTime += currentTimeMillis - QbSdk.puK;
                            }
                            QbSdk.puK = currentTimeMillis;
                        }
                        TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + fS);
                        QbSdk.puJ = fS == 3;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult mHitTestResultImpl;
        private android.webkit.WebView.HitTestResult mSysHitTestResult;

        public HitTestResult() {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = null;
            this.mSysHitTestResult = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = null;
            this.mSysHitTestResult = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.mSysHitTestResult = null;
            this.mHitTestResultImpl = hitTestResult;
            this.mSysHitTestResult = null;
        }

        public String getExtra() {
            return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getExtra() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getExtra() : SQLiteDatabase.KeyEmpty;
        }

        public int getType() {
            return this.mHitTestResultImpl != null ? this.mHitTestResultImpl.getType() : this.mSysHitTestResult != null ? this.mSysHitTestResult.getType() : 0;
        }

        public void setExtra(String str) {
            if (this.mHitTestResultImpl != null) {
                this.mHitTestResultImpl.setExtra(str);
            }
        }

        public void setType(int i) {
            if (this.mHitTestResultImpl != null) {
                this.mHitTestResultImpl.setType(i);
            }
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    private class SystemWebView extends android.webkit.WebView {
        public SystemWebView(WebView webView, Context context) {
            this(context, null);
        }

        public SystemWebView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            CookieSyncManager.createInstance(WebView.this.mContext).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
                WebView.mSysWebviewCreated = true;
            } catch (Exception e) {
            }
        }

        public void computeScroll() {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.RC();
            } else {
                super.computeScroll();
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.pyc && WebView.pyb != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.pyb);
                    canvas.restore();
                }
            } catch (Throwable th) {
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.q(motionEvent) : super.dispatchTouchEvent(motionEvent);
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                return null;
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.r(motionEvent) : super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.b(i, i2, z, z2);
            } else if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            WebView.this.onScrollChanged(i, i2, i3, i4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (WebView.this.mWebViewCallbackClient != null) {
                return WebView.this.mWebViewCallbackClient.p(motionEvent);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return WebView.this.mWebViewCallbackClient != null ? WebView.this.mWebViewCallbackClient.a(i, i2, i3, i4, i5, i6, i7, i8, z) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        public void super_computeScroll() {
            super.computeScroll();
        }

        public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        public void super_onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        public boolean super_onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }
    }

    public class WebViewTransport {
        private WebView mWebview;

        public synchronized WebView getWebView() {
            return this.mWebview;
        }

        public synchronized void setWebView(WebView webView) {
            this.mWebview = webView;
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.De = "WebView";
        this.pxL = false;
        this.pxO = null;
        this.mContext = null;
        this.pxP = 0;
        this.pxQ = false;
        this.pxR = null;
        this.pxW = 1;
        this.pxX = 2;
        this.pxY = 3;
        this.pxZ = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.pya = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.pyd = null;
        this.pye = null;
        this.pxR = new l();
        this.pxR.a("init_all", (byte) 1);
        this.pxR.a("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.pxR.a("tbslog_init", (byte) 2);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (pxT == null) {
            pxT = q.gf(context);
        }
        if (pxT.pzE) {
            TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.bo(context, "debug.conf force syswebview!");
        }
        b(context, this.pxR);
        this.mContext = context;
        if (context != null) {
            aHq = context.getApplicationContext();
        }
        if (!this.pxL || QbSdk.puB) {
            this.pxM = null;
            if (q.fz(this.mContext)) {
                this.pxN = new SystemWebView(context, attributeSet);
            } else {
                this.pxN = new SystemWebView(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            this.pxN.setFocusableInTouchMode(true);
            addView(this.pxN, new LayoutParams(-1, -1));
            setDownloadListener(null);
            fF(context);
        } else {
            this.pxR.a("init_x5_webview", (byte) 1);
            this.pxM = y.bNJ().pyh.fL(context);
            this.pxR.a("init_x5_webview", (byte) 2);
            if (this.pxM == null || this.pxM.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.pxM = null;
                this.pxL = false;
                QbSdk.bo(context, "failed to createTBSWebview!");
                b(context, this.pxR);
                if (q.fz(this.mContext)) {
                    this.pxN = new SystemWebView(context, attributeSet);
                } else {
                    this.pxN = new SystemWebView(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                this.pxN.setFocusableInTouchMode(true);
                addView(this.pxN, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                }
                fF(context);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.pxM.getView().setFocusableInTouchMode(true);
            f(attributeSet);
            addView(this.pxM.getView(), new LayoutParams(-1, -1));
            this.pxM.setDownloadListener(new b(this, null));
            IX5WebViewExtension x5WebViewExtension = this.pxM.getX5WebViewExtension();
            Object invokeStaticMethod = y.bNJ().pyh.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
            x5WebViewExtension.setWebViewClientExtension(new X5ProxyWebViewClientExtension(invokeStaticMethod == null ? null : (IX5WebViewClientExtension) invokeStaticMethod) {
                public void onScrollChanged(int i, int i2, int i3, int i4) {
                    super.onScrollChanged(i, i2, i3, i4);
                    WebView.this.onScrollChanged(i3, i4, i, i2);
                }
            });
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
        }
        if ("com.tencent.mobileqq".equals(this.mContext.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.mContext.getApplicationInfo().packageName)) {
            c.kx(true);
            if (c.useSoftWare() && VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        }
        if (this.pxR != null) {
            this.pxR.a("load_url_gap", (byte) 1);
        }
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void b(Context context, l lVar) {
        if (lVar != null) {
            lVar.a("x5_core_engine_init_sync", (byte) 1);
        }
        y bNJ = y.bNJ();
        bNJ.b(context, lVar);
        this.pxL = bNJ.bNK();
    }

    private static long bND() {
        long j;
        synchronized (QbSdk.puL) {
            if (QbSdk.puJ) {
                QbSdk.sWifiConnectedTime += System.currentTimeMillis() - QbSdk.puK;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.sWifiConnectedTime);
            }
            j = QbSdk.sWifiConnectedTime / 1000;
            QbSdk.sWifiConnectedTime = 0;
            QbSdk.puK = System.currentTimeMillis();
        }
        return j;
    }

    static void bNE() {
        new Thread() {
            public final void run() {
                if (WebView.aHq == null) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                    return;
                }
                c.kx(true);
                if (c.pvi) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                    return;
                }
                h fa = h.fa(WebView.aHq);
                int Qi = fa.Qi("install_status");
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + Qi);
                if (Qi == 2) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                    c.Qh(String.valueOf(fa.Qj("install_core_ver")));
                    c.bMK();
                    return;
                }
                int Qi2 = fa.Qi("copy_status");
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + Qi2);
                if (Qi2 == 1) {
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                    c.Qh(String.valueOf(fa.Qj("copy_core_ver")));
                    c.bMK();
                } else if (!y.bNJ().bNK()) {
                    if (Qi == 3 || Qi2 == 3) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                        c.Qh(String.valueOf(c.bMJ()));
                        c.bMK();
                    }
                }
            }
        }.start();
    }

    private boolean df(View view) {
        if (this.mContext != null && getTbsCoreVersion(this.mContext) > 36200) {
            return false;
        }
        Object a = n.a(this.pyd, "onLongClick", new Class[]{View.class}, view);
        return a != null ? ((Boolean) a).booleanValue() : false;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!y.bNJ().bNK()) {
            n.el("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!y.bNJ().bNK()) {
            n.el("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    private void f(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.pxM.getView().setVerticalScrollBarEnabled(false);
                            this.pxM.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.pxM.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.pxM.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void fF(final Context context) {
        if (pxS == null) {
            pxS = new ConnectivityChangedReceiver();
            new Thread() {
                public void run() {
                    try {
                        QbSdk.puJ = b.fS(context) == 3;
                        QbSdk.puK = System.currentTimeMillis();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        context.getApplicationContext().registerReceiver(WebView.pxS, intentFilter);
                    } catch (Throwable th) {
                    }
                }
            }.start();
        }
    }

    private static boolean fG(Context context) {
        try {
            if (context.getPackageName().indexOf("com.tencent.mobileqq") >= 0) {
                return true;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    private static int fH(Context context) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        int i = -1;
        if (m.bNm().fw(context)) {
            if (pxJ.tryLock()) {
                FileInputStream fileInputStream2 = null;
                try {
                    File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                    if (file.exists()) {
                        Properties properties = new Properties();
                        fileInputStream = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream);
                            fileInputStream.close();
                            String property = properties.getProperty("PV");
                            if (property == null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                }
                                pxJ.unlock();
                                m.bNm().bNo();
                            } else {
                                i = Integer.parseInt(property);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22) {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                }
                                pxJ.unlock();
                                m.bNm().bNo();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e222) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                                    }
                                }
                                pxJ.unlock();
                                m.bNm().bNo();
                                return i;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e2222) {
                                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                                    }
                                }
                                pxJ.unlock();
                                m.bNm().bNo();
                                throw th;
                            }
                        }
                    }
                    pxJ.unlock();
                    m.bNm().bNo();
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    pxJ.unlock();
                    m.bNm().bNo();
                    return i;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    pxJ.unlock();
                    m.bNm().bNo();
                    throw th;
                }
            }
            m.bNm().bNo();
        }
        return i;
    }

    static void fI(Context context) {
        String str;
        int fH = fH(context);
        if (fH != -1) {
            str = "PV=" + String.valueOf(fH + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!(file.isFile() && file.exists())) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file, false);
            pxK = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            if (pxK != null) {
                pxK.flush();
            }
        } catch (Throwable th) {
        }
    }

    private static void fJ(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    public static String findAddress(String str) {
        return !y.bNJ().bNK() ? android.webkit.WebView.findAddress(str) : null;
    }

    public static String getCrashExtraMessage(Context context) {
        String str = null;
        String str2 = "tbs_core_version:" + QbSdk.getTbsVersion(context) + ";tbs_sdk_version:36901" + ";";
        if (q.fz(context)) {
            return "nothing return ^-^." + str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c kx = c.kx(true);
        if (kx.pvc == null || QbSdk.puB) {
            str = "system webview get nothing...";
        } else {
            t tVar = kx.pvc;
            Object invokeStaticMethod = tVar.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = tVar.pxC.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
            }
            if (invokeStaticMethod != null) {
                str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + p.pxi + " ReaderPackVersion=" + p.pxj;
            }
            if (str == null) {
                str = "X5 core get nothing...";
            }
        }
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(str2);
        if (QbSdk.puX != null && QbSdk.puX.containsKey("weapp_id") && QbSdk.puX.containsKey("weapp_name")) {
            str = "weapp_id:" + QbSdk.puX.get("weapp_id") + ";weapp_name:" + QbSdk.puX.get("weapp_name") + ";";
            stringBuilder.append("\n");
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 8192 ? stringBuilder.substring(stringBuilder.length() - 8192) : stringBuilder.toString();
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object el;
        synchronized (WebView.class) {
            el = !y.bNJ().bNK() ? n.el("android.webkit.WebView", "getPluginList") : null;
        }
        return el;
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        bNE();
        return c.kx(true).getTbsNeedReboot();
    }

    public static int getTbsSDKVersion(Context context) {
        return 36901;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != pyc) {
                pyc = z;
                if (pyb == null) {
                    Paint paint = new Paint();
                    pyb = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (z) {
                    if (pyb.getAlpha() != NORMAL_MODE_ALPHA) {
                        pyb.setAlpha(NORMAL_MODE_ALPHA);
                    }
                } else if (pyb.getAlpha() != NIGHT_MODE_ALPHA) {
                    pyb.setAlpha(NIGHT_MODE_ALPHA);
                }
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                pxU = declaredMethod;
                if (declaredMethod != null) {
                    pxU.setAccessible(true);
                    pxU.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
            }
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.pxL) {
            this.pxM.addJavascriptInterface(obj, str);
        } else {
            this.pxN.addJavascriptInterface(obj, str);
        }
    }

    public void addView(View view) {
        if (this.pxL) {
            View view2 = this.pxM.getView();
            try {
                Method c = n.c(view2, "addView", View.class);
                c.setAccessible(true);
                c.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.addView(view);
    }

    public boolean canGoBack() {
        return !this.pxL ? this.pxN.canGoBack() : this.pxM.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.pxL ? this.pxN.canGoBackOrForward(i) : this.pxM.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.pxL ? this.pxN.canGoForward() : this.pxM.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.pxL) {
            return this.pxM.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object b = n.b(this.pxN, "canZoomIn");
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.pxL) {
            return this.pxM.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object b = n.b(this.pxN, "canZoomOut");
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.pxL) {
            return this.pxM.capturePicture();
        }
        Object b = n.b(this.pxN, "capturePicture");
        return b == null ? null : (Picture) b;
    }

    public void clearCache(boolean z) {
        if (this.pxL) {
            this.pxM.clearCache(z);
        } else {
            this.pxN.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.pxL) {
            this.pxM.clearFormData();
        } else {
            this.pxN.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.pxL) {
            this.pxM.clearHistory();
        } else {
            this.pxN.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.pxL) {
            this.pxM.clearMatches();
        } else {
            this.pxN.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.pxL) {
            this.pxM.clearSslPreferences();
        } else {
            this.pxN.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.pxL) {
            this.pxM.clearView();
        } else {
            n.b(this.pxN, "clearView");
        }
    }

    public void computeScroll() {
        if (this.pxL) {
            this.pxM.computeScroll();
        } else {
            this.pxN.computeScroll();
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.pxL ? WebBackForwardList.a(this.pxM.copyBackForwardList()) : WebBackForwardList.a(this.pxN.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        if (this.pxL) {
            try {
                return this.pxM.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            return obj;
        } else {
            return n.a(this.pxN, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public void destroy() {
        if (!(this.pxQ || this.pxP == 0)) {
            this.pxQ = true;
            String str = SQLiteDatabase.KeyEmpty;
            String str2 = SQLiteDatabase.KeyEmpty;
            String str3 = SQLiteDatabase.KeyEmpty;
            if (this.pxL) {
                Bundle sdkQBStatisticsInfo = this.pxM.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int fH = fH(this.mContext);
                if (fH == -1) {
                    fH = this.pxP;
                }
                this.pxP = fH;
                fJ(this.mContext);
            }
            com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.pxP, this.pxL, bND());
            this.pxP = 0;
            this.pxQ = false;
        }
        if (this.pxL) {
            this.pxM.destroy();
            return;
        }
        Object invoke;
        try {
            Class cls = Class.forName("android.webkit.WebViewClassic");
            Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
            method.setAccessible(true);
            invoke = method.invoke(null, new Object[]{this.pxN});
            if (invoke != null) {
                Field declaredField = cls.getDeclaredField("mListBoxDialog");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(invoke);
                if (obj != null) {
                    Dialog dialog = (Dialog) obj;
                    dialog.setOnCancelListener(null);
                    Class cls2 = Class.forName("android.app.Dialog");
                    Field declaredField2 = cls2.getDeclaredField("CANCEL");
                    declaredField2.setAccessible(true);
                    int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                    Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                    declaredField3.setAccessible(true);
                    ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                }
            }
        } catch (Exception e) {
        }
        this.pxN.destroy();
        try {
            declaredField2 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            declaredField2.setAccessible(true);
            ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField2.get(null);
            if (componentCallbacks != null) {
                declaredField2.set(null, null);
                declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                declaredField2.setAccessible(true);
                invoke = declaredField2.get(null);
                if (invoke != null) {
                    List list = (List) invoke;
                    synchronized (list) {
                        list.remove(componentCallbacks);
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public void documentHasImages(Message message) {
        if (this.pxL) {
            this.pxM.documentHasImages(message);
        } else {
            this.pxN.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.pxL) {
            this.pxM.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        n.a(this.pxN, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
    }

    public void evaluateJavascript(String str, u<String> uVar) {
        Method c;
        if (this.pxL) {
            try {
                c = n.c(this.pxM.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                c.setAccessible(true);
                c.invoke(this.pxM.getView(), new Object[]{str, uVar});
            } catch (Exception e) {
                loadUrl(str);
            }
        } else if (VERSION.SDK_INT >= 19) {
            try {
                c = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                c.setAccessible(true);
                c.invoke(this.pxN, new Object[]{str, uVar});
            } catch (Exception e2) {
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.pxL) {
            return this.pxM.findAll(str);
        }
        Object a = n.a(this.pxN, "findAll", new Class[]{String.class}, str);
        return a == null ? 0 : ((Integer) a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.pxL) {
            this.pxM.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            n.a(this.pxN, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.pxL) {
            return this.pxM.findHierarchyView(str, i);
        }
        return (View) n.a(this.pxN, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.pxL) {
            this.pxM.findNext(z);
        } else {
            this.pxN.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.pxL) {
            this.pxM.flingScroll(i, i2);
        } else {
            this.pxN.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.pxL) {
            this.pxM.freeMemory();
        } else {
            n.b(this.pxN, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.pxL ? this.pxN.getCertificate() : this.pxM.getCertificate();
    }

    public int getContentHeight() {
        return !this.pxL ? this.pxN.getContentHeight() : this.pxM.getContentHeight();
    }

    public int getContentWidth() {
        if (this.pxL) {
            return this.pxM.getContentWidth();
        }
        Object b = n.b(this.pxN, "getContentWidth");
        return b == null ? 0 : ((Integer) b).intValue();
    }

    public Bitmap getFavicon() {
        return !this.pxL ? this.pxN.getFavicon() : this.pxM.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.pxL ? new HitTestResult(this.pxN.getHitTestResult()) : new HitTestResult(this.pxM.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.pxL ? this.pxN.getHttpAuthUsernamePassword(str, str2) : this.pxM.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.pxL ? this.pxN.getOriginalUrl() : this.pxM.getOriginalUrl();
    }

    public int getProgress() {
        return !this.pxL ? this.pxN.getProgress() : this.pxM.getProgress();
    }

    @Deprecated
    public float getScale() {
        if (this.pxL) {
            return this.pxM.getScale();
        }
        Object b = n.b(this.pxN, "getScale");
        return b == null ? 0.0f : ((Float) b).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.pxO != null) {
            return this.pxO;
        }
        if (this.pxL) {
            WebSettings webSettings = new WebSettings(this.pxM.getSettings());
            this.pxO = webSettings;
            return webSettings;
        }
        webSettings = new WebSettings(this.pxN.getSettings());
        this.pxO = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.pxL ? null : this.pxM.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.pxL ? this.pxN.getTitle() : this.pxM.getTitle();
    }

    public String getUrl() {
        return !this.pxL ? this.pxN.getUrl() : this.pxM.getUrl();
    }

    public View getView() {
        return !this.pxL ? this.pxN : this.pxM.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.pxL) {
            return this.pxM.getVisibleTitleHeight();
        }
        Object b = n.b(this.pxN, "getVisibleTitleHeight");
        return b == null ? 0 : ((Integer) b).intValue();
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.pxL ? null : this.pxM.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.pxL ? this.pxM.getView().getScrollX() : this.pxN.getScrollX();
    }

    public int getWebScrollY() {
        return this.pxL ? this.pxM.getView().getScrollY() : this.pxN.getScrollY();
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.pxL ? null : this.pxM.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.pxL ? null : this.pxM.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.pxL ? (View) n.b(this.pxN, "getZoomControls") : this.pxM.getZoomControls();
    }

    public void goBack() {
        if (this.pxL) {
            this.pxM.goBack();
        } else {
            this.pxN.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.pxL) {
            this.pxM.goBackOrForward(i);
        } else {
            this.pxN.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.pxL) {
            this.pxM.goForward();
        } else {
            this.pxN.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.pxL) {
            this.pxM.invokeZoomPicker();
        } else {
            this.pxN.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return pyc;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.pxL) {
            return this.pxM.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object b = n.b(this.pxN, "isPrivateBrowsingEnabled");
        return b == null ? false : ((Boolean) b).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.pxL) {
            this.pxM.loadData(str, str2, str3);
        } else {
            this.pxN.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.pxL) {
            this.pxM.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.pxN.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (this.pxL && this.pxR != null) {
            this.pxR.a("load_url_gap", (byte) 2);
            this.pxR.a("init_all", (byte) 2);
            this.pxR.az(this.pxM.hashCode(), str);
        }
        if (str != null && !showDebugView(str)) {
            if (this.pxL) {
                this.pxM.loadUrl(str);
            } else {
                this.pxN.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (this.pxL && this.pxR != null) {
            this.pxR.a("load_url_gap", (byte) 2);
            this.pxR.a("init_all", (byte) 2);
            this.pxR.az(this.pxM.hashCode(), str);
        }
        if (str != null && !showDebugView(str)) {
            if (this.pxL) {
                this.pxM.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.pxN.loadUrl(str, map);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (!(this.pxQ || this.pxP == 0)) {
            this.pxQ = true;
            String str = SQLiteDatabase.KeyEmpty;
            String str2 = SQLiteDatabase.KeyEmpty;
            String str3 = SQLiteDatabase.KeyEmpty;
            if (this.pxL) {
                Bundle sdkQBStatisticsInfo = this.pxM.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                int fH = fH(this.mContext);
                if (fH == -1) {
                    fH = this.pxP;
                }
                this.pxP = fH;
                fJ(this.mContext);
            }
            com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.pxP, this.pxL, bND());
            this.pxP = 0;
            this.pxQ = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.pye != null ? !this.pye.onLongClick(view) ? df(view) : true : df(view);
    }

    public void onPause() {
        if (this.pxL) {
            this.pxM.onPause();
        } else {
            n.b(this.pxN, "onPause");
        }
    }

    public void onResume() {
        if (this.pxL) {
            this.pxM.onResume();
        } else {
            n.b(this.pxN, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && fG(this.mContext) && isHardwareAccelerated() && i > 0 && i2 > 0 && getLayerType() != 2 && this.pxM != null && this.pxM.getView() != null) {
            this.pxM.getView().setLayerType(2, null);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.mContext == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (pxV == null) {
            pxV = this.mContext.getApplicationInfo().packageName;
        }
        if (pxV == null || !(pxV.equals("com.tencent.mm") || pxV.equals("com.tencent.mobileqq"))) {
            if (!(i == 0 || this.pxQ || this.pxP == 0)) {
                this.pxQ = true;
                String str = SQLiteDatabase.KeyEmpty;
                String str2 = SQLiteDatabase.KeyEmpty;
                String str3 = SQLiteDatabase.KeyEmpty;
                if (this.pxL) {
                    Bundle sdkQBStatisticsInfo = this.pxM.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if ("com.qzone".equals(this.mContext.getApplicationInfo().packageName)) {
                    int fH = fH(this.mContext);
                    if (fH == -1) {
                        fH = this.pxP;
                    }
                    this.pxP = fH;
                    fJ(this.mContext);
                }
                com.tencent.smtt.sdk.a.b.a(this.mContext, str, str2, str3, this.pxP, this.pxL, bND());
                this.pxP = 0;
                this.pxQ = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.pxL ? this.pxN.overlayHorizontalScrollbar() : this.pxM.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.pxL ? this.pxM.overlayVerticalScrollbar() : this.pxN.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.pxL ? this.pxN.pageDown(z) : this.pxM.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.pxL ? this.pxN.pageUp(z) : this.pxM.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.pxL) {
            this.pxM.pauseTimers();
        } else {
            this.pxN.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.pxL) {
            this.pxM.postUrl(str, bArr);
        } else {
            this.pxN.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.pxL) {
            this.pxM.refreshPlugins(z);
            return;
        }
        n.a(this.pxN, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void reload() {
        if (this.pxL) {
            this.pxM.reload();
        } else {
            this.pxN.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.pxL) {
            if (VERSION.SDK_INT >= 11) {
                n.a(this.pxN, "removeJavascriptInterface", new Class[]{String.class}, str);
                return;
            }
            this.pxM.removeJavascriptInterface(str);
        }
    }

    public void removeView(View view) {
        if (this.pxL) {
            View view2 = this.pxM.getView();
            try {
                Method c = n.c(view2, "removeView", View.class);
                c.setAccessible(true);
                c.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.removeView(view);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.pxL) {
            View view2 = this.pxM.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view != this) {
                view2 = view;
            }
            return viewGroup.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.webkit.WebView webView = this.pxN;
        if (view == this) {
            view = this.pxN;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.pxL) {
            this.pxM.requestFocusNodeHref(message);
        } else {
            this.pxN.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.pxL) {
            this.pxM.requestImageRef(message);
        } else {
            this.pxN.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.pxL) {
            return this.pxM.restorePicture(bundle, file);
        }
        Object a = n.a(this.pxN, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.pxL ? WebBackForwardList.a(this.pxN.restoreState(bundle)) : WebBackForwardList.a(this.pxM.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.pxL) {
            this.pxM.resumeTimers();
        } else {
            this.pxN.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.pxL) {
            this.pxM.savePassword(str, str2, str3);
            return;
        }
        n.a(this.pxN, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.pxL) {
            return this.pxM.savePicture(bundle, file);
        }
        Object a = n.a(this.pxN, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.pxL ? WebBackForwardList.a(this.pxN.saveState(bundle)) : WebBackForwardList.a(this.pxM.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.pxL) {
            this.pxM.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            n.a(this.pxN, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, u<String> uVar) {
        if (this.pxL) {
            this.pxM.saveWebArchive(str, z, uVar);
        } else if (VERSION.SDK_INT >= 11) {
            n.a(this.pxN, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), uVar);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.pxL) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
        }
    }

    public void setBackgroundColor(int i) {
        if (this.pxL) {
            this.pxM.setBackgroundColor(i);
        } else {
            this.pxN.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.pxL) {
            this.pxM.setCertificate(sslCertificate);
        } else {
            this.pxN.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.pxL) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.pxL) {
            this.pxM.setDownloadListener(new b(this, downloadListener));
        } else {
            this.pxN.setDownloadListener(new DownloadListener() {
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (downloadListener == null) {
                        c.a(WebView.this.mContext, str, null, null);
                    } else {
                        downloadListener.onDownloadStart(str, str2, str3, str4, j);
                    }
                }
            });
        }
    }

    @TargetApi(16)
    public void setFindListener(final FindListener findListener) {
        if (this.pxL) {
            this.pxM.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.pxN.setFindListener(new android.webkit.WebView.FindListener() {
                public void onFindResultReceived(int i, int i2, boolean z) {
                    findListener.onFindResultReceived(i, i2, z);
                }
            });
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.pxL) {
            this.pxM.setHorizontalScrollbarOverlay(z);
        } else {
            this.pxN.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.pxL) {
            this.pxM.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.pxN.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.pxL) {
            this.pxM.setInitialScale(i);
        } else {
            this.pxN.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.pxL) {
            this.pxM.setMapTrackballToArrowKeys(z);
            return;
        }
        n.a(this.pxN, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void setNetworkAvailable(boolean z) {
        if (this.pxL) {
            this.pxM.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.pxN.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.pxL) {
            View view = this.pxM.getView();
            try {
                if (this.pyd == null) {
                    Method c = n.c(view, "getListenerInfo", new Class[0]);
                    c.setAccessible(true);
                    Object invoke = c.invoke(view, null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.pyd = declaredField.get(invoke);
                }
                this.pye = onLongClickListener;
                getView().setOnLongClickListener(this);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(final PictureListener pictureListener) {
        if (this.pxL) {
            if (pictureListener == null) {
                this.pxM.setPictureListener(null);
            } else {
                this.pxM.setPictureListener(new com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener() {
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                        WebView.this.pxM = iX5WebViewBase;
                        pictureListener.onNewPicture(WebView.this, picture);
                    }

                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }
                });
            }
        } else if (pictureListener == null) {
            this.pxN.setPictureListener(null);
        } else {
            this.pxN.setPictureListener(new android.webkit.WebView.PictureListener() {
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.pxL) {
            this.pxM.getView().setScrollBarStyle(i);
        } else {
            this.pxN.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.pxL) {
            this.pxM.setVerticalScrollbarOverlay(z);
        } else {
            this.pxN.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.pxM == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.pxM.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        getView().setVisibility(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.pxL) {
            IX5WebViewBase iX5WebViewBase = this.pxM;
            if (webChromeClient != null) {
                IX5WebChromeClient iX5WebChromeClient;
                z zVar = y.bNJ().pyh;
                if (zVar.pxC == null) {
                    iX5WebChromeClient = null;
                } else {
                    Object invokeStaticMethod = zVar.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
                    iX5WebChromeClient = invokeStaticMethod == null ? null : (IX5WebChromeClient) invokeStaticMethod;
                }
                Object dVar = new d(iX5WebChromeClient, this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(r1);
            return;
        }
        android.webkit.WebView webView = this.pxN;
        if (webChromeClient != null) {
            webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
        }
        webView.setWebChromeClient(webChromeClient2);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.pxL) {
            this.pxM.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(x xVar) {
        this.mWebViewCallbackClient = xVar;
        if (this.pxL && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        if (this.pxL) {
            IX5WebViewBase iX5WebViewBase = this.pxM;
            if (webViewClient != null) {
                Object invokeStaticMethod = y.bNJ().pyh.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
                Object eVar = new e(invokeStaticMethod == null ? null : (IX5WebViewClient) invokeStaticMethod, this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(r1);
            return;
        }
        android.webkit.WebView webView = this.pxN;
        if (webViewClient != null) {
            webViewClient2 = new SystemWebViewClient(this, webViewClient);
        }
        webView.setWebViewClient(webViewClient2);
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.pxL) {
            this.pxM.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            d.fX(this.mContext).a(toLowerCase, this, this.mContext, k.bNl().getLooper());
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com") || this.pxL) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "utf-8", null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.pxL) {
            this.pxM.stopLoading();
        } else {
            this.pxN.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.pxL) {
            try {
                n.b(this.pxM.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.super_computeScroll();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.pxL) {
            return this.pxN.super_dispatchTouchEvent(motionEvent);
        }
        try {
            Object a = n.a(this.pxM.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.pxL) {
            return this.pxN.super_onInterceptTouchEvent(motionEvent);
        }
        try {
            Object a = n.a(this.pxM.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.pxL) {
            try {
                n.a(this.pxM.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.super_onOverScrolled(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.pxL) {
            try {
                n.a(this.pxM.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.pxN.super_onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.pxL) {
            return this.pxN.super_onTouchEvent(motionEvent);
        }
        try {
            Object a = n.a(this.pxM.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.pxL) {
            return this.pxN.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object a = n.a(this.pxM.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z != pyc) {
            pyc = z;
            if (z) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!pyc) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.pxL ? this.pxN.zoomIn() : this.pxM.zoomIn();
    }

    public boolean zoomOut() {
        return !this.pxL ? this.pxN.zoomOut() : this.pxM.zoomOut();
    }
}
