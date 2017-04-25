package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.a.b;

public class a extends b {
    public static int kFg = 1;
    public static int kFh = 2;

    public final void d(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", kFh) == kFg) {
            intent.putExtra("from_bind_ui", kFg);
            a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            return;
        }
        intent.putExtra("from_bind_ui", kFh);
        a(activity, "wallet", ".balance.ui.WalletBalanceFetchUI", -1, intent, true);
    }

    public final String anS() {
        return "BalanceFetchCardProcess";
    }
}
