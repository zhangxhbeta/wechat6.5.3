package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class l extends k implements j {
    public final b cif;
    private e cii;

    private l() {
        a aVar = new a();
        aVar.czn = new ru();
        aVar.czo = new rv();
        aVar.uri = "/cgi-bin/micromsg-bin/geta8key";
        aVar.czm = 233;
        aVar.czp = 155;
        aVar.czq = 1000000155;
        this.cif = aVar.Bv();
        ru ruVar = (ru) this.cif.czk.czs;
        ak.yW();
        String ma = be.ma((String) c.vf().get(46, null));
        ruVar.med = new are().ba(be.KG(ma));
        ak.yW();
        String ma2 = be.ma((String) c.vf().get(72, null));
        ruVar.mvE = new are().ba(be.KG(ma2));
        v.d("MicroMsg.NetSceneGetA8Key", "dkwt get a2=" + ma + " newa2=" + ma2);
    }

    public l(String str, String str2, String str3) {
        this();
        ru ruVar = (ru) this.cif.czk.czs;
        ruVar.lZm = 1;
        ruVar.mvx = new arf().JF(str);
        ruVar.mvy = new arf().JF(str2);
        ruVar.mvz = new arf().JF(str3);
        v.d("MicroMsg.NetSceneGetA8Key", "get a8key appid=" + str);
    }

    public l(String str, String str2, int i) {
        this();
        ru ruVar = (ru) this.cif.czk.czs;
        ruVar.lZm = 2;
        ruVar.mvA = new arf().JF(str);
        ruVar.maG = i;
        ruVar.gln = str2;
        ruVar.mvF = 0;
        v.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + str2 + ", scene = " + i + ", reason = 0");
    }

    public l(String str, int i, int i2, int i3) {
        this();
        ru ruVar = (ru) this.cif.czk.czs;
        ruVar.lZm = 2;
        ruVar.mvA = new arf().JF(str);
        ruVar.maG = i;
        ruVar.gln = null;
        ruVar.mvF = 0;
        ruVar.mvI = i2;
        ruVar.mvJ = i3;
        v.d("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = " + str + ", username = " + null + ", scene = " + i + ", reason = 0, codeType = " + i2 + ", codeVersion = " + i3);
    }

    public l(String str, String str2, int i, int i2, int i3, String str3) {
        this();
        ru ruVar = (ru) this.cif.czk.czs;
        ruVar.lZm = 2;
        ruVar.mvA = new arf().JF(str);
        ruVar.maG = i;
        ruVar.gln = str2;
        ruVar.mvF = i2;
        ruVar.mbK = i3;
        ruVar.mvH = str3;
        v.i("MicroMsg.NetSceneGetA8Key", "get a8key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3);
    }

    public l(int i) {
        this();
        ru ruVar = (ru) this.cif.czk.czs;
        ruVar.lZm = 3;
        ruVar.maG = 5;
        ruVar.mvC = i;
        v.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key friendQQNum:%d  a2key-len:%d", Integer.valueOf(i), Integer.valueOf(ruVar.med.mQu));
    }

    public final int getType() {
        return 233;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetA8Key", "dkwt geta8key onGYNetEnd:[%d,%d] url:[%s]  a8key:[%s]", Integer.valueOf(i2), Integer.valueOf(i3), IT(), ((rv) this.cif.czl.czs).mvL);
        this.cii.a(i2, i3, str, this);
    }

    public final String IT() {
        return ((rv) this.cif.czl.czs).mvK;
    }

    public final String IU() {
        arf com_tencent_mm_protocal_c_arf = ((ru) this.cif.czk.czs).mvA;
        if (com_tencent_mm_protocal_c_arf != null) {
            return com_tencent_mm_protocal_c_arf.mQy;
        }
        return null;
    }

    public final String getTitle() {
        return ((rv) this.cif.czl.czs).aXz;
    }

    public final String pO() {
        return ((rv) this.cif.czl.czs).hQP;
    }

    public final int IV() {
        return ((rv) this.cif.czl.czs).lZu;
    }

    public final byte[] IW() {
        rv rvVar = (rv) this.cif.czl.czs;
        if (rvVar.mvT == null) {
            return null;
        }
        try {
            return m.a(rvVar.mvT);
        } catch (Exception e) {
            return null;
        }
    }

    public final String IX() {
        return ((rv) this.cif.czl.czs).mvO;
    }

    public final ArrayList<byte[]> IY() {
        rv rvVar = (rv) this.cif.czl.czs;
        ArrayList<byte[]> arrayList = new ArrayList();
        if (rvVar == null || rvVar.mvQ == null) {
            return arrayList;
        }
        Iterator it = rvVar.mvQ.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(((hp) it.next()).toByteArray());
            } catch (Throwable e) {
                v.e("MicroMsg.NetSceneGetA8Key", "exception:%s", be.e(e));
            }
        }
        v.d("MicroMsg.NetSceneGetA8Key", "ScopeList size = %s", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final long IZ() {
        rv rvVar = (rv) this.cif.czl.czs;
        return rvVar.mvS != null ? rvVar.mvS.moL : -1;
    }
}
