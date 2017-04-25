package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b cif;
    private e cii;
    private final String gVK;
    private int hGO = 0;
    public int kkU;
    public LinkedList<azi> klq;

    public c(int i, long j, String str, int i2) {
        this.hGO = i2;
        a aVar = new a();
        aVar.czn = new zo();
        aVar.czo = new zp();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.czm = 336;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        zo zoVar = (zo) this.cif.czk.czs;
        zoVar.mqS = i;
        zoVar.mqT = j;
        this.gVK = str;
        zoVar.maG = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 336;
    }

    public final String bas() {
        return this.gVK;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            zp zpVar = (zp) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[]{zpVar.toString()});
            this.kkU = zpVar.mqU;
            this.klq = aa(zpVar.mbB);
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    private static LinkedList<azi> aa(LinkedList<azi> linkedList) {
        LinkedList<azi> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            azi com_tencent_mm_protocal_c_azi = (azi) it.next();
            if (!be.kS(com_tencent_mm_protocal_c_azi.gln)) {
                linkedList2.add(com_tencent_mm_protocal_c_azi);
            }
        }
        return linkedList2;
    }

    public final int bat() {
        return this.hGO;
    }
}
