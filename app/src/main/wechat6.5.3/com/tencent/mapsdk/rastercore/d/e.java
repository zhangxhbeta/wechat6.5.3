package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.g.a;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.g.j;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.net.HttpURLConnection;
import java.net.URL;

public final class e implements b {
    public static StringBuffer a = new StringBuffer();
    public static StringBuffer b = new StringBuffer();
    private static volatile Context c;
    private static boolean q = true;
    private static boolean s = false;
    private static volatile int t = com.tencent.mapsdk.rastercore.b.a;
    private static volatile int u = com.tencent.mapsdk.rastercore.b.b;
    private static volatile int v = 0;
    private static volatile int w = BaseReportManager.MAX_READ_COUNT;
    private static volatile int x = BaseReportManager.MAX_READ_COUNT;
    private static volatile int y = 0;
    private static volatile String z = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
    private boolean A = false;
    private MapView d;
    private a e;
    private b f;
    private f g;
    private com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 h;
    private com.tencent.mapsdk.rastercore.tile.e i;
    private c j;
    private com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 k;
    private volatile com.tencent.mapsdk.rastercore.g.b l;
    private a m;
    private int n = 1;
    private j o = null;
    private boolean p = false;
    private Rect r = null;

    public e(MapView mapView, int i, boolean z) {
        this.A = z;
        y = i;
        c = mapView.getContext().getApplicationContext();
        com.tencent.mapsdk.rastercore.tile.a.a.a().a(c);
        if (c != null) {
            if (!z) {
                d.a.a();
                x = d.a.a(c.getPackageName(), false);
            }
            d.a.a();
            y = d.a.b(c.getPackageName(), false);
            d.a.a();
            t = d.a.a(x, y, false);
            d.a.a();
            w = d.a.a(c.getPackageName(), true);
            d.a.a();
            v = d.a.b(c.getPackageName(), true);
            d.a.a();
            u = d.a.a(w, v, true);
            new Thread(this) {
                public final void run() {
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(e.v, e.u, true);
                    com.tencent.mapsdk.rastercore.tile.a.a.a().d();
                }
            }.start();
        }
        this.d = mapView;
        this.k = new com.tencent.mapsdk.rastercore.d.a.AnonymousClass1(this);
        this.l = new com.tencent.mapsdk.rastercore.g.b(this);
        com.tencent.mapsdk.rastercore.a.a();
        new d(c, this, i, v).a();
        this.j = new c(this);
        this.m = new a(this);
        this.e = new a(this);
        this.f = new b(this);
        this.g = new f(this);
        this.h = new com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1(this, y, t);
        this.i = new com.tencent.mapsdk.rastercore.tile.e(this);
        this.j.a();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        mapView.addView(this.f, layoutParams);
        mapView.addView(this.m, layoutParams);
        mapView.addView(this.l, layoutParams);
        this.k.b(1);
        this.k.a(true);
        this.k.c(0);
    }

    public static Context a() {
        return c;
    }

    public static void a(String str) {
        z = str;
    }

    private void a(final StringBuffer stringBuffer, final String str) {
        if (stringBuffer != null && stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            new Thread(this) {
                public final void run() {
                    HttpURLConnection httpURLConnection;
                    Throwable th;
                    HttpURLConnection httpURLConnection2 = null;
                    try {
                        httpURLConnection = (HttpURLConnection) new URL("http://pr.map.qq.com/pingd?" + com.tencent.mapsdk.rastercore.a.a.toString() + "&appid=sdk&logid=ditu&ts=" + stringBuffer.toString() + "&type=" + str).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() == 200) {
                                httpURLConnection.getInputStream();
                                stringBuffer.setLength(0);
                            }
                            httpURLConnection.disconnect();
                        } catch (Exception e) {
                            httpURLConnection.disconnect();
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            httpURLConnection2 = httpURLConnection;
                            th = th3;
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                    } catch (Exception e2) {
                        httpURLConnection = null;
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2.disconnect();
                        throw th;
                    }
                }
            }.start();
        }
    }

    public static void c(boolean z) {
        q = false;
    }

    public static void d(boolean z) {
        s = z;
    }

    public static void n() {
    }

    public static void o() {
    }

    public static boolean r() {
        return q;
    }

    public static boolean s() {
        return s;
    }

    public static int t() {
        return u;
    }

    public static int u() {
        return v;
    }

    public static int v() {
        return w;
    }

    public static String w() {
        return z;
    }

    public static int x() {
        return t;
    }

    public static int y() {
        return y;
    }

    public static int z() {
        return x;
    }

    public final void a(int i) {
        if (i == 2) {
            this.l.a(true);
        } else {
            this.l.a(false);
        }
        this.n = i;
        a(false, false);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap) {
        if (!this.A) {
            y = i2;
        }
        com.tencent.mapsdk.rastercore.b.e = i;
        t = i3;
        u = i6;
        v = i5;
        w = i4;
        this.h.a(i2);
        this.h.b(i3);
        if (this.l != null) {
            this.l.a(bitmap);
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.k.e(bundle.getBoolean("ANIMATION_ENABLED", true));
            this.k.b(bundle.getBoolean("SCROLL_ENABLED", true));
            this.k.c(bundle.getBoolean("ZOOM_ENABLED", true));
            this.k.b(bundle.getInt("LOGO_POSITION", 0));
            this.k.c(bundle.getInt("SCALEVIEW_POSITION", 0));
            this.k.a(bundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
            this.f.b(bundle.getDouble("ZOOM", this.f.c()), false, null);
            Double valueOf = Double.valueOf(bundle.getDouble("CENTERX", Double.NaN));
            Double valueOf2 = Double.valueOf(bundle.getDouble("CENTERY", Double.NaN));
            if (!valueOf.isNaN() && !valueOf2.isNaN()) {
                this.f.a(new c(valueOf2.doubleValue(), valueOf.doubleValue()));
            }
        }
    }

    public final void a(j jVar) {
        a(jVar, null);
    }

    public final void a(j jVar, Rect rect) {
        this.o = jVar;
        this.r = rect;
        if (this.p) {
            p();
            return;
        }
        this.f.a(true);
        a(false, false);
    }

    public final void a(boolean z) {
        if (z) {
            this.m.setVisibility(0);
            this.m.d();
            return;
        }
        a.b();
        a.c();
        this.m.setVisibility(8);
    }

    public final void a(boolean z, boolean z2) {
        this.p = false;
        this.h.a(z, z2);
        this.d.layout();
        this.d.postInvalidate();
    }

    public final c b() {
        return this.j;
    }

    public final void b(int i) {
        if (this.l != null) {
            this.l.a(i);
            this.l.invalidate();
            if (this.m.getVisibility() == 0) {
                this.m.invalidate();
            }
        }
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("ANIMATION_ENABLED", this.k.k());
        bundle.putBoolean("SCROLL_ENABLED", this.k.h());
        bundle.putBoolean("ZOOM_ENABLED", this.k.i());
        bundle.putInt("LOGO_POSITION", this.k.j());
        bundle.putInt("SCALEVIEW_POSITION", this.k.f());
        bundle.putBoolean("SCALE_CONTROLL_ENABLED", this.k.g());
        bundle.putDouble("ZOOM", this.f.c());
        bundle.putDouble("CENTERX", this.f.b().b());
        bundle.putDouble("CENTERY", this.f.b().a());
    }

    protected final void b(boolean z) {
        this.p = z;
    }

    public final b c() {
        return this.f;
    }

    public final void c(int i) {
        if (this.m.getVisibility() == 0 && this.m != null) {
            this.m.a(i);
            this.m.invalidate();
        }
    }

    public final MapView d() {
        return this.d;
    }

    public final a e() {
        return this.e;
    }

    public final com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 f() {
        return this.k;
    }

    public final com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 g() {
        return this.h;
    }

    public final f h() {
        return this.g;
    }

    public final com.tencent.mapsdk.rastercore.tile.e i() {
        return this.i;
    }

    public final void j() {
        this.m.e();
    }

    public final void k() {
        this.m.d();
    }

    public final int l() {
        return this.n;
    }

    public final void m() {
        this.m.a();
        this.l.a();
        this.e.b();
        this.d.stopAnimation();
        this.d.removeAllViews();
        this.h.a();
        if (a.length() > 0) {
            a(a, "1");
        }
        if (b.length() > 0) {
            a(b, "2");
        }
        System.gc();
    }

    protected final void p() {
        if (this.o != null) {
            this.d.setDrawingCacheEnabled(true);
            this.d.buildDrawingCache();
            if (this.r == null) {
                Bitmap.createBitmap(this.d.getDrawingCache());
            } else {
                Bitmap.createBitmap(this.d.getDrawingCache(), this.r.left, this.r.top, this.r.width(), this.r.height());
            }
            this.d.destroyDrawingCache();
        }
    }

    public final void q() {
        if (this.l != null) {
            this.l.invalidate();
        }
    }
}
