package com.tencent.mm.modelsearch;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class s extends k implements j {
    public int bkE;
    private b cQA;
    public ahm cWR;
    public int cWS;
    private int cWh;
    private e cii;
    public int scene;

    public s(int i, int i2, int i3, int i4) {
        this.scene = i;
        this.cWh = i3;
        this.bkE = i4;
        this.cWS = i2;
        v.i("MicroMsg.FTS.NetSceneBizSearchGuide", "scene %d, h5Version=%d type=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.czm = 1048;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.czn = new ahl();
        aVar.czo = new ahm();
        this.cQA = aVar.Bv();
        ahl com_tencent_mm_protocal_c_ahl = (ahl) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_ahl.maG = i;
        com_tencent_mm_protocal_c_ahl.mGY = i3;
        com_tencent_mm_protocal_c_ahl.mGZ = h.Ig();
        com_tencent_mm_protocal_c_ahl.mHa = i2;
    }

    public final int getType() {
        return 1048;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.FTS.NetSceneBizSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.cWR = (ahm) this.cQA.czl.czs;
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
