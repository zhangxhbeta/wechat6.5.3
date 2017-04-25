package com.tencent.mm.plugin.appbrand.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
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

public class AppBrandTextureView extends TextureView implements SurfaceTextureListener {
    private Map<String, d> dVl;
    private f dVm;

    public AppBrandTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AppBrandTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
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

    private void a(d dVar) {
        this.dVl.put(dVar.getMethod(), dVar);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.AppBrandSurfaceView", "setVisibility(%s)", new Object[]{Integer.valueOf(i)});
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandSurfaceView", "onSurfaceTextureAvailable");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandSurfaceView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandSurfaceView", "onSurfaceTextureDestroyed");
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.AppBrandSurfaceView", "onSurfaceTextureUpdated");
    }
}
