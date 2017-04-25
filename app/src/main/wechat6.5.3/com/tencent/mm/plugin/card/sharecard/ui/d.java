package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public final class d implements a {
    private c eFY;

    public final /* synthetic */ b iQ(int i) {
        return this.eFY != null ? (ShareCardInfo) this.eFY.getItem(i) : null;
    }

    public d(c cVar) {
        this.eFY = cVar;
    }

    public final void onCreate() {
        if (this.eFY != null) {
            af.aak().c(this.eFY);
        }
    }

    public final void onDestroy() {
        if (this.eFY != null) {
            af.aak().d(this.eFY);
            c cVar = this.eFY;
            cVar.eFW.release();
            cVar.eFW = null;
            cVar.avc();
            int i = (int) (cVar.endTime - cVar.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(25);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g gVar = g.iuh;
            g.d(arrayList, true);
            this.eFY = null;
        }
    }

    public final void zk() {
        if (this.eFY != null) {
            this.eFY.a(null, null);
        }
    }
}
