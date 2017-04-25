package com.tencent.mm.plugin.subapp;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public final class Plugin implements c {
    public Plugin() {
        v.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    }

    public final i createApplication() {
        v.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        return new b();
    }

    public final b getContactWidgetFactory() {
        v.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ag createSubCore() {
        v.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        return new a();
    }
}
