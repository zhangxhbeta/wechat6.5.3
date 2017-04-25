package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    private final com.tencent.mm.v.b cif;
    private e cii;
    public e iOG;

    public b(float f, float f2) {
        a aVar = new a();
        aVar.czn = new wy();
        aVar.czo = new wz();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        aVar.czm = 1251;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        wy wyVar = (wy) this.cif.czk.czs;
        wyVar.bhs = f2;
        wyVar.biH = f;
    }

    public final int getType() {
        return 1251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            wz wzVar = (wz) this.cif.czl.czs;
            if (wzVar != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!wzVar.mzf) {
                    v.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (wzVar.mzj <= currentTimeMillis) {
                    v.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + wzVar.mzj + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(wzVar.eBK)) {
                    v.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (wzVar.mzg) {
                        v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.iOG = new e();
                    this.iOG.eCZ = 1;
                    this.iOG.eBK = wzVar.eBK;
                    this.iOG.bom = wzVar.bom;
                    this.iOG.title = wzVar.title;
                    this.iOG.eBN = wzVar.eBN;
                    this.iOG.eBO = wzVar.eBO;
                    this.iOG.eCD = wzVar.eCD;
                    this.iOG.eBM = wzVar.eBM;
                    this.iOG.coN = wzVar.coN;
                    this.iOG.iOH = 0;
                    this.iOG.iOK = wzVar.iOK;
                    this.iOG.iOL = wzVar.iOL;
                    this.iOG.iOM = wzVar.iOM;
                    this.iOG.iON = wzVar.iON;
                    this.iOG.iOO = "";
                    this.iOG.eBR = wzVar.eBR;
                    this.iOG.iOP = wzVar.iOP;
                    this.iOG.iOQ = wzVar.iOQ;
                    com.tencent.mm.plugin.shake.b.k.aNU().iOJ = this.iOG.iOO;
                    v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + wzVar.mzj + " is <= currentTime:" + currentTimeMillis);
                    v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + wzVar.mzl);
                    ak.yW();
                    c.vf().a(t.a.nop, Integer.valueOf(currentTimeMillis));
                    ak.yW();
                    c.vf().a(t.a.noq, Integer.valueOf(wzVar.mzj));
                    ak.yW();
                    c.vf().a(t.a.nor, wzVar.mzm);
                    ak.yW();
                    c.vf().a(t.a.nou, wzVar.mzk);
                    ak.yW();
                    c.vf().a(t.a.nov, Integer.valueOf(wzVar.mzl));
                    String aOl = com.tencent.mm.plugin.shake.c.c.a.aOl();
                    v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + wzVar.mzh);
                    v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + aOl);
                    if (TextUtils.isEmpty(wzVar.mzh)) {
                        v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(aOl)) {
                        v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.p.c.us().t(262155, true);
                        ak.yW();
                        c.vf().a(t.a.noz, wzVar.mzh);
                        ak.yW();
                        c.vf().a(t.a.noA, wzVar.mzi);
                    } else if (!aOl.equals(wzVar.mzh)) {
                        v.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.p.c.us().t(262155, true);
                        ak.yW();
                        c.vf().a(t.a.noz, wzVar.mzh);
                        ak.yW();
                        c.vf().a(t.a.noA, wzVar.mzi);
                    } else if (aOl.equals(wzVar.mzh)) {
                        v.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    g.iuh.Y(11721, wzVar.eBK);
                }
            } else {
                v.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
