package com.tencent.mm.sdk.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class az<R> {
    private final long cAo;
    long ctK;
    private Object lock;
    private Runnable nje;
    long nlq;
    boolean nlr;
    private R result;

    public abstract R run();

    public az() {
        this(0, null);
    }

    public az(long j, R r, boolean z) {
        this.lock = new Object();
        this.nlr = false;
        this.nje = new Runnable(this) {
            final /* synthetic */ az nls;

            {
                this.nls = r1;
            }

            public final void run() {
                v.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + this.nls.nlr);
                if (this.nls.nlr) {
                    this.nls.run();
                } else {
                    this.nls.bd(this.nls.run());
                }
                this.nls.nlq = be.az(this.nls.ctK);
            }
        };
        this.cAo = j;
        this.result = r;
        this.nlr = true;
    }

    public az(long j, R r) {
        this.lock = new Object();
        this.nlr = false;
        this.nje = /* anonymous class already generated */;
        this.cAo = j;
        this.result = r;
    }

    public final void bd(R r) {
        v.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            v.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R c(ac acVar) {
        if (acVar == null) {
            v.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        v.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == acVar.getLooper().getThread().getId()) {
            v.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.ctK = be.Nj();
        try {
            synchronized (this.lock) {
                v.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                acVar.post(this.nje);
                this.lock.wait(this.cAo);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.SyncTask", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        long az = be.az(this.ctK);
        v.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", this.result, Long.valueOf(az), Long.valueOf(this.nlq), Long.valueOf(az - this.nlq));
        return this.result;
    }
}
