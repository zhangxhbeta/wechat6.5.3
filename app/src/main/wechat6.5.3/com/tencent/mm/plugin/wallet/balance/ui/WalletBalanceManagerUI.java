package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet.balance.a;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.t;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

public class WalletBalanceManagerUI extends WalletBaseUI implements g {
    protected int cVh;
    protected TextView kFP;
    protected Button kFQ;
    protected View kFR;
    protected View kFS;
    protected TextView kFT;
    protected Bankcard kFU;
    protected TextView kFw;

    static /* synthetic */ void b(WalletBalanceManagerUI walletBalanceManagerUI) {
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.uA.get("key_pay_info");
        PayInfo payInfo = new PayInfo();
        payInfo.bkq = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", a.kFg);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, a.class, bundle, null);
    }

    protected final int getLayoutId() {
        return 2130904607;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.pluginsdk.g.a.O(this);
        this.cVh = getIntent().getIntExtra("key_scene_balance_manager", 0);
        gQ(621);
        k.bgh();
        v.a(this);
        NI();
        n.dB(2, 0);
        com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(6), Integer.valueOf(0)});
        e.yD(10);
    }

    public void bey() {
        boolean z;
        com.tencent.mm.plugin.wallet.a.k.beN();
        if (com.tencent.mm.plugin.wallet.a.k.beO().kFU == null) {
            z = true;
        } else {
            z = false;
        }
        b(new l(null, 0), z);
    }

    public void onDestroy() {
        gR(621);
        k.bgh();
        v.b(this);
        super.onDestroy();
    }

    public void bez() {
        q(WalletBalanceSaveUI.class);
    }

    protected final void NI() {
        vD(2131236004);
        this.kFP = (TextView) findViewById(2131759782);
        this.kFw = (TextView) findViewById(2131759773);
        ((Button) findViewById(2131756365)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceManagerUI kFV;

            {
                this.kFV = r1;
            }

            public final void onClick(View view) {
                this.kFV.bez();
                e.yD(14);
            }
        });
        this.kFQ = (Button) findViewById(2131759783);
        this.kFQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceManagerUI kFV;

            {
                this.kFV = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet.a.k.beN();
                ArrayList bgH = com.tencent.mm.plugin.wallet.a.k.beO().bgH();
                if (bgH == null || bgH.size() == 0) {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                    com.tencent.mm.ui.base.g.a(this.kFV, false, this.kFV.getString(2131235998), "", this.kFV.getString(2131235997), this.kFV.getString(2131231010), new DialogInterface.OnClickListener(this.kFV) {
                        final /* synthetic */ WalletBalanceManagerUI kFV;

                        {
                            this.kFV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            WalletBalanceManagerUI.b(this.kFV);
                        }
                    }, new DialogInterface.OnClickListener(this.kFV) {
                        final /* synthetic */ WalletBalanceManagerUI kFV;

                        {
                            this.kFV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
                com.tencent.mm.wallet_core.a.a(this.kFV, b.class, null, null);
                e.yD(15);
            }
        });
        TextView textView = (TextView) findViewById(2131759787);
        if (!u.bsY().equals("zh_CN") ? true : be.He()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI kFV;

                {
                    this.kFV = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                    c.b(this.kFV, "webview", ".ui.tools.WebViewUI", intent);
                    e.yD(17);
                }
            });
            textView.setVisibility(0);
        }
        ((TextView) findViewById(2131759788)).setText(q.bLl());
        this.kFR = findViewById(2131759784);
        this.kFT = (TextView) findViewById(2131759786);
        this.kFS = findViewById(2131759785);
        final qk qkVar = new qk();
        qkVar.brG.brI = "2";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ WalletBalanceManagerUI kFV;

            public final void run() {
                if (!be.kS(qkVar.brH.brJ)) {
                    e.a(this.kFV.kFw, qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    public void onResume() {
        av();
        bey();
        super.onResume();
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bmN());
    }

    public final void av() {
        boolean z;
        com.tencent.mm.plugin.wallet.a.k.beN();
        this.kFU = com.tencent.mm.plugin.wallet.a.k.beO().kFU;
        if (this.kFU != null) {
            if (this.kFU.kNv >= 0.0d) {
                this.kFP.setText(e.l(this.kFU.kNv));
            } else {
                this.kFP.setText(getString(2131236194));
            }
            com.tencent.mm.plugin.wallet.a.k.beN();
            if ((com.tencent.mm.plugin.wallet.a.k.beO().bgz().kQP & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.plugin.wallet.a.k.beO().bgz().kQP)});
            int i = (!z || this.kFU.kNv <= 0.0d) ? 0 : 1;
            if (i != 0) {
                this.kFQ.setVisibility(0);
            } else {
                this.kFQ.setVisibility(8);
            }
            beA();
        }
        if ((new z().kQP & 32768) > 0) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(new z().kQP)});
        if (z) {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(t.a.nsK, getString(2131234343));
            this.kFR.setVisibility(0);
            this.kFT.setTextColor(getResources().getColor(2131690094));
            this.kFT.setText(str);
            this.kFS.setVisibility(8);
            this.kFR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI kFV;

                {
                    this.kFV = r1;
                }

                public final void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("real_name_verify_mode", 0);
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
                    bundle.putInt("entry_scene", 1009);
                    com.tencent.mm.wallet_core.a.a(this.kFV, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                }
            });
            return;
        }
        com.tencent.mm.plugin.wallet.a.k.beN();
        final ab beO = com.tencent.mm.plugin.wallet.a.k.beO();
        if (beO != null) {
            if ((beO.bgz().kQP & 1024) > 0) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(beO.bgz().kQP)});
            if (!(!z || TextUtils.isEmpty(beO.bgD()) || TextUtils.isEmpty(beO.bgE()))) {
                this.kFR.setVisibility(0);
                this.kFT.setText(beO.bgD());
                this.kFS.setVisibility(0);
                this.kFR.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletBalanceManagerUI kFV;

                    public final void onClick(View view) {
                        e.l(this.kFV, beO.bgE(), true);
                    }
                });
                return;
            }
        }
        this.kFR.setVisibility(8);
    }

    private void beA() {
        com.tencent.mm.plugin.wallet.a.k.beN();
        com.tencent.mm.plugin.wallet.a.k.beO();
        String str = this.kFU.field_bindSerial;
        if (!be.kS(this.kFU.kNy)) {
            a(0, getString(2131236000), new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI kFV;

                {
                    this.kFV = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.kFV.kFU.kNy);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                    intent.putExtra("KPublisherId", "pay_blance_list");
                    intent.putExtra("geta8key_scene", 33);
                    c.b(this.kFV, "webview", ".ui.tools.WebViewUI", intent);
                    e.yD(16);
                    return true;
                }
            });
        }
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0 && !(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (kVar instanceof l)) {
            av();
        }
        return false;
    }

    public final void mO(int i) {
        com.tencent.mm.plugin.wallet.a.k.beN();
        this.kFU = com.tencent.mm.plugin.wallet.a.k.beO().kFU;
        if (this.kFU != null) {
            if (this.kFU.kNv >= 0.0d) {
                this.kFP.setText(e.l(this.kFU.kNv));
            } else {
                this.kFP.setText(getString(2131236194));
            }
            beA();
        }
    }

    protected void onNewIntent(Intent intent) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == a.kFg) {
            com.tencent.mm.wallet_core.a.a((Activity) this, b.class, null, null);
            e.yD(15);
        }
    }
}
