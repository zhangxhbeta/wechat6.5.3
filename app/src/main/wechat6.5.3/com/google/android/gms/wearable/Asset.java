package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new r();
    public byte[] aDR;
    public String aDS;
    public ParcelFileDescriptor aDT;
    final int mVersionCode;
    public Uri uri;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.mVersionCode = i;
        this.aDR = bArr;
        this.aDS = str;
        this.aDT = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset ar(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset h(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return v.d(this.aDR, asset.aDR) && v.d(this.aDS, asset.aDS) && v.d(this.aDT, asset.aDT) && v.d(this.uri, asset.uri);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.aDR, this.aDS, this.aDT, this.uri});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.aDS == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.aDS);
        }
        if (this.aDR != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.aDR.length);
        }
        if (this.aDT != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.aDT);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        r.a(this, parcel, i | 1);
    }
}
