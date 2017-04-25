package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements j {
    private final b cif;
    private com.tencent.mm.v.e cii;
    public LinkedList<String> eDs;
    public LinkedList<String> eDt = new LinkedList();

    public e(LinkedList<String> linkedList) {
        this.eDs = linkedList;
        a aVar = new a();
        aVar.czn = new yy();
        aVar.czo = new yz();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.czm = 903;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        ((yy) this.cif.czk.czs).mfG = linkedList;
        v.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(903), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            yz yzVar = (yz) this.cif.czl.czs;
            v.v("MicroMsg.NetSceneGetShareCardList", "json:" + yzVar.eDn);
            Object obj = yzVar.eDn;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.cii.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList ql = d.ql(obj);
            if (ql != null) {
                if (this.eDs != null) {
                    this.eDt.addAll(this.eDs);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ak.yW();
                long er = c.wE().er(Thread.currentThread().getId());
                Iterator it = ql.iterator();
                int i4 = 0;
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (com.tencent.mm.plugin.card.b.j.a(shareCardInfo)) {
                        v.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        com.tencent.mm.plugin.card.sharecard.a.b.K(aa.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            com.tencent.mm.plugin.card.sharecard.a.b.bf(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.eDt.remove(shareCardInfo.field_card_id);
                    }
                }
                ak.yW();
                c.wE().es(er);
                v.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                v.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                com.tencent.mm.plugin.card.b.j.acI();
                if (ql.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue(currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue(ql.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue(currentTimeMillis3 / ql.size());
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g gVar = g.iuh;
                    g.d(arrayList, true);
                }
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        v.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 903;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
