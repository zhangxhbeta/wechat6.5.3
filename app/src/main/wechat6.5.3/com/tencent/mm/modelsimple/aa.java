package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.asu;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class aa extends k implements j {
    private final b cif;
    private e cii;

    public aa(int[] iArr) {
        a aVar = new a();
        aVar.czn = new ast();
        aVar.czo = new asu();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        this.cif = aVar.Bv();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((ast) this.cif.czk.czs).mRo = linkedList;
        ((ast) this.cif.czk.czs).mRn = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 116;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
