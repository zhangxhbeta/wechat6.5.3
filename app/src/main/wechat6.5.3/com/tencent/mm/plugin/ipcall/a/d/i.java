package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class i extends k implements j {
    private b cif = null;
    private e cii;
    private anx gHO = null;
    private any gHP = null;

    public i(int i, long j, boolean z) {
        a aVar = new a();
        aVar.czn = new anx();
        aVar.czo = new any();
        aVar.czm = 227;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHO = (anx) this.cif.czk.czs;
        this.gHO.mqS = i;
        this.gHO.mNQ = j;
        this.gHO.mOj = z ? 1 : 0;
        v.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", new Object[]{Integer.valueOf(this.gHO.mqS), Long.valueOf(this.gHO.mNQ), Integer.valueOf(this.gHO.mOj)});
        anx com_tencent_mm_protocal_c_anx = this.gHO;
        com.tencent.mm.plugin.ipcall.a.c.b auo = com.tencent.mm.plugin.ipcall.a.i.auo();
        v.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", new Object[]{auo.gFG + "," + auo.gFH + "," + auo.gHf + "," + auo.dwA + "," + auo.gHg + "," + auo.gGV + "," + auo.gGW + "," + auo.gGX + "," + auo.gGY + "," + auo.gGZ + "," + auo.gHa + "," + auo.gHb + "," + auo.gHc + "," + auo.gHd + "," + auo.gHe + "," + auo.gHh + "," + c.avA() + "," + auo.gHr + "," + auo.bfd + "," + auo.gHs + "," + auo.gHt + "," + auo.gHu + auo.gHp + "," + auo.gHw});
        com_tencent_mm_protocal_c_anx.mOg = m.lY(r3);
        com_tencent_mm_protocal_c_anx = this.gHO;
        auo = com.tencent.mm.plugin.ipcall.a.i.auo();
        v.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", new Object[]{auo.gFG + "," + auo.gFH + "," + auo.gHf + auo.gHo});
        com_tencent_mm_protocal_c_anx.mOh = m.lY(r3);
        com_tencent_mm_protocal_c_anx = this.gHO;
        auo = com.tencent.mm.plugin.ipcall.a.i.auo();
        v.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", new Object[]{auo.gFG + "," + auo.gFH + "," + auo.gHf + auo.gHn});
        com_tencent_mm_protocal_c_anx.mOi = m.lY(r3);
    }

    public final int getType() {
        return 227;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHP = (any) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
