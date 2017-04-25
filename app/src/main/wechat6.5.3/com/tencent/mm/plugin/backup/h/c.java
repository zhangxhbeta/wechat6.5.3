package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import java.util.LinkedList;

public final class c extends a {
    public int aKG = 0;
    private b cif;
    public LinkedList<arf> emu = new LinkedList();
    private int emv = 0;
    public int endFlag = 0;
    public int index = 0;

    public c(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new eb();
        aVar.czo = new ec();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatrecoverhead";
        aVar.czm = 326;
        aVar.czp = 139;
        aVar.czq = 1000000139;
        this.cif = aVar.Bv();
        this.emn = i;
        this.ehp = str;
        this.aKG = i3;
        int i4 = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 131072 : 16384;
        eb ebVar = (eb) this.cif.czk.czs;
        ebVar.meZ = str;
        ebVar.mfa = i;
        ebVar.mfc = i4;
        ebVar.mfl = i2;
        ebVar.efm = i3;
        v.d("MicroMsg.NetSceneBakChatRecoverHead", "rr.req.rImpl  " + ebVar.toString());
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 326;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBakChatRecoverHead", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ec ecVar = (ec) ((b) pVar).czl.czs;
            this.index = ecVar.mfl;
            this.endFlag = ecVar.mfh;
            this.emv = ecVar.eeQ;
            this.emu = ecVar.eeu;
            v.d("MicroMsg.NetSceneBakChatRecoverHead", "resp  index: " + this.index + " endFlag: " + this.endFlag + " totalCount: " + this.emv);
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
