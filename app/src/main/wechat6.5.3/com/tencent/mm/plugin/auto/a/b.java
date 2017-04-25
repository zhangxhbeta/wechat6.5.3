package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b implements ag {
    private a eaa = new a();

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.nhr.e(this.eaa.dZY);
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.nhr.f(this.eaa.dZY);
    }
}
