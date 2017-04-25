package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.sdk.platformtools.y.b;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        y.a(new b() {
            public final void prepare() {
                TalkRoomReceiver.ap(aa.getContext());
            }

            public final void cancel() {
                TalkRoomReceiver.aq(aa.getContext());
            }
        });
    }

    public void onReceive(Context context, Intent intent) {
        v.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:" + intent.getBooleanExtra("MMBoot_Bump", false));
        ap(context);
    }

    public static void ap(Context context) {
        long btd = y.btd();
        v.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=" + btd);
        if (btd <= 600000) {
            if (btd < 30000) {
                btd = 30000;
            }
            v.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[]{Long.valueOf(btd), Long.valueOf(SystemClock.elapsedRealtime())});
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                v.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(2, btd + r4, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
        }
    }

    public static void aq(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            v.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
