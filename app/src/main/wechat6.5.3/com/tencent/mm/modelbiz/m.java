package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    private String bZy;
    private a<m> cDe;
    b cif;
    private e cii;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public m(String str, String str2, a<m> aVar) {
        this(str, str2);
        this.cDe = aVar;
    }

    private m(String str, String str2) {
        this.bZy = str;
        v.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czm = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.czn = new gp();
        aVar.czo = new gq();
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        gp gpVar = (gp) this.cif.czk.czs;
        gpVar.mhz = this.bZy;
        gpVar.mhA = new com.tencent.mm.ba.b(be.KG(be.ma(str2)));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
        if (this.cDe != null) {
            this.cDe.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1075;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
