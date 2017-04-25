package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ExceptionMonitorService extends Service {
    public static long cvj = 0;
    public static int nfi = 0;
    private static ExceptionMonitorService nfm = null;
    private long nfj = 300000;
    private ac nfk = new ac();
    private Runnable nfl = new Runnable(this) {
        final /* synthetic */ ExceptionMonitorService nfn;

        {
            this.nfn = r1;
        }

        public final void run() {
            v.d("MicroMsg.CrashMonitorService", "stopSelf");
            this.nfn.stopSelf();
        }
    };

    public void onCreate() {
        super.onCreate();
        nfm = this;
        c.e(hashCode(), this);
        this.nfk.postDelayed(this.nfl, this.nfj);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        j(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        j(intent);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        nfm = null;
        c.f(hashCode(), this);
        this.nfk.removeCallbacks(this.nfl);
    }

    private void j(Intent intent) {
        if (intent != null) {
            this.nfk.removeCallbacks(this.nfl);
            this.nfk.postDelayed(this.nfl, this.nfj);
            String action = intent.getAction();
            v.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + action);
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                int intExtra = intent.getIntExtra("exceptionPid", 0);
                stringExtra.equals("exception");
                nfi = intExtra;
                cvj = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                v.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
                if (!be.kS(stringExtra2) && a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, be.Nh(), stringExtra2, booleanExtra)) == 0) {
                    dy(this);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.CrashMonitorService", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void dy(Context context) {
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, be.Ni() + 1800000, broadcast);
            v.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2));
        }
    }
}
