package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.protocal.c.ki;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class z extends k implements j {
    private b cif;
    private e cii;
    private a lAI;

    public interface a {
        void D(String str, int i, int i2);
    }

    public z(String str, String str2, String str3, int i, a aVar) {
        com.tencent.mm.v.b.a aVar2 = new com.tencent.mm.v.b.a();
        aVar2.czn = new kh();
        aVar2.czo = new ki();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        aVar2.czm = 939;
        aVar2.czp = 0;
        aVar2.czq = 0;
        this.cif = aVar2.Bv();
        kh khVar = (kh) this.cif.czk.czs;
        khVar.fileid = str;
        khVar.aZy = str2;
        khVar.mmR = str3;
        khVar.mmS = i;
        this.lAI = aVar;
        v.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[]{khVar.fileid, khVar.aZy, khVar.mmR, Integer.valueOf(khVar.mmS), be.bur()});
    }

    public final int getType() {
        return 939;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.cii.a(i2, i3, str, this);
        if (this.lAI != null) {
            a aVar;
            String str2;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                ki kiVar = (ki) ((b) pVar).czl.czs;
                aVar = this.lAI;
                if (kiVar != null) {
                    str2 = kiVar.aeskey;
                    aVar.D(str2, i2, i3);
                }
                aVar2 = aVar;
            } else {
                aVar2 = this.lAI;
            }
            aVar = aVar2;
            str2 = "";
            aVar.D(str2, i2, i3);
        }
    }
}
