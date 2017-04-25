package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.wv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private b cif;
    private e cii;
    public LinkedList<pc> hQp;
    public String hQx;

    public g(String str, String str2, bt btVar) {
        a aVar = new a();
        aVar.czn = new wu();
        aVar.czo = new wv();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        aVar.czm = 578;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        wu wuVar = (wu) this.cif.czk.czs;
        this.hQx = str;
        wuVar.mjc = str;
        v.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + str);
        wuVar.mjX = str2;
        wuVar.myZ = btVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        wv wvVar = (wv) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0 && wvVar.mjY == 0) {
            v.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + wvVar.mzb);
            this.hQp = wvVar.mza;
        }
        if (i3 == 0 && wvVar.mjY != 0) {
            i3 = wvVar.mjY;
            str = wvVar.mjZ;
        }
        v.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 578;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
