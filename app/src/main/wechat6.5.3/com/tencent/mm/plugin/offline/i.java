package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.b;

public class i extends b {
    public final b c(Activity activity, Bundle bundle) {
        String str;
        String str2 = "";
        if (bundle != null) {
            if (be.kS(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.kPm == null || orders.kPm.size() <= 0)) {
                    str = ((Commodity) orders.kPm.get(0)).eWA;
                }
            } else {
                str = "key_trans_id";
            }
            ak.vy().a(new d("offlineshowpage", "push", str), 0);
            b(activity, WalletOrderInfoUI.class, bundle);
            ak.yW();
            c.vf().a(a.ntq, Boolean.valueOf(true));
            return this;
        }
        str = str2;
        ak.vy().a(new d("offlineshowpage", "push", str), 0);
        b(activity, WalletOrderInfoUI.class, bundle);
        ak.yW();
        c.vf().a(a.ntq, Boolean.valueOf(true));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletOrderInfoUI) {
            D(activity);
        }
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        af(activity);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String anS() {
        return "ShowOrderSuccessProcess";
    }
}
