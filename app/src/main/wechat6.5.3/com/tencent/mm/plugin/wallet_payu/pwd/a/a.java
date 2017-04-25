package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.f;

public class a extends d {
    private Bundle fNM;

    public a(MMActivity mMActivity, f fVar, Bundle bundle) {
        super(mMActivity, fVar);
        this.fNM = bundle;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (be.kS(cVar.token)) {
                v.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                v.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.fNM.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.k(this.piR, this.fNM);
            }
        }
        return false;
    }

    public final boolean j(Object... objArr) {
        this.fNM.putString("key_pwd1", (String) objArr[0]);
        this.piS.a(new c(this.fNM.getString("key_pwd1")), true);
        return true;
    }
}
