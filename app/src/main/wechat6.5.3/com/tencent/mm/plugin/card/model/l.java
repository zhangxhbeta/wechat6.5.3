package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ae;
import com.tencent.mm.protocal.c.af;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class l extends k implements j {
    private final b cif;
    private e cii;
    public String eDn;
    public int eDo;
    public String eDp;

    public l(LinkedList<iv> linkedList, int i, String str, String str2, int i2) {
        a aVar = new a();
        aVar.czn = new ae();
        aVar.czo = new af();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        aVar.czm = 687;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ae aeVar = (ae) this.cif.czk.czs;
        aeVar.lZQ = linkedList;
        aeVar.bon = i;
        aeVar.lZM = str;
        aeVar.lZL = str2;
        aeVar.lZN = i2;
    }

    public final int getType() {
        return 687;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            af afVar = (af) this.cif.czl.czs;
            this.eDn = afVar.eDn;
            this.eDo = afVar.eDo;
            this.eDp = afVar.eDp;
            v.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.eDo + " ret_msg = " + this.eDp);
        }
        this.cii.a(i2, i3, str, this);
    }
}
