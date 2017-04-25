package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.remittance.c.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String bZy = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vB(8);
        this.pjH.gQ(1574);
        this.bZy = getIntent().getStringExtra("receiver_name");
        j(new h(k.xM()));
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return true;
    }

    public final void b(int i, int i2, String str, com.tencent.mm.v.k kVar, boolean z) {
        super.b(i, i2, str, kVar, z);
        if (i == 0 && i2 == 0 && (kVar instanceof h)) {
            h hVar = (h) kVar;
            v.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[]{hVar.irL});
            Intent intent = getIntent();
            if (hVar.haq == 1) {
                e.a(this, 2, this.bZy, 11, null);
            } else {
                intent.setClass(this, RemittanceOSUI.class);
                intent.putExtra("os_currency", hVar.haq);
                intent.putExtra("os_currencyuint", hVar.irL);
                intent.putExtra("os_currencywording", hVar.irM);
                intent.putExtra("os_notice", hVar.hbX);
                intent.putExtra("os_notice_url", hVar.irN);
                startActivity(intent);
            }
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.pjH.gR(1574);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
