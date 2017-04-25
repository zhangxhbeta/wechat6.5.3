package com.google.android.gms.c;

import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class am extends af<am> {
    public final List<a> azw = new ArrayList();
    public final List<c> azx = new ArrayList();
    public final Map<String, List<a>> azy = new HashMap();
    public b azz;

    public final /* synthetic */ void a(af afVar) {
        am amVar = (am) afVar;
        amVar.azw.addAll(this.azw);
        amVar.azx.addAll(this.azx);
        for (Entry entry : this.azy.entrySet()) {
            String str = (String) entry.getKey();
            for (a aVar : (List) entry.getValue()) {
                if (aVar != null) {
                    Object obj;
                    if (str == null) {
                        obj = "";
                    } else {
                        String str2 = str;
                    }
                    if (!amVar.azy.containsKey(obj)) {
                        amVar.azy.put(obj, new ArrayList());
                    }
                    ((List) amVar.azy.get(obj)).add(aVar);
                }
            }
        }
        if (this.azz != null) {
            amVar.azz = this.azz;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        if (!this.azw.isEmpty()) {
            hashMap.put("products", this.azw);
        }
        if (!this.azx.isEmpty()) {
            hashMap.put("promotions", this.azx);
        }
        if (!this.azy.isEmpty()) {
            hashMap.put("impressions", this.azy);
        }
        hashMap.put("productAction", this.azz);
        return af.ac(hashMap);
    }
}
