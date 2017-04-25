package ct;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ay {
    public static int a = -1;
    public static int b = -1;
    private static int c = 20000;
    private static ThreadPoolExecutor d;

    static class a implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.d = str + "-" + a.getAndIncrement() + "-thread-";
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static class b implements Runnable {
        private CountDownLatch a = null;
        private c b = null;
        private ax c = null;

        public b(CountDownLatch countDownLatch, c cVar, ax axVar) {
            this.a = countDownLatch;
            this.b = cVar;
            this.c = axVar;
        }

        public final void run() {
            SocketAddress inetSocketAddress;
            InetAddress inetAddress = null;
            ax axVar = this.c;
            new StringBuilder("Thread:").append(Thread.currentThread().getName()).append(" isDaemon:").append(Thread.currentThread().isDaemon());
            bd.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (TextUtils.isEmpty(axVar.b)) {
                inetSocketAddress = new InetSocketAddress(axVar.g.a, axVar.g.b);
                axVar.e = 0;
            } else {
                try {
                    inetAddress = InetAddress.getByName(axVar.b);
                } catch (Exception e) {
                    e.getClass().getSimpleName();
                    axVar.d = "Dns InetAddress exception: domain" + axVar.b;
                }
                try {
                    axVar.e = (int) (System.currentTimeMillis() - currentTimeMillis);
                    inetSocketAddress = new InetSocketAddress(inetAddress.getHostAddress(), 14000);
                } catch (Exception e2) {
                    axVar.d = be.a(e2);
                } catch (Throwable th) {
                    return;
                }
            }
            Socket socket = new Socket();
            try {
                currentTimeMillis = System.currentTimeMillis();
                axVar.a = ct.b.a.b().b.a;
                socket.connect(inetSocketAddress, axVar.a);
                if (socket.isConnected() && !socket.isClosed()) {
                    axVar.c = socket;
                    axVar.f = (int) (System.currentTimeMillis() - currentTimeMillis);
                }
            } catch (Exception e22) {
                e22.getClass().getSimpleName();
                axVar.d = be.a(e22);
                axVar.f = (int) (System.currentTimeMillis() - 0);
                axVar.c = null;
            }
            System.currentTimeMillis();
            ay.a = this.c.e;
            ay.b = this.c.f;
            c cVar = this.b;
            ax axVar2 = this.c;
            if (axVar2 != null) {
                cVar.a.lock();
                if (cVar.b == null) {
                    cVar.b = axVar2;
                } else {
                    try {
                        axVar2.c.close();
                    } catch (IOException e3) {
                    }
                }
                cVar.a.unlock();
            }
            this.a.countDown();
        }
    }

    static class c {
        Lock a;
        ax b;

        private c() {
            this.a = new ReentrantLock();
            this.b = null;
        }
    }

    public static ax a(String str, int i) {
        ax axVar = null;
        if (str != null) {
            try {
                if (!SQLiteDatabase.KeyEmpty.equals(str)) {
                    axVar = b(str, i);
                }
            } catch (Exception e) {
            }
        }
        return axVar;
    }

    public static ax a(ArrayList arrayList, int i) {
        ax axVar = null;
        if (arrayList != null) {
            try {
                if (arrayList.size() > 0) {
                    axVar = a(arrayList, SQLiteDatabase.KeyEmpty, i);
                }
            } catch (Exception e) {
            }
        }
        return axVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ct.ax a(java.util.ArrayList r12, java.lang.String r13, int r14) {
        /*
        r10 = new java.util.concurrent.CountDownLatch;
        r0 = 1;
        r10.<init>(r0);
        r11 = new ct.ay$c;
        r0 = 0;
        r11.<init>();
        r9 = new ct.ax;
        r9.<init>();
        r0 = d;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        if (r0 != 0) goto L_0x0030;
    L_0x0015:
        r1 = new java.util.concurrent.ThreadPoolExecutor;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r2 = 3;
        r3 = 5;
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r7 = new java.util.concurrent.LinkedBlockingQueue;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = 5;
        r7.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r8 = new ct.ay$a;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = "HalleyAccess";
        r8.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r1.<init>(r2, r3, r4, r6, r7, r8);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        d = r1;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
    L_0x0030:
        r0 = a(r12, r13);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r1 = r0.iterator();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
    L_0x0038:
        r0 = r1.hasNext();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        if (r0 == 0) goto L_0x0057;
    L_0x003e:
        r0 = r1.next();	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = (ct.ax) r0;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r2 = new ct.ay$b;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r2.<init>(r10, r11, r0);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = d;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0.execute(r2);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        goto L_0x0038;
    L_0x004f:
        r0 = move-exception;
        r0 = "ThreadPool is full";
        r9.d = r0;
        r0 = r9;
    L_0x0056:
        return r0;
    L_0x0057:
        if (r14 < 0) goto L_0x005d;
    L_0x0059:
        r0 = c;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        if (r14 <= r0) goto L_0x005f;
    L_0x005d:
        r14 = c;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
    L_0x005f:
        r0 = (long) r14;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = r10.await(r0, r2);	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        if (r0 != 0) goto L_0x006f;
    L_0x0068:
        r0 = "latch wait too long";
        r9.d = r0;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        r0 = r9;
        goto L_0x0056;
    L_0x006f:
        r0 = r11.b;	 Catch:{ RejectedExecutionException -> 0x004f, InterruptedException -> 0x0072, Throwable -> 0x007a }
        goto L_0x0056;
    L_0x0072:
        r0 = move-exception;
        r0 = "countDownLatch InterruptedException";
        r9.d = r0;
        r0 = r9;
        goto L_0x0056;
    L_0x007a:
        r0 = move-exception;
        r0 = "Parallel connect failed";
        r9.d = r0;
        r0 = r9;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.ay.a(java.util.ArrayList, java.lang.String, int):ct.ax");
    }

    private static List a(ArrayList arrayList, String str) {
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            ax axVar = new ax();
            axVar.g = sVar;
            arrayList2.add(axVar);
        }
        if (!TextUtils.isEmpty(str)) {
            ax axVar2 = new ax();
            axVar2.b = str;
            arrayList2.add(axVar2);
        }
        return arrayList2;
    }

    public static void a() {
        if (d != null) {
            d.shutdownNow();
            d = null;
        }
    }

    private static ax b(String str, int i) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c cVar = new c();
        ax axVar = new ax();
        axVar.b = str;
        o.a().a(new b(countDownLatch, cVar, axVar));
        try {
            if (countDownLatch.await((long) i, TimeUnit.MILLISECONDS)) {
                axVar = cVar.b;
            } else {
                axVar.d = "latch wait too long";
            }
        } catch (InterruptedException e) {
        }
        return axVar;
    }
}
