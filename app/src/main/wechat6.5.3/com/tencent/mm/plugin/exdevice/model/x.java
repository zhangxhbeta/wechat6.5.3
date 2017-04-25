package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class x extends k implements j {
    private b cif;
    private e cii;
    public abt fuD;

    public x(abt com_tencent_mm_protocal_c_abt, int i) {
        this.fuD = com_tencent_mm_protocal_c_abt;
        a aVar = new a();
        aVar.czn = new bao();
        aVar.czo = new bap();
        aVar.czm = 537;
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bao com_tencent_mm_protocal_c_bao = (bao) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bao.mgm = com_tencent_mm_protocal_c_abt;
        com_tencent_mm_protocal_c_bao.mbK = i;
    }

    public final int getType() {
        return 537;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        i iVar = i.fuj;
        i.ba(0);
        com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(this.fuD.eez);
        if (sq != null) {
            if (!(u.ajW().frL == null || u.ajW().frL.bm(sq.field_mac))) {
                v.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ac.ajq().bu(this.fuD.eez, this.fuD.meq)) {
                v.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            v.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[]{this.fuD.eez});
        }
        if (!(i2 == 0 && i3 == 0)) {
            v.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[]{Integer.valueOf(537)});
        }
        bap com_tencent_mm_protocal_c_bap = (this.cif == null || this.cif.czl.czs == null) ? null : (bap) this.cif.czl.czs;
        if (com_tencent_mm_protocal_c_bap == null) {
            v.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.cii.a(i2, i3, str, this);
    }
}
