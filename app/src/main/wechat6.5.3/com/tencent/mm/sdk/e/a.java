package com.tencent.mm.sdk.e;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.r;

public abstract class a {
    public String bfm;
    public String lBj;

    public abstract int getType();

    public void t(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.lBj);
        bundle.putString("_wxapi_basereq_openid", this.bfm);
    }

    public void u(Bundle bundle) {
        this.lBj = r.c(bundle, "_wxapi_basereq_transaction");
        this.bfm = r.c(bundle, "_wxapi_basereq_openid");
    }
}
