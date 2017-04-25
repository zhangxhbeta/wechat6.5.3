package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.sdk.platformtools.v;

public final class d extends a {
    public final int[] aux() {
        return new int[]{991};
    }

    public final int CV() {
        return 1;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            if (cVar.gFJ == 0) {
                cVar.gFJ = (int) System.currentTimeMillis();
            }
            ak.vy().a(new g(cVar.bob, cVar.gGi, cVar.gFJ, cVar.gFK, cVar.gFL), 0);
            v.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[]{cVar.bob, cVar.gGi, Integer.valueOf(cVar.gFJ)});
        }
    }
}
