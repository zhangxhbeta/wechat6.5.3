package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.e;

public class b extends com.tencent.mm.wallet_core.b {
    static /* synthetic */ String n(b bVar) {
        if (bVar.fNM != null) {
            PayInfo payInfo = (PayInfo) bVar.fNM.getParcelable("key_pay_info");
            if (payInfo != null) {
                return payInfo.fTG;
            }
        }
        return "";
    }

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            k.beN();
            if (!k.beO().bgv()) {
                this.fNM.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.fNM.getParcelable("key_bankcard")) != null) {
                this.fNM.putInt("key_pay_flag", 3);
                this.fNM.putString("key_pwd_cash_title", activity.getString(2131235995));
                Orders orders = (Orders) this.fNM.getParcelable("key_orders");
                if (orders != null) {
                    this.fNM.putString("key_pwd_cash_money", e.l(orders.kOU));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.fNM.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            b(activity, WalletBalanceFetchUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            k.beN();
            if (!k.beO().bgv()) {
                this.fNM.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.fNM.getParcelable("key_bankcard")) != null) {
                this.fNM.putInt("key_pay_flag", 3);
                this.fNM.putString("key_pwd_cash_title", activity.getString(2131235995));
                Orders orders = (Orders) this.fNM.getParcelable("key_orders");
                if (orders != null) {
                    this.fNM.putString("key_pwd_cash_money", e.l(orders.kOU));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.fNM.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                b(activity, WalletBalanceResultUI.class, bundle);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletCardElementUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            k.beN();
            if (k.beO().bgv()) {
                b(activity, WalletBalanceResultUI.class, bundle);
            } else {
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletBalanceResultUI.class, bundle);
        } else if (activity instanceof WalletBalanceResultUI) {
            d(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else if (activity instanceof WalletBalanceResultUI) {
            d(activity, this.fNM);
        } else {
            D(activity);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        a(activity, WalletBalanceManagerUI.class, -1, true);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletBalanceFetchUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kFi;

                public final boolean o(Object... objArr) {
                    k.beN();
                    this.kFi.fNM.putParcelable("key_history_bankcard", k.beO().kQR);
                    PayInfo payInfo = (PayInfo) this.kFi.fNM.get("key_pay_info");
                    this.piS.a(new l(payInfo == null ? null : payInfo.fTG, 4), true);
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.kFi.a(this.piR, 0, this.kFi.fNM);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kFi;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    boolean z = false;
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.kFi.fNM.putString("kreq_token", bVar.token);
                    this.kFi.fNM.putParcelable("key_authen", bVar.hdp);
                    Bundle d = this.kFi.fNM;
                    String str2 = "key_need_verify_sms";
                    if (!bVar.hdm) {
                        z = true;
                    }
                    d.putBoolean(str2, z);
                    Parcelable parcelable = bVar.hKv;
                    if (parcelable != null) {
                        this.kFi.fNM.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    a.k(this.piR, this.kFi.fNM);
                    this.piR.finish();
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Bankcard bankcard = (Bankcard) this.kFi.fNM.getParcelable("key_bankcard");
                    this.kFi.fNM.putString("key_pwd1", (String) objArr[0]);
                    this.kFi.fNM.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.bkU = 3;
                    authen.kMR = (String) objArr[0];
                    authen.hMu = bankcard.field_bindSerial;
                    authen.hMt = bankcard.field_bankcardType;
                    authen.imN = (PayInfo) this.kFi.fNM.getParcelable("key_pay_info");
                    authen.kMZ = bankcard.field_arrive_type;
                    this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) this.kFi.fNM.getParcelable("key_orders")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kFi;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        this.kFi.fNM.putString("kreq_token", bVar.token);
                        if (bVar.hdn) {
                            this.kFi.fNM.putParcelable("key_orders", bVar.hdo);
                        }
                    }
                    if (this.kFi.e(this.piR, null)) {
                        this.piS.a(new l(b.n(this.kFi)), true, true);
                        return true;
                    }
                    this.kFi.a(this.piR, 0, this.kFi.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (this.kFi.fNM.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!this.kFi.bKV()) {
                                authen.bkU = 1;
                                break;
                            }
                            authen.bkU = 4;
                            break;
                        case 2:
                            if (!this.kFi.bKV()) {
                                authen.bkU = 2;
                                break;
                            }
                            authen.bkU = 5;
                            break;
                        case 3:
                            if (!this.kFi.bKV()) {
                                authen.bkU = 3;
                                break;
                            }
                            authen.bkU = 6;
                            break;
                        default:
                            return false;
                    }
                    this.kFi.fNM.putParcelable("key_authen", authen);
                    this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kFi;

                public final /* synthetic */ CharSequence nK(int i) {
                    String str;
                    String ah = be.ah(this.kFi.fNM.getString("key_mobile"), "");
                    if (be.kS(ah)) {
                        Bankcard bankcard = (Bankcard) this.kFi.fNM.getParcelable("key_bankcard");
                        if (bankcard != null) {
                            str = bankcard.field_mobile;
                            return this.piR.getString(2131236501, new Object[]{str});
                        }
                    }
                    str = ah;
                    return this.piR.getString(2131236501, new Object[]{str});
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) {
                            com.tencent.mm.plugin.wallet.pay.a.c.e eVar = (com.tencent.mm.plugin.wallet.pay.a.c.e) kVar;
                            if (eVar.hdn) {
                                this.kFi.fNM.putParcelable("key_orders", eVar.hdo);
                            }
                            a.k(this.piR, this.kFi.fNM);
                            return true;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                            Parcelable parcelable = bVar.hKv;
                            if (parcelable != null) {
                                this.kFi.fNM.putParcelable("key_realname_guide_helper", parcelable);
                            }
                            this.kFi.fNM.putString("kreq_token", bVar.token);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                    if (!(lVar == null || lVar.imN == null)) {
                        lVar.imN.bkq = 21;
                    }
                    Orders orders = (Orders) this.kFi.fNM.getParcelable("key_orders");
                    switch (this.kFi.fNM.getInt("key_pay_flag", 0)) {
                        case 1:
                            lVar.flag = "1";
                            break;
                        case 2:
                            if (!this.kFi.bKV()) {
                                lVar.flag = "2";
                                break;
                            }
                            lVar.flag = "5";
                            break;
                        case 3:
                            if (!this.kFi.bKV()) {
                                lVar.flag = "3";
                                break;
                            }
                            lVar.flag = "6";
                            break;
                        default:
                            return false;
                    }
                    this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.c.e(lVar, orders), true, true);
                    return true;
                }

                public final boolean p(Object... objArr) {
                    Authen authen = (Authen) this.kFi.fNM.getParcelable("key_authen");
                    this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) this.kFi.fNM.getParcelable("key_orders")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kFi;

                public final boolean o(Object... objArr) {
                    Orders orders = (Orders) this.kFi.fNM.getParcelable("key_orders");
                    Bankcard bankcard = com.tencent.mm.plugin.wallet_core.model.k.bga().kFU;
                    bankcard.kNv -= orders.kOU;
                    this.kFi.fNM.putInt("key_balance_result_logo", 2130839534);
                    return super.o(objArr);
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final CharSequence nK(int i) {
                    switch (i) {
                        case 0:
                            return this.piR.getString(2131236010);
                        case 1:
                            Orders orders = (Orders) this.kFi.fNM.getParcelable("key_orders");
                            if (orders == null || be.kS(orders.kPh)) {
                                return this.piR.getString(2131236008);
                            }
                            return orders.kPh;
                        default:
                            return super.nK(i);
                    }
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b kFi;

            public final /* synthetic */ CharSequence nK(int i) {
                return this.piR.getString(2131236475);
            }

            public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f)) {
                    return false;
                }
                com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) kVar;
                if (fVar.hdn) {
                    this.kFi.fNM.putParcelable("key_orders", fVar.hdo);
                }
                this.kFi.a(this.piR, 0, this.kFi.fNM);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.piS.a(new com.tencent.mm.plugin.wallet.pay.a.d.f((com.tencent.mm.plugin.wallet_core.model.l) objArr[0], (Orders) this.kFi.fNM.getParcelable("key_orders")), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final int d(MMActivity mMActivity, int i) {
        return 2131235991;
    }

    public final String anS() {
        return "BalanceFetchProcess";
    }
}
