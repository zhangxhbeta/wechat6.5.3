package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView kKF;
    private WalletFormView kRY;
    private String lwr;

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        if (be.kS(str)) {
            s.makeText(walletCheckIdentityUI, 2131236138, 0).show();
            return false;
        } else if (!be.kS(str2) && str2.length() >= 4 && (!be.kS(walletCheckIdentityUI.lwr) || walletCheckIdentityUI.kKF.Ou())) {
            return true;
        } else {
            s.makeText(walletCheckIdentityUI, 2131236094, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904695;
    }

    public final void NI() {
        vD(2131236140);
        this.kRY = (WalletFormView) findViewById(2131759831);
        a.d(this, this.kRY);
        this.kKF = (WalletFormView) findViewById(2131759858);
        a.b(this.kKF);
        d(this.kKF, 1, false);
        CharSequence string = this.uA.getString("key_pre_name");
        this.lwr = this.uA.getString("key_pre_indentity");
        if (!be.kS(string)) {
            this.kRY.ioy.setText(string);
            this.kRY.setHint(getString(2131236130));
        }
        if (!be.kS(this.lwr)) {
            this.kKF.ioU = 4;
            this.kKF.ioy.setText(this.lwr);
            this.kKF.setHint(getString(2131236097));
        }
        findViewById(2131756365).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCheckIdentityUI lws;

            {
                this.lws = r1;
            }

            public final void onClick(View view) {
                if (WalletCheckIdentityUI.a(this.lws, this.lws.kRY.getText(), this.lws.kKF.getText())) {
                    this.lws.bLD().j(r0, r1);
                }
            }
        });
    }

    protected final int NO() {
        return 1;
    }
}
