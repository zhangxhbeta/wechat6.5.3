package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR = new u();
    private static final Random aEd = new SecureRandom();
    public byte[] aDR;
    final Bundle aEe;
    public final Uri mUri;
    final int mVersionCode;

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.aEe = bundle;
        this.aEe.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.aDR = bArr;
    }

    private PutDataRequest(Uri uri) {
        this(1, uri, new Bundle(), null);
    }

    public static PutDataRequest at(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return e(new Builder().scheme("wear").path(str).build());
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest e(Uri uri) {
        return new PutDataRequest(uri);
    }

    public final PutDataRequest b(String str, Asset asset) {
        w.Z(str);
        w.Z(asset);
        this.aEe.putParcelable(str, asset);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, Asset> my() {
        Map hashMap = new HashMap();
        for (String str : this.aEe.keySet()) {
            hashMap.put(str, (Asset) this.aEe.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String toString() {
        boolean isLoggable = Log.isLoggable("DataMap", 3);
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.aDR == null ? "null" : Integer.valueOf(this.aDR.length)));
        stringBuilder.append(", numAssets=" + this.aEe.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (isLoggable) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.aEe.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.aEe.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel, i);
    }
}
