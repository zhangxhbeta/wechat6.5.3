package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    public ag createSubCore() {
        return new b();
    }

    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
