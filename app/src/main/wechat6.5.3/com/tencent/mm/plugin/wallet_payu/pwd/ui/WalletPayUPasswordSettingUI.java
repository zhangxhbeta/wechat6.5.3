package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    protected final void bfy() {
        v.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        a.a(this, f.class, null);
    }

    protected final void bfx() {
        v.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        a.a(this, g.class, null);
    }

    protected final void bfz() {
        this.ocZ.aO("wallet_modify_gesture_password", true);
        this.ocZ.aO("wallet_open_gesture_password", true);
    }

    protected final int bfw() {
        return 2131099746;
    }
}
