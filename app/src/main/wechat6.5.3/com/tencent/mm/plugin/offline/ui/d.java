package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.mm.e.a.oy;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends c<oy> {
    private ac mHandler;

    public d() {
        this.mHandler = new ac(Looper.getMainLooper());
        this.nhz = oy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oy oyVar = (oy) bVar;
        if (ak.uz() && (oyVar instanceof oy)) {
            v.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            if (oyVar.bqj.bqk) {
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ d hLx;

                    {
                        this.hLx = r1;
                    }

                    public final void run() {
                        j.aEM();
                        j.aEP().aEL();
                    }
                }, 10000);
            } else {
                j.aEM();
                j.aEP().aEL();
            }
        }
        return false;
    }
}
