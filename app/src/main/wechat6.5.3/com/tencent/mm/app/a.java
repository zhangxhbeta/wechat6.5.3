package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.u.b;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;

final class a implements com.tencent.mm.pluginsdk.ui.h.a {
    private Bitmap aQs;
    d aQt;

    public a() {
        this.aQs = null;
        this.aQs = com.tencent.mm.compatible.f.a.decodeResource(aa.getContext().getResources(), 2131165440);
    }

    public final void a(h hVar) {
        if (hVar instanceof com.tencent.mm.u.d.a) {
            n.AX().a((com.tencent.mm.u.d.a) hVar);
        }
    }

    public final Bitmap bg(String str) {
        return b.a(str, false, -1);
    }

    public final Bitmap od() {
        return this.aQs;
    }

    public final Bitmap bh(String str) {
        if (this.aQt == null) {
            this.aQt = n.AX();
        }
        return d.gH(str);
    }

    public final Bitmap a(String str, int i, int i2, int i3) {
        return b.b(str, i, i2, i3);
    }
}
