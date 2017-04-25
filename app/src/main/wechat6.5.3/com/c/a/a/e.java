package com.c.a.a;

import android.os.Handler;

abstract class e {
    private a aHu;
    long aHv;
    final Handler handler;

    private class a implements Runnable {
        private boolean aHw;
        final /* synthetic */ e aHx;
        private boolean started;

        private a(e eVar) {
            this.aHx = eVar;
        }

        public final void run() {
            if (!this.aHw) {
                this.aHx.ne();
                this.aHx.handler.postDelayed(this, this.aHx.aHv);
            }
        }

        static /* synthetic */ void a(a aVar, long j) {
            if (!aVar.started && !aVar.aHw) {
                aVar.aHx.handler.postDelayed(aVar, j);
                aVar.started = true;
            }
        }

        static /* synthetic */ void a(a aVar) {
            aVar.aHw = true;
            aVar.aHx.handler.removeCallbacks(aVar);
        }
    }

    abstract void ne();

    e(Handler handler) {
        if (handler == null) {
            handler = new Handler();
        }
        this.handler = handler;
    }

    final void b(long j, long j2) {
        stop();
        this.aHv = j;
        this.aHu = new a();
        a.a(this.aHu, j2);
    }

    final void stop() {
        if (this.aHu != null) {
            a.a(this.aHu);
        }
    }
}
