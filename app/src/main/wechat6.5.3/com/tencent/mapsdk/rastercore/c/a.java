package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.tencentmap.mapsdk.map.c;

public abstract class a {
    protected boolean a = true;
    protected long b = 1000;
    protected c c = null;

    public final void a(long j) {
        this.b = j;
    }

    public abstract void a(e eVar);

    public final void a(c cVar) {
        this.c = cVar;
    }

    public final void a(boolean z) {
        this.a = false;
    }

    public boolean a() {
        return true;
    }
}
