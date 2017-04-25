package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.k.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public a dCs;
    public Map<String, c> dCt;
    public d dCu;
    public b dCv;
    public JSONObject dCw;
    public String dCx;

    public static class a {
        public String dCA;
        public String dCB;
        public boolean dCC;
        public boolean dCD;
        public String dCE;
        public String dCy;
        public String dCz;
    }

    public static class b {
        public int bfw;
        public int dCF;
        public int dCG;
        public int dCH;
    }

    public static class c {
        public String dCA;
        public String dCB;
        public boolean dCC;
        public boolean dCD;
        public String dCE;
        public ArrayList<String> dCI;
        public String dCy;
        public String dCz;
    }

    public static class d {
        public ArrayList<e> bjA = new ArrayList();
        public String coN;
        public String dCB;
        public String dCJ;
        public String dCK;
        public String dCL;

        public final boolean mZ(String str) {
            Iterator it = this.bjA.iterator();
            while (it.hasNext()) {
                if (((e) it.next()).url.equals(j.ov(str))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class e {
        public String bll;
        public String dCM;
        public String text;
        public String url;
    }

    public final String Pv() {
        if (be.kS(this.dCx)) {
            return "index.html";
        }
        return this.dCx;
    }

    public static a mY(String str) {
        JSONObject jSONObject;
        a aVar = new a();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.dCx = jSONObject.optString("entryPagePath");
        aVar.dCw = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        a aVar2 = new a();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        optJSONObject = optJSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        aVar2.dCy = optJSONObject.optString("navigationBarTitleText");
        aVar2.dCz = optJSONObject.optString("navigationBarTextStyle");
        aVar2.dCA = optJSONObject.optString("navigationBarBackgroundColor");
        aVar2.dCB = optJSONObject.optString("backgroundColor");
        aVar2.dCD = optJSONObject.optBoolean("enablePullDownRefresh");
        aVar2.dCE = optJSONObject.optString("backgroundTextStyle");
        aVar2.dCC = optJSONObject.optBoolean("fullScreen", false);
        aVar.dCs = aVar2;
        aVar.dCt = a(jSONObject.optJSONObject("page"), aVar.dCs);
        aVar.dCu = c(jSONObject.optJSONObject("tabBar"));
        jSONObject = jSONObject.optJSONObject("networkTimeout");
        b bVar = new b();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        bVar.bfw = jSONObject.optInt(bc.NAME);
        bVar.dCF = jSONObject.optInt(o.NAME);
        bVar.dCH = jSONObject.optInt(p.NAME);
        bVar.dCG = jSONObject.optInt(bv.NAME);
        aVar.dCv = bVar;
        return aVar;
    }

    private static Map<String, c> a(JSONObject jSONObject, a aVar) {
        Map<String, c> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), aVar));
        }
        return hashMap;
    }

    public static c b(JSONObject jSONObject, a aVar) {
        c cVar = new c();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.dCy = optJSONObject.optString("navigationBarTitleText", aVar.dCy);
        cVar.dCz = optJSONObject.optString("navigationBarTextStyle", aVar.dCz);
        cVar.dCA = optJSONObject.optString("navigationBarBackgroundColor", aVar.dCA);
        cVar.dCB = optJSONObject.optString("backgroundColor", aVar.dCB);
        cVar.dCC = optJSONObject.optBoolean("fullScreen", aVar.dCC);
        cVar.dCD = optJSONObject.optBoolean("enablePullDownRefresh", aVar.dCD);
        cVar.dCE = optJSONObject.optString("backgroundTextStyle", aVar.dCE);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("cssFiles");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        cVar.dCI = arrayList;
        return cVar;
    }

    private static d c(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        d dVar = new d();
        dVar.dCJ = jSONObject.optString("position");
        dVar.coN = jSONObject.optString("color");
        dVar.dCK = jSONObject.optString("selectedColor");
        dVar.dCB = jSONObject.optString("backgroundColor");
        dVar.dCL = jSONObject.optString("borderStyle");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList = dVar.bjA;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                e eVar = new e();
                eVar.url = jSONObject2.optString("pagePath");
                eVar.text = jSONObject2.optString("text");
                eVar.bll = jSONObject2.optString("iconData");
                eVar.dCM = jSONObject2.optString("selectedIconData");
                arrayList.add(eVar);
            }
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        return dVar;
    }
}
