package com.tencent.mm.plugin.wallet_core.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.a.a.a;
import com.tencent.mm.plugin.wallet_core.b.h;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b.n;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class b extends a {
    static /* synthetic */ int e(b bVar) {
        return !bVar.bKV() ? k.bga().bgv() ? 2 : 1 : k.bga().bgv() ? 5 : 4;
    }

    public com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        t("start", activity, bundle);
        v.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            n.dB(6, bundle.getInt("key_bind_scene"));
        } else {
            n.dB(6, 0);
        }
        if (k.bga().bgv()) {
            b(activity, WalletCheckPwdUI.class, bundle);
            return this;
        }
        if (bundle != null) {
            c.cK(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            return super.c(activity, bundle);
        }
        b(activity, WalletCardImportUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        t("forward", activity, Integer.valueOf(i), bundle);
        v.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
            } else {
                b(activity, WalletBankcardIdUI.class, bundle);
            }
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!bKV()) {
                v.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else if (k.bga().bgv()) {
                v.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                g.bf(activity, activity.getString(2131236024));
                d(activity, bundle);
            } else {
                v.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && k.bga().bgv()) {
            v.i("MicroMsg.BindCardProcess", "end process after verify!");
            d(activity, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            v.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            c.cK(this.fNM.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            g.bf(activity, activity.getString(2131236024));
            d(activity, bundle);
        } else {
            v.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
        }
    }

    public d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kLh;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final CharSequence nK(int i) {
                    switch (i) {
                        case 0:
                            return this.piR.getString(2131236145);
                        case 1:
                            return this.piR.getString(2131236192);
                        default:
                            return super.nK(i);
                    }
                }
            };
        }
        if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kLh;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof a) {
                            this.kLh.fNM.putString("kreq_token", ((a) kVar).token);
                            if (this.kLh.e(this.piR, this.kLh.fNM)) {
                                v.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                                this.piS.a(new l(null), false);
                                return true;
                            }
                            v.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                            this.kLh.a(this.piR, 0, this.kLh.fNM);
                            return true;
                        } else if (kVar instanceof l) {
                            v.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                            this.kLh.a(this.piR, 0, this.kLh.fNM);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.kLh.t("onNext", objArr);
                    v.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
                    Authen authen = (Authen) objArr[0];
                    authen.bkU = b.e(this.kLh);
                    this.piS.a(new a(authen), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kLh;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof a)) {
                        return false;
                    }
                    v.i("MicroMsg.BindCardProcess", "verify code success!");
                    this.kLh.fNM.putString("kreq_token", ((a) kVar).token);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    this.kLh.t("WalletVerifyCodeUI onNext", objArr);
                    v.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                    if (k.bga().bgv()) {
                        lVar.flag = "2";
                    } else {
                        lVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(this.kLh.anS())) {
                        this.piS.a(new h(lVar, this.kLh.fNM.getInt("entry_scene", -1)), true, true);
                    } else {
                        this.piS.a(new h(lVar), true, true);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b kLh;

            public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                return false;
            }

            public final boolean j(Object... objArr) {
                com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[0];
                this.kLh.fNM.getString("verify_card_flag", "0");
                if ("realname_verify_process".equals(this.kLh.anS())) {
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.a.a.b(lVar, this.kLh.fNM.getInt("entry_scene", -1)), true);
                } else {
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.a.a.b(lVar), true);
                }
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public void d(Activity activity, Bundle bundle) {
        t("end", activity, bundle);
        v.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        bKY();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            d(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
    }

    public boolean e(Activity activity, Bundle bundle) {
        if (!k.bga().bgv()) {
            return activity instanceof WalletPwdConfirmUI;
        }
        if (((activity instanceof WalletCardElementUI) && bKV()) || (activity instanceof WalletVerifyCodeUI)) {
            return true;
        }
        return false;
    }

    public String anS() {
        return "BindCardProcess";
    }
}
