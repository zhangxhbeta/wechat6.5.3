package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class af extends k implements j {
    public final b cif;
    private e cii;

    public af(String str, int i, LinkedList<cb> linkedList) {
        v.d("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        a aVar = new a();
        aVar.czn = new bac();
        aVar.czo = new bad();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        this.cif = aVar.Bv();
        bac com_tencent_mm_protocal_c_bac = (bac) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bac.cZp = str;
        com_tencent_mm_protocal_c_bac.scene = i;
        com_tencent_mm_protocal_c_bac.mWK = linkedList;
    }

    public final int getType() {
        return 1200;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.cii.a(i2, i3, str, this);
    }

    public final bad Jy() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (bad) this.cif.czl.czs;
    }
}
