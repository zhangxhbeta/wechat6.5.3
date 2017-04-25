package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class MMReceivers {

    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
                v.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + booleanExtra);
                if (booleanExtra) {
                    ap(context);
                } else if (!b.s(context, "alarm")) {
                    as(context);
                    v.bta();
                }
            }
        }

        public static void ap(Context context) {
            long btd = y.btd();
            v.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + btd);
            if (btd <= 1860000) {
                if (btd < 30000) {
                    btd = 30000;
                }
                v.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + btd);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                if (alarmManager == null) {
                    v.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                    return;
                }
                alarmManager.set(0, btd + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
            }
        }

        public static void aq(Context context) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                v.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }

        public static void ar(Context context) {
            v.w("MicroMsg.AlarmReceiver", "keep awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                v.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            int i = z.Ms() ? 300000 : 900000;
            alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.CREATE_IF_NECESSARY));
        }

        public static void as(Context context) {
            v.w("MicroMsg.AlarmReceiver", "stop awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                v.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                new StringBuilder("system booted, pid=").append(Process.myPid());
                if (!b.s(context, "auto")) {
                    AlarmReceiver.as(context);
                    v.bta();
                }
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                v.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
                if (!b.s(context, "connection")) {
                    AlarmReceiver.as(context);
                    v.bta();
                } else if (z.Mw() != null) {
                    NetworkInfo activeNetworkInfo;
                    try {
                        activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception e) {
                        v.i("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed.");
                        activeNetworkInfo = null;
                    }
                    com.tencent.mm.network.z.a Mw;
                    if (activeNetworkInfo == null || activeNetworkInfo.getState() != State.CONNECTED) {
                        v.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: false");
                        Mw = z.Mw();
                        if (activeNetworkInfo != null) {
                            activeNetworkInfo.getTypeName();
                        }
                        if (activeNetworkInfo != null) {
                            activeNetworkInfo.getSubtypeName();
                        }
                        Mw.ao(false);
                        return;
                    }
                    v.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                    Mw = z.Mw();
                    activeNetworkInfo.getTypeName();
                    activeNetworkInfo.getSubtypeName();
                    Mw.ao(true);
                }
            }
        }
    }

    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static a bXO = null;

        public static void a(a aVar) {
            bXO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (bXO != null) {
                bXO.onReceive(context, intent);
            }
        }
    }

    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static a bXO = null;

        public static void a(a aVar) {
            bXO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (bXO != null) {
                bXO.onReceive(context, intent);
            }
        }
    }

    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static a bXO = null;

        public static void a(a aVar) {
            bXO = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (bXO != null) {
                bXO.onReceive(context, intent);
            }
        }
    }

    public interface a {
        void onReceive(Context context, Intent intent);
    }
}
