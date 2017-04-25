package com.tencent.mm.modelfriend;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class u extends k implements j {
    public final p cAt;
    e cii;
    private int czX;

    public static class a extends i {
        private final com.tencent.mm.protocal.n.a cIc = new com.tencent.mm.protocal.n.a();
        private final b cId = new b();

        protected final c zd() {
            return this.cIc;
        }

        public final d ze() {
            return this.cId;
        }

        public final int getType() {
            return 145;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bindopmobileforreg";
        }

        public final int Bu() {
            return 1;
        }
    }

    public u(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, 0, str3, str4);
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.cAt.Bx();
        aVar.lWY.mgB = str5;
        aVar.lWY.mgC = str6;
    }

    public u(String str, int i, String str2, int i2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        ((com.tencent.mm.protocal.n.a) this.cAt.Bx()).lWY.meg = str4;
    }

    public u(String str, int i, String str2, int i2, String str3) {
        this.cii = null;
        this.czX = 2;
        this.cAt = new a();
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.cAt.Bx();
        aVar.lWY.meB = i;
        v.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.lWY.mgw = str;
        aVar.lWY.mgx = str2;
        aVar.lWY.mgy = i2;
        aVar.lWY.mgz = str3;
        aVar.lWY.fvz = com.tencent.mm.sdk.platformtools.u.bsY();
        aVar.lWY.mep = ak.uR();
        if (be.kS(aVar.lWY.mgB) && be.kS(aVar.lWY.mgC)) {
            aVar.lWY.mgB = f.nia ? aa.getContext().getString(2131234695) : aa.getContext().getString(2131234694);
            aVar.lWY.mgC = com.tencent.mm.protocal.d.lWf;
        }
    }

    public final void fq(int i) {
        ((com.tencent.mm.protocal.n.a) this.cAt.Bx()).lWY.mgE = i;
    }

    public final void fr(int i) {
        ((com.tencent.mm.protocal.n.a) this.cAt.Bx()).lWY.mgF = i;
    }

    public final int AG() {
        return ((com.tencent.mm.protocal.n.a) this.cAt.Bx()).lWY.meB;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.protocal.n.a aVar = (com.tencent.mm.protocal.n.a) this.cAt.Bx();
        if (aVar.lWY.mgw == null || aVar.lWY.mgw.length() <= 0) {
            v.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.lWY.mgw);
            return -1;
        } else if ((aVar.lWY.meB != 6 && aVar.lWY.meB != 9) || (aVar.lWY.mgx != null && aVar.lWY.mgx.length() > 0)) {
            return a(eVar, this.cAt, this);
        } else {
            v.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.lWY.mgw);
            return -1;
        }
    }

    public final int getType() {
        return 145;
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        b bVar = (b) pVar.ze();
        if (i2 == 4 && i3 == -301) {
            al.a(true, bVar.lWZ.mgK, bVar.lWZ.mgL, bVar.lWZ.mgJ);
            this.czX--;
            if (this.czX <= 0) {
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else {
                a(this.czE, this.cii);
            }
        } else if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ u cIa;

                public final void run() {
                    new m().a(this.cIa.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 cIb;

                        {
                            this.cIb = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.cIb.cIa.a(this.cIb.cIa.czE, this.cIb.cIa.cii);
                            } else {
                                this.cIb.cIa.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.cIb.cIa);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            al.a(false, bVar.lWZ.mgK, bVar.lWZ.mgL, bVar.lWZ.mgJ);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.a.b.gM(Fp());
            }
            this.cii.a(i2, i3, str, this);
        } else {
            v.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.cii.a(i2, i3, str, this);
        }
    }

    public final String Fh() {
        return ((b) this.cAt.ze()).lWZ.mgI;
    }

    public final String getUsername() {
        return ((b) this.cAt.ze()).lWZ.mdw;
    }

    public final String Fi() {
        return ((b) this.cAt.ze()).lWZ.bax;
    }

    public final String Fj() {
        return ((b) this.cAt.ze()).lWZ.meg;
    }

    public final String Fk() {
        return ((b) this.cAt.ze()).lWZ.mgP;
    }

    public final int Fl() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 6) {
                    return be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 3);
                }
            }
        }
        return 3;
    }

    public final int Fm() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 4) {
                    return be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 30);
                }
            }
        }
        return 30;
    }

    public final int Fn() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 5) {
                    return be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                }
            }
        }
        return 0;
    }

    public final boolean Fo() {
        int i;
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 7) {
                    i = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    private int Fp() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
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

    public final boolean Fq() {
        int i;
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 10) {
                    i = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final String Fr() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 14) {
                    return com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
        }
        return null;
    }

    public final String Fs() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lWZ.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 15) {
                    return com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
        }
        return null;
    }
}
