package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.b;

public class a extends b {
    public b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        b(activity, RemittanceAdapterUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void d(Activity activity, Bundle bundle) {
        super.af(activity);
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String anS() {
        return "RemittanceProcess";
    }
}
