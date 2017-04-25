package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.protocal.c.ber;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    public b cif;
    private e cii;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        a aVar = new a();
        aVar.czn = new beq();
        aVar.czo = new ber();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        aVar.czm = 823;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        beq com_tencent_mm_protocal_c_beq = (beq) this.cif.czk.czs;
        com_tencent_mm_protocal_c_beq.mNO = i;
        com_tencent_mm_protocal_c_beq.nau = str;
        com_tencent_mm_protocal_c_beq.mnk = i2;
        com_tencent_mm_protocal_c_beq.nav = com.tencent.mm.ba.b.aT(bArr);
        com_tencent_mm_protocal_c_beq.naw = com.tencent.mm.ba.b.aT(bArr2);
        com_tencent_mm_protocal_c_beq.mNN = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            com_tencent_mm_protocal_c_beq.nax = str2;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 823;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
