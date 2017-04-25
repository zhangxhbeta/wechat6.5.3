package com.tencent.mm.plugin.label.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    private final b cif;
    private e cii;

    public c() {
        a aVar = new a();
        aVar.czn = new vc();
        aVar.czo = new vd();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        aVar.czm = 639;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        int i4 = 0;
        v.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(209408, Long.valueOf(System.currentTimeMillis()));
            vd vdVar = (vd) this.cif.czl.czs;
            if (!(vdVar == null || vdVar.mbG == null)) {
                LinkedList linkedList = vdVar.mbG;
                List arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    afp com_tencent_mm_protocal_c_afp = (afp) linkedList.get(i4);
                    w wVar = new w();
                    wVar.field_labelID = com_tencent_mm_protocal_c_afp.mFs;
                    wVar.field_labelName = com_tencent_mm_protocal_c_afp.mFr;
                    wVar.field_labelPYFull = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_afp.mFr);
                    wVar.field_labelPYShort = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_afp.mFr);
                    arrayList.add(wVar);
                    i4++;
                }
                com.tencent.mm.plugin.label.e.avK().bU(arrayList);
                com.tencent.mm.plugin.label.e.avK().bV(com.tencent.mm.plugin.label.e.avK().bW(arrayList));
            }
        } else {
            v.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
