package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.i.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public class ad {
    private static ac niG = null;
    private ac fMX = null;
    public HandlerThread htb = null;
    private String niH = null;

    public interface a {
        boolean AZ();

        boolean Ba();
    }

    public interface b {
        void vC();
    }

    private void Kl(String str) {
        this.fMX = null;
        if (be.kS(str)) {
            str = "MMHandlerThread";
        }
        this.niH = str;
        this.htb = e.bJ(this.niH, 0);
        this.htb.start();
    }

    public static void va(int i) {
        try {
            Process.setThreadPriority(i);
            v.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d ok", Integer.valueOf(i));
        } catch (Throwable e) {
            v.i("MicroMsg.MMHandlerThread", "setCurrentPriority to %d fail, %s", Integer.valueOf(i), e.getMessage());
            v.a("MicroMsg.MMHandlerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final void btt() {
        if (this.htb == null || !this.htb.isAlive()) {
            v.e("MicroMsg.MMHandlerThread", "setLowestPriority failed thread is dead");
            return;
        }
        int threadId = this.htb.getThreadId();
        try {
            if (19 == Process.getThreadPriority(threadId)) {
                v.w("MicroMsg.MMHandlerThread", "setLowestPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 19);
            v.i("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            v.w("MicroMsg.MMHandlerThread", "thread:%d setLowestPriority failed", Integer.valueOf(threadId));
            v.a("MicroMsg.MMHandlerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final void btu() {
        if (this.htb == null || !this.htb.isAlive()) {
            v.e("MicroMsg.MMHandlerThread", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.htb.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                v.w("MicroMsg.MMHandlerThread", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            v.i("MicroMsg.MMHandlerThread", "thread:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            v.w("MicroMsg.MMHandlerThread", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            v.a("MicroMsg.MMHandlerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final boolean btv() {
        if (this.htb == null || !this.htb.isAlive()) {
            v.e("MicroMsg.MMHandlerThread", "check inHighPriority failed thread is dead");
            return false;
        }
        int threadId = this.htb.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                return true;
            }
        } catch (Throwable e) {
            v.w("MicroMsg.MMHandlerThread", "thread:%d  check inHighPriority failed", Integer.valueOf(threadId));
            v.a("MicroMsg.MMHandlerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return false;
    }

    public final void btw() {
        if (this.htb == null || !this.htb.isAlive()) {
            v.e("MicroMsg.MMHandlerThread", "setLowPriority failed thread is dead");
            return;
        }
        int threadId = this.htb.getThreadId();
        try {
            if (Process.getThreadPriority(threadId) == 0) {
                v.w("MicroMsg.MMHandlerThread", "setLowPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, 0);
            v.i("MicroMsg.MMHandlerThread", "thread:%d setLowPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            v.w("MicroMsg.MMHandlerThread", "thread:%d setLowPriority failed", Integer.valueOf(threadId));
            v.a("MicroMsg.MMHandlerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public ad() {
        v.i("MicroMsg.MMHandlerThread", "init stack:%s", be.bur());
        Kl(null);
    }

    public ad(String str) {
        Kl(str);
    }

    public final ac btx() {
        if (this.fMX == null) {
            this.fMX = new ac(this.htb.getLooper());
        }
        return this.fMX;
    }

    public final int a(final b bVar) {
        int a;
        v.i("MicroMsg.MMHandlerThread", "syncReset stack:%s", be.bur());
        Assert.assertTrue("syncReset should in mainThread", isMainThread());
        long id = this.htb.getId();
        final Object obj = new byte[0];
        final String str = this.niH;
        a anonymousClass1 = new a(this) {
            final /* synthetic */ ad niL;

            public final boolean Ba() {
                v.d("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
                return true;
            }

            public final boolean AZ() {
                v.d("MicroMsg.MMHandlerThread", "syncReset doInBackground");
                this.niL.htb.quit();
                if (bVar != null) {
                    bVar.vC();
                }
                v.d("MicroMsg.MMHandlerThread", "syncReset init start tid[%d]", Long.valueOf(this.niL.htb.getId()));
                this.niL.Kl(str);
                v.d("MicroMsg.MMHandlerThread", "syncReset init done tid[%d]", Long.valueOf(this.niL.htb.getId()));
                synchronized (obj) {
                    v.d("MicroMsg.MMHandlerThread", "syncReset notify");
                    obj.notify();
                }
                return true;
            }
        };
        synchronized (obj) {
            a = a(anonymousClass1);
            v.i("MicroMsg.MMHandlerThread", "syncReset postAtFrontOfWorker ret[%d], oldTid[%d], curTid[%d]", Integer.valueOf(a), Long.valueOf(id), Long.valueOf(this.htb.getId()));
            if (a == 0 && id == r4) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    v.d("MicroMsg.MMHandlerThread", "syncReset lock wait end with exception[%s]", e.getMessage());
                }
            }
        }
        return a;
    }

    public int x(Runnable runnable) {
        if (runnable == null) {
            return -1;
        }
        btx().post(runnable);
        return 0;
    }

    public final int A(Runnable runnable) {
        btx().postAtFrontOfQueueV2(runnable);
        return 0;
    }

    public final int f(Runnable runnable, long j) {
        if (runnable == null) {
            return -1;
        }
        btx().postDelayed(runnable, j);
        return 0;
    }

    public final int a(final a aVar) {
        return new ac(this.htb.getLooper()).postAtFrontOfQueueV2(new Runnable(this) {
            final /* synthetic */ ad niL;

            public final void run() {
                aVar.AZ();
                ad.bty().postAtFrontOfQueueV2(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 niN;

                    {
                        this.niN = r1;
                    }

                    public final void run() {
                        aVar.Ba();
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|" + aVar.toString();
            }
        }) ? 0 : -2;
    }

    public static boolean isMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    private static ac bty() {
        if (niG == null) {
            niG = new ac(Looper.getMainLooper());
        }
        return niG;
    }

    public static void o(Runnable runnable) {
        if (runnable != null) {
            bty().post(runnable);
        }
    }

    public static void g(Runnable runnable, long j) {
        if (runnable != null) {
            bty().postDelayed(runnable, j);
        }
    }

    public static void B(Runnable runnable) {
        if (runnable != null) {
            bty().removeCallbacks(runnable);
        }
    }
}
