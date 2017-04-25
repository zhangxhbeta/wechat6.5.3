package com.tencent.mm.plugin.ipcall.a.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public abstract class b extends a implements com.tencent.mm.plugin.ipcall.a.a.a.a {
    protected boolean gFD = false;
    public a gFE = null;
    private ac mHandler = new ac(Looper.getMainLooper());

    public interface a {
        void a(int i, k kVar, int i2, int i3);

        void b(int i, k kVar, int i2, int i3);
    }

    public abstract void auA();

    public abstract int auy();

    public abstract void auz();

    public abstract void b(c cVar);

    public abstract void onStop();

    public final void init() {
        this.gFC = this;
        super.init();
    }

    public final void destroy() {
        super.destroy();
    }

    public final void a(c cVar) {
        super.a(cVar);
        this.gFD = true;
        v.d("MicroMsg.BaseIPCallTimerService", "start service, type: %d", new Object[]{Integer.valueOf(CV())});
    }

    public final void stop() {
        this.gFD = false;
        onStop();
        v.d("MicroMsg.BaseIPCallTimerService", "stop service, type: %d", new Object[]{Integer.valueOf(CV())});
    }

    public final void a(int i, Object obj, int i2, int i3) {
        v.i("MicroMsg.BaseIPCallTimerService", "timer request success!, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.gFD), Integer.valueOf(auy())});
        auz();
        if (this.gFE != null) {
            this.gFE.a(i, (k) obj, i2, i3);
        }
        if (this.gFD) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ b gFF;

                {
                    this.gFF = r1;
                }

                public final void run() {
                    this.gFF.b(this.gFF.gFa);
                }
            }, (long) auy());
        }
    }

    public final void b(int i, Object obj, int i2, int i3) {
        v.i("MicroMsg.BaseIPCallTimerService", "timer request failed, type: %d, isLoop: %b, interval: %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.gFD), Integer.valueOf(auy())});
        auA();
        if (this.gFE != null) {
            this.gFE.b(i, (k) obj, i2, i3);
        }
        if (this.gFD) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ b gFF;

                {
                    this.gFF = r1;
                }

                public final void run() {
                    this.gFF.b(this.gFF.gFa);
                }
            }, (long) auy());
        }
    }
}
