package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;

public final class Plugin implements c {
    private b esY = new b(this) {
        final /* synthetic */ Plugin ila;

        {
            this.ila = r1;
        }

        public final a J(Context context, String str) {
            v.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", new Object[]{str});
            if ("widget_type_news".equals(str)) {
                return new com.tencent.mm.plugin.readerapp.ui.b(context);
            }
            return null;
        }
    };

    public final i createApplication() {
        return new com.tencent.mm.plugin.readerapp.a.a();
    }

    public final b getContactWidgetFactory() {
        return this.esY;
    }

    public final ag createSubCore() {
        return new g();
    }
}
