package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;

public final class e extends k implements j {
    public b cif;
    private com.tencent.mm.v.e cii;
    private byte[] iwb;
    private int iwc = 1;
    private String iwd = "en";
    private String iwe = "zh_CN";
    private int iwf;

    public e(byte[] bArr, String str, String str2, int i) {
        this.iwb = bArr;
        this.iwc = 1;
        this.iwd = str;
        this.iwe = str2;
        this.iwf = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new akk();
        aVar.czo = new akl();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.czm = 392;
        aVar.czp = 199;
        aVar.czq = 1000000199;
        this.cif = aVar.Bv();
        akk com_tencent_mm_protocal_c_akk = (akk) this.cif.czk.czs;
        com_tencent_mm_protocal_c_akk.mid = ((int) be.Ni()) & Integer.MAX_VALUE;
        com_tencent_mm_protocal_c_akk.mie = new are().ba(this.iwb);
        com_tencent_mm_protocal_c_akk.mig = this.iwc;
        com_tencent_mm_protocal_c_akk.mLq = this.iwd;
        com_tencent_mm_protocal_c_akk.mLr = this.iwe;
        com_tencent_mm_protocal_c_akk.mih = this.iwf;
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        akk com_tencent_mm_protocal_c_akk = (akk) ((b) pVar).czk.czs;
        if (com_tencent_mm_protocal_c_akk.mid > 0 && !be.kS(com_tencent_mm_protocal_c_akk.mLr) && !be.kS(com_tencent_mm_protocal_c_akk.mLq) && com_tencent_mm_protocal_c_akk.mig >= 0 && com_tencent_mm_protocal_c_akk.mie != null && com_tencent_mm_protocal_c_akk.mie.mQu > 0) {
            return k.b.czU;
        }
        v.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
        return k.b.czV;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 392;
    }
}
