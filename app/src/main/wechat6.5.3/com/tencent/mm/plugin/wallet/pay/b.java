package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;

public class b extends com.tencent.mm.plugin.wallet_core.a.a {

    private abstract class a extends c {
        final /* synthetic */ b kIn;

        public a(b bVar, WalletBaseUI walletBaseUI, f fVar) {
            this.kIn = bVar;
            super(walletBaseUI, fVar);
        }
    }

    static /* synthetic */ String h(b bVar) {
        if (bVar.fNM != null) {
            PayInfo payInfo = (PayInfo) bVar.fNM.getParcelable("key_pay_info");
            if (payInfo != null) {
                return payInfo.fTG;
            }
        }
        return "";
    }

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.bkq);
        bundle.putInt("key_pay_channel", payInfo.bkh);
        if (!g(activity, bundle)) {
            v.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    v.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    b(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    v.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    b(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !bKV()) {
                        v.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    v.i("MicroMsg.PayProcess", "jump to result ui!");
                    h(activity, bundle);
                    break;
                    break;
                default:
                    break;
            }
        }
        v.w("MicroMsg.PayProcess", "hy: has err. return");
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (g(activity, bundle)) {
            v.i("MicroMsg.PayProcess", "deal with the err!");
            return;
        }
        int i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.fNM.getInt("key_pay_flag", 0);
        v.i("MicroMsg.PayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 1:
                v.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    b(activity, WalletPwdConfirmUI.class, bundle);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    h(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bKV()) {
                        v.i("MicroMsg.PayProcess", "oversea, set pwd");
                        b(activity, WalletSetPasswordUI.class, bundle);
                        return;
                    }
                    v.i("MicroMsg.PayProcess", "domestic, verify code");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 2:
                v.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    h(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (bKV()) {
                        v.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        h(activity, bundle);
                        return;
                    }
                    v.i("MicroMsg.PayProcess", "domestic, verify code!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 3:
                v.i("MicroMsg.PayProcess", "forwardBound()");
                if (activity instanceof WalletVerifyCodeUI) {
                    h(activity, bundle);
                    return;
                } else if ((activity instanceof WalletResetInfoUI) || (activity instanceof WalletChangeBankcardUI)) {
                    if ((!bundle.getBoolean("key_need_verify_sms", false) || bKV()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        v.i("MicroMsg.PayProcess", "jump to result ui!");
                        h(activity, bundle);
                        return;
                    }
                    v.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else if ((activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    v.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void d(Activity activity, int i) {
        v.i("MicroMsg.PayProcess", "back pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            D(activity);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        int i = -1;
        v.i("MicroMsg.PayProcess", "end pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        int i2 = this.fNM.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            PayInfo payInfo = (PayInfo) this.fNM.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.fNM.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.fNM.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.fNM.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.fNM.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.fNM.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.bkh);
            }
            intent.putExtras(bundle2);
        }
        qp qpVar = new qp();
        qpVar.bsg.context = activity;
        qpVar.bsg.intent = intent;
        com.tencent.mm.e.a.qp.a aVar = qpVar.bsg;
        if (!this.fNM.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.bpc = i;
        com.tencent.mm.sdk.c.a.nhr.z(qpVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
    }

    private boolean g(Activity activity, Bundle bundle) {
        v.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", new Object[]{Integer.valueOf(bundle.getInt("key_err_code", 0))});
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletChangeBankcardUI.class, bundle);
                return true;
            case -1003:
                k.beN();
                if (k.beO().bgv()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.fNM.get("key_bankcard");
                if (bankcard == null || !bankcard.bfG()) {
                    b(activity, WalletResetInfoUI.class, bundle);
                } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgG() == null || com.tencent.mm.plugin.wallet_core.model.k.bga().bgG().size() <= 0) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    v.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", com.tencent.mm.plugin.wallet_core.model.k.bga().bgG());
                    bundle2.putString("key_top_tips", activity.getString(2131236463));
                    b(activity, WalletSelectBankcardUI.class, bundle2);
                }
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletResetInfoUI.class, bundle);
                return true;
            default:
                return false;
        }
    }

    private void h(Activity activity, Bundle bundle) {
        if (this.fNM != null && this.fNM.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.fNM.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        v.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", new Object[]{Integer.valueOf(i)});
        if (i == 11 || i == 21) {
            b(activity, WalletBalanceResultUI.class, bundle);
        } else if (i == 5 || i == 31 || i == 32 || i == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
        } else if (i == 37 || i == 39 || i == 42) {
            d(activity, bundle);
            t.a((PayInfo) bundle.getParcelable("key_pay_info"), (Orders) bundle.getParcelable("key_orders"));
        } else {
            b(activity, WalletOrderInfoUI.class, bundle);
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayProcess", "pay_flag : " + this.fNM.getInt("key_pay_flag", 0));
        switch (this.fNM.getInt("key_pay_flag", 0)) {
            case 1:
                return activity instanceof WalletOrderInfoUI;
            case 2:
                return activity instanceof WalletOrderInfoUI;
            default:
                return false;
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean o(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.piS.a(new i((String) objArr[0], 4, (String) objArr[1]), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBankcardIdUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean o(Object... objArr) {
                    if (this.kIn.fNM.getInt("key_pay_scene", 0) == 11) {
                        k.beN();
                        this.kIn.fNM.putParcelable("key_history_bankcard", k.beO().kQR);
                    }
                    return super.o(objArr);
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        this.kIn.fNM.putString("kreq_token", bVar.token);
                        if (bVar.hdn) {
                            this.kIn.fNM.putParcelable("key_orders", bVar.hdo);
                        }
                        RealnameGuideHelper realnameGuideHelper = bVar.hKv;
                        if (realnameGuideHelper != null) {
                            this.kIn.fNM.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                    } else if (kVar instanceof c) {
                        c cVar = (c) kVar;
                        this.kIn.fNM.putString("kreq_token", cVar.token);
                        if (cVar.hdn) {
                            this.kIn.fNM.putParcelable("key_orders", cVar.hdo);
                        }
                    }
                    if (this.kIn.e(this.piR, null)) {
                        this.piS.a(new l(b.h(this.kIn)), true, true);
                        return true;
                    }
                    this.kIn.a(this.piR, 0, this.kIn.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    v.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + this.kIn.fNM.getInt("key_pay_flag", 0));
                    switch (this.kIn.fNM.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (this.kIn.bKV()) {
                                authen.bkU = 4;
                            } else {
                                authen.bkU = 1;
                            }
                            this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            return true;
                        case 2:
                            if (this.kIn.bKV()) {
                                authen.bkU = 5;
                            } else {
                                authen.bkU = 2;
                            }
                            if (this.kIn.fNM.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.piS.a(new c(authen, orders), true, true);
                            } else {
                                this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            }
                            return true;
                        case 3:
                            if (this.kIn.bKV()) {
                                authen.bkU = 6;
                            } else {
                                authen.bkU = 3;
                            }
                            this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            return true;
                        default:
                            return false;
                    }
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final /* synthetic */ CharSequence nK(int i) {
                    boolean z = this.kIn.fNM.getBoolean("key_is_changing_balance_phone_num");
                    boolean z2 = this.kIn.fNM.getBoolean("key_is_return_from_switch_phone", false);
                    Authen authen = (Authen) this.kIn.fNM.getParcelable("key_authen");
                    String str = (authen == null || authen.kNf == null) ? "" : authen.kNf;
                    int i2 = this.kIn.fNM.getInt("key_pay_flag", 3);
                    Bankcard bankcard;
                    String ma;
                    MMActivity mMActivity;
                    Object[] objArr;
                    if (!z2 || str.isEmpty()) {
                        if (!z || i2 == 2) {
                            str = be.ah(this.kIn.fNM.getString("key_mobile"), "");
                            return String.format(this.piR.getString(2131236504), new Object[]{str});
                        }
                        bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                        ma = be.ma(this.kIn.fNM.getString("key_mobile"));
                        mMActivity = this.piR;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = e.PT(be.kS(ma) ? bankcard.field_mobile : ma);
                        return mMActivity.getString(2131236493, objArr);
                    } else if (str.equals("cft")) {
                        bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                        ma = be.ma(this.kIn.fNM.getString("key_mobile"));
                        mMActivity = this.piR;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = e.PT(be.kS(ma) ? bankcard.field_mobile : ma);
                        return mMActivity.getString(2131236493, objArr);
                    } else {
                        str = be.ah(this.kIn.fNM.getString("key_mobile"), "");
                        return String.format(this.piR.getString(2131236504), new Object[]{str});
                    }
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i == 0 && i2 == 0) {
                        if ((kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) || (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.b)) {
                            com.tencent.mm.plugin.wallet.pay.a.c.e eVar = (com.tencent.mm.plugin.wallet.pay.a.c.e) kVar;
                            if (eVar.hdn) {
                                this.kIn.fNM.putParcelable("key_orders", eVar.hdo);
                            }
                            RealnameGuideHelper realnameGuideHelper = eVar.hKv;
                            if (realnameGuideHelper != null) {
                                this.kIn.fNM.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            g.iuh.h(10707, new Object[]{Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.wallet_core.d.c.bhv())});
                            return false;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                    Orders orders = (Orders) this.kIn.fNM.getParcelable("key_orders");
                    v.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + this.kIn.fNM.getInt("key_pay_flag", 0));
                    boolean z = this.kIn.fNM.getBoolean("key_is_changing_balance_phone_num");
                    com.tencent.mm.plugin.wallet.pay.a.c.e a;
                    switch (this.kIn.fNM.getInt("key_pay_flag", 0)) {
                        case 1:
                            lVar.flag = "1";
                            if (z) {
                                this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.c.b(lVar, orders), true, true);
                            } else {
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(lVar, orders);
                                if (a != null) {
                                    this.piS.a(a, true, true);
                                }
                            }
                            return true;
                        case 2:
                            if (this.kIn.bKV()) {
                                lVar.flag = "5";
                            } else {
                                lVar.flag = "2";
                            }
                            if (z) {
                                this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.c.b(lVar, orders), true, true);
                            } else {
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(lVar, orders);
                                if (a != null) {
                                    this.piS.a(a, true, true);
                                }
                            }
                            return true;
                        case 3:
                            if (this.kIn.bKV()) {
                                lVar.flag = "6";
                            } else {
                                lVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                            }
                            if (z) {
                                this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.c.b(lVar, orders), true, true);
                            } else {
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(lVar, orders);
                                if (a != null) {
                                    this.piS.a(a, true, true);
                                }
                            }
                            return true;
                        default:
                            return false;
                    }
                }
            };
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    Orders orders = (Orders) objArr[0];
                    k.beN();
                    Bankcard bankcard = k.beO().kFU;
                    bankcard.kNv += orders.kOU;
                    return false;
                }

                public final CharSequence nK(int i) {
                    switch (i) {
                        case 0:
                            return this.piR.getString(2131236013);
                        case 1:
                            return this.piR.getString(2131236012);
                        default:
                            return super.nK(i);
                    }
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final /* synthetic */ CharSequence nK(int i) {
                    return this.piR.getString(2131236475);
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f) || i != 0 || i2 != 0) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) kVar;
                    if (fVar.hdn) {
                        this.kIn.fNM.putParcelable("key_orders", fVar.hdo);
                    }
                    RealnameGuideHelper realnameGuideHelper = fVar.hKv;
                    if (realnameGuideHelper != null) {
                        this.kIn.fNM.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                    }
                    this.kIn.a(this.piR, 0, this.kIn.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    com.tencent.mm.v.k kVar;
                    com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[0];
                    Orders orders = (Orders) this.kIn.fNM.getParcelable("key_orders");
                    if (lVar == null || orders == null) {
                        v.e("MicroMsg.CgiManager", "empty verify or orders");
                        kVar = null;
                    } else {
                        PayInfo payInfo = lVar.imN;
                        String str = "";
                        if (payInfo != null) {
                            v.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.fTG;
                        }
                        if (be.kS(str)) {
                            v.i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.fTG;
                        }
                        if (be.kS(str)) {
                            v.i("MicroMsg.CgiManager", "empty reqKey!");
                            kVar = new com.tencent.mm.plugin.wallet.pay.a.d.f(lVar, orders);
                        } else {
                            if (payInfo != null) {
                                v.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fTG, orders.fTG});
                            }
                            v.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[]{str});
                            if (com.tencent.mm.plugin.wallet.pay.a.a.beR()) {
                                v.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                                kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.d.a(lVar, orders) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.d.e(lVar, orders) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.d.b(lVar, orders) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.d.c(lVar, orders) : str.startsWith("sns_") ? new com.tencent.mm.plugin.wallet.pay.a.d.d(lVar, orders) : new com.tencent.mm.plugin.wallet.pay.a.d.f(lVar, orders);
                            } else {
                                kVar = new com.tencent.mm.plugin.wallet.pay.a.d.f(lVar, orders);
                            }
                        }
                    }
                    if (kVar != null) {
                        this.piS.a(kVar, true, true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletChangeBankcardUI) {
            return new c(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSelectBankcardUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof c)) {
                        v.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        this.kIn.a(this.piR, 0, this.kIn.fNM);
                        return true;
                    } else if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
                        return false;
                    } else {
                        v.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        beQ();
                        return false;
                    }
                }

                public final boolean j(Object... objArr) {
                    v.i("MicroMsg.PayProcess", "onNext for select bank card");
                    this.kIn.fNM.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        v.i("MicroMsg.PayProcess", "directToBindNew()");
                        this.kIn.fNM.putInt("key_pay_flag", 2);
                        this.kIn.a(this.piR, 0, this.kIn.fNM);
                    } else if (com.tencent.mm.plugin.wallet_core.model.k.bgi().Da(bankcard.field_bankcardType) != null) {
                        beQ();
                    } else {
                        this.piS.a(new com.tencent.mm.plugin.wallet_core.b.k("", "", null), true, true);
                    }
                    return false;
                }

                private void beQ() {
                    v.i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = this.kIn.fNM.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) this.kIn.fNM.getParcelable("key_authen");
                    Orders orders = (Orders) this.kIn.fNM.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                    ElementQuery Da = com.tencent.mm.plugin.wallet_core.model.k.bgi().Da(bankcard.field_bankcardType);
                    this.kIn.fNM.putParcelable("elemt_query", Da);
                    if (z) {
                        authen.hMt = bankcard.field_bankcardType;
                        authen.hMu = bankcard.field_bindSerial;
                        this.kIn.a(this.piR, 0, this.kIn.fNM);
                        return;
                    }
                    authen.kLp = "";
                    authen.hMt = bankcard.field_bankcardType;
                    authen.hMu = bankcard.field_bindSerial;
                    this.kIn.fNM.putString("key_mobile", bankcard.field_mobile);
                    if (Da == null || Da.kNW || Da.kNX) {
                        v.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                        this.kIn.a(this.piR, 0, this.kIn.fNM);
                        return;
                    }
                    this.piS.a(new c(authen, orders), true);
                }
            };
        }
        if (mMActivity instanceof WalletResetInfoUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b kIn;

                public final boolean o(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletSwitchVerifyPhoneUI ? new a(this, (WalletBaseUI) mMActivity, fVar) {
            final /* synthetic */ b kIn;

            public final boolean j(Object... objArr) {
                v.i("MicroMsg.PayProcess", "start do authen");
                el elVar = (el) objArr[0];
                Authen authen = (Authen) this.kIn.fNM.getParcelable("key_authen");
                Bankcard bankcard = new Bankcard();
                bankcard.field_bindSerial = elVar.hMu;
                bankcard.field_mobile = elVar.kLp;
                bankcard.field_desc = elVar.kNS;
                bankcard.field_bankcardType = authen.hMt;
                v.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", new Object[]{authen.hMt, elVar.hMu, authen.hMu});
                this.kIn.fNM.putString("key_mobile", bankcard.field_mobile);
                this.kIn.fNM.putParcelable("key_bankcard", bankcard);
                Orders orders = (Orders) this.kIn.fNM.getParcelable("key_orders");
                authen.kNf = elVar.mfr;
                authen.kNg = elVar.hMu;
                authen.kNh = elVar.hMt;
                authen.kNi = "1";
                com.tencent.mm.plugin.wallet.pay.a.a.b a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
                if (a != null) {
                    this.piS.a(a, true, true);
                }
                return false;
            }

            public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                if (!(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                    return false;
                }
                v.i("MicroMsg.PayProcess", "finish auth");
                Authen authen = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).hdp;
                Orders orders = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).hdo;
                this.kIn.fNM.putParcelable("key_authen", authen);
                this.kIn.fNM.putParcelable("key_orders", orders);
                this.kIn.fNM.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).token);
                this.kIn.fNM.putBoolean("key_is_return_from_switch_phone", true);
                this.kIn.fNM.putInt("key_err_code", 0);
                Bankcard bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                bankcard.field_bankcardType = authen.hMt;
                bankcard.field_bindSerial = authen.hMu;
                this.kIn.a(this.piR, 0, this.kIn.fNM);
                this.kIn.D(this.piR);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean a(final WalletBaseUI walletBaseUI, final int i, String str) {
        v.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 402:
            case 403:
            case 408:
                if (bKX() && this.fNM.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.fNM.getParcelable("key_bankcard");
                    if (be.kS(str)) {
                        string = walletBaseUI.getString(2131236367, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.g.b(walletBaseUI, string, "", walletBaseUI.getString(2131236366), walletBaseUI.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ b kIn;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kIn.fNM.putInt("key_pay_flag", 3);
                            this.kIn.fNM.putInt("key_err_code", i);
                            this.kIn.a(walletBaseUI, 0, this.kIn.fNM);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, null);
                    return true;
                }
            case 404:
                v.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                k.beN();
                ArrayList bgG = k.beO().bgG();
                if (bgG == null || bgG.isEmpty()) {
                    com.tencent.mm.ui.base.g.b(walletBaseUI, str, "", walletBaseUI.getString(2131236326), walletBaseUI.getString(2131236054), new OnClickListener(this) {
                        final /* synthetic */ b kIn;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kIn.fNM.putInt("key_err_code", -1003);
                            this.kIn.a(walletBaseUI, 0, this.kIn.fNM);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ b kIn;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kIn.d(walletBaseUI, this.kIn.fNM);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.g.b(walletBaseUI, str, "", walletBaseUI.getString(2131236342), walletBaseUI.getString(2131236054), new OnClickListener(this) {
                        final /* synthetic */ b kIn;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bankcard bankcard = (Bankcard) this.kIn.fNM.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) this.kIn.fNM.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.kNu = payInfo.fTG;
                            }
                            this.kIn.fNM.putInt("key_err_code", -1004);
                            this.kIn.a(walletBaseUI, 0, this.kIn.fNM);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ b kIn;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kIn.d(walletBaseUI, this.kIn.fNM);
                            if (walletBaseUI.ayJ()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
        }
        return false;
    }

    public final int d(MMActivity mMActivity, int i) {
        return 2131236353;
    }

    public final String anS() {
        return "PayProcess";
    }
}
