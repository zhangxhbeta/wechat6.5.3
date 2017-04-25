package com.c.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z {
    private static z aNM;
    private static final SparseArray<z> aNN = new SparseArray();
    private final ExecutorService aNO;
    private final Handler handler;

    private z(Handler handler) {
        if (handler != null) {
            this.aNO = null;
        } else {
            this.aNO = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
    }

    static z b(Handler handler) {
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            z zVar = (z) aNN.get(hashCode);
            if (zVar != null) {
                return zVar;
            }
            zVar = new z(handler);
            aNN.put(hashCode, zVar);
            return zVar;
        }
        if (aNM == null) {
            aNM = new z(null);
        }
        return aNM;
    }

    final void execute(Runnable runnable) {
        if (this.handler != null) {
            this.handler.post(runnable);
        } else {
            this.aNO.execute(runnable);
        }
    }
}
