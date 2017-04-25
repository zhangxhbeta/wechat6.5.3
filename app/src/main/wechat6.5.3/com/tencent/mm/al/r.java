package com.tencent.mm.al;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;

public final class r extends c<jx> {
    private static long bYq = 604800000;

    public r() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ak.yW();
        if (be.ax(Long.valueOf(be.d((Long) com.tencent.mm.model.c.vf().get(81937, null))).longValue()) * 1000 > bYq) {
            s.HQ().update();
        }
        return false;
    }
}
