package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904693;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        ((TextView) findViewById(2131760042)).setText(e.l(this.uA.getDouble("key_credit_amount")));
        bzV();
        iS(false);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditChangeAmountResultUI lwt;

            {
                this.lwt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lwt.bLC().a(this.lwt.nDR.nEl, 0, this.lwt.uA);
                return true;
            }
        });
    }
}
