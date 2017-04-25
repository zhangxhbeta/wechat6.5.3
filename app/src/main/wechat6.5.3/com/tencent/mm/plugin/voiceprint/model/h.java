package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.at;
import com.tencent.mm.model.at.a;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.b;

public final class h extends k implements j {
    private final p cAt;
    e cii;
    private String filename;
    String koC = "";
    public boolean kot = false;
    private boolean kou = false;
    private Handler kov = null;
    private int kow = 0;
    int koz = 0;
    private int vI = 0;

    public h(String str, int i, String str2) {
        v.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[]{Integer.valueOf(i), be.ah(str2, "")});
        this.cAt = new c();
        a aVar = (a) this.cAt.Bx();
        this.filename = str;
        this.vI = 0;
        aVar.ctc.mPA = i;
        aVar.ctc.mBQ = str2;
        this.kow = 0;
        aVar.ctc.mPy = 0;
        v.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.kot = true;
        baR();
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    private int baR() {
        a aVar = (a) this.cAt.Bx();
        bdy com_tencent_mm_protocal_c_bdy = new bdy();
        g gVar = new g();
        aVar.ctc.mZA = com_tencent_mm_protocal_c_bdy;
        l lVar = new l(m.as(this.filename, false));
        int aQ = com.tencent.mm.a.e.aQ(m.as(this.filename, false));
        if (aQ - this.vI >= 6000) {
            gVar = lVar.aU(this.vI, 6000);
        } else {
            gVar = lVar.aU(this.vI, aQ - this.vI);
        }
        v.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.vI), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.aUT), Integer.valueOf(aQ), Boolean.valueOf(this.kot)});
        if (gVar.aUT == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            v.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.vI >= 469000) {
            v.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.vI)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bdy.mZI = new are().ba(gVar.buf);
            com_tencent_mm_protocal_c_bdy.mdA = this.vI;
            com_tencent_mm_protocal_c_bdy.mZG = gVar.aUT;
            com_tencent_mm_protocal_c_bdy.mZH = 0;
            aVar.ctc.mPy = this.kow;
            if (this.kot && gVar.dik >= com.tencent.mm.a.e.aQ(m.as(this.filename, false))) {
                com_tencent_mm_protocal_c_bdy.mZH = 1;
                this.kou = true;
                v.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aQ)});
            }
            this.vI = gVar.dik;
            aVar.ctc.mZA = com_tencent_mm_protocal_c_bdy;
            return 0;
        }
    }

    public final int getType() {
        return 617;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        at.b bVar = (at.b) pVar.ze();
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.Bx().lWS.ver;
            v.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ h koD;

                public final void run() {
                    new m().a(this.koD.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 koE;

                        {
                            this.koE = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.koE.koD.a(this.koE.koD.czE, this.koE.koD.cii);
                            } else {
                                this.koE.koD.cii.a(i, i2, "", this.koE.koD);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            this.kow = bVar.ctd.mPy;
            this.koz = bVar.ctd.mmL;
            this.koC = bVar.ctd.mZr;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.ctd.mPy);
            objArr[1] = Integer.valueOf(this.koz);
            objArr[2] = Boolean.valueOf(be.kS(this.koC));
            objArr[3] = Integer.valueOf(be.kS(this.koC) ? 0 : this.koC.length());
            v.i(str2, str3, objArr);
            if (this.kou) {
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(baR())});
            a(this.czE, this.cii);
            v.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
