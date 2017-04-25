package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

public final class e {
    WebView liG;
    Map<String, a> ljn;
    private JsapiPermissionWrapper ljo;
    private GeneralControlWrapper ljp;
    private final JsapiPermissionWrapper ljq = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper ljr = GeneralControlWrapper.lWr;
    private int[] ljs;
    private int[] ljt;

    private static class a {
        public JsapiPermissionWrapper lju;
        public GeneralControlWrapper ljv;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.lju = jsapiPermissionWrapper;
            this.ljv = generalControlWrapper;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.lju);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.ljv);
            return stringBuilder.toString();
        }
    }

    public e(Activity activity, WebView webView) {
        int i;
        this.ljo = (JsapiPermissionWrapper) activity.getIntent().getParcelableExtra("hardcode_jspermission");
        if (q.dqe == null || q.dqe.length() == 0) {
            v.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = be.getInt(q.dqe, 0);
                if (i < 0) {
                    v.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.ljo = new JsapiPermissionWrapper(i);
                    v.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.ljo);
                }
            } catch (Exception e) {
                v.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.ljo = null;
            }
        }
        this.ljp = (GeneralControlWrapper) activity.getIntent().getParcelableExtra("hardcode_general_ctrl");
        if (q.dqf == null || q.dqf.length() == 0) {
            v.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                v.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[]{Integer.valueOf(be.getInt(q.dqf, 0))});
                rr rrVar = new rr();
                rrVar.mvv = i;
                this.ljp = new GeneralControlWrapper(rrVar);
            } catch (Exception e2) {
                v.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[]{e2.getMessage()});
                this.ljp = null;
            }
            v.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.ljp);
        }
        v.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.ljo + ", hardcodeGenCtrl = " + this.ljp);
        this.liG = webView;
        this.ljn = new HashMap();
        this.ljs = activity.getIntent().getIntArrayExtra("jsapi_blacklist");
        this.ljt = activity.getIntent().getIntArrayExtra("jsapi_whitelist");
        if (!(this.ljs == null || this.ljs.length <= 0 || this.ljo == null)) {
            v.i("MicroMsg.WebViewPermission", "albie: setBlacklist jsapi(%s).", new Object[]{this.ljs});
            this.ljo.p(this.ljs);
        }
        if (this.ljt != null && this.ljt.length > 0 && this.ljo != null) {
            v.i("MicroMsg.WebViewPermission", "albie: setWhitelist jsapi(%s).", new Object[]{this.ljt});
            this.ljo.q(this.ljt);
        }
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (be.kS(str)) {
            v.e("MicroMsg.WebViewPermission", "update fail, url is null");
            return;
        }
        String Fa = Fa(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.ljq;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.ljr;
        }
        if (this.ljs != null && this.ljs.length > 0) {
            v.i("MicroMsg.WebViewPermission", "albie: update setBlacklist jsapi(%s).", new Object[]{this.ljs});
            jsapiPermissionWrapper.p(this.ljs);
        }
        if (this.ljt != null && this.ljt.length > 0) {
            v.i("MicroMsg.WebViewPermission", "albie: update setWhitelist jsapi(%s).", new Object[]{this.ljt});
            jsapiPermissionWrapper.q(this.ljt);
        }
        v.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + Fa);
        this.ljn.put(Fa, new a(jsapiPermissionWrapper, generalControlWrapper));
    }

    public final boolean has(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.WebViewPermission", "has fail, url is null");
            return false;
        }
        a aVar = (a) this.ljn.get(Fa(str));
        return (aVar == null || aVar.lju == this.ljq || aVar.ljv == this.ljr) ? false : true;
    }

    public final JsapiPermissionWrapper bjS() {
        if (this.ljo != null) {
            v.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.ljo);
            return this.ljo;
        }
        return EZ(this.liG == null ? null : this.liG.getUrl());
    }

    public final JsapiPermissionWrapper EZ(String str) {
        if (this.ljo != null) {
            v.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.ljo);
            return this.ljo;
        } else if (be.kS(str)) {
            v.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + str);
            return this.ljq;
        } else {
            String Fa = Fa(str);
            if (this.ljn == null) {
                v.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                return this.ljq;
            }
            a aVar = (a) this.ljn.get(Fa);
            return aVar == null ? this.ljq : aVar.lju;
        }
    }

    public final GeneralControlWrapper bjT() {
        Object obj = null;
        if (this.ljp != null) {
            v.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.ljp);
            return this.ljp;
        }
        String url;
        if (this.liG != null) {
            url = this.liG.getUrl();
            if (!be.kS(url)) {
                String Fa = Fa(url);
                a aVar = (a) this.ljn.get(Fa);
                String str = "MicroMsg.WebViewPermission";
                StringBuilder stringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
                if (aVar != null) {
                    obj = aVar.ljv;
                }
                v.i(str, stringBuilder.append(obj).append(", url = ").append(Fa).toString());
                return aVar == null ? this.ljr : aVar.ljv;
            }
        } else {
            url = null;
        }
        v.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + url);
        return this.ljr;
    }

    private static String Fa(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
