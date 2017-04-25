package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument;
import com.tencent.mm.plugin.appbrand.jsapi.file.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.b;
import com.tencent.mm.plugin.appbrand.jsapi.file.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandJSInterface {
    private String aWQ;
    private c dEM;
    private Map<String, d> dEN;
    private Handler dEO;
    private String dzg;
    private Context mContext;
    private long startTime;

    public AppBrandJSInterface(f fVar) {
        this.dzg = fVar.dzg;
        this.dEM = fVar;
        f.dEZ = new HashMap();
        f.a(new l());
        f.a(new aa());
        f.a(new bi());
        f.a(new m());
        f.a(new ad());
        f.a(new bj());
        f.a(new bc());
        f.a(new o());
        f.a(new bf());
        f.a(new n());
        f.a(new JsApiLogin());
        f.a(new JsApiAuthorize());
        f.a(new JsApiOperateWXData());
        f.a(new bh());
        f.a(new an());
        f.a(new as());
        f.a(new am());
        f.a(new JsApiChooseImage());
        f.a(new bv());
        f.a(new p());
        f.a(new ar());
        f.a(new JsApiChooseVideo());
        f.a(new JsApiStartRecordVoice());
        f.a(new JsApiStopRecordVoice());
        f.a(new JsApiStartPlayVoice());
        f.a(new JsApiPausePlayVoice());
        f.a(new JsApiStopPlayVoice());
        f.a(new JsApiGetLocation());
        f.a(new aq());
        f.a(new y());
        f.a(new JsApiGetMusicPlayerState());
        f.a(new JsApiOperateMusicPlayer());
        f.a(new JsApiScanCode());
        f.a(new bd());
        f.a(new ao());
        f.a(new ax());
        f.a(new bw());
        f.a(new h());
        f.a(new bc());
        f.a(new d());
        f.a(new c());
        f.a(new a());
        f.a(new b());
        f.a(new j());
        f.a(new bq());
        f.a(new bn());
        f.a(new ag());
        f.a(new q());
        f.a(new aj());
        f.a(new at());
        f.a(new bt());
        f.a(new JsApiShareAppMessage());
        f.a(new bk());
        f.a(new ae());
        f.a(new ay());
        f.a(new ba());
        f.a(new az());
        f.a(new bs());
        f.a(new bg());
        f.a(new z());
        f.a(new g());
        f.a(new r());
        f.a(new s());
        f.a(new av());
        f.a(new aw());
        f.a(new JsApiOpenDocument());
        f.a(new i());
        f.a(new bm());
        f.a(new bl());
        f.a(new bp());
        f.a(new ah());
        f.a(new u());
        f.a(new al());
        f.a(new ab());
        f.a(new ac());
        f.a(new k());
        f.a(new x());
        f.a(new JsApiRefreshSession());
        f.a(new br());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.f());
        f.a(new i());
        f.a(new be());
        f.a(new bo());
        this.dEN = f.dEZ;
        PU();
    }

    public AppBrandJSInterface(h hVar) {
        this.dzg = hVar.dzg;
        this.dEM = hVar;
        f.dFa = new HashMap();
        f.b(new ap());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.h());
        f.b(new j());
        f.b(new k());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
        f.b(new g());
        f.b(new e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
        f.b(new ai());
        f.b(new ax());
        f.b(new ay());
        f.b(new ba());
        f.b(new az());
        f.b(new bb());
        f.b(new bs());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
        f.b(new by());
        f.b(new ca());
        f.b(new bz());
        f.b(new w());
        f.b(new z());
        f.b(new q());
        f.b(new aj());
        f.b(new at());
        f.b(new bt());
        f.b(new ak());
        f.b(new au());
        f.b(new bu());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.d());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.g());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.c());
        f.b(new t());
        this.dEN = f.dFa;
        PU();
    }

    private void PU() {
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.dEO = new Handler(handlerThread.getLooper());
    }

    public final void OE() {
        this.dEO.getLooper().quit();
    }

    @JavascriptInterface
    public void publishHandler(final String str, final String str2, final String str3) {
        int i = 0;
        this.dEO.post(new Runnable(this) {
            final /* synthetic */ AppBrandJSInterface dES;

            public final void run() {
                this.dES.dEM.a(str, str2, AppBrandJSInterface.nq(str3));
            }
        });
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        v.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public String invokeHandler(final String str, final String str2, final int i) {
        int i2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = this.dzg;
        this.startTime = System.currentTimeMillis();
        com.tencent.mm.plugin.appbrand.page.f mp = com.tencent.mm.plugin.appbrand.a.mp(str3);
        str3 = (mp == null || mp.Rm() == null) ? "" : mp.Rm().Ra();
        this.aWQ = str3;
        Context context = (mp == null || mp.Rm() == null) ? null : mp.Rm().getContext();
        this.mContext = context;
        boolean z = this.dEN.get(str) instanceof g;
        if (z) {
            str3 = A(str, str2, i);
        } else {
            this.dEO.post(new Runnable(this) {
                final /* synthetic */ AppBrandJSInterface dES;

                public final void run() {
                    this.dES.h(str, str2, i);
                }
            });
            str3 = "";
        }
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        if (str2 != null) {
            i2 = str2.length();
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        v.d(str4, str5, objArr);
        return str3;
    }

    private String A(String str, String str2, int i) {
        try {
            return h(str, str2, i);
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandJSInterface", "Invoke Error: %s, %s", new Object[]{str, e.getMessage()});
            throw e;
        }
    }

    private String h(String str, final String str2, final int i) {
        String str3;
        d dVar = (d) this.dEN.get(str);
        boolean z = dVar instanceof g;
        String aI;
        if (dVar == null) {
            aI = aI(str, "fail:not supported");
            a(this.dzg, str, str2, "fail:not supported", 2);
            str3 = aI;
        } else {
            Object obj = (dVar == null || !(com.tencent.mm.plugin.appbrand.h.b.b(this.dzg, dVar) || com.tencent.mm.plugin.appbrand.h.a.aR(this.dzg, dVar.getName()))) ? null : 1;
            a aVar;
            if (obj == null) {
                if (dVar instanceof a) {
                    Object obj2;
                    final String name;
                    int i2;
                    aVar = (a) dVar;
                    if (aVar != null) {
                        if (com.tencent.mm.plugin.appbrand.h.b.a(this.dzg, aVar) == 4) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            obj = 1;
                            if (obj != null) {
                                obj2 = null;
                            } else {
                                name = aVar.getName();
                                com.tencent.mm.plugin.appbrand.h.a.a(this.dzg, aVar.getName(), new com.tencent.mm.plugin.appbrand.h.a.a(this) {
                                    final /* synthetic */ AppBrandJSInterface dES;

                                    public final void PV() {
                                        if (this.dES.dEM != null && this.dES.dEM.isRunning()) {
                                            this.dES.dEO.post(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass3 dEX;

                                                {
                                                    this.dEX = r1;
                                                }

                                                public final void run() {
                                                    this.dEX.dES.h(name, str2, i);
                                                }
                                            });
                                        }
                                    }

                                    public final void PW() {
                                        ns("fail auth deny");
                                    }

                                    public final void onCancel() {
                                        ns("fail auth cancel");
                                    }

                                    private void ns(String str) {
                                        if (this.dES.dEM != null && this.dES.dEM.isRunning()) {
                                            this.dES.dEM.y(i, AppBrandJSInterface.aI(name, str));
                                        }
                                    }
                                });
                                i2 = 1;
                            }
                            if (obj2 != null) {
                                return null;
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        name = aVar.getName();
                        com.tencent.mm.plugin.appbrand.h.a.a(this.dzg, aVar.getName(), /* anonymous class already generated */);
                        i2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        return null;
                    }
                }
                aI = aI(str, "fail:access denied");
                a(this.dzg, str, str2, "fail:access denied", 2);
                str3 = aI;
            } else {
                JSONObject np = np(str2);
                if (np == null) {
                    aI = aI(str, "fail:invalid data");
                    a(this.dzg, str, str2, "fail:invalid data", 2);
                    str3 = aI;
                } else {
                    c cVar;
                    if (z) {
                        g gVar = (g) dVar;
                        cVar = this.dEM;
                        String a = cVar instanceof f ? gVar.a((f) cVar, np) : cVar instanceof h ? gVar.a((h) cVar) : "";
                        aI = a;
                    } else {
                        aVar = (a) dVar;
                        cVar = this.dEM;
                        if (cVar instanceof f) {
                            aVar.a((f) cVar, np, i);
                            aI = null;
                        } else {
                            if (cVar instanceof h) {
                                aVar.a((h) cVar, np, i);
                            }
                            aI = null;
                        }
                    }
                    a(this.dzg, str, str2, "", 1);
                    str3 = aI;
                }
            }
        }
        if (z) {
            return str3;
        }
        if (str3 != null) {
            this.dEM.y(i, str3);
        }
        return "";
    }

    private static JSONObject np(String str) {
        try {
            if (be.kS(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return null;
        }
    }

    private static String aI(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    private static int[] nq(String str) {
        int[] iArr;
        Exception e;
        int[] iArr2 = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    iArr[i] = jSONArray.getInt(i);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            iArr = iArr2;
            e = exception;
            v.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return iArr;
        }
        return iArr;
    }

    private void a(String str, String str2, String str3, String str4, int i) {
        b bVar = (b) this.dEN.get(str2);
        com.tencent.mm.plugin.appbrand.report.a.a(this.mContext, str, this.aWQ, str2, str3, i, bVar == null ? 0 : com.tencent.mm.plugin.appbrand.h.b.a(str, bVar), System.currentTimeMillis() - this.startTime, str4);
    }
}
