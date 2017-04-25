package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.remittance.ui.RemittanceUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.plugin.wallet_payu.remittance.a.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;

public class PayURemittanceUI extends RemittanceUI {
    private final String laA = "ZAR";

    public final void aKi() {
        j(new g(this.bZy, this.isb));
    }

    public final void yG(String str) {
        j(new d(this.irZ, "ZAR", this.bZy, this.cVh));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof d)) {
            return true;
        }
        d dVar = (d) kVar;
        if (be.kS(dVar.ecR)) {
            s.makeText(this.nDR.nEl, 2131236586, 0).show();
            return true;
        }
        String str2 = dVar.ecR;
        String str3 = this.bZy;
        PayInfo payInfo = new PayInfo();
        payInfo.fTG = str2;
        payInfo.bkq = this.isa;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", getIntent().getStringExtra("desc"));
        bundle.putString("extinfo_key_4", getIntent().getStringExtra("scan_remittance_id"));
        bundle.putString("fee_type", "ZAR");
        bundle.putDouble("total_fee", this.irZ);
        payInfo.lVD = bundle;
        e.a(this, payInfo, 1);
        return true;
    }
}
