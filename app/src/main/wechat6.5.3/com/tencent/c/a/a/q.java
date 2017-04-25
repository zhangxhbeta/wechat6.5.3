package com.tencent.c.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    protected abstract void a(a aVar);

    protected abstract boolean nM();

    protected abstract String nN();

    protected abstract a nO();

    protected abstract void write(String str);

    protected q(Context context) {
        this.context = context;
    }

    public final g nV() {
        String decode;
        if (nM()) {
            decode = s.decode(nN());
        } else {
            decode = null;
        }
        if (decode != null) {
            return g.aL(decode);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (nM()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a nW() {
        if (nM()) {
            return nO();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && nM()) {
            a(aVar);
        }
    }
}
