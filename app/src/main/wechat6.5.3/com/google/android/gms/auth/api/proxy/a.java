package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<ProxyGrpcRequest> {
    static void a(ProxyGrpcRequest proxyGrpcRequest, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.a(parcel, 1, proxyGrpcRequest.hostname);
        b.c(parcel, 1000, proxyGrpcRequest.versionCode);
        b.c(parcel, 2, proxyGrpcRequest.port);
        b.a(parcel, 3, proxyGrpcRequest.ajO);
        b.a(parcel, 4, proxyGrpcRequest.body);
        b.a(parcel, 5, proxyGrpcRequest.method);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyGrpcRequest(i2, str2, i, j, bArr, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyGrpcRequest[i];
    }
}
