package com.tencent.mm.modelfriend;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public final class ab extends k implements j {
    private final b cif;
    private e cii = null;

    public ab(String str, List<String> list) {
        a aVar = new a();
        aVar.czn = new atb();
        aVar.czo = new atc();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.czm = 432;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        atb com_tencent_mm_protocal_c_atb = (atb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_atb.mpB = str;
        com_tencent_mm_protocal_c_atb.mGc = new LinkedList();
        com_tencent_mm_protocal_c_atb.mGb = list.size();
        for (String str2 : list) {
            if (!be.kS(str2)) {
                com_tencent_mm_protocal_c_atb.mGc.add(new arf().JF(str2));
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 432;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, str, this);
    }
}
