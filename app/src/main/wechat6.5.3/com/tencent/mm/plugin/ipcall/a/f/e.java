package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.v.k;

public final class e extends a implements h.a {
    private h gIu = null;

    public final int[] aux() {
        return new int[0];
    }

    public final int CV() {
        return 8;
    }

    public final void op() {
        this.gIu = new h();
        this.gIu.gFf = this;
        com.tencent.mm.sdk.c.a.nhr.e(this.gIu);
    }

    public final void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.gIu);
    }

    public final void b(c cVar) {
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public final void a(anu com_tencent_mm_protocal_c_anu) {
        this.gFC.a(8, com_tencent_mm_protocal_c_anu, 0, 0);
    }
}
