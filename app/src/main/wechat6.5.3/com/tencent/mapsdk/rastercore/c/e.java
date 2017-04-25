package com.tencent.mapsdk.rastercore.c;

import android.graphics.Point;
import android.graphics.PointF;

public final class e extends a {
    private float d;
    private Point e;

    public final void a(float f) {
        this.d = f;
    }

    public final void a(Point point) {
        this.e = point;
    }

    public final void a(com.tencent.mapsdk.rastercore.d.e eVar) {
        if (this.e != null) {
            eVar.c().a((double) this.d, new PointF((float) this.e.x, (float) this.e.y), this.a, this.c);
            return;
        }
        eVar.c().a((double) this.d, this.a, this.c);
    }
}
