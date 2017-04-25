package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.protocal.c.afz;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class f extends k implements j {
    final b cif;
    private e cii;

    public f(String str) {
        a aVar = new a();
        aVar.czn = new afz();
        aVar.czo = new aga();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.czm = 377;
        aVar.czp = 184;
        aVar.czq = 1000000184;
        this.cif = aVar.Bv();
        ((afz) this.cif.czk.czs).cTd = str;
        v.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aga com_tencent_mm_protocal_c_aga = (aga) this.cif.czl.czs;
        if (i2 != 0) {
            this.cii.a(i2, i3, str, this);
            return;
        }
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aga.mbB.size(); i4++) {
            h hVar = new h();
            hVar.username = ((afy) com_tencent_mm_protocal_c_aga.mbB.get(i4)).gln;
            hVar.cyD = ((afy) com_tencent_mm_protocal_c_aga.mbB.get(i4)).mlY;
            hVar.cyC = ((afy) com_tencent_mm_protocal_c_aga.mbB.get(i4)).mlZ;
            hVar.aP(true);
            arrayList.add(hVar);
        }
        n.Bo().z(arrayList);
        this.cii.a(i2, i3, str, this);
    }
}
