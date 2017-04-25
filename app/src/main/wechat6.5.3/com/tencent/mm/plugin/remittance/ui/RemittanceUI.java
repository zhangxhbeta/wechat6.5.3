package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.remittance.c.d;
import com.tencent.mm.plugin.wallet_core.b.p;
import com.tencent.mm.plugin.wallet_core.b.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;

public class RemittanceUI extends RemittanceBaseUI {
    public final void aKh() {
        if (k.xT()) {
            v.e("MicroMsg.RemittanceUI", "it is payu account , do not doQueryTransfer");
        } else {
            p(new p(this.isa));
        }
        if (aKq()) {
            ak.yW();
            this.isl = (String) c.vf().get(a.ntZ, "");
            ak.yW();
            this.ism = (String) c.vf().get(a.nud, "");
            ak.yW();
            this.isn = ((Integer) c.vf().get(a.nue, Integer.valueOf(0))).intValue();
            if (be.kS(this.isl) || be.kS(this.ism)) {
                q.a(true, null);
            } else {
                q.a(false, null);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void yG(String str) {
        if (this.irY != null) {
            this.irY.i(3, new Object[]{Integer.valueOf(this.isa), Double.valueOf(this.irZ)});
        }
        com.tencent.mm.wallet_core.b.k dVar = new d(this.irZ, "1", this.bZy, this.isa, this.cVh, str, this.isb);
        dVar.mProcessName = "RemittanceProcess";
        j(dVar);
    }

    public final void aKk() {
        s.makeText(this.nDR.nEl, 2131234479, 0).show();
    }

    public final void aKn() {
        final qk qkVar = new qk();
        qkVar.brG.brI = "7";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ RemittanceUI itl;

            public final void run() {
                if (be.kS(qkVar.brH.brJ)) {
                    v.i("MicroMsg.RemittanceUI", "no bulletin data");
                } else {
                    e.a((TextView) this.itl.findViewById(2131756367), qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }
}
