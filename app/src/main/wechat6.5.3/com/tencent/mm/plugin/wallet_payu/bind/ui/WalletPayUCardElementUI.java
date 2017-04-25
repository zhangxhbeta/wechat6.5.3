package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button fzj;
    private TextView kYA;
    private TextView kYB;
    private TextView kYC;
    private b kYD;
    private boolean kYE = false;
    private boolean kYF = false;
    private boolean kYG = false;
    private HashMap<String, PayUBankcardElement> kYH = null;
    private HashSet<String> kYI = null;
    private WalletFormView kYx;
    WalletFormView kYy;
    private WalletFormView kYz;

    private abstract class a implements TextWatcher {
        final /* synthetic */ WalletPayUCardElementUI kYJ;

        private a(WalletPayUCardElementUI walletPayUCardElementUI) {
            this.kYJ = walletPayUCardElementUI;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    protected class b {
        final /* synthetic */ WalletPayUCardElementUI kYJ;
        boolean kYK;
        boolean kYL;
        boolean kYM;

        protected b(WalletPayUCardElementUI walletPayUCardElementUI) {
            this.kYJ = walletPayUCardElementUI;
        }

        protected final void bhB() {
            this.kYK = this.kYJ.kYx.Ou();
            this.kYL = this.kYJ.kYy.Ou();
            this.kYM = this.kYJ.kYz.Ou();
            if (!this.kYJ.kYG || this.kYM) {
                this.kYJ.kYB.setVisibility(4);
            } else {
                this.kYJ.kYB.setVisibility(0);
                this.kYJ.kYB.setText(2131236073);
            }
            boolean z;
            if (!this.kYJ.kYE) {
                z = false;
            } else if (!this.kYK) {
                this.kYJ.kYA.setVisibility(0);
                this.kYJ.kYA.setTextColor(this.kYJ.getResources().getColor(2131689960));
                this.kYJ.kYA.setText(2131236065);
                z = false;
            } else if (!this.kYJ.kYH.containsKey(this.kYJ.kYx.getText()) || this.kYJ.kYI.contains(this.kYJ.kYx.getText())) {
                this.kYJ.b(new NetScenePayUElementQuery(this.kYJ.kYx.getText()), false);
                this.kYJ.kYI.add(this.kYJ.kYx.getText());
                this.kYJ.kYA.setVisibility(0);
                this.kYJ.kYA.setTextColor(this.kYJ.getResources().getColor(2131689792));
                this.kYJ.kYA.setText(this.kYJ.getString(2131236052));
                z = true;
            } else {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.kYJ.kYH.get(this.kYJ.kYx.getText());
                this.kYJ.kYA.setVisibility(0);
                if (be.kS(payUBankcardElement.kYs)) {
                    this.kYJ.kYA.setTextColor(this.kYJ.getResources().getColor(2131689960));
                    this.kYJ.kYA.setText(payUBankcardElement.kYt);
                    this.kYK = false;
                    z = false;
                } else {
                    this.kYJ.kYA.setTextColor(this.kYJ.getResources().getColor(2131689792));
                    this.kYJ.kYA.setText(payUBankcardElement.kYt);
                    z = false;
                }
            }
            if (this.kYK && this.kYL && this.kYM && !r0) {
                this.kYJ.fzj.setEnabled(true);
            } else {
                this.kYJ.fzj.setEnabled(false);
            }
        }
    }

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.kYx.getId()) {
                walletPayUCardElementUI.kYE = true;
            } else if (view.getId() == walletPayUCardElementUI.kYz.getId()) {
                walletPayUCardElementUI.kYG = true;
            } else if (view.getId() == walletPayUCardElementUI.kYy.getId()) {
                walletPayUCardElementUI.kYF = true;
            }
        }
        walletPayUCardElementUI.kYD.bhB();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kYD = new b(this);
        this.kYH = new HashMap();
        this.kYI = new HashSet();
        this.kYx = (WalletFormView) findViewById(2131758526);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kYx);
        this.kYy = (WalletFormView) findViewById(2131758530);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.kYy);
        this.kYz = (WalletFormView) findViewById(2131758528);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.kYz);
        this.kYA = (TextView) findViewById(2131758527);
        this.kYB = (TextView) findViewById(2131758529);
        this.fzj = (Button) findViewById(2131756365);
        d(this.kYx, 0, false);
        d(this.kYz, 0, false);
        this.kYx.pkk = this;
        this.kYz.pkk = this;
        this.kYy.pkk = this;
        this.kYx.pko = 0;
        this.kYz.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI kYJ;

            {
                this.kYJ = r2;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.kYJ, this.kYJ.kYz, editable);
            }
        });
        this.kYy.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI kYJ;

            {
                this.kYJ = r2;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.kYJ, this.kYJ.kYy, editable);
            }
        });
        this.kYx.a(new a(this) {
            final /* synthetic */ WalletPayUCardElementUI kYJ;

            {
                this.kYJ = r2;
            }

            public final void afterTextChanged(Editable editable) {
                WalletPayUCardElementUI.a(this.kYJ, this.kYJ.kYx, editable);
            }
        });
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUCardElementUI kYJ;

            {
                this.kYJ = r1;
            }

            public final void onClick(View view) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.kYJ.kYH.get(this.kYJ.kYx.getText());
                if (payUBankcardElement == null) {
                    v.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    return;
                }
                this.kYJ.kYx.pko = 50;
                this.kYJ.uA.putParcelable("key_card_element", payUBankcardElement);
                this.kYJ.uA.putString("key_card_id", this.kYJ.kYx.getText());
                this.kYJ.uA.putString("key_cvv", this.kYJ.kYz.getText());
                this.kYJ.uA.putString("key_expire_data", this.kYJ.kYy.getText());
                this.kYJ.bLD().j(new Object[0]);
            }
        });
        ((TextView) findViewById(2131758532)).setText(q.bLl());
        this.kYC = (TextView) findViewById(2131758531);
        c.a(this, this.kYC);
    }

    public void onResume() {
        super.onResume();
        this.kYD.bhB();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof NetScenePayUElementQuery) {
            this.kYH.put(((NetScenePayUElementQuery) kVar).kYp, (PayUBankcardElement) this.uA.getParcelable("key_card_element"));
            this.kYD.bhB();
            this.kYI.remove(((NetScenePayUElementQuery) kVar).kYp);
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                return false;
            }
            this.kYx.pko = 0;
            return false;
        }
    }

    protected final int getLayoutId() {
        return 2130904153;
    }

    public final void fc(boolean z) {
    }

    protected final boolean beY() {
        return true;
    }
}
