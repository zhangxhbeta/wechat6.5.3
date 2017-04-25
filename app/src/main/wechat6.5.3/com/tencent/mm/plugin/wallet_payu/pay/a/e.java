package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.plugin.wallet_core.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class e extends a {
    public final b c(Activity activity, Bundle bundle) {
        bundle.putInt("key_pay_scene", ((PayInfo) bundle.getParcelable("key_pay_info")).bkq);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
            case -1003:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            default:
                v.d("MicroMsg.PayUPayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
                switch (bundle.getInt("key_pay_flag", 0)) {
                    case 3:
                        j(activity, bundle);
                        break;
                }
                break;
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        boolean z;
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                z = true;
                break;
            case -1003:
                com.tencent.mm.wallet_core.a.a(activity, c.class, bundle);
                z = true;
                break;
            case 402:
            case 403:
            case 408:
                d(activity, bundle);
                z = true;
                break;
            default:
                int i2 = 0;
                break;
        }
        if (i2 != 0) {
            v.i("MicroMsg.PayUPayProcess", "deal with the err!");
            return;
        }
        i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.fNM.getInt("key_pay_flag", 0);
        v.d("MicroMsg.PayUPayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 3:
                if (activity instanceof WalletPayUVerifyCodeUI) {
                    h(activity, bundle);
                    return;
                } else if (activity instanceof WalletPayUChangeBankcardUI) {
                    j(activity, bundle);
                    return;
                } else if (activity instanceof WalletPayUBalanceResultUI) {
                    Intent intent = new Intent(activity, WalletPayUBalanceManagerUI.class);
                    intent.putExtras(new Bundle());
                    intent.getExtras().putAll(bundle);
                    a(activity, WalletPayUBalanceManagerUI.class, -1, intent, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void d(Activity activity, int i) {
        v.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            D(activity);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        int i = -1;
        v.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        int i2 = this.fNM.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.fNM.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.fNM.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.fNM.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.fNM.getString("intent_wap_pay_jump_url"));
            intent.putExtras(bundle2);
        }
        qp qpVar = new qp();
        qpVar.bsg.context = activity;
        qpVar.bsg.intent = intent;
        qp.a aVar = qpVar.bsg;
        if (!this.fNM.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.bpc = i;
        com.tencent.mm.sdk.c.a.nhr.z(qpVar);
        a(activity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i2, intent, false);
    }

    private void j(Activity activity, Bundle bundle) {
        if (bundle.getBoolean("key_should_redirect", false)) {
            bundle.getString("key_gateway_code");
            String string = bundle.getString("key_gateway_reference");
            boolean z = bundle.getBoolean("key_should_force_adjust");
            String string2 = bundle.getString("key_force_adjust_code");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("shouldForceViewPort", z);
            intent.putExtra("pay_channel", 2);
            intent.putExtra("view_port_code", string2);
            com.tencent.mm.ay.c.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 23351);
            return;
        }
        h(activity, bundle);
    }

    private void h(Activity activity, Bundle bundle) {
        int i = bundle.getInt("key_pay_scene", 6);
        if (i == 11 || i == 21) {
            b(activity, WalletPayUBalanceResultUI.class, bundle);
        } else if (i == 31 || i == 32 || i == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
        } else {
            b(activity, WalletPayUOrderInfoUI.class, bundle);
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        switch (this.fNM.getInt("key_pay_flag", 0)) {
        }
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUPayUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e kZN;

                public final boolean o(Object... objArr) {
                    PayInfo payInfo = (PayInfo) this.piR.getIntent().getParcelableExtra("key_pay_info");
                    if (payInfo == null || be.kS(payInfo.fTG)) {
                        return false;
                    }
                    this.piS.a(new c(payInfo.fTG), payInfo.lVA, true);
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.b.b.a(), payInfo.lVA, true);
                    return true;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletPayUBalanceResultUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ e kZN;

            public final boolean d(int i, int i2, String str, k kVar) {
                return false;
            }

            public final boolean j(Object... objArr) {
                Orders orders = (Orders) objArr[0];
                com.tencent.mm.plugin.wallet.a.k.beN();
                Bankcard bankcard = com.tencent.mm.plugin.wallet.a.k.beO().kFU;
                bankcard.kNv += orders.kOU;
                return false;
            }

            public final CharSequence nK(int i) {
                switch (i) {
                    case 0:
                        return this.piR.getString(2131236013);
                    case 1:
                        return this.piR.getString(2131236012);
                    default:
                        return super.nK(i);
                }
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    public final int d(MMActivity mMActivity, int i) {
        return 2131236354;
    }

    public final String anS() {
        return "PayUPayProcess";
    }
}
