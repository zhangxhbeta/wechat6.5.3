package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class a {
    public static MallRechargeProduct bd(List<MallRechargeProduct> list) {
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                v.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                return mallRechargeProduct;
            }
        }
        v.d("MicroMsg.MallRechargeLogic", "products.get(0)");
        return (MallRechargeProduct) list.get(0);
    }
}
