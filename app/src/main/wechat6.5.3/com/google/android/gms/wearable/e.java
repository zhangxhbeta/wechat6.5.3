package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;
import com.google.android.gms.wearable.internal.bi;

public final class e extends h<d> implements g {
    private final Status aDC;

    public e(DataHolder dataHolder) {
        super(dataHolder);
        this.aDC = new Status(dataHolder.akn);
    }

    protected final /* synthetic */ Object ad(int i, int i2) {
        return new bi(this.amM, i, i2);
    }

    protected final String jI() {
        return "path";
    }

    public final Status jo() {
        return this.aDC;
    }
}
