package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ad {
    private static final int sB = sH.bq();
    private static final Object sC = new Object();
    private static String sD;
    private static Set<String> sE = new HashSet();
    private static h sG;
    public static final b sH;
    private static final Object sLock = new Object();
    public final Context mContext;
    public final NotificationManager sF = ((NotificationManager) this.mContext.getSystemService("notification"));

    interface b {
        void a(NotificationManager notificationManager, String str, int i);

        void a(NotificationManager notificationManager, String str, int i, Notification notification);

        int bq();
    }

    private static class g {
        final ComponentName sK;
        final IBinder sL;

        public g(ComponentName componentName, IBinder iBinder) {
            this.sK = componentName;
            this.sL = iBinder;
        }
    }

    private static class h implements ServiceConnection, Callback {
        private final Context mContext;
        final Handler mHandler;
        private final HandlerThread sM;
        private final Map<ComponentName, a> sN = new HashMap();
        private Set<String> sO = new HashSet();

        private static class a {
            public int retryCount = 0;
            public final ComponentName sK;
            public boolean sP = false;
            public p sQ;
            public LinkedList<i> sR = new LinkedList();

            public a(ComponentName componentName) {
                this.sK = componentName;
            }
        }

        public h(Context context) {
            this.mContext = context;
            this.sM = new HandlerThread("NotificationManagerCompat");
            this.sM.start();
            this.mHandler = new Handler(this.sM.getLooper(), this);
        }

        public final boolean handleMessage(Message message) {
            a aVar;
            switch (message.what) {
                case 0:
                    Iterator it;
                    i iVar = (i) message.obj;
                    Set i = ad.i(this.mContext);
                    if (!i.equals(this.sO)) {
                        this.sO = i;
                        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                        Set<ComponentName> hashSet = new HashSet();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (i.contains(resolveInfo.serviceInfo.packageName)) {
                                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                                if (resolveInfo.serviceInfo.permission != null) {
                                    new StringBuilder("Permission present on component ").append(componentName).append(", not adding listener record.");
                                } else {
                                    hashSet.add(componentName);
                                }
                            }
                        }
                        for (ComponentName componentName2 : hashSet) {
                            if (!this.sN.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Adding listener record for ").append(componentName2);
                                }
                                this.sN.put(componentName2, new a(componentName2));
                            }
                        }
                        it = this.sN.entrySet().iterator();
                        while (it.hasNext()) {
                            Entry entry = (Entry) it.next();
                            if (!hashSet.contains(entry.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Removing listener record for ").append(entry.getKey());
                                }
                                a((a) entry.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (a aVar2 : this.sN.values()) {
                        aVar2.sR.add(iVar);
                        c(aVar2);
                    }
                    return true;
                case 1:
                    g gVar = (g) message.obj;
                    ComponentName componentName3 = gVar.sK;
                    IBinder iBinder = gVar.sL;
                    aVar = (a) this.sN.get(componentName3);
                    if (aVar != null) {
                        aVar.sQ = android.support.v4.app.p.a.a(iBinder);
                        aVar.retryCount = 0;
                        c(aVar);
                    }
                    return true;
                case 2:
                    aVar = (a) this.sN.get((ComponentName) message.obj);
                    if (aVar != null) {
                        a(aVar);
                    }
                    return true;
                case 3:
                    aVar = (a) this.sN.get((ComponentName) message.obj);
                    if (aVar != null) {
                        c(aVar);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.mHandler.obtainMessage(1, new g(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void a(a aVar) {
            if (aVar.sP) {
                this.mContext.unbindService(this);
                aVar.sP = false;
            }
            aVar.sQ = null;
        }

        private void b(a aVar) {
            if (!this.mHandler.hasMessages(3, aVar.sK)) {
                aVar.retryCount++;
                if (aVar.retryCount > 6) {
                    new StringBuilder("Giving up on delivering ").append(aVar.sR.size()).append(" tasks to ").append(aVar.sK).append(" after ").append(aVar.retryCount).append(" retries");
                    aVar.sR.clear();
                    return;
                }
                int i = (1 << (aVar.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    new StringBuilder("Scheduling retry for ").append(i).append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, aVar.sK), (long) i);
            }
        }

        private void c(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Processing component ").append(aVar.sK).append(", ").append(aVar.sR.size()).append(" queued tasks");
            }
            if (!aVar.sR.isEmpty()) {
                boolean z;
                if (aVar.sP) {
                    z = true;
                } else {
                    aVar.sP = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.sK), this, ad.sB);
                    if (aVar.sP) {
                        aVar.retryCount = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(aVar.sK);
                        this.mContext.unbindService(this);
                    }
                    z = aVar.sP;
                }
                if (!z || aVar.sQ == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    i iVar = (i) aVar.sR.peek();
                    if (iVar == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(iVar);
                        }
                        iVar.a(aVar.sQ);
                        aVar.sR.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(aVar.sK);
                        }
                    } catch (RemoteException e2) {
                        new StringBuilder("RemoteException communicating with ").append(aVar.sK);
                    }
                }
                if (!aVar.sR.isEmpty()) {
                    b(aVar);
                }
            }
        }
    }

    private interface i {
        void a(p pVar);
    }

    private static class a implements i {
        final int id;
        final String packageName;
        final boolean sI = false;
        final String tag = null;

        public a(String str, int i, String str2) {
            this.packageName = str;
            this.id = i;
        }

        public final void a(p pVar) {
            if (this.sI) {
                pVar.l(this.packageName);
            } else {
                pVar.b(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.sI);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static class c implements b {
        c() {
        }

        public void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int bq() {
            return 1;
        }
    }

    private static class f implements i {
        final int id;
        final String packageName;
        final Notification sJ;
        final String tag = null;

        public f(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.sJ = notification;
        }

        public final void a(p pVar) {
            pVar.a(this.packageName, this.id, this.tag, this.sJ);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(null, i);
        }

        public final void a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(null, i, notification);
        }
    }

    static class e extends d {
        e() {
        }

        public final int bq() {
            return 33;
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            sH = new e();
        } else if (VERSION.SDK_INT >= 5) {
            sH = new d();
        } else {
            sH = new c();
        }
    }

    public static ad h(Context context) {
        return new ad(context);
    }

    private ad(Context context) {
        this.mContext = context;
    }

    public static Set<String> i(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(sD))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (sC) {
                sE = hashSet;
                sD = string;
            }
        }
        return sE;
    }

    public final void a(i iVar) {
        synchronized (sLock) {
            if (sG == null) {
                sG = new h(this.mContext.getApplicationContext());
            }
        }
        sG.mHandler.obtainMessage(0, iVar).sendToTarget();
    }
}
