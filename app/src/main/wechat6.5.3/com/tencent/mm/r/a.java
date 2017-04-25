package com.tencent.mm.r;

import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class a implements com.tencent.mm.ui.account.h.a, e {
    public void k(Bundle bundle) {
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("expires");
        v.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            ak.yW();
            c.vf().set(65832, string2);
        }
        ak.yW();
        c.vf().set(65830, string);
        ak.yW();
        c.vf().set(65831, Long.valueOf(System.currentTimeMillis()));
        ak.vy().a(183, (e) this);
        ak.vy().a(new g(2, string), 0);
    }

    public void onError(int i, String str) {
        v.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            ak.vy().b(183, (e) this);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.RefreshTokenListener", "update token success");
            } else {
                v.e("MicroMsg.RefreshTokenListener", "update token fail");
            }
        }
    }
}
