package com.tencent.mm.plugin.sns;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public final class f extends c<jx> {
    public f() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((jx) bVar) instanceof jx)) {
            v.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            return false;
        } else if (ad.aSn()) {
            return false;
        } else {
            v.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (ad.aSA() != null) {
                ad.aSA().aTe();
            }
            v.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (ad.aSu() != null) {
                ad.aSD().aSf();
            }
            int i = (!ak.uz() || ak.uG()) ? 0 : 1;
            if (i != 0) {
                ak.yW();
                if ((be.ax(be.a((Long) com.tencent.mm.model.c.vf().get(68390, null), 0)) * 1000 > 3600000 ? 1 : 0) != 0) {
                    List linkedList = new LinkedList();
                    ak.yW();
                    int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68388, null), 0);
                    ak.yW();
                    i = be.a((Integer) com.tencent.mm.model.c.vf().get(68389, null), 0);
                    if (a > 0 || i > 0) {
                        linkedList.add(new a(10077, a + "," + i));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68388, Integer.valueOf(0));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68389, Integer.valueOf(0));
                    }
                    ak.yW();
                    i = be.a((Integer) com.tencent.mm.model.c.vf().get(68391, null), 0);
                    if (i > 0) {
                        linkedList.add(new a(28, String.valueOf(i)));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68391, Integer.valueOf(0));
                    }
                    ak.yW();
                    a = be.a((Integer) com.tencent.mm.model.c.vf().get(68392, null), 0);
                    ak.yW();
                    i = be.a((Integer) com.tencent.mm.model.c.vf().get(68393, null), 0);
                    if (a > 0 || i > 0) {
                        linkedList.add(new a(10072, a + "," + i));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68392, Integer.valueOf(0));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68393, Integer.valueOf(0));
                    }
                    if (!linkedList.isEmpty()) {
                        ak.yW();
                        com.tencent.mm.model.c.wG().b(new i(linkedList));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68390, Long.valueOf(be.Nh()));
                    }
                }
            }
            return true;
        }
    }
}
