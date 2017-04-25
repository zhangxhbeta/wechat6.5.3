package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class ad extends k implements j {
    private final b cif;
    private e cii;
    public int fMa;
    public f fMb;
    private LinkedList<aja> fMc;
    private LinkedList<aix> fMd;
    public String fMe;
    public int type;

    private ad(int i, LinkedList<aix> linkedList, LinkedList<aja> linkedList2, int i2) {
        this.cii = null;
        a aVar = new a();
        aVar.czn = new aiy();
        aVar.czo = new aiz();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.czm = 426;
        aVar.czp = 216;
        aVar.czq = 1000000216;
        this.cif = aVar.Bv();
        this.fMc = linkedList2;
        this.fMd = linkedList;
        this.fMa = i;
        this.type = i2;
    }

    public ad(int i, LinkedList<aix> linkedList, LinkedList<aja> linkedList2) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
    }

    public ad(int i, f fVar) {
        this(i, fVar.field_modItem.fMd, fVar.field_modItem.mtE, 1);
        this.fMb = fVar;
    }

    public ad(int i, LinkedList<aix> linkedList, LinkedList<aja> linkedList2, String str) {
        this(i, (LinkedList) linkedList, (LinkedList) linkedList2, 0);
        this.fMe = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.fMd == null || this.fMd.size() == 0) {
            return -1;
        }
        aiy com_tencent_mm_protocal_c_aiy = (aiy) this.cif.czk.czs;
        com_tencent_mm_protocal_c_aiy.mJu = this.fMd.size();
        if (this.fMc != null) {
            com_tencent_mm_protocal_c_aiy.mJw = this.fMc.size();
            com_tencent_mm_protocal_c_aiy.mfQ = this.fMc;
        } else {
            com_tencent_mm_protocal_c_aiy.mJw = 0;
            com_tencent_mm_protocal_c_aiy.mfQ = new LinkedList();
        }
        if (!be.kS(this.fMe)) {
            com_tencent_mm_protocal_c_aiy.mJx = this.fMe;
        }
        com_tencent_mm_protocal_c_aiy.mJu = this.fMd.size();
        com_tencent_mm_protocal_c_aiy.mJv = this.fMd;
        com_tencent_mm_protocal_c_aiy.mbJ = this.fMa;
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final long amj() {
        if (this.fMb == null) {
            return -1;
        }
        return this.fMb.field_localId;
    }

    public final int amk() {
        if (this.fMb == null) {
            return -1;
        }
        return this.fMb.field_type;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneModFavItem", "favId: " + this.fMa + ", netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 426;
    }
}
