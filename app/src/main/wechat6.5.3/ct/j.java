package ct;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;

final class j {
    private static j a = null;
    private n b;
    private final BroadcastReceiver c = new k(this);
    private final BroadcastReceiver d = new m(this);

    class a implements Runnable {
        private /* synthetic */ j a;

        private a(j jVar) {
            this.a = jVar;
        }

        public final void run() {
            try {
                this.a.b();
                bd.b();
            } catch (Exception e) {
            }
        }
    }

    class b implements Runnable {
        private Intent a;
        private /* synthetic */ j b;

        b(j jVar, Intent intent) {
            this.b = jVar;
            this.a = intent;
        }

        public final void run() {
            try {
                this.b.a((NetworkInfo) this.a.getParcelableExtra("networkInfo"));
            } catch (Throwable th) {
            }
        }
    }

    j() {
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    public final void a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            String str = bc.b;
            bc.b();
            String str2 = bc.b;
            if (!str.equals(str2)) {
                if (str.equals(bc.a) && bc.e()) {
                    bd.b();
                    if (this.b != null) {
                        this.b.b();
                    } else {
                        bd.c();
                    }
                } else if (str2.equals(bc.a) || !bc.e()) {
                    bd.b();
                } else {
                    new StringBuilder("onTrigger：  apn1：").append(str).append(" ,apn2：").append(str2);
                    bd.b();
                    if (this.b != null) {
                        this.b.b();
                    } else {
                        bd.c();
                    }
                }
            }
        }
    }

    public final void a(n nVar) {
        this.b = nVar;
        p.a.registerReceiver(this.c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        bd.b();
        bd.b();
        p.a.registerReceiver(this.d, new IntentFilter("action.scheduler.access.trigger.timer"));
        AlarmManager alarmManager = (AlarmManager) p.a.getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.setRepeating(3, System.currentTimeMillis() + 1200000, 1200000, PendingIntent.getBroadcast(p.a, 0, new Intent("action.scheduler.access.trigger.timer"), 0));
            bd.a();
        }
    }

    public final void b() {
        if (this.b != null) {
            this.b.b();
        } else {
            bd.c();
        }
    }
}
