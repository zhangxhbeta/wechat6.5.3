package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.b;

public final class a extends b implements b {
    private com.tencent.mm.plugin.search.ui.c.a iGL;
    protected boolean iGM;
    private ac iGN = new ac(Looper.getMainLooper());

    public a(c cVar) {
        super(cVar);
        this.iGL = new com.tencent.mm.plugin.search.ui.c.a(cVar.getContext(), this, 0);
    }

    protected final com.tencent.mm.ui.f.a.a pe(int i) {
        return this.iGL.pe(i);
    }

    protected final void aMm() {
        this.iGM = false;
        this.iGL.a(this.bkC, this.iGN, null);
    }

    protected final boolean a(com.tencent.mm.ui.f.a.a aVar) {
        return false;
    }

    public final void a(f fVar, String str) {
        int xY = this.iGL.xY(0);
        pf(xY);
        notifyDataSetChanged();
        D(xY, true);
    }
}
