package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.a.b;

public class a extends b {
    public final void d(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".pay.ui.WalletPayUI", -1, intent, false);
    }

    public final String anS() {
        return "BindCardForPayProcess";
    }
}
