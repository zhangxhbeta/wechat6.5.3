package com.tencent.mm.sandbox.updater;

import com.tencent.mm.e.a.py;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;

public final class g extends c<py> {
    public g() {
        this.nhz = py.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        py pyVar = (py) bVar;
        if (pyVar instanceof py) {
            Updater c = Updater.c(pyVar.bri.context, null);
            if (c != null) {
                c.S(pyVar.bri.type, true);
            }
        }
        return false;
    }
}
