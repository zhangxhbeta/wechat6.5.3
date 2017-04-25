package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class q {
    public HashMap<Integer, a> lco = new HashMap();

    public final void a(a aVar) {
        for (Integer intValue : aVar.bhU()) {
            v.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[]{Integer.valueOf(intValue.intValue()), aVar});
            this.lco.put(Integer.valueOf(r0), aVar);
        }
    }

    public final a sD(int i) {
        return (a) this.lco.get(Integer.valueOf(i));
    }
}
