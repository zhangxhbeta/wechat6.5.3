package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g {
    private static g aNX = null;
    private Map<Integer, f> a = null;
    private int b = 0;
    private Context c = null;

    private g(Context context) {
        this.c = context.getApplicationContext();
        this.a = new HashMap(3);
        this.a.put(Integer.valueOf(1), new e(context));
        this.a.put(Integer.valueOf(2), new b(context));
        this.a.put(Integer.valueOf(4), new d(context));
    }

    public static synchronized g P(Context context) {
        g gVar;
        synchronized (g.class) {
            if (aNX == null) {
                aNX = new g(context);
            }
            gVar = aNX;
        }
        return gVar;
    }

    private c n(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                f fVar = (f) this.a.get(num);
                if (fVar != null) {
                    c nK = fVar.nK();
                    if (nK != null && h.c(nK.c)) {
                        return nK;
                    }
                }
            }
        }
        return new c();
    }

    public final void a(String str) {
        c nL = nL();
        nL.c = str;
        if (!h.b(nL.a)) {
            nL.a = h.a(this.c);
        }
        if (!h.b(nL.b)) {
            nL.b = h.b(this.c);
        }
        nL.d = System.currentTimeMillis();
        for (Entry value : this.a.entrySet()) {
            ((f) value.getValue()).a(nL);
        }
    }

    public final c nL() {
        return n(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }
}
