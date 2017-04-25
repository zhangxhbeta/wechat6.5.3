package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public String bjE;
    private com.tencent.mm.v.b cif;
    private e cii;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new we();
        aVar.czo = new wf();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        aVar.czm = 1337;
        this.cif = aVar.Bv();
        we weVar = (we) this.cif.czk.czs;
        weVar.glj = str;
        weVar.myH = str2;
        weVar.myI = str3;
        v.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
    }

    public final int getType() {
        return 1337;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        wf wfVar = (wf) ((com.tencent.mm.v.b) pVar).czl.czs;
        if (pVar.ze().lWU != 0) {
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.bjE = wfVar.mwc;
        this.cii.a(i2, i3, str, this);
    }
}
