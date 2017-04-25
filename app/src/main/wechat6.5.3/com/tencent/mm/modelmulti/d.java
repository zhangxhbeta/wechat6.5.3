package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;

public final class d extends k implements j {
    public final b cQA;
    private e cii;

    public d(List<acr> list, long j, act com_tencent_mm_protocal_c_act) {
        a aVar = new a();
        aVar.czn = new tb();
        aVar.czo = new tc();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        this.cQA = aVar.Bv();
        tb tbVar = (tb) this.cQA.czk.czs;
        tbVar.mww.addAll(list);
        tbVar.mwz = j;
        tbVar.mwy = com_tencent_mm_protocal_c_act;
        v.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(tbVar.mww.size()));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.cii.a(i2, i3, str, this);
        tb tbVar = (tb) this.cQA.czk.czs;
        acr com_tencent_mm_protocal_c_acr = (acr) tbVar.mww.get(0);
        act com_tencent_mm_protocal_c_act = tbVar.mwy;
        tc tcVar = (tc) ((b) pVar).czl.czs;
        if (i2 == 0 && i3 == 0) {
            if (tcVar.bpc != 0) {
                g.iuh.h(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_acr.gjT, Integer.valueOf(com_tencent_mm_protocal_c_acr.major), Integer.valueOf(com_tencent_mm_protocal_c_acr.minor), String.valueOf(com_tencent_mm_protocal_c_act.latitude), String.valueOf(com_tencent_mm_protocal_c_act.longitude), Integer.valueOf(2), Integer.valueOf(tcVar.bpc));
            }
            v.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            return;
        }
        g.iuh.h(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_acr.gjT, Integer.valueOf(com_tencent_mm_protocal_c_acr.major), Integer.valueOf(com_tencent_mm_protocal_c_acr.minor), String.valueOf(com_tencent_mm_protocal_c_act.latitude), String.valueOf(com_tencent_mm_protocal_c_act.longitude), Integer.valueOf(1), Integer.valueOf(tcVar.bpc));
        v.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    }

    public final int getType() {
        return 1708;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }
}
