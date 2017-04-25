package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.protocal.c.im;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class f extends k implements j {
    private b cif;
    private e cii;

    public f(LinkedList<arj> linkedList, String str) {
        int i = 0;
        a aVar = new a();
        aVar.czn = new il();
        aVar.czo = new im();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        aVar.czm = 555;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        il ilVar = (il) this.cif.czk.czs;
        ilVar.mjW = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        ilVar.hOe = i;
        ilVar.mjX = str;
        v.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + str);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        im imVar = (im) ((b) pVar).czl.czs;
        if (i3 == 0 && imVar.mjY != 0) {
            i3 = imVar.mjY;
            str = imVar.mjZ;
        }
        v.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
