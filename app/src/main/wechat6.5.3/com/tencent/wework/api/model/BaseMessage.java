package com.tencent.wework.api.model;

import android.content.Context;
import android.os.Bundle;

public abstract class BaseMessage {
    protected Context mContext = null;

    public abstract boolean checkArgs();

    public abstract void t(Bundle bundle);

    public final void setContext(Context context) {
        this.mContext = context;
    }

    public static Bundle b(BaseMessage baseMessage) {
        if (baseMessage == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        baseMessage.t(bundle);
        bundle.putString("_wwobject_identifier_", baseMessage.getClass().getName());
        return bundle;
    }
}
