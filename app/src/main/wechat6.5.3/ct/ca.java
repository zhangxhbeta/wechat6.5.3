package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ca extends BroadcastReceiver {
    private final bk a;
    private boolean b;
    private ExecutorService c;
    private a d;

    class a implements Runnable {
        private Context a;
        private Intent b;
        private /* synthetic */ ca c;

        public a(ca caVar, Context context) {
            this.c = caVar;
            this.a = context;
        }

        public final void a(Intent intent) {
            this.b = intent;
        }

        public final void run() {
            boolean booleanExtra = this.b.getBooleanExtra("noConnectivity", false);
            ct.b.a.b("TxNetworkStateMonitor", "listenNetworkState: call is running");
            if (booleanExtra) {
                this.c.a.c(Integer.valueOf(-1));
            } else if (ct.b.a.b(this.a)) {
                this.c.a.c(Integer.valueOf(1));
            } else {
                this.c.a.c(Integer.valueOf(0));
            }
        }
    }

    public ca(bk bkVar) {
        this.a = bkVar;
    }

    public final void a() {
        if (!this.b) {
            this.b = true;
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.c = Executors.newFixedThreadPool(1);
                this.d = new a(this, this.a.a);
                this.a.a.registerReceiver(this, intentFilter);
            } catch (Throwable e) {
                ct.b.a.a("TxNetworkStateMonitor", "listenNetworkState: failed", e);
            }
        }
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            try {
                this.a.a.unregisterReceiver(this);
                this.c.shutdown();
            } catch (Exception e) {
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                this.d.a(intent);
                this.c.execute(this.d);
            } catch (Throwable e) {
                ct.b.a.a("TxNetworkStateMonitor", "listenNetworkState: Exception", e);
            }
        }
    }
}
