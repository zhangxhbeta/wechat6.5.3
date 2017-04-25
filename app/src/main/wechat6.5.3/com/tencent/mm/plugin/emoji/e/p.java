package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.network.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class p extends k implements j {
    private final b cif;
    private e cxf;
    public String fdU;
    private int feu;

    public p(String str, int i) {
        this.fdU = str;
        if (!be.kS(str) && str.equals(String.valueOf(a.nwJ))) {
            this.fdU = "com.tencent.xin.emoticon.tusiji";
        }
        this.feu = i;
        b.a aVar = new b.a();
        aVar.czn = new aiv();
        aVar.czo = new aiw();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.czm = 413;
        aVar.czp = 212;
        aVar.czq = 1000000212;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 413;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        aiv com_tencent_mm_protocal_c_aiv = (aiv) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aiv.mdM = this.fdU;
        com_tencent_mm_protocal_c_aiv.lZm = this.feu;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.feu == 1) {
                g.iuh.a(165, 2, 1, false);
            } else {
                g.iuh.a(165, 4, 1, false);
            }
            this.cxf.a(i2, i3, str, this);
            return;
        }
        this.cxf.a(i2, i3, str, this);
        if (this.feu == 1) {
            g.iuh.a(165, 3, 1, false);
            v.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            return;
        }
        g.iuh.a(165, 5, 1, false);
        v.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[]{this.fdU});
    }
}
