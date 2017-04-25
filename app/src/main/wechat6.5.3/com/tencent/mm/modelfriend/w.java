package com.tencent.mm.modelfriend;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.q.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class w extends k implements j {
    public p cAt;
    private e cii;
    private int czX;

    public static class a extends i {
        private com.tencent.mm.protocal.q.a cIe = new com.tencent.mm.protocal.q.a();
        private b cIf = new b();

        public final int getType() {
            return 481;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        public final d ze() {
            return this.cIf;
        }

        protected final c zd() {
            return this.cIe;
        }

        public final int Bu() {
            return 1;
        }
    }

    private w(int i, String str, String str2, String str3) {
        this.czX = 2;
        this.cAt = new a();
        com.tencent.mm.protocal.q.a aVar = (com.tencent.mm.protocal.q.a) this.cAt.Bx();
        aVar.lXg.meB = i;
        aVar.lXg.mgi = str;
        aVar.lXg.fvz = u.bsY();
        aVar.lXg.mgI = be.KE(str2);
        aVar.lXg.mpy = str3;
        aVar.lXg.mep = ak.uR();
        aVar.lXg.mpz = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.lXg.mpA = 1;
    }

    public w(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public w(String str, String str2) {
        this(1, str, str2, SQLiteDatabase.KeyEmpty);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        b bVar = (b) pVar.ze();
        if (i2 == 4 && i3 == -301) {
            al.a(true, bVar.lXh.mgK, bVar.lXh.mgL, bVar.lXh.mgJ);
            this.czX--;
            if (this.czX <= 0) {
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else {
                a(this.czE, this.cii);
            }
        } else if (i2 == 0 && i3 == 0) {
            al.a(false, bVar.lXh.mgK, bVar.lXh.mgL, bVar.lXh.mgJ);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.a.b.gM(Fp());
            }
            this.cii.a(i2, i3, str, this);
        } else {
            v.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int ul() {
        return 5;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    public final int Fp() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lXh.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 1) {
                    return be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                }
            }
        }
        return 0;
    }

    public final int getType() {
        return 481;
    }
}
