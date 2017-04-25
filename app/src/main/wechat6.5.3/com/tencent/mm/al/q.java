package com.tencent.mm.al;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class q extends c<jx> {
    private static long bYq = 86400000;

    public q() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return HP();
    }

    private static boolean HP() {
        v.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + qh());
        if (qh()) {
            c.HL().update();
        }
        return false;
    }

    private static boolean qh() {
        ak.yW();
        if (be.ax(Long.valueOf(be.d((Long) com.tencent.mm.model.c.vf().get(81938, null))).longValue()) * 1000 > bYq) {
            return true;
        }
        return false;
    }
}
