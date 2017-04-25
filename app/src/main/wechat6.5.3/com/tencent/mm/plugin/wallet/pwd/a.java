package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends com.tencent.mm.plugin.wallet_core.a.a {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.fNM;
        String str = "key_is_oversea";
        k.beN();
        bundle2.putBoolean(str, !k.beO().bgA());
        bundle2 = this.fNM;
        str = "key_support_bankcard";
        k.beN();
        bundle2.putInt(str, k.beO().bgA() ? 1 : 2);
        this.fNM.putBoolean("key_is_forgot_process", true);
        b(activity, WalletForgotPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                b(activity, WalletForgotPwdBindNewUI.class, bundle);
            } else {
                b(activity, WalletCardElementUI.class, bundle);
            }
        } else if (activity instanceof WalletCardElementUI) {
            if (bKV()) {
                b(activity, WalletSetPasswordUI.class, bundle);
            } else {
                b(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            d(activity, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            t("startActivity2", activity, WalletCardElementUI.class, bundle, new StringBuilder("flag: 67108864").toString());
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.fNM.putAll(bundle);
            }
            v.d("MicroMsg.ProcessManager", "bankcard tag :" + bKU());
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        a(activity, WalletForgotPwdUI.class, -1, false);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletForgotPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a kJU;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof l)) {
                        v.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[]{com.tencent.mm.plugin.wallet_core.model.k.bfX().bgT().field_reset_passwd_flag, com.tencent.mm.plugin.wallet_core.model.k.bfX().bgT().field_find_passwd_url});
                        if ((com.tencent.mm.plugin.wallet_core.model.k.bga().bgG() == null ? 0 : com.tencent.mm.plugin.wallet_core.model.k.bga().bgG().size()) <= 0 && !be.kS(r2.field_find_passwd_url)) {
                            v.i("MicroMsg.ProcessManager", "hy: no bankcard and do not support add bank card to forget");
                            MMActivity mMActivity = this.piR;
                            g.a(mMActivity, true, mMActivity.getString(2131236281), "", mMActivity.getString(2131231107), mMActivity.getString(2131231010), new com.tencent.mm.plugin.wallet.pwd.a.f.AnonymousClass1(mMActivity), new com.tencent.mm.plugin.wallet.pwd.a.f.AnonymousClass2(true, mMActivity));
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a kJU;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
                        return false;
                    }
                    this.kJU.fNM.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).token);
                    this.kJU.a(this.piR, 0, this.kJU.fNM);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    if (this.kJU.bKV()) {
                        authen.bkU = 4;
                    } else {
                        authen.bkU = 1;
                    }
                    this.piS.a(new com.tencent.mm.plugin.wallet.pwd.a.d(authen, this.kJU.fNM.getBoolean("key_is_reset_with_new_card", false)), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a kJU;

                public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
                        return false;
                    }
                    this.kJU.fNM.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).token);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.l lVar = (com.tencent.mm.plugin.wallet_core.model.l) objArr[1];
                    lVar.flag = "3";
                    this.piS.a(new e(lVar), true, true);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ a kJU;

            public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof c)) {
                    return false;
                }
                this.kJU.a(this.piR, 0, this.kJU.fNM);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.piS.a(new c((com.tencent.mm.plugin.wallet_core.model.l) objArr[0]), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                g.a(walletBaseUI, str, null, walletBaseUI.getString(2131236187), false, new OnClickListener(this) {
                    final /* synthetic */ a kJU;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kJU.d(walletBaseUI, this.kJU.fNM);
                        if (walletBaseUI.ayJ()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.bLA();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public final int d(MMActivity mMActivity, int i) {
        return 2131236187;
    }

    public final String anS() {
        return "ForgotPwdProcess";
    }
}
