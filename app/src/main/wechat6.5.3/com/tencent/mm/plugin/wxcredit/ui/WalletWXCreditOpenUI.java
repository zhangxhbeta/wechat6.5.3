package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button fzj;
    private Bankcard kHr;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904701;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kHr = (Bankcard) this.uA.getParcelable("key_bankcard");
        NI();
    }

    protected final void NI() {
        vD(2131236574);
        ((CheckBox) findViewById(2131759869)).setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI lxd;

            {
                this.lxd = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.lxd.fzj.setEnabled(z);
            }
        });
        findViewById(2131758286).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI lxd;

            {
                this.lxd = r1;
            }

            public final void onClick(View view) {
                e.a(this.lxd, this.lxd.kHr.field_bankcardType, this.lxd.kHr.field_bankName, true, false);
            }
        });
        this.fzj = (Button) findViewById(2131756365);
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI lxd;

            {
                this.lxd = r1;
            }

            public final void onClick(View view) {
                this.lxd.beC();
            }
        });
    }
}
