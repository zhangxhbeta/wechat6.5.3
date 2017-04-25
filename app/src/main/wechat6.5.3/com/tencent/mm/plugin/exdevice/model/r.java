package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.e.b.bk;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class r extends k implements j {
    private String aZU;
    private b cif = null;
    private e cii = null;
    String fuA;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        a aVar = new a();
        aVar.czn = new abv();
        aVar.czo = new abw();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.czm = 541;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        abv com_tencent_mm_protocal_c_abv = (abv) this.cif.czk.czs;
        abt com_tencent_mm_protocal_c_abt = new abt();
        com_tencent_mm_protocal_c_abt.meq = str2;
        com_tencent_mm_protocal_c_abt.eez = str3;
        com_tencent_mm_protocal_c_abv.mgm = com_tencent_mm_protocal_c_abt;
        com_tencent_mm_protocal_c_abv.mCX = i;
        com_tencent_mm_protocal_c_abv.mCY = new are().ba(bArr);
        this.fuA = str3;
        this.aZU = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        bk sq = ac.ajq().sq(this.fuA);
        if (i2 == 0 && i3 == 0) {
            abw com_tencent_mm_protocal_c_abw = (abw) this.cif.czl.czs;
            if (sq != null) {
                byte[] ajk = ajk();
                if (ajk != null) {
                    sq.field_authBuf = ajk;
                }
                sq.bKZ = com_tencent_mm_protocal_c_abw.mDd;
                sq.bKL = true;
                sq.bKY = com_tencent_mm_protocal_c_abw.mDc;
                sq.bKL = true;
                byte[] uT = uT();
                if (uT != null) {
                    u.ajV().a(sq.field_mac, uT, 2);
                    if (u.ajW().frL != null) {
                        u.ajW().frL.setChannelSessionKey(sq.field_mac, uT);
                    }
                    sq.field_sessionKey = uT;
                }
                uT = ajl();
                if (uT != null) {
                    u.ajV().a(sq.field_mac, uT, 3);
                    sq.field_sessionBuf = uT;
                }
                uT = ajk();
                if (ajk != null) {
                    u.ajV().a(sq.field_mac, uT, 1);
                    sq.field_authBuf = ajk;
                }
                sq.bLa = System.currentTimeMillis() / 1000;
                sq.bKL = true;
                if (2 == u.ajV().bf(sq.field_mac)) {
                    ac.ajB();
                    e.a(this.aZU, sq.field_url, 2, sq.field_deviceID);
                }
                u.ajV().bi(sq.field_mac);
                boolean a = ac.ajq().a(sq, new String[0]);
                v.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", new Object[]{Boolean.valueOf(a)});
            } else {
                v.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (sq != null) {
                u.ajV().bj(sq.field_mac);
                ac.ajB();
                e.a(this.aZU, sq.field_url, 4, sq.field_deviceID);
            }
            ac.ajB();
            e.as(this.aZU, 3);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    private byte[] uT() {
        try {
            return ((abw) this.cif.czl.czs).mdU.mQw.lVU;
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    public final byte[] ajk() {
        try {
            return ((abw) this.cif.czl.czs).mDa.mQw.lVU;
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    private byte[] ajl() {
        try {
            return ((abw) this.cif.czl.czs).mCZ.mQw.lVU;
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }
}
