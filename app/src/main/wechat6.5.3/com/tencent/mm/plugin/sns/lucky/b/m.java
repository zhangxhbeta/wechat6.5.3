package com.tencent.mm.plugin.sns.lucky.b;

import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.util.Map;

public final class m {
    private static m jes = null;
    private static String jet = "";
    StringBuffer eid = new StringBuffer();
    public int level = 0;

    public final void ak(String str, boolean z) {
        this.eid = new StringBuffer();
        Map q = bf.q(str, "sysmsg");
        this.level = 0;
        if (q == null) {
            v.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[]{str});
            if (z) {
                b.kZ(68);
                return;
            }
            return;
        }
        this.level = be.KL((String) q.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
        v.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[]{Integer.valueOf(this.level)});
        if (!z) {
            return;
        }
        if (this.level == 0) {
            b.kZ(69);
        } else if (this.level == 1) {
            b.kZ(70);
        } else if (this.level == 2) {
            b.kZ(71);
        } else if (this.level == 3) {
            b.kZ(72);
        } else if (this.level == 4) {
            b.kZ(73);
        }
    }

    public static m aRg() {
        if (!ak.uz()) {
            return new m();
        }
        ak.yW();
        String str = (String) c.vf().get(a.nsd, "");
        String m = g.m(str.getBytes());
        if (jes == null || !m.equals(jet)) {
            v.i("MicroMsg.NewYearSnsAmountLevel", "create NewYearSnsAmountLevel");
            m mVar = new m();
            jes = mVar;
            mVar.ak(str, false);
            jet = m;
        }
        return jes;
    }
}
