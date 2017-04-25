package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new b();
    public static final int ajP = 0;
    public static final int ajQ = 1;
    public static final int ajR = 2;
    public static final int ajS = 3;
    public static final int ajT = 4;
    public static final int ajU = 5;
    public static final int ajV = 6;
    public static final int ajW = 7;
    public static final int ajX = 7;
    public final long ajO;
    public final int ajY;
    Bundle ajZ;
    public final byte[] body;
    public final String url;
    final int versionCode;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.ajY = i2;
        this.ajO = j;
        this.body = bArr;
        this.ajZ = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.ajY + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
