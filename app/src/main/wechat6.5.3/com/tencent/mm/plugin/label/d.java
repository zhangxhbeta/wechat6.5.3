package com.tencent.mm.plugin.label;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends c<jx> {
    public d() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ak.yW();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            v.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            ak.vy().a(new com.tencent.mm.plugin.label.a.c(), 0);
            ak.yW();
            com.tencent.mm.model.c.vf().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        return false;
    }
}
