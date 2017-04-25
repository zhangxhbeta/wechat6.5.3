package com.tencent.mm.plugin.qqmail;

import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public final class Plugin implements c {
    private a iai = new a();

    public final i createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return this.iai;
    }

    public final ag createSubCore() {
        return new x();
    }
}
