package com.tencent.mm.plugin.profile;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public final class Plugin implements c {
    public Plugin() {
        v.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
    }

    public final i createApplication() {
        v.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        return new a();
    }

    public final b getContactWidgetFactory() {
        v.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ag createSubCore() {
        v.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        return new b();
    }
}
