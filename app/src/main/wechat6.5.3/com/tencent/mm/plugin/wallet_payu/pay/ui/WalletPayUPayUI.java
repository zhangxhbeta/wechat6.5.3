package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.qo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String kZO = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        v.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
    }

    protected final void bff() {
        b(new c(bfp().fTG), bfp().lVA);
        b(new com.tencent.mm.plugin.wallet_core.b.b.a(bfp().fTG), bfp().lVA);
    }

    protected final void beX() {
        if (Ox()) {
            v.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.kFo = b.a(this, this.ith, this.kID, this.kFr, new b(this) {
                final /* synthetic */ WalletPayUPayUI kZS;

                {
                    this.kZS = r1;
                }

                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    this.kZS.axg();
                    this.kZS.kIC = str;
                    this.kZS.kZO = str2;
                    this.kZS.hh(false);
                    com.tencent.mm.plugin.wallet_core.d.c.bhu();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUPayUI kZS;

                {
                    this.kZS = r1;
                }

                public final void onClick(View view) {
                    this.kZS.kID = (FavorPayInfo) view.getTag();
                    if (this.kZS.kID != null) {
                        this.kZS.kID.kOz = "";
                    }
                    this.kZS.d(false, 0, "");
                    this.kZS.kFo.dismiss();
                    this.kZS.kIC = null;
                    this.kZS.kFo = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUPayUI kZS;

                {
                    this.kZS = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.kZS.kIC = null;
                    this.kZS.kFo = null;
                    if (this.kZS.ayJ()) {
                        this.kZS.finish();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.kFr.field_bankcardType));
        }
    }

    protected final void y(Bundle bundle) {
        boolean z = true;
        this.kJh = true;
        if (this.ith != null) {
            bundle.putInt("key_support_bankcard", this.ith.kLu);
        }
        String str = "key_is_oversea";
        if (bfk()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
    }

    protected final void hh(boolean z) {
        if (this.kIA.bkq == 32 || this.kIA.bkq == 31) {
            int i;
            if (this.kIA.bkq == 32) {
                v.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            p(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.kIA.fTG, this.kIC, this.kIA.lVD.getDouble("total_fee"), this.kIA.lVD.getString("fee_type"), i, this.kIA.lVD.getString("extinfo_key_1"), this.kFr.field_bindSerial, this.kIA.lVD.getString("extinfo_key_4")));
        } else if (this.kIA.bkq == 11) {
            String str = this.kIC;
            String str2 = this.kZO;
            String str3 = this.kIA.fTG;
            double d = this.kIA.lVD.getDouble("total_fee");
            String string = this.kIA.lVD.getString("fee_type");
            String str4 = this.kFr.field_bindSerial;
            String str5 = this.kFr.field_bankcardType;
            k.beN();
            p(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str, str2, str3, d, string, str4, str5, k.beO().kFU.field_bindSerial));
        } else {
            j(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.kIA.fTG, this.kIA.lVD.getDouble("total_fee"), this.kIA.lVD.getString("fee_type"), this.kFr.field_bankcardType, this.kFr.field_bindSerial, this.kZO, this.kIC));
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        int i3 = 0;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                this.ith = ((c) kVar).ith;
                if (this.ith != null) {
                    i3 = this.ith.kPm.size();
                }
                this.mCount = i3;
                v.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.ith != null ? Integer.valueOf(this.ith.kLu) : ""));
                Ox();
                if (!(this.ith == null || this.ith.kPm == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.ith.kPm) {
                        if (be.kS(commodity.eWA)) {
                            commodity.eWA = this.kIA.fTG;
                        }
                        linkedList.add(commodity.eWA);
                    }
                    if (linkedList.size() > 0) {
                        qo qoVar = new qo();
                        qoVar.bsd.bsf = linkedList;
                        com.tencent.mm.sdk.c.a.nhr.z(qoVar);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putDouble("total_fee", this.ith.kOU);
                    bundle.putString("fee_type", "ZAR");
                    if (this.kIA.lVD == null) {
                        this.kIA.lVD = bundle;
                    } else {
                        this.kIA.lVD.putAll(bundle);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.b.a) {
                k.beN();
                this.kFq = k.beO().hk(beU());
                k.beN();
                this.kFr = k.beO().a(null, null, beU(), false);
                this.kIx.setClickable(true);
                if (!(this.ith == null || this.kFq == null || this.kIA == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.kIA, this.ith);
                    g gVar = g.iuh;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.kIA.bkq);
                    objArr[1] = Integer.valueOf(0);
                    k.beN();
                    objArr[2] = Integer.valueOf(k.beO().bgv() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.ith.kOU * 100.0d));
                    objArr[4] = this.ith.hNg;
                    gVar.h(10690, objArr);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                r1 = this.uA;
                r1.putParcelable("key_pay_info", this.kIA);
                r1.putParcelable("key_bankcard", this.kFr);
                r1.putString("key_bank_type", this.kFr.field_bankcardType);
                if (!be.kS(this.kIC)) {
                    r1.putString("key_pwd1", this.kIC);
                }
                r1.putString("kreq_token", bVar.axY());
                r1.putParcelable("key_authen", bfj());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.kFr.field_mobile);
                if (bVar.iY()) {
                    r1.putParcelable("key_orders", d.a(this.ith, bVar.kZK, bVar.kZL, bVar.eWB, bVar.kRM));
                }
                this.uA.putBoolean("key_should_redirect", bVar.kZI);
                this.uA.putString("key_gateway_code", bVar.kYl);
                this.uA.putString("key_gateway_reference", bVar.kYk);
                this.uA.putBoolean("key_should_force_adjust", bVar.kZJ);
                this.uA.putString("key_force_adjust_code", bVar.kYn);
                r1.putInt("key_pay_flag", 3);
                y(r1);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) kVar;
                r1 = this.uA;
                r1.putParcelable("key_pay_info", this.kIA);
                r1.putParcelable("key_bankcard", this.kFr);
                r1.putString("key_bank_type", this.kFr.field_bankcardType);
                if (!be.kS(this.kIC)) {
                    r1.putString("key_pwd1", this.kIC);
                }
                r1.putString("kreq_token", aVar.axY());
                r1.putParcelable("key_authen", bfj());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.kFr.field_mobile);
                r1.putParcelable("key_orders", this.ith);
                r1.putInt("key_pay_flag", 3);
                y(r1);
                return true;
            }
            av();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                    this.kJl = this.uA;
                    this.kJl.putParcelable("key_pay_info", this.kIA);
                    this.kJl.putParcelable("key_bankcard", this.kFr);
                    if (!be.kS(this.kIC)) {
                        this.kJl.putString("key_pwd1", this.kIC);
                    }
                    this.kJl.putString("kreq_token", bVar.axY());
                    this.kJl.putString("key_mobile", this.kFr.field_mobile);
                    this.kJl.putInt("key_err_code", i2);
                    this.kJl.putParcelable("key_orders", this.ith);
                    if (be.kS(str)) {
                        string = getString(2131236367);
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.g.b(this, string, "", getString(2131236366), getString(2131231010), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUPayUI kZS;

                        {
                            this.kZS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kZS.kJl.putInt("key_pay_flag", 3);
                            this.kZS.y(this.kZS.kJl);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUPayUI kZS;

                        {
                            this.kZS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.kZS.ayJ()) {
                                this.kZS.finish();
                            }
                        }
                    });
                    return true;
                case 404:
                    if (!(this.kFr == null || this.ith == null)) {
                        this.kFr.kNu = this.ith.fTG;
                        if (this.kFq == null || this.kFq.size() <= 1) {
                            c(true, 4, str);
                            return true;
                        }
                        d(true, 4, str);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
