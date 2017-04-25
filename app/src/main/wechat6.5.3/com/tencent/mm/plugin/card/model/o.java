package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.fb;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class o extends k implements j {
    private final b cif;
    private e cii;
    private LinkedList<ad> eDs;
    public LinkedList<ad> eDt = new LinkedList();

    public o(LinkedList<ad> linkedList) {
        this.eDs = linkedList;
        a aVar = new a();
        aVar.czn = new fb();
        aVar.czo = new fc();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.czm = 559;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((fb) this.cif.czk.czs).mfG = y(linkedList);
    }

    public final int getType() {
        return 559;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fc) this.cif.czl.czs).eDn;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.cii.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList qm = d.qm(obj);
            if (qm != null) {
                if (this.eDs != null) {
                    this.eDt.addAll(this.eDs);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ak.yW();
                long er = c.wE().er(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = qm.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    CardInfo cardInfo = (CardInfo) it.next();
                    i5++;
                    if (!com.tencent.mm.plugin.card.b.j.b(cardInfo)) {
                        i4++;
                        LinkedList linkedList = this.eDt;
                        if (cardInfo != null) {
                            ad adVar = new ad();
                            adVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(adVar);
                        }
                    }
                    i4 = i4;
                }
                ak.yW();
                c.wE().es(er);
                v.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                v.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                com.tencent.mm.plugin.card.b.j.acG();
                if (qm.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue(currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue(qm.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue(currentTimeMillis3 / qm.size());
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g gVar = g.iuh;
                    g.d(arrayList, true);
                }
            }
            this.cii.a(0, 0, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }

    private static LinkedList<String> y(LinkedList<ad> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ad adVar = (ad) it.next();
            if (adVar != null) {
                linkedList2.add(adVar.field_cardUserId);
            }
        }
        return linkedList2;
    }
}
