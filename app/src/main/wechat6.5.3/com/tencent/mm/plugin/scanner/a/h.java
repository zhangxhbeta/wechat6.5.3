package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class h extends k implements j {
    private b cif;
    private e cii;

    public h(String str, String str2, int i, String str3, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new hn();
        aVar.czo = new ho();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.czm = 1064;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        hn hnVar = (hn) this.cif.czk.czs;
        hnVar.mio = d.lWb;
        hnVar.mip = d.lWa;
        hnVar.miq = d.lWd;
        hnVar.mir = d.lWe;
        hnVar.mis = u.bsY();
        hnVar.itQ = 11294;
        hnVar.mit = null;
        hnVar.ivO = str;
        hnVar.ivN = str2;
        hnVar.type = i;
        hnVar.value = str3;
        hnVar.count = i2;
        hnVar.miu = i3;
        v.v("MircoMsg.NetSceneScanProductReport", "statid:" + str2);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1064;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
