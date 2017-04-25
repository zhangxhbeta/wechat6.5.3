package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.v;
import java.security.Signature;

public enum o {
    ;
    
    public String fUl;
    public boolean fUm;
    public Signature kQo;

    private o(String str) {
        this.fUl = null;
        this.fUm = false;
        this.kQo = null;
    }

    public final void reset() {
        v.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.kQo = null;
        this.fUl = null;
        this.fUm = false;
    }
}
