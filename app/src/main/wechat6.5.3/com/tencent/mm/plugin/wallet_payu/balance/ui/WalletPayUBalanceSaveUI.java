package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.v.k;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kFu.setVisibility(8);
    }

    protected final void beD() {
        j(new a(this.irZ, "ZAR"));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            e.a(this, ((a) kVar).fTG, "", 11, 1);
        }
        return false;
    }
}
