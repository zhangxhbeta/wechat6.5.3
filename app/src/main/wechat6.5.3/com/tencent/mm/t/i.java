package com.tencent.mm.t;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsearch.t;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class i extends t implements j {
    private b cxe;
    private e cxf;
    private bjs jVN;

    public i(String str, int i, int i2, int i3) {
        this.jVO = str;
        this.cVh = i;
        this.cVf = i3;
        if (be.kS(str)) {
            v.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
            return;
        }
        v.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", new Object[]{str});
        a aVar = new a();
        aVar.czm = 1173;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
        aVar.czn = new my();
        aVar.czo = new bjs();
        this.cxe = aVar.Bv();
        my myVar = (my) this.cxe.czk.czs;
        myVar.bkC = str;
        myVar.ncj = i2;
        ak.yW();
        Object obj = c.vf().get(com.tencent.mm.storage.t.a.pRH, null);
        if (obj != null && (obj instanceof String)) {
            myVar.pRA = (String) obj;
        }
        myVar.ncl = b.jHr;
        myVar.ncm = b.jHs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.jVN = (bjs) this.cxe.czl.czs;
            if (this.jVN != null) {
                v.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", new Object[]{this.jVN.min});
            }
            this.cxf.a(i2, i3, str, this);
            return;
        }
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1173;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.cxe, this);
    }

    public final String AI() {
        return this.jVN != null ? this.jVN.min : "";
    }
}
