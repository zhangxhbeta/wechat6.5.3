package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.k;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends a {
    public int gIv = 1;
    public boolean gIw = false;

    public final int[] aux() {
        return new int[]{723};
    }

    public final int CV() {
        return 4;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            v.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.gFG), Integer.valueOf(cVar.gFJ)});
            ak.vy().a(new k(cVar.gFG, cVar.gFH, cVar.gFI, this.gIv), 0);
        }
    }
}
