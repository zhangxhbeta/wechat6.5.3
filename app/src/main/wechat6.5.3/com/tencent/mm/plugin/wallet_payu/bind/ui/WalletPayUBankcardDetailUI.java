package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (1 == this.kGa.field_bankcardState) {
            beE();
            findViewById(2131759826).setVisibility(8);
            findViewById(2131759827).setVisibility(8);
        } else {
            hb(false);
        }
        findViewById(2131759829).setVisibility(8);
        ((TextView) findViewById(2131759830)).setText(2131236034);
    }
}
