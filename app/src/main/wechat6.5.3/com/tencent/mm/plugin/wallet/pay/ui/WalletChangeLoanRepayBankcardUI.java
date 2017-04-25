package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletChangeLoanRepayBankcardUI kII;

            {
                this.kII = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kII.setResult(-1, null);
                return true;
            }
        });
    }

    protected final f beW() {
        this.kFq = k.bgb().kQN;
        beV();
        return new f(this, this.kFq, this.kIy, this.ith);
    }

    protected final void sj(int i) {
        int size = this.kFq != null ? this.kFq.size() : 0;
        if (this.kFq != null && i < size) {
            Bankcard bankcard = (Bankcard) this.kFq.get(i);
            this.kFr = bankcard;
            this.kIz.kTm = bankcard.field_bindSerial;
            this.kIx.setEnabled(true);
            this.kIz.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("bindSerial", bankcard.field_bindSerial);
            intent.putExtra("ret", 0);
            setResult(-1, intent);
        } else if (size == i) {
            Intent intent2 = new Intent();
            intent2.putExtra("ret", -1003);
            setResult(-1, intent2);
        }
        finish();
    }

    protected final int NO() {
        return 1;
    }
}
