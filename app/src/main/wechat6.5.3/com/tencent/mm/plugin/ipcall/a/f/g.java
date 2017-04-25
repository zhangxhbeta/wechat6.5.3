package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends a {
    public final int[] aux() {
        return new int[]{227};
    }

    public final int CV() {
        return 7;
    }

    public final void op() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            ak.vy().a(new i(cVar.gFG, cVar.gFI, cVar.gGk), 0);
            v.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[]{Integer.valueOf(cVar.gFG), Long.valueOf(cVar.gFI), Boolean.valueOf(cVar.gGk)});
        }
    }
}
