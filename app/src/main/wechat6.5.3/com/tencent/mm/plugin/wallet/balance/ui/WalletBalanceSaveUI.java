package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@a(3)
public class WalletBalanceSaveUI extends WalletBaseUI {
    protected WalletFormView eWC;
    protected Button fzj;
    public double irZ;
    private ArrayList<Bankcard> kFq;
    protected Bankcard kFr;
    private String kFs;
    public WalletFormView kFu;

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                boolean a;
                c cVar = (c) kVar;
                if ("1".equals(cVar.brU)) {
                    v.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, cVar.brV, cVar.brW, cVar.brX, bundle, ayJ(), null, 0, 2);
                } else if ("2".equals(cVar.brU)) {
                    v.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, cVar.brV, cVar.brY, cVar.brW, cVar.brX, ayJ(), null);
                } else {
                    v.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + cVar.brU);
                    a = false;
                }
                if (!a) {
                    String str2 = ((c) kVar).bfr;
                    String str3 = this.kFr == null ? "" : this.kFr.field_bindSerial;
                    String str4 = "";
                    if (!be.kS(str2)) {
                        e.a(this, true, str3, e.a(str2, str4, null, null, 11, 0), 1);
                    }
                }
            } else if (kVar instanceof l) {
                beu();
                av();
            }
        }
        return false;
    }

    private void beu() {
        com.tencent.mm.plugin.wallet.a.k.beN();
        ab beO = com.tencent.mm.plugin.wallet.a.k.beO();
        this.kFq = beO.bgH();
        this.kFr = beO.a(this.kFq, null, false, true);
    }

    protected final int getLayoutId() {
        return 2130904609;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.tencent.mm.model.k.xT()) {
            b(new l(null, 3), false);
        }
        beu();
        this.kFs = getString(2131236017);
        NI();
        av();
        n.dB(3, 0);
    }

    protected final void NI() {
        vD(2131236021);
        this.eWC = (WalletFormView) findViewById(2131756361);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.eWC);
        this.eWC.eXB.setText(String.format(getString(2131236019), new Object[]{q.bLm()}));
        d(this.eWC, 2, false);
        this.fzj = (Button) findViewById(2131756365);
        this.fzj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceSaveUI kGc;

            {
                this.kGc = r1;
            }

            public final void onClick(View view) {
                this.kGc.irZ = be.getDouble(this.kGc.eWC.getText(), 0.0d);
                if (this.kGc.irZ <= 0.0d || !this.kGc.eWC.Ou()) {
                    s.makeText(this.kGc.nDR.nEl, 2131236020, 0).show();
                } else {
                    this.kGc.beD();
                }
            }
        });
        this.kFu = (WalletFormView) findViewById(2131759776);
        if (this.kFu != null) {
            com.tencent.mm.wallet_core.ui.formview.a.g(this.kFu);
            this.kFu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceSaveUI kGc;

                {
                    this.kGc = r1;
                }

                public final void onClick(View view) {
                    ActionBarActivity actionBarActivity = this.kGc.nDR.nEl;
                    h.a(actionBarActivity, this.kGc.kFq, this.kGc.kFs, actionBarActivity.getString(2131236022), this.kGc.kFr, new g.a(this) {
                        final /* synthetic */ AnonymousClass2 kGd;

                        {
                            this.kGd = r1;
                        }

                        public final void oI(int i) {
                            if (this.kGd.kGc.kFq == null || i < 0 || i >= this.kGd.kGc.kFq.size()) {
                                this.kGd.kGc.kFr = null;
                            } else {
                                this.kGd.kGc.kFr = (Bankcard) this.kGd.kGc.kFq.get(i);
                            }
                            this.kGd.kGc.av();
                        }
                    });
                }
            });
        }
    }

    private void av() {
        if (this.kFu == null) {
            return;
        }
        if (this.kFr != null) {
            this.kFu.setText(this.kFr.field_desc);
            if (be.kS(this.kFr.field_avail_save_wording)) {
                v.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                this.kFu.ioB.setText("");
                return;
            }
            this.kFu.ioB.setText(this.kFr.field_avail_save_wording);
            return;
        }
        this.kFu.setText(this.kFs);
        this.kFu.ioB.setText("");
    }

    public void beD() {
        if (this.kFr != null) {
            j(new c(this.irZ, "CNY", this.kFr.field_bindSerial, this.kFr.field_bankcardType));
        } else {
            j(new c(this.irZ, "CNY", "", ""));
        }
    }

    protected final int NO() {
        return 1;
    }
}
