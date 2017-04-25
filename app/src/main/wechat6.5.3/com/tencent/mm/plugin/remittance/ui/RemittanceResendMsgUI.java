package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.remittance.c.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.dtW.setVisibility(8);
        vB(8);
        String stringExtra = getIntent().getStringExtra("transaction_id");
        String stringExtra2 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (!be.kS(stringExtra) && !be.kS(stringExtra2)) {
            h(stringExtra, stringExtra2, intExtra2, intExtra);
        }
    }

    public void h(String str, String str2, int i, int i2) {
        g gVar = new g(str, str2, i, i2);
        gVar.mProcessName = "RemittanceProcess";
        j(gVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof g)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.base.g.bf(this, getString(2131234539));
            finish();
            return true;
        }
        com.tencent.mm.ui.base.g.bf(this, str);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
