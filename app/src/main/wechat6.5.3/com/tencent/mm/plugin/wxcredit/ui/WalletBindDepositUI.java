package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletBindDepositUI extends WalletBaseUI {
    private Button kHi;
    private ElementQuery kMo = new ElementQuery();
    private WalletFormView kRX;
    private WalletFormView kSr;
    private WalletFormView lwo;
    private boolean lwp = true;

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        if (!walletBindDepositUI.kRX.Ou()) {
            s.makeText(walletBindDepositUI, 2131236086, 0).show();
            return false;
        } else if (!walletBindDepositUI.kSr.Ou()) {
            s.makeText(walletBindDepositUI, 2131236066, 0).show();
            return false;
        } else if (walletBindDepositUI.lwo.Ou()) {
            return true;
        } else {
            s.makeText(walletBindDepositUI, 2131236106, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904601;
    }

    public final void NI() {
        vD(2131236050);
        this.kRX = (WalletFormView) findViewById(2131759759);
        a.a(this.kRX);
        this.kSr = (WalletFormView) findViewById(2131759760);
        this.lwo = (WalletFormView) findViewById(2131759761);
        a.c(this, this.lwo);
        this.kHi = (Button) findViewById(2131756365);
        d(this.kRX, 0, false);
        d(this.lwo, 0, false);
        this.kSr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBindDepositUI lwq;

            {
                this.lwq = r1;
            }

            public final void onClick(View view) {
                if (!be.kS(this.lwq.kRX.getText())) {
                    if (this.lwq.lwp) {
                        this.lwq.bLD().p(r0);
                        this.lwq.lwp = false;
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_support_bankcard", 1);
                    bundle.putString("key_bank_type", this.lwq.kMo.hMt);
                    bundle.putInt("key_bankcard_type", 1);
                    com.tencent.mm.wallet_core.a.ae(this.lwq).a(this.lwq, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.kHi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBindDepositUI lwq;

            {
                this.lwq = r1;
            }

            public final void onClick(View view) {
                if (WalletBindDepositUI.e(this.lwq)) {
                    this.lwq.bLD().j(this.lwq.kRX.getText(), this.lwq.kMo.hMt, this.lwq.lwo.getText(), this.lwq.kMo.kOe, Boolean.valueOf(false));
                }
            }
        });
    }

    private void av() {
        if (be.kS(this.kMo.kNS)) {
            this.kSr.setText("");
        } else if (2 == this.kMo.kOb) {
            this.kSr.setText(this.kMo.kNS + " " + getString(2131236153));
        } else {
            this.kSr.setText(this.kMo.kNS + " " + getString(2131236167));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    if (elementQuery.bfM()) {
                        this.kMo = elementQuery;
                        av();
                        return;
                    }
                    g.f(this, 2131236048, 2131231164);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
            com.tencent.mm.plugin.wallet_core.b.k kVar2 = (com.tencent.mm.plugin.wallet_core.b.k) kVar;
            if (kVar2.kLs != null) {
                if (kVar2.kLs.bfM()) {
                    this.kMo = kVar2.kLs;
                    av();
                    if (this.kMo.kNZ && this.kMo.isError()) {
                        g.f(this, 2131236023, 2131231164);
                        return true;
                    }
                    b ae = com.tencent.mm.wallet_core.a.ae(this);
                    if (ae != null) {
                        int i3 = this.kMo.kLu;
                        if (ae != null) {
                            if (ae.fNM.containsKey("key_support_bankcard")) {
                                int bKU = ae.bKU();
                                z = bKU == 0 ? true : Bankcard.cI(bKU, i3);
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (ae.bKV()) {
                                v.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                g.f(this, 2131235979, 2131231164);
                            } else {
                                v.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                g.f(this, 2131235978, 2131231164);
                            }
                            this.kRX.aJx();
                            return true;
                        }
                    }
                    av();
                    return true;
                }
                g.f(this, 2131236048, 2131231164);
                return true;
            }
        }
        return false;
    }

    protected final int NO() {
        return 1;
    }
}
