package com.tencent.c.a.a;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

final class m {
    private int aOI = 0;
    private JSONObject aOJ = null;
    protected Context context = null;

    m(Context context, JSONObject jSONObject) {
        this.context = context;
        this.aOI = (int) (System.currentTimeMillis() / 1000);
        this.aOJ = jSONObject;
    }

    final JSONObject nT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.aOI);
            jSONObject.put("si", this.aOI);
            s.b(jSONObject, "ui", s.V(this.context));
            s.b(jSONObject, "mc", s.W(this.context));
            String nR = i.R(this.context).nR();
            if (s.aN(nR)) {
                jSONObject.put("mid", nR);
            } else {
                jSONObject.put("mid", "0");
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (b.aOg != null) {
                    a aVar = b.aOg;
                    jSONObject2.put("sr", new StringBuilder(String.valueOf(aVar.aOl.widthPixels)).append("*").append(aVar.aOl.heightPixels).toString());
                    s.b(jSONObject2, "av", aVar.aOj);
                    s.b(jSONObject2, "ch", aVar.aOp);
                    s.b(jSONObject2, "mf", aVar.aOn);
                    s.b(jSONObject2, "sv", aVar.aOk);
                    s.b(jSONObject2, "ov", Integer.toString(aVar.aOm));
                    jSONObject2.put("os", 1);
                    s.b(jSONObject2, "op", aVar.aOq);
                    s.b(jSONObject2, "lg", aVar.aOo);
                    s.b(jSONObject2, "md", aVar.model);
                    s.b(jSONObject2, "tz", aVar.timezone);
                    if (aVar.aOs != 0) {
                        jSONObject2.put("jb", aVar.aOs);
                    }
                    s.b(jSONObject2, "sd", aVar.aOr);
                    s.b(jSONObject2, "apn", aVar.packageName);
                    if (s.U(aVar.ctx)) {
                        JSONObject jSONObject3 = new JSONObject();
                        s.b(jSONObject3, "bs", s.X(aVar.ctx));
                        s.b(jSONObject3, "ss", s.Y(aVar.ctx));
                        if (jSONObject3.length() > 0) {
                            s.b(jSONObject2, "wf", jSONObject3.toString());
                        }
                    }
                    JSONArray Z = s.Z(aVar.ctx);
                    if (Z != null && Z.length() > 0) {
                        s.b(jSONObject2, "wflist", Z.toString());
                    }
                    s.b(jSONObject2, "ram", aVar.aOt);
                    s.b(jSONObject2, "rom", aVar.aOu);
                    s.b(jSONObject2, "im", aVar.imsi);
                }
                s.b(jSONObject2, "cn", bVar.aOi);
                if (bVar.aOh != null) {
                    jSONObject2.put("tn", bVar.aOh);
                }
                jSONObject.put("ev", jSONObject2);
            } catch (Throwable th) {
            }
            if (this.aOJ != null) {
                jSONObject.put("ext", this.aOJ);
            }
        } catch (Throwable th2) {
        }
        return jSONObject;
    }
}
