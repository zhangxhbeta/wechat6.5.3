package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends k implements j {
    private final b cif;
    private e cii;
    private int eDr = 0;

    public n(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.czn = new er();
        aVar.czo = new es();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.czm = 560;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((er) this.cif.czk.czs).mfG = linkedList;
    }

    public final int getType() {
        return 560;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((es) this.cif.czl.czs).mfH;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            v.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                v.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.eDr = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        v.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = af.aak().c(cardInfo, new String[0]);
                        v.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[]{Boolean.valueOf(z)});
                    }
                    if (!z) {
                        this.eDr++;
                    }
                }
                v.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[]{Integer.valueOf(this.eDr)});
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
