package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wallet_core.b.j;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;

@a(3)
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bLC() != null) {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletLoanCheckPwdUI kHu;

                {
                    this.kHu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.a.i(this.kHu, 0);
                    return true;
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof j) || (i == 0 && i2 == 0)) {
            return super.d(i, i2, str, kVar);
        }
        return false;
    }

    protected final int NO() {
        return 1;
    }
}
