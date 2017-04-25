package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;

public final class c extends f {
    public c(l lVar, Orders orders) {
        super(lVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_verifyreg";
    }

    public final int zg() {
        return 1559;
    }
}
