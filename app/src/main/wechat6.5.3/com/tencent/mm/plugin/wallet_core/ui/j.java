package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.o;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class j extends b {
    private String fTP;
    private String kLq;
    private int scene;
    private String token;

    public final b c(Activity activity, Bundle bundle) {
        v.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.kLq = bundle.getString("key_relation_key");
        this.fTP = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        b(activity, WalletVerifyCodeUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void d(Activity activity, int i) {
    }

    public final void d(Activity activity, Bundle bundle) {
        v.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, null, false);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String anS() {
        return null;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        final f fVar2 = fVar;
        final MMActivity mMActivity2 = mMActivity;
        return new d(this, mMActivity, fVar) {
            final /* synthetic */ j kTS;

            public final boolean j(Object... objArr) {
                if (objArr.length == 2) {
                    l lVar = (l) objArr[1];
                    lVar.token = this.kTS.token;
                    v.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    fVar2.a(new o(lVar, this.kTS.kLq), true, true);
                    return true;
                }
                v.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                return false;
            }

            public final boolean p(Object... objArr) {
                v.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                fVar2.a(new com.tencent.mm.plugin.wallet_core.b.j(this.kTS.fTP, this.kTS.token, (byte) 0), true, true);
                return true;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    if (kVar instanceof o) {
                        v.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
                    }
                    return false;
                } else if (kVar instanceof o) {
                    v.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    o oVar = (o) kVar;
                    Bundle bundle = this.kTS.fNM;
                    bundle.putString("key_jsapi_token", oVar.kLy);
                    this.kTS.d(mMActivity2, bundle);
                    return true;
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.j) {
                    return true;
                } else {
                    return false;
                }
            }

            public final CharSequence nK(int i) {
                return String.format(mMActivity2.getResources().getString(2131236501), new Object[]{this.kTS.fNM.getString("key_mobile")});
            }
        };
    }
}
