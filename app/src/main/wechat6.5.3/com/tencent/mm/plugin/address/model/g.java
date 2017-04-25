package com.tencent.mm.plugin.address.model;

import com.tencent.mm.e.a.kj;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends c<kj> {
    public g() {
        this.nhz = kj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kj kjVar = (kj) bVar;
        v.d("MicroMsg.RcptAddressEventListener", "revent " + kjVar.blv.blx);
        ak.yW();
        j.dz(kjVar.blv.blx, com.tencent.mm.model.c.xq() + "address");
        return false;
    }
}
