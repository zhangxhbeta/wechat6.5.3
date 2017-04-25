package com.tencent.mm.sdk.g;

import android.os.Bundle;

public final class b extends com.tencent.mm.sdk.e.b {
    public String kXw;
    public String nhO;
    public String nhR;

    public final void t(Bundle bundle) {
        super.t(bundle);
        bundle.putString("_wxapi_payresp_prepayid", this.kXw);
        bundle.putString("_wxapi_payresp_returnkey", this.nhR);
        bundle.putString("_wxapi_payresp_extdata", this.nhO);
    }

    public final void u(Bundle bundle) {
        super.u(bundle);
        this.kXw = bundle.getString("_wxapi_payresp_prepayid");
        this.nhR = bundle.getString("_wxapi_payresp_returnkey");
        this.nhO = bundle.getString("_wxapi_payresp_extdata");
    }

    public final int getType() {
        return 5;
    }
}
