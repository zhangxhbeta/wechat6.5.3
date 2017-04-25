package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.f.f.b;

public final class e extends a {
    public final f a(Context context, b bVar, int i) {
        return new f(context, bVar, i);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX;
    }

    public final int getPriority() {
        return 113;
    }
}
