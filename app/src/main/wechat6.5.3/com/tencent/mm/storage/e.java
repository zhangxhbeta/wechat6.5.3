package com.tencent.mm.storage;

import com.tencent.mm.bg.g;
import com.tencent.mm.model.aw.b;
import com.tencent.mm.storage.au.c;

public abstract class e {
    protected au nnR;

    public abstract String Lu(String str);

    protected boolean a(at atVar, b bVar) {
        return true;
    }

    public e(au auVar) {
        this.nnR = auVar;
    }

    public final g buZ() {
        return this.nnR.cuX;
    }

    protected static void a(g gVar, String str) {
        au.a(gVar, str);
    }

    protected final void a(au.b bVar) {
        this.nnR.a(bVar);
    }

    protected final String Lv(String str) {
        return this.nnR.Lv(str);
    }

    protected final void a(c cVar) {
        this.nnR.a(cVar);
    }

    protected final void dI(String str, String str2) {
        this.nnR.b(str, str2, null);
    }
}
