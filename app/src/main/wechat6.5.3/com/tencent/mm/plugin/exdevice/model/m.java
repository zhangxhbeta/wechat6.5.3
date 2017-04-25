package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.protocal.c.gl;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    private b cif;
    private e cii;
    private String fuv;
    private long fuw;
    private String fux;
    private long fuy;

    public m(long j, String str, String str2, long j2) {
        this.fuw = j;
        this.fux = str;
        this.fuv = str2;
        this.fuy = j2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            gl glVar = (this.cif == null || this.cif.czl.czs == null) ? null : (gl) this.cif.czl.czs;
            abt com_tencent_mm_protocal_c_abt = glVar.mgm;
            String str2 = null;
            String str3 = null;
            if (com_tencent_mm_protocal_c_abt != null) {
                str2 = com_tencent_mm_protocal_c_abt.eez;
                str3 = com_tencent_mm_protocal_c_abt.meq;
            }
            v.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[]{str2, str3});
            if (ac.ajq().bt(str3, str2) != null) {
                v.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{str3, Boolean.valueOf(ac.ajq().bu(str2, str3))});
                if (ac.ajq().bu(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            com.tencent.mm.plugin.exdevice.h.b bVar = new com.tencent.mm.plugin.exdevice.h.b();
            bVar.field_connProto = this.fuv;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, com_tencent_mm_protocal_c_abt, glVar.mgn);
            if (bVar.field_mac == 0) {
                v.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.fuw;
            }
            if (obj != null) {
                ac.ajq().b(bVar);
            } else {
                ac.ajq().h(bVar);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1262;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new gk();
        aVar.czo = new gl();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.czm = 1262;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        gk gkVar = (gk) this.cif.czk.czs;
        gkVar.mac = com.tencent.mm.plugin.exdevice.j.b.bs(this.fuw);
        gkVar.mhf = this.fux;
        gkVar.mhe = this.fuv;
        gkVar.mhg = this.fuy;
        return a(eVar, this.cif, this);
    }
}
