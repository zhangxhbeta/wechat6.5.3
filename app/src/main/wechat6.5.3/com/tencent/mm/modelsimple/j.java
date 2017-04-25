package com.tencent.mm.modelsimple;

import com.tencent.mm.a.n;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.i;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.j {
    private p cAt;
    public String cYw = SQLiteDatabase.KeyEmpty;
    private e cii;
    public byte[] content;

    public static class a extends i {
        private final com.tencent.mm.protocal.p.a cYx = new com.tencent.mm.protocal.p.a();
        private final b cYy = new b();

        protected final c zd() {
            return this.cYx;
        }

        public final d ze() {
            return this.cYy;
        }

        public final int getType() {
            return 10;
        }

        public final String getUri() {
            return null;
        }
    }

    public j(List<String> list, byte[] bArr) {
        boolean z = true;
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.cAt = new a();
        com.tencent.mm.protocal.p.a aVar = (com.tencent.mm.protocal.p.a) this.cAt.Bx();
        aVar.bdn = MMGIFException.D_GIF_ERR_NOT_READABLE;
        aVar.bkU = 0;
        aVar.cZF = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.lXe = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        aVar.lXf = bArr;
        v.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111" + " seq=" + currentTimeMillis);
        v.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + n.c(bArr, 0));
    }

    public j(d dVar) {
        b bVar = (b) dVar;
        this.cYw = bVar.cYw;
        this.content = bVar.content;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 10;
    }

    public final boolean Bz() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
