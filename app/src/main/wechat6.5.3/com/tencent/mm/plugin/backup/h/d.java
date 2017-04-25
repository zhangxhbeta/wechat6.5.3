package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;

public final class d extends a {
    private b cif;

    public d(String str, int i) {
        int Vx = g.Vx();
        v.d("MicroMsg.NetSceneBakChatUploadEnd", "NetSceneBakChatUploadEnd" + str + " bakChatSvrId " + i + " netType:" + Vx);
        a aVar = new a();
        aVar.czn = new ed();
        aVar.czo = new ee();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatuploadend";
        this.cif = aVar.Bv();
        ed edVar = (ed) this.cif.czk.czs;
        edVar.meZ = str;
        edVar.mfa = i;
        edVar.mfm = Vx;
        this.ehp = str;
        this.emn = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBakChatUploadEnd", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 322;
    }
}
