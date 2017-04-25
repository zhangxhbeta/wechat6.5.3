package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.Tile;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.a.f;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class a {
    private static final Comparator<a> l = new a();
    private final int a;
    private final int b;
    private final int c;
    private MapSource d;
    private final int e;
    private final int f;
    private TileProvider g;
    private Bitmap h;
    private String i;
    private volatile boolean j;
    private f k;

    public static /* synthetic */ class AnonymousClass1 {
        ArrayList<MapTile> a = null;
        ArrayList<MapTile> b = null;
        ArrayList<MapTile> c = null;
        b d;
        private e e;
        private b f;
        private int g = 0;
        private int h;
        private int i;
        private List<f> j;
        private PaintFlagsDrawFilter k;

        public AnonymousClass1(e eVar, int i, int i2) {
            this.e = eVar;
            this.f = eVar.c();
            this.d = new b(eVar);
            this.j = new ArrayList();
            this.h = i;
            this.i = i2;
        }

        private static void a(ArrayList<MapTile> arrayList) {
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MapTile) it.next()).c();
                }
                arrayList.clear();
            }
        }

        private static void a(ArrayList<MapTile> arrayList, ArrayList<MapTile> arrayList2, ArrayList<MapTile> arrayList3) {
            if (arrayList != null && arrayList.size() != 0) {
                MapTile mapTile;
                for (int i = 0; i < arrayList.size(); i++) {
                    mapTile = (MapTile) arrayList.get(i);
                    if (mapTile != null) {
                        List b;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                MapTile mapTile2 = (MapTile) arrayList2.get(i2);
                                if (mapTile2.equals(mapTile)) {
                                    b = mapTile2.b();
                                    arrayList2.remove(i2);
                                    break;
                                }
                            }
                        }
                        b = null;
                        if ((b == null || mapTile.a(b)) && arrayList3 != null) {
                            arrayList3.add(mapTile);
                        }
                    }
                }
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        mapTile = (MapTile) it.next();
                        if (!(mapTile == null || mapTile.b() == null)) {
                            try {
                                mapTile.c();
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }

        private static void a(List<MapTile> list, f fVar) {
            if (list != null) {
                for (MapTile a : list) {
                    a.a(fVar);
                }
            }
        }

        private boolean a(Canvas canvas, ArrayList<MapTile> arrayList) {
            double b = this.f.d().b();
            PointF a = this.f.a();
            if (arrayList == null || arrayList.size() <= 0) {
                return true;
            }
            int a2 = ((MapTile) arrayList.get(0)).a();
            int a3 = this.f.d().a();
            if (this.e.f().e()) {
                a3--;
            }
            b *= Math.pow(2.0d, (double) (a3 - a2));
            if (b != 1.0d) {
                Matrix matrix = new Matrix();
                canvas.save();
                matrix.reset();
                matrix.postScale((float) b, (float) b, a.x, a.y);
                canvas.concat(matrix);
            }
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                z = ((MapTile) it.next()).a(canvas);
            }
            if (b == 1.0d) {
                return z;
            }
            canvas.restore();
            return z;
        }

        private static void b(List<MapTile> list, f fVar) {
            if (list != null) {
                for (MapTile b : list) {
                    b.b(fVar);
                }
            }
        }

        private ArrayList<MapTile> c(int i) {
            return a(this.f.b(), i, this.f.getWidth(), this.f.getHeight(), this.e.f().d());
        }

        PointF a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6, int i7, int i8) {
            PointF pointF2 = new PointF();
            if (i < 0 || i2 < 0 || ((double) i) >= Math.pow(2.0d, (double) i8) || ((double) i2) >= Math.pow(2.0d, (double) i8)) {
                return null;
            }
            pointF2.x = ((float) ((i - i3) * i7)) + pointF.x;
            pointF2.y = ((float) ((i2 - i4) * i7)) + pointF.y;
            return (pointF2.x + ((float) i7) <= 0.0f || pointF2.x >= ((float) i5) || pointF2.y + ((float) i7) <= 0.0f || pointF2.y >= ((float) i6)) ? null : pointF2;
        }

        public f a(TileOverlayOptions tileOverlayOptions) {
            f fVar = new f(this.e, tileOverlayOptions);
            this.j.add(fVar);
            AnonymousClass1.a(this.b, fVar);
            AnonymousClass1.a(this.a, fVar);
            AnonymousClass1.a(this.c, fVar);
            this.e.a(false, false);
            return fVar;
        }

        public ArrayList<MapTile> a(c cVar, int i, int i2, int i3, int i4) {
            int i5 = 0;
            if (this.e.f().e()) {
                i5 = 1;
            }
            double c = com.tencent.mapsdk.rastercore.b.a.c((double) (i5 + i));
            MapSource c2 = this.e.f().c();
            int b = (int) ((cVar.b() - -2.003750834E7d) / (((double) i4) * c));
            int a = (int) ((2.003750834E7d - cVar.a()) / (((double) i4) * c));
            c cVar2 = new c(2.003750834E7d - (((double) (a * i4)) * c), (((double) (b * i4)) * c) - 2.1525280871514951E-7d);
            PointF a2 = this.f.a();
            PointF pointF = new PointF();
            pointF.x = (float) (((cVar2.b() - cVar.b()) / c) + ((double) a2.x));
            pointF.y = (float) (((double) a2.y) - ((cVar2.a() - cVar.a()) / c));
            MapTile mapTile = new MapTile(this.e, b, a, i, this.h, this.i, c2, this.j);
            mapTile.a(pointF);
            ArrayList<MapTile> arrayList = new ArrayList();
            arrayList.add(mapTile);
            int i6 = 1;
            while (true) {
                int i7;
                Object obj = null;
                for (i7 = b - i6; i7 <= b + i6; i7++) {
                    int i8 = a + i6;
                    PointF a3 = a(i7, i8, b, a, pointF, i2, i3, i4, i);
                    if (a3 != null) {
                        if (obj == null) {
                            obj = 1;
                        }
                        MapTile mapTile2 = new MapTile(this.e, i7, i8, i, this.h, this.i, c2, this.j);
                        mapTile2.a(a3);
                        arrayList.add(mapTile2);
                    }
                    i8 = a - i6;
                    a3 = a(i7, i8, b, a, pointF, i2, i3, i4, i);
                    if (a3 != null) {
                        if (obj == null) {
                            obj = 1;
                        }
                        mapTile2 = new MapTile(this.e, i7, i8, i, this.h, this.i, c2, this.j);
                        mapTile2.a(a3);
                        arrayList.add(mapTile2);
                    }
                }
                for (i7 = (a + i6) - 1; i7 > a - i6; i7--) {
                    int i9 = b + i6;
                    a3 = a(i9, i7, b, a, pointF, i2, i3, i4, i);
                    if (a3 != null) {
                        if (obj == null) {
                            obj = 1;
                        }
                        MapTile mapTile3 = new MapTile(this.e, i9, i7, i, this.h, this.i, c2, this.j);
                        mapTile3.a(a3);
                        arrayList.add(mapTile3);
                    }
                    i9 = b - i6;
                    a3 = a(i9, i7, b, a, pointF, i2, i3, i4, i);
                    if (a3 != null) {
                        if (obj == null) {
                            obj = 1;
                        }
                        mapTile3 = new MapTile(this.e, i9, i7, i, this.h, this.i, c2, this.j);
                        mapTile3.a(a3);
                        arrayList.add(mapTile3);
                    }
                }
                if (obj == null) {
                    return arrayList;
                }
                i6++;
            }
        }

        public void a() {
            AnonymousClass1.a(this.a);
            AnonymousClass1.a(this.b);
            AnonymousClass1.a(this.c);
            this.d.a();
        }

        public void a(int i) {
            this.h = i;
        }

        public void a(boolean z, boolean z2) {
            ArrayList arrayList;
            int i;
            ArrayList arrayList2;
            ArrayList arrayList3;
            if (!z) {
                MapSource mapSource = MapSource.TENCENT;
                mapSource = this.e.l() == 2 ? MapSource.SATELLITE : (e.s() && com.tencent.mapsdk.rastercore.c.a() && !b()) ? MapSource.BING : (!e.s() || this.f.d().a() <= 6 || b()) ? MapSource.TENCENT : MapSource.BING;
                if (this.e.f().c() != mapSource) {
                    this.e.f().a(mapSource);
                    if (this.a != null) {
                        this.a.clear();
                    }
                    if (this.b != null) {
                        this.b.clear();
                    }
                    if (this.c != null) {
                        this.c.clear();
                    }
                }
            }
            if (this.e.f().e()) {
                this.e.f().a(512);
            } else {
                this.e.f().a(256);
            }
            int a = this.f.d().a();
            int i2 = this.e.f().e() ? a - 1 : a;
            a = i2 - 2;
            int a2 = a < this.e.b().j().a() ? this.e.b().j().a() : a;
            if (this.b == null || this.b.size() <= 0) {
                arrayList = null;
                i = -1;
            } else {
                int a3 = ((MapTile) this.b.get(0)).a();
                arrayList = this.b;
                i = a3;
            }
            int i3 = i - i2;
            if (i3 != 0 || z2) {
                int i4;
                int i5;
                if (this.a == null || this.a.size() <= 0) {
                    arrayList2 = null;
                    i4 = -1;
                } else {
                    i4 = ((MapTile) this.a.get(0)).a();
                    arrayList2 = this.a;
                }
                if (this.c == null || this.c.size() <= 0) {
                    arrayList3 = null;
                    i5 = -1;
                } else {
                    i5 = ((MapTile) this.c.get(0)).a();
                    arrayList3 = this.c;
                }
                if (i2 == i5 && i5 != -1) {
                    this.b = arrayList3;
                } else if (i2 == i4 && i4 != -1) {
                    this.b = arrayList2;
                }
                if (a2 == i5 && i5 != -1) {
                    this.a = arrayList3;
                } else if (a2 == i && i != -1) {
                    this.a = arrayList;
                }
                if (Math.abs(i3) == 1) {
                    this.c = arrayList;
                }
            }
            arrayList2 = new ArrayList();
            if (a2 != i2 || z2) {
                arrayList3 = c(a2);
                AnonymousClass1.a(arrayList3, this.a, arrayList2);
                this.a = arrayList3;
            }
            if (this.c != null && this.c.size() > 0) {
                arrayList3 = c(((MapTile) this.c.get(0)).a());
                AnonymousClass1.a(arrayList3, this.c, null);
                this.c = arrayList3;
            }
            arrayList3 = c(i2);
            AnonymousClass1.a(arrayList3, this.b, arrayList2);
            this.b = arrayList3;
            this.d.a(arrayList2);
            this.e.c().invalidate();
        }

        public boolean a(Canvas canvas) {
            a(canvas, this.a);
            a(canvas, this.c);
            if (this.k == null) {
                this.k = new PaintFlagsDrawFilter(0, 2);
            }
            canvas.setDrawFilter(this.k);
            boolean a = a(canvas, this.b);
            canvas.setDrawFilter(null);
            if (!a) {
                return false;
            }
            if (this.c != null) {
                this.c.clear();
            }
            return true;
        }

        public boolean a(f fVar) {
            boolean remove = this.j.remove(fVar);
            if (remove) {
                AnonymousClass1.b(this.b, fVar);
                AnonymousClass1.b(this.a, fVar);
                AnonymousClass1.b(this.c, fVar);
            }
            this.e.a(false, false);
            return remove;
        }

        public void b(int i) {
            this.i = i;
        }

        public boolean b() {
            boolean z = false;
            c[] b = this.e.b().b();
            int length = b.length;
            int i = 0;
            while (i < length) {
                c cVar = b[i];
                boolean a = com.tencent.mapsdk.rastercore.c.a(cVar.b(), cVar.a()) | z;
                if (a) {
                    return true;
                }
                i++;
                z = a;
            }
            return z;
        }
    }

    static final class a implements Comparator<a> {
        private a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            return aVar == null ? -1 : aVar2 == null ? 1 : Float.compare(aVar.j(), aVar2.j());
        }
    }

    public a(TileProvider tileProvider, int i, int i2, int i3, int i4, int i5, MapSource mapSource, String str) {
        this.j = false;
        this.g = tileProvider;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.e = i4;
        this.i = str;
        this.d = mapSource;
        this.f = i5;
    }

    public a(f fVar, int i, int i2, int i3, int i4, int i5) {
        this(fVar.f(), i, i2, i3, i4, i5, MapSource.CUSTOMER, fVar.g());
        this.k = fVar;
        fVar.h();
    }

    public static Comparator<a> k() {
        return l;
    }

    public final String a() {
        return this.i;
    }

    public final void a(Bitmap bitmap) {
        this.h = bitmap;
    }

    public final boolean a(Canvas canvas) {
        if ((this.k != null && !this.k.e()) || this.h == null || this.h.isRecycled()) {
            return false;
        }
        try {
            canvas.drawBitmap(this.h, 0.0f, 0.0f, null);
            return true;
        } catch (Exception e) {
            if (!(this.h == null || this.h.isRecycled())) {
                this.h.recycle();
            }
            this.h = null;
            return false;
        }
    }

    public final boolean a(f fVar) {
        return this.k == null ? false : this.k.equals(fVar);
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final TileProvider e() {
        return this.g;
    }

    public final Bitmap f() {
        return this.h;
    }

    public final byte[] g() {
        try {
            Tile tile = this.g.getTile(this.a, this.b, this.c, this.d, Integer.valueOf(this.e), Integer.valueOf(this.f));
            return tile != null ? tile.getData() : null;
        } catch (Exception e) {
            new StringBuilder("get tile raises exception:").append(e.getMessage());
            return null;
        }
    }

    public final void h() {
        this.j = true;
        if (!(this.h == null || this.h.isRecycled())) {
            this.h.recycle();
        }
        this.h = null;
    }

    public final boolean i() {
        return this.j;
    }

    public final float j() {
        return this.k != null ? this.k.a() : Float.NEGATIVE_INFINITY;
    }

    public final int l() {
        return this.f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this.a);
        stringBuilder.append("_");
        stringBuilder.append(this.b);
        stringBuilder.append("_");
        stringBuilder.append(this.c);
        stringBuilder.append("_");
        stringBuilder.append(this.d);
        stringBuilder.append("_");
        stringBuilder.append(this.g.getClass().getCanonicalName());
        return stringBuilder.toString();
    }
}
