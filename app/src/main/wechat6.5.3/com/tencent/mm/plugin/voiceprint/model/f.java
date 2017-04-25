package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    private final b cif;
    private e cii;
    private String filename;
    public boolean kot = false;
    private boolean kou = false;
    private Handler kov = null;
    int kow = 0;
    private int kox = 0;
    int koy = 0;
    int koz = 0;
    private int vI = 0;

    public f(String str, int i, int i2, int i3) {
        v.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.koy = i;
        a aVar = new a();
        aVar.czn = new aqe();
        aVar.czo = new aqf();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.czm = 612;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aqe com_tencent_mm_protocal_c_aqe = (aqe) this.cif.czk.czs;
        this.filename = str;
        this.vI = 0;
        com_tencent_mm_protocal_c_aqe.mPA = i2;
        com_tencent_mm_protocal_c_aqe.efk = i;
        this.kow = i3;
        com_tencent_mm_protocal_c_aqe.mPy = i3;
        v.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.kot = true;
        baR();
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    private int baR() {
        aqe com_tencent_mm_protocal_c_aqe = (aqe) this.cif.czk.czs;
        bdy com_tencent_mm_protocal_c_bdy = new bdy();
        g gVar = new g();
        com_tencent_mm_protocal_c_aqe.mPz = com_tencent_mm_protocal_c_bdy;
        l lVar = new l(m.as(this.filename, false));
        int aQ = com.tencent.mm.a.e.aQ(m.as(this.filename, false));
        if (aQ - this.vI >= 6000) {
            gVar = lVar.aU(this.vI, 6000);
        } else {
            gVar = lVar.aU(this.vI, aQ - this.vI);
        }
        v.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.vI), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.aUT), Integer.valueOf(aQ), Boolean.valueOf(this.kot)});
        if (gVar.aUT == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            v.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.vI >= 469000) {
            v.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.vI)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bdy.mZI = new are().ba(gVar.buf);
            com_tencent_mm_protocal_c_bdy.mdA = this.vI;
            com_tencent_mm_protocal_c_bdy.mZG = gVar.aUT;
            com_tencent_mm_protocal_c_bdy.mZH = 0;
            com_tencent_mm_protocal_c_aqe.mPy = this.kow;
            if (this.kot && gVar.dik >= com.tencent.mm.a.e.aQ(m.as(this.filename, false))) {
                com_tencent_mm_protocal_c_bdy.mZH = 1;
                this.kou = true;
                v.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aQ)});
            }
            this.vI = gVar.dik;
            com_tencent_mm_protocal_c_aqe.mPz = com_tencent_mm_protocal_c_bdy;
            return 0;
        }
    }

    public final int getType() {
        return 612;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aqf com_tencent_mm_protocal_c_aqf = (aqf) ((b) pVar).czl.czs;
        if (i2 == 0 || i3 == 0) {
            v.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aqf.mPy), Integer.valueOf(com_tencent_mm_protocal_c_aqf.mPB), Integer.valueOf(com_tencent_mm_protocal_c_aqf.mPC), Integer.valueOf(com_tencent_mm_protocal_c_aqf.mPB)});
            this.kow = com_tencent_mm_protocal_c_aqf.mPy;
            this.kox = com_tencent_mm_protocal_c_aqf.mPC;
            this.koz = com_tencent_mm_protocal_c_aqf.mPB;
            if (this.kou) {
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(baR())});
            a(this.czE, this.cii);
            v.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
