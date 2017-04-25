package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.LinkedList;

public final class p extends k implements j {
    private final b cif;
    private e cii;
    public LinkedList<CardInfo> eDu = new LinkedList();

    public p(LinkedList<jd> linkedList, axv com_tencent_mm_protocal_c_axv) {
        a aVar = new a();
        aVar.czn = new ez();
        aVar.czo = new fa();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.czm = 699;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ez ezVar = (ez) this.cif.czk.czs;
        ezVar.cqE = linkedList;
        ezVar.lZP = com_tencent_mm_protocal_c_axv;
    }

    public final int getType() {
        return 699;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fa) this.cif.czl.czs).eDn;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.cii.a(4, -1, null, this);
                return;
            }
            Collection qm = d.qm(obj);
            if (qm != null) {
                com.tencent.mm.plugin.card.b.j.acG();
                this.eDu.addAll(qm);
            }
            this.cii.a(0, 0, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }
}
