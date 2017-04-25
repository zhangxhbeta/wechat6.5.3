package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;

public final class b extends e {
    public final int aed() {
        return 121;
    }

    public b(l lVar, Orders orders) {
        super(lVar, orders);
    }

    public final int zg() {
        return 1601;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
    }
}
