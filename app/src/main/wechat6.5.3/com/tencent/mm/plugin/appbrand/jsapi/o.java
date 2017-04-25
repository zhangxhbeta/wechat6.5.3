package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.g.i;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.g.j.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.g.j.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.g.j.a;
import com.tencent.mm.plugin.appbrand.g.k;
import com.tencent.mm.plugin.appbrand.l.b.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public final class o extends a {
    public static final int CTRL_INDEX = 20;
    public static final String NAME = "connectSocket";

    public final void a(final f fVar, JSONObject jSONObject, final int i) {
        j nR = a.dMK.nR(fVar.dzg);
        if (nR != null) {
            if (nR.dMG != null ? nR.dMG.dTO.isOpen() : false) {
                v.i("MicroMsg.JsApiConnectSocket", "the already appid has a websocket");
                Map hashMap = new HashMap();
                hashMap.put("message", "websocket is connected");
                fVar.e("onSocketError", new JSONObject(hashMap).toString(), 0);
                return;
            }
        }
        if (nR != null) {
            a.dMK.nS(fVar.dzg);
        }
        nR = new j();
        a anonymousClass1 = new a(this) {
            final /* synthetic */ o dGc;

            public final void Qa() {
                k QU = a.dMK;
                String str = fVar.dzg;
                j jVar = nR;
                if (!QU.dMl.containsKey(str)) {
                    QU.dMl.put(str, jVar);
                }
                fVar.e("onSocketOpen", null, 0);
            }

            public final void nw(String str) {
                Map hashMap = new HashMap();
                hashMap.put("message", str);
                fVar.e("onSocketError", new JSONObject(hashMap).toString(), 0);
            }

            public final void nx(String str) {
                Map hashMap = new HashMap();
                hashMap.put("data", str);
                fVar.e("onSocketMessage", new JSONObject(hashMap).toString(), 0);
            }

            public final void a(ByteBuffer byteBuffer) {
                Map hashMap = new HashMap();
                try {
                    hashMap.put("data", new String(Base64.encode(byteBuffer.array(), 2), ProtocolPackage.ServerEncoding));
                    hashMap.put("isBuffer", Boolean.valueOf(true));
                    fVar.e("onSocketMessage", new JSONObject(hashMap).toString(), 0);
                } catch (UnsupportedEncodingException e) {
                    v.e("MicroMsg.JsApiConnectSocket", "create string by buffer error. exception : %s", new Object[]{e});
                }
            }

            public final void Qb() {
                a.dMK.nS(fVar.dzg);
                fVar.e("onSocketClose", null, 0);
            }

            public final void ny(String str) {
                if (be.kS(str)) {
                    fVar.y(i, this.dGc.c("fail", null));
                } else {
                    fVar.y(i, this.dGc.c("fail:" + str, null));
                }
            }

            public final void Qc() {
                fVar.y(i, this.dGc.c("ok", null));
            }
        };
        com.tencent.mm.plugin.appbrand.config.a mu = com.tencent.mm.plugin.appbrand.a.mu(fVar.dzg);
        String optString = jSONObject.optString("url");
        if (be.kS(optString)) {
            v.i("MicroMsg.JsApiConnectSocket", "url is null");
            fVar.y(i, c("fail", null));
            return;
        }
        v.i("MicroMsg.JsApiConnectSocket", "url is " + optString);
        AppBrandSysConfig mr = com.tencent.mm.plugin.appbrand.a.mr(fVar.dzg);
        Map a = i.a(jSONObject, mr);
        if (!i.d(mr) || i.b(mr.dDy, optString)) {
            int a2 = i.a(mr, mu, 1);
            if (a2 <= 0) {
                a2 = 60000;
            }
            v.i("MicroMsg.JsApiConnectSocket", "send request ok, url is : %s ,appid: %s", new Object[]{optString, mr.appId});
            String optString2 = jSONObject.optString("url");
            try {
                URI uri = new URI(optString2);
                v.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d", new Object[]{optString2, Integer.valueOf(a2)});
                a.put("User-Agent", s.aW(aa.getContext(), ""));
                try {
                    nR.dMG = new com.tencent.mm.plugin.appbrand.g.j.AnonymousClass1(nR, uri, new c(), a, a2, optString2, anonymousClass1);
                    ah ahVar;
                    if (s.ds(optString2, "ws://")) {
                        v.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[]{optString2});
                        nR.dMG.a(new Socket(Proxy.NO_PROXY));
                        nR.dMG.connect();
                        anonymousClass1.Qc();
                        j.QI();
                        ahVar = new ah(new AnonymousClass2(nR, anonymousClass1), false);
                        j.dMH = ahVar;
                        ahVar.ea((long) a2);
                        return;
                    } else if (s.ds(optString2, "wss://")) {
                        v.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[]{optString2});
                        nR.dMG.a(((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket());
                        nR.dMG.connect();
                        anonymousClass1.Qc();
                        j.QI();
                        ahVar = new ah(new AnonymousClass3(nR, anonymousClass1), false);
                        j.dMH = ahVar;
                        ahVar.ea((long) a2);
                        return;
                    } else {
                        v.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[]{optString2});
                        anonymousClass1.ny("url not ws or wss");
                        return;
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.AppBrandNetworkWebSocket", "url %s exception %s", new Object[]{optString2, e.toString()});
                    anonymousClass1.nw("");
                    return;
                }
            } catch (Exception e2) {
                v.e("MicroMsg.AppBrandNetworkWebSocket", "connect fail : %s ", new Object[]{e2.toString()});
                anonymousClass1.ny("url not well format");
                return;
            }
        }
        fVar.y(i, c("fail:url not in domain list", null));
        v.i("MicroMsg.JsApiConnectSocket", "not in domain url %s", new Object[]{optString});
    }
}
