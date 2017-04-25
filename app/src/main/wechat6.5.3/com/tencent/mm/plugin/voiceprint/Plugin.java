package com.tencent.mm.plugin.voiceprint;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.voiceprint.a.a;
import com.tencent.mm.plugin.voiceprint.model.k;
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
        return new k();
    }
}
