package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.nearby.a.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    private b esY = new b(this) {
        final /* synthetic */ Plugin hEC;

        {
            this.hEC = r1;
        }

        public final a J(Context context, String str) {
            return new com.tencent.mm.plugin.nearby.ui.a(context);
        }
    };

    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.esY;
    }

    public ag createSubCore() {
        return new g();
    }
}
