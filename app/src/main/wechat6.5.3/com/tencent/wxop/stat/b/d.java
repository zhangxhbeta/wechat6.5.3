package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.wxop.stat.b;
import com.tencent.wxop.stat.f;
import com.tencent.wxop.stat.r;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    static e pLE;
    private static b pLF = l.bQC();
    private static JSONObject pLH = new JSONObject();
    String c = null;
    Integer pLG = null;

    public d(Context context) {
        try {
            gT(context);
            this.pLG = l.hc(context.getApplicationContext());
            this.c = f.gQ(context).c;
        } catch (Throwable th) {
            pLF.i(th);
        }
    }

    private static synchronized e gT(Context context) {
        e eVar;
        synchronized (d.class) {
            if (pLE == null) {
                pLE = new e(context.getApplicationContext());
            }
            eVar = pLE;
        }
        return eVar;
    }

    public final void a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (pLE != null) {
                e eVar = pLE;
                if (thread == null) {
                    if (eVar.pLI != null) {
                        jSONObject2.put("sr", eVar.pLI.widthPixels + "*" + eVar.pLI.heightPixels);
                        jSONObject2.put("dpi", eVar.pLI.xdpi + "*" + eVar.pLI.ydpi);
                    }
                    if (f.gQ(eVar.pLJ).e()) {
                        JSONObject jSONObject3 = new JSONObject();
                        r.a(jSONObject3, "bs", r.d(eVar.pLJ));
                        r.a(jSONObject3, "ss", r.e(eVar.pLJ));
                        if (jSONObject3.length() > 0) {
                            r.a(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray hs = r.hs(eVar.pLJ);
                    if (hs != null && hs.length() > 0) {
                        r.a(jSONObject2, "wflist", hs.toString());
                    }
                    r.a(jSONObject2, "sen", eVar.p);
                } else {
                    r.a(jSONObject2, "thn", thread.getName());
                    r.a(jSONObject2, "qq", b.gF(eVar.pLJ));
                    r.a(jSONObject2, "cui", b.gG(eVar.pLJ));
                    if (l.c(eVar.pLK) && eVar.pLK.split("/").length == 2) {
                        r.a(jSONObject2, "fram", eVar.pLK.split("/")[0]);
                    }
                    if (l.c(eVar.s) && eVar.s.split("/").length == 2) {
                        r.a(jSONObject2, "from", eVar.s.split("/")[0]);
                    }
                    if (r.gR(eVar.pLJ).gS(eVar.pLJ) != null) {
                        jSONObject2.put("ui", r.gR(eVar.pLJ).gS(eVar.pLJ).a);
                    }
                    r.a(jSONObject2, "mid", b.gH(eVar.pLJ));
                }
                r.a(jSONObject2, "pcn", l.hf(eVar.pLJ));
                r.a(jSONObject2, "osn", VERSION.RELEASE);
                r.a(jSONObject2, "av", eVar.a);
                r.a(jSONObject2, "ch", eVar.h);
                r.a(jSONObject2, "mf", eVar.f);
                r.a(jSONObject2, "sv", eVar.b);
                r.a(jSONObject2, "osd", Build.DISPLAY);
                r.a(jSONObject2, "prod", Build.PRODUCT);
                r.a(jSONObject2, "tags", Build.TAGS);
                r.a(jSONObject2, SlookAirButtonFrequentContactAdapter.ID, Build.ID);
                r.a(jSONObject2, "fng", Build.FINGERPRINT);
                r.a(jSONObject2, "lch", eVar.n);
                r.a(jSONObject2, "ov", Integer.toString(eVar.d));
                jSONObject2.put("os", 1);
                r.a(jSONObject2, "op", eVar.i);
                r.a(jSONObject2, "lg", eVar.g);
                r.a(jSONObject2, "md", eVar.e);
                r.a(jSONObject2, "tz", eVar.j);
                if (eVar.l != 0) {
                    jSONObject2.put("jb", eVar.l);
                }
                r.a(jSONObject2, "sd", eVar.k);
                r.a(jSONObject2, "apn", eVar.m);
                r.a(jSONObject2, "cpu", eVar.q);
                r.a(jSONObject2, "abi", Build.CPU_ABI);
                r.a(jSONObject2, "abi2", Build.CPU_ABI2);
                r.a(jSONObject2, "ram", eVar.pLK);
                r.a(jSONObject2, "rom", eVar.s);
            }
            r.a(jSONObject2, "cn", this.c);
            if (this.pLG != null) {
                jSONObject2.put("tn", this.pLG);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (pLH != null && pLH.length() > 0) {
                jSONObject.put("eva", pLH);
            }
        } catch (Throwable th) {
            pLF.i(th);
        }
    }
}
