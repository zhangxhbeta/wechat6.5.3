package com.tencent.mm.plugin.remittance;

import com.tencent.mm.model.ag;
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
        return new com.tencent.mm.plugin.remittance.a.b();
    }
}
