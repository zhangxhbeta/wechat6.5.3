package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends com.tencent.mm.pluginsdk.l.a.b implements j {
    public final com.tencent.mm.v.b cif;
    private e cii;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new axn();
        aVar.czo = new axo();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        aVar.czm = 1638;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        axn com_tencent_mm_protocal_c_axn = (axn) this.cif.czk.czs;
        com_tencent_mm_protocal_c_axn.mUE = str;
        com_tencent_mm_protocal_c_axn.bCj = str2;
        com_tencent_mm_protocal_c_axn.mUF = str3;
        com_tencent_mm_protocal_c_axn.mUG = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_axn.mUF);
    }

    public final void b(int i, int i2, String str, p pVar) {
        v.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            v.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            com.tencent.mm.plugin.fingerprint.a.e.dd(true);
        } else {
            v.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.cii.a(i, i2, "", this);
    }

    public final void JK() {
        v.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        v.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }

    public final int getType() {
        return 1638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
