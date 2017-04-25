package com.tencent.mm.protocal;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    public static void c(Context context, boolean z) {
        h.c(context, true);
    }

    public static boolean dr(Context context) {
        if (context != null) {
            return context.getSharedPreferences("system_config_prefs_showdown", 4).getBoolean("shut_down_weixin", false);
        }
        v.e("MicroMsg.WeChatAppStatus", "getShutDownWxStatus context == null");
        return false;
    }
}
