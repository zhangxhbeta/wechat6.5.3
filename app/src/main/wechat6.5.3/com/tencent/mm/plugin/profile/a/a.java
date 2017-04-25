package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    private final b cif;
    private e cii;
    public String hTx;

    public a(String str, String str2) {
        this.hTx = str;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aax();
        aVar.czo = new aay();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.czm = 205;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aax com_tencent_mm_protocal_c_aax = (aax) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aax.gln = str2;
        ak.yW();
        String ma = be.ma((String) c.vf().get(46, null));
        com_tencent_mm_protocal_c_aax.med = new are().ba(be.KG(ma));
        ak.yW();
        String ma2 = be.ma((String) c.vf().get(72, null));
        com_tencent_mm_protocal_c_aax.mvE = new are().ba(be.KG(ma2));
        v.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + ma + " , newa2:" + ma2);
    }

    public final int getType() {
        return 205;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), getURL()});
        this.cii.a(i2, i3, str, this);
    }

    public final String getURL() {
        return ((aay) this.cif.czl.czs).URL;
    }
}
