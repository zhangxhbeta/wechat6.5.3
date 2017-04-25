package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class m extends k implements j {
    private final b cif;
    private e cii;

    public m(String str, String str2) {
        a aVar = new a();
        att com_tencent_mm_protocal_c_att = new att();
        com_tencent_mm_protocal_c_att.moN = str;
        com_tencent_mm_protocal_c_att.mxl = str2;
        aVar.czn = com_tencent_mm_protocal_c_att;
        aVar.czo = new atu();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.czm = 993;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 993;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
