package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bbm;
import com.tencent.mm.protocal.c.bbn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class o extends k implements j {
    public String biB = null;
    public int caG = 0;
    private final b cif;
    private e cii = null;
    public String eOP = null;
    public String eOY = null;
    public int eOZ = 0;

    public o(String str) {
        a aVar = new a();
        aVar.czn = new bbm();
        aVar.czo = new bbn();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.czm = 482;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.biB = str;
        ((bbm) this.cif.czk.czs).moN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bbn com_tencent_mm_protocal_c_bbn = (bbn) this.cif.czl.czs;
        v.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.eOY = com_tencent_mm_protocal_c_bbn.mJb;
        if (!be.kS(this.eOY)) {
            com.tencent.mm.storage.o LC = ak.yW().wO().LC(this.biB);
            if (LC == null) {
                LC = new com.tencent.mm.storage.o();
            }
            LC.dK(com.tencent.mm.model.k.xF(), this.eOY);
            i.a(LC);
        }
        this.eOP = com_tencent_mm_protocal_c_bbn.mxz;
        this.caG = com_tencent_mm_protocal_c_bbn.mxy;
        this.eOZ = com_tencent_mm_protocal_c_bbn.mxA;
        this.cii.a(i2, i3, str, this);
    }
}
