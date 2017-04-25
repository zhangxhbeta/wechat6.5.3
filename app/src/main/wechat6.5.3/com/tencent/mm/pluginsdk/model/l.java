package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    private final b cif;
    private e cii;

    public l(String str, String str2) {
        this(str, str2, 0);
    }

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.czn = new asp();
        aVar.czo = new asq();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.czm = 153;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        asp com_tencent_mm_protocal_c_asp = (asp) this.cif.czk.czs;
        if (i != 8) {
            if (be.kS(str2)) {
                str2 = v.bmZ();
            } else {
                str2 = str2 + " " + v.bmZ();
            }
        }
        com_tencent_mm_protocal_c_asp.mRl = str;
        com_tencent_mm_protocal_c_asp.hQP = str2;
        com_tencent_mm_protocal_c_asp.mFm = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 153;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.cii.a(i2, i3, str, this);
    }
}
