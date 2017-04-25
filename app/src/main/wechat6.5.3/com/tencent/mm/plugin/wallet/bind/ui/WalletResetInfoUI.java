package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private TextView dMQ;
    private Orders ith;
    private Bankcard kGa;
    private Button kHi;
    private WalletFormView kHj;
    private WalletFormView kHk;
    private WalletFormView kHl;
    private WalletFormView kHm;
    private Authen kHn;
    private ElementQuery kHo;

    protected final int getLayoutId() {
        return 2130904679;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        this.dMQ = (TextView) findViewById(2131760015);
        Bankcard bankcard = (Bankcard) this.uA.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
        }
        this.kGa = bankcard;
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        this.kHn = (Authen) this.uA.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.uA.getString("key_pwd1", ""))) {
            this.uA.putString("key_pwd1", this.kHn.kMR);
            v.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.kHo = (ElementQuery) this.uA.getParcelable("elemt_query");
        this.kHj = (WalletFormView) findViewById(2131760016);
        this.kHk = (WalletFormView) findViewById(2131758530);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.kHk);
        this.kHl = (WalletFormView) findViewById(2131758528);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.kHl);
        this.kHm = (WalletFormView) findViewById(2131759761);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.kHm);
        this.kHk.pkk = this;
        this.kHl.pkk = this;
        this.kHm.pkk = this;
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131758524);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.kGa != null) {
            this.kHj.setText(this.kGa.field_desc);
        } else {
            this.kHj.setVisibility(8);
        }
        beM();
        if (beL()) {
            b(new k("", "", null), true);
        }
    }

    private boolean beL() {
        return this.uA.getInt("key_err_code", 408) == 408 && this.kHo == null;
    }

    private void beM() {
        switch (this.uA.getInt("key_err_code", 408)) {
            case 402:
                vD(2131236448);
                this.kHl.setVisibility(0);
                this.dMQ.setText(2131236447);
                break;
            case 403:
                vD(2131236454);
                this.kHk.setVisibility(0);
                this.dMQ.setText(2131236453);
                break;
            default:
                if (this.uA.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    vD(2131236452);
                    this.kHm.setVisibility(0);
                } else {
                    vD(2131236450);
                }
                if (this.kGa != null) {
                    v.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[]{this.kGa.field_bankPhone});
                    this.dMQ.setText(String.format(getString(2131236451), new Object[]{this.kGa.field_bankPhone}));
                }
                if (this.kHo == null && this.kGa != null) {
                    this.kHo = com.tencent.mm.plugin.wallet_core.model.k.bgi().Da(this.kGa.field_bankcardType);
                }
                if (this.kHo != null && this.kHo.kNW) {
                    this.kHl.setVisibility(0);
                }
                if (this.kHo != null && this.kHo.kNX) {
                    this.kHk.setVisibility(0);
                    break;
                }
        }
        this.kHi = (Button) findViewById(2131756365);
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletResetInfoUI kHp;

            {
                this.kHp = r1;
            }

            public final void onClick(View view) {
                if (this.kHp.Ox()) {
                    if (this.kHp.kHl.getVisibility() == 0) {
                        this.kHp.kHn.kMW = this.kHp.kHl.getText();
                    }
                    if (this.kHp.kHk.getVisibility() == 0) {
                        this.kHp.kHn.kMX = be.ah(this.kHp.kHk.getText(), "");
                    }
                    if (this.kHp.kHm.getVisibility() == 0) {
                        this.kHp.kHn.kLp = be.ah(this.kHp.kHm.getText(), "");
                        this.kHp.uA.putString("key_mobile", e.PT(this.kHp.kHn.kLp));
                    }
                    v.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[]{this.kHp.kHn.hMt, this.kHp.kHn.hMu});
                    this.kHp.kHn.kMQ = 1;
                    if (this.kHp.uA.getBoolean("key_is_changing_balance_phone_num", false)) {
                        this.kHp.j(new c(this.kHp.kHn, this.kHp.ith));
                        return;
                    }
                    b a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.kHp.kHn, this.kHp.ith, false);
                    if (a != null) {
                        this.kHp.j(a);
                        return;
                    }
                    return;
                }
                v.w("Micromsg.WalletResetInfoUI", "input format illegal!");
            }
        });
        Ox();
        if (beL()) {
            oa(4);
        } else {
            oa(0);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.uA;
            if ((kVar instanceof b) || (kVar instanceof c)) {
                b bVar = (b) kVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.hdm);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.hdn) {
                    bundle.putParcelable("key_orders", bVar.hdo);
                }
                RealnameGuideHelper realnameGuideHelper = bVar.hKv;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.k(this, bundle);
                return true;
            } else if ((kVar instanceof k) && this.kGa != null) {
                this.kHo = com.tencent.mm.plugin.wallet_core.model.k.bgi().Db(this.kGa.field_bindSerial);
                beM();
            }
        }
        return false;
    }

    private boolean Ox() {
        boolean z;
        if (this.kHk.de(null)) {
            z = true;
        } else {
            z = false;
        }
        if (!this.kHm.de(null)) {
            z = false;
        }
        if (!this.kHl.de(null)) {
            z = false;
        }
        if (this.ith == null || this.kHn == null) {
            z = false;
        }
        if (z) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
        } else {
            this.kHi.setEnabled(false);
            this.kHi.setClickable(false);
        }
        return z;
    }

    public final void fc(boolean z) {
        Ox();
    }
}
