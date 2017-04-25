package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.ld;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends c<ld> {
    public i() {
        this.nhz = ld.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ld ldVar = (ld) bVar;
        if (!ak.uz()) {
            v.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (ldVar instanceof ld) {
            v.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.ank();
            if (a.anl() != null) {
                a.ank();
                a.anl();
                c.anq();
                v.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            return true;
        }
        return false;
    }
}
