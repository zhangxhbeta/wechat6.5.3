package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.c.aa;
import com.tencent.mm.plugin.appbrand.c.ab;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.c.d;
import com.tencent.mm.plugin.appbrand.c.e;
import com.tencent.mm.plugin.appbrand.c.f;
import com.tencent.mm.plugin.appbrand.c.g;
import com.tencent.mm.plugin.appbrand.c.h;
import com.tencent.mm.plugin.appbrand.c.i;
import com.tencent.mm.plugin.appbrand.c.j;
import com.tencent.mm.plugin.appbrand.c.k;
import com.tencent.mm.plugin.appbrand.c.l;
import com.tencent.mm.plugin.appbrand.c.m;
import com.tencent.mm.plugin.appbrand.c.n;
import com.tencent.mm.plugin.appbrand.c.o;
import com.tencent.mm.plugin.appbrand.c.p;
import com.tencent.mm.plugin.appbrand.c.q;
import com.tencent.mm.plugin.appbrand.c.r;
import com.tencent.mm.plugin.appbrand.c.s;
import com.tencent.mm.plugin.appbrand.c.t;
import com.tencent.mm.plugin.appbrand.c.u;
import com.tencent.mm.plugin.appbrand.c.v;
import com.tencent.mm.plugin.appbrand.c.w;
import com.tencent.mm.plugin.appbrand.c.x;
import com.tencent.mm.plugin.appbrand.c.y;
import com.tencent.mm.plugin.appbrand.c.z;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandDrawableView extends View {
    public JSONArray dVk;
    private Map<String, d> dVl;
    public f dVm;
    private Bitmap mBitmap;

    public AppBrandDrawableView(Context context) {
        super(context);
        init();
    }

    public AppBrandDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AppBrandDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dVm = new f();
        this.dVl = new HashMap();
        a(new y());
        a(new r());
        a(new z());
        a(new t());
        a(new l());
        a(new b());
        a(new i());
        a(new e());
        a(new m());
        a(new j());
        a(new g());
        a(new k());
        a(new h());
        a(new c());
        a(new aa());
        a(new u());
        a(new v());
        a(new w());
        a(new x());
        a(new s());
        a(new q());
        a(new o());
        a(new ab());
        a(new p());
        a(new n());
    }

    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandDrawableView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            }
            if (this.mBitmap == null) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AppBrandDrawableView", "bitmap is null.");
                return;
            }
            long currentTimeMillis2;
            this.mBitmap.eraseColor(0);
            Canvas aVar = new a(this.mBitmap);
            long currentTimeMillis3 = System.currentTimeMillis();
            long currentTimeMillis4 = System.currentTimeMillis();
            if (!(this.dVk == null || this.dVk.length() == 0)) {
                for (measuredHeight = 0; measuredHeight < this.dVk.length(); measuredHeight++) {
                    JSONObject optJSONObject = this.dVk.optJSONObject(measuredHeight);
                    if (optJSONObject != null) {
                        try {
                            f fVar = this.dVm;
                            String optString = optJSONObject.optString("method");
                            JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                            d dVar = (d) this.dVl.get(optString);
                            if (dVar != null) {
                                dVar.a(fVar, aVar, optJSONArray);
                            }
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.AppBrandDrawableView", "drawAction error, exception : %s", new Object[]{e});
                        }
                    }
                }
                currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandDrawableView", "startDrawAction : %s, endDrawAction : %s, cost : %s", new Object[]{Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis4)});
            }
            canvas.drawBitmap(aVar.mBitmap, 0.0f, 0.0f, null);
            currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandDrawableView", "startDraw : %s, endDraw : %s, createBitmapEnd : %s, createBitmapCost : %s, cost : %s", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis3), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.dVk != null && this.dVk.length() > 0) {
            if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                this.mBitmap.recycle();
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandDrawableView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            }
        }
    }

    private void a(d dVar) {
        this.dVl.put(dVar.getMethod(), dVar);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandDrawableView", "dispatchTouchEvent(r : %s, event : %s)", new Object[]{Boolean.valueOf(super.dispatchTouchEvent(motionEvent)), motionEvent});
        return super.dispatchTouchEvent(motionEvent);
    }
}
