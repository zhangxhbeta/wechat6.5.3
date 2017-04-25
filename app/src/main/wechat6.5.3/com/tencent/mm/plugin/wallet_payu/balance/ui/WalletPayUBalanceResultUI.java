package com.tencent.mm.plugin.wallet_payu.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI extends WalletBalanceResultUI {
    protected final void NI() {
        super.NI();
        this.kFZ.setVisibility(8);
    }

    protected final void av() {
        if (this.ith != null) {
            this.kFX.setText(e.d(this.ith.kOU, this.ith.hNg));
            if (this.kGa != null && !be.kS(this.kGa.field_bankName)) {
                if (be.kS(this.kGa.field_bankcardTail)) {
                    this.kFY.setText(this.kGa.field_bankName);
                } else {
                    this.kFY.setText(this.kGa.field_bankName + " " + getString(2131236343) + this.kGa.field_bankcardTail);
                }
            }
        }
    }
}
