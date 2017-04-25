package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.wearable.d;

public final class bi extends f implements d {
    private final int aFt;

    public bi(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.aFt = i2;
    }

    public final int getType() {
        return getInteger("event_type");
    }

    public final /* synthetic */ Object jH() {
        return new bh(this);
    }

    public final com.google.android.gms.wearable.f mx() {
        return new f(this.amM, this.ani, this.aFt);
    }

    public final String toString() {
        String str = getInteger("event_type") == 1 ? "changed" : getInteger("event_type") == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + mx() + " }";
    }
}
