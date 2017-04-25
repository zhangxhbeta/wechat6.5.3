package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    b gEu = new b();

    public i createApplication() {
        return this.gEu;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return com.tencent.mm.plugin.ipcall.a.i.aul();
    }
}
