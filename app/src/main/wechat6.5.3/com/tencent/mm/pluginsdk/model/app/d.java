package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.ak;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class d implements e {
    Map<Integer, Set<s>> cAd = new HashMap();

    public d() {
        ak.vy().a(452, (e) this);
    }

    public final void a(int i, s sVar) {
        if (!this.cAd.containsKey(Integer.valueOf(i))) {
            this.cAd.put(Integer.valueOf(i), new HashSet());
        }
        if (!((Set) this.cAd.get(Integer.valueOf(i))).contains(sVar)) {
            ((Set) this.cAd.get(Integer.valueOf(i))).add(sVar);
        }
    }

    public final void b(int i, s sVar) {
        if (this.cAd.get(Integer.valueOf(i)) != null) {
            ((Set) this.cAd.get(Integer.valueOf(i))).remove(sVar);
        }
    }

    public static void a(int i, v vVar) {
        ak.vy().a(new w(i, vVar), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w wVar = (w) kVar;
        Set set = (Set) this.cAd.get(Integer.valueOf(wVar.lAE));
        if (set != null && set.size() > 0) {
            Set<s> hashSet = new HashSet();
            hashSet.addAll(set);
            for (s sVar : hashSet) {
                if (sVar != null && set.contains(sVar)) {
                    sVar.a(i, i2, str, wVar.lAF);
                }
            }
        }
    }
}
