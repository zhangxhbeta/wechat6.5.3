package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletPayUPwdConfirmUI extends WalletPwdConfirmUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a(this.kTr, false);
    }
}
