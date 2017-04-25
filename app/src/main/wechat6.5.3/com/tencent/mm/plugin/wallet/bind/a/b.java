package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.k;

public final class b extends k {
    private com.tencent.mm.v.b cif;
    private e cii;
    private String kGk;

    public final void c(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet.a.k.beN();
            com.tencent.mm.plugin.wallet.a.k.beO();
            ab.Df(this.kGk);
        }
        this.cii.a(i, i2, str, this);
    }

    public final int getType() {
        return 621;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
