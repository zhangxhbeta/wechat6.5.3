package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class f extends k implements j {
    public int aYV;
    public int aYW;
    private b cif;
    private e cii;

    public f(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new hh();
        aVar.czo = new hi();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.czm = 1061;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        hh hhVar = (hh) this.cif.czk.czs;
        hhVar.efm = i;
        hhVar.mic = str;
        hhVar.maG = 1;
        this.aYV = i2;
        this.aYW = i3;
        v.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        hh hhVar = (hh) ((b) pVar).czk.czs;
        if (hhVar.efm >= 0 && hhVar.mic != null && hhVar.mic.length() > 0) {
            return k.b.czU;
        }
        v.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + hhVar.efm + ", Barcode = %s" + hhVar.mic);
        return k.b.czV;
    }

    public final hi aKS() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (hi) this.cif.czl.czs;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1061;
    }
}
