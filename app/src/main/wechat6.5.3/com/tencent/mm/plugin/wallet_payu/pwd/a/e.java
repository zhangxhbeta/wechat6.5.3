package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public abstract class e extends b {
    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.fNM.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, 2131236257, 0).show();
        } else {
            s.makeText(activity, 2131236173, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ e lah;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof d)) {
                    return false;
                }
                v.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.lah.fNM.putInt("key_errcode_payu", 0);
                a.b(this.piR, this.lah.fNM, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                l lVar = (l) objArr[0];
                this.piS.a(new d(this.lah.fNM.getString("payu_reference"), lVar.kQj), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }
}
