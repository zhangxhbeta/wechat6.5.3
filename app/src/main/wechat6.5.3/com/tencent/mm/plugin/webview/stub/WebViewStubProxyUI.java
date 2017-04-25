package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.py;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

@a(7)
public class WebViewStubProxyUI extends MMActivity {
    public static boolean lhs = false;
    private ah aSW = new ah(new ah.a(this) {
        final /* synthetic */ WebViewStubProxyUI lhz;

        {
            this.lhz = r1;
        }

        public final boolean oU() {
            if (this.lhz.getWindow() != null && this.lhz.getWindow().getDecorView() != null && this.lhz.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.e(this.lhz);
                this.lhz.lht = true;
                return false;
            } else if (this.lhz.fNP < 10) {
                WebViewStubProxyUI.d(this.lhz);
                return true;
            } else {
                v.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                this.lhz.finish();
                return false;
            }
        }
    }, true);
    private int fNP = 0;
    private e leB = null;
    private boolean lht = false;
    private int lhu;
    private final e lhv = new e(this) {
        final /* synthetic */ WebViewStubProxyUI lhz;

        {
            this.lhz = r1;
        }

        public final IBinder asBinder() {
            return null;
        }

        public final boolean sM(int i) {
            this.lhz.leB.sM(i);
            return false;
        }

        public final boolean g(int i, Bundle bundle) {
            this.lhz.leB.g(i, bundle);
            return false;
        }

        public final boolean a(c cVar) {
            this.lhz.leB.a(cVar);
            return false;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            v.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.lhs = WebViewStubProxyUI.EA(str2);
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            this.lhz.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 lhE;

                public final void run() {
                    j.tl(this.lhE.lhz.lhu).a(null, null, null);
                    this.lhE.lhz.finish();
                    try {
                        this.lhE.lhz.leB.a(str3, str4, bundle2, z2);
                    } catch (Exception e) {
                        v.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                    }
                }
            });
            return false;
        }

        public final String bjo() {
            return this.lhz.leB.bjo();
        }

        public final String Ra() {
            return this.lhz.leB.Ra();
        }

        public final String bjp() {
            return this.lhz.leB.bjp();
        }

        public final void hu(boolean z) {
            this.lhz.leB.hu(z);
        }

        public final void hv(boolean z) {
            this.lhz.leB.hv(z);
        }

        public final void h(int i, Bundle bundle) {
            this.lhz.leB.h(i, bundle);
        }

        public final void bjq() {
            this.lhz.leB.bjq();
        }

        public final void B(Bundle bundle) {
            this.lhz.leB.B(bundle);
        }

        public final void EB(String str) {
            this.lhz.leB.EB(str);
        }

        public final void bjr() {
            if (this.lhz.leB != null) {
                this.lhz.leB.bjr();
            }
        }

        public final void i(String str, String str2, int i, int i2) {
        }

        public final void da(String str, String str2) {
            this.lhz.leB.da(str, str2);
        }

        public final Bundle i(int i, Bundle bundle) {
            return this.lhz.leB.i(i, bundle);
        }

        public final void C(Bundle bundle) {
            this.lhz.leB.C(bundle);
        }

        public final void hw(boolean z) {
            this.lhz.leB.hw(z);
        }
    };
    private OnDismissListener lhw = new OnDismissListener(this) {
        final /* synthetic */ WebViewStubProxyUI lhz;

        {
            this.lhz = r1;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.lhz.isFinishing()) {
                this.lhz.finish();
            }
        }
    };
    private ah lhx = new ah(new ah.a(this) {
        final /* synthetic */ WebViewStubProxyUI lhz;

        {
            this.lhz = r1;
        }

        public final boolean oU() {
            if (!this.lhz.isFinishing()) {
                this.lhz.finish();
            }
            return false;
        }
    }, true);

    static /* synthetic */ boolean EA(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(":");
        return split.length > 0 && split[0].equals("startMonitoringBeacons");
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.fNP + 1;
        webViewStubProxyUI.fNP = i;
        return i;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        v.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = " + intExtra);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                k kVar = new k();
                kVar.type = intent.getStringExtra("proxyui_type_key");
                kVar.lqZ = intent.getStringExtra("proxyui_function_key");
                kVar.lqX = intent.getStringExtra("proxyui_callback_key");
                kVar.iaJ = k.P(intent.getExtras());
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                j.tl(webViewStubProxyUI.lhu).a((Context) webViewStubProxyUI, webViewStubProxyUI.lhv, webViewStubProxyUI.leB);
                if (!j.tl(webViewStubProxyUI.lhu).a(kVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.lhv.a(null, null, null, true);
                        return;
                    } catch (Exception e) {
                        v.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                j.tl(webViewStubProxyUI.lhu).a((Context) webViewStubProxyUI, webViewStubProxyUI.lhv);
                if (!j.tl(webViewStubProxyUI.lhu).FE(intent.getStringExtra("proxyui_username_key"))) {
                    v.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    return;
                }
                return;
            default:
                v.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = " + intExtra);
                webViewStubProxyUI.finish();
                return;
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.dW(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.leB = webViewStubCallbackWrapper.ljN;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.lhu = intent.getIntExtra("webview_binder_id", 0);
        v.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(this.lhu)});
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            lhs = true;
        }
        switch (intExtra) {
            case 1:
                if (!this.lht) {
                    this.aSW.ea(100);
                }
                if (lhs) {
                    this.lhx.ea(5000);
                    return;
                }
                return;
            case 2:
                final py pyVar = new py();
                pyVar.bpT = new Runnable(this) {
                    final /* synthetic */ WebViewStubProxyUI lhz;

                    public final void run() {
                        if (pyVar.brj.brk) {
                            if (this.lhz.leB != null) {
                                try {
                                    this.lhz.leB.g(1001, null);
                                } catch (RemoteException e) {
                                    v.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            this.lhz.finish();
                            com.tencent.mm.pluginsdk.j.j jVar = com.tencent.mm.pluginsdk.j.a.lxI;
                            if (jVar != null) {
                                jVar.ai(this.lhz);
                                return;
                            }
                            return;
                        }
                        this.lhz.finish();
                    }
                };
                pyVar.bri.context = this;
                pyVar.bri.type = intent.getIntExtra("update_type_key", 0);
                if (pyVar.bri.type <= 0) {
                    v.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + pyVar.bri.type);
                    finish();
                    return;
                }
                com.tencent.mm.sdk.c.a.nhr.a(pyVar, Looper.myLooper());
                return;
            case 3:
                Dialog a;
                ak.yW();
                ax Nr = c.wN().Nr("@t.qq.com");
                if (!com.tencent.mm.model.k.yn()) {
                    a = g.a(this, 2131232087, 2131231164, new OnClickListener(this) {
                        final /* synthetic */ WebViewStubProxyUI lhz;

                        {
                            this.lhz = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.webview.a.a.drp.h(new Intent(), this.lhz);
                        }
                    }, null);
                } else if (Nr == null || be.kS(Nr.name)) {
                    a = g.f(this, 2131235183, 2131231164);
                } else {
                    ak.vy().a(new z(getIntent().getIntExtra(Columns.TYPE, 0), be.ma(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.leB.sM(0);
                        a = null;
                    } catch (Exception e) {
                        v.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    return;
                } else {
                    a.setOnDismissListener(this.lhw);
                    return;
                }
            case 4:
                this.aSW.ea(100);
                return;
            case 5:
                if (com.tencent.mm.pluginsdk.j.a.lxV != null) {
                    com.tencent.mm.pluginsdk.j.a.lxV.a(this, intent.getStringExtra("proxyui_handle_event_url"), this.lhw);
                    return;
                }
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    v.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    return;
                }
                com.tencent.mm.e.a.c cVar = new com.tencent.mm.e.a.c();
                cVar.aWm.aWn = this;
                cVar.aWm.errType = intExtra2;
                cVar.aWm.errCode = intExtra3;
                com.tencent.mm.sdk.c.a.nhr.z(cVar);
                return;
            case 8:
                String stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (be.kS(stringExtra)) {
                    v.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                com.tencent.mm.pluginsdk.ui.d.g.a(this, stringExtra, this.lhw, bundle2);
                return;
            case 9:
                intent = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent.setFlags(603979776);
                com.tencent.mm.ay.c.a(this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", null, intent);
                finish();
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!lhs) {
            this.leB = null;
        }
        v.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] == 0) {
                    j.tl(this.lhu).a(i, -1, null);
                    return;
                } else {
                    j.tl(this.lhu).a(i, 0, null);
                    return;
                }
            default:
                return;
        }
    }
}
