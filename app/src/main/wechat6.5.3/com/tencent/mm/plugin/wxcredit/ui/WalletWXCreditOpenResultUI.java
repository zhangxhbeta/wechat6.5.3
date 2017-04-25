package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox lxb;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904700;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        c.vf().set(196658, Boolean.valueOf(true));
        com.tencent.mm.plugin.wallet_core.model.k.bga().kQV = be.Nh();
        NI();
    }

    protected final void NI() {
        vD(2131236568);
        TextView textView = (TextView) findViewById(2131760058);
        this.lxb = (CheckBox) findViewById(2131760059);
        if (((Bankcard) this.uA.getParcelable("key_bankcard")) != null) {
            this.lxb.setText(getString(2131236570, new Object[]{r1.field_bankName}));
            textView.setText(2131236571);
        }
        ((Button) findViewById(2131756365)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenResultUI lxc;

            {
                this.lxc = r1;
            }

            public final void onClick(View view) {
                this.lxc.bfv();
            }
        });
    }

    private void bfv() {
        bLD().j(Boolean.valueOf(this.lxb.isChecked()));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        bfv();
        return true;
    }
}
