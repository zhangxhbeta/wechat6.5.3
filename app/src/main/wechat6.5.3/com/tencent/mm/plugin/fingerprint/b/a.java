package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public final class a extends b implements j {
    public final com.tencent.mm.v.b cif;
    private e cii;
    public String fUl = "";
    public boolean fUm = false;

    public a() {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new axl();
        aVar.czo = new axm();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.czm = 1586;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        axl com_tencent_mm_protocal_c_axl = (axl) this.cif.czk.czs;
        c bol = com.tencent.mm.pluginsdk.l.e.bol();
        v.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[]{bol.bgr, bol.bgs});
        com_tencent_mm_protocal_c_axl.bgr = r2;
        com_tencent_mm_protocal_c_axl.bgs = r1;
        com_tencent_mm_protocal_c_axl.scene = 0;
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void b(int i, int i2, String str, p pVar) {
        v.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            boolean z;
            axm com_tencent_mm_protocal_c_axm = (axm) ((com.tencent.mm.v.b) pVar).czl.czs;
            this.fUl = com_tencent_mm_protocal_c_axm.fUl;
            o.kQn.fUl = this.fUl;
            this.fUm = 1 == com_tencent_mm_protocal_c_axm.mUD;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == com_tencent_mm_protocal_c_axm.mUD) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.d(str2, str3, objArr);
            o.kQn.fUm = this.fUm;
            v.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[]{this.fUl, Boolean.valueOf(this.fUm)});
        }
        this.cii.a(i, i2, str, this);
    }

    public final void JK() {
        v.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        if (this.cii != null) {
            this.cii.a(4, -1, "", this);
        }
    }
}
