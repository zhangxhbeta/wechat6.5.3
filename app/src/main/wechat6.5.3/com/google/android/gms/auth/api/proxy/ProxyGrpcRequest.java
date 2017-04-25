package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyGrpcRequest implements SafeParcelable {
    public static final Creator<ProxyGrpcRequest> CREATOR = new a();
    public final long ajO;
    public final byte[] body;
    public final String hostname;
    public final String method;
    public final int port;
    final int versionCode;

    ProxyGrpcRequest(int i, String str, int i2, long j, byte[] bArr, String str2) {
        this.versionCode = i;
        this.hostname = str;
        this.port = i2;
        this.ajO = j;
        this.body = bArr;
        this.method = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
