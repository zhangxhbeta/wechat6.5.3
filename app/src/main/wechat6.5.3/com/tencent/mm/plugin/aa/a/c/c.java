package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public class c extends com.tencent.mm.vending.app.a {

    public class a {
        final /* synthetic */ c dte;
        public List<String> dtf;

        public a(c cVar) {
            this.dte = cVar;
        }
    }

    static /* synthetic */ a a(c cVar) {
        String stringExtra = cVar.pgh.getStringExtra("chatroom");
        if (be.kS(stringExtra)) {
            return null;
        }
        a aVar = new a(cVar);
        aVar.dtf = i.ej(stringExtra);
        if (aVar.dtf == null || aVar.dtf.size() <= 0) {
            return aVar;
        }
        aVar.dtf.remove(k.xF());
        return aVar;
    }

    protected final void onCreate() {
        super.onCreate();
        a(a.class, new com.tencent.mm.vending.app.a.a<a>(this) {
            final /* synthetic */ c dte;

            {
                this.dte = r1;
            }

            protected final /* synthetic */ Object NB() {
                return c.a(this.dte);
            }
        });
    }
}
