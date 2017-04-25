package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tenpay.android.wechat.TenpayUtil;

public final class c extends b implements j {
    public final com.tencent.mm.v.b cif;
    private e cii;

    public c(String str, h hVar) {
        a aVar = new a();
        aVar.czn = new axp();
        aVar.czo = new axq();
        aVar.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar.czm = 1665;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        axp com_tencent_mm_protocal_c_axp = (axp) this.cif.czk.czs;
        com_tencent_mm_protocal_c_axp.mUF = str;
        com_tencent_mm_protocal_c_axp.mUH = hVar.kdf;
        com_tencent_mm_protocal_c_axp.mUI = hVar.bCj;
        com_tencent_mm_protocal_c_axp.mUG = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_axp.mUF);
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void b(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.cii.a(i, i2, str, this);
    }

    public final void JK() {
        v.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        v.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }
}
