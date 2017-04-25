package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.r.b;
import com.tencent.mm.v.i;

public final class o extends n {

    private static class a extends i {
        final com.tencent.mm.protocal.r.a lDZ = new com.tencent.mm.protocal.r.a();
        final b lEa = new b();

        protected final c zd() {
            return this.lDZ;
        }

        public final int getType() {
            return 722;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        public final d ze() {
            return this.lEa;
        }

        public final int Bu() {
            return 1;
        }
    }

    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
    }

    protected final km g(p pVar) {
        return ((a) pVar).lEa.lXj;
    }

    public final int getType() {
        return 722;
    }

    protected final p bnZ() {
        p aVar = new a();
        com.tencent.mm.protocal.r.a aVar2 = aVar.lDZ;
        aVar2.cW(0);
        aVar2.lXi.mqQ.mqO.mmY.addAll(this.lDW);
        return aVar;
    }
}
