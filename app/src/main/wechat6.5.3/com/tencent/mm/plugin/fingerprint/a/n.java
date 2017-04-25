package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class n {
    a fUj;

    public interface a {
        void tp(String str);
    }

    public n(a aVar) {
        this.fUj = aVar;
    }

    public final void anR() {
        e.a(new Runnable(this) {
            final /* synthetic */ n fUk;

            {
                this.fUk = r1;
            }

            public final void run() {
                String str = "";
                if (e.anx()) {
                    v.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.bL(aa.getContext()), e.getUserId(), p.rK());
                } else {
                    v.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (this.fUk.fUj != null) {
                    this.fUk.fUj.tp(str);
                }
            }
        }, getClass().getName());
    }
}
