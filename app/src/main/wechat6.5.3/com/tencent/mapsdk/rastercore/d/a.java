package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.e.a.c;
import com.tencent.mapsdk.rastercore.e.b;
import com.tencent.mapsdk.rastercore.e.d;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.tencentmap.mapsdk.map.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a {
    private static int e = 0;
    private e a;
    private CopyOnWriteArrayList<b> b = new CopyOnWriteArrayList();
    private SortedMap<String, c> c = new TreeMap();
    private a d = new a();

    public static /* synthetic */ class AnonymousClass1 {
        protected float a = 0.9f;
        protected int b = 0;
        final Handler c = new d(this);
        private MapSource d = MapSource.TENCENT;
        private int e = 256;
        private boolean f = true;
        private boolean g = true;
        private boolean h = false;
        private boolean i = true;
        private int j = 0;
        private int k = 0;
        private e l;

        protected AnonymousClass1(e eVar) {
            this.l = eVar;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i = e.a().getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                this.b = 1;
                this.a = 0.5f;
            } else if (i <= 160) {
                this.b = 2;
                this.a = 0.8f;
            } else if (i <= 240) {
                this.b = 3;
                this.a = 0.87f;
            } else if (i <= 320) {
                this.a = 1.0f;
                this.b = 4;
            } else if (i <= 480) {
                this.a = DownloadHelper.SAVE_FATOR;
                this.b = 5;
            } else {
                this.a = 1.8f;
                this.b = 6;
            }
        }

        public int a() {
            return this.b;
        }

        public void a(int i) {
            this.e = i;
        }

        public void a(MapSource mapSource) {
            this.d = mapSource;
            this.l.q();
        }

        public void a(boolean z) {
            this.h = z;
            this.c.obtainMessage(1).sendToTarget();
        }

        public float b() {
            return this.a;
        }

        public void b(int i) {
            this.j = i;
            this.l.b(i);
        }

        public void b(boolean z) {
            this.f = z;
        }

        public MapSource c() {
            return this.d;
        }

        public void c(int i) {
            this.k = i;
            this.l.c(i);
        }

        public void c(boolean z) {
            this.g = z;
        }

        public int d() {
            return this.e;
        }

        public void d(boolean z) {
            c(z);
            b(z);
        }

        public void e(boolean z) {
            this.i = z;
        }

        public boolean e() {
            return this.d == MapSource.BING;
        }

        public int f() {
            return this.k;
        }

        public boolean g() {
            return this.h;
        }

        public boolean h() {
            return this.f;
        }

        public boolean i() {
            return this.g;
        }

        public int j() {
            return this.j;
        }

        public boolean k() {
            return this.i;
        }
    }

    class a implements Comparator<Object> {
        private a(a aVar) {
        }

        public final int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            if (!(bVar == null || bVar2 == null)) {
                try {
                    if (bVar.getZIndex() > bVar2.getZIndex()) {
                        return 1;
                    }
                    if (bVar.getZIndex() < bVar2.getZIndex()) {
                        return -1;
                    }
                } catch (Exception e) {
                }
            }
            return 0;
        }
    }

    public a(e eVar) {
        this.a = eVar;
    }

    public static String a(String str) {
        e++;
        return str + e;
    }

    public final c a(MarkerOptions markerOptions) {
        c cVar = new c(this.a, markerOptions);
        this.c.put(cVar.m(), cVar);
        return cVar;
    }

    public final com.tencent.mapsdk.rastercore.e.a a(GroundOverlayOptions groundOverlayOptions) {
        b aVar = new com.tencent.mapsdk.rastercore.e.a(this.a, groundOverlayOptions);
        a(aVar);
        return aVar;
    }

    public final com.tencent.mapsdk.rastercore.e.c a(PolygonOptions polygonOptions) {
        b cVar = new com.tencent.mapsdk.rastercore.e.c(this.a, polygonOptions);
        a(cVar);
        return cVar;
    }

    public final d a(PolylineOptions polylineOptions) {
        b dVar = new com.tencent.mapsdk.rastercore.e.a.d(this.a, polylineOptions);
        a(dVar);
        return dVar;
    }

    public final com.tencent.mapsdk.rastercore.tile.a.b a(CircleOptions circleOptions) {
        b bVar = new com.tencent.mapsdk.rastercore.tile.a.b(this.a, circleOptions);
        a(bVar);
        return bVar;
    }

    public final void a() {
        try {
            for (Entry value : this.c.entrySet()) {
                ((c) value.getValue()).c();
            }
            this.c.clear();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).destroy();
            }
            this.b.clear();
        } catch (Exception e) {
        }
        this.a.a(false, false);
    }

    public final void a(Canvas canvas) {
        int size = this.b.size();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.isVisible() && (size <= 20 || bVar.checkInBounds())) {
                bVar.draw(canvas);
            }
        }
    }

    public final void a(b bVar) {
        b(bVar.getId());
        this.b.add(bVar);
        c();
        this.a.a(false, false);
    }

    public final boolean a(MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        return false;
    }

    public final boolean a(GeoPoint geoPoint) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        return false;
    }

    public final boolean a(GeoPoint geoPoint, MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        return false;
    }

    protected final void b() {
        a();
    }

    public final boolean b(String str) {
        Object obj;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            obj = (b) it.next();
            if (obj != null && obj.getId().equals(str)) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        boolean remove = this.b.remove(obj);
        this.a.a(false, false);
        return remove;
    }

    public final void c() {
        Object[] toArray = this.b.toArray();
        Arrays.sort(toArray, this.d);
        this.b.clear();
        for (Object obj : toArray) {
            this.b.add((b) obj);
        }
    }

    public final boolean c(String str) {
        c cVar = (c) this.c.remove(str);
        if (cVar == null) {
            return false;
        }
        cVar.c();
        return true;
    }
}
