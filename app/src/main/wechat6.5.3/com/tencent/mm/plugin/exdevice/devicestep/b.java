package com.tencent.mm.plugin.exdevice.devicestep;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private com.tencent.mm.v.b cif;
    private e cii;
    private bbs frv;

    public b(String str, String str2, int i, int i2, int i3, String str3) {
        this(str, str2, i, i2, i3, str3, 1);
    }

    public b(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.cii = null;
        this.cif = null;
        v.i("MicroMsg.exdevice.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a aVar = new a();
        aVar.czn = new bbs();
        aVar.czo = new bbt();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.czm = 1261;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.frv = (bbs) this.cif.czk.czs;
        this.frv.aRh = str;
        this.frv.aZN = str2;
        this.frv.mXv = i;
        this.frv.mXw = i2;
        this.frv.aMN = i3;
        this.frv.mXx = com.tencent.mm.plugin.exdevice.j.b.akJ();
        this.frv.mXA = str3;
        this.frv.mXD = i4;
    }

    public final int getType() {
        return 1261;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }
}
