package com.tencent.wework.api.model;

import android.os.Bundle;

public abstract class WWBaseMessage extends BaseMessage {
    private String bfm;
    private String lBj;

    public void t(Bundle bundle) {
        bundle.putString("_wwapi_basereq_transaction", this.lBj);
        bundle.putString("_wwapi_basereq_openid", this.bfm);
        try {
            bundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
            bundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
        } catch (Throwable th) {
        }
        bundle.putInt("_wwobject_sdkVer", 1);
    }
}
