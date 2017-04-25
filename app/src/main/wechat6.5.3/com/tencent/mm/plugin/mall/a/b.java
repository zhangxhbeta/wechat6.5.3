package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;

    public b() {
        boolean booleanValue;
        a aVar = new a();
        aVar.czn = new alw();
        aVar.czo = new alx();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        aVar.czm = 1577;
        this.cif = aVar.Bv();
        alw com_tencent_mm_protocal_c_alw = (alw) this.cif.czk.czs;
        ak.yW();
        Object obj = c.vf().get(t.a.nrO, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_alw.mMB = booleanValue ? 1 : 0;
        com_tencent_mm_protocal_c_alw.aOo = u.bsY();
        com_tencent_mm_protocal_c_alw.mME = VERSION.RELEASE;
        com_tencent_mm_protocal_c_alw.mMD = f.S(null, d.lWh);
        com_tencent_mm_protocal_c_alw.mMF = Build.MANUFACTURER;
        v.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_alw.mMB), com_tencent_mm_protocal_c_alw.aOo, com_tencent_mm_protocal_c_alw.mME, com_tencent_mm_protocal_c_alw.mMD, com_tencent_mm_protocal_c_alw.mMF});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            alx com_tencent_mm_protocal_c_alx = (alx) ((com.tencent.mm.v.b) pVar).czl.czs;
            if (com_tencent_mm_protocal_c_alx.mMI == null || com_tencent_mm_protocal_c_alx.mMJ == null) {
                v.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + com_tencent_mm_protocal_c_alx.hih);
            } else {
                v.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd " + com_tencent_mm_protocal_c_alx.hih + " wallet_gray_area: " + com_tencent_mm_protocal_c_alx.mMI.mws.size() + " wallet_threepoint_area: " + com_tencent_mm_protocal_c_alx.mMJ.mws.size());
            }
            ak.yW();
            c.vf().a(t.a.nsQ, Integer.valueOf(com_tencent_mm_protocal_c_alx.hih));
            com.tencent.mm.plugin.wallet_core.model.k.bgg().a(com_tencent_mm_protocal_c_alx.hih, com_tencent_mm_protocal_c_alx);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
