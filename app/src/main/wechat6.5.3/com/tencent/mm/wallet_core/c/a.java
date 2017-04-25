package com.tencent.mm.wallet_core.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.e.a.d;
import com.tencent.mm.wallet_core.e.a.f;
import com.tencent.mm.wallet_core.e.a.h;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {
    private h piO;
    private int piP = 0;
    private e piQ;

    public a(e eVar) {
        this.piQ = eVar;
    }

    public final boolean a(h hVar) {
        int i = 0;
        this.piO = hVar;
        ak.vy().a(385, this);
        if (!this.piO.bLt() || this.piO.yz(this.piP)) {
            return false;
        }
        k dVar;
        v.i("MicroMsg.DelayQueryOrderHelper", "doDelayQuery,delay = " + this.piO.pja + " sec");
        this.piP++;
        Map bLs = this.piO.bLs();
        String str = (String) bLs.get("req_key");
        if (be.kS(str)) {
            v.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            dVar = new d(bLs);
        } else {
            v.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[]{str});
            c Ls = com.tencent.mm.model.c.c.Au().Ls("100162");
            if (Ls.isValid() && "1".equals(Ls.buX().get("UseNewPayCgi"))) {
                i = 1;
            }
            if (i != 0) {
                v.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
                dVar = str.startsWith("sns_aa_") ? new com.tencent.mm.wallet_core.e.a.a(bLs) : str.startsWith("sns_tf_") ? new f(bLs) : str.startsWith("sns_ff_") ? new b(bLs) : str.startsWith("ts_") ? new com.tencent.mm.wallet_core.e.a.c(bLs) : str.startsWith("sns_") ? new com.tencent.mm.wallet_core.e.a.e(bLs) : new d(bLs);
            } else {
                dVar = new d(bLs);
            }
        }
        ak.vy().a(dVar, this.piO.pja);
        return true;
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        v.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.piO != null) {
            v.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.piO.a(i2, str, jSONObject);
        }
        if (this.piQ != null) {
            v.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.piQ.a(i, i2, str, this.piO);
        }
        v.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.piO = null;
        this.piP = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            ak.vy().b(385, this);
            d dVar = (d) kVar;
            if (i == 0 && i2 == 0) {
                a(i, i2, str, dVar.bLr());
                return;
            }
            v.e("MicroMsg.DelayQueryOrderHelper", "DelayQueryOrder Error");
            if (this.piO == null) {
                v.e("MicroMsg.DelayQueryOrderHelper", "mScene = null");
            } else if (!this.piO.bLt() || this.piO.yz(this.piP)) {
                a(i, this.piO.pje, this.piO.pjf, this.piO.pjg);
            } else {
                v.d("MicroMsg.DelayQueryOrderHelper", "onSceneEnd doDelayQuery");
                a(this.piO);
            }
        }
    }
}
