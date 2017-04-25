package com.tencent.mm.plugin.notification;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.notification.c.e;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    a hIx = new a();

    public i createApplication() {
        return this.hIx;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return e.aEy();
    }
}
