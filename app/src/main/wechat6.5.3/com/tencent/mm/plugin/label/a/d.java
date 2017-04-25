package com.tencent.mm.plugin.label.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class d extends k implements j {
    private final b cif;
    private e cii;
    private LinkedList<bcz> gPT = new LinkedList();

    public d(LinkedList<bcz> linkedList) {
        a aVar = new a();
        aVar.czn = new ajl();
        aVar.czo = new ajm();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.czm = 638;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gPT = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.cii = eVar2;
        ajl com_tencent_mm_protocal_c_ajl = (ajl) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ajl.mJS = this.gPT;
        com_tencent_mm_protocal_c_ajl.mxK = this.gPT.size();
        return a(eVar, this.cif, this);
    }
}
