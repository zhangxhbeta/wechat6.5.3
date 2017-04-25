package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.d.e;

public final class b {
    private static b gIr;
    private e gIs;

    public static b auP() {
        if (gIr == null) {
            gIr = new b();
        }
        return gIr;
    }

    public final void dK(boolean z) {
        ak.vy().c(this.gIs);
        this.gIs = null;
        if (z) {
            this.gIs = new e(1);
        } else {
            this.gIs = new e(0);
        }
        ak.vy().a(this.gIs, 0);
    }
}
