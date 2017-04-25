package com.tencent.mm.al;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<jx> {
    public o() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ak.yW();
        if (be.ax(be.a((Long) com.tencent.mm.model.c.vf().get(66818, null), 0)) * 1000 > 1800000) {
            ak.yW();
            int a = be.a((Integer) com.tencent.mm.model.c.vf().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                bl.p(9, String.valueOf(a));
                ak.yW();
                com.tencent.mm.model.c.vf().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            ak.yW();
            com.tencent.mm.model.c.vf().set(66818, Long.valueOf(be.Nh()));
        }
        return false;
    }
}
