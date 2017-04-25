package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.e.a.ql.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.ui.e;

public class MallIndexUI extends MallIndexBaseUI {
    b hji;
    private boolean hjj = false;

    static /* synthetic */ void b(MallIndexUI mallIndexUI) {
        if (k.bga().bgz().bgr()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
            v.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[]{intent.getStringExtra("rawUrl")});
            c.b(mallIndexUI, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        a.b(mallIndexUI, "PayUShowOrderProcess", null);
    }

    static /* synthetic */ boolean b(MallIndexUI mallIndexUI, b bVar) {
        if (mallIndexUI.hjj) {
            v.i("MicorMsg.MallIndexUI", "isDoRealname bye bye");
            return true;
        } else if ("1".equals(bVar.brU)) {
            v.i("MicorMsg.MallIndexUI", "need realname verify");
            mallIndexUI.hjj = true;
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".mall.ui.WalletBalanceSaveUI");
            bundle.putString("realname_verify_process_jump_plugin", "mall");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(mallIndexUI, bVar.brV, bVar.brW, bVar.brX, bundle, mallIndexUI.ayJ(), null, 0, 2);
        } else if ("2".equals(bVar.brU)) {
            v.i("MicorMsg.MallIndexUI", "need upload credit");
            mallIndexUI.hjj = true;
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(mallIndexUI, bVar.brV, bVar.brY, bVar.brW, bVar.brX, mallIndexUI.ayJ(), null);
        } else {
            v.i("MicorMsg.MallIndexUI", "realnameGuideFlag =  " + bVar.brU);
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.g.a.O(this);
        f.g(this, 2);
        this.hji = new b();
        this.hji.brM = false;
        this.hji.brN = true;
        this.hji.brO = false;
        super.onCreate(bundle);
    }

    protected final void ayG() {
        vD(2131233736);
    }

    protected final void bU(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2131758043);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2131758039);
        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(2131758035);
        this.hiP = (TextView) view.findViewById(2131758042);
        relativeLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI hjk;

            {
                this.hjk = r1;
            }

            public final void onClick(View view) {
                MallIndexUI mallIndexUI = this.hjk;
                if (com.tencent.mm.model.k.xT()) {
                    c.w(mallIndexUI, "wallet_payu", ".bind.ui.WalletPayUBankcardManageUI");
                } else {
                    c.w(mallIndexUI, "wallet", ".bind.ui.WalletBankcardManageUI");
                }
                e.yD(5);
            }
        });
        relativeLayout2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI hjk;

            {
                this.hjk = r1;
            }

            public final void onClick(View view) {
                Intent intent;
                if (com.tencent.mm.model.k.xT()) {
                    intent = new Intent();
                    intent.putExtra("key_scene_balance_manager", 2);
                    c.b(this.hjk, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("key_scene_balance_manager", 2);
                    c.b(this.hjk, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                }
                e.yD(11);
            }
        });
        relativeLayout3.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallIndexUI hjk;

            {
                this.hjk = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 1);
                c.b(this.hjk.nDR.nEl, "offline", ".ui.WalletOfflineEntranceUI", intent);
                n.dB(9, 0);
                g.iuh.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
            }
        });
        this.hiN = (ImageView) findViewById(2131758044);
        this.hiO = (ImageView) view.findViewById(2131758046);
        ayU();
    }

    protected final void ayP() {
        final qk qkVar = new qk();
        qkVar.brG.brI = "1";
        qkVar.bpT = new Runnable(this) {
            final /* synthetic */ MallIndexUI hjk;

            public final void run() {
                if (!be.kS(qkVar.brH.brJ)) {
                    e.a(this.hjk.hiQ, qkVar.brH.brJ, qkVar.brH.content, qkVar.brH.url);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.z(qkVar);
    }

    protected final boolean ayK() {
        v.i("MicorMsg.MallIndexUI", "init BankcardList");
        final ql qlVar = new ql();
        qlVar.bpT = new Runnable(this) {
            final /* synthetic */ MallIndexUI hjk;

            public final void run() {
                v.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + this.hjk.hji.brN + " hasNewTips : " + this.hjk.hji.brO + " swipeOn : " + this.hjk.hji.brP);
                this.hjk.hji = qlVar.brL;
                if (this.hjk.hji.errCode == 0) {
                    this.hjk.ayU();
                    this.hjk.ayQ();
                    MallIndexUI mallIndexUI = this.hjk;
                    v.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
                    if (mallIndexUI.hji == null || !(mallIndexUI.hji.brM || mallIndexUI.hji.brS)) {
                        v.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
                    } else {
                        boolean bgq = k.bga().bgz().bgq();
                        ak.yW();
                        Object obj = com.tencent.mm.model.c.vf().get(t.a.nrO, Boolean.valueOf(false));
                        boolean booleanValue = obj != null ? ((Boolean) obj).booleanValue() : false;
                        v.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + booleanValue + ";isswc=" + bgq);
                        if (!booleanValue && bgq) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(t.a.nrO, Boolean.valueOf(true));
                            com.tencent.mm.ui.base.g.a(mallIndexUI, mallIndexUI.getString(2131233737), null, true, null);
                        }
                    }
                    MallIndexUI.b(this.hjk, this.hjk.hji);
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(qlVar, Looper.myLooper());
        return false;
    }

    protected final void ayU() {
        if (this.hiO != null) {
            if (!this.hji.brO) {
                int i;
                h hVar = k.bga().kQT;
                if (hVar != null) {
                    int i2 = hVar.field_red_dot_index;
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(t.a.nrk, Integer.valueOf(-1))).intValue() >= i2 || i2 <= 0) {
                        v.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
                    } else {
                        v.i("MicorMsg.MallIndexUI", "bankcard need red point");
                        i = 1;
                        if (i == 0) {
                            this.hiO.setVisibility(8);
                            return;
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    this.hiO.setVisibility(8);
                    return;
                }
            }
            this.hiO.setVisibility(0);
        }
    }

    protected final void ayQ() {
        v.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[]{Boolean.valueOf((new z().kQP & 16384) > 0), Integer.valueOf(new z().kQP)});
        if ((new z().kQP & 16384) > 0) {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(t.a.nsL, getString(2131234342));
            this.hiP.setTextColor(getResources().getColor(2131689856));
            this.hiP.setText(str);
            return;
        }
        this.hiP.setTextColor(getResources().getColor(2131689855));
        Bankcard bankcard = k.bga().kFU;
        if (bankcard == null || bankcard.kNv < 0.0d) {
            this.hiP.setText(getString(2131236194));
        } else {
            this.hiP.setText(e.l(bankcard.kNv));
        }
    }

    protected final void ayS() {
        this.nDR.bAi();
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexUI hjk;

            {
                this.hjk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                if (com.tencent.mm.model.k.xT()) {
                    if (this.hjk.hji.brM) {
                        stringArray = this.hjk.getResources().getStringArray(2131296258);
                    } else {
                        stringArray = this.hjk.getResources().getStringArray(2131296260);
                    }
                } else if (this.hjk.hji.brM) {
                    if (this.hjk.hji.brT) {
                        stringArray = this.hjk.getResources().getStringArray(2131296261);
                    } else {
                        stringArray = this.hjk.getResources().getStringArray(2131296257);
                    }
                } else if (this.hjk.hji.brS && this.hjk.hji.brT) {
                    stringArray = this.hjk.getResources().getStringArray(2131296262);
                } else {
                    stringArray = this.hjk.getResources().getStringArray(2131296259);
                }
                com.tencent.mm.ui.base.g.a(this.hjk.nDR.nEl, null, stringArray, null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass6 hjm;

                    {
                        this.hjm = r1;
                    }

                    public final void gT(int i) {
                        if (com.tencent.mm.model.k.xT()) {
                            if (this.hjm.hjk.hji.brM) {
                                switch (i) {
                                    case 0:
                                        MallIndexUI.b(this.hjm.hjk);
                                        return;
                                    case 1:
                                        this.hjm.hjk.ayO();
                                        return;
                                    case 2:
                                        this.hjm.hjk.ayT();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            switch (i) {
                                case 0:
                                    MallIndexUI.b(this.hjm.hjk);
                                    return;
                                case 1:
                                    this.hjm.hjk.ayT();
                                    return;
                                default:
                                    return;
                            }
                        } else if (this.hjm.hjk.hji.brM) {
                            if (this.hjm.hjk.hji.brT) {
                                this.hjm.hjk.mQ(i);
                            } else {
                                this.hjm.hjk.mR(i);
                            }
                        } else if (this.hjm.hjk.hji.brS && this.hjm.hjk.hji.brT) {
                            this.hjm.hjk.mP(i);
                        } else {
                            switch (i) {
                                case 0:
                                    MallIndexUI.y(this.hjm.hjk);
                                    return;
                                case 1:
                                    this.hjm.hjk.ayO();
                                    e.yD(21);
                                    return;
                                case 2:
                                    e.eT(this.hjm.hjk);
                                    e.yD(21);
                                    return;
                                case 3:
                                    this.hjm.hjk.ayT();
                                    e.yD(23);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                });
                return true;
            }
        });
    }

    public void onResume() {
        com.tencent.mm.pluginsdk.g.a.a(this, com.tencent.mm.pluginsdk.g.b.bmN());
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void ayH() {
        com.tencent.mm.plugin.mall.b.a.ayW();
    }

    protected final void ayI() {
        if ((k.bfX().bgT() == null || k.bfX().bgT().bgt() || k.bfX().bgT().bgs()) && com.tencent.mm.model.k.xT()) {
            v.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
            p(new com.tencent.mm.plugin.wallet_core.b.b.a("", false));
        }
    }
}
