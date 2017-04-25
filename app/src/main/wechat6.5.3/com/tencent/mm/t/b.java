package com.tencent.mm.t;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public static String jHr;
    public static String jHs;

    public static void gr(String str) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "pref_appbrand_process", 4);
        String str2 = str + ":start_time";
        Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.commit();
        v.v("MicroMsg.AppBrandReporter", "onProcessExit");
    }
}
