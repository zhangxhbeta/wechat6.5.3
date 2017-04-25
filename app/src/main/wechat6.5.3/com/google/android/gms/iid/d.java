package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class d {
    static String arU = null;
    static int arV = 0;
    static int arW = 0;
    static int arX = 0;
    Map<String, Object> arY = new HashMap();
    Messenger arZ;
    PendingIntent aro;
    Messenger ars;
    MessengerCompat asa;
    long asb;
    long asc;
    int asd;
    int ase;
    long asf;
    Context context;

    public d(Context context) {
        this.context = context;
    }

    public static String H(Context context) {
        ApplicationInfo applicationInfo;
        if (arU != null) {
            return arU;
        }
        arV = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    new StringBuilder("Found ").append(applicationInfo2.uid);
                    arW = applicationInfo2.uid;
                    String str = resolveInfo.serviceInfo.packageName;
                    arU = str;
                    return str;
                } catch (NameNotFoundException e) {
                }
            } else {
                new StringBuilder("Possible malicious package ").append(resolveInfo.serviceInfo.packageName).append(" declares com.google.android.c2dm.intent.REGISTER without permission");
            }
        }
        try {
            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
            arU = applicationInfo.packageName;
            arW = applicationInfo.uid;
            return arU;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                arU = applicationInfo.packageName;
                arW = applicationInfo.uid;
                return arU;
            } catch (NameNotFoundException e3) {
                return null;
            }
        }
    }

    private static String a(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return a.c(instance.sign());
            } catch (GeneralSecurityException e) {
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    private void ab(Object obj) {
        synchronized (getClass()) {
            for (String str : this.arY.keySet()) {
                Object obj2 = this.arY.get(str);
                this.arY.put(str, obj);
                i(obj2, obj);
            }
        }
    }

    private synchronized void f(Intent intent) {
        if (this.aro == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aro = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.aro);
    }

    static String g(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        new StringBuilder("Unexpected response from GCM ").append(intent.getExtras());
        Throwable th = new Throwable();
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private static void i(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                new StringBuilder("Failed to send response ").append(e);
            }
        }
    }

    private void j(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.arY.get(str);
            this.arY.put(str, obj);
            i(obj2, obj);
        }
    }

    public static synchronized String kC() {
        String num;
        synchronized (d.class) {
            int i = arX;
            arX = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    final Intent a(Bundle bundle, KeyPair keyPair) {
        ConditionVariable conditionVariable = new ConditionVariable();
        String kC = kC();
        synchronized (getClass()) {
            this.arY.put(kC, conditionVariable);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.asf == 0 || elapsedRealtime > this.asf) {
            if (this.ars == null) {
                H(this.context);
                this.ars = new Messenger(new Handler(this, Looper.getMainLooper()) {
                    final /* synthetic */ d asg;

                    public final void handleMessage(Message message) {
                        d dVar = this.asg;
                        if (message != null && (message.obj instanceof Intent)) {
                            Intent intent = (Intent) message.obj;
                            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                            if (intent.hasExtra("google.messenger")) {
                                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                                if (parcelableExtra instanceof MessengerCompat) {
                                    dVar.asa = (MessengerCompat) parcelableExtra;
                                }
                                if (parcelableExtra instanceof Messenger) {
                                    dVar.arZ = (Messenger) parcelableExtra;
                                }
                            }
                            dVar.h((Intent) message.obj);
                        }
                    }
                });
            }
            if (arU == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            Object remove;
            Intent intent;
            this.asb = SystemClock.elapsedRealtime();
            Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent2.setPackage(arU);
            bundle.putString("gmsv", Integer.toString(a.D(this.context)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(a.E(this.context)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", a.a(keyPair));
            bundle.putString("pub2", a.c(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", a(keyPair, this.context.getPackageName(), r0));
            intent2.putExtras(bundle);
            f(intent2);
            this.asb = SystemClock.elapsedRealtime();
            intent2.putExtra("kid", "|ID|" + kC + "|");
            intent2.putExtra("X-kid", "|ID|" + kC + "|");
            boolean equals = "com.google.android.gsf".equals(arU);
            String stringExtra = intent2.getStringExtra("useGsf");
            if (stringExtra != null) {
                equals = "1".equals(stringExtra);
            }
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                new StringBuilder("Sending ").append(intent2.getExtras());
            }
            if (this.arZ != null) {
                intent2.putExtra("google.messenger", this.ars);
                Message obtain = Message.obtain();
                obtain.obj = intent2;
                try {
                    this.arZ.send(obtain);
                } catch (RemoteException e) {
                    Log.isLoggable("InstanceID/Rpc", 3);
                }
                conditionVariable.block(30000);
                synchronized (getClass()) {
                    remove = this.arY.remove(kC);
                    if (remove instanceof Intent) {
                        intent = (Intent) remove;
                    } else if (remove instanceof String) {
                        new StringBuilder("No response ").append(remove);
                        throw new IOException("TIMEOUT");
                    } else {
                        throw new IOException((String) remove);
                    }
                }
                return intent;
            }
            if (equals) {
                intent = new Intent("com.google.android.gms.iid.InstanceID");
                intent.setPackage(this.context.getPackageName());
                intent.putExtra("GSF", intent2);
                this.context.startService(intent);
            } else {
                intent2.putExtra("google.messenger", this.ars);
                intent2.putExtra("messenger2", "1");
                if (this.asa != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = intent2;
                    try {
                        MessengerCompat messengerCompat = this.asa;
                        if (messengerCompat.arR != null) {
                            messengerCompat.arR.send(obtain2);
                        } else {
                            messengerCompat.arS.send(obtain2);
                        }
                    } catch (RemoteException e2) {
                        Log.isLoggable("InstanceID/Rpc", 3);
                    }
                }
                this.context.startService(intent2);
            }
            conditionVariable.block(30000);
            synchronized (getClass()) {
                remove = this.arY.remove(kC);
                if (remove instanceof Intent) {
                    intent = (Intent) remove;
                } else if (remove instanceof String) {
                    new StringBuilder("No response ").append(remove);
                    throw new IOException("TIMEOUT");
                } else {
                    throw new IOException((String) remove);
                }
            }
            return intent;
        }
        new StringBuilder("Backoff mode, next request attempt: ").append(this.asf - elapsedRealtime).append(" interval: ").append(this.ase);
        throw new IOException("RETRY_LATER");
    }

    final void h(Intent intent) {
        if (intent == null) {
            Log.isLoggable("InstanceID/Rpc", 3);
            return;
        }
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            action = intent.getStringExtra("registration_id");
            String stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    new StringBuilder("Unexpected response, no error or registration id ").append(intent.getExtras());
                    return;
                }
                action = Log.isLoggable("InstanceID/Rpc", 3) ? null : null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if ("ID".equals(split[1])) {
                    }
                    if (split.length > 2) {
                        action = split[2];
                        stringExtra = split[3];
                        if (stringExtra.startsWith(":")) {
                            stringExtra = stringExtra.substring(1);
                        }
                    } else {
                        stringExtra = "UNKNOWN";
                    }
                    intent.putExtra("error", stringExtra);
                }
                if (action == null) {
                    ab(stringExtra);
                } else {
                    j(action, stringExtra);
                }
                long longExtra = intent.getLongExtra("Retry-After", 0);
                if (longExtra > 0) {
                    this.asc = SystemClock.elapsedRealtime();
                    this.ase = ((int) longExtra) * 1000;
                    this.asf = SystemClock.elapsedRealtime() + ((long) this.ase);
                    new StringBuilder("Explicit request from server to backoff: ").append(this.ase);
                    return;
                } else if (("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) && "com.google.android.gsf".equals(arU)) {
                    this.asd++;
                    if (this.asd >= 3) {
                        if (this.asd == 3) {
                            this.ase = new Random().nextInt(1000) + 1000;
                        }
                        this.ase *= 2;
                        this.asf = SystemClock.elapsedRealtime() + ((long) this.ase);
                        new StringBuilder("Backoff due to ").append(stringExtra).append(" for ").append(this.ase);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            this.asb = SystemClock.elapsedRealtime();
            this.asf = 0;
            this.asd = 0;
            this.ase = 0;
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                new StringBuilder("AppIDResponse: ").append(stringExtra).append(" ").append(intent.getExtras());
            }
            action = null;
            if (stringExtra.startsWith("|")) {
                String[] split2 = stringExtra.split("\\|");
                if ("ID".equals(split2[1])) {
                    stringExtra = split2[2];
                } else {
                    stringExtra = split2[2];
                }
                if (split2.length > 4) {
                    if ("SYNC".equals(split2[3])) {
                        InstanceIDListenerService.G(this.context);
                    } else if ("RST".equals(split2[3])) {
                        Context context = this.context;
                        a.F(this.context);
                        InstanceIDListenerService.a(context, a.ky());
                        intent.removeExtra("registration_id");
                        j(stringExtra, intent);
                        return;
                    }
                }
                action = split2[split2.length - 1];
                if (action.startsWith(":")) {
                    action = action.substring(1);
                }
                intent.putExtra("registration_id", action);
                action = stringExtra;
            }
            if (action == null) {
                ab(intent);
            } else {
                j(action, intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            new StringBuilder("Unexpected response ").append(intent.getAction());
        }
    }
}
