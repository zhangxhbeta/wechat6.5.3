package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Creator<ProxyRequest> {
    static void a(ProxyRequest proxyRequest, Parcel parcel) {
        int t = com.google.android.gms.common.internal.safeparcel.b.t(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, proxyRequest.url);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1000, proxyRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 2, proxyRequest.ajY);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, proxyRequest.ajO);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, proxyRequest.body);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, proxyRequest.ajZ);
        com.google.android.gms.common.internal.safeparcel.b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = a.b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = a.k(parcel, readInt);
                    break;
                case 2:
                    i = a.e(parcel, readInt);
                    break;
                case 3:
                    j = a.f(parcel, readInt);
                    break;
                case 4:
                    bArr = a.n(parcel, readInt);
                    break;
                case 5:
                    bundle = a.m(parcel, readInt);
                    break;
                case 1000:
                    i2 = a.e(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
