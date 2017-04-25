package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.w;

abstract class ae {
    private static volatile Handler ahU;
    final q afY;
    final Runnable ahV = new Runnable(this) {
        final /* synthetic */ ae ahY;

        {
            this.ahY = r1;
        }

        public final void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.ahY.afY.ia().c(this);
                return;
            }
            boolean iN = this.ahY.iN();
            this.ahY.ahW = 0;
            if (iN && !this.ahY.ahX) {
                this.ahY.run();
            }
        }
    };
    volatile long ahW;
    private boolean ahX;

    ae(q qVar) {
        w.Z(qVar);
        this.afY = qVar;
    }

    public final void cancel() {
        this.ahW = 0;
        getHandler().removeCallbacks(this.ahV);
    }

    final Handler getHandler() {
        if (ahU != null) {
            return ahU;
        }
        Handler handler;
        synchronized (ae.class) {
            if (ahU == null) {
                ahU = new Handler(this.afY.mContext.getMainLooper());
            }
            handler = ahU;
        }
        return handler;
    }

    public final boolean iN() {
        return this.ahW != 0;
    }

    public final void j(long j) {
        cancel();
        if (j >= 0) {
            this.ahW = this.afY.agn.currentTimeMillis();
            if (!getHandler().postDelayed(this.ahV, j)) {
                this.afY.hZ().g("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public abstract void run();
}
