package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements c {
    public Plugin() {
        v.i("SubCoreSoter", "soter plugin constructor");
    }

    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new b();
    }
}
