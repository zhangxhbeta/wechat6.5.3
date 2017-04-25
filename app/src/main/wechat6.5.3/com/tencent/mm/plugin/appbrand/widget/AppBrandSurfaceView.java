package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
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

public class AppBrandSurfaceView extends SurfaceView implements Callback {
    private SurfaceHolder dVL;
    private JSONArray dVk;
    private Map<String, d> dVl;
    private f dVm;

    public AppBrandSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AppBrandSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dVL = getHolder();
        this.dVL.addCallback(this);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        setZOrderOnTop(true);
        getContext().getSystemService("window");
        this.dVL.setFormat(-2);
        this.dVm = new f();
        this.dVl = new HashMap();
        a(new y());
        a(new r());
        a(new z());
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

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas lockCanvas = this.dVL.lockCanvas();
        if (lockCanvas != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!(this.dVk == null || this.dVk.length() == 0)) {
                for (int i = 0; i < this.dVk.length(); i++) {
                    JSONObject optJSONObject = this.dVk.optJSONObject(i);
                    if (optJSONObject != null) {
                        try {
                            f fVar = this.dVm;
                            String optString = optJSONObject.optString("method");
                            JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                            d dVar = (d) this.dVl.get(optString);
                            if (dVar != null) {
                                dVar.a(fVar, lockCanvas, optJSONArray);
                            }
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.AppBrandSurfaceView", "drawAction error, exception : %s", new Object[]{e});
                        }
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandSurfaceView", "startDraw : %s, endDraw : %s, cost : %s", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            }
            this.dVL.unlockCanvasAndPost(lockCanvas);
        }
    }

    private void a(d dVar) {
        this.dVl.put(dVar.getMethod(), dVar);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AppBrandSurfaceView", "setVisibility(%s)", new Object[]{Integer.valueOf(i)});
    }
}
