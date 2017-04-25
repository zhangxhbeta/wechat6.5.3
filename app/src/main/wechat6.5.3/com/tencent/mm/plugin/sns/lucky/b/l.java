package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.d.a;

public final class l implements b {
    public final void a(a aVar) {
        v.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.kZ(67);
        if (aVar == null || aVar.czu == null) {
            v.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        m mVar = new m();
        String a = m.a(aVar.czu.mbW);
        mVar.ak(a, true);
        v.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + mVar.eid.toString());
        ak.yW();
        c.vf().a(t.a.nsd, a);
        ak.yW();
        c.vf().iB(true);
    }
}
