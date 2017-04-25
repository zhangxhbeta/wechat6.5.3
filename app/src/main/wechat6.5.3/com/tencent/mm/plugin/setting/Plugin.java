package com.tencent.mm.plugin.setting;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public final class Plugin implements c {
    public Plugin() {
        v.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
    }

    public final i createApplication() {
        v.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
        return new a();
    }

    public final b getContactWidgetFactory() {
        v.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ag createSubCore() {
        v.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
        return new b();
    }
}
