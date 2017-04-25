package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.a.f;
import com.tencent.mapsdk.rastercore.tile.a.b;
import com.tencent.mapsdk.rastercore.tile.b.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MapTile {
    private e a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private PointF g;
    private MapSource h = MapSource.TENCENT;
    private List<a> i = new ArrayList();
    private List<a> j = new ArrayList();

    public enum MapSource {
        TENCENT,
        BING,
        SATELLITE,
        TRAFFIC,
        CUSTOMER
    }

    public MapTile(e eVar, int i, int i2, int i3, int i4, int i5, MapSource mapSource, List<f> list) {
        this.a = eVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.h = mapSource;
        a aVar = new a(c.a(this.a, mapSource), this.b, this.c, this.d, this.e, this.f, mapSource, b.a(mapSource, this.e, this.f));
        if (this.i.size() > 0) {
            this.i.set(0, aVar);
            this.j.set(0, aVar);
        } else {
            this.i.add(aVar);
            this.j.add(aVar);
        }
        if (list != null && !list.isEmpty()) {
            for (f a : list) {
                a(a);
            }
        }
    }

    public final int a() {
        return this.d;
    }

    public final void a(PointF pointF) {
        this.g = pointF;
    }

    public final void a(f fVar) {
        this.i.size();
        a aVar = new a(fVar, this.b, this.c, this.d, this.e, this.f);
        this.i.add(aVar);
        this.j.add(aVar);
    }

    public final boolean a(Canvas canvas) {
        if (this.i == null || this.i.size() <= 0) {
            return true;
        }
        Collections.sort(this.j, a.k());
        canvas.save();
        canvas.translate(this.g.x, this.g.y);
        boolean z = true;
        for (a a : this.j) {
            z = a.a(canvas) & z;
        }
        canvas.restore();
        return z;
    }

    public final boolean a(List<a> list) {
        for (a a : list) {
            String a2 = a.a();
            if (a2 != null && a2.contains("BingGrid") && !a2.endsWith(e.w())) {
                return true;
            }
        }
        this.i.clear();
        this.i.addAll(list);
        this.j.clear();
        this.j.addAll(list);
        for (a a3 : this.i) {
            if (a3.f() == null) {
                return true;
            }
        }
        return false;
    }

    public final List<a> b() {
        return new ArrayList(this.i);
    }

    public final void b(f fVar) {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a(fVar)) {
                aVar.h();
                it.remove();
                return;
            }
        }
    }

    public final void c() {
        for (a h : this.i) {
            h.h();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapTile)) {
            return false;
        }
        MapTile mapTile = (MapTile) obj;
        return this.b == mapTile.b && this.c == mapTile.c && this.d == mapTile.d;
    }

    public final int hashCode() {
        return ((this.b * 7) + (this.c * 11)) + (this.d * 13);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("MapTile(");
        stringBuilder.append(this.b);
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(",");
        stringBuilder.append(this.d);
        stringBuilder.append(",");
        stringBuilder.append(this.h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
