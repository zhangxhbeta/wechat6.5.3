package com.tencent.mm.a;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class b {
    static ac aPK;
    File aPH;
    private ReentrantLock aPI = new ReentrantLock();
    private Condition aPJ = this.aPI.newCondition();

    public b(final String str) {
        synchronized (b.class) {
            if (aPK == null) {
                HandlerThread handlerThread = new HandlerThread("I/O Worker");
                handlerThread.start();
                aPK = new ac(handlerThread.getLooper());
            }
        }
        File file = new File(str);
        if (file.exists()) {
            this.aPH = file;
            return;
        }
        v.i("MicroMsg.ConcurrentFileBuilder", "create new file %s", str);
        aPK.post(new Runnable(this) {
            final /* synthetic */ b aPM;

            public final void run() {
                File file = new File(str);
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.aW(str);
                    v.i("MicroMsg.ConcurrentFileBuilder", "make dir last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    currentTimeMillis = System.currentTimeMillis();
                    try {
                        file.createNewFile();
                    } catch (Throwable e) {
                        v.a("MicroMsg.ConcurrentFileBuilder", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        v.a("MicroMsg.ConcurrentFileBuilder", e, "createNewFile", new Object[0]);
                    }
                    v.i("MicroMsg.ConcurrentFileBuilder", "make file last %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                this.aPM.aPI.lock();
                try {
                    this.aPM.aPH = file;
                    this.aPM.aPJ.signal();
                    v.i("MicroMsg.ConcurrentFileBuilder", "notify file prepared %s", file.getAbsoluteFile());
                } finally {
                    this.aPM.aPI.unlock();
                }
            }
        });
    }

    public final File nY() {
        this.aPI.lock();
        while (this.aPH == null) {
            try {
                v.i("MicroMsg.ConcurrentFileBuilder", "getFile await");
                this.aPJ.await();
            } catch (Exception e) {
            } finally {
                this.aPI.unlock();
            }
        }
        return this.aPH;
    }
}
