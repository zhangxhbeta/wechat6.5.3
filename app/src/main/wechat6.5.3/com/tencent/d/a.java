package com.tencent.d;

public final class a implements com.tencent.d.b.a {
    private g pHh;
    private boolean pHi = true;

    protected a(g gVar) {
        this.pHh = gVar;
    }

    public final void o(String str, Object obj) {
        if (this.pHi) {
            f bPf = f.bPf();
            if (obj == null) {
                throw new h("TpfServiceCenter|registerService|name or service should not be null");
            }
            synchronized (bPf.pHo) {
                bPf.pHm.put(str, obj);
            }
        }
    }
}
