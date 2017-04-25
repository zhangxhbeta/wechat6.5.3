package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class Res {
    private static final String TAG = "Res";
    protected final String RclassName = (this.ctx.getPackageName() + ".R");
    protected Context ctx;

    public Res(Context context) {
        this.ctx = context;
    }

    private int reflectResouce(String str, String str2) {
        int i = -1;
        if (this.RclassName == null || str == null || str2 == null) {
            return 0;
        }
        try {
            Class cls = Class.forName(this.RclassName + "$" + str);
            return be.getInt(cls.getField(str2).get(cls.newInstance()).toString(), -1);
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
            return i;
        }
    }

    public int string(String str) {
        return reflectResouce("string", str);
    }

    public int drawable(String str) {
        return reflectResouce("drawable", str);
    }

    public int layout(String str) {
        return reflectResouce("layout", str);
    }

    public int id(String str) {
        return reflectResouce(SlookAirButtonFrequentContactAdapter.ID, str);
    }

    public int style(String str) {
        return reflectResouce("style", str);
    }
}
