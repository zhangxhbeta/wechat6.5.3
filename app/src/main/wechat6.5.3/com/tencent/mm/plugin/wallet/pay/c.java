package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class c extends d {
    public c(WalletBaseUI walletBaseUI, f fVar) {
        super(walletBaseUI, fVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
