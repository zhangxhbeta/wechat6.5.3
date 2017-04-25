package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wb;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ac extends k implements j {
    private final b cif;
    private e cii = null;

    public ac() {
        a aVar = new a();
        aVar.czn = new wa();
        aVar.czo = new wb();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.czm = 438;
        aVar.czp = 217;
        aVar.czq = 1000000217;
        this.cif = aVar.Bv();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            wb wbVar = (wb) ((b) pVar).czl.czs;
            v.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[]{Long.valueOf(wbVar.mbR), Long.valueOf(wbVar.eeN), Integer.valueOf(wbVar.myC), Integer.valueOf(wbVar.myB), Integer.valueOf(wbVar.myA)});
            v.bI(wbVar.mbR);
            v.bJ(wbVar.eeN);
            v.bK((long) wbVar.myC);
            v.bL((long) wbVar.myB);
            v.bM((long) wbVar.myA);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 438;
    }
}
