package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.c.aa;
import com.google.android.gms.c.u;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.stats.c.a;
import com.tencent.mmdb.FileUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Object apf = new Object();
    private static Integer aqA;
    private static b aqt;
    private static final ComponentName aqy = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    private final List<String> aqu;
    private final List<String> aqv;
    private final List<String> aqw;
    private final List<String> aqx;
    private e aqz;

    private b() {
        if (getLogLevel() == d.LOG_LEVEL_OFF) {
            this.aqu = Collections.EMPTY_LIST;
            this.aqv = Collections.EMPTY_LIST;
            this.aqw = Collections.EMPTY_LIST;
            this.aqx = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) a.aqD.get();
        this.aqu = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aqE.get();
        this.aqv = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aqF.get();
        this.aqw = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aqG.get();
        this.aqx = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.aqz = new e(((Long) a.aqH.get()).longValue());
    }

    private static ServiceInfo b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, FileUtils.S_IWUSR);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.bS(20)});
            return null;
        }
        if (queryIntentServices.size() > 1) {
            String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.bS(20)});
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                String str = ((ResolveInfo) it.next()).serviceInfo.name;
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private static int getLogLevel() {
        if (aqA == null) {
            try {
                aqA = Integer.valueOf(u.kP() ? ((Integer) a.aqC.get()).intValue() : d.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                aqA = Integer.valueOf(d.LOG_LEVEL_OFF);
            }
        }
        return aqA.intValue();
    }

    public static b kr() {
        synchronized (apf) {
            if (aqt == null) {
                aqt = new b();
            }
        }
        return aqt;
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, serviceConnection, null, null, 1);
    }

    public final void a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        if (f.aob) {
            Object obj;
            String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
            int logLevel = getLogLevel();
            if (logLevel == d.LOG_LEVEL_OFF || this.aqz == null) {
                obj = null;
            } else if (i == 4 || i == 1) {
                obj = this.aqz.Z(valueOf) ? 1 : null;
            } else {
                ServiceInfo b = b(context, intent);
                if (b == null) {
                    String.format("Client %s made an invalid request %s", new Object[]{str, intent.toUri(0)});
                    obj = null;
                } else {
                    String J = aa.J(context);
                    String str2 = b.processName;
                    String str3 = b.name;
                    if (this.aqu.contains(J) || this.aqv.contains(str) || this.aqw.contains(str2) || this.aqx.contains(str3) || (str2.equals(J) && (logLevel & d.aqM) != 0)) {
                        obj = null;
                    } else {
                        this.aqz.Y(valueOf);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Parcelable connectionEvent;
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = null;
                if ((getLogLevel() & d.aqL) != 0) {
                    str4 = aa.bS(5);
                }
                long j = 0;
                if ((getLogLevel() & d.aqN) != 0) {
                    j = Debug.getNativeHeapAllocatedSize();
                }
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str4, valueOf, SystemClock.elapsedRealtime(), j);
                } else {
                    ServiceInfo b2 = b(context, intent);
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, aa.J(context), str, b2.processName, b2.name, str4, valueOf, SystemClock.elapsedRealtime(), j);
                }
                context.startService(new Intent().setComponent(aqy).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean h = (component == null || (f.aob && "com.google.android.gms".equals(component.getPackageName()))) ? false : u.h(context, component.getPackageName());
        if (h) {
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, serviceConnection, str, intent, 2);
        }
        return bindService;
    }
}
