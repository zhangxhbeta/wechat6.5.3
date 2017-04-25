package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class f {
    private e mapContext;
    public c pAd;

    public f(e eVar) {
        this.mapContext = eVar;
        this.pAd = eVar.b();
    }

    private LatLng e(Point point) {
        return this.pAd.a(point.x, point.y);
    }

    public final VisibleRegion bOk() {
        int width = this.mapContext.c().getWidth();
        int height = this.mapContext.c().getHeight();
        LatLng e = e(new Point(0, 0));
        LatLng e2 = e(new Point(width, 0));
        LatLng e3 = e(new Point(0, height));
        LatLng e4 = e(new Point(width, height));
        return new VisibleRegion(e3, e4, e, e2, LatLngBounds.builder().include(e3).include(e4).include(e).include(e2).build());
    }
}
