package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private b cif;
    private e cii;
    int etj = 0;
    private com.tencent.mm.modelvoice.b etm;
    int msgType = -1;

    public g(String str) {
        a aVar = new a();
        aVar.czn = new azp();
        aVar.czo = new azq();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.czm = 154;
        aVar.czp = 53;
        aVar.czq = 1000000053;
        this.cif = aVar.Bv();
        if (!be.kS(str)) {
            this.msgType = 1;
            azp com_tencent_mm_protocal_c_azp = (azp) this.cif.czk.czs;
            com_tencent_mm_protocal_c_azp.mNl = 0;
            com_tencent_mm_protocal_c_azp.gll = this.msgType;
            com_tencent_mm_protocal_c_azp.mdA = 0;
            com_tencent_mm_protocal_c_azp.mdz = str.getBytes().length;
            com_tencent_mm_protocal_c_azp.mpw = 0;
            com_tencent_mm_protocal_c_azp.mok = m.H(str.getBytes());
            com_tencent_mm_protocal_c_azp.mHw = com.tencent.mm.a.g.m((str + be.Ni()).getBytes());
        }
    }

    public g(String str, int i) {
        a aVar = new a();
        aVar.czn = new azp();
        aVar.czo = new azq();
        aVar.uri = "/cgi-bin/micromsg-bin/throwbottle";
        aVar.czm = 154;
        aVar.czp = 53;
        aVar.czq = 1000000053;
        this.cif = aVar.Bv();
        if (!be.kS(str) && i > 0) {
            this.msgType = 3;
            azp com_tencent_mm_protocal_c_azp = (azp) this.cif.czk.czs;
            com_tencent_mm_protocal_c_azp.mpw = i;
            com_tencent_mm_protocal_c_azp.mHw = str;
            com_tencent_mm_protocal_c_azp.mNl = 0;
            com_tencent_mm_protocal_c_azp.gll = this.msgType;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        if (this.msgType == 1) {
            this.msgType = 0 - this.msgType;
        } else if (this.msgType == 3) {
            azp com_tencent_mm_protocal_c_azp = (azp) this.cif.czk.czs;
            com_tencent_mm_protocal_c_azp.gll = 3;
            com_tencent_mm_protocal_c_azp.mNl = 0;
            if (this.etm == null) {
                this.etm = q.lC(com_tencent_mm_protocal_c_azp.mHw);
                this.etj = 0;
                com_tencent_mm_protocal_c_azp.mdz = o.le(com_tencent_mm_protocal_c_azp.mHw);
            }
            com.tencent.mm.modelvoice.g aU = this.etm.aU(this.etj, 6000);
            v.d("MicroMsg.NetSceneThrowBottle", "doScene READ file[" + com_tencent_mm_protocal_c_azp.mHw + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + this.etj + " line:" + com.tencent.mm.compatible.util.g.sk());
            if (aU.ret < 0 || aU.aUT == 0) {
                v.e("MicroMsg.NetSceneThrowBottle", "Err doScene READ file[" + com_tencent_mm_protocal_c_azp.mHw + "] read ret:" + aU.ret + " readlen:" + aU.aUT + " newOff:" + aU.dik + " netOff:" + this.etj);
                q.lD(com_tencent_mm_protocal_c_azp.mHw);
                return -1;
            }
            Object obj = new byte[aU.aUT];
            System.arraycopy(aU.buf, 0, obj, 0, aU.aUT);
            com_tencent_mm_protocal_c_azp.mok = m.H(obj);
            com_tencent_mm_protocal_c_azp.mdA = this.etj;
        } else {
            v.e("MicroMsg.NetSceneThrowBottle", "doScene Error Msg type: " + this.msgType);
            return -1;
        }
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        azp com_tencent_mm_protocal_c_azp = (azp) ((b) pVar).czk.czs;
        if (com_tencent_mm_protocal_c_azp.gll == 1) {
            return k.b.czU;
        }
        if (com_tencent_mm_protocal_c_azp.gll != 3) {
            return k.b.czV;
        }
        if (com_tencent_mm_protocal_c_azp.mdz == 0 || com_tencent_mm_protocal_c_azp.mdz <= com_tencent_mm_protocal_c_azp.mdA || be.kS(com_tencent_mm_protocal_c_azp.mHw) || be.bl(m.a(com_tencent_mm_protocal_c_azp.mok))) {
            return k.b.czV;
        }
        return k.b.czU;
    }

    protected final int ul() {
        return 10;
    }

    protected final void a(k.a aVar) {
        v.e("MicroMsg.NetSceneThrowBottle", "setSecurityCheckError:" + aVar + " type:" + this.msgType);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneThrowBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        azp com_tencent_mm_protocal_c_azp = (azp) this.cif.czk.czs;
        azq com_tencent_mm_protocal_c_azq = (azq) this.cif.czl.czs;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.iv(com_tencent_mm_protocal_c_azq.mwN);
                    c.iu(com_tencent_mm_protocal_c_azq.mwM);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneThrowBottle", "getStartPos " + com_tencent_mm_protocal_c_azq.mdA);
            v.d("MicroMsg.NetSceneThrowBottle", "getTotalLen " + com_tencent_mm_protocal_c_azq.mdz);
            v.d("MicroMsg.NetSceneThrowBottle", "getThrowCount " + com_tencent_mm_protocal_c_azq.mwM);
            v.d("MicroMsg.NetSceneThrowBottle", "getPickCount " + com_tencent_mm_protocal_c_azq.mwN);
            v.d("MicroMsg.NetSceneThrowBottle", "getDistance " + com_tencent_mm_protocal_c_azq.mNn);
            v.d("MicroMsg.NetSceneThrowBottle", "getBottleList " + com_tencent_mm_protocal_c_azq.mWm.size());
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_azq.mWm.size(); i4++) {
                v.d("MicroMsg.NetSceneThrowBottle", "bott id:" + com_tencent_mm_protocal_c_azq.mWm.get(i4));
            }
            if (com_tencent_mm_protocal_c_azp.gll == 1) {
                this.cii.a(i2, i3, str, this);
                ix(1);
                return;
            }
            this.etj += com_tencent_mm_protocal_c_azp.mok.mQu;
            if (this.etj >= com_tencent_mm_protocal_c_azp.mdz) {
                c.iv(com_tencent_mm_protocal_c_azq.mwN);
                c.iu(com_tencent_mm_protocal_c_azq.mwM);
                ix(3);
                q.lD(com_tencent_mm_protocal_c_azp.mHw);
                this.cii.a(i2, i3, str, this);
                return;
            } else if (a(this.czE, this.cii) == -1) {
                this.cii.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        v.d("MicroMsg.NetSceneThrowBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        q.lD(com_tencent_mm_protocal_c_azp.mHw);
        this.cii.a(i2, i3, str, this);
    }

    public final int XE() {
        return ((azq) this.cif.czl.czs).mNn;
    }

    private int ix(int i) {
        a aVar = new a();
        aVar.msgType = i;
        azp com_tencent_mm_protocal_c_azp = (azp) this.cif.czk.czs;
        azq com_tencent_mm_protocal_c_azq = (azq) this.cif.czl.czs;
        aVar.etb = com_tencent_mm_protocal_c_azq.mWm.size();
        aVar.etd = 1;
        if (i == 3) {
            aVar.content = com_tencent_mm_protocal_c_azp.mHw;
            aVar.ete = com_tencent_mm_protocal_c_azp.mpw;
        } else {
            aVar.content = new String(m.a(com_tencent_mm_protocal_c_azp.mok));
        }
        String str = "";
        for (int i2 = 0; i2 < com_tencent_mm_protocal_c_azq.mWm.size(); i2++) {
            str = str + com_tencent_mm_protocal_c_azq.mWm.get(i2);
        }
        aVar.eta = com.tencent.mm.a.g.m(str.getBytes());
        aVar.etf = be.Ni();
        for (int i3 = 0; i3 < com_tencent_mm_protocal_c_azq.mWm.size(); i3++) {
            String pw = c.pw(m.a((arf) com_tencent_mm_protocal_c_azq.mWm.get(i3)));
            if (!be.kS(pw)) {
                aVar.etc = pw;
                i.XG().a(aVar);
            }
        }
        return 0;
    }

    public final int getType() {
        return 154;
    }
}
