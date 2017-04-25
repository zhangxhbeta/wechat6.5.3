package com.tencent.c.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    private static r aOR = null;
    private Map<Integer, q> aOP;
    private int aOQ;

    private r(Context context) {
        this.aOP = null;
        this.aOQ = 0;
        this.aOP = new HashMap(3);
        this.aOP.put(Integer.valueOf(1), new o(context));
        this.aOP.put(Integer.valueOf(2), new d(context));
        this.aOP.put(Integer.valueOf(4), new k(context));
    }

    static synchronized r T(Context context) {
        r rVar;
        synchronized (r.class) {
            if (aOR == null) {
                aOR = new r(context);
            }
            rVar = aOR;
        }
        return rVar;
    }

    final g nV() {
        return o(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    final g o(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                q qVar = (q) this.aOP.get(num);
                if (qVar != null) {
                    g nV = qVar.nV();
                    if (nV != null && s.aN(nV.aOx)) {
                        return nV;
                    }
                }
            }
        }
        return new g();
    }

    final a nW() {
        return p(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(4)})));
    }

    private a p(List<Integer> list) {
        if (list.size() > 0) {
            for (Integer num : list) {
                q qVar = (q) this.aOP.get(num);
                if (qVar != null) {
                    a nW = qVar.nW();
                    if (nW != null) {
                        return nW;
                    }
                }
            }
        }
        return new a();
    }

    final void b(a aVar) {
        for (Entry value : this.aOP.entrySet()) {
            ((q) value.getValue()).b(aVar);
        }
    }

    final void b(g gVar) {
        for (Entry value : this.aOP.entrySet()) {
            ((q) value.getValue()).b(gVar);
        }
    }
}
