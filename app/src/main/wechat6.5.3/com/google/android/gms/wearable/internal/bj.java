package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.g;

public final class bj implements g {
    private final String afy;
    private final String ayh;

    public bj(g gVar) {
        this.afy = gVar.getId();
        this.ayh = gVar.mz();
    }

    public final String getId() {
        return this.afy;
    }

    public final /* synthetic */ Object jH() {
        return this;
    }

    public final String mz() {
        return this.ayh;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.afy == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.afy);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.ayh);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
