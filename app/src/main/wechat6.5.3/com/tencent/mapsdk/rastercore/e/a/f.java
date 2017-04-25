package com.tencent.mapsdk.rastercore.e.a;

import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.tile.a.a;
import java.io.File;

public final class f {
    private static int h = 0;
    private e a;
    private final String b;
    private boolean c = true;
    private float d = Float.NEGATIVE_INFINITY;
    private boolean e = true;
    private TileProvider f;
    private String g;

    public f(e eVar, TileOverlayOptions tileOverlayOptions) {
        StringBuilder stringBuilder = new StringBuilder("TileOverlay_");
        int i = h;
        h = i + 1;
        this.b = stringBuilder.append(i).toString();
        this.a = eVar;
        this.g = e.a().getPackageName() + File.separator + this.b;
        this.e = tileOverlayOptions.getDiskCacheEnabled();
        this.f = tileOverlayOptions.getTileProvider();
        this.d = tileOverlayOptions.getZIndex();
        this.c = tileOverlayOptions.isVisible();
    }

    public static void c() {
        a.a().b();
    }

    public final float a() {
        return this.d;
    }

    public final void a(boolean z) {
        this.c = z;
        this.a.a(false, false);
    }

    public final void b() {
        this.a.g().a(this);
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        return this.b.equals(((f) obj).b);
    }

    public final TileProvider f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.e;
    }
}
