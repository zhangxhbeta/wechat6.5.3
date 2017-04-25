package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.pwd.a.a;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b extends com.tencent.mm.wallet_core.b {
    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            d(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        a(activity, WalletPasswordSettingUI.class, -1, false);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b kJV;

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.piS.a(new i((String) objArr[0], 3, (String) objArr[1]), true, true);
                    return true;
                }

                public final CharSequence nK(int i) {
                    switch (i) {
                        case 0:
                            return this.piR.getString(2131236142);
                        case 1:
                            return this.piR.getString(2131236314);
                        default:
                            return super.nK(i);
                    }
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b kJV;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (!(kVar instanceof a)) {
                        return true;
                    }
                    this.kJV.a(this.piR, 0, this.kJV.fNM);
                    g.bf(this.piR, this.piR.getString(2131236305));
                    return true;
                } else if (!(kVar instanceof a)) {
                    return false;
                } else {
                    g.a(this.piR, str, "", false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 kJW;

                        {
                            this.kJW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kJW.kJV.d(this.kJW.piR, 0);
                        }
                    });
                    return true;
                }
            }

            public final boolean j(Object... objArr) {
                l lVar = (l) objArr[0];
                this.piS.a(new a(this.kJV.fNM.getString("key_pwd1"), lVar.kQj), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                g.a(walletBaseUI, str, null, walletBaseUI.getString(2131236469), false, new OnClickListener(this) {
                    final /* synthetic */ b kJV;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kJV.d(walletBaseUI, this.kJV.fNM);
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
        return 2131236469;
    }

    public final String anS() {
        return "ModifyPwdProcess";
    }
}
