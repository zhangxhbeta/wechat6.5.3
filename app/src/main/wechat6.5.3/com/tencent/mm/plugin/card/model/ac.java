package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ac extends k implements j {
    private final b cif;
    private e cii;
    public com.tencent.mm.ba.b eDH;
    public boolean eDI;
    public String eDn;

    public ac(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.ba.b bVar) {
        a aVar = new a();
        aVar.czn = new sp();
        aVar.czo = new sq();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        aVar.czm = 664;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        sp spVar = (sp) this.cif.czk.czs;
        spVar.eBQ = str;
        spVar.eKw = i;
        spVar.eKx = str2;
        spVar.eKy = str3;
        spVar.time_stamp = i2;
        spVar.eKz = str4;
        spVar.eBK = str5;
        spVar.eKA = str6;
        spVar.eDH = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            spVar.mwo = 1;
        } else {
            spVar.mwo = 0;
        }
    }

    public final int getType() {
        return 664;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            sq sqVar = (sq) this.cif.czl.czs;
            this.eDn = sqVar.eDn;
            this.eDH = sqVar.eDH;
            this.eDI = sqVar.mwp != 0;
        }
        this.cii.a(i2, i3, str, this);
    }
}
