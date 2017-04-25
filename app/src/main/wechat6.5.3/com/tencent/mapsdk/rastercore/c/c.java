package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;

public final class c extends a {
    private CameraPosition d;

    public final void a(CameraPosition cameraPosition) {
        this.d = cameraPosition;
    }

    public final void a(e eVar) {
        b c = eVar.c();
        if (this.a) {
            c.a(a.a(this.d.getTarget()), this.b, this.c);
        } else {
            c.b(a.a(this.d.getTarget()));
        }
        if (this.d.getZoom() > 0.0f) {
            c.b((double) this.d.getZoom(), this.a, this.c);
        }
    }

    public final boolean a() {
        return false;
    }
}
