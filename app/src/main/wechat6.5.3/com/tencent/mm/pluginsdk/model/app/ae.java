package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ae extends k implements j {
    public b cif;
    private e cii;

    public ae(int i, String str) {
        a aVar = new a();
        aVar.czn = new agv();
        aVar.czo = new agw();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        this.cif = aVar.Bv();
        agv com_tencent_mm_protocal_c_agv = (agv) this.cif.czk.czs;
        com_tencent_mm_protocal_c_agv.offset = i;
        com_tencent_mm_protocal_c_agv.aGx = 20;
        com_tencent_mm_protocal_c_agv.cUi = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1060;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        return a(eVar, this.cif, this);
    }
}
