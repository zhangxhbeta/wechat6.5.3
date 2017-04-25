package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.d;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static int ark = 5000000;
    public static int arl = 6500000;
    public static int arm = 7000000;
    static a arn;
    private static final AtomicInteger arq = new AtomicInteger(1);
    private PendingIntent aro;
    private Map<String, Handler> arp = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> arr = new LinkedBlockingQueue();
    final Messenger ars = new Messenger(new Handler(this, Looper.getMainLooper()) {
        final /* synthetic */ a art;

        public final void handleMessage(Message message) {
            if (message != null) {
                Object obj = message.obj;
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.art.arr.add(intent);
            } else if (!a.a(this.art, intent)) {
                intent.setPackage(this.art.context.getPackageName());
                this.art.context.sendBroadcast(intent);
            }
        }
    });
    private Context context;

    public static synchronized a C(Context context) {
        a aVar;
        synchronized (a.class) {
            if (arn == null) {
                aVar = new a();
                arn = aVar;
                aVar.context = context.getApplicationContext();
            }
            aVar = arn;
        }
        return aVar;
    }

    public static int D(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d.H(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    static /* synthetic */ boolean a(a aVar, Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) aVar.arp.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static String c(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? "gcm" : stringExtra;
    }

    private synchronized void d(Intent intent) {
        if (this.aro == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aro = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.aro);
    }

    @Deprecated
    private Intent i(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (D(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(d.H(this.context));
            d(intent);
            intent.putExtra("google.message_id", "google.rpc" + String.valueOf(arq.getAndIncrement()));
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.ars);
            this.context.startService(intent);
            try {
                return (Intent) this.arr.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d(intent);
        intent.setPackage(d.H(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(0));
        intent.putExtra("google.delay", Integer.toString(-1));
        if (d.H(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            com.google.android.gms.iid.a.F(this.context).b("GCM", "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    @Deprecated
    public final synchronized String b(String... strArr) {
        String d;
        Object obj = null;
        synchronized (this) {
            String stringBuilder = new StringBuilder(strArr[0]).toString();
            Bundle bundle = new Bundle();
            if (d.H(this.context).contains(".gsf")) {
                bundle.putString("legacy.sender", stringBuilder);
                com.google.android.gms.iid.a F = com.google.android.gms.iid.a.F(this.context);
                String str = "GCM";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    throw new IOException("MAIN_THREAD");
                }
                Object obj2 = 1;
                d = com.google.android.gms.iid.a.kA() ? null : com.google.android.gms.iid.a.arE.d(F.arH, stringBuilder, str);
                if (d == null) {
                    if (bundle.getString("ttl") != null) {
                        obj2 = null;
                    }
                    if (!"jwt".equals(bundle.getString("type"))) {
                        obj = obj2;
                    }
                    d = F.b(stringBuilder, str, bundle);
                    if (!(d == null || r0 == null)) {
                        com.google.android.gms.iid.a.arE.a(F.arH, stringBuilder, str, d, com.google.android.gms.iid.a.arJ);
                    }
                }
            } else {
                bundle.putString("sender", stringBuilder);
                Intent i = i(bundle);
                String str2 = "registration_id";
                if (i == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                d = i.getStringExtra(str2);
                if (d == null) {
                    String stringExtra = i.getStringExtra("error");
                    if (stringExtra != null) {
                        throw new IOException(stringExtra);
                    }
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
        }
        return d;
    }
}
