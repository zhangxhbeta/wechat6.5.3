package com.tencent.mm.plugin.backup.movemodel;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class m extends k implements j {
    public p cAt = new a();
    private e cii;

    public static class a extends i {
        private final com.tencent.mm.protocal.k.a els = new com.tencent.mm.protocal.k.a();
        private final b elt = new b();

        protected final c zd() {
            return this.els;
        }

        public final d ze() {
            return this.elt;
        }

        public final int getType() {
            return 1000;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bakchatcreateqrcodeoffline";
        }

        public final int Bu() {
            return 1;
        }
    }

    public m(LinkedList<li> linkedList, String str) {
        com.tencent.mm.protocal.k.a aVar = (com.tencent.mm.protocal.k.a) this.cAt.Bx();
        aVar.lWK = com.tencent.mm.plugin.backup.g.b.UV();
        aVar.lWJ.meD = linkedList.size();
        aVar.lWJ.meE = linkedList;
        aVar.lWJ.meF = com.tencent.mm.compatible.d.p.getDeviceID(aa.getContext());
        aVar.lWJ.meG = com.tencent.mm.model.k.xF();
        aVar.lWJ.maG = 2;
        aVar.lWJ.eeK = 0;
        aVar.lWJ.meH = str;
        aVar.lWJ.meI = com.tencent.mm.plugin.backup.g.b.UW();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBakChatCreateQRCodeOffline", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (q.dqL) {
            g.Vz();
            this.cii.a(0, 0, SQLiteDatabase.KeyEmpty, this);
        } else if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.NetSceneBakChatCreateQRCodeOffline", "onGYNetEnd QRCodeUrl:%s", ((b) pVar.ze()).lWL.meK);
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1000;
    }
}
