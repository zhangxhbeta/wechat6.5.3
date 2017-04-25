package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private Button fzj;
    private WalletPayUSecurityQuestionView laE;
    private WalletFormView laF;
    private m laJ;
    private String laK = "";
    private a laL;

    protected class a {
        final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

        protected a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
            this.laM = walletPayUSecurityQuestionSettingUI;
        }

        static /* synthetic */ void a(a aVar) {
            if (aVar.bhG()) {
                aVar.laM.fzj.setEnabled(true);
            } else {
                aVar.laM.fzj.setEnabled(false);
            }
        }

        protected final boolean bhG() {
            boolean z;
            if (be.kS(this.laM.laE.laO)) {
                z = false;
            } else {
                z = true;
            }
            return z && this.laM.laF.Ou();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.laJ = new m(this);
        this.laJ.kk(true);
        this.laJ.jXn = new c(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

            {
                this.laM = r1;
            }

            public final void a(l lVar) {
                lVar.clear();
                ArrayList a = this.laM.uA.getParcelableArrayList("key_security_question_list");
                if (a != null) {
                    for (int i = 0; i < a.size(); i++) {
                        lVar.add(((PayUSecurityQuestion) a.get(i)).desc);
                    }
                }
            }
        };
        this.laJ.jXo = new d(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

            {
                this.laM = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                this.laM.laE.DF(((PayUSecurityQuestion) this.laM.uA.getParcelableArrayList("key_security_question_list").get(i)).desc);
                this.laM.laK = ((PayUSecurityQuestion) this.laM.uA.getParcelableArrayList("key_security_question_list").get(i)).id;
                this.laM.laF.aJx();
                a.a(this.laM.laL);
            }
        };
        this.laL = new a(this);
        this.laE = (WalletPayUSecurityQuestionView) findViewById(2131758534);
        this.laF = (WalletFormView) findViewById(2131758535);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.laF);
        this.fzj = (Button) findViewById(2131758536);
        this.laE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

            {
                this.laM = r1;
            }

            public final void onClick(View view) {
                this.laM.laJ.dQ();
            }
        });
        this.laF.pkk = new com.tencent.mm.wallet_core.ui.formview.WalletFormView.a(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

            {
                this.laM = r1;
            }

            public final void fc(boolean z) {
                a.a(this.laM.laL);
            }
        };
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUSecurityQuestionSettingUI laM;

            {
                this.laM = r1;
            }

            public final void onClick(View view) {
                if (this.laM.laL.bhG()) {
                    this.laM.uA.putString("key_question_id", this.laM.laK);
                    this.laM.uA.putString("key_question_answer", this.laM.laF.getText());
                    com.tencent.mm.wallet_core.a.k(this.laM, this.laM.uA);
                    return;
                }
                a.a(this.laM.laL);
            }
        });
        a.a(this.laL);
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) && this.laJ.isShowing()) {
            this.laJ.dismiss();
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904155;
    }

    protected final boolean beY() {
        return true;
    }
}
