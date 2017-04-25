package com.tencent.mm.kernel;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.v;

public final class h {
    public static void c(Context context, boolean z) {
        if (context == null) {
            v.e("MicroMsg.WeChatAppStatus", "editFullExitStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs", 4).edit().putBoolean("settings_fully_exit", z).commit();
        v.i("MicroMsg.WeChatAppStatus", "editFullExitStatus to " + z);
    }

    public static void d(Context context, boolean z) {
        if (context == null) {
            v.e("MicroMsg.WeChatAppStatus", "editShutDownWxStatus context == null");
            return;
        }
        context.getSharedPreferences("system_config_prefs_showdown", 4).edit().putBoolean("shut_down_weixin", z).commit();
        v.i("MicroMsg.WeChatAppStatus", "editShutDownWxStatus to " + z);
    }
}
