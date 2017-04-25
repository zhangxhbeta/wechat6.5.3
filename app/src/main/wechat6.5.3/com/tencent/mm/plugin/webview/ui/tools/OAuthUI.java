package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.modelmsg.b.a;
import com.tencent.mm.sdk.modelmsg.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean hdQ = false;
    private boolean liT = true;
    private a liU;
    private c liV;

    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        String EG;
        String bjv;
        Exception exception;
        b bVar;
        Bundle bundle;
        com.tencent.mm.sdk.a.a.a aVar;
        String str2 = null;
        v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = " + str);
        Uri parse = Uri.parse(str);
        if (parse == null) {
            oAuthUI.igd.loadUrl(str);
            return;
        }
        v.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
        try {
            EG = oAuthUI.liH.EG(oAuthUI.appId);
            try {
                bjv = oAuthUI.liH.bjv();
            } catch (Exception e) {
                exception = e;
                bjv = str2;
                v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (!be.kS(EG)) {
                    v.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                    oAuthUI.igd.loadUrl(str);
                } else if (!str.toLowerCase().startsWith("http")) {
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                    oAuthUI.igd.loadUrl(str);
                } else if (oAuthUI.hdQ) {
                    v.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                } else {
                    oAuthUI.hdQ = true;
                    bVar = new b();
                    bVar.lBj = oAuthUI.liU.lBj;
                    bVar.cUi = bjv;
                    bVar.cJg = str2;
                    str2 = parse.getQueryParameter("code");
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                    if (!be.kS(str2)) {
                        bVar.errCode = -1;
                    } else if (str2.toLowerCase().equals("authdeny")) {
                        bVar.errCode = -4;
                    } else {
                        bVar.errCode = 0;
                        bVar.code = str2;
                    }
                    bVar.cCl = parse.getQueryParameter("state");
                    bVar.egi = parse.getQueryParameter("reason");
                    bVar.url = str;
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + bVar.code + ", errCode=" + bVar.errCode + ", state=" + bVar.cCl + ", reason=" + bVar.egi);
                    bundle = new Bundle();
                    bVar.t(bundle);
                    p.R(bundle);
                    aVar = new com.tencent.mm.sdk.a.a.a();
                    aVar.nhj = EG;
                    aVar.nhl = bundle;
                    com.tencent.mm.sdk.a.a.a(oAuthUI, aVar);
                    oAuthUI.finish();
                }
            }
            try {
                str2 = oAuthUI.liH.am(274436, null);
            } catch (Exception e2) {
                exception = e2;
                v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (!be.kS(EG)) {
                    v.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                    oAuthUI.igd.loadUrl(str);
                } else if (!str.toLowerCase().startsWith("http")) {
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                    oAuthUI.igd.loadUrl(str);
                } else if (oAuthUI.hdQ) {
                    oAuthUI.hdQ = true;
                    bVar = new b();
                    bVar.lBj = oAuthUI.liU.lBj;
                    bVar.cUi = bjv;
                    bVar.cJg = str2;
                    str2 = parse.getQueryParameter("code");
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                    if (!be.kS(str2)) {
                        bVar.errCode = -1;
                    } else if (str2.toLowerCase().equals("authdeny")) {
                        bVar.errCode = 0;
                        bVar.code = str2;
                    } else {
                        bVar.errCode = -4;
                    }
                    bVar.cCl = parse.getQueryParameter("state");
                    bVar.egi = parse.getQueryParameter("reason");
                    bVar.url = str;
                    v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + bVar.code + ", errCode=" + bVar.errCode + ", state=" + bVar.cCl + ", reason=" + bVar.egi);
                    bundle = new Bundle();
                    bVar.t(bundle);
                    p.R(bundle);
                    aVar = new com.tencent.mm.sdk.a.a.a();
                    aVar.nhj = EG;
                    aVar.nhl = bundle;
                    com.tencent.mm.sdk.a.a.a(oAuthUI, aVar);
                    oAuthUI.finish();
                } else {
                    v.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
                }
            }
        } catch (Exception e3) {
            exception = e3;
            EG = str2;
            bjv = str2;
            v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
            if (!be.kS(EG)) {
                v.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.igd.loadUrl(str);
            } else if (!str.toLowerCase().startsWith("http")) {
                v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.igd.loadUrl(str);
            } else if (oAuthUI.hdQ) {
                v.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
            } else {
                oAuthUI.hdQ = true;
                bVar = new b();
                bVar.lBj = oAuthUI.liU.lBj;
                bVar.cUi = bjv;
                bVar.cJg = str2;
                str2 = parse.getQueryParameter("code");
                v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                if (!be.kS(str2)) {
                    bVar.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    bVar.errCode = -4;
                } else {
                    bVar.errCode = 0;
                    bVar.code = str2;
                }
                bVar.cCl = parse.getQueryParameter("state");
                bVar.egi = parse.getQueryParameter("reason");
                bVar.url = str;
                v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + bVar.code + ", errCode=" + bVar.errCode + ", state=" + bVar.cCl + ", reason=" + bVar.egi);
                bundle = new Bundle();
                bVar.t(bundle);
                p.R(bundle);
                aVar = new com.tencent.mm.sdk.a.a.a();
                aVar.nhj = EG;
                aVar.nhl = bundle;
                com.tencent.mm.sdk.a.a.a(oAuthUI, aVar);
                oAuthUI.finish();
            }
        }
        if (!be.kS(EG)) {
            v.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
            oAuthUI.igd.loadUrl(str);
        } else if (!str.toLowerCase().startsWith("http")) {
            v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
            oAuthUI.igd.loadUrl(str);
        } else if (oAuthUI.hdQ) {
            v.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
        } else {
            oAuthUI.hdQ = true;
            bVar = new b();
            bVar.lBj = oAuthUI.liU.lBj;
            bVar.cUi = bjv;
            bVar.cJg = str2;
            str2 = parse.getQueryParameter("code");
            v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
            if (!be.kS(str2)) {
                bVar.errCode = -1;
            } else if (str2.toLowerCase().equals("authdeny")) {
                bVar.errCode = -4;
            } else {
                bVar.errCode = 0;
                bVar.code = str2;
            }
            bVar.cCl = parse.getQueryParameter("state");
            bVar.egi = parse.getQueryParameter("reason");
            bVar.url = str;
            v.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + bVar.code + ", errCode=" + bVar.errCode + ", state=" + bVar.cCl + ", reason=" + bVar.egi);
            bundle = new Bundle();
            bVar.t(bundle);
            p.R(bundle);
            aVar = new com.tencent.mm.sdk.a.a.a();
            aVar.nhj = EG;
            aVar.nhl = bundle;
            com.tencent.mm.sdk.a.a.a(oAuthUI, aVar);
            oAuthUI.finish();
        }
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ldG != null) {
            this.ldG.biv().bpX = "weixin://mark/oauth";
        }
    }

    protected final void aqj() {
        boolean bjs;
        super.aqj();
        try {
            bjs = this.liH.bjs();
        } catch (Exception e) {
            v.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            bjs = false;
        }
        if (bjs) {
            this.igd.setWebChromeClient(new WebChromeClient(this) {
                final /* synthetic */ OAuthUI liW;

                {
                    this.liW = r1;
                }

                public final void onReceivedTitle(WebView webView, String str) {
                    super.onReceivedTitle(webView, str);
                    this.liW.Fd(str);
                }
            });
            this.igd.setWebViewClient(new i(this) {
                final /* synthetic */ OAuthUI liW;

                {
                    this.liW = r1;
                }

                public final boolean ER(String str) {
                    v.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = " + str);
                    if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                        OAuthUI.a(this.liW, str);
                    }
                    return true;
                }
            });
            this.igd.setDownloadListener(new DownloadListener(this) {
                final /* synthetic */ OAuthUI liW;

                {
                    this.liW = r1;
                }

                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    this.liW.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            });
            this.igd.bKn();
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ OAuthUI liW;

                {
                    this.liW = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.liW.bjN();
                    this.liW.finish();
                    return true;
                }
            });
            a(1, getString(2131231144), new OnMenuItemClickListener(this) {
                final /* synthetic */ OAuthUI liW;

                {
                    this.liW = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.liW.liV != null) {
                        this.liW.liV;
                    }
                    this.liW.igd.stopLoading();
                    this.liW.z(false, false);
                    this.liW.bjP();
                    return false;
                }
            });
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("_mmessage_content");
            if (be.kS(string)) {
                v.f("MicroMsg.OAuthUI", "content is null");
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            v.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.liH.EF(this.appId);
            } catch (Exception e2) {
                v.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.liU = new a(extras);
            try {
                this.lky.bkL();
            } catch (Exception e22) {
                v.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            bjP();
            return;
        }
        v.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, 2131230793, 1).show();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ OAuthUI liW;

            {
                this.liW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.liW.finish();
                return true;
            }
        });
        iT(false);
    }

    protected void onStop() {
        this.igd.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        try {
            this.lky.bkM();
        } catch (Exception e) {
            v.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.liT && i == 4 && this.igd.canGoBack()) {
            this.igd.goBack();
            return true;
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            bjN();
            finish();
            return true;
        }
    }

    private void bjN() {
        Exception exception;
        String str = null;
        v.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.hdQ) {
            v.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            return;
        }
        String EG;
        String bjv;
        b bVar;
        Bundle bundle;
        com.tencent.mm.sdk.a.a.a aVar;
        this.hdQ = true;
        try {
            EG = this.liH.EG(this.appId);
            try {
                bjv = this.liH.bjv();
            } catch (Exception e) {
                exception = e;
                bjv = str;
                v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (be.kS(EG)) {
                    v.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                bVar = new b();
                bVar.lBj = this.liU.lBj;
                bVar.errCode = -2;
                bVar.cUi = bjv;
                bVar.cJg = str;
                bundle = new Bundle();
                bVar.t(bundle);
                p.R(bundle);
                aVar = new com.tencent.mm.sdk.a.a.a();
                aVar.nhj = EG;
                aVar.nhl = bundle;
                com.tencent.mm.sdk.a.a.a(this, aVar);
            }
            try {
                str = this.liH.am(274436, null);
            } catch (Exception e2) {
                exception = e2;
                v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
                if (be.kS(EG)) {
                    v.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
                    return;
                }
                bVar = new b();
                bVar.lBj = this.liU.lBj;
                bVar.errCode = -2;
                bVar.cUi = bjv;
                bVar.cJg = str;
                bundle = new Bundle();
                bVar.t(bundle);
                p.R(bundle);
                aVar = new com.tencent.mm.sdk.a.a.a();
                aVar.nhj = EG;
                aVar.nhl = bundle;
                com.tencent.mm.sdk.a.a.a(this, aVar);
            }
        } catch (Exception e3) {
            exception = e3;
            EG = str;
            bjv = str;
            v.w("MicroMsg.OAuthUI", "getPackageName, ex = " + exception.getMessage());
            if (be.kS(EG)) {
                bVar = new b();
                bVar.lBj = this.liU.lBj;
                bVar.errCode = -2;
                bVar.cUi = bjv;
                bVar.cJg = str;
                bundle = new Bundle();
                bVar.t(bundle);
                p.R(bundle);
                aVar = new com.tencent.mm.sdk.a.a.a();
                aVar.nhj = EG;
                aVar.nhl = bundle;
                com.tencent.mm.sdk.a.a.a(this, aVar);
            }
            v.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        if (be.kS(EG)) {
            v.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
            return;
        }
        bVar = new b();
        bVar.lBj = this.liU.lBj;
        bVar.errCode = -2;
        bVar.cUi = bjv;
        bVar.cJg = str;
        bundle = new Bundle();
        bVar.t(bundle);
        p.R(bundle);
        aVar = new com.tencent.mm.sdk.a.a.a();
        aVar.nhj = EG;
        aVar.nhl = bundle;
        com.tencent.mm.sdk.a.a.a(this, aVar);
    }

    protected final boolean bjO() {
        return true;
    }

    protected final void NI() {
        super.NI();
        this.igd.getSettings().setJavaScriptEnabled(true);
        this.igd.setVerticalScrollBarEnabled(false);
    }

    private void bjP() {
        u.d(getSharedPreferences(aa.bti(), 0));
        this.liV = c.a(this, this.appId, this.liU, new c.a(this) {
            final /* synthetic */ OAuthUI liW;

            {
                this.liW = r1;
            }

            public final void a(c cVar, String str, boolean z) {
                v.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", networkAvailable = " + z);
                if (cVar != null) {
                    cVar.liO = false;
                }
                if (!z) {
                    String string;
                    try {
                        string = this.liW.getString(2131234132);
                    } catch (Throwable e) {
                        v.a("MicroMsg.OAuthUI", e, "", new Object[0]);
                        string = null;
                    }
                    v.i("MicroMsg.OAuthUI", "onResult, html = " + string);
                    if (this.liW.igd != null) {
                        this.liW.igd.loadUrl(string);
                        if (this.liW.ldG != null) {
                            this.liW.ldG.biv().bpX = string;
                        }
                    }
                } else if (!be.kS(str) && this.liW.igd != null) {
                    this.liW.igd.loadUrl(str);
                    if (this.liW.ldG != null) {
                        this.liW.ldG.biv().bpX = str;
                    }
                }
            }
        }, this.liH);
    }

    public final void b(c cVar) {
        String string;
        int i;
        Exception exception;
        boolean z;
        int i2 = -1;
        if (this.liV != null) {
            c cVar2 = this.liV;
            if (cVar2.liO) {
                int bjm;
                try {
                    bjm = cVar.bjm();
                    try {
                        i2 = cVar.bjn();
                        cVar.Ch();
                        string = cVar.getData().getString("geta8key_result_full_url");
                    } catch (Exception e) {
                        Exception exception2 = e;
                        i = i2;
                        i2 = bjm;
                        exception = exception2;
                        v.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + exception.getMessage());
                        bjm = i2;
                        i2 = i;
                        string = null;
                        v.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + bjm + ", errCode = " + i2);
                        if (cVar2.gcy != null) {
                            cVar2.gcy.dismiss();
                        }
                        cVar2.liN = false;
                        cVar2.cxS.QI();
                        if (i2 != 0) {
                        }
                        if (bjm == 4) {
                        }
                        if (bjm != 1) {
                        }
                        v.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + bjm);
                        z = false;
                        if (z) {
                            cVar2.liP.a(cVar2, string, true);
                            return;
                        } else {
                            cVar2.liP.a(cVar2, null, false);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    exception = e2;
                    i = -1;
                    v.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + exception.getMessage());
                    bjm = i2;
                    i2 = i;
                    string = null;
                    v.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + bjm + ", errCode = " + i2);
                    if (cVar2.gcy != null) {
                        cVar2.gcy.dismiss();
                    }
                    cVar2.liN = false;
                    cVar2.cxS.QI();
                    if (i2 != 0) {
                    }
                    if (bjm == 4) {
                    }
                    if (bjm != 1) {
                    }
                    v.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + bjm);
                    z = false;
                    if (z) {
                        cVar2.liP.a(cVar2, string, true);
                        return;
                    } else {
                        cVar2.liP.a(cVar2, null, false);
                        return;
                    }
                }
                v.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + bjm + ", errCode = " + i2);
                if (cVar2.gcy != null) {
                    cVar2.gcy.dismiss();
                }
                cVar2.liN = false;
                cVar2.cxS.QI();
                if (i2 != 0 && bjm == 0) {
                    cVar2.liP.a(cVar2, string, true);
                    return;
                } else if (bjm == 4 || i2 != -100) {
                    if (bjm != 1 || bjm == 2 || bjm == 7 || bjm == 8) {
                        v.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + bjm);
                        z = false;
                    } else if (ak.isConnected(cVar2.liQ)) {
                        z = true;
                    } else {
                        v.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                        z = false;
                    }
                    if (z) {
                        cVar2.liP.a(cVar2, null, false);
                        return;
                    } else {
                        cVar2.liP.a(cVar2, string, true);
                        return;
                    }
                } else {
                    cVar2.liQ.z(true, true);
                    try {
                        cVar2.liH.N(bjm, i2, cVar2.hashCode());
                        return;
                    } catch (Exception e22) {
                        v.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e22.getMessage());
                        return;
                    }
                }
            }
            v.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
        }
    }
}
