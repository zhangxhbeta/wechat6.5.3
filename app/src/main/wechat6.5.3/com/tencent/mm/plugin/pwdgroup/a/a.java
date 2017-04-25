package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private b cif;
    private e cii;
    public int hXJ;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new pr();
        aVar.czo = new ps();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        aVar.czm = 653;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        pr prVar = (pr) this.cif.czk.czs;
        this.hXJ = i;
        prVar.lZm = i;
        prVar.mrz = str;
        prVar.mpB = str2;
        prVar.mjM = f2;
        prVar.mjN = f;
        prVar.mrA = i2;
        if (!be.kS(str3)) {
            prVar.mrB = str3;
        }
        if (!be.kS(str4)) {
            prVar.mrC = str4;
        }
        prVar.mrD = i3;
        v.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[]{Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3)});
        n.a(2007, f2, f, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.hXJ == 0) {
            ps aHa = aHa();
            if (aHa != null) {
                LinkedList linkedList = aHa.mbB;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        pt ptVar = (pt) linkedList.get(i4);
                        h hVar = new h();
                        if (be.kS(ptVar.gln)) {
                            hVar.username = ptVar.mrE;
                        } else {
                            hVar.username = ptVar.gln;
                        }
                        v.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[]{ptVar.gln, ptVar.mqa});
                        hVar.cyC = ptVar.mqa;
                        hVar.aP(true);
                        arrayList.add(hVar);
                    }
                    com.tencent.mm.u.n.Bo().z(arrayList);
                    v.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 653;
    }

    public final ps aHa() {
        return (ps) this.cif.czl.czs;
    }
}
