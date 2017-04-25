package android.support.v7.view;

import android.content.Context;
import android.support.v7.a.a.b;

public final class a {
    public Context mContext;

    public static a m(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    public final boolean dj() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 16) {
            return this.mContext.getResources().getBoolean(b.HT);
        }
        return this.mContext.getResources().getBoolean(b.HU);
    }

    public final boolean dk() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
}
