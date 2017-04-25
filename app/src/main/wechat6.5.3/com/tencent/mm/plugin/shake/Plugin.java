package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    private b iNN = new b(this) {
        final /* synthetic */ Plugin iNO;

        {
            this.iNO = r1;
        }

        public final a J(Context context, String str) {
            return new com.tencent.mm.plugin.shake.ui.a(context);
        }
    };

    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.iNN;
    }

    public ag createSubCore() {
        return new k();
    }
}
