package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;

@a(3)
public class WalletPayUVerifyCodeUI extends WalletVerifyCodeUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kWc.pko = 60;
    }

    protected final void bhq() {
        super.bhq();
    }

    protected final void bhr() {
        super.bhr();
    }

    public final void bhp() {
        this.kWb = 180000;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) && !((com.tencent.mm.plugin.wallet_payu.a.a) kVar).kZk) {
            v.w("MicroMsg.WalletPayUVerifyCodeUI", "hy: confirm code not verified");
        }
        return false;
    }

    protected final boolean beY() {
        return true;
    }
}
