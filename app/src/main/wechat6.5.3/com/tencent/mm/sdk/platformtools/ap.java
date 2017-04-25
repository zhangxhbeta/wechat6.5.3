package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ap {
    boolean bke;
    Object lock;
    String name;
    private int nkA;
    Vector<b> nkB;
    ac nkC;
    public LinkedBlockingQueue<a> nkz;
    int priority;

    public interface a {
        boolean AZ();

        boolean Ba();
    }

    final class b extends Thread {
        private int lis;
        final /* synthetic */ ap nkD;

        private b(ap apVar) {
            this.nkD = apVar;
            super(apVar.name);
            this.lis = 60;
            setPriority(apVar.priority);
            apVar.nkB.add(this);
        }

        public final void run() {
            while (this.lis > 0) {
                a aVar;
                synchronized (this.nkD.lock) {
                    try {
                        if (this.nkD.bke) {
                            this.nkD.lock.wait();
                        }
                    } catch (Throwable e) {
                        v.a("QueueWorkerThread.QueueWorkerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                try {
                    aVar = (a) this.nkD.nkz.poll(2000, TimeUnit.MILLISECONDS);
                } catch (Throwable e2) {
                    v.a("QueueWorkerThread.QueueWorkerThread", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    aVar = null;
                }
                if (aVar == null) {
                    this.lis--;
                } else {
                    this.lis = 60;
                    if (aVar.AZ()) {
                        this.nkD.nkC.sendMessage(this.nkD.nkC.obtainMessage(0, aVar));
                    }
                }
            }
            this.nkD.nkB.remove(this);
            v.d("QueueWorkerThread.QueueWorkerThread", "dktest Finish queueToReqSize:" + this.nkD.nkz.size() + " ThreadSize:" + this.nkD.nkB.size());
        }
    }

    public ap(int i, String str) {
        this(i, str, 1);
    }

    public ap(int i, String str, int i2) {
        this(i, str, i2, Looper.myLooper());
    }

    public ap(int i, String str, int i2, Looper looper) {
        this.nkz = new LinkedBlockingQueue();
        this.bke = false;
        this.nkA = 1;
        this.priority = 1;
        this.name = SQLiteDatabase.KeyEmpty;
        this.lock = new byte[0];
        this.nkB = new Vector();
        this.nkA = i2;
        this.name = str;
        this.priority = i;
        if (looper == null && Looper.myLooper() == null) {
            Looper.prepare();
            looper = Looper.myLooper();
        }
        this.nkC = new ac(this, looper) {
            final /* synthetic */ ap nkD;

            public final void handleMessage(Message message) {
                if (message != null && message.obj != null) {
                    ((a) message.obj).Ba();
                }
            }
        };
    }

    public final int c(a aVar) {
        if (aVar == null) {
            v.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
            return -1;
        }
        try {
            if (!this.nkz.offer(aVar, 1, TimeUnit.MILLISECONDS)) {
                v.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
                return -2;
            } else if (this.nkB.size() != 0 && (this.nkz.size() <= 0 || this.nkA <= this.nkB.size())) {
                return 0;
            } else {
                new b().start();
                return 0;
            }
        } catch (Throwable e) {
            v.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + e.getMessage());
            v.a("QueueWorkerThread.QueueWorkerThread", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return -3;
        }
    }

    @Deprecated
    public final boolean btK() {
        if (this.nkB == null || this.nkB.size() == 0) {
            return true;
        }
        return false;
    }

    public final void en(boolean z) {
        synchronized (this.lock) {
            this.bke = z;
            if (!z) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                }
            }
        }
    }
}
