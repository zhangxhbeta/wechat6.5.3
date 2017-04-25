package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<LogEvent> {
    static void a(LogEvent logEvent, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, logEvent.versionCode);
        b.a(parcel, 2, logEvent.aBf);
        b.a(parcel, 3, logEvent.tag);
        b.a(parcel, 4, logEvent.aBh);
        b.a(parcel, 5, logEvent.aBi);
        b.a(parcel, 6, logEvent.aBg);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        byte[] bArr = null;
        long j2 = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.a.m(parcel, readInt);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LogEvent[i];
    }
}
