package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.b.b.a;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bey() {
        k.beN();
        b(new a(), k.beO().kFU == null);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof a)) {
            av();
        }
        return false;
    }

    protected final void bez() {
        q(WalletPayUBalanceSaveUI.class);
    }
}
