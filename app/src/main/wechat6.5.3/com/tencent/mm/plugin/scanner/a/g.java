package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    public b cif;
    private e cii;
    private int cyu;
    private byte[] iwb;
    private int iwc = 1;
    private int iwf;
    private int offset;

    public g(byte[] bArr, int i, int i2) {
        this.iwb = bArr;
        this.iwc = 1;
        this.cyu = i;
        this.offset = 0;
        this.iwf = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new hj();
        aVar.czo = new hk();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.czm = 1062;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        hj hjVar = (hj) this.cif.czk.czs;
        hjVar.mid = ((int) be.Ni()) & Integer.MAX_VALUE;
        hjVar.mie = new are().ba(this.iwb);
        hjVar.mif = this.cyu;
        hjVar.mfb = this.offset;
        if (this.offset + this.iwb.length < this.cyu) {
            hjVar.mfh = 0;
        } else {
            hjVar.mfh = 1;
        }
        hjVar.mig = this.iwc;
        hjVar.mih = this.iwf;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        hj hjVar = (hj) ((b) pVar).czk.czs;
        if (hjVar.mid > 0 && hjVar.mig >= 0 && hjVar.mie != null && hjVar.mie.mQu > 0 && hjVar.mif > 0 && hjVar.mfb >= 0 && hjVar.mfb + hjVar.mie.mQu <= hjVar.mif) {
            return k.b.czU;
        }
        v.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[]{Integer.valueOf(hjVar.mig), Integer.valueOf(hjVar.mif), Integer.valueOf(hjVar.mfb)});
        if (hjVar.mie != null) {
            v.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[]{Integer.valueOf(hjVar.mie.mQu)});
        }
        return k.b.czV;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1062;
    }
}
