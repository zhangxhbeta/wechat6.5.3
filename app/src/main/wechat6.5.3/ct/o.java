package ct;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class o {
    private static o a;

    static class a extends o {
        private ScheduledExecutorService a;

        public a() {
            this.a = null;
            this.a = Executors.newSingleThreadScheduledExecutor();
            SparseArray sparseArray = new SparseArray();
        }

        public final synchronized void a(Runnable runnable) {
            if (runnable == null) {
                bd.b();
            } else {
                this.a.execute(runnable);
            }
        }
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (a == null) {
                a = new a();
            }
            oVar = a;
        }
        return oVar;
    }

    public abstract void a(Runnable runnable);
}
