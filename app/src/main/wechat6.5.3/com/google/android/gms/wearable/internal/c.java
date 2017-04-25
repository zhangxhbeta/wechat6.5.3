package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.wearable.g;

public final class c extends f implements g {
    public c(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final String getId() {
        return getString("asset_id");
    }

    public final /* synthetic */ Object jH() {
        return new bj(this);
    }

    public final String mz() {
        return getString("asset_key");
    }
}
