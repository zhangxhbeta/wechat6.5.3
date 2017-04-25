package com.tencent.mm.plugin.safedevice;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new f();
    }
}
