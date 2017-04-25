package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;

public final class e extends f {
    private final b cif;
    private com.tencent.mm.v.e cii;
    private final String gVK;
    private int hGO = 0;

    public e(String str, int i, long j, int i2) {
        this.hGO = i2;
        a aVar = new a();
        aVar.czn = new azf();
        aVar.czo = new azg();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.czm = 335;
        aVar.czp = 149;
        aVar.czq = 1000000149;
        this.cif = aVar.Bv();
        azf com_tencent_mm_protocal_c_azf = (azf) this.cif.czk.czs;
        com_tencent_mm_protocal_c_azf.mqS = i;
        com_tencent_mm_protocal_c_azf.mqT = j;
        com_tencent_mm_protocal_c_azf.mbL = (int) be.Nh();
        this.gVK = str;
        com_tencent_mm_protocal_c_azf.maG = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        v.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final String bas() {
        return this.gVK;
    }

    public final int bat() {
        return this.hGO;
    }
}
