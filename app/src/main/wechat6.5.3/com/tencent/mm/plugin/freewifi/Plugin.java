package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    public i createApplication() {
        return new g();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new j();
    }
}
