package com.tencent.mm.sdk.i;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e implements a {
    private static e nmF;
    static int[] nmG = new int[]{19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    static long nmH = 0;
    static long nmI = 0;
    private static b nmJ;
    private static a nmK;
    private static b nmL;
    private boolean aWE = false;
    volatile boolean beg = false;
    Object lock = new Object();
    private LinkedList<g> nmA = new LinkedList();
    private ArrayList<g> nmB = new ArrayList();
    private HashMap<g, Thread> nmC = new HashMap();
    private ArrayList<c> nmD = new ArrayList();
    private c nmE;
    private f nmx = new f(this.nmy + 2, TimeUnit.SECONDS, this.nmz, this);
    private int nmy = buG();
    private PriorityBlockingQueue<Runnable> nmz = new PriorityBlockingQueue(33);

    public interface b {
    }

    class a implements c {
        private final Runnable nmM;
        final /* synthetic */ e nmN;

        public a(e eVar, Runnable runnable) {
            this.nmN = eVar;
            this.nmM = runnable;
        }

        public final void p(Runnable runnable) {
            if (runnable.equals(this.nmM)) {
                synchronized (this.nmM) {
                    this.nmM.notifyAll();
                    e.c(this);
                }
            }
        }
    }

    class c extends ac {
        final /* synthetic */ e nmN;

        public c(e eVar, Looper looper) {
            this.nmN = eVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(message.what);
                    if (this.nmN.beg) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (e.nmH > 0 && Math.abs(e.nmI - currentTimeMillis) > e.nmH) {
                            v.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
                            e eVar = this.nmN;
                            synchronized (eVar.lock) {
                                eVar.beg = false;
                                e.nmI = 0;
                                e.nmH = 0;
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    e.a(this.nmN);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        synchronized (eVar.lock) {
            if (!eVar.nmA.isEmpty()) {
                Iterator it = eVar.nmA.iterator();
                if (it != null && it.hasNext()) {
                    g gVar = (g) it.next();
                    it.remove();
                    eVar.buH();
                    eVar.nmx.execute(gVar);
                    it = new ArrayList(eVar.nmD).iterator();
                    while (it.hasNext()) {
                        it.next();
                        Runnable runnable = gVar.nje;
                        eVar.nmx.getActiveCount();
                    }
                }
            }
            if (!eVar.nmA.isEmpty()) {
                eVar.nmE.sendEmptyMessage(1);
            }
        }
    }

    public static e buF() {
        if (nmF == null) {
            synchronized (e.class) {
                if (nmF == null) {
                    nmF = new e();
                }
            }
        }
        return nmF;
    }

    private e() {
        HandlerThread Lg = Lg("THREAD_POOL_HANDLER");
        Lg.start();
        this.nmE = new c(this, Lg.getLooper());
    }

    private static int buG() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 32) {
            return 32;
        }
        return availableProcessors;
    }

    public final void beforeExecute(Thread thread, Runnable runnable) {
        int i = 10;
        synchronized (this.lock) {
            Iterator it = this.nmB.iterator();
            if (it != null) {
                Object obj;
                g gVar = (g) runnable;
                int i2 = gVar.priority;
                if (i2 <= 0) {
                    i = 1;
                } else if (i2 <= 10) {
                    i = i2;
                }
                thread.setPriority(i);
                thread.setName(gVar.njf);
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    this.nmC.put(gVar, thread);
                    ArrayList arrayList = new ArrayList(this.nmD);
                    if (!this.aWE) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    this.aWE = true;
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        Runnable runnable2 = gVar.nje;
                    }
                }
            }
        }
    }

    public final void G(Runnable runnable) {
        synchronized (this.lock) {
            g gVar = (g) runnable;
            Iterator it = this.nmC.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Iterator it2 = new ArrayList(this.nmD).iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).p(gVar.nje);
                    }
                }
            }
            int activeCount = this.nmx.getActiveCount();
            int size = this.nmx.getQueue().size();
            int corePoolSize = this.nmx.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.nmy = buG();
                    this.nmx.setCorePoolSize(0);
                    this.nmx.setMaximumPoolSize(this.nmy + 2);
                }
                Iterator it3 = new ArrayList(this.nmD).iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                this.aWE = false;
            }
        }
    }

    public static void a(c cVar) {
        buF().b(cVar);
    }

    private void b(c cVar) {
        synchronized (this.lock) {
            if (!this.nmD.contains(cVar)) {
                this.nmD.add(cVar);
            }
        }
    }

    public static void c(c cVar) {
        e buF = buF();
        synchronized (buF.lock) {
            buF.nmD.remove(cVar);
        }
    }

    public static void a(Runnable runnable, String str) {
        buF().c(runnable, str, 5);
    }

    public static void b(Runnable runnable, String str, int i) {
        buF().c(runnable, str, i);
    }

    private void c(Runnable runnable, String str, int i) {
        synchronized (this.lock) {
            g gVar = new g(runnable, str, i, true, nmL);
            this.nmA.add(gVar);
            this.nmB.add(gVar);
            this.nmE.sendEmptyMessage(1);
            iz(false);
        }
    }

    public static void b(Runnable runnable, String str) {
        e buF = buF();
        synchronized (buF.lock) {
            Object gVar = new g(runnable, str, Integer.MAX_VALUE, true, nmL);
            buF.nmB.add(gVar);
            buF.nmx.execute(gVar);
            if (buF.nmx.getActiveCount() < buF.nmy || buF.nmy >= buG() * 2) {
                buF.buH();
            } else {
                buF.nmy++;
                buF.nmx.setCorePoolSize(buF.nmy);
                buF.nmx.setMaximumPoolSize(buF.nmy);
                v.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + buF.nmy);
            }
            Iterator it = new ArrayList(buF.nmD).iterator();
            while (it.hasNext()) {
                it.next();
                Runnable runnable2 = gVar.nje;
            }
            buF.iz(false);
        }
    }

    public static void H(Runnable runnable) {
        e buF = buF();
        synchronized (buF.lock) {
            Thread I = buF.I(runnable);
            if (I != null) {
                I.interrupt();
            } else {
                buF.O(runnable);
            }
        }
    }

    private Thread I(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        synchronized (this.lock) {
            Iterator it = this.nmC.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    obj = (g) it.next();
                    if (obj != null && obj.nje.equals(runnable)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Thread thread = (Thread) this.nmC.get(obj);
                    return thread;
                }
            }
            return null;
        }
    }

    public static void J(Runnable runnable) {
        buF().K(runnable);
    }

    private void K(Runnable runnable) {
        Assert.assertNotNull("join arg runnable is null!", runnable);
        Object obj = null;
        synchronized (this.lock) {
            if (N(runnable)) {
                obj = new a(this, runnable);
                b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (this.nmD.contains(obj)) {
                    runnable.wait();
                } else {
                    v.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static void L(Runnable runnable) {
        int i = 1;
        e buF = buF();
        Assert.assertNotNull("join arg runnable is null!", runnable);
        if (5000 < 0) {
            throw new IllegalArgumentException();
        }
        int i2;
        if (5000 >= 9223372036854L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (5000 != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            buF.K(runnable);
            return;
        }
        Object obj = null;
        synchronized (buF.lock) {
            if (buF.N(runnable)) {
                obj = new a(buF, runnable);
                buF().b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (buF.nmD.contains(obj)) {
                    runnable.wait(5000, 0);
                } else {
                    v.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static boolean M(Runnable runnable) {
        return buF().N(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean N(java.lang.Runnable r6) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        if (r6 != 0) goto L_0x0006;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = r5.lock;
        monitor-enter(r3);
        r0 = r5.nmB;	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x002a;
    L_0x0011:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x002a;
    L_0x0017:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.i.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x001f:
        r0 = r0.nje;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0011;
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x002a:
        r0 = r5.nmC;	 Catch:{ all -> 0x0052 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0052 }
        r4 = r0.iterator();	 Catch:{ all -> 0x0052 }
        if (r4 == 0) goto L_0x004f;
    L_0x0036:
        r0 = r4.hasNext();	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x004f;
    L_0x003c:
        r0 = r4.next();	 Catch:{ all -> 0x0052 }
        r0 = (com.tencent.mm.sdk.i.g) r0;	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x0044:
        r0 = r0.nje;	 Catch:{ all -> 0x0052 }
        r0 = r0.equals(r6);	 Catch:{ all -> 0x0052 }
        if (r0 == 0) goto L_0x0036;
    L_0x004c:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r2;
        goto L_0x0005;
    L_0x004f:
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        r0 = r1;
        goto L_0x0005;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0052 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.i.e.N(java.lang.Runnable):boolean");
    }

    public static boolean remove(Runnable runnable) {
        return buF().O(runnable);
    }

    private boolean O(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            Iterator it = this.nmB.iterator();
            if (it != null) {
                Runnable runnable2;
                while (it.hasNext()) {
                    runnable2 = (g) it.next();
                    if (runnable2 != null && runnable2.nje.equals(runnable)) {
                        it.remove();
                        break;
                    }
                }
                runnable2 = null;
                if (runnable2 != null) {
                    this.nmx.remove(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    private void buH() {
        if (this.nmx.getCorePoolSize() < this.nmy) {
            this.nmx.setCorePoolSize(this.nmy);
            this.nmx.setMaximumPoolSize(this.nmy);
        }
    }

    public static void buI() {
        buF().iz(true);
    }

    private void iz(boolean z) {
        if (z) {
            synchronized (this.lock) {
                v.i("MicroMsg.ThreadPool", "------------------------------------------");
                Iterator it = this.nmA.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        v.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + ((g) it.next()) + "}");
                    }
                }
                v.i("MicroMsg.ThreadPool", "-----------");
                it = this.nmB.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        v.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + ((g) it.next()) + "}");
                    }
                }
                v.i("MicroMsg.ThreadPool", "-----------");
                it = this.nmC.keySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        v.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + ((g) it.next()) + "}");
                    }
                }
                v.i("MicroMsg.ThreadPool", "-----------");
                v.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.nmx.getPoolSize() + "|activeCount=" + this.nmx.getActiveCount() + "|corePoolSize=" + this.nmx.getPoolSize() + "|largestPoolSize=" + this.nmx.getLargestPoolSize() + "|maximuPoolSize=" + this.nmx.getMaximumPoolSize());
                v.i("MicroMsg.ThreadPool", "------------------------------------------");
            }
        }
    }

    private static b buJ() {
        if (nmJ == null) {
            nmJ = new b(nmL);
        }
        return nmJ;
    }

    public static Thread c(Runnable runnable, String str) {
        return buJ().a(runnable, str, 5);
    }

    public static Thread d(Runnable runnable, String str, int i) {
        return buJ().a(runnable, str, i);
    }

    private static a buK() {
        if (nmK == null) {
            nmK = new a(nmL);
        }
        return nmK;
    }

    public static HandlerThread Lg(String str) {
        return buK().bI(str, 0);
    }

    public static HandlerThread bJ(String str, int i) {
        return buK().bI(str, i);
    }
}
