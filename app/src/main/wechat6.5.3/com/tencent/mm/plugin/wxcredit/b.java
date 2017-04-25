package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class b extends com.tencent.mm.wallet_core.b {
    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletWXCreditChangeAmountUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            b(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountResultUI) {
            d(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b lvH;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof e) {
                        this.lvH.fNM.putString("kreq_token", ((e) kVar).token);
                        return false;
                    } else if (!(kVar instanceof c)) {
                        return false;
                    } else {
                        this.lvH.fNM.putDouble("key_credit_amount", ((c) kVar).lvP);
                        this.lvH.a(this.piR, 0, this.lvH.fNM);
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    this.piS.a(new e(((Bankcard) this.lvH.fNM.getParcelable("key_bankcard")).field_bindSerial), true, true);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b lvH;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.lvH.a(this.piR, 0, this.lvH.fNM);
                this.piR.finish();
                return true;
            }

            public final boolean j(Object... objArr) {
                this.lvH.fNM.putString("key_pwd1", (String) objArr[0]);
                this.piS.a(new i((String) objArr[0], 5, ""), true, true);
                return true;
            }
        } : null;
    }

    public final String anS() {
        return "WXCreditChangeAmountProcess";
    }
}
