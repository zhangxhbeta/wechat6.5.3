package com.tencent.mm.ap;

import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.protocal.c.bdm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends b {
    private String cZW;
    private boolean cZX;
    private com.tencent.mm.v.b cif;
    private e cii;

    public g(String str, String str2, String str3, String str4) {
        this.cZX = false;
        this.cZX = false;
        a aVar = new a();
        aVar.czn = new bdl();
        aVar.czo = new bdm();
        aVar.uri = "/cgi-bin/micromsg-bin/verifysoterfingerprintlogin";
        aVar.czm = 248;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bdl com_tencent_mm_protocal_c_bdl = (bdl) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bdl.maG = 248;
        com_tencent_mm_protocal_c_bdl.mXp = str;
        com_tencent_mm_protocal_c_bdl.mhd = str2;
        com_tencent_mm_protocal_c_bdl.mXo = str3;
        com_tencent_mm_protocal_c_bdl.mhc = str4;
        com_tencent_mm_protocal_c_bdl.mgD = new are().ba(be.buh());
    }

    public final int getType() {
        return 248;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 3;
    }

    public final void b(int i, int i2, String str, p pVar) {
        if (i == 0 && i2 == 0) {
            this.cZW = ((bdm) ((com.tencent.mm.v.b) pVar).czl.czs).mZr;
        }
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final void JK() {
        v.i("MicroMsg.NetSceneVerifySoterFingerprintLoginRsa", "onAuth key expired");
        if (this.cii != null) {
            this.cii.a(4, -3202, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }
}
