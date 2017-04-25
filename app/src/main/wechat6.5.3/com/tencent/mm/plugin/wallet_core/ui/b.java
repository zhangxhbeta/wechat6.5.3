package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum b {
    ;
    
    private Map<String, WeakReference<a>> kRO;

    private b(String str) {
        this.kRO = new HashMap();
    }

    public final a a(Orders orders) {
        String str;
        if (orders == null || orders.kPm == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < orders.kPm.size(); i++) {
                stringBuilder.append(((Commodity) orders.kPm.get(i)).eWA);
            }
            stringBuilder.append("@");
            stringBuilder.append(orders.kOT);
            str = stringBuilder.toString();
        }
        if (be.kS(str)) {
            v.w("MicroMsg.FavorLogicHelperPool", "get key null");
            return null;
        }
        if (this.kRO.containsKey(str)) {
            v.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:" + str);
            WeakReference weakReference = (WeakReference) this.kRO.get(str);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    return aVar;
                }
                v.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                v.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.kPn == null) {
            return null;
        }
        a aVar2 = new a(orders.kPn);
        this.kRO.put(str, new WeakReference(aVar2));
        return aVar2;
    }
}
