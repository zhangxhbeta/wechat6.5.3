package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends c<jx> {
    public g() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (ak.uz()) {
            h.azg();
            ak.yW();
            if (be.ay(be.a((Long) com.tencent.mm.model.c.vf().get(102409, null), 0)) > 900000) {
                h.azg().azb();
                h.azg();
                c.ch(be.Ni());
            } else {
                v.d("MicroMsg.PostTaskMassSendListener", "time limit");
            }
        } else {
            v.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
        }
        return false;
    }
}
