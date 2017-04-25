package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShareAppMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.webview.d.af;
import com.tencent.mm.plugin.webview.d.ai;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageData;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wework.api.WWAPIFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener {
    private static final Set<String> lee;
    private static final ArrayList<aa> lkp = new ArrayList();
    private static RenderPriority lkv = RenderPriority.NORMAL;
    private static int llm = 0;
    private static IUtils llr = null;
    private static final Pattern lly = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern llz = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private String aZj = "";
    private String bnX;
    public volatile String bpX = null;
    private int bsZ;
    public com.tencent.smtt.sdk.x dOV = new com.tencent.smtt.sdk.x(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final boolean p(MotionEvent motionEvent) {
            if (this.llO.igd == null) {
                return false;
            }
            return this.llO.igd.z(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (this.llO.igd == null) {
                return false;
            }
            return this.llO.igd.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void RC() {
            if (this.llO.igd != null) {
                this.llO.igd.bKp();
            }
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            if (this.llO.igd != null) {
                this.llO.igd.c(i, i2, z, z2);
            }
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (this.llO.igd != null) {
                this.llO.igd.r(i, i2, i3, i4);
                int height = this.llO.cU().cV().getHeight();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "t = %d, threshold = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(height)});
            }
        }

        public final boolean q(MotionEvent motionEvent) {
            if (this.llO.igd == null) {
                return false;
            }
            return this.llO.igd.A(motionEvent);
        }

        public final boolean r(MotionEvent motionEvent) {
            if (this.llO.igd == null) {
                return false;
            }
            return this.llO.igd.B(motionEvent);
        }
    };
    private ProxyWebViewClientExtension dOW = new ProxyWebViewClientExtension(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object valueOf;
            String str2 = null;
            String str3 = "MicroMsg.WebViewUI";
            String str4 = "method = %s, bundler == null ? %b, invoker == null ? %b";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bundle == null);
            objArr[2] = Boolean.valueOf(this.llO.liH == null);
            com.tencent.mm.sdk.platformtools.v.i(str3, str4, objArr);
            if (!(be.kS(str) || bundle == null || this.llO.liH == null)) {
                String EI;
                try {
                    EI = this.llO.liH.EI("WebviewEnableTbsDownload");
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "get dynamic config failed");
                    EI = str2;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "enable value = %s", new Object[]{EI});
                if (be.kS(EI) || !EI.equals("0")) {
                    Bundle i;
                    if (str.equals("addDownloadTask")) {
                        try {
                            i = this.llO.liH.i(14, bundle);
                            if (i != null) {
                                valueOf = Long.valueOf(i.getLong("download_id", 0));
                            }
                        } catch (RemoteException e2) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
                        }
                    }
                    if (str.equals("cancelDownloadTask")) {
                        try {
                            i = this.llO.liH.i(16, bundle);
                            if (i != null) {
                                valueOf = Boolean.valueOf(i.getBoolean("cancel_result", false));
                            }
                        } catch (RemoteException e3) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
                        }
                    }
                    if (str.equals("queryDownloadTask")) {
                        try {
                            i = this.llO.liH.i(15, bundle);
                            if (i != null) {
                                valueOf = Integer.valueOf(i.getInt("download_state", 0));
                            }
                        } catch (RemoteException e4) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
                        }
                    }
                    if (str.equals("installDownloadTask")) {
                        try {
                            i = this.llO.liH.i(17, bundle);
                            if (i != null) {
                                valueOf = Boolean.valueOf(i.getBoolean("install_result"));
                            }
                        } catch (RemoteException e5) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
                        }
                    }
                    if (str.equals("getDrawable")) {
                        str3 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                        int i2 = bundle.getInt("resourceId");
                        if (!be.kS(str3) && i2 > 0) {
                            try {
                                valueOf = com.tencent.mm.be.a.b(this.llO.getPackageManager().getResourcesForApplication(str3), i2);
                            } catch (Exception e6) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", new Object[]{str3, e6.getMessage()});
                            }
                        }
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
                }
            }
            return valueOf;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.llO.dOV.p(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.llO.dOV.r(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.llO.dOV.q(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.llO.dOV.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.llO.dOV.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.llO.dOV.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            this.llO.dOV.RC();
        }
    };
    private long dPP = 0;
    private long dPR = 0;
    private volatile String dPT = "";
    protected int dQw;
    private View dQx;
    public View dQy;
    com.tencent.mm.ui.tools.l eIV;
    private long evC = 0;
    private int fromScene;
    private ServiceConnection gfD = new ServiceConnection(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (this.llO.igd == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                return;
            }
            this.llO.liH = com.tencent.mm.plugin.webview.stub.d.a.S(iBinder);
            try {
                this.llO.liH.a(this.llO.leB, this.llO.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "onServiceConnected, invoker == null ? %b";
            Object[] objArr = new Object[1];
            if (this.llO.liH != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
            if (this.llO.liH == null) {
                com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                this.llO.finish();
                return;
            }
            this.llO.aqj();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((this.llO.lln && WebViewUI.llm <= 0) || (!this.llO.lln && WebViewUI.llm <= 1)) {
                com.tencent.mm.plugin.webview.e.b.b(this.llO.liH);
                com.tencent.mm.plugin.webview.modelcache.u biN = a.lgb;
                for (int i = 0; i < biN.lfZ.size(); i++) {
                    biN.lfZ.valueAt(i);
                }
                biN.lfZ.clear();
                biN.lga.clear();
            }
            if (this.llO.lln || this.llO.llo || this.llO.isFinishing()) {
                this.llO.liH = null;
                return;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            this.llO.bjW();
        }
    };
    public ac handler;
    private int height;
    public MMWebView igd;
    private boolean jLZ = true;
    protected ai ldG = new ai();
    private String ldY;
    public com.tencent.mm.plugin.webview.stub.e leB = new com.tencent.mm.plugin.webview.stub.e.a(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final boolean g(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "callback, actionCode = " + i);
            final String string;
            final String string2;
            final boolean z;
            int i2;
            final long j;
            final String string3;
            final Map hashMap;
            switch (i) {
                case as.CTRL_INDEX /*13*/:
                    if (bundle != null) {
                        bundle.putString("application_language", this.llO.liH.getLanguage());
                        this.llO.lkQ = new e(bundle);
                        break;
                    }
                    break;
                case am.CTRL_INDEX /*15*/:
                    string = bundle.getString("exdevice_device_id");
                    final boolean z2 = bundle.getBoolean("exdevice_is_complete");
                    final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                    final boolean z3 = bundle.getBoolean("exdevice_is_lan_device");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                String str = string;
                                byte[] bArr = byteArray;
                                boolean z = z2;
                                boolean z2 = z3;
                                if (fVar.loB) {
                                    String str2 = "MicroMsg.JsApiHandler";
                                    String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = str;
                                    objArr[1] = Boolean.valueOf(z);
                                    objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                    com.tencent.mm.sdk.platformtools.v.i(str2, str3, objArr);
                                    if (be.kS(str)) {
                                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONArray jSONArray = new JSONArray();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("deviceId", str);
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ();
                                        if (com.tencent.mm.plugin.webview.ui.tools.a.b.aR(bArr) || (bArr != null && z2)) {
                                            jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                                        }
                                        jSONArray.put(jSONObject2);
                                        jSONObject.put("devices", jSONArray);
                                        if (z) {
                                            jSONObject.put("isCompleted", "1");
                                        } else {
                                            jSONObject.put("isCompleted", "0");
                                        }
                                    } catch (Exception e) {
                                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
                                    }
                                    try {
                                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[]{com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onScanWXDeviceResult", jSONObject, fVar.loD, fVar.loE)});
                                        fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                                    } catch (Exception e2) {
                                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e2.getMessage()});
                                    }
                                    if (!z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.bkQ().lnq = bArr;
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[]{this.llY.llO.lkl, this.llY.llO.lkw});
                        }
                    });
                    break;
                case 16:
                    string2 = bundle.getString("exdevice_device_id");
                    final String string4 = bundle.getString("exdevice_brand_name");
                    final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                String str = string2;
                                byte[] bArr = byteArray2;
                                String str2 = string4;
                                if (fVar.loB) {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[]{str, str2});
                                    if (be.kS(str) || be.kS(str2) || bArr == null) {
                                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass40(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onReceiveDataFromWXDevice", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                            }
                        }
                    });
                    break;
                case 17:
                    string2 = bundle.getString("exdevice_device_id");
                    final boolean z4 = bundle.getBoolean("exdevice_is_bound");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                String str = string2;
                                boolean z = z4;
                                if (fVar.loB) {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[]{str, Boolean.valueOf(z)});
                                    if (be.kS(str)) {
                                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    if (z) {
                                        hashMap.put("state", "bind");
                                    } else {
                                        hashMap.put("state", "unbind");
                                    }
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass41(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onWXDeviceBindStateChange", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 18:
                    z = bundle.getBoolean("exdevice_bt_state");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                boolean z = z;
                                if (fVar.loB) {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[]{Boolean.valueOf(z)});
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass42(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onWXDeviceBluetoothStateChange", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 19:
                case 20:
                case 21:
                case bf.CTRL_INDEX /*22*/:
                case 23:
                case 24:
                case 25:
                    this.llO.k(i, bundle);
                    break;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                case bv.CTRL_INDEX /*27*/:
                case com.tencent.mm.plugin.appbrand.jsapi.p.CTRL_INDEX /*28*/:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                case 30:
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                case JsApiChooseVideo.CTRL_INDEX /*36*/:
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                case aq.CTRL_INDEX /*38*/:
                case com.tencent.mm.plugin.appbrand.jsapi.y.CTRL_INDEX /*39*/:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    this.llO.n(i, bundle);
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    z = bundle.getBoolean("exdevice_lan_state");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                boolean z = z;
                                if (fVar.loB) {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[]{Boolean.valueOf(z)});
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass43(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onWXDeviceLanStateChange", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 48:
                    String[] stringArray = bundle.getStringArray("msgIds");
                    String[] stringArray2 = bundle.getStringArray("contents");
                    String[] stringArray3 = bundle.getStringArray("senders");
                    int[] intArray = bundle.getIntArray("msgTypes");
                    int[] intArray2 = bundle.getIntArray("msgTimes");
                    final JSONArray jSONArray = new JSONArray();
                    int length = stringArray.length;
                    for (i2 = 0; i2 < length; i2++) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("newMsgId", stringArray[i2]);
                            jSONObject.put("content", stringArray2[i2]);
                            jSONObject.put("sender", stringArray3[i2]);
                            jSONObject.put("msgType", intArray[i2]);
                            jSONObject.put("msgTime", intArray2[i2]);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + e.getMessage());
                        }
                    }
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                JSONArray jSONArray = jSONArray;
                                if (jSONArray == null) {
                                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("msgs", jSONArray);
                                ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass33(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onGetMsgProofItems", hashMap, fVar.loD, fVar.loE)));
                            }
                        }
                    });
                    break;
                case 1001:
                    if (!this.llO.isFinishing()) {
                        this.llO.finish();
                        break;
                    }
                    break;
                case 1002:
                    j = bundle.getLong("download_manager_downloadid");
                    string = bundle.getString("download_manager_appid", "");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null && this.llY.llO.lkw != null && this.llY.llO.lkw.bjS() != null && this.llY.llO.lkw.bjS().uC(42)) {
                                this.llY.llO.lkl.c(string, j, "download_succ");
                            }
                        }
                    });
                    break;
                case 1003:
                    j = bundle.getLong("download_manager_downloadid");
                    string = bundle.getString("download_manager_appid", "");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null && this.llY.llO.lkw != null && this.llY.llO.lkw.bjS() != null && this.llY.llO.lkw.bjS().uC(42)) {
                                this.llY.llO.lkl.c(string, j, "download_fail");
                            }
                        }
                    });
                    break;
                case 1004:
                    string2 = bundle.getString("exdevice_device_id");
                    i2 = bundle.getInt("exdevice_on_state_change_state");
                    final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            boolean z = false;
                            if (this.llY.llO.lkl != null && this.llY.llO.lkw != null && this.llY.llO.lkw.bjS() != null) {
                                this.llY.llO.lkw.bjS();
                                JsapiPermissionWrapper.brB();
                                this.llY.llO.lkl.bo(string2, i2);
                            } else if (this.llY.llO.lkl == null || !valueOf.booleanValue()) {
                                String str = "MicroMsg.WebViewUI";
                                String str2 = "something null, %s, %s";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(this.llY.llO.lkl == null);
                                if (this.llY.llO.lkw == null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                com.tencent.mm.sdk.platformtools.v.w(str, str2, objArr);
                            } else {
                                this.llY.llO.lkl.bo(string2, i2);
                            }
                        }
                    });
                    break;
                case 1006:
                    if (this.llO.lkl != null) {
                        this.llO.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass23 llY;

                            public final void run() {
                                boolean z = false;
                                byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                if (byteArray == null || this.llY.llO.lkw == null || this.llY.llO.lkw.bjS() == null) {
                                    String str = "MicroMsg.WebViewUI";
                                    String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Boolean.valueOf(byteArray != null);
                                    if (this.llY.llO.lkw != null) {
                                        z = true;
                                    }
                                    objArr[1] = Boolean.valueOf(z);
                                    com.tencent.mm.sdk.platformtools.v.e(str, str2, objArr);
                                } else {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
                                    this.llY.llO.lkw.bjS().lWx = byteArray;
                                }
                                if (this.llY.llO.lkl != null) {
                                    this.llY.llO.lkl.bld();
                                }
                            }
                        });
                        break;
                    }
                    break;
                case 1007:
                    final long j2 = bundle.getLong("download_manager_downloadid");
                    final int i3 = bundle.getInt("download_manager_progress");
                    string3 = bundle.getString("download_manager_appid", "");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null && this.llY.llO.lkw != null && this.llY.llO.lkw.bjS() != null && this.llY.llO.lkw.bjS().uC(42)) {
                                this.llY.llO.lkl.g(string3, j2, i3);
                            }
                        }
                    });
                    break;
                case 1008:
                    j = bundle.getLong("download_manager_downloadid");
                    string = bundle.getString("download_manager_appid", "");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null && this.llY.llO.lkw != null && this.llY.llO.lkw.bjS() != null && this.llY.llO.lkw.bjS().uC(42)) {
                                this.llY.llO.lkl.c(string, j, "download_removed");
                            }
                        }
                    });
                    break;
                case 2002:
                    hashMap = new HashMap();
                    hashMap.put("err_msg", bundle.getString("playResult"));
                    hashMap.put("localId", bundle.getString("localId"));
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.M(hashMap);
                            }
                        }
                    });
                    break;
                case 2003:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.bp(string2, i2);
                            }
                        }
                    });
                    break;
                case 2004:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.bq(string2, i2);
                            }
                        }
                    });
                    break;
                case 2005:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.br(string2, i2);
                            }
                        }
                    });
                    break;
                case 2006:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.bs(string2, i2);
                            }
                        }
                    });
                    break;
                case 2007:
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.vE(2131236614);
                        }
                    });
                    break;
                case 2008:
                    hashMap = new HashMap();
                    hashMap.put("localId", bundle.getString("localId"));
                    hashMap.put("err_msg", bundle.getString("recordResult"));
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            this.llY.llO.NY(null);
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.N(hashMap);
                            }
                        }
                    });
                    break;
                case 2009:
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.NY(null);
                        }
                    });
                    break;
                case 2010:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.bt(string2, i2);
                            }
                        }
                    });
                    break;
                case 2011:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                String str = string2;
                                int i = i2;
                                if (fVar.loB) {
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
                                    Map hashMap = new HashMap();
                                    hashMap.put("localId", str);
                                    hashMap.put("percent", Integer.valueOf(i));
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass5(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onMediaFileUploadProgress", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                            }
                        }
                    });
                    break;
                case 4007:
                    final int i4 = bundle.getInt("nfc_key_on_touch_errcode", 0);
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                int i = i4;
                                if (fVar.loB) {
                                    Map hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(i));
                                    ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass11(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onNfcTouch", hashMap, fVar.loD, fVar.loE)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                            }
                        }
                    });
                    break;
                case 40001:
                    string2 = bundle.getString("err_msg");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llY.llO.lkl;
                                String str = string2;
                                Map hashMap = new HashMap();
                                hashMap.put("err_msg", str);
                                ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass15(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onBeaconMonitoring", hashMap, fVar.loD, fVar.loE)));
                            }
                        }
                    });
                    break;
                case 40002:
                    string3 = bundle.getString("uuid");
                    final int i5 = bundle.getInt("major");
                    final int i6 = bundle.getInt("minor");
                    final double d = bundle.getDouble("accuracy");
                    final double d2 = bundle.getDouble("rssi");
                    final float f = bundle.getFloat("heading");
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.lkl != null) {
                                this.llY.llO.lkl.a(string3, i5, i6, d, d2, f);
                            }
                        }
                    });
                    break;
                case 80001:
                case 80002:
                    this.llO.m(i, bundle);
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(final com.tencent.mm.plugin.webview.stub.c r4) {
            /*
            r3 = this;
            r0 = 0;
            r1 = 1;
            r2 = r3.llO;
            r2 = r2.lky;
            r2 = r2.lnc;
            if (r2 <= 0) goto L_0x003d;
        L_0x000a:
            r2 = r1;
        L_0x000b:
            if (r2 != 0) goto L_0x002e;
        L_0x000d:
            r2 = r3.llO;
            r2 = r2.lkz;
            r2 = r2.lnd;
            if (r2 <= 0) goto L_0x003f;
        L_0x0015:
            r2 = r1;
        L_0x0016:
            if (r2 != 0) goto L_0x002e;
        L_0x0018:
            r2 = r3.llO;
            r2 = r2.lkA;
            r2 = r2.lne;
            if (r2 <= 0) goto L_0x0041;
        L_0x0020:
            r2 = r1;
        L_0x0021:
            if (r2 != 0) goto L_0x002e;
        L_0x0023:
            r2 = r3.llO;
            r2 = r2.lkB;
            r2 = r2.lmR;
            if (r2 <= 0) goto L_0x002c;
        L_0x002b:
            r0 = r1;
        L_0x002c:
            if (r0 == 0) goto L_0x003c;
        L_0x002e:
            r0 = r3.llO;
            r0 = r0.handler;
            r2 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$23$19;
            r2.<init>(r3, r4);
            r0.post(r2);
        L_0x003c:
            return r1;
        L_0x003d:
            r2 = r0;
            goto L_0x000b;
        L_0x003f:
            r2 = r0;
            goto L_0x0016;
        L_0x0041:
            r2 = r0;
            goto L_0x0021;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23.a(com.tencent.mm.plugin.webview.stub.c):boolean");
        }

        public final boolean sM(final int i) {
            this.llO.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass23 llY;

                public final void run() {
                    this.llY.llO.setProgressBarIndeterminateVisibility(false);
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", new Object[]{Integer.valueOf(i)});
                    if (i != 0) {
                        this.llY.llO.ljR.finish();
                    } else if (!this.llY.llO.lkX) {
                        this.llY.llO.ljR.start();
                    }
                }
            });
            return true;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            if (this.llO.lkl != null) {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                this.llO.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass23 llY;

                    public final void run() {
                        this.llY.llO.lkl.a(str3, str4, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.P(bundle2), z2);
                        if (!be.kS(str4) && str4.equals("add_emoticon:ok")) {
                            this.llY.llO.lke = true;
                            try {
                                List arrayList = new ArrayList();
                                arrayList.add("2");
                                arrayList.add("");
                                arrayList.add("");
                                arrayList.add("");
                                this.llY.llO.liH.g(10431, arrayList);
                            } catch (RemoteException e) {
                            }
                        }
                    }
                });
            }
            return false;
        }

        public final String bjo() {
            return this.llO.bpX;
        }

        public final String Ra() {
            return this.llO.bkc();
        }

        public final String bjp() {
            return this.llO.getIntent().getStringExtra("srcUsername");
        }

        public final void hu(final boolean z) {
            final boolean booleanExtra = this.llO.getIntent().getBooleanExtra("forceHideShare", false);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra)});
            this.llO.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass23 llY;

                public final void run() {
                    if (booleanExtra) {
                        if (!(this.llY.llO.igd == null || be.kS(this.llY.llO.igd.getUrl()))) {
                            this.llY.llO.lkL.put(this.llY.llO.igd.getUrl(), Boolean.valueOf(false));
                        }
                        this.llY.llO.hz(false);
                        return;
                    }
                    if (!(this.llY.llO.igd == null || be.kS(this.llY.llO.igd.getUrl()))) {
                        this.llY.llO.lkL.put(this.llY.llO.igd.getUrl(), Boolean.valueOf(z));
                    }
                    this.llY.llO.hz(z);
                }
            });
        }

        public final void hv(final boolean z) {
            this.llO.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass23 llY;

                public final void run() {
                    this.llY.llO.hA(z);
                }
            });
        }

        public final void bjq() {
            if (this.llO.lkl != null) {
                this.llO.lkl.bjq();
            }
        }

        public final void B(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
            if (bundle != null) {
                Intent intent = new Intent();
                intent.putExtra("result_data", bundle);
                this.llO.setResult(-1, intent);
            }
            this.llO.finish();
        }

        public final void EB(String str) {
            int i = 0;
            try {
                i = be.getInt(str, 0);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + e.getMessage());
            }
            if (this.llO.igd == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
            } else {
                this.llO.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass23 llY;

                    public final void run() {
                        this.llY.llO.tf(i);
                    }
                });
            }
        }

        public final void bjr() {
            if (this.llO.lkl != null) {
                this.llO.lkl.bjr();
            }
        }

        public final void i(String str, final String str2, int i, int i2) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "result: " + str2);
            if (this.llO.llc != null && str != null && str.equals(this.llO.llc.lhm)) {
                if (this.llO.llc != null) {
                    this.llO.llc.bji();
                }
                this.llO.lla = i;
                this.llO.llb = i2;
                if (str2 != null && this.llO.eIV != null) {
                    this.llO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.igd != null) {
                                this.llY.llO.lkZ = str2;
                                this.llY.llO.eIV.b(this.llY.llO.igd, new OnCreateContextMenuListener(this) {
                                    final /* synthetic */ AnonymousClass26 lms;

                                    {
                                        this.lms = r1;
                                    }

                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        if (this.lms.llY.llO.lld != null) {
                                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "show webkit menu");
                                            this.lms.llY.llO.a(contextMenu, this.lms.llY.llO.lld);
                                            this.lms.llY.llO.lld = null;
                                        } else if (this.lms.llY.llO.lle != null) {
                                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "show IX5 menu");
                                            this.lms.llY.llO.a(contextMenu, this.lms.llY.llO.lle);
                                            this.lms.llY.llO.lle = null;
                                        }
                                    }
                                }, null);
                                this.llY.llO.eIV.aXZ();
                            }
                        }
                    });
                }
            }
        }

        public final void h(final int i, final Bundle bundle) {
            this.llO.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass23 llY;

                public final void run() {
                    if (this.llY.llO.igd != null) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + i);
                        Set<Object> hashSet = new HashSet();
                        if (i == 3003 || i == 3004) {
                            hashSet.add("menuItem:share:brand");
                            hashSet.add("menuItem:share:appMessage");
                            hashSet.add("menuItem:share:dataMessage");
                            hashSet.add("menuItem:share:timeline");
                            hashSet.add("menuItem:favorite");
                            hashSet.add("menuItem:profile");
                            hashSet.add("menuItem:addContact");
                            hashSet.add("menuItem:copyUrl");
                            hashSet.add("menuItem:openWithSafari");
                            hashSet.add("menuItem:share:email");
                            hashSet.add("menuItem:delete");
                            hashSet.add("menuItem:editTag");
                            hashSet.add("menuItem:readMode");
                            hashSet.add("menuItem:originPage");
                            hashSet.add("menuItem:share:qq");
                            hashSet.add("menuItem:share:weiboApp");
                            hashSet.add("menuItem:share:QZone");
                            hashSet.add("menuItem:share:enterprise");
                            hashSet.add("menuItem:share:wework");
                            hashSet.add("menuItem:share:weread");
                        } else if (bundle == null) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
                            return;
                        } else {
                            Collection stringArrayList = bundle.getStringArrayList("menu_item_list");
                            if (stringArrayList == null || stringArrayList.size() == 0) {
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
                                return;
                            }
                            hashSet.addAll(stringArrayList);
                            hashSet.remove("menuItem:exposeArticle");
                            hashSet.remove("menuItem:setFont");
                            hashSet.remove("menuItem:profile");
                            hashSet.remove("menuItem:addContact");
                        }
                        String url = this.llY.llO.igd.getUrl();
                        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.llY.llO.llF.get(url);
                        switch (i) {
                            case 3001:
                            case 3003:
                                SparseBooleanArray sparseBooleanArray2;
                                if (sparseBooleanArray == null) {
                                    sparseBooleanArray = new SparseBooleanArray();
                                    this.llY.llO.llF.put(url, sparseBooleanArray);
                                    sparseBooleanArray2 = sparseBooleanArray;
                                } else {
                                    sparseBooleanArray2 = sparseBooleanArray;
                                }
                                for (Object obj : hashSet) {
                                    int a = be.a((Integer) this.llY.llO.llG.get(obj), -1);
                                    if (a >= 0) {
                                        sparseBooleanArray2.put(a, true);
                                    }
                                }
                                return;
                            case 3002:
                            case 3004:
                                if (sparseBooleanArray != null) {
                                    for (Object obj2 : hashSet) {
                                        int a2 = be.a((Integer) this.llY.llO.llG.get(obj2), -1);
                                        if (a2 >= 0) {
                                            sparseBooleanArray.delete(a2);
                                        }
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }

        public final void da(final String str, String str2) {
            this.llO.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass23 llY;

                public final void run() {
                    if (be.kS(this.llY.llO.igd.getUrl())) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setPageOwner, null url");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + str);
                    this.llY.llO.lkM.put(this.llY.llO.igd.getUrl(), str);
                }
            });
        }

        public final Bundle i(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            Intent intent;
            int a;
            final String string;
            String string2;
            final boolean z;
            int init;
            switch (i) {
                case 11:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            if (this.llY.llO.lkR != null && this.llY.llO.lkR.isShowing()) {
                                this.llY.llO.lkR.dismiss();
                            }
                        }
                    });
                    break;
                case 12:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.lkQ = null;
                        }
                    });
                    break;
                case 18:
                    bundle2.putString("KPublisherId", this.llO.bnX);
                    intent = this.llO.getIntent();
                    if (intent != null) {
                        a = this.llO.Fl(this.llO.getIntent().getStringExtra("geta8key_username"));
                        bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                        bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                        bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                        bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                        bundle2.putInt("getA8KeyScene", a);
                        bundle2.putString("referUrl", this.llO.lfi);
                        break;
                    }
                    break;
                case bf.CTRL_INDEX /*22*/:
                    bundle2.putInt("pay_channel", this.llO.getIntent().getIntExtra("pay_channel", -1));
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", new Object[]{Integer.valueOf(this.llO.getIntent().getIntExtra("pay_channel", -1))});
                    break;
                case 25:
                    bundle2.putInt("scene", this.llO.getIntent().getIntExtra("scene", -1));
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", new Object[]{Integer.valueOf(this.llO.getIntent().getIntExtra("scene", 0))});
                    break;
                case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                    intent = this.llO.getIntent();
                    if (intent != null) {
                        bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                        bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                        break;
                    }
                    break;
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            WebViewUI.q(this.llY.llO);
                        }
                    });
                    break;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.llx.startLoading();
                        }
                    });
                    break;
                case JsApiChooseVideo.CTRL_INDEX /*36*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.llx.stopLoading();
                        }
                    });
                    break;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    string = bundle.getString("show_kb_placeholder");
                    a = bundle.getInt("show_kb_max_length");
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            WebViewUI.a(this.llY.llO, string, a);
                        }
                    });
                    break;
                case aq.CTRL_INDEX /*38*/:
                    if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                        this.llO.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass23 llY;

                            {
                                this.llY = r1;
                            }

                            public final void run() {
                                this.llY.llO.llx.hx(true);
                            }
                        });
                        break;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.y.CTRL_INDEX /*39*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            WebViewUI.r(this.llY.llO);
                        }
                    });
                    break;
                case 43:
                    string = bundle.getString("set_page_title_text");
                    a = d.bn(bundle.getString("set_page_title_color"), this.llO.getResources().getColor(2131689496));
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (this.llY.llO.jLZ) {
                                if (string != null) {
                                    this.llY.llO.Fd(string);
                                }
                                this.llY.llO.vC(a);
                            }
                        }
                    });
                    break;
                case 44:
                    Bitmap EY;
                    final String string3 = bundle.getString("set_navigation_bar_buttons_text");
                    string2 = bundle.getString("set_navigation_bar_buttons_icon_data");
                    z = be.kS(string3) && be.kS(string2);
                    try {
                        EY = d.EY(string2);
                    } catch (Exception e) {
                        EY = null;
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[]{e});
                    }
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            if (z) {
                                this.llY.llO.hC(true);
                                return;
                            }
                            this.llY.llO.hC(false);
                            if (EY != null && !EY.isRecycled()) {
                                WebViewUI webViewUI = this.llY.llO;
                                webViewUI.nDR.a(0, string3, new BitmapDrawable(this.llY.llO.getResources(), EY), new AnonymousClass30(webViewUI, webViewUI.bkp(), webViewUI.getIntent().getStringExtra("srcUsername")));
                            } else if (!be.kS(string3)) {
                                this.llY.llO.a(0, string3, new OnMenuItemClickListener(this) {
                                    final /* synthetic */ AnonymousClass40 lmz;

                                    {
                                        this.lmz = r1;
                                    }

                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "click item: %s", new Object[]{Integer.valueOf(menuItem.getItemId())});
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lmz.llY.llO.lkl;
                                        if (fVar.loB) {
                                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
                                            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onNavigationBarRightButtonClick", new HashMap(), fVar.loD, fVar.loE) + ")", null);
                                        } else {
                                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
                                        }
                                        return false;
                                    }
                                });
                            }
                        }
                    });
                    break;
                case 45:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.bkb();
                        }
                    });
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        {
                            this.llY = r1;
                        }

                        public final void run() {
                            this.llY.llO.llx.bjU();
                        }
                    });
                    break;
                case 48:
                case 49:
                    break;
                case 53:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            WebViewUI.a(this.llY.llO, bundle);
                        }
                    });
                    break;
                case 71:
                    if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                        bundle2.putString("enterprise_context_biz", this.llO.getIntent().getStringExtra("enterprise_biz_name"));
                        bundle2.putLong("enterprise_context_bizchatid", this.llO.getIntent().getLongExtra("biz_chat_chat_id", -1));
                        break;
                    }
                    break;
                case j.CTRL_INDEX /*72*/:
                    this.llO.llx.sZ(d.bn(bundle.getString("key_set_bounce_background_color"), this.llO.getResources().getColor(2131690121)));
                    break;
                case JsApiShareAppMessage.CTRL_INDEX /*73*/:
                    intent = this.llO.getIntent();
                    if (bundle != null) {
                        switch (bundle.getInt("scene")) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case JsApiGetLocation.CTRL_INDEX /*37*/:
                            case 45:
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                break;
                            case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                break;
                            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                                if (intent.getStringExtra("k_webview_img") != null) {
                                    bundle2.putString("webviewImg", intent.getStringExtra("k_webview_img"));
                                }
                                if (intent.getStringExtra("k_webview_html") != null) {
                                    bundle2.putString("webviewHtml", intent.getStringExtra("k_webview_html"));
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(intent.getStringExtra("k_expose_url"));
                                bundle2.putStringArrayList("content", arrayList);
                                break;
                            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                            case JsApiChooseVideo.CTRL_INDEX /*36*/:
                            case aq.CTRL_INDEX /*38*/:
                            case com.tencent.mm.plugin.appbrand.jsapi.y.CTRL_INDEX /*39*/:
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                                break;
                            default:
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "unknown expose scene: %d", new Object[]{Integer.valueOf(bundle.getInt("scene"))});
                                return bundle2;
                        }
                        bundle2.putString("username", intent.getStringExtra("k_username"));
                        break;
                    }
                    break;
                case 77:
                    bundle2.putString("KSessionId", this.llO.aZj);
                    bundle2.putString("KUserAgent", this.llO.lkb);
                    bundle2.putBoolean("KReportPage", this.llO.lkc);
                    bundle2.putString("KUrl", this.llO.llJ);
                    break;
                case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    this.llO.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            bundle2.putInt("height", WebViewUI.s(this.llY.llO));
                        }
                    });
                    break;
                case 101:
                    com.tencent.mm.ay.c.b(this.llO, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case 4005:
                case 4008:
                    final com.tencent.mm.e.a.j jVar = new com.tencent.mm.e.a.j();
                    jVar.aWx.context = this.llO.nDR.nEl;
                    jVar.aWx.actionCode = i;
                    if (4003 == i) {
                        jVar.aWx.aWz = bundle.getString("apdu");
                    } else if (4004 == i) {
                        string2 = bundle.getString("apdus");
                        boolean z2 = bundle.getBoolean("breakIfFail", true);
                        boolean z3 = bundle.getBoolean("breakIfTrue", false);
                        jVar.aWx.aWz = string2;
                        jVar.aWx.aWA = z2;
                        jVar.aWx.aWB = z3;
                    }
                    jVar.bpT = new Runnable(this) {
                        final /* synthetic */ AnonymousClass23 llY;

                        public final void run() {
                            bundle2.putAll(jVar.aWy.aWC);
                        }
                    };
                    com.tencent.mm.sdk.c.a.nhr.z(jVar);
                    break;
                case 5001:
                    if (this.llO.liH.isSDCardAvailable()) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "availableSize = %d", new Object[]{Long.valueOf(at.btV())});
                        if (at.btV() < 524288000) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.lcH);
                            z = true;
                            if (!file.exists()) {
                                z = file.mkdirs();
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z)});
                            }
                            if (z) {
                                init = FactoryProxyManager.getPlayManager().init(this.llO, com.tencent.mm.plugin.webview.a.lcH);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(this.llO, null);
                    } else {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(this.llO, null);
                    }
                    if (init == 0) {
                        if (WebViewUI.llr == null) {
                            WebViewUI.llr = new x();
                            FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.llr);
                        }
                        a = FactoryProxyManager.getPlayManager().getLocalServerPort();
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", new Object[]{Integer.valueOf(init), Integer.valueOf(a)});
                        af o = this.llO.lls;
                        if (a <= 0 || a > 65535) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[]{Integer.valueOf(a)});
                        }
                        if (!o.lex.contains(Integer.valueOf(a))) {
                            o.lex.add(Integer.valueOf(a));
                        }
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    string2 = bundle.getString("webview_video_proxy_cdn_urls");
                    String string4 = bundle.getString("webview_video_proxy_fileId");
                    int i2 = bundle.getInt("webview_video_proxy_file_size");
                    init = FactoryProxyManager.getPlayManager().startPlay(string2, bundle.getInt("webview_video_proxy_file_type"), string4, (long) i2, bundle.getInt("webview_video_proxy_file_duration"));
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{string2, string4, Integer.valueOf(i2), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init)});
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", r4);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(init)});
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, a));
                    break;
                case 6001:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent2.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent2.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                    this.llO.sendBroadcast(intent2);
                    break;
                case 90000:
                    bundle2.putStringArray("webview_get_route_url_list", this.llO.llq.bjj());
                    bundle2.putInt("webview_get_route_url_geta8key_scene", this.llO.bsZ);
                    break;
                case 90001:
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", new Object[]{this.llO.bkc(), CookieManager.getInstance().getCookie(this.llO.bkc())});
                    bundle2.putString("cookie", string2);
                    break;
                case 90002:
                    string = bundle.getString("traceid");
                    string2 = bundle.getString("username");
                    g gVar = g.pRr;
                    gVar.juo = string;
                    gVar.networkType = ai.bip();
                    gVar.aZj = com.tencent.smtt.utils.h.aX(string2 + be.Ni());
                    gVar.cvW = false;
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }

        public final void C(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setCustomMenu");
            ArrayList stringArrayList = bundle.getStringArrayList("keys");
            ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
            int size = stringArrayList.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(new com.tencent.mm.h.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
            }
            if (stringArrayList.size() > 0) {
                String url = this.llO.igd.getUrl();
                if (this.llO.lkN.containsKey(url)) {
                    this.llO.lkN.remove(url);
                }
                this.llO.lkN.put(url, arrayList);
            }
        }

        public final void hw(boolean z) {
            this.llO.hC(z);
        }
    };
    private volatile String lfi;
    public com.tencent.mm.plugin.webview.stub.d liH = null;
    protected boolean liT = true;
    protected boolean ljQ = false;
    protected MMFalseProgressBar ljR;
    private ImageButton ljS;
    private ImageButton ljT;
    private View ljU;
    private FrameLayout ljV;
    protected MovingImageButton ljW;
    private boolean ljX = false;
    private boolean ljY = false;
    private WebViewInputFooter ljZ;
    protected r lkA = new r(this);
    protected c lkB = new c(this);
    private boolean lkC = false;
    private com.tencent.mm.sdk.platformtools.x<String, Bitmap> lkD = new com.tencent.mm.sdk.platformtools.x(12);
    private HashMap<String, String> lkE = new HashMap();
    private b lkF;
    private int lkG = 0;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.h lkH;
    protected volatile boolean lkI = false;
    private boolean lkJ = false;
    private String lkK = "";
    private HashMap<String, Boolean> lkL = new HashMap();
    private HashMap<String, String> lkM = new HashMap();
    private HashMap<String, ArrayList<com.tencent.mm.h.d.b>> lkN = new HashMap();
    private HashMap<String, Boolean> lkO = new HashMap();
    private HashMap<String, Integer> lkP = new HashMap();
    private e lkQ;
    private com.tencent.mm.ui.base.h lkR = null;
    private View lkS;
    protected View lkT = null;
    private String lkU = null;
    private boolean lkV = false;
    private volatile boolean lkW = false;
    private volatile boolean lkX = false;
    private final Set<String> lkY = new HashSet();
    String lkZ;
    private boolean lka;
    private String lkb = "";
    private boolean lkc = false;
    private boolean lkd = false;
    private boolean lke = false;
    private boolean lkf = true;
    private boolean lkg = false;
    private boolean lkh = false;
    private boolean lki = false;
    private boolean lkj = true;
    private String lkk = null;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.f lkl = null;
    private View lkm;
    private ah lkn;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.d> lko = new ArrayList();
    private boolean lkq = false;
    private CustomViewCallback lkr;
    private View lks;
    private WebChromeClient lkt;
    private ProgressBar lku;
    private e lkw = null;
    private m lkx = new m(null);
    protected n lky = new n(this);
    protected p lkz = new p(this);
    private final com.tencent.mm.plugin.webview.e.c llA = new com.tencent.mm.plugin.webview.e.c();
    private final com.tencent.mm.plugin.webview.e.a llB = new com.tencent.mm.plugin.webview.e.a();
    private boolean llC;
    private OnLongClickListener llD = new OnLongClickListener(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final boolean onLongClick(View view) {
            return bkF();
        }

        private boolean bkF() {
            Exception e;
            HitTestResult hitTestResult = this.llO.igd.getHitTestResult();
            if (hitTestResult == null || be.kS(hitTestResult.getExtra())) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
                return false;
            }
            boolean z;
            boolean bv;
            try {
                bv = this.llO.liH.bv(hitTestResult.getExtra());
                if (bv) {
                    try {
                        this.llO.liH.bk(hitTestResult.getExtra(), this.llO.hashCode());
                    } catch (Exception e2) {
                        e = e2;
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                        z = bv;
                        if (!z) {
                            return z;
                        }
                        com.tencent.mm.ui.base.g.a(this.llO, hitTestResult.getExtra(), new String[]{com.tencent.mm.bd.a.O(this.llO, 2131234275), com.tencent.mm.bd.a.O(this.llO, 2131234271)}, "", new com.tencent.mm.ui.base.g.c(this.llO, hitTestResult.getExtra()) {
                            final /* synthetic */ WebViewUI llO;

                            public final void gT(int i) {
                                switch (i) {
                                    case 0:
                                        if (this.llO.Fo(r4)) {
                                            this.llO.igd.loadUrl(r4);
                                            return;
                                        }
                                        com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + r4);
                                        this.llO.bkf();
                                        return;
                                    case 1:
                                        com.tencent.mm.pluginsdk.j.c.a(this.llO, r4, r4);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                }
                z = bv;
            } catch (Exception e3) {
                e = e3;
                bv = true;
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                z = bv;
                if (!z) {
                    return z;
                }
                com.tencent.mm.ui.base.g.a(this.llO, hitTestResult.getExtra(), new String[]{com.tencent.mm.bd.a.O(this.llO, 2131234275), com.tencent.mm.bd.a.O(this.llO, 2131234271)}, "", /* anonymous class already generated */);
                return true;
            }
            if (!z) {
                return z;
            }
            com.tencent.mm.ui.base.g.a(this.llO, hitTestResult.getExtra(), new String[]{com.tencent.mm.bd.a.O(this.llO, 2131234275), com.tencent.mm.bd.a.O(this.llO, 2131234271)}, "", /* anonymous class already generated */);
            return true;
        }
    };
    private com.tencent.mm.plugin.webview.e.f.c llE = new com.tencent.mm.plugin.webview.e.f.c(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final void Ey(String str) {
            try {
                if (this.llO.liH != null) {
                    this.llO.liH.EM(str);
                } else {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
                }
            } catch (RemoteException e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "recog failed");
            }
        }
    };
    private Map<String, SparseBooleanArray> llF = new HashMap();
    private Map<String, Integer> llG = new HashMap();
    private String llH = "";
    private volatile String llI = null;
    private volatile String llJ = "";
    private com.tencent.mm.ui.base.i llK;
    private long llL = 0;
    private String[] llM = null;
    protected com.tencent.mm.ui.snackbar.b.b llN = new com.tencent.mm.ui.snackbar.b.b(this) {
        final /* synthetic */ WebViewUI llO;

        {
            this.llO = r1;
        }

        public final void bkH() {
            try {
                this.llO.liH.bjw();
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    int lla;
    int llb;
    com.tencent.mm.plugin.webview.e.f llc;
    HitTestResult lld;
    IX5WebViewBase.HitTestResult lle;
    private Map llf;
    private int llg = 0;
    private boolean llh = false;
    private String lli = "";
    private boolean llj = false;
    private final Map<String, String> llk = new HashMap();
    private final Set<String> lll = new HashSet();
    private boolean lln = false;
    private boolean llo = false;
    private com.tencent.mm.plugin.webview.d.a llp = new com.tencent.mm.plugin.webview.d.a(this.ldG);
    private com.tencent.mm.plugin.webview.e.i llq = new com.tencent.mm.plugin.webview.e.i();
    private af lls = new af();
    private boolean llt = true;
    public boolean llu = false;
    private int llv = 0;
    private boolean llw = false;
    public final f llx = new f();
    private int networkType;
    private int screenOrientation = -1;
    private int width;

    class AnonymousClass30 implements OnMenuItemClickListener {
        final /* synthetic */ String dIm;
        final /* synthetic */ WebViewUI llO;
        final /* synthetic */ boolean lmJ;

        AnonymousClass30(WebViewUI webViewUI, boolean z, String str) {
            this.llO = webViewUI;
            this.lmJ = z;
            this.dIm = str;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.lmJ) {
                WebViewUI.i(this.llO, this.dIm);
            } else {
                WebViewUI.C(this.llO);
            }
            return true;
        }
    }

    private static final class aa {
        final int id;
        final WeakReference<WebViewUI> keg;

        public aa(WebViewUI webViewUI) {
            this.keg = new WeakReference(webViewUI);
            this.id = webViewUI.hashCode();
        }
    }

    protected class c {
        final /* synthetic */ WebViewUI llO;
        int lmR = 0;

        protected c(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }
    }

    private static final class e {
        private String cUi;
        String lmS;
        private String lmT;
        private String lmU;
        private String lmV;
        private String lmW;
        private String lmX;
        private String lmY;

        public e(Bundle bundle) {
            this.lmS = bundle.getString("close_window_confirm_dialog_switch");
            this.lmT = bundle.getString("close_window_confirm_dialog_title_cn");
            this.lmU = bundle.getString("close_window_confirm_dialog_title_eng");
            this.lmV = bundle.getString("close_window_confirm_dialog_ok_cn");
            this.lmW = bundle.getString("close_window_confirm_dialog_ok_eng");
            this.lmX = bundle.getString("close_window_confirm_dialog_cancel_cn");
            this.lmY = bundle.getString("close_window_confirm_dialog_cancel_eng");
            this.cUi = bundle.getString("application_language");
        }

        public final String bkI() {
            if ("zh_CN".equals(this.cUi)) {
                return this.lmT;
            }
            return this.lmU;
        }

        public final String bkJ() {
            if ("zh_CN".equals(this.cUi)) {
                return this.lmV;
            }
            return this.lmW;
        }

        public final String bkK() {
            if ("zh_CN".equals(this.cUi)) {
                return this.lmX;
            }
            return this.lmY;
        }
    }

    protected class i extends WebViewClient {
        final /* synthetic */ WebViewUI llO;

        public i(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public boolean ER(String str) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                return true;
            }
            if (this.llO.Fn(str)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + str);
                return true;
            }
            this.llO.llI = str;
            return false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, final String str) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + str);
            if (!this.llO.Fo(str)) {
                com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
                this.llO.bkf();
                return true;
            } else if (com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "about:blank")) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
                return true;
            } else {
                try {
                    if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                        this.llO.Fi(str);
                        return true;
                    } else if (str.startsWith("weixin://dl/business") && com.tencent.mm.pluginsdk.d.i(Uri.parse(str))) {
                        String host = Uri.parse(this.llO.bpX).getHost();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.BROWSABLE");
                        intent.setData(Uri.parse(str + "&domain=" + host));
                        intent.putExtra("translate_link_scene", 13);
                        this.llO.startActivity(intent);
                        return true;
                    } else if (str.startsWith("weixinpreinject://iframe") && this.llO.lkH != null) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                        this.llO.lkH.lpb = true;
                        this.llO.lkH.blo();
                        if (!str.equals(this.llO.llH)) {
                            this.llO.llH = "";
                            return true;
                        } else if (!this.llO.Fj(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                                return true;
                            }
                            r1 = this.llO.lkx.Ft(str);
                            if (r1 == 0) {
                            }
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                            if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.llO.liH, this.llO.hashCode())) {
                                this.llO.igd.stopLoading();
                                this.llO.igd.post(new Runnable(this) {
                                    final /* synthetic */ i lna;

                                    public final void run() {
                                        this.lna.llO.Ff(str);
                                    }
                                });
                            } else {
                                this.llO.igd.stopLoading();
                            }
                            if (str.equals(this.llO.lkk)) {
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return ER(str);
                            }
                            this.llO.h(str, true, -1);
                            return true;
                        }
                    } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                        if ((this.llO.bpX.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && this.llO.lkh) {
                            com.tencent.mm.pluginsdk.d.aJ(this.llO.nDR.nEl, str);
                            this.llO.finish();
                            return true;
                        }
                        if (!str.equals(this.llO.llH)) {
                            this.llO.llH = "";
                            return true;
                        } else if (!this.llO.Fj(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                                return true;
                            }
                            r1 = this.llO.lkx.Ft(str);
                            if ((r1 == 0 && r1 != 2) || this.llO.lkd) {
                                return ER(str);
                            }
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                            if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.llO.liH, this.llO.hashCode())) {
                                this.llO.igd.stopLoading();
                                this.llO.igd.post(/* anonymous class already generated */);
                            } else {
                                this.llO.igd.stopLoading();
                            }
                            if (str.equals(this.llO.lkk)) {
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return ER(str);
                            }
                            this.llO.h(str, true, -1);
                            return true;
                        }
                    } else {
                        if (str.startsWith("weixin://webview/initReady/") || str.startsWith("weixin://webview/preInjectJSBridge/")) {
                            this.llO.lkH.blo();
                            return true;
                        }
                        if (!str.equals(this.llO.llH)) {
                            this.llO.llH = "";
                            return true;
                        } else if (!this.llO.Fj(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                r1 = this.llO.lkx.Ft(str);
                                if (r1 == 0) {
                                }
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                                if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.llO.liH, this.llO.hashCode())) {
                                    this.llO.igd.stopLoading();
                                } else {
                                    this.llO.igd.stopLoading();
                                    this.llO.igd.post(/* anonymous class already generated */);
                                }
                                if (str.equals(this.llO.lkk)) {
                                    this.llO.h(str, true, -1);
                                    return true;
                                }
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return ER(str);
                            }
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                    if (this.llO.lkw == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                        return true;
                    }
                }
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
            super.doUpdateVisitedHistory(webView, str, z);
            String url = webView.getUrl();
            if (this.llO.lkd) {
                this.llO.h(url, false, -1);
            }
            if (!(this.llO.lkw == null || this.llO.lkw.has(url))) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
                this.llO.h(url, false, -1);
                this.llO.z(true, false);
                this.llO.llj = true;
            }
            this.llO.llx.bjU();
            this.llO.llI = str;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + str);
            com.tencent.mm.plugin.report.service.g.iuh.a(155, 0, 1, false);
            if (com.tencent.mm.sdk.b.b.bsI() && "http://www.dktest-mmcrash.com/".equals(str)) {
                Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
            }
            if (com.tencent.mm.sdk.b.b.bsI() && "http://www.jiamintest-recovery.com/".equals(str)) {
                com.tencent.mm.bc.b.JG("com.tencent.mm:tools");
            }
            this.llO.lfi = this.llO.llI;
            this.llO.f(str, be.Nh(), 1);
            this.llO.ldG.biv().lfi = this.llO.lfi;
            this.llO.llI = str;
            g gVar = g.pRr;
            String str2 = gVar.pRs;
            gVar.pRs = str;
            if (!be.kS(gVar.juo)) {
                gVar.e(1, str2, 0);
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[]{this.llO.lfi, this.llO.llI});
            if (this.llO.Fo(str)) {
                this.llO.llx.bjU();
                this.llO.llx.Fb(str);
                if (this.llO.Fj(str)) {
                    this.llO.llH = str;
                    return;
                }
                this.llO.lkH.blm();
                this.llO.setProgressBarIndeterminateVisibility(false);
                if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.llO.liH, this.llO.hashCode())) {
                    this.llO.lkX = true;
                    this.llO.ljR.finish();
                    this.llO.igd.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (this.llO.lkl != null) {
                        this.llO.lkl.Fw((String) this.llO.llk.get(str));
                    }
                } else {
                    this.llO.lkX = false;
                    this.llO.ljR.start();
                }
                if (w.NO_NEED.equals(this.llO.h(str, false, -1))) {
                    this.llO.llq.Ez(str);
                }
                this.llO.z(true, false);
                this.llO.llj = false;
                com.tencent.mm.plugin.webview.d.ai.k bit = this.llO.ldG.bit();
                int w = this.llO.bsZ;
                String i = this.llO.bnX;
                bit.bsZ = w;
                bit.leY = i;
                if (be.kS(str)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                } else if (!bit.lfm.containsKey(str)) {
                    bit.lfm.put(str, Long.valueOf(be.Ni()));
                }
                this.llO.llg = 0;
                return;
            }
            com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + str);
            this.llO.bkf();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.llO.lkV) {
                this.llO.lkV = true;
                this.llO.ldG.bix().leQ = true;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[]{str});
            com.tencent.mm.plugin.webview.d.ai.b biC = this.llO.ldG.biC();
            if (biC.leS && !biC.leT) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("http")) {
                        String host = parse.getHost();
                        if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(283, 0, 1, true);
                            biC.leT = true;
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[]{str});
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[]{str});
                }
            }
            g gVar = g.pRr;
            if (!be.kS(gVar.juo)) {
                gVar.kZ(2);
            }
            if (this.llO.igd == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
                return;
            }
            this.llO.llq.Ez(str);
            String title = this.llO.igd.getTitle();
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[]{this.llO.bzY(), title, Boolean.valueOf(this.llO.ljQ), Boolean.valueOf(this.llO.jLZ), this.llO.llI});
            if (!(this.llO.igd.getX5WebViewExtension() != null || title == null || title.equals(this.llO.bzY()) || title.startsWith("http") || ((this.llO.llI != null && this.llO.llI.equals(title)) || this.llO.ljQ || !this.llO.jLZ))) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                this.llO.Fd(title);
            }
            this.llO.llx.Fb(this.llO.bkc());
            boolean booleanExtra = this.llO.getIntent().getBooleanExtra("shouldForceViewPort", false);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + booleanExtra);
            if (booleanExtra) {
                webView.evaluateJavascript(this.llO.getIntent().getStringExtra("view_port_code"), null);
            }
            this.llO.bku();
            if (this.llO.Fo(str)) {
                this.llO.setProgressBarIndeterminateVisibility(false);
                this.llO.ljR.finish();
                this.llO.llH = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                    return;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + this.llO.lli);
                com.tencent.mm.pluginsdk.ui.tools.s.c(this.llO.igd);
                this.llO.lkH.bln();
                if (!(this.llO.lkw == null || this.llO.lkw.EZ(str) == null)) {
                    this.llO.A(this.llO.lkw.EZ(str).uC(34), this.llO.lkw.EZ(str).uC(75));
                }
                this.llO.hA(false);
                com.tencent.mm.plugin.webview.d.ai.k bit = this.llO.ldG.bit();
                if (be.kS(str)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                } else if (bit.lfm.containsKey(str)) {
                    bit.lfm.put(str, Long.valueOf(be.Ni() - ((Long) bit.lfm.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.d.ai.d biu = this.llO.ldG.biu();
                if (be.kS(str)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                } else if (biu.leW.containsKey(str)) {
                    biu.leW.put(str, Long.valueOf(be.Ni() - ((Long) biu.leW.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.d.ai.e biw = this.llO.ldG.biw();
                com.tencent.mm.plugin.webview.stub.d dVar = this.llO.liH;
                if (!(dVar == null || biw.eyP)) {
                    biw.eyP = true;
                    int bip = ai.bip();
                    long Ni = be.Ni() - biw.startTime;
                    if (Ni >= 0 && Ni <= 180000) {
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Long.valueOf(Ni);
                        objArr[2] = Integer.valueOf(bip);
                        objArr[3] = biw.url == null ? biw.url : biw.url.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.leO);
                        objArr[8] = Integer.valueOf(ai.leP);
                        objArr[9] = Integer.valueOf(biw.bsZ);
                        objArr[10] = biw.leY;
                        d.a(dVar, 11215, objArr);
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{biw.url, Long.valueOf(Ni), Integer.valueOf(bip), Integer.valueOf(ai.leO), Integer.valueOf(ai.leP), Integer.valueOf(biw.bsZ), biw.leY});
                    }
                }
                if (!this.llO.lkL.containsKey(str)) {
                    this.llO.lkL.put(str, Boolean.valueOf(this.llO.bzX()));
                }
                this.llO.hz(((Boolean) this.llO.lkL.get(str)).booleanValue());
                Boolean bool = (Boolean) this.llO.lkO.get(str);
                if (bool == null || !bool.booleanValue()) {
                    this.llO.V(0, true);
                } else {
                    this.llO.V(0, false);
                }
                this.llO.dPP = be.Nh();
                return;
            }
            com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + str);
            this.llO.bkf();
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String E = webView.getUrl() == null ? this.llO.llI : webView.getUrl();
            com.tencent.mm.plugin.report.service.g.iuh.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.a(155, 30, 1, false);
            if (this.llO.lkF == null) {
                this.llO.lkF = new b(this.llO, this.llO.igd, this.llO.liH);
            }
            b aH = this.llO.lkF;
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", new Object[]{E});
            if (aH.liG == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
            } else if (be.kS(E)) {
                sslErrorHandler.cancel();
            } else {
                try {
                    URL url = new URL(E);
                    if (url.getHost().endsWith(".qq.com") || url.getHost().endsWith(".linkedin.com")) {
                        Boolean bool = (Boolean) aH.liJ.get(E);
                        if (bool != null) {
                            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", new Object[]{bool});
                            if (bool.booleanValue()) {
                                sslErrorHandler.proceed();
                                return;
                            } else {
                                sslErrorHandler.cancel();
                                return;
                            }
                        }
                        List list = (List) aH.liI.get(E);
                        if (list == null || list.size() == 0) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("1");
                            stringBuilder.append(",");
                            stringBuilder.append(aH.a(E, sslError));
                            String stringBuilder2 = stringBuilder.toString();
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", new Object[]{stringBuilder2});
                            d.a(aH.liH, 11098, stringBuilder2);
                            list = new ArrayList();
                            list.add(sslErrorHandler);
                            aH.liI.put(E, list);
                            com.tencent.mm.ui.base.g.a(aH.context, false, aH.context.getString(2131236657, new Object[]{url.getHost()}), aH.context.getString(2131236658), aH.context.getString(2131231014), aH.context.getString(2131230906), new com.tencent.mm.plugin.webview.ui.tools.b.AnonymousClass1(aH, E), new com.tencent.mm.plugin.webview.ui.tools.b.AnonymousClass2(aH, E));
                            return;
                        }
                        list.add(sslErrorHandler);
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com' or '.linkedin.com'");
                    sslErrorHandler.cancel();
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e.getLocalizedMessage());
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            boolean isConnected = ak.isConnected(this.llO);
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected)});
            com.tencent.mm.plugin.report.service.g.iuh.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.iuh.a(155, (long) a.sS(i), 1, false);
            super.onReceivedError(webView, i, str, str2);
            g.pRr.zT(i);
            if (this.llO.lki) {
                this.llO.finish();
            }
        }

        public void onLoadResource(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + str);
            if (this.llO.Fo(str) || this.llO.bkx()) {
                com.tencent.mm.plugin.webview.d.ai.d biu = this.llO.ldG.biu();
                if (be.kS(str)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                } else if (!(be.kS(biu.ldY) || str.equals(biu.ldY) || !biu.leX)) {
                    if (biu.leV.containsKey(biu.ldY)) {
                        biu.leV.put(biu.ldY, Long.valueOf(be.Ni() - ((Long) biu.leV.get(biu.ldY)).longValue()));
                    }
                    biu.leX = false;
                }
                super.onLoadResource(webView, str);
                return;
            }
            com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + str);
            super.onLoadResource(webView, str);
            this.llO.bkf();
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[]{str});
            String bkc = this.llO.bkc();
            af o = this.llO.lls;
            if (this.llO.lkW) {
                z = false;
            }
            WebResourceResponse a = o.a(bkc, str, z, this.llO.liH, this.llO.hashCode());
            if (a == null) {
                return null;
            }
            dd(bkc, str);
            return a;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || be.kS(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            String bkc = this.llO.bkc();
            String uri = webResourceRequest.getUrl().toString();
            af o = this.llO.lls;
            if (this.llO.lkW) {
                z = false;
            }
            WebResourceResponse a = o.a(bkc, uri, z, this.llO.liH, this.llO.hashCode());
            if (a == null) {
                return null;
            }
            dd(bkc, uri);
            return a;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || be.kS(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            if (WebView.getTbsCoreVersion(this.llO) > 36541) {
                try {
                    int i = bundle.getInt("resourceType");
                    if (i == 1 || i == 7) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                        this.llO.h(webResourceRequest.getUrl().toString(), false, 5);
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
                } catch (Throwable th) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
                }
            }
            String bkc = this.llO.bkc();
            String uri = webResourceRequest.getUrl().toString();
            af o = this.llO.lls;
            if (this.llO.lkW) {
                z = false;
            }
            WebResourceResponse a = o.a(bkc, uri, z, this.llO.liH, this.llO.hashCode());
            if (a == null) {
                return null;
            }
            dd(bkc, uri);
            return a;
        }

        private void dd(String str, String str2) {
            if (str2.equals(str) || this.llO.dc(str, str2)) {
                this.llO.handler.post(new Runnable(this) {
                    final /* synthetic */ i lna;

                    {
                        this.lna = r1;
                    }

                    public final void run() {
                        if (this.lna.llO.igd != null) {
                            this.lna.llO.igd.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        }
                        WebViewUI webViewUI = this.lna.llO;
                        Runnable anonymousClass53 = new Runnable(webViewUI) {
                            final /* synthetic */ WebViewUI llO;

                            {
                                this.llO = r1;
                            }

                            public final void run() {
                                if (this.llO.ljR != null) {
                                    this.llO.ljR.finish();
                                }
                            }
                        };
                        if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                            anonymousClass53.run();
                        } else {
                            webViewUI.handler.post(anonymousClass53);
                        }
                    }
                });
            }
        }
    }

    private static class m {
        private static final Pattern hDe = Pattern.compile(".*#.*wechat_redirect");
        private String let = null;

        public m(String str) {
            this.let = str;
        }

        public final int Ft(String str) {
            if (be.kS(str)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.let)) {
                return 0;
            } else {
                if (hDe.matcher(str).find()) {
                    return 2;
                }
                return 1;
            }
        }
    }

    protected class n {
        final /* synthetic */ WebViewUI llO;
        int lnc = 0;

        protected n(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final void bkL() {
            if (this.lnc == 0) {
                this.llO.ta(233);
            }
            this.lnc++;
        }

        public final void bkM() {
            this.lnc--;
            if (this.lnc <= 0) {
                this.llO.tb(233);
            }
        }
    }

    protected class p {
        final /* synthetic */ WebViewUI llO;
        int lnd = 0;

        protected p(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }
    }

    protected class r {
        final /* synthetic */ WebViewUI llO;
        int lne = 0;

        protected r(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }
    }

    enum w {
        NO_NEED,
        WILL_GET,
        FAILED
    }

    private class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private a(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://jump/");
        }

        public final boolean Fj(String str) {
            if (this.llO.lkw.bjT().bry()) {
                try {
                    this.llO.liH.ax(str, this.llO.lkw.bjS().uC(7));
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
                }
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
            }
            return true;
        }
    }

    private class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;
        public final String lmQ;

        private b(WebViewUI webViewUI) {
            this.llO = webViewUI;
            this.lmQ = "weixin://addfriend/";
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://addfriend/");
        }

        public final boolean Fj(String str) {
            if (this.llO.lkw.bjS().uC(5)) {
                String substring = str.substring(19);
                if (be.kS(substring)) {
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_webview", true);
                bundle.putString("userName", substring);
                try {
                    this.llO.liH.a(8, bundle, this.llO.hashCode());
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                    return true;
                }
            }
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
            return true;
        }
    }

    private class d implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private d(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://webview/close/");
        }

        public final boolean Fj(String str) {
            if (this.llO.lkw.bjS().uC(17)) {
                this.llO.finish();
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "close window permission fail");
            }
            return true;
        }
    }

    private class f implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;
        private final String lmZ;

        private f(WebViewUI webViewUI) {
            this.llO = webViewUI;
            this.lmZ = "weixin://webview/copy/";
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://webview/copy/");
        }

        public final boolean Fj(String str) {
            CharSequence substring = str.substring(22);
            com.tencent.mm.pluginsdk.j.c.a(this.llO, substring, substring);
            return true;
        }
    }

    private class g implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private g(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://critical_update/");
        }

        public final boolean Fj(String str) {
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 25, 1, true);
            WebViewUI.e(this.llO, 1);
            return true;
        }
    }

    private class h implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private h(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://");
        }

        public final boolean Fj(String str) {
            int a = this.llO.Fl(be.ma(this.llO.lkU));
            if (!com.tencent.mm.pluginsdk.d.E(str, this.llO.llL)) {
                return false;
            }
            try {
                if ("weixin://dl/shopping".equals(str)) {
                    String bjx = this.llO.liH.bjx();
                    if (!be.kS(bjx)) {
                        this.llO.igd.loadUrl(bjx);
                    }
                } else if ("weixin://dl/faq".equals(str)) {
                    int uQ = this.llO.liH.uQ();
                    int bjz = this.llO.liH.bjz();
                    this.llO.igd.loadUrl(com.tencent.mm.sdk.platformtools.aa.getContext().getString(2131235163, new Object[]{Integer.valueOf(uQ), Integer.valueOf(bjz)}));
                } else if ("weixin://dl/posts".equals(str)) {
                    this.llO.liH.bjA();
                } else if ("weixin://dl/moments".equals(str)) {
                    this.llO.liH.bjB();
                } else if (str.startsWith("weixin://dl/feedback")) {
                    this.llO.liH.EO(str);
                } else if ("weixin://dl/scan".equals(str)) {
                    com.tencent.mm.ay.c.a(this.llO, "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                } else {
                    com.tencent.mm.pluginsdk.d.Ge(str);
                }
                List arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add("1");
                arrayList.add(String.valueOf(a));
                arrayList.add(be.ma(this.llO.lkU));
                arrayList.add(be.ma(this.llO.bpX));
                this.llO.liH.g(11405, arrayList);
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", new Object[]{e.getMessage()});
                return true;
            }
        }
    }

    private class j implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;
        private final String lnb;

        private j(WebViewUI webViewUI) {
            this.llO = webViewUI;
            this.lnb = "weixin://feedback/";
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://feedback/");
        }

        public final boolean Fj(String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("MMActivity.OverrideEnterAnimation", 0);
            bundle.putInt("MMActivity.OverrideExitAnimation", 2130968644);
            try {
                this.llO.liH.a(7, bundle, this.llO.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            return true;
        }
    }

    private class k implements com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a {
        final /* synthetic */ WebViewUI llO;

        private k(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final void pi(int i) {
            int i2 = 2;
            switch (i) {
                case 0:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
            }
            this.llO.te(i2);
            try {
                if (this.llO.liH.bjs()) {
                    this.llO.liH.cO(16384, i2);
                    this.llO.liH.cO(16388, i2);
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
            }
        }
    }

    private class l implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private l(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://connectToFreeWifi/");
        }

        public final boolean Fj(String str) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[]{queryParameter});
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!be.kS(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!be.kS(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.ay.c.b(com.tencent.mm.sdk.platformtools.aa.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            return true;
        }
    }

    private class o implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private o(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://gethtml/");
        }

        public final boolean Fj(String str) {
            if (!be.kS(str)) {
                String substring = str.substring(17);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + substring);
                WebViewUI.j(this.llO, substring);
            }
            return false;
        }
    }

    private class q implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private q(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://profile/");
        }

        public final boolean Fj(String str) {
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
            } else if (!(this.llO.lkw == null || this.llO.lkw.bjS() == null || !this.llO.lkw.bjS().uC(2))) {
                this.llO.lkl.Fv(substring);
            }
            return true;
        }
    }

    private class s implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private s(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://manual_update/");
        }

        public final boolean Fj(String str) {
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 26, 1, true);
            WebViewUI.e(this.llO, 3);
            return true;
        }
    }

    private class t implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private t(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://readershare/");
        }

        public final boolean Fj(String str) {
            com.tencent.mm.ui.base.g.a(this.llO, "", new String[]{this.llO.getString(2131234321)}, "", new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ t lnf;

                {
                    this.lnf = r1;
                }

                public final void gT(int i) {
                    if (i == 0) {
                        t tVar = this.lnf;
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("shortUrl", tVar.llO.getIntent().getStringExtra("shortUrl"));
                            bundle.putInt(Columns.TYPE, tVar.llO.getIntent().getIntExtra(Columns.TYPE, 0));
                            tVar.llO.liH.a(4, bundle, tVar.hashCode());
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                        }
                    }
                }
            });
            return true;
        }
    }

    private class u implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private u(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://recommend_update/");
        }

        public final boolean Fj(String str) {
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 24, 1, true);
            WebViewUI.e(this.llO, 2);
            return true;
        }
    }

    private class v implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;
        private final String lmZ;

        private v(WebViewUI webViewUI) {
            this.llO = webViewUI;
            this.lmZ = "weixin://openapi/openwebview/result?";
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://openapi/openwebview/result?");
        }

        public final boolean Fj(String str) {
            com.tencent.mm.sdk.f.e.a aVar = new com.tencent.mm.sdk.f.e.a();
            Uri parse = Uri.parse(str);
            aVar.bfz = parse.getQuery();
            aVar.errCode = be.getInt(parse.getQueryParameter("errCode"), 0);
            aVar.egi = parse.getQueryParameter("errMsg");
            aVar.lBj = this.llO.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (be.kS(queryParameter)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
            } else {
                Bundle bundle = new Bundle();
                aVar.t(bundle);
                com.tencent.mm.pluginsdk.model.app.p.R(bundle);
                com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
                try {
                    aVar2.nhj = this.llO.liH.EG(queryParameter);
                    aVar2.nhl = bundle;
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[]{aVar2});
                    com.tencent.mm.sdk.a.a.a(this.llO, aVar2);
                    this.llO.finish();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    }

    private class x implements IUtils {
        final /* synthetic */ WebViewUI llO;

        private x(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final void javaUtilLog(int i, String str, String str2) {
            switch (i) {
                case 2:
                    com.tencent.mm.sdk.platformtools.v.v(str, str2);
                    return;
                case 3:
                    com.tencent.mm.sdk.platformtools.v.d(str, str2);
                    return;
                case 4:
                    com.tencent.mm.sdk.platformtools.v.i(str, str2);
                    return;
                case 5:
                    com.tencent.mm.sdk.platformtools.v.w(str, str2);
                    return;
                case 6:
                    com.tencent.mm.sdk.platformtools.v.e(str, str2);
                    return;
                default:
                    return;
            }
        }

        public final void httpproxyReport(String... strArr) {
            com.tencent.mm.plugin.webview.d.ai.h biA = this.llO.ldG.biA();
            if (!(strArr == null || strArr.length == 0)) {
                if (biA.lfa == null) {
                    biA.lfa = new ArrayList();
                } else {
                    biA.lfa.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[]{strArr[r0]});
                    biA.lfa.add(add);
                }
            }
            com.tencent.mm.plugin.webview.d.ai.h biA2 = this.llO.ldG.biA();
            com.tencent.mm.plugin.webview.stub.d dVar = this.llO.liH;
            if (biA2.lfa != null && biA2.lfa.size() != 0 && dVar != null) {
                d.a(dVar, 12033, biA2.lfa);
                biA2.lfa.clear();
            }
        }

        public final void idKeyReport(String str, String str2, String str3) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", new Object[]{str, str2, str3});
            if (!be.kS(str) && !be.kS(str2) && !be.kS(str3)) {
                com.tencent.mm.plugin.report.service.g.iuh.a((long) be.getInt(str, 0), (long) be.getInt(str2, 0), (long) be.getInt(str3, 0), false);
            }
        }

        public final void kvReport(String... strArr) {
            com.tencent.mm.plugin.webview.d.ai.g biB = this.llO.ldG.biB();
            if (!(strArr == null || strArr.length == 0)) {
                if (biB.lfa == null) {
                    biB.lfa = new ArrayList();
                } else {
                    biB.lfa.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[]{strArr[r0]});
                    biB.lfa.add(add);
                }
            }
            com.tencent.mm.plugin.webview.d.ai.g biB2 = this.llO.ldG.biB();
            com.tencent.mm.plugin.webview.stub.d dVar = this.llO.liH;
            if (biB2.lfa != null && biB2.lfa.size() != 0 && dVar != null) {
                d.a(dVar, 12666, biB2.lfa);
                biB2.lfa.clear();
            }
        }
    }

    private class y implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private y(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://private/gethtml/");
        }

        public final boolean Fj(String str) {
            try {
                String decode = URLDecoder.decode(str.substring(25));
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", this.llO.ldY);
                bundle.putString("tweetid", be.ma(this.llO.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt(Columns.TYPE, this.llO.getIntent().getIntExtra(Columns.TYPE, 0));
                this.llO.liH.a(3, bundle, this.llO.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    private class z implements com.tencent.mm.plugin.webview.ui.tools.jsapi.d {
        final /* synthetic */ WebViewUI llO;

        private z(WebViewUI webViewUI) {
            this.llO = webViewUI;
        }

        public final boolean Fs(String str) {
            if (be.kS(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.ds(str, "weixin://viewimage/");
        }

        public final boolean Fj(String str) {
            try {
                if (this.llO.liH.isSDCardAvailable()) {
                    this.llO.ldY = str.substring(19);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + this.llO.ldY);
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.llO.igd, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", this.llO.lkj);
                    return true;
                }
                this.llO.liH.a(2, null, this.llO.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    static /* synthetic */ void C(WebViewUI webViewUI) {
        String str = null;
        String url = webViewUI.igd.getUrl();
        final ArrayList arrayList = webViewUI.lkN.containsKey(url) ? (ArrayList) webViewUI.lkN.get(url) : null;
        boolean z = arrayList != null && arrayList.size() > 0;
        final Boolean valueOf = Boolean.valueOf(z);
        com.tencent.mm.ui.widget.f fVar = valueOf.booleanValue() ? new com.tencent.mm.ui.widget.f(webViewUI.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false) : new com.tencent.mm.ui.widget.f(webViewUI.nDR.nEl, com.tencent.mm.ui.widget.f.pbR, true);
        fVar.jXo = new com.tencent.mm.ui.base.n.d(webViewUI) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                String stringExtra;
                Throwable e;
                boolean z;
                boolean z2 = false;
                if (WebViewUI.g(menuItem)) {
                    com.tencent.mm.h.d.b bVar = (com.tencent.mm.h.d.b) menuItem.getMenuInfo();
                    if (bVar != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llO.lkl;
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                        Map hashMap = new HashMap();
                        hashMap.put("key", bVar.apU);
                        hashMap.put("title", bVar.title);
                        fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:custom", hashMap, fVar.loD, fVar.loE) + ")", null);
                        return;
                    }
                    return;
                }
                String stringExtra2;
                String stringExtra3;
                com.tencent.mm.plugin.webview.d.ai.c biz;
                com.tencent.mm.plugin.webview.d.ai.c biz2;
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 1:
                        stringExtra2 = this.llO.getIntent().getStringExtra("KPublisherId");
                        stringExtra3 = this.llO.getIntent().getStringExtra("KAppId");
                        stringExtra = this.llO.getIntent().getStringExtra("srcUsername");
                        biz = this.llO.ldG.biz();
                        biz.leU = new Object[]{this.llO.bpX, Integer.valueOf(1), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                        biz.a(this.llO.liH);
                        this.llO.lkc = this.llO.lkw.bjT().brA();
                        WebViewUI webViewUI = this.llO;
                        webViewUI.lkl.ay("sendAppMessage", true);
                        webViewUI.lkl.blg();
                        return;
                    case 2:
                        int intValue;
                        stringExtra2 = this.llO.getIntent().getStringExtra("KPublisherId");
                        stringExtra3 = this.llO.getIntent().getStringExtra("KAppId");
                        stringExtra = this.llO.getIntent().getStringExtra("srcUsername");
                        biz = this.llO.ldG.biz();
                        biz.leU = new Object[]{this.llO.bpX, Integer.valueOf(2), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                        biz.a(this.llO.liH);
                        this.llO.lkc = this.llO.lkw.bjT().brA();
                        if (this.llO.lkP.containsKey(this.llO.igd.getUrl())) {
                            intValue = ((Integer) this.llO.lkP.get(this.llO.igd.getUrl())).intValue();
                        } else {
                            intValue = 0;
                        }
                        WebViewUI webViewUI2 = this.llO;
                        webViewUI2.lkl.ay(bk.NAME, true);
                        fVar = webViewUI2.lkl;
                        if (fVar.loB) {
                            try {
                                fVar.liH.w("urlAttribute", String.valueOf(intValue), fVar.lhu);
                            } catch (Throwable e2) {
                                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                            }
                            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:timeline", new HashMap(), fVar.loD, fVar.loE) + ")", null);
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
                        return;
                    case 3:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(3), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        com.tencent.mm.plugin.report.service.g.iuh.a(157, 6, 1, false);
                        this.llO.lkc = this.llO.lkw.bjT().brA();
                        Activity activity = this.llO;
                        Bundle bundle = new Bundle();
                        bundle.putLong("msg_id", activity.getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
                        bundle.putString("sns_local_id", activity.getIntent().getStringExtra("sns_local_id"));
                        bundle.putInt("news_svr_id", activity.getIntent().getIntExtra("news_svr_id", 0));
                        bundle.putString("news_svr_tweetid", activity.getIntent().getStringExtra("news_svr_tweetid"));
                        bundle.putInt("message_index", activity.getIntent().getIntExtra("message_index", 0));
                        bundle.putString("rawUrl", activity.bpX);
                        Intent intent2 = activity.getIntent();
                        if (intent2 != null) {
                            bundle.putString("preChatName", intent2.getStringExtra("preChatName"));
                            bundle.putInt("preMsgIndex", intent2.getIntExtra("preMsgIndex", 0));
                            bundle.putString("prePublishId", intent2.getStringExtra("prePublishId"));
                            bundle.putString("preUsername", intent2.getStringExtra("preUsername"));
                        }
                        try {
                            com.tencent.mm.plugin.webview.stub.b F = activity.liH.F(bundle);
                            if (F.bjl()) {
                                activity.lkl.ay("sendAppMessage", false);
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar2 = activity.lkl;
                                if (fVar2.loB) {
                                    Map hashMap2 = new HashMap();
                                    hashMap2.put("scene", "favorite");
                                    fVar2.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:appmessage", hashMap2, fVar2.loD, fVar2.loE) + ")", null);
                                    try {
                                        fVar2.liH.w("scene", "favorite", fVar2.lhu);
                                    } catch (Exception e3) {
                                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e3.getMessage());
                                    }
                                } else {
                                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onFavorite fail, not ready");
                                }
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "on favorite simple url");
                                return;
                            }
                            com.tencent.mm.pluginsdk.model.c.a(F.getRet(), 35, activity);
                            if (F.getRet() == 0) {
                                activity.tc(1);
                                return;
                            } else {
                                activity.tc(2);
                                return;
                            }
                        } catch (Exception e32) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "edw, favoriteUrl fail, ex = " + e32.getMessage());
                            return;
                        }
                    case 5:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(4), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        stringExtra2 = (String) this.llO.lkM.get(this.llO.igd.getUrl());
                        if (stringExtra2 == null) {
                            stringExtra2 = this.llO.getIntent().getStringExtra("srcUsername");
                        }
                        WebViewUI.h(this.llO, "Contact_Scene");
                        WebViewUI.i(this.llO, stringExtra2);
                        return;
                    case 6:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(5), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.Z(this.llO);
                        return;
                    case 7:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(13), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.aa(this.llO);
                        return;
                    case 8:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(15), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.ab(this.llO);
                        return;
                    case 9:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(7), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        com.tencent.mm.ui.base.g.a(this.llO.nDR.nEl, this.llO.nDR.nEl.getString(2131231021), null, null, this.llO.nDR.nEl.getString(2131231020), new com.tencent.mm.ui.base.g.d(this.llO) {
                            final /* synthetic */ WebViewUI llO;

                            {
                                this.llO = r1;
                            }

                            public final void bw(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("fav_local_id", this.llO.getIntent().getLongExtra("fav_local_id", -1));
                                        try {
                                            if (this.llO.liH.I(bundle)) {
                                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
                                                this.llO.finish();
                                                return;
                                            }
                                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "try to del web url fail");
                                            return;
                                        } catch (Throwable e) {
                                            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
                                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "try to del web url crash");
                                            return;
                                        }
                                    default:
                                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 10:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(11), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        if (ak.isWifi(this.llO)) {
                            com.tencent.mm.pluginsdk.ui.tools.s.a(this.llO.igd, "weixin://gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", this.llO.lkj);
                            return;
                        } else {
                            WebViewUI.j(this.llO, null);
                            return;
                        }
                    case 11:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(8), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        if (this.llO.ljU.getVisibility() == 8) {
                            this.llO.ljU.startAnimation(AnimationUtils.loadAnimation(this.llO, 2130968625));
                            this.llO.ljU.setVisibility(0);
                            return;
                        }
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.llO, 2130968626);
                        loadAnimation.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ AnonymousClass28 lmG;

                            {
                                this.lmG = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.lmG.llO.ljU.setVisibility(8);
                            }
                        });
                        this.llO.ljU.startAnimation(loadAnimation);
                        this.llO.ljU.setVisibility(8);
                        return;
                    case 12:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(6), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", this.llO.getIntent().getLongExtra("fav_local_id", -1));
                        com.tencent.mm.ay.c.b(this.llO.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent);
                        return;
                    case an.CTRL_INDEX /*14*/:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(9), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        if (this.llO.lkJ) {
                            WebViewUI.k(this.llO, this.llO.lkK);
                            return;
                        } else {
                            WebViewUI.a(this.llO, this.llO.igd.getUrl(), this.llO.igd.getSettings().getUserAgentString(), this.llO.width, this.llO.height);
                            return;
                        }
                    case am.CTRL_INDEX /*15*/:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(19), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.a(this.llO, menuItem);
                        return;
                    case 16:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(21), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.a(this.llO, menuItem);
                        return;
                    case 17:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(20), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.a(this.llO, menuItem);
                        return;
                    case 18:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(22), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.a(this.llO, menuItem);
                        return;
                    case 19:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(23), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.a(this.llO, menuItem);
                        return;
                    case 20:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(17), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.ak(this.llO);
                        return;
                    case 21:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(18), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.al(this.llO);
                        return;
                    case bf.CTRL_INDEX /*22*/:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(24), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.am(this.llO);
                        return;
                    case 23:
                        intent = new Intent();
                        stringExtra3 = this.llO.getIntent().getStringExtra("sns_local_id");
                        if (stringExtra3 != null) {
                            intent.putExtra("sns_send_data_ui_activity", true);
                            intent.putExtra("sns_local_id", stringExtra3);
                        } else {
                            intent.putExtra("Retr_Msg_Id", Long.valueOf(this.llO.getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                        }
                        com.tencent.mm.ay.c.a(this.llO.nDR.nEl, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    case 24:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(16), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.an(this.llO);
                        return;
                    case 25:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(26), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.ai(this.llO);
                        return;
                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(27), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        WebViewUI.aj(this.llO);
                        return;
                    case bv.CTRL_INDEX /*27*/:
                        this.llO.finish();
                        return;
                    default:
                        biz2 = this.llO.ldG.biz();
                        biz2.leU = new Object[]{this.llO.bpX, Integer.valueOf(16), Integer.valueOf(1)};
                        biz2.a(this.llO.liH);
                        stringExtra = menuItem.getTitle();
                        if (!be.kS(stringExtra)) {
                            try {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("data", stringExtra);
                                bundle2 = this.llO.liH.i(50, bundle2);
                                if (bundle2 != null) {
                                    boolean z3 = bundle2.getInt("key_biz_type") == 2;
                                    try {
                                        if (bundle2.getInt("key_biz_type") == 3) {
                                            z2 = true;
                                        }
                                    } catch (RemoteException e4) {
                                        e2 = e4;
                                        z = z3;
                                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                        z2 = z;
                                        if (z2) {
                                            WebViewUI.m(this.llO, stringExtra);
                                            return;
                                        } else {
                                            this.llO.Fh(stringExtra);
                                            return;
                                        }
                                    }
                                }
                            } catch (RemoteException e5) {
                                e2 = e5;
                                z = false;
                                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                z2 = z;
                                if (z2) {
                                    this.llO.Fh(stringExtra);
                                    return;
                                } else {
                                    WebViewUI.m(this.llO, stringExtra);
                                    return;
                                }
                            }
                            if (z2) {
                                this.llO.Fh(stringExtra);
                                return;
                            } else {
                                WebViewUI.m(this.llO, stringExtra);
                                return;
                            }
                        }
                        return;
                }
            }
        };
        fVar.jXn = new com.tencent.mm.ui.base.n.c(webViewUI) {
            final /* synthetic */ WebViewUI llO;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                boolean z = false;
                int size;
                if (valueOf.booleanValue()) {
                    size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        com.tencent.mm.h.d.b bVar = (com.tencent.mm.h.d.b) arrayList.get(i);
                        com.tencent.mm.ui.base.m mVar = (com.tencent.mm.ui.base.m) lVar.d(bVar.id, bVar.title);
                        mVar.nWJ = bVar;
                        mVar.setIcon(null);
                        mVar.setIcon(0);
                    }
                    return;
                }
                boolean eD;
                try {
                    LinkedList ao = this.llO.bko();
                    if (ao != null) {
                        size = 0;
                        while (size < ao.size() && size < 8) {
                            com.tencent.mm.h.d.a aVar = (com.tencent.mm.h.d.a) ao.get(size);
                            mVar = null;
                            if ("index".equals(be.ma(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(15, this.llO.getString(2131236600), 2131165331);
                            } else if ("categories".equals(be.ma(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(16, this.llO.getString(2131236599), 2131165330);
                            } else if ("cart".equals(be.ma(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(17, this.llO.getString(2131236598), 2131165329);
                            } else if ("profile".equals(be.ma(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(18, this.llO.getString(2131236602), 2131165337);
                            } else if ("member".equals(be.ma(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(19, this.llO.getString(2131236601), 2131165332);
                            }
                            if (mVar != null) {
                                mVar.guw = aVar.url;
                            }
                            size++;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "exception in add jd menu, " + e.getMessage());
                }
                JsapiPermissionWrapper bjS = this.llO.lkw.bjS();
                if (bjS.uC(21) && WebViewUI.d(this.llO, 1)) {
                    lVar.a(1, this.llO.getString(2131234310), 2131165344);
                }
                if (bjS.uC(23) && WebViewUI.d(this.llO, 2)) {
                    lVar.a(2, this.llO.getString(2131234311), 2131165334);
                }
                if (!this.llO.lkf && this.llO.bkn() && WebViewUI.d(this.llO, 3)) {
                    lVar.a(3, this.llO.getString(2131234180), 2131165326);
                }
                try {
                    if (this.llO.liH.l(this.llO.getIntent().getLongExtra("msg_id", Long.MIN_VALUE), this.llO.getIntent().getStringExtra("sns_local_id"))) {
                        lVar.a(23, this.llO.getString(2131232303), 2131165336);
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e2, "", new Object[0]);
                }
                if (bjS.uC(44) && WebViewUI.d(this.llO, 6)) {
                    lVar.a(6, this.llO.getString(2131236659), 2131165318);
                }
                if (bjS.lWx != null && this.llO.lkf && this.llO.getIntent().getBooleanExtra("key_detail_can_delete", true) && this.llO.bkn()) {
                    if (WebViewUI.d(this.llO, 12)) {
                        lVar.a(12, this.llO.getString(2131232639), 2131165313);
                    }
                    if (WebViewUI.d(this.llO, 9)) {
                        lVar.a(9, this.llO.getString(2131231020), 2131165320);
                    }
                }
                String stringExtra = this.llO.getIntent().getStringExtra("srcUsername");
                if (!be.kS(stringExtra)) {
                    try {
                        eD = this.llO.liH.eD(stringExtra);
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                        eD = false;
                    }
                    if (eD) {
                        boolean eC;
                        try {
                            eC = this.llO.liH.eC(stringExtra);
                        } catch (Exception e32) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "sharebtn click fail, ex = " + e32.getMessage());
                            eC = false;
                        }
                        if (eC) {
                            eD = bjS.uC(19);
                        } else {
                            eD = bjS.uC(20);
                        }
                        boolean ar = this.llO.bkp();
                        if ((eD && WebViewUI.d(this.llO, 5)) || ar) {
                            int i2 = eC ? 2131236670 : 2131236661;
                            if (ar) {
                                i2 = 2131236671;
                            }
                            lVar.a(5, this.llO.getString(i2), 2131165315);
                        }
                    } else {
                        try {
                            this.llO.liH.EJ(stringExtra);
                        } catch (Exception e322) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "sharebtn click fail triggerGetContact, ex = " + e322.getMessage());
                        }
                    }
                }
                if (bjS.uC(45) && WebViewUI.d(this.llO, 7)) {
                    lVar.a(7, this.llO.getString(2131236664), 2131165316);
                }
                if (bjS.uC(43) && WebViewUI.d(this.llO, 24)) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_action", "enterprise_has_connector");
                        bundle = this.llO.liH.i(71, bundle);
                        if (bundle != null) {
                            eD = bundle.getBoolean("enterprise_has_connector");
                            if (eD) {
                                lVar.a(24, this.llO.getString(2131234318), 2131165323);
                            }
                        }
                    } catch (Exception e3222) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "builder add, ex = " + e3222.getMessage());
                    }
                    eD = false;
                    if (eD) {
                        lVar.a(24, this.llO.getString(2131234318), 2131165323);
                    }
                }
                if (bjS.uC(18) && WebViewUI.d(this.llO, 11)) {
                    lVar.a(11, this.llO.getString(2131234309), 2131165327);
                }
                if (bjS.uC(73) && WebViewUI.d(this.llO, 14) && !this.llO.lkJ) {
                    lVar.a(14, this.llO.getString(2131236684), 2131165340);
                }
                if (this.llO.lkJ && WebViewUI.d(this.llO, 14)) {
                    lVar.a(14, this.llO.getString(2131236683), 2131165336);
                }
                if ((this.llO.lkw.bjT().lWs & 16) > 0) {
                    z = true;
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GeneralControlWrapper", "allowExpose, ret = " + z);
                if (z && WebViewUI.d(this.llO, 10)) {
                    lVar.a(10, this.llO.getString(2131231490), 2131165317);
                }
                if (bjS.uC(36) && WebViewUI.d(this.llO, 8)) {
                    String str = null;
                    try {
                        str = this.llO.liH.bju();
                    } catch (Exception e4) {
                    }
                    if (be.kS(str)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "get mail session key is null or nil, should not show send mail menu");
                    } else {
                        lVar.a(8, this.llO.getString(2131236666), 2131165333);
                    }
                }
                if (WWAPIFactory.gC(this.llO).bPT() && WebViewUI.d(this.llO, 25)) {
                    lVar.S(25, 2131234319, 2131165346);
                }
                if (com.tencent.mm.plugin.webview.stub.a.aG(this.llO, this.llO.igd.getUrl()) && WebViewUI.d(this.llO, 26)) {
                    lVar.a(26, this.llO.getString(2131236688), 2131165345);
                }
                if (bjS.uC(91) && com.tencent.mm.plugin.webview.stub.a.cO(this.llO) && WebViewUI.d(this.llO, 20)) {
                    lVar.a(20, this.llO.getString(2131236689), 2131165338);
                }
                if (bjS.uC(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX) && com.tencent.mm.plugin.webview.stub.a.cO(this.llO) && WebViewUI.d(this.llO, 22)) {
                    lVar.a(22, this.llO.getString(2131236690), 2131165339);
                }
                if (this.llO.ljW.getVisibility() == 0) {
                    lVar.a(27, this.llO.getString(2131234314), 2131165324);
                }
            }
        };
        if (webViewUI.igd != null) {
            str = webViewUI.igd.getUrl();
        }
        if (!be.kS(str)) {
            if (!be.kS(Uri.parse(str).getHost())) {
                fVar.c(webViewUI.getString(2131236611, new Object[]{Uri.parse(str).getHost()}), 1);
            }
        }
        if (webViewUI.ljY) {
            fVar.pca = true;
            fVar.pcd = true;
        } else {
            fVar.pca = false;
            fVar.pcd = false;
        }
        fVar.bKh();
    }

    static /* synthetic */ void T(WebViewUI webViewUI) {
        if (!webViewUI.bkv()) {
            webViewUI.lln = true;
            g.pRr.close();
            webViewUI.finish();
        }
    }

    static /* synthetic */ void U(WebViewUI webViewUI) {
        View view = webViewUI.igd.getView();
        view.scrollTo(view.getScrollX(), 0);
        com.tencent.mm.plugin.webview.d.ai.f biy = webViewUI.ldG.biy();
        biy.leU = new Object[]{webViewUI.bpX, Integer.valueOf(7)};
        biy.a(webViewUI.liH);
    }

    static /* synthetic */ void Z(WebViewUI webViewUI) {
        CharSequence url = webViewUI.igd.getUrl();
        if (url == null || url.length() == 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "copyLink fail, url is null");
            return;
        }
        CharSequence Ec;
        try {
            Ec = webViewUI.liH.Ec(url);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "copy link failed");
            Ec = url;
        }
        ClipboardManager clipboardManager = (ClipboardManager) webViewUI.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(Ec);
                Toast.makeText(webViewUI, webViewUI.getString(2131236660), 0).show();
                return;
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e2, "clip.setText error", new Object[0]);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "clipboard manager is null");
    }

    static /* synthetic */ void a(WebViewUI webViewUI, Bundle bundle) {
        int color;
        int i;
        boolean z = bundle.getBoolean("set_navigation_bar_color_reset", false);
        if (z) {
            color = webViewUI.getResources().getColor(2131689495);
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        Drawable colorDrawable = new ColorDrawable(color);
        colorDrawable.setAlpha(i);
        if (webViewUI.cU().cV() != null) {
            webViewUI.cU().cV().setBackgroundDrawable(colorDrawable);
        }
        View customView = webViewUI.cU().cV().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131755264);
            if (findViewById != null && !z) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setNavigationBar set divider half_alpha_white color");
                findViewById.setBackgroundColor(webViewUI.getResources().getColor(2131689783));
            } else if (findViewById != null && z) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "setNavigationBar set divider actionbar_devider_color color");
                findViewById.setBackgroundColor(webViewUI.getResources().getColor(2131689501));
            }
            customView.setBackgroundDrawable(colorDrawable);
            customView.invalidate();
            webViewUI.setStatusBarColor(color == webViewUI.getResources().getColor(2131689495) ? webViewUI.getResources().getColor(2131690051) : d.sX(color));
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "setNavigationBar view is null");
    }

    static /* synthetic */ void a(WebViewUI webViewUI, MenuItem menuItem) {
        if (menuItem instanceof com.tencent.mm.ui.base.m) {
            String str = ((com.tencent.mm.ui.base.m) menuItem).guw;
            if (!be.kS(str) && !str.equals(webViewUI.igd.getUrl())) {
                webViewUI.igd.loadUrl(str);
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, ViewGroup viewGroup, WindowInsets windowInsets) {
        if (webViewUI.dQw != windowInsets.getSystemWindowInsetTop()) {
            webViewUI.dQw = windowInsets.getSystemWindowInsetTop();
            webViewUI.bjZ();
            if (viewGroup instanceof SwipeBackLayout) {
                viewGroup = viewGroup.getChildAt(0);
            }
            View findViewById = viewGroup.findViewById(2131755248);
            if (findViewById != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                findViewById.setLayoutParams(marginLayoutParams);
                findViewById.requestLayout();
            }
            if (webViewUI.bka()) {
                webViewUI.setStatusBarColor(webViewUI.getResources().getColor(2131690051));
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, int i) {
        if (webViewUI.ljZ != null) {
            WebViewInputFooter webViewInputFooter = webViewUI.ljZ;
            webViewInputFooter.setVisibility(0);
            if (webViewInputFooter.lrZ != null) {
                webViewInputFooter.lrZ.setVisibility(0);
            }
            if (webViewInputFooter.lrY != null) {
                webViewInputFooter.lrY.setEnabled(true);
                webViewInputFooter.lrY.setBackgroundResource(2130838423);
            }
            if (webViewInputFooter.lrV != null) {
                webViewInputFooter.lrV.setVisibility(0);
            }
            webViewInputFooter.lsa = false;
            if (webViewInputFooter.lrY != null) {
                webViewInputFooter.lrY.setFocusable(true);
                webViewInputFooter.lrY.setFocusableInTouchMode(true);
                webViewInputFooter.lrY.requestFocus();
            }
            if (webViewInputFooter.aWn != null) {
                webViewInputFooter.aWn.aJs();
            }
            webViewInputFooter.state = 0;
            if (!be.kS(str)) {
                WebViewInputFooter webViewInputFooter2 = webViewUI.ljZ;
                webViewInputFooter2.lrY.setText("");
                if (!be.kS(str)) {
                    try {
                        webViewInputFooter2.lrY.append(str);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
                    }
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[]{webViewInputFooter2.lrY.getText()});
                }
            }
            if (i >= 0) {
                webViewInputFooter = webViewUI.ljZ;
                if (i > 0) {
                    webViewInputFooter.lsb = i;
                }
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, String str2, int i, int i2) {
        if (webViewUI.lkw == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "startGetReadingModeInfo fail, after onDestroy");
            return;
        }
        p pVar = webViewUI.lkz;
        if (pVar.lnd == 0) {
            pVar.llO.ta(673);
        }
        pVar.lnd++;
        webViewUI.lkK = str;
        webViewUI.lkJ = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        boolean z = false;
        try {
            z = webViewUI.liH.l(673, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "startGetReadingModeInfo, doScene ret = " + z);
    }

    static /* synthetic */ void aa(WebViewUI webViewUI) {
        com.tencent.mm.plugin.webview.stub.d dVar = webViewUI.liH;
        if (webViewUI != null && !webViewUI.isFinishing()) {
            String bkc = webViewUI.bkc();
            if (be.kS(bkc)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                return;
            }
            if (dVar != null) {
                try {
                    bkc = dVar.Ec(bkc);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", new Object[]{e});
                }
            }
            if (!(bkc.startsWith("http://") || bkc.startsWith("https://"))) {
                bkc = "http://" + bkc;
            }
            Parcelable intent = new Intent("android.intent.action.VIEW", Uri.parse(bkc));
            try {
                if (be.He()) {
                    webViewUI.startActivity(intent);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("targeturl", bkc);
                bundle.putParcelable("targetintent", intent);
                Intent intent2 = new Intent();
                intent2.setClass(webViewUI, AppChooserUI.class);
                intent2.putExtra("scene", 4);
                intent2.putExtra(Columns.TYPE, 0);
                intent2.putExtra("title", webViewUI.getString(2131231924));
                intent2.putExtra("targetintent", intent);
                intent2.putExtra("transferback", bundle);
                webViewUI.startActivityForResult(intent2, 2);
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e2.getMessage()});
            }
        }
    }

    static /* synthetic */ void ab(WebViewUI webViewUI) {
        webViewUI.lkl.ay("sendEmail", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:email", new HashMap(), fVar.loD, fVar.loE) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
    }

    static /* synthetic */ void ai(WebViewUI webViewUI) {
        webViewUI.lkl.ay("sendAppMessage", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:appmessage", new HashMap(), fVar.loD, fVar.loE) + ")", null);
            try {
                fVar.liH.w("scene", "wework", fVar.lhu);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
    }

    static /* synthetic */ void aj(WebViewUI webViewUI) {
        String str = null;
        try {
            str = webViewUI.liH.Ec(webViewUI.igd.getUrl());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getShareUrl failed : %s", new Object[]{e.getMessage()});
        }
        if (be.kS(str)) {
            str = webViewUI.bpX;
        }
        try {
            str = "weread://mp?url=" + com.tencent.mm.compatible.util.p.encode(str, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "encode url failed ; %s", new Object[]{e2.getMessage()});
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "now url = %s", new Object[]{str});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        if (be.m(webViewUI.nDR.nEl, intent)) {
            webViewUI.startActivity(intent);
        } else {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "not availble app match this intent");
        }
    }

    static /* synthetic */ void ak(WebViewUI webViewUI) {
        webViewUI.lkl.ay("shareQQ", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:qq", new HashMap(), fVar.loD, fVar.loE) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
    }

    static /* synthetic */ void al(WebViewUI webViewUI) {
        webViewUI.lkl.ay("shareWeiboApp", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:weiboApp", new HashMap(), fVar.loD, fVar.loE) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
    }

    static /* synthetic */ void am(WebViewUI webViewUI) {
        webViewUI.lkl.ay("shareQZone", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:QZone", new HashMap(), fVar.loD, fVar.loE) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
    }

    static /* synthetic */ void an(WebViewUI webViewUI) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            final Object stringArrayList = webViewUI.liH.i(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                if (stringArrayList.size() == 1) {
                    webViewUI.Fh((String) stringArrayList.get(0));
                    return;
                }
                webViewUI.bI(stringArrayList);
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(webViewUI.nDR.nEl);
                lVar.a(webViewUI.igd, webViewUI, null);
                lVar.oTB = new com.tencent.mm.ui.base.n.a(webViewUI) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void a(ImageView imageView, MenuItem menuItem) {
                        if (WebViewUI.g(menuItem)) {
                            imageView.setVisibility(8);
                            return;
                        }
                        String str = menuItem.getTitle();
                        if (this.llO.lkD.get(str) == null || ((Bitmap) this.llO.lkD.get(str)).isRecycled()) {
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                            try {
                                String ED = this.llO.liH.ED(str);
                                if (!be.kS(ED)) {
                                    Bitmap EW = d.EW(ED);
                                    if (EW != null && !EW.isRecycled()) {
                                        imageView.setImageBitmap(EW);
                                        this.llO.lkD.put(str, EW);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                                return;
                            }
                        }
                        imageView.setImageBitmap((Bitmap) this.llO.lkD.get(str));
                    }
                };
                lVar.oTC = new com.tencent.mm.ui.base.n.b(webViewUI) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void a(TextView textView, MenuItem menuItem) {
                        String str = menuItem.getTitle();
                        if (textView != null) {
                            String str2 = (String) this.llO.lkE.get(str);
                            if (be.kS(str2)) {
                                textView.setText(str);
                            } else {
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.llO.nDR.nEl, str2, textView.getTextSize()));
                            }
                        }
                    }
                };
                lVar.b(webViewUI.igd, new OnCreateContextMenuListener(webViewUI) {
                    final /* synthetic */ WebViewUI llO;

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        Iterator it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            contextMenu.add((String) it.next());
                        }
                    }
                }, new com.tencent.mm.ui.base.n.d(webViewUI) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        this.llO.Fh(menuItem.getTitle().toString());
                    }
                });
                lVar.aXZ();
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "builder add, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, int i) {
        if (webViewUI.ljZ != null && com.tencent.mm.compatible.util.d.dW(21) && webViewUI.bjX()) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.ljZ.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.ljZ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, String str) {
        if (webViewUI.liH != null) {
            Bundle bundle = new Bundle(1);
            bundle.putString("show_kb_input_callback_text", be.ma(str));
            try {
                webViewUI.liH.a(41, bundle, webViewUI.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", new Object[]{e, str});
            }
        }
        if (webViewUI.ljZ != null) {
            webViewUI.ljZ.hide();
        }
    }

    static /* synthetic */ boolean d(WebViewUI webViewUI, int i) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) webViewUI.llF.get(webViewUI.igd.getUrl());
        return sparseBooleanArray == null || !sparseBooleanArray.get(i, false);
    }

    static /* synthetic */ void e(WebViewUI webViewUI, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("update_type_key", i);
        try {
            webViewUI.liH.a(1, bundle, webViewUI.hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "doUpdate fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void e(WebViewUI webViewUI, String str) {
        try {
            webViewUI.liH.EL(str);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "sendImgToFriend fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void f(WebViewUI webViewUI, String str) {
        try {
            com.tencent.mm.pluginsdk.model.c.a(webViewUI.liH.EK(str), 34, (Activity) webViewUI);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ boolean g(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    static /* synthetic */ void h(WebViewUI webViewUI, String str) {
        if (webViewUI.lkl != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, 43);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
            try {
                fVar.liH.a(21, bundle, fVar.lhu);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.JsApiHandler", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = " + e);
            }
        }
    }

    static /* synthetic */ void i(WebViewUI webViewUI, String str) {
        webViewUI.lkl.ay("profile", true);
        webViewUI.lkl.Fv(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void j(com.tencent.mm.plugin.webview.ui.tools.WebViewUI r14, java.lang.String r15) {
        /*
        r13 = 3;
        r12 = 2;
        r11 = 4;
        r10 = 1;
        r9 = 0;
        r0 = r14.getIntent();
        r1 = "geta8key_username";
        r0 = r0.getStringExtra(r1);
        r1 = r14.getIntent();
        r2 = "k_username";
        r1.putExtra(r2, r0);
        r0 = r14.getIntent();
        r1 = "k_expose_url";
        r2 = r14.igd;
        r2 = r2.getUrl();
        r0.putExtra(r1, r2);
        r0 = r14.getIntent();
        r1 = "showShare";
        r0.putExtra(r1, r9);
        r0 = r14.igd;
        r2 = r0.getUrl();
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r1 != 0) goto L_0x0049;
    L_0x0041:
        r0 = android.net.Uri.parse(r2);
        r0 = r0.getHost();
    L_0x0049:
        r1 = 0;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r3 != 0) goto L_0x0148;
    L_0x0050:
        r3 = "mp.weixin.qq.com";
        r0 = r0.startsWith(r3);
        if (r0 == 0) goto L_0x0148;
    L_0x0059:
        r0 = "https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r4 = 0;
        r5 = r14.igd;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r5 = r5.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r6 = "utf-8";
        r5 = com.tencent.mm.compatible.util.p.encode(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r3[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r0 = java.lang.String.format(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x013a }
    L_0x0073:
        if (r0 == 0) goto L_0x01ec;
    L_0x0075:
        r1 = r14.igd;
        r1 = r1.getUrl();
        r3 = r14.Fk(r1);
        r1 = r14.lkw;
        r1 = r1.bjT();
        r1 = r1.brA();
        r2 = "MicroMsg.WebViewUI";
        r4 = "doExpose enableReportPageEvent %s";
        r5 = new java.lang.Object[r10];
        r6 = java.lang.Boolean.valueOf(r1);
        r5[r9] = r6;
        com.tencent.mm.sdk.platformtools.v.d(r2, r4, r5);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x011d;
    L_0x00a0:
        if (r1 == 0) goto L_0x011d;
    L_0x00a2:
        r1 = r14.igd;
        r1 = r1.getUrl();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x00ae:
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r1 = "MicroMsg.WebViewUI";
        r2 = "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r9] = r7;
        r7 = java.lang.Long.valueOf(r4);
        r6[r10] = r7;
        r6[r12] = r3;
        r7 = r14.igd;
        r7 = r7.getUrl();
        r6[r13] = r7;
        r7 = r14.aZj;
        r6[r11] = r7;
        r7 = 5;
        r8 = java.lang.Integer.valueOf(r11);
        r6[r7] = r8;
        r7 = 6;
        r8 = java.lang.Integer.valueOf(r10);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.v.d(r1, r2, r6);
        r1 = "";
        r2 = r14.igd;	 Catch:{ UnsupportedEncodingException -> 0x01ef }
        r2 = r2.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x01ef }
        r6 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x01ef }
    L_0x00f8:
        r2 = com.tencent.mm.plugin.report.service.g.iuh;
        r6 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r4 = java.lang.Long.valueOf(r4);
        r7[r9] = r4;
        r7[r10] = r3;
        r7[r12] = r1;
        r1 = r14.aZj;
        r7[r13] = r1;
        r1 = java.lang.Integer.valueOf(r11);
        r7[r11] = r1;
        r1 = 5;
        r3 = java.lang.Integer.valueOf(r10);
        r7[r1] = r3;
        r2.h(r6, r7);
    L_0x011d:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 == 0) goto L_0x0134;
    L_0x0123:
        r0 = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
        r1 = new java.lang.Object[r10];
        r2 = 34;
        r2 = java.lang.Integer.valueOf(r2);
        r1[r9] = r2;
        r0 = java.lang.String.format(r0, r1);
    L_0x0134:
        r1 = r14.igd;
        r1.loadUrl(r0);
        return;
    L_0x013a:
        r0 = move-exception;
        r3 = "MicroMsg.WebViewUI";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.v.e(r3, r0);
        r0 = r2;
        goto L_0x0073;
    L_0x0148:
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r15);
        if (r0 != 0) goto L_0x01ec;
    L_0x014e:
        r0 = "expose";
        r2 = 0;
        r0 = r14.getDir(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0.mkdirs();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r0.getAbsolutePath();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r2.append(r0);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2 = "/screenshot.jpg";
        r0 = r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2 = com.tencent.mm.sdk.platformtools.as.V(r14);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r3 = 80;
        r4 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r5 = 1;
        com.tencent.mm.sdk.platformtools.d.a(r2, r3, r4, r0, r5);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2 = 0;
        r4 = com.tencent.mm.modelsfs.FileOp.jP(r0);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r3 = (int) r4;	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r2 = com.tencent.mm.modelsfs.FileOp.c(r0, r2, r3);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        com.tencent.mm.loader.stub.b.deleteFile(r0);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r14.getIntent();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r3 = "k_webview_html";
        r4 = "UTF-8";
        r4 = r15.getBytes(r4);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r5 = 11;
        r4 = android.util.Base64.encodeToString(r4, r5);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0.putExtra(r3, r4);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r14.getIntent();	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r3 = "k_webview_img";
        r4 = 0;
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0.putExtra(r3, r2);	 Catch:{ UnsupportedEncodingException -> 0x01b3, IOException -> 0x01d1 }
        r0 = r1;
        goto L_0x0075;
    L_0x01b3:
        r0 = move-exception;
        r2 = "MicroMsg.WebViewUI";
        r3 = new java.lang.StringBuilder;
        r4 = "[oneliang]html get byte error, ex = ";
        r3.<init>(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r2, r0);
        r0 = r1;
        goto L_0x0075;
    L_0x01d1:
        r0 = move-exception;
        r2 = "MicroMsg.WebViewUI";
        r3 = new java.lang.StringBuilder;
        r4 = "[oneliang]save screen shot to file error, ex = ";
        r3.<init>(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r2, r0);
    L_0x01ec:
        r0 = r1;
        goto L_0x0075;
    L_0x01ef:
        r2 = move-exception;
        r6 = "MicroMsg.WebViewUI";
        r7 = "";
        r8 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.v.a(r6, r2, r7, r8);
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.j(com.tencent.mm.plugin.webview.ui.tools.WebViewUI, java.lang.String):void");
    }

    static /* synthetic */ void k(WebViewUI webViewUI, String str) {
        if (!(be.kS(str) || str.equals(webViewUI.igd.getUrl()))) {
            webViewUI.igd.loadUrl(str);
        }
        webViewUI.lkJ = false;
    }

    static /* synthetic */ void m(WebViewUI webViewUI, String str) {
        webViewUI.lkl.ay("sendAppMessage", false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = webViewUI.lkl;
        if (fVar.loB) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "connector");
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:appmessage", hashMap, fVar.loD, fVar.loE) + ")", null);
            try {
                fVar.liH.w("connector_local_send", str, fVar.lhu);
                fVar.liH.w("scene", "connector", fVar.lhu);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
    }

    static /* synthetic */ void q(WebViewUI webViewUI) {
        webViewUI.llx.ljw = new com.tencent.mm.plugin.webview.ui.tools.f.a(webViewUI) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void bjV() {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
                if (this.llO.lkl != null) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llO.lkl;
                    if (fVar.loB) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                        ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass28(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.f.Fy(com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onPullDownRefresh", null, fVar.loD, fVar.loE))));
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
                }
            }
        };
        f fVar = webViewUI.llx;
        fVar.dCD = true;
        if (fVar.ljy != null) {
            fVar.ljy.setVisibility(0);
            fVar.ljy.lix = fVar;
            fVar.ljy.liu = true;
            fVar.ljy.hx(false);
            fVar.ljy.liv = fVar.ljz;
        }
        if (fVar.ljx != null) {
            fVar.ljx.setWillNotDraw(true);
            fVar.ljx.setImageResource(2130839545);
            fVar.ljx.setVisibility(0);
            fVar.ljx.setAlpha(0.0f);
            fVar.ljx.setWillNotDraw(false);
            fVar.ljx.invalidate();
        }
        if (fVar.ljI != null) {
            fVar.ljI.setVisibility(8);
        }
    }

    static /* synthetic */ void r(WebViewUI webViewUI) {
        if (webViewUI.igd != null) {
            webViewUI.igd.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new com.tencent.smtt.sdk.u<String>(webViewUI) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "get background color s = %s", new Object[]{str});
                    if (!be.kS(str)) {
                        int color = this.llO.getResources().getColor(2131690121);
                        String[] split;
                        if (WebViewUI.lly.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 4) {
                                try {
                                    color = Color.argb(be.getInt(be.ma(split[3]).trim(), 0), be.getInt(be.ma(split[0]).trim(), 0), be.getInt(be.ma(split[1]).trim(), 0), be.getInt(be.ma(split[2]).trim(), 0));
                                } catch (Exception e) {
                                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                                    return;
                                }
                            }
                            return;
                        } else if (WebViewUI.llz.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 3) {
                                try {
                                    color = Color.argb(255, be.getInt(be.ma(split[0]).trim(), 0), be.getInt(be.ma(split[1]).trim(), 0), be.getInt(be.ma(split[2]).trim(), 0));
                                } catch (Exception e2) {
                                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                                    return;
                                }
                            }
                            return;
                        } else {
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
                        }
                        this.llO.llx.sZ(color);
                        f p = this.llO.llx;
                        if (p.ljI != null) {
                            p.ljI.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ int s(WebViewUI webViewUI) {
        if (webViewUI.ljZ == null) {
            return 0;
        }
        WebViewInputFooter webViewInputFooter = webViewUI.ljZ;
        webViewInputFooter.setVisibility(0);
        if (webViewInputFooter.lrZ != null) {
            webViewInputFooter.lrZ.setVisibility(8);
        }
        webViewInputFooter.lsa = true;
        webViewInputFooter.state = 1;
        return webViewInputFooter.blH();
    }

    static {
        Set hashSet = new HashSet();
        lee = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.cnh;
        if (!be.kS(str)) {
            str = com.tencent.mm.compatible.util.e.cnh.replace("/data/user/0", "/data/data");
        }
        lee.add("file://" + new File(str, "fts/res").getAbsolutePath());
        lee.add("file://" + new File(com.tencent.mm.compatible.util.e.cnj, "fts/res").getAbsolutePath());
        lee.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        lee.add("file://" + new File(com.tencent.mm.compatible.util.e.cnj, "wenote/res").getAbsolutePath());
        lee.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath()});
        lee.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        lee.add("file://" + new File(com.tencent.mm.compatible.util.e.cnj, "emoji/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = lee.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    private void Fc(String str) {
        if (this.igd != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.igd, new Object[0]);
            } catch (NoSuchMethodException e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private void hy(boolean z) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPageStateChange, active = %b", new Object[]{Boolean.valueOf(z)});
        if (this.lkl != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lkl;
            if (fVar.loB) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", new Object[]{Boolean.valueOf(z)});
                Map hashMap = new HashMap();
                hashMap.put("active", String.valueOf(z));
                ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass29(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.f.Fy(com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onPageStateChange", hashMap, fVar.loD, fVar.loE))));
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
            }
        }
        if (!z) {
            this.lkq = true;
        }
    }

    public void onResume() {
        super.onResume();
        this.ldG.biv().lfk = be.Nj();
        g gVar = g.pRr;
        if (!be.kS(gVar.juo)) {
            gVar.kZ(7);
        }
        if (!this.llt) {
            int hashCode = hashCode();
            for (int size = lkp.size() - 1; size >= 0; size--) {
                if (((aa) lkp.get(size)).id == hashCode) {
                    lkp.remove(size);
                    break;
                }
            }
            lkp.add(new aa(this));
        }
        this.llt = false;
        if (this.lkq) {
            hy(true);
            this.lkq = false;
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && this.nFw != null) {
            this.nFw.hVC = false;
        }
        Fc("onResume");
        Fe("onResume");
        try {
            if (this.liH != null) {
                Bundle i = this.liH.i(19, null);
                if (i != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[]{Boolean.valueOf(i.getBoolean("webview_video_proxy_init"))});
                    if (i.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[]{e.getMessage()});
        }
        this.evC = be.Nh();
        com.tencent.mm.modelstat.d.a(3, "WebViewUI_" + Fl(be.ma(this.lkU)), hashCode());
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.modelstat.d.a(4, "WebViewUI_" + Fl(be.ma(this.lkU)), hashCode());
        com.tencent.mm.modelstat.d.d("WebViewUI_" + Fl(be.ma(this.lkU)), this.evC, be.Nh());
        com.tencent.mm.plugin.webview.d.ai.i biv = this.ldG.biv();
        if (biv.lfk != -1) {
            biv.jxX += be.az(biv.lfk) / 1000;
        }
        g gVar = g.pRr;
        if (!(gVar.cvW || be.kS(gVar.juo))) {
            gVar.kZ(6);
        }
        try {
            if (this.liH != null) {
                Bundle i = this.liH.i(19, null);
                if (i != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[]{Boolean.valueOf(i.getBoolean("webview_video_proxy_init"))});
                    if (i.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[]{e.getMessage()});
        }
        bkq();
        Fc("onPause");
        Fe("onPause");
        if (this.lkt != null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.lkt.onHideCustomView();
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e2, "onPause", new Object[0]);
            }
        }
    }

    public void finish() {
        if (this.lke) {
            setResult(-1);
        }
        try {
            if (this.liH != null) {
                this.liH.sP(hashCode());
                this.liH.sL(hashCode());
            }
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + e);
        }
        this.llo = true;
        super.finish();
    }

    public int getLayoutId() {
        return 2130904706;
    }

    protected final boolean Sd() {
        return false;
    }

    public void Fd(String str) {
        super.Fd(str);
        vC(getResources().getColor(2131689496));
    }

    private void Fe(String str) {
        if (this.lkl != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lkl;
            if (fVar.loB) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + str);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass2(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("activity:state_change", hashMap, fVar.loD, fVar.loE)));
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
            }
            try {
                if (str.equals("onPause")) {
                    this.liH.sR(hashCode());
                } else if (str.equals("onResume")) {
                    this.liH.sQ(hashCode());
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onResume, ex = " + e.getMessage());
            }
        }
    }

    protected boolean bjO() {
        return false;
    }

    private void bjW() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.gfD, 1);
    }

    protected final void PK() {
        aq(5);
        aq(9);
        setProgressBarIndeterminateVisibility(false);
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.bpX = bkm();
        this.lka = getIntent().getBooleanExtra("key_trust_url", false);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "albie: trustUrl : %b.", new Object[]{Boolean.valueOf(this.lka)});
        llm++;
        lkp.add(new aa(this));
        if (lkp.size() > 1) {
            aa aaVar = (aa) lkp.get(lkp.size() - 2);
            if (!(aaVar.keg == null || aaVar.keg.get() == null)) {
                ((WebViewUI) aaVar.keg.get()).hy(false);
            }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "initView , rawUrl = %s ", new Object[]{this.bpX});
        this.bnX = be.ma(getIntent().getStringExtra("KPublisherId"));
        this.bsZ = Fl(getIntent().getStringExtra("geta8key_username"));
        com.tencent.mm.plugin.webview.d.ai.l bir = this.ldG.bir();
        int i = this.bsZ;
        String str = this.bnX;
        bir.bsZ = i;
        bir.leY = str;
        this.handler = new ac();
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.llG.clear();
        this.llG.put("menuItem:share:brand", Integer.valueOf(0));
        this.llG.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.llG.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.llG.put("menuItem:share:timeline", Integer.valueOf(2));
        this.llG.put("menuItem:favorite", Integer.valueOf(3));
        this.llG.put("menuItem:profile", Integer.valueOf(5));
        this.llG.put("menuItem:addContact", Integer.valueOf(5));
        this.llG.put("menuItem:copyUrl", Integer.valueOf(6));
        this.llG.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.llG.put("menuItem:share:email", Integer.valueOf(8));
        this.llG.put("menuItem:delete", Integer.valueOf(9));
        this.llG.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.llG.put("menuItem:setFont", Integer.valueOf(11));
        this.llG.put("menuItem:editTag", Integer.valueOf(12));
        this.llG.put("menuItem:readMode", Integer.valueOf(14));
        this.llG.put("menuItem:originPage", Integer.valueOf(14));
        this.llG.put("menuItem:share:qq", Integer.valueOf(20));
        this.llG.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.llG.put("menuItem:share:QZone", Integer.valueOf(22));
        this.llG.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.llG.put("menuItem:share:wework", Integer.valueOf(25));
        this.llG.put("menuItem:share:weread", Integer.valueOf(26));
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.pluginsdk.model.v.a.df(this);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "initWebView, check Tbs time consumed = %d(ms)", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        this.igd = bkd();
        if (!(this.igd == null || this.igd.pdG || com.tencent.mm.compatible.util.d.dW(19))) {
            try {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new com.tencent.mm.compatible.loader.c(this.igd, "mSysWebView", null).get()});
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get()});
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get()});
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get()});
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get()});
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
        this.igd.getSettings().setJavaScriptEnabled(booleanExtra3);
        this.igd.getSettings().setPluginsEnabled(booleanExtra);
        this.igd.getSettings().setDomStorageEnabled(true);
        this.igd.getSettings().setBuiltInZoomControls(booleanExtra2);
        this.igd.getSettings().setUseWideViewPort(true);
        this.igd.getSettings().setLoadWithOverviewMode(true);
        this.igd.getSettings().setSavePassword(false);
        this.igd.getSettings().setSaveFormData(false);
        this.igd.getSettings().setGeolocationEnabled(true);
        this.igd.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.igd.getSettings().setMixedContentMode(0);
        this.igd.getSettings().setAppCacheMaxSize(10485760);
        this.igd.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.igd.getSettings().setAppCacheEnabled(true);
        this.igd.getSettings().setDatabaseEnabled(true);
        this.igd.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.cnf + "databases/");
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.igd, true);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e2) {
        }
        bjW();
        this.lkw = new e(this, this.igd);
        NI();
        Fe("onCreate");
        this.lkb = this.igd.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[]{Integer.valueOf(this.fromScene)});
        this.aZj = com.tencent.mm.model.o.fz(be.ma(hashCode()));
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[]{this.aZj});
        if (ak.isConnected(this)) {
            if (ak.isWifi(this)) {
                this.networkType = 1;
            } else if (ak.is4G(this)) {
                this.networkType = 4;
            } else if (ak.is3G(this)) {
                this.networkType = 3;
            } else if (ak.is2G(this)) {
                this.networkType = 2;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "get networkType %d", new Object[]{Integer.valueOf(this.networkType)});
        }
        this.width = getResources().getDisplayMetrics().widthPixels;
        this.height = getResources().getDisplayMetrics().heightPixels;
        com.tencent.mm.plugin.webview.d.ai.e biw = this.ldG.biw();
        i = this.bsZ;
        str = this.bnX;
        biw.bsZ = i;
        biw.leY = str;
        biw.url = this.bpX;
        com.tencent.mm.plugin.webview.d.ai.b biC = this.ldG.biC();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[]{this.bpX});
        try {
            Uri parse = Uri.parse(this.bpX);
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str = parse.getHost();
                if (str == null || str.toLowerCase().endsWith(".qq.com")) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[]{str});
                    this.dQy = ((ViewGroup) findViewById(16908290)).getChildAt(0);
                    bjZ();
                    ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                        final /* synthetic */ WebViewUI llO;

                        {
                            this.llO = r1;
                        }

                        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            this.llO.bjZ();
                        }
                    });
                    if (com.tencent.mm.compatible.util.d.dW(21) || !bjX()) {
                        ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                    } else {
                        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                        viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                            final /* synthetic */ WebViewUI llO;

                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                WebViewUI.a(this.llO, viewGroup, windowInsets);
                                return windowInsets.consumeSystemWindowInsets();
                            }
                        });
                    }
                    this.llp.vA().x(new Runnable(this) {
                        final /* synthetic */ WebViewUI llO;

                        {
                            this.llO = r1;
                        }

                        public final void run() {
                            com.tencent.mm.bf.f.buR();
                            com.tencent.mm.bf.b.buL();
                        }
                    });
                }
                biC.leS = true;
                this.dQy = ((ViewGroup) findViewById(16908290)).getChildAt(0);
                bjZ();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
                if (com.tencent.mm.compatible.util.d.dW(21)) {
                }
                ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                this.llp.vA().x(/* anonymous class already generated */);
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[]{parse.getScheme()});
            this.dQy = ((ViewGroup) findViewById(16908290)).getChildAt(0);
            bjZ();
            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
            if (com.tencent.mm.compatible.util.d.dW(21)) {
            }
            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
            this.llp.vA().x(/* anonymous class already generated */);
        } catch (Exception e3) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[]{r1});
        }
    }

    public boolean bjX() {
        return true;
    }

    public final int bjY() {
        if (getResources().getDimensionPixelSize(2131492881) > com.tencent.mm.bd.a.fromDPToPix(this, 48)) {
            return getResources().getDimensionPixelSize(2131492881);
        }
        if (com.tencent.mm.compatible.util.j.aF(this)) {
            return getResources().getDimensionPixelSize(2131493015);
        }
        return getResources().getDimensionPixelSize(2131493014);
    }

    private void bjZ() {
        if (!this.llu && this.dQy != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.dQy.getLayoutParams();
            int bjY = this.dQw + bjY();
            if (bjY != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = bjY;
                this.dQy.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public boolean bka() {
        return true;
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        if (this.dQw > 0 && !com.tencent.mm.compatible.util.d.dX(21)) {
            getWindow().setStatusBarColor(0);
            if (this.dQx == null) {
                this.dQx = new View(this);
                ((ViewGroup) findViewById(16908290)).addView(this.dQx, new LayoutParams(-1, this.dQw));
            } else {
                LayoutParams layoutParams = this.dQx.getLayoutParams();
                if (layoutParams.height != this.dQw) {
                    layoutParams.height = this.dQw;
                    this.dQx.setLayoutParams(layoutParams);
                }
            }
            this.dQx.setBackgroundColor(i);
        }
    }

    public void bkb() {
        this.llu = true;
        cU().cV().setBackgroundDrawable(new ColorDrawable(0));
        if (cU().cV().getCustomView() != null) {
            cU().cV().getCustomView().setBackgroundColor(0);
            cU().cV().getCustomView().invalidate();
        }
        setStatusBarColor(0);
        if (this.dQy != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.dQy.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.dQy.setLayoutParams(marginLayoutParams);
        }
    }

    public final String bkc() {
        if (this.handler == null) {
            return this.llI;
        }
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            return this.igd == null ? "" : this.igd.getUrl();
        } else {
            if (be.kS(this.llI)) {
                return (String) new az<String>(this, "") {
                    final /* synthetic */ WebViewUI llO;

                    protected final /* synthetic */ Object run() {
                        return this.llO.igd == null ? "" : this.llO.igd.getUrl();
                    }
                }.c(this.handler);
            }
            return this.llI;
        }
    }

    public MMWebView bkd() {
        return com.tencent.mm.ui.widget.MMWebView.a.eP(this);
    }

    protected final void Se() {
        if (VERSION.SDK_INT <= 10) {
            super.Se();
        } else if (NO() == -1) {
            this.nDQ = getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bti(), 4).getBoolean("settings_landscape_mode", false);
            if (this.nDQ) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(NO());
        }
    }

    protected final int NO() {
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        return this.screenOrientation;
    }

    private View bke() {
        int identifier;
        View view = null;
        if (com.tencent.mm.compatible.util.d.dW(11)) {
            try {
                identifier = Resources.getSystem().getIdentifier("action_bar_container", "id", "android");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[]{e});
            }
            if (identifier > 0) {
                view = findViewById(identifier);
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
            return view;
        }
        identifier = -1;
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.llv != configuration.orientation) {
            View bke = bke();
            bke = bke == null ? null : (View) bke.getParent();
            if (bke != null) {
                bke.dispatchConfigurationChanged(configuration);
                bke.requestLayout();
                this.llv = configuration.orientation;
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.ljW == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "fullScreenMenu is null");
        } else {
            this.ljX = getIntent().getBooleanExtra("show_full_screen", false);
            if (this.ljX) {
                if (cU().cV() != null) {
                    cU().cV().hide();
                }
                this.ljY = true;
                this.llu = true;
                if (this.dQy != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.dQy.getLayoutParams();
                    marginLayoutParams.topMargin = 0;
                    this.dQy.setLayoutParams(marginLayoutParams);
                }
                getWindow().setFlags(1024, 1024);
                getWindow().getDecorView().setSystemUiVisibility(5894);
                this.ljW.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void onClick(View view) {
                        WebViewUI.C(this.llO);
                    }
                });
                MovingImageButton movingImageButton = this.ljW;
                int i = this.screenOrientation;
                movingImageButton.lrL = 0;
                movingImageButton.lrM = 0;
                movingImageButton.Wj = i;
                this.ljW.setVisibility(0);
            } else {
                this.ljW.setVisibility(8);
                if (this.ljY) {
                    getWindow().clearFlags(1024);
                    getWindow().getDecorView().setSystemUiVisibility(0);
                    if (cU().cV() != null) {
                        cU().cV().show();
                    }
                    this.llu = false;
                    this.ljY = false;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onStart");
    }

    protected void onStop() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onStop");
        z(true, true);
        super.onStop();
    }

    private void ta(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.liH.a(5, bundle, hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
        }
    }

    private void tb(int i) {
        try {
            if (this.liH != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.liH.a(6, bundle, hashCode());
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    @TargetApi(11)
    public void onDestroy() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        this.lln = true;
        llm--;
        int hashCode = hashCode();
        for (int size = lkp.size() - 1; size >= 0; size--) {
            if (((aa) lkp.get(size)).id == hashCode) {
                lkp.remove(size);
                break;
            }
        }
        f("", be.Nh(), 0);
        a.lgb.O(hashCode(), true);
        com.tencent.mm.plugin.webview.d.ai.f biy = this.ldG.biy();
        biy.leU = new Object[]{this.bpX, Integer.valueOf(2)};
        biy.a(this.liH);
        this.ldG.a(this.liH);
        ai aiVar = this.ldG;
        aiVar.leF = null;
        aiVar.leD = null;
        aiVar.leE = null;
        aiVar.leC = null;
        aiVar.leG = null;
        aiVar.leH = null;
        aiVar.leI = null;
        aiVar.leJ = null;
        Fe("onDestroy");
        this.lkL.clear();
        for (SparseBooleanArray sparseBooleanArray : this.llF.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.llF.clear();
        com.tencent.mm.plugin.webview.d.a aVar = this.llp;
        if (!(aVar.ldF == null || aVar.ldF.htb.getLooper() == null)) {
            aVar.ldF.htb.getLooper().quit();
        }
        aVar.ldF = null;
        af afVar = this.lls;
        afVar.lex.clear();
        afVar.ley.clear();
        afVar.lez.clear();
        afVar.lev.clear();
        afVar.lew.clear();
        if (this.llK != null) {
            this.llK.dismiss();
            this.llK = null;
        }
        tb(233);
        this.lkM.clear();
        this.lkP.clear();
        CookieSyncManager createInstance = CookieSyncManager.createInstance(com.tencent.mm.sdk.platformtools.aa.getContext());
        if (createInstance != null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            createInstance.sync();
        }
        if (bkp()) {
            try {
                if (this.liH != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.liH.a(30, bundle, hashCode());
                }
            } catch (Exception e) {
            }
        }
        try {
            if (this.liH != null) {
                bundle = this.liH.i(19, null);
                if (bundle != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(llm)});
                    if (bundle.getBoolean("webview_video_proxy_init") && llm <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.liH.i(75, null);
                    }
                }
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[]{e2.getMessage()});
        }
        if (this.gfD != null) {
            try {
                unbindService(this.gfD);
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e3, "unbindService", new Object[0]);
            }
        }
        if (this.lkl != null) {
            this.lkl.detach();
        }
        this.lko.clear();
        if (this.lkF != null) {
            b bVar = this.lkF;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            bVar.context = null;
            bVar.liG = null;
            bVar.liI.clear();
            bVar.liJ.clear();
        }
        if (this.lkH != null) {
            this.lkH.detach();
        }
        if (VERSION.SDK_INT >= 11) {
            this.igd.removeJavascriptInterface("MicroMsg");
            this.igd.removeJavascriptInterface("JsApi");
        }
        try {
            this.igd.setWebChromeClient(null);
            this.igd.setWebViewClient(null);
            this.igd.setOnTouchListener(null);
            this.igd.setOnLongClickListener(null);
            this.igd.setVisibility(8);
            this.igd.removeAllViews();
            this.igd.clearView();
        } catch (Exception e22) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[]{e22.getMessage()});
        }
        this.llq.bjk();
        if (this.lkw != null) {
            e eVar = this.lkw;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewPermission", "detach");
            eVar.ljn.clear();
            eVar.ljn = null;
            eVar.liG = null;
            this.lkw = null;
        }
        try {
            this.llx.release();
        } catch (Exception e222) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e222.getMessage());
        }
        try {
            this.igd.destroy();
        } catch (Exception e2222) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[]{e2222.getMessage()});
        }
        this.igd = null;
        System.gc();
        super.onDestroy();
    }

    private void bkf() {
        try {
            this.llx.release();
            this.igd.stopLoading();
            this.igd.removeAllViews();
            this.igd.clearView();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.lkl != null) {
            this.lkl.detach();
        }
        try {
            this.igd.destroy();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
        this.igd = null;
        finish();
        com.tencent.mm.sdk.platformtools.v.bta();
        int myPid = Process.myPid();
        com.tencent.recovery.b.yH(13);
        Process.killProcess(myPid);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || this.llw) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.lks == null || this.lkr == null || this.lkt == null) {
            if (i == 4) {
                boolean z;
                if (this.ljZ == null || !this.ljZ.isShown()) {
                    z = false;
                } else {
                    this.ljZ.hide();
                    bkq();
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            if (i == 4) {
                if (this.igd.canGoBack()) {
                    bkg();
                    com.tencent.mm.plugin.webview.d.ai.f biy = this.ldG.biy();
                    biy.leU = new Object[]{this.bpX, Integer.valueOf(1)};
                    biy.a(this.liH);
                    return true;
                }
                g.pRr.close();
            }
            if (i == 4 && bkv()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        try {
            this.lkt.onHideCustomView();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
        }
        biy = this.ldG.biy();
        biy.leU = new Object[]{this.bpX, Integer.valueOf(1)};
        biy.a(this.liH);
        return true;
    }

    public void bkg() {
        this.igd.goBack();
        this.lkk = null;
        if (this.lkJ) {
            this.lkJ = false;
        }
        g gVar = g.pRr;
        if (!be.kS(gVar.juo)) {
            gVar.kZ(5);
        }
    }

    protected void bjR() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.nDR.dtW == null) {
            this.igd.setBackgroundDrawable(com.tencent.mm.bd.a.a(this, 2131689900));
            return;
        }
        vA(intExtra);
        this.nDR.dtW.setBackgroundResource(intExtra);
        this.igd.setBackgroundResource(17170445);
        findViewById(2131756749).setBackgroundResource(17170445);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.ljX) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void NI() {
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.lki = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.lkf = getIntent().getBooleanExtra("is_favorite_item", false);
        this.jLZ = getIntent().getBooleanExtra("isWebwx", true);
        this.lkd = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.lkW = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.lkh = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.lkS = LayoutInflater.from(this.nDR.nEl).inflate(2130904528, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.lkU = be.ma(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            a(1, getString(2131235016), new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        this.llO.igd.loadUrl(this.llO.liH.EO(null));
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", new Object[]{e.getMessage()});
                    }
                    return false;
                }
            });
        }
        this.lkT = findViewById(2131756752);
        this.lkT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onClick(View view) {
                this.llO.h(this.llO.lkk, true, -1);
                com.tencent.mm.plugin.webview.d.ai.f biy = this.llO.ldG.biy();
                biy.leU = new Object[]{this.llO.bpX, Integer.valueOf(4)};
                biy.a(this.llO.liH);
            }
        });
        if (this.jLZ) {
            CharSequence ma = be.ma(getIntent().getStringExtra("title"));
            if (ma.length() > 0) {
                this.ljQ = true;
            }
            super.H(ma);
            vC(getResources().getColor(2131689496));
        } else {
            Fd("");
        }
        hA(false);
        hB(false);
        if (lkv == RenderPriority.NORMAL) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.igd.getSettings().setRenderPriority(RenderPriority.HIGH);
            lkv = RenderPriority.HIGH;
        }
        f fVar = this.llx;
        View view = this.nDR.dtW;
        fVar.ljy = (LogoWebViewWrapper) view.findViewById(2131756750);
        fVar.ljx = (ImageView) view.findViewById(2131760071);
        fVar.ljH = view.findViewById(2131760070);
        if (fVar.ljH != null) {
            fVar.ljI = fVar.ljH.findViewById(2131760081);
            fVar.ljJ = (TextView) fVar.ljI.findViewById(2131760082);
        }
        fVar.ljz = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(fVar.ljy.getContext(), 72.0f);
        String str = "MicroMsg.WebViewPullDownLogoDelegate";
        String str2 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        objArr[0] = fVar.ljx == null ? "null" : String.valueOf(fVar.ljx.getId());
        objArr[1] = fVar.ljy == null ? "null" : String.valueOf(fVar.ljy.getId());
        com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[]{Integer.valueOf(fVar.ljz)});
        f fVar2 = this.llx;
        MMWebView mMWebView = this.igd;
        mMWebView.pdI = fVar2.ljy;
        mMWebView.bKo();
        if (VERSION.SDK_INT <= 10) {
            fVar2.ljy.bjK().setBackgroundColor(fVar2.ljy.getResources().getColor(2131690121));
        }
        LogoWebViewWrapper logoWebViewWrapper = fVar2.ljy;
        logoWebViewWrapper.bjK();
        if (logoWebViewWrapper.lin != null) {
            logoWebViewWrapper.eQN = mMWebView;
            logoWebViewWrapper.lin.addView(logoWebViewWrapper.eQN);
        }
        fVar2.ljK = mMWebView.pdG;
        if (!fVar2.ljK || fVar2.ljL) {
            fVar2.hx(true);
        } else {
            fVar2.hx(false);
            if (fVar2.ljI != null) {
                fVar2.ljI.setVisibility(0);
            }
        }
        bjR();
        this.ljV = (FrameLayout) findViewById(2131755326);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.igd.pdG);
        if (this.igd.pdG) {
            this.igd.setWebViewCallbackClient(this.dOV);
            this.igd.getX5WebViewExtension().setWebViewClientExtension(this.dOW);
            fVar2 = this.llx;
            com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a anonymousClass7 = new com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final void bjM() {
                    if (this.llO.igd.pdG) {
                        com.tencent.mm.plugin.webview.d.ai.f biy = this.llO.ldG.biy();
                        biy.leU = new Object[]{this.llO.bpX, Integer.valueOf(10)};
                        biy.a(this.llO.liH);
                    }
                }
            };
            if (fVar2.ljy != null) {
                fVar2.ljy.liw = anonymousClass7;
            }
        }
        this.ljZ = (WebViewInputFooter) findViewById(2131760072);
        if (this.ljZ != null) {
            this.ljZ.hide();
            this.ljZ.lrR = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final void Fq(String str) {
                    WebViewUI.b(this.llO, str);
                }
            };
            this.ljZ.lrS = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final boolean oI(String str) {
                    if (this.llO.lkl != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llO.lkl;
                        Map hashMap = new HashMap();
                        hashMap.put("smiley", str);
                        ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass14(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onGetSmiley", hashMap, fVar.loD, fVar.loE)));
                    }
                    return true;
                }
            };
            this.ljZ.lrT = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final void bkD() {
                    WebViewUI.b(this.llO, 0);
                }

                public final void bkE() {
                    WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.llO.findViewById(2131756749);
                    if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.ljl > 0) {
                        WebViewUI.b(this.llO, webViewKeyboardLinearLayout.ljl);
                    }
                }
            };
        }
        this.ljW = (MovingImageButton) findViewById(2131760073);
        this.lkm = findViewById(2131760074);
        if (this.lkm != null) {
            this.lkm.setVisibility(8);
        }
        if (!booleanExtra) {
            this.igd.setVerticalScrollBarEnabled(false);
        }
        this.lkt = new WebChromeClient(this) {
            public volatile boolean fHM = false;
            private Dialog gpw = null;
            final /* synthetic */ WebViewUI llO;
            private final List<String> llP = new LinkedList();

            {
                this.llO = r2;
            }

            public final void onProgressChanged(WebView webView, int i) {
                if (i < 100) {
                    this.llO.hB(false);
                } else if (i >= 100) {
                    this.llO.hB(true);
                }
            }

            public final void onReceivedTitle(WebView webView, String str) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[]{str, this.llO.llI});
                super.onReceivedTitle(webView, str);
                if (this.llO.ljQ) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + str);
                } else if (str == null) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "null title");
                } else if (this.llO.jLZ && !be.ma(this.llO.llI).equals(str) && !com.tencent.mm.plugin.webview.modelcache.v.Ei(str)) {
                    this.llO.Fd(str);
                }
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
                try {
                    if (this.llO.lks != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.llO.vB(4);
                    this.llO.hA(false);
                    this.llO.lks = view;
                    this.llO.lkr = customViewCallback;
                    this.llO.igd.setVisibility(8);
                    this.llO.ljV.addView(view);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
                if (this.llO.lks != null) {
                    try {
                        this.llO.vB(0);
                        this.llO.hA(false);
                        this.llO.igd.setVisibility(0);
                        if (this.llO.ljV != null) {
                            this.llO.ljV.removeView(this.llO.lks);
                        }
                        this.llO.lks = null;
                        if (this.llO.lkr != null) {
                            this.llO.lkr.onCustomViewHidden();
                        }
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
                    }
                }
            }

            public final View getVideoLoadingProgressView() {
                if (this.llO.lku == null) {
                    this.llO.lku = new ProgressBar(this.llO);
                    this.llO.lku.setIndeterminate(true);
                }
                return this.llO.lku;
            }

            public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
                com.tencent.mm.ui.base.g.a(this.llO, false, this.llO.getString(2131236677, new Object[]{str}), this.llO.getString(2131236678), this.llO.getString(2131231107), this.llO.getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 llS;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok, origin = %s");
                        geolocationPermissionsCallback.invoke(str, true, true);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 llS;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel, origin = %s");
                        geolocationPermissionsCallback.invoke(str, false, false);
                    }
                });
            }

            public final void openFileChooser(com.tencent.smtt.sdk.u<Uri> uVar, String str, String str2) {
                this.llO.llA.a(this.llO, this.llO.lkw, uVar, null, str, str2);
            }

            public final boolean onShowFileChooser(WebView webView, com.tencent.smtt.sdk.u<Uri[]> uVar, com.tencent.smtt.sdk.WebChromeClient.a aVar) {
                if (aVar.getMode() != 0) {
                    return false;
                }
                if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                    return true;
                }
                this.llO.llA.a(this.llO, this.llO.lkw, null, uVar, aVar.getAcceptTypes()[0], "*");
                return true;
            }

            public final boolean onJsConfirm(WebView webView, final String str, String str2, final JsResult jsResult) {
                this.llO.llg = this.llO.llg + 1;
                if (this.llO.llg > 2) {
                    this.gpw = com.tencent.mm.ui.base.g.a(this.llO, str2, "", this.llO.getString(2131236672), this.llO.getString(2131231107), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11683, new Object[]{str, Integer.valueOf(1), Integer.valueOf(this.llS.llO.llg)});
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.llS.llO.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, 2131689564);
                } else {
                    this.gpw = com.tencent.mm.ui.base.g.a(this.llO.nDR.nEl, false, str2, "", this.llO.getString(2131231107), this.llO.getString(2131231010), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    });
                }
                if (this.gpw == null) {
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }
                this.gpw.setCancelable(false);
                this.gpw.setCanceledOnTouchOutside(false);
                return true;
            }

            public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            public final boolean onJsAlert(WebView webView, final String str, String str2, final JsResult jsResult) {
                com.tencent.mm.ui.base.h a;
                this.llO.llg = this.llO.llg + 1;
                if (this.llO.llg > 2) {
                    a = com.tencent.mm.ui.base.g.a(this.llO, str2, "", this.llO.getString(2131236672), this.llO.getString(2131231107), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11683, new Object[]{str, Integer.valueOf(1), Integer.valueOf(this.llS.llO.llg)});
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.llS.llO.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    }, 2131689819);
                } else {
                    a = com.tencent.mm.ui.base.g.a(this.llO, str2, "", this.llO.getString(2131231107), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass11 llS;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.confirm();
                        }
                    });
                }
                if (a == null) {
                    return super.onJsAlert(webView, str, str2, jsResult);
                }
                a.setCanceledOnTouchOutside(false);
                a.ji(false);
                return true;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String message = consoleMessage != null ? consoleMessage.message() : null;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onConsoleMessage : %s", new Object[]{message});
                if (be.kS(message) || this.llO.lkH == null) {
                    return false;
                }
                if (message.equalsIgnoreCase("weixin://preInjectJSBridge/start")) {
                    this.llO.llh = true;
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "now inject js library");
                    if (this.llO.lkH != null) {
                        this.llO.lkH.blo();
                    }
                    return true;
                } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/fail")) {
                    if (this.llO.llh) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "preInjectJSBridge fail");
                        com.tencent.mm.plugin.report.service.g.iuh.a(156, 3, 1, false);
                    }
                    this.llO.llh = false;
                    return true;
                } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/ok")) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "preInjectJSBridge ok");
                    return true;
                } else if (this.llO.lkH.lpa) {
                    if (com.tencent.mm.pluginsdk.ui.tools.s.Ie(message).booleanValue()) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onConsoleMessage,set by console handle");
                        this.llO.lkH.lpa = false;
                        this.llO.lkj = false;
                        return true;
                    } else if (!com.tencent.mm.pluginsdk.ui.tools.s.Id(message).booleanValue()) {
                        return false;
                    } else {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onConsoleMessage preinject ,set by console handle");
                        this.llO.lkH.lpa = false;
                        this.llO.lkj = false;
                        this.llO.lkH.lpb = true;
                        this.llO.lkH.blo();
                        return true;
                    }
                } else if (!com.tencent.mm.pluginsdk.ui.tools.s.ds(message, "weixin://private/setresult/") && !com.tencent.mm.pluginsdk.ui.tools.s.ds(message, "weixin://dispatch_message/") && !com.tencent.mm.pluginsdk.ui.tools.s.ds(message, "weixin://gethtml/")) {
                    return false;
                } else {
                    if (message.equals(this.llO.llH)) {
                        this.llO.llH = "";
                        return true;
                    } else if (this.llP.size() > 200) {
                        return true;
                    } else {
                        this.llP.add(message);
                        if (!(this.llO.handler == null || this.fHM)) {
                            this.llO.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass11 llS;

                                {
                                    this.llS = r1;
                                }

                                public final void run() {
                                    if (this.llS.llP.size() > 0) {
                                        this.llS.fHM = true;
                                        String str = (String) this.llS.llP.remove(0);
                                        this.llS.llO.Fj(str);
                                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onConsoleMessage, handleUrl = " + str);
                                        this.llS.llO.handler.postDelayed(this, 20);
                                        return;
                                    }
                                    this.llS.fHM = false;
                                }
                            });
                        }
                        return true;
                    }
                }
            }
        };
        this.igd.setWebChromeClient(this.lkt);
        this.igd.setWebViewClient(new i(this));
        this.igd.setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
                if (str4 != null && str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                    com.tencent.mm.sdk.platformtools.v.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[]{str});
                    d.a(this.llO.liH, 11154, str);
                }
                if (this.llO.lkw == null || this.llO.lkw.bjS() == null) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                    return;
                }
                if (str4 != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(this.llO.bjH())});
                    CharSequence Fp = WebViewUI.Fg(str3);
                    int i2 = (Fp == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", Fp)) ? 0 : 1;
                    boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.b.log.contains(str4.toLowerCase());
                    if (!r3 || (i2 == 0 && !contains)) {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (i != 0 || this.llO.lkw.bjS().uC(24) || this.llO.lkC) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(268435456);
                    try {
                        this.llO.startActivity(intent);
                        return;
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
                        return;
                    }
                }
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
            }
        });
        this.igd.requestFocus(130);
        this.igd.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.llO.ljU != null && this.llO.ljU.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.llO, 2130968626);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass14 llU;

                        {
                            this.llU = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.llU.llO.ljU.setVisibility(8);
                        }
                    });
                    this.llO.ljU.startAnimation(loadAnimation);
                    this.llO.ljU.setVisibility(8);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                if (this.llO.igd != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
                    if (motionEvent.getPointerCount() > 1) {
                        this.llO.igd.getSettings().setBuiltInZoomControls(true);
                        this.llO.igd.getSettings().setSupportZoom(true);
                    } else {
                        this.llO.igd.getSettings().setBuiltInZoomControls(false);
                        this.llO.igd.getSettings().setSupportZoom(false);
                    }
                }
                return false;
            }
        });
        this.igd.getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.s.aW(this, this.igd.getSettings().getUserAgentString()));
        this.igd.bKn();
        this.eIV = new com.tencent.mm.ui.tools.l(this.nDR.nEl);
        this.eIV.a(this.igd, this, null);
        this.eIV.d(new OnCancelListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.llO.llc != null && this.llO.liH != null) {
                    try {
                        this.llO.liH.EN(this.llO.llc.lhm);
                        this.llO.llc.bji();
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "cancel capture failed");
                    }
                }
            }
        });
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.llO.axg();
                WebViewUI.T(this.llO);
                return true;
            }
        }, bkh());
        if (bki()) {
            final WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(2131756749);
            webViewKeyboardLinearLayout.nBa = new com.tencent.mm.ui.KeyboardLinearLayout.a(this) {
                final /* synthetic */ WebViewUI llO;

                public final void mC(int i) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + i);
                    if (i == -3) {
                        final int i2 = webViewKeyboardLinearLayout.ljl;
                        if (i2 > 0 && this.llO.bjX()) {
                            WebViewUI.b(this.llO, i2);
                        }
                        if (this.llO.igd.getX5WebViewExtension() != null || VERSION.SDK_INT >= 19) {
                            this.llO.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass32 lmM;

                                public final void run() {
                                    if (this.lmM.llO.lkl != null) {
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lmM.llO.lkl;
                                        int i = i2;
                                        Map hashMap = new HashMap();
                                        hashMap.put("height", Integer.valueOf(com.tencent.mm.bd.a.P(com.tencent.mm.sdk.platformtools.aa.getContext(), i)));
                                        ad.o(new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.AnonymousClass13(fVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("onGetKeyboardHeight", hashMap, fVar.loD, fVar.loE)));
                                    }
                                }
                            });
                        }
                        if (this.llO.ljZ != null && this.llO.ljZ.getVisibility() == 0) {
                            WebViewInputFooter as = this.llO.ljZ;
                            if (as.lsa) {
                                as.setVisibility(8);
                            }
                            as.state = 0;
                            as.SR();
                        }
                    } else {
                        WebViewUI.b(this.llO, 0);
                    }
                    this.llO.a(webViewKeyboardLinearLayout, i);
                }
            };
        }
        this.ljR = (MMFalseProgressBar) findViewById(2131756753);
        super.P(new Runnable(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void run() {
                WebViewUI.U(this.llO);
            }
        });
    }

    public int bkh() {
        return 2131165204;
    }

    public boolean bki() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.plugin.webview.e.c cVar = this.llA;
        if (i == 1) {
            if (cVar.lgI == null && cVar.lgJ == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
            } else {
                Uri uri;
                if (i2 == -1) {
                    String str = null;
                    if (intent != null) {
                        uri = null;
                        if (intent.getData() == null) {
                            Bundle extras = intent.getExtras();
                            if (extras != null) {
                                uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                            }
                        } else {
                            uri = intent.getData();
                        }
                        str = be.d(this, uri);
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[]{str});
                    }
                    if (be.kS(str)) {
                        File file = new File(com.tencent.mm.plugin.webview.d.ah.DX(cVar.lgH));
                        if (file.exists()) {
                            uri = Uri.fromFile(file);
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                            cVar.h(uri);
                            cVar.biW();
                        }
                    } else {
                        Object obj2;
                        String Ih = com.tencent.mm.pluginsdk.ui.tools.s.Ih(str);
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[]{Ih});
                        if (be.kS(cVar.lgG)) {
                            obj2 = 1;
                        } else {
                            for (String replace : cVar.lgG.split(",")) {
                                boolean z;
                                String replace2 = replace2.replace(" ", "");
                                if (be.kS(replace2)) {
                                    z = true;
                                } else {
                                    if (!be.kS(Ih)) {
                                        if (replace2.contains("/") && Ih.contains("/")) {
                                            String[] split = replace2.split("/");
                                            String[] split2 = Ih.split("/");
                                            if (be.ma(split[0]).equals(split2[0])) {
                                                z = be.ma(split[1]).equals("*") || be.ma(split[1]).equals(split2[1]);
                                            }
                                        } else {
                                            z = replace2.equals(Ih);
                                        }
                                    }
                                    z = false;
                                }
                                if (z) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            uri = intent.getData() == null ? Uri.fromFile(new File(str)) : intent.getData();
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                            cVar.h(uri);
                            cVar.biW();
                        }
                    }
                }
                uri = null;
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                cVar.h(uri);
                cVar.biW();
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null || !com.tencent.mm.plugin.webview.e.a.a(this, i, i2, intent)) {
        }
    }

    public final void Rj() {
        if (this.igd != null) {
            if (this.llC) {
                this.igd.setOnLongClickListener(this.llD);
            } else {
                this.igd.setOnLongClickListener(null);
            }
        }
        axg();
        super.Rj();
    }

    public final boolean bkj() {
        return true;
    }

    public final void onCancel() {
        if (this.igd != null) {
            if (this.llC) {
                this.igd.setOnLongClickListener(this.llD);
            } else {
                this.igd.setOnLongClickListener(null);
            }
        }
        super.onCancel();
    }

    public final void Rk() {
        if (this.igd != null) {
            this.igd.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        super.Rk();
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar, String str) {
        if (be.kS(str) || dVar == null) {
            return false;
        }
        return dVar.Fs(str);
    }

    public void aqj() {
        String EI;
        boolean z;
        int bjG;
        Map hashMap;
        Object obj;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw postBinded");
        bku();
        com.tencent.mm.plugin.webview.d.a aVar = this.llp;
        com.tencent.mm.plugin.webview.stub.d dVar = this.liH;
        try {
            EI = dVar.EI("DNSAdvanceOpen");
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[]{EI});
            if (be.kS(EI)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = EI.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    EI = dVar.EI("DNSAdvanceRelateDomain");
                    if (be.kS(EI)) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        aVar.vA().x(new com.tencent.mm.plugin.webview.d.a.AnonymousClass1(aVar, EI, dVar));
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        try {
            this.liH.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        EI = null;
        if (this.igd != null) {
            EI = this.igd.getTitle();
        }
        if (be.kS(EI)) {
            EI = getIntent().getStringExtra("title");
        }
        if (be.kS(EI)) {
            EI = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.d.ai.i biv = this.ldG.biv();
        biv.username = stringExtra;
        biv.lfj = intExtra;
        biv.bpX = this.bpX;
        biv.lfe = intExtra2;
        biv.scene = Fl(stringExtra);
        biv.lfd = longExtra;
        biv.lfg = new com.tencent.mm.a.o(longExtra).toString();
        biv.lfb = stringExtra2;
        biv.lfc = stringExtra3;
        biv.lff = stringExtra4;
        biv.appId = stringExtra5;
        biv.lfh = stringExtra6;
        biv.lfi = this.lfi;
        biv.jGu = string;
        biv.title = be.ah(EI, "");
        biv.bNx = stringExtra7;
        this.ldG.bix().bpX = this.bpX;
        if (bkp()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.liH.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!be.kS(stringExtra2)) {
            try {
                this.liH.EJ(stringExtra2);
            } catch (Exception e5) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
            } else {
                bjG = this.liH.bjG();
                if (bjG != -1) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", new Object[]{Integer.valueOf(bjG)});
                    getIntent().putExtra("pay_channel", bjG);
                }
            }
        } catch (Exception e6) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.lko.clear();
        MMWebView mMWebView = this.igd;
        e eVar = this.lkw;
        Map hashMap2 = new HashMap();
        hashMap2.put("webview_type", "1");
        hashMap2.put("init_url", this.bpX);
        hashMap2.put("init_font_size", "1");
        hashMap2.put("short_url", be.ma(getIntent().getStringExtra("shortUrl")));
        this.lkl = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(mMWebView, eVar, hashMap2, this.liH, hashCode());
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lkl;
        String stringExtra8 = getIntent().getStringExtra("geta8key_username");
        if (!be.kS(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (be.kS(stringExtra8)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra8);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(Fl(stringExtra8)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        if (!be.kS(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        fVar.loA = hashMap;
        this.lko.add(this.lkl);
        this.lko.add(new q());
        this.lko.add(new g());
        this.lko.add(new s());
        this.lko.add(new u());
        this.lko.add(new a());
        this.lko.add(new z());
        this.lko.add(new t());
        this.lko.add(new j());
        this.lko.add(new b());
        this.lko.add(new f());
        this.lko.add(new d());
        this.lko.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.g(this.igd, this.liH, hashCode(), this.lkl));
        this.lko.add(new y());
        this.lko.add(new v());
        this.lko.add(new o());
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.lko.add(new l());
        }
        this.lko.add(new h());
        try {
            bjG = be.getInt(this.liH.EI("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            bjG = 0;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[]{Integer.valueOf(bjG), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false))});
        if (bjG == 1 || r1) {
            this.llx.hx(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.llx.hx(true);
        }
        try {
            this.lkG = be.getInt(this.liH.EI("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", new Object[]{Integer.valueOf(this.lkG)});
        ai.y(this.igd.getX5WebViewExtension() != null, be.ma(this.bpX).startsWith("https://"));
        if (this.igd.getX5WebViewExtension() != null) {
            com.tencent.mm.pluginsdk.ui.tools.k.kZ(7);
            com.tencent.mm.plugin.report.service.g.iuh.ch(1, 0);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(64, 0, 1, false);
        }
        this.lkH = new com.tencent.mm.plugin.webview.ui.tools.jsapi.h(this.igd, this.lkl, new com.tencent.mm.plugin.webview.ui.tools.jsapi.h.a(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void bkG() {
                int V;
                int i = 2;
                boolean z = false;
                try {
                    if (this.llO.liH.bjs()) {
                        if (this.llO.bkr() || this.llO.bks()) {
                            V = this.llO.bkt();
                            if (V > 0 && V <= 4) {
                                i = V;
                            }
                            this.llO.te(i);
                            this.llO.z(true, true);
                            if (this.llO.igd != null && this.llO.lkw != null && this.llO.lkl != null) {
                                String url = this.llO.igd.getUrl();
                                if (!be.kS(url) && this.llO.lll.add(url)) {
                                    GeneralControlWrapper bjT = this.llO.lkw.bjT();
                                    boolean z2 = (bjT.lWs & 512) > 0;
                                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = " + z2);
                                    if (z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.llO.lkl;
                                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[]{Boolean.valueOf(fVar.loB)});
                                        if (fVar.lov != null && fVar.loB) {
                                            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("sys:get_all_hosts", new HashMap(), fVar.loD, fVar.loE) + ")", null);
                                        }
                                    }
                                    if ((bjT.lWs & 1024) > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = " + z2);
                                    if (z2) {
                                        this.llO.lkl.hF(false);
                                        return;
                                    }
                                    af o = this.llO.lls;
                                    if (!be.kS(url)) {
                                        url = Uri.parse(url).getHost();
                                        if (!be.kS(url)) {
                                            z = o.lez.remove(url);
                                        }
                                    }
                                    if (z) {
                                        this.llO.lkl.hF(true);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (be.kS(this.llO.bpX) || !com.tencent.mm.plugin.webview.a.lcG.matcher(this.llO.bpX).matches()) {
                            V = this.llO.liH.cN(16384, 2);
                            i = V;
                            this.llO.te(i);
                            this.llO.z(true, true);
                            if (this.llO.igd != null) {
                            }
                        } else {
                            V = this.llO.liH.cN(16388, 2);
                            i = V;
                            this.llO.te(i);
                            this.llO.z(true, true);
                            if (this.llO.igd != null) {
                            }
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
                }
                V = 2;
                i = V;
                this.llO.te(i);
                this.llO.z(true, true);
                if (this.llO.igd != null) {
                }
            }
        }, getIntent().getBooleanExtra("key_load_js_without_delay", false));
        try {
            bjG = be.getInt(this.liH.EI("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            bjG = 0;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "js digest verification config = %d", new Object[]{Integer.valueOf(bjG)});
        if (bjG == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && bkw()) {
            this.lkH.bll();
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            hz(false);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[]{Long.valueOf(System.currentTimeMillis())});
        } else {
            hz(getIntent().getBooleanExtra("showShare", true));
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z)});
        }
        this.ljU = LayoutInflater.from(this).inflate(2130904703, null);
        FontChooserView fontChooserView = (FontChooserView) this.ljU.findViewById(2131760066);
        View findViewById = this.ljU.findViewById(2131760067);
        if (this.igd.getX5WebViewExtension() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final void onClick(View view) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.llO, 2130968626);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass47 lmO;

                        {
                            this.lmO = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.lmO.llO.ljU.setVisibility(8);
                        }
                    });
                    this.llO.ljU.startAnimation(loadAnimation);
                    this.llO.ljU.setVisibility(8);
                }
            });
        }
        fontChooserView.lrq = new k();
        this.ljU.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.ljV.addView(this.ljU);
        this.ljU.setVisibility(8);
        bjG = 2;
        try {
            if (this.liH.bjs()) {
                bjG = (bkr() || bks()) ? bkt() : (be.kS(this.bpX) || !com.tencent.mm.plugin.webview.a.lcG.matcher(this.bpX).matches()) ? this.liH.cN(16384, 0) : this.liH.cN(16388, 0);
            }
        } catch (Exception e7) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (bjG <= 0 || bjG > 4) {
            bjG = 2;
        }
        te(bjG);
        tf(bjG);
        try {
            this.liH.a(this.bpX, true, null);
        } catch (Exception e52222) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 : this.lko) {
            if (a(dVar2, this.bpX)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "initView, url handled, result = " + dVar2.Fj(this.bpX) + ", url = " + this.bpX);
                return;
            }
        }
        if (bjO()) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            return;
        }
        stringExtra8 = getIntent().getStringExtra("data");
        if (stringExtra8 != null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.liH.EE(stringExtra8);
                } catch (Exception e522222) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.igd.setOnLongClickListener(this.llD);
            this.llC = true;
            this.igd.getSettings().setUseWideViewPort(false);
            this.igd.getSettings().setLoadWithOverviewMode(false);
            if (Fo(null)) {
                this.igd.getSettings().setJavaScriptEnabled(false);
                this.igd.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = " + stringExtra8);
                return;
            }
            com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
            bkf();
            return;
        }
        if (be.kS(this.bpX)) {
            eI(false);
        }
        if (this.bpX == null || this.bpX.length() == 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            return;
        }
        Uri parse = Uri.parse(this.bpX);
        if (parse == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "initView uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.bpX = "http://" + this.bpX;
        } else if (!parse.getScheme().startsWith("http")) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (Fo(this.bpX)) {
                this.igd.loadUrl(this.bpX);
                return;
            }
            com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.bpX);
            bkf();
            return;
        }
        this.lkx = new m(this.bpX);
        if (this.lkd || this.lkw.has(this.bpX)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.lkd);
            if (!Fo(this.bpX)) {
                com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.bpX);
                bkf();
                return;
            } else if (com.tencent.mm.plugin.webview.modelcache.u.a(this.bpX, this.liH, hashCode())) {
                this.lkX = true;
                this.ljR.finish();
                this.ljR.setVisibility(8);
                Ff(this.bpX);
                return;
            } else {
                this.igd.loadUrl(this.bpX);
                return;
            }
        }
        if (com.tencent.mm.plugin.webview.modelcache.u.a(this.bpX, this.liH, hashCode())) {
            Ff(this.bpX);
            this.llI = this.bpX;
            this.lkX = true;
            this.ljR.finish();
            this.ljR.setVisibility(8);
        }
        if (!this.lln && !this.llo && !isFinishing()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            h(this.bpX, false, -1);
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.bpX);
        }
    }

    private void Ff(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.igd.loadUrl(str, hashMap);
    }

    public final boolean bkk() {
        return false;
    }

    private boolean bkl() {
        boolean z = false;
        try {
            if (this.liH == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.liH.bjD();
            }
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + e.getMessage());
        }
        return z;
    }

    private boolean bjH() {
        boolean z = false;
        try {
            if (this.liH == null) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.liH.bjH();
            }
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
        }
        return z;
    }

    private static String Fg(String str) {
        String str2 = null;
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
        }
        return str2;
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.liH.isSDCardAvailable();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        contextMenu.setHeaderTitle(2131236680);
        try {
            isSDCardAvailable = this.liH.bjs();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "hasSetAcc = %b", new Object[]{Boolean.valueOf(isSDCardAvailable)});
        if (isSDCardAvailable) {
            contextMenu.add(0, 0, 0, getString(2131234310)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.llO, str, CookieManager.getInstance().getCookie(str), this.llO.liH.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass22 llW;

                            {
                                this.llW = r1;
                            }

                            public final void Fr(String str) {
                                if (be.kS(str)) {
                                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
                                } else {
                                    WebViewUI.e(this.llW.llO, str);
                                }
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getString(2131234727)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI llO;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean isSDCardAvailable;
                try {
                    isSDCardAvailable = this.llO.liH.isSDCardAvailable();
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    isSDCardAvailable = false;
                }
                try {
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.llO, str, CookieManager.getInstance().getCookie(str), isSDCardAvailable);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
                }
                return true;
            }
        });
        if (isSDCardAvailable) {
            contextMenu.add(0, 0, 0, getString(2131234180)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = this.llO.liH.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.llO, replaceAll, CookieManager.getInstance().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass25 lmE;

                            {
                                this.lmE = r1;
                            }

                            public final void Fr(String str) {
                                WebViewUI.f(this.lmE.llO, str);
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.lkZ == null) {
            return false;
        }
        final String str2 = this.lkZ;
        contextMenu.add(0, 0, 0, getString(2131234352)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI llO;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                try {
                    this.llO.liH.j(str2, this.llO.bkc(), this.llO.lla, this.llO.llb);
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
                } catch (RemoteException e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "recognize qbar result failed");
                }
                return false;
            }
        });
        this.lkZ = null;
        return true;
    }

    private void a(ContextMenu contextMenu, IX5WebViewBase.HitTestResult hitTestResult) {
        if (!a(contextMenu, ((ImageData) hitTestResult.getData()).mPicUrl) && this.lkw.bjT().brz() && bkl()) {
            this.lle = hitTestResult;
            this.llc = new com.tencent.mm.plugin.webview.e.f();
            this.llc.a(this.igd, this.llE);
        }
    }

    private void a(ContextMenu contextMenu, HitTestResult hitTestResult) {
        if (!a(contextMenu, hitTestResult.getExtra()) && this.lkw.bjT().brz() && bkl()) {
            this.lld = hitTestResult;
            this.llc = new com.tencent.mm.plugin.webview.e.f();
            this.llc.a(this.igd, this.llE);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (view instanceof android.webkit.WebView) {
            HitTestResult hitTestResult = this.igd.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    a(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof IX5WebViewBase) {
            IX5WebViewBase.HitTestResult hitTestResult2 = ((IX5WebViewBase) view).getHitTestResult();
            if (hitTestResult2 == null) {
                return;
            }
            if (hitTestResult2.getType() == 5 || hitTestResult2.getType() == 8) {
                a(contextMenu, hitTestResult2);
            }
        }
    }

    protected final String bkm() {
        String str = null;
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[]{e.getMessage()});
            if (e instanceof ClassNotFoundException) {
                finish();
                return str;
            }
        }
        if (str != null && str.length() > 0) {
            return str;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    private boolean bkn() {
        boolean z = false;
        try {
            z = this.liH.EH("favorite");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[z]);
        }
        return z;
    }

    private void bI(List<String> list) {
        Object er;
        Exception e;
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.lkD.get(str) != null) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "find %s icon from cache ok", new Object[]{str});
                } else {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", new Object[]{str});
                    try {
                        String ED = this.liH.ED(str);
                        if (!be.kS(ED)) {
                            Bitmap EW = d.EW(ED);
                            if (EW != null) {
                                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "load ok, and cache it");
                                this.lkD.put(str, EW);
                            }
                        }
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e2.getMessage());
                    }
                }
                if (this.lkE.containsKey(str)) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "find %s nick from cache ok", new Object[]{str});
                } else {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", new Object[]{str});
                    try {
                        er = this.liH.er(str);
                        try {
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "load nick ok");
                        } catch (Exception e3) {
                            e = e3;
                            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                            this.lkE.put(str, er);
                        }
                    } catch (Exception e22) {
                        Exception exception = e22;
                        er = null;
                        e = exception;
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                        this.lkE.put(str, er);
                    }
                    this.lkE.put(str, er);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.h.d.a> bko() {
        /*
        r12 = this;
        r0 = 0;
        r2 = 1;
        r3 = 0;
        r1 = r12.igd;
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        r1 = "MicroMsg.WebViewUI";
        r2 = "viewwv is null, maybe has destroyed";
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = r12.bpX;
        r1 = r12.igd;
        if (r1 == 0) goto L_0x00cc;
    L_0x0017:
        r1 = r12.igd;
        r1 = r1.getUrl();
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r5 != 0) goto L_0x00cc;
    L_0x0023:
        if (r1 == 0) goto L_0x0010;
    L_0x0025:
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x00b8 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = ".*(\\.wanggou\\.com|\\.jd\\.com)";
        r5 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.getHost();	 Catch:{ Exception -> 0x00b8 }
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0010;
    L_0x003b:
        r4 = ".";
        r4 = r1.startsWith(r4);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0054;
    L_0x0044:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b8 }
        r6 = ".";
        r4.<init>(r6);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b8 }
    L_0x0054:
        r4 = "MicroMsg.WebViewUI";
        r6 = "host = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00b8 }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.v.d(r4, r6, r7);	 Catch:{ Exception -> 0x00b8 }
        r1 = r5.matcher(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.matches();	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x006d:
        r1 = r12.llf;	 Catch:{ Exception -> 0x00b8 }
        if (r1 != 0) goto L_0x00a2;
    L_0x0071:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r1 = r12.liH;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.bjy();	 Catch:{ Exception -> 0x00b8 }
        r12.llf = r1;	 Catch:{ Exception -> 0x00b8 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "[hakon] getConfigListMap %b, cost %d";
        r1 = 2;
        r8 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00b8 }
        r9 = 0;
        r1 = r12.llf;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x00b6;
    L_0x008b:
        r1 = r2;
    L_0x008c:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b8 }
        r8[r9] = r1;	 Catch:{ Exception -> 0x00b8 }
        r1 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00b8 }
        r8[r1] = r4;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.v.d(r6, r7, r8);	 Catch:{ Exception -> 0x00b8 }
    L_0x00a2:
        r1 = r12.llf;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x00a6:
        r1 = r12.llf;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.size();	 Catch:{ Exception -> 0x00b8 }
        if (r1 <= 0) goto L_0x0010;
    L_0x00ae:
        r1 = r12.llf;	 Catch:{ Exception -> 0x00b8 }
        r0 = com.tencent.mm.h.d.j(r1);	 Catch:{ Exception -> 0x00b8 }
        goto L_0x0010;
    L_0x00b6:
        r1 = r3;
        goto L_0x008c;
    L_0x00b8:
        r1 = move-exception;
        r4 = "MicroMsg.WebViewUI";
        r5 = "[hakon] getJDMenuItems, ex = ";
        r2 = new java.lang.Object[r2];
        r1 = r1.getMessage();
        r2[r3] = r1;
        com.tencent.mm.sdk.platformtools.v.d(r4, r5, r2);
        goto L_0x0010;
    L_0x00cc:
        r1 = r4;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bko():java.util.LinkedList<com.tencent.mm.h.d$a>");
    }

    final boolean bkp() {
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        return (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) ? false : true;
    }

    public final void hz(boolean z) {
        this.llw = z;
        if (this.igd == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            return;
        }
        iT(z);
        iU(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            iU(booleanExtra);
        }
        int i = 2130838681;
        if (bko() != null) {
            i = 2131165685;
        }
        getIntent().getStringExtra("srcUsername");
        bkp();
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            a(0, i, new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI llO;

                {
                    this.llO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WebViewUI.C(this.llO);
                    return true;
                }
            });
        }
        hC(!z);
    }

    public void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (i == -3 && this.lkm != null) {
            boolean z = (this.lkw.bjT().lWs & 1) > 0;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + z);
            if (z && this.lkm.getVisibility() != 0) {
                if (this.lkn == null) {
                    this.lkn = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                        final /* synthetic */ WebViewUI llO;

                        {
                            this.llO = r1;
                        }

                        public final boolean oU() {
                            this.llO.bkq();
                            return false;
                        }
                    }, false);
                }
                this.lkn.ea(4000);
                View view = this.lkm;
                ((ImageView) view.findViewById(2131757701)).setImageResource(2131165761);
                TextView textView = (TextView) view.findViewById(2131757702);
                textView.setTextSize(14.0f);
                textView.setText(2131236662);
                ((ImageButton) view.findViewById(2131757703)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void onClick(View view) {
                        this.llO.bkq();
                    }
                });
                this.lkm.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.iuh.Y(13125, bkm());
            }
        }
    }

    private void bkq() {
        if (this.lkm != null) {
            this.lkm.setVisibility(8);
        }
        if (this.lkn != null) {
            this.lkn.QI();
        }
    }

    private void Fh(String str) {
        this.lkl.ay("sendAppMessage", false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lkl;
        if (fVar.loB) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:share:appmessage", hashMap, fVar.loD, fVar.loE) + ")", null);
            try {
                fVar.liH.w("connector_local_send", str, fVar.lhu);
                fVar.liH.w("scene", "enterprise", fVar.lhu);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
    }

    void tc(int i) {
        CharSequence Fk = Fk(this.llJ);
        if (TextUtils.isEmpty(this.llJ) || TextUtils.isEmpty(Fk)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "stev appId is null or empty");
            return;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "stev appId %s", new Object[]{Fk});
        long Nh = be.Nh();
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Nh), Fk, this.llJ, this.aZj, Integer.valueOf(3), Integer.valueOf(i)});
        String str = "";
        try {
            str = com.tencent.mm.compatible.util.p.encode(this.llJ, "UTF-8");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(13377, new Object[]{Long.valueOf(Nh), Fk, str, this.aZj, Integer.valueOf(3), Integer.valueOf(i)});
    }

    private void hA(boolean z) {
        if (findViewById(2131756754) != null) {
            if ((findViewById(2131756754).getVisibility() == 0) != z) {
                findViewById(2131756754).startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, z ? 2130968586 : 2130968587));
            }
            if (z) {
                findViewById(2131756754).setVisibility(0);
                this.ljS = (ImageButton) findViewById(2131756755);
                ImageButton imageButton = this.ljS;
                boolean z2 = this.igd != null && this.igd.canGoBack();
                imageButton.setEnabled(z2);
                this.ljS.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void onClick(View view) {
                        if (this.llO.igd != null) {
                            this.llO.igd.goBack();
                            this.llO.lkk = null;
                        }
                    }
                });
                this.ljT = (ImageButton) findViewById(2131756756);
                this.ljT.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void onClick(View view) {
                        if (this.llO.igd != null) {
                            this.llO.igd.reload();
                        }
                    }
                });
                return;
            }
            findViewById(2131756754).setVisibility(8);
        }
    }

    private void hB(boolean z) {
        if (this.ljT != null) {
            this.ljT.setEnabled(z);
        }
    }

    protected final void z(boolean z, boolean z2) {
        if (!bkx()) {
            iT(z);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[]{Boolean.valueOf(z)});
            setProgressBarIndeterminateVisibility(false);
            if (z2) {
                this.ljR.finish();
            } else if (!this.lkX) {
                this.ljR.start();
            }
        }
    }

    public void Fi(String str) {
        if (this.lkw.bjT().bry()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.liH.a(str, this.lkw.bjS().uC(7), bundle)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + str);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    }

    public boolean Fj(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar : this.lko) {
            if (a(dVar, str)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "url handled, url = " + str);
                if (this.llH.equals(str)) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    return true;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "url handled, ret = " + dVar.Fj(str) + ", url = " + str);
                return true;
            }
        }
        return false;
    }

    private String Fk(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || this.liH == null) {
            return str2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("webview_binder_id", hashCode());
        bundle.putString("rawUrl", str);
        try {
            str2 = be.ma(this.liH.i(76, bundle).getString("appId"));
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[]{str2});
            return str2;
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public final void f(String str, long j, int i) {
        Throwable e;
        CharSequence Fk = Fk(this.llJ);
        if (this.fromScene != 0) {
            this.dPT = " ";
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[]{Boolean.valueOf(this.lkw.bjT().brA())});
        if (this.dPR > 0 && this.dPP > this.dPR && j > this.dPP && !TextUtils.isEmpty(Fk) && r4) {
            String encode;
            long j2 = this.dPP - this.dPR;
            long j3 = j - this.dPP;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[]{Integer.valueOf(13376), Long.valueOf(this.dPR), Fk, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.lkb, this.llJ, this.aZj, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.dPT});
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = com.tencent.mm.compatible.util.p.encode(be.ma(this.lkb), "UTF-8");
                str3 = com.tencent.mm.compatible.util.p.encode(be.ma(this.llJ), "UTF-8");
                encode = com.tencent.mm.compatible.util.p.encode(be.ma(str), "UTF-8");
                try {
                    str5 = com.tencent.mm.compatible.util.p.encode(be.ma(this.dPT), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.iuh.h(13376, new Object[]{Long.valueOf(this.dPR), Fk, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.aZj, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                    this.fromScene = 0;
                    if (i != 1) {
                        this.dPT = this.llJ;
                        this.llJ = str;
                        this.dPR = j;
                    }
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                encode = str4;
                e = th;
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
                com.tencent.mm.plugin.report.service.g.iuh.h(13376, new Object[]{Long.valueOf(this.dPR), Fk, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.aZj, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                this.fromScene = 0;
                if (i != 1) {
                    this.dPT = this.llJ;
                    this.llJ = str;
                    this.dPR = j;
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(13376, new Object[]{Long.valueOf(this.dPR), Fk, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.aZj, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
            this.fromScene = 0;
        }
        if (i != 1) {
            this.dPT = this.llJ;
            this.llJ = str;
            this.dPR = j;
        }
    }

    private w h(String str, boolean z, int i) {
        if (this.lln || this.llo || isFinishing()) {
            return w.FAILED;
        }
        if (this.lkT != null) {
            this.lkT.setVisibility(8);
        }
        if (this.lkw == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            return w.FAILED;
        } else if (this.lkd) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.lkw.a(str, null, null);
            return w.NO_NEED;
        } else {
            int i2;
            boolean z2;
            if (this.liH != null && this.lkY.contains(str) && com.tencent.mm.plugin.webview.modelcache.u.a(str, this.liH, hashCode())) {
                i2 = 1;
            } else {
                z2 = false;
            }
            if ((this.lkw.has(str) || r0 != 0) && !z) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                return w.NO_NEED;
            }
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int Fl = Fl(stringExtra);
            if (i == -1) {
                i2 = this.lkx.Ft(str);
            } else {
                i2 = i;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = " + str + ", scene = " + Fl + ", username = " + stringExtra + ", reason = " + i2 + ", force = " + z);
            if (i != 5) {
                z(false, false);
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
            this.lkY.add(str);
            this.lkw.a(str, null, null);
            this.lky.bkL();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", Fl);
            bundle.putInt("geta8key_data_reason", i2);
            if (this.igd.getX5WebViewExtension() != null) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", ai.biq());
            this.lkk = str;
            try {
                z2 = this.liH.l(233, bundle);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
                z2 = false;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + z2);
            com.tencent.mm.plugin.webview.d.ai.j bis = this.ldG.bis();
            int i3 = this.bsZ;
            stringExtra = this.bnX;
            bis.bsZ = i3;
            bis.leY = stringExtra;
            if (be.kS(str)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!bis.lfl.containsKey(str)) {
                bis.lfl.put(str, Long.valueOf(be.Ni()));
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(154, 11, 1, false);
            return w.WILL_GET;
        }
    }

    private int Fl(String str) {
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.liH == null) {
                intExtra = 1;
            } else {
                try {
                    intExtra = this.liH.fn(str) ? 8 : this.liH.eD(str) ? 7 : 1;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e.getMessage());
                    intExtra = 1;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    private boolean Fm(String str) {
        if (be.kS(str)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            return false;
        }
        ta(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        try {
            this.liH.l(106, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        return true;
    }

    private boolean Fn(String str) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (this.liH.bv(str)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + str);
                this.liH.bk(str, hashCode());
                return true;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            if (str.startsWith("tel:")) {
                String replace = str.replace("tel:", "");
                if (be.kS(replace)) {
                    return true;
                }
                try {
                    this.liH.bm(replace, hashCode());
                    return true;
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[]{e2.getMessage()});
                    return true;
                }
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                r2 = new Intent("android.intent.action.SENDTO", parse);
                r2.addFlags(268435456);
                try {
                    startActivity(r2);
                    return true;
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[]{e22.getMessage()});
                    return true;
                }
            } else {
                try {
                    boolean z = (this.lkw.bjT().lWs & 8) > 0;
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + z);
                    if (!(z || this.liH == null || !this.liH.bjs())) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                        return true;
                    }
                } catch (Throwable e3) {
                    com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e3, "", new Object[0]);
                }
                r2 = new Intent("android.intent.action.VIEW", parse);
                r2.addFlags(268435456);
                if (be.m(this.nDR.nEl, r2)) {
                    startActivity(r2);
                    return true;
                }
            }
        }
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!be.kS(str2)) {
            this.lkw.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.lkY.remove(str2);
        }
        if (dc(str, str2)) {
            this.lkw.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.lkY.remove(str);
        } else if (this.liH != null && !be.kS(str) && com.tencent.mm.plugin.webview.modelcache.u.a(str2, this.liH, hashCode())) {
            this.lkw.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.lkY.remove(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void b(com.tencent.mm.plugin.webview.stub.c r12) {
        /*
        r11 = this;
        r0 = "MicroMsg.WebViewUI";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd, instance hashcode = ";
        r1.<init>(r2);
        r2 = r11.hashCode();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = r11.igd;
        if (r0 != 0) goto L_0x0028;
    L_0x001e:
        r0 = "MicroMsg.WebViewUI";
        r1 = "onSceneEnd, viewWV is null, do nothing";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
    L_0x0027:
        return;
    L_0x0028:
        r0 = r11.isFinishing();
        if (r0 != 0) goto L_0x0032;
    L_0x002e:
        r0 = r11.lkw;
        if (r0 != 0) goto L_0x003c;
    L_0x0032:
        r0 = "MicroMsg.WebViewUI";
        r1 = "onSceneEnd, isFinishing, do nothing";
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x0027;
    L_0x003c:
        r3 = 0;
        r2 = -1;
        r1 = -1;
        r4 = 0;
        r3 = r12.getType();	 Catch:{ Exception -> 0x00bc }
        r2 = r12.bjm();	 Catch:{ Exception -> 0x00bc }
        r1 = r12.bjn();	 Catch:{ Exception -> 0x00bc }
        r12.Ch();	 Catch:{ Exception -> 0x00bc }
        r0 = r12.getData();	 Catch:{ Exception -> 0x00bc }
    L_0x0053:
        if (r0 != 0) goto L_0x005a;
    L_0x0055:
        r0 = new android.os.Bundle;
        r0.<init>();
    L_0x005a:
        r4 = "scene_end_listener_hash_code";
        r4 = r0.getInt(r4);
        r5 = "MicroMsg.WebViewUI";
        r6 = "get hash code = %d, self hash code = %d";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r4);
        r7[r8] = r9;
        r8 = 1;
        r9 = r11.hashCode();
        r9 = java.lang.Integer.valueOf(r9);
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r5, r6, r7);
        r5 = "MicroMsg.WebViewUI";
        r6 = new java.lang.StringBuilder;
        r7 = "edw onSceneEnd, type = ";
        r6.<init>(r7);
        r6 = r6.append(r3);
        r7 = ", errCode = ";
        r6 = r6.append(r7);
        r6 = r6.append(r1);
        r7 = ", errType = ";
        r6 = r6.append(r7);
        r6 = r6.append(r2);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.v.i(r5, r6);
        r5 = r11.hashCode();
        if (r4 == r5) goto L_0x00da;
    L_0x00b1:
        r0 = "MicroMsg.WebViewUI";
        r1 = "hash code not equal";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0027;
    L_0x00bc:
        r0 = move-exception;
        r5 = "MicroMsg.WebViewUI";
        r6 = new java.lang.StringBuilder;
        r7 = "onSceneEnd, ex = ";
        r6.<init>(r7);
        r0 = r0.getMessage();
        r0 = r6.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r5, r0);
        r0 = r4;
        goto L_0x0053;
    L_0x00da:
        r4 = 233; // 0xe9 float:3.27E-43 double:1.15E-321;
        if (r3 == r4) goto L_0x00f2;
    L_0x00de:
        r4 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        if (r3 == r4) goto L_0x00f2;
    L_0x00e2:
        r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r3 == r4) goto L_0x00f2;
    L_0x00e6:
        r4 = 673; // 0x2a1 float:9.43E-43 double:3.325E-321;
        if (r3 == r4) goto L_0x00f2;
    L_0x00ea:
        r4 = 666; // 0x29a float:9.33E-43 double:3.29E-321;
        if (r3 == r4) goto L_0x00f2;
    L_0x00ee:
        r4 = 1080; // 0x438 float:1.513E-42 double:5.336E-321;
        if (r3 != r4) goto L_0x0027;
    L_0x00f2:
        switch(r3) {
            case 106: goto L_0x00f7;
            case 233: goto L_0x00fc;
            case 666: goto L_0x02bb;
            case 673: goto L_0x0267;
            case 1080: goto L_0x02d3;
            default: goto L_0x00f5;
        };
    L_0x00f5:
        goto L_0x0027;
    L_0x00f7:
        r11.finish();
        goto L_0x0027;
    L_0x00fc:
        r3 = r11.lky;
        r3.bkM();
        r3 = new com.tencent.mm.protocal.JsapiPermissionWrapper;
        r4 = "geta8key_result_jsapi_perm_control_bytes";
        r4 = r0.getByteArray(r4);
        r3.<init>(r4);
        r4 = new com.tencent.mm.protocal.GeneralControlWrapper;
        r5 = "geta8key_result_general_ctrl_b1";
        r5 = r0.getInt(r5);
        r4.<init>(r5);
        r5 = "geta8key_result_deep_link_bit_set";
        r6 = 0;
        r6 = r0.getLong(r5, r6);
        r11.llL = r6;
        r5 = "geta8key_result_reason";
        r10 = r0.getInt(r5);
        r5 = "MicroMsg.WebViewUI";
        r6 = new java.lang.StringBuilder;
        r7 = "edw geta8key onSceneEnd, req reason = ";
        r6.<init>(r7);
        r6 = r6.append(r10);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.v.i(r5, r6);
        r9 = 0;
        switch(r10) {
            case 0: goto L_0x0163;
            case 1: goto L_0x01f7;
            case 2: goto L_0x0163;
            case 3: goto L_0x0145;
            case 4: goto L_0x0145;
            case 5: goto L_0x01f7;
            default: goto L_0x0145;
        };
    L_0x0145:
        r0 = r9;
    L_0x0146:
        r1 = r11.lkw;
        r1 = r1.EZ(r0);
        r2 = 34;
        r1 = r1.uC(r2);
        r2 = r11.lkw;
        r0 = r2.EZ(r0);
        r2 = 75;
        r0 = r0.uC(r2);
        r11.A(r1, r0);
        goto L_0x0027;
    L_0x0163:
        if (r2 != 0) goto L_0x0167;
    L_0x0165:
        if (r1 == 0) goto L_0x016e;
    L_0x0167:
        r5 = 4;
        if (r2 != r5) goto L_0x0195;
    L_0x016a:
        r5 = -2005; // 0xfffffffffffff82b float:NaN double:NaN;
        if (r1 != r5) goto L_0x0195;
    L_0x016e:
        r1 = "geta8key_result_full_url";
        r1 = r0.getString(r1);
        r2 = "geta8key_result_req_url";
        r2 = r0.getString(r2);
        r11.a(r2, r1, r3, r4);
        r11.L(r0);
        r0 = 24;
        r0 = r3.uC(r0);
        r11.lkC = r0;
        r0 = r11.ldG;
        r0 = r0.bix();
        r2 = 1;
        r0.leR = r2;
        r0 = r1;
        goto L_0x0146;
    L_0x0195:
        r1 = com.tencent.mm.plugin.webview.ui.tools.g.pRr;
        r1.zT(r2);
        r1 = "geta8key_result_req_url";
        r0 = r0.getString(r1);
        r1 = r11.lkT;
        if (r1 == 0) goto L_0x01bc;
    L_0x01a5:
        r1 = r11.liH;
        r2 = r11.hashCode();
        r1 = com.tencent.mm.plugin.webview.modelcache.u.a(r0, r1, r2);
        if (r1 != 0) goto L_0x01bc;
    L_0x01b1:
        r1 = r11.lkT;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = 1;
        r2 = 1;
        r11.z(r1, r2);
    L_0x01bc:
        r1 = r11.ldG;
        r1 = r1.bix();
        r2 = 0;
        r1.leR = r2;
        r1 = r11.ldG;
        r1 = r1.bis();
        r2 = 0;
        r1.aw(r0, r2);
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r4 = 12;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r0 = com.tencent.mm.plugin.webview.ui.tools.a.sU(r10);
        r1 = -1;
        if (r1 == r0) goto L_0x01ed;
    L_0x01e2:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r4 = (long) r0;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
    L_0x01ed:
        r0 = r11.lki;
        if (r0 == 0) goto L_0x01f4;
    L_0x01f1:
        r11.finish();
    L_0x01f4:
        r0 = r9;
        goto L_0x0146;
    L_0x01f7:
        if (r2 != 0) goto L_0x0222;
    L_0x01f9:
        if (r1 != 0) goto L_0x0222;
    L_0x01fb:
        r1 = "geta8key_result_req_url";
        r0 = r0.getString(r1);
        r1 = r11.lkw;
        r1.a(r0, r3, r4);
        r1 = r11.lkY;
        r1.remove(r0);
        r1 = r11.llj;
        if (r1 == 0) goto L_0x0218;
    L_0x0210:
        r1 = 1;
        r2 = 1;
        r11.z(r1, r2);
        r1 = 0;
        r11.llj = r1;
    L_0x0218:
        r1 = 24;
        r1 = r3.uC(r1);
        r11.lkC = r1;
        goto L_0x0146;
    L_0x0222:
        r5 = 4;
        if (r2 != r5) goto L_0x0245;
    L_0x0225:
        r2 = -2005; // 0xfffffffffffff82b float:NaN double:NaN;
        if (r1 != r2) goto L_0x0245;
    L_0x0229:
        r1 = r11.igd;
        r1.stopLoading();
        r1 = "geta8key_result_full_url";
        r1 = r0.getString(r1);
        r2 = "geta8key_result_req_url";
        r2 = r0.getString(r2);
        r11.a(r2, r1, r3, r4);
        r11.L(r0);
        r0 = r1;
        goto L_0x0146;
    L_0x0245:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r4 = 12;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r0 = com.tencent.mm.plugin.webview.ui.tools.a.sU(r10);
        r4 = (long) r0;
        r6 = 1;
        r8 = 0;
        r1.a(r2, r4, r6, r8);
        r0 = 1;
        r1 = 1;
        r11.z(r0, r1);
        goto L_0x0145;
    L_0x0267:
        r3 = r11.lkz;
        r4 = r3.lnd;
        r4 = r4 + -1;
        r3.lnd = r4;
        r4 = r3.lnd;
        if (r4 > 0) goto L_0x027a;
    L_0x0273:
        r3 = r3.llO;
        r4 = 673; // 0x2a1 float:9.43E-43 double:3.325E-321;
        r3.tb(r4);
    L_0x027a:
        if (r2 != 0) goto L_0x02b0;
    L_0x027c:
        if (r1 != 0) goto L_0x02b0;
    L_0x027e:
        if (r0 == 0) goto L_0x02a7;
    L_0x0280:
        r1 = "reading_mode_result_url";
        r0 = r0.getString(r1);
    L_0x0287:
        r1 = "MicroMsg.WebViewUI";
        r2 = "[cpan] onsceneend url:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r1 == 0) goto L_0x02a9;
    L_0x029c:
        r0 = "MicroMsg.WebViewUI";
        r1 = "[cpan] onsceneend failed";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0027;
    L_0x02a7:
        r0 = 0;
        goto L_0x0287;
    L_0x02a9:
        r1 = r11.igd;
        r1.loadUrl(r0);
        goto L_0x0027;
    L_0x02b0:
        r0 = "MicroMsg.WebViewUI";
        r1 = "[cpan] onsceneend failed";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0027;
    L_0x02bb:
        r0 = r11.lkA;
        r1 = r0.lne;
        r1 = r1 + -1;
        r0.lne = r1;
        r1 = r0.lne;
        if (r1 > 0) goto L_0x02ce;
    L_0x02c7:
        r0 = r0.llO;
        r1 = 666; // 0x29a float:9.33E-43 double:3.29E-321;
        r0.tb(r1);
    L_0x02ce:
        r11.finish();
        goto L_0x0027;
    L_0x02d3:
        r1 = r11.lkB;
        r2 = r1.lmR;
        r2 = r2 + -1;
        r1.lmR = r2;
        r2 = r1.lmR;
        if (r2 > 0) goto L_0x02e6;
    L_0x02df:
        r1 = r1.llO;
        r2 = 1080; // 0x438 float:1.513E-42 double:5.336E-321;
        r1.tb(r2);
    L_0x02e6:
        r1 = "key_async_url_check_res_attribute";
        r2 = 0;
        r1 = r0.getInt(r1, r2);
        r2 = "key_async_url_check_url";
        r0 = r0.getString(r2);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r2 != 0) goto L_0x0027;
    L_0x02fb:
        r2 = "MicroMsg.WebViewUI";
        r3 = "check url attr res url[%s] attr[%d]";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r1);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = r11.lkP;
        r1 = java.lang.Integer.valueOf(r1);
        r2.put(r0, r1);
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b(com.tencent.mm.plugin.webview.stub.c):void");
    }

    private void A(boolean z, boolean z2) {
        if (z) {
            vE(2131236646);
            if (!this.lkg) {
                int i;
                if (com.tencent.mm.sdk.platformtools.aa.btk().getInt("enter_web_pay_over_time", 2) <= 0) {
                    i = 0;
                } else {
                    i = com.tencent.mm.sdk.platformtools.aa.btl().getInt("enter_web_pay_over_time", 2);
                    if (i > 0) {
                        Editor edit = com.tencent.mm.sdk.platformtools.aa.btl().edit();
                        edit.putInt("enter_web_pay_over_time", i - 1);
                        edit.commit();
                    }
                }
                switch (i) {
                    case 1:
                        td(2130904689);
                        break;
                    case 2:
                        td(2130904690);
                        break;
                }
                this.lkg = true;
            }
        } else if (z2) {
            vE(2131236654);
        } else {
            NY(null);
        }
    }

    private void td(int i) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "showUserEdPage");
        this.llK = new com.tencent.mm.ui.base.i(this, 2131559266);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, null);
        ImageView imageView;
        if (i == 2130904689) {
            imageView = (ImageView) linearLayout.findViewById(2131760037);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(2131760036);
            try {
                if (this.liH.bjC()) {
                    imageView2.setImageResource(2130838864);
                } else {
                    imageView2.setImageResource(2130838850);
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            try {
                String ED = this.liH.ED(this.liH.am(2, null));
                if (!be.kS(ED)) {
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(d.EW(ED), false, 1.0f);
                    if (!(a == null || a.isRecycled())) {
                        imageView.setImageBitmap(a);
                    }
                }
            } catch (RemoteException e2) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", e2.toString());
            }
        } else if (i == 2130904690) {
            imageView = (ImageView) linearLayout.findViewById(2131760038);
            try {
                if (this.liH.bjC()) {
                    imageView.setImageResource(2130838865);
                } else {
                    imageView.setImageResource(2130838851);
                }
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WebViewUI", e3, "", new Object[0]);
            }
        }
        linearLayout.setMinimumWidth(10000);
        TextView textView = (TextView) linearLayout.findViewById(2131756397);
        this.llK.getWindow();
        this.llK.setCanceledOnTouchOutside(true);
        this.llK.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.llK.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewUI llO;

            {
                this.llO = r1;
            }

            public final void onClick(View view) {
                this.llO.llK.dismiss();
            }
        });
        this.llK.setContentView(linearLayout);
        this.llK.show();
    }

    private void h(String str, Map<String, String> map) {
        String ah = be.ah(bkc(), this.bpX);
        if (be.kS(ah)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            this.igd.loadUrl(str);
        } else if (this.lkl == null) {
            if (map.size() > 0) {
                this.igd.loadUrl(str, map);
            } else {
                this.igd.loadUrl(str);
            }
        } else if (!be.ma(str).contains("#wechat_redirect")) {
            if (!dc(ah, str)) {
                String Ep = com.tencent.mm.plugin.webview.modelcache.v.Ep(ah);
                String Ep2 = com.tencent.mm.plugin.webview.modelcache.v.Ep(str);
                Object obj = (be.kS(Ep2) || be.kS(Ep) || !Ep2.equals(Ep) || this.liH == null || !com.tencent.mm.plugin.webview.modelcache.u.a(ah, this.liH, hashCode())) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.igd.loadUrl(str, map);
                        return;
                    } else {
                        this.igd.loadUrl(str);
                        return;
                    }
                }
            }
            this.llk.put(ah, str);
            this.lkl.Fw(str);
        } else if (map.size() > 0) {
            this.igd.loadUrl(str, map);
        } else {
            this.igd.loadUrl(str);
        }
    }

    private boolean dc(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.lcG.matcher(str).matches() && com.tencent.mm.plugin.webview.a.lcG.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.liH != null && com.tencent.mm.plugin.webview.modelcache.u.a(str, this.liH, hashCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean L(Bundle bundle) {
        String str;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[]{Integer.valueOf(i), string, string2, string3});
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "add http header key = %s, value = %s", new Object[]{stringArray[i2], stringArray2[i2]});
            }
        }
        if (be.kS(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        ai.y(this.igd.getX5WebViewExtension() != null, be.ma(str).startsWith("https://"));
        this.ldG.bis().aw(string4, true);
        com.tencent.mm.plugin.webview.d.ai.d biu = this.ldG.biu();
        int i3 = this.bsZ;
        String str2 = this.bnX;
        biu.bsZ = i3;
        biu.leY = str2;
        if (be.kS(string2)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            biu.ldY = string2;
            biu.leX = true;
            if (!biu.leV.containsKey(string2)) {
                biu.leV.put(string2, Long.valueOf(be.Ni()));
            }
            if (!biu.leW.containsKey(string2)) {
                biu.leW.put(string2, Long.valueOf(be.Ni()));
            }
        }
        switch (i) {
            case 1:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    return false;
                }
                this.igd.getSettings().setJavaScriptEnabled(false);
                this.igd.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    Fd(string);
                }
                if (Fo(string2)) {
                    h(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                bkf();
                return true;
            case 3:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getA8key-app: " + string2);
                if (string2 != null && string2.length() != 0) {
                    return Fn(string2);
                }
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                return false;
            case 4:
                return Fm(string2);
            case 6:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (Fo(string2)) {
                    this.igd.loadUrl(string2);
                    hz(false);
                    return true;
                } else {
                    com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    bkf();
                    return true;
                }
            case 7:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    Fd(string);
                }
                if (Fo(string2)) {
                    h(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.v.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + string2);
                bkf();
                return true;
            case 20:
                if (be.kS(string2)) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    r rVar = this.lkA;
                    if (rVar.lne == 0) {
                        rVar.llO.ta(666);
                    }
                    rVar.lne++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    try {
                        this.liH.l(666, bundle2);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                return true;
            default:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    public boolean bkr() {
        return false;
    }

    public boolean bks() {
        return false;
    }

    private int bkt() {
        float f = this.nDR.nEl.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bti(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            return 1;
        }
        if (f == 1.125f) {
            return 3;
        }
        if (f == 1.25f || f == 1.375f) {
            return 4;
        }
        return 2;
    }

    private void te(int i) {
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.lkl != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.f fVar = this.lkl;
            if (fVar.loB) {
                Map hashMap = new HashMap();
                hashMap.put("fontSize", String.valueOf(i));
                fVar.lov.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.k.a.a("menu:setfont", hashMap, fVar.loD, fVar.loE) + ")", null);
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            }
        }
        FontChooserView fontChooserView = (FontChooserView) this.ljU.findViewById(2131760066);
        if (fontChooserView != null) {
            fontChooserView.iNI = i - 1;
        }
    }

    private void tf(int i) {
        if (this.igd != null && this.igd.getSettings() != null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + i);
            switch (i) {
                case 1:
                    this.igd.getSettings().setTextSize(TextSize.SMALLER);
                    return;
                case 3:
                    this.igd.getSettings().setTextSize(TextSize.LARGER);
                    return;
                case 4:
                    this.igd.getSettings().setTextSize(TextSize.LARGEST);
                    return;
                default:
                    this.igd.getSettings().setTextSize(TextSize.NORMAL);
                    return;
            }
        }
    }

    private final boolean Fo(String str) {
        if (com.tencent.mm.platformtools.q.dqg) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            return true;
        } else if (be.kS(str)) {
            return true;
        } else {
            if (this.lka) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[]{str});
                return true;
            }
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("file://")) {
                for (String ds : lee) {
                    if (com.tencent.mm.pluginsdk.ui.tools.s.ds(toLowerCase, ds)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (be.kS(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(com.tencent.mm.pluginsdk.ui.tools.s.bre());
        }
    }

    @TargetApi(11)
    private void bku() {
        if (com.tencent.mm.compatible.util.d.dX(11)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
        } else if (this.igd == null || this.liH == null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        } else {
            int i;
            try {
                this.igd.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
            }
            if (this.llM == null) {
                try {
                    if (this.liH.bjs()) {
                        this.llM = this.liH.sO();
                    }
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[]{e2.getMessage()});
                }
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "removeConfigJsInterface, to remove list size = %d";
            Object[] objArr = new Object[1];
            if (this.llM == null) {
                i = 0;
            } else {
                i = this.llM.length;
            }
            objArr[0] = Integer.valueOf(i);
            com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
            if (this.llM != null && this.llM.length != 0) {
                try {
                    for (String str3 : this.llM) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[]{str3});
                        this.igd.removeJavascriptInterface(str3);
                    }
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e22.getMessage()});
                }
            }
        }
    }

    private boolean bkv() {
        if (this.lkQ != null) {
            boolean z;
            e eVar = this.lkQ;
            if (be.kS(eVar.lmS)) {
                z = false;
            } else {
                z = eVar.lmS.equals("true");
            }
            if (!(!z || be.kS(this.lkQ.bkI()) || be.kS(this.lkQ.bkJ()) || be.kS(this.lkQ.bkK()))) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[]{this.lkQ.bkI(), this.lkQ.bkJ(), this.lkQ.bkK()});
                View inflate = View.inflate(this.nDR.nEl, 2130903966, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(2131758198);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(2131758197);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(2131689909));
                textView = (TextView) inflate.findViewById(2131758199);
                textView.setTextColor(getResources().getColor(2131689909));
                textView.setVisibility(8);
                this.lkR = com.tencent.mm.ui.base.g.a(this.nDR.nEl, true, "", inflate, r4, r5, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (checkBox != null && checkBox.isChecked()) {
                            try {
                                if (this.llO.liH.bjs()) {
                                    this.llO.liH.cO(327792, 1);
                                }
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
                            }
                        }
                        this.llO.lln = true;
                        this.llO.lkR = null;
                        g.pRr.close();
                        this.llO.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WebViewUI llO;

                    {
                        this.llO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.llO.lkR = null;
                    }
                });
                return true;
            }
        }
        return false;
    }

    public void eI(boolean z) {
    }

    public void k(int i, Bundle bundle) {
    }

    public boolean bkw() {
        return true;
    }

    public void m(int i, Bundle bundle) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    }

    public void n(int i, Bundle bundle) {
    }

    public final void hC(boolean z) {
        String url = this.igd.getUrl();
        if (z) {
            V(0, false);
            this.lkO.put(url, Boolean.valueOf(true));
            return;
        }
        V(0, true);
        if (this.lkO.containsKey(url)) {
            this.lkO.remove(url);
        }
    }

    public boolean bkx() {
        return false;
    }
}
