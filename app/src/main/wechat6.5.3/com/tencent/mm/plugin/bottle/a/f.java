package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Map;

public final class f extends k implements j {
    private final b cif;
    private e cii;
    boolean etl = false;

    public f() {
        a aVar = new a();
        aVar.czn = new amt();
        aVar.czo = new amu();
        aVar.uri = "/cgi-bin/micromsg-bin/pickbottle";
        aVar.czm = 155;
        aVar.czp = 54;
        aVar.czq = 1000000054;
        this.cif = aVar.Bv();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 155;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + i2 + " code:" + i3);
        if (i2 == 4 && (i3 == -2002 || i3 == -56)) {
            c.iu(0);
            c.iv(0);
        }
        amu com_tencent_mm_protocal_c_amu = (amu) this.cif.czl.czs;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.iv(com_tencent_mm_protocal_c_amu.mwN);
                    c.iu(com_tencent_mm_protocal_c_amu.mwM);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.etl = true;
            v.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + com_tencent_mm_protocal_c_amu.mwN + " throw:" + com_tencent_mm_protocal_c_amu.mwM);
            String[] strArr = null;
            if (com_tencent_mm_protocal_c_amu.mLT != null) {
                strArr = com_tencent_mm_protocal_c_amu.mLT.split(":");
            }
            if (strArr != null && strArr.length >= 2) {
                String str2 = strArr[0];
                ak.yW();
                u LX = c.wH().LX(str2);
                if (LX == null || !LX.field_username.equals(str2)) {
                    u uVar = new u();
                    uVar.setUsername(str2);
                    uVar.bS(com_tencent_mm_protocal_c_amu.efy == null ? "" : com_tencent_mm_protocal_c_amu.efy);
                    uVar.cU(3);
                    h hVar = new h();
                    hVar.username = str2;
                    hVar.bBY = 3;
                    hVar.aP(true);
                    hVar.bkU = -1;
                    try {
                        Map q = bf.q(com_tencent_mm_protocal_c_amu.myI, "userinfo");
                        if (q != null) {
                            uVar.cV(be.getInt((String) q.get(".userinfo.$sex"), 0));
                            uVar.cf((String) q.get(".userinfo.$signature"));
                            uVar.cl(RegionCodeDecoder.Y((String) q.get(".userinfo.$country"), (String) q.get(".userinfo.$province"), (String) q.get(".userinfo.$city")));
                            v.d("MicroMsg.NetScenePickBottle", "user:" + str2 + " sig:" + uVar.bCj + " sex" + uVar.bBZ + " city:" + uVar.getCity() + " prov:" + uVar.getProvince());
                            hVar.cyD = (String) q.get(".userinfo.$bigheadimgurl");
                            hVar.cyC = (String) q.get(".userinfo.$smallheadimgurl");
                            hVar.bkU = -1;
                            v.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[]{str2, hVar.Be(), hVar.Bf()});
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + e.getMessage() + " user:" + str2);
                    }
                    ak.yW();
                    c.wH().L(uVar);
                    n.Bo().a(hVar);
                }
            }
            v.d("MicroMsg.NetScenePickBottle", "getBottleType " + com_tencent_mm_protocal_c_amu.mNl);
            v.d("MicroMsg.NetScenePickBottle", "getMsgType " + com_tencent_mm_protocal_c_amu.gll);
            v.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + com_tencent_mm_protocal_c_amu.mLT);
            v.d("MicroMsg.NetScenePickBottle", "getUserInfo " + com_tencent_mm_protocal_c_amu.myI);
            v.d("MicroMsg.NetScenePickBottle", "getNickName " + com_tencent_mm_protocal_c_amu.efy);
            v.d("MicroMsg.NetScenePickBottle", "getUserStatus " + com_tencent_mm_protocal_c_amu.mNm);
            v.d("MicroMsg.NetScenePickBottle", "getThrowCount " + com_tencent_mm_protocal_c_amu.mwM);
            v.d("MicroMsg.NetScenePickBottle", "getPickCount " + com_tencent_mm_protocal_c_amu.mwN);
            v.d("MicroMsg.NetScenePickBottle", "getDistance " + com_tencent_mm_protocal_c_amu.mNn);
        } else if (i3 == -56) {
            c.iv(com_tencent_mm_protocal_c_amu.mwN);
            c.iv(com_tencent_mm_protocal_c_amu.mwM);
        }
        this.cii.a(i2, i3, str, this);
    }

    final amu XD() {
        return (amu) this.cif.czl.czs;
    }
}
