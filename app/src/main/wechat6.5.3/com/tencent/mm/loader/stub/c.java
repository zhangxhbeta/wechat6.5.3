package com.tencent.mm.loader.stub;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;

public class c {
    public static c cnl = new c(null);
    public final SharedPreferences cnm;

    public c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.cnm = aa.getContext().getSharedPreferences(aa.bti(), 0);
        } else {
            this.cnm = sharedPreferences;
        }
    }

    public final String A(String str, String str2) {
        return this.cnm.getString(str, str2);
    }
}
