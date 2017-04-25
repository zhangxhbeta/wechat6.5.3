package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUCardElementUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.fNM.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, 2131236257, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            return;
        }
        s.makeText(activity, 2131236173, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(this, mMActivity, fVar, this.fNM) {
                final /* synthetic */ c kYv;

                public final CharSequence nK(int i) {
                    if (i == 0) {
                        return this.piR.getString(2131236141);
                    }
                    return super.nK(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUCardElementUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ c kYv;

            public final boolean d(int i, int i2, String str, k kVar) {
                if ((kVar instanceof a) && i == 0 && i2 == 0) {
                    this.kYv.fNM.putInt("key_errcode_payu", 0);
                    this.kYv.d(this.piR, this.kYv.fNM);
                }
                if (kVar instanceof NetScenePayUElementQuery) {
                    if (i == 0 && i2 == 0) {
                        PayUBankcardElement payUBankcardElement = ((NetScenePayUElementQuery) kVar).kYr;
                        if (be.kS(payUBankcardElement.kYs)) {
                            payUBankcardElement.kYt = aa.getContext().getString(2131236372);
                        }
                        this.kYv.fNM.putParcelable("key_card_element", ((NetScenePayUElementQuery) kVar).kYr);
                    } else {
                        Parcelable payUBankcardElement2 = new PayUBankcardElement();
                        if (be.kS(str)) {
                            str = "err card element";
                        }
                        payUBankcardElement2.kYt = str;
                        this.kYv.fNM.putParcelable("key_card_element", payUBankcardElement2);
                    }
                }
                return false;
            }

            public final boolean j(Object... objArr) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.kYv.fNM.getParcelable("key_card_element");
                this.piS.a(new a(payUBankcardElement.hNe, payUBankcardElement.kYt, this.kYv.fNM.getString("key_bank_username"), this.kYv.fNM.getString("key_card_id"), this.kYv.fNM.getString("key_expire_data"), payUBankcardElement.bnG, this.kYv.fNM.getString("key_cvv"), this.kYv.fNM.getString("key_pwd1")), true);
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String anS() {
        return "PayUBindProcess";
    }
}
