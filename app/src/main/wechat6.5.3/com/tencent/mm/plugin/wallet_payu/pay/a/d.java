package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        if (orders == null || orders.kPm == null || orders.kPm.size() <= 0) {
            v.d("MicroMsg.OrdersWrapper", "hy: params error");
        } else {
            for (Commodity commodity : orders.kPm) {
                commodity.hNc = i;
                commodity.hMZ = str.equals("1") ? "2" : "1";
                commodity.hNa = str2;
                commodity.hNe = str3;
            }
        }
        return orders;
    }
}
