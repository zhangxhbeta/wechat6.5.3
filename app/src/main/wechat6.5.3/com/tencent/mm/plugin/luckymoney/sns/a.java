package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class a extends b {
    static /* synthetic */ void mw(int i) {
        nt ntVar = new nt();
        ntVar.boO.key = i;
        ntVar.boO.value = 1;
        ntVar.boO.bna = true;
        com.tencent.mm.sdk.c.a.nhr.z(ntVar);
    }

    public final b c(Activity activity, Bundle bundle) {
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        d(activity, bundle);
    }

    public final void d(Activity activity, int i) {
        d(activity, null);
    }

    public final void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String anS() {
        return "LuckyFreePwdProcess";
    }

    public final d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ a hcC;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof com.tencent.mm.plugin.luckymoney.sns.b.b)) {
                    return false;
                }
                v.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
                if (i == 0 && i2 == 0) {
                    g.bf(this.piR, this.piR.getString(2131233641));
                    a.mw(121);
                    this.hcC.fNM.putBoolean("is_open_sns_pay", true);
                    this.hcC.a(this.piR, 0, this.hcC.fNM);
                    return true;
                }
                g.bf(this.piR, this.piR.getString(2131233640));
                a.mw(122);
                this.hcC.d(this.piR, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.piS.a(new com.tencent.mm.plugin.luckymoney.sns.b.b(1, (String) objArr[0], ""), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }
}
