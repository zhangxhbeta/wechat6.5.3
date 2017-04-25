package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ajx;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class o extends k implements j {
    public final b cif;
    private e cii;

    public o(int i) {
        a aVar = new a();
        aVar.czn = new ajw();
        aVar.czo = new ajx();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.czm = 135;
        aVar.czp = 23;
        aVar.czq = 1000000023;
        this.cif = aVar.Bv();
        ((ajw) this.cif.czk.czs).mEk = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 135;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ajx com_tencent_mm_protocal_c_ajx = (ajx) this.cif.czl.czs;
        v.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + com_tencent_mm_protocal_c_ajx.mzB.size() + " group:" + com_tencent_mm_protocal_c_ajx.mcs.size());
        Set hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_ajx.mKA; i4++) {
            if (!hashSet.contains(((aka) com_tencent_mm_protocal_c_ajx.mzB.get(i4)).gln)) {
                linkedList.add(com_tencent_mm_protocal_c_ajx.mzB.get(i4));
                hashSet.add(((aka) com_tencent_mm_protocal_c_ajx.mzB.get(i4)).gln);
            }
        }
        com_tencent_mm_protocal_c_ajx.mzB = linkedList;
        com_tencent_mm_protocal_c_ajx.mKA = linkedList.size();
        this.cii.a(i2, i3, str, this);
    }
}
