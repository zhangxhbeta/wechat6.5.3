package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.c.gb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    private b cif = null;
    private e cii = null;

    public l(String str, int i) {
        a aVar = new a();
        aVar.czn = new ga();
        aVar.czo = new gb();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.czm = 536;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ga gaVar = (ga) this.cif.czk.czs;
        gaVar.mfZ = be.ma(str);
        gaVar.mgl = be.f(Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            int i4;
            gb ajj = ajj();
            v.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[]{ajj.mgm.eez, ajj.mgm.meq});
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = ajj.mgn.mec;
            objArr[1] = ajj.mgn.mCM;
            objArr[2] = ajj.mgn.mfU;
            objArr[3] = ajj.mgn.mCN;
            objArr[4] = Integer.valueOf(ajj.mgn.mCO);
            objArr[5] = ajj.mbK == 0 ? "sync" : "async";
            v.i(str2, str3, objArr);
            if (ac.ajq().bt(ajj.mgn.mCM, ajj.mgm.eez) != null) {
                v.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{ajj.mgn.mCM, Boolean.valueOf(ac.ajq().bu(ajj.mgm.eez, ajj.mgn.mCM))});
                if (ac.ajq().bu(ajj.mgm.eez, ajj.mgn.mCM)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, ajj.mgm, ajj.mgn);
            bVar.field_url = "";
            f.a bg = u.ajV().bg(bVar.field_mac);
            if (bg != null && bg.baO == 2) {
                v.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ac.ajx();
                d.aU(bVar.field_mac);
                f ajV = u.ajV();
                long j = bVar.field_mac;
                if (ajV.fxr.containsKey(Long.valueOf(j))) {
                    ajV.fxr.remove(Long.valueOf(j));
                    v.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[]{Long.valueOf(j)});
                } else {
                    v.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[]{Long.valueOf(j)});
                }
            }
            if (i4 != 0) {
                ac.ajq().b(bVar);
            } else {
                ac.ajq().h(bVar);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 536;
    }

    public final gb ajj() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (gb) this.cif.czl.czs;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
