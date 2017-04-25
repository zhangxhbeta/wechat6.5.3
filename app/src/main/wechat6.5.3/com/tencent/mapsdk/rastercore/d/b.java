package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.b.a;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.tencentmap.mapsdk.map.g.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

public final class b extends View {
    private e a;
    private c b;
    private boolean c = false;
    private volatile boolean d = false;
    private List<Runnable> e = new Vector();
    private a f;
    private c g = null;
    private PointF h = null;
    private f i;
    private final Handler j = new Handler(this) {
        private /* synthetic */ b a;

        {
            this.a = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 11:
                    for (Runnable run : this.a.e) {
                        run.run();
                    }
                    this.a.e.clear();
                    if (this.a.i != null) {
                        this.a.i;
                        return;
                    }
                    return;
                case 16:
                    this.a.a.p();
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mapsdk.rastercore.a.c k;
    private com.tencent.mapsdk.rastercore.a.b l;

    public b(e eVar) {
        super(e.a());
        e();
        this.a = eVar;
        this.b = eVar.b();
        this.f = new a(10.0d);
        if (eVar.f().a() >= 3 && eVar.f().b() > 1.0f) {
            this.f.a(1.3d);
        }
        this.g = d.a.a(new LatLng(39.91669d, 116.39716d));
        this.h = new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    private c a(int i, int i2) {
        return new c(this.g.a() - (((double) i2) * this.f.d()), this.g.b() + (((double) i) * this.f.d()));
    }

    private void a(a aVar, PointF pointF) {
        double width = (double) (getWidth() / 2);
        double height = (double) (getHeight() / 2);
        double a = this.g.a() - (((((double) pointF.y) - height) * this.f.d()) + ((height - ((double) pointF.y)) * aVar.d()));
        this.g.b(this.g.b() + (((((double) pointF.x) - width) * this.f.d()) + ((width - ((double) pointF.x)) * aVar.d())));
        this.g.a(a);
        this.h.x = (float) ((int) width);
        this.h.y = (float) ((int) height);
        this.f.b(aVar.c());
        this.b.a(this.g);
        this.a.a(false, false);
    }

    private void b(double d, PointF pointF, boolean z, long j, com.tencent.tencentmap.mapsdk.map.c cVar) {
        a(d, pointF, z, j, com.tencent.mapsdk.rastercore.a.a.a.ACCELERATE_DECELERATE, cVar);
    }

    private void e() {
        for (Method method : View.class.getMethods()) {
            if (method.getName().equals("setLayerType")) {
                break;
            }
        }
        Method method2 = null;
        if (method2 != null) {
            try {
                Field field = View.class.getField("LAYER_TYPE_SOFTWARE");
                method2.invoke(this, new Object[]{Integer.valueOf(field.getInt(null)), null});
            } catch (Exception e) {
            }
        }
    }

    private PointF f() {
        return new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final PointF a() {
        return this.h;
    }

    public final void a(double d, PointF pointF) {
        a(this.b.a(new a(this.f.a(), this.f.b() * d)), pointF);
    }

    public final void a(double d, PointF pointF, boolean z, long j, com.tencent.mapsdk.rastercore.a.a.a aVar, com.tencent.tencentmap.mapsdk.map.c cVar) {
        if (z) {
            if (this.k != null) {
                this.k.b();
            }
            this.k = new com.tencent.mapsdk.rastercore.a.c(this.a, d, pointF, j, cVar);
            this.k.a(aVar);
            this.k.a();
            return;
        }
        a(this.b.a(new a(d)), pointF);
        if (cVar != null) {
            cVar.onFinish();
        }
    }

    public final void a(double d, PointF pointF, boolean z, long j, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(d, pointF, false, 0, null);
    }

    public final void a(double d, PointF pointF, boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(this.f.c() + d, pointF, z, 500, cVar);
    }

    public final void a(double d, boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(this.f.c() + d, f(), z, 500, cVar);
    }

    public final void a(int i, int i2, long j, com.tencent.tencentmap.mapsdk.map.c cVar) {
        a(a(i, i2), j, cVar);
    }

    public final void a(PointF pointF, boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(1.0d + this.f.c(), pointF, true, 500, null);
    }

    public final void a(c cVar) {
        this.g = cVar;
        this.b.a(this.g);
        this.a.a(false, false);
    }

    public final void a(c cVar, long j, com.tencent.tencentmap.mapsdk.map.c cVar2) {
        if (this.l != null) {
            this.l.b();
        }
        this.l = new com.tencent.mapsdk.rastercore.a.b(this.a, cVar, j, cVar2);
        this.l.a();
    }

    public final void a(final com.tencent.mapsdk.rastercore.c.a aVar) {
        if (this.d || !aVar.a()) {
            aVar.a(this.a);
        } else {
            this.e.add(new Runnable(this) {
                private /* synthetic */ b b;

                public final void run() {
                    aVar.a(this.b.a);
                }
            });
        }
    }

    public final void a(f fVar) {
        this.i = fVar;
    }

    public final void a(boolean z) {
        this.c = true;
    }

    public final void a(boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(1.0d + this.f.c(), f(), z, 500, cVar);
    }

    public final c b() {
        return this.g;
    }

    public final void b(double d, boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(d, f(), z, 500, cVar);
    }

    public final void b(c cVar) {
        a(cVar);
    }

    public final void b(boolean z, com.tencent.tencentmap.mapsdk.map.c cVar) {
        b(this.f.c() - 1.0d, f(), z, 500, cVar);
    }

    public final double c() {
        return this.f.c();
    }

    public final void clearAnimation() {
        super.clearAnimation();
        if (this.l != null) {
            this.l.b();
        }
        if (this.k != null) {
            this.k.b();
        }
    }

    public final a d() {
        return this.f;
    }

    public final void draw(Canvas canvas) {
        if (!this.d) {
            this.j.sendEmptyMessage(11);
            this.d = true;
        }
        boolean a = this.a.g().a(canvas);
        this.a.e().a(canvas);
        if (!e.r()) {
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setTextSize(50.0f);
            Rect rect = new Rect();
            String str = "鉴权失败，请到腾讯";
            String str2 = "地图官网申请密钥";
            int width = getWidth();
            int height = getHeight();
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, (float) ((width / 2) - (rect.width() / 2)), (float) ((height / 2) - rect.height()), paint);
            paint.getTextBounds(str2, 0, str2.length(), rect);
            canvas.drawText(str2, (float) ((width / 2) - (rect.width() / 2)), (float) ((height / 2) + 2), paint);
        }
        this.a.b(a);
        if (this.c && a) {
            this.c = false;
            this.j.sendEmptyMessage(16);
        }
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.b.g() == 0.0d || this.b.h() == 0.0d)) {
            this.b.b(this.b.g(), this.b.h());
            this.b.a(0);
            this.b.b(0);
        }
        this.h = new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
        int i5 = a.a;
        while (256.0d * Math.pow(2.0d, (double) i5) < ((double) Math.max(getWidth(), getHeight()))) {
            i5++;
        }
        a.a = i5;
        if (this.b.j().a() < a.a) {
            this.b.d(a.a);
        }
        this.a.a(false, false);
    }

    public final void scrollBy(int i, int i2) {
        a(a(i, i2));
    }
}
