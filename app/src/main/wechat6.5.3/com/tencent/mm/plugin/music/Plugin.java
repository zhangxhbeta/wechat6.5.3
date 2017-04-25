package com.tencent.mm.plugin.music;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    public i createApplication() {
        return new b();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new com.tencent.mm.plugin.music.a.i();
    }
}
