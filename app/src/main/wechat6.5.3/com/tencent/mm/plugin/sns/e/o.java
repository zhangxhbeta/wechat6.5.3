package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.awc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.List;
import java.util.Vector;

public final class o extends k implements j {
    public static List<Long> jjT = new Vector();
    public b cif;
    public e cii;
    private long jdG;

    public static boolean cH(long j) {
        if (jjT.contains(Long.valueOf(j))) {
            return false;
        }
        jjT.add(Long.valueOf(j));
        return true;
    }

    private static boolean cI(long j) {
        jjT.remove(Long.valueOf(j));
        return true;
    }

    public o(long j) {
        this.jdG = j;
        a aVar = new a();
        aVar.czn = new awb();
        aVar.czo = new awc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        aVar.czm = 210;
        aVar.czp = 101;
        aVar.czq = 1000000101;
        this.cif = aVar.Bv();
        ((awb) this.cif.czk.czs).mjq = j;
        v.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId " + j);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 210;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            awa com_tencent_mm_protocal_c_awa = ((awc) this.cif.czl.czs).mTB;
            if (com_tencent_mm_protocal_c_awa != null) {
                v.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + m.b(com_tencent_mm_protocal_c_awa.mTg));
            }
            ah.d(com_tencent_mm_protocal_c_awa);
            this.cii.a(i2, i3, str, this);
            cI(this.jdG);
            return;
        }
        this.cii.a(i2, i3, str, this);
        cI(this.jdG);
    }
}
