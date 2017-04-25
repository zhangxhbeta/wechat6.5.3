package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.a.a;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b;

public class i extends a {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
        b(activity, PayURemittanceAdapterUI.class, bundle);
        return this;
    }
}
