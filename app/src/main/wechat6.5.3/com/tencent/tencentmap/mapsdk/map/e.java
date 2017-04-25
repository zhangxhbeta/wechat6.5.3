package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.e.b;

public final class e implements b {
    protected String id = getId();
    protected boolean isVisible = true;
    protected com.tencent.mapsdk.rastercore.d.e mapContext;
    protected a pAa;
    protected MapView pzZ;
    protected float zIndex = 0.0f;

    public final void a(MapView mapView) {
        this.pzZ = mapView;
        this.mapContext = mapView.getMapContext();
        this.pAa = this.mapContext.e();
    }

    public final boolean checkInBounds() {
        return false;
    }

    public final void destroy() {
    }

    public final void draw(Canvas canvas) {
    }

    public final boolean equalsRemote(b bVar) {
        return equals(bVar) || bVar.getId().equals(getId());
    }

    public final String getId() {
        if (this.id == null) {
            this.id = a.a("Overlay");
        }
        return this.id;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final int hashCodeRemote() {
        return 0;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void remove() {
        this.pAa.b(getId());
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
        this.mapContext.a(false, false);
    }

    public final void setZIndex(float f) {
        this.zIndex = f;
        this.pAa.c();
        this.mapContext.a(false, false);
    }
}
