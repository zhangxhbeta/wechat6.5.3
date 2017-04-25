package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b;

public class d extends a {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, PayUMallOrderRecordListUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof PayUMallOrderRecordListUI) {
            b(activity, PayUMallOrderDetailUI.class, bundle);
        }
    }
}
