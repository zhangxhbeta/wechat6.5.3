package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;

public class Plugin implements c {
    private b esY = new b(this) {
        final /* synthetic */ Plugin hjo;

        {
            this.hjo = r1;
        }

        public final a J(Context context, String str) {
            return new com.tencent.mm.plugin.masssend.ui.a(context);
        }
    };

    public i createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.esY;
    }

    public ag createSubCore() {
        return new h();
    }
}
