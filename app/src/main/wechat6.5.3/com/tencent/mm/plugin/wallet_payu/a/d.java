package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_payu.create.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wallet_payu.remittance.a.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public final class d implements ag {
    public String kZn = null;
    private int kZo = -1;

    static {
        a.b("PayUOpenProcess", c.class);
        a.b("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
        a.b("PayUForgotPwdProcess", f.class);
        a.b("PayUModifyPasswordProcess", g.class);
        a.b("PayURemittanceProcess", i.class);
        a.b("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    }

    public static d bhD() {
        d dVar = (d) ak.yP().fY("plugin.wallet_payu");
        if (dVar != null) {
            return dVar;
        }
        v.w("MicroMsg.SubCoreWalletPayU", "not found in MMCore, new one");
        dVar = new d();
        ak.yP().a("plugin.wallet_payu", dVar);
        return dVar;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
    }

    public final void aH(boolean z) {
    }

    public final void th() {
    }
}
