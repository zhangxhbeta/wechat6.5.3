package com.tencent.mm.plugin.gallery;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import java.util.HashMap;

public class Plugin implements c {
    public i createApplication() {
        return new i(this) {
            final /* synthetic */ Plugin gdp;

            {
                this.gdp = r1;
            }

            public final void a(h hVar) {
            }

            public final void a(g gVar) {
            }
        };
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new ag(this) {
            final /* synthetic */ Plugin gdp;

            {
                this.gdp = r1;
            }

            public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
                return null;
            }

            public final void ed(int i) {
            }

            public final void aG(boolean z) {
            }

            public final void aH(boolean z) {
            }

            public final void th() {
            }
        };
    }
}
