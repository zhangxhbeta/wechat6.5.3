package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class b extends k implements j {
    public String biS;
    private Runnable cZn;
    public final com.tencent.mm.v.b cif;
    private e cii;
    public int errCode;
    public int errType;
    public String gRI = "";
    public String gTq;

    public b(String str) {
        a aVar = new a();
        aVar.czn = new aet();
        aVar.czo = new aeu();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.czm = 490;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((aet) this.cif.czk.czs).mEX = str;
        v.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + str);
    }

    public final int getType() {
        return 490;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aeu com_tencent_mm_protocal_c_aeu;
        this.errType = i2;
        this.errCode = i3;
        this.biS = str;
        if (((com.tencent.mm.v.b) pVar).czl.czs != null) {
            com_tencent_mm_protocal_c_aeu = (aeu) ((com.tencent.mm.v.b) pVar).czl.czs;
        } else {
            com_tencent_mm_protocal_c_aeu = null;
        }
        v.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if ((i3 == 0 || i3 >= 1000) && com_tencent_mm_protocal_c_aeu != null) {
            this.gRI = com_tencent_mm_protocal_c_aeu.mrc;
            v.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[]{this.gRI});
        }
        if (com_tencent_mm_protocal_c_aeu != null) {
            this.gTq = com_tencent_mm_protocal_c_aeu.mjZ;
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
        if (this.cZn != null) {
            this.cZn.run();
        }
    }
}
