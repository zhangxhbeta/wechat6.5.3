package com.tencent.mm.plugin.wallet.b;

import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.j.g;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static boolean bfA() {
        boolean z;
        g gVar = com.tencent.mm.pluginsdk.j.a.lxX;
        v.i("MicroMsg.WalletUtil", "mgr==null?" + (gVar == null));
        if (gVar != null) {
            v.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + gVar.anx());
        }
        k.beN();
        ab beO = k.beO();
        z bgz = beO.bgz();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (bgz == null) {
            z = true;
        } else {
            z = false;
        }
        v.i(str, stringBuilder.append(z).toString());
        if (bgz != null) {
            v.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + bgz.bgp());
        }
        v.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + beO.bgv());
        if (gVar != null && gVar.anx() && bgz != null && bgz.bgp() && beO.bgv()) {
            return true;
        }
        return false;
    }
}
