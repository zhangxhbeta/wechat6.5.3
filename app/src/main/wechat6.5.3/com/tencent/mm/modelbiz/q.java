package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class q extends k implements j {
    public String cDf;
    public b cif;
    private e cii;

    public q(String str, String str2) {
        a aVar = new a();
        aVar.czn = new aez();
        aVar.czo = new afa();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.cif = aVar.Bv();
        aez com_tencent_mm_protocal_c_aez = (aez) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aez.mEZ = str;
        com_tencent_mm_protocal_c_aez.mFa = str2;
        this.cDf = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 674;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        return a(eVar, this.cif, this);
    }

    public final afa Dt() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (afa) this.cif.czl.czs;
    }
}
