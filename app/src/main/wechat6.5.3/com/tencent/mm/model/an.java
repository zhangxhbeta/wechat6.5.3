package com.tencent.mm.model;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.v;

public final class an {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ ih csq;
        final /* synthetic */ ih csr;
        final /* synthetic */ ih css;

        public AnonymousClass1(ih ihVar, ih ihVar2, ih ihVar3) {
            this.csq = ihVar;
            this.csr = ihVar2;
            this.css = ihVar3;
        }

        public final void run() {
            a aVar = new a();
            long j = -1;
            if (!(ak.yO() == null || this.csq == null)) {
                ak.yO().b(this.csq, this.csr, this.css);
                j = aVar.sn();
            }
            v.d("MicroMsg.MMReqRespAuthHelper", "dkrsa setautoauthtick [%d %d]", Long.valueOf(aVar.sn()), Long.valueOf(j));
        }
    }
}
