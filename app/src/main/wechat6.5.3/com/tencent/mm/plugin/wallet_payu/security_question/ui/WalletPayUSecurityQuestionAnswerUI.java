package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button fzj;
    private WalletPayUSecurityQuestionView laE;
    private WalletFormView laF;
    private PayUSecurityQuestion laG;
    private a laH;

    protected class a {
        final /* synthetic */ WalletPayUSecurityQuestionAnswerUI laI;

        protected a(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
            this.laI = walletPayUSecurityQuestionAnswerUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.laH = new a(this);
        this.laE = (WalletPayUSecurityQuestionView) findViewById(2131758534);
        this.laF = (WalletFormView) findViewById(2131758535);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.laF);
        this.fzj = (Button) findViewById(2131758536);
        this.laF.pkk = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionAnswerUI laI;

            {
                this.laI = r1;
            }

            public final void fc(boolean z) {
                boolean z2;
                a a = this.laI.laH;
                if (a.laI.laF.Ou()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    a.laI.fzj.setEnabled(true);
                } else {
                    a.laI.fzj.setEnabled(false);
                }
            }
        };
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionAnswerUI laI;

            {
                this.laI = r1;
            }

            public final void onClick(View view) {
                if (this.laI.laF.Ou()) {
                    this.laI.uA.putString("key_question_answer", this.laI.laF.getText());
                    this.laI.bLD().j(new Object[0]);
                }
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            this.laG = (PayUSecurityQuestion) this.uA.getParcelable("key_security_question");
            v.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.laG != null) {
                this.laE.DF(this.laG.desc);
            }
            this.laF.aJx();
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904154;
    }

    protected final boolean beY() {
        return true;
    }
}
