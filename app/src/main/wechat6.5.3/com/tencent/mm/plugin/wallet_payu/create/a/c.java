package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.e;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        k.beN();
        String Fk = k.Fk();
        k.beN();
        String beP = k.beP();
        if (bundle != null) {
            bundle.putString("key_mobile", Fk);
            bundle.putString("dial_code", beP);
        }
        b(activity, WalletPayUStartOpenUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUStartOpenUI) {
            b(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (bundle.getBoolean("key_is_has_mobile")) {
                b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            } else {
                b(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        } else {
            d(activity, this.fNM);
        }
    }

    public final boolean i(Activity activity, Bundle bundle) {
        bundle.putInt("key_open_error_code", 1);
        s.makeText(activity, activity.getString(2131236385), 0).show();
        d(activity, bundle);
        return true;
    }

    public final void d(Activity activity, Bundle bundle) {
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            v.i("MicroMsg.PayUOpenProcess", "hy: user open success");
            d(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        v.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.af(activity);
        e.eS(activity);
    }

    public final int d(MMActivity mMActivity, int i) {
        if (i == 1) {
            return 2131236374;
        }
        return super.d(mMActivity, i);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c kYS;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (kVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) {
                        v.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.wallet_payu.a.b bVar = (com.tencent.mm.plugin.wallet_payu.a.b) kVar;
                            this.kYS.fNM.putString("payu_reference", bVar.ecR);
                            v.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[]{bVar.ecR});
                            this.kYS.fNM.putBoolean("key_is_has_mobile", bVar.kZm);
                            a.k(this.piR, this.kYS.fNM);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_payu.a.b(this.kYS.fNM.getString("dial_code"), this.kYS.fNM.getString("key_mobile")), true);
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c kYS;

                public final boolean p(Object... objArr) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_payu.a.b(this.kYS.fNM.getString("dial_code"), this.kYS.fNM.getString("key_mobile")), true, true);
                    return true;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (kVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) {
                        com.tencent.mm.plugin.wallet_payu.a.a aVar = (com.tencent.mm.plugin.wallet_payu.a.a) kVar;
                        if (i == 0 && i2 == 0 && aVar.kZk) {
                            this.kYS.fNM.putString("payu_reference", aVar.kZl);
                            a.k(this.piR, this.kYS.fNM);
                            return true;
                        }
                    } else if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) && i == 0 && i2 == 0) {
                        this.kYS.fNM.putString("payu_reference", ((com.tencent.mm.plugin.wallet_payu.a.b) kVar).ecR);
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_payu.a.a((String) objArr[0], this.kYS.fNM.getString("payu_reference")), true);
                    return true;
                }

                public final CharSequence nK(int i) {
                    if (i != 0) {
                        return super.nK(i);
                    }
                    return this.piR.getString(2131236495, new Object[]{e.PT("+" + this.kYS.fNM.getString("dial_code") + this.kYS.fNM.getString("key_mobile"))});
                }
            };
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c kYS;

                public final boolean o(Object... objArr) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_payu.security_question.model.d(), true);
                    return false;
                }

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) || i != 0 || i2 != 0) {
                        return false;
                    }
                    this.kYS.fNM.putParcelableArrayList("key_security_question_list", ((com.tencent.mm.plugin.wallet_payu.security_question.model.d) kVar).laD);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c kYS;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if ((kVar instanceof a) && i == 0 && i2 == 0) {
                        v.d("MicroMsg.PayUOpenProcess", "hy: create user success");
                        a.b(this.piR, this.kYS.fNM, 0);
                        this.kYS.fNM.putInt("key_open_error_code", 0);
                        s.makeText(this.piR, this.piR.getString(2131236391), 0).show();
                        return true;
                    } else if (!(kVar instanceof b) || i != 0 || i2 != 0) {
                        return false;
                    } else {
                        v.d("MicroMsg.PayUOpenProcess", "hy: link user success");
                        a.b(this.piR, this.kYS.fNM, 0);
                        this.kYS.fNM.putInt("key_open_error_code", 0);
                        s.makeText(this.piR, this.piR.getString(2131236391), 0).show();
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    l lVar = (l) objArr[0];
                    String string = this.kYS.fNM.getString("dial_code");
                    String string2 = this.kYS.fNM.getString("key_mobile");
                    String str = lVar.kQj;
                    String string3 = this.kYS.fNM.getString("key_question_id");
                    String string4 = this.kYS.fNM.getString("key_question_answer");
                    String string5 = this.kYS.fNM.getString("payu_reference");
                    if (this.kYS.fNM.getBoolean("key_is_has_mobile")) {
                        this.piS.a(new b(string, string2, str, string5), true);
                    } else {
                        this.piS.a(new a(string, string2, str, string3, string4, string5), true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            return new com.tencent.mm.plugin.wallet_payu.security_question.model.a(mMActivity, fVar, this.fNM);
        }
        return super.a(mMActivity, fVar);
    }

    public final String anS() {
        return "PayUOpenProcess";
    }
}
