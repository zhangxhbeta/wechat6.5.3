package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.aj;

public final class v extends o {
    private final aj ahq = new aj();

    v(q qVar) {
        super(qVar);
    }

    protected final void hm() {
        this.afY.ia().la().a(this.ahq);
        l id = this.afY.id();
        String hK = id.hK();
        if (hK != null) {
            this.ahq.afG = hK;
        }
        String hJ = id.hJ();
        if (hJ != null) {
            this.ahq.afH = hJ;
        }
    }

    public final aj io() {
        hX();
        return this.ahq;
    }
}
