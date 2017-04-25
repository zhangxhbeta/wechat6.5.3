package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ag extends k implements j {
    public long cBd;
    public b cif;
    private e cii;

    public ag(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public ag(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public ag(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        this.cBd = 0;
        a aVar = new a();
        aVar.czn = new bdh();
        aVar.czo = new bdi();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.czm = 384;
        aVar.czp = 182;
        aVar.czq = 1000000182;
        this.cif = aVar.Bv();
        bdh com_tencent_mm_protocal_c_bdh = (bdh) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bdh.lZm = i;
        com_tencent_mm_protocal_c_bdh.mRN = i2;
        com_tencent_mm_protocal_c_bdh.mZj = be.KF(str);
        com_tencent_mm_protocal_c_bdh.mgS = be.KE(str);
        com_tencent_mm_protocal_c_bdh.mBN = new arf().JF(str2);
        com_tencent_mm_protocal_c_bdh.mZk = new arf().JF(str3);
        com_tencent_mm_protocal_c_bdh.mgW = new arf().JF(str4);
        if (i == 5 || i == 2) {
            byte[] b;
            this.cBd = new o(com.tencent.mm.model.k.xE()).longValue();
            if (z) {
                b = g.vu().cjh.b(this.cBd, str3);
            } else {
                b = g.vu().cjh.a(this.cBd, be.KF(str), z2);
            }
            com_tencent_mm_protocal_c_bdh.mfv = new are().ba(b);
        }
        com_tencent_mm_protocal_c_bdh.mgX = new are().ba(be.KG(be.ma((String) g.vw().vf().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_bdh.lZm);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_bdh.mfv == null ? -1 : com_tencent_mm_protocal_c_bdh.mfv.mQu);
        objArr[4] = com_tencent_mm_protocal_c_bdh.mfv == null ? "null" : be.KW(be.bk(com_tencent_mm_protocal_c_bdh.mfv.mQw.lVU));
        v.i(str5, str6, objArr);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 384;
    }

    public final String Fi() {
        try {
            return ((bdi) this.cif.czl.czs).mpB;
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneVerifyPswd", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bdh com_tencent_mm_protocal_c_bdh = (bdh) this.cif.czk.czs;
        bdi com_tencent_mm_protocal_c_bdi = (bdi) this.cif.czl.czs;
        if (com_tencent_mm_protocal_c_bdi.mdX != null && com_tencent_mm_protocal_c_bdi.mdX.mQu > 0) {
            boolean a = g.vu().cjh.a(this.cBd, m.a(com_tencent_mm_protocal_c_bdi.mdX));
            v.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_bdi.mdX.mQu));
        }
        if (i2 == 0 && i3 == 0) {
            g.vw().vf().set(77830, com_tencent_mm_protocal_c_bdi.mpB);
            g.vw().vf().set(32, com_tencent_mm_protocal_c_bdh.mZj);
            g.vw().vf().set(33, com_tencent_mm_protocal_c_bdh.mgS);
            g.vw().vf().set(46, be.bn(m.a(com_tencent_mm_protocal_c_bdi.med)));
            String bn = be.bn(m.a(com_tencent_mm_protocal_c_bdh.mgX));
            g.vw().vf().set(47, bn);
            g.vw().cjT.set(18, bn);
            g.vw().vf().set(-1535680990, com_tencent_mm_protocal_c_bdi.mec);
            int i4 = com_tencent_mm_protocal_c_bdi.med == null ? 0 : com_tencent_mm_protocal_c_bdi.med.mQu;
            int length = com_tencent_mm_protocal_c_bdi.mec == null ? 0 : com_tencent_mm_protocal_c_bdi.mec.length();
            int length2 = com_tencent_mm_protocal_c_bdi.mpB == null ? 0 : com_tencent_mm_protocal_c_bdi.mpB.length();
            v.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(i4), Integer.valueOf(length), Integer.valueOf(length2));
        } else if (i2 == 4) {
            g.vw().vf().set(32, SQLiteDatabase.KeyEmpty);
            g.vw().vf().set(33, SQLiteDatabase.KeyEmpty);
        }
        this.cii.a(i2, i3, str, this);
    }
}
