package com.tencent.mm.plugin.sns.a.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.List;

public final class e extends k implements j {
    private b cif;
    public com.tencent.mm.v.e cii;
    public List<afi> dIB;

    public e(List<afi> list) {
        int i = 0;
        a aVar = new a();
        this.dIB = list;
        aVar.czn = new ay();
        aVar.czo = new az();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.czm = 1802;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ay ayVar = (ay) this.cif.czk.czs;
        afh com_tencent_mm_protocal_c_afh = new afh();
        com_tencent_mm_protocal_c_afh.mio = d.lWb;
        com_tencent_mm_protocal_c_afh.mip = d.lWa;
        com_tencent_mm_protocal_c_afh.miq = d.lWd;
        com_tencent_mm_protocal_c_afh.mir = d.lWe;
        com_tencent_mm_protocal_c_afh.mis = u.bsY();
        com_tencent_mm_protocal_c_afh.mFk = (int) (System.currentTimeMillis() / 1000);
        ayVar.mbx = com_tencent_mm_protocal_c_afh;
        while (i < list.size()) {
            ayVar.mby.add(list.get(i));
            i++;
        }
        v.i("MicroMsg.NetSceneAdLog", "report count: " + ayVar.mby.size());
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 1802;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneAdLog", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            int i4 = ((az) ((b) pVar).czl.czs).mbz;
            ak.yW();
            c.vf().a(t.a.nqo, Integer.valueOf(i4));
        }
        this.cii.a(i2, i3, str, this);
    }
}
