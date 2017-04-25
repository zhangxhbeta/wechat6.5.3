package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class c extends k implements j {
    public b cif;
    private e cii;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        a aVar = new a();
        aVar.czn = new hd();
        aVar.czo = new he();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.czm = 1068;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        hd hdVar = (hd) this.cif.czk.czs;
        hdVar.mdM = str;
        hdVar.maG = i;
        hdVar.mhX = str2;
        hdVar.mhW = linkedList;
        hdVar.mhZ = d2;
        hdVar.mhY = d;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1068;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
