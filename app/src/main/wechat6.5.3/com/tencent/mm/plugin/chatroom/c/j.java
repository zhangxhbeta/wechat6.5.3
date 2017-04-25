package com.tencent.mm.plugin.chatroom.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class j extends k implements com.tencent.mm.network.j {
    private final b cif;
    private e cii = null;

    public final int getType() {
        return 339;
    }

    public j(String str) {
        a aVar = new a();
        aVar.czn = new abn();
        aVar.czo = new abo();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.czm = 339;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((abn) this.cif.czk.czs).gom = str;
        v.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            int intValue = ((Integer) c.vf().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                ak.yW();
                c.vf().set(135176, Integer.valueOf(intValue - 1));
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }
}
