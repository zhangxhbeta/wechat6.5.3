package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;

public final class d extends f {
    public int actionType;
    private final b cif;
    private e cii;
    private final String gVK;
    private int hGO = 0;
    public int kkU;

    public d(int i, long j, int i2, String str, int i3) {
        this.hGO = i3;
        a aVar = new a();
        aVar.czn = new azd();
        aVar.czo = new aze();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.czm = 334;
        aVar.czp = 146;
        aVar.czq = 1000000146;
        this.cif = aVar.Bv();
        azd com_tencent_mm_protocal_c_azd = (azd) this.cif.czk.czs;
        com_tencent_mm_protocal_c_azd.mqS = i;
        com_tencent_mm_protocal_c_azd.mqT = j;
        com_tencent_mm_protocal_c_azd.muU = i2;
        com_tencent_mm_protocal_c_azd.mbL = (int) be.Nh();
        this.actionType = i2;
        this.gVK = str;
        com_tencent_mm_protocal_c_azd.maG = i3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 334;
    }

    public final String bas() {
        return this.gVK;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.kkU = ((aze) this.cif.czl.czs).mqU;
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int bat() {
        return this.hGO;
    }
}
