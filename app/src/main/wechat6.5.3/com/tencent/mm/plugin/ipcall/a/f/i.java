package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends b {
    private l gIx = null;
    private int gIy = 0;

    public final int[] aux() {
        return new int[]{819};
    }

    public final void onStop() {
        if (this.gIx != null) {
            ak.vy().c(this.gIx);
        }
    }

    public final int CV() {
        return 2;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        boolean z = true;
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.d(str, str2, objArr);
        if (this.gFa != null) {
            this.gIy = this.gFa.gFR;
            this.gIx = new l(this.gFa.gFG, this.gFa.gFH, this.gFa.auB(), this.gFa.gFI, false);
            ak.vy().a(this.gIx, 0);
        }
    }

    public final int auy() {
        return this.gIy;
    }

    public final void auz() {
        v.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    }

    public final void auA() {
        v.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    }
}
