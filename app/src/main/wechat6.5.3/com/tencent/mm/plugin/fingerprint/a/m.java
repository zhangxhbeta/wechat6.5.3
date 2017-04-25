package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.a.ov.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class m extends c<ov> {
    public m() {
        this.nhz = ov.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ov ovVar = (ov) bVar;
        if (!ak.uz()) {
            v.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (ovVar instanceof ov) {
            v.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean anp = c.anp();
            v.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is " + anp);
            a aVar = new a();
            aVar.bqg = anp;
            ovVar.bqf = aVar;
            if (ovVar.bpT != null) {
                ovVar.bpT.run();
            }
            return true;
        }
        return false;
    }
}
