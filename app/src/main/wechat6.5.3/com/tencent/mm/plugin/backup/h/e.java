package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.protocal.c.eg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import junit.framework.Assert;

public final class e extends a {
    private b cif;
    private String emw;

    public e(String str, String str2, boolean z, int i) {
        a aVar = new a();
        aVar.czn = new ef();
        aVar.czo = new eg();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatuploadhead";
        this.cif = aVar.Bv();
        ef efVar = (ef) this.cif.czk.czs;
        efVar.meZ = str;
        efVar.eer = str2;
        if (z) {
            efVar.itH = i;
            efVar.mfn = 1;
        }
        this.ehp = str;
        this.emw = str2;
        int length = com.tencent.mm.plugin.backup.g.b.Vl() == null ? -1 : com.tencent.mm.plugin.backup.g.b.Vl().length;
        v.i("MicroMsg.NetSceneBakChatUploadHead", "dkbak bakChatClientId:%s bakChatName:%s needpwd:%b keyHashCode:%d pwd:%d", efVar.meZ, efVar.eer, Boolean.valueOf(z), Integer.valueOf(efVar.itH), Integer.valueOf(length));
        if (!z && length > 0) {
            Assert.assertTrue("NetSceneBakChatUploadHead pwd is not null , but NOT needPwd", false);
        }
        if (z && length <= 0) {
            Assert.assertTrue("NetSceneBakChatUploadHead pwd is null , but needPwd", false);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBakChatUploadHead", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            eg egVar = (eg) ((b) pVar).czl.czs;
            this.emn = egVar.mfa;
            v.i("MicroMsg.NetSceneBakChatUploadHead", "dkbak bakSvrId:" + this.emn + " pcBakChatClientId:" + egVar.meZ + " pwd:" + (com.tencent.mm.plugin.backup.g.b.Vl() == null ? -1 : com.tencent.mm.plugin.backup.g.b.Vl().length));
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 321;
    }
}
