package com.tencent.mm.w;

import com.tencent.mm.a.o;
import com.tencent.mm.e.a.pt;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a extends k implements j {
    private String bgb;
    private String bgd;
    public long cBd;
    public final b cif;
    private e cii;

    public a(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] b;
        this.cBd = 0;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new gg();
        aVar.czo = new gh();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.czm = 144;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.cBd = j;
        gg ggVar = (gg) this.cif.czk.czs;
        ggVar.mgR = new o(j).intValue();
        ggVar.mgI = SQLiteDatabase.KeyEmpty;
        ggVar.mgS = SQLiteDatabase.KeyEmpty;
        ggVar.mgT = SQLiteDatabase.KeyEmpty;
        ggVar.mgU = SQLiteDatabase.KeyEmpty;
        ggVar.mgW = new arf().JF(SQLiteDatabase.KeyEmpty);
        ggVar.mgV = 1;
        if (z) {
            b = ak.yS().b(j, str3);
        } else {
            b = ak.yS().a(j, be.KF(str), true);
        }
        ggVar.mfv = new are().ba(b);
        ak.yW();
        ggVar.mgX = new are().ba(be.KG(be.ma((String) c.vf().get(47, null))));
        v.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(be.bm(b)), str3, str2, str4, r1);
    }

    public a(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        this.bgb = str5;
        this.bgd = str6;
        gg ggVar = (gg) this.cif.czk.czs;
        ggVar.mgB = str5;
        ggVar.mgC = str6;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 144;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        gg ggVar = (gg) this.cif.czk.czs;
        gh ghVar = (gh) this.cif.czl.czs;
        byte[] a = m.a(ghVar.mdX);
        boolean z = false;
        if (!be.bl(a)) {
            z = ak.yS().a(new o(ggVar.mgR).longValue(), a);
        }
        v.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(be.bm(a)), ghVar.mgT);
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            c.vf().set(9, Integer.valueOf(ggVar.mgR));
            if (ggVar.mgV == 1) {
                ak.yW();
                c.vf().set(17, Integer.valueOf(ghVar.maB));
            }
            ak.yW();
            ay wN = c.wN();
            String str2 = ghVar.mha;
            boolean z2 = ghVar.mgZ == 1;
            if (be.kS(str2)) {
                v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            } else {
                ax Ns = wN.Ns(str2);
                if (Ns == null) {
                    wN.a(new ax(str2, z2, 2));
                    v.d("MicroMsg.RoleStorage", "insert new role, user=" + str2);
                } else {
                    Ns.dN(z2);
                    Ns.bkU = 4;
                    wN.b(Ns);
                }
            }
            int i4 = ggVar.mgR;
            if (i4 != 0) {
                ak.yW();
                c.wN().bV(new o(i4) + "@qqim", 3);
            }
            com.tencent.mm.u.b.d((long) i4, 3);
            ak.yW();
            c.vf().set(32, ggVar.mgI);
            ak.yW();
            c.vf().set(33, ggVar.mgS);
            v.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(z), be.KW(be.bn(ak.yS().R(new o(ggVar.mgR).longValue()))));
            ak.yW();
            c.vf().set(72, r3);
            ak.yW();
            c.vf().set(46, be.bn(m.a(ghVar.med)));
            String bn = be.bn(m.a(ggVar.mgX));
            ak.yW();
            c.vf().set(47, bn);
            ak.yT().set(18, bn);
            ak.yW();
            c.vf().set(-1535680990, ghVar.mhb);
            if (!(be.kS(this.bgb) || be.kS(this.bgd))) {
                ak.yW();
                c.vf().set(64, Integer.valueOf(ghVar.may));
                com.tencent.mm.sdk.c.b ptVar = new pt();
                ptVar.bqZ.bra = ghVar;
                com.tencent.mm.sdk.c.a.nhr.z(ptVar);
                com.tencent.mm.sdk.c.b puVar = new pu();
                puVar.brb.brc = true;
                puVar.brb.brd = true;
                com.tencent.mm.sdk.c.a.nhr.z(puVar);
            }
        } else if (i2 == 4) {
            ak.yW();
            c.vf().set(32, SQLiteDatabase.KeyEmpty);
            ak.yW();
            c.vf().set(33, SQLiteDatabase.KeyEmpty);
        }
        if (ggVar.mgV == 3 && i3 == -3) {
            i3 = 10000;
            v.d("MicroMsg.NetSceneBindQQ", new StringBuilder("onGYNetEnd : retCode = 10000").toString());
        }
        this.cii.a(i2, i3, str, this);
    }
}
