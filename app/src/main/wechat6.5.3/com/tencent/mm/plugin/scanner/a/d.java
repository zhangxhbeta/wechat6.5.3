package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d extends k implements j {
    private String aZD;
    public b cif;
    private e cii;
    private String iwa;
    private int scene;

    public d(String str, int i, String str2) {
        this.aZD = str;
        this.scene = i;
        this.iwa = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new hf();
        aVar.czo = new hg();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.czm = 1063;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        hf hfVar = (hf) this.cif.czk.czs;
        hfVar.mdM = this.aZD;
        hfVar.maG = this.scene;
        hfVar.mhX = this.iwa;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        hf hfVar = (hf) ((b) pVar).czk.czs;
        if (hfVar.maG >= 0 && hfVar.mdM != null && hfVar.mdM.length() > 0) {
            return k.b.czU;
        }
        v.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(hfVar.maG)});
        return k.b.czV;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1063;
    }
}
