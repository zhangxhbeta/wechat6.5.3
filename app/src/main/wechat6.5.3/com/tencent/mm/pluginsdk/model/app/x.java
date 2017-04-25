package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class x extends k implements j {
    private b cif;
    private e cii;
    private final b lAG;

    public x(b bVar, String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.czn = new jq();
        aVar.czo = new jr();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        this.cif = aVar.Bv();
        this.lAG = bVar;
        jq jqVar = (jq) this.cif.czk.czs;
        jqVar.mjT = str;
        jqVar.mmc = bVar.field_totalLen;
        jqVar.mmd = str2;
        jqVar.cUd = str3;
        jqVar.mme = str4;
        jqVar.gon = str5;
        ak.yW();
        jqVar.gom = (String) c.vf().get(2, SQLiteDatabase.KeyEmpty);
        jqVar.mdC = com.tencent.mm.modelcdntran.b.cEC;
        v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", be.KW(jqVar.mjT), jqVar.mmd, jqVar.cUd, jqVar.mme, Long.valueOf(jqVar.mmc), Integer.valueOf(jqVar.mdC), be.bur());
    }

    public final int getType() {
        return 728;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            jr jrVar = (jr) ((b) pVar).czl.czs;
            this.lAG.field_signature = jrVar.cHf;
            this.lAG.field_fakeAeskey = jrVar.mmg;
            this.lAG.field_fakeSignature = jrVar.mmh;
            boolean a = am.Wf().a(this.lAG, new String[0]);
            v.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", be.KW(this.lAG.field_signature), be.KW(this.lAG.field_fakeAeskey), be.KW(this.lAG.field_fakeSignature), Boolean.valueOf(a));
        }
        this.cii.a(i2, i3, str, this);
    }
}
