package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.d.u;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class b extends WebViewClient {
    Activity gZX;
    ServiceConnection gfD;
    private MMWebView jyU;
    private e loC;
    private d loV;
    f loX;
    private String lrA;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.d> lrB;
    private final Map<String, String> lrC;
    boolean lrD;
    private c lrE;
    h lrs;
    private boolean lrt;
    private String lru;
    private Set<String> lrv;
    protected b lrw;
    private a lrx;
    private String lry;
    private String lrz;
    private ac mHandler;

    private static class a {
        private static final Pattern hDe = Pattern.compile(".*#.*wechat_redirect");
        private String let = null;

        public a(String str) {
            this.let = str;
        }

        public final int Ft(String str) {
            if (be.kS(str)) {
                v.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
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

    protected class b {
        int lnc = 0;
        final /* synthetic */ b lrF;

        protected b(b bVar) {
            this.lrF = bVar;
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        bVar.jyU.loadUrl(str, hashMap);
    }

    static /* synthetic */ boolean a(b bVar, c cVar) {
        int type = cVar.getType();
        int bjm = cVar.bjm();
        int bjn = cVar.bjn();
        cVar.Ch();
        Bundle data = cVar.getData();
        if (data == null) {
            data = new Bundle();
        }
        if (bVar.jyU != null) {
            if (!bVar.gZX.isFinishing() && bVar.loC != null) {
                v.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(bVar.jyU.hashCode())});
                v.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + type + ", errCode = " + bjn + ", errType = " + bjm);
                if (data.getInt("scene_end_listener_hash_code") == bVar.jyU.hashCode()) {
                    switch (type) {
                        case 233:
                            b bVar2 = bVar.lrw;
                            bVar2.lnc--;
                            if (bVar2.lnc <= 0) {
                                bVar2.lrF.tb(233);
                            }
                            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                            int i = data.getInt("geta8key_result_reason");
                            v.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = " + i);
                            switch (i) {
                                case 0:
                                case 2:
                                    if ((bjm == 0 && bjn == 0) || (bjm == 4 && bjn == -2005)) {
                                        bVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        bVar.Q(data);
                                        break;
                                    }
                                case 1:
                                    if (bjm != 0 || bjn != 0) {
                                        if (bjm == 4 && bjn == -2005) {
                                            bVar.jyU.stopLoading();
                                            bVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                            bVar.Q(data);
                                            break;
                                        }
                                    }
                                    String string = data.getString("geta8key_result_req_url");
                                    bVar.loC.a(string, jsapiPermissionWrapper, generalControlWrapper);
                                    bVar.lrv.remove(string);
                                    break;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                v.e("MicroMsg.MMWebViewClient", "hash code not equal");
            } else {
                v.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
            }
        } else {
            v.w("MicroMsg.MMWebViewClient", "onSceneEnd, viewWV is null, do nothing");
        }
        return true;
    }

    static /* synthetic */ void f(b bVar) {
        int i;
        Map hashMap = new HashMap();
        hashMap.put("init_url", bVar.lry);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        bVar.loX = new f(bVar.jyU, bVar.loC, hashMap, bVar.loV, bVar.jyU.hashCode());
        bVar.loX.loA = null;
        bVar.lrB.add(bVar.loX);
        bVar.lrB.add(new g(bVar.jyU, bVar.loV, bVar.jyU.hashCode(), bVar.loX));
        bVar.lrs = new h(bVar.jyU, bVar.loX, new com.tencent.mm.plugin.webview.ui.tools.jsapi.h.a(bVar) {
            final /* synthetic */ b lrF;

            {
                this.lrF = r1;
            }

            public final void bkG() {
            }
        }, false);
        try {
            i = be.getInt(bVar.loV.EI("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            v.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        v.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", new Object[]{Integer.valueOf(i)});
        if (i == 0 && bVar.gZX.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            bVar.lrs.bll();
        }
    }

    static /* synthetic */ void g(b bVar) {
        try {
            bVar.loV.a(bVar.lry, true, null);
        } catch (Exception e) {
            v.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!bVar.FI(bVar.lry)) {
            Uri parse = Uri.parse(bVar.lry);
            if (parse.getScheme() == null) {
                bVar.lry += "http://";
                parse = Uri.parse(bVar.lry);
            }
            if (parse.getScheme().startsWith("http")) {
                v.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                bVar.lrx = new a(bVar.lrD ? "" : bVar.lry);
                bVar.lrD = false;
                if (bVar.lrt || bVar.loC.has(bVar.lry)) {
                    bVar.jyU.loadUrl(bVar.lry);
                } else {
                    bVar.aA(bVar.lry, false);
                }
            } else if (u.DQ(bVar.lry)) {
                bVar.jyU.loadUrl(bVar.lry);
            }
        }
    }

    public b() {
        this.lrs = null;
        this.loX = null;
        this.lrt = false;
        this.lru = "";
        this.lrv = new HashSet();
        this.lrw = new b(this);
        this.lrx = new a(null);
        this.lry = null;
        this.lrz = null;
        this.lrA = null;
        this.lrB = new ArrayList();
        this.lrC = new HashMap();
        this.lrD = false;
        this.gfD = new ServiceConnection(this) {
            final /* synthetic */ b lrF;

            {
                this.lrF = r1;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                v.i("MicroMsg.MMWebViewClient", "onServiceConnected");
                if (this.lrF.jyU == null) {
                    v.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                    return;
                }
                try {
                    this.lrF.loV = com.tencent.mm.plugin.webview.stub.d.a.S(iBinder);
                    this.lrF.loV.a(this.lrF.lrE, this.lrF.jyU.hashCode());
                    b.f(this.lrF);
                    b.g(this.lrF);
                } catch (Exception e) {
                    v.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                v.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
                if (this.lrF.gZX.isFinishing()) {
                    this.lrF.loV = null;
                    return;
                }
                v.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
                this.lrF.bjW();
            }
        };
        this.lrE = new c(this) {
            final /* synthetic */ b lrF;
            private c lrG = new c();

            {
                this.lrF = r2;
            }

            public final boolean sM(int i) {
                return this.lrG.sM(i);
            }

            public final boolean g(int i, final Bundle bundle) {
                v.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + i);
                final long j;
                final String string;
                final Map hashMap;
                final String string2;
                final int i2;
                switch (i) {
                    case 1002:
                        j = bundle.getLong("download_manager_downloadid");
                        string = bundle.getString("download_manager_appid", "");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null && this.lrH.lrF.loC != null && this.lrH.lrF.loC.bjS() != null && this.lrH.lrF.loC.bjS().uC(42)) {
                                    this.lrH.lrF.loX.c(string, j, "download_succ");
                                }
                            }
                        });
                        break;
                    case 1003:
                        j = bundle.getLong("download_manager_downloadid");
                        string = bundle.getString("download_manager_appid", "");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null && this.lrH.lrF.loC != null && this.lrH.lrF.loC.bjS() != null && this.lrH.lrF.loC.bjS().uC(42)) {
                                    this.lrH.lrF.loX.c(string, j, "download_fail");
                                }
                            }
                        });
                        break;
                    case 1006:
                        if (this.lrF.loX != null) {
                            this.lrF.mHandler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 lrH;

                                public final void run() {
                                    boolean z = false;
                                    byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                    if (byteArray == null || this.lrH.lrF.loC == null || this.lrH.lrF.loC.bjS() == null) {
                                        String str = "MicroMsg.MMWebViewClient";
                                        String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Boolean.valueOf(byteArray != null);
                                        if (this.lrH.lrF.loC != null) {
                                            z = true;
                                        }
                                        objArr[1] = Boolean.valueOf(z);
                                        v.e(str, str2, objArr);
                                    } else {
                                        v.i("MicroMsg.MMWebViewClient", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
                                        this.lrH.lrF.loC.bjS().lWx = byteArray;
                                    }
                                    if (this.lrH.lrF.loX != null) {
                                        this.lrH.lrF.loX.bld();
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case 1007:
                        final long j2 = bundle.getLong("download_manager_downloadid");
                        final int i3 = bundle.getInt("download_manager_progress");
                        final String string3 = bundle.getString("download_manager_appid", "");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null && this.lrH.lrF.loC != null && this.lrH.lrF.loC.bjS() != null && this.lrH.lrF.loC.bjS().uC(42)) {
                                    this.lrH.lrF.loX.g(string3, j2, i3);
                                }
                            }
                        });
                        break;
                    case 1008:
                        j = bundle.getLong("download_manager_downloadid");
                        string = bundle.getString("download_manager_appid", "");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null && this.lrH.lrF.loC != null && this.lrH.lrF.loC.bjS() != null && this.lrH.lrF.loC.bjS().uC(42)) {
                                    this.lrH.lrF.loX.c(string, j, "download_removed");
                                }
                            }
                        });
                        break;
                    case 2002:
                        hashMap = new HashMap();
                        hashMap.put("err_msg", bundle.getString("playResult"));
                        hashMap.put("localId", bundle.getString("localId"));
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.M(hashMap);
                                }
                            }
                        });
                        break;
                    case 2003:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.bp(string2, i2);
                                }
                            }
                        });
                        break;
                    case 2004:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.bq(string2, i2);
                                }
                            }
                        });
                        break;
                    case 2005:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.br(string2, i2);
                                }
                            }
                        });
                        break;
                    case 2006:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.bs(string2, i2);
                                }
                            }
                        });
                        break;
                    case 2008:
                        hashMap = new HashMap();
                        hashMap.put("localId", bundle.getString("localId"));
                        hashMap.put("err_msg", bundle.getString("recordResult"));
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.N(hashMap);
                                }
                            }
                        });
                        break;
                    case 2010:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        this.lrF.mHandler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 lrH;

                            public final void run() {
                                if (this.lrH.lrF.loX != null) {
                                    this.lrH.lrF.loX.bt(string2, i2);
                                }
                            }
                        });
                        break;
                    default:
                        v.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                        break;
                }
                this.lrG.g(i, bundle);
                return true;
            }

            public final boolean a(final c cVar) {
                v.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.lrF.jyU.hashCode());
                this.lrF.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 lrH;

                    public final void run() {
                        try {
                            b.a(this.lrH.lrF, cVar);
                        } catch (Exception e) {
                            v.e("MicroMsg.MMWebViewClient", e.getMessage());
                        }
                    }
                });
                return this.lrG.a(cVar);
            }

            public final boolean a(String str, String str2, Bundle bundle, boolean z) {
                if (this.lrF.loX != null) {
                    final String str3 = str;
                    final String str4 = str2;
                    final Bundle bundle2 = bundle;
                    final boolean z2 = z;
                    this.lrF.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 lrH;

                        public final void run() {
                            this.lrH.lrF.loX.a(str3, str4, k.P(bundle2), z2);
                        }
                    });
                    this.lrG.a(str, str2, bundle, z);
                }
                return false;
            }

            public final String bjo() {
                return this.lrF.lry;
            }

            public final String Ra() {
                return this.lrF.bkc();
            }

            public final String bjp() {
                return this.lrG.bjp();
            }

            public final void hu(boolean z) {
                this.lrG.hu(z);
            }

            public final void hv(boolean z) {
                this.lrG.hv(z);
            }

            public final void h(int i, Bundle bundle) {
                this.lrG.h(i, bundle);
            }

            public final void bjq() {
                if (this.lrF.loX != null) {
                    this.lrF.loX.bjq();
                }
            }

            public final void B(Bundle bundle) {
                this.lrG.B(bundle);
            }

            public final void EB(String str) {
                this.lrG.EB(str);
            }

            public final void da(String str, String str2) {
                this.lrG.da(str, str2);
            }

            public final void bjr() {
                if (this.lrF.loX != null) {
                    this.lrF.loX.bjr();
                }
            }

            public final void i(String str, String str2, int i, int i2) {
                this.lrG.i(str, str2, i, i2);
            }

            public final Bundle i(int i, Bundle bundle) {
                return this.lrG.i(i, bundle);
            }

            public final void C(Bundle bundle) {
                this.lrG.C(bundle);
            }

            public final void hw(boolean z) {
                this.lrG.hw(z);
            }
        };
    }

    public b(MMWebView mMWebView) {
        this(mMWebView, false);
    }

    public b(MMWebView mMWebView, boolean z) {
        this.lrs = null;
        this.loX = null;
        this.lrt = false;
        this.lru = "";
        this.lrv = new HashSet();
        this.lrw = new b(this);
        this.lrx = new a(null);
        this.lry = null;
        this.lrz = null;
        this.lrA = null;
        this.lrB = new ArrayList();
        this.lrC = new HashMap();
        this.lrD = false;
        this.gfD = /* anonymous class already generated */;
        this.lrE = /* anonymous class already generated */;
        this.gZX = (Activity) mMWebView.getContext();
        this.jyU = mMWebView;
        this.mHandler = new ac();
        this.loC = new e(this.gZX, mMWebView);
        this.lrt = z;
    }

    public boolean ym(String str) {
        return false;
    }

    public void a(WebView webView) {
    }

    private boolean FI(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar : this.lrB) {
            if (dVar.Fs(str)) {
                v.i("MicroMsg.MMWebViewClient", "url handled, ret = " + dVar.Fj(str) + ", url = " + str);
                return true;
            }
        }
        return ym(str);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        v.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + str);
        if (this.loV == null) {
            v.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            return true;
        } else if (!u.DQ(str)) {
            v.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + str);
            return true;
        } else if (str.equals(this.lrA)) {
            this.lrA = "";
            return true;
        } else {
            boolean FI = FI(str);
            if (!FI && str.startsWith("weixin://")) {
                v.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                return true;
            } else if (FI) {
                return true;
            } else {
                int Ft = this.lrx.Ft(str);
                if ((Ft != 0 && Ft != 2) || this.lrt) {
                    return false;
                }
                v.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + Ft);
                if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.loV, this.jyU.hashCode())) {
                    this.jyU.stopLoading();
                    this.jyU.post(new Runnable(this) {
                        final /* synthetic */ b lrF;

                        public final void run() {
                            b.a(this.lrF, str);
                        }
                    });
                } else {
                    this.jyU.stopLoading();
                }
                if (str.equals(this.lru)) {
                    v.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return false;
                }
                aA(str, true);
                return true;
            }
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        v.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        super.doUpdateVisitedHistory(webView, str, z);
        String url = webView.getUrl();
        if (this.lrt) {
            aA(url, false);
        }
        if (this.loC != null && !this.loC.has(url)) {
            v.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
            aA(url, false);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        int i = 1;
        v.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", new Object[]{str});
        if (this.loV == null) {
            this.lry = str;
            bjW();
        } else {
            i = 0;
        }
        if (i != 0) {
            if (!this.lrD) {
                webView.stopLoading();
            }
        } else if (!u.DQ(str)) {
            v.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + str);
        } else if (FI(str)) {
            this.lrA = str;
        } else {
            this.lrz = str;
            super.onPageStarted(webView, str, bitmap);
            this.lrs.blm();
            if (com.tencent.mm.plugin.webview.modelcache.u.a(str, this.loV, this.jyU.hashCode())) {
                this.jyU.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.loX != null) {
                    this.loX.Fw((String) this.lrC.get(str));
                }
            }
            aA(str, false);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        v.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", new Object[]{str});
        if (this.loV != null) {
            super.onPageFinished(webView, str);
            if (u.DQ(str)) {
                this.lrA = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    v.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    return;
                }
                this.lrs.bln();
                a(webView);
                return;
            }
            v.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    public void onLoadResource(WebView webView, String str) {
        v.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + str);
        super.onLoadResource(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        v.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", new Object[]{str});
        return a.lgb.lfY.a(bkc(), str, this.loV, webView.hashCode());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null || be.kS(webResourceRequest.getUrl().toString())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        v.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
        return a.lgb.lfY.a(bkc(), webResourceRequest.getUrl().toString(), this.loV, webView.hashCode());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
    }

    private void bjW() {
        v.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.gZX.bindService(new Intent(this.gZX, WebViewStubService.class), this.gfD, 1);
    }

    private void aA(String str, boolean z) {
        boolean z2 = false;
        if (!this.gZX.isFinishing()) {
            if (this.loC == null) {
                v.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            } else if (this.lrt) {
                v.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
                this.loC.a(str, null, null);
            } else {
                if (this.loV != null && this.lrv.contains(str) && com.tencent.mm.plugin.webview.modelcache.u.a(str, this.loV, this.jyU.hashCode())) {
                    int i = 1;
                } else {
                    boolean z3 = z2;
                }
                if ((this.loC.has(str) || r0 != 0) && !z) {
                    v.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                    return;
                }
                String str2 = "";
                int Ft = this.lrx.Ft(str);
                v.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = 0, username = " + str2 + ", reason = " + Ft + ", force = " + z);
                v.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
                this.lrv.add(str);
                this.loC.a(str, null, null);
                b bVar = this.lrw;
                if (bVar.lnc == 0) {
                    b bVar2 = bVar.lrF;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("scene_end_type", 233);
                        bundle.putInt("scene_end_listener_hash_code", bVar2.jyU.hashCode());
                        bVar2.loV.a(5, bundle, bVar2.jyU.hashCode());
                    } catch (Exception e) {
                        v.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
                    }
                }
                bVar.lnc++;
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_data_req_url", str);
                bundle2.putString("geta8key_data_username", str2);
                bundle2.putInt("geta8key_data_scene", z2);
                bundle2.putInt("geta8key_data_reason", Ft);
                if (this.jyU.getX5WebViewExtension() != null) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", z2);
                }
                bundle2.putString("geta8key_data_net_type", s.biq());
                this.lru = str;
                try {
                    z2 = this.loV.l(233, bundle2);
                } catch (Exception e2) {
                    v.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
                }
                v.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + z2);
            }
        }
    }

    final void tb(int i) {
        try {
            if (this.loV != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", 233);
                bundle.putInt("scene_end_listener_hash_code", this.jyU.hashCode());
                this.loV.a(6, bundle, this.jyU.hashCode());
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    private void FJ(String str) {
        String ah = be.ah(bkc(), this.lry);
        if (be.kS(ah)) {
            v.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.jyU.loadUrl(str);
        } else if (this.loX == null) {
            this.jyU.loadUrl(str);
        } else if (be.ma(str).contains("#wechat_redirect")) {
            this.jyU.loadUrl(str);
        } else {
            if (!dc(ah, str)) {
                String Ep = com.tencent.mm.plugin.webview.modelcache.v.Ep(ah);
                String Ep2 = com.tencent.mm.plugin.webview.modelcache.v.Ep(str);
                Object obj = (be.kS(Ep2) || be.kS(Ep) || !Ep2.equals(Ep) || this.loV == null || !com.tencent.mm.plugin.webview.modelcache.u.a(ah, this.loV, this.jyU.hashCode())) ? null : 1;
                if (obj == null) {
                    this.jyU.loadUrl(str);
                    return;
                }
            }
            this.lrC.put(ah, str);
            this.loX.Fw(str);
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
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.loV != null && com.tencent.mm.plugin.webview.modelcache.u.a(str, this.loV, this.jyU.hashCode())) {
                return true;
            }
        }
        return false;
    }

    private boolean Q(Bundle bundle) {
        v.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        v.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        switch (i) {
            case 1:
                v.i("MicroMsg.MMWebViewClient", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    v.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    return false;
                }
                this.jyU.getSettings().setJavaScriptEnabled(false);
                this.jyU.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
            case 7:
                v.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    v.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    return false;
                } else if (u.DQ(string2)) {
                    FJ(string2);
                    return true;
                } else {
                    v.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                    return true;
                }
            case 6:
                v.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    v.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (u.DQ(string2)) {
                    this.jyU.loadUrl(string2);
                    return true;
                } else {
                    v.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    return true;
                }
            default:
                v.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!be.kS(str2)) {
            this.loC.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.lrv.remove(str2);
        }
        if (dc(str, str2)) {
            this.loC.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.lrv.remove(str);
        } else if (this.loV != null && !be.kS(str) && com.tencent.mm.plugin.webview.modelcache.u.a(str2, this.loV, this.jyU.hashCode())) {
            this.loC.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.lrv.remove(str);
        }
    }

    private String bkc() {
        if (!be.kS(this.lrz)) {
            return this.lrz;
        }
        if (this.mHandler == null) {
            return null;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.jyU == null ? "" : this.jyU.getUrl();
        } else {
            return (String) new az<String>(this, "") {
                final /* synthetic */ b lrF;

                protected final /* synthetic */ Object run() {
                    return this.lrF.jyU == null ? "" : this.lrF.jyU.getUrl();
                }
            }.c(this.mHandler);
        }
    }
}
