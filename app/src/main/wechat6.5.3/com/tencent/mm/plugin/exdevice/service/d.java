package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public static boolean bE(Context context) {
        if (context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
            v.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(268435456);
        context.startService(intent);
        return true;
    }
}
