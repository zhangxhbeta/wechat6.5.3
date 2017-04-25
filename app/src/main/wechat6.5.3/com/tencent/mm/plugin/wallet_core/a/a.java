package com.tencent.mm.plugin.wallet_core.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a extends b {
    public b c(Activity activity, Bundle bundle) {
        t("start", activity, bundle);
        if (bundle != null) {
            bundle.putBoolean("key_is_bind_reg_process", true);
        }
        b(activity, WalletBankcardIdUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        t("forward", activity, Integer.valueOf(i), bundle);
        if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletOrderInfoUI) {
            d(activity, bundle);
        }
    }

    public void d(Activity activity, int i) {
        t("back", activity, Integer.valueOf(i));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            D(activity);
        }
    }

    public boolean e(Activity activity, Bundle bundle) {
        return activity instanceof WalletOrderInfoUI;
    }

    public boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case 404:
                v.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
                g.a(walletBaseUI, str, null, walletBaseUI.getString(2131236053), false, new OnClickListener(this) {
                    final /* synthetic */ a kLg;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kLg.d((Activity) walletBaseUI, this.kLg.fNM);
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

    public int d(MMActivity mMActivity, int i) {
        return 2131236213;
    }
}
