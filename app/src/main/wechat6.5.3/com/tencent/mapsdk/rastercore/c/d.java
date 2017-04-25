package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;

public final class d extends a {
    private float d;
    private float e;

    public final void a(float f) {
        this.d = f;
    }

    public final void a(e eVar) {
        b c = eVar.c();
        if (this.a) {
            c.a((int) this.d, (int) this.e, this.b, this.c);
        } else {
            c.scrollBy((int) this.d, (int) this.e);
        }
    }

    public final void b(float f) {
        this.e = f;
    }
}
