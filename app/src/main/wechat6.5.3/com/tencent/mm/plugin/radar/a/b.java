package com.tencent.mm.plugin.radar.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class b extends k implements j {
    int bdf;
    private float bhs;
    private float biH;
    private int biI;
    private int biJ;
    private String biK;
    private String biL;
    com.tencent.mm.v.b cif;
    private e cii;

    public b(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (i == 0) {
            v.e("MicroMsg.NetSceneRadarSearch", "opcode is wrong!");
            return;
        }
        this.bdf = i;
        this.biL = str2;
        this.biJ = i3;
        this.bhs = f;
        this.biH = f2;
        this.biK = str;
        this.biI = i2;
    }

    public b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneRadarSearch", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (this.bdf == 1 && i2 == 0) {
            List arrayList = new ArrayList();
            apc com_tencent_mm_protocal_c_apc = (apc) this.cif.czl.czs;
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_apc.mbB.size(); i4++) {
                apa com_tencent_mm_protocal_c_apa = (apa) com_tencent_mm_protocal_c_apc.mbB.get(i4);
                h hVar = new h();
                if (com_tencent_mm_protocal_c_apa.gln != null) {
                    hVar.username = com_tencent_mm_protocal_c_apa.gln;
                } else {
                    hVar.username = com_tencent_mm_protocal_c_apa.mrE;
                }
                hVar.cyC = ((apa) com_tencent_mm_protocal_c_apc.mbB.get(i4)).mqa;
                hVar.aP(true);
                arrayList.add(hVar);
            }
            n.Bo().z(arrayList);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 425;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        a aVar = new a();
        aVar.czn = new apb();
        aVar.czo = new apc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmradarsearch";
        aVar.czm = 425;
        aVar.czp = 209;
        aVar.czq = 1000000209;
        this.cif = aVar.Bv();
        apb com_tencent_mm_protocal_c_apb = (apb) this.cif.czk.czs;
        com_tencent_mm_protocal_c_apb.lZm = this.bdf;
        com_tencent_mm_protocal_c_apb.mrC = this.biL;
        com_tencent_mm_protocal_c_apb.mrD = this.biJ;
        com_tencent_mm_protocal_c_apb.mjN = this.bhs;
        com_tencent_mm_protocal_c_apb.mjM = this.biH;
        com_tencent_mm_protocal_c_apb.mrB = this.biK;
        com_tencent_mm_protocal_c_apb.mrA = this.biI;
        return a(eVar, this.cif, this);
    }

    public final int aIE() {
        return ((apc) this.cif.czl.czs).eOX;
    }
}
