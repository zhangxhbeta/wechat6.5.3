package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.model.as.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.k.b;

public final class f extends k implements j {
    private p cAt = new d();
    private e cii;

    public f(String str, String str2) {
        v.i("MicroMsg.NetSceneUploadSoterASKRsa", "MicroMsg.NetSceneUploadSoterASKRsa constructor");
        a aVar = (a) this.cAt.Bx();
        aVar.cta.mXm = str;
        aVar.cta.mXn = str2;
    }

    protected final int ul() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 627;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneUploadSoterASKRsa", "MicroMsg.NetSceneUploadSoterASKRsa errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
