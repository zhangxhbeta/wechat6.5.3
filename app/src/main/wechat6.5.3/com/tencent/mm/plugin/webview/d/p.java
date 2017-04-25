package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements j {
    private final b cif;
    private e cii;

    public p(List<afi> list) {
        a aVar = new a();
        aVar.czn = new aev();
        aVar.czo = new aew();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        aVar.czm = 1803;
        this.cif = aVar.Bv();
        aev com_tencent_mm_protocal_c_aev = (aev) this.cif.czk.czs;
        afh com_tencent_mm_protocal_c_afh = new afh();
        com_tencent_mm_protocal_c_afh.mio = d.lWb;
        com_tencent_mm_protocal_c_afh.mip = d.lWa;
        com_tencent_mm_protocal_c_afh.miq = d.lWd;
        com_tencent_mm_protocal_c_afh.mir = d.lWe;
        com_tencent_mm_protocal_c_afh.mis = u.bsY();
        com_tencent_mm_protocal_c_afh.mFk = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_aev.mbx = com_tencent_mm_protocal_c_afh;
        com_tencent_mm_protocal_c_aev.mby.addAll(list);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            aew com_tencent_mm_protocal_c_aew = (aew) ((b) pVar).czl.czs;
            v.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (be.bP(com_tencent_mm_protocal_c_aew.mEY)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = com_tencent_mm_protocal_c_aew.mEY.iterator();
                while (it.hasNext()) {
                    ade com_tencent_mm_protocal_c_ade = (ade) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ade.mEf), Integer.valueOf(com_tencent_mm_protocal_c_ade.mEg)}));
                }
            }
            stringBuilder.append(" }");
            v.i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            a.ldT;
            e.bE(com_tencent_mm_protocal_c_aew.mEY);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.d("MicroMsg.NetSceneJsLog", "doScene");
        return a(eVar, this.cif, this);
    }
}
