package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    private b esY = new b(this) {
        final /* synthetic */ Plugin hZD;

        {
            this.hZD = r1;
        }

        public final a J(Context context, String str) {
            if ("widget_type_contact".equals(str)) {
                return new com.tencent.mm.plugin.qmessage.ui.a(context);
            }
            return new com.tencent.mm.plugin.qmessage.ui.b(context);
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
