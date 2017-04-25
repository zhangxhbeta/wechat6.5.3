package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;

public final class d extends f {
    public d(l lVar, Orders orders) {
        super(lVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_verifyreg";
    }

    public final int zg() {
        return 1520;
    }
}
