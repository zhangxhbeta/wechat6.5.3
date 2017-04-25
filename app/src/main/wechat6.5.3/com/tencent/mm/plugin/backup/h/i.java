package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class i extends k implements j {
    private final b cif;
    private e cii;

    public i(String str) {
        v.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, be.bur());
        a aVar = new a();
        aVar.czn = new va();
        aVar.czo = new vb();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        this.cif = aVar.Bv();
        ((va) this.cif.czk.czs).URL = str;
    }

    public final int getType() {
        return 595;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final vb WC() {
        return (vb) this.cif.czl.czs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (q.dqL) {
            g.Vz();
            this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
            return;
        }
        if (i2 == 0 && i3 == 0) {
            vb vbVar = (vb) this.cif.czl.czs;
            com.tencent.mm.plugin.backup.g.b.oW(vbVar.ID);
            com.tencent.mm.plugin.backup.g.b.oX(vbVar.meM);
            com.tencent.mm.plugin.backup.g.b.oY(vbVar.meN);
            com.tencent.mm.plugin.backup.g.b.O(vbVar.mes.mQw.lVU);
            v.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", vbVar.ID, vbVar.meM, vbVar.meN, vbVar.meF, vbVar.meG, Integer.valueOf(vbVar.maG));
            v.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", vbVar.mxJ);
            com.tencent.mm.ba.b bVar = vbVar.mes.mQw;
        }
        this.cii.a(i2, i3, str, this);
    }
}
