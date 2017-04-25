package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.bind.a.c;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private PayInfo imN = new PayInfo();
    private boolean kHc = false;
    private String kHd;
    private int kHe = -1;
    private com.tencent.mm.plugin.wallet_core.b.a kHf = null;
    private boolean kHg = false;
    private String token = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gQ(580);
        ql qlVar = new ql();
        qlVar.bpT = new Runnable(this) {
            final /* synthetic */ WalletBindUI kHh;

            {
                this.kHh = r1;
            }

            public final void run() {
                if (!this.kHh.kHg) {
                    this.kHh.beI();
                }
                this.kHh.kHg = true;
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qlVar);
        n.dB(6, 0);
    }

    private void beI() {
        this.kHd = getIntent().getStringExtra("key_import_key");
        this.kHe = getIntent().getIntExtra("key_bind_scene", -1);
        this.imN.bkr = this.kHe;
        this.uA.putParcelable("key_pay_info", this.imN);
        if (this.kHe == 2) {
            if (be.kS(this.kHd)) {
                rI("");
                return;
            }
            v.d("MicroMsg.WalletBindUI", "importKey " + this.kHd);
            p(new c(this.kHd, this.imN));
        } else if (this.kHe == 4) {
            if (getIntent() == null) {
                rI("");
                return;
            }
            this.kHf = new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"));
            p(this.kHf);
        } else if (this.kHe == 6) {
            beK();
        } else {
            beJ();
        }
    }

    private void beJ() {
        v.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + be.bur().toString());
        Bundle bundle = this.uA;
        bundle.putParcelable("key_pay_info", this.imN);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        k.beN();
        if (k.beO().bgu()) {
            v.i("MicroMsg.WalletBindUI", "user status invalid");
            p(new l(null));
            return;
        }
        k.beN();
        if (k.beO().bgv()) {
            v.i("MicroMsg.WalletBindUI", "user status reg");
            this.kHc = true;
            this.imN.bkr = this.kHe;
            bundle.putInt("key_bind_scene", this.imN.bkr);
            if (!be.kS(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle, null);
            return;
        }
        v.i("MicroMsg.WalletBindUI", "user status unreg");
        this.kHc = true;
        if (this.kHe >= 0) {
            this.imN.bkr = this.kHe;
        } else {
            this.imN.bkr = 1;
        }
        bundle.putInt("key_bind_scene", this.imN.bkr);
        com.tencent.mm.wallet_core.a.a(this, b.class, bundle, null);
    }

    private void beK() {
        k.beN();
        if (k.beO().bgu()) {
            p(new l(null));
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!be.kS(str) && split.length >= 2) {
            String str2 = null;
            str = null;
            for (String str3 : split) {
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
            }
            if (!(be.kS(str) || be.kS(str2))) {
                k.beN();
                if (k.beO().Dd(str2)) {
                    Bundle bundle = new Bundle();
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a(this, "WXCreditOpenProcess", bundle, null);
                    return;
                }
            }
        }
        finish();
    }

    public void onResume() {
        if (this.kHc) {
            finish();
        }
        super.onResume();
    }

    public void onDestroy() {
        gR(580);
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof c) {
            this.kHc = true;
        }
        if (i != 0 || i2 != 0) {
            rI(str);
            return true;
        } else if (kVar instanceof l) {
            if (this.kHe == 6) {
                beK();
            } else {
                beI();
            }
            return true;
        } else if (kVar instanceof c) {
            c cVar = (c) kVar;
            Bundle bundle = this.uA;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.kFq == null || cVar.kFq.size() <= 0) {
                if (be.kS(str)) {
                    str = getString(2131236051);
                }
                g.a(this, str, null, false, new OnClickListener(this) {
                    final /* synthetic */ WalletBindUI kHh;

                    {
                        this.kHh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kHh.finish();
                    }
                });
            } else {
                Bankcard bankcard = (Bankcard) cVar.kFq.get(0);
                if (bankcard.kNC) {
                    g.a(this, 2131236102, 0, false, new OnClickListener(this) {
                        final /* synthetic */ WalletBindUI kHh;

                        {
                            this.kHh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kHh.finish();
                        }
                    });
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.kGm);
                    bundle.putString("key_recommand_desc", cVar.kGn);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.kHc = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a(this, b.class, bundle, new com.tencent.mm.wallet_core.b.a(this) {
                        final /* synthetic */ WalletBindUI kHh;

                        {
                            this.kHh = r1;
                        }

                        public final Intent e(int i, Bundle bundle) {
                            return new Intent(this.kHh.nDR.nEl, WalletBankcardManageUI.class);
                        }
                    });
                }
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) || this.kHf == null || !this.kHf.equals(kVar)) {
            return false;
        } else {
            this.token = ((com.tencent.mm.plugin.wallet_core.b.a) kVar).axY();
            beJ();
            return true;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.kHc);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.kHc = bundle.getBoolean("key_is_jump", false);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final boolean ayM() {
        return false;
    }

    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            return;
        }
        super.onNewIntent(intent);
        v.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            v.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            v.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
    }

    private void rI(String str) {
        if (be.kS(str)) {
            str = getString(2131236492);
        }
        g.a(this, str, null, false, new OnClickListener(this) {
            final /* synthetic */ WalletBindUI kHh;

            {
                this.kHh = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kHh.finish();
            }
        });
    }

    protected final int NO() {
        return 1;
    }
}
