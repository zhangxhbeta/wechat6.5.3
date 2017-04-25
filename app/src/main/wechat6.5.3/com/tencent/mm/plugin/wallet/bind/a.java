package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends b {
    public final b c(Activity activity, Bundle bundle) {
        v.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            f(activity, bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public void f(Activity activity, Bundle bundle) {
        b(activity, WalletBankcardDetailUI.class, bundle);
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        D(activity);
    }

    public void d(Activity activity, Bundle bundle) {
        if (this.fNM.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
            return;
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            private String fTG = null;
            final /* synthetic */ a kGh;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.d) {
                    if (i == 0 && i2 == 0) {
                        this.kGh.fNM.putInt("key_process_result_code", -1);
                        if (this.kGh.e(this.piR, null)) {
                            this.piS.a(new l(this.fTG), true, true);
                        } else {
                            this.kGh.a(this.piR, 0, null);
                            if (this.piR instanceof WalletBaseUI) {
                                ((WalletBaseUI) this.piR).nU(0);
                            }
                            this.piR.finish();
                        }
                        return true;
                    }
                    this.kGh.fNM.putInt("key_process_result_code", 1);
                }
                return false;
            }

            public final boolean o(Object... objArr) {
                Bankcard bankcard = (Bankcard) this.kGh.fNM.getParcelable("key_bankcard");
                if (bankcard == null || bankcard.field_bankcardState != 1) {
                    this.kGh.fNM.putInt("key_process_result_code", 1);
                    return super.o(objArr);
                }
                this.piS.a(new com.tencent.mm.plugin.wallet.bind.a.d(bankcard.field_bankcardType, bankcard.field_bindSerial), true, true);
                this.kGh.fNM.putBoolean("key_is_expired_bankcard", true);
                return true;
            }

            public final boolean j(Object... objArr) {
                Bankcard bankcard = (Bankcard) this.kGh.fNM.getParcelable("key_bankcard");
                String str = (String) objArr[0];
                this.fTG = (String) objArr[1];
                if (bankcard != null) {
                    this.piS.a(new com.tencent.mm.plugin.wallet.bind.a.d(bankcard.field_bankcardType, bankcard.field_bindSerial, str), true, true);
                    return true;
                }
                this.kGh.fNM.putInt("key_process_result_code", 1);
                return false;
            }

            public final CharSequence nK(int i) {
                switch (i) {
                    case 1:
                        return this.piR.getString(2131236209);
                    default:
                        return super.nK(i);
                }
            }
        } : super.a(mMActivity, fVar);
    }

    public boolean e(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String anS() {
        return "UnbindProcess";
    }
}
