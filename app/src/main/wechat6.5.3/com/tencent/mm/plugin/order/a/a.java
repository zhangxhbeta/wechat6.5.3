package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b;

public class a extends b {
    public b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        b(activity, MallOrderRecordListUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof MallOrderRecordListUI) {
            b(activity, MallOrderTransactionInfoUI.class, bundle);
        } else if (activity instanceof MallOrderDetailInfoUI) {
            int i2 = bundle.getInt("key_enter_id");
            if (i2 == 0) {
                b(activity, MallOrderProductListUI.class, bundle);
            } else if (i2 == 1) {
                b(activity, MallOrderTransactionInfoUI.class, bundle);
            }
        } else if ((activity instanceof MallOrderProductListUI) || (activity instanceof MallOrderTransactionInfoUI)) {
            D(activity);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        super.af(activity);
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String anS() {
        return "ShowOrdersInfoProcess";
    }
}
