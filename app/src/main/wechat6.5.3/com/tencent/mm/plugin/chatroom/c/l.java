package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class l extends k implements j {
    private b cif;
    private e cii;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.czn = new aqz();
        aVar.czo = new ara();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        aVar.czm = 700;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        aqz com_tencent_mm_protocal_c_aqz = (aqz) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aqz.mQm = str;
        com_tencent_mm_protocal_c_aqz.mQn = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 700;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.cii.a(i2, i3, str, this);
    }
}
