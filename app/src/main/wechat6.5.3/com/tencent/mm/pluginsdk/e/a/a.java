package com.tencent.mm.pluginsdk.e.a;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
    private CountDownLatch lyK = null;

    public final void countDown() {
        if (this.lyK != null) {
            this.lyK.countDown();
            this.lyK = null;
        }
    }

    public final void b(long j, Runnable runnable) {
        v.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.lyK == null) {
            this.lyK = new CountDownLatch(1);
        }
        ad.o(runnable);
        v.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.lyK != null) {
            try {
                this.lyK.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                v.w("MicroMsg.SyncJob", e.getMessage());
                v.a("MicroMsg.SyncJob", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
    }
}
