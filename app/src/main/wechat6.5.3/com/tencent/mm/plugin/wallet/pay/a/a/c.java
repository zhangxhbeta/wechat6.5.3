package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class c extends b {
    public c(Authen authen, Orders orders) {
        super(authen, orders);
    }

    public final int aed() {
        return 120;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public final int zg() {
        return 1600;
    }
}
