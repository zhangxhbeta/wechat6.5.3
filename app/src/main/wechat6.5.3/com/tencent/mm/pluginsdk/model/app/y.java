package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.js;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class y extends k implements j {
    private b cif;
    private e cii;
    private final a lAH;

    public interface a {
        void a(String str, String str2, String str3, String str4, String str5, long j);
    }

    public y(com.tencent.mm.q.a.a aVar, String str, String str2, a aVar2) {
        com.tencent.mm.v.b.a aVar3 = new com.tencent.mm.v.b.a();
        aVar3.czn = new js();
        aVar3.czo = new jt();
        aVar3.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.cif = aVar3.Bv();
        js jsVar = (js) this.cif.czk.czs;
        if (aVar != null) {
            jsVar.mjT = aVar.cop;
            jsVar.mmd = aVar.filemd5;
            jsVar.cUd = aVar.title;
            jsVar.mme = aVar.coc;
            jsVar.mmc = (long) aVar.cob;
        } else {
            g.Ea();
            jsVar.mjT = com.tencent.mm.modelcdntran.b.DU();
            g.Ea();
            jsVar.mmd = com.tencent.mm.modelcdntran.b.im(str);
            jsVar.cUd = com.tencent.mm.a.e.aT(str);
            jsVar.mme = com.tencent.mm.a.e.aS(str);
            jsVar.mmc = (long) com.tencent.mm.a.e.aQ(str);
        }
        jsVar.mdC = com.tencent.mm.modelcdntran.b.cEC;
        jsVar.gom = str2;
        jsVar.gon = com.tencent.mm.model.k.xF();
        this.lAH = aVar2;
        v.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", aVar, jsVar.mjT, jsVar.mmd, jsVar.cUd, Long.valueOf(jsVar.mmc), jsVar.mme, jsVar.gom, jsVar.gon, be.bur());
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
            js jsVar = (js) ((b) pVar).czk.czs;
            jt jtVar = (jt) ((b) pVar).czl.czs;
            v.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", jtVar.cHf, Integer.valueOf(jtVar.mmf), jtVar.mmg, jtVar.mmh);
            if (this.lAH != null) {
                this.lAH.a(jsVar.mmd, jsVar.mjT, jtVar.cHf, jtVar.mmg, jtVar.mmh, jsVar.mmc);
                return;
            }
            return;
        }
        v.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.cii.a(i2, i3, str, this);
        if (this.lAH != null) {
            this.lAH.a(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
        }
    }
}
