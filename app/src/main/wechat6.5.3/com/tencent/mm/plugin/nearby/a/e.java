package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    private final b cif;
    private com.tencent.mm.v.e cii;
    public String hEG;
    public String hEH;

    public e(float f, float f2, int i, String str, String str2) {
        a aVar = new a();
        aVar.czn = new agb();
        aVar.czo = new agc();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.czm = 376;
        aVar.czp = 183;
        aVar.czq = 1000000183;
        this.cif = aVar.Bv();
        agb com_tencent_mm_protocal_c_agb = (agb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agb.lZm = 1;
        com_tencent_mm_protocal_c_agb.mjM = f;
        com_tencent_mm_protocal_c_agb.mjN = f2;
        com_tencent_mm_protocal_c_agb.mrA = i;
        com_tencent_mm_protocal_c_agb.mrB = str;
        com_tencent_mm_protocal_c_agb.mrC = str2;
        com_tencent_mm_protocal_c_agb.mrD = 0;
        v.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1" + " lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
    }

    public e(String str, int i, int i2) {
        a aVar = new a();
        aVar.czn = new agb();
        aVar.czo = new agc();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.czm = 376;
        aVar.czp = 183;
        aVar.czq = 1000000183;
        this.cif = aVar.Bv();
        agb com_tencent_mm_protocal_c_agb = (agb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agb.mjM = 0.0f;
        com_tencent_mm_protocal_c_agb.mjN = 0.0f;
        com_tencent_mm_protocal_c_agb.mrA = 0;
        com_tencent_mm_protocal_c_agb.mrD = 0;
        com_tencent_mm_protocal_c_agb.mrB = "";
        com_tencent_mm_protocal_c_agb.mrC = "";
        com_tencent_mm_protocal_c_agb.lZm = 2;
        com_tencent_mm_protocal_c_agb.cTd = str;
        com_tencent_mm_protocal_c_agb.mFP = i;
        com_tencent_mm_protocal_c_agb.mFO = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 376;
    }

    public final int AG() {
        return ((agb) this.cif.czk.czs).lZm;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + AG());
        agc com_tencent_mm_protocal_c_agc = (agc) ((b) pVar).czl.czs;
        if (i2 != 0) {
            this.cii.a(i2, i3, str, this);
        } else if (AG() == 1) {
            this.hEG = com_tencent_mm_protocal_c_agc.cTd;
            this.hEH = com_tencent_mm_protocal_c_agc.mFQ;
            this.cii.a(i2, i3, str, this);
        } else if (AG() == 2) {
            b.xf(((agb) ((b) pVar).czk.czs).cTd);
            this.cii.a(i2, i3, str, this);
        }
    }
}
