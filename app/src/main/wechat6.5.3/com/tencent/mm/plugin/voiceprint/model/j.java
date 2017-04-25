package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j extends k implements com.tencent.mm.network.j {
    private final b cif;
    private e cii;
    private String filename;
    private String koC = "";
    public boolean kot = false;
    private boolean kou = false;
    private Handler kov = null;
    private int kow = 0;
    int koz = 0;
    private int vI = 0;

    public j(String str, int i) {
        v.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.czn = new bdq();
        aVar.czo = new bdr();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.czm = 613;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bdq com_tencent_mm_protocal_c_bdq = (bdq) this.cif.czk.czs;
        this.filename = str;
        this.vI = 0;
        com_tencent_mm_protocal_c_bdq.mPA = i;
        this.kow = 0;
        com_tencent_mm_protocal_c_bdq.mPy = 0;
        v.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
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
        bdq com_tencent_mm_protocal_c_bdq = (bdq) this.cif.czk.czs;
        bdy com_tencent_mm_protocal_c_bdy = new bdy();
        g gVar = new g();
        com_tencent_mm_protocal_c_bdq.mZA = com_tencent_mm_protocal_c_bdy;
        l lVar = new l(m.as(this.filename, false));
        int aQ = com.tencent.mm.a.e.aQ(m.as(this.filename, false));
        if (aQ - this.vI >= 6000) {
            gVar = lVar.aU(this.vI, 6000);
        } else {
            gVar = lVar.aU(this.vI, aQ - this.vI);
        }
        v.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.vI), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.aUT), Integer.valueOf(aQ), Boolean.valueOf(this.kot)});
        if (gVar.aUT == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            v.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.vI >= 469000) {
            v.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.vI)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bdy.mZI = new are().ba(gVar.buf);
            com_tencent_mm_protocal_c_bdy.mdA = this.vI;
            com_tencent_mm_protocal_c_bdy.mZG = gVar.aUT;
            com_tencent_mm_protocal_c_bdy.mZH = 0;
            com_tencent_mm_protocal_c_bdq.mPy = this.kow;
            if (this.kot && gVar.dik >= com.tencent.mm.a.e.aQ(m.as(this.filename, false))) {
                com_tencent_mm_protocal_c_bdy.mZH = 1;
                this.kou = true;
                v.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aQ)});
            }
            this.vI = gVar.dik;
            com_tencent_mm_protocal_c_bdq.mZA = com_tencent_mm_protocal_c_bdy;
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bdr com_tencent_mm_protocal_c_bdr = (bdr) ((b) pVar).czl.czs;
        if (i2 == 0 || i3 == 0) {
            this.kow = com_tencent_mm_protocal_c_bdr.mPy;
            this.koz = com_tencent_mm_protocal_c_bdr.mmL;
            v.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdr.mPy), Integer.valueOf(this.koz)});
            if (this.kou) {
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(baR())});
            a(this.czE, this.cii);
            v.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
