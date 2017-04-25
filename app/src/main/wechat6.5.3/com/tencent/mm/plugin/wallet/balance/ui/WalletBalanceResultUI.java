package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Button fzj;
    protected TextView hfA;
    public Orders ith;
    public TextView kFX;
    public TextView kFY;
    public CheckBox kFZ;
    public Bankcard kGa;
    protected TextView kdN;

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        if (walletBalanceResultUI.uA.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.uA.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.a(walletBalanceResultUI, bundle, new OnClickListener(walletBalanceResultUI) {
                    final /* synthetic */ WalletBalanceResultUI kGb;

                    {
                        this.kGb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kGb.beB();
                    }
                });
                walletBalanceResultUI.uA.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceResultUI.beB();
    }

    protected final int getLayoutId() {
        return 2130904608;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        NI();
        av();
        t.a((PayInfo) this.uA.getParcelable("key_pay_info"), this.ith);
    }

    public void NI() {
        Fd((String) bLD().nK(0));
        this.kdN = (TextView) findViewById(2131759790);
        this.kdN.setText(bLD().nK(1));
        this.hfA = (TextView) findViewById(2131759791);
        CharSequence nK = bLD().nK(2);
        if (be.D(nK)) {
            this.hfA.setVisibility(8);
        } else {
            this.hfA.setVisibility(0);
            this.hfA.setText(nK);
        }
        ImageView imageView = (ImageView) findViewById(2131759789);
        int i = this.uA.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(2130839535);
        }
        this.kFY = (TextView) findViewById(2131759793);
        this.kFX = (TextView) findViewById(2131759795);
        TextView textView = (TextView) findViewById(2131759794);
        if (bLC() instanceof b) {
            textView.setText(getString(2131236015));
        }
        this.kFZ = (CheckBox) findViewById(2131759798);
        this.kGa = (Bankcard) this.uA.getParcelable("key_bankcard");
        if (this.kGa != null) {
            this.kFZ.setVisibility(8);
        } else {
            this.kFZ.setVisibility(0);
        }
        this.fzj = (Button) findViewById(2131756365);
        this.fzj.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletBalanceResultUI kGb;

            {
                this.kGb = r1;
            }

            public final void onClick(View view) {
                WalletBalanceResultUI.a(this.kGb);
            }
        });
        bzV();
        iS(false);
    }

    private void beB() {
        if (this.kFZ.getVisibility() == 0 && this.kFZ.isChecked()) {
            PayInfo payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
            j(new com.tencent.mm.plugin.wallet.balance.a.a(this.uA.getInt("key_pay_flag", 0), this.uA.getString("key_pwd1"), this.uA.getString("key_verify_code"), payInfo.fTG, payInfo.bkq));
            return;
        }
        beC();
    }

    public void av() {
        if (this.ith != null) {
            this.kFX.setText(e.d(this.ith.kOU, this.ith.hNg));
            if (this.ith.kPm != null && this.ith.kPm.size() > 0) {
                Commodity commodity = (Commodity) this.ith.kPm.get(0);
                if (be.kS(commodity.kPy)) {
                    this.kFY.setText(commodity.hNe);
                } else {
                    this.kFY.setText(commodity.hNe + " " + getString(2131236343) + commodity.kPy);
                }
            }
            if (!(bLC() instanceof b)) {
                return;
            }
            if (this.ith.iro > 0.0d) {
                findViewById(2131759796).setVisibility(0);
                TextView textView = (TextView) findViewById(2131759797);
                textView.setText(e.d(this.ith.iro, this.ith.hNg));
                textView.setVisibility(0);
                return;
            }
            v.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
        }
    }

    public final void beC() {
        if (!bLD().j(this.ith)) {
            super.beC();
        }
    }

    public void onBackPressed() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.balance.a.a)) {
            return false;
        }
        com.tencent.mm.plugin.wallet.a.k.beN();
        com.tencent.mm.plugin.wallet.a.k.beO().kQV = be.Nh();
        beC();
        return true;
    }
}
