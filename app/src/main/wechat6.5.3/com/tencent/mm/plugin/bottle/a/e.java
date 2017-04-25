package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.a;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.akz;
import com.tencent.mm.protocal.c.ala;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private String aST = "";
    private b cif;
    private com.tencent.mm.v.e cii;
    private String eti = "";
    private int etj = 0;
    private a etk = null;
    private int msgType = 0;

    public e(String str, int i) {
        b.a aVar = new b.a();
        aVar.czn = new akz();
        aVar.czo = new ala();
        aVar.uri = "/cgi-bin/micromsg-bin/openbottle";
        aVar.czm = 156;
        aVar.czp = 55;
        aVar.czq = 1000000055;
        this.cif = aVar.Bv();
        this.eti = str;
        this.msgType = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        akz com_tencent_mm_protocal_c_akz = (akz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_akz.gll = this.msgType;
        com_tencent_mm_protocal_c_akz.mLT = this.eti;
        if (com_tencent_mm_protocal_c_akz.mLU == null) {
            com_tencent_mm_protocal_c_akz.mLU = new ln();
        }
        if (com_tencent_mm_protocal_c_akz.mLV == null) {
            com_tencent_mm_protocal_c_akz.mLV = new ln();
        }
        if (this.msgType == 1) {
            com_tencent_mm_protocal_c_akz.mLU.mdA = 0;
            com_tencent_mm_protocal_c_akz.mLU.moj = 0;
        } else if (this.msgType != 3) {
            v.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
            return -1;
        }
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        akz com_tencent_mm_protocal_c_akz = (akz) ((b) pVar).czk.czs;
        if (com_tencent_mm_protocal_c_akz.gll == 1) {
            return k.b.czU;
        }
        if (com_tencent_mm_protocal_c_akz.gll != 3) {
            return k.b.czV;
        }
        if (com_tencent_mm_protocal_c_akz.mLU == null) {
            v.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
            return k.b.czV;
        } else if (com_tencent_mm_protocal_c_akz.mLU.moj == 0 && com_tencent_mm_protocal_c_akz.mLU.mdA == 0) {
            return k.b.czU;
        } else {
            if (com_tencent_mm_protocal_c_akz.mLU.moj <= com_tencent_mm_protocal_c_akz.mLU.mdA) {
                return k.b.czV;
            }
            return k.b.czU;
        }
    }

    protected final int ul() {
        return 10;
    }

    private int XC() {
        akz com_tencent_mm_protocal_c_akz = (akz) this.cif.czk.czs;
        ala com_tencent_mm_protocal_c_ala = (ala) this.cif.czl.czs;
        a aVar = new a();
        aVar.msgType = com_tencent_mm_protocal_c_akz.gll;
        aVar.etb = 0;
        aVar.etd = 2;
        aVar.etc = c.pw(com_tencent_mm_protocal_c_akz.mLT);
        aVar.etf = be.Ni();
        aVar.eta = g.m(com_tencent_mm_protocal_c_akz.mLT.getBytes());
        if (this.msgType == 3) {
            aVar.content = this.aST;
            aVar.ete = com_tencent_mm_protocal_c_ala.mpw;
        } else {
            aVar.content = new String(com_tencent_mm_protocal_c_ala.mLX.mok.mQw.lVU);
        }
        i.XG().a(aVar);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            akz com_tencent_mm_protocal_c_akz = (akz) this.cif.czk.czs;
            ala com_tencent_mm_protocal_c_ala = (ala) this.cif.czl.czs;
            at atVar;
            if (this.msgType == 1) {
                XC();
                atVar = new at();
                atVar.cH(com_tencent_mm_protocal_c_akz.mLT);
                atVar.setContent(m.b(com_tencent_mm_protocal_c_ala.mLX.mok));
                atVar.z(be.Ni());
                atVar.di(0);
                atVar.dh(3);
                atVar.setType(c.iw(com_tencent_mm_protocal_c_akz.gll));
                ak.yW();
                c.wJ().R(atVar);
                v.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + atVar.field_content);
                this.cii.a(i2, i3, str, this);
                return;
            }
            if (be.kS(this.aST)) {
                this.aST = u.lI(this.eti);
                this.etk = new a(q.iU(this.aST));
                this.etj = 0;
            }
            if (com_tencent_mm_protocal_c_ala.mLX.moj < com_tencent_mm_protocal_c_ala.mLX.mdA + com_tencent_mm_protocal_c_ala.mLX.mok.mQu) {
                v.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + com_tencent_mm_protocal_c_ala.mLX.moj + " start:" + com_tencent_mm_protocal_c_ala.mLX.mdA + " len:" + com_tencent_mm_protocal_c_ala.mLX.mok.mQu);
                this.cii.a(3, -1, str, this);
                return;
            } else if (com_tencent_mm_protocal_c_ala.mLX.mdA != this.etj) {
                v.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_ala.mLX.mdA + " off:" + this.etj);
                this.cii.a(3, -1, str, this);
                return;
            } else {
                int write = this.etk.write(com_tencent_mm_protocal_c_ala.mLX.mok.mQw.lVU, com_tencent_mm_protocal_c_ala.mLX.mok.mQu, com_tencent_mm_protocal_c_ala.mLX.mdA);
                if (write != com_tencent_mm_protocal_c_ala.mLX.mok.mQu + com_tencent_mm_protocal_c_ala.mLX.mdA) {
                    v.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_ala.mLX.mdA + " len:" + com_tencent_mm_protocal_c_ala.mLX.mok.mQu + " writeRet:" + write);
                    this.cii.a(3, -1, str, this);
                    return;
                }
                this.etj = write;
                if (com_tencent_mm_protocal_c_ala.mLX.moj <= this.etj) {
                    XC();
                    atVar = new at();
                    atVar.cH(com_tencent_mm_protocal_c_akz.mLT);
                    atVar.setContent(n.b("bottle", (long) com_tencent_mm_protocal_c_ala.mpw, false));
                    atVar.cI(this.aST);
                    atVar.z(be.Ni());
                    atVar.di(0);
                    atVar.dh(3);
                    atVar.setType(c.iw(com_tencent_mm_protocal_c_akz.gll));
                    ak.yW();
                    c.wJ().R(atVar);
                    v.d("MicroMsg.NetSceneOpenBottle", "voice :" + com_tencent_mm_protocal_c_ala.mpw + " file:" + this.aST);
                    this.cii.a(i2, i3, str, this);
                    return;
                } else if (a(this.czE, this.cii) == -1) {
                    this.cii.a(3, -1, "doScene failed", this);
                    return;
                } else {
                    return;
                }
            }
        }
        v.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 156;
    }
}
