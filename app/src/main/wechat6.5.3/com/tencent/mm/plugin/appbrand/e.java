package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.e.a.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.t.a;

public final class e {
    private static final c<d> dzf = new c<d>() {
        {
            this.nhz = d.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(((d) bVar).aWo.aWp || ak.yN())) {
                ak.yW();
                long longValue = ((Long) com.tencent.mm.model.c.vf().get(a.nsV, Long.valueOf(0))).longValue();
                long Nh = be.Nh();
                if (Nh >= longValue) {
                    e.sq();
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(a.nsV, Long.valueOf(Nh + 86400));
                }
            }
            return false;
        }
    };

    static /* synthetic */ void sq() {
        com.tencent.mm.plugin.appbrand.k.a.vA().x(j.dAW);
        com.tencent.mm.plugin.appbrand.k.a.vA().x(com.tencent.mm.plugin.appbrand.appstorage.d.dAW);
    }

    public static void setup() {
        com.tencent.mm.sdk.c.a.nhr.d(dzf);
    }

    public static void release() {
        com.tencent.mm.sdk.c.a.nhr.f(dzf);
    }
}
