package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.c.h;
import com.tencent.mapsdk.rastercore.d.a;

public final class d {
    private boolean pzY = true;
    public MapView pzZ;

    public d(MapView mapView) {
        this.pzZ = mapView;
    }

    public final void b(GeoPoint geoPoint) {
        this.pzZ.getMap().a(new a(a.a(CameraPosition.builder().target(com.tencent.mapsdk.rastercore.f.a.a(geoPoint)).build())), 1000);
    }

    public final void c(GeoPoint geoPoint) {
        g map = this.pzZ.getMap();
        float zoomLevel = (float) map.getZoomLevel();
        map.a(new a(a.a(CameraPosition.builder().target(com.tencent.mapsdk.rastercore.f.a.a(geoPoint)).zoom(zoomLevel).build())), 0);
    }

    public final void setZoom(int i) {
        g map = this.pzZ.getMap();
        float f = (float) i;
        com.tencent.mapsdk.rastercore.c.a hVar = new h();
        hVar.a(f);
        map.a(new a(hVar), 0);
    }
}
