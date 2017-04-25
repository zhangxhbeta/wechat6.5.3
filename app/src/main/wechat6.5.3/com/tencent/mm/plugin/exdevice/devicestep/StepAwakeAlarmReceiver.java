package com.tencent.mm.plugin.exdevice.devicestep;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class StepAwakeAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (context.getSharedPreferences("system_config_prefs", 4).getBoolean("settings_fully_exit", true)) {
                v.i("MicroMsg.exdevice.StepAwakeAlarmReceiver", "fully exited, no need to start service");
                return;
            }
            v.i("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step] alarm receive %s, %s", new Object[]{intent.getAction(), Boolean.valueOf(c.aiF())});
            if (!c.aiF()) {
                return;
            }
            if (r.getInt(103, 0) != 1) {
                v.i("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step] step swich if off");
                return;
            }
            d.bE(aa.getContext());
            ar(context);
        }
    }

    public static void ar(Context context) {
        v.w("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step]keep awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            v.e("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step]keep awaker failed, null am");
            return;
        }
        alarmManager.setRepeating(0, System.currentTimeMillis() + 3600000, 3600000, PendingIntent.getBroadcast(context, 0, new Intent(context, StepAwakeAlarmReceiver.class), 268435456));
    }

    public static void as(Context context) {
        v.w("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step]stop awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            v.e("MicroMsg.exdevice.StepAwakeAlarmReceiver", "[hakon][Step]keep awaker failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, StepAwakeAlarmReceiver.class), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
