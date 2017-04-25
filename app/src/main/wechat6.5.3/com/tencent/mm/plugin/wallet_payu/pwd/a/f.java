package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;

public class f extends e {
    public final b c(Activity activity, Bundle bundle) {
        b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
        return super.c(activity, bundle);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final d a(MMActivity mMActivity, com.tencent.mm.wallet_core.c.f fVar) {
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            return new a(mMActivity, fVar, this.fNM);
        }
        return super.a(mMActivity, fVar);
    }

    public final String anS() {
        return "PayUForgotPwdProcess";
    }
}
