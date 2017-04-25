package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.f;

public class d extends a {
    protected final void f(Activity activity, Bundle bundle) {
        b(activity, WalletPayUBankcardDetailUI.class, bundle);
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.fNM.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, 2131236257, 0).show();
        } else {
            s.makeText(activity, 2131236173, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletPayUCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletPayUCheckPwdUI) {
            d(activity, bundle);
        }
    }

    public final com.tencent.mm.wallet_core.c.d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletPayUCheckPwdUI ? new com.tencent.mm.wallet_core.c.d(this, mMActivity, fVar) {
            final /* synthetic */ d kYw;

            public final CharSequence nK(int i) {
                if (i == 0) {
                    return this.piR.getString(2131236148);
                }
                return super.nK(i);
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof c) {
                    if (i2 == 0 && i == 0) {
                        c cVar = (c) kVar;
                        this.kYw.fNM.putString("payu_reference", cVar.token);
                        if (be.kS(cVar.token)) {
                            v.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                        } else {
                            v.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                            Bankcard bankcard = (Bankcard) this.kYw.fNM.getParcelable("key_bankcard");
                            if (bankcard != null) {
                                this.piS.a(new b(bankcard.field_bindSerial, this.kYw.fNM.getString("payu_reference")), true);
                            }
                        }
                    }
                } else if ((kVar instanceof b) && i == 0 && i2 == 0) {
                    this.kYw.fNM.putInt("key_errcode_payu", 0);
                    this.kYw.d(this.piR, this.kYw.fNM);
                }
                return false;
            }

            public final boolean j(Object... objArr) {
                this.kYw.fNM.putString("key_pwd1", (String) objArr[0]);
                this.piS.a(new c(this.kYw.fNM.getString("key_pwd1")), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }
}
