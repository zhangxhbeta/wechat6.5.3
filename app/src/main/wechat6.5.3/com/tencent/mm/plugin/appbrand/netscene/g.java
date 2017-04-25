package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.plugin.appbrand.k.h;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;
import java.util.concurrent.CountDownLatch;

public final class g {

    public static class a<T extends aqx> extends com.tencent.mm.v.a.a<T> {
        public a() {
            this.errType = 3;
            this.errCode = -13;
        }
    }

    public static <T extends aqx> com.tencent.mm.v.a.a<T> b(b bVar) {
        if (bVar == null) {
            return null;
        }
        final h hVar = new h();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        u.a(bVar, new com.tencent.mm.v.u.a() {
            public final int a(int i, int i2, String str, b bVar, k kVar) {
                hVar.dTk = com.tencent.mm.v.a.a.a(i, i2, str, (aqx) bVar.czl.czs, kVar);
                countDownLatch.countDown();
                return 0;
            }
        });
        new ah(com.tencent.mm.plugin.appbrand.k.a.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a() {
            public final boolean oU() {
                hVar.dTk = new a();
                countDownLatch.countDown();
                return false;
            }
        }, false).ea(20000);
        try {
            countDownLatch.await();
            return (com.tencent.mm.v.a.a) hVar.dTk;
        } catch (Throwable e) {
            v.a("MicroMsg.SynchronousCgiCall", e, "latch await exp ", new Object[0]);
            return null;
        }
    }
}
