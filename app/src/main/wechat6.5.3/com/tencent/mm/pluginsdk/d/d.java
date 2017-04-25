package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.e.a.hv;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;

public abstract class d implements a {
    public int lyI = 0;

    public abstract g asj();

    public abstract b um(String str);

    public final void bmH() {
        if (this.lyI == 0) {
            g asj = asj();
            if (asj != null) {
                asj.c(this);
            }
        }
        this.lyI++;
    }

    public final void unregister() {
        if (this.lyI != 0) {
            this.lyI--;
            if (this.lyI == 0) {
                g asj = asj();
                if (asj != null) {
                    asj.d(this);
                }
            }
        }
    }

    public final void a(String str, i iVar) {
        hv hvVar = new hv();
        hvVar.bhI.bhJ = um(str);
        com.tencent.mm.sdk.c.a.nhr.z(hvVar);
    }
}
