package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.sdk.platformtools.v;

public abstract class d implements Runnable {
    public abstract void execute();

    public abstract String getName();

    public d() {
        v.i("MicroMsg.WearBaseWorkerTask", "Create %s", new Object[]{getName()});
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            execute();
        } catch (Throwable e) {
            v.a("MicroMsg.WearBaseWorkerTask", e, "run task %s occur exception: %s", new Object[]{getName(), e.getMessage()});
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        v.i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", new Object[]{getName(), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
    }
}
