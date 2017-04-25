package com.tencent.mm.ag;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c extends k implements j {
    private final b cQA;
    private e cii;

    public c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.czn = new adm();
        aVar.czo = new adn();
        aVar.uri = "/cgi-bin/micromsg-bin/invitelinkedinfriend";
        this.cQA = aVar.Bv();
        adm com_tencent_mm_protocal_c_adm = (adm) this.cQA.czk.czs;
        com_tencent_mm_protocal_c_adm.mEm = str;
        com_tencent_mm_protocal_c_adm.mEo = str2;
        com_tencent_mm_protocal_c_adm.mEn = str3;
    }

    public final int getType() {
        return 677;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cQA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneInviteLinkedInFriend", "[oneliang][NetSceneInviteLinkedInFriend]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            v.d("MicroMsg.NetSceneInviteLinkedInFriend", "[oneliang][NetSceneInviteLinkedInFriend]:net end ok");
        }
        this.cii.a(i2, i3, str, this);
    }

    protected final int ul() {
        return 10;
    }

    protected final int a(p pVar) {
        return b.czU;
    }
}
