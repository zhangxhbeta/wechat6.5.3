package com.tencent.mm.plugin.clean.b.a;

import android.os.Looper;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, ac> eVg = new HashMap(4);
    private HashSet<Long> eVh = new HashSet(4);

    public b() {
        for (int i = 0; i < 4; i++) {
            e.d(new Runnable(this) {
                final /* synthetic */ b eVi;

                {
                    this.eVi = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.eVi.eVg.put(Long.valueOf(Thread.currentThread().getId()), new ac(Looper.myLooper()));
                    Looper.loop();
                }
            }, "ThreadController_handler", 1).start();
        }
    }

    public final synchronized boolean a(a aVar) {
        boolean z;
        aVar.eVf = this;
        v.d("MicroMsg.ThreadController", "running threads %s", new Object[]{this.eVh.toString()});
        for (Entry entry : this.eVg.entrySet()) {
            if (!this.eVh.contains(entry.getKey())) {
                ((ac) entry.getValue()).post(aVar);
                this.eVh.add(entry.getKey());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    private synchronized void f(Long l) {
        if (this.eVh.remove(l)) {
            v.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[]{l});
        }
    }

    public final void g(Long l) {
        f(l);
    }
}
