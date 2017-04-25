package com.tencent.mm.sdk.e;

import android.os.Bundle;

public abstract class b {
    public String bfm;
    public String egi;
    public int errCode;
    public String lBj;

    public abstract int getType();

    public void t(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putInt("_wxapi_baseresp_errcode", this.errCode);
        bundle.putString("_wxapi_baseresp_errstr", this.egi);
        bundle.putString("_wxapi_baseresp_transaction", this.lBj);
        bundle.putString("_wxapi_baseresp_openId", this.bfm);
    }

    public void u(Bundle bundle) {
        this.errCode = bundle.getInt("_wxapi_baseresp_errcode");
        this.egi = bundle.getString("_wxapi_baseresp_errstr");
        this.lBj = bundle.getString("_wxapi_baseresp_transaction");
        this.bfm = bundle.getString("_wxapi_baseresp_openId");
    }
}
