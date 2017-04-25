package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.l;

public final class g extends e {
    public g(l lVar, Orders orders) {
        super(lVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_verify";
    }

    public final int zg() {
        return 1592;
    }
}
