package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class h extends k implements j {
    private final b cif;
    private e cii;
    public byte[] emD;
    private final String id;

    public h(String str) {
        a aVar = new a();
        aVar.czn = new st();
        aVar.czo = new su();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        this.cif = aVar.Bv();
        st stVar = (st) this.cif.czk.czs;
        stVar.ID = str;
        stVar.mwr = ad.brI().ver;
        this.id = str;
        v.i("MicroMsg.NetSceneBakchatkey", "init id:%s, ver:0x%x", stVar.ID, Integer.valueOf(stVar.mwr));
    }

    public final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 596;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBakchatkey", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.emD = ((su) this.cif.czl.czs).mes.mQw.lVU;
            String str2 = "MicroMsg.NetSceneBakchatkey";
            String str3 = "id:%s,  key len:%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.emD == null ? 0 : this.emD.length);
            v.i(str2, str3, objArr);
            if (this.emD != null) {
                byte[] bArr2 = this.emD;
                str2 = SQLiteDatabase.KeyEmpty;
                for (byte b : bArr2) {
                    str2 = str2 + Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA) + " ";
                }
                v.i("MicroMsg.NetSceneBakchatkey", "dump bakchat: %s", str2);
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
