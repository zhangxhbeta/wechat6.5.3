package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.i;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private f dxf;
    private boolean hasInit = false;
    private Bankcard kHr;
    private OnClickListener lwQ = new OnClickListener(this) {
        final /* synthetic */ WalletWXCreditDetailUI lwU;

        {
            this.lwU = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == 2131760053) {
                if (this.lwU.lwT != null) {
                    e.M(this.lwU, this.lwU.lwT.lwj.username);
                }
            } else if (view.getId() == 2131760054 && this.lwU.lwT != null) {
                e.l(this.lwU, this.lwU.lwT.lwi, false);
            }
        }
    };
    private b lwS;
    private k lwT;

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        Bundle bundle = walletWXCreditDetailUI.lwS.fNM;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
    }

    public final int Oo() {
        return 2131099747;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bLG().gQ(621);
        bLG().gQ(600);
        oa(4);
        this.lwS = com.tencent.mm.wallet_core.a.ae(this);
        if (this.kHr == null) {
            this.kHr = (Bankcard) this.lwS.fNM.getParcelable("key_bankcard");
        }
        if (bml()) {
            if (this.pjI == null) {
                if (this.pjG == null) {
                    this.pjG = com.tencent.mm.wallet_core.a.ae(this);
                }
                this.pjI = this.pjG.a(this, this.pjH);
            }
            if (!this.pjI.o(this.kHr)) {
                oa(0);
                NI();
            }
        }
    }

    private boolean bml() {
        if (this.kHr == null) {
            return false;
        }
        if (this.kHr.field_bankcardState == 0) {
            return true;
        }
        int i = this.kHr.field_wxcreditState;
        if (this.lwT != null) {
            i = this.lwT.lvU;
        }
        switch (i) {
            case 1:
                long ax = be.ax(com.tencent.mm.plugin.wallet_core.model.k.bga().kQW);
                v.d("MicroMsg.WalletUserInfoManger", "pass time " + ax);
                if (ax > 300) {
                    i = 1;
                } else {
                    boolean z = false;
                }
                if (i != 0) {
                    return true;
                }
                return false;
            case 3:
                g.a(this, 2131236557, -1, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletWXCreditDetailUI lwU;

                    {
                        this.lwU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.lwU.bLG().a(new i(this.lwU.kHr.field_bankcardType, this.lwU.kHr.kNr), true, true);
                    }
                });
                return false;
            case 4:
                break;
            case 5:
                this.lwS.fNM.putBoolean("key_can_unbind", false);
                break;
            default:
                return true;
        }
        if (this.lwT == null) {
            return true;
        }
        this.lwS.fNM.putString("key_repayment_url", this.lwT.lwc);
        this.lwS.a((Activity) this, 1, this.lwS.fNM);
        return false;
    }

    protected void onDestroy() {
        bLG().gR(621);
        bLG().gR(600);
        super.onDestroy();
    }

    protected final void NI() {
        this.hasInit = true;
        vD(2131236558);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditDetailUI lwU;

            {
                this.lwU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lwU.axg();
                this.lwU.finish();
                return true;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletWXCreditDetailUI lwU;

            {
                this.lwU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                List arrayList = new ArrayList();
                com.tencent.mm.plugin.wallet_core.model.k.bga();
                String str = this.lwU.kHr.field_bindSerial;
                g.a(this.lwU, null, (String[]) arrayList.toArray(new String[arrayList.size()]), this.lwU.getString(2131236208), false, new c(this) {
                    final /* synthetic */ AnonymousClass4 lwV;

                    {
                        this.lwV = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                com.tencent.mm.plugin.wallet_core.model.k.bga();
                                String str = this.lwV.lwU.kHr.field_bindSerial;
                                return;
                            case 1:
                                WalletWXCreditDetailUI.c(this.lwV.lwU);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
    }

    private void av() {
        if (!this.hasInit) {
            NI();
        }
        if (this.lwT != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.dxf.Ow("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.dtD.setText(e.l(this.lwT.lvV));
            String str = this.kHr.field_bankName;
            String str2 = this.lwT.lwh;
            walletWXCreditDetailHeaderPreference.lwR.setText(walletWXCreditDetailHeaderPreference.mContext.getString(2131236585, new Object[]{str2, str}));
        }
        if (this.lwT != null) {
            boolean z;
            this.dxf.Ow("wallet_wxcredit_total_amount").setTitle(getString(2131236559, new Object[]{e.l(this.lwT.lvP)}));
            f fVar = this.dxf;
            str2 = "wallet_wxcredit_change_amount";
            if (this.lwT.lwa) {
                z = false;
            } else {
                z = true;
            }
            fVar.aO(str2, z);
            Preference Ow = this.dxf.Ow("wallet_wxcredit_bill");
            if (this.lwT.lvW != 0.0d) {
                Ow.setSummary(e.l(this.lwT.lvW));
            }
            Ow = this.dxf.Ow("wallet_wxcredit_repayment");
            Preference Ow2 = this.dxf.Ow("wallet_wxcredit_repayment_tips");
            if (this.lwT.lvY > 0.0d) {
                Ow.setSummary(e.l(this.lwT.lvY));
                Ow2.setTitle(getString(2131236583, new Object[]{this.lwT.lwd}));
                this.dxf.aO("wallet_wxcredit_repayment_tips", false);
            } else {
                this.dxf.aO("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.kHr != null) {
            this.dxf.Ow("wallet_wxcredit_bank_name").setTitle(this.kHr.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.dxf.Ow("wallet_wxcredit_footer")).lwQ = this.lwQ;
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.kHr);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.b.class, bundle);
            return true;
        } else if ("wallet_wxcredit_bill".equals(str)) {
            if (this.lwT == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.lwT.lwg);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.lwT == null) {
                return false;
            }
            r1 = new Bundle();
            r1.putString("key_url", this.lwT.lwe);
            com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, r1);
            return false;
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.lwT == null) {
                return false;
            }
            e.l(this, this.lwT.lwf, false);
            return false;
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.lwT == null) {
                return false;
            }
            e.l(this, this.lwT.lwc, false);
            return false;
        } else if (!"wallet_wxcredit_bank_name".equals(str) || this.lwT == null) {
            return false;
        } else {
            e.L(this, this.lwT.lwj.username);
            return false;
        }
    }

    public final boolean f(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                com.tencent.mm.plugin.wallet_core.model.k.bga().kQW = System.currentTimeMillis() / 1000;
                this.lwT = ((d) kVar).lvQ;
                if (this.lwT != null && this.lwT.lvU == 2) {
                    ak.yW();
                    if (((Boolean) com.tencent.mm.model.c.vf().get(196658, Boolean.valueOf(false))).booleanValue()) {
                        b ae = com.tencent.mm.wallet_core.a.ae(this);
                        Bundle bundle = ae.fNM;
                        bundle.putDouble("key_total_amount", this.lwT.lvP);
                        bundle.putBoolean("key_can_upgrade_amount", this.lwT.lwa);
                        ae.a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        return true;
                    }
                }
                if (bml()) {
                    oa(0);
                    av();
                }
                return true;
            } else if (kVar instanceof i) {
                bLG().a(new l(null), true, true);
            } else if (kVar instanceof l) {
                finish();
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        oa(0);
        av();
        super.onActivityResult(i, i2, intent);
    }
}
