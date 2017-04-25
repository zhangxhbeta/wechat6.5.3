package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends k implements j {
    private final b cQA;
    private e cii;

    public w(String str) {
        a aVar = new a();
        aVar.czn = new aex();
        aVar.czo = new aey();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        aVar.czm = 666;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cQA = aVar.Bv();
        ((aex) this.cQA.czk.czs).glb = str;
    }

    public final int getType() {
        return 666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.cii.a(i2, i3, str, this);
    }

    public final aey Jv() {
        return (aey) this.cQA.czl.czs;
    }
}
