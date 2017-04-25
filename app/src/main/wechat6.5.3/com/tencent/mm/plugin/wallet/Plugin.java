package com.tencent.mm.plugin.wallet;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    public i createApplication() {
        return null;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new k();
    }
}
