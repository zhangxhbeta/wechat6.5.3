package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g extends k implements j {
    private b cif;
    private e cii;
    public int opType;

    public g(int i, String str) {
        this.opType = i;
        a aVar = new a();
        aVar.czn = new pp();
        aVar.czo = new pq();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        this.cif = aVar.Bv();
        pp ppVar = (pp) this.cif.czk.czs;
        if (be.kS(str)) {
            str = SQLiteDatabase.KeyEmpty;
        }
        ppVar.mrv = str;
        ppVar.gly = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            pq pqVar = (pq) this.cif.czl.czs;
            int i4 = pqVar.mQl.mcj;
            if (i4 != 0) {
                v.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + i4);
                this.cii.a(4, i4, str, this);
                return;
            }
            v.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + pqVar.mrx + ", fbusername = " + pqVar.mry);
            if (this.opType == 0 || this.opType == 1) {
                ak.yW();
                c.vf().set(65825, pqVar.mrx);
                com.tencent.mm.u.b.gx(pqVar.mrx);
                ak.yW();
                c.vf().set(65826, pqVar.mry);
                ak.yW();
                c.vf().iB(true);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
