package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b cif;
    private e cii;
    public int gFG;
    public long gFH;
    private final String gVK;
    private int hGO = 0;
    public int kkU;
    public int kkV;
    public LinkedList<azh> kkX;
    public LinkedList<azi> klq;

    public a(String str, int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        this.hGO = i;
        aVar.czn = new op();
        aVar.czo = new oq();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.czm = 332;
        aVar.czp = 147;
        aVar.czq = 1000000147;
        this.cif = aVar.Bv();
        ((op) this.cif.czk.czs).mqR = str;
        ((op) this.cif.czk.czs).maG = i;
        this.gVK = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.hGO)});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 332;
    }

    public final String bas() {
        return this.gVK;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            oq oqVar = (oq) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[]{oqVar.toString()});
            this.gFG = oqVar.mqS;
            this.gFH = oqVar.mqT;
            this.kkU = oqVar.mqU;
            this.kkV = oqVar.mqW;
            this.klq = aa(oqVar.mbB);
            this.kkX = ab(oqVar.meE);
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

    private static LinkedList<azh> ab(LinkedList<azh> linkedList) {
        LinkedList<azh> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((azh) it.next());
        }
        return linkedList2;
    }

    public final int bat() {
        return this.hGO;
    }
}
