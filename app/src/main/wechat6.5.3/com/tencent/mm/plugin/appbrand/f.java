package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.jsapi.AppBrandJSInterface;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.aa;
import com.tencent.smtt.sdk.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class f implements c {
    public boolean ZO = true;
    AppBrandJSInterface dWV;
    public String dzg;
    b dzh;
    Set<a> dzi = Collections.newSetFromMap(new ConcurrentHashMap());
    public Context mContext;

    public interface a {
        void onDestroy();
    }

    public f(Context context, String str) {
        this.mContext = context;
        this.dzg = str;
        this.dWV = new AppBrandJSInterface(this);
        if (aa.fM(com.tencent.mm.sdk.platformtools.aa.getContext())) {
            this.dzh = new i(com.tencent.mm.sdk.platformtools.aa.getContext(), this.dWV, "WeixinJSCore");
            g.iuh.a(434, 2, 1, false);
            v.i("MicroMsg.AppBrandService", "Using X5 Javascript Engine");
        } else {
            this.dzh = new h(com.tencent.mm.sdk.platformtools.aa.getContext(), this.dWV, "WeixinJSCore");
            g.iuh.a(434, 1, 1, false);
            v.i("MicroMsg.AppBrandService", "Using WebView Based Javascript Engine");
        }
        g.iuh.a(434, 0, 1, false);
        OJ();
        String aq = b.aq(this.dzg, "WAService.js");
        g.iuh.a(370, 5, 1, false);
        if (be.kS(aq)) {
            v.e("MicroMsg.AppBrandService", "get Null Or Nil service js");
            g.iuh.a(370, 6, 1, false);
        } else {
            com.tencent.mm.plugin.appbrand.k.c.a(this.mContext, this.dzh, aq, new com.tencent.mm.plugin.appbrand.k.c.a(this) {
                final /* synthetic */ f dzj;

                {
                    this.dzj = r1;
                }

                public final void onSuccess() {
                    this.dzj.dzh.evaluateJavascript("wx.version", new u<String>(this) {
                        final /* synthetic */ AnonymousClass1 dzk;

                        {
                            this.dzk = r1;
                        }

                        public final /* synthetic */ void onReceiveValue(Object obj) {
                            v.i("MicroMsg.AppBrandService", "service inject library ok, wx.version %s", new Object[]{(String) obj});
                        }
                    });
                    g.iuh.a(370, 7, 1, false);
                }

                public final void OK() {
                    v.e("MicroMsg.AppBrandService", "service inject library js fail");
                    g.iuh.a(370, 6, 1, false);
                    com.tencent.mm.plugin.appbrand.report.a.S(this.dzj.dzg, 24);
                }
            });
        }
        aq = b.aq(this.dzg, "app-service.js");
        g.iuh.a(370, 9, 1, false);
        if (be.kS(aq)) {
            v.e("MicroMsg.AppBrandService", "get Null Or Nil app-service js");
            g.iuh.a(370, 10, 1, false);
            return;
        }
        com.tencent.mm.plugin.appbrand.k.c.a(this.mContext, this.dzh, aq, new com.tencent.mm.plugin.appbrand.k.c.a(this) {
            final /* synthetic */ f dzj;

            {
                this.dzj = r1;
            }

            public final void onSuccess() {
                g.iuh.a(370, 11, 1, false);
            }

            public final void OK() {
                v.e("MicroMsg.AppBrandService", "service inject app js fail");
                g.iuh.a(370, 10, 1, false);
                com.tencent.mm.plugin.appbrand.report.a.S(this.dzj.dzg, 24);
            }
        });
    }

    public final void e(String str, String str2, int i) {
        if (be.kS(str2)) {
            str2 = "{}";
        }
        v.d("MicroMsg.AppBrandService", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(i)});
        b bVar = this.dzh;
        String str3 = "typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        objArr[3] = new JSONObject(hashMap).toString();
        bVar.evaluateJavascript(String.format(str3, objArr), null);
    }

    public final void y(int i, String str) {
        if (be.kS(str)) {
            str = "{}";
        }
        v.d("MicroMsg.AppBrandService", "callbackId: %d, data size: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(str.length())});
        this.dzh.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), str}), null);
    }

    public final void a(String str, String str2, int[] iArr) {
        a.a(this.dzg, str, str2, iArr);
    }

    public final int OI() {
        return hashCode();
    }

    public final boolean isRunning() {
        return this.ZO;
    }

    public final void a(a aVar) {
        this.dzi.add(aVar);
    }

    public final void b(a aVar) {
        this.dzi.remove(aVar);
    }

    public final String getAppId() {
        return this.dzg;
    }

    private void OJ() {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = a.mu(this.dzg).dCw;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            str = (String) keys.next();
            try {
                jSONObject.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        String str2 = "debug";
        boolean z = a.mr(this.dzg).dDp && a.mr(this.dzg).dDB.dBr == 1;
        a(jSONObject, str2, Boolean.valueOf(z));
        a(jSONObject, "downloadDomain", a.mr(this.dzg).dDA);
        a(jSONObject, "platform", (Object) "android");
        str = a.mu(this.dzg).dCx;
        this.dzh.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{jSONObject.toString(), str}), null);
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandService", e.getMessage());
        }
    }
}
