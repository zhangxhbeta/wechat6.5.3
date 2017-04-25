package com.tencent.mm.modelsimple;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.protocal.z.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u extends k implements j {
    public p cAt;
    private final String cYZ;
    private final String cZa;
    private final String cZb;
    private final String cZc;
    private final String cZd;
    private final String cZe;
    private final int cZf;
    private final int cZg;
    private boolean cZh = true;
    public boolean cZi = false;
    e cii;
    private int czX = 2;

    public u(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2) {
        v.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + str + " nickname = " + str3);
        v.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + i + "bindEmail = " + str4 + " bindMobile = " + str5);
        v.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + i2 + " ticket: " + str6);
        this.cZg = i2;
        this.cAt = new ao();
        a aVar = (a) this.cAt.Bx();
        aVar.cW(0);
        aVar.lXu.gln = str;
        aVar.lXu.mgI = be.KE(str2);
        if (i2 == 4) {
            aVar.lXu.mgI = str6;
            v.w("MicroMsg.NetSceneReg", "dkreg rand:" + str6 + " reqMd5:" + aVar.lXu.mgI);
        }
        aVar.lXu.efy = str3;
        aVar.lXu.mar = i;
        aVar.lXu.mas = str4;
        aVar.lXu.mat = str5;
        aVar.lXu.mpB = str6;
        aVar.lXu.mAT = i2;
        aVar.lXu.fvy = be.buj();
        aVar.lXu.mpz = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.lXu.fvz = com.tencent.mm.sdk.platformtools.u.bsY();
        aVar.lXu.meo = 0;
        aVar.lXu.mKL = 0;
        aVar.lXu.mKM = com.tencent.mm.compatible.d.p.getAndroidId();
        aVar.lXu.mrB = com.tencent.mm.compatible.d.p.rL();
        aVar.lXu.mKN = aa.getContext().getSharedPreferences(aa.bti(), 0).getString("installreferer", SQLiteDatabase.KeyEmpty);
        aVar.lXu.mKO = bb.eN(2);
        aVar.lXu.mKP = aa.getContext().getSharedPreferences(aa.bti() + "_google_aid", 4).getString("getgoogleaid", SQLiteDatabase.KeyEmpty);
        this.cYZ = str;
        this.cZa = str2;
        this.cZb = str3;
        this.cZc = str4;
        this.cZd = str5;
        this.cZf = i;
        this.cZe = SQLiteDatabase.KeyEmpty;
        boolean z = (str6 == null || str6.length() <= 0) && str4.length() <= 0;
        this.cZh = z;
        aVar.lXu.mep = com.tencent.mm.kernel.a.uR();
    }

    public u(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, boolean z, boolean z2) {
        v.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", str, be.KW(str2), str3, Integer.valueOf(i), str4, str5, str6, str7, str8, Integer.valueOf(i2), str9, str11, str10, Boolean.valueOf(z), Boolean.valueOf(z2));
        this.cZg = i2;
        this.cAt = new ao();
        a aVar = (a) this.cAt.Bx();
        aVar.cW(0);
        aVar.lXu.gln = str;
        aVar.lXu.mgI = be.KE(str2);
        if (i2 == 4) {
            aVar.lXu.mgI = str8;
            v.w("MicroMsg.NetSceneReg", "dkreg rand:" + str8 + " reqMd5:" + aVar.lXu.mgI);
        }
        aVar.lXu.efy = str3;
        aVar.lXu.mar = i;
        aVar.lXu.mas = str4;
        aVar.lXu.mat = str5;
        aVar.lXu.mpB = str8;
        aVar.lXu.mAT = i2;
        aVar.lXu.fvy = be.buj();
        aVar.lXu.mpz = com.tencent.mm.compatible.d.p.getSimCountryIso();
        aVar.lXu.fvz = com.tencent.mm.sdk.platformtools.u.bsY();
        aVar.lXu.meo = 0;
        aVar.lXu.cHh = str9;
        aVar.lXu.mAS = str11;
        aVar.lXu.mAR = str10;
        aVar.lXu.mgA = z ? 1 : 0;
        aVar.lXu.mKK = z2 ? 1 : 0;
        aVar.lXu.mep = com.tencent.mm.kernel.a.uR();
        aVar.lXu.mKM = com.tencent.mm.compatible.d.p.getAndroidId();
        aVar.lXu.mrB = com.tencent.mm.compatible.d.p.rL();
        aVar.lXu.mKN = aa.getContext().getSharedPreferences(aa.bti(), 0).getString("installreferer", SQLiteDatabase.KeyEmpty);
        aVar.lXu.mKO = bb.eN(2);
        aVar.lXu.mKP = aa.getContext().getSharedPreferences(aa.bti() + "_google_aid", 4).getString("getgoogleaid", SQLiteDatabase.KeyEmpty);
        this.cYZ = str;
        this.cZa = str2;
        this.cZb = str3;
        this.cZc = str4;
        this.cZd = str5;
        this.cZf = i;
        this.cZe = str9;
        boolean z3 = (str8 == null || str8.length() <= 0) && (str4 == null || str4.length() <= 0);
        this.cZh = z3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 126;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        boolean z = true;
        final b bVar = (b) pVar.ze();
        if (i2 == 4 && i3 == -301) {
            al.a(true, bVar.lXv.mgK, bVar.lXv.mgL, bVar.lXv.mgJ);
            this.czX--;
            if (this.czX <= 0) {
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
            } else {
                a(this.czE, this.cii);
            }
        } else if (i2 == 4 && i3 == -102) {
            r0 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(r0));
            g.vA().x(new Runnable(this) {
                final /* synthetic */ u cZj;

                public final void run() {
                    new m().a(this.cZj.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 cZk;

                        {
                            this.cZk = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.cZk.cZj.a(this.cZk.cZj.czE, this.cZk.cZj.cii);
                            } else {
                                this.cZk.cZj.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.cZk.cZj);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            a aVar = (a) pVar.Bx();
            v.d("MicroMsg.NetSceneReg", "dkreg: pass:" + bVar.lXv.fvq + " regtype:" + bVar.lXv.mav + " mode:" + aVar.lXu.mAT);
            if (!(bVar.lXv.fvo == 0 || this.cZh)) {
                com.tencent.mm.kernel.e.a(g.vw().cjT, bVar.lXv.fvo);
                com.tencent.mm.kernel.a.ey(bVar.lXv.fvo);
                if (aVar.lXu.mAT == 4) {
                    g.vw().vf().set(2, aVar.lXu.gln);
                }
                g.vw().vf().set(16, Integer.valueOf(1));
                g.vw().vf().set(52, Integer.valueOf(bVar.lXv.mav));
                g.vw().vf().set(340240, Long.valueOf(System.currentTimeMillis()));
                g.vw().vf().set(340241, Boolean.valueOf(true));
                if (!(this.cYZ == null || this.cYZ.length() <= 0 || this.cZg == 1)) {
                    bVar.lXv.gln = this.cYZ;
                }
                bVar.lXv.mas = this.cZc;
                bVar.lXv.eeO = 0;
                aj.a(bVar, this.cZe, this.cZf, this.cZb, this.cZd);
                al.a(false, bVar.lXv.mgK, bVar.lXv.mgL, bVar.lXv.mgJ);
                aj.a(bVar.lXv.mwS, bVar.lXv.mwT, bVar.lXv.mwU);
                g.vw().vf().iB(true);
                g.vy().a(new ay(new ay.a(this) {
                    final /* synthetic */ u cZj;

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.BU().i(bVar.dlf, bVar.lXv.fvo);
                        }
                    }
                }), 0);
                v.d("MicroMsg.NetSceneReg", "resp return flag" + bVar.lXv.mKT);
                this.cZi = (bVar.lXv.mKT & 1) != 0;
            }
            List linkedList = new LinkedList();
            linkedList.add(new i.a(21, "android-" + VERSION.SDK_INT + "-" + Build.MODEL));
            ((d) g.f(d.class)).wG().b(new i(linkedList));
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.a.b.gM(Fp());
            }
            r0 = bVar.lXv.mek;
            v.i("MicroMsg.NetSceneReg", "summerauth mmtls:%d", Integer.valueOf(r0));
            g.vx();
            g.vw().cjT.set(47, Integer.valueOf(r0));
            com.tencent.mm.network.e eVar = g.vv().cjC.cAa;
            if (eVar != null) {
                if ((r0 & 1) != 0) {
                    z = false;
                }
                eVar.aW(z);
            }
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final byte[] Fv() {
        return m.a(((b) this.cAt.ze()).lXv.mAU, new byte[0]);
    }

    public final String Fw() {
        return ((b) this.cAt.ze()).lXv.mAR;
    }

    public final String Jq() {
        return ((b) this.cAt.ze()).lXv.mKX;
    }

    public final int Fp() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lXv.mef;
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

    public final String Jr() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lXv.mef;
        String str = SQLiteDatabase.KeyEmpty;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 2) {
                    return com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
        }
        return str;
    }

    public final int Js() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lXv.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 3) {
                    return be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 2);
                }
            }
        }
        return 2;
    }

    public final String Jt() {
        aux com_tencent_mm_protocal_c_aux = ((b) this.cAt.ze()).lXv.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 17) {
                    return com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
        }
        return null;
    }
}
