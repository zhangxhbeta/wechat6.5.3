package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.bottle.ui.e;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public final class Plugin implements c {
    private b esY = new b(this) {
        final /* synthetic */ Plugin esZ;

        {
            this.esZ = r1;
        }

        public final a J(Context context, String str) {
            return new e(context);
        }
    };

    public final i createApplication() {
        return new a();
    }

    public final ag createSubCore() {
        return new com.tencent.mm.plugin.bottle.a.i();
    }

    public final b getContactWidgetFactory() {
        return this.esY;
    }
}
