package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.wallet_core.b.d;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView kVN;
    private List<el> kVO;
    public boolean kVP = false;

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        walletSwitchVerifyPhoneUI.uA.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.uA.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.k(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.uA);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, el elVar) {
        Parcelable bankcard = new Bankcard();
        bankcard.field_bindSerial = elVar.hMu;
        bankcard.field_mobile = elVar.kLp;
        bankcard.field_bankcardType = elVar.hMt;
        bankcard.field_desc = elVar.kNS;
        v.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", new Object[]{bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName});
        walletSwitchVerifyPhoneUI.uA.putParcelable("key_bankcard", bankcard);
        if (k.bgi().Da(bankcard.field_bankcardType) != null) {
            v.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.beQ();
            return;
        }
        walletSwitchVerifyPhoneUI.b(new com.tencent.mm.plugin.wallet_core.b.k("", "", null), true);
    }

    public void onCreate(Bundle bundle) {
        overridePendingTransition(2130968646, 2130968589);
        super.onCreate(bundle);
        Fd(getString(2131236483));
        NI();
        this.kVP = this.uA.getBoolean("key_block_bind_new_card", false);
        if (!this.kVP) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.nDR.nEl);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(2131236479), null);
            this.kVN.a(switchPhoneItemView, -1);
        }
        gQ(1667);
        gQ(461);
        gQ(1505);
        j(new d(bLx()));
    }

    protected final void NI() {
        this.kVN = (SwitchPhoneItemGroupView) findViewById(2131760034);
        this.kVN.kWE = new SwitchPhoneItemGroupView.a(this) {
            final /* synthetic */ WalletSwitchVerifyPhoneUI kVQ;

            {
                this.kVQ = r1;
            }

            public final void cn(View view) {
                if (view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    v.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[]{Integer.valueOf(intValue)});
                    if (intValue == -1) {
                        v.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                        WalletSwitchVerifyPhoneUI.a(this.kVQ);
                        return;
                    }
                    el elVar = (el) this.kVQ.kVO.get(intValue);
                    this.kVQ.uA.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    v.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[]{Boolean.valueOf(elVar.mfr.equals("wx"))});
                    this.kVQ.bLD().j(elVar);
                }
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();
        gR(1667);
        gR(461);
        gR(1505);
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                this.kVO = ((d) kVar).kLi.mws;
                Collections.sort(this.kVO, new Comparator<el>(this) {
                    final /* synthetic */ WalletSwitchVerifyPhoneUI kVQ;

                    {
                        this.kVQ = r1;
                    }

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        el elVar = (el) obj;
                        el elVar2 = (el) obj2;
                        if (elVar.mfr.equals("wx") && elVar2.mfr.equals("cft")) {
                            return -1;
                        }
                        return (elVar.mfr.equals("cft") && elVar2.mfr.equals("wx")) ? 1 : 0;
                    }
                });
                if (this.kVO == null || this.kVO.isEmpty()) {
                    v.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.kVO.size() - 1; size >= 0; size--) {
                        final el elVar = (el) this.kVO.get(size);
                        if (elVar.mfr.equals("cft")) {
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.nDR.nEl);
                            String string = elVar.mfs.equals("1") ? getString(2131236482) : getString(2131236481);
                            Object string2 = getString(2131236480, new Object[]{elVar.kNS, string, elVar.mft});
                            if (this.kVP) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(2131236485);
                                g gVar = new g(this);
                                String str2 = string2 + "，";
                                gVar.sc = getResources().getColor(2131689552);
                                spannableString = new SpannableString(str2 + string3);
                                spannableString.setSpan(gVar, str2.length(), str2.length() + string3.length(), 33);
                                gVar.kTx = new g.a(this) {
                                    final /* synthetic */ WalletSwitchVerifyPhoneUI kVQ;

                                    public final void onClick(View view) {
                                        v.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.a(this.kVQ, elVar);
                                    }
                                };
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(elVar.kLp, spannableString);
                            this.kVN.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.nDR.nEl);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(elVar.kLp, getString(2131236486));
                            this.kVN.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.k) {
                beQ();
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904686;
    }

    protected final boolean beY() {
        return true;
    }

    private void beQ() {
        v.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.uA.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
        Object Da = k.bgi().Da(bankcard.field_bankcardType);
        this.uA.putParcelable("elemt_query", Da);
        authen.hMt = bankcard.field_bankcardType;
        authen.hMu = bankcard.field_bindSerial;
        bankcard.field_bankPhone = Da.kOe;
        this.uA.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.uA.putBoolean("key_is_changing_balance_phone_num", true);
        this.uA.putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.k(this, this.uA);
    }
}
