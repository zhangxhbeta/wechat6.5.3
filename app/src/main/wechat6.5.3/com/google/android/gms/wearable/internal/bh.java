package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

public final class bh implements d {
    private f aGe;
    private int amO;

    public bh(d dVar) {
        this.amO = dVar.getType();
        this.aGe = (f) dVar.mx().jH();
    }

    public final int getType() {
        return this.amO;
    }

    public final /* synthetic */ Object jH() {
        return this;
    }

    public final f mx() {
        return this.aGe;
    }

    public final String toString() {
        String str = this.amO == 1 ? "changed" : this.amO == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + this.aGe + " }";
    }
}
