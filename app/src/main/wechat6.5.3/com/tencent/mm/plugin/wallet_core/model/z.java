package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;

public final class z {
    public int kQP = 0;

    public z(int i) {
        ak.yW();
        c.vf().set(196660, Integer.valueOf(i));
        this.kQP = i;
        v.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i);
    }

    public z() {
        ak.yW();
        this.kQP = ((Integer) c.vf().get(196660, Integer.valueOf(0))).intValue();
        v.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.kQP);
    }

    public final boolean bgn() {
        boolean z;
        if ((this.kQP & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kQP)});
        return z;
    }

    public final boolean bgo() {
        boolean z;
        if ((this.kQP & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kQP)});
        return z;
    }

    public final boolean bgp() {
        boolean z;
        if ((this.kQP & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kQP)});
        return z;
    }

    public final boolean bgq() {
        boolean z;
        if ((this.kQP & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kQP)});
        return z;
    }

    public final boolean bgr() {
        boolean z;
        if ((this.kQP & 65536) > 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kQP)});
        return z;
    }
}
