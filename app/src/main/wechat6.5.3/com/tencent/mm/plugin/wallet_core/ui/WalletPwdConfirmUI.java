package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.e.a.qq;
import com.tencent.mm.e.a.qr;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletPwdConfirmUI extends WalletBaseUI {
    private c bYn = new c<qq>(this) {
        final /* synthetic */ WalletPwdConfirmUI kUM;

        {
            this.kUM = r2;
            this.nhz = qq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((qq) bVar) instanceof qq) {
                v.d("Micromsg.WalletPwdConfirmUI", "event WalletPwdConfirmDoSecondaryProgressCallbackEvent");
                this.kUM.kUK = false;
                this.kUM.bhf();
            }
            return false;
        }
    };
    private PayInfo kIA;
    public EditHintPasswdView kTr;
    private TextView kUJ;
    private boolean kUK = false;
    private ah kUL = new ah(new ah.a(this) {
        final /* synthetic */ WalletPwdConfirmUI kUM;

        {
            this.kUM = r1;
        }

        public final boolean oU() {
            if (this.kUM.kUK) {
                this.kUM.kUK = false;
                this.kUM.bhf();
            }
            return false;
        }
    }, false);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fd(q.eR(this));
        this.kIA = (PayInfo) this.uA.getParcelable("key_pay_info");
        NI();
        com.tencent.mm.plugin.wallet_core.d.c.a(this, this.uA, 6);
    }

    protected final void NI() {
        ((TextView) findViewById(2131760026)).setText(k.xT() ? getString(2131236285) : getString(2131236284));
        this.kUJ = (TextView) findViewById(2131760029);
        if (be.D(nK(0))) {
            this.kUJ.setText(2131231065);
        } else {
            this.kUJ.setText(2131236475);
        }
        this.kUJ.setVisibility(0);
        this.kUJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPwdConfirmUI kUM;

            {
                this.kUM = r1;
            }

            public final void onClick(View view) {
                String string = this.kUM.uA.getString("key_new_pwd1");
                String bLI = this.kUM.kTr.bLI();
                String string2 = this.kUM.uA.getString("kreq_token");
                String string3 = this.kUM.uA.getString("key_verify_code");
                v.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + this.kUM.kIA + " vertifyCode: " + string3);
                if (string == null || !string.equals(bLI)) {
                    com.tencent.mm.wallet_core.a.i(this.kUM, -1002);
                    return;
                }
                l lVar = new l();
                lVar.kQj = this.kUM.kTr.getText();
                lVar.imN = this.kUM.kIA;
                lVar.token = string2;
                lVar.kQk = string3;
                lVar.kQl = this.kUM.uA.getBoolean("key_is_bind_bankcard", true);
                if (com.tencent.mm.wallet_core.a.ae(this.kUM).bKV()) {
                    lVar.flag = "4";
                } else {
                    lVar.flag = "1";
                }
                FavorPayInfo favorPayInfo = (FavorPayInfo) this.kUM.uA.getParcelable("key_favor_pay_info");
                if (favorPayInfo != null) {
                    lVar.kNd = favorPayInfo.kOy;
                    lVar.kNe = favorPayInfo.kOv;
                }
                this.kUM.bLD().j(lVar);
            }
        });
        this.kUJ.setEnabled(false);
        this.kUJ.setClickable(false);
        this.kTr = (EditHintPasswdView) findViewById(2131758506);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kTr);
        this.kTr.pkg = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletPwdConfirmUI kUM;

            {
                this.kUM = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    String string = this.kUM.uA.getString("key_new_pwd1");
                    String bLI = this.kUM.kTr.bLI();
                    if (string == null || !string.equals(bLI)) {
                        com.tencent.mm.wallet_core.a.i(this.kUM, -1002);
                        return;
                    }
                    this.kUM.kUJ.setEnabled(z);
                    this.kUM.kUJ.setClickable(z);
                    return;
                }
                this.kUM.kUJ.setEnabled(z);
                this.kUM.kUJ.setClickable(z);
            }
        };
        findViewById(2131760027).setVisibility(8);
        d(this.kTr, 0, false);
    }

    public void onResume() {
        this.kTr.requestFocus();
        super.onResume();
        com.tencent.mm.sdk.c.a.nhr.e(this.bYn);
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.c.a.nhr.f(this.bYn);
    }

    private void bhf() {
        Bundle bundle = this.uA;
        bundle.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, bundle);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.uA.putString("key_pwd1", this.kTr.getText());
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.l) {
            if (!this.kUK) {
                bhf();
            }
        } else if (com.tencent.mm.wallet_core.a.ae(this) == null || !com.tencent.mm.wallet_core.a.ae(this).e(this, null)) {
            com.tencent.mm.wallet_core.a.k(this, this.uA);
        } else {
            p(new com.tencent.mm.plugin.wallet_core.b.l(this.kIA != null ? this.kIA.fTG : ""));
            qr qrVar = new qr();
            if (com.tencent.mm.sdk.c.a.nhr.m(qrVar.getClass())) {
                this.kUK = true;
                com.tencent.mm.sdk.c.a.nhr.z(qrVar);
            }
            this.kUL.ea(10000);
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130904684;
    }

    protected final boolean beY() {
        return true;
    }

    protected final int NO() {
        return 1;
    }
}
