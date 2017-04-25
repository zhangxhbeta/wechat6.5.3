package com.tencent.mm.plugin.search;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public final class Plugin implements c {
    public final i createApplication() {
        return new a();
    }

    public final ag createSubCore() {
        return new com.tencent.mm.plugin.search.a.i();
    }

    public final b getContactWidgetFactory() {
        return null;
    }
}
