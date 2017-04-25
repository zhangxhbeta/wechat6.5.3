package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.w;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah {
    private static volatile ah ayX;
    private volatile aj ahq;
    private final List<Object> ayY = new CopyOnWriteArrayList();
    private final ad ayZ = new ad();
    public final a aza = new a(this);
    public UncaughtExceptionHandler azb;
    public final Context mContext;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ae azc;
        final /* synthetic */ ah azd;

        public AnonymousClass1(ah ahVar, ae aeVar) {
            this.azd = ahVar;
            this.azc = aeVar;
        }

        public final void run() {
            this.azc.ayK.a(this.azc);
            Iterator it = this.azd.ayY.iterator();
            while (it.hasNext()) {
                it.next();
            }
            ah.d(this.azc);
        }
    }

    private class a extends ThreadPoolExecutor {
        final /* synthetic */ ah azd;

        public a(ah ahVar) {
            this.azd = ahVar;
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }

        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new FutureTask<T>(this, runnable, t) {
                final /* synthetic */ a aze;

                protected final void setException(Throwable th) {
                    UncaughtExceptionHandler b = this.aze.azd.azb;
                    if (b != null) {
                        b.uncaughtException(Thread.currentThread(), th);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        new StringBuilder("MeasurementExecutor: job failed with ").append(th);
                    }
                    super.setException(th);
                }
            };
        }
    }

    private static class b implements ThreadFactory {
        private static final AtomicInteger azf = new AtomicInteger();

        private b() {
        }

        public final Thread newThread(Runnable runnable) {
            return new c(runnable, "measurement-" + azf.incrementAndGet());
        }
    }

    private static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private ah(Context context) {
        Context applicationContext = context.getApplicationContext();
        w.Z(applicationContext);
        this.mContext = applicationContext;
    }

    public static ah L(Context context) {
        w.Z(context);
        if (ayX == null) {
            synchronized (ah.class) {
                if (ayX == null) {
                    ayX = new ah(context);
                }
            }
        }
        return ayX;
    }

    static /* synthetic */ void d(ae aeVar) {
        w.W("deliver should be called from worker thread");
        w.b(aeVar.ayL, "Measurement must be submitted");
        List<ai> list = aeVar.ayT;
        if (!list.isEmpty()) {
            Set hashSet = new HashSet();
            for (ai aiVar : list) {
                Uri iS = aiVar.iS();
                if (!hashSet.contains(iS)) {
                    hashSet.add(iS);
                    aiVar.b(aeVar);
                }
            }
        }
    }

    public static void if() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> a(Callable<V> callable) {
        w.Z(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.aza.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void c(Runnable runnable) {
        w.Z(runnable);
        this.aza.submit(runnable);
    }

    public final aj la() {
        if (this.ahq == null) {
            synchronized (this) {
                if (this.ahq == null) {
                    aj ajVar = new aj();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    ajVar.azg = packageName;
                    ajVar.azh = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                    ajVar.afG = packageName;
                    ajVar.afH = str;
                    this.ahq = ajVar;
                }
            }
        }
        return this.ahq;
    }
}
