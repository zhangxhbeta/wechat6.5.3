package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class l extends k implements j {
    public b cif;
    protected e cii;

    public l(LinkedList<li> linkedList, String str) {
        a aVar = new a();
        aVar.czn = new du();
        aVar.czo = new dw();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        this.cif = aVar.Bv();
        du duVar = (du) this.cif.czk.czs;
        duVar.meD = linkedList.size();
        duVar.meE = linkedList;
        duVar.meG = com.tencent.mm.model.k.xF();
        duVar.meF = p.getDeviceID(aa.getContext());
        duVar.meH = str;
        duVar.eeK = 0;
        duVar.maG = 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBakChatCreateQRCode", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (q.dqL) {
            g.Vz();
            this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
        } else if (i2 == 0 && i3 == 0) {
            dw dwVar = (dw) this.cif.czl.czs;
            v.i("MicroMsg.NetSceneBakChatCreateQRCode", "onGYNetEnd QRCodeUrl:%s", dwVar.meK);
            com.tencent.mm.plugin.backup.g.b.oW(SQLiteDatabase.KeyEmpty);
            com.tencent.mm.plugin.backup.g.b.oX(dwVar.meM);
            com.tencent.mm.plugin.backup.g.b.oY(dwVar.meN);
            com.tencent.mm.plugin.backup.g.b.O(dwVar.mes.mQw.lVU);
            com.tencent.mm.plugin.backup.g.b.oV(dwVar.meI);
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 704;
    }
}
