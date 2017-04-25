package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.protocal.c.ayd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class ae extends k implements j {
    private final String bcB;
    private final b cif;
    private e cii;

    public static void z(String str, int i) {
        if (!be.kS(str)) {
            ak.yW();
            if (c.ww() == 0) {
                return;
            }
            if (!m.fn(str) || m.eH(str)) {
                ak.vy().a(new ae(str, i), 0);
            }
        }
    }

    public static void a(String str, int i, String str2, String str3) {
        if (!be.kS(str) && !m.fn(str)) {
            ak.yW();
            if (c.ww() != 0) {
                ak.vy().a(new ae(str, i, str2, str3), 0);
            }
        }
    }

    public ae(String str, int i) {
        this.bcB = str;
        a aVar = new a();
        aVar.czn = new ayc();
        aVar.czo = new ayd();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.cif = aVar.Bv();
        ayc com_tencent_mm_protocal_c_ayc = (ayc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ayc.gon = com.tencent.mm.model.k.xF();
        com_tencent_mm_protocal_c_ayc.mVA = i;
        com_tencent_mm_protocal_c_ayc.gom = str;
        com_tencent_mm_protocal_c_ayc.mcN = System.currentTimeMillis();
        v.d("MicroMsg.NetSceneStatusNotify", "toUserName = " + str);
    }

    private ae(String str, int i, String str2, String str3) {
        this.bcB = str;
        a aVar = new a();
        aVar.czn = new ayc();
        aVar.czo = new ayd();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.cif = aVar.Bv();
        ayc com_tencent_mm_protocal_c_ayc = (ayc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ayc.gon = com.tencent.mm.model.k.xF();
        com_tencent_mm_protocal_c_ayc.mVA = i;
        com_tencent_mm_protocal_c_ayc.gom = str;
        com_tencent_mm_protocal_c_ayc.mcN = System.currentTimeMillis();
        com_tencent_mm_protocal_c_ayc.mVD = new ayb();
        com_tencent_mm_protocal_c_ayc.mVD.gkB = str2;
        com_tencent_mm_protocal_c_ayc.mVD.mVz = str3;
    }

    public final int getType() {
        return 251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            v.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.bcB);
        }
        this.cii.a(i2, i3, str, this);
    }
}
