package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class g extends e {
    public final b c(Activity activity, Bundle bundle) {
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(this, mMActivity, fVar, this.fNM) {
                final /* synthetic */ g lai;

                public final CharSequence nK(int i) {
                    if (i == 0) {
                        return this.piR.getString(2131236143);
                    }
                    return super.nK(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ g lai;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof b)) {
                    return false;
                }
                v.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.lai.fNM.putInt("key_errcode_payu", 0);
                a.b(this.piR, this.lai.fNM, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                l lVar = (l) objArr[0];
                this.piS.a(new b(this.lai.fNM.getString("key_pwd1"), lVar.kQj), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String anS() {
        return "PayUModifyPasswordProcess";
    }
}
