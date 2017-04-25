package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bag;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a extends k implements j {
    private e cii;
    private List<String> fHE;

    public a(List<String> list) {
        this.fHE = list;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.czG = i;
        if (!(i2 == 0 && i3 == 0)) {
            v.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        bo boVar = new bo();
        Collection arrayList = new ArrayList();
        if (this.fHE != null) {
            for (int i = 0; i < this.fHE.size(); i++) {
                bag com_tencent_mm_protocal_c_bag = new bag();
                com_tencent_mm_protocal_c_bag.gln = (String) this.fHE.get(i);
                arrayList.add(com_tencent_mm_protocal_c_bag);
            }
        }
        boVar.mch.addAll(arrayList);
        aVar.czn = boVar;
        aVar.czo = new bp();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.czm = 583;
        aVar.czp = 0;
        aVar.czp = 0;
        return a(eVar, aVar.Bv(), this);
    }
}
