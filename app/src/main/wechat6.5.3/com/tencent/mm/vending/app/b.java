package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b pgm;
    Map<c, a> pgn = new ConcurrentHashMap();
    final SparseIntArray pgo = new SparseIntArray();
    final Handler pgp = new Handler(this, com.tencent.mm.vending.i.b.bKT().pii.getLooper()) {
        final /* synthetic */ b pgq;

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.onCreate();
                    synchronized (aVar.pgc) {
                        aVar.pgf = true;
                        aVar.pgc.notify();
                    }
                    return;
                case 4:
                    aVar.onDestroy();
                    return;
                default:
                    return;
            }
        }
    };

    static {
        pgm = null;
        pgm = new b();
    }

    public static b bKz() {
        return pgm;
    }
}
