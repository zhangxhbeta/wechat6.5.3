package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public final class a extends b {
    private String a;
    private int m;
    private int n = 100;
    private Thread pKP = null;

    public a(Context context, int i, Throwable th, e eVar) {
        super(context, i, eVar);
        b(99, th);
    }

    public a(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        b(2, th);
        this.pKP = thread;
    }

    private void b(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.a = stringWriter.toString();
            this.m = i;
            printWriter.close();
        }
    }

    public final boolean L(JSONObject jSONObject) {
        r.a(jSONObject, "er", this.a);
        jSONObject.put("ea", this.m);
        if (this.m == 2 || this.m == 3) {
            new d(this.pKS).a(jSONObject, this.pKP);
        }
        return true;
    }

    public final c bQt() {
        return c.ERROR;
    }
}
