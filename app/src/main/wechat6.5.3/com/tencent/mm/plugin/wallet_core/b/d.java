package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.protocal.c.sw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private b cif;
    private e cii;
    public sw kLi;

    public d(String str) {
        a aVar = new a();
        aVar.czn = new sv();
        aVar.czo = new sw();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.czm = 1667;
        this.cif = aVar.Bv();
        sv svVar = (sv) this.cif.czk.czs;
        v.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[]{str});
        svVar.bfr = str;
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.kLi = (sw) this.cif.czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
