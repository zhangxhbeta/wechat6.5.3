package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.u;
import com.tencent.mm.plugin.backup.d.v;

public final class a extends b {
    private u egT = new u();
    private v egU = new v();

    public a(int i) {
        this.egT.eev = i;
    }

    public final com.tencent.mm.ba.a Ud() {
        return this.egU;
    }

    public final com.tencent.mm.ba.a Ue() {
        return this.egT;
    }

    public final void Uf() {
        if (this.egU.eeO == 0) {
            e(0, 0, "ok");
            return;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", Integer.valueOf(this.egT.eev), Integer.valueOf(this.egU.eeO));
        e(4, this.egU.eeO, "fail");
    }

    public final int getType() {
        return 3;
    }
}
