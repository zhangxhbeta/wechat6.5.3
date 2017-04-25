package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public class c extends a {
    public final void aYP() {
        v.i("MicroMsg.SoterProcessGenASK", "hy: start gen ask process");
        if (k.aYJ()) {
            e.a(new Runnable(this) {
                final /* synthetic */ c kdA;

                {
                    this.kdA = r1;
                }

                public final void run() {
                    final int aYK = k.aYK();
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 kdB;

                        public final void run() {
                            this.kdB.kdA.rl(aYK);
                        }
                    });
                }
            }, c.class.getName());
            return;
        }
        v.w("MicroMsg.SoterProcessGenASK", "hy: not support soter");
        rl(3);
    }
}
