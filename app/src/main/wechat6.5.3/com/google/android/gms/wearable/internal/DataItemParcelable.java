package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.HashMap;
import java.util.Map;

public class DataItemParcelable implements SafeParcelable, f {
    public static final Creator<DataItemParcelable> CREATOR = new e();
    byte[] aDR;
    final Map<String, g> aFa;
    final Uri mUri;
    final int mVersionCode;

    DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.mUri = uri;
        Map hashMap = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.aFa = hashMap;
        this.aDR = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.aDR;
    }

    public final Uri getUri() {
        return this.mUri;
    }

    public final /* synthetic */ Object jH() {
        return this;
    }

    public final Map<String, g> my() {
        return this.aFa;
    }

    public String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(",dataSz=" + (this.aDR == null ? "null" : Integer.valueOf(this.aDR.length)));
        stringBuilder.append(", numAssets=" + this.aFa.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (isLoggable) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.aFa.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.aFa.get(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel, i);
    }
}
