package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    public EditHintPasswdView kTr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(q.eR(this));
        NI();
        c.a(this, this.uA, 5);
    }

    protected final void NI() {
        TextView textView;
        if (this.uA.getInt("key_err_code", 0) == -1002) {
            textView = (TextView) findViewById(2131760028);
            textView.setVisibility(0);
            textView.setText(k.xT() ? getString(2131236474) : getString(2131236473));
            this.uA.putInt("key_err_code", 0);
        }
        this.kTr = (EditHintPasswdView) findViewById(2131758506);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kTr);
        findViewById(2131760027).setVisibility(8);
        textView = (TextView) findViewById(2131760026);
        b ae = com.tencent.mm.wallet_core.a.ae(this);
        CharSequence string = (ae == null || !(ae instanceof com.tencent.mm.plugin.wallet_core.id_verify.a)) ? k.xT() ? getString(2131236472) : getString(2131236470) : getString(2131236471);
        textView.setText(string);
        this.kTr.pkg = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletSetPasswordUI kVM;

            {
                this.kVM = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    String bLI = this.kVM.kTr.bLI();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_new_pwd1", bLI);
                    this.kVM.kTr.aJx();
                    com.tencent.mm.wallet_core.a.k(this.kVM, bundle);
                }
            }
        };
        d(this.kTr, 0, false);
    }

    public void onResume() {
        this.kTr.requestFocus();
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904684;
    }

    protected final boolean beY() {
        return true;
    }

    protected final int NO() {
        return 1;
    }
}
