package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.plugin.wxcredit.a.g;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class e extends b {
    public final b c(Activity activity, Bundle bundle) {
        if (!k.bga().bgu()) {
            if (k.bga().bgv()) {
                b(activity, WalletCheckPwdUI.class, bundle);
            } else {
                b(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            D(activity);
            b(activity, WalletWXCreditOpenUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                b(activity, WalletBindDepositUI.class, bundle);
            } else {
                b(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletBindDepositUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (k.bga().bgv()) {
                b(activity, WalletWXCreditOpenResultUI.class, bundle);
            } else {
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletWXCreditOpenResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenResultUI) {
            d(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e lvK;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.b) {
                        com.tencent.mm.plugin.wxcredit.a.b bVar = (com.tencent.mm.plugin.wxcredit.a.b) kVar;
                        this.lvK.fNM.putString("KEY_SESSION_KEY", bVar.token);
                        this.lvK.fNM.putString("key_pre_name", bVar.name);
                        this.lvK.fNM.putString("key_pre_indentity", bVar.lvN);
                        this.lvK.fNM.putBoolean("key_has_indentity_info", bVar.lvO);
                    }
                    this.lvK.a(this.piR, 0, this.lvK.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    int i = 0;
                    this.lvK.fNM.putString("key_pwd1", (String) objArr[0]);
                    f fVar = this.piS;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i = be.KL((String) objArr[1]);
                    }
                    fVar.a(new com.tencent.mm.plugin.wxcredit.a.b(str, i, this.lvK.fNM.getString("key_bank_type")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCheckIdentityUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e lvK;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof a) {
                        a aVar = (a) kVar;
                        this.lvK.fNM.putString("KEY_SESSION_KEY", aVar.token);
                        this.lvK.fNM.putString("key_mobile", aVar.bhT);
                        this.lvK.fNM.putBoolean("key_need_bind_deposit", aVar.brN);
                        this.lvK.fNM.putBoolean("key_is_bank_user", aVar.lvM);
                    }
                    this.lvK.a(this.piR, 0, this.lvK.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    this.lvK.fNM.putString("key_name", str);
                    this.lvK.fNM.putString("key_indentity", str2);
                    this.piS.a(new a(str, str2, this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_bank_type")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e lvK;

                public final /* synthetic */ CharSequence nK(int i) {
                    if (this.lvK.fNM.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) this.lvK.fNM.getParcelable("key_bankcard");
                        return this.piR.getString(2131236506, new Object[]{bankcard.field_bankName, bankcard.field_bankName, this.lvK.fNM.getString("key_mobile")});
                    }
                    return this.piR.getString(2131236507, new Object[]{this.lvK.fNM.getString("key_mobile")});
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof g) {
                        String str2 = ((g) kVar).bkp;
                        if (!be.kS(str2)) {
                            this.lvK.fNM.putString("key_bank_username", str2);
                        }
                        this.lvK.a(this.piR, 0, this.lvK.fNM);
                        return true;
                    } else if (kVar instanceof h) {
                        this.lvK.a(this.piR, 0, this.lvK.fNM);
                        return true;
                    } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.h) {
                        if (k.bga().bgv()) {
                            this.piS.a(new l(null), true, true);
                            return true;
                        }
                        this.lvK.a(this.piR, 0, this.lvK.fNM);
                        return true;
                    } else if (!(kVar instanceof l)) {
                        return false;
                    } else {
                        this.piS.a(new g(this.lvK.fNM.getString("key_verify_code"), this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_pwd1"), k.bga().bgI(), this.lvK.fNM.getString("key_bank_type")), true, true);
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    String str = (String) objArr[0];
                    this.lvK.fNM.putString("key_verify_code", str);
                    com.tencent.mm.plugin.wallet_core.model.l lVar;
                    if (k.bga().bgv()) {
                        if (!this.lvK.fNM.getBoolean("key_need_bind_deposit", true) || this.lvK.fNM.getBoolean("key_is_bank_user")) {
                            this.piS.a(new g(str, this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_pwd1"), this.lvK.fNM.getString("key_bind_serial"), this.lvK.fNM.getString("key_bank_type")), true, true);
                        } else {
                            lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                            lVar.flag = "2";
                            this.piS.a(new com.tencent.mm.plugin.wallet_core.b.h(lVar), true, true);
                        }
                    } else if (this.lvK.fNM.getBoolean("key_is_bank_user", false)) {
                        this.lvK.fNM.putString("key_verify_code", str);
                        this.piS.a(new h(str, this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_pwd1"), this.lvK.fNM.getString("key_bind_serial"), this.lvK.fNM.getString("key_bank_type")), true, true);
                    } else {
                        lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                        lVar.flag = "1";
                        this.piS.a(new com.tencent.mm.plugin.wallet_core.b.h(lVar), true, true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBindDepositUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e lvK;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.a.a.a)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet_core.a.a.a aVar = (com.tencent.mm.plugin.wallet_core.a.a.a) kVar;
                    new StringBuilder("reqKey  ").append(aVar.kIr);
                    this.lvK.fNM.putString("kreq_token", aVar.token);
                    this.lvK.a(this.piR, 0, this.lvK.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    c.bhu();
                    Authen authen = new Authen();
                    authen.kMV = (String) objArr[0];
                    authen.hMt = (String) objArr[1];
                    authen.kLp = (String) objArr[2];
                    this.lvK.fNM.putString("key_bank_phone", (String) objArr[3]);
                    authen.bkU = k.bga().bgv() ? 2 : 1;
                    authen.kMU = 1;
                    authen.imN = (PayInfo) this.lvK.fNM.getParcelable("key_pay_info");
                    authen.kMR = this.lvK.fNM.getString("key_pwd1");
                    if (!this.lvK.fNM.getBoolean("key_has_indentity_info", false)) {
                        authen.kMS = this.lvK.fNM.getString("key_name");
                        authen.kMT = this.lvK.fNM.getString("key_indentity");
                    }
                    this.lvK.fNM.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.PT(authen.kLp));
                    this.lvK.fNM.putBoolean("key_is_oversea", false);
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.a.a.a(authen), true, true);
                    return true;
                }

                public final boolean p(Object... objArr) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.b.k("", (String) objArr[0], (PayInfo) this.lvK.fNM.getParcelable("key_pay_info")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e lvK;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet_core.a.a.b) {
                        this.piS.a(new l(null), true, true);
                        return true;
                    } else if (kVar instanceof l) {
                        this.piS.a(new g(this.lvK.fNM.getString("key_verify_code"), this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_pwd1"), k.bga().bgI(), this.lvK.fNM.getString("key_bank_type")), true, true);
                        return true;
                    } else if (!(kVar instanceof g)) {
                        return false;
                    } else {
                        String str2 = ((g) kVar).bkp;
                        if (!be.kS(str2)) {
                            this.lvK.fNM.putString("key_bank_username", str2);
                        }
                        this.lvK.a(this.piR, 0, this.lvK.fNM);
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    if (this.lvK.fNM.getBoolean("key_is_bank_user", false)) {
                        this.piS.a(new g(this.lvK.fNM.getString("key_verify_code"), this.lvK.fNM.getString("KEY_SESSION_KEY"), this.lvK.fNM.getString("key_pwd1"), k.bga().bgI(), this.lvK.fNM.getString("key_bank_type")), true, true);
                    } else {
                        this.piS.a(new com.tencent.mm.plugin.wallet_core.a.a.b((com.tencent.mm.plugin.wallet_core.model.l) objArr[0]), true, true);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletWXCreditOpenResultUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ e lvK;

            public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.lvK.a(this.piR, 0, this.lvK.fNM);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.lvK.fNM.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                this.lvK.bKY();
                this.piS.a(new l(null), true, true);
                return true;
            }
        } : null;
    }

    public final String anS() {
        return "WXCreditOpenProcess";
    }
}
