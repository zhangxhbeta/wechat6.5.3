package com.tencent.mm.modelfriend;

import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class v extends k implements j {
    private String bgb;
    private String bgd;
    public final b cif;
    private e cii;

    public v(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        this.bgb = str4;
        this.bgd = str5;
        ge geVar = (ge) this.cif.czk.czs;
        geVar.mgB = str4;
        geVar.mgC = str5;
    }

    public v(String str, int i, String str2, int i2, String str3) {
        this.cii = null;
        this.bgb = null;
        this.bgd = null;
        a aVar = new a();
        aVar.czn = new ge();
        aVar.czo = new gf();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.czm = 132;
        aVar.czp = 45;
        aVar.czq = 1000000045;
        this.cif = aVar.Bv();
        ge geVar = (ge) this.cif.czk.czs;
        geVar.meB = i;
        geVar.mgy = i2;
        geVar.mgz = str3;
        if (be.kS(this.bgb) && be.kS(this.bgd)) {
            geVar.mgB = f.nia ? aa.getContext().getString(2131234695) : aa.getContext().getString(2131234694);
            geVar.mgC = d.lWf;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            ak.yW();
            c.vf().set(4097, str);
        } else if (i == 2 || i == 19) {
            ak.yW();
            str = (String) c.vf().get(4097, null);
        } else if (i == 3) {
            ak.yW();
            str = (String) c.vf().get(6, null);
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        geVar.mgw = str;
        geVar.mgx = str2;
        geVar.fvz = u.bsY();
    }

    public final int AG() {
        return ((ge) this.cif.czk.czs).meB;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        ge geVar = (ge) this.cif.czk.czs;
        if (geVar.mgw == null || geVar.mgw.length() <= 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + geVar.mgw);
            return -1;
        } else if ((geVar.meB != 2 && geVar.meB != 19) || (geVar.mgx != null && geVar.mgx.length() > 0)) {
            return a(eVar, this.cif, this);
        } else {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + geVar.mgw);
            return -1;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ge geVar = (ge) this.cif.czk.czs;
            gf gfVar = (gf) this.cif.czl.czs;
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + gfVar.mgG + "safedevice status = " + gfVar.may);
            if (geVar.meB == 2 || geVar.meB == 4 || geVar.meB == 11 || geVar.meB == 19) {
                ak.yW();
                c.vf().set(4097, SQLiteDatabase.KeyEmpty);
                ak.yW();
                c.vf().set(6, geVar.mgw);
                if (be.kS(this.bgb) || be.kS(this.bgd)) {
                    m.EV();
                }
                if (!(be.kS(this.bgb) || be.kS(this.bgd))) {
                    com.tencent.mm.sdk.c.b ptVar = new pt();
                    ptVar.bqZ.bra = gfVar;
                    com.tencent.mm.sdk.c.a.nhr.z(ptVar);
                    ak.yW();
                    c.vf().set(64, Integer.valueOf(gfVar.may));
                    com.tencent.mm.sdk.c.b puVar = new pu();
                    puVar.brb.brc = true;
                    puVar.brb.brd = true;
                    com.tencent.mm.sdk.c.a.nhr.z(puVar);
                }
                if (geVar.meB == 19) {
                    ak.yW();
                    c.vf().set(12322, null);
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (geVar.meB == 3) {
                ak.yW();
                c.vf().set(4097, SQLiteDatabase.KeyEmpty);
                ak.yW();
                c.vf().set(6, SQLiteDatabase.KeyEmpty);
                ak.yW();
                c.vf().set(12322, null);
                ak.yW();
                c.vf().set(64, Integer.valueOf(gfVar.may));
                com.tencent.mm.sdk.c.b puVar2 = new pu();
                puVar2.brb.brc = false;
                puVar2.brb.brd = true;
                com.tencent.mm.sdk.c.a.nhr.z(puVar2);
                m.Fc();
                m.Fd();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }
}
