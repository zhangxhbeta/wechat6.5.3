package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.b.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends b {
    static /* synthetic */ void d(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).uA.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).uA.getInt("offline_add_fee", 0);
        Bankcard aFn = a.aFn();
        if (aFn != null) {
            ((WalletBaseUI) mMActivity).p(new h(aFn, string, i));
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        if (a.aFk()) {
            b(activity, WalletOfflineEntranceUI.class);
        } else if (bundle.getInt("key_entry_scene", -1) == 2) {
            d(activity, "wallet", ".trading.WalletPayOrCollectUI");
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
        }
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, int i) {
        super.d(activity, i);
    }

    public final com.tencent.mm.wallet_core.c.d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new com.tencent.mm.wallet_core.c.d(this, mMActivity, fVar) {
                final /* synthetic */ d hJJ;

                public final boolean j(Object... objArr) {
                    l lVar = (l) objArr[1];
                    lVar.flag = "1";
                    this.piS.a(new com.tencent.mm.plugin.wallet_core.b.h(lVar), true, true);
                    return true;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.l) {
                            if (!(((WalletBaseUI) this.piR).uA == null || ((WalletBaseUI) this.piR).uA.getInt("key_bind_scene", -1) != 5 || a.aFk())) {
                                d.d(this.piR);
                                return true;
                            }
                        } else if (kVar instanceof h) {
                            com.tencent.mm.wallet_core.a.k(this.piR, ((WalletBaseUI) this.piR).uA);
                            a.H(this.piR);
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new com.tencent.mm.wallet_core.c.d(this, mMActivity, fVar) {
            final /* synthetic */ d hJJ;

            public final boolean j(Object... objArr) {
                this.piS.a(new com.tencent.mm.plugin.wallet_core.a.a.b((l) objArr[0]), true, true);
                return true;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.l) {
                        if (!(((WalletBaseUI) this.piR).uA == null || ((WalletBaseUI) this.piR).uA.getInt("key_bind_scene", -1) != 5 || a.aFk())) {
                            d.d(this.piR);
                        }
                        return true;
                    } else if (kVar instanceof h) {
                        Bundle bundle = ((WalletBaseUI) this.piR).uA;
                        bundle.putBoolean("intent_bind_end", true);
                        com.tencent.mm.wallet_core.a.k(this.piR, bundle);
                        a.H(this.piR);
                        return true;
                    }
                }
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return super.e(activity, bundle);
    }

    public final String anS() {
        return "OfflineBindCardRegProcess";
    }
}
