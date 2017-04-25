package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.e;
import com.tencent.wxop.stat.r;
import org.json.JSONObject;

public abstract class b {
    protected static String j = null;
    protected String b = null;
    protected long c;
    protected int d;
    protected int f;
    protected String g = null;
    protected String h = null;
    protected String i = null;
    protected c pKQ = null;
    protected boolean pKR = false;
    protected Context pKS;
    public e pKT = null;

    b(Context context, int i, e eVar) {
        this.pKS = context;
        this.c = System.currentTimeMillis() / 1000;
        this.d = i;
        this.h = com.tencent.wxop.stat.b.gE(context);
        this.i = l.ha(context);
        this.b = com.tencent.wxop.stat.b.gD(context);
        if (eVar != null) {
            this.pKT = eVar;
            if (l.c(eVar.a)) {
                this.b = eVar.a;
            }
            if (l.c(eVar.b)) {
                this.h = eVar.b;
            }
            if (l.c(eVar.c)) {
                this.i = eVar.c;
            }
            this.pKR = eVar.e;
        }
        this.g = com.tencent.wxop.stat.b.gG(context);
        this.pKQ = r.gR(context).gS(context);
        if (bQt() != c.NETWORK_DETECTOR) {
            this.f = l.hh(context).intValue();
        } else {
            this.f = -c.NETWORK_DETECTOR.j;
        }
        if (!h.c(j)) {
            String gH = com.tencent.wxop.stat.b.gH(context);
            j = gH;
            if (!l.c(gH)) {
                j = "0";
            }
        }
    }

    private boolean M(JSONObject jSONObject) {
        boolean z = false;
        try {
            com.tencent.wxop.stat.b.r.a(jSONObject, "ky", this.b);
            jSONObject.put("et", bQt().j);
            if (this.pKQ != null) {
                jSONObject.put("ui", this.pKQ.a);
                com.tencent.wxop.stat.b.r.a(jSONObject, "mc", this.pKQ.b);
                int i = this.pKQ.e;
                jSONObject.put("ut", i);
                if (i == 0 && l.hk(this.pKS) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            com.tencent.wxop.stat.b.r.a(jSONObject, "cui", this.g);
            if (bQt() != c.SESSION_ENV) {
                com.tencent.wxop.stat.b.r.a(jSONObject, "av", this.i);
                com.tencent.wxop.stat.b.r.a(jSONObject, "ch", this.h);
            }
            if (this.pKR) {
                jSONObject.put("impt", 1);
            }
            com.tencent.wxop.stat.b.r.a(jSONObject, "mid", j);
            jSONObject.put("idx", this.f);
            jSONObject.put("si", this.d);
            jSONObject.put("ts", this.c);
            jSONObject.put("dts", l.v(this.pKS, false));
            z = L(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    public abstract boolean L(JSONObject jSONObject);

    public final Context bQo() {
        return this.pKS;
    }

    public abstract c bQt();

    public final long c() {
        return this.c;
    }

    public final boolean f() {
        return this.pKR;
    }

    public final String g() {
        try {
            JSONObject jSONObject = new JSONObject();
            M(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
