package com.tencent.mm.plugin.recovery.service;

import android.os.Process;
import com.tencent.mm.bc.d;
import com.tencent.mm.plugin.recovery.a.c;
import com.tencent.recovery.b;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.a;

public class RecoveryTinkerResultService extends AbstractResultService {
    private d irf;

    public void onCreate() {
        super.onCreate();
        this.irf = new d();
        this.irf.open();
        b.a(this.irf);
    }

    public void onDestroy() {
        this.irf.close();
        super.onDestroy();
        int myPid = Process.myPid();
        b.yH(13);
        Process.killProcess(myPid);
    }

    public final void a(a aVar) {
        this.irf.i("MicroMsg.Recovery.RecoveryTinkerResultService", "RecoveryTinkerResultService receive result: %s", aVar.toString());
        c aJX = c.aJX();
        aJX.aJY();
        aJX.yB("KeyPatchResultTotalCount");
        if (aVar == null || !aVar.bbq) {
            this.irf.i("MicroMsg.Recovery.RecoveryTinkerResultService", "patch fail", new Object[0]);
            aJX.yB("KeyPatchResultFailCount");
        } else {
            this.irf.i("MicroMsg.Recovery.RecoveryTinkerResultService", "patch success", new Object[0]);
            aJX.yB("KeyPatchResultSuccessCount");
        }
        if (c.a(this, com.tencent.recovery.e.a.eU(this), aJX)) {
            c.aKa();
        } else {
            aJX.aJZ();
        }
        stopSelf();
    }
}
