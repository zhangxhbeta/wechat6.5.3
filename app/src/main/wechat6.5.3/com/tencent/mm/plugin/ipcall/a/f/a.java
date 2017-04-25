package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.v;

public final class a extends com.tencent.mm.plugin.ipcall.a.a.a {
    public final int[] aux() {
        return new int[]{843};
    }

    public final int CV() {
        return 3;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            v.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.gFG), Integer.valueOf(cVar.gFJ)});
            ak.vy().a(new com.tencent.mm.plugin.ipcall.a.d.a(cVar.gFG, cVar.gFH, cVar.bob, cVar.gGi, cVar.gFJ, cVar.gFI), 0);
        }
    }
}
