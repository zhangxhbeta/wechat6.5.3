package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.gcm.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String arM = "google.com/iid";
    private static String arN = "CMD";
    private static String ari = "gcm.googleapis.com/refresh";
    MessengerCompat arK = new MessengerCompat(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ InstanceIDListenerService arQ;

        public final void handleMessage(Message message) {
            InstanceIDListenerService.a(this.arQ, message, MessengerCompat.c(message));
        }
    });
    BroadcastReceiver arL = new BroadcastReceiver(this) {
        final /* synthetic */ InstanceIDListenerService arQ;

        {
            this.arQ = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                new StringBuilder("Received GSF callback using dynamic receiver: ").append(intent.getExtras());
            }
            this.arQ.e(intent);
            this.arQ.stop();
        }
    };
    int arO;
    int arP;

    static void G(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(arN, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, e eVar) {
        eVar.kD();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(arN, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    static /* synthetic */ void a(InstanceIDListenerService instanceIDListenerService, Message message, int i) {
        d.H(instanceIDListenerService);
        instanceIDListenerService.getPackageManager();
        if (i == d.arW || i == d.arV) {
            instanceIDListenerService.e((Intent) message.obj);
        } else {
            new StringBuilder("Message from unexpected caller ").append(i).append(" mine=").append(d.arV).append(" appid=").append(d.arW);
        }
    }

    public final void e(Intent intent) {
        a F;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            F = a.F(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            F = a.a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(arN);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                a.ky().ac(stringExtra == null ? SQLiteDatabase.KeyEmpty : stringExtra);
                a.kz().h(intent);
                return;
            } else if (ari.equals(intent.getStringExtra("from"))) {
                a.ky().ac(stringExtra);
                return;
            } else if ("RST".equals(stringExtra2)) {
                F.arI = 0;
                a.arE.ab(F.arH + "|");
                F.arG = null;
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!a.ky().isEmpty()) {
                    a.ky().kD();
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                a.ky().ac(stringExtra);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    a.C(this).a(arM, d.kC(), intent.getExtras());
                    return;
                } catch (IOException e) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            a.kz().h(intent);
        } else {
            a.kz().h(intent);
        }
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.arK.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.arL, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.arL);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            this.arO++;
            if (i2 > this.arP) {
                this.arP = i2;
            }
        }
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                e(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.b(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    final void stop() {
        synchronized (this) {
            this.arO--;
            if (this.arO == 0) {
                stopSelf(this.arP);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Stop ").append(this.arO).append(" ").append(this.arP);
            }
        }
    }
}
