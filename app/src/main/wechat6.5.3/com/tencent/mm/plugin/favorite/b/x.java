package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.a.rc;
import com.tencent.mm.model.o;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class x extends k implements j {
    private final b cif;
    private e cii = null;
    public i fLI;

    public x(i iVar) {
        a aVar = new a();
        aVar.czn = new bi();
        aVar.czo = new bj();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.czm = 401;
        aVar.czp = 193;
        aVar.czq = 1000000193;
        this.cif = aVar.Bv();
        this.fLI = iVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bi biVar = (bi) this.cif.czk.czs;
        biVar.mbN = com.tencent.mm.model.j.f(this.fLI.field_xml, System.currentTimeMillis());
        biVar.efm = this.fLI.field_type;
        biVar.mbO = this.fLI.field_sourceType;
        this.fLI.field_xml = i.b(this.fLI);
        h.alu().a(this.fLI, "localId");
        biVar.mbQ = this.fLI.field_xml;
        biVar.mbP = this.fLI.field_sourceId;
        this.fLI.sN("MicroMsg.NetSceneAddFav");
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", new Object[]{this.fLI.field_sourceId, Long.valueOf(this.fLI.field_localId), Integer.valueOf(this.fLI.field_id)});
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            bj bjVar = (bj) ((b) pVar).czl.czs;
            v.i("MicroMsg.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", new Object[]{Integer.valueOf(bjVar.mbJ), Long.valueOf(this.fLI.field_localId), Integer.valueOf(this.fLI.field_itemStatus), Integer.valueOf(bjVar.mbM)});
            this.fLI.field_id = bjVar.mbJ;
            this.fLI.field_localSeq = bjVar.mbM;
            if (this.fLI.field_itemStatus == 12) {
                v.v("MicroMsg.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.fLI.field_itemStatus = 13;
            }
            if (this.fLI.field_itemStatus == 9) {
                v.v("MicroMsg.NetSceneAddFav", "onGYNetEnd item done");
                this.fLI.field_itemStatus = 10;
                h.alp().bz(this.fLI.field_localId);
                g.iuh.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(this.fLI.field_type), Integer.valueOf(0), Long.valueOf(v.k(this.fLI)), Long.valueOf(v.bG(this.fLI.field_localId))});
            }
            i bC = h.alu().bC((long) bjVar.mbJ);
            if (bC != null) {
                this.fLI.field_updateSeq = bC.field_updateSeq;
                h.alu().d(bC);
                v.i("MicroMsg.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", new Object[]{Integer.valueOf(bC.field_id)});
            }
            o.b fy = o.yx().fy(this.fLI.field_sessionId);
            if (!(be.kS(this.fLI.field_sessionId) || this.fLI.field_type != 5 || fy == null)) {
                rc rcVar = new rc();
                rcVar.bsP.bsQ = fy.getString("prePublishId", "");
                if (!(this.fLI.field_favProto == null || this.fLI.field_favProto.mtP == null)) {
                    rcVar.bsP.url = this.fLI.field_favProto.mtP.cZp;
                }
                if (!(!be.kS(rcVar.bsP.url) || this.fLI.field_favProto == null || this.fLI.field_favProto.mtc == null || this.fLI.field_favProto.mtc.mur == null)) {
                    rcVar.bsP.url = this.fLI.field_favProto.mtc.mur;
                }
                if (be.kS(rcVar.bsP.url)) {
                    rcVar.bsP.url = fy.getString("url", "");
                }
                rcVar.bsP.bsS = fy.getString("preUsername", "");
                rcVar.bsP.bsT = fy.getString("preChatName", "");
                rcVar.bsP.bsU = fy.bf("preMsgIndex");
                rcVar.bsP.bsY = fy.bf("sendAppMsgScene");
                rcVar.bsP.bsZ = fy.bf("getA8KeyScene");
                rcVar.bsP.bta = fy.getString("referUrl", null);
                rcVar.bsP.btb = fy.getString("adExtStr", null);
                rcVar.bsP.bsV = "";
                rcVar.bsP.bsW = "";
                rcVar.bsP.bsX = 0;
                rcVar.bsP.bsR = "fav_" + com.tencent.mm.model.k.xF() + "_" + this.fLI.field_id;
                com.tencent.mm.sdk.c.a.nhr.z(rcVar);
            }
            this.fLI.field_sessionId = null;
            h.alu().a(this.fLI, "localId");
            v.bI(bjVar.mbR);
        }
        if (i2 == 4 && i3 == -401) {
            v.w("MicroMsg.NetSceneAddFav", "fav fail, full size");
            if (this.fLI.alE()) {
                h.alu().r(16, this.fLI.field_localId);
            } else {
                h.alu().r(6, this.fLI.field_localId);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 401;
    }
}
