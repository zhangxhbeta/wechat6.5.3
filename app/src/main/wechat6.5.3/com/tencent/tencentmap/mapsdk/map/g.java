package com.tencent.tencentmap.mapsdk.map;

import android.view.View;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;

public final class g {
    public static b pAe;
    public com.tencent.mapsdk.rastercore.d.e mapContext;
    com.tencent.mapsdk.rastercore.d.a pAa;
    com.tencent.mapsdk.rastercore.d.c pAd;

    public interface a {
        View bOl();
    }

    public interface b {
        void collectErrorInfo(String str);
    }

    public interface c {
    }

    public interface d {
        void Qx();

        void Qy();
    }

    public interface e {
        void Qw();
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        boolean a(Marker marker);
    }

    public interface i {
    }

    public interface j {
    }

    public g(com.tencent.mapsdk.rastercore.d.e eVar) {
        this.mapContext = eVar;
        this.pAa = eVar.e();
        this.pAd = eVar.b();
    }

    public final void a(a aVar, long j) {
        if (!this.mapContext.f().k() || j <= 0) {
            aVar.pzX.a(false);
        }
        aVar.pzX.a(null);
        aVar.pzX.a(j);
        this.mapContext.c().a(aVar.pzX);
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return new GroundOverlay(this.pAa.a(groundOverlayOptions));
    }

    public final void b(h hVar) {
        this.mapContext.h().a(hVar);
    }

    public final LatLng getMapCenter() {
        return this.pAd.d().getTarget();
    }

    public final int getZoomLevel() {
        return (int) this.pAd.d().getZoom();
    }
}
