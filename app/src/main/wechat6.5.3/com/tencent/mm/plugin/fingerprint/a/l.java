package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class l implements h {
    public final void a(a aVar) {
        v.i("MicroMsg.SoterPrePayAuthDelegate", "hy: pre auth prepare.");
        if (be.kS(o.kQn.fUl)) {
            v.e("MicroMsg.SoterPrePayAuthDelegate", "hy: no challenge. failed.");
            aVar.K(-1, "no challenge");
            return;
        }
        aVar.K(0, "");
    }
}
