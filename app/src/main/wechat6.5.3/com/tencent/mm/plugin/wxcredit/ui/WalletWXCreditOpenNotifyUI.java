package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904699;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        c.vf().set(196658, Boolean.valueOf(false));
        NI();
    }

    protected final void NI() {
        int i = 0;
        vD(2131236565);
        bzV();
        iS(false);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenNotifyUI lxa;

            {
                this.lxa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lxa.setResult(-1);
                this.lxa.finish();
                return true;
            }
        });
        ((TextView) findViewById(2131760042)).setText(e.l(this.uA.getDouble("key_total_amount")));
        Button button = (Button) findViewById(2131756365);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenNotifyUI lxa;

            {
                this.lxa = r1;
            }

            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("key_bankcard", this.lxa.uA.getParcelable("key_bankcard"));
                a.a(this.lxa, b.class, bundle);
            }
        });
        if (!this.uA.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
    }
}
