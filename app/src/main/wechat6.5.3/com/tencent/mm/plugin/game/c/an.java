package com.tencent.mm.plugin.game.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class an extends k implements j {
    private e cii;
    public final b fut;

    public an(String str, LinkedList<String> linkedList, n nVar, n nVar2, n nVar3, boolean z) {
        v.i("MicroMsg.NetSceneGetGameIndex_V3", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            v.i("MicroMsg.NetSceneGetGameIndex_V3", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a aVar = new a();
        aVar.czn = new ab();
        aVar.czo = new ac();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex_v3";
        aVar.czm = 1297;
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        ab abVar = (ab) this.fut.czk.czs;
        abVar.glC = str;
        abVar.glQ = linkedList;
        String bV = e.bV(aa.getContext());
        if (be.kS(bV)) {
            bV = be.buo();
        }
        if (!be.kS(h.bfd)) {
            bV = h.bfd;
        }
        abVar.cHl = bV;
        if (nVar == null) {
            if (nVar2 != null) {
                nVar = nVar2;
            } else if (nVar3 != null) {
                nVar = nVar3;
            } else {
                nVar = null;
            }
        }
        abVar.glR = new com.tencent.mm.plugin.game.d.k();
        if (nVar != null) {
            abVar.glR.gli = nVar.gin.gja;
            abVar.glR.glj = nVar.field_appId;
            abVar.glR.gkx = nVar.giU;
            if (nVar.field_msgType == 100) {
                abVar.glR.gll = nVar.giT;
            } else {
                abVar.glR.gll = nVar.field_msgType;
            }
        }
        if (nVar2 != null) {
            com.tencent.mm.plugin.game.d.k kVar = abVar.glR;
            kVar.glk |= 1;
        }
        if (nVar3 != null) {
            kVar = abVar.glR;
            kVar.glk |= 2;
        }
        abVar.glS = au.asc().arA();
        abVar.glT = z;
        v.i("MicroMsg.NetSceneGetGameIndex_V3", "Country Code: %s", new Object[]{bV});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.fut, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetGameIndex_V3", "errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1297;
    }
}
