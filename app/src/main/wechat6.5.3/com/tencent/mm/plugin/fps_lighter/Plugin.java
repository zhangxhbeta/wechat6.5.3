package com.tencent.mm.plugin.fps_lighter;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.fps_lighter.b.e;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements c {
    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        v.d("MicroMsg.FPSLighterCore.Plugin", "[createSubCore]");
        return new e();
    }
}
