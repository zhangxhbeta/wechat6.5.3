package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.kl;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;

public final class m extends n {
    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    protected final km g(p pVar) {
        return (km) ((b) pVar).czl.czs;
    }

    public m(int i) {
        aqw com_tencent_mm_protocal_c_aqw = new aqw();
        com_tencent_mm_protocal_c_aqw.efm = i;
        this.lDW.clear();
        this.lDW.add(com_tencent_mm_protocal_c_aqw);
    }

    protected final p bnZ() {
        a aVar = new a();
        com.tencent.mm.ba.a klVar = new kl();
        klVar.mmY.addAll(this.lDW);
        aVar.czn = klVar;
        aVar.czo = new km();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.czm = 721;
        aVar.czp = 0;
        aVar.czq = 0;
        return aVar.Bv();
    }

    public final int getType() {
        return 721;
    }
}
