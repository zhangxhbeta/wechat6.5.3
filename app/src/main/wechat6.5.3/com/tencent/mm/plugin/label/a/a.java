package com.tencent.mm.plugin.label.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private final b cif;
    private e cii;
    private LinkedList<afp> gPR = new LinkedList();

    public a(String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bd();
        aVar.czo = new be();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.czm = 635;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        if (!com.tencent.mm.sdk.platformtools.be.kS(str)) {
            afp com_tencent_mm_protocal_c_afp = new afp();
            com_tencent_mm_protocal_c_afp.mFr = str;
            this.gPR.add(com_tencent_mm_protocal_c_afp);
        }
    }

    public a(List<String> list) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bd();
        aVar.czo = new be();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.czm = 635;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                afp com_tencent_mm_protocal_c_afp = new afp();
                com_tencent_mm_protocal_c_afp.mFr = (String) list.get(i);
                this.gPR.add(com_tencent_mm_protocal_c_afp);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.cii = eVar2;
        bd bdVar = (bd) this.cif.czk.czs;
        if (this.gPR == null || this.gPR.size() <= 0) {
            v.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            eVar2.a(3, -1, "[doScene]empty contact list.", this);
            return 0;
        }
        bdVar.mbG = this.gPR;
        bdVar.mbF = this.gPR.size();
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        be avL = avL();
        if (avL != null) {
            LinkedList linkedList = avL.mbG;
            List arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                afp com_tencent_mm_protocal_c_afp = (afp) linkedList.get(i4);
                w wVar = new w();
                wVar.field_labelID = com_tencent_mm_protocal_c_afp.mFs;
                wVar.field_labelName = com_tencent_mm_protocal_c_afp.mFr;
                wVar.field_labelPYFull = c.lT(com_tencent_mm_protocal_c_afp.mFr);
                wVar.field_labelPYShort = c.lU(com_tencent_mm_protocal_c_afp.mFr);
                wVar.field_isTemporary = false;
                arrayList.add(wVar);
            }
            com.tencent.mm.plugin.label.e.avK().bT(arrayList);
            com.tencent.mm.plugin.label.e.avK().bU(arrayList);
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 635;
    }

    public final be avL() {
        return (be) this.cif.czl.czs;
    }
}
