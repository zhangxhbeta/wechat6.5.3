package com.tencent.mm.al;

import com.tencent.mm.e.a.bn;
import com.tencent.mm.e.a.pv;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    Map<Integer, Object<?>> cUq = new ConcurrentHashMap();
    public c cUr = new c<pv>(this) {
        final /* synthetic */ l cUt;

        {
            this.cUt = r2;
            this.nhz = pv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.cUt.cUq.get(Integer.valueOf(((pv) bVar).bre.aZc));
            return false;
        }
    };
    public c cUs = new c<bn>(this) {
        final /* synthetic */ l cUt;

        {
            this.cUt = r2;
            this.nhz = bn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.cUt.cUq.get(Integer.valueOf(((bn) bVar).aZb.aZc));
            return false;
        }
    };
}
