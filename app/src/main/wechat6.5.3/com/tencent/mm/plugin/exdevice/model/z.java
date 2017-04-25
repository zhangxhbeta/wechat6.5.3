package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class z extends k implements j {
    private e cxf = null;
    private String fuF = "";
    b fut = null;

    public z(LinkedList<wk> linkedList, String str, String str2) {
        this.fuF = str2;
        a aVar = new a();
        aVar.czn = new wl();
        aVar.czo = new wm();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.czm = 543;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        wl wlVar = (wl) this.fut.czk.czs;
        if (!be.kS(str)) {
            wj wjVar = new wj();
            wjVar.mfT = str;
            wlVar.myR = wjVar;
        }
        wlVar.myQ = linkedList;
    }

    public final int getType() {
        return 543;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
    }
}
