package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.model.ag;
import com.tencent.mm.model.w.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public final class Plugin implements c {
    public final i createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ag createSubCore() {
        a.a(new com.tencent.mm.plugin.appbrand.config.b());
        return new com.tencent.mm.plugin.appbrand.a.a();
    }
}
