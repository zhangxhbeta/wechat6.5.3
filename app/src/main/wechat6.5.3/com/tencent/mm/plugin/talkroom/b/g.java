package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azj;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.azl;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private final b cif;
    private e cii;

    public g(LinkedList<azj> linkedList, int i) {
        a aVar = new a();
        aVar.czn = new azk();
        aVar.czo = new azl();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.czm = 373;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        azk com_tencent_mm_protocal_c_azk = (azk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_azk.mWi = linkedList.size();
        com_tencent_mm_protocal_c_azk.mWj = linkedList;
        com_tencent_mm_protocal_c_azk.maG = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 373;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
