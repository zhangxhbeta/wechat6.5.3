package com.tencent.mm.plugin.wear.model;

import android.os.Process;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public final class j {
    BlockingQueue<d> lbN = new LinkedBlockingDeque();
    a lbO = new a();
    int lbP = -1;

    private class a implements Runnable {
        boolean eUv;
        final /* synthetic */ j lbQ;

        private a(j jVar) {
            this.lbQ = jVar;
        }

        public final void run() {
            this.lbQ.lbP = Process.myTid();
            v.i("MicroMsg.Wear.WearWorker", "start worker thread %d", new Object[]{Integer.valueOf(this.lbQ.lbP)});
            while (true) {
                d dVar;
                try {
                    dVar = (d) this.lbQ.lbN.take();
                } catch (InterruptedException e) {
                    dVar = null;
                }
                if (this.eUv) {
                    this.lbQ.lbP = -1;
                    v.i("MicroMsg.Wear.WearWorker", "stop worker thread %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
                    return;
                } else if (dVar != null) {
                    try {
                        dVar.run();
                    } catch (Exception e2) {
                        v.a("MicroMsg.Wear.WearWorker", e2.getCause(), "run task %s occur exception", new Object[]{dVar.getName()});
                    }
                }
            }
        }
    }

    public j() {
        if (com.tencent.mm.compatible.util.d.dY(18)) {
            e.d(this.lbO, "WearWorker_worker_thread", 1).start();
        }
    }

    public final void a(d dVar) {
        this.lbN.add(dVar);
    }
}
