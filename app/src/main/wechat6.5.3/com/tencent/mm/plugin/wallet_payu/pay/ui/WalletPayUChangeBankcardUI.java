package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String kZO = null;
    private c kZP = new c<jt>(this) {
        final /* synthetic */ WalletPayUChangeBankcardUI kZQ;

        {
            this.kZQ = r2;
            this.nhz = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jt jtVar = (jt) bVar;
            v.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            d dVar = new d(jtVar);
            this.kZQ.uA.putString("app_id", dVar.appId);
            this.kZQ.uA.putString("package", dVar.bkn);
            this.kZQ.uA.putString("timestamp", dVar.bkm);
            this.kZQ.uA.putString("noncestr", dVar.bkl);
            this.kZQ.uA.putString("pay_sign", dVar.bko);
            this.kZQ.uA.putString("sign_type", dVar.bkk);
            this.kZQ.uA.putString("url", dVar.url);
            this.kZQ.uA.putBoolean("from_jsapi", true);
            this.kZQ.uA.putString("key_trans_id", ((PayInfo) this.kZQ.uA.getParcelable("key_pay_info")).fTG);
            this.kZQ.uA.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.k(this.kZQ, this.kZQ.uA);
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.c.a.nhr.e(this.kZP);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.kZP);
    }

    protected final f beW() {
        return new a(this, this.kFq, this.kIy, this.ith);
    }

    protected final void beX() {
        v.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.uA.getString("key_pwd1");
        if (be.kS(string)) {
            oa(4);
            this.kFo = b.a(this, this.ith, this.kID, this.kFr, new b.b(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI kZQ;

                {
                    this.kZQ = r1;
                }

                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    this.kZQ.kID = favorPayInfo;
                    this.kZQ.uA.putParcelable("key_favor_pay_info", this.kZQ.kID);
                    this.kZQ.kIC = str;
                    this.kZQ.kZO = str2;
                    this.kZQ.axg();
                    this.kZQ.CV(str);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI kZQ;

                {
                    this.kZQ = r1;
                }

                public final void onClick(View view) {
                    if (this.kZQ.kFo != null) {
                        this.kZQ.kFo.dismiss();
                    }
                    this.kZQ.kIz.R(this.kZQ.kFq);
                    this.kZQ.kID = (FavorPayInfo) view.getTag();
                    if (this.kZQ.kID != null) {
                        this.kZQ.kID.kOz = "";
                    }
                    this.kZQ.uA.putParcelable("key_favor_pay_info", this.kZQ.kID);
                    this.kZQ.av();
                    this.kZQ.oa(0);
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI kZQ;

                {
                    this.kZQ = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.kZQ.kIC = null;
                    if (this.kZQ.nDR.dtW.getVisibility() != 0) {
                        this.kZQ.beZ();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.kFr.field_bankcardType));
            return;
        }
        CV(string);
    }

    protected final void CV(String str) {
        this.kHn.kMR = str;
        if (this.kFr != null) {
            this.uA.putString("key_mobile", this.kFr.field_mobile);
            this.uA.putParcelable("key_bankcard", this.kFr);
            this.kHn.hMu = this.kFr.field_bindSerial;
            this.kHn.hMt = this.kFr.field_bankcardType;
            if (this.kID != null) {
                this.kHn.kNe = this.kID.kOv;
            } else {
                this.kHn.kNe = null;
            }
            if (!(this.ith == null || this.ith.kPn == null)) {
                this.kHn.kNd = this.ith.kPn.kHB;
            }
            if (this.ith != null && this.ith.kLu == 3) {
                boolean z;
                if (this.kFr.bfI()) {
                    this.kHn.bkU = 3;
                } else {
                    this.kHn.bkU = 6;
                }
                Bundle bundle = this.uA;
                String str2 = "key_is_oversea";
                if (this.kFr.bfI()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.uA.putParcelable("key_authen", this.kHn);
        if (this.kIA.bkq == 32 || this.kIA.bkq == 31) {
            int i;
            if (this.kIA.bkq == 32) {
                v.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            p(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.kIA.fTG, this.kIC, this.kIA.lVD.getDouble("total_fee"), this.kIA.lVD.getString("fee_type"), i, this.kIA.lVD.getString("extinfo_key_1"), this.kFr.field_bindSerial, this.kIA.lVD.getString("extinfo_key_4")));
        } else if (this.kIA.bkq == 11) {
            String str3 = this.kIC;
            String str4 = this.kZO;
            String str5 = this.kIA.fTG;
            double d = this.kIA.lVD.getDouble("total_fee");
            String string = this.kIA.lVD.getString("fee_type");
            String str6 = this.kFr.field_bindSerial;
            String str7 = this.kFr.field_bankcardType;
            k.beN();
            p(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str4, str5, d, string, str6, str7, k.beO().kFU.field_bindSerial));
        } else {
            j(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.kIA.fTG, this.kIA.lVD.getDouble("total_fee"), this.kIA.lVD.getString("fee_type"), this.kFr.field_bankcardType, this.kFr.field_bindSerial, this.kZO, str));
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {
            return false;
        }
        Bundle bundle = this.uA;
        if (!be.kS(this.kIC)) {
            bundle.putString("key_pwd1", this.kIC);
        }
        bundle.putBoolean("key_need_verify_sms", false);
        bundle.putParcelable("key_pay_info", this.kIA);
        bundle.putInt("key_pay_flag", 3);
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
            bundle.putString("transid", bVar.hOJ);
            bundle.putBoolean("key_should_redirect", bVar.kZI);
            bundle.putString("key_gateway_code", bVar.kYl);
            bundle.putString("key_gateway_reference", bVar.kYk);
            bundle.putString("key_force_adjust_code", bVar.kYn);
            bundle.putBoolean("key_should_force_adjust", bVar.kZJ);
            if (bVar.iY()) {
                bundle.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.d.a(this.ith, bVar.kZK, bVar.kZL, bVar.eWB, bVar.kRM));
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
            com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) kVar;
            bundle.putString("transid", bVar2.hOJ);
            bundle.putBoolean("key_should_redirect", bVar2.kYj);
            bundle.putString("key_gateway_code", bVar2.kYl);
            bundle.putString("key_gateway_reference", bVar2.kYk);
            bundle.putString("key_force_adjust_code", bVar2.kYn);
            bundle.putBoolean("key_should_force_adjust", bVar2.kYm);
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 23351) {
            v.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                this.uA.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.k(this, this.uA);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.b(this, this.uA, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
