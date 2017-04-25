package com.tencent.mm.u;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private e cii;
    LinkedList<arf> cyH = null;
    LinkedList<acz> cyI = null;

    public j(LinkedList<arf> linkedList) {
        this.cyH = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.cyH == null || this.cyH.size() <= 0) {
            v.e("MicroMsg.NetSceneBatchGetHeadImg", g.sm() + "doScene ReqSize==0");
            return -1;
        }
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new fh();
        aVar.czo = new fi();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.czm = 123;
        aVar.czp = 15;
        aVar.czq = 1000000015;
        p Bv = aVar.Bv();
        fh fhVar = (fh) Bv.czk.czs;
        fhVar.mfO = this.cyH;
        fhVar.eet = this.cyH.size();
        return a(eVar, Bv, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.cyI = ((fi) ((b) pVar).czl.czs).mfR;
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 123;
    }
}
